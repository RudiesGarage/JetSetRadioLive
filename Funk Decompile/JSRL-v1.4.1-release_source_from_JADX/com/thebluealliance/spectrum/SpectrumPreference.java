package com.thebluealliance.spectrum;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.thebluealliance.spectrum.C1273a.C1263a;
import com.thebluealliance.spectrum.C1273a.C1264b;
import com.thebluealliance.spectrum.C1273a.C1265c;
import com.thebluealliance.spectrum.C1273a.C1266d;
import com.thebluealliance.spectrum.SpectrumPalette.C1259a;
import com.thebluealliance.spectrum.p046a.C1267a;

public class SpectrumPreference extends DialogPreference {
    private int[] f3279a;
    private int f3280b;
    private boolean f3281c = true;
    private SpectrumPalette f3282d;
    private boolean f3283e = false;
    private View f3284f;
    private int f3285g = 0;
    private int f3286h = -1;
    private OnSharedPreferenceChangeListener f3287i = new C12601(this);

    class C12601 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ SpectrumPreference f3277a;

        C12601(SpectrumPreference spectrumPreference) {
            this.f3277a = spectrumPreference;
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (this.f3277a.getKey().equals(str)) {
                this.f3277a.f3280b = sharedPreferences.getInt(str, this.f3277a.f3280b);
                this.f3277a.m5805a();
            }
        }
    }

    class C12612 implements C1259a {
        final /* synthetic */ SpectrumPreference f3278a;

        C12612(SpectrumPreference spectrumPreference) {
            this.f3278a = spectrumPreference;
        }

        public void mo868a(int i) {
            this.f3278a.f3280b = i;
            this.f3278a.m5805a();
            if (this.f3278a.f3281c) {
                this.f3278a.onClick(null, -1);
                if (this.f3278a.getDialog() != null) {
                    this.f3278a.getDialog().dismiss();
                }
            }
        }
    }

    public SpectrumPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1266d.SpectrumPreference, 0, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(C1266d.SpectrumPreference_spectrum_colors, 0);
            if (resourceId != 0) {
                this.f3279a = getContext().getResources().getIntArray(resourceId);
            }
            this.f3281c = obtainStyledAttributes.getBoolean(C1266d.SpectrumPreference_spectrum_closeOnSelected, true);
            this.f3285g = obtainStyledAttributes.getDimensionPixelSize(C1266d.SpectrumPalette_spectrum_outlineWidth, 0);
            this.f3286h = obtainStyledAttributes.getInt(C1266d.SpectrumPalette_spectrum_columnCount, -1);
            setDialogLayoutResource(C1265c.dialog_color_picker);
            setWidgetLayoutResource(C1265c.color_preference_widget);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected View onCreateView(ViewGroup viewGroup) {
        getSharedPreferences().registerOnSharedPreferenceChangeListener(this.f3287i);
        return super.onCreateView(viewGroup);
    }

    protected void onPrepareForRemoval() {
        super.onPrepareForRemoval();
        getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this.f3287i);
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        this.f3284f = view.findViewById(C1264b.color_preference_widget);
        m5805a();
    }

    protected void onPrepareDialogBuilder(Builder builder) {
        super.onPrepareDialogBuilder(builder);
        if (this.f3281c) {
            builder.setPositiveButton(null, null);
        }
    }

    private void m5805a() {
        if (this.f3284f != null) {
            Drawable c1267a = new C1267a(this.f3280b);
            c1267a.m5816d(this.f3285g);
            if (!isEnabled()) {
                c1267a.m5813a(-16777216);
                c1267a.setAlpha(0);
                c1267a.m5816d(getContext().getResources().getDimensionPixelSize(C1263a.color_preference_disabled_outline_size));
                c1267a.m5814b(-16777216);
                c1267a.m5815c(97);
            }
            if (VERSION.SDK_INT >= 16) {
                this.f3284f.setBackground(c1267a);
            } else {
                this.f3284f.setBackgroundDrawable(c1267a);
            }
        }
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        if (this.f3279a == null) {
            throw new RuntimeException("SpectrumPreference requires a colors array");
        }
        this.f3282d = (SpectrumPalette) view.findViewById(C1264b.palette);
        this.f3282d.setColors(this.f3279a);
        this.f3282d.setSelectedColor(this.f3280b);
        this.f3282d.setOutlineWidth(this.f3285g);
        this.f3282d.setFixedColumnCount(this.f3286h);
        this.f3282d.setOnColorSelectedListener(new C12612(this));
    }

    protected void onDialogClosed(boolean z) {
        if (z) {
            persistInt(this.f3280b);
        }
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        if (z) {
            this.f3280b = getPersistedInt(-16777216);
            return;
        }
        this.f3280b = ((Integer) obj).intValue();
        persistInt(this.f3280b);
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInteger(i, -16777216));
    }
}
