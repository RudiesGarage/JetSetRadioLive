package android.support.v4.p024g;

import java.util.Map;

/* compiled from: SimpleArrayMap */
public class C0356i<K, V> {
    static Object[] f841b;
    static int f842c;
    static Object[] f843d;
    static int f844e;
    int[] f845f;
    Object[] f846g;
    int f847h;

    int m1285a(Object obj, int i) {
        int i2 = this.f847h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0358b.m1296a(this.f845f, i2, i);
        if (a < 0 || obj.equals(this.f846g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f845f[i3] == i) {
            if (obj.equals(this.f846g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f845f[a] == i) {
            if (obj.equals(this.f846g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    int m1283a() {
        int i = this.f847h;
        if (i == 0) {
            return -1;
        }
        int a = C0358b.m1296a(this.f845f, i, 0);
        if (a < 0 || this.f846g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f845f[i2] == 0) {
            if (this.f846g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f845f[a] == 0) {
            if (this.f846g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void m1282e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0357a.class) {
                if (f843d != null) {
                    objArr = f843d;
                    this.f846g = objArr;
                    f843d = (Object[]) objArr[0];
                    this.f845f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f844e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0357a.class) {
                if (f841b != null) {
                    objArr = f841b;
                    this.f846g = objArr;
                    f841b = (Object[]) objArr[0];
                    this.f845f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f842c--;
                    return;
                }
            }
        }
        this.f845f = new int[i];
        this.f846g = new Object[(i << 1)];
    }

    private static void m1281a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0357a.class) {
                if (f844e < 10) {
                    objArr[0] = f843d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f843d = objArr;
                    f844e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0357a.class) {
                if (f842c < 10) {
                    objArr[0] = f841b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f841b = objArr;
                    f842c++;
                }
            }
        }
    }

    public C0356i() {
        this.f845f = C0358b.f849a;
        this.f846g = C0358b.f851c;
        this.f847h = 0;
    }

    public C0356i(int i) {
        if (i == 0) {
            this.f845f = C0358b.f849a;
            this.f846g = C0358b.f851c;
        } else {
            m1282e(i);
        }
        this.f847h = 0;
    }

    public void clear() {
        if (this.f847h != 0) {
            C0356i.m1281a(this.f845f, this.f846g, this.f847h);
            this.f845f = C0358b.f849a;
            this.f846g = C0358b.f851c;
            this.f847h = 0;
        }
    }

    public void m1287a(int i) {
        if (this.f845f.length < i) {
            Object obj = this.f845f;
            Object obj2 = this.f846g;
            m1282e(i);
            if (this.f847h > 0) {
                System.arraycopy(obj, 0, this.f845f, 0, this.f847h);
                System.arraycopy(obj2, 0, this.f846g, 0, this.f847h << 1);
            }
            C0356i.m1281a(obj, obj2, this.f847h);
        }
    }

    public boolean containsKey(Object obj) {
        return m1284a(obj) >= 0;
    }

    public int m1284a(Object obj) {
        return obj == null ? m1283a() : m1285a(obj, obj.hashCode());
    }

    int m1289b(Object obj) {
        int i = 1;
        int i2 = this.f847h * 2;
        Object[] objArr = this.f846g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m1289b(obj) >= 0;
    }

    public V get(Object obj) {
        int a = m1284a(obj);
        return a >= 0 ? this.f846g[(a << 1) + 1] : null;
    }

    public K m1290b(int i) {
        return this.f846g[i << 1];
    }

    public V m1291c(int i) {
        return this.f846g[(i << 1) + 1];
    }

    public V m1286a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f846g[i2];
        this.f846g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f847h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m1283a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m1285a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f846g[i3];
            this.f846g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f847h >= this.f845f.length) {
            if (this.f847h >= 8) {
                i2 = this.f847h + (this.f847h >> 1);
            } else if (this.f847h < 4) {
                i2 = 4;
            }
            Object obj = this.f845f;
            Object obj2 = this.f846g;
            m1282e(i2);
            if (this.f845f.length > 0) {
                System.arraycopy(obj, 0, this.f845f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f846g, 0, obj2.length);
            }
            C0356i.m1281a(obj, obj2, this.f847h);
        }
        if (a < this.f847h) {
            System.arraycopy(this.f845f, a, this.f845f, a + 1, this.f847h - a);
            System.arraycopy(this.f846g, a << 1, this.f846g, (a + 1) << 1, (this.f847h - a) << 1);
        }
        this.f845f[a] = i;
        this.f846g[a << 1] = k;
        this.f846g[(a << 1) + 1] = v;
        this.f847h++;
        return null;
    }

    public void m1288a(C0356i<? extends K, ? extends V> c0356i) {
        int i = 0;
        int i2 = c0356i.f847h;
        m1287a(this.f847h + i2);
        if (this.f847h != 0) {
            while (i < i2) {
                put(c0356i.m1290b(i), c0356i.m1291c(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(c0356i.f845f, 0, this.f845f, 0, i2);
            System.arraycopy(c0356i.f846g, 0, this.f846g, 0, i2 << 1);
            this.f847h = i2;
        }
    }

    public V remove(Object obj) {
        int a = m1284a(obj);
        if (a >= 0) {
            return m1292d(a);
        }
        return null;
    }

    public V m1292d(int i) {
        int i2 = 8;
        V v = this.f846g[(i << 1) + 1];
        if (this.f847h <= 1) {
            C0356i.m1281a(this.f845f, this.f846g, this.f847h);
            this.f845f = C0358b.f849a;
            this.f846g = C0358b.f851c;
            this.f847h = 0;
        } else if (this.f845f.length <= 8 || this.f847h >= this.f845f.length / 3) {
            this.f847h--;
            if (i < this.f847h) {
                System.arraycopy(this.f845f, i + 1, this.f845f, i, this.f847h - i);
                System.arraycopy(this.f846g, (i + 1) << 1, this.f846g, i << 1, (this.f847h - i) << 1);
            }
            this.f846g[this.f847h << 1] = null;
            this.f846g[(this.f847h << 1) + 1] = null;
        } else {
            if (this.f847h > 8) {
                i2 = this.f847h + (this.f847h >> 1);
            }
            Object obj = this.f845f;
            Object obj2 = this.f846g;
            m1282e(i2);
            this.f847h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f845f, 0, i);
                System.arraycopy(obj2, 0, this.f846g, 0, i << 1);
            }
            if (i < this.f847h) {
                System.arraycopy(obj, i + 1, this.f845f, i, this.f847h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f846g, i << 1, (this.f847h - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.f847h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i;
        Object b;
        Object c;
        Object obj2;
        if (obj instanceof C0356i) {
            C0356i c0356i = (C0356i) obj;
            if (size() != c0356i.size()) {
                return false;
            }
            i = 0;
            while (i < this.f847h) {
                try {
                    b = m1290b(i);
                    c = m1291c(i);
                    obj2 = c0356i.get(b);
                    if (c == null) {
                        if (obj2 != null || !c0356i.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e) {
                    return false;
                } catch (ClassCastException e2) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            i = 0;
            while (i < this.f847h) {
                try {
                    b = m1290b(i);
                    c = m1291c(i);
                    obj2 = map.get(b);
                    if (c == null) {
                        if (obj2 != null || !map.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int[] iArr = this.f845f;
        Object[] objArr = this.f846g;
        int i = this.f847h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f847h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f847h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0356i b = m1290b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1291c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
