package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

/* compiled from: LayoutInflaterCompat */
public final class C0578i {
    static final C0574a f1141a;

    /* compiled from: LayoutInflaterCompat */
    interface C0574a {
        void mo431a(LayoutInflater layoutInflater, C0233m c0233m);
    }

    /* compiled from: LayoutInflaterCompat */
    static class C0575b implements C0574a {
        C0575b() {
        }

        public void mo431a(LayoutInflater layoutInflater, C0233m c0233m) {
            C0580j.m2467a(layoutInflater, c0233m);
        }
    }

    /* compiled from: LayoutInflaterCompat */
    static class C0576c extends C0575b {
        C0576c() {
        }

        public void mo431a(LayoutInflater layoutInflater, C0233m c0233m) {
            C0582k.m2468a(layoutInflater, c0233m);
        }
    }

    /* compiled from: LayoutInflaterCompat */
    static class C0577d extends C0576c {
        C0577d() {
        }

        public void mo431a(LayoutInflater layoutInflater, C0233m c0233m) {
            C0583l.m2470a(layoutInflater, c0233m);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1141a = new C0577d();
        } else if (i >= 11) {
            f1141a = new C0576c();
        } else {
            f1141a = new C0575b();
        }
    }

    public static void m2466a(LayoutInflater layoutInflater, C0233m c0233m) {
        f1141a.mo431a(layoutInflater, c0233m);
    }
}
