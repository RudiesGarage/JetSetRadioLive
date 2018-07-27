package android.support.v4.p024g;

/* compiled from: Pools */
public final class C0370h {

    /* compiled from: Pools */
    public interface C0368a<T> {
        T mo203a();

        boolean mo204a(T t);
    }

    /* compiled from: Pools */
    public static class C0369b<T> implements C0368a<T> {
        private final Object[] f879a;
        private int f880b;

        public C0369b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f879a = new Object[i];
        }

        public T mo203a() {
            if (this.f880b <= 0) {
                return null;
            }
            int i = this.f880b - 1;
            T t = this.f879a[i];
            this.f879a[i] = null;
            this.f880b--;
            return t;
        }

        public boolean mo204a(T t) {
            if (m1325b(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f880b >= this.f879a.length) {
                return false;
            } else {
                this.f879a[this.f880b] = t;
                this.f880b++;
                return true;
            }
        }

        private boolean m1325b(T t) {
            for (int i = 0; i < this.f880b; i++) {
                if (this.f879a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }
}
