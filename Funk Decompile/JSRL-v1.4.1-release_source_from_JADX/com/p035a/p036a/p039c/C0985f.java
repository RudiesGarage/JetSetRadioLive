package com.p035a.p036a.p039c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.p035a.p036a.p037a.C0908a;
import com.p035a.p036a.p039c.p040a.C0962a;
import com.p035a.p036a.p039c.p040a.p041a.C0958d;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0022j.C0023a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0022j.C0024b;
import p000a.p001a.p002a.p003a.p004a.p006b.C0031n;
import p000a.p001a.p002a.p003a.p004a.p007c.C0062d;
import p000a.p001a.p002a.p003a.p004a.p007c.C0063e;
import p000a.p001a.p002a.p003a.p004a.p007c.C0065l;
import p000a.p001a.p002a.p003a.p004a.p007c.C0071g;
import p000a.p001a.p002a.p003a.p004a.p007c.C0074m;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p010e.C0089b;
import p000a.p001a.p002a.p003a.p004a.p010e.C0100g;
import p000a.p001a.p002a.p003a.p004a.p011f.C0103a;
import p000a.p001a.p002a.p003a.p004a.p011f.C0104b;
import p000a.p001a.p002a.p003a.p004a.p011f.C0105c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;
import p000a.p001a.p002a.p003a.p004a.p012g.C0124o;
import p000a.p001a.p002a.p003a.p004a.p012g.C0125p;
import p000a.p001a.p002a.p003a.p004a.p012g.C0129q;
import p000a.p001a.p002a.p003a.p004a.p012g.C0129q.C0128b;
import p000a.p001a.p002a.p003a.p004a.p012g.C0131t;

@C0062d(a = {C0962a.class})
/* compiled from: CrashlyticsCore */
public class C0985f extends C0149i<Void> {
    private C0088e f2673A;
    private C0988g f2674B;
    private C0962a f2675C;
    private final long f2676a;
    private final ConcurrentHashMap<String, String> f2677b;
    private File f2678c;
    private C0103a f2679d;
    private C0989h f2680k;
    private C0989h f2681l;
    private C0982i f2682m;
    private C1005l f2683n;
    private String f2684o;
    private String f2685p;
    private String f2686q;
    private String f2687r;
    private String f2688s;
    private String f2689t;
    private String f2690u;
    private String f2691v;
    private String f2692w;
    private float f2693x;
    private boolean f2694y;
    private final C1033w f2695z;

    /* compiled from: CrashlyticsCore */
    class C09711 extends C0071g<Void> {
        final /* synthetic */ C0985f f2656a;

        C09711(C0985f c0985f) {
            this.f2656a = c0985f;
        }

        public /* synthetic */ Object call() {
            return m4837a();
        }

        public Void m4837a() {
            return this.f2656a.m4875d();
        }

        public C0063e mo11b() {
            return C0063e.IMMEDIATE;
        }
    }

    /* compiled from: CrashlyticsCore */
    class C09722 implements Callable<Void> {
        final /* synthetic */ C0985f f2657a;

        C09722(C0985f c0985f) {
            this.f2657a = c0985f;
        }

        public /* synthetic */ Object call() {
            return m4839a();
        }

        public Void m4839a() {
            this.f2657a.f2680k.m4901a();
            C0142c.m468h().mo46a("CrashlyticsCore", "Initialization marker file created.");
            return null;
        }
    }

    /* compiled from: CrashlyticsCore */
    class C09733 implements Callable<Boolean> {
        final /* synthetic */ C0985f f2658a;

        C09733(C0985f c0985f) {
            this.f2658a = c0985f;
        }

        public /* synthetic */ Object call() {
            return m4840a();
        }

        public Boolean m4840a() {
            try {
                boolean c = this.f2658a.f2680k.m4903c();
                C0142c.m468h().mo46a("CrashlyticsCore", "Initialization marker file removed: " + c);
                return Boolean.valueOf(c);
            } catch (Throwable e) {
                C0142c.m468h().mo54e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.valueOf(false);
            }
        }
    }

    /* compiled from: CrashlyticsCore */
    class C09744 implements Callable<Boolean> {
        final /* synthetic */ C0985f f2659a;

        C09744(C0985f c0985f) {
            this.f2659a = c0985f;
        }

        public /* synthetic */ Object call() {
            return m4841a();
        }

        public Boolean m4841a() {
            return Boolean.valueOf(this.f2659a.f2680k.m4902b());
        }
    }

    /* compiled from: CrashlyticsCore */
    class C09755 implements C0128b<Boolean> {
        final /* synthetic */ C0985f f2660a;

        C09755(C0985f c0985f) {
            this.f2660a = c0985f;
        }

        public /* synthetic */ Object mo734b(C0131t c0131t) {
            return m4842a(c0131t);
        }

        public Boolean m4842a(C0131t c0131t) {
            boolean z = false;
            if (!c0131t.f288d.f255a) {
                return Boolean.valueOf(false);
            }
            if (!this.f2660a.m4895y()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: CrashlyticsCore */
    class C09766 implements C0128b<Boolean> {
        final /* synthetic */ C0985f f2661a;

        C09766(C0985f c0985f) {
            this.f2661a = c0985f;
        }

        public /* synthetic */ Object mo734b(C0131t c0131t) {
            return m4844a(c0131t);
        }

        public Boolean m4844a(C0131t c0131t) {
            boolean z = true;
            Activity b = this.f2661a.m497F().m475b();
            if (!(b == null || b.isFinishing() || !this.f2661a.m4894x())) {
                z = this.f2661a.m4860a(b, c0131t.f287c);
            }
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: CrashlyticsCore */
    private static final class C0981a implements Callable<Boolean> {
        private final C0989h f2670a;

        public /* synthetic */ Object call() {
            return m4846a();
        }

        public C0981a(C0989h c0989h) {
            this.f2670a = c0989h;
        }

        public Boolean m4846a() {
            if (!this.f2670a.m4902b()) {
                return Boolean.FALSE;
            }
            C0142c.m468h().mo46a("CrashlyticsCore", "Found previous crash marker.");
            this.f2670a.m4903c();
            return Boolean.TRUE;
        }
    }

    /* compiled from: CrashlyticsCore */
    private static final class C0983b implements C0982i {
        private C0983b() {
        }

        public void mo735a() {
        }
    }

    /* compiled from: CrashlyticsCore */
    private static class C0984c {
        private boolean f2671a;
        private final CountDownLatch f2672b;

        private C0984c() {
            this.f2671a = false;
            this.f2672b = new CountDownLatch(1);
        }

        void m4849a(boolean z) {
            this.f2671a = z;
            this.f2672b.countDown();
        }

        boolean m4850a() {
            return this.f2671a;
        }

        void m4851b() {
            try {
                this.f2672b.await();
            } catch (InterruptedException e) {
            }
        }
    }

    protected /* synthetic */ Object mo67f() {
        return m4875d();
    }

    public C0985f() {
        this(1.0f, null, null, false);
    }

    C0985f(float f, C0982i c0982i, C1033w c1033w, boolean z) {
        this(f, c0982i, c1033w, z, C0031n.m103a("Crashlytics Exception Handler"));
    }

    C0985f(float f, C0982i c0982i, C1033w c1033w, boolean z, ExecutorService executorService) {
        this.f2684o = null;
        this.f2685p = null;
        this.f2686q = null;
        this.f2693x = f;
        if (c0982i == null) {
            c0982i = new C0983b();
        }
        this.f2682m = c0982i;
        this.f2695z = c1033w;
        this.f2694y = z;
        this.f2674B = new C0988g(executorService);
        this.f2677b = new ConcurrentHashMap();
        this.f2676a = System.currentTimeMillis();
    }

    protected boolean a_() {
        return m4873a(super.m496E());
    }

    boolean m4873a(Context context) {
        if (this.f2694y) {
            return false;
        }
        this.f2689t = new C0018g().m46a(context);
        if (this.f2689t == null) {
            return false;
        }
        C0142c.m468h().mo50c("CrashlyticsCore", "Initializing Crashlytics " + mo64a());
        this.f2679d = new C0104b(this);
        this.f2681l = new C0989h("crash_marker", this.f2679d);
        this.f2680k = new C0989h("initialization_marker", this.f2679d);
        try {
            m4857a(context, this.f2689t);
            ac c1017t = new C1017t(context, m4878h());
            boolean u = m4891u();
            m4854K();
            m4858a(c1017t);
            if (!u || !C0021i.m94n(context)) {
                return true;
            }
            m4853J();
            return false;
        } catch (Throwable e) {
            throw new C0074m(e);
        } catch (Throwable e2) {
            C0142c.m468h().mo54e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e2);
            return false;
        }
    }

    private void m4857a(Context context, String str) {
        C0100g c0991k = this.f2695z != null ? new C0991k(this.f2695z) : null;
        this.f2673A = new C0089b(C0142c.m468h());
        this.f2673A.mo29a(c0991k);
        this.f2688s = context.getPackageName();
        this.f2690u = m495D().m121j();
        C0142c.m468h().mo46a("CrashlyticsCore", "Installer package name is: " + this.f2690u);
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.f2688s, 0);
        this.f2691v = Integer.toString(packageInfo.versionCode);
        this.f2692w = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
        this.f2687r = C0021i.m93m(context);
        m4868a(this.f2687r, C0985f.m4865b(context)).m4732a(str, this.f2688s);
    }

    private void m4858a(ac acVar) {
        try {
            C0142c.m468h().mo46a("CrashlyticsCore", "Installing exception handler...");
            this.f2683n = new C1005l(Thread.getDefaultUncaughtExceptionHandler(), this.f2674B, m495D(), acVar, this.f2679d, this);
            this.f2683n.m4963b();
            Thread.setDefaultUncaughtExceptionHandler(this.f2683n);
            C0142c.m468h().mo46a("CrashlyticsCore", "Successfully installed exception handler.");
        } catch (Throwable e) {
            C0142c.m468h().mo54e("CrashlyticsCore", "There was a problem installing the exception handler.", e);
        }
    }

    protected Void m4875d() {
        m4889s();
        this.f2683n.m4968g();
        try {
            C0131t b = C0129q.m415a().m419b();
            if (b == null) {
                C0142c.m468h().mo51d("CrashlyticsCore", "Received null settings, skipping initialization!");
            } else if (b.f288d.f257c) {
                this.f2683n.m4964c();
                C1007n a = m4869a(b);
                if (a == null) {
                    C0142c.m468h().mo51d("CrashlyticsCore", "Unable to create a call to upload reports.");
                    m4890t();
                } else {
                    new C1038z(a).m5054a(this.f2693x);
                    m4890t();
                }
            } else {
                C0142c.m468h().mo46a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                m4890t();
            }
        } catch (Throwable e) {
            C0142c.m468h().mo54e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            m4890t();
        }
        return null;
    }

    public String mo66b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String mo64a() {
        return "2.3.10.127";
    }

    public static C0985f m4866e() {
        return (C0985f) C0142c.m460a(C0985f.class);
    }

    public void m4871a(Throwable th) {
        if (this.f2694y || !C0985f.m4862a("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            C0142c.m468h().mo45a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.f2683n.m4960a(Thread.currentThread(), th);
        }
    }

    static void m4859a(String str, String str2) {
        C0908a c0908a = (C0908a) C0142c.m460a(C0908a.class);
        if (c0908a != null) {
            c0908a.m4597a(new C0024b(str, str2));
        }
    }

    static void m4864b(String str, String str2) {
        C0908a c0908a = (C0908a) C0142c.m460a(C0908a.class);
        if (c0908a != null) {
            c0908a.m4596a(new C0023a(str, str2));
        }
    }

    Map<String, String> m4877g() {
        return Collections.unmodifiableMap(this.f2677b);
    }

    C0963a m4868a(String str, boolean z) {
        return new C0963a(str, z);
    }

    String m4878h() {
        return this.f2688s;
    }

    String m4879i() {
        return this.f2689t;
    }

    String m4880j() {
        return this.f2690u;
    }

    String m4881k() {
        return this.f2692w;
    }

    String m4882l() {
        return this.f2691v;
    }

    String m4883m() {
        return C0021i.m78b(m496E(), "com.crashlytics.ApiEndpoint");
    }

    String m4884n() {
        return this.f2687r;
    }

    C1005l m4885o() {
        return this.f2683n;
    }

    String m4886p() {
        return m495D().m112a() ? this.f2684o : null;
    }

    String m4887q() {
        return m495D().m112a() ? this.f2685p : null;
    }

    String m4888r() {
        return m495D().m112a() ? this.f2686q : null;
    }

    private void m4853J() {
        Callable c09711 = new C09711(this);
        for (C0065l a : m500I()) {
            c09711.m224a(a);
        }
        Future submit = m497F().m480f().submit(c09711);
        C0142c.m468h().mo46a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            C0142c.m468h().mo54e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            C0142c.m468h().mo54e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            C0142c.m468h().mo54e("CrashlyticsCore", "Crashlytics timed out during initialization.", e22);
        }
    }

    void m4889s() {
        this.f2674B.m4897a(new C09722(this));
    }

    void m4890t() {
        this.f2674B.m4899b(new C09733(this));
    }

    boolean m4891u() {
        return ((Boolean) this.f2674B.m4897a(new C09744(this))).booleanValue();
    }

    C0958d m4892v() {
        if (this.f2675C != null) {
            return this.f2675C.m4731a();
        }
        return null;
    }

    File m4893w() {
        if (this.f2678c == null) {
            this.f2678c = new C0104b(this).mo34a();
        }
        return this.f2678c;
    }

    boolean m4894x() {
        return ((Boolean) C0129q.m415a().m418a(new C09755(this), Boolean.valueOf(false))).booleanValue();
    }

    boolean m4895y() {
        return new C0106d(this).mo35a().getBoolean("always_send_reports_opt_in", false);
    }

    @SuppressLint({"CommitPrefEdits"})
    void m4872a(boolean z) {
        C0105c c0106d = new C0106d(this);
        c0106d.mo36a(c0106d.mo37b().putBoolean("always_send_reports_opt_in", z));
    }

    boolean m4896z() {
        return ((Boolean) C0129q.m415a().m418a(new C09766(this), Boolean.valueOf(true))).booleanValue();
    }

    C1007n m4869a(C0131t c0131t) {
        if (c0131t != null) {
            return new C1008o(this, m4883m(), c0131t.f285a.f242d, this.f2673A);
        }
        return null;
    }

    private void m4854K() {
        if (Boolean.TRUE.equals((Boolean) this.f2674B.m4897a(new C0981a(this.f2681l)))) {
            try {
                this.f2682m.mo735a();
            } catch (Throwable e) {
                C0142c.m468h().mo54e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void m4867A() {
        this.f2681l.m4901a();
    }

    private boolean m4860a(Activity activity, C0124o c0124o) {
        final C1012q c1012q = new C1012q(activity, c0124o);
        final C0984c c0984c = new C0984c();
        final Activity activity2 = activity;
        final C0124o c0124o2 = c0124o;
        activity.runOnUiThread(new Runnable(this) {
            final /* synthetic */ C0985f f2669e;

            /* compiled from: CrashlyticsCore */
            class C09771 implements OnClickListener {
                final /* synthetic */ C09807 f2662a;

                C09771(C09807 c09807) {
                    this.f2662a = c09807;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    c0984c.m4849a(true);
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: CrashlyticsCore */
            class C09782 implements OnClickListener {
                final /* synthetic */ C09807 f2663a;

                C09782(C09807 c09807) {
                    this.f2663a = c09807;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    c0984c.m4849a(false);
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: CrashlyticsCore */
            class C09793 implements OnClickListener {
                final /* synthetic */ C09807 f2664a;

                C09793(C09807 c09807) {
                    this.f2664a = c09807;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f2664a.f2669e.m4872a(true);
                    c0984c.m4849a(true);
                    dialogInterface.dismiss();
                }
            }

            public void run() {
                Builder builder = new Builder(activity2);
                OnClickListener c09771 = new C09771(this);
                float f = activity2.getResources().getDisplayMetrics().density;
                int a = C0985f.m4863b(f, 5);
                View textView = new TextView(activity2);
                textView.setAutoLinkMask(15);
                textView.setText(c1012q.m4980b());
                textView.setTextAppearance(activity2, 16973892);
                textView.setPadding(a, a, a, a);
                textView.setFocusable(false);
                View scrollView = new ScrollView(activity2);
                scrollView.setPadding(C0985f.m4863b(f, 14), C0985f.m4863b(f, 2), C0985f.m4863b(f, 10), C0985f.m4863b(f, 12));
                scrollView.addView(textView);
                builder.setView(scrollView).setTitle(c1012q.m4979a()).setCancelable(false).setNeutralButton(c1012q.m4981c(), c09771);
                if (c0124o2.f266d) {
                    builder.setNegativeButton(c1012q.m4983e(), new C09782(this));
                }
                if (c0124o2.f268f) {
                    builder.setPositiveButton(c1012q.m4982d(), new C09793(this));
                }
                builder.show();
            }
        });
        C0142c.m468h().mo46a("CrashlyticsCore", "Waiting for user opt-in.");
        c0984c.m4851b();
        return c0984c.m4850a();
    }

    static C0125p m4852B() {
        C0131t b = C0129q.m415a().m419b();
        return b == null ? null : b.f286b;
    }

    private static boolean m4865b(Context context) {
        return C0021i.m74a(context, "com.crashlytics.RequireBuildId", true);
    }

    private static boolean m4862a(String str) {
        C0985f e = C0985f.m4866e();
        if (e != null && e.f2683n != null) {
            return true;
        }
        C0142c.m468h().mo54e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    private static int m4863b(float f, int i) {
        return (int) (((float) i) * f);
    }
}
