package android.support.v4.p024g;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ArrayMap */
public class C0357a<K, V> extends C0356i<K, V> implements Map<K, V> {
    C0354g<K, V> f848a;

    /* compiled from: ArrayMap */
    class C03551 extends C0354g<K, V> {
        final /* synthetic */ C0357a f840a;

        C03551(C0357a c0357a) {
            this.f840a = c0357a;
        }

        protected int mo194a() {
            return this.f840a.h;
        }

        protected Object mo196a(int i, int i2) {
            return this.f840a.g[(i << 1) + i2];
        }

        protected int mo195a(Object obj) {
            return this.f840a.m1284a(obj);
        }

        protected int mo200b(Object obj) {
            return this.f840a.m1289b(obj);
        }

        protected Map<K, V> mo201b() {
            return this.f840a;
        }

        protected void mo199a(K k, V v) {
            this.f840a.put(k, v);
        }

        protected V mo197a(int i, V v) {
            return this.f840a.m1286a(i, (Object) v);
        }

        protected void mo198a(int i) {
            this.f840a.m1292d(i);
        }

        protected void mo202c() {
            this.f840a.clear();
        }
    }

    public C0357a(int i) {
        super(i);
    }

    private C0354g<K, V> m1293b() {
        if (this.f848a == null) {
            this.f848a = new C03551(this);
        }
        return this.f848a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m1287a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean m1294a(Collection<?> collection) {
        return C0354g.m1257c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m1293b().m1269d();
    }

    public Set<K> keySet() {
        return m1293b().m1270e();
    }

    public Collection<V> values() {
        return m1293b().m1271f();
    }
}
