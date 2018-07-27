package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ae;
import android.support.v7.view.menu.C0709n.C0706a;
import android.support.v7.view.menu.C0711m.C0736a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter */
public abstract class C0712b implements C0711m {
    protected Context f1409a;
    protected Context f1410b;
    protected C0724g f1411c;
    protected LayoutInflater f1412d;
    protected LayoutInflater f1413e;
    protected C0709n f1414f;
    private C0736a f1415g;
    private int f1416h;
    private int f1417i;

    public abstract void mo686a(C0726h c0726h, C0706a c0706a);

    public C0712b(Context context, int i, int i2) {
        this.f1409a = context;
        this.f1412d = LayoutInflater.from(context);
        this.f1416h = i;
        this.f1417i = i2;
    }

    public void mo508a(Context context, C0724g c0724g) {
        this.f1410b = context;
        this.f1413e = LayoutInflater.from(this.f1410b);
        this.f1411c = c0724g;
    }

    public void mo513b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1414f;
        if (viewGroup != null) {
            int i;
            if (this.f1411c != null) {
                this.f1411c.m3040i();
                ArrayList h = this.f1411c.m3039h();
                int size = h.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    C0726h c0726h = (C0726h) h.get(i2);
                    if (mo688a(i, c0726h)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0726h itemData = childAt instanceof C0706a ? ((C0706a) childAt).getItemData() : null;
                        View a = mo685a(c0726h, childAt, viewGroup);
                        if (c0726h != itemData) {
                            a.setPressed(false);
                            ae.m2238r(a);
                        }
                        if (a != childAt) {
                            m2930a(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo689a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void m2930a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1414f).addView(view, i);
    }

    protected boolean mo689a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void mo510a(C0736a c0736a) {
        this.f1415g = c0736a;
    }

    public C0736a m2923a() {
        return this.f1415g;
    }

    public C0706a m2924a(ViewGroup viewGroup) {
        return (C0706a) this.f1412d.inflate(this.f1417i, viewGroup, false);
    }

    public View mo685a(C0726h c0726h, View view, ViewGroup viewGroup) {
        C0706a c0706a;
        if (view instanceof C0706a) {
            c0706a = (C0706a) view;
        } else {
            c0706a = m2924a(viewGroup);
        }
        mo686a(c0726h, c0706a);
        return (View) c0706a;
    }

    public boolean mo688a(int i, C0726h c0726h) {
        return true;
    }

    public void mo509a(C0724g c0724g, boolean z) {
        if (this.f1415g != null) {
            this.f1415g.mo559a(c0724g, z);
        }
    }

    public boolean mo512a(C0741s c0741s) {
        if (this.f1415g != null) {
            return this.f1415g.mo560a(c0741s);
        }
        return false;
    }

    public boolean mo514b() {
        return false;
    }

    public boolean mo511a(C0724g c0724g, C0726h c0726h) {
        return false;
    }

    public boolean mo515b(C0724g c0724g, C0726h c0726h) {
        return false;
    }
}
