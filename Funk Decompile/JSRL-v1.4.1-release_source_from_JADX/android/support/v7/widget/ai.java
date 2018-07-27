package android.support.v7.widget;

/* compiled from: RtlSpacingHelper */
class ai {
    private int f2171a = 0;
    private int f2172b = 0;
    private int f2173c = Integer.MIN_VALUE;
    private int f2174d = Integer.MIN_VALUE;
    private int f2175e = 0;
    private int f2176f = 0;
    private boolean f2177g = false;
    private boolean f2178h = false;

    ai() {
    }

    public int m4215a() {
        return this.f2171a;
    }

    public int m4218b() {
        return this.f2172b;
    }

    public int m4220c() {
        return this.f2177g ? this.f2172b : this.f2171a;
    }

    public int m4221d() {
        return this.f2177g ? this.f2171a : this.f2172b;
    }

    public void m4216a(int i, int i2) {
        this.f2173c = i;
        this.f2174d = i2;
        this.f2178h = true;
        if (this.f2177g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2171a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2172b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f2171a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2172b = i2;
        }
    }

    public void m4219b(int i, int i2) {
        this.f2178h = false;
        if (i != Integer.MIN_VALUE) {
            this.f2175e = i;
            this.f2171a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2176f = i2;
            this.f2172b = i2;
        }
    }

    public void m4217a(boolean z) {
        if (z != this.f2177g) {
            this.f2177g = z;
            if (!this.f2178h) {
                this.f2171a = this.f2175e;
                this.f2172b = this.f2176f;
            } else if (z) {
                this.f2171a = this.f2174d != Integer.MIN_VALUE ? this.f2174d : this.f2175e;
                this.f2172b = this.f2173c != Integer.MIN_VALUE ? this.f2173c : this.f2176f;
            } else {
                this.f2171a = this.f2173c != Integer.MIN_VALUE ? this.f2173c : this.f2175e;
                this.f2172b = this.f2174d != Integer.MIN_VALUE ? this.f2174d : this.f2176f;
            }
        }
    }
}
