package android.support.v4.p015c.p016a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DrawableCompatBase */
class C0303b {
    public static void m1153a(Drawable drawable, int i) {
        if (drawable instanceof C0157k) {
            ((C0157k) drawable).setTint(i);
        }
    }

    public static void m1154a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0157k) {
            ((C0157k) drawable).setTintList(colorStateList);
        }
    }

    public static void m1156a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0157k) {
            ((C0157k) drawable).setTintMode(mode);
        }
    }

    public static Drawable m1152a(Drawable drawable) {
        if (drawable instanceof C0157k) {
            return drawable;
        }
        return new C0310g(drawable);
    }

    public static void m1155a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }
}
