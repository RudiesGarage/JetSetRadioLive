package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0763h;
import android.support.v7.widget.RecyclerView.C0798r;
import android.view.View;

/* compiled from: ScrollbarHelper */
class aj {
    static int m4223a(C0798r c0798r, af afVar, View view, View view2, C0763h c0763h, boolean z, boolean z2) {
        if (c0763h.m3367t() == 0 || c0798r.m3687e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (c0798r.m3687e() - Math.max(c0763h.m3330d(view), c0763h.m3330d(view2))) - 1) : Math.max(0, Math.min(c0763h.m3330d(view), c0763h.m3330d(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(afVar.mo655b(view2) - afVar.mo653a(view))) / ((float) (Math.abs(c0763h.m3330d(view) - c0763h.m3330d(view2)) + 1)))) + ((float) (afVar.mo656c() - afVar.mo653a(view))));
    }

    static int m4222a(C0798r c0798r, af afVar, View view, View view2, C0763h c0763h, boolean z) {
        if (c0763h.m3367t() == 0 || c0798r.m3687e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(c0763h.m3330d(view) - c0763h.m3330d(view2)) + 1;
        }
        return Math.min(afVar.mo661f(), afVar.mo655b(view2) - afVar.mo653a(view));
    }

    static int m4224b(C0798r c0798r, af afVar, View view, View view2, C0763h c0763h, boolean z) {
        if (c0763h.m3367t() == 0 || c0798r.m3687e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c0798r.m3687e();
        }
        return (int) ((((float) (afVar.mo655b(view2) - afVar.mo653a(view))) / ((float) (Math.abs(c0763h.m3330d(view) - c0763h.m3330d(view2)) + 1))) * ((float) c0798r.m3687e()));
    }
}
