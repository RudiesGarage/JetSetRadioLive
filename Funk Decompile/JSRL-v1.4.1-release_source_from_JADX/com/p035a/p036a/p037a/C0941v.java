package com.p035a.p036a.p037a;

import android.content.Context;
import java.util.Map;
import java.util.UUID;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o.C0032a;

/* compiled from: SessionMetadataCollector */
class C0941v {
    private final Context f2560a;
    private final C0033o f2561b;
    private final String f2562c;
    private final String f2563d;

    public C0941v(Context context, C0033o c0033o, String str, String str2) {
        this.f2560a = context;
        this.f2561b = c0033o;
        this.f2562c = str;
        this.f2563d = str2;
    }

    public C0939t m4690a() {
        Map i = this.f2561b.m120i();
        return new C0939t(this.f2561b.m114c(), UUID.randomUUID().toString(), this.f2561b.m113b(), (String) i.get(C0032a.ANDROID_ID), (String) i.get(C0032a.ANDROID_ADVERTISING_ID), this.f2561b.m123l(), (String) i.get(C0032a.FONT_TOKEN), C0021i.m93m(this.f2560a), this.f2561b.m115d(), this.f2561b.m118g(), this.f2562c, this.f2563d);
    }
}
