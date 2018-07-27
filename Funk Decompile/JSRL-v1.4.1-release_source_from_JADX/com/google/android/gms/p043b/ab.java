package com.google.android.gms.p043b;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.C1133a;
import com.google.android.gms.common.api.C1133a.C1053b;
import com.google.android.gms.common.api.C1133a.C1056a.C1057a;
import com.google.android.gms.common.api.C1133a.C1129g;
import com.google.android.gms.common.api.C1136c.C1085b;
import com.google.android.gms.common.api.C1136c.C1086c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1178j;
import com.google.android.gms.signin.internal.C1252f;

public final class ab {
    public static final C1129g<C1252f> f2834a = new C1129g();
    public static final C1129g<C1252f> f2835b = new C1129g();
    public static final C1053b<C1252f, ad> f2836c = new C10541();
    static final C1053b<C1252f, C1058a> f2837d = new C10552();
    public static final Scope f2838e = new Scope("profile");
    public static final Scope f2839f = new Scope("email");
    public static final C1133a<ad> f2840g = new C1133a("SignIn.API", f2836c, f2834a);
    public static final C1133a<C1058a> f2841h = new C1133a("SignIn.INTERNAL_API", f2837d, f2835b);

    class C10541 extends C1053b<C1252f, ad> {
        C10541() {
        }

        public C1252f m5083a(Context context, Looper looper, C1178j c1178j, ad adVar, C1085b c1085b, C1086c c1086c) {
            return new C1252f(context, looper, true, c1178j, adVar == null ? ad.f2842a : adVar, c1085b, c1086c);
        }
    }

    class C10552 extends C1053b<C1252f, C1058a> {
        C10552() {
        }

        public C1252f m5085a(Context context, Looper looper, C1178j c1178j, C1058a c1058a, C1085b c1085b, C1086c c1086c) {
            return new C1252f(context, looper, false, c1178j, c1058a.m5086a(), c1085b, c1086c);
        }
    }

    public static class C1058a implements C1057a {
        private final Bundle f2833a;

        public Bundle m5086a() {
            return this.f2833a;
        }
    }
}
