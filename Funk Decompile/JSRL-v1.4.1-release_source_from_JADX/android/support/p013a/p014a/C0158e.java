package android.support.p013a.p014a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.p015c.p016a.C0157k;
import android.support.v4.p015c.p016a.C0302a;
import android.util.AttributeSet;

@TargetApi(21)
/* compiled from: VectorDrawableCommon */
abstract class C0158e extends Drawable implements C0157k {
    Drawable f374b;

    C0158e() {
    }

    static TypedArray m525b(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f374b != null) {
            this.f374b.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.f374b != null) {
            return C0302a.m1149e(this.f374b);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.f374b != null) {
            return this.f374b.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f374b != null) {
            this.f374b.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f374b != null) {
            C0302a.m1138a(this.f374b, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f374b != null) {
            C0302a.m1140a(this.f374b, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f374b != null) {
            this.f374b.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.f374b != null) {
            C0302a.m1137a(this.f374b);
        }
    }

    public void applyTheme(Theme theme) {
        if (this.f374b != null) {
            C0302a.m1142a(this.f374b, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f374b != null) {
            this.f374b.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.f374b != null) {
            return this.f374b.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.f374b != null) {
            return this.f374b.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.f374b != null) {
            return this.f374b.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.f374b != null) {
            return this.f374b.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.f374b != null) {
            return this.f374b.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.f374b != null) {
            return this.f374b.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.f374b != null) {
            this.f374b.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.f374b != null) {
            return this.f374b.setState(iArr);
        }
        return super.setState(iArr);
    }
}
