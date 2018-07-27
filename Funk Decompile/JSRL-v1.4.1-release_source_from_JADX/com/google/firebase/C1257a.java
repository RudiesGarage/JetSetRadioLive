package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.p018b.C0185a;
import android.support.v4.p024g.C0357a;
import android.util.Log;
import com.google.android.gms.common.internal.C1157b;
import com.google.android.gms.common.internal.C1211z;
import com.google.android.gms.common.util.C1228i;
import com.google.android.gms.common.util.C1229j;
import com.google.android.gms.p043b.C1051a;
import com.google.android.gms.p043b.C1065b;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class C1257a {
    static final Map<String, C1257a> f3238a = new C0357a();
    private static final List<String> f3239b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> f3240c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> f3241d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> f3242e = Arrays.asList(new String[0]);
    private static final Set<String> f3243f = Collections.emptySet();
    private static final Object f3244g = new Object();
    private final Context f3245h;
    private final String f3246i;
    private final C1258b f3247j;
    private final AtomicBoolean f3248k = new AtomicBoolean(false);
    private final AtomicBoolean f3249l = new AtomicBoolean();
    private final List<Object> f3250m = new CopyOnWriteArrayList();
    private final List<C1255a> f3251n = new CopyOnWriteArrayList();
    private final List<Object> f3252o = new CopyOnWriteArrayList();

    public interface C1255a {
        void m5770a(boolean z);
    }

    @TargetApi(24)
    private static class C1256b extends BroadcastReceiver {
        private static AtomicReference<C1256b> f3236a = new AtomicReference();
        private final Context f3237b;

        public C1256b(Context context) {
            this.f3237b = context;
        }

        private static void m5772b(Context context) {
            if (f3236a.get() == null) {
                BroadcastReceiver c1256b = new C1256b(context);
                if (f3236a.compareAndSet(null, c1256b)) {
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.USER_UNLOCKED");
                    intentFilter.addDataScheme("package");
                    context.registerReceiver(c1256b, intentFilter);
                }
            }
        }

        public void m5773a() {
            this.f3237b.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (C1257a.f3244g) {
                for (C1257a a : C1257a.f3238a.values()) {
                    a.m5786g();
                }
            }
            m5773a();
        }
    }

    protected C1257a(Context context, String str, C1258b c1258b) {
        this.f3245h = (Context) C1157b.m5369a((Object) context);
        this.f3246i = C1157b.m5371a(str);
        this.f3247j = (C1258b) C1157b.m5369a((Object) c1258b);
    }

    public static C1257a m5774a(Context context) {
        C1257a c;
        synchronized (f3244g) {
            if (f3238a.containsKey("[DEFAULT]")) {
                c = C1257a.m5783c();
            } else {
                C1258b a = C1258b.m5790a(context);
                if (a == null) {
                    c = null;
                } else {
                    c = C1257a.m5775a(context, a);
                }
            }
        }
        return c;
    }

    public static C1257a m5775a(Context context, C1258b c1258b) {
        return C1257a.m5776a(context, c1258b, "[DEFAULT]");
    }

    public static C1257a m5776a(Context context, C1258b c1258b, String str) {
        Object c1257a;
        C1065b a = C1065b.m5103a(context);
        C1257a.m5781b(context);
        String a2 = C1257a.m5777a(str);
        if (!(context instanceof Application)) {
            Object applicationContext = context.getApplicationContext();
        }
        synchronized (f3244g) {
            C1157b.m5374a(!f3238a.containsKey(a2), new StringBuilder(String.valueOf(a2).length() + 33).append("FirebaseApp name ").append(a2).append(" already exists!").toString());
            C1157b.m5370a(applicationContext, (Object) "Application context cannot be null.");
            c1257a = new C1257a(applicationContext, a2, c1258b);
            f3238a.put(a2, c1257a);
        }
        a.m5104a((C1257a) c1257a);
        c1257a.m5779a(C1257a.class, c1257a, f3239b);
        if (c1257a.m5789d()) {
            c1257a.m5779a(C1257a.class, c1257a, f3240c);
            c1257a.m5779a(Context.class, c1257a.m5787a(), f3241d);
        }
        return c1257a;
    }

    private static String m5777a(String str) {
        return str.trim();
    }

    private <T> void m5779a(Class<T> cls, T t, Iterable<String> iterable) {
        String valueOf;
        boolean a = C0185a.m613a(this.f3245h);
        if (a) {
            C1256b.m5772b(this.f3245h);
        }
        for (String valueOf2 : iterable) {
            if (a) {
                try {
                    if (!f3242e.contains(valueOf2)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (f3243f.contains(valueOf2)) {
                        throw new IllegalStateException(String.valueOf(valueOf2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(valueOf2).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(String.valueOf(valueOf2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (Throwable e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (Throwable e4) {
                    String str = "FirebaseApp";
                    String str2 = "Failed to initialize ";
                    valueOf2 = String.valueOf(valueOf2);
                    Log.wtf(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e4);
                }
            }
            Method method = Class.forName(valueOf2).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
    }

    public static void m5780a(boolean z) {
        synchronized (f3244g) {
            Iterator it = new ArrayList(f3238a.values()).iterator();
            while (it.hasNext()) {
                C1257a c1257a = (C1257a) it.next();
                if (c1257a.f3248k.get()) {
                    c1257a.m5782b(z);
                }
            }
        }
    }

    @TargetApi(14)
    private static void m5781b(Context context) {
        if (C1228i.m5687c() && (context.getApplicationContext() instanceof Application)) {
            C1051a.m5079a((Application) context.getApplicationContext());
        }
    }

    private void m5782b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (C1255a a : this.f3251n) {
            a.m5770a(z);
        }
    }

    public static C1257a m5783c() {
        C1257a c1257a;
        synchronized (f3244g) {
            c1257a = (C1257a) f3238a.get("[DEFAULT]");
            if (c1257a == null) {
                String valueOf = String.valueOf(C1229j.m5692a());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(valueOf).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return c1257a;
    }

    private void m5785f() {
        C1157b.m5374a(!this.f3249l.get(), (Object) "FirebaseApp was deleted");
    }

    private void m5786g() {
        m5779a(C1257a.class, (Object) this, f3239b);
        if (m5789d()) {
            m5779a(C1257a.class, (Object) this, f3240c);
            m5779a(Context.class, this.f3245h, f3241d);
        }
    }

    public Context m5787a() {
        m5785f();
        return this.f3245h;
    }

    public String m5788b() {
        m5785f();
        return this.f3246i;
    }

    public boolean m5789d() {
        return "[DEFAULT]".equals(m5788b());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof C1257a) ? false : this.f3246i.equals(((C1257a) obj).m5788b());
    }

    public int hashCode() {
        return this.f3246i.hashCode();
    }

    public String toString() {
        return C1211z.m5660a((Object) this).m5658a("name", this.f3246i).m5658a("options", this.f3247j).toString();
    }
}
