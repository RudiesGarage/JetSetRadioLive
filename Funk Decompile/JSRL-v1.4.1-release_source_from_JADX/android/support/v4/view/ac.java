package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* compiled from: VelocityTrackerCompat */
public final class ac {
    static final C0515c f1102a;

    /* compiled from: VelocityTrackerCompat */
    interface C0515c {
        float mo357a(VelocityTracker velocityTracker, int i);

        float mo358b(VelocityTracker velocityTracker, int i);
    }

    /* compiled from: VelocityTrackerCompat */
    static class C0516a implements C0515c {
        C0516a() {
        }

        public float mo357a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float mo358b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    /* compiled from: VelocityTrackerCompat */
    static class C0517b implements C0515c {
        C0517b() {
        }

        public float mo357a(VelocityTracker velocityTracker, int i) {
            return ad.m2066a(velocityTracker, i);
        }

        public float mo358b(VelocityTracker velocityTracker, int i) {
            return ad.m2067b(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f1102a = new C0517b();
        } else {
            f1102a = new C0516a();
        }
    }

    public static float m2064a(VelocityTracker velocityTracker, int i) {
        return f1102a.mo357a(velocityTracker, i);
    }

    public static float m2065b(VelocityTracker velocityTracker, int i) {
        return f1102a.mo358b(velocityTracker, i);
    }
}
