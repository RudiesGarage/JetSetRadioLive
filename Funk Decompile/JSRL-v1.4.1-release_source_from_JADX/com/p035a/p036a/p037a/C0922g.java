package com.p035a.p036a.p037a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.p002a.p003a.C0142c;

/* compiled from: BackgroundManager */
class C0922g {
    final AtomicReference<ScheduledFuture<?>> f2490a = new AtomicReference();
    boolean f2491b = true;
    private final ScheduledExecutorService f2492c;
    private final List<C0921a> f2493d = new ArrayList();
    private volatile boolean f2494e = true;

    /* compiled from: BackgroundManager */
    class C09201 implements Runnable {
        final /* synthetic */ C0922g f2489a;

        C09201(C0922g c0922g) {
            this.f2489a = c0922g;
        }

        public void run() {
            this.f2489a.f2490a.set(null);
            this.f2489a.m4633c();
        }
    }

    /* compiled from: BackgroundManager */
    public interface C0921a {
        void mo724a();
    }

    public C0922g(ScheduledExecutorService scheduledExecutorService) {
        this.f2492c = scheduledExecutorService;
    }

    public void m4636a(boolean z) {
        this.f2494e = z;
    }

    private void m4633c() {
        for (C0921a a : this.f2493d) {
            a.mo724a();
        }
    }

    public void m4635a(C0921a c0921a) {
        this.f2493d.add(c0921a);
    }

    public void m4634a() {
        this.f2491b = false;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f2490a.getAndSet(null);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void m4637b() {
        if (this.f2494e && !this.f2491b) {
            this.f2491b = true;
            try {
                this.f2490a.compareAndSet(null, this.f2492c.schedule(new C09201(this), 5000, TimeUnit.MILLISECONDS));
            } catch (Throwable e) {
                C0142c.m468h().mo47a("Answers", "Failed to schedule background detector", e);
            }
        }
    }
}
