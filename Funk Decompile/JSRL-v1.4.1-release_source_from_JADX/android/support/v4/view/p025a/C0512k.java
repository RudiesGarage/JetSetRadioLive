package android.support.v4.view.p025a;

import android.os.Build.VERSION;

/* compiled from: AccessibilityRecordCompat */
public class C0512k {
    private static final C0507c f1100a;
    private final Object f1101b;

    /* compiled from: AccessibilityRecordCompat */
    interface C0507c {
        void mo349a(Object obj, int i);

        void mo350a(Object obj, boolean z);

        void mo351b(Object obj, int i);

        void mo352c(Object obj, int i);

        void mo353d(Object obj, int i);

        void mo354e(Object obj, int i);

        void mo355f(Object obj, int i);

        void mo356g(Object obj, int i);
    }

    /* compiled from: AccessibilityRecordCompat */
    static class C0508e implements C0507c {
        C0508e() {
        }

        public void mo349a(Object obj, int i) {
        }

        public void mo351b(Object obj, int i) {
        }

        public void mo355f(Object obj, int i) {
        }

        public void mo356g(Object obj, int i) {
        }

        public void mo352c(Object obj, int i) {
        }

        public void mo353d(Object obj, int i) {
        }

        public void mo350a(Object obj, boolean z) {
        }

        public void mo354e(Object obj, int i) {
        }
    }

    /* compiled from: AccessibilityRecordCompat */
    static class C0509a extends C0508e {
        C0509a() {
        }

        public void mo349a(Object obj, int i) {
            C0513l.m2050a(obj, i);
        }

        public void mo351b(Object obj, int i) {
            C0513l.m2052b(obj, i);
        }

        public void mo352c(Object obj, int i) {
            C0513l.m2053c(obj, i);
        }

        public void mo353d(Object obj, int i) {
            C0513l.m2054d(obj, i);
        }

        public void mo350a(Object obj, boolean z) {
            C0513l.m2051a(obj, z);
        }

        public void mo354e(Object obj, int i) {
            C0513l.m2055e(obj, i);
        }
    }

    /* compiled from: AccessibilityRecordCompat */
    static class C0510b extends C0509a {
        C0510b() {
        }

        public void mo355f(Object obj, int i) {
            C0514m.m2056a(obj, i);
        }

        public void mo356g(Object obj, int i) {
            C0514m.m2057b(obj, i);
        }
    }

    /* compiled from: AccessibilityRecordCompat */
    static class C0511d extends C0510b {
        C0511d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1100a = new C0511d();
        } else if (VERSION.SDK_INT >= 15) {
            f1100a = new C0510b();
        } else if (VERSION.SDK_INT >= 14) {
            f1100a = new C0509a();
        } else {
            f1100a = new C0508e();
        }
    }

    @Deprecated
    public C0512k(Object obj) {
        this.f1101b = obj;
    }

    public void m2043a(boolean z) {
        f1100a.mo350a(this.f1101b, z);
    }

    public void m2042a(int i) {
        f1100a.mo351b(this.f1101b, i);
    }

    public void m2044b(int i) {
        f1100a.mo349a(this.f1101b, i);
    }

    public void m2045c(int i) {
        f1100a.mo354e(this.f1101b, i);
    }

    public void m2046d(int i) {
        f1100a.mo352c(this.f1101b, i);
    }

    public void m2047e(int i) {
        f1100a.mo353d(this.f1101b, i);
    }

    public void m2048f(int i) {
        f1100a.mo355f(this.f1101b, i);
    }

    public void m2049g(int i) {
        f1100a.mo356g(this.f1101b, i);
    }

    public int hashCode() {
        return this.f1101b == null ? 0 : this.f1101b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0512k c0512k = (C0512k) obj;
        if (this.f1101b == null) {
            if (c0512k.f1101b != null) {
                return false;
            }
            return true;
        } else if (this.f1101b.equals(c0512k.f1101b)) {
            return true;
        } else {
            return false;
        }
    }
}
