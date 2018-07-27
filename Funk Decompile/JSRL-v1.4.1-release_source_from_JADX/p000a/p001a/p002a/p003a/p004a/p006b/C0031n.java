package p000a.p001a.p002a.p003a.p004a.p006b;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p000a.p001a.p002a.p003a.C0142c;

/* compiled from: ExecutorUtils */
public final class C0031n {
    public static ExecutorService m103a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C0031n.m107c(str));
        C0031n.m104a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService m106b(String str) {
        Object newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(C0031n.m107c(str));
        C0031n.m104a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory m107c(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new C0009h(this) {
                    final /* synthetic */ C00291 f48b;

                    public void mo4a() {
                        runnable.run();
                    }
                });
                newThread.setName(str + atomicLong.getAndIncrement());
                return newThread;
            }
        };
    }

    private static final void m104a(String str, ExecutorService executorService) {
        C0031n.m105a(str, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void m105a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        final String str2 = str;
        final ExecutorService executorService2 = executorService;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        Runtime.getRuntime().addShutdownHook(new Thread(new C0009h() {
            public void mo4a() {
                try {
                    C0142c.m468h().mo46a("Fabric", "Executing shutdown hook for " + str2);
                    executorService2.shutdown();
                    if (!executorService2.awaitTermination(j2, timeUnit2)) {
                        C0142c.m468h().mo46a("Fabric", str2 + " did not shut down in the" + " allocated time. Requesting immediate shutdown.");
                        executorService2.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    C0142c.m468h().mo46a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str2}));
                    executorService2.shutdownNow();
                }
            }
        }, "Crashlytics Shutdown Hook for " + str));
    }
}
