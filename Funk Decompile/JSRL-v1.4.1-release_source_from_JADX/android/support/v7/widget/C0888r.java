package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0801u;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChildHelper */
class C0888r {
    final C0773b f2399a;
    final C0887a f2400b = new C0887a();
    final List<View> f2401c = new ArrayList();

    /* compiled from: ChildHelper */
    interface C0773b {
        int mo616a();

        int mo617a(View view);

        void mo618a(int i);

        void mo619a(View view, int i);

        void mo620a(View view, int i, LayoutParams layoutParams);

        C0801u mo621b(View view);

        View mo622b(int i);

        void mo623b();

        void mo624c(int i);

        void mo625c(View view);

        void mo626d(View view);
    }

    /* compiled from: ChildHelper */
    static class C0887a {
        long f2397a = 0;
        C0887a f2398b;

        C0887a() {
        }

        void m4516a(int i) {
            if (i >= 64) {
                m4514b();
                this.f2398b.m4516a(i - 64);
                return;
            }
            this.f2397a |= 1 << i;
        }

        private void m4514b() {
            if (this.f2398b == null) {
                this.f2398b = new C0887a();
            }
        }

        void m4518b(int i) {
            if (i < 64) {
                this.f2397a &= (1 << i) ^ -1;
            } else if (this.f2398b != null) {
                this.f2398b.m4518b(i - 64);
            }
        }

        boolean m4519c(int i) {
            if (i < 64) {
                return (this.f2397a & (1 << i)) != 0;
            } else {
                m4514b();
                return this.f2398b.m4519c(i - 64);
            }
        }

        void m4515a() {
            this.f2397a = 0;
            if (this.f2398b != null) {
                this.f2398b.m4515a();
            }
        }

        void m4517a(int i, boolean z) {
            if (i >= 64) {
                m4514b();
                this.f2398b.m4517a(i - 64, z);
                return;
            }
            boolean z2 = (this.f2397a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f2397a = (((j ^ -1) & this.f2397a) << 1) | (this.f2397a & j);
            if (z) {
                m4516a(i);
            } else {
                m4518b(i);
            }
            if (z2 || this.f2398b != null) {
                m4514b();
                this.f2398b.m4517a(0, z2);
            }
        }

        boolean m4520d(int i) {
            if (i >= 64) {
                m4514b();
                return this.f2398b.m4520d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2397a & j) != 0;
            this.f2397a &= j ^ -1;
            j--;
            this.f2397a = Long.rotateRight((j ^ -1) & this.f2397a, 1) | (this.f2397a & j);
            if (this.f2398b == null) {
                return z;
            }
            if (this.f2398b.m4519c(0)) {
                m4516a(63);
            }
            this.f2398b.m4520d(0);
            return z;
        }

        int m4521e(int i) {
            if (this.f2398b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f2397a);
                }
                return Long.bitCount(this.f2397a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f2397a & ((1 << i) - 1));
            } else {
                return this.f2398b.m4521e(i - 64) + Long.bitCount(this.f2397a);
            }
        }

        public String toString() {
            return this.f2398b == null ? Long.toBinaryString(this.f2397a) : this.f2398b.toString() + "xx" + Long.toBinaryString(this.f2397a);
        }
    }

    C0888r(C0773b c0773b) {
        this.f2399a = c0773b;
    }

    private void m4523g(View view) {
        this.f2401c.add(view);
        this.f2399a.mo625c(view);
    }

    private boolean m4524h(View view) {
        if (!this.f2401c.remove(view)) {
            return false;
        }
        this.f2399a.mo626d(view);
        return true;
    }

    void m4531a(View view, boolean z) {
        m4530a(view, -1, z);
    }

    void m4530a(View view, int i, boolean z) {
        int a;
        if (i < 0) {
            a = this.f2399a.mo616a();
        } else {
            a = m4522e(i);
        }
        this.f2400b.m4517a(a, z);
        if (z) {
            m4523g(view);
        }
        this.f2399a.mo619a(view, a);
    }

    private int m4522e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f2399a.mo616a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f2400b.m4521e(i2));
            if (e == 0) {
                while (this.f2400b.m4519c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    void m4528a(View view) {
        int a = this.f2399a.mo617a(view);
        if (a >= 0) {
            if (this.f2400b.m4520d(a)) {
                m4524h(view);
            }
            this.f2399a.mo618a(a);
        }
    }

    void m4527a(int i) {
        int e = m4522e(i);
        View b = this.f2399a.mo622b(e);
        if (b != null) {
            if (this.f2400b.m4520d(e)) {
                m4524h(b);
            }
            this.f2399a.mo618a(e);
        }
    }

    View m4534b(int i) {
        return this.f2399a.mo622b(m4522e(i));
    }

    void m4526a() {
        this.f2400b.m4515a();
        for (int size = this.f2401c.size() - 1; size >= 0; size--) {
            this.f2399a.mo626d((View) this.f2401c.get(size));
            this.f2401c.remove(size);
        }
        this.f2399a.mo623b();
    }

    View m4525a(int i, int i2) {
        int size = this.f2401c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f2401c.get(i3);
            C0801u b = this.f2399a.mo621b(view);
            if (b.m3724d() == i && !b.m3734n() && !b.m3737q() && (i2 == -1 || b.m3728h() == i2)) {
                return view;
            }
        }
        return null;
    }

    void m4529a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a;
        if (i < 0) {
            a = this.f2399a.mo616a();
        } else {
            a = m4522e(i);
        }
        this.f2400b.m4517a(a, z);
        if (z) {
            m4523g(view);
        }
        this.f2399a.mo620a(view, a, layoutParams);
    }

    int m4532b() {
        return this.f2399a.mo616a() - this.f2401c.size();
    }

    int m4535c() {
        return this.f2399a.mo616a();
    }

    View m4536c(int i) {
        return this.f2399a.mo622b(i);
    }

    void m4538d(int i) {
        int e = m4522e(i);
        this.f2400b.m4520d(e);
        this.f2399a.mo624c(e);
    }

    int m4533b(View view) {
        int a = this.f2399a.mo617a(view);
        if (a == -1 || this.f2400b.m4519c(a)) {
            return -1;
        }
        return a - this.f2400b.m4521e(a);
    }

    boolean m4537c(View view) {
        return this.f2401c.contains(view);
    }

    void m4539d(View view) {
        int a = this.f2399a.mo617a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f2400b.m4516a(a);
        m4523g(view);
    }

    void m4540e(View view) {
        int a = this.f2399a.mo617a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f2400b.m4519c(a)) {
            this.f2400b.m4518b(a);
            m4524h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f2400b.toString() + ", hidden list:" + this.f2401c.size();
    }

    boolean m4541f(View view) {
        int a = this.f2399a.mo617a(view);
        if (a == -1) {
            return m4524h(view) ? true : true;
        } else {
            if (!this.f2400b.m4519c(a)) {
                return false;
            }
            this.f2400b.m4520d(a);
            if (m4524h(view)) {
                this.f2399a.mo618a(a);
            } else {
                this.f2399a.mo618a(a);
            }
            return true;
        }
    }
}
