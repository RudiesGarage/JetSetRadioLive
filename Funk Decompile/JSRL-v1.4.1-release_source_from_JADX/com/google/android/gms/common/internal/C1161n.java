package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.C1147b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1133a.C1060f;
import com.google.android.gms.common.api.C1136c.C1085b;
import com.google.android.gms.common.api.C1136c.C1086c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1160i.C1168b;
import com.google.android.gms.common.internal.C1160i.C1169c;
import java.util.Set;

public abstract class C1161n<T extends IInterface> extends C1160i<T> implements C1060f {
    private final C1178j f3109e;
    private final Set<Scope> f3110f;
    private final Account f3111g;

    class C11851 implements C1168b {
        final /* synthetic */ C1085b f3150a;

        C11851(C1085b c1085b) {
            this.f3150a = c1085b;
        }

        public void mo796a(int i) {
            this.f3150a.mo759a(i);
        }

        public void mo797a(Bundle bundle) {
            this.f3150a.mo760a(bundle);
        }
    }

    class C11862 implements C1169c {
        final /* synthetic */ C1086c f3151a;

        C11862(C1086c c1086c) {
            this.f3151a = c1086c;
        }

        public void mo798a(ConnectionResult connectionResult) {
            this.f3151a.mo761a(connectionResult);
        }
    }

    protected C1161n(Context context, Looper looper, int i, C1178j c1178j, C1085b c1085b, C1086c c1086c) {
        this(context, looper, C1187o.m5492a(context), C1147b.m5323a(), i, c1178j, (C1085b) C1157b.m5369a((Object) c1085b), (C1086c) C1157b.m5369a((Object) c1086c));
    }

    protected C1161n(Context context, Looper looper, C1187o c1187o, C1147b c1147b, int i, C1178j c1178j, C1085b c1085b, C1086c c1086c) {
        super(context, looper, c1187o, c1147b, i, C1161n.m5422a(c1085b), C1161n.m5423a(c1086c), c1178j.m5468d());
        this.f3109e = c1178j;
        this.f3111g = c1178j.m5465a();
        this.f3110f = m5424b(c1178j.m5466b());
    }

    private static C1168b m5422a(C1085b c1085b) {
        return c1085b == null ? null : new C11851(c1085b);
    }

    private static C1169c m5423a(C1086c c1086c) {
        return c1086c == null ? null : new C11862(c1086c);
    }

    private Set<Scope> m5424b(Set<Scope> set) {
        Set<Scope> a = m5425a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    protected Set<Scope> m5425a(Set<Scope> set) {
        return set;
    }

    public final Account mo783l() {
        return this.f3111g;
    }
}
