package p000a.p001a.p002a.p003a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p002a.p003a.C0135a.C0002b;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o;
import p000a.p001a.p002a.p003a.p004a.p007c.C0062d;
import p000a.p001a.p002a.p003a.p004a.p007c.C0073k;
import p000a.p001a.p002a.p003a.p004a.p007c.C0074m;

/* compiled from: Fabric */
public class C0142c {
    static volatile C0142c f324a;
    static final C0136l f325b = new C0137b();
    final C0136l f326c;
    final boolean f327d;
    private final Context f328e;
    private final Map<Class<? extends C0149i>, C0149i> f329f;
    private final ExecutorService f330g;
    private final Handler f331h;
    private final C0139f<C0142c> f332i;
    private final C0139f<?> f333j;
    private final C0033o f334k;
    private C0135a f335l;
    private WeakReference<Activity> f336m;
    private AtomicBoolean f337n = new AtomicBoolean(false);

    /* compiled from: Fabric */
    class C01381 extends C0002b {
        final /* synthetic */ C0142c f310a;

        C01381(C0142c c0142c) {
            this.f310a = c0142c;
        }

        public void mo56a(Activity activity, Bundle bundle) {
            this.f310a.m471a(activity);
        }

        public void mo55a(Activity activity) {
            this.f310a.m471a(activity);
        }

        public void mo57b(Activity activity) {
            this.f310a.m471a(activity);
        }
    }

    /* compiled from: Fabric */
    public static class C0141a {
        private final Context f315a;
        private C0149i[] f316b;
        private C0073k f317c;
        private Handler f318d;
        private C0136l f319e;
        private boolean f320f;
        private String f321g;
        private String f322h;
        private C0139f<C0142c> f323i;

        public C0141a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f315a = context.getApplicationContext();
        }

        public C0141a m456a(C0149i... c0149iArr) {
            if (this.f316b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.f316b = c0149iArr;
            return this;
        }

        public C0142c m457a() {
            Map hashMap;
            if (this.f317c == null) {
                this.f317c = C0073k.m232a();
            }
            if (this.f318d == null) {
                this.f318d = new Handler(Looper.getMainLooper());
            }
            if (this.f319e == null) {
                if (this.f320f) {
                    this.f319e = new C0137b(3);
                } else {
                    this.f319e = new C0137b();
                }
            }
            if (this.f322h == null) {
                this.f322h = this.f315a.getPackageName();
            }
            if (this.f323i == null) {
                this.f323i = C0139f.f311d;
            }
            if (this.f316b == null) {
                hashMap = new HashMap();
            } else {
                hashMap = C0142c.m465b(Arrays.asList(this.f316b));
            }
            return new C0142c(this.f315a, hashMap, this.f317c, this.f318d, this.f319e, this.f320f, this.f323i, new C0033o(this.f315a, this.f322h, this.f321g, hashMap.values()));
        }
    }

    static C0142c m458a() {
        if (f324a != null) {
            return f324a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    C0142c(Context context, Map<Class<? extends C0149i>, C0149i> map, C0073k c0073k, Handler handler, C0136l c0136l, boolean z, C0139f c0139f, C0033o c0033o) {
        this.f328e = context;
        this.f329f = map;
        this.f330g = c0073k;
        this.f331h = handler;
        this.f326c = c0136l;
        this.f327d = z;
        this.f332i = c0139f;
        this.f333j = m472a(map.size());
        this.f334k = c0033o;
    }

    public static C0142c m459a(Context context, C0149i... c0149iArr) {
        if (f324a == null) {
            synchronized (C0142c.class) {
                if (f324a == null) {
                    C0142c.m467c(new C0141a(context).m456a(c0149iArr).m457a());
                }
            }
        }
        return f324a;
    }

    private static void m467c(C0142c c0142c) {
        f324a = c0142c;
        c0142c.m470j();
    }

    public C0142c m471a(Activity activity) {
        this.f336m = new WeakReference(activity);
        return this;
    }

    public Activity m475b() {
        if (this.f336m != null) {
            return (Activity) this.f336m.get();
        }
        return null;
    }

    private void m470j() {
        m471a(m466c(this.f328e));
        this.f335l = new C0135a(this.f328e);
        this.f335l.m425a(new C01381(this));
        m473a(this.f328e);
    }

    public String m477c() {
        return "1.3.12.127";
    }

    public String m478d() {
        return "io.fabric.sdk.android:fabric";
    }

    void m473a(Context context) {
        StringBuilder append;
        Future b = m476b(context);
        Collection g = m481g();
        C0152m c0152m = new C0152m(b, g);
        List<C0149i> arrayList = new ArrayList(g);
        Collections.sort(arrayList);
        c0152m.m503a(context, this, C0139f.f311d, this.f334k);
        for (C0149i a : arrayList) {
            a.m503a(context, this, this.f333j, this.f334k);
        }
        c0152m.m494C();
        if (C0142c.m468h().mo48a("Fabric", 3)) {
            append = new StringBuilder("Initializing ").append(m478d()).append(" [Version: ").append(m477c()).append("], with the following kits:\n");
        } else {
            append = null;
        }
        for (C0149i a2 : arrayList) {
            a2.f343f.m213a(c0152m.f);
            m474a(this.f329f, a2);
            a2.m494C();
            if (append != null) {
                append.append(a2.mo66b()).append(" [Version: ").append(a2.mo64a()).append("]\n");
            }
        }
        if (append != null) {
            C0142c.m468h().mo46a("Fabric", append.toString());
        }
    }

    void m474a(Map<Class<? extends C0149i>, C0149i> map, C0149i c0149i) {
        C0062d c0062d = c0149i.f347j;
        if (c0062d != null) {
            for (Class cls : c0062d.m195a()) {
                if (cls.isInterface()) {
                    for (C0149i c0149i2 : map.values()) {
                        if (cls.isAssignableFrom(c0149i2.getClass())) {
                            c0149i.f343f.m213a(c0149i2.f343f);
                        }
                    }
                } else if (((C0149i) map.get(cls)) == null) {
                    throw new C0074m("Referenced Kit was null, does the kit exist?");
                } else {
                    c0149i.f343f.m213a(((C0149i) map.get(cls)).f343f);
                }
            }
        }
    }

    private Activity m466c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public C0135a m479e() {
        return this.f335l;
    }

    public ExecutorService m480f() {
        return this.f330g;
    }

    public Collection<C0149i> m481g() {
        return this.f329f.values();
    }

    public static <T extends C0149i> T m460a(Class<T> cls) {
        return (C0149i) C0142c.m458a().f329f.get(cls);
    }

    public static C0136l m468h() {
        if (f324a == null) {
            return f325b;
        }
        return f324a.f326c;
    }

    public static boolean m469i() {
        if (f324a == null) {
            return false;
        }
        return f324a.f327d;
    }

    private static Map<Class<? extends C0149i>, C0149i> m465b(Collection<? extends C0149i> collection) {
        Map hashMap = new HashMap(collection.size());
        C0142c.m463a(hashMap, (Collection) collection);
        return hashMap;
    }

    private static void m463a(Map<Class<? extends C0149i>, C0149i> map, Collection<? extends C0149i> collection) {
        for (C0149i c0149i : collection) {
            map.put(c0149i.getClass(), c0149i);
            if (c0149i instanceof C0150j) {
                C0142c.m463a((Map) map, ((C0150j) c0149i).mo726c());
            }
        }
    }

    C0139f<?> m472a(final int i) {
        return new C0139f(this) {
            final CountDownLatch f312a = new CountDownLatch(i);
            final /* synthetic */ C0142c f314c;

            public void mo59a(Object obj) {
                this.f312a.countDown();
                if (this.f312a.getCount() == 0) {
                    this.f314c.f337n.set(true);
                    this.f314c.f332i.mo59a(this.f314c);
                }
            }

            public void mo58a(Exception exception) {
                this.f314c.f332i.mo58a(exception);
            }
        };
    }

    Future<Map<String, C0151k>> m476b(Context context) {
        return m480f().submit(new C0144e(context.getPackageCodePath()));
    }
}
