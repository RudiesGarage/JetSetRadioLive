package android.support.v4.view.p025a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityEventCompat */
public final class C0474a {
    private static final C0469e f1087a;

    /* compiled from: AccessibilityEventCompat */
    interface C0469e {
        int mo314a(AccessibilityEvent accessibilityEvent);

        void mo315a(AccessibilityEvent accessibilityEvent, int i);
    }

    /* compiled from: AccessibilityEventCompat */
    static class C0470d implements C0469e {
        C0470d() {
        }

        public void mo315a(AccessibilityEvent accessibilityEvent, int i) {
        }

        public int mo314a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }
    }

    /* compiled from: AccessibilityEventCompat */
    static class C0471a extends C0470d {
        C0471a() {
        }
    }

    /* compiled from: AccessibilityEventCompat */
    static class C0472b extends C0471a {
        C0472b() {
        }
    }

    /* compiled from: AccessibilityEventCompat */
    static class C0473c extends C0472b {
        C0473c() {
        }

        public void mo315a(AccessibilityEvent accessibilityEvent, int i) {
            C0475b.m1861a(accessibilityEvent, i);
        }

        public int mo314a(AccessibilityEvent accessibilityEvent) {
            return C0475b.m1860a(accessibilityEvent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f1087a = new C0473c();
        } else if (VERSION.SDK_INT >= 16) {
            f1087a = new C0472b();
        } else if (VERSION.SDK_INT >= 14) {
            f1087a = new C0471a();
        } else {
            f1087a = new C0470d();
        }
    }

    public static C0512k m1857a(AccessibilityEvent accessibilityEvent) {
        return new C0512k(accessibilityEvent);
    }

    public static void m1858a(AccessibilityEvent accessibilityEvent, int i) {
        f1087a.mo315a(accessibilityEvent, i);
    }

    public static int m1859b(AccessibilityEvent accessibilityEvent) {
        return f1087a.mo314a(accessibilityEvent);
    }
}
