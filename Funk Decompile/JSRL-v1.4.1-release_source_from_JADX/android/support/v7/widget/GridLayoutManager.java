package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.p025a.C0489c;
import android.support.v4.view.p025a.C0489c.C0488m;
import android.support.v7.widget.LinearLayoutManager.C0765a;
import android.support.v7.widget.LinearLayoutManager.C0766b;
import android.support.v7.widget.LinearLayoutManager.C0767c;
import android.support.v7.widget.RecyclerView.C0761i;
import android.support.v7.widget.RecyclerView.C0763h;
import android.support.v7.widget.RecyclerView.C0793n;
import android.support.v7.widget.RecyclerView.C0798r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean f1723a = false;
    int f1724b = -1;
    int[] f1725c;
    View[] f1726d;
    final SparseIntArray f1727e = new SparseIntArray();
    final SparseIntArray f1728f = new SparseIntArray();
    C0759c f1729g = new C0760a();
    final Rect f1730h = new Rect();

    public static abstract class C0759c {
        final SparseIntArray f1691a = new SparseIntArray();
        private boolean f1692b = false;

        public abstract int mo572a(int i);

        public void m3227a() {
            this.f1691a.clear();
        }

        int m3229b(int i, int i2) {
            if (!this.f1692b) {
                return mo573a(i, i2);
            }
            int i3 = this.f1691a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = mo573a(i, i2);
            this.f1691a.put(i, i3);
            return i3;
        }

        public int mo573a(int i, int i2) {
            int a = mo572a(i);
            if (a == i2) {
                return 0;
            }
            int b;
            int a2;
            int i3;
            if (this.f1692b && this.f1691a.size() > 0) {
                b = m3228b(i);
                if (b >= 0) {
                    a2 = this.f1691a.get(b) + mo572a(b);
                    b++;
                    i3 = b;
                    while (i3 < i) {
                        b = mo572a(i3);
                        a2 += b;
                        if (a2 == i2) {
                            b = 0;
                        } else if (a2 <= i2) {
                            b = a2;
                        }
                        i3++;
                        a2 = b;
                    }
                    if (a2 + a > i2) {
                        return a2;
                    }
                    return 0;
                }
            }
            b = 0;
            a2 = 0;
            i3 = b;
            while (i3 < i) {
                b = mo572a(i3);
                a2 += b;
                if (a2 == i2) {
                    b = 0;
                } else if (a2 <= i2) {
                    b = a2;
                }
                i3++;
                a2 = b;
            }
            if (a2 + a > i2) {
                return 0;
            }
            return a2;
        }

        int m3228b(int i) {
            int i2 = 0;
            int size = this.f1691a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f1691a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            size = i2 - 1;
            if (size < 0 || size >= this.f1691a.size()) {
                return -1;
            }
            return this.f1691a.keyAt(size);
        }

        public int m3230c(int i, int i2) {
            int a = mo572a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int a2 = mo572a(i3);
                i5 += a2;
                if (i5 == i2) {
                    i4++;
                    a2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    a2 = i5;
                }
                i3++;
                i5 = a2;
            }
            if (i5 + a > i2) {
                return i4 + 1;
            }
            return i4;
        }
    }

    public static final class C0760a extends C0759c {
        public int mo572a(int i) {
            return 1;
        }

        public int mo573a(int i, int i2) {
            return i % i2;
        }
    }

    public static class C0762b extends C0761i {
        private int f1697e = -1;
        private int f1698f = 0;

        public C0762b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0762b(int i, int i2) {
            super(i, i2);
        }

        public C0762b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0762b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int m3240a() {
            return this.f1697e;
        }

        public int m3241b() {
            return this.f1698f;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m3462a(C0763h.m3244a(context, attributeSet, i, i2).f1774b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        m3462a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        m3462a(i);
    }

    public void mo608a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.mo608a(false);
    }

    public int mo596a(C0793n c0793n, C0798r c0798r) {
        if (this.i == 0) {
            return this.f1724b;
        }
        if (c0798r.m3687e() < 1) {
            return 0;
        }
        return m3445a(c0793n, c0798r, c0798r.m3687e() - 1) + 1;
    }

    public int mo610b(C0793n c0793n, C0798r c0798r) {
        if (this.i == 1) {
            return this.f1724b;
        }
        if (c0798r.m3687e() < 1) {
            return 0;
        }
        return m3445a(c0793n, c0798r, c0798r.m3687e() - 1) + 1;
    }

    public void mo603a(C0793n c0793n, C0798r c0798r, View view, C0489c c0489c) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0762b) {
            C0762b c0762b = (C0762b) layoutParams;
            int a = m3445a(c0793n, c0798r, c0762b.m3235e());
            if (this.i == 0) {
                int a2 = c0762b.m3240a();
                int b = c0762b.m3241b();
                boolean z = this.f1724b > 1 && c0762b.m3241b() == this.f1724b;
                c0489c.m1950b(C0488m.m1940a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = c0762b.m3240a();
            int b2 = c0762b.m3241b();
            boolean z2 = this.f1724b > 1 && c0762b.m3241b() == this.f1724b;
            c0489c.m1950b(C0488m.m1940a(a, 1, a3, b2, z2, false));
            return;
        }
        super.m3290a(view, c0489c);
    }

    public void mo587c(C0793n c0793n, C0798r c0798r) {
        if (c0798r.m3683a()) {
            m3442J();
        }
        super.mo587c(c0793n, c0798r);
        m3441I();
        if (!c0798r.m3683a()) {
            this.f1723a = false;
        }
    }

    private void m3441I() {
        this.f1727e.clear();
        this.f1728f.clear();
    }

    private void m3442J() {
        int t = m3367t();
        for (int i = 0; i < t; i++) {
            C0762b c0762b = (C0762b) m3349h(i).getLayoutParams();
            int e = c0762b.m3235e();
            this.f1727e.put(e, c0762b.m3241b());
            this.f1728f.put(e, c0762b.m3240a());
        }
    }

    public void mo605a(RecyclerView recyclerView, int i, int i2) {
        this.f1729g.m3227a();
    }

    public void mo604a(RecyclerView recyclerView) {
        this.f1729g.m3227a();
    }

    public void mo611b(RecyclerView recyclerView, int i, int i2) {
        this.f1729g.m3227a();
    }

    public void mo607a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f1729g.m3227a();
    }

    public void mo606a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f1729g.m3227a();
    }

    public C0761i mo575a() {
        if (this.i == 0) {
            return new C0762b(-2, -1);
        }
        return new C0762b(-1, -2);
    }

    public C0761i mo597a(Context context, AttributeSet attributeSet) {
        return new C0762b(context, attributeSet);
    }

    public C0761i mo598a(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0762b((MarginLayoutParams) layoutParams);
        }
        return new C0762b(layoutParams);
    }

    public boolean mo609a(C0761i c0761i) {
        return c0761i instanceof C0762b;
    }

    private void m3443K() {
        int w;
        if (m3431f() == 1) {
            w = (m3370w() - m3254A()) - m3372y();
        } else {
            w = (m3371x() - m3255B()) - m3373z();
        }
        m3454l(w);
    }

    public void mo600a(Rect rect, int i, int i2) {
        if (this.f1725c == null) {
            super.mo600a(rect, i, i2);
        }
        int A = m3254A() + m3372y();
        int z = m3373z() + m3255B();
        if (this.i == 1) {
            z = C0763h.m3242a(i2, z + rect.height(), m3258E());
            A = C0763h.m3242a(i, A + this.f1725c[this.f1725c.length - 1], m3257D());
        } else {
            A = C0763h.m3242a(i, A + rect.width(), m3257D());
            z = C0763h.m3242a(i2, z + this.f1725c[this.f1725c.length - 1], m3258E());
        }
        m3333d(A, z);
    }

    private void m3454l(int i) {
        this.f1725c = m3449a(this.f1725c, this.f1724b, i);
    }

    static int[] m3449a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    void mo601a(C0793n c0793n, C0798r c0798r, C0765a c0765a, int i) {
        super.mo601a(c0793n, c0798r, c0765a, i);
        m3443K();
        if (c0798r.m3687e() > 0 && !c0798r.m3683a()) {
            m3452b(c0793n, c0798r, c0765a, i);
        }
        m3444L();
    }

    private void m3444L() {
        if (this.f1726d == null || this.f1726d.length != this.f1724b) {
            this.f1726d = new View[this.f1724b];
        }
    }

    public int mo574a(int i, C0793n c0793n, C0798r c0798r) {
        m3443K();
        m3444L();
        return super.mo574a(i, c0793n, c0798r);
    }

    public int mo581b(int i, C0793n c0793n, C0798r c0798r) {
        m3443K();
        m3444L();
        return super.mo581b(i, c0793n, c0798r);
    }

    private void m3452b(C0793n c0793n, C0798r c0798r, C0765a c0765a, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = m3451b(c0793n, c0798r, c0765a.f1734a);
        if (obj != null) {
            while (b > 0 && c0765a.f1734a > 0) {
                c0765a.f1734a--;
                b = m3451b(c0793n, c0798r, c0765a.f1734a);
            }
            return;
        }
        int e = c0798r.m3687e() - 1;
        int i2 = c0765a.f1734a;
        int i3 = b;
        while (i2 < e) {
            b = m3451b(c0793n, c0798r, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        c0765a.f1734a = i2;
    }

    View mo599a(C0793n c0793n, C0798r c0798r, int i, int i2, int i3) {
        View view = null;
        m3435h();
        int c = this.j.mo656c();
        int d = this.j.mo658d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m3349h(i);
            int d2 = m3330d(h);
            if (d2 >= 0 && d2 < i3) {
                if (m3451b(c0793n, c0798r, d2) != 0) {
                    view3 = view;
                    h = view2;
                } else if (((C0761i) h.getLayoutParams()).m3233c()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.j.mo653a(h) < d && this.j.mo655b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = h;
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

    private int m3445a(C0793n c0793n, C0798r c0798r, int i) {
        if (!c0798r.m3683a()) {
            return this.f1729g.m3230c(i, this.f1724b);
        }
        int b = c0793n.m3626b(i);
        if (b != -1) {
            return this.f1729g.m3230c(b, this.f1724b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int m3451b(C0793n c0793n, C0798r c0798r, int i) {
        if (!c0798r.m3683a()) {
            return this.f1729g.m3229b(i, this.f1724b);
        }
        int i2 = this.f1728f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0793n.m3626b(i);
        if (i2 != -1) {
            return this.f1729g.m3229b(i2, this.f1724b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int m3453c(C0793n c0793n, C0798r c0798r, int i) {
        if (!c0798r.m3683a()) {
            return this.f1729g.mo572a(i);
        }
        int i2 = this.f1727e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0793n.m3626b(i);
        if (i2 != -1) {
            return this.f1729g.mo572a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    void mo602a(C0793n c0793n, C0798r c0798r, C0767c c0767c, C0766b c0766b) {
        int i = this.j.mo664i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = m3367t() > 0 ? this.f1725c[this.f1724b] : 0;
        if (obj != null) {
            m3443K();
        }
        boolean z = c0767c.f1746e == 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f1724b;
        if (!z) {
            i5 = m3451b(c0793n, c0798r, c0767c.f1745d) + m3453c(c0793n, c0798r, c0767c.f1745d);
        }
        while (i3 < this.f1724b && c0767c.m3493a(c0798r) && i5 > 0) {
            int i6 = c0767c.f1745d;
            int c = m3453c(c0793n, c0798r, i6);
            if (c <= this.f1724b) {
                i5 -= c;
                if (i5 >= 0) {
                    View a = c0767c.m3490a(c0793n);
                    if (a == null) {
                        break;
                    }
                    i4 += c;
                    this.f1726d[i3] = a;
                    i3++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i6 + " requires " + c + " spans but GridLayoutManager has only " + this.f1724b + " spans.");
        }
        if (i3 == 0) {
            c0766b.f1739b = true;
            return;
        }
        View view;
        int a2;
        int a3;
        m3447a(c0793n, c0798r, i3, i4, z);
        int i7 = 0;
        float f = 0.0f;
        c = 0;
        while (i7 < i3) {
            View view2 = this.f1726d[i7];
            if (c0767c.f1752k == null) {
                if (z) {
                    m3313b(view2);
                } else {
                    m3314b(view2, 0);
                }
            } else if (z) {
                m3284a(view2);
            } else {
                m3285a(view2, 0);
            }
            C0762b c0762b = (C0762b) view2.getLayoutParams();
            int a4 = C0763h.m3243a(this.f1725c[c0762b.f1697e + c0762b.f1698f] - this.f1725c[c0762b.f1697e], i, 0, this.i == 0 ? c0762b.height : c0762b.width, false);
            int a5 = C0763h.m3243a(this.j.mo661f(), this.j.mo663h(), 0, this.i == 1 ? c0762b.height : c0762b.width, true);
            if (this.i == 1) {
                m3448a(view2, a4, a5, c0762b.height == -1, false);
            } else {
                m3448a(view2, a5, a4, c0762b.width == -1, false);
            }
            i6 = this.j.mo657c(view2);
            if (i6 <= c) {
                i6 = c;
            }
            float d = (1.0f * ((float) this.j.mo659d(view2))) / ((float) c0762b.f1698f);
            if (d <= f) {
                d = f;
            }
            i7++;
            f = d;
            c = i6;
        }
        if (obj != null) {
            m3446a(f, i2);
            c = 0;
            int i8 = 0;
            while (i8 < i3) {
                view = this.f1726d[i8];
                c0762b = (C0762b) view.getLayoutParams();
                a2 = C0763h.m3243a(this.f1725c[c0762b.f1697e + c0762b.f1698f] - this.f1725c[c0762b.f1697e], 1073741824, 0, this.i == 0 ? c0762b.height : c0762b.width, false);
                a3 = C0763h.m3243a(this.j.mo661f(), this.j.mo663h(), 0, this.i == 1 ? c0762b.height : c0762b.width, true);
                if (this.i == 1) {
                    m3448a(view, a2, a3, false, true);
                } else {
                    m3448a(view, a3, a2, false, true);
                }
                i5 = this.j.mo657c(view);
                if (i5 <= c) {
                    i5 = c;
                }
                i8++;
                c = i5;
            }
        }
        a3 = MeasureSpec.makeMeasureSpec(c, 1073741824);
        for (i6 = 0; i6 < i3; i6++) {
            view = this.f1726d[i6];
            if (this.j.mo657c(view) != c) {
                c0762b = (C0762b) view.getLayoutParams();
                a2 = C0763h.m3243a(this.f1725c[c0762b.f1697e + c0762b.f1698f] - this.f1725c[c0762b.f1697e], 1073741824, 0, this.i == 0 ? c0762b.height : c0762b.width, false);
                if (this.i == 1) {
                    m3448a(view, a2, a3, true, true);
                } else {
                    m3448a(view, a3, a2, true, true);
                }
            }
        }
        c0766b.f1738a = c;
        i6 = 0;
        i5 = 0;
        if (this.i == 1) {
            if (c0767c.f1747f == -1) {
                i5 = c0767c.f1743b;
                i6 = i5 - c;
                c = 0;
                i4 = 0;
            } else {
                i6 = c0767c.f1743b;
                i5 = i6 + c;
                c = 0;
                i4 = 0;
            }
        } else if (c0767c.f1747f == -1) {
            i4 = c0767c.f1743b;
            int i9 = i4;
            i4 -= c;
            c = i9;
        } else {
            i4 = c0767c.f1743b;
            c += i4;
        }
        int i10 = 0;
        a2 = i4;
        i4 = c;
        c = i6;
        i6 = i5;
        while (i10 < i3) {
            int i11;
            int i12;
            view = this.f1726d[i10];
            c0762b = (C0762b) view.getLayoutParams();
            if (this.i != 1) {
                c = this.f1725c[c0762b.f1697e] + m3373z();
                i6 = this.j.mo659d(view) + c;
                i11 = i4;
                i12 = a2;
            } else if (m3434g()) {
                i4 = m3372y() + this.f1725c[c0762b.f1697e + c0762b.f1698f];
                i11 = i4;
                i12 = i4 - this.j.mo659d(view);
            } else {
                a2 = this.f1725c[c0762b.f1697e] + m3372y();
                i11 = this.j.mo659d(view) + a2;
                i12 = a2;
            }
            m3287a(view, i12 + c0762b.leftMargin, c + c0762b.topMargin, i11 - c0762b.rightMargin, i6 - c0762b.bottomMargin);
            if (c0762b.m3233c() || c0762b.m3234d()) {
                c0766b.f1740c = true;
            }
            c0766b.f1741d |= view.isFocusable();
            i10++;
            i4 = i11;
            a2 = i12;
        }
        Arrays.fill(this.f1726d, null);
    }

    private void m3446a(float f, int i) {
        m3454l(Math.max(Math.round(((float) this.f1724b) * f), i));
    }

    private void m3448a(View view, int i, int i2, boolean z, boolean z2) {
        boolean a;
        m3289a(view, this.f1730h);
        C0761i c0761i = (C0761i) view.getLayoutParams();
        if (z || this.i == 1) {
            i = m3450b(i, c0761i.leftMargin + this.f1730h.left, c0761i.rightMargin + this.f1730h.right);
        }
        if (z || this.i == 0) {
            i2 = m3450b(i2, c0761i.topMargin + this.f1730h.top, c0761i.bottomMargin + this.f1730h.bottom);
        }
        if (z2) {
            a = m3302a(view, i, i2, c0761i);
        } else {
            a = m3316b(view, i, i2, c0761i);
        }
        if (a) {
            view.measure(i, i2);
        }
    }

    private int m3450b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    private void m3447a(C0793n c0793n, C0798r c0798r, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = i - 1;
            i3 = -1;
            i = -1;
        }
        if (this.i == 1 && m3434g()) {
            i5 = this.f1724b - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.f1726d[i5];
            C0762b c0762b = (C0762b) view.getLayoutParams();
            c0762b.f1698f = m3453c(c0793n, c0798r, m3330d(view));
            if (i6 != -1 || c0762b.f1698f <= 1) {
                c0762b.f1697e = i7;
            } else {
                c0762b.f1697e = i7 - (c0762b.f1698f - 1);
            }
            i7 += c0762b.f1698f * i6;
        }
    }

    public void m3462a(int i) {
        if (i != this.f1724b) {
            this.f1723a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f1724b = i;
            this.f1729g.m3227a();
        }
    }

    public View mo576a(View view, int i, C0793n c0793n, C0798r c0798r) {
        View e = m3337e(view);
        if (e == null) {
            return null;
        }
        C0762b c0762b = (C0762b) e.getLayoutParams();
        int a = c0762b.f1697e;
        int a2 = c0762b.f1697e + c0762b.f1698f;
        if (super.mo576a(view, i, c0793n, c0798r) == null) {
            return null;
        }
        int t;
        int i2;
        int i3;
        if (((m3428e(i) == 1) != this.k ? 1 : null) != null) {
            t = m3367t() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            t = 0;
            i2 = 1;
            i3 = m3367t();
        }
        Object obj = (this.i == 1 && m3434g()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = t;
        while (i6 != i3) {
            View h = m3349h(i6);
            if (h == e) {
                break;
            }
            View view3;
            if (h.isFocusable()) {
                c0762b = (C0762b) h.getLayoutParams();
                int a3 = c0762b.f1697e;
                int a4 = c0762b.f1697e + c0762b.f1698f;
                if (a3 == a && a4 == a2) {
                    return h;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = c0762b.f1697e;
                    t = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = h;
                } else {
                    t = i5;
                    i5 = i4;
                    view3 = view2;
                }
            } else {
                t = i5;
                i5 = i4;
                view3 = view2;
            }
            i6 += i2;
            view2 = view3;
            i4 = i5;
            i5 = t;
        }
        return view2;
    }

    public boolean mo583b() {
        return this.n == null && !this.f1723a;
    }
}
