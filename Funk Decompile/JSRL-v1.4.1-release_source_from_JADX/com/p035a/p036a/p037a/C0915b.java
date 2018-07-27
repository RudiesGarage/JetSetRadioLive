package com.p035a.p036a.p037a;

import android.content.Context;
import com.p035a.p036a.p037a.C0938s.C0936a;
import java.util.concurrent.ScheduledExecutorService;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p009d.C0080d;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p012g.C0108b;

/* compiled from: AnswersEventsHandler */
class C0915b implements C0080d {
    final ScheduledExecutorService f2475a;
    C0923r f2476b = new C0924h();
    private final C0149i f2477c;
    private final Context f2478d;
    private final C0916c f2479e;
    private final C0941v f2480f;
    private final C0088e f2481g;

    /* compiled from: AnswersEventsHandler */
    class C09102 implements Runnable {
        final /* synthetic */ C0915b f2468a;

        C09102(C0915b c0915b) {
            this.f2468a = c0915b;
        }

        public void run() {
            try {
                C0923r c0923r = this.f2468a.f2476b;
                this.f2468a.f2476b = new C0924h();
                c0923r.mo717b();
            } catch (Throwable e) {
                C0142c.m468h().mo54e("Answers", "Failed to disable events", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler */
    class C09113 implements Runnable {
        final /* synthetic */ C0915b f2469a;

        C09113(C0915b c0915b) {
            this.f2469a = c0915b;
        }

        public void run() {
            try {
                this.f2469a.f2476b.mo714a();
            } catch (Throwable e) {
                C0142c.m468h().mo54e("Answers", "Failed to send events files", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler */
    class C09124 implements Runnable {
        final /* synthetic */ C0915b f2470a;

        C09124(C0915b c0915b) {
            this.f2470a = c0915b;
        }

        public void run() {
            try {
                C0939t a = this.f2470a.f2480f.m4690a();
                C0932o a2 = this.f2470a.f2479e.m4618a();
                a2.m241a(this.f2470a);
                this.f2470a.f2476b = new C0925i(this.f2470a.f2477c, this.f2470a.f2478d, this.f2470a.f2475a, a2, this.f2470a.f2481g, a);
            } catch (Throwable e) {
                C0142c.m468h().mo54e("Answers", "Failed to enable events", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler */
    class C09135 implements Runnable {
        final /* synthetic */ C0915b f2471a;

        C09135(C0915b c0915b) {
            this.f2471a = c0915b;
        }

        public void run() {
            try {
                this.f2471a.f2476b.mo718c();
            } catch (Throwable e) {
                C0142c.m468h().mo54e("Answers", "Failed to flush events", e);
            }
        }
    }

    public C0915b(C0149i c0149i, Context context, C0916c c0916c, C0941v c0941v, C0088e c0088e, ScheduledExecutorService scheduledExecutorService) {
        this.f2477c = c0149i;
        this.f2478d = context;
        this.f2479e = c0916c;
        this.f2480f = c0941v;
        this.f2481g = c0088e;
        this.f2475a = scheduledExecutorService;
    }

    public void m4611a(C0936a c0936a) {
        m4612a(c0936a, false, false);
    }

    public void m4615b(C0936a c0936a) {
        m4612a(c0936a, false, true);
    }

    public void m4617c(C0936a c0936a) {
        m4612a(c0936a, true, false);
    }

    public void m4610a(final C0108b c0108b, final String str) {
        m4605b(new Runnable(this) {
            final /* synthetic */ C0915b f2467c;

            public void run() {
                try {
                    this.f2467c.f2476b.mo715a(c0108b, str);
                } catch (Throwable e) {
                    C0142c.m468h().mo54e("Answers", "Failed to set analytics settings data", e);
                }
            }
        });
    }

    public void m4609a() {
        m4605b(new C09102(this));
    }

    public void mo708a(String str) {
        m4605b(new C09113(this));
    }

    public void m4614b() {
        m4605b(new C09124(this));
    }

    public void m4616c() {
        m4605b(new C09135(this));
    }

    void m4612a(final C0936a c0936a, boolean z, final boolean z2) {
        Runnable c09146 = new Runnable(this) {
            final /* synthetic */ C0915b f2474c;

            public void run() {
                try {
                    this.f2474c.f2476b.mo716a(c0936a);
                    if (z2) {
                        this.f2474c.f2476b.mo718c();
                    }
                } catch (Throwable e) {
                    C0142c.m468h().mo54e("Answers", "Failed to process event", e);
                }
            }
        };
        if (z) {
            m4603a(c09146);
        } else {
            m4605b(c09146);
        }
    }

    private void m4603a(Runnable runnable) {
        try {
            this.f2475a.submit(runnable).get();
        } catch (Throwable e) {
            C0142c.m468h().mo54e("Answers", "Failed to run events task", e);
        }
    }

    private void m4605b(Runnable runnable) {
        try {
            this.f2475a.submit(runnable);
        } catch (Throwable e) {
            C0142c.m468h().mo54e("Answers", "Failed to submit events task", e);
        }
    }
}
