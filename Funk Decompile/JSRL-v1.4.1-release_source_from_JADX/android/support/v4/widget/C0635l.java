package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* compiled from: PopupWindowCompatApi21 */
class C0635l {
    private static Field f1230a;

    static {
        try {
            f1230a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f1230a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void m2677a(PopupWindow popupWindow, boolean z) {
        if (f1230a != null) {
            try {
                f1230a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
