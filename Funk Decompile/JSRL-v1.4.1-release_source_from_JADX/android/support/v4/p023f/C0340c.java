package android.support.v4.p023f;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompatApi23 */
class C0340c {
    private static Method f817a;

    static {
        try {
            f817a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String m1234a(Locale locale) {
        try {
            return ((Locale) f817a.invoke(null, new Object[]{locale})).getScript();
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
