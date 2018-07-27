package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public abstract class TwoStatePreference extends Preference {
    protected boolean f1276a;
    private CharSequence f1277b;
    private CharSequence f1278c;
    private boolean f1279d;
    private boolean f1280e;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void mo479a() {
        super.mo479a();
        boolean z = !m2812d();
        if (m2785a((Object) Boolean.valueOf(z))) {
            m2811d(z);
        }
    }

    public void m2811d(boolean z) {
        boolean z2 = this.f1276a != z;
        if (z2 || !this.f1279d) {
            this.f1276a = z;
            this.f1279d = true;
            m2789b(z);
            if (z2) {
                mo483a(mo480b());
                m2802o();
            }
        }
    }

    public boolean m2812d() {
        return this.f1276a;
    }

    public boolean mo480b() {
        boolean z = this.f1280e ? this.f1276a : !this.f1276a;
        if (z || super.mo480b()) {
            return true;
        }
        return false;
    }

    public void m2809c(CharSequence charSequence) {
        this.f1277b = charSequence;
        if (m2812d()) {
            m2802o();
        }
    }

    public void m2810d(CharSequence charSequence) {
        this.f1278c = charSequence;
        if (!m2812d()) {
            m2802o();
        }
    }

    public void m2813e(boolean z) {
        this.f1280e = z;
    }

    protected Object mo478a(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    protected void m2807b(View view) {
        int i = 0;
        if (view instanceof TextView) {
            int i2;
            TextView textView = (TextView) view;
            int i3 = 1;
            if (this.f1276a && !TextUtils.isEmpty(this.f1277b)) {
                textView.setText(this.f1277b);
                i3 = 0;
            } else if (!(this.f1276a || TextUtils.isEmpty(this.f1278c))) {
                textView.setText(this.f1278c);
                i3 = 0;
            }
            if (i3 != 0) {
                CharSequence c = mo482c();
                if (!TextUtils.isEmpty(c)) {
                    textView.setText(c);
                    i2 = 0;
                    if (i2 != 0) {
                        i = 8;
                    }
                    if (i != textView.getVisibility()) {
                        textView.setVisibility(i);
                    }
                }
            }
            i2 = i3;
            if (i2 != 0) {
                i = 8;
            }
            if (i != textView.getVisibility()) {
                textView.setVisibility(i);
            }
        }
    }
}
