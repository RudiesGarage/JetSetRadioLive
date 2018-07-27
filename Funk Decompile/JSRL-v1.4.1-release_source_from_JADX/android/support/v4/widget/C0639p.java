package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: ScrollerCompat */
public final class C0639p {
    OverScroller f1234a;
    private final boolean f1235b;

    public static C0639p m2683a(Context context) {
        return C0639p.m2684a(context, null);
    }

    public static C0639p m2684a(Context context, Interpolator interpolator) {
        return new C0639p(VERSION.SDK_INT >= 14, context, interpolator);
    }

    C0639p(boolean z, Context context, Interpolator interpolator) {
        this.f1235b = z;
        this.f1234a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public boolean m2689a() {
        return this.f1234a.isFinished();
    }

    public int m2691b() {
        return this.f1234a.getCurrX();
    }

    public int m2692c() {
        return this.f1234a.getCurrY();
    }

    public int m2693d() {
        return this.f1234a.getFinalX();
    }

    public int m2694e() {
        return this.f1234a.getFinalY();
    }

    public float m2695f() {
        return this.f1235b ? C0640q.m2698a(this.f1234a) : 0.0f;
    }

    public boolean m2696g() {
        return this.f1234a.computeScrollOffset();
    }

    public void m2685a(int i, int i2, int i3, int i4) {
        this.f1234a.startScroll(i, i2, i3, i4);
    }

    public void m2686a(int i, int i2, int i3, int i4, int i5) {
        this.f1234a.startScroll(i, i2, i3, i4, i5);
    }

    public void m2687a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1234a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m2688a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1234a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m2690a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f1234a.springBack(i, i2, i3, i4, i5, i6);
    }

    public void m2697h() {
        this.f1234a.abortAnimation();
    }
}
