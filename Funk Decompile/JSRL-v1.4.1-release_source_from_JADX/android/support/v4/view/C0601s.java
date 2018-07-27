package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
public final class C0601s {
    static final C0597d f1147a;

    /* compiled from: MotionEventCompat */
    interface C0597d {
        float mo438a(MotionEvent motionEvent, int i);
    }

    /* compiled from: MotionEventCompat */
    static class C0598a implements C0597d {
        C0598a() {
        }

        public float mo438a(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    /* compiled from: MotionEventCompat */
    static class C0599b extends C0598a {
        C0599b() {
        }

        public float mo438a(MotionEvent motionEvent, int i) {
            return C0602t.m2516a(motionEvent, i);
        }
    }

    /* compiled from: MotionEventCompat */
    private static class C0600c extends C0599b {
        C0600c() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f1147a = new C0600c();
        } else if (VERSION.SDK_INT >= 12) {
            f1147a = new C0599b();
        } else {
            f1147a = new C0598a();
        }
    }

    public static int m2508a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m2510b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    @Deprecated
    public static int m2509a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    @Deprecated
    public static int m2511b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    @Deprecated
    public static float m2512c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    @Deprecated
    public static float m2514d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    @Deprecated
    public static int m2513c(MotionEvent motionEvent) {
        return motionEvent.getSource();
    }

    public static float m2515e(MotionEvent motionEvent, int i) {
        return f1147a.mo438a(motionEvent, i);
    }
}
