package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.p025a.C0474a;
import android.support.v4.view.p025a.C0512k;
import android.support.v7.widget.RecyclerView.C0761i;
import android.support.v7.widget.RecyclerView.C0763h;
import android.support.v7.widget.RecyclerView.C0763h.C0788a;
import android.support.v7.widget.RecyclerView.C0793n;
import android.support.v7.widget.RecyclerView.C0798r;
import android.support.v7.widget.RecyclerView.C0801u;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends C0763h {
    private C0767c f1710a;
    private boolean f1711b;
    private boolean f1712c;
    private boolean f1713d;
    private boolean f1714e;
    private boolean f1715f;
    int f1716i;
    af f1717j;
    boolean f1718k;
    int f1719l;
    int f1720m;
    SavedState f1721n;
    final C0765a f1722o;

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C07641();
        int f1731a;
        int f1732b;
        boolean f1733c;

        static class C07641 implements Creator<SavedState> {
            C07641() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3478a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3479a(i);
            }

            public SavedState m3478a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m3479a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.f1731a = parcel.readInt();
            this.f1732b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f1733c = z;
        }

        public SavedState(SavedState savedState) {
            this.f1731a = savedState.f1731a;
            this.f1732b = savedState.f1732b;
            this.f1733c = savedState.f1733c;
        }

        boolean m3480a() {
            return this.f1731a >= 0;
        }

        void m3481b() {
            this.f1731a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1731a);
            parcel.writeInt(this.f1732b);
            parcel.writeInt(this.f1733c ? 1 : 0);
        }
    }

    class C0765a {
        int f1734a;
        int f1735b;
        boolean f1736c;
        final /* synthetic */ LinearLayoutManager f1737d;

        C0765a(LinearLayoutManager linearLayoutManager) {
            this.f1737d = linearLayoutManager;
        }

        void m3484a() {
            this.f1734a = -1;
            this.f1735b = Integer.MIN_VALUE;
            this.f1736c = false;
        }

        void m3486b() {
            this.f1735b = this.f1736c ? this.f1737d.f1717j.mo658d() : this.f1737d.f1717j.mo656c();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1734a + ", mCoordinate=" + this.f1735b + ", mLayoutFromEnd=" + this.f1736c + '}';
        }

        private boolean m3483a(View view, C0798r c0798r) {
            C0761i c0761i = (C0761i) view.getLayoutParams();
            return !c0761i.m3233c() && c0761i.m3235e() >= 0 && c0761i.m3235e() < c0798r.m3687e();
        }

        public void m3485a(View view) {
            int b = this.f1737d.f1717j.m4172b();
            if (b >= 0) {
                m3487b(view);
                return;
            }
            this.f1734a = this.f1737d.m3330d(view);
            int c;
            if (this.f1736c) {
                b = (this.f1737d.f1717j.mo658d() - b) - this.f1737d.f1717j.mo655b(view);
                this.f1735b = this.f1737d.f1717j.mo658d() - b;
                if (b > 0) {
                    c = this.f1735b - this.f1737d.f1717j.mo657c(view);
                    int c2 = this.f1737d.f1717j.mo656c();
                    c -= c2 + Math.min(this.f1737d.f1717j.mo653a(view) - c2, 0);
                    if (c < 0) {
                        this.f1735b = Math.min(b, -c) + this.f1735b;
                        return;
                    }
                    return;
                }
                return;
            }
            c = this.f1737d.f1717j.mo653a(view);
            c2 = c - this.f1737d.f1717j.mo656c();
            this.f1735b = c;
            if (c2 > 0) {
                b = (this.f1737d.f1717j.mo658d() - Math.min(0, (this.f1737d.f1717j.mo658d() - b) - this.f1737d.f1717j.mo655b(view))) - (c + this.f1737d.f1717j.mo657c(view));
                if (b < 0) {
                    this.f1735b -= Math.min(c2, -b);
                }
            }
        }

        public void m3487b(View view) {
            if (this.f1736c) {
                this.f1735b = this.f1737d.f1717j.mo655b(view) + this.f1737d.f1717j.m4172b();
            } else {
                this.f1735b = this.f1737d.f1717j.mo653a(view);
            }
            this.f1734a = this.f1737d.m3330d(view);
        }
    }

    protected static class C0766b {
        public int f1738a;
        public boolean f1739b;
        public boolean f1740c;
        public boolean f1741d;

        protected C0766b() {
        }

        void m3488a() {
            this.f1738a = 0;
            this.f1739b = false;
            this.f1740c = false;
            this.f1741d = false;
        }
    }

    static class C0767c {
        boolean f1742a = true;
        int f1743b;
        int f1744c;
        int f1745d;
        int f1746e;
        int f1747f;
        int f1748g;
        int f1749h = 0;
        boolean f1750i = false;
        int f1751j;
        List<C0801u> f1752k = null;
        boolean f1753l;

        C0767c() {
        }

        boolean m3493a(C0798r c0798r) {
            return this.f1745d >= 0 && this.f1745d < c0798r.m3687e();
        }

        View m3490a(C0793n c0793n) {
            if (this.f1752k != null) {
                return m3489b();
            }
            View c = c0793n.m3632c(this.f1745d);
            this.f1745d += this.f1746e;
            return c;
        }

        private View m3489b() {
            int size = this.f1752k.size();
            for (int i = 0; i < size; i++) {
                View view = ((C0801u) this.f1752k.get(i)).f1823a;
                C0761i c0761i = (C0761i) view.getLayoutParams();
                if (!c0761i.m3233c() && this.f1745d == c0761i.m3235e()) {
                    m3492a(view);
                    return view;
                }
            }
            return null;
        }

        public void m3491a() {
            m3492a(null);
        }

        public void m3492a(View view) {
            View b = m3494b(view);
            if (b == null) {
                this.f1745d = -1;
            } else {
                this.f1745d = ((C0761i) b.getLayoutParams()).m3235e();
            }
        }

        public View m3494b(View view) {
            int size = this.f1752k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                int i3;
                View view3;
                View view4 = ((C0801u) this.f1752k.get(i2)).f1823a;
                C0761i c0761i = (C0761i) view4.getLayoutParams();
                if (view4 != view) {
                    if (c0761i.m3233c()) {
                        i3 = i;
                        view3 = view2;
                    } else {
                        i3 = (c0761i.m3235e() - this.f1745d) * this.f1746e;
                        if (i3 < 0) {
                            i3 = i;
                            view3 = view2;
                        } else if (i3 < i) {
                            if (i3 == 0) {
                                return view4;
                            }
                            view3 = view4;
                        }
                    }
                    i2++;
                    view2 = view3;
                    i = i3;
                }
                i3 = i;
                view3 = view2;
                i2++;
                view2 = view3;
                i = i3;
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f1712c = false;
        this.f1718k = false;
        this.f1713d = false;
        this.f1714e = true;
        this.f1719l = -1;
        this.f1720m = Integer.MIN_VALUE;
        this.f1721n = null;
        this.f1722o = new C0765a(this);
        m3417b(i);
        m3418b(z);
        m3327c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1712c = false;
        this.f1718k = false;
        this.f1713d = false;
        this.f1714e = true;
        this.f1719l = -1;
        this.f1720m = Integer.MIN_VALUE;
        this.f1721n = null;
        this.f1722o = new C0765a(this);
        C0788a a = C0763h.m3244a(context, attributeSet, i, i2);
        m3417b(a.f1773a);
        m3418b(a.f1775c);
        mo608a(a.f1776d);
        m3327c(true);
    }

    public C0761i mo575a() {
        return new C0761i(-2, -2);
    }

    public void mo578a(RecyclerView recyclerView, C0793n c0793n) {
        super.mo578a(recyclerView, c0793n);
        if (this.f1715f) {
            m3321c(c0793n);
            c0793n.m3618a();
        }
    }

    public void mo579a(AccessibilityEvent accessibilityEvent) {
        super.mo579a(accessibilityEvent);
        if (m3367t() > 0) {
            C0512k a = C0474a.m1857a(accessibilityEvent);
            a.m2044b(m3439l());
            a.m2045c(m3440m());
        }
    }

    public Parcelable mo585c() {
        if (this.f1721n != null) {
            return new SavedState(this.f1721n);
        }
        Parcelable savedState = new SavedState();
        if (m3367t() > 0) {
            m3435h();
            boolean z = this.f1711b ^ this.f1718k;
            savedState.f1733c = z;
            View K;
            if (z) {
                K = m3376K();
                savedState.f1732b = this.f1717j.mo658d() - this.f1717j.mo655b(K);
                savedState.f1731a = m3330d(K);
                return savedState;
            }
            K = m3375J();
            savedState.f1731a = m3330d(K);
            savedState.f1732b = this.f1717j.mo653a(K) - this.f1717j.mo656c();
            return savedState;
        }
        savedState.m3481b();
        return savedState;
    }

    public void mo577a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f1721n = (SavedState) parcelable;
            m3360n();
        }
    }

    public boolean mo590d() {
        return this.f1716i == 0;
    }

    public boolean mo592e() {
        return this.f1716i == 1;
    }

    public void mo608a(boolean z) {
        mo580a(null);
        if (this.f1713d != z) {
            this.f1713d = z;
            m3360n();
        }
    }

    public int m3431f() {
        return this.f1716i;
    }

    public void m3417b(int i) {
        if (i == 0 || i == 1) {
            mo580a(null);
            if (i != this.f1716i) {
                this.f1716i = i;
                this.f1717j = null;
                m3360n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    private void m3374I() {
        boolean z = true;
        if (this.f1716i == 1 || !m3434g()) {
            this.f1718k = this.f1712c;
            return;
        }
        if (this.f1712c) {
            z = false;
        }
        this.f1718k = z;
    }

    public void m3418b(boolean z) {
        mo580a(null);
        if (z != this.f1712c) {
            this.f1712c = z;
            m3360n();
        }
    }

    public View mo586c(int i) {
        int t = m3367t();
        if (t == 0) {
            return null;
        }
        int d = i - m3330d(m3349h(0));
        if (d >= 0 && d < t) {
            View h = m3349h(d);
            if (m3330d(h) == i) {
                return h;
            }
        }
        return super.mo586c(i);
    }

    protected int m3403a(C0798r c0798r) {
        if (c0798r.m3686d()) {
            return this.f1717j.mo661f();
        }
        return 0;
    }

    public void mo587c(C0793n c0793n, C0798r c0798r) {
        if (!(this.f1721n == null && this.f1719l == -1) && c0798r.m3687e() == 0) {
            m3321c(c0793n);
            return;
        }
        int i;
        int d;
        if (this.f1721n != null && this.f1721n.m3480a()) {
            this.f1719l = this.f1721n.f1731a;
        }
        m3435h();
        this.f1710a.f1742a = false;
        m3374I();
        this.f1722o.m3484a();
        this.f1722o.f1736c = this.f1718k ^ this.f1713d;
        m3384a(c0793n, c0798r, this.f1722o);
        int a = m3403a(c0798r);
        if (this.f1710a.f1751j >= 0) {
            i = 0;
        } else {
            i = a;
            a = 0;
        }
        i += this.f1717j.mo656c();
        a += this.f1717j.mo662g();
        if (!(!c0798r.m3683a() || this.f1719l == -1 || this.f1720m == Integer.MIN_VALUE)) {
            View c = mo586c(this.f1719l);
            if (c != null) {
                if (this.f1718k) {
                    d = (this.f1717j.mo658d() - this.f1717j.mo655b(c)) - this.f1720m;
                } else {
                    d = this.f1720m - (this.f1717j.mo653a(c) - this.f1717j.mo656c());
                }
                if (d > 0) {
                    i += d;
                } else {
                    a -= d;
                }
            }
        }
        d = this.f1722o.f1736c ? this.f1718k ? 1 : -1 : this.f1718k ? -1 : 1;
        mo601a(c0793n, c0798r, this.f1722o, d);
        m3274a(c0793n);
        this.f1710a.f1753l = m3437j();
        this.f1710a.f1750i = c0798r.m3683a();
        int i2;
        if (this.f1722o.f1736c) {
            m3388b(this.f1722o);
            this.f1710a.f1749h = i;
            m3402a(c0793n, this.f1710a, c0798r, false);
            i = this.f1710a.f1743b;
            i2 = this.f1710a.f1745d;
            if (this.f1710a.f1744c > 0) {
                a += this.f1710a.f1744c;
            }
            m3380a(this.f1722o);
            this.f1710a.f1749h = a;
            C0767c c0767c = this.f1710a;
            c0767c.f1745d += this.f1710a.f1746e;
            m3402a(c0793n, this.f1710a, c0798r, false);
            d = this.f1710a.f1743b;
            if (this.f1710a.f1744c > 0) {
                a = this.f1710a.f1744c;
                m3394f(i2, i);
                this.f1710a.f1749h = a;
                m3402a(c0793n, this.f1710a, c0798r, false);
                a = this.f1710a.f1743b;
            } else {
                a = i;
            }
            i = a;
            a = d;
        } else {
            m3380a(this.f1722o);
            this.f1710a.f1749h = a;
            m3402a(c0793n, this.f1710a, c0798r, false);
            a = this.f1710a.f1743b;
            d = this.f1710a.f1745d;
            if (this.f1710a.f1744c > 0) {
                i += this.f1710a.f1744c;
            }
            m3388b(this.f1722o);
            this.f1710a.f1749h = i;
            C0767c c0767c2 = this.f1710a;
            c0767c2.f1745d += this.f1710a.f1746e;
            m3402a(c0793n, this.f1710a, c0798r, false);
            i = this.f1710a.f1743b;
            if (this.f1710a.f1744c > 0) {
                i2 = this.f1710a.f1744c;
                m3392e(d, a);
                this.f1710a.f1749h = i2;
                m3402a(c0793n, this.f1710a, c0798r, false);
                a = this.f1710a.f1743b;
            }
        }
        if (m3367t() > 0) {
            int b;
            if ((this.f1718k ^ this.f1713d) != 0) {
                d = m3377a(a, c0793n, c0798r, true);
                i += d;
                a += d;
                b = m3386b(i, c0793n, c0798r, false);
                i += b;
                a += b;
            } else {
                d = m3386b(i, c0793n, c0798r, true);
                i += d;
                a += d;
                b = m3377a(a, c0793n, c0798r, false);
                i += b;
                a += b;
            }
        }
        m3390b(c0793n, c0798r, i, a);
        if (!c0798r.m3683a()) {
            this.f1719l = -1;
            this.f1720m = Integer.MIN_VALUE;
            this.f1717j.m4170a();
        }
        this.f1711b = this.f1713d;
        this.f1721n = null;
    }

    void mo601a(C0793n c0793n, C0798r c0798r, C0765a c0765a, int i) {
    }

    private void m3390b(C0793n c0793n, C0798r c0798r, int i, int i2) {
        if (c0798r.m3684b() && m3367t() != 0 && !c0798r.m3683a() && mo583b()) {
            int i3 = 0;
            int i4 = 0;
            List b = c0793n.m3627b();
            int size = b.size();
            int d = m3330d(m3349h(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                C0801u c0801u = (C0801u) b.get(i5);
                if (c0801u.m3737q()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((c0801u.m3724d() < d) != this.f1718k ? -1 : 1) == -1) {
                        i7 = this.f1717j.mo657c(c0801u.f1823a) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.f1717j.mo657c(c0801u.f1823a) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.f1710a.f1752k = b;
            if (i3 > 0) {
                m3394f(m3330d(m3375J()), i);
                this.f1710a.f1749h = i3;
                this.f1710a.f1744c = 0;
                this.f1710a.m3491a();
                m3402a(c0793n, this.f1710a, c0798r, false);
            }
            if (i4 > 0) {
                m3392e(m3330d(m3376K()), i2);
                this.f1710a.f1749h = i4;
                this.f1710a.f1744c = 0;
                this.f1710a.m3491a();
                m3402a(c0793n, this.f1710a, c0798r, false);
            }
            this.f1710a.f1752k = null;
        }
    }

    private void m3384a(C0793n c0793n, C0798r c0798r, C0765a c0765a) {
        if (!m3385a(c0798r, c0765a) && !m3391b(c0793n, c0798r, c0765a)) {
            c0765a.m3486b();
            c0765a.f1734a = this.f1713d ? c0798r.m3687e() - 1 : 0;
        }
    }

    private boolean m3391b(C0793n c0793n, C0798r c0798r, C0765a c0765a) {
        boolean z = false;
        if (m3367t() == 0) {
            return false;
        }
        View C = m3256C();
        if (C != null && c0765a.m3483a(C, c0798r)) {
            c0765a.m3485a(C);
            return true;
        } else if (this.f1711b != this.f1713d) {
            return false;
        } else {
            C = c0765a.f1736c ? m3393f(c0793n, c0798r) : m3395g(c0793n, c0798r);
            if (C == null) {
                return false;
            }
            c0765a.m3487b(C);
            if (!c0798r.m3683a() && mo583b()) {
                if (this.f1717j.mo653a(C) >= this.f1717j.mo658d() || this.f1717j.mo655b(C) < this.f1717j.mo656c()) {
                    z = true;
                }
                if (z) {
                    c0765a.f1735b = c0765a.f1736c ? this.f1717j.mo658d() : this.f1717j.mo656c();
                }
            }
            return true;
        }
    }

    private boolean m3385a(C0798r c0798r, C0765a c0765a) {
        boolean z = false;
        if (c0798r.m3683a() || this.f1719l == -1) {
            return false;
        }
        if (this.f1719l < 0 || this.f1719l >= c0798r.m3687e()) {
            this.f1719l = -1;
            this.f1720m = Integer.MIN_VALUE;
            return false;
        }
        c0765a.f1734a = this.f1719l;
        if (this.f1721n != null && this.f1721n.m3480a()) {
            c0765a.f1736c = this.f1721n.f1733c;
            if (c0765a.f1736c) {
                c0765a.f1735b = this.f1717j.mo658d() - this.f1721n.f1732b;
                return true;
            }
            c0765a.f1735b = this.f1717j.mo656c() + this.f1721n.f1732b;
            return true;
        } else if (this.f1720m == Integer.MIN_VALUE) {
            View c = mo586c(this.f1719l);
            if (c == null) {
                if (m3367t() > 0) {
                    boolean z2;
                    if (this.f1719l < m3330d(m3349h(0))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 == this.f1718k) {
                        z = true;
                    }
                    c0765a.f1736c = z;
                }
                c0765a.m3486b();
                return true;
            } else if (this.f1717j.mo657c(c) > this.f1717j.mo661f()) {
                c0765a.m3486b();
                return true;
            } else if (this.f1717j.mo653a(c) - this.f1717j.mo656c() < 0) {
                c0765a.f1735b = this.f1717j.mo656c();
                c0765a.f1736c = false;
                return true;
            } else if (this.f1717j.mo658d() - this.f1717j.mo655b(c) < 0) {
                c0765a.f1735b = this.f1717j.mo658d();
                c0765a.f1736c = true;
                return true;
            } else {
                c0765a.f1735b = c0765a.f1736c ? this.f1717j.mo655b(c) + this.f1717j.m4172b() : this.f1717j.mo653a(c);
                return true;
            }
        } else {
            c0765a.f1736c = this.f1718k;
            if (this.f1718k) {
                c0765a.f1735b = this.f1717j.mo658d() - this.f1720m;
                return true;
            }
            c0765a.f1735b = this.f1717j.mo656c() + this.f1720m;
            return true;
        }
    }

    private int m3377a(int i, C0793n c0793n, C0798r c0798r, boolean z) {
        int d = this.f1717j.mo658d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -m3420c(-d, c0793n, c0798r);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.f1717j.mo658d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.f1717j.mo654a(i2);
        return d + i2;
    }

    private int m3386b(int i, C0793n c0793n, C0798r c0798r, boolean z) {
        int c = i - this.f1717j.mo656c();
        if (c <= 0) {
            return 0;
        }
        c = -m3420c(c, c0793n, c0798r);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.f1717j.mo656c();
        if (i2 <= 0) {
            return c;
        }
        this.f1717j.mo654a(-i2);
        return c - i2;
    }

    private void m3380a(C0765a c0765a) {
        m3392e(c0765a.f1734a, c0765a.f1735b);
    }

    private void m3392e(int i, int i2) {
        this.f1710a.f1744c = this.f1717j.mo658d() - i2;
        this.f1710a.f1746e = this.f1718k ? -1 : 1;
        this.f1710a.f1745d = i;
        this.f1710a.f1747f = 1;
        this.f1710a.f1743b = i2;
        this.f1710a.f1748g = Integer.MIN_VALUE;
    }

    private void m3388b(C0765a c0765a) {
        m3394f(c0765a.f1734a, c0765a.f1735b);
    }

    private void m3394f(int i, int i2) {
        this.f1710a.f1744c = i2 - this.f1717j.mo656c();
        this.f1710a.f1745d = i;
        this.f1710a.f1746e = this.f1718k ? 1 : -1;
        this.f1710a.f1747f = -1;
        this.f1710a.f1743b = i2;
        this.f1710a.f1748g = Integer.MIN_VALUE;
    }

    protected boolean m3434g() {
        return m3365r() == 1;
    }

    void m3435h() {
        if (this.f1710a == null) {
            this.f1710a = m3436i();
        }
        if (this.f1717j == null) {
            this.f1717j = af.m4167a(this, this.f1716i);
        }
    }

    C0767c m3436i() {
        return new C0767c();
    }

    public void mo589d(int i) {
        this.f1719l = i;
        this.f1720m = Integer.MIN_VALUE;
        if (this.f1721n != null) {
            this.f1721n.m3481b();
        }
        m3360n();
    }

    public int mo574a(int i, C0793n c0793n, C0798r c0798r) {
        if (this.f1716i == 1) {
            return 0;
        }
        return m3420c(i, c0793n, c0798r);
    }

    public int mo581b(int i, C0793n c0793n, C0798r c0798r) {
        if (this.f1716i == 0) {
            return 0;
        }
        return m3420c(i, c0793n, c0798r);
    }

    public int mo582b(C0798r c0798r) {
        return m3396h(c0798r);
    }

    public int mo584c(C0798r c0798r) {
        return m3396h(c0798r);
    }

    public int mo588d(C0798r c0798r) {
        return m3398i(c0798r);
    }

    public int mo591e(C0798r c0798r) {
        return m3398i(c0798r);
    }

    public int mo593f(C0798r c0798r) {
        return m3400j(c0798r);
    }

    public int mo594g(C0798r c0798r) {
        return m3400j(c0798r);
    }

    private int m3396h(C0798r c0798r) {
        boolean z = false;
        if (m3367t() == 0) {
            return 0;
        }
        m3435h();
        af afVar = this.f1717j;
        View a = m3378a(!this.f1714e, true);
        if (!this.f1714e) {
            z = true;
        }
        return aj.m4223a(c0798r, afVar, a, m3387b(z, true), this, this.f1714e, this.f1718k);
    }

    private int m3398i(C0798r c0798r) {
        boolean z = false;
        if (m3367t() == 0) {
            return 0;
        }
        m3435h();
        af afVar = this.f1717j;
        View a = m3378a(!this.f1714e, true);
        if (!this.f1714e) {
            z = true;
        }
        return aj.m4222a(c0798r, afVar, a, m3387b(z, true), this, this.f1714e);
    }

    private int m3400j(C0798r c0798r) {
        boolean z = false;
        if (m3367t() == 0) {
            return 0;
        }
        m3435h();
        af afVar = this.f1717j;
        View a = m3378a(!this.f1714e, true);
        if (!this.f1714e) {
            z = true;
        }
        return aj.m4224b(c0798r, afVar, a, m3387b(z, true), this, this.f1714e);
    }

    private void m3379a(int i, int i2, boolean z, C0798r c0798r) {
        int i3 = -1;
        int i4 = 1;
        this.f1710a.f1753l = m3437j();
        this.f1710a.f1749h = m3403a(c0798r);
        this.f1710a.f1747f = i;
        View K;
        C0767c c0767c;
        if (i == 1) {
            C0767c c0767c2 = this.f1710a;
            c0767c2.f1749h += this.f1717j.mo662g();
            K = m3376K();
            c0767c = this.f1710a;
            if (!this.f1718k) {
                i3 = 1;
            }
            c0767c.f1746e = i3;
            this.f1710a.f1745d = m3330d(K) + this.f1710a.f1746e;
            this.f1710a.f1743b = this.f1717j.mo655b(K);
            i3 = this.f1717j.mo655b(K) - this.f1717j.mo658d();
        } else {
            K = m3375J();
            c0767c = this.f1710a;
            c0767c.f1749h += this.f1717j.mo656c();
            c0767c = this.f1710a;
            if (!this.f1718k) {
                i4 = -1;
            }
            c0767c.f1746e = i4;
            this.f1710a.f1745d = m3330d(K) + this.f1710a.f1746e;
            this.f1710a.f1743b = this.f1717j.mo653a(K);
            i3 = (-this.f1717j.mo653a(K)) + this.f1717j.mo656c();
        }
        this.f1710a.f1744c = i2;
        if (z) {
            C0767c c0767c3 = this.f1710a;
            c0767c3.f1744c -= i3;
        }
        this.f1710a.f1748g = i3;
    }

    boolean m3437j() {
        return this.f1717j.mo663h() == 0 && this.f1717j.mo660e() == 0;
    }

    int m3420c(int i, C0793n c0793n, C0798r c0798r) {
        if (m3367t() == 0 || i == 0) {
            return 0;
        }
        this.f1710a.f1742a = true;
        m3435h();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m3379a(i2, abs, true, c0798r);
        int a = this.f1710a.f1748g + m3402a(c0793n, this.f1710a, c0798r, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f1717j.mo654a(-i);
        this.f1710a.f1751j = i;
        return i;
    }

    public void mo580a(String str) {
        if (this.f1721n == null) {
            super.mo580a(str);
        }
    }

    private void m3382a(C0793n c0793n, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    m3269a(i3, c0793n);
                }
                return;
            }
            while (i > i2) {
                m3269a(i, c0793n);
                i--;
            }
        }
    }

    private void m3381a(C0793n c0793n, int i) {
        if (i >= 0) {
            int t = m3367t();
            int i2;
            if (this.f1718k) {
                for (i2 = t - 1; i2 >= 0; i2--) {
                    if (this.f1717j.mo655b(m3349h(i2)) > i) {
                        m3382a(c0793n, t - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < t; i2++) {
                if (this.f1717j.mo655b(m3349h(i2)) > i) {
                    m3382a(c0793n, 0, i2);
                    return;
                }
            }
        }
    }

    private void m3389b(C0793n c0793n, int i) {
        int t = m3367t();
        if (i >= 0) {
            int e = this.f1717j.mo660e() - i;
            int i2;
            if (this.f1718k) {
                for (i2 = 0; i2 < t; i2++) {
                    if (this.f1717j.mo653a(m3349h(i2)) < e) {
                        m3382a(c0793n, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = t - 1; i2 >= 0; i2--) {
                if (this.f1717j.mo653a(m3349h(i2)) < e) {
                    m3382a(c0793n, t - 1, i2);
                    return;
                }
            }
        }
    }

    private void m3383a(C0793n c0793n, C0767c c0767c) {
        if (c0767c.f1742a && !c0767c.f1753l) {
            if (c0767c.f1747f == -1) {
                m3389b(c0793n, c0767c.f1748g);
            } else {
                m3381a(c0793n, c0767c.f1748g);
            }
        }
    }

    int m3402a(C0793n c0793n, C0767c c0767c, C0798r c0798r, boolean z) {
        int i = c0767c.f1744c;
        if (c0767c.f1748g != Integer.MIN_VALUE) {
            if (c0767c.f1744c < 0) {
                c0767c.f1748g += c0767c.f1744c;
            }
            m3383a(c0793n, c0767c);
        }
        int i2 = c0767c.f1744c + c0767c.f1749h;
        C0766b c0766b = new C0766b();
        while (true) {
            if ((!c0767c.f1753l && i2 <= 0) || !c0767c.m3493a(c0798r)) {
                break;
            }
            c0766b.m3488a();
            mo602a(c0793n, c0798r, c0767c, c0766b);
            if (!c0766b.f1739b) {
                c0767c.f1743b += c0766b.f1738a * c0767c.f1747f;
                if (!(c0766b.f1740c && this.f1710a.f1752k == null && c0798r.m3683a())) {
                    c0767c.f1744c -= c0766b.f1738a;
                    i2 -= c0766b.f1738a;
                }
                if (c0767c.f1748g != Integer.MIN_VALUE) {
                    c0767c.f1748g += c0766b.f1738a;
                    if (c0767c.f1744c < 0) {
                        c0767c.f1748g += c0767c.f1744c;
                    }
                    m3383a(c0793n, c0767c);
                }
                if (z && c0766b.f1741d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0767c.f1744c;
    }

    void mo602a(C0793n c0793n, C0798r c0798r, C0767c c0767c, C0766b c0766b) {
        View a = c0767c.m3490a(c0793n);
        if (a == null) {
            c0766b.f1739b = true;
            return;
        }
        int w;
        int d;
        int i;
        int i2;
        C0761i c0761i = (C0761i) a.getLayoutParams();
        if (c0767c.f1752k == null) {
            if (this.f1718k == (c0767c.f1747f == -1)) {
                m3313b(a);
            } else {
                m3314b(a, 0);
            }
        } else {
            boolean z;
            boolean z2 = this.f1718k;
            if (c0767c.f1747f == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 == z) {
                m3284a(a);
            } else {
                m3285a(a, 0);
            }
        }
        m3286a(a, 0, 0);
        c0766b.f1738a = this.f1717j.mo657c(a);
        if (this.f1716i == 1) {
            if (m3434g()) {
                w = m3370w() - m3254A();
                d = w - this.f1717j.mo659d(a);
            } else {
                d = m3372y();
                w = this.f1717j.mo659d(a) + d;
            }
            if (c0767c.f1747f == -1) {
                i = c0767c.f1743b - c0766b.f1738a;
                i2 = w;
                w = c0767c.f1743b;
            } else {
                i = c0767c.f1743b;
                i2 = w;
                w = c0767c.f1743b + c0766b.f1738a;
            }
        } else {
            i = m3373z();
            w = this.f1717j.mo659d(a) + i;
            if (c0767c.f1747f == -1) {
                d = c0767c.f1743b - c0766b.f1738a;
                i2 = c0767c.f1743b;
            } else {
                d = c0767c.f1743b;
                i2 = c0767c.f1743b + c0766b.f1738a;
            }
        }
        m3287a(a, d + c0761i.leftMargin, i + c0761i.topMargin, i2 - c0761i.rightMargin, w - c0761i.bottomMargin);
        if (c0761i.m3233c() || c0761i.m3234d()) {
            c0766b.f1740c = true;
        }
        c0766b.f1741d = a.isFocusable();
    }

    boolean mo595k() {
        return (m3369v() == 1073741824 || m3368u() == 1073741824 || !m3261H()) ? false : true;
    }

    int m3428e(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                if (this.f1716i != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 33:
                if (this.f1716i != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 66:
                if (this.f1716i != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case 130:
                if (this.f1716i == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View m3375J() {
        return m3349h(this.f1718k ? m3367t() - 1 : 0);
    }

    private View m3376K() {
        return m3349h(this.f1718k ? 0 : m3367t() - 1);
    }

    private View m3378a(boolean z, boolean z2) {
        if (this.f1718k) {
            return m3405a(m3367t() - 1, -1, z, z2);
        }
        return m3405a(0, m3367t(), z, z2);
    }

    private View m3387b(boolean z, boolean z2) {
        if (this.f1718k) {
            return m3405a(0, m3367t(), z, z2);
        }
        return m3405a(m3367t() - 1, -1, z, z2);
    }

    private View m3393f(C0793n c0793n, C0798r c0798r) {
        return this.f1718k ? m3397h(c0793n, c0798r) : m3399i(c0793n, c0798r);
    }

    private View m3395g(C0793n c0793n, C0798r c0798r) {
        return this.f1718k ? m3399i(c0793n, c0798r) : m3397h(c0793n, c0798r);
    }

    private View m3397h(C0793n c0793n, C0798r c0798r) {
        return mo599a(c0793n, c0798r, 0, m3367t(), c0798r.m3687e());
    }

    private View m3399i(C0793n c0793n, C0798r c0798r) {
        return mo599a(c0793n, c0798r, m3367t() - 1, -1, c0798r.m3687e());
    }

    View mo599a(C0793n c0793n, C0798r c0798r, int i, int i2, int i3) {
        View view = null;
        m3435h();
        int c = this.f1717j.mo656c();
        int d = this.f1717j.mo658d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m3349h(i);
            int d2 = m3330d(h);
            if (d2 >= 0 && d2 < i3) {
                if (((C0761i) h.getLayoutParams()).m3233c()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                } else if (this.f1717j.mo653a(h) < d && this.f1717j.mo655b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                }
            }
            view3 = view;
            h = view2;
            i += i4;
            view = view3;
            view2 = h;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public int m3439l() {
        View a = m3405a(0, m3367t(), false, true);
        return a == null ? -1 : m3330d(a);
    }

    public int m3440m() {
        View a = m3405a(m3367t() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return m3330d(a);
    }

    View m3405a(int i, int i2, boolean z, boolean z2) {
        m3435h();
        int c = this.f1717j.mo656c();
        int d = this.f1717j.mo658d();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View h = m3349h(i);
            int a = this.f1717j.mo653a(h);
            int b = this.f1717j.mo655b(h);
            if (a < d && b > c) {
                if (!z) {
                    return h;
                }
                if (a >= c && b <= d) {
                    return h;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = h;
                }
            }
            h = view;
            i += i3;
            view = h;
        }
        return view;
    }

    public View mo576a(View view, int i, C0793n c0793n, C0798r c0798r) {
        m3374I();
        if (m3367t() == 0) {
            return null;
        }
        int e = m3428e(i);
        if (e == Integer.MIN_VALUE) {
            return null;
        }
        View g;
        m3435h();
        if (e == -1) {
            g = m3395g(c0793n, c0798r);
        } else {
            g = m3393f(c0793n, c0798r);
        }
        if (g == null) {
            return null;
        }
        View J;
        m3435h();
        m3379a(e, (int) (0.33333334f * ((float) this.f1717j.mo661f())), false, c0798r);
        this.f1710a.f1748g = Integer.MIN_VALUE;
        this.f1710a.f1742a = false;
        m3402a(c0793n, this.f1710a, c0798r, true);
        if (e == -1) {
            J = m3375J();
        } else {
            J = m3376K();
        }
        if (J == g || !J.isFocusable()) {
            return null;
        }
        return J;
    }

    public boolean mo583b() {
        return this.f1721n == null && this.f1711b == this.f1713d;
    }
}
