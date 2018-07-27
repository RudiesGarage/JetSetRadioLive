package android.support.v4.p023f;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompatIcs */
class C0341d {
    private static Method f818a;
    private static Method f819b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f818a = cls.getMethod("getScript", new Class[]{String.class});
                f819b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f818a = null;
            f819b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String m1236a(Locale locale) {
        String b = C0341d.m1237b(locale);
        if (b != null) {
            return C0341d.m1235a(b);
        }
        return null;
    }

    private static String m1235a(String str) {
        try {
            if (f818a != null) {
                return (String) f818a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    private static String m1237b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f819b != null) {
                return (String) f819b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
