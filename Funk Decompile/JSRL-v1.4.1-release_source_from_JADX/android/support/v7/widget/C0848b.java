package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable */
class C0848b extends Drawable {
    final ActionBarContainer f2266a;

    public C0848b(ActionBarContainer actionBarContainer) {
        this.f2266a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f2266a.f1561d) {
            if (this.f2266a.f1558a != null) {
                this.f2266a.f1558a.draw(canvas);
            }
            if (this.f2266a.f1559b != null && this.f2266a.f1562e) {
                this.f2266a.f1559b.draw(canvas);
            }
        } else if (this.f2266a.f1560c != null) {
            this.f2266a.f1560c.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
