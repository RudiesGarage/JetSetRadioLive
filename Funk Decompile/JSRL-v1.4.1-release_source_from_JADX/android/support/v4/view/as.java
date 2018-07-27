package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatJB */
class as {
    public static void m2382a(final View view, final at atVar) {
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
