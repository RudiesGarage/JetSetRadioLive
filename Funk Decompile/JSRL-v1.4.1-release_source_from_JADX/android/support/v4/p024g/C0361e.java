package android.support.v4.p024g;

/* compiled from: LongSparseArray */
public class C0361e<E> implements Cloneable {
    private static final Object f854a = new Object();
    private boolean f855b;
    private long[] f856c;
    private Object[] f857d;
    private int f858e;

    public /* synthetic */ Object clone() {
        return m1304a();
    }

    public C0361e() {
        this(10);
    }

    public C0361e(int i) {
        this.f855b = false;
        if (i == 0) {
            this.f856c = C0358b.f850b;
            this.f857d = C0358b.f851c;
        } else {
            int b = C0358b.m1299b(i);
            this.f856c = new long[b];
            this.f857d = new Object[b];
        }
        this.f858e = 0;
    }

    public C0361e<E> m1304a() {
        try {
            C0361e<E> c0361e = (C0361e) super.clone();
            try {
                c0361e.f856c = (long[]) this.f856c.clone();
                c0361e.f857d = (Object[]) this.f857d.clone();
                return c0361e;
            } catch (CloneNotSupportedException e) {
                return c0361e;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1305a(long j) {
        return m1306a(j, null);
    }

    public E m1306a(long j, E e) {
        int a = C0358b.m1297a(this.f856c, this.f858e, j);
        return (a < 0 || this.f857d[a] == f854a) ? e : this.f857d[a];
    }

    public void m1310b(long j) {
        int a = C0358b.m1297a(this.f856c, this.f858e, j);
        if (a >= 0 && this.f857d[a] != f854a) {
            this.f857d[a] = f854a;
            this.f855b = true;
        }
    }

    public void m1307a(int i) {
        if (this.f857d[i] != f854a) {
            this.f857d[i] = f854a;
            this.f855b = true;
        }
    }

    private void m1303d() {
        int i = this.f858e;
        long[] jArr = this.f856c;
        Object[] objArr = this.f857d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f854a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f855b = false;
        this.f858e = i2;
    }

    public void m1311b(long j, E e) {
        int a = C0358b.m1297a(this.f856c, this.f858e, j);
        if (a >= 0) {
            this.f857d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f858e || this.f857d[a] != f854a) {
            if (this.f855b && this.f858e >= this.f856c.length) {
                m1303d();
                a = C0358b.m1297a(this.f856c, this.f858e, j) ^ -1;
            }
            if (this.f858e >= this.f856c.length) {
                int b = C0358b.m1299b(this.f858e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f856c, 0, obj, 0, this.f856c.length);
                System.arraycopy(this.f857d, 0, obj2, 0, this.f857d.length);
                this.f856c = obj;
                this.f857d = obj2;
            }
            if (this.f858e - a != 0) {
                System.arraycopy(this.f856c, a, this.f856c, a + 1, this.f858e - a);
                System.arraycopy(this.f857d, a, this.f857d, a + 1, this.f858e - a);
            }
            this.f856c[a] = j;
            this.f857d[a] = e;
            this.f858e++;
            return;
        }
        this.f856c[a] = j;
        this.f857d[a] = e;
    }

    public int m1308b() {
        if (this.f855b) {
            m1303d();
        }
        return this.f858e;
    }

    public long m1309b(int i) {
        if (this.f855b) {
            m1303d();
        }
        return this.f856c[i];
    }

    public E m1312c(int i) {
        if (this.f855b) {
            m1303d();
        }
        return this.f857d[i];
    }

    public void m1313c() {
        int i = this.f858e;
        Object[] objArr = this.f857d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f858e = 0;
        this.f855b = false;
    }

    public String toString() {
        if (m1308b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f858e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f858e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1309b(i));
            stringBuilder.append('=');
            C0361e c = m1312c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
