package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;

/* compiled from: IdManager */
public class C0033o {
    private static final Pattern f64d = Pattern.compile("[^\\p{Alnum}]");
    private static final String f65e = Pattern.quote("/");
    C0011c f66a;
    C0008b f67b;
    boolean f68c;
    private final ReentrantLock f69f = new ReentrantLock();
    private final C0035p f70g;
    private final boolean f71h;
    private final boolean f72i;
    private final Context f73j;
    private final String f74k;
    private final String f75l;
    private final Collection<C0149i> f76m;

    /* compiled from: IdManager */
    public enum C0032a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        
        public final int f63h;

        private C0032a(int i) {
            this.f63h = i;
        }
    }

    public C0033o(Context context, String str, String str2, Collection<C0149i> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        } else {
            this.f73j = context;
            this.f74k = str;
            this.f75l = str2;
            this.f76m = collection;
            this.f70g = new C0035p();
            this.f66a = new C0011c(context);
            this.f71h = C0021i.m74a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.f71h) {
                C0142c.m468h().mo46a("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.f72i = C0021i.m74a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.f72i) {
                C0142c.m468h().mo46a("Fabric", "User information collection disabled for " + context.getPackageName());
            }
        }
    }

    public boolean m112a() {
        return this.f72i;
    }

    private String m109a(String str) {
        return str == null ? null : f64d.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String m113b() {
        String str = this.f75l;
        if (str != null) {
            return str;
        }
        SharedPreferences a = C0021i.m57a(this.f73j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m108a(a);
        }
        return str;
    }

    public String m114c() {
        return this.f74k;
    }

    public String m115d() {
        return m116e() + "/" + m117f();
    }

    public String m116e() {
        return m111b(VERSION.RELEASE);
    }

    public String m117f() {
        return m111b(VERSION.INCREMENTAL);
    }

    public String m118g() {
        return String.format(Locale.US, "%s/%s", new Object[]{m111b(Build.MANUFACTURER), m111b(Build.MODEL)});
    }

    private String m111b(String str) {
        return str.replaceAll(f65e, "");
    }

    public String m119h() {
        String str = "";
        if (!this.f71h) {
            return str;
        }
        str = m125n();
        if (str != null) {
            return str;
        }
        SharedPreferences a = C0021i.m57a(this.f73j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m108a(a);
        }
        return str;
    }

    private String m108a(SharedPreferences sharedPreferences) {
        this.f69f.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m109a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.f69f.unlock();
            return string;
        } catch (Throwable th) {
            this.f69f.unlock();
        }
    }

    public Map<C0032a, String> m120i() {
        Map hashMap = new HashMap();
        for (C0149i c0149i : this.f76m) {
            if (c0149i instanceof C0027m) {
                for (Entry entry : ((C0027m) c0149i).mo728e().entrySet()) {
                    m110a(hashMap, (C0032a) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        m110a(hashMap, C0032a.ANDROID_ID, m125n());
        m110a(hashMap, C0032a.ANDROID_ADVERTISING_ID, m124m());
        return Collections.unmodifiableMap(hashMap);
    }

    public String m121j() {
        return this.f70g.m128a(this.f73j);
    }

    synchronized C0008b m122k() {
        if (!this.f68c) {
            this.f67b = this.f66a.m31a();
            this.f68c = true;
        }
        return this.f67b;
    }

    public Boolean m123l() {
        if (!this.f71h) {
            return null;
        }
        C0008b k = m122k();
        if (k != null) {
            return Boolean.valueOf(k.f13b);
        }
        return null;
    }

    public String m124m() {
        if (!this.f71h) {
            return null;
        }
        C0008b k = m122k();
        if (k != null) {
            return k.f12a;
        }
        return null;
    }

    private void m110a(Map<C0032a, String> map, C0032a c0032a, String str) {
        if (str != null) {
            map.put(c0032a, str);
        }
    }

    public String m125n() {
        if (!this.f71h) {
            return null;
        }
        String string = Secure.getString(this.f73j.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string)) {
            return null;
        }
        return m109a(string);
    }
}
