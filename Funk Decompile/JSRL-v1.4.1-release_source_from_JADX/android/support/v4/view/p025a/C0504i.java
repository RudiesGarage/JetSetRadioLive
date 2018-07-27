package android.support.v4.view.p025a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatJellyBean */
class C0504i {

    /* compiled from: AccessibilityNodeProviderCompatJellyBean */
    interface C0495a {
        Object mo341a(int i);

        List<Object> mo342a(String str, int i);

        boolean mo343a(int i, int i2, Bundle bundle);
    }

    public static Object m2016a(final C0495a c0495a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c0495a.mo341a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c0495a.mo342a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c0495a.mo343a(i, i2, bundle);
            }
        };
    }
}
