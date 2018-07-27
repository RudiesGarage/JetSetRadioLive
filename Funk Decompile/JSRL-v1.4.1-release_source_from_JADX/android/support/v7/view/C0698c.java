package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.p027b.C0670a.C0668j;
import android.view.LayoutInflater;

/* compiled from: ContextThemeWrapper */
public class C0698c extends ContextWrapper {
    private int f1316a;
    private Theme f1317b;
    private LayoutInflater f1318c;

    public C0698c(Context context, int i) {
        super(context);
        this.f1316a = i;
    }

    public C0698c(Context context, Theme theme) {
        super(context);
        this.f1317b = theme;
    }

    public void setTheme(int i) {
        if (this.f1316a != i) {
            this.f1316a = i;
            m2859a();
        }
    }

    public Theme getTheme() {
        if (this.f1317b != null) {
            return this.f1317b;
        }
        if (this.f1316a == 0) {
            this.f1316a = C0668j.Theme_AppCompat_Light;
        }
        m2859a();
        return this.f1317b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1318c == null) {
            this.f1318c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1318c;
    }

    protected void m2860a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void m2859a() {
        boolean z = this.f1317b == null;
        if (z) {
            this.f1317b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1317b.setTo(theme);
            }
        }
        m2860a(this.f1317b, this.f1316a, z);
    }
}
