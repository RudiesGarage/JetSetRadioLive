package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0663e;
import android.support.v7.p027b.C0670a.C0667i;
import android.support.v7.p027b.C0670a.C0669k;
import android.support.v7.p028c.p029a.C0673b;
import android.support.v7.view.menu.C0710a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

/* compiled from: ToolbarWidgetWrapper */
public class at implements C0846s {
    Toolbar f2243a;
    CharSequence f2244b;
    Callback f2245c;
    boolean f2246d;
    private int f2247e;
    private View f2248f;
    private Drawable f2249g;
    private Drawable f2250h;
    private Drawable f2251i;
    private boolean f2252j;
    private CharSequence f2253k;
    private CharSequence f2254l;
    private int f2255m;
    private int f2256n;
    private Drawable f2257o;

    /* compiled from: ToolbarWidgetWrapper */
    class C08451 implements OnClickListener {
        final C0710a f2241a = new C0710a(this.f2242b.f2243a.getContext(), 0, 16908332, 0, 0, this.f2242b.f2244b);
        final /* synthetic */ at f2242b;

        C08451(at atVar) {
            this.f2242b = atVar;
        }

        public void onClick(View view) {
            if (this.f2242b.f2245c != null && this.f2242b.f2246d) {
                this.f2242b.f2245c.onMenuItemSelected(0, this.f2241a);
            }
        }
    }

    public at(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0667i.abc_action_bar_up_description, C0663e.abc_ic_ab_back_material);
    }

    public at(Toolbar toolbar, boolean z, int i, int i2) {
        this.f2255m = 0;
        this.f2256n = 0;
        this.f2243a = toolbar;
        this.f2244b = toolbar.getTitle();
        this.f2253k = toolbar.getSubtitle();
        this.f2252j = this.f2244b != null;
        this.f2251i = toolbar.getNavigationIcon();
        as a = as.m4294a(toolbar.getContext(), null, C0669k.ActionBar, C0659a.actionBarStyle, 0);
        this.f2257o = a.m4297a(C0669k.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence b = a.m4301b(C0669k.ActionBar_title);
            if (!TextUtils.isEmpty(b)) {
                m4331b(b);
            }
            b = a.m4301b(C0669k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(b)) {
                m4334c(b);
            }
            Drawable a2 = a.m4297a(C0669k.ActionBar_logo);
            if (a2 != null) {
                m4330b(a2);
            }
            a2 = a.m4297a(C0669k.ActionBar_icon);
            if (a2 != null) {
                mo678a(a2);
            }
            if (this.f2251i == null && this.f2257o != null) {
                m4333c(this.f2257o);
            }
            m4335d(a.m4296a(C0669k.ActionBar_displayOptions, 0));
            int g = a.m4310g(C0669k.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                m4325a(LayoutInflater.from(this.f2243a.getContext()).inflate(g, this.f2243a, false));
                m4335d(this.f2247e | 16);
            }
            g = a.m4308f(C0669k.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.f2243a.getLayoutParams();
                layoutParams.height = g;
                this.f2243a.setLayoutParams(layoutParams);
            }
            g = a.m4304d(C0669k.ActionBar_contentInsetStart, -1);
            int d = a.m4304d(C0669k.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.f2243a.m4088a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.m4310g(C0669k.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.f2243a.m4089a(this.f2243a.getContext(), g);
            }
            g = a.m4310g(C0669k.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.f2243a.m4091b(this.f2243a.getContext(), g);
            }
            int g2 = a.m4310g(C0669k.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.f2243a.setPopupTheme(g2);
            }
        } else {
            this.f2247e = m4317c();
        }
        a.m4298a();
        m4332c(i);
        this.f2254l = this.f2243a.getNavigationContentDescription();
        this.f2243a.setNavigationOnClickListener(new C08451(this));
    }

    public void m4332c(int i) {
        if (i != this.f2256n) {
            this.f2256n = i;
            if (TextUtils.isEmpty(this.f2243a.getNavigationContentDescription())) {
                m4337e(this.f2256n);
            }
        }
    }

    private int m4317c() {
        if (this.f2243a.getNavigationIcon() == null) {
            return 11;
        }
        this.f2257o = this.f2243a.getNavigationIcon();
        return 15;
    }

    public Context m4328b() {
        return this.f2243a.getContext();
    }

    public void mo679a(Callback callback) {
        this.f2245c = callback;
    }

    public void mo680a(CharSequence charSequence) {
        if (!this.f2252j) {
            m4320e(charSequence);
        }
    }

    public CharSequence mo676a() {
        return this.f2243a.getTitle();
    }

    public void m4331b(CharSequence charSequence) {
        this.f2252j = true;
        m4320e(charSequence);
    }

    private void m4320e(CharSequence charSequence) {
        this.f2244b = charSequence;
        if ((this.f2247e & 8) != 0) {
            this.f2243a.setTitle(charSequence);
        }
    }

    public void m4334c(CharSequence charSequence) {
        this.f2253k = charSequence;
        if ((this.f2247e & 8) != 0) {
            this.f2243a.setSubtitle(charSequence);
        }
    }

    public void mo677a(int i) {
        mo678a(i != 0 ? C0673b.m2768b(m4328b(), i) : null);
    }

    public void mo678a(Drawable drawable) {
        this.f2249g = drawable;
        m4318d();
    }

    public void mo681b(int i) {
        m4330b(i != 0 ? C0673b.m2768b(m4328b(), i) : null);
    }

    public void m4330b(Drawable drawable) {
        this.f2250h = drawable;
        m4318d();
    }

    private void m4318d() {
        Drawable drawable = null;
        if ((this.f2247e & 2) != 0) {
            drawable = (this.f2247e & 1) != 0 ? this.f2250h != null ? this.f2250h : this.f2249g : this.f2249g;
        }
        this.f2243a.setLogo(drawable);
    }

    public void m4335d(int i) {
        int i2 = this.f2247e ^ i;
        this.f2247e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m4321f();
                }
                m4319e();
            }
            if ((i2 & 3) != 0) {
                m4318d();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2243a.setTitle(this.f2244b);
                    this.f2243a.setSubtitle(this.f2253k);
                } else {
                    this.f2243a.setTitle(null);
                    this.f2243a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f2248f != null) {
                if ((i & 16) != 0) {
                    this.f2243a.addView(this.f2248f);
                } else {
                    this.f2243a.removeView(this.f2248f);
                }
            }
        }
    }

    public void m4325a(View view) {
        if (!(this.f2248f == null || (this.f2247e & 16) == 0)) {
            this.f2243a.removeView(this.f2248f);
        }
        this.f2248f = view;
        if (view != null && (this.f2247e & 16) != 0) {
            this.f2243a.addView(this.f2248f);
        }
    }

    public void m4333c(Drawable drawable) {
        this.f2251i = drawable;
        m4319e();
    }

    private void m4319e() {
        if ((this.f2247e & 4) != 0) {
            this.f2243a.setNavigationIcon(this.f2251i != null ? this.f2251i : this.f2257o);
        } else {
            this.f2243a.setNavigationIcon(null);
        }
    }

    public void m4336d(CharSequence charSequence) {
        this.f2254l = charSequence;
        m4321f();
    }

    public void m4337e(int i) {
        m4336d(i == 0 ? null : m4328b().getString(i));
    }

    private void m4321f() {
        if ((this.f2247e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f2254l)) {
            this.f2243a.setNavigationContentDescription(this.f2256n);
        } else {
            this.f2243a.setNavigationContentDescription(this.f2254l);
        }
    }
}
