package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C1133a.C1056a;
import com.google.android.gms.common.api.C1133a.C1060f;
import com.google.android.gms.common.api.C1133a.C1131i;
import com.google.android.gms.common.api.C1136c.C1085b;
import com.google.android.gms.common.api.C1136c.C1086c;
import com.google.android.gms.common.internal.C1157b;
import com.google.android.gms.common.internal.C1162e;
import com.google.android.gms.common.internal.C1178j;
import com.google.android.gms.p043b.C1072e;
import com.google.android.gms.p043b.C1087i;

public abstract class C1142j<O extends C1056a> {
    private final Context f3035a;
    private final C1133a<O> f3036b;
    private final O f3037c;
    private final C1072e<O> f3038d;
    private final int f3039e;
    private final C1060f f3040f;
    private final C1087i f3041g;

    public C1060f m5302a(Looper looper, C1085b c1085b, C1086c c1086c) {
        C1157b.m5374a(this.f3040f == null, (Object) "Client is already built, use getClient(). getClientCallbacks() should also be provided with a helper.");
        if (this.f3036b.m5295c()) {
            C1131i b = this.f3036b.m5294b();
            return new C1162e(this.f3035a, looper, b.m5291a(), c1085b, c1086c, C1178j.m5464a(this.f3035a), b.m5292a(this.f3037c));
        }
        return this.f3036b.m5293a().mo749a(this.f3035a, looper, C1178j.m5464a(this.f3035a), this.f3037c, c1085b, c1086c);
    }

    public boolean m5303a() {
        return (this.f3040f == null || this.f3041g == null) ? false : true;
    }

    public C1060f m5304b() {
        return (C1060f) C1157b.m5370a(this.f3040f, (Object) "Client is null, buildApiClient() should be used.");
    }

    public C1087i m5305c() {
        return (C1087i) C1157b.m5370a(this.f3041g, (Object) "ClientCallbacks is null.");
    }

    public C1072e<O> m5306d() {
        return this.f3038d;
    }

    public int m5307e() {
        return this.f3039e;
    }
}
