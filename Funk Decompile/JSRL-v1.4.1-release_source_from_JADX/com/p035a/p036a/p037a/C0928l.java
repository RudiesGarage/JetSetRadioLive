package com.p035a.p036a.p037a;

import java.util.Random;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.C0054a;

/* compiled from: RandomBackoff */
class C0928l implements C0054a {
    final C0054a f2508a;
    final Random f2509b;
    final double f2510c;

    public C0928l(C0054a c0054a, double d) {
        this(c0054a, d, new Random());
    }

    public C0928l(C0054a c0054a, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (c0054a == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random == null) {
            throw new NullPointerException("random must not be null");
        } else {
            this.f2508a = c0054a;
            this.f2510c = d;
            this.f2509b = random;
        }
    }

    public long mo9a(int i) {
        return (long) (m4658a() * ((double) this.f2508a.mo9a(i)));
    }

    double m4658a() {
        double d = 1.0d - this.f2510c;
        return d + (((this.f2510c + 1.0d) - d) * this.f2509b.nextDouble());
    }
}
