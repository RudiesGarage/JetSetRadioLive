package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0669k;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: AppCompatBackgroundHelper */
class C0868h {
    private final View f2336a;
    private final C0873i f2337b;
    private int f2338c = -1;
    private C0867a f2339d;
    private C0867a f2340e;
    private C0867a f2341f;

    /* compiled from: AppCompatBackgroundHelper */
    private static class C0867a extends aq {
        public ColorStateList f2335a;

        C0867a() {
        }

        void mo692a() {
            super.mo692a();
            this.f2335a = null;
        }
    }

    C0868h(View view) {
        this.f2336a = view;
        this.f2337b = C0873i.m4467a();
    }

    void m4450a(AttributeSet attributeSet, int i) {
        as a = as.m4294a(this.f2336a.getContext(), attributeSet, C0669k.ViewBackgroundHelper, i, 0);
        try {
            if (a.m4309f(C0669k.ViewBackgroundHelper_android_background)) {
                this.f2338c = a.m4310g(C0669k.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.f2337b.m4488b(this.f2336a.getContext(), this.f2338c);
                if (b != null) {
                    m4452b(b);
                }
            }
            if (a.m4309f(C0669k.ViewBackgroundHelper_backgroundTint)) {
                ae.m2207a(this.f2336a, a.m4305d(C0669k.ViewBackgroundHelper_backgroundTint));
            }
            if (a.m4309f(C0669k.ViewBackgroundHelper_backgroundTintMode)) {
                ae.m2208a(this.f2336a, C0901u.m4587a(a.m4296a(C0669k.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.m4298a();
        } catch (Throwable th) {
            a.m4298a();
        }
    }

    void m4446a(int i) {
        this.f2338c = i;
        m4452b(this.f2337b != null ? this.f2337b.m4488b(this.f2336a.getContext(), i) : null);
        if (m4444d()) {
            m4453c();
        }
    }

    void m4449a(Drawable drawable) {
        this.f2338c = -1;
        m4452b(null);
        if (m4444d()) {
            m4453c();
        }
    }

    void m4447a(ColorStateList colorStateList) {
        if (this.f2340e == null) {
            this.f2340e = new C0867a();
        }
        this.f2340e.f2335a = colorStateList;
        this.f2340e.b = null;
        this.f2340e.e = true;
        if (m4444d()) {
            m4453c();
        }
    }

    private boolean m4444d() {
        if (this.f2340e != null && this.f2340e.e) {
            if (this.f2338c >= 0) {
                ColorStateList a = this.f2337b.m4484a(this.f2336a.getContext(), this.f2338c, this.f2340e.f2335a);
                if (a != null) {
                    this.f2340e.b = a;
                    return true;
                }
            }
            if (this.f2340e.b != this.f2340e.f2335a) {
                this.f2340e.b = this.f2340e.f2335a;
                return true;
            }
        }
        return false;
    }

    ColorStateList m4445a() {
        return this.f2340e != null ? this.f2340e.b : null;
    }

    void m4448a(Mode mode) {
        if (this.f2340e == null) {
            this.f2340e = new C0867a();
        }
        this.f2340e.c = mode;
        this.f2340e.d = true;
        m4453c();
    }

    Mode m4451b() {
        return this.f2340e != null ? this.f2340e.c : null;
    }

    void m4453c() {
        Drawable background = this.f2336a.getBackground();
        if (background == null) {
            return;
        }
        if (VERSION.SDK_INT != 21 || !m4443b(background)) {
            if (this.f2340e != null) {
                C0873i.m4470a(background, this.f2340e, this.f2336a.getDrawableState());
            } else if (this.f2339d != null) {
                C0873i.m4470a(background, this.f2339d, this.f2336a.getDrawableState());
            }
        }
    }

    void m4452b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2339d == null) {
                this.f2339d = new C0867a();
            }
            this.f2339d.b = colorStateList;
            this.f2339d.e = true;
        } else {
            this.f2339d = null;
        }
        m4453c();
    }

    private boolean m4443b(Drawable drawable) {
        if (this.f2341f == null) {
            this.f2341f = new C0867a();
        }
        aq aqVar = this.f2341f;
        aqVar.mo692a();
        ColorStateList t = ae.m2240t(this.f2336a);
        if (t != null) {
            aqVar.f2237e = true;
            aqVar.f2234b = t;
        }
        Mode u = ae.m2241u(this.f2336a);
        if (u != null) {
            aqVar.f2236d = true;
            aqVar.f2235c = u;
        }
        if (!aqVar.f2237e && !aqVar.f2236d) {
            return false;
        }
        C0873i.m4470a(drawable, aqVar, this.f2336a.getDrawableState());
        return true;
    }
}
