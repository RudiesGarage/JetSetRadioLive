package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.p015c.C0317a;
import android.util.TypedValue;

/* compiled from: ThemeUtils */
class an {
    static final int[] f2220a = new int[]{-16842910};
    static final int[] f2221b = new int[]{16842908};
    static final int[] f2222c = new int[]{16843518};
    static final int[] f2223d = new int[]{16842919};
    static final int[] f2224e = new int[]{16842912};
    static final int[] f2225f = new int[]{16842913};
    static final int[] f2226g = new int[]{-16842919, -16842908};
    static final int[] f2227h = new int[0];
    private static final ThreadLocal<TypedValue> f2228i = new ThreadLocal();
    private static final int[] f2229j = new int[1];

    public static int m4282a(Context context, int i) {
        f2229j[0] = i;
        as a = as.m4293a(context, null, f2229j);
        try {
            int b = a.m4300b(0, 0);
            return b;
        } finally {
            a.m4298a();
        }
    }

    public static ColorStateList m4285b(Context context, int i) {
        f2229j[0] = i;
        as a = as.m4293a(context, null, f2229j);
        try {
            ColorStateList d = a.m4305d(0);
            return d;
        } finally {
            a.m4298a();
        }
    }

    public static int m4286c(Context context, int i) {
        ColorStateList b = m4285b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f2220a, b.getDefaultColor());
        }
        TypedValue a = m4284a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m4283a(context, i, a.getFloat());
    }

    private static TypedValue m4284a() {
        TypedValue typedValue = (TypedValue) f2228i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f2228i.set(typedValue);
        return typedValue;
    }

    static int m4283a(Context context, int i, float f) {
        int a = m4282a(context, i);
        return C0317a.m1188b(a, Math.round(((float) Color.alpha(a)) * f));
    }
}
