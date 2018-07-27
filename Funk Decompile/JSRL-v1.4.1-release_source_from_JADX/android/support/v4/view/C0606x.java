package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper */
public class C0606x {
    private final ViewGroup f1152a;
    private int f1153b;

    public C0606x(ViewGroup viewGroup) {
        this.f1152a = viewGroup;
    }

    public void m2528a(View view, View view2, int i) {
        this.f1153b = i;
    }

    public int m2526a() {
        return this.f1153b;
    }

    public void m2527a(View view) {
        this.f1153b = 0;
    }
}
