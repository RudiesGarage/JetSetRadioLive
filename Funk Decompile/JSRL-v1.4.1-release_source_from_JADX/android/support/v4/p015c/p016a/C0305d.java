package android.support.v4.p015c.p016a;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatKitKat */
class C0305d {
    public static void m1159a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m1160a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m1161b(Drawable drawable) {
        if (drawable instanceof C0157k) {
            return drawable;
        }
        return new C0314i(drawable);
    }

    public static int m1162c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
