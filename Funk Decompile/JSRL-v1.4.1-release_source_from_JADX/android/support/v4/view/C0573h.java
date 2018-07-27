package android.support.v4.view;

import android.view.KeyEvent;

/* compiled from: KeyEventCompatHoneycomb */
class C0573h {
    public static int m2459a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m2460a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m2461b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
