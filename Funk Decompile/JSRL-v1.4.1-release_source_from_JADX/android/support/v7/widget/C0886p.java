package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p027b.C0670a.C0669k;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextHelperV17 */
class C0886p extends C0885o {
    private aq f2395b;
    private aq f2396c;

    C0886p(TextView textView) {
        super(textView);
    }

    void mo698a(AttributeSet attributeSet, int i) {
        super.mo698a(attributeSet, i);
        Context context = this.a.getContext();
        C0873i a = C0873i.m4467a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0669k.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(C0669k.AppCompatTextHelper_android_drawableStart)) {
            this.f2395b = C0885o.m4505a(context, a, obtainStyledAttributes.getResourceId(C0669k.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(C0669k.AppCompatTextHelper_android_drawableEnd)) {
            this.f2396c = C0885o.m4505a(context, a, obtainStyledAttributes.getResourceId(C0669k.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.recycle();
    }

    void mo697a() {
        super.mo697a();
        if (this.f2395b != null || this.f2396c != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m4509a(compoundDrawablesRelative[0], this.f2395b);
            m4509a(compoundDrawablesRelative[2], this.f2396c);
        }
    }
}
