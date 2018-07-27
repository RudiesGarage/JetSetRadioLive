package android.support.v4.p018b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p022e.C0323c;
import android.util.TypedValue;

/* compiled from: ContextCompat */
public class C0185a {
    private static final Object f484a = new Object();
    private static TypedValue f485b;

    public static final Drawable m612a(Context context, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 21) {
            return C0284b.m1069a(context, i);
        }
        if (i2 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f484a) {
            if (f485b == null) {
                f485b = new TypedValue();
            }
            context.getResources().getValue(i, f485b, true);
            i2 = f485b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static final ColorStateList m614b(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return C0285c.m1070a(context, i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static boolean m613a(Context context) {
        if (C0323c.m1195a()) {
            return C0286d.m1071a(context);
        }
        return false;
    }
}
