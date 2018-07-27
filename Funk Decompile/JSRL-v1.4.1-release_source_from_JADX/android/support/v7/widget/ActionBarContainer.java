package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0664f;
import android.support.v7.p027b.C0670a.C0669k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    Drawable f1558a;
    Drawable f1559b;
    Drawable f1560c;
    boolean f1561d;
    boolean f1562e;
    private boolean f1563f;
    private View f1564g;
    private View f1565h;
    private View f1566i;
    private int f1567j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable c0849c;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            c0849c = new C0849c(this);
        } else {
            c0849c = new C0848b(this);
        }
        ae.m2209a((View) this, c0849c);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0669k.ActionBar);
        this.f1558a = obtainStyledAttributes.getDrawable(C0669k.ActionBar_background);
        this.f1559b = obtainStyledAttributes.getDrawable(C0669k.ActionBar_backgroundStacked);
        this.f1567j = obtainStyledAttributes.getDimensionPixelSize(C0669k.ActionBar_height, -1);
        if (getId() == C0664f.split_action_bar) {
            this.f1561d = true;
            this.f1560c = obtainStyledAttributes.getDrawable(C0669k.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f1561d ? this.f1560c == null : this.f1558a == null && this.f1559b == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1565h = findViewById(C0664f.action_bar);
        this.f1566i = findViewById(C0664f.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1558a != null) {
            this.f1558a.setCallback(null);
            unscheduleDrawable(this.f1558a);
        }
        this.f1558a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1565h != null) {
                this.f1558a.setBounds(this.f1565h.getLeft(), this.f1565h.getTop(), this.f1565h.getRight(), this.f1565h.getBottom());
            }
        }
        if (this.f1561d) {
            if (this.f1560c != null) {
                z = false;
            }
        } else if (!(this.f1558a == null && this.f1559b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1559b != null) {
            this.f1559b.setCallback(null);
            unscheduleDrawable(this.f1559b);
        }
        this.f1559b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1562e && this.f1559b != null) {
                this.f1559b.setBounds(this.f1564g.getLeft(), this.f1564g.getTop(), this.f1564g.getRight(), this.f1564g.getBottom());
            }
        }
        if (this.f1561d) {
            if (this.f1560c != null) {
                z = false;
            }
        } else if (!(this.f1558a == null && this.f1559b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1560c != null) {
            this.f1560c.setCallback(null);
            unscheduleDrawable(this.f1560c);
        }
        this.f1560c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1561d && this.f1560c != null) {
                this.f1560c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1561d) {
            if (this.f1560c != null) {
                z = false;
            }
        } else if (!(this.f1558a == null && this.f1559b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1558a != null) {
            this.f1558a.setVisible(z, false);
        }
        if (this.f1559b != null) {
            this.f1559b.setVisible(z, false);
        }
        if (this.f1560c != null) {
            this.f1560c.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1558a && !this.f1561d) || ((drawable == this.f1559b && this.f1562e) || ((drawable == this.f1560c && this.f1561d) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1558a != null && this.f1558a.isStateful()) {
            this.f1558a.setState(getDrawableState());
        }
        if (this.f1559b != null && this.f1559b.isStateful()) {
            this.f1559b.setState(getDrawableState());
        }
        if (this.f1560c != null && this.f1560c.isStateful()) {
            this.f1560c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1558a != null) {
                this.f1558a.jumpToCurrentState();
            }
            if (this.f1559b != null) {
                this.f1559b.jumpToCurrentState();
            }
            if (this.f1560c != null) {
                this.f1560c.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.f1563f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1563f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ak akVar) {
        if (this.f1564g != null) {
            removeView(this.f1564g);
        }
        this.f1564g = akVar;
        if (akVar != null) {
            addView(akVar);
            LayoutParams layoutParams = akVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            akVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f1564g;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    private boolean m3136a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m3137b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.f1565h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1567j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f1567j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1565h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f1564g != null && this.f1564g.getVisibility() != 8 && mode != 1073741824) {
                int b;
                if (!m3136a(this.f1565h)) {
                    b = m3137b(this.f1565h);
                } else if (m3136a(this.f1566i)) {
                    b = 0;
                } else {
                    b = m3137b(this.f1566i);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m3137b(this.f1564g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1564g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1561d) {
            int i6;
            if (this.f1558a != null) {
                if (this.f1565h.getVisibility() == 0) {
                    this.f1558a.setBounds(this.f1565h.getLeft(), this.f1565h.getTop(), this.f1565h.getRight(), this.f1565h.getBottom());
                } else if (this.f1566i == null || this.f1566i.getVisibility() != 0) {
                    this.f1558a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1558a.setBounds(this.f1566i.getLeft(), this.f1566i.getTop(), this.f1566i.getRight(), this.f1566i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f1562e = z2;
            if (!z2 || this.f1559b == null) {
                i5 = i6;
            } else {
                this.f1559b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1560c != null) {
            this.f1560c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
