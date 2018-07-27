package com.google.android.gms.p043b;

public final class C1098q<L> {
    private volatile L f2931a;

    public static final class C1097a<L> {
        private final L f2929a;
        private final String f2930b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1097a)) {
                return false;
            }
            C1097a c1097a = (C1097a) obj;
            return this.f2929a == c1097a.f2929a && this.f2930b.equals(c1097a.f2930b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f2929a) * 31) + this.f2930b.hashCode();
        }
    }

    public void m5223a() {
        this.f2931a = null;
    }
}
