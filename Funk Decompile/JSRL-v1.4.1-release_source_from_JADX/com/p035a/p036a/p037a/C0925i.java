package com.p035a.p036a.p037a;

import android.content.Context;
import com.p035a.p036a.p037a.C0938s.C0936a;
import com.p035a.p036a.p037a.C0938s.C0937b;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p009d.C0082f;
import p000a.p001a.p002a.p003a.p004a.p009d.C0085i;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p012g.C0108b;

/* compiled from: EnabledSessionAnalyticsManagerStrategy */
class C0925i implements C0923r {
    final C0939t f2495a;
    C0082f f2496b;
    C0018g f2497c = new C0018g();
    C0926j f2498d = new C0927k();
    boolean f2499e = true;
    boolean f2500f = true;
    volatile int f2501g = -1;
    private final C0149i f2502h;
    private final C0088e f2503i;
    private final Context f2504j;
    private final C0932o f2505k;
    private final ScheduledExecutorService f2506l;
    private final AtomicReference<ScheduledFuture<?>> f2507m = new AtomicReference();

    public C0925i(C0149i c0149i, Context context, ScheduledExecutorService scheduledExecutorService, C0932o c0932o, C0088e c0088e, C0939t c0939t) {
        this.f2502h = c0149i;
        this.f2504j = context;
        this.f2506l = scheduledExecutorService;
        this.f2505k = c0932o;
        this.f2503i = c0088e;
        this.f2495a = c0939t;
    }

    public void mo715a(C0108b c0108b, String str) {
        this.f2496b = C0919f.m4629a(new C0933p(this.f2502h, str, c0108b.f216a, this.f2503i, this.f2497c.m46a(this.f2504j)));
        this.f2505k.m4665a(c0108b);
        this.f2499e = c0108b.f221f;
        C0142c.m468h().mo46a("Answers", "Custom event tracking " + (this.f2499e ? "enabled" : "disabled"));
        this.f2500f = c0108b.f222g;
        C0142c.m468h().mo46a("Answers", "Predefined event tracking " + (this.f2500f ? "enabled" : "disabled"));
        if (c0108b.f224i > 1) {
            C0142c.m468h().mo46a("Answers", "Event sampling enabled");
            this.f2498d = new C0931n(c0108b.f224i);
        }
        this.f2501g = c0108b.f217b;
        m4649a(0, (long) this.f2501g);
    }

    public void mo716a(C0936a c0936a) {
        C0938s a = c0936a.m4681a(this.f2495a);
        if (!this.f2499e && C0937b.CUSTOM.equals(a.f2540c)) {
            C0142c.m468h().mo46a("Answers", "Custom events tracking disabled - skipping event: " + a);
        } else if (!this.f2500f && C0937b.PREDEFINED.equals(a.f2540c)) {
            C0142c.m468h().mo46a("Answers", "Predefined events tracking disabled - skipping event: " + a);
        } else if (this.f2498d.mo720a(a)) {
            C0142c.m468h().mo46a("Answers", "Skipping filtered event: " + a);
        } else {
            try {
                this.f2505k.m242a((Object) a);
            } catch (Throwable e) {
                C0142c.m468h().mo54e("Answers", "Failed to write event: " + a, e);
            }
            m4655e();
        }
    }

    public void m4655e() {
        if ((this.f2501g != -1 ? 1 : null) != null) {
            m4649a((long) this.f2501g, (long) this.f2501g);
        }
    }

    public void mo714a() {
        if (this.f2496b == null) {
            C0021i.m68a(this.f2504j, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        C0021i.m68a(this.f2504j, "Sending all files");
        List e = this.f2505k.m247e();
        int i = 0;
        while (e.size() > 0) {
            int size;
            C0021i.m68a(this.f2504j, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(e.size())}));
            boolean a = this.f2496b.mo713a(e);
            if (a) {
                size = e.size() + i;
                try {
                    this.f2505k.m243a(e);
                    i = size;
                } catch (Exception e2) {
                    Throwable e3 = e2;
                }
            }
            if (!a) {
                break;
            }
            try {
                e = this.f2505k.m247e();
            } catch (Throwable e4) {
                Throwable th = e4;
                size = i;
                e3 = th;
            }
        }
        if (i == 0) {
            this.f2505k.m249g();
        }
        C0021i.m69a(this.f2504j, "Failed to send batch of analytics files to server: " + e3.getMessage(), e3);
        i = size;
        if (i == 0) {
            this.f2505k.m249g();
        }
    }

    public void mo719d() {
        if (this.f2507m.get() != null) {
            C0021i.m68a(this.f2504j, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.f2507m.get()).cancel(false);
            this.f2507m.set(null);
        }
    }

    public void mo717b() {
        this.f2505k.m248f();
    }

    public boolean mo718c() {
        try {
            return this.f2505k.m246d();
        } catch (Throwable e) {
            C0021i.m69a(this.f2504j, "Failed to roll file over.", e);
            return false;
        }
    }

    void m4649a(long j, long j2) {
        if ((this.f2507m.get() == null ? 1 : null) != null) {
            Runnable c0085i = new C0085i(this.f2504j, this);
            C0021i.m68a(this.f2504j, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.f2507m.set(this.f2506l.scheduleAtFixedRate(c0085i, j, j2, TimeUnit.SECONDS));
            } catch (Throwable e) {
                C0021i.m69a(this.f2504j, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
