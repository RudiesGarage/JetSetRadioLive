package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewCompatBase */
class af {
    private static Field f1109a;
    private static boolean f1110b;
    private static Field f1111c;
    private static boolean f1112d;

    static ColorStateList m2245a(View view) {
        return view instanceof ab ? ((ab) view).getSupportBackgroundTintList() : null;
    }

    static void m2246a(View view, ColorStateList colorStateList) {
        if (view instanceof ab) {
            ((ab) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static Mode m2248b(View view) {
        return view instanceof ab ? ((ab) view).getSupportBackgroundTintMode() : null;
    }

    static void m2247a(View view, Mode mode) {
        if (view instanceof ab) {
            ((ab) view).setSupportBackgroundTintMode(mode);
        }
    }

    static boolean m2249c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m2250d(View view) {
        if (!f1110b) {
            try {
                f1109a = View.class.getDeclaredField("mMinWidth");
                f1109a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f1110b = true;
        }
        if (f1109a != null) {
            try {
                return ((Integer) f1109a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int m2251e(View view) {
        if (!f1112d) {
            try {
                f1111c = View.class.getDeclaredField("mMinHeight");
                f1111c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f1112d = true;
        }
        if (f1111c != null) {
            try {
                return ((Integer) f1111c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m2252f(View view) {
        return view.getWindowToken() != null;
    }
}
