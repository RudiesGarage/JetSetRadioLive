package com.google.android.gms.signin.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C1136c.C1085b;
import com.google.android.gms.common.api.C1136c.C1086c;
import com.google.android.gms.common.internal.C1161n;
import com.google.android.gms.common.internal.C1178j;
import com.google.android.gms.p043b.ac;
import com.google.android.gms.p043b.ad;
import com.google.android.gms.signin.internal.C1248d.C1250a;

public class C1252f extends C1161n<C1248d> implements ac {
    private final boolean f3232e;
    private final C1178j f3233f;
    private final Bundle f3234g;
    private Integer f3235h;

    public C1252f(Context context, Looper looper, boolean z, C1178j c1178j, Bundle bundle, C1085b c1085b, C1086c c1086c) {
        super(context, looper, 44, c1178j, c1085b, c1086c);
        this.f3232e = z;
        this.f3233f = c1178j;
        this.f3234g = bundle;
        this.f3235h = c1178j.m5470f();
    }

    public C1252f(Context context, Looper looper, boolean z, C1178j c1178j, ad adVar, C1085b c1085b, C1086c c1086c) {
        this(context, looper, z, c1178j, C1252f.m5757a(c1178j), c1085b, c1086c);
    }

    public static Bundle m5757a(C1178j c1178j) {
        ad e = c1178j.m5469e();
        Integer f = c1178j.m5470f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c1178j.m5465a());
        if (f != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", f.intValue());
        }
        if (e != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", e.m5095a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", e.m5096b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", e.m5097c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", e.m5098d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", e.m5099e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", e.m5100f());
            if (e.m5101g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", e.m5101g().longValue());
            }
            if (e.m5102h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", e.m5102h().longValue());
            }
        }
        return bundle;
    }

    protected /* synthetic */ IInterface mo784a(IBinder iBinder) {
        return m5759b(iBinder);
    }

    protected C1248d m5759b(IBinder iBinder) {
        return C1250a.m5753a(iBinder);
    }

    public boolean mo866d() {
        return this.f3232e;
    }

    protected String mo786f() {
        return "com.google.android.gms.signin.service.START";
    }

    protected String mo787g() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected Bundle mo867n() {
        if (!m5416k().getPackageName().equals(this.f3233f.m5467c())) {
            this.f3234g.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f3233f.m5467c());
        }
        return this.f3234g;
    }
}
