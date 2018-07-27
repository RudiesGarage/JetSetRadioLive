package com.p035a.p036a.p039c;

import java.io.File;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0103a;

/* compiled from: CrashlyticsFileMarker */
class C0989h {
    private final String f2701a;
    private final C0103a f2702b;

    public C0989h(String str, C0103a c0103a) {
        this.f2701a = str;
        this.f2702b = c0103a;
    }

    public boolean m4901a() {
        boolean z = false;
        try {
            z = m4900d().createNewFile();
        } catch (Throwable e) {
            C0142c.m468h().mo54e("CrashlyticsCore", "Error creating marker: " + this.f2701a, e);
        }
        return z;
    }

    public boolean m4902b() {
        return m4900d().exists();
    }

    public boolean m4903c() {
        return m4900d().delete();
    }

    private File m4900d() {
        return new File(this.f2702b.mo34a(), this.f2701a);
    }
}
