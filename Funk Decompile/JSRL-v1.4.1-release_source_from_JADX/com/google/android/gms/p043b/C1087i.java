package com.google.android.gms.p043b;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1133a;
import com.google.android.gms.common.api.C1136c.C1085b;
import com.google.android.gms.common.api.C1136c.C1086c;
import com.google.android.gms.common.internal.C1157b;

public class C1087i implements C1085b, C1086c {
    public final C1133a<?> f2890a;
    private final int f2891b;
    private C1088j f2892c;

    private void m5153a() {
        C1157b.m5370a(this.f2892c, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public void mo759a(int i) {
        m5153a();
        this.f2892c.mo759a(i);
    }

    public void mo760a(Bundle bundle) {
        m5153a();
        this.f2892c.mo760a(bundle);
    }

    public void m5156a(C1088j c1088j) {
        this.f2892c = c1088j;
    }

    public void mo761a(ConnectionResult connectionResult) {
        m5153a();
        this.f2892c.mo764a(connectionResult, this.f2890a, this.f2891b);
    }
}
