package com.p035a.p036a.p038b;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0007a;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098d;

/* compiled from: CheckForUpdatesRequest */
class C0950e extends C0007a {
    private final C0952g f2590b;

    static String m4723a(String str) {
        return "3:" + str;
    }

    public C0950e(C0149i c0149i, String str, String str2, C0088e c0088e, C0952g c0952g) {
        super(c0149i, str, str2, c0088e, C0090c.GET);
        this.f2590b = c0952g;
    }

    public C0951f m4725a(String str, String str2, C0949d c0949d) {
        C0098d a;
        Throwable e;
        Throwable th;
        C0951f c0951f = null;
        try {
            Map a2 = m4724a(c0949d);
            try {
                a = m4722a(m20a(a2), str, str2);
                C0142c.m468h().mo46a("Beta", "Checking for updates from " + m21a());
                C0142c.m468h().mo46a("Beta", "Checking for updates query params are: " + a2);
                if (a.m332c()) {
                    C0142c.m468h().mo46a("Beta", "Checking for updates was successful");
                    c0951f = this.f2590b.m4726a(new JSONObject(a.m337e()));
                    if (a != null) {
                        C0142c.m468h().mo46a("Fabric", "Checking for updates request ID: " + a.m328b("X-REQUEST-ID"));
                    }
                } else {
                    C0142c.m468h().mo53e("Beta", "Checking for updates failed. Response code: " + a.m326b());
                    if (a != null) {
                        C0142c.m468h().mo46a("Fabric", "Checking for updates request ID: " + a.m328b("X-REQUEST-ID"));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    C0142c.m468h().mo54e("Beta", "Error while checking for updates from " + m21a(), e);
                    if (a != null) {
                        C0142c.m468h().mo46a("Fabric", "Checking for updates request ID: " + a.m328b("X-REQUEST-ID"));
                    }
                    return c0951f;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        C0142c.m468h().mo46a("Fabric", "Checking for updates request ID: " + a.m328b("X-REQUEST-ID"));
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            C0142c.m468h().mo54e("Beta", "Error while checking for updates from " + m21a(), e);
            if (a != null) {
                C0142c.m468h().mo46a("Fabric", "Checking for updates request ID: " + a.m328b("X-REQUEST-ID"));
            }
            return c0951f;
        } catch (Throwable e4) {
            a = null;
            th = e4;
            if (a != null) {
                C0142c.m468h().mo46a("Fabric", "Checking for updates request ID: " + a.m328b("X-REQUEST-ID"));
            }
            throw th;
        }
        return c0951f;
    }

    private C0098d m4722a(C0098d c0098d, String str, String str2) {
        return c0098d.m316a("Accept", "application/json").m316a("User-Agent", "Crashlytics Android SDK/" + this.a.mo64a()).m316a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").m316a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m316a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo64a()).m316a("X-CRASHLYTICS-API-KEY", str).m316a("X-CRASHLYTICS-BETA-TOKEN", C0950e.m4723a(str2));
    }

    private Map<String, String> m4724a(C0949d c0949d) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c0949d.f2586a);
        hashMap.put("display_version", c0949d.f2587b);
        hashMap.put("instance", c0949d.f2588c);
        hashMap.put("source", "3");
        return hashMap;
    }
}
