package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0567e;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0669k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: LinearLayoutCompat */
public class C0754z extends ViewGroup {
    private boolean f1628a;
    private int f1629b;
    private int f1630c;
    private int f1631d;
    private int f1632e;
    private int f1633f;
    private float f1634g;
    private boolean f1635h;
    private int[] f1636i;
    private int[] f1637j;
    private Drawable f1638k;
    private int f1639l;
    private int f1640m;
    private int f1641n;
    private int f1642o;

    /* compiled from: LinearLayoutCompat */
    public static class C0750a extends MarginLayoutParams {
        public float f1619g;
        public int f1620h;

        public C0750a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1620h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0669k.LinearLayoutCompat_Layout);
            this.f1619g = obtainStyledAttributes.getFloat(C0669k.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1620h = obtainStyledAttributes.getInt(C0669k.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public C0750a(int i, int i2) {
            super(i, i2);
            this.f1620h = -1;
            this.f1619g = 0.0f;
        }

        public C0750a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1620h = -1;
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return mo566g();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return mo563b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return mo564b(layoutParams);
    }

    public C0754z(Context context) {
        this(context, null);
    }

    public C0754z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0754z(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1628a = true;
        this.f1629b = -1;
        this.f1630c = 0;
        this.f1632e = 8388659;
        as a = as.m4294a(context, attributeSet, C0669k.LinearLayoutCompat, i, 0);
        int a2 = a.m4296a(C0669k.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m4296a(C0669k.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m4299a(C0669k.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.f1634g = a.m4295a(C0669k.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1629b = a.m4296a(C0669k.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1635h = a.m4299a(C0669k.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.m4297a(C0669k.LinearLayoutCompat_divider));
        this.f1641n = a.m4296a(C0669k.LinearLayoutCompat_showDividers, 0);
        this.f1642o = a.m4306e(C0669k.LinearLayoutCompat_dividerPadding, 0);
        a.m4298a();
    }

    public void setShowDividers(int i) {
        if (i != this.f1641n) {
            requestLayout();
        }
        this.f1641n = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.f1641n;
    }

    public Drawable getDividerDrawable() {
        return this.f1638k;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f1638k) {
            this.f1638k = drawable;
            if (drawable != null) {
                this.f1639l = drawable.getIntrinsicWidth();
                this.f1640m = drawable.getIntrinsicHeight();
            } else {
                this.f1639l = 0;
                this.f1640m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f1642o = i;
    }

    public int getDividerPadding() {
        return this.f1642o;
    }

    public int getDividerWidth() {
        return this.f1639l;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f1638k != null) {
            if (this.f1631d == 1) {
                m3176a(canvas);
            } else {
                m3185b(canvas);
            }
        }
    }

    void m3176a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m3182b(i);
            if (!(b == null || b.getVisibility() == 8 || !m3187c(i))) {
                m3177a(canvas, (b.getTop() - ((C0750a) b.getLayoutParams()).topMargin) - this.f1640m);
            }
            i++;
        }
        if (m3187c(virtualChildCount)) {
            int height;
            View b2 = m3182b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f1640m;
            } else {
                C0750a c0750a = (C0750a) b2.getLayoutParams();
                height = c0750a.bottomMargin + b2.getBottom();
            }
            m3177a(canvas, height);
        }
    }

    void m3185b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = aw.m4362a(this);
        int i = 0;
        while (i < virtualChildCount) {
            C0750a c0750a;
            int right;
            View b = m3182b(i);
            if (!(b == null || b.getVisibility() == 8 || !m3187c(i))) {
                c0750a = (C0750a) b.getLayoutParams();
                if (a) {
                    right = c0750a.rightMargin + b.getRight();
                } else {
                    right = (b.getLeft() - c0750a.leftMargin) - this.f1639l;
                }
                m3186b(canvas, right);
            }
            i++;
        }
        if (m3187c(virtualChildCount)) {
            View b2 = m3182b(virtualChildCount - 1);
            if (b2 != null) {
                c0750a = (C0750a) b2.getLayoutParams();
                if (a) {
                    right = (b2.getLeft() - c0750a.leftMargin) - this.f1639l;
                } else {
                    right = c0750a.rightMargin + b2.getRight();
                }
            } else if (a) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.f1639l;
            }
            m3186b(canvas, right);
        }
    }

    void m3177a(Canvas canvas, int i) {
        this.f1638k.setBounds(getPaddingLeft() + this.f1642o, i, (getWidth() - getPaddingRight()) - this.f1642o, this.f1640m + i);
        this.f1638k.draw(canvas);
    }

    void m3186b(Canvas canvas, int i) {
        this.f1638k.setBounds(i, getPaddingTop() + this.f1642o, this.f1639l + i, (getHeight() - getPaddingBottom()) - this.f1642o);
        this.f1638k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f1628a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1635h = z;
    }

    public int getBaseline() {
        if (this.f1629b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f1629b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f1629b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.f1630c;
            if (this.f1631d == 1) {
                i = this.f1632e & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1633f) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1633f;
                            break;
                    }
                }
            }
            i = i2;
            return (((C0750a) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.f1629b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1629b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1629b = i;
    }

    View m3182b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1634g;
    }

    public void setWeightSum(float f) {
        this.f1634g = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1631d == 1) {
            m3174a(i, i2);
        } else {
            m3183b(i, i2);
        }
    }

    protected boolean m3187c(int i) {
        if (i == 0) {
            if ((this.f1641n & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.f1641n & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f1641n & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    void m3174a(int i, int i2) {
        int i3;
        int i4;
        View b;
        this.f1633f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        int i9 = this.f1629b;
        boolean z = this.f1635h;
        int i10 = Integer.MIN_VALUE;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            Object obj4;
            Object obj5;
            int i12;
            int i13;
            View b2 = m3182b(i11);
            if (b2 == null) {
                this.f1633f += m3188d(i11);
                i3 = i10;
                obj4 = obj3;
                obj5 = obj;
                i12 = i6;
                i13 = i5;
            } else if (b2.getVisibility() == 8) {
                i11 += m3173a(b2, i11);
                i3 = i10;
                obj4 = obj3;
                obj5 = obj;
                i12 = i6;
                i13 = i5;
            } else {
                if (m3187c(i11)) {
                    this.f1633f += this.f1640m;
                }
                C0750a c0750a = (C0750a) b2.getLayoutParams();
                float f2 = f + c0750a.f1619g;
                if (mode2 == 1073741824 && c0750a.height == 0 && c0750a.f1619g > 0.0f) {
                    i3 = this.f1633f;
                    this.f1633f = Math.max(i3, (c0750a.topMargin + i3) + c0750a.bottomMargin);
                    obj3 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0750a.height == 0 && c0750a.f1619g > 0.0f) {
                        i3 = 0;
                        c0750a.height = -2;
                    }
                    int i14 = i3;
                    m3178a(b2, i11, i, 0, i2, f2 == 0.0f ? this.f1633f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        c0750a.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f1633f;
                    this.f1633f = Math.max(i15, (((i15 + i3) + c0750a.topMargin) + c0750a.bottomMargin) + m3179b(b2));
                    if (z) {
                        i10 = Math.max(i3, i10);
                    }
                }
                if (i9 >= 0 && i9 == i11 + 1) {
                    this.f1630c = this.f1633f;
                }
                if (i11 >= i9 || c0750a.f1619g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || c0750a.width != -1) {
                        obj6 = obj2;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i12 = c0750a.rightMargin + c0750a.leftMargin;
                    i13 = b2.getMeasuredWidth() + i12;
                    i5 = Math.max(i5, i13);
                    int a = aw.m4360a(i6, ae.m2230j(b2));
                    obj5 = (obj == null || c0750a.width != -1) ? null : 1;
                    if (c0750a.f1619g > 0.0f) {
                        if (obj7 != null) {
                            i3 = i12;
                        } else {
                            i3 = i13;
                        }
                        i3 = Math.max(i8, i3);
                        i12 = i7;
                    } else {
                        if (obj7 == null) {
                            i12 = i13;
                        }
                        i12 = Math.max(i7, i12);
                        i3 = i8;
                    }
                    i11 += m3173a(b2, i11);
                    obj4 = obj3;
                    i8 = i3;
                    i7 = i12;
                    i13 = i5;
                    i3 = i10;
                    i12 = a;
                    obj2 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i11++;
            i10 = i3;
            obj3 = obj4;
            obj = obj5;
            i6 = i12;
            i5 = i13;
        }
        if (this.f1633f > 0 && m3187c(virtualChildCount)) {
            this.f1633f += this.f1640m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f1633f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                b = m3182b(i4);
                if (b == null) {
                    this.f1633f += m3188d(i4);
                    i3 = i4;
                } else if (b.getVisibility() == 8) {
                    i3 = m3173a(b, i4) + i4;
                } else {
                    C0750a c0750a2 = (C0750a) b.getLayoutParams();
                    int i16 = this.f1633f;
                    this.f1633f = Math.max(i16, (c0750a2.bottomMargin + ((i16 + i10) + c0750a2.topMargin)) + m3179b(b));
                    i3 = i4;
                }
                i4 = i3 + 1;
            }
        }
        this.f1633f += getPaddingTop() + getPaddingBottom();
        int a2 = ae.m2202a(Math.max(this.f1633f, getSuggestedMinimumHeight()), i2, 0);
        i4 = (16777215 & a2) - this.f1633f;
        int i17;
        if (obj3 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f1634g > 0.0f) {
                f = this.f1634g;
            }
            this.f1633f = 0;
            i10 = 0;
            float f3 = f;
            Object obj8 = obj;
            i17 = i7;
            i16 = i6;
            i8 = i5;
            i15 = i4;
            while (i10 < virtualChildCount) {
                View b3 = m3182b(i10);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i4 = i16;
                    i12 = i8;
                    obj5 = obj8;
                } else {
                    float f4;
                    float f5;
                    c0750a2 = (C0750a) b3.getLayoutParams();
                    float f6 = c0750a2.f1619g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i4;
                        i12 = C0754z.getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + c0750a2.leftMargin) + c0750a2.rightMargin, c0750a2.width);
                        if (c0750a2.height == 0 && mode2 == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        } else {
                            i4 += b3.getMeasuredHeight();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        }
                        f4 = f3;
                        i11 = i15;
                        i15 = aw.m4360a(i16, ae.m2230j(b3) & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i11 = i15;
                        i15 = i16;
                    }
                    i16 = c0750a2.leftMargin + c0750a2.rightMargin;
                    i12 = b3.getMeasuredWidth() + i16;
                    i8 = Math.max(i8, i12);
                    Object obj9 = (mode == 1073741824 || c0750a2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i12;
                    }
                    i12 = Math.max(i17, i16);
                    obj5 = (obj8 == null || c0750a2.width != -1) ? null : 1;
                    i13 = this.f1633f;
                    this.f1633f = Math.max(i13, (c0750a2.bottomMargin + ((b3.getMeasuredHeight() + i13) + c0750a2.topMargin)) + m3179b(b3));
                    i3 = i12;
                    i12 = i8;
                    f4 = f5;
                    i4 = i15;
                    i15 = i11;
                    f3 = f4;
                }
                i10++;
                i17 = i3;
                i8 = i12;
                obj8 = obj5;
                i16 = i4;
            }
            this.f1633f += getPaddingTop() + getPaddingBottom();
            obj = obj8;
            i3 = i17;
            i6 = i16;
            i4 = i8;
        } else {
            i17 = Math.max(i7, i8);
            if (z && mode2 != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    b = m3182b(i4);
                    if (!(b == null || b.getVisibility() == 8 || ((C0750a) b.getLayoutParams()).f1619g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i10, 1073741824));
                    }
                }
            }
            i3 = i17;
            i4 = i5;
        }
        if (obj != null || mode == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(ae.m2202a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i6), a2);
        if (obj2 != null) {
            m3170c(virtualChildCount, i2);
        }
    }

    private void m3170c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m3182b(i3);
            if (b.getVisibility() != 8) {
                C0750a c0750a = (C0750a) b.getLayoutParams();
                if (c0750a.width == -1) {
                    int i4 = c0750a.height;
                    c0750a.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    c0750a.height = i4;
                }
            }
        }
    }

    void m3183b(int i, int i2) {
        Object obj;
        int i3;
        Object obj2;
        int i4;
        int i5;
        int i6;
        C0750a c0750a;
        this.f1633f = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        Object obj3 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj4 = null;
        Object obj5 = null;
        if (this.f1636i == null || this.f1637j == null) {
            this.f1636i = new int[4];
            this.f1637j = new int[4];
        }
        int[] iArr = this.f1636i;
        int[] iArr2 = this.f1637j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f1628a;
        boolean z2 = this.f1635h;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            Object obj6;
            View b = m3182b(i12);
            if (b == null) {
                this.f1633f += m3188d(i12);
                i3 = i11;
                obj2 = obj5;
                obj6 = obj3;
                i4 = i8;
                i5 = i7;
            } else if (b.getVisibility() == 8) {
                i12 += m3173a(b, i12);
                i3 = i11;
                obj2 = obj5;
                obj6 = obj3;
                i4 = i8;
                i5 = i7;
            } else {
                Object obj7;
                if (m3187c(i12)) {
                    this.f1633f += this.f1639l;
                }
                C0750a c0750a2 = (C0750a) b.getLayoutParams();
                float f2 = f + c0750a2.f1619g;
                if (mode == 1073741824 && c0750a2.width == 0 && c0750a2.f1619g > 0.0f) {
                    if (obj != null) {
                        this.f1633f += c0750a2.leftMargin + c0750a2.rightMargin;
                    } else {
                        i3 = this.f1633f;
                        this.f1633f = Math.max(i3, (c0750a2.leftMargin + i3) + c0750a2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj5 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0750a2.width == 0 && c0750a2.f1619g > 0.0f) {
                        i3 = 0;
                        c0750a2.width = -2;
                    }
                    int i13 = i3;
                    m3178a(b, i12, i, f2 == 0.0f ? this.f1633f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        c0750a2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj != null) {
                        this.f1633f += ((c0750a2.leftMargin + i3) + c0750a2.rightMargin) + m3179b(b);
                    } else {
                        int i14 = this.f1633f;
                        this.f1633f = Math.max(i14, (((i14 + i3) + c0750a2.leftMargin) + c0750a2.rightMargin) + m3179b(b));
                    }
                    if (z2) {
                        i11 = Math.max(i3, i11);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || c0750a2.height != -1) {
                    obj7 = obj4;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i4 = c0750a2.bottomMargin + c0750a2.topMargin;
                i5 = b.getMeasuredHeight() + i4;
                int a = aw.m4360a(i8, ae.m2230j(b));
                if (z) {
                    i8 = b.getBaseline();
                    if (i8 != -1) {
                        int i15 = ((((c0750a2.f1620h < 0 ? this.f1632e : c0750a2.f1620h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i8);
                        iArr2[i15] = Math.max(iArr2[i15], i5 - i8);
                    }
                }
                i8 = Math.max(i7, i5);
                obj6 = (obj3 == null || c0750a2.height != -1) ? null : 1;
                if (c0750a2.f1619g > 0.0f) {
                    if (obj8 != null) {
                        i3 = i4;
                    } else {
                        i3 = i5;
                    }
                    i3 = Math.max(i10, i3);
                    i4 = i9;
                } else {
                    if (obj8 == null) {
                        i4 = i5;
                    }
                    i4 = Math.max(i9, i4);
                    i3 = i10;
                }
                i12 += m3173a(b, i12);
                obj2 = obj5;
                i10 = i3;
                i9 = i4;
                i5 = i8;
                i3 = i11;
                i4 = a;
                obj4 = obj7;
                f = f2;
            }
            i12++;
            i11 = i3;
            obj5 = obj2;
            obj3 = obj6;
            i8 = i4;
            i7 = i5;
        }
        if (this.f1633f > 0 && m3187c(virtualChildCount)) {
            this.f1633f += this.f1639l;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i12 = i7;
        } else {
            i12 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f1633f = 0;
            i6 = 0;
            while (i6 < virtualChildCount) {
                View b2 = m3182b(i6);
                if (b2 == null) {
                    this.f1633f += m3188d(i6);
                    i3 = i6;
                } else if (b2.getVisibility() == 8) {
                    i3 = m3173a(b2, i6) + i6;
                } else {
                    c0750a = (C0750a) b2.getLayoutParams();
                    if (obj != null) {
                        this.f1633f = ((c0750a.rightMargin + (c0750a.leftMargin + i11)) + m3179b(b2)) + this.f1633f;
                        i3 = i6;
                    } else {
                        i4 = this.f1633f;
                        this.f1633f = Math.max(i4, (c0750a.rightMargin + ((i4 + i11) + c0750a.leftMargin)) + m3179b(b2));
                        i3 = i6;
                    }
                }
                i6 = i3 + 1;
            }
        }
        this.f1633f += getPaddingLeft() + getPaddingRight();
        int a2 = ae.m2202a(Math.max(this.f1633f, getSuggestedMinimumWidth()), i, 0);
        i6 = (16777215 & a2) - this.f1633f;
        int i16;
        if (obj5 != null || (i6 != 0 && f > 0.0f)) {
            if (this.f1634g > 0.0f) {
                f = this.f1634g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f1633f = 0;
            i11 = 0;
            float f3 = f;
            Object obj9 = obj3;
            i16 = i9;
            i15 = i8;
            i14 = i6;
            i9 = -1;
            while (i11 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = m3182b(i11);
                if (b3 == null) {
                    f4 = f3;
                    i6 = i14;
                    i4 = i9;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i6 = i14;
                    i4 = i9;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    c0750a = (C0750a) b3.getLayoutParams();
                    float f6 = c0750a.f1619g;
                    if (f6 > 0.0f) {
                        i6 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i4 = i14 - i6;
                        i14 = C0754z.getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + c0750a.topMargin) + c0750a.bottomMargin, c0750a.height);
                        if (c0750a.width == 0 && mode == 1073741824) {
                            if (i6 <= 0) {
                                i6 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i6, 1073741824), i14);
                        } else {
                            i6 += b3.getMeasuredWidth();
                            if (i6 < 0) {
                                i6 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i6, 1073741824), i14);
                        }
                        i10 = aw.m4360a(i15, ae.m2230j(b3) & -16777216);
                        f5 = f3;
                    } else {
                        i4 = i14;
                        i10 = i15;
                        f5 = f3;
                    }
                    if (obj != null) {
                        this.f1633f += ((b3.getMeasuredWidth() + c0750a.leftMargin) + c0750a.rightMargin) + m3179b(b3);
                    } else {
                        i6 = this.f1633f;
                        this.f1633f = Math.max(i6, (((b3.getMeasuredWidth() + i6) + c0750a.leftMargin) + c0750a.rightMargin) + m3179b(b3));
                    }
                    obj2 = (mode2 == 1073741824 || c0750a.height != -1) ? null : 1;
                    i12 = c0750a.topMargin + c0750a.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i12;
                    i9 = Math.max(i9, i14);
                    if (obj2 != null) {
                        i6 = i12;
                    } else {
                        i6 = i14;
                    }
                    i12 = Math.max(i16, i6);
                    obj2 = (obj9 == null || c0750a.height != -1) ? null : 1;
                    if (z) {
                        i5 = b3.getBaseline();
                        if (i5 != -1) {
                            i3 = ((((c0750a.f1620h < 0 ? this.f1632e : c0750a.f1620h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i5);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i5);
                        }
                    }
                    f4 = f5;
                    i14 = i12;
                    obj10 = obj2;
                    i15 = i10;
                    i6 = i4;
                    i4 = i9;
                }
                i11++;
                i16 = i14;
                i9 = i4;
                obj9 = obj10;
                i14 = i6;
                f3 = f4;
            }
            this.f1633f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i9 = Math.max(i9, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj3 = obj9;
            i3 = i16;
            i8 = i15;
            i6 = i9;
        } else {
            i16 = Math.max(i9, i10);
            if (z2 && mode != 1073741824) {
                for (i6 = 0; i6 < virtualChildCount; i6++) {
                    View b4 = m3182b(i6);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((C0750a) b4.getLayoutParams()).f1619g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i11, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i6 = i12;
        }
        if (obj3 != null || mode2 == 1073741824) {
            i3 = i6;
        }
        setMeasuredDimension((-16777216 & i8) | a2, ae.m2202a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i8 << 16));
        if (obj4 != null) {
            m3171d(virtualChildCount, i);
        }
    }

    private void m3171d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m3182b(i3);
            if (b.getVisibility() != 8) {
                C0750a c0750a = (C0750a) b.getLayoutParams();
                if (c0750a.height == -1) {
                    int i4 = c0750a.width;
                    c0750a.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    c0750a.width = i4;
                }
            }
        }
    }

    int m3173a(View view, int i) {
        return 0;
    }

    int m3188d(int i) {
        return 0;
    }

    void m3178a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int m3172a(View view) {
        return 0;
    }

    int m3179b(View view) {
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1631d == 1) {
            m3175a(i, i2, i3, i4);
        } else {
            m3184b(i, i2, i3, i4);
        }
    }

    void m3175a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.f1632e & 8388615;
        switch (this.f1632e & 112) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - this.f1633f) / 2);
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - this.f1633f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = m3182b(i7);
            if (b == null) {
                i8 += m3188d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0750a c0750a = (C0750a) b.getLayoutParams();
                i5 = c0750a.f1620h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (C0567e.m2446a(i5, ae.m2228h(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + c0750a.leftMargin) - c0750a.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - c0750a.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + c0750a.leftMargin;
                        break;
                }
                if (m3187c(i7)) {
                    i5 = this.f1640m + i8;
                } else {
                    i5 = i8;
                }
                int i10 = i5 + c0750a.topMargin;
                m3169a(b, i9, i10 + m3172a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((c0750a.bottomMargin + measuredHeight) + m3179b(b));
                i5 = m3173a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void m3184b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = aw.m4362a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f1632e & 8388615;
        int i8 = this.f1632e & 112;
        boolean z = this.f1628a;
        int[] iArr = this.f1636i;
        int[] iArr2 = this.f1637j;
        switch (C0567e.m2446a(i7, ae.m2228h(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f1633f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f1633f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = m3182b(i10);
            if (b == null) {
                paddingLeft += m3188d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0750a c0750a = (C0750a) b.getLayoutParams();
                if (!z || c0750a.height == -1) {
                    i7 = -1;
                } else {
                    i7 = b.getBaseline();
                }
                int i12 = c0750a.f1620h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case 16:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + c0750a.topMargin) - c0750a.bottomMargin;
                        break;
                    case 48:
                        i11 = paddingTop + c0750a.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case 80:
                        i11 = (paddingBottom - measuredHeight) - c0750a.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                if (m3187c(i10)) {
                    i7 = this.f1639l + paddingLeft;
                } else {
                    i7 = paddingLeft;
                }
                paddingLeft = i7 + c0750a.leftMargin;
                m3169a(b, paddingLeft + m3172a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (c0750a.rightMargin + measuredWidth) + m3179b(b);
                i7 = m3173a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    private void m3169a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.f1631d != i) {
            this.f1631d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f1631d;
    }

    public void setGravity(int i) {
        if (this.f1632e != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1632e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f1632e & 8388615) != i2) {
            this.f1632e = i2 | (this.f1632e & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f1632e & 112) != i2) {
            this.f1632e = i2 | (this.f1632e & -113);
            requestLayout();
        }
    }

    public C0750a mo563b(AttributeSet attributeSet) {
        return new C0750a(getContext(), attributeSet);
    }

    protected C0750a mo566g() {
        if (this.f1631d == 0) {
            return new C0750a(-2, -2);
        }
        if (this.f1631d == 1) {
            return new C0750a(-1, -2);
        }
        return null;
    }

    protected C0750a mo564b(LayoutParams layoutParams) {
        return new C0750a(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0750a;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0754z.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C0754z.class.getName());
        }
    }
}
