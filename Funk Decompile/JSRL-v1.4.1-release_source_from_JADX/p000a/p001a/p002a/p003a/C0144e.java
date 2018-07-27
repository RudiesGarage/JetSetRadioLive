package p000a.p001a.p002a.p003a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;

/* compiled from: FabricKitsFinder */
class C0144e implements Callable<Map<String, C0151k>> {
    final String f340a;

    public /* synthetic */ Object call() {
        return m483a();
    }

    C0144e(String str) {
        this.f340a = str;
    }

    public Map<String, C0151k> m483a() {
        Map<String, C0151k> hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ZipFile b = m484b();
        Enumeration entries = b.entries();
        int i = 0;
        while (entries.hasMoreElements()) {
            int i2 = i + 1;
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/") && zipEntry.getName().length() > "fabric/".length()) {
                C0151k a = m482a(zipEntry, b);
                if (a != null) {
                    hashMap.put(a.m510a(), a);
                    C0142c.m468h().mo49b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a.m510a(), a.m511b()}));
                }
            }
            i = i2;
        }
        if (b != null) {
            try {
                b.close();
            } catch (IOException e) {
            }
        }
        C0142c.m468h().mo49b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " reading:" + i);
        return hashMap;
    }

    private C0151k m482a(ZipEntry zipEntry, ZipFile zipFile) {
        Throwable e;
        Closeable inputStream;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                Object property = properties.getProperty("fabric-identifier");
                Object property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
                C0151k c0151k = new C0151k(property, property2, property3);
                C0021i.m70a(inputStream);
                return c0151k;
            } catch (IOException e2) {
                e = e2;
                try {
                    C0142c.m468h().mo54e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    C0021i.m70a(inputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    C0021i.m70a(inputStream);
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            C0142c.m468h().mo54e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
            C0021i.m70a(inputStream);
            return null;
        } catch (Throwable th2) {
            e = th2;
            inputStream = null;
            C0021i.m70a(inputStream);
            throw e;
        }
    }

    protected ZipFile m484b() {
        return new ZipFile(this.f340a);
    }
}
