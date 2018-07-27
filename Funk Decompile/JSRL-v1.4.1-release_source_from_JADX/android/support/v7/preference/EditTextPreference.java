package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.C0695b.C0691a;
import android.text.TextUtils;
import android.util.AttributeSet;

public class EditTextPreference extends DialogPreference {
    private String f1287a;

    public EditTextPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0691a.editTextPreferenceStyle);
    }

    protected Object mo478a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    public boolean mo480b() {
        return TextUtils.isEmpty(this.f1287a) || super.mo480b();
    }
}
