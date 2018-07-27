package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C1136c.C1085b;
import com.google.android.gms.common.api.C1136c.C1086c;
import com.google.android.gms.common.internal.C1154r;
import com.google.android.gms.common.internal.C1157b;
import com.google.android.gms.common.internal.C1160i.C1092f;
import com.google.android.gms.common.internal.C1178j;
import java.util.Set;

public final class C1133a<O extends C1056a> {
    private final C1053b<?, O> f3010a;
    private final C1131i<?, O> f3011b = null;
    private final C1129g<?> f3012c;
    private final C1132j<?> f3013d;
    private final String f3014e;

    public static abstract class C1052e<T extends C1059c, O> {
    }

    public static abstract class C1053b<T extends C1060f, O> extends C1052e<T, O> {
        public abstract T mo749a(Context context, Looper looper, C1178j c1178j, O o, C1085b c1085b, C1086c c1086c);
    }

    public interface C1056a {

        public interface C1057a extends C1056a {
        }

        public interface C1063b extends C1056a {
        }

        public interface C1064c extends C1057a, C1063b {
        }
    }

    public interface C1059c {
    }

    public interface C1060f extends C1059c {
        void m5087a();

        void m5088a(C1092f c1092f);

        void m5089a(C1154r c1154r, Set<Scope> set);

        boolean m5090b();

        boolean m5091c();

        boolean mo866d();

        boolean m5093e();
    }

    public static class C1128d<C extends C1059c> {
    }

    public static final class C1129g<C extends C1060f> extends C1128d<C> {
    }

    public interface C1130h<T extends IInterface> extends C1059c {
        T m5287a(IBinder iBinder);

        String m5288a();

        void m5289a(int i, T t);

        String m5290b();
    }

    public static abstract class C1131i<T extends C1130h, O> extends C1052e<T, O> {
        public abstract int m5291a();

        public abstract T m5292a(O o);
    }

    public static final class C1132j<C extends C1130h> extends C1128d<C> {
    }

    public <C extends C1060f> C1133a(String str, C1053b<C, O> c1053b, C1129g<C> c1129g) {
        C1157b.m5370a((Object) c1053b, (Object) "Cannot construct an Api with a null ClientBuilder");
        C1157b.m5370a((Object) c1129g, (Object) "Cannot construct an Api with a null ClientKey");
        this.f3014e = str;
        this.f3010a = c1053b;
        this.f3012c = c1129g;
        this.f3013d = null;
    }

    public C1053b<?, O> m5293a() {
        C1157b.m5374a(this.f3010a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f3010a;
    }

    public C1131i<?, O> m5294b() {
        C1157b.m5374a(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public boolean m5295c() {
        return false;
    }

    public String m5296d() {
        return this.f3014e;
    }
}
