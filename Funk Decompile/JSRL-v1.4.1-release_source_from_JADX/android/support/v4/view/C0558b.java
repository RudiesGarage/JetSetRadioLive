package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: AccessibilityDelegateCompatIcs */
class C0558b {

    /* compiled from: AccessibilityDelegateCompatIcs */
    public interface C0461a {
        void mo287a(View view, int i);

        void mo288a(View view, Object obj);

        boolean mo289a(View view, AccessibilityEvent accessibilityEvent);

        boolean mo290a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo291b(View view, AccessibilityEvent accessibilityEvent);

        void mo292c(View view, AccessibilityEvent accessibilityEvent);

        void mo293d(View view, AccessibilityEvent accessibilityEvent);
    }

    public static Object m2418a() {
        return new AccessibilityDelegate();
    }

    public static Object m2419a(final C0461a c0461a) {
        return new AccessibilityDelegate() {
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return c0461a.mo289a(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c0461a.mo291b(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                c0461a.mo288a(view, (Object) accessibilityNodeInfo);
            }

            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c0461a.mo292c(view, accessibilityEvent);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return c0461a.mo290a(viewGroup, view, accessibilityEvent);
            }

            public void sendAccessibilityEvent(View view, int i) {
                c0461a.mo287a(view, i);
            }

            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                c0461a.mo293d(view, accessibilityEvent);
            }
        };
    }

    public static boolean m2422a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        return ((AccessibilityDelegate) obj).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static void m2424b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void m2421a(Object obj, View view, Object obj2) {
        ((AccessibilityDelegate) obj).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo) obj2);
    }

    public static void m2425c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean m2423a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return ((AccessibilityDelegate) obj).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static void m2420a(Object obj, View view, int i) {
        ((AccessibilityDelegate) obj).sendAccessibilityEvent(view, i);
    }

    public static void m2426d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
