package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C0724g.C0708b;
import android.support.v7.widget.as;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0708b, C0709n, OnItemClickListener {
    private static final int[] f1377a = new int[]{16842964, 16843049};
    private C0724g f1378b;
    private int f1379c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        as a = as.m4294a(context, attributeSet, f1377a, i, 0);
        if (a.m4309f(0)) {
            setBackgroundDrawable(a.m4297a(0));
        }
        if (a.m4309f(1)) {
            setDivider(a.m4297a(1));
        }
        a.m4298a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean mo496a(C0726h c0726h) {
        return this.f1378b.m3024a((MenuItem) c0726h, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo496a((C0726h) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f1379c;
    }
}
