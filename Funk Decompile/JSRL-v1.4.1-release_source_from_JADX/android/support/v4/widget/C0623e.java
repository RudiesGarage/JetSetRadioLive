package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* compiled from: EdgeEffectCompatIcs */
class C0623e {
    public static Object m2649a(Context context) {
        return new EdgeEffect(context);
    }

    public static void m2650a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean m2651a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static void m2655b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean m2652a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean m2656c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public static boolean m2653a(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    public static boolean m2654a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
