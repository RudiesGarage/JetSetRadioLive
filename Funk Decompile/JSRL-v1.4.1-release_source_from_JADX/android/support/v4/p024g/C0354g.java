package android.support.v4.p024g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: MapCollections */
abstract class C0354g<K, V> {
    C0364b f837b;
    C0365c f838c;
    C0367e f839d;

    /* compiled from: MapCollections */
    final class C0363a<T> implements Iterator<T> {
        final int f867a;
        int f868b;
        int f869c;
        boolean f870d = false;
        final /* synthetic */ C0354g f871e;

        C0363a(C0354g c0354g, int i) {
            this.f871e = c0354g;
            this.f867a = i;
            this.f868b = c0354g.mo194a();
        }

        public boolean hasNext() {
            return this.f869c < this.f868b;
        }

        public T next() {
            T a = this.f871e.mo196a(this.f869c, this.f867a);
            this.f869c++;
            this.f870d = true;
            return a;
        }

        public void remove() {
            if (this.f870d) {
                this.f869c--;
                this.f868b--;
                this.f870d = false;
                this.f871e.mo198a(this.f869c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections */
    final class C0364b implements Set<Entry<K, V>> {
        final /* synthetic */ C0354g f872a;

        C0364b(C0354g c0354g) {
            this.f872a = c0354g;
        }

        public /* synthetic */ boolean add(Object obj) {
            return m1321a((Entry) obj);
        }

        public boolean m1321a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f872a.mo194a();
            for (Entry entry : collection) {
                this.f872a.mo199a(entry.getKey(), entry.getValue());
            }
            return a != this.f872a.mo194a();
        }

        public void clear() {
            this.f872a.mo202c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f872a.mo195a(entry.getKey());
            if (a >= 0) {
                return C0358b.m1298a(this.f872a.mo196a(a, 1), entry.getValue());
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f872a.mo194a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0366d(this.f872a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f872a.mo194a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return C0354g.m1255a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f872a.mo194a() - 1;
            int i = 0;
            while (a >= 0) {
                int i2;
                Object a2 = this.f872a.mo196a(a, 0);
                Object a3 = this.f872a.mo196a(a, 1);
                int hashCode = a2 == null ? 0 : a2.hashCode();
                if (a3 == null) {
                    i2 = 0;
                } else {
                    i2 = a3.hashCode();
                }
                a--;
                i += i2 ^ hashCode;
            }
            return i;
        }
    }

    /* compiled from: MapCollections */
    final class C0365c implements Set<K> {
        final /* synthetic */ C0354g f873a;

        C0365c(C0354g c0354g) {
            this.f873a = c0354g;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f873a.mo202c();
        }

        public boolean contains(Object obj) {
            return this.f873a.mo195a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0354g.m1254a(this.f873a.mo201b(), (Collection) collection);
        }

        public boolean isEmpty() {
            return this.f873a.mo194a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0363a(this.f873a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f873a.mo195a(obj);
            if (a < 0) {
                return false;
            }
            this.f873a.mo198a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0354g.m1256b(this.f873a.mo201b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0354g.m1257c(this.f873a.mo201b(), collection);
        }

        public int size() {
            return this.f873a.mo194a();
        }

        public Object[] toArray() {
            return this.f873a.m1267b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f873a.m1264a((Object[]) tArr, 0);
        }

        public boolean equals(Object obj) {
            return C0354g.m1255a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f873a.mo194a() - 1; a >= 0; a--) {
                Object a2 = this.f873a.mo196a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }
    }

    /* compiled from: MapCollections */
    final class C0366d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f874a;
        int f875b;
        boolean f876c = false;
        final /* synthetic */ C0354g f877d;

        public /* synthetic */ Object next() {
            return m1322a();
        }

        C0366d(C0354g c0354g) {
            this.f877d = c0354g;
            this.f874a = c0354g.mo194a() - 1;
            this.f875b = -1;
        }

        public boolean hasNext() {
            return this.f875b < this.f874a;
        }

        public Entry<K, V> m1322a() {
            this.f875b++;
            this.f876c = true;
            return this;
        }

        public void remove() {
            if (this.f876c) {
                this.f877d.mo198a(this.f875b);
                this.f875b--;
                this.f874a--;
                this.f876c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f876c) {
                return this.f877d.mo196a(this.f875b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f876c) {
                return this.f877d.mo196a(this.f875b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f876c) {
                return this.f877d.mo197a(this.f875b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f876c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(C0358b.m1298a(entry.getKey(), this.f877d.mo196a(this.f875b, 0)) && C0358b.m1298a(entry.getValue(), this.f877d.mo196a(this.f875b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.f876c) {
                Object a = this.f877d.mo196a(this.f875b, 0);
                Object a2 = this.f877d.mo196a(this.f875b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: MapCollections */
    final class C0367e implements Collection<V> {
        final /* synthetic */ C0354g f878a;

        C0367e(C0354g c0354g) {
            this.f878a = c0354g;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f878a.mo202c();
        }

        public boolean contains(Object obj) {
            return this.f878a.mo200b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f878a.mo194a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0363a(this.f878a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f878a.mo200b(obj);
            if (b < 0) {
                return false;
            }
            this.f878a.mo198a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f878a.mo194a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f878a.mo196a(i, 1))) {
                    this.f878a.mo198a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.f878a.mo194a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f878a.mo196a(i, 1))) {
                    this.f878a.mo198a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f878a.mo194a();
        }

        public Object[] toArray() {
            return this.f878a.m1267b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f878a.m1264a((Object[]) tArr, 1);
        }
    }

    protected abstract int mo194a();

    protected abstract int mo195a(Object obj);

    protected abstract Object mo196a(int i, int i2);

    protected abstract V mo197a(int i, V v);

    protected abstract void mo198a(int i);

    protected abstract void mo199a(K k, V v);

    protected abstract int mo200b(Object obj);

    protected abstract Map<K, V> mo201b();

    protected abstract void mo202c();

    C0354g() {
    }

    public static <K, V> boolean m1254a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean m1256b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m1257c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] m1267b(int i) {
        int a = mo194a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo196a(i2, i);
        }
        return objArr;
    }

    public <T> T[] m1264a(T[] tArr, int i) {
        T[] tArr2;
        int a = mo194a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo196a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    public static <T> boolean m1255a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public Set<Entry<K, V>> m1269d() {
        if (this.f837b == null) {
            this.f837b = new C0364b(this);
        }
        return this.f837b;
    }

    public Set<K> m1270e() {
        if (this.f838c == null) {
            this.f838c = new C0365c(this);
        }
        return this.f838c;
    }

    public Collection<V> m1271f() {
        if (this.f839d == null) {
            this.f839d = new C0367e(this);
        }
        return this.f839d;
    }
}
