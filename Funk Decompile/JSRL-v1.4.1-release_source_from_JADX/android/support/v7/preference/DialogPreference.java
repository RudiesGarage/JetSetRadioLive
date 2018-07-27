package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.p018b.p019a.C0283f;
import android.support.v7.preference.C0695b.C0691a;
import android.support.v7.preference.C0695b.C0694d;
import android.util.AttributeSet;

public abstract class DialogPreference extends Preference {
    private CharSequence f1281a;
    private CharSequence f1282b;
    private Drawable f1283c;
    private CharSequence f1284d;
    private CharSequence f1285e;
    private int f1286f;

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0694d.DialogPreference, i, i2);
        this.f1281a = C0283f.m1067b(obtainStyledAttributes, C0694d.DialogPreference_dialogTitle, C0694d.DialogPreference_android_dialogTitle);
        if (this.f1281a == null) {
            this.f1281a = m2794g();
        }
        this.f1282b = C0283f.m1067b(obtainStyledAttributes, C0694d.DialogPreference_dialogMessage, C0694d.DialogPreference_android_dialogMessage);
        this.f1283c = C0283f.m1064a(obtainStyledAttributes, C0694d.DialogPreference_dialogIcon, C0694d.DialogPreference_android_dialogIcon);
        this.f1284d = C0283f.m1067b(obtainStyledAttributes, C0694d.DialogPreference_positiveButtonText, C0694d.DialogPreference_android_positiveButtonText);
        this.f1285e = C0283f.m1067b(obtainStyledAttributes, C0694d.DialogPreference_negativeButtonText, C0694d.DialogPreference_android_negativeButtonText);
        this.f1286f = C0283f.m1066b(obtainStyledAttributes, C0694d.DialogPreference_dialogLayout, C0694d.DialogPreference_android_dialogLayout, 0);
        obtainStyledAttributes.recycle();
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0691a.dialogPreferenceStyle);
    }

    public void m2818a(int i) {
        this.f1286f = i;
    }

    protected void mo479a() {
        m2803p().m2845a(this);
    }
}
