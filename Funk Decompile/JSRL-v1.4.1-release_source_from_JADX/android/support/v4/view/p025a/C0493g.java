package android.support.v4.view.p025a;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

/* compiled from: AccessibilityNodeInfoCompatKitKat */
class C0493g {
    public static void m1991a(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionInfo((CollectionInfo) obj2);
    }

    public static void m1992b(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionItemInfo((CollectionItemInfo) obj2);
    }

    public static Object m1990a(int i, int i2, boolean z, int i3) {
        return CollectionInfo.obtain(i, i2, z);
    }

    public static Object m1989a(int i, int i2, int i3, int i4, boolean z) {
        return CollectionItemInfo.obtain(i, i2, i3, i4, z);
    }
}
