package com.p035a.p036a.p037a;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.p035a.p036a.p037a.C0922g.C0921a;
import com.p035a.p036a.p037a.C0938s.C0937b;
import java.util.concurrent.ScheduledExecutorService;
import p000a.p001a.p002a.p003a.C0135a;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0031n;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p010e.C0089b;
import p000a.p001a.p002a.p003a.p004a.p011f.C0104b;
import p000a.p001a.p002a.p003a.p004a.p012g.C0108b;

/* compiled from: SessionAnalyticsManager */
class C0934q implements C0921a {
    final C0915b f2517a;
    final C0135a f2518b;
    final C0922g f2519c;
    final C0918e f2520d;
    private final long f2521e;

    public static C0934q m4669a(C0149i c0149i, Context context, C0033o c0033o, String str, String str2, long j) {
        C0941v c0941v = new C0941v(context, c0033o, str, str2);
        C0916c c0916c = new C0916c(context, new C0104b(c0149i));
        C0088e c0089b = new C0089b(C0142c.m468h());
        C0135a c0135a = new C0135a(context);
        ScheduledExecutorService b = C0031n.m106b("Answers Events Handler");
        C0922g c0922g = new C0922g(b);
        return new C0934q(new C0915b(c0149i, context, c0916c, c0941v, c0089b, b), c0135a, c0922g, C0918e.m4626a(context), j);
    }

    C0934q(C0915b c0915b, C0135a c0135a, C0922g c0922g, C0918e c0918e, long j) {
        this.f2517a = c0915b;
        this.f2518b = c0135a;
        this.f2519c = c0922g;
        this.f2520d = c0918e;
        this.f2521e = j;
    }

    public void m4676b() {
        this.f2517a.m4614b();
        this.f2518b.m425a(new C0917d(this, this.f2519c));
        this.f2519c.m4635a((C0921a) this);
        if (m4675a(this.f2521e)) {
            m4679d();
            this.f2520d.m4627a();
        }
    }

    public void m4678c() {
        this.f2518b.m424a();
        this.f2517a.m4609a();
    }

    public void m4674a(String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        C0142c.m468h().mo46a("Answers", "Logged crash");
        this.f2517a.m4617c(C0938s.m4686a(str, str2));
    }

    public void m4673a(String str) {
    }

    public void m4679d() {
        C0142c.m468h().mo46a("Answers", "Logged install");
        this.f2517a.m4615b(C0938s.m4683a());
    }

    public void m4672a(Activity activity, C0937b c0937b) {
        C0142c.m468h().mo46a("Answers", "Logged lifecycle event: " + c0937b.name());
        this.f2517a.m4611a(C0938s.m4684a(c0937b, activity));
    }

    public void mo724a() {
        C0142c.m468h().mo46a("Answers", "Flush events when app is backgrounded");
        this.f2517a.m4616c();
    }

    public void m4671a(C0108b c0108b, String str) {
        this.f2519c.m4636a(c0108b.f223h);
        this.f2517a.m4610a(c0108b, str);
    }

    boolean m4675a(long j) {
        return !this.f2520d.m4628b() && m4677b(j);
    }

    boolean m4677b(long j) {
        return System.currentTimeMillis() - j < 3600000;
    }
}
