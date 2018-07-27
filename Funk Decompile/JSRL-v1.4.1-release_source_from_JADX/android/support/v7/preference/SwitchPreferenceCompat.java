package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.p018b.p019a.C0283f;
import android.support.v7.preference.C0695b.C0691a;
import android.support.v7.preference.C0695b.C0692b;
import android.support.v7.preference.C0695b.C0694d;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class SwitchPreferenceCompat extends TwoStatePreference {
    private final C0686a f1303b;
    private CharSequence f1304c;
    private CharSequence f1305d;

    private class C0686a implements OnCheckedChangeListener {
        final /* synthetic */ SwitchPreferenceCompat f1302a;

        private C0686a(SwitchPreferenceCompat switchPreferenceCompat) {
            this.f1302a = switchPreferenceCompat;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f1302a.m2785a((Object) Boolean.valueOf(z))) {
                this.f1302a.m2811d(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1303b = new C0686a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0694d.SwitchPreferenceCompat, i, i2);
        m2809c(C0283f.m1067b(obtainStyledAttributes, C0694d.SwitchPreferenceCompat_summaryOn, C0694d.SwitchPreferenceCompat_android_summaryOn));
        m2810d(C0283f.m1067b(obtainStyledAttributes, C0694d.SwitchPreferenceCompat_summaryOff, C0694d.SwitchPreferenceCompat_android_summaryOff));
        m2839a(C0283f.m1067b(obtainStyledAttributes, C0694d.SwitchPreferenceCompat_switchTextOn, C0694d.SwitchPreferenceCompat_android_switchTextOn));
        m2840b(C0283f.m1067b(obtainStyledAttributes, C0694d.SwitchPreferenceCompat_switchTextOff, C0694d.SwitchPreferenceCompat_android_switchTextOff));
        m2813e(C0283f.m1065a(obtainStyledAttributes, C0694d.SwitchPreferenceCompat_disableDependentsState, C0694d.SwitchPreferenceCompat_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0691a.switchPreferenceCompatStyle);
    }

    public void m2839a(CharSequence charSequence) {
        this.f1304c = charSequence;
        m2802o();
    }

    public void m2840b(CharSequence charSequence) {
        this.f1305d = charSequence;
        m2802o();
    }

    protected void mo481a(View view) {
        super.mo481a(view);
        m2836c(view);
    }

    private void m2836c(View view) {
        if (((AccessibilityManager) m2801n().getSystemService("accessibility")).isEnabled()) {
            m2837d(view.findViewById(C0692b.switchWidget));
            m2807b(view.findViewById(16908304));
        }
    }

    private void m2837d(View view) {
        if (view instanceof SwitchCompat) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.a);
        }
        if (view instanceof SwitchCompat) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f1304c);
            switchCompat.setTextOff(this.f1305d);
            switchCompat.setOnCheckedChangeListener(this.f1303b);
        }
    }
}
