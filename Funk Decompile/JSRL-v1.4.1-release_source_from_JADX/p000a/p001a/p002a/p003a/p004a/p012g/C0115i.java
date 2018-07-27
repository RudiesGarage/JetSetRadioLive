package p000a.p001a.p002a.p003a.p004a.p012g;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p011f.C0104b;

/* compiled from: DefaultCachedSettingsIo */
class C0115i implements C0113g {
    private final C0149i f247a;

    public C0115i(C0149i c0149i) {
        this.f247a = c0149i;
    }

    public JSONObject mo39a() {
        Throwable e;
        Closeable closeable = null;
        C0142c.m468h().mo46a("Fabric", "Reading cached settings...");
        Closeable fileInputStream;
        try {
            JSONObject jSONObject;
            File file = new File(new C0104b(this.f247a).mo34a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(C0021i.m60a((InputStream) fileInputStream));
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0142c.m468h().mo54e("Fabric", "Failed to fetch cached settings", e);
                        C0021i.m71a(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileInputStream;
                        C0021i.m71a(closeable, "Error while closing settings cache file.");
                        throw e;
                    }
                }
            }
            C0142c.m468h().mo46a("Fabric", "No cached settings found.");
            jSONObject = null;
            C0021i.m71a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C0142c.m468h().mo54e("Fabric", "Failed to fetch cached settings", e);
            C0021i.m71a(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            C0021i.m71a(closeable, "Error while closing settings cache file.");
            throw e;
        }
    }

    public void mo40a(long j, JSONObject jSONObject) {
        Closeable fileWriter;
        Throwable e;
        C0142c.m468h().mo46a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            Closeable closeable = null;
            try {
                jSONObject.put("expires_at", j);
                fileWriter = new FileWriter(new File(new C0104b(this.f247a).mo34a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    C0021i.m71a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0142c.m468h().mo54e("Fabric", "Failed to cache settings", e);
                        C0021i.m71a(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileWriter;
                        C0021i.m71a(closeable, "Failed to close settings writer.");
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
                C0142c.m468h().mo54e("Fabric", "Failed to cache settings", e);
                C0021i.m71a(fileWriter, "Failed to close settings writer.");
            } catch (Throwable th2) {
                e = th2;
                C0021i.m71a(closeable, "Failed to close settings writer.");
                throw e;
            }
        }
    }
}
