package android.support.v4.p015c.p016a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DrawableCompatLollipop */
class C0306e {
    public static void m1164a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m1166a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m1165a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void m1167a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m1170a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Drawable m1163a(Drawable drawable) {
        if (drawable instanceof C0157k) {
            return drawable;
        }
        return new C0316j(drawable);
    }

    public static void m1168a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean m1171b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m1172c(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void m1169a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }
}
