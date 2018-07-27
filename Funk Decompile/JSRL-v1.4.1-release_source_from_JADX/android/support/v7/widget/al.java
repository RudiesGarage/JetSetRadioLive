package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0785e;
import android.support.v7.widget.RecyclerView.C0785e.C0784c;
import android.support.v7.widget.RecyclerView.C0801u;
import android.view.View;

/* compiled from: SimpleItemAnimator */
public abstract class al extends C0785e {
    boolean f2199a = true;

    public abstract boolean mo700a(C0801u c0801u);

    public abstract boolean mo701a(C0801u c0801u, int i, int i2, int i3, int i4);

    public abstract boolean mo702a(C0801u c0801u, C0801u c0801u2, int i, int i2, int i3, int i4);

    public abstract boolean mo705b(C0801u c0801u);

    public boolean mo671g(C0801u c0801u) {
        return !this.f2199a || c0801u.m3734n();
    }

    public boolean mo667a(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
        int i = c0784c.f1762a;
        int i2 = c0784c.f1763b;
        View view = c0801u.f1823a;
        int left = c0784c2 == null ? view.getLeft() : c0784c2.f1762a;
        int top = c0784c2 == null ? view.getTop() : c0784c2.f1763b;
        if (c0801u.m3737q() || (i == left && i2 == top)) {
            return mo700a(c0801u);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo701a(c0801u, i, i2, left, top);
    }

    public boolean mo669b(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
        if (c0784c == null || (c0784c.f1762a == c0784c2.f1762a && c0784c.f1763b == c0784c2.f1763b)) {
            return mo705b(c0801u);
        }
        return mo701a(c0801u, c0784c.f1762a, c0784c.f1763b, c0784c2.f1762a, c0784c2.f1763b);
    }

    public boolean mo670c(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
        if (c0784c.f1762a == c0784c2.f1762a && c0784c.f1763b == c0784c2.f1763b) {
            m4248i(c0801u);
            return false;
        }
        return mo701a(c0801u, c0784c.f1762a, c0784c.f1763b, c0784c2.f1762a, c0784c2.f1763b);
    }

    public boolean mo668a(C0801u c0801u, C0801u c0801u2, C0784c c0784c, C0784c c0784c2) {
        int i;
        int i2;
        int i3 = c0784c.f1762a;
        int i4 = c0784c.f1763b;
        if (c0801u2.m3723c()) {
            i = c0784c.f1762a;
            i2 = c0784c.f1763b;
        } else {
            i = c0784c2.f1762a;
            i2 = c0784c2.f1763b;
        }
        return mo702a(c0801u, c0801u2, i3, i4, i, i2);
    }

    public final void m4247h(C0801u c0801u) {
        m4254o(c0801u);
        m3583e(c0801u);
    }

    public final void m4248i(C0801u c0801u) {
        m4258s(c0801u);
        m3583e(c0801u);
    }

    public final void m4249j(C0801u c0801u) {
        m4256q(c0801u);
        m3583e(c0801u);
    }

    public final void m4234a(C0801u c0801u, boolean z) {
        m4245d(c0801u, z);
        m3583e(c0801u);
    }

    public final void m4250k(C0801u c0801u) {
        m4253n(c0801u);
    }

    public final void m4251l(C0801u c0801u) {
        m4257r(c0801u);
    }

    public final void m4252m(C0801u c0801u) {
        m4255p(c0801u);
    }

    public final void m4240b(C0801u c0801u, boolean z) {
        m4243c(c0801u, z);
    }

    public void m4253n(C0801u c0801u) {
    }

    public void m4254o(C0801u c0801u) {
    }

    public void m4255p(C0801u c0801u) {
    }

    public void m4256q(C0801u c0801u) {
    }

    public void m4257r(C0801u c0801u) {
    }

    public void m4258s(C0801u c0801u) {
    }

    public void m4243c(C0801u c0801u, boolean z) {
    }

    public void m4245d(C0801u c0801u, boolean z) {
    }
}
