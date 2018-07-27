package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.p024g.C0357a;
import android.view.View;
import com.google.android.gms.common.C1147b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1133a.C1053b;
import com.google.android.gms.common.api.C1133a.C1056a;
import com.google.android.gms.common.internal.C1178j;
import com.google.android.gms.common.internal.C1178j.C1177a;
import com.google.android.gms.p043b.ab;
import com.google.android.gms.p043b.ac;
import com.google.android.gms.p043b.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class C1136c {
    private static final Set<C1136c> f3032a = Collections.newSetFromMap(new WeakHashMap());

    public interface C1085b {
        void mo759a(int i);

        void mo760a(Bundle bundle);
    }

    public interface C1086c {
        void mo761a(ConnectionResult connectionResult);
    }

    public static final class C1135a {
        private Account f3015a;
        private final Set<Scope> f3016b = new HashSet();
        private final Set<Scope> f3017c = new HashSet();
        private int f3018d;
        private View f3019e;
        private String f3020f;
        private String f3021g;
        private final Map<C1133a<?>, C1177a> f3022h = new C0357a();
        private final Context f3023i;
        private final Map<C1133a<?>, C1056a> f3024j = new C0357a();
        private int f3025k = -1;
        private Looper f3026l;
        private C1147b f3027m = C1147b.m5323a();
        private C1053b<? extends ac, ad> f3028n = ab.f2836c;
        private final ArrayList<C1085b> f3029o = new ArrayList();
        private final ArrayList<C1086c> f3030p = new ArrayList();
        private boolean f3031q = false;

        public C1135a(Context context) {
            this.f3023i = context;
            this.f3026l = context.getMainLooper();
            this.f3020f = context.getPackageName();
            this.f3021g = context.getClass().getName();
        }

        public C1178j m5298a() {
            ad adVar = ad.f2842a;
            if (this.f3024j.containsKey(ab.f2840g)) {
                adVar = (ad) this.f3024j.get(ab.f2840g);
            }
            return new C1178j(this.f3015a, this.f3016b, this.f3022h, this.f3018d, this.f3019e, this.f3020f, this.f3021g, adVar);
        }
    }
}
