package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: AccessibilityDelegateCompatJellyBean */
class C0560c {

    /* compiled from: AccessibilityDelegateCompatJellyBean */
    public interface C0466a {
        Object mo305a(View view);

        void mo306a(View view, int i);

        void mo307a(View view, Object obj);

        boolean mo308a(View view, int i, Bundle bundle);

        boolean mo309a(View view, AccessibilityEvent accessibilityEvent);

        boolean mo310a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo311b(View view, AccessibilityEvent accessibilityEvent);

        void mo312c(View view, AccessibilityEvent accessibilityEvent);

        void mo313d(View view, AccessibilityEvent accessibilityEvent);
    }

    public static Object m2427a(final C0466a c0466a) {
        return new AccessibilityDelegate() {
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return c0466a.mo309a(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c0466a.mo311b(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                c0466a.mo307a(view, (Object) accessibilityNodeInfo);
            }

            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c0466a.mo312c(view, accessibilityEvent);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return c0466a.mo310a(viewGroup, view, accessibilityEvent);
            }

            public void sendAccessibilityEvent(View view, int i) {
                c0466a.mo306a(view, i);
            }

            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                c0466a.mo313d(view, accessibilityEvent);
            }

            public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                return (AccessibilityNodeProvider) c0466a.mo305a(view);
            }

            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                return c0466a.mo308a(view, i, bundle);
            }
        };
    }

    public static Object m2428a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m2429a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
