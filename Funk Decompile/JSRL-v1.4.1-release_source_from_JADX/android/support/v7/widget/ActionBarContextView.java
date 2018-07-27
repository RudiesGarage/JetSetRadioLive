package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0664f;
import android.support.v7.p027b.C0670a.C0666h;
import android.support.v7.p027b.C0670a.C0669k;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0743a {
    private CharSequence f1576g;
    private CharSequence f1577h;
    private View f1578i;
    private View f1579j;
    private LinearLayout f1580k;
    private TextView f1581l;
    private TextView f1582m;
    private int f1583n;
    private int f1584o;
    private boolean f1585p;
    private int f1586q;

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0659a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        as a = as.m4294a(context, attributeSet, C0669k.ActionMode, i, 0);
        ae.m2209a((View) this, a.m4297a(C0669k.ActionMode_background));
        this.f1583n = a.m4310g(C0669k.ActionMode_titleTextStyle, 0);
        this.f1584o = a.m4310g(C0669k.ActionMode_subtitleTextStyle, 0);
        this.e = a.m4308f(C0669k.ActionMode_height, 0);
        this.f1586q = a.m4310g(C0669k.ActionMode_closeItemLayout, C0666h.abc_action_mode_close_item_material);
        a.m4298a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m4397e();
            this.d.m4399g();
        }
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f1579j != null) {
            removeView(this.f1579j);
        }
        this.f1579j = view;
        if (!(view == null || this.f1580k == null)) {
            removeView(this.f1580k);
            this.f1580k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1576g = charSequence;
        m3143a();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1577h = charSequence;
        m3143a();
    }

    public CharSequence getTitle() {
        return this.f1576g;
    }

    public CharSequence getSubtitle() {
        return this.f1577h;
    }

    private void m3143a() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.f1580k == null) {
            LayoutInflater.from(getContext()).inflate(C0666h.abc_action_bar_title_item, this);
            this.f1580k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1581l = (TextView) this.f1580k.findViewById(C0664f.action_bar_title);
            this.f1582m = (TextView) this.f1580k.findViewById(C0664f.action_bar_subtitle);
            if (this.f1583n != 0) {
                this.f1581l.setTextAppearance(getContext(), this.f1583n);
            }
            if (this.f1584o != 0) {
                this.f1582m.setTextAppearance(getContext(), this.f1584o);
            }
        }
        this.f1581l.setText(this.f1576g);
        this.f1582m.setText(this.f1577h);
        Object obj2 = !TextUtils.isEmpty(this.f1576g) ? 1 : null;
        if (TextUtils.isEmpty(this.f1577h)) {
            obj = null;
        }
        TextView textView = this.f1582m;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.f1580k;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.f1580k.getParent() == null) {
            addView(this.f1580k);
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int i5;
            int a;
            int size = MeasureSpec.getSize(i);
            if (this.e > 0) {
                i5 = this.e;
            } else {
                i5 = MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i6 = i5 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
            if (this.f1578i != null) {
                a = m3141a(this.f1578i, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1578i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m3141a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1580k != null && this.f1579j == null) {
                if (this.f1585p) {
                    this.f1580k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f1580k.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f1580k.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m3141a(this.f1580k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1579j != null) {
                int min;
                LayoutParams layoutParams = this.f1579j.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i6);
                } else {
                    min = i6;
                }
                this.f1579j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.e <= 0) {
                makeMeasureSpec = getChildCount();
                i5 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= i5) {
                        paddingLeft = i5;
                    }
                    i4++;
                    i5 = paddingLeft;
                }
                setMeasuredDimension(size, i5);
                return;
            }
            setMeasuredDimension(size, i5);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = aw.m4362a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1578i == null || this.f1578i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1578i.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = C0743a.m3138a(paddingRight, i5, a);
            i5 = C0743a.m3138a(m3142a(this.f1578i, i5, paddingTop, paddingTop2, a) + i5, i6, a);
        }
        if (!(this.f1580k == null || this.f1579j != null || this.f1580k.getVisibility() == 8)) {
            i5 += m3142a(this.f1580k, i5, paddingTop, paddingTop2, a);
        }
        if (this.f1579j != null) {
            int a2 = m3142a(this.f1579j, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a2 = m3142a(this.c, i5, paddingTop, paddingTop2, !a) + i5;
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1576g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1585p) {
            requestLayout();
        }
        this.f1585p = z;
    }
}
