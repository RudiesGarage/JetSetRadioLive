package p000a.p001a.p002a.p003a.p004a.p012g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0025k;
import p000a.p001a.p002a.p003a.p004a.p011f.C0105c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;

/* compiled from: DefaultSettingsController */
class C0117j implements C0116s {
    private final C0133w f248a;
    private final C0118v f249b;
    private final C0025k f250c;
    private final C0113g f251d;
    private final C0120x f252e;
    private final C0149i f253f;
    private final C0105c f254g = new C0106d(this.f253f);

    public C0117j(C0149i c0149i, C0133w c0133w, C0025k c0025k, C0118v c0118v, C0113g c0113g, C0120x c0120x) {
        this.f253f = c0149i;
        this.f248a = c0133w;
        this.f250c = c0025k;
        this.f249b = c0118v;
        this.f251d = c0113g;
        this.f252e = c0120x;
    }

    public C0131t mo41a() {
        return mo42a(C0130r.USE_CACHE);
    }

    public C0131t mo42a(C0130r c0130r) {
        Throwable th;
        C0131t c0131t;
        Throwable th2;
        C0131t c0131t2 = null;
        try {
            if (!(C0142c.m469i() || m393d())) {
                c0131t2 = m387b(c0130r);
            }
            if (c0131t2 == null) {
                try {
                    JSONObject a = this.f252e.mo44a(this.f248a);
                    if (a != null) {
                        c0131t2 = this.f249b.mo43a(this.f250c, a);
                        this.f251d.mo40a(c0131t2.f291g, a);
                        m386a(a, "Loaded settings: ");
                        m390a(m391b());
                    }
                } catch (Throwable e) {
                    th = e;
                    c0131t = c0131t2;
                    th2 = th;
                    C0142c.m468h().mo54e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return c0131t;
                }
            }
            c0131t = c0131t2;
            if (c0131t == null) {
                try {
                    c0131t = m387b(C0130r.IGNORE_CACHE_EXPIRATION);
                } catch (Exception e2) {
                    th2 = e2;
                    C0142c.m468h().mo54e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return c0131t;
                }
            }
        } catch (Throwable e3) {
            th = e3;
            c0131t = null;
            th2 = th;
            C0142c.m468h().mo54e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
            return c0131t;
        }
        return c0131t;
    }

    private C0131t m387b(C0130r c0130r) {
        Throwable th;
        C0131t c0131t = null;
        try {
            if (C0130r.SKIP_CACHE_LOOKUP.equals(c0130r)) {
                return null;
            }
            JSONObject a = this.f251d.mo39a();
            if (a != null) {
                C0131t a2 = this.f249b.mo43a(this.f250c, a);
                if (a2 != null) {
                    m386a(a, "Loaded cached settings: ");
                    long a3 = this.f250c.mo8a();
                    if (C0130r.IGNORE_CACHE_EXPIRATION.equals(c0130r) || !a2.m422a(a3)) {
                        try {
                            C0142c.m468h().mo46a("Fabric", "Returning cached settings.");
                            return a2;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            c0131t = a2;
                            th = th2;
                            C0142c.m468h().mo54e("Fabric", "Failed to get cached settings", th);
                            return c0131t;
                        }
                    }
                    C0142c.m468h().mo46a("Fabric", "Cached settings have expired.");
                    return null;
                }
                C0142c.m468h().mo54e("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            C0142c.m468h().mo46a("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e2) {
            th = e2;
            C0142c.m468h().mo54e("Fabric", "Failed to get cached settings", th);
            return c0131t;
        }
    }

    private void m386a(JSONObject jSONObject, String str) {
        C0142c.m468h().mo46a("Fabric", str + jSONObject.toString());
    }

    String m391b() {
        return C0021i.m66a(C0021i.m93m(this.f253f.m496E()));
    }

    String m392c() {
        return this.f254g.mo35a().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean m390a(String str) {
        Editor b = this.f254g.mo37b();
        b.putString("existing_instance_identifier", str);
        return this.f254g.mo36a(b);
    }

    boolean m393d() {
        return !m392c().equals(m391b());
    }
}
