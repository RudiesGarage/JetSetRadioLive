package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ab;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p028c.p029a.C0673b;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/* compiled from: AppCompatAutoCompleteTextView */
public class C0803g extends AutoCompleteTextView implements ab {
    private static final int[] f1889a = new int[]{16843126};
    private C0868h f1890b;
    private C0885o f1891c;

    public C0803g(Context context) {
        this(context, null);
    }

    public C0803g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0659a.autoCompleteTextViewStyle);
    }

    public C0803g(Context context, AttributeSet attributeSet, int i) {
        super(ap.m4289a(context), attributeSet, i);
        as a = as.m4294a(getContext(), attributeSet, f1889a, i, 0);
        if (a.m4309f(0)) {
            setDropDownBackgroundDrawable(a.m4297a(0));
        }
        a.m4298a();
        this.f1890b = new C0868h(this);
        this.f1890b.m4450a(attributeSet, i);
        this.f1891c = C0885o.m4506a((TextView) this);
        this.f1891c.mo698a(attributeSet, i);
        this.f1891c.mo697a();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0673b.m2768b(getContext(), i));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1890b != null) {
            this.f1890b.m4446a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1890b != null) {
            this.f1890b.m4449a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1890b != null) {
            this.f1890b.m4447a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1890b != null ? this.f1890b.m4445a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1890b != null) {
            this.f1890b.m4448a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1890b != null ? this.f1890b.m4451b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1890b != null) {
            this.f1890b.m4453c();
        }
        if (this.f1891c != null) {
            this.f1891c.mo697a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1891c != null) {
            this.f1891c.m4508a(context, i);
        }
    }
}
