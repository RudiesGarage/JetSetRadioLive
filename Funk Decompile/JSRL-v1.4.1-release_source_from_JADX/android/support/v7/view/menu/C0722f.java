package android.support.v7.view.menu;

import android.support.v7.p027b.C0670a.C0666h;
import android.support.v7.view.menu.C0709n.C0706a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* compiled from: MenuAdapter */
public class C0722f extends BaseAdapter {
    static final int f1457a = C0666h.abc_popup_menu_item_layout;
    C0724g f1458b;
    private int f1459c = -1;
    private boolean f1460d;
    private final boolean f1461e;
    private final LayoutInflater f1462f;

    public /* synthetic */ Object getItem(int i) {
        return m2995a(i);
    }

    public C0722f(C0724g c0724g, LayoutInflater layoutInflater, boolean z) {
        this.f1461e = z;
        this.f1462f = layoutInflater;
        this.f1458b = c0724g;
        m2997b();
    }

    public void m2996a(boolean z) {
        this.f1460d = z;
    }

    public int getCount() {
        ArrayList k = this.f1461e ? this.f1458b.m3042k() : this.f1458b.m3039h();
        if (this.f1459c < 0) {
            return k.size();
        }
        return k.size() - 1;
    }

    public C0724g m2994a() {
        return this.f1458b;
    }

    public C0726h m2995a(int i) {
        ArrayList k = this.f1461e ? this.f1458b.m3042k() : this.f1458b.m3039h();
        if (this.f1459c >= 0 && i >= this.f1459c) {
            i++;
        }
        return (C0726h) k.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.f1462f.inflate(f1457a, viewGroup, false);
        } else {
            inflate = view;
        }
        C0706a c0706a = (C0706a) inflate;
        if (this.f1460d) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        c0706a.mo491a(m2995a(i), 0);
        return inflate;
    }

    void m2997b() {
        C0726h o = this.f1458b.m3046o();
        if (o != null) {
            ArrayList k = this.f1458b.m3042k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                if (((C0726h) k.get(i)) == o) {
                    this.f1459c = i;
                    return;
                }
            }
        }
        this.f1459c = -1;
    }

    public void notifyDataSetChanged() {
        m2997b();
        super.notifyDataSetChanged();
    }
}
