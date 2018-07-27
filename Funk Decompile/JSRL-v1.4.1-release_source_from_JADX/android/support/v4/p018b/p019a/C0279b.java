package android.support.v4.p018b.p019a;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/* compiled from: ConfigurationHelperGingerbread */
class C0279b {
    static int m1055a(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    static int m1056b(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    static int m1057c(Resources resources) {
        return Math.min(C0279b.m1056b(resources), C0279b.m1055a(resources));
    }
}
