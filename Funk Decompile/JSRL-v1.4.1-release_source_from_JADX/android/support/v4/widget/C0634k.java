package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.view.C0567e;
import android.support.v4.view.ae;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* compiled from: PopupWindowCompat */
public final class C0634k {
    static final C0629e f1229a;

    /* compiled from: PopupWindowCompat */
    interface C0629e {
        void mo469a(PopupWindow popupWindow, int i);

        void mo470a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void mo471a(PopupWindow popupWindow, boolean z);
    }

    /* compiled from: PopupWindowCompat */
    static class C0630c implements C0629e {
        private static Method f1227a;
        private static boolean f1228b;

        C0630c() {
        }

        public void mo470a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((C0567e.m2446a(i3, ae.m2228h(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void mo471a(PopupWindow popupWindow, boolean z) {
        }

        public void mo469a(PopupWindow popupWindow, int i) {
            if (!f1228b) {
                try {
                    f1227a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                    f1227a.setAccessible(true);
                } catch (Exception e) {
                }
                f1228b = true;
            }
            if (f1227a != null) {
                try {
                    f1227a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                }
            }
        }
    }

    /* compiled from: PopupWindowCompat */
    static class C0631d extends C0630c {
        C0631d() {
        }

        public void mo470a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            C0637n.m2680a(popupWindow, view, i, i2, i3);
        }
    }

    /* compiled from: PopupWindowCompat */
    static class C0632a extends C0631d {
        C0632a() {
        }

        public void mo471a(PopupWindow popupWindow, boolean z) {
            C0635l.m2677a(popupWindow, z);
        }
    }

    /* compiled from: PopupWindowCompat */
    static class C0633b extends C0632a {
        C0633b() {
        }

        public void mo471a(PopupWindow popupWindow, boolean z) {
            C0636m.m2679a(popupWindow, z);
        }

        public void mo469a(PopupWindow popupWindow, int i) {
            C0636m.m2678a(popupWindow, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1229a = new C0633b();
        } else if (i >= 21) {
            f1229a = new C0632a();
        } else if (i >= 19) {
            f1229a = new C0631d();
        } else {
            f1229a = new C0630c();
        }
    }

    public static void m2675a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1229a.mo470a(popupWindow, view, i, i2, i3);
    }

    public static void m2676a(PopupWindow popupWindow, boolean z) {
        f1229a.mo471a(popupWindow, z);
    }

    public static void m2674a(PopupWindow popupWindow, int i) {
        f1229a.mo469a(popupWindow, i);
    }
}
