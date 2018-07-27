package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p015c.p016a.C0302a;
import android.support.v4.view.C0601s;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0669k;
import android.support.v7.p028c.p029a.C0673b;
import android.support.v7.p033f.C0678a;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton {
    private static final int[] f2006M = new int[]{16842912};
    private int f2007A;
    private int f2008B;
    private int f2009C;
    private int f2010D;
    private int f2011E;
    private int f2012F;
    private TextPaint f2013G;
    private ColorStateList f2014H;
    private Layout f2015I;
    private Layout f2016J;
    private TransformationMethod f2017K;
    private final Rect f2018L;
    C0816a f2019a;
    private Drawable f2020b;
    private ColorStateList f2021c;
    private Mode f2022d;
    private boolean f2023e;
    private boolean f2024f;
    private Drawable f2025g;
    private ColorStateList f2026h;
    private Mode f2027i;
    private boolean f2028j;
    private boolean f2029k;
    private int f2030l;
    private int f2031m;
    private int f2032n;
    private boolean f2033o;
    private CharSequence f2034p;
    private CharSequence f2035q;
    private boolean f2036r;
    private int f2037s;
    private int f2038t;
    private float f2039u;
    private float f2040v;
    private VelocityTracker f2041w;
    private int f2042x;
    private float f2043y;
    private int f2044z;

    private class C0816a extends Animation {
        final float f2002a;
        final float f2003b;
        final float f2004c;
        final /* synthetic */ SwitchCompat f2005d;

        C0816a(SwitchCompat switchCompat, float f, float f2) {
            this.f2005d = switchCompat;
            this.f2002a = f;
            this.f2003b = f2;
            this.f2004c = f2 - f;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            this.f2005d.setThumbPosition(this.f2002a + (this.f2004c * f));
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0659a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2021c = null;
        this.f2022d = null;
        this.f2023e = false;
        this.f2024f = false;
        this.f2026h = null;
        this.f2027i = null;
        this.f2028j = false;
        this.f2029k = false;
        this.f2041w = VelocityTracker.obtain();
        this.f2018L = new Rect();
        this.f2013G = new TextPaint(1);
        Resources resources = getResources();
        this.f2013G.density = resources.getDisplayMetrics().density;
        as a = as.m4294a(context, attributeSet, C0669k.SwitchCompat, i, 0);
        this.f2020b = a.m4297a(C0669k.SwitchCompat_android_thumb);
        if (this.f2020b != null) {
            this.f2020b.setCallback(this);
        }
        this.f2025g = a.m4297a(C0669k.SwitchCompat_track);
        if (this.f2025g != null) {
            this.f2025g.setCallback(this);
        }
        this.f2034p = a.m4301b(C0669k.SwitchCompat_android_textOn);
        this.f2035q = a.m4301b(C0669k.SwitchCompat_android_textOff);
        this.f2036r = a.m4299a(C0669k.SwitchCompat_showText, true);
        this.f2030l = a.m4306e(C0669k.SwitchCompat_thumbTextPadding, 0);
        this.f2031m = a.m4306e(C0669k.SwitchCompat_switchMinWidth, 0);
        this.f2032n = a.m4306e(C0669k.SwitchCompat_switchPadding, 0);
        this.f2033o = a.m4299a(C0669k.SwitchCompat_splitTrack, false);
        ColorStateList d = a.m4305d(C0669k.SwitchCompat_thumbTint);
        if (d != null) {
            this.f2021c = d;
            this.f2023e = true;
        }
        Mode a2 = C0901u.m4587a(a.m4296a(C0669k.SwitchCompat_thumbTintMode, -1), null);
        if (this.f2022d != a2) {
            this.f2022d = a2;
            this.f2024f = true;
        }
        if (this.f2023e || this.f2024f) {
            m4045b();
        }
        d = a.m4305d(C0669k.SwitchCompat_trackTint);
        if (d != null) {
            this.f2026h = d;
            this.f2028j = true;
        }
        a2 = C0901u.m4587a(a.m4296a(C0669k.SwitchCompat_trackTintMode, -1), null);
        if (this.f2027i != a2) {
            this.f2027i = a2;
            this.f2029k = true;
        }
        if (this.f2028j || this.f2029k) {
            m4040a();
        }
        int g = a.m4310g(C0669k.SwitchCompat_switchTextAppearance, 0);
        if (g != 0) {
            m4048a(context, g);
        }
        a.m4298a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2038t = viewConfiguration.getScaledTouchSlop();
        this.f2042x = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void m4048a(Context context, int i) {
        as a = as.m4292a(context, i, C0669k.TextAppearance);
        ColorStateList d = a.m4305d(C0669k.TextAppearance_android_textColor);
        if (d != null) {
            this.f2014H = d;
        } else {
            this.f2014H = getTextColors();
        }
        int e = a.m4306e(C0669k.TextAppearance_android_textSize, 0);
        if (!(e == 0 || ((float) e) == this.f2013G.getTextSize())) {
            this.f2013G.setTextSize((float) e);
            requestLayout();
        }
        m4041a(a.m4296a(C0669k.TextAppearance_android_typeface, -1), a.m4296a(C0669k.TextAppearance_android_textStyle, -1));
        if (a.m4299a(C0669k.TextAppearance_textAllCaps, false)) {
            this.f2017K = new C0678a(getContext());
        } else {
            this.f2017K = null;
        }
        a.m4298a();
    }

    private void m4041a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        m4049a(typeface, i2);
    }

    public void m4049a(Typeface typeface, int i) {
        boolean z = false;
        if (i > 0) {
            Typeface defaultFromStyle;
            int style;
            float f;
            if (typeface == null) {
                defaultFromStyle = Typeface.defaultFromStyle(i);
            } else {
                defaultFromStyle = Typeface.create(typeface, i);
            }
            setSwitchTypeface(defaultFromStyle);
            if (defaultFromStyle != null) {
                style = defaultFromStyle.getStyle();
            } else {
                style = 0;
            }
            style = (style ^ -1) & i;
            TextPaint textPaint = this.f2013G;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.f2013G;
            if ((style & 2) != 0) {
                f = -0.25f;
            } else {
                f = 0.0f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.f2013G.setFakeBoldText(false);
        this.f2013G.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.f2013G.getTypeface() != typeface) {
            this.f2013G.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.f2032n = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.f2032n;
    }

    public void setSwitchMinWidth(int i) {
        this.f2031m = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.f2031m;
    }

    public void setThumbTextPadding(int i) {
        this.f2030l = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.f2030l;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.f2025g != null) {
            this.f2025g.setCallback(null);
        }
        this.f2025g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(C0673b.m2768b(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.f2025g;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f2026h = colorStateList;
        this.f2028j = true;
        m4040a();
    }

    public ColorStateList getTrackTintList() {
        return this.f2026h;
    }

    public void setTrackTintMode(Mode mode) {
        this.f2027i = mode;
        this.f2029k = true;
        m4040a();
    }

    public Mode getTrackTintMode() {
        return this.f2027i;
    }

    private void m4040a() {
        if (this.f2025g == null) {
            return;
        }
        if (this.f2028j || this.f2029k) {
            this.f2025g = this.f2025g.mutate();
            if (this.f2028j) {
                C0302a.m1141a(this.f2025g, this.f2026h);
            }
            if (this.f2029k) {
                C0302a.m1144a(this.f2025g, this.f2027i);
            }
            if (this.f2025g.isStateful()) {
                this.f2025g.setState(getDrawableState());
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.f2020b != null) {
            this.f2020b.setCallback(null);
        }
        this.f2020b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(C0673b.m2768b(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.f2020b;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f2021c = colorStateList;
        this.f2023e = true;
        m4045b();
    }

    public ColorStateList getThumbTintList() {
        return this.f2021c;
    }

    public void setThumbTintMode(Mode mode) {
        this.f2022d = mode;
        this.f2024f = true;
        m4045b();
    }

    public Mode getThumbTintMode() {
        return this.f2022d;
    }

    private void m4045b() {
        if (this.f2020b == null) {
            return;
        }
        if (this.f2023e || this.f2024f) {
            this.f2020b = this.f2020b.mutate();
            if (this.f2023e) {
                C0302a.m1141a(this.f2020b, this.f2021c);
            }
            if (this.f2024f) {
                C0302a.m1144a(this.f2020b, this.f2022d);
            }
            if (this.f2020b.isStateful()) {
                this.f2020b.setState(getDrawableState());
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.f2033o = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.f2033o;
    }

    public CharSequence getTextOn() {
        return this.f2034p;
    }

    public void setTextOn(CharSequence charSequence) {
        this.f2034p = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.f2035q;
    }

    public void setTextOff(CharSequence charSequence) {
        this.f2035q = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.f2036r != z) {
            this.f2036r = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.f2036r;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int max;
        int i3 = 0;
        if (this.f2036r) {
            if (this.f2015I == null) {
                this.f2015I = m4039a(this.f2034p);
            }
            if (this.f2016J == null) {
                this.f2016J = m4039a(this.f2035q);
            }
        }
        Rect rect = this.f2018L;
        if (this.f2020b != null) {
            this.f2020b.getPadding(rect);
            intrinsicWidth = (this.f2020b.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f2020b.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (this.f2036r) {
            max = Math.max(this.f2015I.getWidth(), this.f2016J.getWidth()) + (this.f2030l * 2);
        } else {
            max = 0;
        }
        this.f2008B = Math.max(max, intrinsicWidth);
        if (this.f2025g != null) {
            this.f2025g.getPadding(rect);
            i3 = this.f2025g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        max = rect.left;
        intrinsicWidth = rect.right;
        if (this.f2020b != null) {
            rect = C0901u.m4588a(this.f2020b);
            max = Math.max(max, rect.left);
            intrinsicWidth = Math.max(intrinsicWidth, rect.right);
        }
        intrinsicWidth = Math.max(this.f2031m, intrinsicWidth + (max + (this.f2008B * 2)));
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.f2044z = intrinsicWidth;
        this.f2007A = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(ae.m2229i(this), intrinsicHeight);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.f2034p : this.f2035q;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout m4039a(CharSequence charSequence) {
        int ceil;
        CharSequence transformation = this.f2017K != null ? this.f2017K.getTransformation(charSequence, this) : charSequence;
        TextPaint textPaint = this.f2013G;
        if (transformation != null) {
            ceil = (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.f2013G));
        } else {
            ceil = 0;
        }
        return new StaticLayout(transformation, textPaint, ceil, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean m4044a(float f, float f2) {
        if (this.f2020b == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f2020b.getPadding(this.f2018L);
        int i = this.f2010D - this.f2038t;
        thumbOffset = (thumbOffset + this.f2009C) - this.f2038t;
        int i2 = (((this.f2008B + thumbOffset) + this.f2018L.left) + this.f2018L.right) + this.f2038t;
        int i3 = this.f2012F + this.f2038t;
        if (f <= ((float) thumbOffset) || f >= ((float) i2) || f2 <= ((float) i) || f2 >= ((float) i3)) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f2041w.addMovement(motionEvent);
        float x;
        float y;
        switch (C0601s.m2508a(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (isEnabled() && m4044a(x, y)) {
                    this.f2037s = 1;
                    this.f2039u = x;
                    this.f2040v = y;
                    break;
                }
            case 1:
            case 3:
                if (this.f2037s != 2) {
                    this.f2037s = 0;
                    this.f2041w.clear();
                    break;
                }
                m4046b(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.f2037s) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (Math.abs(x - this.f2039u) > ((float) this.f2038t) || Math.abs(y - this.f2040v) > ((float) this.f2038t)) {
                            this.f2037s = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f2039u = x;
                            this.f2040v = y;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x2 - this.f2039u;
                        x = thumbScrollRange != 0 ? f / ((float) thumbScrollRange) : f > 0.0f ? 1.0f : -1.0f;
                        if (aw.m4362a(this)) {
                            x = -x;
                        }
                        x = m4038a(x + this.f2043y, 0.0f, 1.0f);
                        if (x != this.f2043y) {
                            this.f2039u = x2;
                            setThumbPosition(x);
                        }
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void m4042a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void m4046b(MotionEvent motionEvent) {
        boolean z = true;
        this.f2037s = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.f2041w.computeCurrentVelocity(1000);
            float xVelocity = this.f2041w.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f2042x)) {
                z = getTargetCheckedState();
            } else if (aw.m4362a(this)) {
                if (xVelocity >= 0.0f) {
                    z = false;
                }
            } else if (xVelocity <= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        m4042a(motionEvent);
    }

    private void m4043a(final boolean z) {
        if (this.f2019a != null) {
            m4047c();
        }
        this.f2019a = new C0816a(this, this.f2043y, z ? 1.0f : 0.0f);
        this.f2019a.setDuration(250);
        this.f2019a.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ SwitchCompat f2001b;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (this.f2001b.f2019a == animation) {
                    this.f2001b.setThumbPosition(z ? 1.0f : 0.0f);
                    this.f2001b.f2019a = null;
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        startAnimation(this.f2019a);
    }

    private void m4047c() {
        if (this.f2019a != null) {
            clearAnimation();
            this.f2019a = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.f2043y > 0.5f;
    }

    void setThumbPosition(float f) {
        this.f2043y = f;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && ae.m2243w(this) && isShown()) {
            m4043a(isChecked);
            return;
        }
        m4047c();
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f2020b != null) {
            Rect rect = this.f2018L;
            if (this.f2025g != null) {
                this.f2025g.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a = C0901u.m4588a(this.f2020b);
            max = Math.max(0, a.left - rect.left);
            i5 = Math.max(0, a.right - rect.right);
        } else {
            max = 0;
        }
        if (aw.m4362a(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.f2044z + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.f2044z);
            max = paddingLeft;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f2007A / 2);
                paddingLeft = this.f2007A + paddingTop;
                break;
            case 80:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.f2007A;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.f2007A + paddingTop;
                break;
        }
        this.f2009C = i5;
        this.f2010D = paddingTop;
        this.f2012F = paddingLeft;
        this.f2011E = max;
    }

    public void draw(Canvas canvas) {
        Rect a;
        int i;
        Rect rect = this.f2018L;
        int i2 = this.f2009C;
        int i3 = this.f2010D;
        int i4 = this.f2011E;
        int i5 = this.f2012F;
        int thumbOffset = i2 + getThumbOffset();
        if (this.f2020b != null) {
            a = C0901u.m4588a(this.f2020b);
        } else {
            a = C0901u.f2448a;
        }
        if (this.f2025g != null) {
            this.f2025g.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (a != null) {
                if (a.left > rect.left) {
                    i2 += a.left - rect.left;
                }
                if (a.top > rect.top) {
                    thumbOffset = (a.top - rect.top) + i3;
                } else {
                    thumbOffset = i3;
                }
                if (a.right > rect.right) {
                    i4 -= a.right - rect.right;
                }
                i = a.bottom > rect.bottom ? i5 - (a.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.f2025g.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.f2020b != null) {
            this.f2020b.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.f2008B) + rect.right;
            this.f2020b.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                C0302a.m1140a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.f2018L;
        Drawable drawable = this.f2025g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f2010D + rect.top;
        int i2 = this.f2012F - rect.bottom;
        Drawable drawable2 = this.f2020b;
        if (drawable != null) {
            if (!this.f2033o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a = C0901u.m4588a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a.left;
                rect.right -= a.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f2015I : this.f2016J;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.f2014H != null) {
                this.f2013G.setColor(this.f2014H.getColorForState(drawableState, 0));
            }
            this.f2013G.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public int getCompoundPaddingLeft() {
        if (!aw.m4362a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f2044z;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft;
        }
        return compoundPaddingLeft + this.f2032n;
    }

    public int getCompoundPaddingRight() {
        if (aw.m4362a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f2044z;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.f2032n;
    }

    private int getThumbOffset() {
        float f;
        if (aw.m4362a(this)) {
            f = 1.0f - this.f2043y;
        } else {
            f = this.f2043y;
        }
        return (int) ((f * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.f2025g == null) {
            return 0;
        }
        Rect a;
        Rect rect = this.f2018L;
        this.f2025g.getPadding(rect);
        if (this.f2020b != null) {
            a = C0901u.m4588a(this.f2020b);
        } else {
            a = C0901u.f2448a;
        }
        return ((((this.f2044z - this.f2008B) - rect.left) - rect.right) - a.left) - a.right;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f2006M);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f2020b;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.f2025g;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.f2020b != null) {
            C0302a.m1138a(this.f2020b, f, f2);
        }
        if (this.f2025g != null) {
            C0302a.m1138a(this.f2025g, f, f2);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2020b || drawable == this.f2025g;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f2020b != null) {
                this.f2020b.jumpToCurrentState();
            }
            if (this.f2025g != null) {
                this.f2025g.jumpToCurrentState();
            }
            m4047c();
            setThumbPosition(isChecked() ? 1.0f : 0.0f);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.f2034p : this.f2035q;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }

    private static float m4038a(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }
}
