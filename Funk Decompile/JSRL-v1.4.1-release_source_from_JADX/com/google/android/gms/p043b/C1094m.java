package com.google.android.gms.p043b;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.C1147b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1133a;
import com.google.android.gms.common.api.C1133a.C1056a;
import com.google.android.gms.common.api.C1133a.C1059c;
import com.google.android.gms.common.api.C1133a.C1060f;
import com.google.android.gms.common.api.C1136c.C1085b;
import com.google.android.gms.common.api.C1136c.C1086c;
import com.google.android.gms.common.api.C1142j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1160i.C1092f;
import com.google.android.gms.common.internal.C1162e;
import com.google.android.gms.common.util.C1220a;
import com.google.android.gms.p043b.C1069d.C1071b;
import com.google.android.gms.p043b.C1098q.C1097a;
import com.google.android.gms.p044c.C1116b;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class C1094m implements Callback {
    public static final Status f2910a = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status f2911b = new Status(4, "The user must be signed in to make this API call.");
    private static final Object f2912f = new Object();
    private static C1094m f2913g;
    private long f2914c;
    private long f2915d;
    private long f2916e;
    private final Context f2917h;
    private final C1147b f2918i;
    private int f2919j;
    private final AtomicInteger f2920k;
    private final AtomicInteger f2921l;
    private final Map<C1072e<?>, C1091a<?>> f2922m;
    private C1090l f2923n;
    private final Set<C1072e<?>> f2924o;
    private final Set<C1072e<?>> f2925p;
    private final Handler f2926q;

    class C1091a<O extends C1056a> implements C1088j, C1085b, C1086c {
        final /* synthetic */ C1094m f2896a;
        private final Queue<C1069d> f2897b = new LinkedList();
        private final C1060f f2898c;
        private final C1059c f2899d;
        private final C1072e<O> f2900e;
        private final C1089k f2901f;
        private final Set<C1073f> f2902g = new HashSet();
        private final Map<C1097a<?>, C1101t> f2903h = new HashMap();
        private final int f2904i;
        private boolean f2905j;
        private ConnectionResult f2906k = null;

        public C1091a(C1094m c1094m, C1142j<O> c1142j) {
            this.f2896a = c1094m;
            if (c1142j.m5303a()) {
                this.f2898c = c1142j.m5304b();
                c1142j.m5305c().m5156a((C1088j) this);
            } else {
                this.f2898c = c1142j.m5302a(c1094m.f2926q.getLooper(), this, this);
            }
            if (this.f2898c instanceof C1162e) {
                this.f2899d = ((C1162e) this.f2898c).mo788h();
            } else {
                this.f2899d = this.f2898c;
            }
            this.f2900e = c1142j.m5306d();
            this.f2901f = new C1089k();
            this.f2904i = c1142j.m5307e();
        }

        private void m5167a(Status status) {
            for (C1069d a : this.f2897b) {
                a.mo756a(status);
            }
            this.f2897b.clear();
        }

        private void m5168b(C1069d c1069d) {
            c1069d.mo754a(this.f2901f, m5192h());
            try {
                c1069d.mo755a(this);
            } catch (DeadObjectException e) {
                mo759a(1);
                this.f2898c.m5087a();
            }
        }

        private void m5170b(ConnectionResult connectionResult) {
            for (C1073f a : this.f2902g) {
                a.m5127a(this.f2900e, connectionResult);
            }
            this.f2902g.clear();
        }

        private void m5173j() {
            if (this.f2905j) {
                m5178o();
            }
        }

        private void m5174k() {
            if (this.f2905j) {
                this.f2896a.f2926q.removeMessages(9, this.f2900e);
                this.f2896a.f2926q.removeMessages(7, this.f2900e);
                this.f2905j = false;
            }
        }

        private void m5175l() {
            if (this.f2905j) {
                m5174k();
                m5167a(this.f2896a.f2918i.mo773a(this.f2896a.f2917h) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f2898c.m5087a();
            }
        }

        private void m5176m() {
            this.f2896a.f2926q.removeMessages(10, this.f2900e);
            this.f2896a.f2926q.sendMessageDelayed(this.f2896a.f2926q.obtainMessage(10, this.f2900e), this.f2896a.f2916e);
        }

        private void m5177n() {
            if (!this.f2898c.m5090b() || this.f2903h.size() != 0) {
                return;
            }
            if (this.f2901f.m5160a()) {
                m5176m();
            } else {
                this.f2898c.m5087a();
            }
        }

        private void m5178o() {
            if (!this.f2898c.m5090b() && !this.f2898c.m5091c()) {
                if (this.f2898c.m5093e() && this.f2896a.f2919j != 0) {
                    this.f2896a.f2919j = this.f2896a.f2918i.mo773a(this.f2896a.f2917h);
                    if (this.f2896a.f2919j != 0) {
                        mo761a(new ConnectionResult(this.f2896a.f2919j, null));
                        return;
                    }
                }
                if (this.f2898c.mo866d()) {
                    this.f2898c.m5088a(new C1093b(this.f2896a, this.f2898c, this.f2900e));
                } else {
                    this.f2898c.m5088a(new C1093b(this.f2896a, this.f2898c, this.f2900e));
                }
            }
        }

        public void m5179a() {
            while (this.f2898c.m5090b() && !this.f2897b.isEmpty()) {
                m5168b((C1069d) this.f2897b.remove());
            }
        }

        public void mo759a(int i) {
            m5189e();
            this.f2905j = true;
            this.f2901f.m5162c();
            this.f2896a.f2926q.sendMessageDelayed(Message.obtain(this.f2896a.f2926q, 7, this.f2900e), this.f2896a.f2914c);
            this.f2896a.f2926q.sendMessageDelayed(Message.obtain(this.f2896a.f2926q, 9, this.f2900e), this.f2896a.f2915d);
            this.f2896a.f2919j = -1;
        }

        public void mo760a(Bundle bundle) {
            m5189e();
            m5170b(ConnectionResult.f2960a);
            m5174k();
            for (C1101t c1101t : this.f2903h.values()) {
                try {
                    c1101t.f2936a.m5225a(this.f2899d, new C1116b());
                } catch (DeadObjectException e) {
                    mo759a(1);
                    this.f2898c.m5087a();
                }
            }
            m5179a();
            m5176m();
        }

        public void m5182a(C1069d c1069d) {
            if (this.f2898c.m5090b()) {
                m5168b(c1069d);
                m5176m();
                return;
            }
            this.f2897b.add(c1069d);
            if (this.f2906k == null || !this.f2906k.m5259a()) {
                m5178o();
            } else {
                mo761a(this.f2906k);
            }
        }

        public void m5183a(C1073f c1073f) {
            this.f2902g.add(c1073f);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo761a(com.google.android.gms.common.ConnectionResult r6) {
            /*
            r5 = this;
            r5.m5189e();
            r0 = r5.f2896a;
            r1 = -1;
            r0.f2919j = r1;
            r5.m5170b(r6);
            r0 = r6.m5261c();
            r1 = 4;
            if (r0 != r1) goto L_0x001b;
        L_0x0013:
            r0 = com.google.android.gms.p043b.C1094m.f2911b;
            r5.m5167a(r0);
        L_0x001a:
            return;
        L_0x001b:
            r0 = r5.f2897b;
            r0 = r0.isEmpty();
            if (r0 == 0) goto L_0x0026;
        L_0x0023:
            r5.f2906k = r6;
            goto L_0x001a;
        L_0x0026:
            r1 = com.google.android.gms.p043b.C1094m.f2912f;
            monitor-enter(r1);
            r0 = r5.f2896a;	 Catch:{ all -> 0x004e }
            r0 = r0.f2923n;	 Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0051;
        L_0x0033:
            r0 = r5.f2896a;	 Catch:{ all -> 0x004e }
            r0 = r0.f2924o;	 Catch:{ all -> 0x004e }
            r2 = r5.f2900e;	 Catch:{ all -> 0x004e }
            r0 = r0.contains(r2);	 Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0051;
        L_0x0041:
            r0 = r5.f2896a;	 Catch:{ all -> 0x004e }
            r0 = r0.f2923n;	 Catch:{ all -> 0x004e }
            r2 = r5.f2904i;	 Catch:{ all -> 0x004e }
            r0.m5136b(r6, r2);	 Catch:{ all -> 0x004e }
            monitor-exit(r1);	 Catch:{ all -> 0x004e }
            goto L_0x001a;
        L_0x004e:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x004e }
            throw r0;
        L_0x0051:
            monitor-exit(r1);	 Catch:{ all -> 0x004e }
            r0 = r5.f2896a;
            r1 = r5.f2904i;
            r0 = r0.m5216a(r6, r1);
            if (r0 != 0) goto L_0x001a;
        L_0x005c:
            r0 = r6.m5261c();
            r1 = 18;
            if (r0 != r1) goto L_0x0067;
        L_0x0064:
            r0 = 1;
            r5.f2905j = r0;
        L_0x0067:
            r0 = r5.f2905j;
            if (r0 == 0) goto L_0x0088;
        L_0x006b:
            r0 = r5.f2896a;
            r0 = r0.f2926q;
            r1 = r5.f2896a;
            r1 = r1.f2926q;
            r2 = 7;
            r3 = r5.f2900e;
            r1 = android.os.Message.obtain(r1, r2, r3);
            r2 = r5.f2896a;
            r2 = r2.f2914c;
            r0.sendMessageDelayed(r1, r2);
            goto L_0x001a;
        L_0x0088:
            r0 = new com.google.android.gms.common.api.Status;
            r1 = 17;
            r2 = r5.f2900e;
            r2 = r2.m5125a();
            r2 = java.lang.String.valueOf(r2);
            r3 = new java.lang.StringBuilder;
            r4 = java.lang.String.valueOf(r2);
            r4 = r4.length();
            r4 = r4 + 38;
            r3.<init>(r4);
            r4 = "API: ";
            r3 = r3.append(r4);
            r2 = r3.append(r2);
            r3 = " is not available on this device.";
            r2 = r2.append(r3);
            r2 = r2.toString();
            r0.<init>(r1, r2);
            r5.m5167a(r0);
            goto L_0x001a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.m.a.a(com.google.android.gms.common.ConnectionResult):void");
        }

        public void mo764a(ConnectionResult connectionResult, C1133a<?> c1133a, int i) {
            mo761a(connectionResult);
        }

        public void m5186b() {
            m5167a(C1094m.f2910a);
            this.f2901f.m5161b();
            for (C1097a c1071b : this.f2903h.keySet()) {
                m5182a(new C1071b(c1071b, new C1116b()));
            }
            this.f2898c.m5087a();
        }

        public C1060f m5187c() {
            return this.f2898c;
        }

        public Map<C1097a<?>, C1101t> m5188d() {
            return this.f2903h;
        }

        public void m5189e() {
            this.f2906k = null;
        }

        ConnectionResult m5190f() {
            return this.f2906k;
        }

        boolean m5191g() {
            return this.f2898c.m5090b();
        }

        public boolean m5192h() {
            return this.f2898c.mo866d();
        }

        public int m5193i() {
            return this.f2904i;
        }
    }

    private class C1093b implements C1092f {
        final /* synthetic */ C1094m f2907a;
        private final C1060f f2908b;
        private final C1072e<?> f2909c;

        public C1093b(C1094m c1094m, C1060f c1060f, C1072e<?> c1072e) {
            this.f2907a = c1094m;
            this.f2908b = c1060f;
            this.f2909c = c1072e;
        }

        public void mo765a(ConnectionResult connectionResult) {
            if (!connectionResult.m5260b()) {
                ((C1091a) this.f2907a.f2922m.get(this.f2909c)).mo761a(connectionResult);
            } else if (!this.f2908b.mo866d()) {
                this.f2908b.m5089a(null, Collections.emptySet());
            }
        }
    }

    private C1094m(Context context) {
        this(context, C1147b.m5323a());
    }

    private C1094m(Context context, C1147b c1147b) {
        this.f2914c = 5000;
        this.f2915d = 120000;
        this.f2916e = 10000;
        this.f2919j = -1;
        this.f2920k = new AtomicInteger(1);
        this.f2921l = new AtomicInteger(0);
        this.f2922m = new ConcurrentHashMap(5, 0.75f, 1);
        this.f2923n = null;
        this.f2924o = new C1220a();
        this.f2925p = new C1220a();
        this.f2917h = context;
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        this.f2926q = new Handler(handlerThread.getLooper(), this);
        this.f2918i = c1147b;
    }

    public static C1094m m5198a(Context context) {
        C1094m c1094m;
        synchronized (f2912f) {
            if (f2913g == null) {
                f2913g = new C1094m(context.getApplicationContext());
            }
            c1094m = f2913g;
        }
        return c1094m;
    }

    private void m5199a(int i, ConnectionResult connectionResult) {
        for (C1091a c1091a : this.f2922m.values()) {
            if (c1091a.m5193i() == i) {
                break;
            }
        }
        C1091a c1091a2 = null;
        if (c1091a2 != null) {
            String valueOf = String.valueOf(this.f2918i.mo778b(connectionResult.m5261c()));
            String valueOf2 = String.valueOf(connectionResult.m5263e());
            c1091a2.m5167a(new Status(17, new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(valueOf2).length()).append("Error resolution was canceled by the user, original error message: ").append(valueOf).append(": ").append(valueOf2).toString()));
            return;
        }
        Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
    }

    private void m5200a(C1099r c1099r) {
        C1091a c1091a = (C1091a) this.f2922m.get(c1099r.f2934c.m5306d());
        if (c1091a == null) {
            m5201a(c1099r.f2934c);
            c1091a = (C1091a) this.f2922m.get(c1099r.f2934c.m5306d());
        }
        if (!c1091a.m5192h() || this.f2921l.get() == c1099r.f2933b) {
            c1091a.m5182a(c1099r.f2932a);
            return;
        }
        c1099r.f2932a.mo756a(f2910a);
        c1091a.m5186b();
    }

    private void m5201a(C1142j<?> c1142j) {
        C1072e d = c1142j.m5306d();
        if (!this.f2922m.containsKey(d)) {
            this.f2922m.put(d, new C1091a(this, c1142j));
        }
        C1091a c1091a = (C1091a) this.f2922m.get(d);
        if (c1091a.m5192h()) {
            this.f2925p.add(d);
        }
        c1091a.m5178o();
    }

    private void m5208e() {
        for (C1091a c1091a : this.f2922m.values()) {
            c1091a.m5189e();
            c1091a.m5178o();
        }
    }

    public void m5214a() {
        this.f2926q.sendMessage(this.f2926q.obtainMessage(2));
    }

    public void m5215a(C1073f c1073f) {
        for (C1072e c1072e : c1073f.m5126a()) {
            C1091a c1091a = (C1091a) this.f2922m.get(c1072e);
            if (c1091a == null) {
                c1073f.m5127a(c1072e, new ConnectionResult(13));
                return;
            } else if (c1091a.m5191g()) {
                c1073f.m5127a(c1072e, ConnectionResult.f2960a);
            } else if (c1091a.m5190f() != null) {
                c1073f.m5127a(c1072e, c1091a.m5190f());
            } else {
                c1091a.m5183a(c1073f);
            }
        }
    }

    boolean m5216a(ConnectionResult connectionResult, int i) {
        if (!connectionResult.m5259a() && !this.f2918i.mo776a(connectionResult.m5261c())) {
            return false;
        }
        this.f2918i.m5336a(this.f2917h, connectionResult, i);
        return true;
    }

    public void m5217b() {
        for (C1072e remove : this.f2925p) {
            ((C1091a) this.f2922m.remove(remove)).m5186b();
        }
        this.f2925p.clear();
    }

    public void m5218b(ConnectionResult connectionResult, int i) {
        if (!m5216a(connectionResult, i)) {
            this.f2926q.sendMessage(this.f2926q.obtainMessage(4, i, 0, connectionResult));
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                m5215a((C1073f) message.obj);
                break;
            case 2:
                m5208e();
                break;
            case 3:
            case 6:
            case 11:
                m5200a((C1099r) message.obj);
                break;
            case 4:
                m5199a(message.arg1, (ConnectionResult) message.obj);
                break;
            case 5:
                m5201a((C1142j) message.obj);
                break;
            case 7:
                if (this.f2922m.containsKey(message.obj)) {
                    ((C1091a) this.f2922m.get(message.obj)).m5173j();
                    break;
                }
                break;
            case 8:
                m5217b();
                break;
            case 9:
                if (this.f2922m.containsKey(message.obj)) {
                    ((C1091a) this.f2922m.get(message.obj)).m5175l();
                    break;
                }
                break;
            case 10:
                if (this.f2922m.containsKey(message.obj)) {
                    ((C1091a) this.f2922m.get(message.obj)).m5177n();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }
}
