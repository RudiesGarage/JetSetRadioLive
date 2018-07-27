package android.support.v7.preference;

import android.content.Context;
import android.support.v7.preference.C0695b.C0691a;
import android.util.AttributeSet;

public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0691a.preferenceCategoryStyle);
    }

    public boolean mo484h() {
        return false;
    }

    public boolean mo480b() {
        return !super.mo484h();
    }
}
