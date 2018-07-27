package com.google.android.gms.p043b;

import com.google.android.gms.common.api.C1133a;
import com.google.android.gms.common.api.C1133a.C1056a;
import com.google.android.gms.common.internal.C1211z;

public final class C1072e<O extends C1056a> {
    private final boolean f2856a;
    private final int f2857b;
    private final C1133a<O> f2858c;
    private final O f2859d;

    public String m5125a() {
        return this.f2858c.m5296d();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1072e)) {
            return false;
        }
        C1072e c1072e = (C1072e) obj;
        return !this.f2856a && !c1072e.f2856a && C1211z.m5661a(this.f2858c, c1072e.f2858c) && C1211z.m5661a(this.f2859d, c1072e.f2859d);
    }

    public int hashCode() {
        return this.f2857b;
    }
}
