package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0709n;
import android.support.v7.view.menu.C0711m.C0736a;
import android.support.v7.view.menu.C0724g;
import android.support.v7.view.menu.C0724g.C0708b;
import android.support.v7.view.menu.C0724g.C0723a;
import android.support.v7.view.menu.C0726h;
import android.support.v7.widget.C0754z.C0750a;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends C0754z implements C0708b, C0709n {
    C0723a f1643a;
    C0753e f1644b;
    private C0724g f1645c;
    private Context f1646d;
    private int f1647e;
    private boolean f1648f;
    private C0858d f1649g;
    private C0736a f1650h;
    private boolean f1651i;
    private int f1652j;
    private int f1653k;
    private int f1654l;

    public interface C0707a {
        boolean mo493c();

        boolean mo494d();
    }

    private class C0749b implements C0736a {
        final /* synthetic */ ActionMenuView f1618a;

        C0749b(ActionMenuView actionMenuView) {
            this.f1618a = actionMenuView;
        }

        public void mo559a(C0724g c0724g, boolean z) {
        }

        public boolean mo560a(C0724g c0724g) {
            return false;
        }
    }

    public static class C0751c extends C0750a {
        @ExportedProperty
        public boolean f1621a;
        @ExportedProperty
        public int f1622b;
        @ExportedProperty
        public int f1623c;
        @ExportedProperty
        public boolean f1624d;
        @ExportedProperty
        public boolean f1625e;
        boolean f1626f;

        public C0751c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0751c(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0751c(C0751c c0751c) {
            super(c0751c);
            this.f1621a = c0751c.f1621a;
        }

        public C0751c(int i, int i2) {
            super(i, i2);
            this.f1621a = false;
        }
    }

    private class C0752d implements C0723a {
        final /* synthetic */ ActionMenuView f1627a;

        C0752d(ActionMenuView actionMenuView) {
            this.f1627a = actionMenuView;
        }

        public boolean mo562a(C0724g c0724g, MenuItem menuItem) {
            return this.f1627a.f1644b != null && this.f1627a.f1644b.mo639a(menuItem);
        }

        public void mo561a(C0724g c0724g) {
            if (this.f1627a.f1643a != null) {
                this.f1627a.f1643a.mo561a(c0724g);
            }
        }
    }

    public interface C0753e {
        boolean mo639a(MenuItem menuItem);
    }

    public /* synthetic */ C0750a mo563b(AttributeSet attributeSet) {
        return m3193a(attributeSet);
    }

    protected /* synthetic */ C0750a mo564b(LayoutParams layoutParams) {
        return m3194a(layoutParams);
    }

    protected /* synthetic */ C0750a mo566g() {
        return m3192a();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3192a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3193a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m3194a(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1653k = (int) (56.0f * f);
        this.f1654l = (int) (f * 4.0f);
        this.f1646d = context;
        this.f1647e = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f1647e != i) {
            this.f1647e = i;
            if (i == 0) {
                this.f1646d = getContext();
            } else {
                this.f1646d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1647e;
    }

    public void setPresenter(C0858d c0858d) {
        this.f1649g = c0858d;
        this.f1649g.m4386a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1649g != null) {
            this.f1649g.mo513b(false);
            if (this.f1649g.m4400h()) {
                this.f1649g.m4397e();
                this.f1649g.m4396d();
            }
        }
    }

    public void setOnMenuItemClickListener(C0753e c0753e) {
        this.f1644b = c0753e;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f1651i;
        this.f1651i = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1651i) {
            this.f1652j = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f1651i || this.f1645c == null || size == this.f1652j)) {
            this.f1652j = size;
            this.f1645c.m3028b(true);
        }
        int childCount = getChildCount();
        if (!this.f1651i || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0751c c0751c = (C0751c) getChildAt(i3).getLayoutParams();
                c0751c.rightMargin = 0;
                c0751c.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m3191c(i, i2);
    }

    private void m3191c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f1653k;
        size = i3 % this.f1653k;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i5;
        C0751c c0751c;
        Object obj;
        Object obj2;
        int i6 = this.f1653k + (size / i4);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        paddingLeft = 0;
        Object obj3 = null;
        long j = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            int i11;
            long j2;
            int i12;
            int i13;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i11 = paddingLeft;
                j2 = j;
                i12 = i7;
                i13 = i4;
                i4 = i8;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i5 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f1654l, 0, this.f1654l, 0);
                }
                c0751c = (C0751c) childAt.getLayoutParams();
                c0751c.f1626f = false;
                c0751c.f1623c = 0;
                c0751c.f1622b = 0;
                c0751c.f1624d = false;
                c0751c.leftMargin = 0;
                c0751c.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m2898b();
                c0751c.f1625e = z2;
                if (c0751c.f1621a) {
                    paddingLeft = 1;
                } else {
                    paddingLeft = i4;
                }
                int a = m3190a(childAt, i6, paddingLeft, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, a);
                if (c0751c.f1624d) {
                    paddingLeft = i9 + 1;
                } else {
                    paddingLeft = i9;
                }
                if (c0751c.f1621a) {
                    obj = 1;
                } else {
                    obj = obj3;
                }
                int i14 = i4 - a;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = paddingLeft;
                    obj3 = obj;
                    j2 = j3;
                    i4 = i8;
                    i11 = i5;
                } else {
                    i11 = i5;
                    i4 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj3 = obj;
                    i9 = paddingLeft;
                    j2 = j4;
                }
            }
            i10++;
            i8 = i4;
            i7 = i12;
            i4 = i13;
            j = j2;
            paddingLeft = i11;
        }
        if (obj3 == null || paddingLeft != 2) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i9 > 0 && paddingTop > 0) {
            i5 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                c0751c = (C0751c) getChildAt(i15).getLayoutParams();
                if (!c0751c.f1624d) {
                    size = i4;
                    i4 = i5;
                } else if (c0751c.f1622b < i5) {
                    i4 = c0751c.f1622b;
                    j = (long) (1 << i15);
                    size = 1;
                } else if (c0751c.f1622b == i5) {
                    j |= (long) (1 << i15);
                    size = i4 + 1;
                    i4 = i5;
                } else {
                    size = i4;
                    i4 = i5;
                }
                i15++;
                i5 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i5 + 1;
            i5 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                c0751c = (C0751c) childAt2.getLayoutParams();
                if ((((long) (1 << i5)) & j) != 0) {
                    if (obj2 != null && c0751c.f1625e && i4 == 1) {
                        childAt2.setPadding(this.f1654l + i6, 0, this.f1654l, 0);
                    }
                    c0751c.f1622b++;
                    c0751c.f1626f = true;
                    size = i4 - 1;
                } else if (c0751c.f1622b == i15) {
                    j6 |= (long) (1 << i5);
                    size = i4;
                } else {
                    size = i4;
                }
                i5++;
                i4 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj3 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i8 <= 1)) {
            obj2 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0751c) getChildAt(0).getLayoutParams()).f1625e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0751c) getChildAt(childCount - 1).getLayoutParams()).f1625e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i4 = 0;
                    obj2 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj2;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0751c = (C0751c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0751c.f1623c = paddingLeft;
                                c0751c.f1626f = true;
                                if (i4 == 0 && !c0751c.f1625e) {
                                    c0751c.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (c0751c.f1621a) {
                                if (i4 != 0) {
                                    c0751c.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0751c.rightMargin = paddingLeft / 2;
                                }
                                obj = obj2;
                            } else {
                                c0751c.f1623c = paddingLeft;
                                c0751c.f1626f = true;
                                c0751c.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj2 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj2 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0751c = (C0751c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0751c.f1623c = paddingLeft;
                        c0751c.f1626f = true;
                        c0751c.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (c0751c.f1621a) {
                        if (i4 != 0) {
                            c0751c.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0751c.rightMargin = paddingLeft / 2;
                        }
                        obj = obj2;
                    } else {
                        c0751c.f1623c = paddingLeft;
                        c0751c.f1626f = true;
                        c0751c.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj2;
                }
                i4++;
                obj2 = obj;
            }
        }
        if (obj2 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                c0751c = (C0751c) childAt.getLayoutParams();
                if (c0751c.f1626f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0751c.f1623c + (c0751c.f1622b * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i3, i7);
    }

    static int m3190a(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        C0751c c0751c = (C0751c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.m2898b()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0751c.f1621a && z) {
            z2 = true;
        }
        c0751c.f1624d = z2;
        c0751c.f1622b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1651i) {
            int i5;
            int i6;
            C0751c c0751c;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = aw.m4362a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    c0751c = (C0751c) childAt.getLayoutParams();
                    if (c0751c.f1621a) {
                        i6 = childAt.getMeasuredWidth();
                        if (m3197a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = c0751c.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - c0751c.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + c0751c.leftMargin) + c0751c.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (m3197a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    c0751c = (C0751c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (c0751c.f1621a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= c0751c.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((c0751c.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                c0751c = (C0751c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (c0751c.f1621a) {
                    paddingLeft = i6;
                } else {
                    i6 += c0751c.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((c0751c.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3205f();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1649g.m4383a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1649g.m4393c();
    }

    public void setOverflowReserved(boolean z) {
        this.f1648f = z;
    }

    protected C0751c m3192a() {
        C0751c c0751c = new C0751c(-2, -2);
        c0751c.h = 16;
        return c0751c;
    }

    public C0751c m3193a(AttributeSet attributeSet) {
        return new C0751c(getContext(), attributeSet);
    }

    protected C0751c m3194a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m3192a();
        }
        C0751c c0751c = layoutParams instanceof C0751c ? new C0751c((C0751c) layoutParams) : new C0751c(layoutParams);
        if (c0751c.h > 0) {
            return c0751c;
        }
        c0751c.h = 16;
        return c0751c;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0751c);
    }

    public C0751c m3199b() {
        C0751c a = m3192a();
        a.f1621a = true;
        return a;
    }

    public boolean mo496a(C0726h c0726h) {
        return this.f1645c.m3024a((MenuItem) c0726h, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void m3195a(C0724g c0724g) {
        this.f1645c = c0724g;
    }

    public Menu getMenu() {
        if (this.f1645c == null) {
            Context context = getContext();
            this.f1645c = new C0724g(context);
            this.f1645c.mo545a(new C0752d(this));
            this.f1649g = new C0858d(context);
            this.f1649g.m4394c(true);
            this.f1649g.mo510a(this.f1650h != null ? this.f1650h : new C0749b(this));
            this.f1645c.m3018a(this.f1649g, this.f1646d);
            this.f1649g.m4386a(this);
        }
        return this.f1645c;
    }

    public void m3196a(C0736a c0736a, C0723a c0723a) {
        this.f1650h = c0736a;
        this.f1643a = c0723a;
    }

    public C0724g m3202c() {
        return this.f1645c;
    }

    public boolean m3203d() {
        return this.f1649g != null && this.f1649g.m4396d();
    }

    public boolean m3204e() {
        return this.f1649g != null && this.f1649g.m4400h();
    }

    public void m3205f() {
        if (this.f1649g != null) {
            this.f1649g.m4398f();
        }
    }

    protected boolean m3197a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0707a)) {
            z = 0 | ((C0707a) childAt).mo494d();
        }
        return (i <= 0 || !(childAt2 instanceof C0707a)) ? z : ((C0707a) childAt2).mo493c() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1649g.m4395d(z);
    }
}
