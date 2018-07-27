package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ab;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageView */
public class C0854l extends ImageView implements ab {
    private C0868h f2273a;
    private C0875k f2274b;

    public C0854l(Context context) {
        this(context, null);
    }

    public C0854l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0854l(Context context, AttributeSet attributeSet, int i) {
        super(ap.m4289a(context), attributeSet, i);
        this.f2273a = new C0868h(this);
        this.f2273a.m4450a(attributeSet, i);
        this.f2274b = new C0875k(this);
        this.f2274b.m4490a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f2274b.m4489a(i);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2273a != null) {
            this.f2273a.m4446a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2273a != null) {
            this.f2273a.m4449a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2273a != null) {
            this.f2273a.m4447a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2273a != null ? this.f2273a.m4445a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2273a != null) {
            this.f2273a.m4448a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2273a != null ? this.f2273a.m4451b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2273a != null) {
            this.f2273a.m4453c();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f2274b.m4491a() && super.hasOverlappingRendering();
    }
}
