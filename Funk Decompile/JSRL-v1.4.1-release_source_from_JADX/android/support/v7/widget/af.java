package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0761i;
import android.support.v7.widget.RecyclerView.C0763h;
import android.view.View;

/* compiled from: OrientationHelper */
public abstract class af {
    protected final C0763h f2165a;
    private int f2166b;

    public abstract int mo653a(View view);

    public abstract void mo654a(int i);

    public abstract int mo655b(View view);

    public abstract int mo656c();

    public abstract int mo657c(View view);

    public abstract int mo658d();

    public abstract int mo659d(View view);

    public abstract int mo660e();

    public abstract int mo661f();

    public abstract int mo662g();

    public abstract int mo663h();

    public abstract int mo664i();

    private af(C0763h c0763h) {
        this.f2166b = Integer.MIN_VALUE;
        this.f2165a = c0763h;
    }

    public void m4170a() {
        this.f2166b = mo661f();
    }

    public int m4172b() {
        return Integer.MIN_VALUE == this.f2166b ? 0 : mo661f() - this.f2166b;
    }

    public static af m4167a(C0763h c0763h, int i) {
        switch (i) {
            case 0:
                return m4166a(c0763h);
            case 1:
                return m4168b(c0763h);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static af m4166a(C0763h c0763h) {
        return new af(c0763h) {
            public int mo658d() {
                return this.a.m3370w() - this.a.m3254A();
            }

            public int mo660e() {
                return this.a.m3370w();
            }

            public void mo654a(int i) {
                this.a.mo636i(i);
            }

            public int mo656c() {
                return this.a.m3372y();
            }

            public int mo657c(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.rightMargin + (this.a.m3342f(view) + c0761i.leftMargin);
            }

            public int mo659d(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.bottomMargin + (this.a.m3346g(view) + c0761i.topMargin);
            }

            public int mo655b(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.rightMargin + this.a.m3352j(view);
            }

            public int mo653a(View view) {
                return this.a.m3348h(view) - ((C0761i) view.getLayoutParams()).leftMargin;
            }

            public int mo661f() {
                return (this.a.m3370w() - this.a.m3372y()) - this.a.m3254A();
            }

            public int mo662g() {
                return this.a.m3254A();
            }

            public int mo663h() {
                return this.a.m3368u();
            }

            public int mo664i() {
                return this.a.m3369v();
            }
        };
    }

    public static af m4168b(C0763h c0763h) {
        return new af(c0763h) {
            public int mo658d() {
                return this.a.m3371x() - this.a.m3255B();
            }

            public int mo660e() {
                return this.a.m3371x();
            }

            public void mo654a(int i) {
                this.a.mo637j(i);
            }

            public int mo656c() {
                return this.a.m3373z();
            }

            public int mo657c(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.bottomMargin + (this.a.m3346g(view) + c0761i.topMargin);
            }

            public int mo659d(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.rightMargin + (this.a.m3342f(view) + c0761i.leftMargin);
            }

            public int mo655b(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.bottomMargin + this.a.m3354k(view);
            }

            public int mo653a(View view) {
                return this.a.m3350i(view) - ((C0761i) view.getLayoutParams()).topMargin;
            }

            public int mo661f() {
                return (this.a.m3371x() - this.a.m3373z()) - this.a.m3255B();
            }

            public int mo662g() {
                return this.a.m3255B();
            }

            public int mo663h() {
                return this.a.m3369v();
            }

            public int mo664i() {
                return this.a.m3368u();
            }
        };
    }
}
