package android.support.v7.p030d.p031a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p015c.p016a.C0302a;

/* compiled from: DrawableWrapper */
public class C0675a extends Drawable implements Callback {
    private Drawable f1249a;

    public C0675a(Drawable drawable) {
        m2776a(drawable);
    }

    public void draw(Canvas canvas) {
        this.f1249a.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.f1249a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f1249a.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f1249a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f1249a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1249a.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f1249a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1249a.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f1249a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f1249a.setState(iArr);
    }

    public int[] getState() {
        return this.f1249a.getState();
    }

    public void jumpToCurrentState() {
        C0302a.m1137a(this.f1249a);
    }

    public Drawable getCurrent() {
        return this.f1249a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1249a.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f1249a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f1249a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f1249a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f1249a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f1249a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f1249a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f1249a.getPadding(rect);
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
        return this.f1249a.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        C0302a.m1145a(this.f1249a, z);
    }

    public boolean isAutoMirrored() {
        return C0302a.m1146b(this.f1249a);
    }

    public void setTint(int i) {
        C0302a.m1139a(this.f1249a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0302a.m1141a(this.f1249a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0302a.m1144a(this.f1249a, mode);
    }

    public void setHotspot(float f, float f2) {
        C0302a.m1138a(this.f1249a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0302a.m1140a(this.f1249a, i, i2, i3, i4);
    }

    public Drawable m2775a() {
        return this.f1249a;
    }

    public void m2776a(Drawable drawable) {
        if (this.f1249a != null) {
            this.f1249a.setCallback(null);
        }
        this.f1249a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
