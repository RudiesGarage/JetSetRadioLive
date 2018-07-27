package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* compiled from: KeyEventCompat */
public final class C0572g {
    static final C0569c f1140a;

    /* compiled from: KeyEventCompat */
    interface C0569c {
        boolean mo428a(int i, int i2);

        boolean mo429b(int i);
    }

    /* compiled from: KeyEventCompat */
    static class C0570a implements C0569c {
        C0570a() {
        }

        private static int m2450a(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 != null) {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            } else if (obj != null) {
                return i & (i3 ^ -1);
            } else {
                return i;
            }
        }

        public int mo430a(int i) {
            int i2;
            if ((i & 192) != 0) {
                i2 = i | 1;
            } else {
                i2 = i;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public boolean mo428a(int i, int i2) {
            if (C0570a.m2450a(C0570a.m2450a(mo430a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        public boolean mo429b(int i) {
            return (mo430a(i) & 247) == 0;
        }
    }

    /* compiled from: KeyEventCompat */
    static class C0571b extends C0570a {
        C0571b() {
        }

        public int mo430a(int i) {
            return C0573h.m2459a(i);
        }

        public boolean mo428a(int i, int i2) {
            return C0573h.m2460a(i, i2);
        }

        public boolean mo429b(int i) {
            return C0573h.m2461b(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f1140a = new C0571b();
        } else {
            f1140a = new C0570a();
        }
    }

    public static boolean m2458a(KeyEvent keyEvent, int i) {
        return f1140a.mo428a(keyEvent.getMetaState(), i);
    }

    public static boolean m2457a(KeyEvent keyEvent) {
        return f1140a.mo429b(keyEvent.getMetaState());
    }
}
