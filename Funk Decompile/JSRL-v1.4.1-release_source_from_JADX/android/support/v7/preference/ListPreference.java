package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.p018b.p019a.C0283f;
import android.support.v7.preference.C0695b.C0691a;
import android.support.v7.preference.C0695b.C0694d;
import android.util.AttributeSet;

public class ListPreference extends DialogPreference {
    private CharSequence[] f1288a;
    private CharSequence[] f1289b;
    private String f1290c;
    private String f1291d;

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0694d.ListPreference, i, i2);
        this.f1288a = C0283f.m1068c(obtainStyledAttributes, C0694d.ListPreference_entries, C0694d.ListPreference_android_entries);
        this.f1289b = C0283f.m1068c(obtainStyledAttributes, C0694d.ListPreference_entryValues, C0694d.ListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0694d.Preference, i, i2);
        this.f1291d = C0283f.m1067b(obtainStyledAttributes, C0694d.Preference_summary, C0694d.Preference_android_summary);
        obtainStyledAttributes.recycle();
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0691a.dialogPreferenceStyle);
    }

    public CharSequence mo482c() {
        CharSequence d = m2825d();
        if (this.f1291d == null) {
            return super.mo482c();
        }
        String str = this.f1291d;
        Object[] objArr = new Object[1];
        if (d == null) {
            d = "";
        }
        objArr[0] = d;
        return String.format(str, objArr);
    }

    public CharSequence m2825d() {
        int r = m2821r();
        return (r < 0 || this.f1288a == null) ? null : this.f1288a[r];
    }

    public int m2822a(String str) {
        if (!(str == null || this.f1289b == null)) {
            for (int length = this.f1289b.length - 1; length >= 0; length--) {
                if (this.f1289b[length].equals(str)) {
                    return length;
                }
            }
        }
        return -1;
    }

    private int m2821r() {
        return m2822a(this.f1290c);
    }

    protected Object mo478a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }
}
