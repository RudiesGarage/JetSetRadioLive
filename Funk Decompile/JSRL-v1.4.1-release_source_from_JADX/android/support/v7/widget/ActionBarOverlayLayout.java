package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0605w;
import android.support.v4.view.C0606x;
import android.support.v4.view.ae;
import android.support.v4.view.aq;
import android.support.v4.view.at;
import android.support.v4.view.au;
import android.support.v4.widget.C0639p;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0664f;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements C0605w {
    static final int[] f1590e = new int[]{C0659a.actionBarSize, 16842841};
    private final Runnable f1591A;
    private final C0606x f1592B;
    ActionBarContainer f1593a;
    boolean f1594b;
    aq f1595c;
    final at f1596d;
    private int f1597f;
    private int f1598g;
    private ContentFrameLayout f1599h;
    private C0846s f1600i;
    private Drawable f1601j;
    private boolean f1602k;
    private boolean f1603l;
    private boolean f1604m;
    private boolean f1605n;
    private int f1606o;
    private int f1607p;
    private final Rect f1608q;
    private final Rect f1609r;
    private final Rect f1610s;
    private final Rect f1611t;
    private final Rect f1612u;
    private final Rect f1613v;
    private C0747a f1614w;
    private final int f1615x;
    private C0639p f1616y;
    private final Runnable f1617z;

    class C07441 extends au {
        final /* synthetic */ ActionBarOverlayLayout f1587a;

        C07441(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1587a = actionBarOverlayLayout;
        }

        public void mo419b(View view) {
            this.f1587a.f1595c = null;
            this.f1587a.f1594b = false;
        }

        public void mo420c(View view) {
            this.f1587a.f1595c = null;
            this.f1587a.f1594b = false;
        }
    }

    class C07452 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1588a;

        C07452(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1588a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1588a.m3163c();
            this.f1588a.f1595c = ae.m2235o(this.f1588a.f1593a).m2374c(0.0f).m2370a(this.f1588a.f1596d);
        }
    }

    class C07463 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1589a;

        C07463(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1589a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1589a.m3163c();
            this.f1589a.f1595c = ae.m2235o(this.f1589a.f1593a).m2374c((float) (-this.f1589a.f1593a.getHeight())).m2370a(this.f1589a.f1596d);
        }
    }

    public interface C0747a {
        void m3146a();

        void m3147a(int i);

        void m3148a(boolean z);

        void m3149b();

        void m3150c();

        void m3151d();
    }

    public static class C0748b extends MarginLayoutParams {
        public C0748b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0748b(int i, int i2) {
            super(i, i2);
        }

        public C0748b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3160a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3161a(attributeSet);
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1598g = 0;
        this.f1608q = new Rect();
        this.f1609r = new Rect();
        this.f1610s = new Rect();
        this.f1611t = new Rect();
        this.f1612u = new Rect();
        this.f1613v = new Rect();
        this.f1615x = 600;
        this.f1596d = new C07441(this);
        this.f1617z = new C07452(this);
        this.f1591A = new C07463(this);
        m3153a(context);
        this.f1592B = new C0606x(this);
    }

    private void m3153a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1590e);
        this.f1597f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1601j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1601j == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1602k = z;
        this.f1616y = C0639p.m2683a(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3163c();
    }

    public void setActionBarVisibilityCallback(C0747a c0747a) {
        this.f1614w = c0747a;
        if (getWindowToken() != null) {
            this.f1614w.m3147a(this.f1598g);
            if (this.f1607p != 0) {
                onWindowSystemUiVisibilityChanged(this.f1607p);
                ae.m2237q(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f1603l = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f1602k = z2;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1604m = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3153a(getContext());
        ae.m2237q(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m3162b();
        int i2 = this.f1607p ^ i;
        this.f1607p = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1614w != null) {
            C0747a c0747a = this.f1614w;
            if (z) {
                z2 = false;
            }
            c0747a.m3148a(z2);
            if (z3 || !z) {
                this.f1614w.m3146a();
            } else {
                this.f1614w.m3149b();
            }
        }
        if ((i2 & 256) != 0 && this.f1614w != null) {
            ae.m2237q(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1598g = i;
        if (this.f1614w != null) {
            this.f1614w.m3147a(i);
        }
    }

    private boolean m3155a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0748b c0748b = (C0748b) view.getLayoutParams();
        if (z && c0748b.leftMargin != rect.left) {
            c0748b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0748b.topMargin != rect.top) {
            c0748b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0748b.rightMargin != rect.right) {
            c0748b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0748b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0748b.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        m3162b();
        if ((ae.m2236p(this) & 256) != 0) {
            a = m3155a(this.f1593a, rect, true, true, false, true);
            this.f1611t.set(rect);
            aw.m4361a(this, this.f1611t, this.f1608q);
        } else {
            a = m3155a(this.f1593a, rect, true, true, false, true);
            this.f1611t.set(rect);
            aw.m4361a(this, this.f1611t, this.f1608q);
        }
        if (!this.f1609r.equals(this.f1608q)) {
            this.f1609r.set(this.f1608q);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected C0748b m3160a() {
        return new C0748b(-1, -1);
    }

    public C0748b m3161a(AttributeSet attributeSet) {
        return new C0748b(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0748b(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0748b;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int i3;
        m3162b();
        measureChildWithMargins(this.f1593a, i, 0, i2, 0);
        C0748b c0748b = (C0748b) this.f1593a.getLayoutParams();
        int max = Math.max(0, (this.f1593a.getMeasuredWidth() + c0748b.leftMargin) + c0748b.rightMargin);
        int max2 = Math.max(0, c0748b.bottomMargin + (this.f1593a.getMeasuredHeight() + c0748b.topMargin));
        int a = aw.m4360a(0, ae.m2230j(this.f1593a));
        if ((ae.m2236p(this) & 256) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i3 = this.f1597f;
            if (this.f1604m && this.f1593a.getTabContainer() != null) {
                i3 += this.f1597f;
            }
        } else {
            i3 = this.f1593a.getVisibility() != 8 ? this.f1593a.getMeasuredHeight() : 0;
        }
        this.f1610s.set(this.f1608q);
        this.f1612u.set(this.f1611t);
        Rect rect;
        Rect rect2;
        if (this.f1603l || obj != null) {
            rect = this.f1612u;
            rect.top = i3 + rect.top;
            rect2 = this.f1612u;
            rect2.bottom += 0;
        } else {
            rect = this.f1610s;
            rect.top = i3 + rect.top;
            rect2 = this.f1610s;
            rect2.bottom += 0;
        }
        m3155a(this.f1599h, this.f1610s, true, true, true, true);
        if (!this.f1613v.equals(this.f1612u)) {
            this.f1613v.set(this.f1612u);
            this.f1599h.m3224a(this.f1612u);
        }
        measureChildWithMargins(this.f1599h, i, 0, i2, 0);
        c0748b = (C0748b) this.f1599h.getLayoutParams();
        int max3 = Math.max(max, (this.f1599h.getMeasuredWidth() + c0748b.leftMargin) + c0748b.rightMargin);
        i3 = Math.max(max2, c0748b.bottomMargin + (this.f1599h.getMeasuredHeight() + c0748b.topMargin));
        int a2 = aw.m4360a(a, ae.m2230j(this.f1599h));
        setMeasuredDimension(ae.m2202a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), ae.m2202a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0748b c0748b = (C0748b) childAt.getLayoutParams();
                int i6 = c0748b.leftMargin + paddingLeft;
                paddingRight = c0748b.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1601j != null && !this.f1602k) {
            int bottom = this.f1593a.getVisibility() == 0 ? (int) ((((float) this.f1593a.getBottom()) + ae.m2232l(this.f1593a)) + 0.5f) : 0;
            this.f1601j.setBounds(0, bottom, getWidth(), this.f1601j.getIntrinsicHeight() + bottom);
            this.f1601j.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1593a.getVisibility() != 0) {
            return false;
        }
        return this.f1605n;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1592B.m2528a(view, view2, i);
        this.f1606o = getActionBarHideOffset();
        m3163c();
        if (this.f1614w != null) {
            this.f1614w.m3150c();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1606o += i2;
        setActionBarHideOffset(this.f1606o);
    }

    public void onStopNestedScroll(View view) {
        if (this.f1605n && !this.f1594b) {
            if (this.f1606o <= this.f1593a.getHeight()) {
                m3156d();
            } else {
                m3157e();
            }
        }
        if (this.f1614w != null) {
            this.f1614w.m3151d();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1605n || !z) {
            return false;
        }
        if (m3154a(f, f2)) {
            m3159g();
        } else {
            m3158f();
        }
        this.f1594b = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f1592B.m2526a();
    }

    void m3162b() {
        if (this.f1599h == null) {
            this.f1599h = (ContentFrameLayout) findViewById(C0664f.action_bar_activity_content);
            this.f1593a = (ActionBarContainer) findViewById(C0664f.action_bar_container);
            this.f1600i = m3152a(findViewById(C0664f.action_bar));
        }
    }

    private C0846s m3152a(View view) {
        if (view instanceof C0846s) {
            return (C0846s) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1605n) {
            this.f1605n = z;
            if (!z) {
                m3163c();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.f1593a != null ? -((int) ae.m2232l(this.f1593a)) : 0;
    }

    public void setActionBarHideOffset(int i) {
        m3163c();
        ae.m2217b(this.f1593a, (float) (-Math.max(0, Math.min(i, this.f1593a.getHeight()))));
    }

    void m3163c() {
        removeCallbacks(this.f1617z);
        removeCallbacks(this.f1591A);
        if (this.f1595c != null) {
            this.f1595c.m2371a();
        }
    }

    private void m3156d() {
        m3163c();
        postDelayed(this.f1617z, 600);
    }

    private void m3157e() {
        m3163c();
        postDelayed(this.f1591A, 600);
    }

    private void m3158f() {
        m3163c();
        this.f1617z.run();
    }

    private void m3159g() {
        m3163c();
        this.f1591A.run();
    }

    private boolean m3154a(float f, float f2) {
        this.f1616y.m2687a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f1616y.m2694e() > this.f1593a.getHeight()) {
            return true;
        }
        return false;
    }

    public void setWindowCallback(Callback callback) {
        m3162b();
        this.f1600i.mo679a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m3162b();
        this.f1600i.mo680a(charSequence);
    }

    public CharSequence getTitle() {
        m3162b();
        return this.f1600i.mo676a();
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        m3162b();
        this.f1600i.mo677a(i);
    }

    public void setIcon(Drawable drawable) {
        m3162b();
        this.f1600i.mo678a(drawable);
    }

    public void setLogo(int i) {
        m3162b();
        this.f1600i.mo681b(i);
    }
}
