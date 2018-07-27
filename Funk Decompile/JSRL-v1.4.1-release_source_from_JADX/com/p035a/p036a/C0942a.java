package com.p035a.p036a;

import com.p035a.p036a.p037a.C0908a;
import com.p035a.p036a.p038b.C0948c;
import com.p035a.p036a.p039c.C0985f;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.C0150j;

/* compiled from: Crashlytics */
public class C0942a extends C0149i<Void> implements C0150j {
    public final C0908a f2564a;
    public final C0948c f2565b;
    public final C0985f f2566c;
    public final Collection<? extends C0149i> f2567d;

    protected /* synthetic */ Object mo67f() {
        return m4697d();
    }

    public C0942a() {
        this(new C0908a(), new C0948c(), new C0985f());
    }

    C0942a(C0908a c0908a, C0948c c0948c, C0985f c0985f) {
        this.f2564a = c0908a;
        this.f2565b = c0948c;
        this.f2566c = c0985f;
        this.f2567d = Collections.unmodifiableCollection(Arrays.asList(new C0149i[]{c0908a, c0948c, c0985f}));
    }

    public String mo64a() {
        return "2.6.1.139";
    }

    public String mo66b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public Collection<? extends C0149i> mo726c() {
        return this.f2567d;
    }

    protected Void m4697d() {
        return null;
    }

    public static C0942a m4692e() {
        return (C0942a) C0142c.m460a(C0942a.class);
    }

    public static void m4691a(Throwable th) {
        C0942a.m4693g();
        C0942a.m4692e().f2566c.m4871a(th);
    }

    private static void m4693g() {
        if (C0942a.m4692e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
