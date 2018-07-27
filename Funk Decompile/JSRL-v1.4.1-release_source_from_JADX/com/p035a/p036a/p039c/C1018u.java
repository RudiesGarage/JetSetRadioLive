package com.p035a.p036a.p039c;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;

/* compiled from: MetaDataStore */
class C1018u {
    private static final Charset f2758a = Charset.forName("UTF-8");
    private final File f2759b;

    public C1018u(File file) {
        this.f2759b = file;
    }

    public ad m5005a(String str) {
        Closeable fileInputStream;
        Throwable e;
        File c = m5001c(str);
        if (!c.exists()) {
            return ad.f2634a;
        }
        try {
            fileInputStream = new FileInputStream(c);
            try {
                ad e2 = C1018u.m5003e(C0021i.m60a((InputStream) fileInputStream));
                C0021i.m71a(fileInputStream, "Failed to close user metadata file.");
                return e2;
            } catch (Exception e3) {
                e = e3;
                try {
                    C0142c.m468h().mo54e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    C0021i.m71a(fileInputStream, "Failed to close user metadata file.");
                    return ad.f2634a;
                } catch (Throwable th) {
                    e = th;
                    C0021i.m71a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            C0142c.m468h().mo54e("CrashlyticsCore", "Error deserializing user metadata.", e);
            C0021i.m71a(fileInputStream, "Failed to close user metadata file.");
            return ad.f2634a;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            C0021i.m71a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    public Map<String, String> m5006b(String str) {
        Closeable fileInputStream;
        Throwable e;
        File d = m5002d(str);
        if (!d.exists()) {
            return Collections.emptyMap();
        }
        try {
            fileInputStream = new FileInputStream(d);
            try {
                Map<String, String> f = C1018u.m5004f(C0021i.m60a((InputStream) fileInputStream));
                C0021i.m71a(fileInputStream, "Failed to close user metadata file.");
                return f;
            } catch (Exception e2) {
                e = e2;
                try {
                    C0142c.m468h().mo54e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    C0021i.m71a(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    e = th;
                    C0021i.m71a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C0142c.m468h().mo54e("CrashlyticsCore", "Error deserializing user metadata.", e);
            C0021i.m71a(fileInputStream, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            C0021i.m71a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    private File m5001c(String str) {
        return new File(this.f2759b, str + "user" + ".meta");
    }

    private File m5002d(String str) {
        return new File(this.f2759b, str + "keys" + ".meta");
    }

    private static ad m5003e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new ad(C1018u.m5000a(jSONObject, "userId"), C1018u.m5000a(jSONObject, "userName"), C1018u.m5000a(jSONObject, "userEmail"));
    }

    private static Map<String, String> m5004f(String str) {
        JSONObject jSONObject = new JSONObject(str);
        Map<String, String> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, C1018u.m5000a(jSONObject, str2));
        }
        return hashMap;
    }

    private static String m5000a(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) ? jSONObject.optString(str, null) : null;
    }
}
