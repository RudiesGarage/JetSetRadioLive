package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.p022e.C0329h;
import android.support.v4.view.C0601s;
import android.support.v4.view.C0603u;
import android.support.v4.view.C0604v;
import android.support.v4.view.aa;
import android.support.v4.view.ac;
import android.support.v4.view.ae;
import android.support.v4.view.am;
import android.support.v4.view.p025a.C0474a;
import android.support.v4.view.p025a.C0489c;
import android.support.v4.view.p025a.C0489c.C0487l;
import android.support.v4.view.p025a.C0489c.C0488m;
import android.support.v4.view.p025a.C0512k;
import android.support.v4.widget.C0622d;
import android.support.v4.widget.C0639p;
import android.support.v7.p032e.C0677a.C0676a;
import android.support.v7.widget.C0866f.C0775a;
import android.support.v7.widget.C0866f.C0865b;
import android.support.v7.widget.C0888r.C0773b;
import android.support.v7.widget.av.C0771b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements aa, C0603u {
    static final boolean f1839a;
    private static final Interpolator aq = new C07703();
    private static final int[] f1840k = new int[]{16843830};
    private static final boolean f1841l;
    private static final Class<?>[] f1842m = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private int f1843A;
    private boolean f1844B;
    private boolean f1845C;
    private boolean f1846D;
    private int f1847E;
    private boolean f1848F;
    private final boolean f1849G;
    private final AccessibilityManager f1850H;
    private List<C0789j> f1851I;
    private boolean f1852J;
    private int f1853K;
    private C0622d f1854L;
    private C0622d f1855M;
    private C0622d f1856N;
    private C0622d f1857O;
    private int f1858P;
    private int f1859Q;
    private VelocityTracker f1860R;
    private int f1861S;
    private int f1862T;
    private int f1863U;
    private int f1864V;
    private int f1865W;
    private final int aa;
    private final int ab;
    private float ac;
    private final C0800t ad;
    private C0791l ae;
    private List<C0791l> af;
    private C0783b ag;
    private boolean ah;
    private ag ai;
    private C0781d aj;
    private final int[] ak;
    private C0604v al;
    private final int[] am;
    private final int[] an;
    private final int[] ao;
    private Runnable ap;
    private final C0771b ar;
    final C0793n f1866b;
    C0866f f1867c;
    C0888r f1868d;
    final av f1869e;
    C0763h f1870f;
    C0785e f1871g;
    final C0798r f1872h;
    boolean f1873i;
    boolean f1874j;
    private final C0795p f1875n;
    private SavedState f1876o;
    private boolean f1877p;
    private final Runnable f1878q;
    private final Rect f1879r;
    private C0778a f1880s;
    private C0794o f1881t;
    private final ArrayList<C0787g> f1882u;
    private final ArrayList<C0790k> f1883v;
    private C0790k f1884w;
    private boolean f1885x;
    private boolean f1886y;
    private boolean f1887z;

    public static class C0761i extends MarginLayoutParams {
        C0801u f1693a;
        final Rect f1694b = new Rect();
        boolean f1695c = true;
        boolean f1696d = false;

        public C0761i(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0761i(int i, int i2) {
            super(i, i2);
        }

        public C0761i(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0761i(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0761i(C0761i c0761i) {
            super(c0761i);
        }

        public boolean m3233c() {
            return this.f1693a.m3737q();
        }

        public boolean m3234d() {
            return this.f1693a.m3744x();
        }

        public int m3235e() {
            return this.f1693a.m3724d();
        }
    }

    public static abstract class C0763h {
        private boolean f1699a = false;
        private boolean f1700b = false;
        private boolean f1701c = true;
        private int f1702d;
        private int f1703e;
        private int f1704f;
        private int f1705g;
        C0888r f1706p;
        RecyclerView f1707q;
        C0797q f1708r;
        boolean f1709s = false;

        public static class C0788a {
            public int f1773a;
            public int f1774b;
            public boolean f1775c;
            public boolean f1776d;
        }

        public abstract C0761i mo575a();

        void m3310b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f1707q = null;
                this.f1706p = null;
                this.f1704f = 0;
                this.f1705g = 0;
            } else {
                this.f1707q = recyclerView;
                this.f1706p = recyclerView.f1868d;
                this.f1704f = recyclerView.getWidth();
                this.f1705g = recyclerView.getHeight();
            }
            this.f1702d = 1073741824;
            this.f1703e = 1073741824;
        }

        void m3268a(int i, int i2) {
            this.f1704f = MeasureSpec.getSize(i);
            this.f1702d = MeasureSpec.getMode(i);
            if (this.f1702d == 0 && !RecyclerView.f1839a) {
                this.f1704f = 0;
            }
            this.f1705g = MeasureSpec.getSize(i2);
            this.f1703e = MeasureSpec.getMode(i2);
            if (this.f1703e == 0 && !RecyclerView.f1839a) {
                this.f1705g = 0;
            }
        }

        void m3308b(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int t = m3367t();
            if (t == 0) {
                this.f1707q.m3841d(i, i2);
                return;
            }
            int i5 = 0;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            while (i5 < t) {
                View h = m3349h(i5);
                C0761i c0761i = (C0761i) h.getLayoutParams();
                int h2 = m3348h(h) - c0761i.leftMargin;
                int j = c0761i.rightMargin + m3352j(h);
                int i8 = m3350i(h) - c0761i.topMargin;
                int k = c0761i.bottomMargin + m3354k(h);
                if (h2 >= i7) {
                    h2 = i7;
                }
                if (j <= i6) {
                    j = i6;
                }
                if (i8 >= i3) {
                    i8 = i3;
                }
                if (k <= i4) {
                    k = i4;
                }
                i5++;
                i6 = j;
                i3 = i8;
                i7 = h2;
                i4 = k;
            }
            this.f1707q.f1879r.set(i7, i3, i6, i4);
            mo600a(this.f1707q.f1879r, i, i2);
        }

        public void mo600a(Rect rect, int i, int i2) {
            m3333d(C0763h.m3242a(i, (rect.width() + m3372y()) + m3254A(), m3257D()), C0763h.m3242a(i2, (rect.height() + m3373z()) + m3255B(), m3258E()));
        }

        public void m3360n() {
            if (this.f1707q != null) {
                this.f1707q.requestLayout();
            }
        }

        public static int m3242a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public void mo580a(String str) {
            if (this.f1707q != null) {
                this.f1707q.m3827a(str);
            }
        }

        public void m3327c(boolean z) {
            this.f1700b = z;
        }

        public boolean mo583b() {
            return false;
        }

        void m3323c(RecyclerView recyclerView) {
            this.f1709s = true;
            m3334d(recyclerView);
        }

        void m3312b(RecyclerView recyclerView, C0793n c0793n) {
            this.f1709s = false;
            mo578a(recyclerView, c0793n);
        }

        public boolean m3362o() {
            return this.f1709s;
        }

        public boolean m3304a(Runnable runnable) {
            if (this.f1707q != null) {
                return this.f1707q.removeCallbacks(runnable);
            }
            return false;
        }

        public void m3334d(RecyclerView recyclerView) {
        }

        @Deprecated
        public void m3338e(RecyclerView recyclerView) {
        }

        public void mo578a(RecyclerView recyclerView, C0793n c0793n) {
            m3338e(recyclerView);
        }

        public boolean m3363p() {
            return this.f1707q != null && this.f1707q.f1877p;
        }

        public void mo587c(C0793n c0793n, C0798r c0798r) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public boolean mo609a(C0761i c0761i) {
            return c0761i != null;
        }

        public C0761i mo598a(LayoutParams layoutParams) {
            if (layoutParams instanceof C0761i) {
                return new C0761i((C0761i) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new C0761i((MarginLayoutParams) layoutParams);
            }
            return new C0761i(layoutParams);
        }

        public C0761i mo597a(Context context, AttributeSet attributeSet) {
            return new C0761i(context, attributeSet);
        }

        public int mo574a(int i, C0793n c0793n, C0798r c0798r) {
            return 0;
        }

        public int mo581b(int i, C0793n c0793n, C0798r c0798r) {
            return 0;
        }

        public boolean mo590d() {
            return false;
        }

        public boolean mo592e() {
            return false;
        }

        public void mo589d(int i) {
        }

        public boolean m3364q() {
            return this.f1708r != null && this.f1708r.m3662c();
        }

        public int m3365r() {
            return ae.m2228h(this.f1707q);
        }

        public void m3284a(View view) {
            m3285a(view, -1);
        }

        public void m3285a(View view, int i) {
            m3249a(view, i, true);
        }

        public void m3313b(View view) {
            m3314b(view, -1);
        }

        public void m3314b(View view, int i) {
            m3249a(view, i, false);
        }

        private void m3249a(View view, int i, boolean z) {
            C0801u c = RecyclerView.m3783c(view);
            if (z || c.m3737q()) {
                this.f1707q.f1869e.m4356e(c);
            } else {
                this.f1707q.f1869e.m4357f(c);
            }
            C0761i c0761i = (C0761i) view.getLayoutParams();
            if (c.m3731k() || c.m3729i()) {
                if (c.m3729i()) {
                    c.m3730j();
                } else {
                    c.m3732l();
                }
                this.f1706p.m4529a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f1707q) {
                int b = this.f1706p.m4533b(view);
                if (i == -1) {
                    i = this.f1706p.m4532b();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1707q.indexOfChild(view));
                } else if (b != i) {
                    this.f1707q.f1870f.m3320c(b, i);
                }
            } else {
                this.f1706p.m4530a(view, i, false);
                c0761i.f1695c = true;
                if (this.f1708r != null && this.f1708r.m3662c()) {
                    this.f1708r.m3660b(view);
                }
            }
            if (c0761i.f1696d) {
                c.f1823a.invalidate();
                c0761i.f1696d = false;
            }
        }

        public void m3325c(View view) {
            this.f1706p.m4528a(view);
        }

        public void m3343f(int i) {
            if (m3349h(i) != null) {
                this.f1706p.m4527a(i);
            }
        }

        public int m3366s() {
            return -1;
        }

        public int m3330d(View view) {
            return ((C0761i) view.getLayoutParams()).m3235e();
        }

        public View m3337e(View view) {
            if (this.f1707q == null) {
                return null;
            }
            View b = this.f1707q.m3831b(view);
            if (b == null || this.f1706p.m4537c(b)) {
                return null;
            }
            return b;
        }

        public View mo586c(int i) {
            int t = m3367t();
            for (int i2 = 0; i2 < t; i2++) {
                View h = m3349h(i2);
                C0801u c = RecyclerView.m3783c(h);
                if (c != null && c.m3724d() == i && !c.m3723c() && (this.f1707q.f1872h.m3683a() || !c.m3737q())) {
                    return h;
                }
            }
            return null;
        }

        public void m3347g(int i) {
            m3245a(i, m3349h(i));
        }

        private void m3245a(int i, View view) {
            this.f1706p.m4538d(i);
        }

        public void m3288a(View view, int i, C0761i c0761i) {
            C0801u c = RecyclerView.m3783c(view);
            if (c.m3737q()) {
                this.f1707q.f1869e.m4356e(c);
            } else {
                this.f1707q.f1869e.m4357f(c);
            }
            this.f1706p.m4529a(view, i, c0761i, c.m3737q());
        }

        public void m3326c(View view, int i) {
            m3288a(view, i, (C0761i) view.getLayoutParams());
        }

        public void m3320c(int i, int i2) {
            View h = m3349h(i);
            if (h == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            m3347g(i);
            m3326c(h, i2);
        }

        public void m3291a(View view, C0793n c0793n) {
            m3325c(view);
            c0793n.m3624a(view);
        }

        public void m3269a(int i, C0793n c0793n) {
            View h = m3349h(i);
            m3343f(i);
            c0793n.m3624a(h);
        }

        public int m3367t() {
            return this.f1706p != null ? this.f1706p.m4532b() : 0;
        }

        public View m3349h(int i) {
            return this.f1706p != null ? this.f1706p.m4534b(i) : null;
        }

        public int m3368u() {
            return this.f1702d;
        }

        public int m3369v() {
            return this.f1703e;
        }

        public int m3370w() {
            return this.f1704f;
        }

        public int m3371x() {
            return this.f1705g;
        }

        public int m3372y() {
            return this.f1707q != null ? this.f1707q.getPaddingLeft() : 0;
        }

        public int m3373z() {
            return this.f1707q != null ? this.f1707q.getPaddingTop() : 0;
        }

        public int m3254A() {
            return this.f1707q != null ? this.f1707q.getPaddingRight() : 0;
        }

        public int m3255B() {
            return this.f1707q != null ? this.f1707q.getPaddingBottom() : 0;
        }

        public View m3256C() {
            if (this.f1707q == null) {
                return null;
            }
            View focusedChild = this.f1707q.getFocusedChild();
            if (focusedChild == null || this.f1706p.m4537c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void mo636i(int i) {
            if (this.f1707q != null) {
                this.f1707q.m3833b(i);
            }
        }

        public void mo637j(int i) {
            if (this.f1707q != null) {
                this.f1707q.m3823a(i);
            }
        }

        public void m3274a(C0793n c0793n) {
            for (int t = m3367t() - 1; t >= 0; t--) {
                m3247a(c0793n, t, m3349h(t));
            }
        }

        private void m3247a(C0793n c0793n, int i, View view) {
            C0801u c = RecyclerView.m3783c(view);
            if (!c.m3723c()) {
                if (!c.m3734n() || c.m3737q() || this.f1707q.f1880s.m3559b()) {
                    m3347g(i);
                    c0793n.m3636c(view);
                    this.f1707q.f1869e.m4359h(c);
                    return;
                }
                m3343f(i);
                c0793n.m3630b(c);
            }
        }

        void m3309b(C0793n c0793n) {
            int d = c0793n.m3637d();
            for (int i = d - 1; i >= 0; i--) {
                View e = c0793n.m3640e(i);
                C0801u c = RecyclerView.m3783c(e);
                if (!c.m3723c()) {
                    c.m3719a(false);
                    if (c.m3738r()) {
                        this.f1707q.removeDetachedView(e, false);
                    }
                    if (this.f1707q.f1871g != null) {
                        this.f1707q.f1871g.mo707c(c);
                    }
                    c.m3719a(true);
                    c0793n.m3631b(e);
                }
            }
            c0793n.m3641e();
            if (d > 0) {
                this.f1707q.invalidate();
            }
        }

        boolean m3302a(View view, int i, int i2, C0761i c0761i) {
            return (this.f1701c && C0763h.m3252b(view.getMeasuredWidth(), i, c0761i.width) && C0763h.m3252b(view.getMeasuredHeight(), i2, c0761i.height)) ? false : true;
        }

        boolean m3316b(View view, int i, int i2, C0761i c0761i) {
            return (!view.isLayoutRequested() && this.f1701c && C0763h.m3252b(view.getWidth(), i, c0761i.width) && C0763h.m3252b(view.getHeight(), i2, c0761i.height)) ? false : true;
        }

        private static boolean m3252b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    if (size < i) {
                        return false;
                    }
                    return true;
                case 0:
                    return true;
                case 1073741824:
                    if (size != i) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }

        public void m3286a(View view, int i, int i2) {
            C0761i c0761i = (C0761i) view.getLayoutParams();
            Rect g = this.f1707q.m3848g(view);
            int i3 = (g.left + g.right) + i;
            int i4 = (g.bottom + g.top) + i2;
            i3 = C0763h.m3243a(m3370w(), m3368u(), i3 + (((m3372y() + m3254A()) + c0761i.leftMargin) + c0761i.rightMargin), c0761i.width, mo590d());
            i4 = C0763h.m3243a(m3371x(), m3369v(), i4 + (((m3373z() + m3255B()) + c0761i.topMargin) + c0761i.bottomMargin), c0761i.height, mo592e());
            if (m3316b(view, i3, i4, c0761i)) {
                view.measure(i3, i4);
            }
        }

        public static int m3243a(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = max;
                            break;
                        case 0:
                            i2 = 0;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    max = i5;
                    i5 = i2;
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public int m3342f(View view) {
            Rect rect = ((C0761i) view.getLayoutParams()).f1694b;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public int m3346g(View view) {
            Rect rect = ((C0761i) view.getLayoutParams()).f1694b;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public void m3287a(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((C0761i) view.getLayoutParams()).f1694b;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public int m3348h(View view) {
            return view.getLeft() - m3359n(view);
        }

        public int m3350i(View view) {
            return view.getTop() - m3357l(view);
        }

        public int m3352j(View view) {
            return view.getRight() + m3361o(view);
        }

        public int m3354k(View view) {
            return view.getBottom() + m3358m(view);
        }

        public void m3289a(View view, Rect rect) {
            if (this.f1707q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f1707q.m3848g(view));
            }
        }

        public int m3357l(View view) {
            return ((C0761i) view.getLayoutParams()).f1694b.top;
        }

        public int m3358m(View view) {
            return ((C0761i) view.getLayoutParams()).f1694b.bottom;
        }

        public int m3359n(View view) {
            return ((C0761i) view.getLayoutParams()).f1694b.left;
        }

        public int m3361o(View view) {
            return ((C0761i) view.getLayoutParams()).f1694b.right;
        }

        public View mo576a(View view, int i, C0793n c0793n, C0798r c0798r) {
            return null;
        }

        public View m3331d(View view, int i) {
            return null;
        }

        public boolean m3299a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int y = m3372y();
            int z2 = m3373z();
            int w = m3370w() - m3254A();
            int x = m3371x() - m3255B();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = left + rect.width();
            int height = top + rect.height();
            int min = Math.min(0, left - y);
            int min2 = Math.min(0, top - z2);
            int max = Math.max(0, width - w);
            x = Math.max(0, height - x);
            if (m3365r() == 1) {
                if (max == 0) {
                    max = Math.max(min, width - w);
                }
                min = max;
            } else {
                min = min != 0 ? min : Math.min(left - y, max);
            }
            max = min2 != 0 ? min2 : Math.min(top - z2, x);
            if (min == 0 && max == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(min, max);
            } else {
                recyclerView.m3824a(min, max);
            }
            return true;
        }

        @Deprecated
        public boolean m3300a(RecyclerView recyclerView, View view, View view2) {
            return m3364q() || recyclerView.m3854j();
        }

        public boolean m3298a(RecyclerView recyclerView, C0798r c0798r, View view, View view2) {
            return m3300a(recyclerView, view, view2);
        }

        public void m3273a(C0778a c0778a, C0778a c0778a2) {
        }

        public boolean m3301a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void mo604a(RecyclerView recyclerView) {
        }

        public void mo605a(RecyclerView recyclerView, int i, int i2) {
        }

        public void mo611b(RecyclerView recyclerView, int i, int i2) {
        }

        public void m3324c(RecyclerView recyclerView, int i, int i2) {
        }

        public void mo607a(RecyclerView recyclerView, int i, int i2, Object obj) {
            m3324c(recyclerView, i, i2);
        }

        public void mo606a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public int mo588d(C0798r c0798r) {
            return 0;
        }

        public int mo582b(C0798r c0798r) {
            return 0;
        }

        public int mo593f(C0798r c0798r) {
            return 0;
        }

        public int mo591e(C0798r c0798r) {
            return 0;
        }

        public int mo584c(C0798r c0798r) {
            return 0;
        }

        public int mo594g(C0798r c0798r) {
            return 0;
        }

        public void m3275a(C0793n c0793n, C0798r c0798r, int i, int i2) {
            this.f1707q.m3841d(i, i2);
        }

        public void m3333d(int i, int i2) {
            this.f1707q.setMeasuredDimension(i, i2);
        }

        public int m3257D() {
            return ae.m2233m(this.f1707q);
        }

        public int m3258E() {
            return ae.m2234n(this.f1707q);
        }

        public Parcelable mo585c() {
            return null;
        }

        public void mo577a(Parcelable parcelable) {
        }

        void m3259F() {
            if (this.f1708r != null) {
                this.f1708r.m3656a();
            }
        }

        private void m3248a(C0797q c0797q) {
            if (this.f1708r == c0797q) {
                this.f1708r = null;
            }
        }

        public void mo638k(int i) {
        }

        public void m3321c(C0793n c0793n) {
            for (int t = m3367t() - 1; t >= 0; t--) {
                if (!RecyclerView.m3783c(m3349h(t)).m3723c()) {
                    m3269a(t, c0793n);
                }
            }
        }

        void m3272a(C0489c c0489c) {
            m3276a(this.f1707q.f1866b, this.f1707q.f1872h, c0489c);
        }

        public void m3276a(C0793n c0793n, C0798r c0798r, C0489c c0489c) {
            if (ae.m2220b(this.f1707q, -1) || ae.m2215a(this.f1707q, -1)) {
                c0489c.m1943a(8192);
                c0489c.m1947a(true);
            }
            if (ae.m2220b(this.f1707q, 1) || ae.m2215a(this.f1707q, 1)) {
                c0489c.m1943a(4096);
                c0489c.m1947a(true);
            }
            c0489c.m1946a(C0487l.m1939a(mo596a(c0793n, c0798r), mo610b(c0793n, c0798r), m3340e(c0793n, c0798r), m3328d(c0793n, c0798r)));
        }

        public void mo579a(AccessibilityEvent accessibilityEvent) {
            m3278a(this.f1707q.f1866b, this.f1707q.f1872h, accessibilityEvent);
        }

        public void m3278a(C0793n c0793n, C0798r c0798r, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            C0512k a = C0474a.m1857a(accessibilityEvent);
            if (this.f1707q != null && a != null) {
                if (!(ae.m2220b(this.f1707q, 1) || ae.m2220b(this.f1707q, -1) || ae.m2215a(this.f1707q, -1) || ae.m2215a(this.f1707q, 1))) {
                    z = false;
                }
                a.m2043a(z);
                if (this.f1707q.f1880s != null) {
                    a.m2042a(this.f1707q.f1880s.m3546a());
                }
            }
        }

        void m3290a(View view, C0489c c0489c) {
            C0801u c = RecyclerView.m3783c(view);
            if (c != null && !c.m3737q() && !this.f1706p.m4537c(c.f1823a)) {
                mo603a(this.f1707q.f1866b, this.f1707q.f1872h, view, c0489c);
            }
        }

        public void mo603a(C0793n c0793n, C0798r c0798r, View view, C0489c c0489c) {
            int d;
            int d2 = mo592e() ? m3330d(view) : 0;
            if (mo590d()) {
                d = m3330d(view);
            } else {
                d = 0;
            }
            c0489c.m1950b(C0488m.m1940a(d2, 1, d, 1, false, false));
        }

        public void m3260G() {
            this.f1699a = true;
        }

        public int m3328d(C0793n c0793n, C0798r c0798r) {
            return 0;
        }

        public int mo596a(C0793n c0793n, C0798r c0798r) {
            if (this.f1707q == null || this.f1707q.f1880s == null || !mo592e()) {
                return 1;
            }
            return this.f1707q.f1880s.m3546a();
        }

        public int mo610b(C0793n c0793n, C0798r c0798r) {
            if (this.f1707q == null || this.f1707q.f1880s == null || !mo590d()) {
                return 1;
            }
            return this.f1707q.f1880s.m3546a();
        }

        public boolean m3340e(C0793n c0793n, C0798r c0798r) {
            return false;
        }

        boolean m3294a(int i, Bundle bundle) {
            return m3296a(this.f1707q.f1866b, this.f1707q.f1872h, i, bundle);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean m3296a(android.support.v7.widget.RecyclerView.C0793n r7, android.support.v7.widget.RecyclerView.C0798r r8, int r9, android.os.Bundle r10) {
            /*
            r6 = this;
            r4 = -1;
            r2 = 1;
            r1 = 0;
            r0 = r6.f1707q;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            switch(r9) {
                case 4096: goto L_0x004a;
                case 8192: goto L_0x0018;
                default: goto L_0x000b;
            };
        L_0x000b:
            r0 = r1;
            r3 = r1;
        L_0x000d:
            if (r3 != 0) goto L_0x0011;
        L_0x000f:
            if (r0 == 0) goto L_0x0007;
        L_0x0011:
            r1 = r6.f1707q;
            r1.scrollBy(r0, r3);
            r1 = r2;
            goto L_0x0007;
        L_0x0018:
            r0 = r6.f1707q;
            r0 = android.support.v4.view.ae.m2220b(r0, r4);
            if (r0 == 0) goto L_0x007f;
        L_0x0020:
            r0 = r6.m3371x();
            r3 = r6.m3373z();
            r0 = r0 - r3;
            r3 = r6.m3255B();
            r0 = r0 - r3;
            r0 = -r0;
        L_0x002f:
            r3 = r6.f1707q;
            r3 = android.support.v4.view.ae.m2215a(r3, r4);
            if (r3 == 0) goto L_0x007a;
        L_0x0037:
            r3 = r6.m3370w();
            r4 = r6.m3372y();
            r3 = r3 - r4;
            r4 = r6.m3254A();
            r3 = r3 - r4;
            r3 = -r3;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x004a:
            r0 = r6.f1707q;
            r0 = android.support.v4.view.ae.m2220b(r0, r2);
            if (r0 == 0) goto L_0x007d;
        L_0x0052:
            r0 = r6.m3371x();
            r3 = r6.m3373z();
            r0 = r0 - r3;
            r3 = r6.m3255B();
            r0 = r0 - r3;
        L_0x0060:
            r3 = r6.f1707q;
            r3 = android.support.v4.view.ae.m2215a(r3, r2);
            if (r3 == 0) goto L_0x007a;
        L_0x0068:
            r3 = r6.m3370w();
            r4 = r6.m3372y();
            r3 = r3 - r4;
            r4 = r6.m3254A();
            r3 = r3 - r4;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x007a:
            r3 = r0;
            r0 = r1;
            goto L_0x000d;
        L_0x007d:
            r0 = r1;
            goto L_0x0060;
        L_0x007f:
            r0 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.h.a(android.support.v7.widget.RecyclerView$n, android.support.v7.widget.RecyclerView$r, int, android.os.Bundle):boolean");
        }

        boolean m3303a(View view, int i, Bundle bundle) {
            return m3297a(this.f1707q.f1866b, this.f1707q.f1872h, view, i, bundle);
        }

        public boolean m3297a(C0793n c0793n, C0798r c0798r, View view, int i, Bundle bundle) {
            return false;
        }

        public static C0788a m3244a(Context context, AttributeSet attributeSet, int i, int i2) {
            C0788a c0788a = new C0788a();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0676a.RecyclerView, i, i2);
            c0788a.f1773a = obtainStyledAttributes.getInt(C0676a.RecyclerView_android_orientation, 1);
            c0788a.f1774b = obtainStyledAttributes.getInt(C0676a.RecyclerView_spanCount, 1);
            c0788a.f1775c = obtainStyledAttributes.getBoolean(C0676a.RecyclerView_reverseLayout, false);
            c0788a.f1776d = obtainStyledAttributes.getBoolean(C0676a.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return c0788a;
        }

        void m3344f(RecyclerView recyclerView) {
            m3268a(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean mo595k() {
            return false;
        }

        boolean m3261H() {
            int t = m3367t();
            for (int i = 0; i < t; i++) {
                LayoutParams layoutParams = m3349h(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    class C07681 implements Runnable {
        final /* synthetic */ RecyclerView f1754a;

        C07681(RecyclerView recyclerView) {
            this.f1754a = recyclerView;
        }

        public void run() {
            if (this.f1754a.f1887z && !this.f1754a.isLayoutRequested()) {
                if (this.f1754a.f1845C) {
                    this.f1754a.f1844B = true;
                } else {
                    this.f1754a.m3812t();
                }
            }
        }
    }

    class C07692 implements Runnable {
        final /* synthetic */ RecyclerView f1755a;

        C07692(RecyclerView recyclerView) {
            this.f1755a = recyclerView;
        }

        public void run() {
            if (this.f1755a.f1871g != null) {
                this.f1755a.f1871g.mo699a();
            }
            this.f1755a.ah = false;
        }
    }

    static class C07703 implements Interpolator {
        C07703() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C07724 implements C0771b {
        final /* synthetic */ RecyclerView f1756a;

        C07724(RecyclerView recyclerView) {
            this.f1756a = recyclerView;
        }

        public void mo613a(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
            this.f1756a.f1866b.m3639d(c0801u);
            this.f1756a.m3775b(c0801u, c0784c, c0784c2);
        }

        public void mo614b(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
            this.f1756a.m3760a(c0801u, c0784c, c0784c2);
        }

        public void mo615c(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
            c0801u.m3719a(false);
            if (this.f1756a.f1852J) {
                if (this.f1756a.f1871g.mo668a(c0801u, c0801u, c0784c, c0784c2)) {
                    this.f1756a.m3747C();
                }
            } else if (this.f1756a.f1871g.mo670c(c0801u, c0784c, c0784c2)) {
                this.f1756a.m3747C();
            }
        }

        public void mo612a(C0801u c0801u) {
            this.f1756a.f1870f.m3291a(c0801u.f1823a, this.f1756a.f1866b);
        }
    }

    class C07745 implements C0773b {
        final /* synthetic */ RecyclerView f1757a;

        C07745(RecyclerView recyclerView) {
            this.f1757a = recyclerView;
        }

        public int mo616a() {
            return this.f1757a.getChildCount();
        }

        public void mo619a(View view, int i) {
            this.f1757a.addView(view, i);
            this.f1757a.m3801j(view);
        }

        public int mo617a(View view) {
            return this.f1757a.indexOfChild(view);
        }

        public void mo618a(int i) {
            View childAt = this.f1757a.getChildAt(i);
            if (childAt != null) {
                this.f1757a.m3799i(childAt);
            }
            this.f1757a.removeViewAt(i);
        }

        public View mo622b(int i) {
            return this.f1757a.getChildAt(i);
        }

        public void mo623b() {
            int a = mo616a();
            for (int i = 0; i < a; i++) {
                this.f1757a.m3799i(mo622b(i));
            }
            this.f1757a.removeAllViews();
        }

        public C0801u mo621b(View view) {
            return RecyclerView.m3783c(view);
        }

        public void mo620a(View view, int i, LayoutParams layoutParams) {
            C0801u c = RecyclerView.m3783c(view);
            if (c != null) {
                if (c.m3738r() || c.m3723c()) {
                    c.m3733m();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + c);
                }
            }
            this.f1757a.attachViewToParent(view, i, layoutParams);
        }

        public void mo624c(int i) {
            View b = mo622b(i);
            if (b != null) {
                C0801u c = RecyclerView.m3783c(b);
                if (c != null) {
                    if (!c.m3738r() || c.m3723c()) {
                        c.m3722b(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + c);
                    }
                }
            }
            this.f1757a.detachViewFromParent(i);
        }

        public void mo625c(View view) {
            C0801u c = RecyclerView.m3783c(view);
            if (c != null) {
                c.m3712z();
            }
        }

        public void mo626d(View view) {
            C0801u c = RecyclerView.m3783c(view);
            if (c != null) {
                c.m3700A();
            }
        }
    }

    class C07766 implements C0775a {
        final /* synthetic */ RecyclerView f1758a;

        C07766(RecyclerView recyclerView) {
            this.f1758a = recyclerView;
        }

        public C0801u mo627a(int i) {
            C0801u a = this.f1758a.m3820a(i, true);
            if (a == null || this.f1758a.f1868d.m4537c(a.f1823a)) {
                return null;
            }
            return a;
        }

        public void mo628a(int i, int i2) {
            this.f1758a.m3826a(i, i2, true);
            this.f1758a.f1873i = true;
            C0798r.m3666a(this.f1758a.f1872h, i2);
        }

        public void mo631b(int i, int i2) {
            this.f1758a.m3826a(i, i2, false);
            this.f1758a.f1873i = true;
        }

        public void mo629a(int i, int i2, Object obj) {
            this.f1758a.m3825a(i, i2, obj);
            this.f1758a.f1874j = true;
        }

        public void mo630a(C0865b c0865b) {
            m3540c(c0865b);
        }

        void m3540c(C0865b c0865b) {
            switch (c0865b.f2323a) {
                case 1:
                    this.f1758a.f1870f.mo605a(this.f1758a, c0865b.f2324b, c0865b.f2326d);
                    return;
                case 2:
                    this.f1758a.f1870f.mo611b(this.f1758a, c0865b.f2324b, c0865b.f2326d);
                    return;
                case 4:
                    this.f1758a.f1870f.mo607a(this.f1758a, c0865b.f2324b, c0865b.f2326d, c0865b.f2325c);
                    return;
                case 8:
                    this.f1758a.f1870f.mo606a(this.f1758a, c0865b.f2324b, c0865b.f2326d, 1);
                    return;
                default:
                    return;
            }
        }

        public void mo632b(C0865b c0865b) {
            m3540c(c0865b);
        }

        public void mo633c(int i, int i2) {
            this.f1758a.m3846f(i, i2);
            this.f1758a.f1873i = true;
        }

        public void mo634d(int i, int i2) {
            this.f1758a.m3843e(i, i2);
            this.f1758a.f1873i = true;
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C07771();
        Parcelable f1759a;

        static class C07771 implements Creator<SavedState> {
            C07771() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3542a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3543a(i);
            }

            public SavedState m3542a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m3543a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1759a = parcel.readParcelable(C0763h.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f1759a, 0);
        }

        private void m3544a(SavedState savedState) {
            this.f1759a = savedState.f1759a;
        }
    }

    public static abstract class C0778a<VH extends C0801u> {
        private final C0779b f1760a;
        private boolean f1761b;

        public abstract int m3546a();

        public abstract VH m3548a(ViewGroup viewGroup, int i);

        public abstract void m3551a(VH vh, int i);

        public void m3552a(VH vh, int i, List<Object> list) {
            m3551a((C0801u) vh, i);
        }

        public final VH m3555b(ViewGroup viewGroup, int i) {
            C0329h.m1201a("RV CreateView");
            VH a = m3548a(viewGroup, i);
            a.f1827e = i;
            C0329h.m1200a();
            return a;
        }

        public final void m3557b(VH vh, int i) {
            vh.f1824b = i;
            if (m3559b()) {
                vh.f1826d = m3554b(i);
            }
            vh.m3714a(1, 519);
            C0329h.m1201a("RV OnBindView");
            m3552a(vh, i, vh.m3741u());
            vh.m3740t();
            C0329h.m1200a();
        }

        public int m3547a(int i) {
            return 0;
        }

        public long m3554b(int i) {
            return -1;
        }

        public final boolean m3559b() {
            return this.f1761b;
        }

        public void m3550a(VH vh) {
        }

        public boolean m3560b(VH vh) {
            return false;
        }

        public void m3561c(VH vh) {
        }

        public void m3562d(VH vh) {
        }

        public void m3549a(C0780c c0780c) {
            this.f1760a.registerObserver(c0780c);
        }

        public void m3556b(C0780c c0780c) {
            this.f1760a.unregisterObserver(c0780c);
        }

        public void m3553a(RecyclerView recyclerView) {
        }

        public void m3558b(RecyclerView recyclerView) {
        }
    }

    static class C0779b extends Observable<C0780c> {
    }

    public static abstract class C0780c {
    }

    public interface C0781d {
        int m3563a(int i, int i2);
    }

    public static abstract class C0785e {
        private C0783b f1766a = null;
        private ArrayList<C0782a> f1767b = new ArrayList();
        private long f1768c = 120;
        private long f1769d = 120;
        private long f1770e = 250;
        private long f1771f = 250;

        public interface C0782a {
            void m3564a();
        }

        interface C0783b {
            void mo635a(C0801u c0801u);
        }

        public static class C0784c {
            public int f1762a;
            public int f1763b;
            public int f1764c;
            public int f1765d;

            public C0784c m3566a(C0801u c0801u) {
                return m3567a(c0801u, 0);
            }

            public C0784c m3567a(C0801u c0801u, int i) {
                View view = c0801u.f1823a;
                this.f1762a = view.getLeft();
                this.f1763b = view.getTop();
                this.f1764c = view.getRight();
                this.f1765d = view.getBottom();
                return this;
            }
        }

        public abstract void mo699a();

        public abstract boolean mo667a(C0801u c0801u, C0784c c0784c, C0784c c0784c2);

        public abstract boolean mo668a(C0801u c0801u, C0801u c0801u2, C0784c c0784c, C0784c c0784c2);

        public abstract boolean mo704b();

        public abstract boolean mo669b(C0801u c0801u, C0784c c0784c, C0784c c0784c2);

        public abstract void mo706c();

        public abstract void mo707c(C0801u c0801u);

        public abstract boolean mo670c(C0801u c0801u, C0784c c0784c, C0784c c0784c2);

        public long m3581d() {
            return this.f1770e;
        }

        public long m3582e() {
            return this.f1768c;
        }

        public long m3584f() {
            return this.f1769d;
        }

        public long m3586g() {
            return this.f1771f;
        }

        void m3572a(C0783b c0783b) {
            this.f1766a = c0783b;
        }

        public C0784c m3570a(C0798r c0798r, C0801u c0801u, int i, List<Object> list) {
            return m3589i().m3566a(c0801u);
        }

        public C0784c m3569a(C0798r c0798r, C0801u c0801u) {
            return m3589i().m3566a(c0801u);
        }

        static int m3568d(C0801u c0801u) {
            int f = c0801u.f1834l & 14;
            if (c0801u.m3734n()) {
                return 4;
            }
            if ((f & 4) != 0) {
                return f;
            }
            int f2 = c0801u.m3726f();
            int e = c0801u.m3725e();
            if (f2 == -1 || e == -1 || f2 == e) {
                return f;
            }
            return f | 2048;
        }

        public final void m3583e(C0801u c0801u) {
            m3585f(c0801u);
            if (this.f1766a != null) {
                this.f1766a.mo635a(c0801u);
            }
        }

        public void m3585f(C0801u c0801u) {
        }

        public boolean mo671g(C0801u c0801u) {
            return true;
        }

        public boolean mo703a(C0801u c0801u, List<Object> list) {
            return mo671g(c0801u);
        }

        public final void m3588h() {
            int size = this.f1767b.size();
            for (int i = 0; i < size; i++) {
                ((C0782a) this.f1767b.get(i)).m3564a();
            }
            this.f1767b.clear();
        }

        public C0784c m3589i() {
            return new C0784c();
        }
    }

    private class C0786f implements C0783b {
        final /* synthetic */ RecyclerView f1772a;

        private C0786f(RecyclerView recyclerView) {
            this.f1772a = recyclerView;
        }

        public void mo635a(C0801u c0801u) {
            c0801u.m3719a(true);
            if (c0801u.f1829g != null && c0801u.f1830h == null) {
                c0801u.f1829g = null;
            }
            c0801u.f1830h = null;
            if (!c0801u.m3701B() && !this.f1772a.m3796h(c0801u.f1823a) && c0801u.m3738r()) {
                this.f1772a.removeDetachedView(c0801u.f1823a, false);
            }
        }
    }

    public static abstract class C0787g {
        public void m3592a(Canvas canvas, RecyclerView recyclerView, C0798r c0798r) {
            m3591a(canvas, recyclerView);
        }

        @Deprecated
        public void m3591a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void m3596b(Canvas canvas, RecyclerView recyclerView, C0798r c0798r) {
            m3595b(canvas, recyclerView);
        }

        @Deprecated
        public void m3595b(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void m3593a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void m3594a(Rect rect, View view, RecyclerView recyclerView, C0798r c0798r) {
            m3593a(rect, ((C0761i) view.getLayoutParams()).m3235e(), recyclerView);
        }
    }

    public interface C0789j {
        void m3597a(View view);

        void m3598b(View view);
    }

    public interface C0790k {
        void m3599a(boolean z);

        boolean m3600a(RecyclerView recyclerView, MotionEvent motionEvent);

        void m3601b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class C0791l {
        public void m3602a(RecyclerView recyclerView, int i) {
        }

        public void m3603a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class C0792m {
        private SparseArray<ArrayList<C0801u>> f1777a = new SparseArray();
        private SparseIntArray f1778b = new SparseIntArray();
        private int f1779c = 0;

        public void m3606a() {
            this.f1777a.clear();
        }

        public C0801u m3605a(int i) {
            ArrayList arrayList = (ArrayList) this.f1777a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            C0801u c0801u = (C0801u) arrayList.get(size);
            arrayList.remove(size);
            return c0801u;
        }

        public void m3609a(C0801u c0801u) {
            int h = c0801u.m3728h();
            ArrayList b = m3604b(h);
            if (this.f1778b.get(h) > b.size()) {
                c0801u.m3742v();
                b.add(c0801u);
            }
        }

        void m3607a(C0778a c0778a) {
            this.f1779c++;
        }

        void m3610b() {
            this.f1779c--;
        }

        void m3608a(C0778a c0778a, C0778a c0778a2, boolean z) {
            if (c0778a != null) {
                m3610b();
            }
            if (!z && this.f1779c == 0) {
                m3606a();
            }
            if (c0778a2 != null) {
                m3607a(c0778a2);
            }
        }

        private ArrayList<C0801u> m3604b(int i) {
            ArrayList<C0801u> arrayList = (ArrayList) this.f1777a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f1777a.put(i, arrayList);
                if (this.f1778b.indexOfKey(i) < 0) {
                    this.f1778b.put(i, 5);
                }
            }
            return arrayList;
        }
    }

    public final class C0793n {
        final ArrayList<C0801u> f1780a = new ArrayList();
        final ArrayList<C0801u> f1781b = new ArrayList();
        final /* synthetic */ RecyclerView f1782c;
        private ArrayList<C0801u> f1783d = null;
        private final List<C0801u> f1784e = Collections.unmodifiableList(this.f1780a);
        private int f1785f = 2;
        private C0792m f1786g;
        private C0799s f1787h;

        public C0793n(RecyclerView recyclerView) {
            this.f1782c = recyclerView;
        }

        public void m3618a() {
            this.f1780a.clear();
            m3633c();
        }

        public void m3619a(int i) {
            this.f1785f = i;
            for (int size = this.f1781b.size() - 1; size >= 0 && this.f1781b.size() > i; size--) {
                m3638d(size);
            }
        }

        public List<C0801u> m3627b() {
            return this.f1784e;
        }

        boolean m3625a(C0801u c0801u) {
            if (c0801u.m3737q()) {
                return this.f1782c.f1872h.m3683a();
            }
            if (c0801u.f1824b < 0 || c0801u.f1824b >= this.f1782c.f1880s.m3546a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c0801u);
            } else if (!this.f1782c.f1872h.m3683a() && this.f1782c.f1880s.m3547a(c0801u.f1824b) != c0801u.m3728h()) {
                return false;
            } else {
                if (!this.f1782c.f1880s.m3559b() || c0801u.m3727g() == this.f1782c.f1880s.m3554b(c0801u.f1824b)) {
                    return true;
                }
                return false;
            }
        }

        public int m3626b(int i) {
            if (i >= 0 && i < this.f1782c.f1872h.m3687e()) {
                return !this.f1782c.f1872h.m3683a() ? i : this.f1782c.f1867c.m4435b(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f1782c.f1872h.m3687e());
            }
        }

        public View m3632c(int i) {
            return m3617a(i, false);
        }

        View m3617a(int i, boolean z) {
            boolean z2 = true;
            if (i < 0 || i >= this.f1782c.f1872h.m3687e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.f1782c.f1872h.m3687e());
            }
            C0801u f;
            boolean z3;
            C0801u c0801u;
            boolean z4;
            int b;
            boolean z5;
            int b2;
            LayoutParams layoutParams;
            C0761i c0761i;
            if (this.f1782c.f1872h.m3683a()) {
                f = m3644f(i);
                C0801u c0801u2 = f;
                z3 = f != null;
                c0801u = c0801u2;
            } else {
                c0801u = null;
                z3 = false;
            }
            if (c0801u == null) {
                c0801u = m3615a(i, -1, z);
                if (c0801u != null) {
                    if (m3625a(c0801u)) {
                        z4 = true;
                    } else {
                        if (!z) {
                            c0801u.m3722b(4);
                            if (c0801u.m3729i()) {
                                this.f1782c.removeDetachedView(c0801u.f1823a, false);
                                c0801u.m3730j();
                            } else if (c0801u.m3731k()) {
                                c0801u.m3732l();
                            }
                            m3630b(c0801u);
                        }
                        c0801u = null;
                        z4 = z3;
                    }
                    if (c0801u == null) {
                        b = this.f1782c.f1867c.m4435b(i);
                        if (b >= 0 || b >= this.f1782c.f1880s.m3546a()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f1782c.f1872h.m3687e());
                        }
                        int a = this.f1782c.f1880s.m3547a(b);
                        if (this.f1782c.f1880s.m3559b()) {
                            c0801u = m3616a(this.f1782c.f1880s.m3554b(b), a, z);
                            if (c0801u != null) {
                                c0801u.f1824b = b;
                                z4 = true;
                            }
                        }
                        if (c0801u == null && this.f1787h != null) {
                            View a2 = this.f1787h.m3688a(this, i, a);
                            if (a2 != null) {
                                c0801u = this.f1782c.m3821a(a2);
                                if (c0801u == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (c0801u.m3723c()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (c0801u == null) {
                            c0801u = m3643f().m3605a(a);
                            if (c0801u != null) {
                                c0801u.m3742v();
                                if (RecyclerView.f1841l) {
                                    m3614f(c0801u);
                                }
                            }
                        }
                        if (c0801u == null) {
                            f = this.f1782c.f1880s.m3555b(this.f1782c, a);
                            z5 = z4;
                            if (z5 && !this.f1782c.f1872h.m3683a() && f.m3720a(8192)) {
                                f.m3714a(0, 8192);
                                if (this.f1782c.f1872h.f1811i) {
                                    this.f1782c.m3759a(f, this.f1782c.f1871g.m3570a(this.f1782c.f1872h, f, C0785e.m3568d(f) | 4096, f.m3741u()));
                                }
                            }
                            int i2;
                            if (!this.f1782c.f1872h.m3683a() && f.m3736p()) {
                                f.f1828f = i;
                                i2 = 0;
                            } else if (f.m3736p() || f.m3735o() || f.m3734n()) {
                                b2 = this.f1782c.f1867c.m4435b(i);
                                f.f1833k = this.f1782c;
                                this.f1782c.f1880s.m3557b(f, b2);
                                m3613d(f.f1823a);
                                if (this.f1782c.f1872h.m3683a()) {
                                    f.f1828f = i;
                                }
                                z4 = true;
                            } else {
                                i2 = 0;
                            }
                            layoutParams = f.f1823a.getLayoutParams();
                            if (layoutParams != null) {
                                c0761i = (C0761i) this.f1782c.generateDefaultLayoutParams();
                                f.f1823a.setLayoutParams(c0761i);
                            } else if (this.f1782c.checkLayoutParams(layoutParams)) {
                                c0761i = (C0761i) layoutParams;
                            } else {
                                c0761i = (C0761i) this.f1782c.generateLayoutParams(layoutParams);
                                f.f1823a.setLayoutParams(c0761i);
                            }
                            c0761i.f1693a = f;
                            if (!z5 || r3 == 0) {
                                z2 = false;
                            }
                            c0761i.f1696d = z2;
                            return f.f1823a;
                        }
                    }
                    f = c0801u;
                    z5 = z4;
                    f.m3714a(0, 8192);
                    if (this.f1782c.f1872h.f1811i) {
                        this.f1782c.m3759a(f, this.f1782c.f1871g.m3570a(this.f1782c.f1872h, f, C0785e.m3568d(f) | 4096, f.m3741u()));
                    }
                    if (!this.f1782c.f1872h.m3683a()) {
                    }
                    if (f.m3736p()) {
                    }
                    b2 = this.f1782c.f1867c.m4435b(i);
                    f.f1833k = this.f1782c;
                    this.f1782c.f1880s.m3557b(f, b2);
                    m3613d(f.f1823a);
                    if (this.f1782c.f1872h.m3683a()) {
                        f.f1828f = i;
                    }
                    z4 = true;
                    layoutParams = f.f1823a.getLayoutParams();
                    if (layoutParams != null) {
                        c0761i = (C0761i) this.f1782c.generateDefaultLayoutParams();
                        f.f1823a.setLayoutParams(c0761i);
                    } else if (this.f1782c.checkLayoutParams(layoutParams)) {
                        c0761i = (C0761i) layoutParams;
                    } else {
                        c0761i = (C0761i) this.f1782c.generateLayoutParams(layoutParams);
                        f.f1823a.setLayoutParams(c0761i);
                    }
                    c0761i.f1693a = f;
                    z2 = false;
                    c0761i.f1696d = z2;
                    return f.f1823a;
                }
            }
            z4 = z3;
            if (c0801u == null) {
                b = this.f1782c.f1867c.m4435b(i);
                if (b >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f1782c.f1872h.m3687e());
            }
            f = c0801u;
            z5 = z4;
            f.m3714a(0, 8192);
            if (this.f1782c.f1872h.f1811i) {
                this.f1782c.m3759a(f, this.f1782c.f1871g.m3570a(this.f1782c.f1872h, f, C0785e.m3568d(f) | 4096, f.m3741u()));
            }
            if (!this.f1782c.f1872h.m3683a()) {
            }
            if (f.m3736p()) {
            }
            b2 = this.f1782c.f1867c.m4435b(i);
            f.f1833k = this.f1782c;
            this.f1782c.f1880s.m3557b(f, b2);
            m3613d(f.f1823a);
            if (this.f1782c.f1872h.m3683a()) {
                f.f1828f = i;
            }
            z4 = true;
            layoutParams = f.f1823a.getLayoutParams();
            if (layoutParams != null) {
                c0761i = (C0761i) this.f1782c.generateDefaultLayoutParams();
                f.f1823a.setLayoutParams(c0761i);
            } else if (this.f1782c.checkLayoutParams(layoutParams)) {
                c0761i = (C0761i) this.f1782c.generateLayoutParams(layoutParams);
                f.f1823a.setLayoutParams(c0761i);
            } else {
                c0761i = (C0761i) layoutParams;
            }
            c0761i.f1693a = f;
            z2 = false;
            c0761i.f1696d = z2;
            return f.f1823a;
        }

        private void m3613d(View view) {
            if (this.f1782c.m3853i()) {
                if (ae.m2225e(view) == 0) {
                    ae.m2222c(view, 1);
                }
                if (!ae.m2219b(view)) {
                    ae.m2210a(view, this.f1782c.ai.m4213b());
                }
            }
        }

        private void m3614f(C0801u c0801u) {
            if (c0801u.f1823a instanceof ViewGroup) {
                m3612a((ViewGroup) c0801u.f1823a, false);
            }
        }

        private void m3612a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m3612a((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public void m3624a(View view) {
            C0801u c = RecyclerView.m3783c(view);
            if (c.m3738r()) {
                this.f1782c.removeDetachedView(view, false);
            }
            if (c.m3729i()) {
                c.m3730j();
            } else if (c.m3731k()) {
                c.m3732l();
            }
            m3630b(c);
        }

        void m3633c() {
            for (int size = this.f1781b.size() - 1; size >= 0; size--) {
                m3638d(size);
            }
            this.f1781b.clear();
        }

        void m3638d(int i) {
            m3635c((C0801u) this.f1781b.get(i));
            this.f1781b.remove(i);
        }

        void m3630b(C0801u c0801u) {
            boolean z = true;
            int i = 0;
            if (c0801u.m3729i() || c0801u.f1823a.getParent() != null) {
                StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(c0801u.m3729i()).append(" isAttached:");
                if (c0801u.f1823a.getParent() == null) {
                    z = false;
                }
                throw new IllegalArgumentException(append.append(z).toString());
            } else if (c0801u.m3738r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c0801u);
            } else if (c0801u.m3723c()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                int i2;
                boolean c = c0801u.m3702C();
                boolean z2 = this.f1782c.f1880s != null && c && this.f1782c.f1880s.m3560b(c0801u);
                if (z2 || c0801u.m3743w()) {
                    if (!c0801u.m3720a(14)) {
                        int size = this.f1781b.size();
                        if (size == this.f1785f && size > 0) {
                            m3638d(0);
                        }
                        if (size < this.f1785f) {
                            this.f1781b.add(c0801u);
                            z2 = true;
                            if (z2) {
                                m3635c(c0801u);
                                i = 1;
                                i2 = z2;
                            } else {
                                z = z2;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        z = z2;
                    } else {
                        m3635c(c0801u);
                        i = 1;
                        i2 = z2;
                    }
                } else {
                    i2 = 0;
                }
                this.f1782c.f1869e.m4358g(c0801u);
                if (i2 == 0 && r1 == 0 && c) {
                    c0801u.f1833k = null;
                }
            }
        }

        void m3635c(C0801u c0801u) {
            ae.m2210a(c0801u.f1823a, null);
            m3642e(c0801u);
            c0801u.f1833k = null;
            m3643f().m3609a(c0801u);
        }

        void m3631b(View view) {
            C0801u c = RecyclerView.m3783c(view);
            c.f1836o = null;
            c.f1837p = false;
            c.m3732l();
            m3630b(c);
        }

        void m3636c(View view) {
            C0801u c = RecyclerView.m3783c(view);
            if (!c.m3720a(12) && c.m3744x() && !this.f1782c.m3787c(c)) {
                if (this.f1783d == null) {
                    this.f1783d = new ArrayList();
                }
                c.m3717a(this, true);
                this.f1783d.add(c);
            } else if (!c.m3734n() || c.m3737q() || this.f1782c.f1880s.m3559b()) {
                c.m3717a(this, false);
                this.f1780a.add(c);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        void m3639d(C0801u c0801u) {
            if (c0801u.f1837p) {
                this.f1783d.remove(c0801u);
            } else {
                this.f1780a.remove(c0801u);
            }
            c0801u.f1836o = null;
            c0801u.f1837p = false;
            c0801u.m3732l();
        }

        int m3637d() {
            return this.f1780a.size();
        }

        View m3640e(int i) {
            return ((C0801u) this.f1780a.get(i)).f1823a;
        }

        void m3641e() {
            this.f1780a.clear();
            if (this.f1783d != null) {
                this.f1783d.clear();
            }
        }

        C0801u m3644f(int i) {
            int i2 = 0;
            if (this.f1783d != null) {
                int size = this.f1783d.size();
                if (size != 0) {
                    C0801u c0801u;
                    int i3 = 0;
                    while (i3 < size) {
                        c0801u = (C0801u) this.f1783d.get(i3);
                        if (c0801u.m3731k() || c0801u.m3724d() != i) {
                            i3++;
                        } else {
                            c0801u.m3722b(32);
                            return c0801u;
                        }
                    }
                    if (this.f1782c.f1880s.m3559b()) {
                        int b = this.f1782c.f1867c.m4435b(i);
                        if (b > 0 && b < this.f1782c.f1880s.m3546a()) {
                            long b2 = this.f1782c.f1880s.m3554b(b);
                            while (i2 < size) {
                                c0801u = (C0801u) this.f1783d.get(i2);
                                if (c0801u.m3731k() || c0801u.m3727g() != b2) {
                                    i2++;
                                } else {
                                    c0801u.m3722b(32);
                                    return c0801u;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        C0801u m3615a(int i, int i2, boolean z) {
            int i3 = 0;
            int size = this.f1780a.size();
            int i4 = 0;
            while (i4 < size) {
                View a;
                C0801u c0801u = (C0801u) this.f1780a.get(i4);
                if (c0801u.m3731k() || c0801u.m3724d() != i || c0801u.m3734n() || (!this.f1782c.f1872h.f1810h && c0801u.m3737q())) {
                    i4++;
                } else if (i2 == -1 || c0801u.m3728h() == i2) {
                    c0801u.m3722b(32);
                    return c0801u;
                } else {
                    Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + c0801u.m3728h() + " but expected " + i2 + ")");
                    if (!z) {
                        a = this.f1782c.f1868d.m4525a(i, i2);
                        if (a != null) {
                            c0801u = RecyclerView.m3783c(a);
                            this.f1782c.f1868d.m4540e(a);
                            i3 = this.f1782c.f1868d.m4533b(a);
                            if (i3 != -1) {
                                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c0801u);
                            }
                            this.f1782c.f1868d.m4538d(i3);
                            m3636c(a);
                            c0801u.m3722b(8224);
                            return c0801u;
                        }
                    }
                    i4 = this.f1781b.size();
                    while (i3 < i4) {
                        c0801u = (C0801u) this.f1781b.get(i3);
                        if (c0801u.m3734n() || c0801u.m3724d() != i) {
                            i3++;
                        } else if (z) {
                            return c0801u;
                        } else {
                            this.f1781b.remove(i3);
                            return c0801u;
                        }
                    }
                    return null;
                }
            }
            if (z) {
                a = this.f1782c.f1868d.m4525a(i, i2);
                if (a != null) {
                    c0801u = RecyclerView.m3783c(a);
                    this.f1782c.f1868d.m4540e(a);
                    i3 = this.f1782c.f1868d.m4533b(a);
                    if (i3 != -1) {
                        this.f1782c.f1868d.m4538d(i3);
                        m3636c(a);
                        c0801u.m3722b(8224);
                        return c0801u;
                    }
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c0801u);
                }
            }
            i4 = this.f1781b.size();
            while (i3 < i4) {
                c0801u = (C0801u) this.f1781b.get(i3);
                if (c0801u.m3734n()) {
                }
                i3++;
            }
            return null;
        }

        C0801u m3616a(long j, int i, boolean z) {
            int size;
            for (size = this.f1780a.size() - 1; size >= 0; size--) {
                C0801u c0801u = (C0801u) this.f1780a.get(size);
                if (c0801u.m3727g() == j && !c0801u.m3731k()) {
                    if (i == c0801u.m3728h()) {
                        c0801u.m3722b(32);
                        if (!c0801u.m3737q() || this.f1782c.f1872h.m3683a()) {
                            return c0801u;
                        }
                        c0801u.m3714a(2, 14);
                        return c0801u;
                    } else if (!z) {
                        this.f1780a.remove(size);
                        this.f1782c.removeDetachedView(c0801u.f1823a, false);
                        m3631b(c0801u.f1823a);
                    }
                }
            }
            for (size = this.f1781b.size() - 1; size >= 0; size--) {
                c0801u = (C0801u) this.f1781b.get(size);
                if (c0801u.m3727g() == j) {
                    if (i == c0801u.m3728h()) {
                        if (z) {
                            return c0801u;
                        }
                        this.f1781b.remove(size);
                        return c0801u;
                    } else if (!z) {
                        m3638d(size);
                    }
                }
            }
            return null;
        }

        void m3642e(C0801u c0801u) {
            if (this.f1782c.f1881t != null) {
                this.f1782c.f1881t.m3648a(c0801u);
            }
            if (this.f1782c.f1880s != null) {
                this.f1782c.f1880s.m3550a(c0801u);
            }
            if (this.f1782c.f1872h != null) {
                this.f1782c.f1869e.m4358g(c0801u);
            }
        }

        void m3621a(C0778a c0778a, C0778a c0778a2, boolean z) {
            m3618a();
            m3643f().m3608a(c0778a, c0778a2, z);
        }

        void m3620a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f1781b.size();
            for (int i6 = 0; i6 < size; i6++) {
                C0801u c0801u = (C0801u) this.f1781b.get(i6);
                if (c0801u != null && c0801u.f1824b >= r3 && c0801u.f1824b <= r2) {
                    if (c0801u.f1824b == i) {
                        c0801u.m3716a(i2 - i, false);
                    } else {
                        c0801u.m3716a(i3, false);
                    }
                }
            }
        }

        void m3628b(int i, int i2) {
            int size = this.f1781b.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0801u c0801u = (C0801u) this.f1781b.get(i3);
                if (c0801u != null && c0801u.f1824b >= i) {
                    c0801u.m3716a(i2, true);
                }
            }
        }

        void m3629b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f1781b.size() - 1; size >= 0; size--) {
                C0801u c0801u = (C0801u) this.f1781b.get(size);
                if (c0801u != null) {
                    if (c0801u.f1824b >= i3) {
                        c0801u.m3716a(-i2, z);
                    } else if (c0801u.f1824b >= i) {
                        c0801u.m3722b(8);
                        m3638d(size);
                    }
                }
            }
        }

        void m3623a(C0799s c0799s) {
            this.f1787h = c0799s;
        }

        void m3622a(C0792m c0792m) {
            if (this.f1786g != null) {
                this.f1786g.m3610b();
            }
            this.f1786g = c0792m;
            if (c0792m != null) {
                this.f1786g.m3607a(this.f1782c.getAdapter());
            }
        }

        C0792m m3643f() {
            if (this.f1786g == null) {
                this.f1786g = new C0792m();
            }
            return this.f1786g;
        }

        void m3634c(int i, int i2) {
            int i3 = i + i2;
            for (int size = this.f1781b.size() - 1; size >= 0; size--) {
                C0801u c0801u = (C0801u) this.f1781b.get(size);
                if (c0801u != null) {
                    int d = c0801u.m3724d();
                    if (d >= i && d < i3) {
                        c0801u.m3722b(2);
                        m3638d(size);
                    }
                }
            }
        }

        void m3645g() {
            if (this.f1782c.f1880s == null || !this.f1782c.f1880s.m3559b()) {
                m3633c();
                return;
            }
            int size = this.f1781b.size();
            for (int i = 0; i < size; i++) {
                C0801u c0801u = (C0801u) this.f1781b.get(i);
                if (c0801u != null) {
                    c0801u.m3722b(6);
                    c0801u.m3718a(null);
                }
            }
        }

        void m3646h() {
            int i;
            int i2 = 0;
            int size = this.f1781b.size();
            for (i = 0; i < size; i++) {
                ((C0801u) this.f1781b.get(i)).m3713a();
            }
            size = this.f1780a.size();
            for (i = 0; i < size; i++) {
                ((C0801u) this.f1780a.get(i)).m3713a();
            }
            if (this.f1783d != null) {
                i = this.f1783d.size();
                while (i2 < i) {
                    ((C0801u) this.f1783d.get(i2)).m3713a();
                    i2++;
                }
            }
        }

        void m3647i() {
            int size = this.f1781b.size();
            for (int i = 0; i < size; i++) {
                C0761i c0761i = (C0761i) ((C0801u) this.f1781b.get(i)).f1823a.getLayoutParams();
                if (c0761i != null) {
                    c0761i.f1695c = true;
                }
            }
        }
    }

    public interface C0794o {
        void m3648a(C0801u c0801u);
    }

    private class C0795p extends C0780c {
        final /* synthetic */ RecyclerView f1788a;

        private C0795p(RecyclerView recyclerView) {
            this.f1788a = recyclerView;
        }
    }

    public static abstract class C0797q {
        private int f1796a;
        private RecyclerView f1797b;
        private C0763h f1798c;
        private boolean f1799d;
        private boolean f1800e;
        private View f1801f;
        private final C0796a f1802g;

        public static class C0796a {
            private int f1789a;
            private int f1790b;
            private int f1791c;
            private int f1792d;
            private Interpolator f1793e;
            private boolean f1794f;
            private int f1795g;

            boolean m3652a() {
                return this.f1792d >= 0;
            }

            private void m3650a(RecyclerView recyclerView) {
                if (this.f1792d >= 0) {
                    int i = this.f1792d;
                    this.f1792d = -1;
                    recyclerView.m3791e(i);
                    this.f1794f = false;
                } else if (this.f1794f) {
                    m3651b();
                    if (this.f1793e != null) {
                        recyclerView.ad.m3697a(this.f1789a, this.f1790b, this.f1791c, this.f1793e);
                    } else if (this.f1791c == Integer.MIN_VALUE) {
                        recyclerView.ad.m3699b(this.f1789a, this.f1790b);
                    } else {
                        recyclerView.ad.m3695a(this.f1789a, this.f1790b, this.f1791c);
                    }
                    this.f1795g++;
                    if (this.f1795g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1794f = false;
                } else {
                    this.f1795g = 0;
                }
            }

            private void m3651b() {
                if (this.f1793e != null && this.f1791c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f1791c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }
        }

        protected abstract void m3658a(int i, int i2, C0798r c0798r, C0796a c0796a);

        protected abstract void m3659a(View view, C0798r c0798r, C0796a c0796a);

        protected abstract void m3664e();

        public void m3657a(int i) {
            this.f1796a = i;
        }

        protected final void m3656a() {
            if (this.f1800e) {
                m3664e();
                this.f1797b.f1872h.f1804b = -1;
                this.f1801f = null;
                this.f1796a = -1;
                this.f1799d = false;
                this.f1800e = false;
                this.f1798c.m3248a(this);
                this.f1798c = null;
                this.f1797b = null;
            }
        }

        public boolean m3661b() {
            return this.f1799d;
        }

        public boolean m3662c() {
            return this.f1800e;
        }

        public int m3663d() {
            return this.f1796a;
        }

        private void m3653a(int i, int i2) {
            RecyclerView recyclerView = this.f1797b;
            if (!this.f1800e || this.f1796a == -1 || recyclerView == null) {
                m3656a();
            }
            this.f1799d = false;
            if (this.f1801f != null) {
                if (m3655a(this.f1801f) == this.f1796a) {
                    m3659a(this.f1801f, recyclerView.f1872h, this.f1802g);
                    this.f1802g.m3650a(recyclerView);
                    m3656a();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f1801f = null;
                }
            }
            if (this.f1800e) {
                m3658a(i, i2, recyclerView.f1872h, this.f1802g);
                boolean a = this.f1802g.m3652a();
                this.f1802g.m3650a(recyclerView);
                if (!a) {
                    return;
                }
                if (this.f1800e) {
                    this.f1799d = true;
                    recyclerView.ad.m3693a();
                    return;
                }
                m3656a();
            }
        }

        public int m3655a(View view) {
            return this.f1797b.m3838d(view);
        }

        protected void m3660b(View view) {
            if (m3655a(view) == m3663d()) {
                this.f1801f = view;
            }
        }
    }

    public static class C0798r {
        int f1803a = 0;
        private int f1804b = -1;
        private int f1805c = 1;
        private SparseArray<Object> f1806d;
        private int f1807e = 0;
        private int f1808f = 0;
        private boolean f1809g = false;
        private boolean f1810h = false;
        private boolean f1811i = false;
        private boolean f1812j = false;
        private boolean f1813k = false;
        private boolean f1814l = false;

        static /* synthetic */ int m3666a(C0798r c0798r, int i) {
            int i2 = c0798r.f1808f + i;
            c0798r.f1808f = i2;
            return i2;
        }

        void m3682a(int i) {
            if ((this.f1805c & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f1805c));
            }
        }

        public boolean m3683a() {
            return this.f1810h;
        }

        public boolean m3684b() {
            return this.f1812j;
        }

        public int m3685c() {
            return this.f1804b;
        }

        public boolean m3686d() {
            return this.f1804b != -1;
        }

        public int m3687e() {
            return this.f1810h ? this.f1807e - this.f1808f : this.f1803a;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1804b + ", mData=" + this.f1806d + ", mItemCount=" + this.f1803a + ", mPreviousLayoutItemCount=" + this.f1807e + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1808f + ", mStructureChanged=" + this.f1809g + ", mInPreLayout=" + this.f1810h + ", mRunSimpleAnimations=" + this.f1811i + ", mRunPredictiveAnimations=" + this.f1812j + '}';
        }
    }

    public static abstract class C0799s {
        public abstract View m3688a(C0793n c0793n, int i, int i2);
    }

    private class C0800t implements Runnable {
        final /* synthetic */ RecyclerView f1815a;
        private int f1816b;
        private int f1817c;
        private C0639p f1818d;
        private Interpolator f1819e = RecyclerView.aq;
        private boolean f1820f = false;
        private boolean f1821g = false;

        public C0800t(RecyclerView recyclerView) {
            this.f1815a = recyclerView;
            this.f1818d = C0639p.m2684a(recyclerView.getContext(), RecyclerView.aq);
        }

        public void run() {
            if (this.f1815a.f1870f == null) {
                m3698b();
                return;
            }
            m3691c();
            this.f1815a.m3812t();
            C0639p c0639p = this.f1818d;
            C0797q c0797q = this.f1815a.f1870f.f1708r;
            if (c0639p.m2696g()) {
                int e;
                int i;
                int f;
                int i2;
                Object obj;
                Object obj2;
                int b = c0639p.m2691b();
                int c = c0639p.m2692c();
                int i3 = b - this.f1816b;
                int i4 = c - this.f1817c;
                int i5 = 0;
                int i6 = 0;
                this.f1816b = b;
                this.f1817c = c;
                int i7 = 0;
                int i8 = 0;
                if (this.f1815a.f1880s != null) {
                    this.f1815a.m3832b();
                    this.f1815a.m3818z();
                    C0329h.m1201a("RV Scroll");
                    if (i3 != 0) {
                        i5 = this.f1815a.f1870f.mo574a(i3, this.f1815a.f1866b, this.f1815a.f1872h);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = this.f1815a.f1870f.mo581b(i4, this.f1815a.f1866b, this.f1815a.f1872h);
                        i8 = i4 - i6;
                    }
                    C0329h.m1200a();
                    this.f1815a.m3753I();
                    this.f1815a.m3745A();
                    this.f1815a.m3828a(false);
                    if (!(c0797q == null || c0797q.m3661b() || !c0797q.m3662c())) {
                        e = this.f1815a.f1872h.m3687e();
                        if (e == 0) {
                            c0797q.m3656a();
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else if (c0797q.m3663d() >= e) {
                            c0797q.m3657a(e - 1);
                            c0797q.m3653a(i3 - i7, i4 - i8);
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else {
                            c0797q.m3653a(i3 - i7, i4 - i8);
                        }
                        if (!this.f1815a.f1882u.isEmpty()) {
                            this.f1815a.invalidate();
                        }
                        if (ae.m2203a(this.f1815a) != 2) {
                            this.f1815a.m3797i(i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            f = (int) c0639p.m2695f();
                            if (i6 == b) {
                                e = i6 >= 0 ? -f : i6 <= 0 ? f : 0;
                                i2 = e;
                            } else {
                                i2 = 0;
                            }
                            if (i8 != c) {
                                f = 0;
                            } else if (i8 < 0) {
                                f = -f;
                            } else if (i8 <= 0) {
                                f = 0;
                            }
                            if (ae.m2203a(this.f1815a) != 2) {
                                this.f1815a.m3837c(i2, f);
                            }
                            if ((i2 != 0 || i6 == b || c0639p.m2693d() == 0) && (f != 0 || i8 == c || c0639p.m2694e() == 0)) {
                                c0639p.m2697h();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.f1815a.m3852h(i5, i7);
                        }
                        if (!this.f1815a.awakenScrollBars()) {
                            this.f1815a.invalidate();
                        }
                        obj = (i4 == 0 && this.f1815a.f1870f.mo592e() && i7 == i4) ? 1 : null;
                        obj2 = (i3 == 0 && this.f1815a.f1870f.mo590d() && i5 == i3) ? 1 : null;
                        obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                        if (!c0639p.m2689a() || obj2 == null) {
                            this.f1815a.setScrollState(0);
                        } else {
                            m3693a();
                        }
                    }
                }
                i = i7;
                i7 = i6;
                i6 = i;
                if (this.f1815a.f1882u.isEmpty()) {
                    this.f1815a.invalidate();
                }
                if (ae.m2203a(this.f1815a) != 2) {
                    this.f1815a.m3797i(i3, i4);
                }
                f = (int) c0639p.m2695f();
                if (i6 == b) {
                    i2 = 0;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    i2 = e;
                }
                if (i8 != c) {
                    f = 0;
                } else if (i8 < 0) {
                    f = -f;
                } else if (i8 <= 0) {
                    f = 0;
                }
                if (ae.m2203a(this.f1815a) != 2) {
                    this.f1815a.m3837c(i2, f);
                }
                c0639p.m2697h();
                this.f1815a.m3852h(i5, i7);
                if (this.f1815a.awakenScrollBars()) {
                    this.f1815a.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (c0639p.m2689a()) {
                }
                this.f1815a.setScrollState(0);
            }
            if (c0797q != null) {
                if (c0797q.m3661b()) {
                    c0797q.m3653a(0, 0);
                }
                if (!this.f1821g) {
                    c0797q.m3656a();
                }
            }
            m3692d();
        }

        private void m3691c() {
            this.f1821g = false;
            this.f1820f = true;
        }

        private void m3692d() {
            this.f1820f = false;
            if (this.f1821g) {
                m3693a();
            }
        }

        void m3693a() {
            if (this.f1820f) {
                this.f1821g = true;
                return;
            }
            this.f1815a.removeCallbacks(this);
            ae.m2212a(this.f1815a, (Runnable) this);
        }

        public void m3694a(int i, int i2) {
            this.f1815a.setScrollState(2);
            this.f1817c = 0;
            this.f1816b = 0;
            this.f1818d.m2687a(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            m3693a();
        }

        public void m3699b(int i, int i2) {
            m3696a(i, i2, 0, 0);
        }

        public void m3696a(int i, int i2, int i3, int i4) {
            m3695a(i, i2, m3690b(i, i2, i3, i4));
        }

        private float m3689a(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        private int m3690b(int i, int i2, int i3, int i4) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.f1815a.getWidth() : this.f1815a.getHeight();
            int i5 = width / 2;
            float a = (m3689a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
            } else {
                if (obj != null) {
                    round = abs;
                } else {
                    round = abs2;
                }
                round = (int) (((((float) round) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(round, 2000);
        }

        public void m3695a(int i, int i2, int i3) {
            m3697a(i, i2, i3, RecyclerView.aq);
        }

        public void m3697a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f1819e != interpolator) {
                this.f1819e = interpolator;
                this.f1818d = C0639p.m2684a(this.f1815a.getContext(), interpolator);
            }
            this.f1815a.setScrollState(2);
            this.f1817c = 0;
            this.f1816b = 0;
            this.f1818d.m2686a(0, 0, i, i2, i3);
            m3693a();
        }

        public void m3698b() {
            this.f1815a.removeCallbacks(this);
            this.f1818d.m2697h();
        }
    }

    public static abstract class C0801u {
        private static final List<Object> f1822m = Collections.EMPTY_LIST;
        public final View f1823a;
        int f1824b;
        int f1825c;
        long f1826d;
        int f1827e;
        int f1828f;
        C0801u f1829g;
        C0801u f1830h;
        List<Object> f1831i;
        List<Object> f1832j;
        RecyclerView f1833k;
        private int f1834l;
        private int f1835n;
        private C0793n f1836o;
        private boolean f1837p;
        private int f1838q;

        void m3715a(int i, int i2, boolean z) {
            m3722b(8);
            m3716a(i2, z);
            this.f1824b = i;
        }

        void m3716a(int i, boolean z) {
            if (this.f1825c == -1) {
                this.f1825c = this.f1824b;
            }
            if (this.f1828f == -1) {
                this.f1828f = this.f1824b;
            }
            if (z) {
                this.f1828f += i;
            }
            this.f1824b += i;
            if (this.f1823a.getLayoutParams() != null) {
                ((C0761i) this.f1823a.getLayoutParams()).f1695c = true;
            }
        }

        void m3713a() {
            this.f1825c = -1;
            this.f1828f = -1;
        }

        void m3721b() {
            if (this.f1825c == -1) {
                this.f1825c = this.f1824b;
            }
        }

        boolean m3723c() {
            return (this.f1834l & 128) != 0;
        }

        public final int m3724d() {
            return this.f1828f == -1 ? this.f1824b : this.f1828f;
        }

        public final int m3725e() {
            if (this.f1833k == null) {
                return -1;
            }
            return this.f1833k.m3789d(this);
        }

        public final int m3726f() {
            return this.f1825c;
        }

        public final long m3727g() {
            return this.f1826d;
        }

        public final int m3728h() {
            return this.f1827e;
        }

        boolean m3729i() {
            return this.f1836o != null;
        }

        void m3730j() {
            this.f1836o.m3639d(this);
        }

        boolean m3731k() {
            return (this.f1834l & 32) != 0;
        }

        void m3732l() {
            this.f1834l &= -33;
        }

        void m3733m() {
            this.f1834l &= -257;
        }

        void m3717a(C0793n c0793n, boolean z) {
            this.f1836o = c0793n;
            this.f1837p = z;
        }

        boolean m3734n() {
            return (this.f1834l & 4) != 0;
        }

        boolean m3735o() {
            return (this.f1834l & 2) != 0;
        }

        boolean m3736p() {
            return (this.f1834l & 1) != 0;
        }

        boolean m3737q() {
            return (this.f1834l & 8) != 0;
        }

        boolean m3720a(int i) {
            return (this.f1834l & i) != 0;
        }

        boolean m3738r() {
            return (this.f1834l & 256) != 0;
        }

        boolean m3739s() {
            return (this.f1834l & 512) != 0 || m3734n();
        }

        void m3714a(int i, int i2) {
            this.f1834l = (this.f1834l & (i2 ^ -1)) | (i & i2);
        }

        void m3722b(int i) {
            this.f1834l |= i;
        }

        void m3718a(Object obj) {
            if (obj == null) {
                m3722b(1024);
            } else if ((this.f1834l & 1024) == 0) {
                m3711y();
                this.f1831i.add(obj);
            }
        }

        private void m3711y() {
            if (this.f1831i == null) {
                this.f1831i = new ArrayList();
                this.f1832j = Collections.unmodifiableList(this.f1831i);
            }
        }

        void m3740t() {
            if (this.f1831i != null) {
                this.f1831i.clear();
            }
            this.f1834l &= -1025;
        }

        List<Object> m3741u() {
            if ((this.f1834l & 1024) != 0) {
                return f1822m;
            }
            if (this.f1831i == null || this.f1831i.size() == 0) {
                return f1822m;
            }
            return this.f1832j;
        }

        void m3742v() {
            this.f1834l = 0;
            this.f1824b = -1;
            this.f1825c = -1;
            this.f1826d = -1;
            this.f1828f = -1;
            this.f1835n = 0;
            this.f1829g = null;
            this.f1830h = null;
            m3740t();
            this.f1838q = 0;
        }

        private void m3712z() {
            this.f1838q = ae.m2225e(this.f1823a);
            ae.m2222c(this.f1823a, 4);
        }

        private void m3700A() {
            ae.m2222c(this.f1823a, this.f1838q);
            this.f1838q = 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f1824b + " id=" + this.f1826d + ", oldPos=" + this.f1825c + ", pLpos:" + this.f1828f);
            if (m3729i()) {
                stringBuilder.append(" scrap ").append(this.f1837p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (m3734n()) {
                stringBuilder.append(" invalid");
            }
            if (!m3736p()) {
                stringBuilder.append(" unbound");
            }
            if (m3735o()) {
                stringBuilder.append(" update");
            }
            if (m3737q()) {
                stringBuilder.append(" removed");
            }
            if (m3723c()) {
                stringBuilder.append(" ignored");
            }
            if (m3738r()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!m3743w()) {
                stringBuilder.append(" not recyclable(" + this.f1835n + ")");
            }
            if (m3739s()) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.f1823a.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public final void m3719a(boolean z) {
            this.f1835n = z ? this.f1835n - 1 : this.f1835n + 1;
            if (this.f1835n < 0) {
                this.f1835n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.f1835n == 1) {
                this.f1834l |= 16;
            } else if (z && this.f1835n == 0) {
                this.f1834l &= -17;
            }
        }

        public final boolean m3743w() {
            return (this.f1834l & 16) == 0 && !ae.m2223c(this.f1823a);
        }

        private boolean m3701B() {
            return (this.f1834l & 16) != 0;
        }

        private boolean m3702C() {
            return (this.f1834l & 16) == 0 && ae.m2223c(this.f1823a);
        }

        boolean m3744x() {
            return (this.f1834l & 2) != 0;
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        f1841l = z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        f1839a = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.f1875n = new C0795p();
        this.f1866b = new C0793n(this);
        this.f1869e = new av();
        this.f1878q = new C07681(this);
        this.f1879r = new Rect();
        this.f1882u = new ArrayList();
        this.f1883v = new ArrayList();
        this.f1843A = 0;
        this.f1852J = false;
        this.f1853K = 0;
        this.f1871g = new C0900t();
        this.f1858P = 0;
        this.f1859Q = -1;
        this.ac = Float.MIN_VALUE;
        this.ad = new C0800t(this);
        this.f1872h = new C0798r();
        this.f1873i = false;
        this.f1874j = false;
        this.ag = new C0786f();
        this.ah = false;
        this.ak = new int[2];
        this.am = new int[2];
        this.an = new int[2];
        this.ao = new int[2];
        this.ap = new C07692(this);
        this.ar = new C07724(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.f1849G = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1865W = viewConfiguration.getScaledTouchSlop();
        this.aa = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ab = viewConfiguration.getScaledMaximumFlingVelocity();
        if (ae.m2203a(this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.f1871g.m3572a(this.ag);
        m3822a();
        m3811s();
        if (ae.m2225e(this) == 0) {
            ae.m2222c((View) this, 1);
        }
        this.f1850H = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ag(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0676a.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(C0676a.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            m3757a(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1840k, i, 0);
                z2 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        }
        setNestedScrollingEnabled(z2);
    }

    public ag getCompatAccessibilityDelegate() {
        return this.ai;
    }

    public void setAccessibilityDelegateCompat(ag agVar) {
        this.ai = agVar;
        ae.m2210a((View) this, this.ai);
    }

    private void m3757a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String a = m3754a(context, trim);
                try {
                    ClassLoader classLoader;
                    Object[] objArr;
                    Constructor constructor;
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class asSubclass = classLoader.loadClass(a).asSubclass(C0763h.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(f1842m);
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C0763h) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e32222);
                }
            }
        }
    }

    private String m3754a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        return !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private void m3811s() {
        this.f1868d = new C0888r(new C07745(this));
    }

    void m3822a() {
        this.f1867c = new C0866f(new C07766(this));
    }

    public void setHasFixedSize(boolean z) {
        this.f1886y = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.f1877p) {
            m3851h();
        }
        this.f1877p = z;
        super.setClipToPadding(z);
        if (this.f1887z) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.f1865W = am.m2299a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.f1865W = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(C0778a c0778a) {
        setLayoutFrozen(false);
        m3758a(c0778a, false, true);
        requestLayout();
    }

    private void m3758a(C0778a c0778a, boolean z, boolean z2) {
        if (this.f1880s != null) {
            this.f1880s.m3556b(this.f1875n);
            this.f1880s.m3558b(this);
        }
        if (!z || z2) {
            if (this.f1871g != null) {
                this.f1871g.mo706c();
            }
            if (this.f1870f != null) {
                this.f1870f.m3321c(this.f1866b);
                this.f1870f.m3309b(this.f1866b);
            }
            this.f1866b.m3618a();
        }
        this.f1867c.m4430a();
        C0778a c0778a2 = this.f1880s;
        this.f1880s = c0778a;
        if (c0778a != null) {
            c0778a.m3549a(this.f1875n);
            c0778a.m3553a(this);
        }
        if (this.f1870f != null) {
            this.f1870f.m3273a(c0778a2, this.f1880s);
        }
        this.f1866b.m3621a(c0778a2, this.f1880s, z);
        this.f1872h.f1809g = true;
        m3859o();
    }

    public C0778a getAdapter() {
        return this.f1880s;
    }

    public void setRecyclerListener(C0794o c0794o) {
        this.f1881t = c0794o;
    }

    public int getBaseline() {
        if (this.f1870f != null) {
            return this.f1870f.m3366s();
        }
        return super.getBaseline();
    }

    public void setLayoutManager(C0763h c0763h) {
        if (c0763h != this.f1870f) {
            m3835c();
            if (this.f1870f != null) {
                if (this.f1885x) {
                    this.f1870f.m3312b(this, this.f1866b);
                }
                this.f1870f.m3310b(null);
            }
            this.f1866b.m3618a();
            this.f1868d.m4526a();
            this.f1870f = c0763h;
            if (c0763h != null) {
                if (c0763h.f1707q != null) {
                    throw new IllegalArgumentException("LayoutManager " + c0763h + " is already attached to a RecyclerView: " + c0763h.f1707q);
                }
                this.f1870f.m3310b(this);
                if (this.f1885x) {
                    this.f1870f.m3323c(this);
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f1876o != null) {
            savedState.m3544a(this.f1876o);
        } else if (this.f1870f != null) {
            savedState.f1759a = this.f1870f.mo585c();
        } else {
            savedState.f1759a = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f1876o = (SavedState) parcelable;
            super.onRestoreInstanceState(this.f1876o.getSuperState());
            if (this.f1870f != null && this.f1876o.f1759a != null) {
                this.f1870f.mo577a(this.f1876o.f1759a);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void m3774b(C0801u c0801u) {
        View view = c0801u.f1823a;
        boolean z = view.getParent() == this;
        this.f1866b.m3639d(m3821a(view));
        if (c0801u.m3738r()) {
            this.f1868d.m4529a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f1868d.m4539d(view);
        } else {
            this.f1868d.m4531a(view, true);
        }
    }

    private boolean m3796h(View view) {
        m3832b();
        boolean f = this.f1868d.m4541f(view);
        if (f) {
            C0801u c = m3783c(view);
            this.f1866b.m3639d(c);
            this.f1866b.m3630b(c);
        }
        m3828a(!f);
        return f;
    }

    public C0763h getLayoutManager() {
        return this.f1870f;
    }

    public C0792m getRecycledViewPool() {
        return this.f1866b.m3643f();
    }

    public void setRecycledViewPool(C0792m c0792m) {
        this.f1866b.m3622a(c0792m);
    }

    public void setViewCacheExtension(C0799s c0799s) {
        this.f1866b.m3623a(c0799s);
    }

    public void setItemViewCacheSize(int i) {
        this.f1866b.m3619a(i);
    }

    public int getScrollState() {
        return this.f1858P;
    }

    private void setScrollState(int i) {
        if (i != this.f1858P) {
            this.f1858P = i;
            if (i != 2) {
                m3814v();
            }
            m3840d(i);
        }
    }

    public void setChildDrawingOrderCallback(C0781d c0781d) {
        if (c0781d != this.aj) {
            this.aj = c0781d;
            setChildrenDrawingOrderEnabled(this.aj != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(C0791l c0791l) {
        this.ae = c0791l;
    }

    private void m3791e(int i) {
        if (this.f1870f != null) {
            this.f1870f.mo589d(i);
            awakenScrollBars();
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        if (this.f1870f == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f1845C) {
            boolean d = this.f1870f.mo590d();
            boolean e = this.f1870f.mo592e();
            if (d || e) {
                if (!d) {
                    i = 0;
                }
                if (!e) {
                    i2 = 0;
                }
                m3829a(i, i2, null);
            }
        }
    }

    private void m3812t() {
        if (!this.f1887z) {
            return;
        }
        if (this.f1852J) {
            C0329h.m1201a("RV FullInvalidate");
            m3855k();
            C0329h.m1200a();
        } else if (!this.f1867c.m4439d()) {
        } else {
            if (this.f1867c.m4434a(4) && !this.f1867c.m4434a(11)) {
                C0329h.m1201a("RV PartialInvalidate");
                m3832b();
                this.f1867c.m4436b();
                if (!this.f1844B) {
                    if (m3813u()) {
                        m3855k();
                    } else {
                        this.f1867c.m4438c();
                    }
                }
                m3828a(true);
                C0329h.m1200a();
            } else if (this.f1867c.m4439d()) {
                C0329h.m1201a("RV FullInvalidate");
                m3855k();
                C0329h.m1200a();
            }
        }
    }

    private boolean m3813u() {
        int b = this.f1868d.m4532b();
        for (int i = 0; i < b; i++) {
            C0801u c = m3783c(this.f1868d.m4534b(i));
            if (c != null && !c.m3723c() && c.m3744x()) {
                return true;
            }
        }
        return false;
    }

    boolean m3829a(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int i4;
        int i5;
        m3812t();
        if (this.f1880s != null) {
            int b;
            m3832b();
            m3818z();
            C0329h.m1201a("RV Scroll");
            if (i != 0) {
                a = this.f1870f.mo574a(i, this.f1866b, this.f1872h);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.f1870f.mo581b(i2, this.f1866b, this.f1872h);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            C0329h.m1200a();
            m3753I();
            m3745A();
            m3828a(false);
            i5 = i4;
            i4 = a;
            a = b;
        } else {
            a = 0;
            i4 = 0;
            i5 = 0;
            i3 = 0;
        }
        if (!this.f1882u.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, a, i3, i5, this.am)) {
            this.f1863U -= this.am[0];
            this.f1864V -= this.am[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.am[0], (float) this.am[1]);
            }
            int[] iArr = this.ao;
            iArr[0] = iArr[0] + this.am[0];
            iArr = this.ao;
            iArr[1] = iArr[1] + this.am[1];
        } else if (ae.m2203a(this) != 2) {
            if (motionEvent != null) {
                m3755a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            m3797i(i, i2);
        }
        if (!(i4 == 0 && a == 0)) {
            m3852h(i4, a);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && a == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.f1870f != null && this.f1870f.mo590d()) {
            return this.f1870f.mo582b(this.f1872h);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.f1870f != null && this.f1870f.mo590d()) {
            return this.f1870f.mo588d(this.f1872h);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.f1870f != null && this.f1870f.mo590d()) {
            return this.f1870f.mo593f(this.f1872h);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.f1870f != null && this.f1870f.mo592e()) {
            return this.f1870f.mo584c(this.f1872h);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.f1870f != null && this.f1870f.mo592e()) {
            return this.f1870f.mo591e(this.f1872h);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.f1870f != null && this.f1870f.mo592e()) {
            return this.f1870f.mo594g(this.f1872h);
        }
        return 0;
    }

    void m3832b() {
        this.f1843A++;
        if (this.f1843A == 1 && !this.f1845C) {
            this.f1844B = false;
        }
    }

    void m3828a(boolean z) {
        if (this.f1843A < 1) {
            this.f1843A = 1;
        }
        if (!z) {
            this.f1844B = false;
        }
        if (this.f1843A == 1) {
            if (!(!z || !this.f1844B || this.f1845C || this.f1870f == null || this.f1880s == null)) {
                m3855k();
            }
            if (!this.f1845C) {
                this.f1844B = false;
            }
        }
        this.f1843A--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f1845C) {
            m3827a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f1845C = true;
                this.f1846D = true;
                m3835c();
                return;
            }
            this.f1845C = false;
            if (!(!this.f1844B || this.f1870f == null || this.f1880s == null)) {
                requestLayout();
            }
            this.f1844B = false;
        }
    }

    public void m3824a(int i, int i2) {
        int i3 = 0;
        if (this.f1870f == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f1845C) {
            if (!this.f1870f.mo590d()) {
                i = 0;
            }
            if (this.f1870f.mo592e()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.ad.m3699b(i, i3);
            }
        }
    }

    public boolean m3834b(int i, int i2) {
        if (this.f1870f == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f1845C) {
            return false;
        } else {
            boolean d = this.f1870f.mo590d();
            boolean e = this.f1870f.mo592e();
            if (!d || Math.abs(i) < this.aa) {
                i = 0;
            }
            if (!e || Math.abs(i2) < this.aa) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            d = d || e;
            dispatchNestedFling((float) i, (float) i2, d);
            if (!d) {
                return false;
            }
            this.ad.m3694a(Math.max(-this.ab, Math.min(i, this.ab)), Math.max(-this.ab, Math.min(i2, this.ab)));
            return true;
        }
    }

    public void m3835c() {
        setScrollState(0);
        m3814v();
    }

    private void m3814v() {
        this.ad.m3698b();
        if (this.f1870f != null) {
            this.f1870f.m3259F();
        }
    }

    public int getMinFlingVelocity() {
        return this.aa;
    }

    public int getMaxFlingVelocity() {
        return this.ab;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3755a(float r8, float r9, float r10, float r11) {
        /*
        r7 = this;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 1;
        r5 = 0;
        r1 = 0;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0050;
    L_0x0009:
        r7.m3839d();
        r2 = r7.f1854L;
        r3 = -r9;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r4 = r6 - r4;
        r2 = r2.m2644a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r1 = r0;
    L_0x0025:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x006f;
    L_0x0029:
        r7.m3845f();
        r2 = r7.f1855M;
        r3 = -r11;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r2 = r2.m2644a(r3, r4);
        if (r2 == 0) goto L_0x008e;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x0048:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        android.support.v4.view.ae.m2224d(r7);
    L_0x004f:
        return;
    L_0x0050:
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x0025;
    L_0x0054:
        r7.m3842e();
        r2 = r7.f1856N;
        r3 = r7.getWidth();
        r3 = (float) r3;
        r3 = r9 / r3;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r2 = r2.m2644a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x006d:
        r1 = r0;
        goto L_0x0025;
    L_0x006f:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x008e;
    L_0x0073:
        r7.m3849g();
        r2 = r7.f1857O;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r3 = r11 / r3;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r4 = r6 - r4;
        r2 = r2.m2644a(r3, r4);
        if (r2 != 0) goto L_0x0042;
    L_0x008e:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void m3815w() {
        int i = 0;
        if (this.f1854L != null) {
            i = this.f1854L.m2648c();
        }
        if (this.f1855M != null) {
            i |= this.f1855M.m2648c();
        }
        if (this.f1856N != null) {
            i |= this.f1856N.m2648c();
        }
        if (this.f1857O != null) {
            i |= this.f1857O.m2648c();
        }
        if (i != 0) {
            ae.m2224d(this);
        }
    }

    private void m3797i(int i, int i2) {
        int i3 = 0;
        if (!(this.f1854L == null || this.f1854L.m2642a() || i <= 0)) {
            i3 = this.f1854L.m2648c();
        }
        if (!(this.f1856N == null || this.f1856N.m2642a() || i >= 0)) {
            i3 |= this.f1856N.m2648c();
        }
        if (!(this.f1855M == null || this.f1855M.m2642a() || i2 <= 0)) {
            i3 |= this.f1855M.m2648c();
        }
        if (!(this.f1857O == null || this.f1857O.m2642a() || i2 >= 0)) {
            i3 |= this.f1857O.m2648c();
        }
        if (i3 != 0) {
            ae.m2224d(this);
        }
    }

    void m3837c(int i, int i2) {
        if (i < 0) {
            m3839d();
            this.f1854L.m2645a(-i);
        } else if (i > 0) {
            m3842e();
            this.f1856N.m2645a(i);
        }
        if (i2 < 0) {
            m3845f();
            this.f1855M.m2645a(-i2);
        } else if (i2 > 0) {
            m3849g();
            this.f1857O.m2645a(i2);
        }
        if (i != 0 || i2 != 0) {
            ae.m2224d(this);
        }
    }

    void m3839d() {
        if (this.f1854L == null) {
            this.f1854L = new C0622d(getContext());
            if (this.f1877p) {
                this.f1854L.m2641a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f1854L.m2641a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void m3842e() {
        if (this.f1856N == null) {
            this.f1856N = new C0622d(getContext());
            if (this.f1877p) {
                this.f1856N.m2641a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f1856N.m2641a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void m3845f() {
        if (this.f1855M == null) {
            this.f1855M = new C0622d(getContext());
            if (this.f1877p) {
                this.f1855M.m2641a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f1855M.m2641a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void m3849g() {
        if (this.f1857O == null) {
            this.f1857O = new C0622d(getContext());
            if (this.f1877p) {
                this.f1857O.m2641a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f1857O.m2641a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void m3851h() {
        this.f1857O = null;
        this.f1855M = null;
        this.f1856N = null;
        this.f1854L = null;
    }

    public View focusSearch(View view, int i) {
        View d = this.f1870f.m3331d(view, i);
        if (d != null) {
            return d;
        }
        d = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(d != null || this.f1880s == null || this.f1870f == null || m3854j() || this.f1845C)) {
            m3832b();
            d = this.f1870f.mo576a(view, i, this.f1866b, this.f1872h);
            m3828a(false);
        }
        return d == null ? super.focusSearch(view, i) : d;
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.f1870f.m3298a(this, this.f1872h, view, view2) || view2 == null)) {
            Rect rect;
            boolean z;
            this.f1879r.set(0, 0, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof C0761i) {
                C0761i c0761i = (C0761i) layoutParams;
                if (!c0761i.f1695c) {
                    Rect rect2 = c0761i.f1694b;
                    rect = this.f1879r;
                    rect.left -= rect2.left;
                    rect = this.f1879r;
                    rect.right += rect2.right;
                    rect = this.f1879r;
                    rect.top -= rect2.top;
                    rect = this.f1879r;
                    rect.bottom = rect2.bottom + rect.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.f1879r);
            offsetRectIntoDescendantCoords(view, this.f1879r);
            rect = this.f1879r;
            if (this.f1887z) {
                z = false;
            } else {
                z = true;
            }
            requestChildRectangleOnScreen(view, rect, z);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f1870f.m3299a(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.f1870f == null || !this.f1870f.m3301a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1853K = 0;
        this.f1885x = true;
        this.f1887z = false;
        if (this.f1870f != null) {
            this.f1870f.m3323c(this);
        }
        this.ah = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1871g != null) {
            this.f1871g.mo706c();
        }
        this.f1887z = false;
        m3835c();
        this.f1885x = false;
        if (this.f1870f != null) {
            this.f1870f.m3312b(this, this.f1866b);
        }
        removeCallbacks(this.ap);
        this.f1869e.m4351b();
    }

    public boolean isAttachedToWindow() {
        return this.f1885x;
    }

    void m3827a(String str) {
        if (!m3854j()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    private boolean m3772a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f1884w = null;
        }
        int size = this.f1883v.size();
        int i = 0;
        while (i < size) {
            C0790k c0790k = (C0790k) this.f1883v.get(i);
            if (!c0790k.m3600a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.f1884w = c0790k;
                return true;
            }
        }
        return false;
    }

    private boolean m3782b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f1884w != null) {
            if (action == 0) {
                this.f1884w = null;
            } else {
                this.f1884w.m3601b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f1884w = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f1883v.size();
            for (int i = 0; i < size; i++) {
                C0790k c0790k = (C0790k) this.f1883v.get(i);
                if (c0790k.m3600a(this, motionEvent)) {
                    this.f1884w = c0790k;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        boolean z = true;
        if (this.f1845C) {
            return false;
        }
        if (m3772a(motionEvent)) {
            m3817y();
            return true;
        } else if (this.f1870f == null) {
            return false;
        } else {
            boolean d = this.f1870f.mo590d();
            boolean e = this.f1870f.mo592e();
            if (this.f1860R == null) {
                this.f1860R = VelocityTracker.obtain();
            }
            this.f1860R.addMovement(motionEvent);
            int a = C0601s.m2508a(motionEvent);
            int b = C0601s.m2510b(motionEvent);
            int i2;
            switch (a) {
                case 0:
                    if (this.f1846D) {
                        this.f1846D = false;
                    }
                    this.f1859Q = C0601s.m2511b(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.f1863U = i;
                    this.f1861S = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.f1864V = i;
                    this.f1862T = i;
                    if (this.f1858P == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.ao;
                    this.ao[1] = 0;
                    iArr[0] = 0;
                    if (d) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (e) {
                        i2 |= 2;
                    }
                    startNestedScroll(i2);
                    break;
                case 1:
                    this.f1860R.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    a = C0601s.m2509a(motionEvent, this.f1859Q);
                    if (a >= 0) {
                        b = (int) (C0601s.m2512c(motionEvent, a) + 0.5f);
                        a = (int) (C0601s.m2514d(motionEvent, a) + 0.5f);
                        if (this.f1858P != 1) {
                            b -= this.f1861S;
                            a -= this.f1862T;
                            if (!d || Math.abs(b) <= this.f1865W) {
                                d = false;
                            } else {
                                this.f1863U = ((b < 0 ? -1 : 1) * this.f1865W) + this.f1861S;
                                d = true;
                            }
                            if (e && Math.abs(a) > this.f1865W) {
                                i2 = this.f1862T;
                                int i3 = this.f1865W;
                                if (a >= 0) {
                                    i = 1;
                                }
                                this.f1864V = i2 + (i * i3);
                                d = true;
                            }
                            if (d) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1859Q + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    m3817y();
                    break;
                case 5:
                    this.f1859Q = C0601s.m2511b(motionEvent, b);
                    i2 = (int) (C0601s.m2512c(motionEvent, b) + 0.5f);
                    this.f1863U = i2;
                    this.f1861S = i2;
                    i2 = (int) (C0601s.m2514d(motionEvent, b) + 0.5f);
                    this.f1864V = i2;
                    this.f1862T = i2;
                    break;
                case 6:
                    m3786c(motionEvent);
                    break;
            }
            if (this.f1858P != 1) {
                z = false;
            }
            return z;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f1883v.size();
        for (int i = 0; i < size; i++) {
            ((C0790k) this.f1883v.get(i)).m3599a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f1845C || this.f1846D) {
            return false;
        }
        if (m3782b(motionEvent)) {
            m3817y();
            return true;
        } else if (this.f1870f == null) {
            return false;
        } else {
            boolean d = this.f1870f.mo590d();
            boolean e = this.f1870f.mo592e();
            if (this.f1860R == null) {
                this.f1860R = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int a = C0601s.m2508a(motionEvent);
            int b = C0601s.m2510b(motionEvent);
            if (a == 0) {
                int[] iArr = this.ao;
                this.ao[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.ao[0], (float) this.ao[1]);
            switch (a) {
                case 0:
                    this.f1859Q = C0601s.m2511b(motionEvent, 0);
                    a = (int) (motionEvent.getX() + 0.5f);
                    this.f1863U = a;
                    this.f1861S = a;
                    a = (int) (motionEvent.getY() + 0.5f);
                    this.f1864V = a;
                    this.f1862T = a;
                    if (d) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    if (e) {
                        a |= 2;
                    }
                    startNestedScroll(a);
                    break;
                case 1:
                    this.f1860R.addMovement(obtain);
                    this.f1860R.computeCurrentVelocity(1000, (float) this.ab);
                    float f = d ? -ac.m2064a(this.f1860R, this.f1859Q) : 0.0f;
                    float f2;
                    if (e) {
                        f2 = -ac.m2065b(this.f1860R, this.f1859Q);
                    } else {
                        f2 = 0.0f;
                    }
                    if ((f == 0.0f && r0 == 0.0f) || !m3834b((int) f, (int) r0)) {
                        setScrollState(0);
                    }
                    m3816x();
                    z = true;
                    break;
                case 2:
                    a = C0601s.m2509a(motionEvent, this.f1859Q);
                    if (a >= 0) {
                        int c = (int) (C0601s.m2512c(motionEvent, a) + 0.5f);
                        int d2 = (int) (C0601s.m2514d(motionEvent, a) + 0.5f);
                        int i = this.f1863U - c;
                        a = this.f1864V - d2;
                        if (dispatchNestedPreScroll(i, a, this.an, this.am)) {
                            i -= this.an[0];
                            a -= this.an[1];
                            obtain.offsetLocation((float) this.am[0], (float) this.am[1]);
                            int[] iArr2 = this.ao;
                            iArr2[0] = iArr2[0] + this.am[0];
                            iArr2 = this.ao;
                            iArr2[1] = iArr2[1] + this.am[1];
                        }
                        if (this.f1858P != 1) {
                            boolean z2;
                            if (!d || Math.abs(i) <= this.f1865W) {
                                z2 = false;
                            } else {
                                if (i > 0) {
                                    i -= this.f1865W;
                                } else {
                                    i += this.f1865W;
                                }
                                z2 = true;
                            }
                            if (e && Math.abs(a) > this.f1865W) {
                                if (a > 0) {
                                    a -= this.f1865W;
                                } else {
                                    a += this.f1865W;
                                }
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.f1858P == 1) {
                            this.f1863U = c - this.am[0];
                            this.f1864V = d2 - this.am[1];
                            if (!d) {
                                i = 0;
                            }
                            if (!e) {
                                a = 0;
                            }
                            if (m3829a(i, a, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1859Q + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    m3817y();
                    break;
                case 5:
                    this.f1859Q = C0601s.m2511b(motionEvent, b);
                    a = (int) (C0601s.m2512c(motionEvent, b) + 0.5f);
                    this.f1863U = a;
                    this.f1861S = a;
                    a = (int) (C0601s.m2514d(motionEvent, b) + 0.5f);
                    this.f1864V = a;
                    this.f1862T = a;
                    break;
                case 6:
                    m3786c(motionEvent);
                    break;
            }
            if (!z) {
                this.f1860R.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    private void m3816x() {
        if (this.f1860R != null) {
            this.f1860R.clear();
        }
        stopNestedScroll();
        m3815w();
    }

    private void m3817y() {
        m3816x();
        setScrollState(0);
    }

    private void m3786c(MotionEvent motionEvent) {
        int b = C0601s.m2510b(motionEvent);
        if (C0601s.m2511b(motionEvent, b) == this.f1859Q) {
            b = b == 0 ? 1 : 0;
            this.f1859Q = C0601s.m2511b(motionEvent, b);
            int c = (int) (C0601s.m2512c(motionEvent, b) + 0.5f);
            this.f1863U = c;
            this.f1861S = c;
            b = (int) (C0601s.m2514d(motionEvent, b) + 0.5f);
            this.f1864V = b;
            this.f1862T = b;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.f1870f == null || this.f1845C || (C0601s.m2513c(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f;
            float e;
            if (this.f1870f.mo592e()) {
                f = -C0601s.m2515e(motionEvent, 9);
            } else {
                f = 0.0f;
            }
            if (this.f1870f.mo590d()) {
                e = C0601s.m2515e(motionEvent, 10);
            } else {
                e = 0.0f;
            }
            if (!(f == 0.0f && e == 0.0f)) {
                float scrollFactor = getScrollFactor();
                m3829a((int) (e * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.ac == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.ac = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.ac;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.f1870f == null) {
            m3841d(i, i2);
        } else if (this.f1870f.f1700b) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.f1870f.m3275a(this.f1866b, this.f1872h, i, i2);
            if (!z && this.f1880s != null) {
                if (this.f1872h.f1805c == 1) {
                    m3750F();
                }
                this.f1870f.m3268a(i, i2);
                this.f1872h.f1814l = true;
                m3751G();
                this.f1870f.m3308b(i, i2);
                if (this.f1870f.mo595k()) {
                    this.f1870f.m3268a(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f1872h.f1814l = true;
                    m3751G();
                    this.f1870f.m3308b(i, i2);
                }
            }
        } else if (this.f1886y) {
            this.f1870f.m3275a(this.f1866b, this.f1872h, i, i2);
        } else {
            if (this.f1848F) {
                m3832b();
                m3749E();
                if (this.f1872h.f1812j) {
                    this.f1872h.f1810h = true;
                } else {
                    this.f1867c.m4440e();
                    this.f1872h.f1810h = false;
                }
                this.f1848F = false;
                m3828a(false);
            }
            if (this.f1880s != null) {
                this.f1872h.f1803a = this.f1880s.m3546a();
            } else {
                this.f1872h.f1803a = 0;
            }
            m3832b();
            this.f1870f.m3275a(this.f1866b, this.f1872h, i, i2);
            m3828a(false);
            this.f1872h.f1810h = false;
        }
    }

    void m3841d(int i, int i2) {
        setMeasuredDimension(C0763h.m3242a(i, getPaddingLeft() + getPaddingRight(), ae.m2233m(this)), C0763h.m3242a(i2, getPaddingTop() + getPaddingBottom(), ae.m2234n(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m3851h();
        }
    }

    public void setItemAnimator(C0785e c0785e) {
        if (this.f1871g != null) {
            this.f1871g.mo706c();
            this.f1871g.m3572a(null);
        }
        this.f1871g = c0785e;
        if (this.f1871g != null) {
            this.f1871g.m3572a(this.ag);
        }
    }

    private void m3818z() {
        this.f1853K++;
    }

    private void m3745A() {
        this.f1853K--;
        if (this.f1853K < 1) {
            this.f1853K = 0;
            m3746B();
        }
    }

    boolean m3853i() {
        return this.f1850H != null && this.f1850H.isEnabled();
    }

    private void m3746B() {
        int i = this.f1847E;
        this.f1847E = 0;
        if (i != 0 && m3853i()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            C0474a.m1858a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean m3854j() {
        return this.f1853K > 0;
    }

    boolean m3830a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!m3854j()) {
            return false;
        }
        int b;
        if (accessibilityEvent != null) {
            b = C0474a.m1859b(accessibilityEvent);
        } else {
            b = 0;
        }
        if (b != 0) {
            i = b;
        }
        this.f1847E = i | this.f1847E;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!m3830a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public C0785e getItemAnimator() {
        return this.f1871g;
    }

    private void m3747C() {
        if (!this.ah && this.f1885x) {
            ae.m2212a((View) this, this.ap);
            this.ah = true;
        }
    }

    private boolean m3748D() {
        return this.f1871g != null && this.f1870f.mo583b();
    }

    private void m3749E() {
        boolean z;
        boolean z2 = true;
        if (this.f1852J) {
            this.f1867c.m4430a();
            m3859o();
            this.f1870f.mo604a(this);
        }
        if (m3748D()) {
            this.f1867c.m4436b();
        } else {
            this.f1867c.m4440e();
        }
        boolean z3;
        if (this.f1873i || this.f1874j) {
            z3 = true;
        } else {
            z3 = false;
        }
        C0798r c0798r = this.f1872h;
        if (!this.f1887z || this.f1871g == null || (!(this.f1852J || r0 || this.f1870f.f1699a) || (this.f1852J && !this.f1880s.m3559b()))) {
            z = false;
        } else {
            z = true;
        }
        c0798r.f1811i = z;
        C0798r c0798r2 = this.f1872h;
        if (!(this.f1872h.f1811i && r0 && !this.f1852J && m3748D())) {
            z2 = false;
        }
        c0798r2.f1812j = z2;
    }

    void m3855k() {
        if (this.f1880s == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f1870f == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.f1872h.f1814l = false;
            if (this.f1872h.f1805c == 1) {
                m3750F();
                this.f1870f.m3344f(this);
                m3751G();
            } else if (!this.f1867c.m4441f() && this.f1870f.m3370w() == getWidth() && this.f1870f.m3371x() == getHeight()) {
                this.f1870f.m3344f(this);
            } else {
                this.f1870f.m3344f(this);
                m3751G();
            }
            m3752H();
        }
    }

    private void m3750F() {
        int b;
        int i;
        C0801u c;
        boolean z = true;
        this.f1872h.m3682a(1);
        this.f1872h.f1814l = false;
        m3832b();
        this.f1869e.m4345a();
        m3818z();
        m3749E();
        C0798r c0798r = this.f1872h;
        if (!(this.f1872h.f1811i && this.f1874j)) {
            z = false;
        }
        c0798r.f1813k = z;
        this.f1874j = false;
        this.f1873i = false;
        this.f1872h.f1810h = this.f1872h.f1812j;
        this.f1872h.f1803a = this.f1880s.m3546a();
        m3768a(this.ak);
        if (this.f1872h.f1811i) {
            b = this.f1868d.m4532b();
            for (i = 0; i < b; i++) {
                c = m3783c(this.f1868d.m4534b(i));
                if (!c.m3723c() && (!c.m3734n() || this.f1880s.m3559b())) {
                    this.f1869e.m4347a(c, this.f1871g.m3570a(this.f1872h, c, C0785e.m3568d(c), c.m3741u()));
                    if (!(!this.f1872h.f1813k || !c.m3744x() || c.m3737q() || c.m3723c() || c.m3734n())) {
                        this.f1869e.m4346a(m3819a(c), c);
                    }
                }
            }
        }
        if (this.f1872h.f1812j) {
            m3857m();
            z = this.f1872h.f1809g;
            this.f1872h.f1809g = false;
            this.f1870f.mo587c(this.f1866b, this.f1872h);
            this.f1872h.f1809g = z;
            for (i = 0; i < this.f1868d.m4532b(); i++) {
                c = m3783c(this.f1868d.m4534b(i));
                if (!(c.m3723c() || this.f1869e.m4355d(c))) {
                    b = C0785e.m3568d(c);
                    boolean a = c.m3720a(8192);
                    if (!a) {
                        b |= 4096;
                    }
                    C0784c a2 = this.f1871g.m3570a(this.f1872h, c, b, c.m3741u());
                    if (a) {
                        m3759a(c, a2);
                    } else {
                        this.f1869e.m4352b(c, a2);
                    }
                }
            }
            m3858n();
        } else {
            m3858n();
        }
        m3745A();
        m3828a(false);
        this.f1872h.f1805c = 2;
    }

    private void m3751G() {
        boolean z;
        m3832b();
        m3818z();
        this.f1872h.m3682a(6);
        this.f1867c.m4440e();
        this.f1872h.f1803a = this.f1880s.m3546a();
        this.f1872h.f1808f = 0;
        this.f1872h.f1810h = false;
        this.f1870f.mo587c(this.f1866b, this.f1872h);
        this.f1872h.f1809g = false;
        this.f1876o = null;
        C0798r c0798r = this.f1872h;
        if (!this.f1872h.f1811i || this.f1871g == null) {
            z = false;
        } else {
            z = true;
        }
        c0798r.f1811i = z;
        this.f1872h.f1805c = 4;
        m3745A();
        m3828a(false);
    }

    private void m3752H() {
        this.f1872h.m3682a(4);
        m3832b();
        m3818z();
        this.f1872h.f1805c = 1;
        if (this.f1872h.f1811i) {
            for (int b = this.f1868d.m4532b() - 1; b >= 0; b--) {
                C0801u c = m3783c(this.f1868d.m4534b(b));
                if (!c.m3723c()) {
                    long a = m3819a(c);
                    C0784c a2 = this.f1871g.m3569a(this.f1872h, c);
                    C0801u a3 = this.f1869e.m4344a(a);
                    if (a3 == null || a3.m3723c()) {
                        this.f1869e.m4354c(c, a2);
                    } else {
                        boolean a4 = this.f1869e.m4349a(a3);
                        boolean a5 = this.f1869e.m4349a(c);
                        if (a4 && a3 == c) {
                            this.f1869e.m4354c(c, a2);
                        } else {
                            C0784c b2 = this.f1869e.m4350b(a3);
                            this.f1869e.m4354c(c, a2);
                            C0784c c2 = this.f1869e.m4353c(c);
                            if (b2 == null) {
                                m3756a(a, c, a3);
                            } else {
                                m3761a(a3, c, b2, c2, a4, a5);
                            }
                        }
                    }
                }
            }
            this.f1869e.m4348a(this.ar);
        }
        this.f1870f.m3309b(this.f1866b);
        this.f1872h.f1807e = this.f1872h.f1803a;
        this.f1852J = false;
        this.f1872h.f1811i = false;
        this.f1872h.f1812j = false;
        this.f1870f.f1699a = false;
        if (this.f1866b.f1783d != null) {
            this.f1866b.f1783d.clear();
        }
        m3745A();
        m3828a(false);
        this.f1869e.m4345a();
        if (m3802j(this.ak[0], this.ak[1])) {
            m3852h(0, 0);
        }
    }

    private void m3756a(long j, C0801u c0801u, C0801u c0801u2) {
        int b = this.f1868d.m4532b();
        int i = 0;
        while (i < b) {
            C0801u c = m3783c(this.f1868d.m4534b(i));
            if (c == c0801u || m3819a(c) != j) {
                i++;
            } else if (this.f1880s == null || !this.f1880s.m3559b()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + c + " \n View Holder 2:" + c0801u);
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + c + " \n View Holder 2:" + c0801u);
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0801u2 + " cannot be found but it is necessary for " + c0801u);
    }

    private void m3759a(C0801u c0801u, C0784c c0784c) {
        c0801u.m3714a(0, 8192);
        if (this.f1872h.f1813k && c0801u.m3744x() && !c0801u.m3737q() && !c0801u.m3723c()) {
            this.f1869e.m4346a(m3819a(c0801u), c0801u);
        }
        this.f1869e.m4347a(c0801u, c0784c);
    }

    private void m3768a(int[] iArr) {
        int b = this.f1868d.m4532b();
        if (b == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < b) {
            int i4;
            C0801u c = m3783c(this.f1868d.m4534b(i3));
            if (c.m3723c()) {
                i4 = i;
            } else {
                i4 = c.m3724d();
                if (i4 < i) {
                    i = i4;
                }
                if (i4 > i2) {
                    i2 = i4;
                    i4 = i;
                } else {
                    i4 = i;
                }
            }
            i3++;
            i = i4;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean m3802j(int i, int i2) {
        if (this.f1868d.m4532b() != 0) {
            m3768a(this.ak);
            if (this.ak[0] == i && this.ak[1] == i2) {
                return false;
            }
            return true;
        } else if (i == 0 && i2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    protected void removeDetachedView(View view, boolean z) {
        C0801u c = m3783c(view);
        if (c != null) {
            if (c.m3738r()) {
                c.m3733m();
            } else if (!c.m3723c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + c);
            }
        }
        m3799i(view);
        super.removeDetachedView(view, z);
    }

    long m3819a(C0801u c0801u) {
        return this.f1880s.m3559b() ? c0801u.m3727g() : (long) c0801u.f1824b;
    }

    private void m3760a(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
        c0801u.m3719a(false);
        if (this.f1871g.mo669b(c0801u, c0784c, c0784c2)) {
            m3747C();
        }
    }

    private void m3775b(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
        m3774b(c0801u);
        c0801u.m3719a(false);
        if (this.f1871g.mo667a(c0801u, c0784c, c0784c2)) {
            m3747C();
        }
    }

    private void m3761a(C0801u c0801u, C0801u c0801u2, C0784c c0784c, C0784c c0784c2, boolean z, boolean z2) {
        c0801u.m3719a(false);
        if (z) {
            m3774b(c0801u);
        }
        if (c0801u != c0801u2) {
            if (z2) {
                m3774b(c0801u2);
            }
            c0801u.f1829g = c0801u2;
            m3774b(c0801u);
            this.f1866b.m3639d(c0801u);
            c0801u2.m3719a(false);
            c0801u2.f1830h = c0801u;
        }
        if (this.f1871g.mo668a(c0801u, c0801u2, c0784c, c0784c2)) {
            m3747C();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0329h.m1201a("RV OnLayout");
        m3855k();
        C0329h.m1200a();
        this.f1887z = true;
    }

    public void requestLayout() {
        if (this.f1843A != 0 || this.f1845C) {
            this.f1844B = true;
        } else {
            super.requestLayout();
        }
    }

    void m3856l() {
        int c = this.f1868d.m4535c();
        for (int i = 0; i < c; i++) {
            ((C0761i) this.f1868d.m4536c(i).getLayoutParams()).f1695c = true;
        }
        this.f1866b.m3647i();
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.f1882u.size();
        for (i = 0; i < size; i++) {
            ((C0787g) this.f1882u.get(i)).m3596b(canvas, this, this.f1872h);
        }
        if (this.f1854L == null || this.f1854L.m2642a()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.f1877p ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.f1854L == null || !this.f1854L.m2646a(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.f1855M == null || this.f1855M.m2642a())) {
            size = canvas.save();
            if (this.f1877p) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.f1855M == null || !this.f1855M.m2646a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.f1856N == null || this.f1856N.m2642a())) {
            size = canvas.save();
            int width = getWidth();
            if (this.f1877p) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.f1856N == null || !this.f1856N.m2646a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.f1857O == null || this.f1857O.m2642a())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1877p) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.f1857O != null && this.f1857O.m2646a(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.f1871g == null || this.f1882u.size() <= 0 || !this.f1871g.mo704b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            ae.m2224d(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f1882u.size();
        for (int i = 0; i < size; i++) {
            ((C0787g) this.f1882u.get(i)).m3592a(canvas, this, this.f1872h);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0761i) && this.f1870f.mo609a((C0761i) layoutParams);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.f1870f != null) {
            return this.f1870f.mo575a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f1870f != null) {
            return this.f1870f.mo597a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.f1870f != null) {
            return this.f1870f.mo598a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    void m3857m() {
        int c = this.f1868d.m4535c();
        for (int i = 0; i < c; i++) {
            C0801u c2 = m3783c(this.f1868d.m4536c(i));
            if (!c2.m3723c()) {
                c2.m3721b();
            }
        }
    }

    void m3858n() {
        int c = this.f1868d.m4535c();
        for (int i = 0; i < c; i++) {
            C0801u c2 = m3783c(this.f1868d.m4536c(i));
            if (!c2.m3723c()) {
                c2.m3713a();
            }
        }
        this.f1866b.m3646h();
    }

    void m3843e(int i, int i2) {
        int i3;
        int c = this.f1868d.m4535c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            C0801u c2 = m3783c(this.f1868d.m4536c(i6));
            if (c2 != null && c2.f1824b >= r3 && c2.f1824b <= r2) {
                if (c2.f1824b == i) {
                    c2.m3716a(i2 - i, false);
                } else {
                    c2.m3716a(i3, false);
                }
                this.f1872h.f1809g = true;
            }
        }
        this.f1866b.m3620a(i, i2);
        requestLayout();
    }

    void m3846f(int i, int i2) {
        int c = this.f1868d.m4535c();
        for (int i3 = 0; i3 < c; i3++) {
            C0801u c2 = m3783c(this.f1868d.m4536c(i3));
            if (!(c2 == null || c2.m3723c() || c2.f1824b < i)) {
                c2.m3716a(i2, false);
                this.f1872h.f1809g = true;
            }
        }
        this.f1866b.m3628b(i, i2);
        requestLayout();
    }

    void m3826a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f1868d.m4535c();
        for (int i4 = 0; i4 < c; i4++) {
            C0801u c2 = m3783c(this.f1868d.m4536c(i4));
            if (!(c2 == null || c2.m3723c())) {
                if (c2.f1824b >= i3) {
                    c2.m3716a(-i2, z);
                    this.f1872h.f1809g = true;
                } else if (c2.f1824b >= i) {
                    c2.m3715a(i - 1, -i2, z);
                    this.f1872h.f1809g = true;
                }
            }
        }
        this.f1866b.m3629b(i, i2, z);
        requestLayout();
    }

    void m3825a(int i, int i2, Object obj) {
        int c = this.f1868d.m4535c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View c2 = this.f1868d.m4536c(i4);
            C0801u c3 = m3783c(c2);
            if (c3 != null && !c3.m3723c() && c3.f1824b >= i && c3.f1824b < i3) {
                c3.m3722b(2);
                c3.m3718a(obj);
                ((C0761i) c2.getLayoutParams()).f1695c = true;
            }
        }
        this.f1866b.m3634c(i, i2);
    }

    private boolean m3787c(C0801u c0801u) {
        return this.f1871g == null || this.f1871g.mo703a(c0801u, c0801u.m3741u());
    }

    void m3859o() {
        int c = this.f1868d.m4535c();
        for (int i = 0; i < c; i++) {
            C0801u c2 = m3783c(this.f1868d.m4536c(i));
            if (!(c2 == null || c2.m3723c())) {
                c2.m3722b(6);
            }
        }
        m3856l();
        this.f1866b.m3645g();
    }

    public C0801u m3821a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return m3783c(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public View m3831b(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    static C0801u m3783c(View view) {
        if (view == null) {
            return null;
        }
        return ((C0761i) view.getLayoutParams()).f1693a;
    }

    public int m3838d(View view) {
        C0801u c = m3783c(view);
        return c != null ? c.m3724d() : -1;
    }

    C0801u m3820a(int i, boolean z) {
        int c = this.f1868d.m4535c();
        for (int i2 = 0; i2 < c; i2++) {
            C0801u c2 = m3783c(this.f1868d.m4536c(i2));
            if (!(c2 == null || c2.m3737q())) {
                if (z) {
                    if (c2.f1824b == i) {
                        return c2;
                    }
                } else if (c2.m3724d() == i) {
                    return c2;
                }
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void m3823a(int i) {
        int b = this.f1868d.m4532b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f1868d.m4534b(i2).offsetTopAndBottom(i);
        }
    }

    public void m3844e(View view) {
    }

    public void m3847f(View view) {
    }

    public void m3833b(int i) {
        int b = this.f1868d.m4532b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f1868d.m4534b(i2).offsetLeftAndRight(i);
        }
    }

    Rect m3848g(View view) {
        C0761i c0761i = (C0761i) view.getLayoutParams();
        if (!c0761i.f1695c) {
            return c0761i.f1694b;
        }
        Rect rect = c0761i.f1694b;
        rect.set(0, 0, 0, 0);
        int size = this.f1882u.size();
        for (int i = 0; i < size; i++) {
            this.f1879r.set(0, 0, 0, 0);
            ((C0787g) this.f1882u.get(i)).m3594a(this.f1879r, view, this, this.f1872h);
            rect.left += this.f1879r.left;
            rect.top += this.f1879r.top;
            rect.right += this.f1879r.right;
            rect.bottom += this.f1879r.bottom;
        }
        c0761i.f1695c = false;
        return rect;
    }

    public void m3850g(int i, int i2) {
    }

    void m3852h(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        m3850g(i, i2);
        if (this.ae != null) {
            this.ae.m3603a(this, i, i2);
        }
        if (this.af != null) {
            for (scrollY = this.af.size() - 1; scrollY >= 0; scrollY--) {
                ((C0791l) this.af.get(scrollY)).m3603a(this, i, i2);
            }
        }
    }

    public void m3836c(int i) {
    }

    void m3840d(int i) {
        if (this.f1870f != null) {
            this.f1870f.mo638k(i);
        }
        m3836c(i);
        if (this.ae != null) {
            this.ae.m3602a(this, i);
        }
        if (this.af != null) {
            for (int size = this.af.size() - 1; size >= 0; size--) {
                ((C0791l) this.af.get(size)).m3602a(this, i);
            }
        }
    }

    public boolean m3860p() {
        return !this.f1887z || this.f1852J || this.f1867c.m4439d();
    }

    private void m3753I() {
        int b = this.f1868d.m4532b();
        for (int i = 0; i < b; i++) {
            View b2 = this.f1868d.m4534b(i);
            C0801u a = m3821a(b2);
            if (!(a == null || a.f1830h == null)) {
                View view = a.f1830h.f1823a;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void m3799i(View view) {
        C0801u c = m3783c(view);
        m3847f(view);
        if (!(this.f1880s == null || c == null)) {
            this.f1880s.m3562d(c);
        }
        if (this.f1851I != null) {
            for (int size = this.f1851I.size() - 1; size >= 0; size--) {
                ((C0789j) this.f1851I.get(size)).m3598b(view);
            }
        }
    }

    private void m3801j(View view) {
        C0801u c = m3783c(view);
        m3844e(view);
        if (!(this.f1880s == null || c == null)) {
            this.f1880s.m3561c(c);
        }
        if (this.f1851I != null) {
            for (int size = this.f1851I.size() - 1; size >= 0; size--) {
                ((C0789j) this.f1851I.get(size)).m3597a(view);
            }
        }
    }

    private int m3789d(C0801u c0801u) {
        if (c0801u.m3720a(524) || !c0801u.m3736p()) {
            return -1;
        }
        return this.f1867c.m4437c(c0801u.f1824b);
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m2517a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m2518a();
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().m2521a(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().m2525c();
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m2524b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m2522a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m2523a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().m2520a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().m2519a(f, f2);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.aj == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.aj.m3563a(i, i2);
    }

    private C0604v getScrollingChildHelper() {
        if (this.al == null) {
            this.al = new C0604v(this);
        }
        return this.al;
    }
}
