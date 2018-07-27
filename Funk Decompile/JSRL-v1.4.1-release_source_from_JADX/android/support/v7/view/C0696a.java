package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p018b.p019a.C0278a;
import android.support.v4.view.am;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0660b;
import android.support.v7.p027b.C0670a.C0662d;
import android.support.v7.p027b.C0670a.C0669k;
import android.view.ViewConfiguration;

/* compiled from: ActionBarPolicy */
public class C0696a {
    private Context f1315a;

    public static C0696a m2850a(Context context) {
        return new C0696a(context);
    }

    private C0696a(Context context) {
        this.f1315a = context;
    }

    public int m2851a() {
        Resources resources = this.f1315a.getResources();
        int b = C0278a.m1053b(resources);
        int a = C0278a.m1052a(resources);
        if (C0278a.m1054c(resources) > 600 || b > 600 || ((b > 960 && a > 720) || (b > 720 && a > 960))) {
            return 5;
        }
        if (b >= 500 || ((b > 640 && a > 480) || (b > 480 && a > 640))) {
            return 4;
        }
        if (b >= 360) {
            return 3;
        }
        return 2;
    }

    public boolean m2852b() {
        if (VERSION.SDK_INT < 19 && am.m2300b(ViewConfiguration.get(this.f1315a))) {
            return false;
        }
        return true;
    }

    public int m2853c() {
        return this.f1315a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m2854d() {
        return this.f1315a.getResources().getBoolean(C0660b.abc_action_bar_embed_tabs);
    }

    public int m2855e() {
        TypedArray obtainStyledAttributes = this.f1315a.obtainStyledAttributes(null, C0669k.ActionBar, C0659a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0669k.ActionBar_height, 0);
        Resources resources = this.f1315a.getResources();
        if (!m2854d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0662d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public int m2856f() {
        return this.f1315a.getResources().getDimensionPixelSize(C0662d.abc_action_bar_stacked_tab_max_width);
    }
}
