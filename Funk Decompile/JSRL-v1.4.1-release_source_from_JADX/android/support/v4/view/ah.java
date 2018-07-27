package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

/* compiled from: ViewCompatICS */
class ah {
    public static boolean m2269a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m2270b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void m2268a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }
}
