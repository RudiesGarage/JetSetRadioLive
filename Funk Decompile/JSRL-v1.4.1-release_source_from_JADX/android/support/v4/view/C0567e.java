package android.support.v4.view;

import android.os.Build.VERSION;

/* compiled from: GravityCompat */
public final class C0567e {
    static final C0564a f1139a;

    /* compiled from: GravityCompat */
    interface C0564a {
        int mo427a(int i, int i2);
    }

    /* compiled from: GravityCompat */
    static class C0565b implements C0564a {
        C0565b() {
        }

        public int mo427a(int i, int i2) {
            return -8388609 & i;
        }
    }

    /* compiled from: GravityCompat */
    static class C0566c implements C0564a {
        C0566c() {
        }

        public int mo427a(int i, int i2) {
            return C0568f.m2447a(i, i2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f1139a = new C0566c();
        } else {
            f1139a = new C0565b();
        }
    }

    public static int m2446a(int i, int i2) {
        return f1139a.mo427a(i, i2);
    }
}
