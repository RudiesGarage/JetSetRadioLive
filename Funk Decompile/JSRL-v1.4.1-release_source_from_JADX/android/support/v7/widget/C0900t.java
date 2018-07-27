package android.support.v7.widget;

import android.support.v4.p017a.C0172a;
import android.support.v4.view.ae;
import android.support.v4.view.aq;
import android.support.v4.view.at;
import android.support.v7.widget.RecyclerView.C0801u;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator */
public class C0900t extends al {
    private ArrayList<C0801u> f2437b = new ArrayList();
    private ArrayList<C0801u> f2438c = new ArrayList();
    private ArrayList<C0899b> f2439d = new ArrayList();
    private ArrayList<C0898a> f2440e = new ArrayList();
    private ArrayList<ArrayList<C0801u>> f2441f = new ArrayList();
    private ArrayList<ArrayList<C0899b>> f2442g = new ArrayList();
    private ArrayList<ArrayList<C0898a>> f2443h = new ArrayList();
    private ArrayList<C0801u> f2444i = new ArrayList();
    private ArrayList<C0801u> f2445j = new ArrayList();
    private ArrayList<C0801u> f2446k = new ArrayList();
    private ArrayList<C0801u> f2447l = new ArrayList();

    /* compiled from: DefaultItemAnimator */
    private static class C0892c implements at {
        private C0892c() {
        }

        public void mo418a(View view) {
        }

        public void mo419b(View view) {
        }

        public void mo420c(View view) {
        }
    }

    /* compiled from: DefaultItemAnimator */
    private static class C0898a {
        public C0801u f2426a;
        public C0801u f2427b;
        public int f2428c;
        public int f2429d;
        public int f2430e;
        public int f2431f;

        private C0898a(C0801u c0801u, C0801u c0801u2) {
            this.f2426a = c0801u;
            this.f2427b = c0801u2;
        }

        private C0898a(C0801u c0801u, C0801u c0801u2, int i, int i2, int i3, int i4) {
            this(c0801u, c0801u2);
            this.f2428c = i;
            this.f2429d = i2;
            this.f2430e = i3;
            this.f2431f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2426a + ", newHolder=" + this.f2427b + ", fromX=" + this.f2428c + ", fromY=" + this.f2429d + ", toX=" + this.f2430e + ", toY=" + this.f2431f + '}';
        }
    }

    /* compiled from: DefaultItemAnimator */
    private static class C0899b {
        public C0801u f2432a;
        public int f2433b;
        public int f2434c;
        public int f2435d;
        public int f2436e;

        private C0899b(C0801u c0801u, int i, int i2, int i3, int i4) {
            this.f2432a = c0801u;
            this.f2433b = i;
            this.f2434c = i2;
            this.f2435d = i3;
            this.f2436e = i4;
        }
    }

    public void mo699a() {
        int i;
        int i2;
        int i3;
        int i4 = !this.f2437b.isEmpty() ? 1 : 0;
        if (this.f2439d.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.f2440e.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.f2438c.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            final ArrayList arrayList;
            Runnable c08891;
            Iterator it = this.f2437b.iterator();
            while (it.hasNext()) {
                m4574t((C0801u) it.next());
            }
            this.f2437b.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2439d);
                this.f2442g.add(arrayList);
                this.f2439d.clear();
                c08891 = new Runnable(this) {
                    final /* synthetic */ C0900t f2403b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C0899b c0899b = (C0899b) it.next();
                            this.f2403b.m4565b(c0899b.f2432a, c0899b.f2433b, c0899b.f2434c, c0899b.f2435d, c0899b.f2436e);
                        }
                        arrayList.clear();
                        this.f2403b.f2442g.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    ae.m2213a(((C0899b) arrayList.get(0)).f2432a.f1823a, c08891, m3584f());
                } else {
                    c08891.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2440e);
                this.f2443h.add(arrayList);
                this.f2440e.clear();
                c08891 = new Runnable(this) {
                    final /* synthetic */ C0900t f2405b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            this.f2405b.m4558a((C0898a) it.next());
                        }
                        arrayList.clear();
                        this.f2405b.f2443h.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    ae.m2213a(((C0898a) arrayList.get(0)).f2426a.f1823a, c08891, m3584f());
                } else {
                    c08891.run();
                }
            }
            if (i3 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f2438c);
                this.f2441f.add(arrayList2);
                this.f2438c.clear();
                Runnable c08913 = new Runnable(this) {
                    final /* synthetic */ C0900t f2407b;

                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            this.f2407b.m4575u((C0801u) it.next());
                        }
                        arrayList2.clear();
                        this.f2407b.f2441f.remove(arrayList2);
                    }
                };
                if (i4 == 0 && i == 0 && i2 == 0) {
                    c08913.run();
                    return;
                }
                long d;
                long g;
                long f = i4 != 0 ? m3584f() : 0;
                if (i != 0) {
                    d = m3581d();
                } else {
                    d = 0;
                }
                if (i2 != 0) {
                    g = m3586g();
                } else {
                    g = 0;
                }
                ae.m2213a(((C0801u) arrayList2.get(0)).f1823a, c08913, f + Math.max(d, g));
            }
        }
    }

    public boolean mo700a(C0801u c0801u) {
        m4576v(c0801u);
        this.f2437b.add(c0801u);
        return true;
    }

    private void m4574t(final C0801u c0801u) {
        final aq o = ae.m2235o(c0801u.f1823a);
        this.f2446k.add(c0801u);
        o.m2369a(m3584f()).m2368a(0.0f).m2370a(new C0892c(this) {
            final /* synthetic */ C0900t f2410c;

            public void mo418a(View view) {
                this.f2410c.m4250k(c0801u);
            }

            public void mo419b(View view) {
                o.m2370a(null);
                ae.m2221c(view, 1.0f);
                this.f2410c.m4247h(c0801u);
                this.f2410c.f2446k.remove(c0801u);
                this.f2410c.m4573j();
            }
        }).m2373b();
    }

    public boolean mo705b(C0801u c0801u) {
        m4576v(c0801u);
        ae.m2221c(c0801u.f1823a, 0.0f);
        this.f2438c.add(c0801u);
        return true;
    }

    private void m4575u(final C0801u c0801u) {
        final aq o = ae.m2235o(c0801u.f1823a);
        this.f2444i.add(c0801u);
        o.m2368a(1.0f).m2369a(m3582e()).m2370a(new C0892c(this) {
            final /* synthetic */ C0900t f2413c;

            public void mo418a(View view) {
                this.f2413c.m4252m(c0801u);
            }

            public void mo420c(View view) {
                ae.m2221c(view, 1.0f);
            }

            public void mo419b(View view) {
                o.m2370a(null);
                this.f2413c.m4249j(c0801u);
                this.f2413c.f2444i.remove(c0801u);
                this.f2413c.m4573j();
            }
        }).m2373b();
    }

    public boolean mo701a(C0801u c0801u, int i, int i2, int i3, int i4) {
        View view = c0801u.f1823a;
        int k = (int) (((float) i) + ae.m2231k(c0801u.f1823a));
        int l = (int) (((float) i2) + ae.m2232l(c0801u.f1823a));
        m4576v(c0801u);
        int i5 = i3 - k;
        int i6 = i4 - l;
        if (i5 == 0 && i6 == 0) {
            m4248i(c0801u);
            return false;
        }
        if (i5 != 0) {
            ae.m2205a(view, (float) (-i5));
        }
        if (i6 != 0) {
            ae.m2217b(view, (float) (-i6));
        }
        this.f2439d.add(new C0899b(c0801u, k, l, i3, i4));
        return true;
    }

    private void m4565b(C0801u c0801u, int i, int i2, int i3, int i4) {
        View view = c0801u.f1823a;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            ae.m2235o(view).m2372b(0.0f);
        }
        if (i6 != 0) {
            ae.m2235o(view).m2374c(0.0f);
        }
        final aq o = ae.m2235o(view);
        this.f2445j.add(c0801u);
        final C0801u c0801u2 = c0801u;
        o.m2369a(m3581d()).m2370a(new C0892c(this) {
            final /* synthetic */ C0900t f2418e;

            public void mo418a(View view) {
                this.f2418e.m4251l(c0801u2);
            }

            public void mo420c(View view) {
                if (i5 != 0) {
                    ae.m2205a(view, 0.0f);
                }
                if (i6 != 0) {
                    ae.m2217b(view, 0.0f);
                }
            }

            public void mo419b(View view) {
                o.m2370a(null);
                this.f2418e.m4248i(c0801u2);
                this.f2418e.f2445j.remove(c0801u2);
                this.f2418e.m4573j();
            }
        }).m2373b();
    }

    public boolean mo702a(C0801u c0801u, C0801u c0801u2, int i, int i2, int i3, int i4) {
        if (c0801u == c0801u2) {
            return mo701a(c0801u, i, i2, i3, i4);
        }
        float k = ae.m2231k(c0801u.f1823a);
        float l = ae.m2232l(c0801u.f1823a);
        float f = ae.m2226f(c0801u.f1823a);
        m4576v(c0801u);
        int i5 = (int) (((float) (i3 - i)) - k);
        int i6 = (int) (((float) (i4 - i2)) - l);
        ae.m2205a(c0801u.f1823a, k);
        ae.m2217b(c0801u.f1823a, l);
        ae.m2221c(c0801u.f1823a, f);
        if (c0801u2 != null) {
            m4576v(c0801u2);
            ae.m2205a(c0801u2.f1823a, (float) (-i5));
            ae.m2217b(c0801u2.f1823a, (float) (-i6));
            ae.m2221c(c0801u2.f1823a, 0.0f);
        }
        this.f2440e.add(new C0898a(c0801u, c0801u2, i, i2, i3, i4));
        return true;
    }

    private void m4558a(final C0898a c0898a) {
        View view = null;
        C0801u c0801u = c0898a.f2426a;
        View view2 = c0801u == null ? null : c0801u.f1823a;
        C0801u c0801u2 = c0898a.f2427b;
        if (c0801u2 != null) {
            view = c0801u2.f1823a;
        }
        if (view2 != null) {
            final aq a = ae.m2235o(view2).m2369a(m3586g());
            this.f2447l.add(c0898a.f2426a);
            a.m2372b((float) (c0898a.f2430e - c0898a.f2428c));
            a.m2374c((float) (c0898a.f2431f - c0898a.f2429d));
            a.m2368a(0.0f).m2370a(new C0892c(this) {
                final /* synthetic */ C0900t f2421c;

                public void mo418a(View view) {
                    this.f2421c.m4240b(c0898a.f2426a, true);
                }

                public void mo419b(View view) {
                    a.m2370a(null);
                    ae.m2221c(view, 1.0f);
                    ae.m2205a(view, 0.0f);
                    ae.m2217b(view, 0.0f);
                    this.f2421c.m4234a(c0898a.f2426a, true);
                    this.f2421c.f2447l.remove(c0898a.f2426a);
                    this.f2421c.m4573j();
                }
            }).m2373b();
        }
        if (view != null) {
            a = ae.m2235o(view);
            this.f2447l.add(c0898a.f2427b);
            a.m2372b(0.0f).m2374c(0.0f).m2369a(m3586g()).m2368a(1.0f).m2370a(new C0892c(this) {
                final /* synthetic */ C0900t f2425d;

                public void mo418a(View view) {
                    this.f2425d.m4240b(c0898a.f2427b, false);
                }

                public void mo419b(View view) {
                    a.m2370a(null);
                    ae.m2221c(view, 1.0f);
                    ae.m2205a(view, 0.0f);
                    ae.m2217b(view, 0.0f);
                    this.f2425d.m4234a(c0898a.f2427b, false);
                    this.f2425d.f2447l.remove(c0898a.f2427b);
                    this.f2425d.m4573j();
                }
            }).m2373b();
        }
    }

    private void m4562a(List<C0898a> list, C0801u c0801u) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0898a c0898a = (C0898a) list.get(size);
            if (m4563a(c0898a, c0801u) && c0898a.f2426a == null && c0898a.f2427b == null) {
                list.remove(c0898a);
            }
        }
    }

    private void m4566b(C0898a c0898a) {
        if (c0898a.f2426a != null) {
            m4563a(c0898a, c0898a.f2426a);
        }
        if (c0898a.f2427b != null) {
            m4563a(c0898a, c0898a.f2427b);
        }
    }

    private boolean m4563a(C0898a c0898a, C0801u c0801u) {
        boolean z = false;
        if (c0898a.f2427b == c0801u) {
            c0898a.f2427b = null;
        } else if (c0898a.f2426a != c0801u) {
            return false;
        } else {
            c0898a.f2426a = null;
            z = true;
        }
        ae.m2221c(c0801u.f1823a, 1.0f);
        ae.m2205a(c0801u.f1823a, 0.0f);
        ae.m2217b(c0801u.f1823a, 0.0f);
        m4234a(c0801u, z);
        return true;
    }

    public void mo707c(C0801u c0801u) {
        int size;
        View view = c0801u.f1823a;
        ae.m2235o(view).m2371a();
        for (size = this.f2439d.size() - 1; size >= 0; size--) {
            if (((C0899b) this.f2439d.get(size)).f2432a == c0801u) {
                ae.m2217b(view, 0.0f);
                ae.m2205a(view, 0.0f);
                m4248i(c0801u);
                this.f2439d.remove(size);
            }
        }
        m4562a(this.f2440e, c0801u);
        if (this.f2437b.remove(c0801u)) {
            ae.m2221c(view, 1.0f);
            m4247h(c0801u);
        }
        if (this.f2438c.remove(c0801u)) {
            ae.m2221c(view, 1.0f);
            m4249j(c0801u);
        }
        for (size = this.f2443h.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f2443h.get(size);
            m4562a(list, c0801u);
            if (list.isEmpty()) {
                this.f2443h.remove(size);
            }
        }
        for (int size2 = this.f2442g.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f2442g.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C0899b) arrayList.get(size3)).f2432a == c0801u) {
                    ae.m2217b(view, 0.0f);
                    ae.m2205a(view, 0.0f);
                    m4248i(c0801u);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2442g.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f2441f.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f2441f.get(size);
            if (arrayList.remove(c0801u)) {
                ae.m2221c(view, 1.0f);
                m4249j(c0801u);
                if (arrayList.isEmpty()) {
                    this.f2441f.remove(size);
                }
            }
        }
        if (this.f2446k.remove(c0801u)) {
        }
        if (this.f2444i.remove(c0801u)) {
        }
        if (this.f2447l.remove(c0801u)) {
        }
        if (this.f2445j.remove(c0801u)) {
            m4573j();
        } else {
            m4573j();
        }
    }

    private void m4576v(C0801u c0801u) {
        C0172a.m594a(c0801u.f1823a);
        mo707c(c0801u);
    }

    public boolean mo704b() {
        return (this.f2438c.isEmpty() && this.f2440e.isEmpty() && this.f2439d.isEmpty() && this.f2437b.isEmpty() && this.f2445j.isEmpty() && this.f2446k.isEmpty() && this.f2444i.isEmpty() && this.f2447l.isEmpty() && this.f2442g.isEmpty() && this.f2441f.isEmpty() && this.f2443h.isEmpty()) ? false : true;
    }

    private void m4573j() {
        if (!mo704b()) {
            m3588h();
        }
    }

    public void mo706c() {
        int size;
        for (size = this.f2439d.size() - 1; size >= 0; size--) {
            C0899b c0899b = (C0899b) this.f2439d.get(size);
            View view = c0899b.f2432a.f1823a;
            ae.m2217b(view, 0.0f);
            ae.m2205a(view, 0.0f);
            m4248i(c0899b.f2432a);
            this.f2439d.remove(size);
        }
        for (size = this.f2437b.size() - 1; size >= 0; size--) {
            m4247h((C0801u) this.f2437b.get(size));
            this.f2437b.remove(size);
        }
        for (size = this.f2438c.size() - 1; size >= 0; size--) {
            C0801u c0801u = (C0801u) this.f2438c.get(size);
            ae.m2221c(c0801u.f1823a, 1.0f);
            m4249j(c0801u);
            this.f2438c.remove(size);
        }
        for (size = this.f2440e.size() - 1; size >= 0; size--) {
            m4566b((C0898a) this.f2440e.get(size));
        }
        this.f2440e.clear();
        if (mo704b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.f2442g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2442g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0899b c0899b2 = (C0899b) arrayList.get(size3);
                    View view2 = c0899b2.f2432a.f1823a;
                    ae.m2217b(view2, 0.0f);
                    ae.m2205a(view2, 0.0f);
                    m4248i(c0899b2.f2432a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2442g.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2441f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2441f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0801u c0801u2 = (C0801u) arrayList.get(size3);
                    ae.m2221c(c0801u2.f1823a, 1.0f);
                    m4249j(c0801u2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2441f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2443h.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2443h.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m4566b((C0898a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.f2443h.remove(arrayList);
                    }
                }
            }
            m4578a(this.f2446k);
            m4578a(this.f2445j);
            m4578a(this.f2444i);
            m4578a(this.f2447l);
            m3588h();
        }
    }

    void m4578a(List<C0801u> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ae.m2235o(((C0801u) list.get(size)).f1823a).m2371a();
        }
    }

    public boolean mo703a(C0801u c0801u, List<Object> list) {
        return !list.isEmpty() || super.mo703a(c0801u, (List) list);
    }
}
