package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import p000a.p001a.p002a.p003a.C0142c;

/* compiled from: AdvertisingInfoReflectionStrategy */
class C0013d implements C0012f {
    private final Context f18a;

    public C0013d(Context context) {
        this.f18a = context.getApplicationContext();
    }

    boolean m40a(Context context) {
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public C0008b mo5a() {
        if (m40a(this.f18a)) {
            return new C0008b(m36b(), m37c());
        }
        return null;
    }

    private String m36b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m38d(), new Object[0]);
        } catch (Exception e) {
            C0142c.m468h().mo51d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private boolean m37c() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m38d(), new Object[0])).booleanValue();
        } catch (Exception e) {
            C0142c.m468h().mo51d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    private Object m38d() {
        Object obj = null;
        try {
            obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f18a});
        } catch (Exception e) {
            C0142c.m468h().mo51d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
        }
        return obj;
    }
}
