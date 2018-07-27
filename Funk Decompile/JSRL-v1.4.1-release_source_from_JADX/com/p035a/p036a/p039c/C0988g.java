package com.p035a.p036a.p039c;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import p000a.p001a.p002a.p003a.C0142c;

/* compiled from: CrashlyticsExecutorServiceWrapper */
class C0988g {
    private final ExecutorService f2700a;

    public C0988g(ExecutorService executorService) {
        this.f2700a = executorService;
    }

    <T> T m4897a(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f2700a.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.f2700a.submit(callable).get();
        } catch (RejectedExecutionException e) {
            C0142c.m468h().mo46a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Throwable e2) {
            C0142c.m468h().mo54e("CrashlyticsCore", "Failed to execute task.", e2);
            return null;
        }
    }

    Future<?> m4898a(final Runnable runnable) {
        try {
            return this.f2700a.submit(new Runnable(this) {
                final /* synthetic */ C0988g f2697b;

                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable e) {
                        C0142c.m468h().mo54e("CrashlyticsCore", "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            C0142c.m468h().mo46a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> m4899b(final Callable<T> callable) {
        try {
            return this.f2700a.submit(new Callable<T>(this) {
                final /* synthetic */ C0988g f2699b;

                public T call() {
                    try {
                        return callable.call();
                    } catch (Throwable e) {
                        C0142c.m468h().mo54e("CrashlyticsCore", "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            C0142c.m468h().mo46a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
