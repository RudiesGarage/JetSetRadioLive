package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;

public class AsyncExecutor {
    private final EventBus eventBus;
    private final Constructor<?> failureEventConstructor;
    private final Object scope;
    private final Executor threadPool;

    public static class Builder {
        private EventBus eventBus;
        private Class<?> failureEventType;
        private Executor threadPool;

        private Builder() {
        }

        public Builder threadPool(Executor executor) {
            this.threadPool = executor;
            return this;
        }

        public Builder failureEventType(Class<?> cls) {
            this.failureEventType = cls;
            return this;
        }

        public Builder eventBus(EventBus eventBus) {
            this.eventBus = eventBus;
            return this;
        }

        public AsyncExecutor build() {
            return buildForScope(null);
        }

        public AsyncExecutor buildForActivityScope(Activity activity) {
            return buildForScope(activity.getClass());
        }

        public AsyncExecutor buildForScope(Object obj) {
            if (this.eventBus == null) {
                this.eventBus = EventBus.getDefault();
            }
            if (this.threadPool == null) {
                this.threadPool = Executors.newCachedThreadPool();
            }
            if (this.failureEventType == null) {
                this.failureEventType = ThrowableFailureEvent.class;
            }
            return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, obj);
        }
    }

    public interface RunnableEx {
        void run();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static AsyncExecutor create() {
        return new Builder().build();
    }

    private AsyncExecutor(Executor executor, EventBus eventBus, Class<?> cls, Object obj) {
        this.threadPool = executor;
        this.eventBus = eventBus;
        this.scope = obj;
        try {
            this.failureEventConstructor = cls.getConstructor(new Class[]{Throwable.class});
        } catch (Throwable e) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e);
        }
    }

    public void execute(final RunnableEx runnableEx) {
        this.threadPool.execute(new Runnable() {
            public void run() {
                try {
                    runnableEx.run();
                } catch (Throwable e) {
                    try {
                        Object newInstance = AsyncExecutor.this.failureEventConstructor.newInstance(new Object[]{e});
                        if (newInstance instanceof HasExecutionScope) {
                            ((HasExecutionScope) newInstance).setExecutionScope(AsyncExecutor.this.scope);
                        }
                        AsyncExecutor.this.eventBus.post(newInstance);
                    } catch (Throwable e2) {
                        Log.e(EventBus.TAG, "Original exception:", e);
                        throw new RuntimeException("Could not create failure event", e2);
                    }
                }
            }
        });
    }
}
