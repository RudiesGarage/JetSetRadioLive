package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ab;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextView */
public class C0705q extends TextView implements ab {
    private C0868h f1364a;
    private C0885o f1365b;

    public C0705q(Context context) {
        this(context, null);
    }

    public C0705q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public C0705q(Context context, AttributeSet attributeSet, int i) {
        super(ap.m4289a(context), attributeSet, i);
        this.f1364a = new C0868h(this);
        this.f1364a.m4450a(attributeSet, i);
        this.f1365b = C0885o.m4506a((TextView) this);
        this.f1365b.mo698a(attributeSet, i);
        this.f1365b.mo697a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1364a != null) {
            this.f1364a.m4446a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1364a != null) {
            this.f1364a.m4449a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1364a != null) {
            this.f1364a.m4447a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1364a != null ? this.f1364a.m4445a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1364a != null) {
            this.f1364a.m4448a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1364a != null ? this.f1364a.m4451b() : null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1365b != null) {
            this.f1365b.m4508a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1364a != null) {
            this.f1364a.m4453c();
        }
        if (this.f1365b != null) {
            this.f1365b.mo697a();
        }
    }
}
