package p000a.p001a.p002a.p003a.p004a.p007c;

import android.annotation.TargetApi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PriorityThreadPoolExecutor */
public class C0073k extends ThreadPoolExecutor {
    private static final int f152a = Runtime.getRuntime().availableProcessors();
    private static final int f153b = (f152a + 1);
    private static final int f154c = ((f152a * 2) + 1);

    /* compiled from: PriorityThreadPoolExecutor */
    protected static final class C0072a implements ThreadFactory {
        private final int f151a;

        public C0072a(int i) {
            this.f151a = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f151a);
            thread.setName("Queue");
            return thread;
        }
    }

    public /* synthetic */ BlockingQueue getQueue() {
        return m234b();
    }

    <T extends Runnable & C0060b & C0065l & C0064i> C0073k(int i, int i2, long j, TimeUnit timeUnit, C0061c<T> c0061c, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, c0061c, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & C0060b & C0065l & C0064i> C0073k m233a(int i, int i2) {
        return new C0073k(i, i2, 1, TimeUnit.SECONDS, new C0061c(), new C0072a(10));
    }

    public static C0073k m232a() {
        return C0073k.m233a(f153b, f154c);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0066h(runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0066h(callable);
    }

    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (C0070j.m223a((Object) runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        C0065l c0065l = (C0065l) runnable;
        c0065l.mo12b(true);
        c0065l.mo10a(th);
        m234b().m194d();
        super.afterExecute(runnable, th);
    }

    public C0061c m234b() {
        return (C0061c) super.getQueue();
    }
}
