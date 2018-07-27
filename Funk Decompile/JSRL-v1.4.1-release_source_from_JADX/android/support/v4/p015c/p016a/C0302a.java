package android.support.v4.p015c.p016a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DrawableCompat */
public final class C0302a {
    static final C0295b f784a;

    /* compiled from: DrawableCompat */
    interface C0295b {
        void mo170a(Drawable drawable);

        void mo171a(Drawable drawable, float f, float f2);

        void mo172a(Drawable drawable, int i);

        void mo173a(Drawable drawable, int i, int i2, int i3, int i4);

        void mo174a(Drawable drawable, ColorStateList colorStateList);

        void mo175a(Drawable drawable, Theme theme);

        void mo176a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);

        void mo177a(Drawable drawable, Mode mode);

        void mo178a(Drawable drawable, boolean z);

        boolean mo179b(Drawable drawable);

        Drawable mo180c(Drawable drawable);

        int mo181d(Drawable drawable);

        boolean mo182e(Drawable drawable);

        ColorFilter mo183f(Drawable drawable);
    }

    /* compiled from: DrawableCompat */
    static class C0296a implements C0295b {
        C0296a() {
        }

        public void mo170a(Drawable drawable) {
        }

        public void mo178a(Drawable drawable, boolean z) {
        }

        public boolean mo179b(Drawable drawable) {
            return false;
        }

        public void mo171a(Drawable drawable, float f, float f2) {
        }

        public void mo173a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void mo172a(Drawable drawable, int i) {
            C0303b.m1153a(drawable, i);
        }

        public void mo174a(Drawable drawable, ColorStateList colorStateList) {
            C0303b.m1154a(drawable, colorStateList);
        }

        public void mo177a(Drawable drawable, Mode mode) {
            C0303b.m1156a(drawable, mode);
        }

        public Drawable mo180c(Drawable drawable) {
            return C0303b.m1152a(drawable);
        }

        public int mo181d(Drawable drawable) {
            return 0;
        }

        public void mo175a(Drawable drawable, Theme theme) {
        }

        public boolean mo182e(Drawable drawable) {
            return false;
        }

        public ColorFilter mo183f(Drawable drawable) {
            return null;
        }

        public void mo176a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0303b.m1155a(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    /* compiled from: DrawableCompat */
    static class C0297c extends C0296a {
        C0297c() {
        }

        public void mo170a(Drawable drawable) {
            C0304c.m1157a(drawable);
        }

        public Drawable mo180c(Drawable drawable) {
            return C0304c.m1158b(drawable);
        }
    }

    /* compiled from: DrawableCompat */
    static class C0298d extends C0297c {
        C0298d() {
        }
    }

    /* compiled from: DrawableCompat */
    static class C0299e extends C0298d {
        C0299e() {
        }

        public void mo178a(Drawable drawable, boolean z) {
            C0305d.m1159a(drawable, z);
        }

        public boolean mo179b(Drawable drawable) {
            return C0305d.m1160a(drawable);
        }

        public Drawable mo180c(Drawable drawable) {
            return C0305d.m1161b(drawable);
        }

        public int mo181d(Drawable drawable) {
            return C0305d.m1162c(drawable);
        }
    }

    /* compiled from: DrawableCompat */
    static class C0300f extends C0299e {
        C0300f() {
        }

        public void mo171a(Drawable drawable, float f, float f2) {
            C0306e.m1164a(drawable, f, f2);
        }

        public void mo173a(Drawable drawable, int i, int i2, int i3, int i4) {
            C0306e.m1166a(drawable, i, i2, i3, i4);
        }

        public void mo172a(Drawable drawable, int i) {
            C0306e.m1165a(drawable, i);
        }

        public void mo174a(Drawable drawable, ColorStateList colorStateList) {
            C0306e.m1167a(drawable, colorStateList);
        }

        public void mo177a(Drawable drawable, Mode mode) {
            C0306e.m1170a(drawable, mode);
        }

        public Drawable mo180c(Drawable drawable) {
            return C0306e.m1163a(drawable);
        }

        public void mo175a(Drawable drawable, Theme theme) {
            C0306e.m1168a(drawable, theme);
        }

        public boolean mo182e(Drawable drawable) {
            return C0306e.m1171b(drawable);
        }

        public ColorFilter mo183f(Drawable drawable) {
            return C0306e.m1172c(drawable);
        }

        public void mo176a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0306e.m1169a(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    /* compiled from: DrawableCompat */
    static class C0301g extends C0300f {
        C0301g() {
        }

        public Drawable mo180c(Drawable drawable) {
            return drawable;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f784a = new C0301g();
        } else if (i >= 21) {
            f784a = new C0300f();
        } else if (i >= 19) {
            f784a = new C0299e();
        } else if (i >= 17) {
            f784a = new C0298d();
        } else if (i >= 11) {
            f784a = new C0297c();
        } else {
            f784a = new C0296a();
        }
    }

    public static void m1137a(Drawable drawable) {
        f784a.mo170a(drawable);
    }

    public static void m1145a(Drawable drawable, boolean z) {
        f784a.mo178a(drawable, z);
    }

    public static boolean m1146b(Drawable drawable) {
        return f784a.mo179b(drawable);
    }

    public static void m1138a(Drawable drawable, float f, float f2) {
        f784a.mo171a(drawable, f, f2);
    }

    public static void m1140a(Drawable drawable, int i, int i2, int i3, int i4) {
        f784a.mo173a(drawable, i, i2, i3, i4);
    }

    public static void m1139a(Drawable drawable, int i) {
        f784a.mo172a(drawable, i);
    }

    public static void m1141a(Drawable drawable, ColorStateList colorStateList) {
        f784a.mo174a(drawable, colorStateList);
    }

    public static void m1144a(Drawable drawable, Mode mode) {
        f784a.mo177a(drawable, mode);
    }

    public static int m1147c(Drawable drawable) {
        return f784a.mo181d(drawable);
    }

    public static void m1142a(Drawable drawable, Theme theme) {
        f784a.mo175a(drawable, theme);
    }

    public static boolean m1148d(Drawable drawable) {
        return f784a.mo182e(drawable);
    }

    public static ColorFilter m1149e(Drawable drawable) {
        return f784a.mo183f(drawable);
    }

    public static void m1143a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f784a.mo176a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable m1150f(Drawable drawable) {
        return f784a.mo180c(drawable);
    }

    public static <T extends Drawable> T m1151g(Drawable drawable) {
        if (drawable instanceof C0307f) {
            return ((C0307f) drawable).mo185a();
        }
        return drawable;
    }
}
