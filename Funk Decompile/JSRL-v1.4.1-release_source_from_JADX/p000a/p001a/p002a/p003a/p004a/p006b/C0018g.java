package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import p000a.p001a.p002a.p003a.C0142c;

/* compiled from: ApiKey */
public class C0018g {
    public String m46a(Context context) {
        Object b = m47b(context);
        if (TextUtils.isEmpty(b)) {
            b = m48c(context);
        }
        if (TextUtils.isEmpty(b)) {
            m49d(context);
        }
        return b;
    }

    protected String m47b(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.ApiKey");
                if (str == null) {
                    C0142c.m468h().mo46a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    str = bundle.getString("com.crashlytics.ApiKey");
                }
            }
        } catch (Exception e) {
            C0142c.m468h().mo46a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
        }
        return str;
    }

    protected String m48c(Context context) {
        int a = C0021i.m53a(context, "io.fabric.ApiKey", "string");
        if (a == 0) {
            C0142c.m468h().mo46a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a = C0021i.m53a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a != 0) {
            return context.getResources().getString(a);
        }
        return null;
    }

    protected void m49d(Context context) {
        if (C0142c.m469i() || C0021i.m89i(context)) {
            throw new IllegalArgumentException(m45a());
        }
        C0142c.m468h().mo53e("Fabric", m45a());
    }

    protected String m45a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
