package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ab;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* compiled from: AppCompatImageButton */
public class C0874j extends ImageButton implements ab {
    private C0868h f2358a = new C0868h(this);
    private C0875k f2359b;

    public C0874j(Context context, AttributeSet attributeSet, int i) {
        super(ap.m4289a(context), attributeSet, i);
        this.f2358a.m4450a(attributeSet, i);
        this.f2359b = new C0875k(this);
        this.f2359b.m4490a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f2359b.m4489a(i);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2358a != null) {
            this.f2358a.m4446a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2358a != null) {
            this.f2358a.m4449a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2358a != null) {
            this.f2358a.m4447a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2358a != null ? this.f2358a.m4445a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2358a != null) {
            this.f2358a.m4448a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2358a != null ? this.f2358a.m4451b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2358a != null) {
            this.f2358a.m4453c();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f2359b.m4491a() && super.hasOverlappingRendering();
    }
}
