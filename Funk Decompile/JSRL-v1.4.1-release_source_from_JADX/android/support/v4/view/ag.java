package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* compiled from: ViewCompatHC */
class ag {
    static long m2255a() {
        return ValueAnimator.getFrameDelay();
    }

    public static float m2253a(View view) {
        return view.getAlpha();
    }

    public static void m2257a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int m2259b(View view) {
        return view.getLayerType();
    }

    public static int m2254a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int m2262c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int m2264d(View view) {
        return view.getMeasuredState();
    }

    public static float m2265e(View view) {
        return view.getTranslationX();
    }

    public static float m2266f(View view) {
        return view.getTranslationY();
    }

    public static void m2256a(View view, float f) {
        view.setTranslationX(f);
    }

    public static void m2260b(View view, float f) {
        view.setTranslationY(f);
    }

    public static void m2263c(View view, float f) {
        view.setAlpha(f);
    }

    public static void m2267g(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void m2258a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static void m2261b(View view, boolean z) {
        view.setActivated(z);
    }
}
