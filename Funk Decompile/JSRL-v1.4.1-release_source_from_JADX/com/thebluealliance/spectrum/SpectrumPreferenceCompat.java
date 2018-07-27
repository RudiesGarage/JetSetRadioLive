package com.thebluealliance.spectrum;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import com.thebluealliance.spectrum.C1273a.C1263a;
import com.thebluealliance.spectrum.C1273a.C1265c;
import com.thebluealliance.spectrum.C1273a.C1266d;
import com.thebluealliance.spectrum.p046a.C1267a;

public class SpectrumPreferenceCompat extends DialogPreference {
    private int[] f3289a;
    private int f3290b;
    private boolean f3291c = true;
    private boolean f3292d = false;
    private View f3293e;
    private int f3294f = 0;
    private int f3295g = -1;
    private OnSharedPreferenceChangeListener f3296h = new C12621(this);

    class C12621 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ SpectrumPreferenceCompat f3288a;

        C12621(SpectrumPreferenceCompat spectrumPreferenceCompat) {
            this.f3288a = spectrumPreferenceCompat;
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (this.f3288a.m2796i().equals(str)) {
                this.f3288a.f3290b = sharedPreferences.getInt(str, this.f3288a.f3290b);
                this.f3288a.m5811d();
            }
        }
    }

    public SpectrumPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1266d.SpectrumPreference, 0, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(C1266d.SpectrumPreference_spectrum_colors, 0);
            if (resourceId != 0) {
                this.f3289a = m2801n().getResources().getIntArray(resourceId);
            }
            this.f3291c = obtainStyledAttributes.getBoolean(C1266d.SpectrumPreference_spectrum_closeOnSelected, true);
            this.f3294f = obtainStyledAttributes.getDimensionPixelSize(C1266d.SpectrumPalette_spectrum_outlineWidth, 0);
            this.f3295g = obtainStyledAttributes.getInt(C1266d.SpectrumPalette_spectrum_columnCount, -1);
            m2818a(C1265c.dialog_color_picker);
            m2786b(C1265c.color_preference_widget);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m5811d() {
        if (this.f3293e != null) {
            Drawable c1267a = new C1267a(this.f3290b);
            c1267a.m5816d(this.f3294f);
            if (!mo484h()) {
                c1267a.m5813a(-1);
                c1267a.setAlpha(0);
                c1267a.m5816d(m2801n().getResources().getDimensionPixelSize(C1263a.color_preference_disabled_outline_size));
                c1267a.m5814b(-16777216);
                c1267a.m5815c(97);
            }
            if (VERSION.SDK_INT >= 16) {
                this.f3293e.setBackground(c1267a);
            } else {
                this.f3293e.setBackgroundDrawable(c1267a);
            }
        }
    }

    protected Object mo478a(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInteger(i, -16777216));
    }
}
