package p000a.p001a.p002a.p003a.p004a.p006b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0105c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;

/* compiled from: AdvertisingInfoProvider */
class C0011c {
    private final Context f16a;
    private final C0105c f17b;

    public C0011c(Context context) {
        this.f16a = context.getApplicationContext();
        this.f17b = new C0106d(context, "TwitterAdvertisingInfoPreferences");
    }

    public C0008b m31a() {
        C0008b b = m32b();
        if (m29c(b)) {
            C0142c.m468h().mo46a("Fabric", "Using AdvertisingInfo from Preference Store");
            m26a(b);
            return b;
        }
        b = m30e();
        m28b(b);
        return b;
    }

    private void m26a(final C0008b c0008b) {
        new Thread(new C0009h(this) {
            final /* synthetic */ C0011c f15b;

            public void mo4a() {
                C0008b a = this.f15b.m30e();
                if (!c0008b.equals(a)) {
                    C0142c.m468h().mo46a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    this.f15b.m28b(a);
                }
            }
        }).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m28b(C0008b c0008b) {
        if (m29c(c0008b)) {
            this.f17b.mo36a(this.f17b.mo37b().putString("advertising_id", c0008b.f12a).putBoolean("limit_ad_tracking_enabled", c0008b.f13b));
        } else {
            this.f17b.mo36a(this.f17b.mo37b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected C0008b m32b() {
        return new C0008b(this.f17b.mo35a().getString("advertising_id", ""), this.f17b.mo35a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public C0012f m33c() {
        return new C0013d(this.f16a);
    }

    public C0012f m34d() {
        return new C0017e(this.f16a);
    }

    private boolean m29c(C0008b c0008b) {
        return (c0008b == null || TextUtils.isEmpty(c0008b.f12a)) ? false : true;
    }

    private C0008b m30e() {
        C0008b a = m33c().mo5a();
        if (m29c(a)) {
            C0142c.m468h().mo46a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            a = m34d().mo5a();
            if (m29c(a)) {
                C0142c.m468h().mo46a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                C0142c.m468h().mo46a("Fabric", "AdvertisingInfo not present");
            }
        }
        return a;
    }
}
