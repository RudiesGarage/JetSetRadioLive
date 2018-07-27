package android.support.v7.preference;

import android.content.Context;
import android.support.v7.preference.C0690a.C0688b;
import android.support.v7.preference.C0695b.C0691a;
import android.util.AttributeSet;

public final class PreferenceScreen extends PreferenceGroup {
    private boolean f1301a = true;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, C0691a.preferenceScreenStyle);
    }

    protected void mo479a() {
        if (m2792e() == null && m2793f() == null && m2832d() != 0) {
            C0688b e = m2803p().m2849e();
            if (e != null) {
                e.m2842a(this);
            }
        }
    }
}
