package p000a.p001a.p002a.p003a.p004a.p007c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask */
public abstract class C0059a<Params, Progress, Result> {
    private static final int f122a = Runtime.getRuntime().availableProcessors();
    public static final Executor f123b = new ThreadPoolExecutor(f125d, f126e, 1, TimeUnit.SECONDS, f128g, f127f);
    public static final Executor f124c = new C0052c();
    private static final int f125d = (f122a + 1);
    private static final int f126e = ((f122a * 2) + 1);
    private static final ThreadFactory f127f = new C00441();
    private static final BlockingQueue<Runnable> f128g = new LinkedBlockingQueue(128);
    private static final C0050b f129h = new C0050b();
    private static volatile Executor f130i = f124c;
    private final C0045e<Params, Result> f131j = new C00462(this);
    private final FutureTask<Result> f132k = new FutureTask<Result>(this, this.f131j) {
        final /* synthetic */ C0059a f104a;

        protected void done() {
            try {
                this.f104a.m171d(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.f104a.m171d(null);
            }
        }
    };
    private volatile C0053d f133l = C0053d.PENDING;
    private final AtomicBoolean f134m = new AtomicBoolean();
    private final AtomicBoolean f135n = new AtomicBoolean();

    /* compiled from: AsyncTask */
    static class C00441 implements ThreadFactory {
        private final AtomicInteger f101a = new AtomicInteger(1);

        C00441() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f101a.getAndIncrement());
        }
    }

    /* compiled from: AsyncTask */
    private static abstract class C0045e<Params, Result> implements Callable<Result> {
        Params[] f102b;

        private C0045e() {
        }
    }

    /* compiled from: AsyncTask */
    class C00462 extends C0045e<Params, Result> {
        final /* synthetic */ C0059a f103a;

        C00462(C0059a c0059a) {
            this.f103a = c0059a;
            super();
        }

        public Result call() {
            this.f103a.f135n.set(true);
            Process.setThreadPriority(10);
            return this.f103a.m172e(this.f103a.mo60a(this.b));
        }
    }

    /* compiled from: AsyncTask */
    private static class C0049a<Data> {
        final C0059a f106a;
        final Data[] f107b;

        C0049a(C0059a c0059a, Data... dataArr) {
            this.f106a = c0059a;
            this.f107b = dataArr;
        }
    }

    /* compiled from: AsyncTask */
    private static class C0050b extends Handler {
        public C0050b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C0049a c0049a = (C0049a) message.obj;
            switch (message.what) {
                case 1:
                    c0049a.f106a.m173f(c0049a.f107b[0]);
                    return;
                case 2:
                    c0049a.f106a.m180b(c0049a.f107b);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AsyncTask */
    private static class C0052c implements Executor {
        final LinkedList<Runnable> f110a;
        Runnable f111b;

        private C0052c() {
            this.f110a = new LinkedList();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f110a.offer(new Runnable(this) {
                final /* synthetic */ C0052c f109b;

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        this.f109b.m161a();
                    }
                }
            });
            if (this.f111b == null) {
                m161a();
            }
        }

        protected synchronized void m161a() {
            Runnable runnable = (Runnable) this.f110a.poll();
            this.f111b = runnable;
            if (runnable != null) {
                C0059a.f123b.execute(this.f111b);
            }
        }
    }

    /* compiled from: AsyncTask */
    public enum C0053d {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result mo60a(Params... paramsArr);

    private void m171d(Result result) {
        if (!this.f135n.get()) {
            m172e(result);
        }
    }

    private Result m172e(Result result) {
        f129h.obtainMessage(1, new C0049a(this, result)).sendToTarget();
        return result;
    }

    public final C0053d b_() {
        return this.f133l;
    }

    protected void mo61a() {
    }

    protected void mo62a(Result result) {
    }

    protected void m180b(Progress... progressArr) {
    }

    protected void mo63b(Result result) {
        c_();
    }

    protected void c_() {
    }

    public final boolean m181e() {
        return this.f134m.get();
    }

    public final boolean m178a(boolean z) {
        this.f134m.set(true);
        return this.f132k.cancel(z);
    }

    public final C0059a<Params, Progress, Result> m174a(Executor executor, Params... paramsArr) {
        if (this.f133l != C0053d.PENDING) {
            switch (this.f133l) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f133l = C0053d.RUNNING;
        mo61a();
        this.f131j.f102b = paramsArr;
        executor.execute(this.f132k);
        return this;
    }

    private void m173f(Result result) {
        if (m181e()) {
            mo63b((Object) result);
        } else {
            mo62a((Object) result);
        }
        this.f133l = C0053d.FINISHED;
    }
}
