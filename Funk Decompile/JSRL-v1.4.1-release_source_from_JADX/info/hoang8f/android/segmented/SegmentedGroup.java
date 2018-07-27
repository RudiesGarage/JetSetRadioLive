package info.hoang8f.android.segmented;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import info.hoang8f.android.segmented.C1279a.C1275a;
import info.hoang8f.android.segmented.C1279a.C1276b;
import info.hoang8f.android.segmented.C1279a.C1277c;
import info.hoang8f.android.segmented.C1279a.C1278d;

public class SegmentedGroup extends RadioGroup {
    private int f3323a;
    private Resources f3324b;
    private int f3325c;
    private int f3326d;
    private C1274a f3327e;
    private Float f3328f;

    private class C1274a {
        final /* synthetic */ SegmentedGroup f3309a;
        private int f3310b = -1;
        private int f3311c = -1;
        private final int f3312d = C1277c.radio_checked;
        private final int f3313e = C1277c.radio_unchecked;
        private float f3314f;
        private final float f3315g = TypedValue.applyDimension(1, 0.1f, this.f3309a.getResources().getDisplayMetrics());
        private final float[] f3316h;
        private final float[] f3317i;
        private final float[] f3318j;
        private final float[] f3319k;
        private final float[] f3320l;
        private final float[] f3321m;
        private float[] f3322n;

        public C1274a(SegmentedGroup segmentedGroup, float f) {
            this.f3309a = segmentedGroup;
            this.f3314f = f;
            this.f3316h = new float[]{this.f3314f, this.f3314f, this.f3315g, this.f3315g, this.f3315g, this.f3315g, this.f3314f, this.f3314f};
            this.f3317i = new float[]{this.f3315g, this.f3315g, this.f3314f, this.f3314f, this.f3314f, this.f3314f, this.f3315g, this.f3315g};
            this.f3318j = new float[]{this.f3315g, this.f3315g, this.f3315g, this.f3315g, this.f3315g, this.f3315g, this.f3315g, this.f3315g};
            this.f3319k = new float[]{this.f3314f, this.f3314f, this.f3314f, this.f3314f, this.f3314f, this.f3314f, this.f3314f, this.f3314f};
            this.f3320l = new float[]{this.f3314f, this.f3314f, this.f3314f, this.f3314f, this.f3315g, this.f3315g, this.f3315g, this.f3315g};
            this.f3321m = new float[]{this.f3315g, this.f3315g, this.f3315g, this.f3315g, this.f3314f, this.f3314f, this.f3314f, this.f3314f};
        }

        private int m5829c() {
            return this.f3309a.getChildCount();
        }

        private int m5828b(View view) {
            return this.f3309a.indexOfChild(view);
        }

        private void m5827a(int i, int i2) {
            if (this.f3310b != i || this.f3311c != i2) {
                this.f3310b = i;
                this.f3311c = i2;
                if (this.f3310b == 1) {
                    this.f3322n = this.f3319k;
                } else if (this.f3311c == 0) {
                    this.f3322n = this.f3309a.getOrientation() == 0 ? this.f3316h : this.f3320l;
                } else if (this.f3311c == this.f3310b - 1) {
                    this.f3322n = this.f3309a.getOrientation() == 0 ? this.f3317i : this.f3321m;
                } else {
                    this.f3322n = this.f3318j;
                }
            }
        }

        public int m5830a() {
            return this.f3312d;
        }

        public int m5832b() {
            return this.f3313e;
        }

        public float[] m5831a(View view) {
            m5827a(m5829c(), m5828b(view));
            return this.f3322n;
        }
    }

    public SegmentedGroup(Context context) {
        super(context);
        this.f3326d = -1;
        this.f3324b = getResources();
        this.f3325c = this.f3324b.getColor(C1275a.radio_button_selected_color);
        this.f3323a = (int) getResources().getDimension(C1276b.radio_button_stroke_border);
        this.f3328f = Float.valueOf(getResources().getDimension(C1276b.radio_button_conner_radius));
        this.f3327e = new C1274a(this, this.f3328f.floatValue());
    }

    private void m5833a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, C1278d.SegmentedGroup, 0, 0);
        try {
            this.f3323a = (int) obtainStyledAttributes.getDimension(C1278d.SegmentedGroup_sc_border_width, getResources().getDimension(C1276b.radio_button_stroke_border));
            this.f3328f = Float.valueOf(obtainStyledAttributes.getDimension(C1278d.SegmentedGroup_sc_corner_radius, getResources().getDimension(C1276b.radio_button_conner_radius)));
            this.f3325c = obtainStyledAttributes.getColor(C1278d.SegmentedGroup_sc_tint_color, getResources().getColor(C1275a.radio_button_selected_color));
            this.f3326d = obtainStyledAttributes.getColor(C1278d.SegmentedGroup_sc_checked_text_color, getResources().getColor(17170443));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public SegmentedGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3326d = -1;
        this.f3324b = getResources();
        this.f3325c = this.f3324b.getColor(C1275a.radio_button_selected_color);
        this.f3323a = (int) getResources().getDimension(C1276b.radio_button_stroke_border);
        this.f3328f = Float.valueOf(getResources().getDimension(C1276b.radio_button_conner_radius));
        m5833a(attributeSet);
        this.f3327e = new C1274a(this, this.f3328f.floatValue());
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        m5835a();
    }

    public void setTintColor(int i) {
        this.f3325c = i;
        m5835a();
    }

    public void m5835a() {
        int childCount = super.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            m5834a(childAt);
            if (i != childCount - 1) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(layoutParams.width, layoutParams.height, layoutParams.weight);
                if (getOrientation() == 0) {
                    layoutParams2.setMargins(0, 0, -this.f3323a, 0);
                } else {
                    layoutParams2.setMargins(0, 0, 0, -this.f3323a);
                }
                childAt.setLayoutParams(layoutParams2);
                i++;
            } else {
                return;
            }
        }
    }

    private void m5834a(View view) {
        int a = this.f3327e.m5830a();
        int b = this.f3327e.m5832b();
        r0 = new int[3][];
        r0[0] = new int[]{16842919};
        r0[1] = new int[]{-16842919, -16842912};
        r0[2] = new int[]{-16842919, 16842912};
        ((Button) view).setTextColor(new ColorStateList(r0, new int[]{-7829368, this.f3325c, this.f3326d}));
        Drawable mutate = this.f3324b.getDrawable(a).mutate();
        Drawable mutate2 = this.f3324b.getDrawable(b).mutate();
        ((GradientDrawable) mutate).setColor(this.f3325c);
        ((GradientDrawable) mutate).setStroke(this.f3323a, this.f3325c);
        ((GradientDrawable) mutate2).setStroke(this.f3323a, this.f3325c);
        ((GradientDrawable) mutate).setCornerRadii(this.f3327e.m5831a(view));
        ((GradientDrawable) mutate2).setCornerRadii(this.f3327e.m5831a(view));
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842912}, mutate2);
        stateListDrawable.addState(new int[]{16842912}, mutate);
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(stateListDrawable);
        } else {
            view.setBackgroundDrawable(stateListDrawable);
        }
    }
}
