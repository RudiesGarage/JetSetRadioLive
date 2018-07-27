package android.support.v7.widget;

import android.graphics.Outline;

/* compiled from: ActionBarBackgroundDrawableV21 */
class C0849c extends C0848b {
    public C0849c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f1561d) {
            if (this.a.f1560c != null) {
                this.a.f1560c.getOutline(outline);
            }
        } else if (this.a.f1558a != null) {
            this.a.f1558a.getOutline(outline);
        }
    }
}
