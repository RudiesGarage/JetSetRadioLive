package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ae;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* compiled from: ViewUtils */
public class aw {
    private static Method f2265a;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                f2265a = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                if (!f2265a.isAccessible()) {
                    f2265a.setAccessible(true);
                }
            } catch (NoSuchMethodException e) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    public static boolean m4362a(View view) {
        return ae.m2228h(view) == 1;
    }

    public static int m4360a(int i, int i2) {
        return i | i2;
    }

    public static void m4361a(View view, Rect rect, Rect rect2) {
        if (f2265a != null) {
            try {
                f2265a.invoke(view, new Object[]{rect, rect2});
            } catch (Throwable e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }
}
