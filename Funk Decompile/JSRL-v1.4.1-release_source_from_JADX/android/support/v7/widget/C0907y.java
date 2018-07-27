package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0793n;
import android.support.v7.widget.RecyclerView.C0798r;
import android.view.View;

/* compiled from: LayoutState */
class C0907y {
    boolean f2455a = true;
    int f2456b;
    int f2457c;
    int f2458d;
    int f2459e;
    int f2460f = 0;
    int f2461g = 0;
    boolean f2462h;
    boolean f2463i;

    C0907y() {
    }

    boolean m4594a(C0798r c0798r) {
        return this.f2457c >= 0 && this.f2457c < c0798r.m3687e();
    }

    View m4593a(C0793n c0793n) {
        View c = c0793n.m3632c(this.f2457c);
        this.f2457c += this.f2458d;
        return c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2456b + ", mCurrentPosition=" + this.f2457c + ", mItemDirection=" + this.f2458d + ", mLayoutDirection=" + this.f2459e + ", mStartLine=" + this.f2460f + ", mEndLine=" + this.f2461g + '}';
    }
}
