package android.support.v4.view.p025a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatKitKat */
class C0506j {

    /* compiled from: AccessibilityNodeProviderCompatKitKat */
    interface C0499a {
        Object mo345a(int i);

        List<Object> mo346a(String str, int i);

        boolean mo347a(int i, int i2, Bundle bundle);

        Object mo348b(int i);
    }

    public static Object m2017a(final C0499a c0499a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c0499a.mo345a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c0499a.mo346a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c0499a.mo347a(i, i2, bundle);
            }

            public AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) c0499a.mo348b(i);
            }
        };
    }
}
