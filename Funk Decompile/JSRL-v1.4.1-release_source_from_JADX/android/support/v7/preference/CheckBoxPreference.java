package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.p018b.p019a.C0283f;
import android.support.v7.preference.C0695b.C0691a;
import android.support.v7.preference.C0695b.C0692b;
import android.support.v7.preference.C0695b.C0694d;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;

public class CheckBoxPreference extends TwoStatePreference {
    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0694d.CheckBoxPreference, i, i2);
        m2809c(C0283f.m1067b(obtainStyledAttributes, C0694d.CheckBoxPreference_summaryOn, C0694d.CheckBoxPreference_android_summaryOn));
        m2810d(C0283f.m1067b(obtainStyledAttributes, C0694d.CheckBoxPreference_summaryOff, C0694d.CheckBoxPreference_android_summaryOff));
        m2813e(C0283f.m1065a(obtainStyledAttributes, C0694d.CheckBoxPreference_disableDependentsState, C0694d.CheckBoxPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0691a.checkBoxPreferenceStyle);
    }

    protected void mo481a(View view) {
        super.mo481a(view);
        m2814c(view);
    }

    private void m2814c(View view) {
        if (((AccessibilityManager) m2801n().getSystemService("accessibility")).isEnabled()) {
            m2815d(view.findViewById(C0692b.checkbox));
            m2807b(view.findViewById(16908304));
        }
    }

    private void m2815d(View view) {
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.a);
        }
    }
}
