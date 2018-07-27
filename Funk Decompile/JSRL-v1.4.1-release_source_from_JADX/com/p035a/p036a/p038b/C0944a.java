package com.p035a.p036a.p038b;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;
import p000a.p001a.p002a.p003a.p004a.p006b.C0025k;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o.C0032a;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p011f.C0105c;
import p000a.p001a.p002a.p003a.p004a.p012g.C0112f;

/* compiled from: AbstractCheckForUpdatesController */
abstract class C0944a implements C0943j {
    private final AtomicBoolean f2568a;
    private final AtomicBoolean f2569b;
    private Context f2570c;
    private C0948c f2571d;
    private C0033o f2572e;
    private C0112f f2573f;
    private C0949d f2574g;
    private C0105c f2575h;
    private C0025k f2576i;
    private C0088e f2577j;
    private long f2578k;

    public C0944a() {
        this(false);
    }

    public C0944a(boolean z) {
        this.f2568a = new AtomicBoolean();
        this.f2578k = 0;
        this.f2569b = new AtomicBoolean(z);
    }

    public void mo727a(Context context, C0948c c0948c, C0033o c0033o, C0112f c0112f, C0949d c0949d, C0105c c0105c, C0025k c0025k, C0088e c0088e) {
        this.f2570c = context;
        this.f2571d = c0948c;
        this.f2572e = c0033o;
        this.f2573f = c0112f;
        this.f2574g = c0949d;
        this.f2575h = c0105c;
        this.f2576i = c0025k;
        this.f2577j = c0088e;
        if (m4704b()) {
            m4705c();
        }
    }

    protected boolean m4703a() {
        this.f2569b.set(true);
        return this.f2568a.get();
    }

    boolean m4704b() {
        this.f2568a.set(true);
        return this.f2569b.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void m4705c() {
        synchronized (this.f2575h) {
            if (this.f2575h.mo35a().contains("last_update_check")) {
                this.f2575h.mo36a(this.f2575h.mo37b().remove("last_update_check"));
            }
        }
        long a = this.f2576i.mo8a();
        long j = ((long) this.f2573f.f246b) * 1000;
        C0142c.m468h().mo46a("Beta", "Check for updates delay: " + j);
        C0142c.m468h().mo46a("Beta", "Check for updates last check time: " + m4706d());
        j += m4706d();
        C0142c.m468h().mo46a("Beta", "Check for updates current time: " + a + ", next check time: " + j);
        if (a >= j) {
            try {
                m4700e();
            } finally {
                m4701a(a);
            }
        } else {
            C0142c.m468h().mo46a("Beta", "Check for updates next check time was not passed");
        }
    }

    private void m4700e() {
        C0142c.m468h().mo46a("Beta", "Performing update check");
        new C0950e(this.f2571d, this.f2571d.m4719g(), this.f2573f.f245a, this.f2577j, new C0952g()).m4725a(new C0018g().m46a(this.f2570c), (String) this.f2572e.m120i().get(C0032a.FONT_TOKEN), this.f2574g);
    }

    void m4701a(long j) {
        this.f2578k = j;
    }

    long m4706d() {
        return this.f2578k;
    }
}
