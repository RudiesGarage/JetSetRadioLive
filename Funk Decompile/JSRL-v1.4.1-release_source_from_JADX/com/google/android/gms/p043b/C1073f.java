package com.google.android.gms.p043b;

import android.support.v4.p024g.C0357a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1141i;
import com.google.android.gms.p044c.C1116b;
import java.util.Set;

public final class C1073f {
    private final C0357a<C1072e<?>, ConnectionResult> f2860a;
    private final C1116b<Void> f2861b;
    private int f2862c;
    private boolean f2863d;

    public Set<C1072e<?>> m5126a() {
        return this.f2860a.keySet();
    }

    public void m5127a(C1072e<?> c1072e, ConnectionResult connectionResult) {
        this.f2860a.put(c1072e, connectionResult);
        this.f2862c--;
        if (!connectionResult.m5260b()) {
            this.f2863d = true;
        }
        if (this.f2862c != 0) {
            return;
        }
        if (this.f2863d) {
            this.f2861b.m5249a(new C1141i(this.f2860a));
            return;
        }
        this.f2861b.m5250a(null);
    }
}
