package p000a.p001a.p002a.p003a.p004a.p012g;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0007a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098d;

/* compiled from: DefaultSettingsSpiCall */
class C0121l extends C0007a implements C0120x {
    public C0121l(C0149i c0149i, String str, String str2, C0088e c0088e) {
        this(c0149i, str, str2, c0088e, C0090c.GET);
    }

    C0121l(C0149i c0149i, String str, String str2, C0088e c0088e, C0090c c0090c) {
        super(c0149i, str, str2, c0088e, c0090c);
    }

    public JSONObject mo44a(C0133w c0133w) {
        C0098d c0098d = null;
        try {
            Map b = m408b(c0133w);
            c0098d = m405a(m20a(b), c0133w);
            C0142c.m468h().mo46a("Fabric", "Requesting settings from " + m21a());
            C0142c.m468h().mo46a("Fabric", "Settings query params were: " + b);
            JSONObject a = m409a(c0098d);
            return a;
        } finally {
            if (c0098d != null) {
                C0142c.m468h().mo46a("Fabric", "Settings request ID: " + c0098d.m328b("X-REQUEST-ID"));
            }
        }
    }

    JSONObject m409a(C0098d c0098d) {
        int b = c0098d.m326b();
        C0142c.m468h().mo46a("Fabric", "Settings result was: " + b);
        if (m411a(b)) {
            return m406a(c0098d.m337e());
        }
        C0142c.m468h().mo53e("Fabric", "Failed to retrieve settings from " + m21a());
        return null;
    }

    boolean m411a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    private JSONObject m406a(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            C0142c.m468h().mo47a("Fabric", "Failed to parse settings JSON from " + m21a(), e);
            C0142c.m468h().mo46a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> m408b(C0133w c0133w) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c0133w.f304j);
        hashMap.put("display_version", c0133w.f303i);
        hashMap.put("source", Integer.toString(c0133w.f305k));
        if (c0133w.f306l != null) {
            hashMap.put("icon_hash", c0133w.f306l);
        }
        String str = c0133w.f302h;
        if (!C0021i.m83c(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    private C0098d m405a(C0098d c0098d, C0133w c0133w) {
        m407a(c0098d, "X-CRASHLYTICS-API-KEY", c0133w.f295a);
        m407a(c0098d, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        m407a(c0098d, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo64a());
        m407a(c0098d, "Accept", "application/json");
        m407a(c0098d, "X-CRASHLYTICS-DEVICE-MODEL", c0133w.f296b);
        m407a(c0098d, "X-CRASHLYTICS-OS-BUILD-VERSION", c0133w.f297c);
        m407a(c0098d, "X-CRASHLYTICS-OS-DISPLAY-VERSION", c0133w.f298d);
        m407a(c0098d, "X-CRASHLYTICS-ADVERTISING-TOKEN", c0133w.f299e);
        m407a(c0098d, "X-CRASHLYTICS-INSTALLATION-ID", c0133w.f300f);
        m407a(c0098d, "X-CRASHLYTICS-ANDROID-ID", c0133w.f301g);
        return c0098d;
    }

    private void m407a(C0098d c0098d, String str, String str2) {
        if (str2 != null) {
            c0098d.m316a(str, str2);
        }
    }
}
