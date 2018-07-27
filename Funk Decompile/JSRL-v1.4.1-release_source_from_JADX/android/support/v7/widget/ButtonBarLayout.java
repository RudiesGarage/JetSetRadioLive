package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p018b.p019a.C0278a;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0664f;
import android.support.v7.p027b.C0670a.C0669k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

public class ButtonBarLayout extends LinearLayout {
    private boolean f1679a;
    private int f1680b = -1;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = C0278a.m1052a(getResources()) >= 320;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0669k.ButtonBarLayout);
        this.f1679a = obtainStyledAttributes.getBoolean(C0669k.ButtonBarLayout_allowStacking, z);
        obtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.f1679a != z) {
            this.f1679a = z;
            if (!this.f1679a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        boolean z2 = false;
        int size = MeasureSpec.getSize(i);
        if (this.f1679a) {
            if (size > this.f1680b && m3221a()) {
                setStacked(false);
            }
            this.f1680b = size;
        }
        if (m3221a() || MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f1679a && !m3221a()) {
            if (VERSION.SDK_INT < 11) {
                int i4 = 0;
                for (i3 = 0; i3 < getChildCount(); i3++) {
                    i4 += getChildAt(i3).getMeasuredWidth();
                }
                if ((getPaddingLeft() + i4) + getPaddingRight() > size) {
                    z2 = true;
                }
            } else if ((ae.m2229i(this) & -16777216) == 16777216) {
                z2 = true;
            }
            if (z2) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(C0664f.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    private boolean m3221a() {
        return getOrientation() == 1;
    }
}
