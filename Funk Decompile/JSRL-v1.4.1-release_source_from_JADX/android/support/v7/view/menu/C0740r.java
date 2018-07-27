package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p027b.C0670a.C0662d;
import android.support.v7.p027b.C0670a.C0666h;
import android.support.v7.view.menu.C0711m.C0736a;
import android.support.v7.widget.ad;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

/* compiled from: StandardMenuPopup */
final class C0740r extends C0720k implements C0711m, OnKeyListener, OnItemClickListener, OnDismissListener {
    final ad f1537a;
    View f1538b;
    private final Context f1539c;
    private final C0724g f1540d;
    private final C0722f f1541e;
    private final boolean f1542f;
    private final int f1543g;
    private final int f1544h;
    private final int f1545i;
    private final OnGlobalLayoutListener f1546j = new C07391(this);
    private OnDismissListener f1547k;
    private View f1548l;
    private C0736a f1549m;
    private ViewTreeObserver f1550n;
    private boolean f1551o;
    private boolean f1552p;
    private int f1553q;
    private int f1554r = 0;
    private boolean f1555s;

    /* compiled from: StandardMenuPopup */
    class C07391 implements OnGlobalLayoutListener {
        final /* synthetic */ C0740r f1536a;

        C07391(C0740r c0740r) {
            this.f1536a = c0740r;
        }

        public void onGlobalLayout() {
            if (this.f1536a.mo528d() && !this.f1536a.f1537a.m4126g()) {
                View view = this.f1536a.f1538b;
                if (view == null || !view.isShown()) {
                    this.f1536a.mo525c();
                } else {
                    this.f1536a.f1537a.mo518a();
                }
            }
        }
    }

    public C0740r(Context context, C0724g c0724g, View view, int i, int i2, boolean z) {
        this.f1539c = context;
        this.f1540d = c0724g;
        this.f1542f = z;
        this.f1541e = new C0722f(c0724g, LayoutInflater.from(context), this.f1542f);
        this.f1544h = i;
        this.f1545i = i2;
        Resources resources = context.getResources();
        this.f1543g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0662d.abc_config_prefDialogWidth));
        this.f1548l = view;
        this.f1537a = new ad(this.f1539c, null, this.f1544h, this.f1545i);
        c0724g.m3018a((C0711m) this, context);
    }

    public void mo523a(boolean z) {
        this.f1541e.m2996a(z);
    }

    public void mo519a(int i) {
        this.f1554r = i;
    }

    private boolean m3109h() {
        if (mo528d()) {
            return true;
        }
        if (this.f1551o || this.f1548l == null) {
            return false;
        }
        this.f1538b = this.f1548l;
        this.f1537a.m4114a((OnDismissListener) this);
        this.f1537a.m4112a((OnItemClickListener) this);
        this.f1537a.m4115a(true);
        View view = this.f1538b;
        boolean z = this.f1550n == null;
        this.f1550n = view.getViewTreeObserver();
        if (z) {
            this.f1550n.addOnGlobalLayoutListener(this.f1546j);
        }
        this.f1537a.m4117b(view);
        this.f1537a.m4123e(this.f1554r);
        if (!this.f1552p) {
            this.f1553q = C0720k.m2952a(this.f1541e, null, this.f1539c, this.f1543g);
            this.f1552p = true;
        }
        this.f1537a.m4125g(this.f1553q);
        this.f1537a.m4128h(2);
        this.f1537a.m4110a(m2968g());
        this.f1537a.mo518a();
        ViewGroup e = this.f1537a.mo529e();
        e.setOnKeyListener(this);
        if (this.f1555s && this.f1540d.m3043l() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1539c).inflate(C0666h.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f1540d.m3043l());
            }
            frameLayout.setEnabled(false);
            e.addHeaderView(frameLayout, null, false);
        }
        this.f1537a.mo694a(this.f1541e);
        this.f1537a.mo518a();
        return true;
    }

    public void mo518a() {
        if (!m3109h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void mo525c() {
        if (mo528d()) {
            this.f1537a.mo525c();
        }
    }

    public void mo520a(C0724g c0724g) {
    }

    public boolean mo528d() {
        return !this.f1551o && this.f1537a.mo528d();
    }

    public void onDismiss() {
        this.f1551o = true;
        this.f1540d.close();
        if (this.f1550n != null) {
            if (!this.f1550n.isAlive()) {
                this.f1550n = this.f1538b.getViewTreeObserver();
            }
            this.f1550n.removeGlobalOnLayoutListener(this.f1546j);
            this.f1550n = null;
        }
        if (this.f1547k != null) {
            this.f1547k.onDismiss();
        }
    }

    public void mo513b(boolean z) {
        this.f1552p = false;
        if (this.f1541e != null) {
            this.f1541e.notifyDataSetChanged();
        }
    }

    public void mo510a(C0736a c0736a) {
        this.f1549m = c0736a;
    }

    public boolean mo512a(C0741s c0741s) {
        if (c0741s.hasVisibleItems()) {
            C0735l c0735l = new C0735l(this.f1539c, c0741s, this.f1538b, this.f1542f, this.f1544h, this.f1545i);
            c0735l.m3095a(this.f1549m);
            c0735l.m3098a(C0720k.m2954b((C0724g) c0741s));
            c0735l.m3097a(this.f1547k);
            this.f1547k = null;
            this.f1540d.m3021a(false);
            if (c0735l.m3099a(this.f1537a.m4131j(), this.f1537a.m4132k())) {
                if (this.f1549m != null) {
                    this.f1549m.mo560a(c0741s);
                }
                return true;
            }
        }
        return false;
    }

    public void mo509a(C0724g c0724g, boolean z) {
        if (c0724g == this.f1540d) {
            mo525c();
            if (this.f1549m != null) {
                this.f1549m.mo559a(c0724g, z);
            }
        }
    }

    public boolean mo514b() {
        return false;
    }

    public void mo521a(View view) {
        this.f1548l = view;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo525c();
        return true;
    }

    public void mo522a(OnDismissListener onDismissListener) {
        this.f1547k = onDismissListener;
    }

    public ListView mo529e() {
        return this.f1537a.mo529e();
    }

    public void mo524b(int i) {
        this.f1537a.m4119c(i);
    }

    public void mo526c(int i) {
        this.f1537a.m4120d(i);
    }

    public void mo527c(boolean z) {
        this.f1555s = z;
    }
}
