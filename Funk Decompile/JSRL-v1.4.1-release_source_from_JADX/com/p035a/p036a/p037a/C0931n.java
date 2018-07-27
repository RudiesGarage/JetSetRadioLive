package com.p035a.p036a.p037a;

import com.p035a.p036a.p037a.C0938s.C0937b;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SamplingEventFilter */
class C0931n implements C0926j {
    static final Set<C0937b> f2513b = new C09301();
    final int f2514a;

    /* compiled from: SamplingEventFilter */
    static class C09301 extends HashSet<C0937b> {
        C09301() {
            add(C0937b.START);
            add(C0937b.RESUME);
            add(C0937b.PAUSE);
            add(C0937b.STOP);
        }
    }

    public C0931n(int i) {
        this.f2514a = i;
    }

    public boolean mo720a(C0938s c0938s) {
        boolean z;
        if (f2513b.contains(c0938s.f2540c) && c0938s.f2538a.f2553g == null) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (Math.abs(c0938s.f2538a.f2549c.hashCode() % this.f2514a) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }
}
