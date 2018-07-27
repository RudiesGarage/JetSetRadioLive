package android.support.v4.p015c.p016a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: DrawableWrapperGingerbread */
class C0310g extends Drawable implements Callback, C0307f, C0157k {
    static final Mode f789a = Mode.SRC_IN;
    C0308a f790b;
    Drawable f791c;
    private int f792d;
    private Mode f793e;
    private boolean f794f;
    private boolean f795g;

    /* compiled from: DrawableWrapperGingerbread */
    protected static abstract class C0308a extends ConstantState {
        int f785a;
        ConstantState f786b;
        ColorStateList f787c = null;
        Mode f788d = C0310g.f789a;

        public abstract Drawable newDrawable(Resources resources);

        C0308a(C0308a c0308a, Resources resources) {
            if (c0308a != null) {
                this.f785a = c0308a.f785a;
                this.f786b = c0308a.f786b;
                this.f787c = c0308a.f787c;
                this.f788d = c0308a.f788d;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.f786b != null ? this.f786b.getChangingConfigurations() : 0) | this.f785a;
        }

        boolean m1174a() {
            return this.f786b != null;
        }
    }

    /* compiled from: DrawableWrapperGingerbread */
    private static class C0309b extends C0308a {
        C0309b(C0308a c0308a, Resources resources) {
            super(c0308a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0310g(this, resources);
        }
    }

    C0310g(C0308a c0308a, Resources resources) {
        this.f790b = c0308a;
        m1175a(resources);
    }

    C0310g(Drawable drawable) {
        this.f790b = mo186b();
        m1179a(drawable);
    }

    private void m1175a(Resources resources) {
        if (this.f790b != null && this.f790b.f786b != null) {
            m1179a(m1178a(this.f790b.f786b, resources));
        }
    }

    protected Drawable m1178a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    public void draw(Canvas canvas) {
        this.f791c.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f791c != null) {
            this.f791c.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.f791c.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.f790b != null ? this.f790b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.f791c.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f791c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f791c.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f791c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f791c.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo187c() || this.f790b == null) ? null : this.f790b.f787c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f791c.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m1176a(iArr) || this.f791c.setState(iArr);
    }

    public int[] getState() {
        return this.f791c.getState();
    }

    public Drawable getCurrent() {
        return this.f791c.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f791c.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f791c.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f791c.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f791c.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f791c.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f791c.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f791c.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f791c.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.f790b == null || !this.f790b.m1174a()) {
            return null;
        }
        this.f790b.f785a = getChangingConfigurations();
        return this.f790b;
    }

    public Drawable mutate() {
        if (!this.f795g && super.mutate() == this) {
            this.f790b = mo186b();
            if (this.f791c != null) {
                this.f791c.mutate();
            }
            if (this.f790b != null) {
                this.f790b.f786b = this.f791c != null ? this.f791c.getConstantState() : null;
            }
            this.f795g = true;
        }
        return this;
    }

    C0308a mo186b() {
        return new C0309b(this.f790b, null);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.f791c.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f790b.f787c = colorStateList;
        m1176a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f790b.f788d = mode;
        m1176a(getState());
    }

    private boolean m1176a(int[] iArr) {
        if (!mo187c()) {
            return false;
        }
        ColorStateList colorStateList = this.f790b.f787c;
        Mode mode = this.f790b.f788d;
        if (colorStateList == null || mode == null) {
            this.f794f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f794f && colorForState == this.f792d && mode == this.f793e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f792d = colorForState;
        this.f793e = mode;
        this.f794f = true;
        return true;
    }

    public final Drawable mo185a() {
        return this.f791c;
    }

    public final void m1179a(Drawable drawable) {
        if (this.f791c != null) {
            this.f791c.setCallback(null);
        }
        this.f791c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f790b != null) {
                this.f790b.f786b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean mo187c() {
        return true;
    }
}
