package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: ViewCompatJB */
class ai {
    public static boolean m2275a(View view) {
        return view.hasTransientState();
    }

    public static void m2276b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m2273a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m2274a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int m2277c(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m2271a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static int m2278d(View view) {
        return view.getMinimumWidth();
    }

    public static int m2279e(View view) {
        return view.getMinimumHeight();
    }

    public static void m2280f(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m2281g(View view) {
        return view.hasOverlappingRendering();
    }

    public static void m2272a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }
}
