package android.support.v7.widget;

import android.support.v7.widget.C0866f.C0865b;
import java.util.List;

/* compiled from: OpReorderer */
class ae {
    final C0836a f2164a;

    /* compiled from: OpReorderer */
    interface C0836a {
        C0865b mo690a(int i, int i2, int i3, Object obj);

        void mo691a(C0865b c0865b);
    }

    public ae(C0836a c0836a) {
        this.f2164a = c0836a;
    }

    void m4163a(List<C0865b> list) {
        while (true) {
            int b = m4161b(list);
            if (b != -1) {
                m4160a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    private void m4160a(List<C0865b> list, int i, int i2) {
        C0865b c0865b = (C0865b) list.get(i);
        C0865b c0865b2 = (C0865b) list.get(i2);
        switch (c0865b2.f2323a) {
            case 1:
                m4162c(list, i, c0865b, i2, c0865b2);
                return;
            case 2:
                m4164a(list, i, c0865b, i2, c0865b2);
                return;
            case 4:
                m4165b(list, i, c0865b, i2, c0865b2);
                return;
            default:
                return;
        }
    }

    void m4164a(List<C0865b> list, int i, C0865b c0865b, int i2, C0865b c0865b2) {
        int i3;
        C0865b c0865b3;
        int i4 = 0;
        if (c0865b.f2324b < c0865b.f2326d) {
            i3 = (c0865b2.f2324b == c0865b.f2324b && c0865b2.f2326d == c0865b.f2326d - c0865b.f2324b) ? 1 : 0;
        } else if (c0865b2.f2324b == c0865b.f2326d + 1 && c0865b2.f2326d == c0865b.f2324b - c0865b.f2326d) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (c0865b.f2326d < c0865b2.f2324b) {
            c0865b2.f2324b--;
        } else if (c0865b.f2326d < c0865b2.f2324b + c0865b2.f2326d) {
            c0865b2.f2326d--;
            c0865b.f2323a = 2;
            c0865b.f2326d = 1;
            if (c0865b2.f2326d == 0) {
                list.remove(i2);
                this.f2164a.mo691a(c0865b2);
                return;
            }
            return;
        }
        if (c0865b.f2324b <= c0865b2.f2324b) {
            c0865b2.f2324b++;
            c0865b3 = null;
        } else if (c0865b.f2324b < c0865b2.f2324b + c0865b2.f2326d) {
            c0865b3 = this.f2164a.mo690a(2, c0865b.f2324b + 1, (c0865b2.f2324b + c0865b2.f2326d) - c0865b.f2324b, null);
            c0865b2.f2326d = c0865b.f2324b - c0865b2.f2324b;
        } else {
            c0865b3 = null;
        }
        if (i3 != 0) {
            list.set(i, c0865b2);
            list.remove(i2);
            this.f2164a.mo691a(c0865b);
            return;
        }
        if (i4 != 0) {
            if (c0865b3 != null) {
                if (c0865b.f2324b > c0865b3.f2324b) {
                    c0865b.f2324b -= c0865b3.f2326d;
                }
                if (c0865b.f2326d > c0865b3.f2324b) {
                    c0865b.f2326d -= c0865b3.f2326d;
                }
            }
            if (c0865b.f2324b > c0865b2.f2324b) {
                c0865b.f2324b -= c0865b2.f2326d;
            }
            if (c0865b.f2326d > c0865b2.f2324b) {
                c0865b.f2326d -= c0865b2.f2326d;
            }
        } else {
            if (c0865b3 != null) {
                if (c0865b.f2324b >= c0865b3.f2324b) {
                    c0865b.f2324b -= c0865b3.f2326d;
                }
                if (c0865b.f2326d >= c0865b3.f2324b) {
                    c0865b.f2326d -= c0865b3.f2326d;
                }
            }
            if (c0865b.f2324b >= c0865b2.f2324b) {
                c0865b.f2324b -= c0865b2.f2326d;
            }
            if (c0865b.f2326d >= c0865b2.f2324b) {
                c0865b.f2326d -= c0865b2.f2326d;
            }
        }
        list.set(i, c0865b2);
        if (c0865b.f2324b != c0865b.f2326d) {
            list.set(i2, c0865b);
        } else {
            list.remove(i2);
        }
        if (c0865b3 != null) {
            list.add(i, c0865b3);
        }
    }

    private void m4162c(List<C0865b> list, int i, C0865b c0865b, int i2, C0865b c0865b2) {
        int i3 = 0;
        if (c0865b.f2326d < c0865b2.f2324b) {
            i3 = -1;
        }
        if (c0865b.f2324b < c0865b2.f2324b) {
            i3++;
        }
        if (c0865b2.f2324b <= c0865b.f2324b) {
            c0865b.f2324b += c0865b2.f2326d;
        }
        if (c0865b2.f2324b <= c0865b.f2326d) {
            c0865b.f2326d += c0865b2.f2326d;
        }
        c0865b2.f2324b = i3 + c0865b2.f2324b;
        list.set(i, c0865b2);
        list.set(i2, c0865b);
    }

    void m4165b(List<C0865b> list, int i, C0865b c0865b, int i2, C0865b c0865b2) {
        Object obj;
        Object obj2 = null;
        if (c0865b.f2326d < c0865b2.f2324b) {
            c0865b2.f2324b--;
            obj = null;
        } else if (c0865b.f2326d < c0865b2.f2324b + c0865b2.f2326d) {
            c0865b2.f2326d--;
            obj = this.f2164a.mo690a(4, c0865b.f2324b, 1, c0865b2.f2325c);
        } else {
            obj = null;
        }
        if (c0865b.f2324b <= c0865b2.f2324b) {
            c0865b2.f2324b++;
        } else if (c0865b.f2324b < c0865b2.f2324b + c0865b2.f2326d) {
            int i3 = (c0865b2.f2324b + c0865b2.f2326d) - c0865b.f2324b;
            obj2 = this.f2164a.mo690a(4, c0865b.f2324b + 1, i3, c0865b2.f2325c);
            c0865b2.f2326d -= i3;
        }
        list.set(i2, c0865b);
        if (c0865b2.f2326d > 0) {
            list.set(i, c0865b2);
        } else {
            list.remove(i);
            this.f2164a.mo691a(c0865b2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }

    private int m4161b(List<C0865b> list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((C0865b) list.get(size)).f2323a != 8) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }
}
