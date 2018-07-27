package android.support.v7.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: PreferenceManager */
public class C0690a {
    private Context f1306a;
    private SharedPreferences f1307b;
    private Editor f1308c;
    private boolean f1309d;
    private String f1310e;
    private int f1311f;
    private C0689c f1312g;
    private C0687a f1313h;
    private C0688b f1314i;

    /* compiled from: PreferenceManager */
    public interface C0687a {
        void m2841a(Preference preference);
    }

    /* compiled from: PreferenceManager */
    public interface C0688b {
        void m2842a(PreferenceScreen preferenceScreen);
    }

    /* compiled from: PreferenceManager */
    public interface C0689c {
        boolean m2843a(Preference preference);
    }

    public SharedPreferences m2844a() {
        if (this.f1307b == null) {
            this.f1307b = this.f1306a.getSharedPreferences(this.f1310e, this.f1311f);
        }
        return this.f1307b;
    }

    Editor m2846b() {
        if (!this.f1309d) {
            return m2844a().edit();
        }
        if (this.f1308c == null) {
            this.f1308c = m2844a().edit();
        }
        return this.f1308c;
    }

    boolean m2847c() {
        return !this.f1309d;
    }

    public void m2845a(Preference preference) {
        if (this.f1313h != null) {
            this.f1313h.m2841a(preference);
        }
    }

    public C0689c m2848d() {
        return this.f1312g;
    }

    public C0688b m2849e() {
        return this.f1314i;
    }
}
