package android.support.v4.p015c;

import android.graphics.Color;

/* compiled from: ColorUtils */
public final class C0317a {
    private static final ThreadLocal<double[]> f796a = new ThreadLocal();

    public static int m1186a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int c = C0317a.m1189c(alpha2, alpha);
        return Color.argb(c, C0317a.m1187a(Color.red(i), alpha2, Color.red(i2), alpha, c), C0317a.m1187a(Color.green(i), alpha2, Color.green(i2), alpha, c), C0317a.m1187a(Color.blue(i), alpha2, Color.blue(i2), alpha, c));
    }

    private static int m1189c(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    private static int m1187a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int m1188b(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
