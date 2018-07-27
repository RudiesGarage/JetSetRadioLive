package android.support.v7.widget;

import android.support.v4.p024g.C0357a;
import android.support.v4.p024g.C0361e;
import android.support.v4.p024g.C0370h.C0368a;
import android.support.v4.p024g.C0370h.C0369b;
import android.support.v7.widget.RecyclerView.C0785e.C0784c;
import android.support.v7.widget.RecyclerView.C0801u;

/* compiled from: ViewInfoStore */
class av {
    final C0357a<C0801u, C0847a> f2263a = new C0357a();
    final C0361e<C0801u> f2264b = new C0361e();

    /* compiled from: ViewInfoStore */
    interface C0771b {
        void mo612a(C0801u c0801u);

        void mo613a(C0801u c0801u, C0784c c0784c, C0784c c0784c2);

        void mo614b(C0801u c0801u, C0784c c0784c, C0784c c0784c2);

        void mo615c(C0801u c0801u, C0784c c0784c, C0784c c0784c2);
    }

    /* compiled from: ViewInfoStore */
    static class C0847a {
        static C0368a<C0847a> f2259d = new C0369b(20);
        int f2260a;
        C0784c f2261b;
        C0784c f2262c;

        private C0847a() {
        }

        static C0847a m4340a() {
            C0847a c0847a = (C0847a) f2259d.mo203a();
            return c0847a == null ? new C0847a() : c0847a;
        }

        static void m4341a(C0847a c0847a) {
            c0847a.f2260a = 0;
            c0847a.f2261b = null;
            c0847a.f2262c = null;
            f2259d.mo204a(c0847a);
        }

        static void m4342b() {
            do {
            } while (f2259d.mo203a() != null);
        }
    }

    av() {
    }

    void m4345a() {
        this.f2263a.clear();
        this.f2264b.m1313c();
    }

    void m4347a(C0801u c0801u, C0784c c0784c) {
        C0847a c0847a = (C0847a) this.f2263a.get(c0801u);
        if (c0847a == null) {
            c0847a = C0847a.m4340a();
            this.f2263a.put(c0801u, c0847a);
        }
        c0847a.f2261b = c0784c;
        c0847a.f2260a |= 4;
    }

    boolean m4349a(C0801u c0801u) {
        C0847a c0847a = (C0847a) this.f2263a.get(c0801u);
        return (c0847a == null || (c0847a.f2260a & 1) == 0) ? false : true;
    }

    C0784c m4350b(C0801u c0801u) {
        return m4343a(c0801u, 4);
    }

    C0784c m4353c(C0801u c0801u) {
        return m4343a(c0801u, 8);
    }

    private C0784c m4343a(C0801u c0801u, int i) {
        C0784c c0784c = null;
        int a = this.f2263a.m1284a((Object) c0801u);
        if (a >= 0) {
            C0847a c0847a = (C0847a) this.f2263a.m1291c(a);
            if (!(c0847a == null || (c0847a.f2260a & i) == 0)) {
                c0847a.f2260a &= i ^ -1;
                if (i == 4) {
                    c0784c = c0847a.f2261b;
                } else if (i == 8) {
                    c0784c = c0847a.f2262c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((c0847a.f2260a & 12) == 0) {
                    this.f2263a.m1292d(a);
                    C0847a.m4341a(c0847a);
                }
            }
        }
        return c0784c;
    }

    void m4346a(long j, C0801u c0801u) {
        this.f2264b.m1311b(j, c0801u);
    }

    void m4352b(C0801u c0801u, C0784c c0784c) {
        C0847a c0847a = (C0847a) this.f2263a.get(c0801u);
        if (c0847a == null) {
            c0847a = C0847a.m4340a();
            this.f2263a.put(c0801u, c0847a);
        }
        c0847a.f2260a |= 2;
        c0847a.f2261b = c0784c;
    }

    boolean m4355d(C0801u c0801u) {
        C0847a c0847a = (C0847a) this.f2263a.get(c0801u);
        return (c0847a == null || (c0847a.f2260a & 4) == 0) ? false : true;
    }

    C0801u m4344a(long j) {
        return (C0801u) this.f2264b.m1305a(j);
    }

    void m4354c(C0801u c0801u, C0784c c0784c) {
        C0847a c0847a = (C0847a) this.f2263a.get(c0801u);
        if (c0847a == null) {
            c0847a = C0847a.m4340a();
            this.f2263a.put(c0801u, c0847a);
        }
        c0847a.f2262c = c0784c;
        c0847a.f2260a |= 8;
    }

    void m4356e(C0801u c0801u) {
        C0847a c0847a = (C0847a) this.f2263a.get(c0801u);
        if (c0847a == null) {
            c0847a = C0847a.m4340a();
            this.f2263a.put(c0801u, c0847a);
        }
        r0.f2260a |= 1;
    }

    void m4357f(C0801u c0801u) {
        C0847a c0847a = (C0847a) this.f2263a.get(c0801u);
        if (c0847a != null) {
            c0847a.f2260a &= -2;
        }
    }

    void m4348a(C0771b c0771b) {
        for (int size = this.f2263a.size() - 1; size >= 0; size--) {
            C0801u c0801u = (C0801u) this.f2263a.m1290b(size);
            C0847a c0847a = (C0847a) this.f2263a.m1292d(size);
            if ((c0847a.f2260a & 3) == 3) {
                c0771b.mo612a(c0801u);
            } else if ((c0847a.f2260a & 1) != 0) {
                if (c0847a.f2261b == null) {
                    c0771b.mo612a(c0801u);
                } else {
                    c0771b.mo613a(c0801u, c0847a.f2261b, c0847a.f2262c);
                }
            } else if ((c0847a.f2260a & 14) == 14) {
                c0771b.mo614b(c0801u, c0847a.f2261b, c0847a.f2262c);
            } else if ((c0847a.f2260a & 12) == 12) {
                c0771b.mo615c(c0801u, c0847a.f2261b, c0847a.f2262c);
            } else if ((c0847a.f2260a & 4) != 0) {
                c0771b.mo613a(c0801u, c0847a.f2261b, null);
            } else if ((c0847a.f2260a & 8) != 0) {
                c0771b.mo614b(c0801u, c0847a.f2261b, c0847a.f2262c);
            } else if ((c0847a.f2260a & 2) != 0) {
            }
            C0847a.m4341a(c0847a);
        }
    }

    void m4358g(C0801u c0801u) {
        for (int b = this.f2264b.m1308b() - 1; b >= 0; b--) {
            if (c0801u == this.f2264b.m1312c(b)) {
                this.f2264b.m1307a(b);
                break;
            }
        }
        C0847a c0847a = (C0847a) this.f2263a.remove(c0801u);
        if (c0847a != null) {
            C0847a.m4341a(c0847a);
        }
    }

    void m4351b() {
        C0847a.m4342b();
    }

    public void m4359h(C0801u c0801u) {
        m4357f(c0801u);
    }
}
