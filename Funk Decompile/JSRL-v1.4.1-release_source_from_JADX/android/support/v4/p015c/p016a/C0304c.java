package android.support.v4.p015c.p016a;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatHoneycomb */
class C0304c {
    public static void m1157a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable m1158b(Drawable drawable) {
        if (drawable instanceof C0157k) {
            return drawable;
        }
        return new C0312h(drawable);
    }
}
