package android.support.v4.view;

import android.view.WindowInsets;

/* compiled from: WindowInsetsCompatApi20 */
class aw {
    public static int m2412a(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetBottom();
    }

    public static int m2414b(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetLeft();
    }

    public static int m2415c(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetRight();
    }

    public static int m2416d(Object obj) {
        return ((WindowInsets) obj).getSystemWindowInsetTop();
    }

    public static Object m2413a(Object obj, int i, int i2, int i3, int i4) {
        return ((WindowInsets) obj).replaceSystemWindowInsets(i, i2, i3, i4);
    }
}
