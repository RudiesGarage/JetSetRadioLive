package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewParentCompat */
public final class ao {
    static final C0537b f1115a;

    /* compiled from: ViewParentCompat */
    interface C0537b {
        void mo404a(ViewParent viewParent, View view);

        void mo405a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void mo406a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean mo407a(ViewParent viewParent, View view, float f, float f2);

        boolean mo408a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean mo409a(ViewParent viewParent, View view, View view2, int i);

        void mo410b(ViewParent viewParent, View view, View view2, int i);
    }

    /* compiled from: ViewParentCompat */
    static class C0538e implements C0537b {
        C0538e() {
        }

        public boolean mo409a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0605w) {
                return ((C0605w) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void mo410b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0605w) {
                ((C0605w) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void mo404a(ViewParent viewParent, View view) {
            if (viewParent instanceof C0605w) {
                ((C0605w) viewParent).onStopNestedScroll(view);
            }
        }

        public void mo405a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof C0605w) {
                ((C0605w) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void mo406a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof C0605w) {
                ((C0605w) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean mo408a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof C0605w) {
                return ((C0605w) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean mo407a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof C0605w) {
                return ((C0605w) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    /* compiled from: ViewParentCompat */
    static class C0539a extends C0538e {
        C0539a() {
        }
    }

    /* compiled from: ViewParentCompat */
    static class C0540c extends C0539a {
        C0540c() {
        }
    }

    /* compiled from: ViewParentCompat */
    static class C0541d extends C0540c {
        C0541d() {
        }

        public boolean mo409a(ViewParent viewParent, View view, View view2, int i) {
            return ap.m2335a(viewParent, view, view2, i);
        }

        public void mo410b(ViewParent viewParent, View view, View view2, int i) {
            ap.m2336b(viewParent, view, view2, i);
        }

        public void mo404a(ViewParent viewParent, View view) {
            ap.m2330a(viewParent, view);
        }

        public void mo405a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            ap.m2331a(viewParent, view, i, i2, i3, i4);
        }

        public void mo406a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            ap.m2332a(viewParent, view, i, i2, iArr);
        }

        public boolean mo408a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return ap.m2334a(viewParent, view, f, f2, z);
        }

        public boolean mo407a(ViewParent viewParent, View view, float f, float f2) {
            return ap.m2333a(viewParent, view, f, f2);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1115a = new C0541d();
        } else if (i >= 19) {
            f1115a = new C0540c();
        } else if (i >= 14) {
            f1115a = new C0539a();
        } else {
            f1115a = new C0538e();
        }
    }

    public static boolean m2328a(ViewParent viewParent, View view, View view2, int i) {
        return f1115a.mo409a(viewParent, view, view2, i);
    }

    public static void m2329b(ViewParent viewParent, View view, View view2, int i) {
        f1115a.mo410b(viewParent, view, view2, i);
    }

    public static void m2323a(ViewParent viewParent, View view) {
        f1115a.mo404a(viewParent, view);
    }

    public static void m2324a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f1115a.mo405a(viewParent, view, i, i2, i3, i4);
    }

    public static void m2325a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f1115a.mo406a(viewParent, view, i, i2, iArr);
    }

    public static boolean m2327a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f1115a.mo408a(viewParent, view, f, f2, z);
    }

    public static boolean m2326a(ViewParent viewParent, View view, float f, float f2) {
        return f1115a.mo407a(viewParent, view, f, f2);
    }
}
