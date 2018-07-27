package android.support.v4.p018b.p019a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* compiled from: ResourcesCompat */
public final class C0281d {
    public static Drawable m1061a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            return C0282e.m1062a(resources, i, theme);
        }
        return resources.getDrawable(i);
    }
}
