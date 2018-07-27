package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.C0601s;
import android.support.v4.view.aq;
import android.support.v4.view.at;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0669k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* compiled from: AbsActionBarView */
abstract class C0743a extends ViewGroup {
    protected final C0825a f1568a;
    protected final Context f1569b;
    protected ActionMenuView f1570c;
    protected C0858d f1571d;
    protected int f1572e;
    protected aq f1573f;
    private boolean f1574g;
    private boolean f1575h;

    /* compiled from: AbsActionBarView */
    protected class C0825a implements at {
        int f2099a;
        final /* synthetic */ C0743a f2100b;
        private boolean f2101c = false;

        protected C0825a(C0743a c0743a) {
            this.f2100b = c0743a;
        }

        public void mo418a(View view) {
            super.setVisibility(0);
            this.f2101c = false;
        }

        public void mo419b(View view) {
            if (!this.f2101c) {
                this.f2100b.f1573f = null;
                super.setVisibility(this.f2099a);
            }
        }

        public void mo420c(View view) {
            this.f2101c = true;
        }
    }

    C0743a(Context context) {
        this(context, null);
    }

    C0743a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0743a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1568a = new C0825a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0659a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1569b = context;
        } else {
            this.f1569b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0669k.ActionBar, C0659a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0669k.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1571d != null) {
            this.f1571d.m4382a(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0601s.m2508a(motionEvent);
        if (a == 0) {
            this.f1574g = false;
        }
        if (!this.f1574g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1574g = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1574g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0601s.m2508a(motionEvent);
        if (a == 9) {
            this.f1575h = false;
        }
        if (!this.f1575h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1575h = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1575h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1572e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f1572e;
    }

    public int getAnimatedVisibility() {
        if (this.f1573f != null) {
            return this.f1568a.f2099a;
        }
        return getVisibility();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1573f != null) {
                this.f1573f.m2371a();
            }
            super.setVisibility(i);
        }
    }

    protected int m3141a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected static int m3138a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m3142a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
