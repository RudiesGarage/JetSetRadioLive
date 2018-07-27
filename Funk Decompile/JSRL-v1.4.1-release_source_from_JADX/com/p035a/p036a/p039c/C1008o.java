package com.p035a.p036a.p039c;

import java.util.Map.Entry;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0007a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0041r;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098d;

/* compiled from: DefaultCreateReportSpiCall */
class C1008o extends C0007a implements C1007n {
    public C1008o(C0149i c0149i, String str, String str2, C0088e c0088e) {
        super(c0149i, str, str2, c0088e, C0090c.POST);
    }

    public boolean mo740a(C1006m c1006m) {
        C0098d b = m4971b(m4970a(m22b(), c1006m), c1006m);
        C0142c.m468h().mo46a("CrashlyticsCore", "Sending report to: " + m21a());
        int b2 = b.m326b();
        C0142c.m468h().mo46a("CrashlyticsCore", "Create report request ID: " + b.m328b("X-REQUEST-ID"));
        C0142c.m468h().mo46a("CrashlyticsCore", "Result was: " + b2);
        return C0041r.m156a(b2) == 0;
    }

    private C0098d m4970a(C0098d c0098d, C1006m c1006m) {
        C0098d a = c0098d.m316a("X-CRASHLYTICS-API-KEY", c1006m.f2738a).m316a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m316a("X-CRASHLYTICS-API-CLIENT-VERSION", C0985f.m4866e().mo64a());
        C0098d c0098d2 = a;
        for (Entry a2 : c1006m.f2739b.mo733e().entrySet()) {
            c0098d2 = c0098d2.m322a(a2);
        }
        return c0098d2;
    }

    private C0098d m4971b(C0098d c0098d, C1006m c1006m) {
        C0964y c0964y = c1006m.f2739b;
        return c0098d.m319a("report[file]", c0964y.mo730b(), "application/octet-stream", c0964y.mo732d()).m336e("report[identifier]", c0964y.mo731c());
    }
}
