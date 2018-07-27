package android.support.v4.p023f;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat */
public final class C0349f {
    public static final C0342e f827a = new C0347e(null, false);
    public static final C0342e f828b = new C0347e(null, true);
    public static final C0342e f829c = new C0347e(C0345b.f823a, false);
    public static final C0342e f830d = new C0347e(C0345b.f823a, true);
    public static final C0342e f831e = new C0347e(C0344a.f820a, false);
    public static final C0342e f832f = C0348f.f826a;

    /* compiled from: TextDirectionHeuristicsCompat */
    private interface C0343c {
        int mo190a(CharSequence charSequence, int i, int i2);
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0344a implements C0343c {
        public static final C0344a f820a = new C0344a(true);
        public static final C0344a f821b = new C0344a(false);
        private final boolean f822c;

        public int mo190a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 0;
            while (i < i3) {
                switch (C0349f.m1247a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (!this.f822c) {
                            i4 = 1;
                            break;
                        }
                        return 0;
                    case 1:
                        if (this.f822c) {
                            i4 = 1;
                            break;
                        }
                        return 1;
                    default:
                        break;
                }
                i++;
            }
            if (i4 == 0) {
                return 2;
            }
            if (this.f822c) {
                return 1;
            }
            return 0;
        }

        private C0344a(boolean z) {
            this.f822c = z;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0345b implements C0343c {
        public static final C0345b f823a = new C0345b();

        public int mo190a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = C0349f.m1248b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private C0345b() {
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static abstract class C0346d implements C0342e {
        private final C0343c f824a;

        protected abstract boolean mo192a();

        public C0346d(C0343c c0343c) {
            this.f824a = c0343c;
        }

        public boolean mo191a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f824a == null) {
                return mo192a();
            } else {
                return m1242b(charSequence, i, i2);
            }
        }

        private boolean m1242b(CharSequence charSequence, int i, int i2) {
            switch (this.f824a.mo190a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return mo192a();
            }
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0347e extends C0346d {
        private final boolean f825a;

        C0347e(C0343c c0343c, boolean z) {
            super(c0343c);
            this.f825a = z;
        }

        protected boolean mo192a() {
            return this.f825a;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0348f extends C0346d {
        public static final C0348f f826a = new C0348f();

        public C0348f() {
            super(null);
        }

        protected boolean mo192a() {
            if (C0352g.m1252a(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static int m1247a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    static int m1248b(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }
}
