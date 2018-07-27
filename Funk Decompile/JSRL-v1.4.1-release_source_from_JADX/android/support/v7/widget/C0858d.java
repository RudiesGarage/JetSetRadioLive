package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p015c.p016a.C0302a;
import android.support.v4.view.C0563d;
import android.support.v4.view.C0563d.C0561a;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0666h;
import android.support.v7.p034g.C0679a;
import android.support.v7.view.C0696a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.C0704b;
import android.support.v7.view.menu.C0709n.C0706a;
import android.support.v7.view.menu.C0711m.C0736a;
import android.support.v7.view.menu.C0712b;
import android.support.v7.view.menu.C0719q;
import android.support.v7.view.menu.C0724g;
import android.support.v7.view.menu.C0726h;
import android.support.v7.view.menu.C0735l;
import android.support.v7.view.menu.C0741s;
import android.support.v7.widget.ActionMenuView.C0707a;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

/* compiled from: ActionMenuPresenter */
class C0858d extends C0712b implements C0561a {
    private C0851b f2279A;
    C0855d f2280g;
    C0856e f2281h;
    C0850a f2282i;
    C0852c f2283j;
    final C0857f f2284k = new C0857f(this);
    int f2285l;
    private Drawable f2286m;
    private boolean f2287n;
    private boolean f2288o;
    private boolean f2289p;
    private int f2290q;
    private int f2291r;
    private int f2292s;
    private boolean f2293t;
    private boolean f2294u;
    private boolean f2295v;
    private boolean f2296w;
    private int f2297x;
    private final SparseBooleanArray f2298y = new SparseBooleanArray();
    private View f2299z;

    /* compiled from: ActionMenuPresenter */
    private class C0850a extends C0735l {
        final /* synthetic */ C0858d f2267a;

        public C0850a(C0858d c0858d, Context context, C0741s c0741s, View view) {
            this.f2267a = c0858d;
            super(context, c0741s, view, false, C0659a.actionOverflowMenuStyle);
            if (!((C0726h) c0741s.getItem()).m3070j()) {
                m3096a(c0858d.f2280g == null ? (View) c0858d.f : c0858d.f2280g);
            }
            m3095a(c0858d.f2284k);
        }

        protected void mo682e() {
            this.f2267a.f2282i = null;
            this.f2267a.f2285l = 0;
            super.mo682e();
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class C0851b extends C0704b {
        final /* synthetic */ C0858d f2268a;

        C0851b(C0858d c0858d) {
            this.f2268a = c0858d;
        }

        public C0719q mo683a() {
            return this.f2268a.f2282i != null ? this.f2268a.f2282i.m3100b() : null;
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class C0852c implements Runnable {
        final /* synthetic */ C0858d f2269a;
        private C0856e f2270b;

        public C0852c(C0858d c0858d, C0856e c0856e) {
            this.f2269a = c0858d;
            this.f2270b = c0856e;
        }

        public void run() {
            if (this.f2269a.c != null) {
                this.f2269a.c.m3036e();
            }
            View view = (View) this.f2269a.f;
            if (!(view == null || view.getWindowToken() == null || !this.f2270b.m3101c())) {
                this.f2269a.f2281h = this.f2270b;
            }
            this.f2269a.f2283j = null;
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class C0855d extends C0854l implements C0707a {
        final /* synthetic */ C0858d f2275a;
        private final float[] f2276b = new float[2];

        public C0855d(final C0858d c0858d, Context context) {
            this.f2275a = c0858d;
            super(context, null, C0659a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new C0702x(this, this) {
                final /* synthetic */ C0855d f2272b;

                public C0719q mo485a() {
                    if (this.f2272b.f2275a.f2281h == null) {
                        return null;
                    }
                    return this.f2272b.f2275a.f2281h.m3100b();
                }

                public boolean mo486b() {
                    this.f2272b.f2275a.m4396d();
                    return true;
                }

                public boolean mo684c() {
                    if (this.f2272b.f2275a.f2283j != null) {
                        return false;
                    }
                    this.f2272b.f2275a.m4397e();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.f2275a.m4396d();
            }
            return true;
        }

        public boolean mo493c() {
            return false;
        }

        public boolean mo494d() {
            return false;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0302a.m1140a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class C0856e extends C0735l {
        final /* synthetic */ C0858d f2277a;

        public C0856e(C0858d c0858d, Context context, C0724g c0724g, View view, boolean z) {
            this.f2277a = c0858d;
            super(context, c0724g, view, z, C0659a.actionOverflowMenuStyle);
            m3094a(8388613);
            m3095a(c0858d.f2284k);
        }

        protected void mo682e() {
            if (this.f2277a.c != null) {
                this.f2277a.c.close();
            }
            this.f2277a.f2281h = null;
            super.mo682e();
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class C0857f implements C0736a {
        final /* synthetic */ C0858d f2278a;

        C0857f(C0858d c0858d) {
            this.f2278a = c0858d;
        }

        public boolean mo560a(C0724g c0724g) {
            if (c0724g == null) {
                return false;
            }
            this.f2278a.f2285l = ((C0741s) c0724g).getItem().getItemId();
            C0736a a = this.f2278a.m2923a();
            return a != null ? a.mo560a(c0724g) : false;
        }

        public void mo559a(C0724g c0724g, boolean z) {
            if (c0724g instanceof C0741s) {
                c0724g.mo551m().m3021a(false);
            }
            C0736a a = this.f2278a.m2923a();
            if (a != null) {
                a.mo559a(c0724g, z);
            }
        }
    }

    public C0858d(Context context) {
        super(context, C0666h.abc_action_menu_layout, C0666h.abc_action_menu_item_layout);
    }

    public void mo508a(Context context, C0724g c0724g) {
        super.mo508a(context, c0724g);
        Resources resources = context.getResources();
        C0696a a = C0696a.m2850a(context);
        if (!this.f2289p) {
            this.f2288o = a.m2852b();
        }
        if (!this.f2295v) {
            this.f2290q = a.m2853c();
        }
        if (!this.f2293t) {
            this.f2292s = a.m2851a();
        }
        int i = this.f2290q;
        if (this.f2288o) {
            if (this.f2280g == null) {
                this.f2280g = new C0855d(this, this.a);
                if (this.f2287n) {
                    this.f2280g.setImageDrawable(this.f2286m);
                    this.f2286m = null;
                    this.f2287n = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f2280g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f2280g.getMeasuredWidth();
        } else {
            this.f2280g = null;
        }
        this.f2291r = i;
        this.f2297x = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f2299z = null;
    }

    public void m4382a(Configuration configuration) {
        if (!this.f2293t) {
            this.f2292s = C0696a.m2850a(this.b).m2851a();
        }
        if (this.c != null) {
            this.c.m3028b(true);
        }
    }

    public void m4394c(boolean z) {
        this.f2288o = z;
        this.f2289p = true;
    }

    public void m4395d(boolean z) {
        this.f2296w = z;
    }

    public void m4383a(Drawable drawable) {
        if (this.f2280g != null) {
            this.f2280g.setImageDrawable(drawable);
            return;
        }
        this.f2287n = true;
        this.f2286m = drawable;
    }

    public Drawable m4393c() {
        if (this.f2280g != null) {
            return this.f2280g.getDrawable();
        }
        if (this.f2287n) {
            return this.f2286m;
        }
        return null;
    }

    public View mo685a(C0726h c0726h, View view, ViewGroup viewGroup) {
        View actionView = c0726h.getActionView();
        if (actionView == null || c0726h.m3074n()) {
            actionView = super.mo685a(c0726h, view, viewGroup);
        }
        actionView.setVisibility(c0726h.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m3194a(layoutParams));
        }
        return actionView;
    }

    public void mo686a(C0726h c0726h, C0706a c0706a) {
        c0706a.mo491a(c0726h, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0706a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f2279A == null) {
            this.f2279A = new C0851b(this);
        }
        actionMenuItemView.setPopupCallback(this.f2279A);
    }

    public boolean mo688a(int i, C0726h c0726h) {
        return c0726h.m3070j();
    }

    public void mo513b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            C0679a.m2777a(viewGroup);
        }
        super.mo513b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList j = this.c.m3041j();
            int size = j.size();
            for (i = 0; i < size; i++) {
                C0563d a = ((C0726h) j.get(i)).mo499a();
                if (a != null) {
                    a.m2434a((C0561a) this);
                }
            }
        }
        ArrayList k = this.c != null ? this.c.m3042k() : null;
        if (this.f2288o && k != null) {
            i = k.size();
            if (i == 1) {
                int i4;
                if (((C0726h) k.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f2280g == null) {
                this.f2280g = new C0855d(this, this.a);
            }
            viewGroup = (ViewGroup) this.f2280g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2280g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f2280g, actionMenuView.m3199b());
            }
        } else if (this.f2280g != null && this.f2280g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f2280g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f2288o);
    }

    public boolean mo689a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f2280g) {
            return false;
        }
        return super.mo689a(viewGroup, i);
    }

    public boolean mo512a(C0741s c0741s) {
        if (!c0741s.hasVisibleItems()) {
            return false;
        }
        C0741s c0741s2 = c0741s;
        while (c0741s2.m3134p() != this.c) {
            c0741s2 = (C0741s) c0741s2.m3134p();
        }
        View a = m4374a(c0741s2.getItem());
        if (a == null) {
            return false;
        }
        boolean z;
        this.f2285l = c0741s.getItem().getItemId();
        int size = c0741s.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0741s.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        z = false;
        this.f2282i = new C0850a(this, this.b, c0741s, a);
        this.f2282i.m3098a(z);
        this.f2282i.m3093a();
        super.mo512a(c0741s);
        return true;
    }

    private View m4374a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0706a) && ((C0706a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean m4396d() {
        if (!this.f2288o || m4400h() || this.c == null || this.f == null || this.f2283j != null || this.c.m3042k().isEmpty()) {
            return false;
        }
        this.f2283j = new C0852c(this, new C0856e(this, this.b, this.c, this.f2280g, true));
        ((View) this.f).post(this.f2283j);
        super.mo512a(null);
        return true;
    }

    public boolean m4397e() {
        if (this.f2283j == null || this.f == null) {
            C0735l c0735l = this.f2281h;
            if (c0735l == null) {
                return false;
            }
            c0735l.m3102d();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f2283j);
        this.f2283j = null;
        return true;
    }

    public boolean m4398f() {
        return m4397e() | m4399g();
    }

    public boolean m4399g() {
        if (this.f2282i == null) {
            return false;
        }
        this.f2282i.m3102d();
        return true;
    }

    public boolean m4400h() {
        return this.f2281h != null && this.f2281h.m3104f();
    }

    public boolean mo514b() {
        int size;
        ArrayList arrayList;
        int i;
        if (this.c != null) {
            ArrayList h = this.c.m3039h();
            size = h.size();
            arrayList = h;
        } else {
            size = 0;
            arrayList = null;
        }
        int i2 = this.f2292s;
        int i3 = this.f2291r;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            C0726h c0726h = (C0726h) arrayList.get(i6);
            if (c0726h.m3072l()) {
                i4++;
            } else if (c0726h.m3071k()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.f2296w && c0726h.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i2;
            }
            i6++;
            i2 = i;
        }
        if (this.f2288o && (r4 != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.f2298y;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f2294u) {
            i = i3 / this.f2297x;
            i5 = ((i3 % this.f2297x) / i) + this.f2297x;
        } else {
            i5 = 0;
        }
        int i7 = 0;
        i2 = 0;
        int i8 = i;
        while (i7 < size) {
            c0726h = (C0726h) arrayList.get(i7);
            int i9;
            if (c0726h.m3072l()) {
                View a = mo685a(c0726h, this.f2299z, viewGroup);
                if (this.f2299z == null) {
                    this.f2299z = a;
                }
                if (this.f2294u) {
                    i8 -= ActionMenuView.m3190a(a, i5, i8, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = c0726h.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                c0726h.m3063d(true);
                i = i9;
                i2 = i6;
            } else if (c0726h.m3071k()) {
                boolean z;
                int groupId = c0726h.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.f2294u || i8 > 0);
                if (z3) {
                    View a2 = mo685a(c0726h, this.f2299z, viewGroup);
                    if (this.f2299z == null) {
                        this.f2299z = a2;
                    }
                    boolean z4;
                    if (this.f2294u) {
                        int a3 = ActionMenuView.m3190a(a2, i5, i8, makeMeasureSpec, 0);
                        i9 = i8 - a3;
                        if (a3 == 0) {
                            i8 = 0;
                        } else {
                            z4 = z3;
                        }
                        i4 = i9;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i4 = i8;
                        z4 = z5;
                    }
                    i9 = a2.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.f2294u) {
                        z = i8 & (i3 >= 0 ? 1 : 0);
                        i9 = i2;
                        i2 = i4;
                    } else {
                        z = i8 & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i2;
                        i2 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i2;
                    i2 = i8;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i8 = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (i6 = 0; i6 < i7; i6++) {
                        C0726h c0726h2 = (C0726h) arrayList.get(i6);
                        if (c0726h2.getGroupId() == groupId) {
                            if (c0726h2.m3070j()) {
                                i4++;
                            }
                            c0726h2.m3063d(false);
                        }
                    }
                    i8 = i4;
                } else {
                    i8 = i6;
                }
                if (z) {
                    i8--;
                }
                c0726h.m3063d(z);
                i4 = i9;
                i = i3;
                int i10 = i2;
                i2 = i8;
                i8 = i10;
            } else {
                c0726h.m3063d(false);
                i4 = i2;
                i = i3;
                i2 = i6;
            }
            i7++;
            i3 = i;
            i6 = i2;
            i2 = i4;
        }
        return true;
    }

    public void mo509a(C0724g c0724g, boolean z) {
        m4398f();
        super.mo509a(c0724g, z);
    }

    public void mo687a(boolean z) {
        if (z) {
            super.mo512a(null);
        } else if (this.c != null) {
            this.c.m3021a(false);
        }
    }

    public void m4386a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.m3195a(this.c);
    }
}
