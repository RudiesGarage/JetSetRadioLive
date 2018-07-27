package android.support.v4.view.p025a;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: AccessibilityNodeInfoCompatIcs */
class C0491e {
    public static void m1969a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public static int m1968a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public static void m1970a(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void m1974b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static CharSequence m1973b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public static CharSequence m1975c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static CharSequence m1976d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public static CharSequence m1977e(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public static boolean m1978f(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean m1979g(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean m1980h(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean m1981i(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean m1982j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean m1983k(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean m1984l(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean m1985m(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean m1986n(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean m1987o(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public static void m1971a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void m1972a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }
}
