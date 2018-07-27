package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.C1133a;
import com.google.android.gms.common.api.C1136c.C1135a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.p043b.ad;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class C1178j {
    private final Account f3130a;
    private final Set<Scope> f3131b;
    private final Set<Scope> f3132c;
    private final Map<C1133a<?>, C1177a> f3133d;
    private final int f3134e;
    private final View f3135f;
    private final String f3136g;
    private final String f3137h;
    private final ad f3138i;
    private Integer f3139j;

    public static final class C1177a {
        public final Set<Scope> f3129a;
    }

    public C1178j(Account account, Set<Scope> set, Map<C1133a<?>, C1177a> map, int i, View view, String str, String str2, ad adVar) {
        Map map2;
        this.f3130a = account;
        this.f3131b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f3133d = map2;
        this.f3135f = view;
        this.f3134e = i;
        this.f3136g = str;
        this.f3137h = str2;
        this.f3138i = adVar;
        Set hashSet = new HashSet(this.f3131b);
        for (C1177a c1177a : this.f3133d.values()) {
            hashSet.addAll(c1177a.f3129a);
        }
        this.f3132c = Collections.unmodifiableSet(hashSet);
    }

    public static C1178j m5464a(Context context) {
        return new C1135a(context).m5298a();
    }

    public Account m5465a() {
        return this.f3130a;
    }

    public Set<Scope> m5466b() {
        return this.f3132c;
    }

    public String m5467c() {
        return this.f3136g;
    }

    public String m5468d() {
        return this.f3137h;
    }

    public ad m5469e() {
        return this.f3138i;
    }

    public Integer m5470f() {
        return this.f3139j;
    }
}
