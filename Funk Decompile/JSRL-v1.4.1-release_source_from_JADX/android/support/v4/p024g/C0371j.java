package android.support.v4.p024g;

/* compiled from: SparseArrayCompat */
public class C0371j<E> implements Cloneable {
    private static final Object f881a = new Object();
    private boolean f882b;
    private int[] f883c;
    private Object[] f884d;
    private int f885e;

    public /* synthetic */ Object clone() {
        return m1329a();
    }

    public C0371j() {
        this(10);
    }

    public C0371j(int i) {
        this.f882b = false;
        if (i == 0) {
            this.f883c = C0358b.f849a;
            this.f884d = C0358b.f851c;
        } else {
            int a = C0358b.m1295a(i);
            this.f883c = new int[a];
            this.f884d = new Object[a];
        }
        this.f885e = 0;
    }

    public C0371j<E> m1329a() {
        try {
            C0371j<E> c0371j = (C0371j) super.clone();
            try {
                c0371j.f883c = (int[]) this.f883c.clone();
                c0371j.f884d = (Object[]) this.f884d.clone();
                return c0371j;
            } catch (CloneNotSupportedException e) {
                return c0371j;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1330a(int i) {
        return m1331a(i, null);
    }

    public E m1331a(int i, E e) {
        int a = C0358b.m1296a(this.f883c, this.f885e, i);
        return (a < 0 || this.f884d[a] == f881a) ? e : this.f884d[a];
    }

    public void m1333b(int i) {
        int a = C0358b.m1296a(this.f883c, this.f885e, i);
        if (a >= 0 && this.f884d[a] != f881a) {
            this.f884d[a] = f881a;
            this.f882b = true;
        }
    }

    public void m1336c(int i) {
        m1333b(i);
    }

    private void m1328d() {
        int i = this.f885e;
        int[] iArr = this.f883c;
        Object[] objArr = this.f884d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f881a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f882b = false;
        this.f885e = i2;
    }

    public void m1334b(int i, E e) {
        int a = C0358b.m1296a(this.f883c, this.f885e, i);
        if (a >= 0) {
            this.f884d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f885e || this.f884d[a] != f881a) {
            if (this.f882b && this.f885e >= this.f883c.length) {
                m1328d();
                a = C0358b.m1296a(this.f883c, this.f885e, i) ^ -1;
            }
            if (this.f885e >= this.f883c.length) {
                int a2 = C0358b.m1295a(this.f885e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f883c, 0, obj, 0, this.f883c.length);
                System.arraycopy(this.f884d, 0, obj2, 0, this.f884d.length);
                this.f883c = obj;
                this.f884d = obj2;
            }
            if (this.f885e - a != 0) {
                System.arraycopy(this.f883c, a, this.f883c, a + 1, this.f885e - a);
                System.arraycopy(this.f884d, a, this.f884d, a + 1, this.f885e - a);
            }
            this.f883c[a] = i;
            this.f884d[a] = e;
            this.f885e++;
            return;
        }
        this.f883c[a] = i;
        this.f884d[a] = e;
    }

    public int m1332b() {
        if (this.f882b) {
            m1328d();
        }
        return this.f885e;
    }

    public int m1337d(int i) {
        if (this.f882b) {
            m1328d();
        }
        return this.f883c[i];
    }

    public E m1338e(int i) {
        if (this.f882b) {
            m1328d();
        }
        return this.f884d[i];
    }

    public int m1339f(int i) {
        if (this.f882b) {
            m1328d();
        }
        return C0358b.m1296a(this.f883c, this.f885e, i);
    }

    public void m1335c() {
        int i = this.f885e;
        Object[] objArr = this.f884d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f885e = 0;
        this.f882b = false;
    }

    public String toString() {
        if (m1332b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f885e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f885e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1337d(i));
            stringBuilder.append('=');
            C0371j e = m1338e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
