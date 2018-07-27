package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.v4.p018b.p019a.C0283f;
import android.support.v4.p024g.C0356i;
import android.support.v7.preference.C0695b.C0694d;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

public abstract class PreferenceGroup extends Preference {
    private List<Preference> f1293a;
    private boolean f1294b;
    private int f1295c;
    private boolean f1296d;
    private final C0356i<String, Long> f1297e;
    private final Handler f1298f;
    private final Runnable f1299g;

    class C06841 implements Runnable {
        final /* synthetic */ PreferenceGroup f1300a;

        C06841(PreferenceGroup preferenceGroup) {
            this.f1300a = preferenceGroup;
        }

        public void run() {
            synchronized (this) {
                this.f1300a.f1297e.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1294b = true;
        this.f1295c = 0;
        this.f1296d = false;
        this.f1297e = new C0356i();
        this.f1298f = new Handler();
        this.f1299g = new C06841(this);
        this.f1293a = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0694d.PreferenceGroup, i, i2);
        this.f1294b = C0283f.m1065a(obtainStyledAttributes, C0694d.PreferenceGroup_orderingFromXml, C0694d.PreferenceGroup_orderingFromXml, true);
        obtainStyledAttributes.recycle();
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int m2832d() {
        return this.f1293a.size();
    }

    public Preference m2830a(int i) {
        return (Preference) this.f1293a.get(i);
    }

    public void mo483a(boolean z) {
        super.mo483a(z);
        int d = m2832d();
        for (int i = 0; i < d; i++) {
            m2830a(i).m2787b(this, z);
        }
    }
}
