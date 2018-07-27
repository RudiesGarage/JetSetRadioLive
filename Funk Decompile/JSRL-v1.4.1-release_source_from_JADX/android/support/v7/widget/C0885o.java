package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p027b.C0670a.C0669k;
import android.support.v7.p033f.C0678a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextHelper */
class C0885o {
    final TextView f2390a;
    private aq f2391b;
    private aq f2392c;
    private aq f2393d;
    private aq f2394e;

    static C0885o m4506a(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new C0886p(textView);
        }
        return new C0885o(textView);
    }

    C0885o(TextView textView) {
        this.f2390a = textView;
    }

    void mo698a(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        ColorStateList d;
        ColorStateList colorStateList = null;
        Context context = this.f2390a.getContext();
        C0873i a = C0873i.m4467a();
        as a2 = as.m4294a(context, attributeSet, C0669k.AppCompatTextHelper, i, 0);
        int g = a2.m4310g(C0669k.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.m4309f(C0669k.AppCompatTextHelper_android_drawableLeft)) {
            this.f2391b = C0885o.m4505a(context, a, a2.m4310g(C0669k.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.m4309f(C0669k.AppCompatTextHelper_android_drawableTop)) {
            this.f2392c = C0885o.m4505a(context, a, a2.m4310g(C0669k.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.m4309f(C0669k.AppCompatTextHelper_android_drawableRight)) {
            this.f2393d = C0885o.m4505a(context, a, a2.m4310g(C0669k.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.m4309f(C0669k.AppCompatTextHelper_android_drawableBottom)) {
            this.f2394e = C0885o.m4505a(context, a, a2.m4310g(C0669k.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a2.m4298a();
        boolean z3 = this.f2390a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (g != -1) {
            as a3 = as.m4292a(context, g, C0669k.TextAppearance);
            if (z3 || !a3.m4309f(C0669k.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a3.m4299a(C0669k.TextAppearance_textAllCaps, false);
                z = true;
            }
            if (VERSION.SDK_INT < 23) {
                if (a3.m4309f(C0669k.TextAppearance_android_textColor)) {
                    d = a3.m4305d(C0669k.TextAppearance_android_textColor);
                } else {
                    d = null;
                }
                if (a3.m4309f(C0669k.TextAppearance_android_textColorHint)) {
                    colorStateList = a3.m4305d(C0669k.TextAppearance_android_textColorHint);
                }
            } else {
                d = null;
            }
            a3.m4298a();
        } else {
            d = null;
            z = false;
            z2 = false;
        }
        as a4 = as.m4294a(context, attributeSet, C0669k.TextAppearance, i, 0);
        if (!z3 && a4.m4309f(C0669k.TextAppearance_textAllCaps)) {
            z2 = a4.m4299a(C0669k.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (VERSION.SDK_INT < 23) {
            if (a4.m4309f(C0669k.TextAppearance_android_textColor)) {
                d = a4.m4305d(C0669k.TextAppearance_android_textColor);
            }
            if (a4.m4309f(C0669k.TextAppearance_android_textColorHint)) {
                colorStateList = a4.m4305d(C0669k.TextAppearance_android_textColorHint);
            }
        }
        a4.m4298a();
        if (d != null) {
            this.f2390a.setTextColor(d);
        }
        if (colorStateList != null) {
            this.f2390a.setHintTextColor(colorStateList);
        }
        if (!z3 && r0) {
            m4511a(z2);
        }
    }

    void m4508a(Context context, int i) {
        as a = as.m4292a(context, i, C0669k.TextAppearance);
        if (a.m4309f(C0669k.TextAppearance_textAllCaps)) {
            m4511a(a.m4299a(C0669k.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.m4309f(C0669k.TextAppearance_android_textColor)) {
            ColorStateList d = a.m4305d(C0669k.TextAppearance_android_textColor);
            if (d != null) {
                this.f2390a.setTextColor(d);
            }
        }
        a.m4298a();
    }

    void m4511a(boolean z) {
        this.f2390a.setTransformationMethod(z ? new C0678a(this.f2390a.getContext()) : null);
    }

    void mo697a() {
        if (this.f2391b != null || this.f2392c != null || this.f2393d != null || this.f2394e != null) {
            Drawable[] compoundDrawables = this.f2390a.getCompoundDrawables();
            m4509a(compoundDrawables[0], this.f2391b);
            m4509a(compoundDrawables[1], this.f2392c);
            m4509a(compoundDrawables[2], this.f2393d);
            m4509a(compoundDrawables[3], this.f2394e);
        }
    }

    final void m4509a(Drawable drawable, aq aqVar) {
        if (drawable != null && aqVar != null) {
            C0873i.m4470a(drawable, aqVar, this.f2390a.getDrawableState());
        }
    }

    protected static aq m4505a(Context context, C0873i c0873i, int i) {
        ColorStateList b = c0873i.m4488b(context, i);
        if (b == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.f2237e = true;
        aqVar.f2234b = b;
        return aqVar;
    }
}
