package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatICS */
class ar {
    public static void m2377a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m2376a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m2380b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m2381c(View view, float f) {
        view.animate().translationY(f);
    }

    public static void m2375a(View view) {
        view.animate().cancel();
    }

    public static void m2379b(View view) {
        view.animate().start();
    }

    public static void m2378a(final View view, final at atVar) {
        if (atVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    atVar.mo420c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    atVar.mo419b(view);
                }

                public void onAnimationStart(Animator animator) {
                    atVar.mo418a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }
}
