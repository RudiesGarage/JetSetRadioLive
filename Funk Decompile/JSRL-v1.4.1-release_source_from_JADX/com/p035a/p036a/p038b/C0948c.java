package com.p035a.p036a.p038b;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p005a.C0005b;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0027m;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o.C0032a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0042s;
import p000a.p001a.p002a.p003a.p004a.p010e.C0089b;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;
import p000a.p001a.p002a.p003a.p004a.p012g.C0112f;
import p000a.p001a.p002a.p003a.p004a.p012g.C0129q;
import p000a.p001a.p002a.p003a.p004a.p012g.C0131t;

/* compiled from: Beta */
public class C0948c extends C0149i<Boolean> implements C0027m {
    private final C0005b<String> f2583a = new C0005b();
    private final C0953h f2584b = new C0953h();
    private C0943j f2585c;

    protected /* synthetic */ Object mo67f() {
        return m4716d();
    }

    @TargetApi(14)
    protected boolean a_() {
        this.f2585c = m4712a(VERSION.SDK_INT, (Application) m496E().getApplicationContext());
        return true;
    }

    protected Boolean m4716d() {
        C0142c.m468h().mo46a("Beta", "Beta kit initializing...");
        Context E = m496E();
        C0033o D = m495D();
        if (TextUtils.isEmpty(m4710a(E, D.m121j()))) {
            C0142c.m468h().mo46a("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        C0142c.m468h().mo46a("Beta", "Beta device token is present, checking for app updates.");
        C0112f h = m4711h();
        C0949d a = m4709a(E);
        if (m4714a(h, a)) {
            this.f2585c.mo727a(E, this, D, h, a, new C0106d(this), new C0042s(), new C0089b(C0142c.m468h()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    C0943j m4712a(int i, Application application) {
        if (i >= 14) {
            return new C0947b(m497F().m479e(), m497F().m480f());
        }
        return new C0954i();
    }

    public Map<C0032a, String> mo728e() {
        CharSequence a = m4710a(m496E(), m495D().m121j());
        Map<C0032a, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put(C0032a.FONT_TOKEN, a);
        }
        return hashMap;
    }

    public String mo66b() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String mo64a() {
        return "1.2.1.139";
    }

    boolean m4714a(C0112f c0112f, C0949d c0949d) {
        return (c0112f == null || TextUtils.isEmpty(c0112f.f245a) || c0949d == null) ? false : true;
    }

    private String m4710a(Context context, String str) {
        Object obj;
        try {
            obj = (String) this.f2583a.mo1a(context, this.f2584b);
            if ("".equals(obj)) {
                obj = null;
            }
        } catch (Throwable e) {
            C0142c.m468h().mo54e("Beta", "Failed to load the Beta device token", e);
            obj = null;
        }
        C0142c.m468h().mo46a("Beta", "Beta device token present: " + (!TextUtils.isEmpty(obj)));
        return obj;
    }

    private C0112f m4711h() {
        C0131t b = C0129q.m415a().m419b();
        if (b != null) {
            return b.f290f;
        }
        return null;
    }

    private C0949d m4709a(Context context) {
        InputStream open;
        Throwable th;
        Throwable e;
        Object obj;
        Throwable th2;
        C0949d c0949d;
        InputStream inputStream = null;
        try {
            open = context.getAssets().open("crashlytics-build.properties");
            if (open != null) {
                C0949d a;
                try {
                    a = C0949d.m4720a(open);
                } catch (Throwable e2) {
                    th = e2;
                    obj = inputStream;
                    th2 = th;
                    try {
                        C0142c.m468h().mo54e("Beta", "Error reading Beta build properties", th2);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th22) {
                                C0142c.m468h().mo54e("Beta", "Error closing Beta build properties asset", th22);
                            }
                        }
                        return c0949d;
                    } catch (Throwable th3) {
                        e2 = th3;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th222) {
                                C0142c.m468h().mo54e("Beta", "Error closing Beta build properties asset", th222);
                            }
                        }
                        throw e2;
                    }
                }
                try {
                    C0142c.m468h().mo46a("Beta", a.f2589d + " build properties: " + a.f2587b + " (" + a.f2586a + ")" + " - " + a.f2588c);
                    c0949d = a;
                } catch (Throwable e22) {
                    th = e22;
                    c0949d = a;
                    th222 = th;
                    C0142c.m468h().mo54e("Beta", "Error reading Beta build properties", th222);
                    if (open != null) {
                        open.close();
                    }
                    return c0949d;
                }
            }
            obj = inputStream;
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2222) {
                    C0142c.m468h().mo54e("Beta", "Error closing Beta build properties asset", th2222);
                }
            }
        } catch (Throwable e222) {
            open = inputStream;
            InputStream inputStream2 = inputStream;
            th2222 = e222;
            c0949d = inputStream2;
            C0142c.m468h().mo54e("Beta", "Error reading Beta build properties", th2222);
            if (open != null) {
                open.close();
            }
            return c0949d;
        } catch (Throwable th4) {
            e222 = th4;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        return c0949d;
    }

    String m4719g() {
        return C0021i.m78b(m496E(), "com.crashlytics.ApiEndpoint");
    }
}
