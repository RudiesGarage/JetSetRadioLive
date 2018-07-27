package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* compiled from: EdgeEffectCompat */
public final class C0622d {
    private static final C0618c f1224b;
    private Object f1225a;

    /* compiled from: EdgeEffectCompat */
    interface C0618c {
        Object mo457a(Context context);

        void mo458a(Object obj, int i, int i2);

        boolean mo459a(Object obj);

        boolean mo460a(Object obj, float f);

        boolean mo461a(Object obj, float f, float f2);

        boolean mo462a(Object obj, int i);

        boolean mo463a(Object obj, Canvas canvas);

        void mo464b(Object obj);

        boolean mo465c(Object obj);
    }

    /* compiled from: EdgeEffectCompat */
    static class C0619a implements C0618c {
        C0619a() {
        }

        public Object mo457a(Context context) {
            return null;
        }

        public void mo458a(Object obj, int i, int i2) {
        }

        public boolean mo459a(Object obj) {
            return true;
        }

        public void mo464b(Object obj) {
        }

        public boolean mo460a(Object obj, float f) {
            return false;
        }

        public boolean mo465c(Object obj) {
            return false;
        }

        public boolean mo462a(Object obj, int i) {
            return false;
        }

        public boolean mo463a(Object obj, Canvas canvas) {
            return false;
        }

        public boolean mo461a(Object obj, float f, float f2) {
            return false;
        }
    }

    /* compiled from: EdgeEffectCompat */
    static class C0620b implements C0618c {
        C0620b() {
        }

        public Object mo457a(Context context) {
            return C0623e.m2649a(context);
        }

        public void mo458a(Object obj, int i, int i2) {
            C0623e.m2650a(obj, i, i2);
        }

        public boolean mo459a(Object obj) {
            return C0623e.m2651a(obj);
        }

        public void mo464b(Object obj) {
            C0623e.m2655b(obj);
        }

        public boolean mo460a(Object obj, float f) {
            return C0623e.m2652a(obj, f);
        }

        public boolean mo465c(Object obj) {
            return C0623e.m2656c(obj);
        }

        public boolean mo462a(Object obj, int i) {
            return C0623e.m2653a(obj, i);
        }

        public boolean mo463a(Object obj, Canvas canvas) {
            return C0623e.m2654a(obj, canvas);
        }

        public boolean mo461a(Object obj, float f, float f2) {
            return C0623e.m2652a(obj, f);
        }
    }

    /* compiled from: EdgeEffectCompat */
    static class C0621d extends C0620b {
        C0621d() {
        }

        public boolean mo461a(Object obj, float f, float f2) {
            return C0624f.m2657a(obj, f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1224b = new C0621d();
        } else if (VERSION.SDK_INT >= 14) {
            f1224b = new C0620b();
        } else {
            f1224b = new C0619a();
        }
    }

    public C0622d(Context context) {
        this.f1225a = f1224b.mo457a(context);
    }

    public void m2641a(int i, int i2) {
        f1224b.mo458a(this.f1225a, i, i2);
    }

    public boolean m2642a() {
        return f1224b.mo459a(this.f1225a);
    }

    public void m2647b() {
        f1224b.mo464b(this.f1225a);
    }

    @Deprecated
    public boolean m2643a(float f) {
        return f1224b.mo460a(this.f1225a, f);
    }

    public boolean m2644a(float f, float f2) {
        return f1224b.mo461a(this.f1225a, f, f2);
    }

    public boolean m2648c() {
        return f1224b.mo465c(this.f1225a);
    }

    public boolean m2645a(int i) {
        return f1224b.mo462a(this.f1225a, i);
    }

    public boolean m2646a(Canvas canvas) {
        return f1224b.mo463a(this.f1225a, canvas);
    }
}
