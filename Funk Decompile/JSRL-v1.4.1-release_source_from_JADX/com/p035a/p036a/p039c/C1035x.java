package com.p035a.p036a.p039c;

import java.io.File;
import java.io.InputStream;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0040q;
import p000a.p001a.p002a.p003a.p004a.p006b.C0040q.C0036c;

/* compiled from: QueueFileLogStore */
class C1035x implements C1013r {
    private final File f2797a;
    private final int f2798b;
    private C0040q f2799c;

    public C1035x(File file, int i) {
        this.f2797a = file;
        this.f2798b = i;
    }

    public C0965b mo741a() {
        if (!this.f2797a.exists()) {
            return null;
        }
        m5045d();
        if (this.f2799c == null) {
            return null;
        }
        final int[] iArr = new int[]{0};
        final byte[] bArr = new byte[this.f2799c.m150a()];
        try {
            this.f2799c.m151a(new C0036c(this) {
                final /* synthetic */ C1035x f2796c;

                public void mo7a(InputStream inputStream, int i) {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (Throwable e) {
            C0142c.m468h().mo54e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return C0965b.m4780a(bArr, 0, iArr[0]);
    }

    public void mo742b() {
        C0021i.m71a(this.f2799c, "There was a problem closing the Crashlytics log file.");
        this.f2799c = null;
    }

    public void mo743c() {
        mo742b();
        this.f2797a.delete();
    }

    private void m5045d() {
        if (this.f2799c == null) {
            try {
                this.f2799c = new C0040q(this.f2797a);
            } catch (Throwable e) {
                C0142c.m468h().mo54e("CrashlyticsCore", "Could not open log file: " + this.f2797a, e);
            }
        }
    }
}
