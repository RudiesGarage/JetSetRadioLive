package android.support.v7.widget;

import android.support.v4.p024g.C0370h.C0368a;
import android.support.v4.p024g.C0370h.C0369b;
import android.support.v7.widget.RecyclerView.C0801u;
import android.support.v7.widget.ae.C0836a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterHelper */
class C0866f implements C0836a {
    final ArrayList<C0865b> f2327a;
    final ArrayList<C0865b> f2328b;
    final C0775a f2329c;
    Runnable f2330d;
    final boolean f2331e;
    final ae f2332f;
    private C0368a<C0865b> f2333g;
    private int f2334h;

    /* compiled from: AdapterHelper */
    interface C0775a {
        C0801u mo627a(int i);

        void mo628a(int i, int i2);

        void mo629a(int i, int i2, Object obj);

        void mo630a(C0865b c0865b);

        void mo631b(int i, int i2);

        void mo632b(C0865b c0865b);

        void mo633c(int i, int i2);

        void mo634d(int i, int i2);
    }

    /* compiled from: AdapterHelper */
    static class C0865b {
        int f2323a;
        int f2324b;
        Object f2325c;
        int f2326d;

        C0865b(int i, int i2, int i3, Object obj) {
            this.f2323a = i;
            this.f2324b = i2;
            this.f2326d = i3;
            this.f2325c = obj;
        }

        String m4419a() {
            switch (this.f2323a) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 4:
                    return "up";
                case 8:
                    return "mv";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m4419a() + ",s:" + this.f2324b + "c:" + this.f2326d + ",p:" + this.f2325c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0865b c0865b = (C0865b) obj;
            if (this.f2323a != c0865b.f2323a) {
                return false;
            }
            if (this.f2323a == 8 && Math.abs(this.f2326d - this.f2324b) == 1 && this.f2326d == c0865b.f2324b && this.f2324b == c0865b.f2326d) {
                return true;
            }
            if (this.f2326d != c0865b.f2326d) {
                return false;
            }
            if (this.f2324b != c0865b.f2324b) {
                return false;
            }
            if (this.f2325c != null) {
                if (this.f2325c.equals(c0865b.f2325c)) {
                    return true;
                }
                return false;
            } else if (c0865b.f2325c != null) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            return (((this.f2323a * 31) + this.f2324b) * 31) + this.f2326d;
        }
    }

    C0866f(C0775a c0775a) {
        this(c0775a, false);
    }

    C0866f(C0775a c0775a, boolean z) {
        this.f2333g = new C0369b(30);
        this.f2327a = new ArrayList();
        this.f2328b = new ArrayList();
        this.f2334h = 0;
        this.f2329c = c0775a;
        this.f2331e = z;
        this.f2332f = new ae(this);
    }

    void m4430a() {
        m4433a(this.f2327a);
        m4433a(this.f2328b);
        this.f2334h = 0;
    }

    void m4436b() {
        this.f2332f.m4163a(this.f2327a);
        int size = this.f2327a.size();
        for (int i = 0; i < size; i++) {
            C0865b c0865b = (C0865b) this.f2327a.get(i);
            switch (c0865b.f2323a) {
                case 1:
                    m4426f(c0865b);
                    break;
                case 2:
                    m4422c(c0865b);
                    break;
                case 4:
                    m4423d(c0865b);
                    break;
                case 8:
                    m4421b(c0865b);
                    break;
            }
            if (this.f2330d != null) {
                this.f2330d.run();
            }
        }
        this.f2327a.clear();
    }

    void m4438c() {
        int size = this.f2328b.size();
        for (int i = 0; i < size; i++) {
            this.f2329c.mo632b((C0865b) this.f2328b.get(i));
        }
        m4433a(this.f2328b);
        this.f2334h = 0;
    }

    private void m4421b(C0865b c0865b) {
        m4427g(c0865b);
    }

    private void m4422c(C0865b c0865b) {
        int i = c0865b.f2324b;
        int i2 = c0865b.f2324b + c0865b.f2326d;
        Object obj = -1;
        int i3 = c0865b.f2324b;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.f2329c.mo627a(i3) != null || m4424d(i3)) {
                if (obj == null) {
                    m4425e(mo690a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    m4427g(mo690a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != c0865b.f2326d) {
            mo691a(c0865b);
            c0865b = mo690a(2, i, i4, null);
        }
        if (obj == null) {
            m4425e(c0865b);
        } else {
            m4427g(c0865b);
        }
    }

    private void m4423d(C0865b c0865b) {
        int i = c0865b.f2324b;
        int i2 = c0865b.f2324b + c0865b.f2326d;
        int i3 = c0865b.f2324b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f2329c.mo627a(i3) != null || m4424d(i3)) {
                if (obj == null) {
                    m4425e(mo690a(4, i, i4, c0865b.f2325c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m4427g(mo690a(4, i, i4, c0865b.f2325c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != c0865b.f2326d) {
            Object obj4 = c0865b.f2325c;
            mo691a(c0865b);
            c0865b = mo690a(4, i, i4, obj4);
        }
        if (obj == null) {
            m4425e(c0865b);
        } else {
            m4427g(c0865b);
        }
    }

    private void m4425e(C0865b c0865b) {
        if (c0865b.f2323a == 1 || c0865b.f2323a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int b = m4420b(c0865b.f2324b, c0865b.f2323a);
        int i2 = c0865b.f2324b;
        switch (c0865b.f2323a) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + c0865b);
        }
        int i3 = 1;
        int i4 = b;
        b = i2;
        for (i2 = 1; i2 < c0865b.f2326d; i2++) {
            Object obj;
            int b2 = m4420b(c0865b.f2324b + (i * i2), c0865b.f2323a);
            int i5;
            switch (c0865b.f2323a) {
                case 2:
                    if (b2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (b2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                C0865b a = mo690a(c0865b.f2323a, i4, i3, c0865b.f2325c);
                m4432a(a, b);
                mo691a(a);
                if (c0865b.f2323a == 4) {
                    b += i3;
                }
                i3 = 1;
                i4 = b2;
            }
        }
        Object obj2 = c0865b.f2325c;
        mo691a(c0865b);
        if (i3 > 0) {
            C0865b a2 = mo690a(c0865b.f2323a, i4, i3, obj2);
            m4432a(a2, b);
            mo691a(a2);
        }
    }

    void m4432a(C0865b c0865b, int i) {
        this.f2329c.mo630a(c0865b);
        switch (c0865b.f2323a) {
            case 2:
                this.f2329c.mo628a(i, c0865b.f2326d);
                return;
            case 4:
                this.f2329c.mo629a(i, c0865b.f2326d, c0865b.f2325c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int m4420b(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.f2328b.size() - 1; size >= 0; size--) {
            C0865b c0865b = (C0865b) this.f2328b.get(size);
            if (c0865b.f2323a == 8) {
                int i5;
                int i6;
                if (c0865b.f2324b < c0865b.f2326d) {
                    i5 = c0865b.f2324b;
                    i3 = c0865b.f2326d;
                } else {
                    i5 = c0865b.f2326d;
                    i3 = c0865b.f2324b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < c0865b.f2324b) {
                        if (i2 == 1) {
                            c0865b.f2324b++;
                            c0865b.f2326d++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            c0865b.f2324b--;
                            c0865b.f2326d--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == c0865b.f2324b) {
                    if (i2 == 1) {
                        c0865b.f2326d++;
                    } else if (i2 == 2) {
                        c0865b.f2326d--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        c0865b.f2324b++;
                    } else if (i2 == 2) {
                        c0865b.f2324b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (c0865b.f2324b <= i4) {
                if (c0865b.f2323a == 1) {
                    i4 -= c0865b.f2326d;
                } else if (c0865b.f2323a == 2) {
                    i4 += c0865b.f2326d;
                }
            } else if (i2 == 1) {
                c0865b.f2324b++;
            } else if (i2 == 2) {
                c0865b.f2324b--;
            }
        }
        for (i3 = this.f2328b.size() - 1; i3 >= 0; i3--) {
            c0865b = (C0865b) this.f2328b.get(i3);
            if (c0865b.f2323a == 8) {
                if (c0865b.f2326d == c0865b.f2324b || c0865b.f2326d < 0) {
                    this.f2328b.remove(i3);
                    mo691a(c0865b);
                }
            } else if (c0865b.f2326d <= 0) {
                this.f2328b.remove(i3);
                mo691a(c0865b);
            }
        }
        return i4;
    }

    private boolean m4424d(int i) {
        int size = this.f2328b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0865b c0865b = (C0865b) this.f2328b.get(i2);
            if (c0865b.f2323a == 8) {
                if (m4428a(c0865b.f2326d, i2 + 1) == i) {
                    return true;
                }
            } else if (c0865b.f2323a == 1) {
                int i3 = c0865b.f2324b + c0865b.f2326d;
                for (int i4 = c0865b.f2324b; i4 < i3; i4++) {
                    if (m4428a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m4426f(C0865b c0865b) {
        m4427g(c0865b);
    }

    private void m4427g(C0865b c0865b) {
        this.f2328b.add(c0865b);
        switch (c0865b.f2323a) {
            case 1:
                this.f2329c.mo633c(c0865b.f2324b, c0865b.f2326d);
                return;
            case 2:
                this.f2329c.mo631b(c0865b.f2324b, c0865b.f2326d);
                return;
            case 4:
                this.f2329c.mo629a(c0865b.f2324b, c0865b.f2326d, c0865b.f2325c);
                return;
            case 8:
                this.f2329c.mo634d(c0865b.f2324b, c0865b.f2326d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + c0865b);
        }
    }

    boolean m4439d() {
        return this.f2327a.size() > 0;
    }

    boolean m4434a(int i) {
        return (this.f2334h & i) != 0;
    }

    int m4435b(int i) {
        return m4428a(i, 0);
    }

    int m4428a(int i, int i2) {
        int size = this.f2328b.size();
        int i3 = i;
        while (i2 < size) {
            C0865b c0865b = (C0865b) this.f2328b.get(i2);
            if (c0865b.f2323a == 8) {
                if (c0865b.f2324b == i3) {
                    i3 = c0865b.f2326d;
                } else {
                    if (c0865b.f2324b < i3) {
                        i3--;
                    }
                    if (c0865b.f2326d <= i3) {
                        i3++;
                    }
                }
            } else if (c0865b.f2324b > i3) {
                continue;
            } else if (c0865b.f2323a == 2) {
                if (i3 < c0865b.f2324b + c0865b.f2326d) {
                    return -1;
                }
                i3 -= c0865b.f2326d;
            } else if (c0865b.f2323a == 1) {
                i3 += c0865b.f2326d;
            }
            i2++;
        }
        return i3;
    }

    void m4440e() {
        m4438c();
        int size = this.f2327a.size();
        for (int i = 0; i < size; i++) {
            C0865b c0865b = (C0865b) this.f2327a.get(i);
            switch (c0865b.f2323a) {
                case 1:
                    this.f2329c.mo632b(c0865b);
                    this.f2329c.mo633c(c0865b.f2324b, c0865b.f2326d);
                    break;
                case 2:
                    this.f2329c.mo632b(c0865b);
                    this.f2329c.mo628a(c0865b.f2324b, c0865b.f2326d);
                    break;
                case 4:
                    this.f2329c.mo632b(c0865b);
                    this.f2329c.mo629a(c0865b.f2324b, c0865b.f2326d, c0865b.f2325c);
                    break;
                case 8:
                    this.f2329c.mo632b(c0865b);
                    this.f2329c.mo634d(c0865b.f2324b, c0865b.f2326d);
                    break;
            }
            if (this.f2330d != null) {
                this.f2330d.run();
            }
        }
        m4433a(this.f2327a);
        this.f2334h = 0;
    }

    public int m4437c(int i) {
        int size = this.f2327a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            C0865b c0865b = (C0865b) this.f2327a.get(i3);
            switch (c0865b.f2323a) {
                case 1:
                    if (c0865b.f2324b > i2) {
                        break;
                    }
                    i2 += c0865b.f2326d;
                    break;
                case 2:
                    if (c0865b.f2324b <= i2) {
                        if (c0865b.f2324b + c0865b.f2326d <= i2) {
                            i2 -= c0865b.f2326d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (c0865b.f2324b != i2) {
                        if (c0865b.f2324b < i2) {
                            i2--;
                        }
                        if (c0865b.f2326d > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = c0865b.f2326d;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    boolean m4441f() {
        return (this.f2328b.isEmpty() || this.f2327a.isEmpty()) ? false : true;
    }

    public C0865b mo690a(int i, int i2, int i3, Object obj) {
        C0865b c0865b = (C0865b) this.f2333g.mo203a();
        if (c0865b == null) {
            return new C0865b(i, i2, i3, obj);
        }
        c0865b.f2323a = i;
        c0865b.f2324b = i2;
        c0865b.f2326d = i3;
        c0865b.f2325c = obj;
        return c0865b;
    }

    public void mo691a(C0865b c0865b) {
        if (!this.f2331e) {
            c0865b.f2325c = null;
            this.f2333g.mo204a(c0865b);
        }
    }

    void m4433a(List<C0865b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo691a((C0865b) list.get(i));
        }
        list.clear();
    }
}
