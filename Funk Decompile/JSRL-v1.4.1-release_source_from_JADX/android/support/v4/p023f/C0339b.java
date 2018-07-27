package android.support.v4.p023f;

import android.os.Build.VERSION;
import java.util.Locale;

/* compiled from: ICUCompat */
public final class C0339b {
    private static final C0335a f816a;

    /* compiled from: ICUCompat */
    interface C0335a {
        String mo189a(Locale locale);
    }

    /* compiled from: ICUCompat */
    static class C0336b implements C0335a {
        C0336b() {
        }

        public String mo189a(Locale locale) {
            return null;
        }
    }

    /* compiled from: ICUCompat */
    static class C0337c implements C0335a {
        C0337c() {
        }

        public String mo189a(Locale locale) {
            return C0341d.m1236a(locale);
        }
    }

    /* compiled from: ICUCompat */
    static class C0338d implements C0335a {
        C0338d() {
        }

        public String mo189a(Locale locale) {
            return C0340c.m1234a(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f816a = new C0338d();
        } else if (i >= 14) {
            f816a = new C0337c();
        } else {
            f816a = new C0336b();
        }
    }

    public static String m1233a(Locale locale) {
        return f816a.mo189a(locale);
    }
}
