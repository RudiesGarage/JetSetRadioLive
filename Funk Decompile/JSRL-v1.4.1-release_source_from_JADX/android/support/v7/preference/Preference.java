package android.support.v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.support.v4.p018b.C0294g.C0293a;
import android.support.v4.p018b.p019a.C0283f;
import android.support.v7.preference.C0690a.C0689c;
import android.support.v7.preference.C0695b.C0691a;
import android.support.v7.preference.C0695b.C0693c;
import android.support.v7.preference.C0695b.C0694d;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

public class Preference implements Comparable<Preference> {
    private Context f1251a;
    private C0690a f1252b;
    private C0682b f1253c;
    private C0683c f1254d;
    private int f1255e;
    private CharSequence f1256f;
    private CharSequence f1257g;
    private int f1258h;
    private String f1259i;
    private Intent f1260j;
    private String f1261k;
    private boolean f1262l;
    private boolean f1263m;
    private boolean f1264n;
    private String f1265o;
    private Object f1266p;
    private boolean f1267q;
    private boolean f1268r;
    private boolean f1269s;
    private boolean f1270t;
    private int f1271u;
    private int f1272v;
    private C0681a f1273w;
    private List<Preference> f1274x;
    private final OnClickListener f1275y;

    class C06801 implements OnClickListener {
        final /* synthetic */ Preference f1292a;

        C06801(Preference preference) {
            this.f1292a = preference;
        }

        public void onClick(View view) {
            this.f1292a.mo481a(view);
        }
    }

    interface C0681a {
        void m2826a(Preference preference);
    }

    public interface C0682b {
        boolean m2827a(Preference preference, Object obj);
    }

    public interface C0683c {
        boolean m2828a(Preference preference);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m2779a((Preference) obj);
    }

    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1255e = Integer.MAX_VALUE;
        this.f1262l = true;
        this.f1263m = true;
        this.f1264n = true;
        this.f1267q = true;
        this.f1268r = true;
        this.f1269s = true;
        this.f1270t = true;
        this.f1271u = C0693c.preference;
        this.f1275y = new C06801(this);
        this.f1251a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0694d.Preference, i, i2);
        this.f1258h = C0283f.m1066b(obtainStyledAttributes, C0694d.Preference_icon, C0694d.Preference_android_icon, 0);
        this.f1259i = C0283f.m1067b(obtainStyledAttributes, C0694d.Preference_key, C0694d.Preference_android_key);
        this.f1256f = C0283f.m1067b(obtainStyledAttributes, C0694d.Preference_title, C0694d.Preference_android_title);
        this.f1257g = C0283f.m1067b(obtainStyledAttributes, C0694d.Preference_summary, C0694d.Preference_android_summary);
        this.f1255e = C0283f.m1063a(obtainStyledAttributes, C0694d.Preference_order, C0694d.Preference_android_order, Integer.MAX_VALUE);
        this.f1261k = C0283f.m1067b(obtainStyledAttributes, C0694d.Preference_fragment, C0694d.Preference_android_fragment);
        this.f1271u = C0283f.m1066b(obtainStyledAttributes, C0694d.Preference_layout, C0694d.Preference_android_layout, C0693c.preference);
        this.f1272v = C0283f.m1066b(obtainStyledAttributes, C0694d.Preference_widgetLayout, C0694d.Preference_android_widgetLayout, 0);
        this.f1262l = C0283f.m1065a(obtainStyledAttributes, C0694d.Preference_enabled, C0694d.Preference_android_enabled, true);
        this.f1263m = C0283f.m1065a(obtainStyledAttributes, C0694d.Preference_selectable, C0694d.Preference_android_selectable, true);
        this.f1264n = C0283f.m1065a(obtainStyledAttributes, C0694d.Preference_persistent, C0694d.Preference_android_persistent, true);
        this.f1265o = C0283f.m1067b(obtainStyledAttributes, C0694d.Preference_dependency, C0694d.Preference_android_dependency);
        if (obtainStyledAttributes.hasValue(C0694d.Preference_defaultValue)) {
            this.f1266p = mo478a(obtainStyledAttributes, C0694d.Preference_defaultValue);
        } else if (obtainStyledAttributes.hasValue(C0694d.Preference_android_defaultValue)) {
            this.f1266p = mo478a(obtainStyledAttributes, C0694d.Preference_android_defaultValue);
        }
        this.f1270t = C0283f.m1065a(obtainStyledAttributes, C0694d.Preference_shouldDisableView, C0694d.Preference_shouldDisableView, true);
        obtainStyledAttributes.recycle();
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0691a.preferenceStyle);
    }

    protected Object mo478a(TypedArray typedArray, int i) {
        return null;
    }

    public Intent m2792e() {
        return this.f1260j;
    }

    public String m2793f() {
        return this.f1261k;
    }

    public void m2786b(int i) {
        this.f1272v = i;
    }

    public CharSequence m2794g() {
        return this.f1256f;
    }

    public CharSequence mo482c() {
        return this.f1257g;
    }

    public boolean mo484h() {
        return this.f1262l && this.f1267q && this.f1268r;
    }

    protected void mo479a() {
    }

    public String m2796i() {
        return this.f1259i;
    }

    public boolean m2797j() {
        return !TextUtils.isEmpty(this.f1259i);
    }

    public boolean m2798k() {
        return this.f1264n;
    }

    protected boolean m2799l() {
        return this.f1252b != null && m2798k() && m2797j();
    }

    public boolean m2785a(Object obj) {
        return this.f1253c == null || this.f1253c.m2827a(this, obj);
    }

    protected void mo481a(View view) {
        m2800m();
    }

    public void m2800m() {
        if (mo484h()) {
            mo479a();
            if (this.f1254d == null || !this.f1254d.m2828a(this)) {
                C0690a p = m2803p();
                if (p != null) {
                    C0689c d = p.m2848d();
                    if (d != null && d.m2843a(this)) {
                        return;
                    }
                }
                if (this.f1260j != null) {
                    m2801n().startActivity(this.f1260j);
                }
            }
        }
    }

    public Context m2801n() {
        return this.f1251a;
    }

    public int m2779a(Preference preference) {
        if (this.f1255e != preference.f1255e) {
            return this.f1255e - preference.f1255e;
        }
        if (this.f1256f == preference.f1256f) {
            return 0;
        }
        if (this.f1256f == null) {
            return 1;
        }
        if (preference.f1256f == null) {
            return -1;
        }
        return this.f1256f.toString().compareToIgnoreCase(preference.f1256f.toString());
    }

    protected void m2802o() {
        if (this.f1273w != null) {
            this.f1273w.m2826a(this);
        }
    }

    public C0690a m2803p() {
        return this.f1252b;
    }

    public void mo483a(boolean z) {
        List list = this.f1274x;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((Preference) list.get(i)).m2782a(this, z);
            }
        }
    }

    public void m2782a(Preference preference, boolean z) {
        if (this.f1267q == z) {
            this.f1267q = !z;
            mo483a(mo480b());
            m2802o();
        }
    }

    public void m2787b(Preference preference, boolean z) {
        if (this.f1268r == z) {
            this.f1268r = !z;
            mo483a(mo480b());
            m2802o();
        }
    }

    public boolean mo480b() {
        return !mo484h();
    }

    private void m2778a(Editor editor) {
        if (this.f1252b.m2847c()) {
            C0293a.m1090a().m1091a(editor);
        }
    }

    protected boolean m2789b(boolean z) {
        boolean z2 = false;
        if (!m2799l()) {
            return false;
        }
        if (!z) {
            z2 = true;
        }
        if (z == m2791c(z2)) {
            return true;
        }
        Editor b = this.f1252b.m2846b();
        b.putBoolean(this.f1259i, z);
        m2778a(b);
        return true;
    }

    protected boolean m2791c(boolean z) {
        return !m2799l() ? z : this.f1252b.m2844a().getBoolean(this.f1259i, z);
    }

    public String toString() {
        return m2804q().toString();
    }

    StringBuilder m2804q() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence g = m2794g();
        if (!TextUtils.isEmpty(g)) {
            stringBuilder.append(g).append(' ');
        }
        g = mo482c();
        if (!TextUtils.isEmpty(g)) {
            stringBuilder.append(g).append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder;
    }
}
