package p000a.p001a.p002a.p003a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0026l;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p010e.C0089b;
import p000a.p001a.p002a.p003a.p004a.p012g.C0110d;
import p000a.p001a.p002a.p003a.p004a.p012g.C0111e;
import p000a.p001a.p002a.p003a.p004a.p012g.C0114h;
import p000a.p001a.p002a.p003a.p004a.p012g.C0123n;
import p000a.p001a.p002a.p003a.p004a.p012g.C0129q;
import p000a.p001a.p002a.p003a.p004a.p012g.C0131t;
import p000a.p001a.p002a.p003a.p004a.p012g.C0134y;

/* compiled from: Onboarding */
class C0152m extends C0149i<Boolean> {
    private final C0088e f351a = new C0089b();
    private PackageManager f352b;
    private String f353c;
    private PackageInfo f354d;
    private String f355k;
    private String f356l;
    private String f357m;
    private String f358n;
    private String f359o;
    private final Future<Map<String, C0151k>> f360p;
    private final Collection<C0149i> f361q;

    protected /* synthetic */ Object mo67f() {
        return m522d();
    }

    public C0152m(Future<Map<String, C0151k>> future, Collection<C0149i> collection) {
        this.f360p = future;
        this.f361q = collection;
    }

    public String mo64a() {
        return "1.3.12.127";
    }

    protected boolean a_() {
        try {
            this.f357m = m495D().m121j();
            this.f352b = m496E().getPackageManager();
            this.f353c = m496E().getPackageName();
            this.f354d = this.f352b.getPackageInfo(this.f353c, 0);
            this.f355k = Integer.toString(this.f354d.versionCode);
            this.f356l = this.f354d.versionName == null ? "0.0" : this.f354d.versionName;
            this.f358n = this.f352b.getApplicationLabel(m496E().getApplicationInfo()).toString();
            this.f359o = Integer.toString(m496E().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            C0142c.m468h().mo54e("Fabric", "Failed init", e);
            return false;
        }
    }

    protected Boolean m522d() {
        boolean a;
        String k = C0021i.m91k(m496E());
        C0131t g = m518g();
        if (g != null) {
            try {
                Map map;
                if (this.f360p != null) {
                    map = (Map) this.f360p.get();
                } else {
                    map = new HashMap();
                }
                a = m515a(k, g.f285a, m520a(map, this.f361q).values());
            } catch (Throwable e) {
                C0142c.m468h().mo54e("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(a);
        }
        a = false;
        return Boolean.valueOf(a);
    }

    private C0131t m518g() {
        try {
            C0129q.m415a().m417a(this, this.i, this.f351a, this.f355k, this.f356l, m523e()).m420c();
            return C0129q.m415a().m419b();
        } catch (Throwable e) {
            C0142c.m468h().mo54e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, C0151k> m520a(Map<String, C0151k> map, Collection<C0149i> collection) {
        for (C0149i c0149i : collection) {
            if (!map.containsKey(c0149i.mo66b())) {
                map.put(c0149i.mo66b(), new C0151k(c0149i.mo66b(), c0149i.mo64a(), "binary"));
            }
        }
        return map;
    }

    public String mo66b() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean m515a(String str, C0111e c0111e, Collection<C0151k> collection) {
        if ("new".equals(c0111e.f240b)) {
            if (m516b(str, c0111e, collection)) {
                return C0129q.m415a().m421d();
            }
            C0142c.m468h().mo54e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(c0111e.f240b)) {
            return C0129q.m415a().m421d();
        } else {
            if (!c0111e.f243e) {
                return true;
            }
            C0142c.m468h().mo46a("Fabric", "Server says an update is required - forcing a full App update.");
            m517c(str, c0111e, collection);
            return true;
        }
    }

    private boolean m516b(String str, C0111e c0111e, Collection<C0151k> collection) {
        return new C0114h(this, m523e(), c0111e.f241c, this.f351a).mo38a(m513a(C0123n.m412a(m496E(), str), (Collection) collection));
    }

    private boolean m517c(String str, C0111e c0111e, Collection<C0151k> collection) {
        return m514a(c0111e, C0123n.m412a(m496E(), str), (Collection) collection);
    }

    private boolean m514a(C0111e c0111e, C0123n c0123n, Collection<C0151k> collection) {
        return new C0134y(this, m523e(), c0111e.f241c, this.f351a).mo38a(m513a(c0123n, (Collection) collection));
    }

    private C0110d m513a(C0123n c0123n, Collection<C0151k> collection) {
        return new C0110d(new C0018g().m46a(m496E()), m495D().m114c(), this.f356l, this.f355k, C0021i.m66a(C0021i.m93m(r0)), this.f358n, C0026l.m98a(this.f357m).m99a(), this.f359o, "0", c0123n, collection);
    }

    String m523e() {
        return C0021i.m78b(m496E(), "com.crashlytics.ApiEndpoint");
    }
}
