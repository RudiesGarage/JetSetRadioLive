package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: MenuPopup */
abstract class C0720k implements C0711m, C0719q, OnItemClickListener {
    private Rect f1431a;

    public abstract void mo519a(int i);

    public abstract void mo520a(C0724g c0724g);

    public abstract void mo521a(View view);

    public abstract void mo522a(OnDismissListener onDismissListener);

    public abstract void mo523a(boolean z);

    public abstract void mo524b(int i);

    public abstract void mo526c(int i);

    public abstract void mo527c(boolean z);

    C0720k() {
    }

    public void m2957a(Rect rect) {
        this.f1431a = rect;
    }

    public Rect m2968g() {
        return this.f1431a;
    }

    public void mo508a(Context context, C0724g c0724g) {
    }

    public boolean mo511a(C0724g c0724g, C0726h c0726h) {
        return false;
    }

    public boolean mo515b(C0724g c0724g, C0726h c0726h) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        C0720k.m2953a(listAdapter).f1458b.m3025a((MenuItem) listAdapter.getItem(i), (C0711m) this, mo530f() ? 0 : 4);
    }

    protected static int m2952a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        ViewGroup viewGroup2 = viewGroup;
        while (i2 < count) {
            ViewGroup frameLayout;
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                i3 = itemViewType;
                view = null;
            }
            if (viewGroup2 == null) {
                frameLayout = new FrameLayout(context);
            } else {
                frameLayout = viewGroup2;
            }
            view = listAdapter.getView(i2, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth <= i4) {
                measuredWidth = i4;
            }
            i2++;
            i4 = measuredWidth;
            viewGroup2 = frameLayout;
        }
        return i4;
    }

    protected static C0722f m2953a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (C0722f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (C0722f) listAdapter;
    }

    protected static boolean m2954b(C0724g c0724g) {
        int size = c0724g.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0724g.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected boolean mo530f() {
        return true;
    }
}
