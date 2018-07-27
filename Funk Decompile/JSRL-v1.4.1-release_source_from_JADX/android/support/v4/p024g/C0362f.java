package android.support.v4.p024g;

import java.util.LinkedHashMap;

/* compiled from: LruCache */
public class C0362f<K, V> {
    private final LinkedHashMap<K, V> f859a;
    private int f860b;
    private int f861c;
    private int f862d;
    private int f863e;
    private int f864f;
    private int f865g;
    private int f866h;

    public C0362f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f861c = i;
        this.f859a = new LinkedHashMap(0, 0.75f, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V m1315a(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r0 = new java.lang.NullPointerException;
        r1 = "key == null";
        r0.<init>(r1);
        throw r0;
    L_0x000a:
        monitor-enter(r4);
        r0 = r4.f859a;	 Catch:{ all -> 0x002a }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r1 = r4.f865g;	 Catch:{ all -> 0x002a }
        r1 = r1 + 1;
        r4.f865g = r1;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r4.f866h;	 Catch:{ all -> 0x002a }
        r0 = r0 + 1;
        r4.f866h = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        r1 = r4.m1320b(r5);
        if (r1 != 0) goto L_0x002d;
    L_0x0028:
        r0 = 0;
        goto L_0x001a;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        monitor-enter(r4);
        r0 = r4.f863e;	 Catch:{ all -> 0x0053 }
        r0 = r0 + 1;
        r4.f863e = r0;	 Catch:{ all -> 0x0053 }
        r0 = r4.f859a;	 Catch:{ all -> 0x0053 }
        r0 = r0.put(r5, r1);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0049;
    L_0x003c:
        r2 = r4.f859a;	 Catch:{ all -> 0x0053 }
        r2.put(r5, r0);	 Catch:{ all -> 0x0053 }
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0056;
    L_0x0044:
        r2 = 0;
        r4.m1318a(r2, r5, r1, r0);
        goto L_0x001a;
    L_0x0049:
        r2 = r4.f860b;	 Catch:{ all -> 0x0053 }
        r3 = r4.m1314c(r5, r1);	 Catch:{ all -> 0x0053 }
        r2 = r2 + r3;
        r4.f860b = r2;	 Catch:{ all -> 0x0053 }
        goto L_0x0041;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        throw r0;
    L_0x0056:
        r0 = r4.f861c;
        r4.m1317a(r0);
        r0 = r1;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.f.a(java.lang.Object):V");
    }

    public final V m1316a(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.f862d++;
            this.f860b += m1314c(k, v);
            put = this.f859a.put(k, v);
            if (put != null) {
                this.f860b -= m1314c(k, put);
            }
        }
        if (put != null) {
            m1318a(false, k, put, v);
        }
        m1317a(this.f861c);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1317a(int r5) {
        /*
        r4 = this;
    L_0x0000:
        monitor-enter(r4);
        r0 = r4.f860b;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r4.f859a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r4.f860b;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r4.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r4.f860b;	 Catch:{ all -> 0x0032 }
        if (r0 <= r5) goto L_0x0041;
    L_0x0039:
        r0 = r4.f859a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r0 = r4.f859a;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r2 = r4.f859a;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r2 = r4.f860b;	 Catch:{ all -> 0x0032 }
        r3 = r4.m1314c(r1, r0);	 Catch:{ all -> 0x0032 }
        r2 = r2 - r3;
        r4.f860b = r2;	 Catch:{ all -> 0x0032 }
        r2 = r4.f864f;	 Catch:{ all -> 0x0032 }
        r2 = r2 + 1;
        r4.f864f = r2;	 Catch:{ all -> 0x0032 }
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        r2 = 1;
        r3 = 0;
        r4.m1318a(r2, r1, r0, r3);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.f.a(int):void");
    }

    protected void m1318a(boolean z, K k, V v, V v2) {
    }

    protected V m1320b(K k) {
        return null;
    }

    private int m1314c(K k, V v) {
        int b = m1319b(k, v);
        if (b >= 0) {
            return b;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected int m1319b(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f865g + this.f866h;
            if (i2 != 0) {
                i = (this.f865g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f861c), Integer.valueOf(this.f865g), Integer.valueOf(this.f866h), Integer.valueOf(i)});
        }
        return format;
    }
}
