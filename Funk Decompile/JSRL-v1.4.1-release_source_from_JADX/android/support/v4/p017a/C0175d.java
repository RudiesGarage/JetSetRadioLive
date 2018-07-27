package android.support.v4.p017a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: HoneycombMr1AnimatorCompatProvider */
class C0175d implements C0173b {
    private TimeInterpolator f452a;

    C0175d() {
    }

    public void mo90a(View view) {
        if (this.f452a == null) {
            this.f452a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f452a);
    }
}
