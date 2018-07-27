package com.p035a.p036a.p037a;

import android.content.Context;
import java.util.UUID;
import p000a.p001a.p002a.p003a.p004a.p006b.C0025k;
import p000a.p001a.p002a.p003a.p004a.p009d.C0078b;
import p000a.p001a.p002a.p003a.p004a.p009d.C0079c;
import p000a.p001a.p002a.p003a.p004a.p012g.C0108b;

/* compiled from: SessionAnalyticsFilesManager */
class C0932o extends C0078b<C0938s> {
    private C0108b f2515g;

    C0932o(Context context, C0940u c0940u, C0025k c0025k, C0079c c0079c) {
        super(context, c0940u, c0025k, c0079c, 100);
    }

    protected String mo721a() {
        return "sa" + "_" + UUID.randomUUID().toString() + "_" + this.c.mo8a() + ".tap";
    }

    protected int mo722b() {
        return this.f2515g == null ? super.mo722b() : this.f2515g.f220e;
    }

    protected int mo723c() {
        return this.f2515g == null ? super.mo723c() : this.f2515g.f218c;
    }

    void m4665a(C0108b c0108b) {
        this.f2515g = c0108b;
    }
}
