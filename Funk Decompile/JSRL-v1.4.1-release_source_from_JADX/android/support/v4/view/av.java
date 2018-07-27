package android.support.v4.view;

import android.os.Build.VERSION;

/* compiled from: WindowInsetsCompat */
public class av {
    private static final C0553d f1132a;
    private final Object f1133b;

    /* compiled from: WindowInsetsCompat */
    private interface C0553d {
        int mo421a(Object obj);

        av mo422a(Object obj, int i, int i2, int i3, int i4);

        int mo423b(Object obj);

        int mo424c(Object obj);

        int mo425d(Object obj);

        boolean mo426e(Object obj);
    }

    /* compiled from: WindowInsetsCompat */
    private static class C0554c implements C0553d {
        C0554c() {
        }

        public int mo423b(Object obj) {
            return 0;
        }

        public int mo425d(Object obj) {
            return 0;
        }

        public int mo424c(Object obj) {
            return 0;
        }

        public int mo421a(Object obj) {
            return 0;
        }

        public boolean mo426e(Object obj) {
            return false;
        }

        public av mo422a(Object obj, int i, int i2, int i3, int i4) {
            return null;
        }
    }

    /* compiled from: WindowInsetsCompat */
    private static class C0555a extends C0554c {
        C0555a() {
        }

        public int mo421a(Object obj) {
            return aw.m2412a(obj);
        }

        public int mo423b(Object obj) {
            return aw.m2414b(obj);
        }

        public int mo424c(Object obj) {
            return aw.m2415c(obj);
        }

        public int mo425d(Object obj) {
            return aw.m2416d(obj);
        }

        public av mo422a(Object obj, int i, int i2, int i3, int i4) {
            return new av(aw.m2413a(obj, i, i2, i3, i4));
        }
    }

    /* compiled from: WindowInsetsCompat */
    private static class C0556b extends C0555a {
        C0556b() {
        }

        public boolean mo426e(Object obj) {
            return ax.m2417a(obj);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1132a = new C0556b();
        } else if (i >= 20) {
            f1132a = new C0555a();
        } else {
            f1132a = new C0554c();
        }
    }

    av(Object obj) {
        this.f1133b = obj;
    }

    public int m2406a() {
        return f1132a.mo423b(this.f1133b);
    }

    public int m2408b() {
        return f1132a.mo425d(this.f1133b);
    }

    public int m2409c() {
        return f1132a.mo424c(this.f1133b);
    }

    public int m2410d() {
        return f1132a.mo421a(this.f1133b);
    }

    public boolean m2411e() {
        return f1132a.mo426e(this.f1133b);
    }

    public av m2407a(int i, int i2, int i3, int i4) {
        return f1132a.mo422a(this.f1133b, i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        av avVar = (av) obj;
        if (this.f1133b != null) {
            return this.f1133b.equals(avVar.f1133b);
        }
        if (avVar.f1133b != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f1133b == null ? 0 : this.f1133b.hashCode();
    }

    static av m2404a(Object obj) {
        return obj == null ? null : new av(obj);
    }

    static Object m2405a(av avVar) {
        return avVar == null ? null : avVar.f1133b;
    }
}
