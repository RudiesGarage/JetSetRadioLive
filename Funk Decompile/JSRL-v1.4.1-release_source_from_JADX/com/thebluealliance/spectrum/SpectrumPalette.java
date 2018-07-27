package com.thebluealliance.spectrum;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.thebluealliance.spectrum.C1273a.C1263a;
import com.thebluealliance.spectrum.C1273a.C1266d;
import com.thebluealliance.spectrum.p046a.C1270b;
import com.thebluealliance.spectrum.p046a.C1272d;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SpectrumPalette extends LinearLayout {
    private int f3259a;
    private int f3260b;
    private int[] f3261c;
    private int f3262d;
    private C1259a f3263e;
    private boolean f3264f = false;
    private boolean f3265g = false;
    private int f3266h = -1;
    private int f3267i = 0;
    private int f3268j = 0;
    private int f3269k = 0;
    private int f3270l = 0;
    private boolean f3271m = false;
    private int f3272n = 2;
    private int f3273o = -1;
    private boolean f3274p = false;
    private EventBus f3275q;
    private List<C1270b> f3276r = new ArrayList();

    public interface C1259a {
        void mo868a(int i);
    }

    public SpectrumPalette(Context context) {
        super(context);
        m5797b();
    }

    public SpectrumPalette(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, C1266d.SpectrumPalette, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(C1266d.SpectrumPalette_spectrum_colors, 0);
        if (resourceId != 0) {
            this.f3261c = getContext().getResources().getIntArray(resourceId);
        }
        this.f3264f = obtainStyledAttributes.getBoolean(C1266d.SpectrumPalette_spectrum_autoPadding, false);
        this.f3267i = obtainStyledAttributes.getDimensionPixelSize(C1266d.SpectrumPalette_spectrum_outlineWidth, 0);
        this.f3266h = obtainStyledAttributes.getInt(C1266d.SpectrumPalette_spectrum_columnCount, -1);
        if (this.f3266h != -1) {
            this.f3265g = true;
        }
        obtainStyledAttributes.recycle();
        this.f3269k = getPaddingTop();
        this.f3270l = getPaddingBottom();
        m5797b();
    }

    private void m5797b() {
        this.f3275q = new EventBus();
        this.f3275q.register(this);
        this.f3259a = getResources().getDimensionPixelSize(C1263a.color_item_small);
        this.f3260b = getResources().getDimensionPixelSize(C1263a.color_item_margins_small);
        setOrientation(1);
    }

    public void setColors(int[] iArr) {
        this.f3261c = iArr;
        this.f3274p = false;
        m5801a();
    }

    public void setSelectedColor(int i) {
        this.f3262d = i;
        this.f3275q.post(new C1272d(this.f3262d));
    }

    public void setOnColorSelectedListener(C1259a c1259a) {
        this.f3263e = c1259a;
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f3265g) {
            size = (m5796b(this.f3266h) + getPaddingLeft()) + getPaddingRight();
            this.f3272n = this.f3266h;
        } else if (mode == 1073741824) {
            this.f3272n = m5793a(size - (getPaddingLeft() + getPaddingRight()));
        } else if (mode == Integer.MIN_VALUE) {
            this.f3272n = m5793a(size - (getPaddingLeft() + getPaddingRight()));
        } else {
            size = (m5796b(4) + getPaddingLeft()) + getPaddingRight();
            this.f3272n = 4;
        }
        this.f3268j = (size - ((m5796b(this.f3272n) + getPaddingLeft()) + getPaddingRight())) / 2;
        if (mode2 == 1073741824) {
            mode = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            mode = (m5798c(this.f3272n) + this.f3269k) + this.f3270l;
            if (this.f3264f) {
                mode += this.f3268j * 2;
            }
            mode = Math.min(mode, size2);
        } else {
            mode = (m5798c(this.f3272n) + this.f3269k) + this.f3270l;
            if (this.f3264f) {
                mode += this.f3268j * 2;
            }
        }
        if (this.f3264f) {
            m5795a(getPaddingLeft(), this.f3269k + this.f3268j, getPaddingRight(), this.f3270l + this.f3268j);
        }
        m5801a();
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
    }

    private int m5793a(int i) {
        int i2 = 0;
        while (((i2 + 1) * this.f3259a) + (((i2 + 1) * 2) * this.f3260b) <= i) {
            i2++;
        }
        return i2;
    }

    private int m5796b(int i) {
        return (this.f3259a + (this.f3260b * 2)) * i;
    }

    private int m5798c(int i) {
        int length = this.f3261c.length / i;
        if (this.f3261c.length % i != 0) {
            length++;
        }
        return length * (this.f3259a + (this.f3260b * 2));
    }

    private void m5795a(int i, int i2, int i3, int i4) {
        this.f3271m = true;
        setPadding(i, i2, i3, i4);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (!this.f3271m) {
            this.f3269k = i2;
            this.f3270l = i4;
        }
    }

    private int getOriginalPaddingTop() {
        return this.f3269k;
    }

    private int getOriginalPaddingBottom() {
        return this.f3270l;
    }

    protected void m5801a() {
        if (!this.f3274p || this.f3272n != this.f3273o) {
            this.f3274p = true;
            this.f3273o = this.f3272n;
            removeAllViews();
            if (this.f3261c != null) {
                View c = m5799c();
                int i = 0;
                for (int a : this.f3261c) {
                    c.addView(m5794a(a, this.f3262d));
                    i++;
                    if (i == this.f3272n) {
                        addView(c);
                        c = m5799c();
                        i = 0;
                    }
                }
                if (i > 0) {
                    while (i < this.f3272n) {
                        c.addView(m5800d());
                        i++;
                    }
                    addView(c);
                }
            }
        }
    }

    private LinearLayout m5799c() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2));
        linearLayout.setGravity(1);
        return linearLayout;
    }

    private C1270b m5794a(int i, int i2) {
        C1270b c1270b = new C1270b(getContext(), i, i == i2, this.f3275q);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f3259a, this.f3259a);
        layoutParams.setMargins(this.f3260b, this.f3260b, this.f3260b, this.f3260b);
        c1270b.setLayoutParams(layoutParams);
        if (this.f3267i != 0) {
            c1270b.setOutlineWidth(this.f3267i);
        }
        this.f3276r.add(c1270b);
        return c1270b;
    }

    private ImageView m5800d() {
        ImageView imageView = new ImageView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f3259a, this.f3259a);
        layoutParams.setMargins(this.f3260b, this.f3260b, this.f3260b, this.f3260b);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Subscribe
    public void onSelectedColorChaxnged(C1272d c1272d) {
        this.f3262d = c1272d.m5826a();
        if (this.f3263e != null) {
            this.f3263e.mo868a(this.f3262d);
        }
    }

    public void setOutlineWidth(int i) {
        this.f3267i = i;
        for (C1270b outlineWidth : this.f3276r) {
            outlineWidth.setOutlineWidth(i);
        }
    }

    public void setFixedColumnCount(int i) {
        if (i > 0) {
            Log.d("spectrum", "set column count to " + i);
            this.f3265g = true;
            this.f3266h = i;
            requestLayout();
            invalidate();
            return;
        }
        this.f3265g = false;
        this.f3266h = -1;
        requestLayout();
        invalidate();
    }
}
