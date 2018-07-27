package android.support.v4.p015c.p016a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.v4.p015c.p016a.C0310g.C0308a;

/* compiled from: DrawableWrapperLollipop */
class C0316j extends C0314i {

    /* compiled from: DrawableWrapperLollipop */
    private static class C0315a extends C0308a {
        C0315a(C0308a c0308a, Resources resources) {
            super(c0308a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0316j(this, resources);
        }
    }

    C0316j(Drawable drawable) {
        super(drawable);
    }

    C0316j(C0308a c0308a, Resources resources) {
        super(c0308a, resources);
    }

    public void setHotspot(float f, float f2) {
        this.c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.c.setHotspotBounds(i, i2, i3, i4);
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void setTintList(ColorStateList colorStateList) {
        if (mo187c()) {
            super.setTintList(colorStateList);
        } else {
            this.c.setTintList(colorStateList);
        }
    }

    public void setTint(int i) {
        if (mo187c()) {
            super.setTint(i);
        } else {
            this.c.setTint(i);
        }
    }

    public void setTintMode(Mode mode) {
        if (mo187c()) {
            super.setTintMode(mode);
        } else {
            this.c.setTintMode(mode);
        }
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    protected boolean mo187c() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.c;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable)) {
            return true;
        }
        return false;
    }

    C0308a mo186b() {
        return new C0315a(this.b, null);
    }
}
