package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C1146i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1171u.C1172a;
import com.google.android.gms.common.internal.C1201v.C1203a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class C1160i<T extends IInterface> {
    public static final String[] f3085d = new String[]{"service_esmobile", "service_googleme"};
    final Handler f3086a;
    protected C1092f f3087b;
    protected AtomicInteger f3088c = new AtomicInteger(0);
    private int f3089e;
    private long f3090f;
    private long f3091g;
    private int f3092h;
    private long f3093i;
    private final Context f3094j;
    private final Looper f3095k;
    private final C1187o f3096l;
    private final C1146i f3097m;
    private final Object f3098n = new Object();
    private final Object f3099o = new Object();
    private C1201v f3100p;
    private T f3101q;
    private final ArrayList<C1166e<?>> f3102r = new ArrayList();
    private C1174h f3103s;
    private int f3104t = 1;
    private final C1168b f3105u;
    private final C1169c f3106v;
    private final int f3107w;
    private final String f3108x;

    public interface C1092f {
        void mo765a(ConnectionResult connectionResult);
    }

    protected abstract class C1166e<TListener> {
        private TListener f3115a;
        private boolean f3116b = false;
        final /* synthetic */ C1160i f3117d;

        public C1166e(C1160i c1160i, TListener tListener) {
            this.f3117d = c1160i;
            this.f3115a = tListener;
        }

        protected abstract void mo789a(TListener tListener);

        protected abstract void mo790b();

        public void m5441c() {
            synchronized (this) {
                Object obj = this.f3115a;
                if (this.f3116b) {
                    String valueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (obj != null) {
                try {
                    mo789a(obj);
                } catch (RuntimeException e) {
                    mo790b();
                    throw e;
                }
            }
            mo790b();
            synchronized (this) {
                this.f3116b = true;
            }
            m5442d();
        }

        public void m5442d() {
            m5443e();
            synchronized (this.f3117d.f3102r) {
                this.f3117d.f3102r.remove(this);
            }
        }

        public void m5443e() {
            synchronized (this) {
                this.f3115a = null;
            }
        }
    }

    private abstract class C1167a extends C1166e<Boolean> {
        public final int f3118a;
        public final Bundle f3119b;
        final /* synthetic */ C1160i f3120c;

        protected C1167a(C1160i c1160i, int i, Bundle bundle) {
            this.f3120c = c1160i;
            super(c1160i, Boolean.valueOf(true));
            this.f3118a = i;
            this.f3119b = bundle;
        }

        protected abstract void mo793a(ConnectionResult connectionResult);

        protected void m5445a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.f3120c.m5391b(1, null);
                return;
            }
            switch (this.f3118a) {
                case 0:
                    if (!mo794a()) {
                        this.f3120c.m5391b(1, null);
                        mo793a(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.f3120c.m5391b(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.f3120c.m5391b(1, null);
                    if (this.f3119b != null) {
                        pendingIntent = (PendingIntent) this.f3119b.getParcelable("pendingIntent");
                    }
                    mo793a(new ConnectionResult(this.f3118a, pendingIntent));
                    return;
            }
        }

        protected /* synthetic */ void mo789a(Object obj) {
            m5445a((Boolean) obj);
        }

        protected abstract boolean mo794a();

        protected void mo790b() {
        }
    }

    public interface C1168b {
        void mo796a(int i);

        void mo797a(Bundle bundle);
    }

    public interface C1169c {
        void mo798a(ConnectionResult connectionResult);
    }

    final class C1170d extends Handler {
        final /* synthetic */ C1160i f3121a;

        public C1170d(C1160i c1160i, Looper looper) {
            this.f3121a = c1160i;
            super(looper);
        }

        private void m5452a(Message message) {
            C1166e c1166e = (C1166e) message.obj;
            c1166e.mo790b();
            c1166e.m5442d();
        }

        private boolean m5453b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (this.f3121a.f3088c.get() != message.arg1) {
                if (m5453b(message)) {
                    m5452a(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !this.f3121a.m5409c()) {
                m5452a(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.f3121a.f3087b.mo765a(connectionResult);
                this.f3121a.m5404a(connectionResult);
            } else if (message.what == 4) {
                this.f3121a.m5391b(4, null);
                if (this.f3121a.f3105u != null) {
                    this.f3121a.f3105u.mo796a(message.arg2);
                }
                this.f3121a.m5399a(message.arg2);
                this.f3121a.m5388a(4, 1, null);
            } else if (message.what == 2 && !this.f3121a.m5408b()) {
                m5452a(message);
            } else if (m5453b(message)) {
                ((C1166e) message.obj).m5441c();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    public static final class C1173g extends C1172a {
        private C1160i f3122a;
        private final int f3123b;

        public C1173g(C1160i c1160i, int i) {
            this.f3122a = c1160i;
            this.f3123b = i;
        }

        private void m5457a() {
            this.f3122a = null;
        }

        public void mo791a(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public void mo792a(int i, IBinder iBinder, Bundle bundle) {
            C1157b.m5370a(this.f3122a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f3122a.m5401a(i, iBinder, bundle, this.f3123b);
            m5457a();
        }
    }

    public final class C1174h implements ServiceConnection {
        final /* synthetic */ C1160i f3124a;
        private final int f3125b;

        public C1174h(C1160i c1160i, int i) {
            this.f3124a = c1160i;
            this.f3125b = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder == null) {
                this.f3124a.m5392b(new ConnectionResult(8, null, "ServiceBroker IBinder is null"));
                return;
            }
            synchronized (this.f3124a.f3099o) {
                this.f3124a.f3100p = C1203a.m5649a(iBinder);
            }
            this.f3124a.m5400a(0, null, this.f3125b);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.f3124a.f3099o) {
                this.f3124a.f3100p = null;
            }
            this.f3124a.f3086a.sendMessage(this.f3124a.f3086a.obtainMessage(4, this.f3125b, 1));
        }
    }

    protected final class C1175i extends C1167a {
        public final IBinder f3126e;
        final /* synthetic */ C1160i f3127f;

        public C1175i(C1160i c1160i, int i, IBinder iBinder, Bundle bundle) {
            this.f3127f = c1160i;
            super(c1160i, i, bundle);
            this.f3126e = iBinder;
        }

        protected void mo793a(ConnectionResult connectionResult) {
            if (this.f3127f.f3106v != null) {
                this.f3127f.f3106v.mo798a(connectionResult);
            }
            this.f3127f.m5404a(connectionResult);
        }

        protected boolean mo794a() {
            try {
                String interfaceDescriptor = this.f3126e.getInterfaceDescriptor();
                if (this.f3127f.mo787g().equals(interfaceDescriptor)) {
                    IInterface a = this.f3127f.mo784a(this.f3126e);
                    if (a == null || !this.f3127f.m5388a(2, 3, a)) {
                        return false;
                    }
                    Bundle o = this.f3127f.m5420o();
                    if (this.f3127f.f3105u != null) {
                        this.f3127f.f3105u.mo797a(o);
                    }
                    return true;
                }
                String valueOf = String.valueOf(this.f3127f.mo787g());
                Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class C1176j extends C1167a {
        final /* synthetic */ C1160i f3128e;

        public C1176j(C1160i c1160i, int i, Bundle bundle) {
            this.f3128e = c1160i;
            super(c1160i, i, bundle);
        }

        protected void mo793a(ConnectionResult connectionResult) {
            this.f3128e.f3087b.mo765a(connectionResult);
            this.f3128e.m5404a(connectionResult);
        }

        protected boolean mo794a() {
            this.f3128e.f3087b.mo765a(ConnectionResult.f2960a);
            return true;
        }
    }

    protected C1160i(Context context, Looper looper, C1187o c1187o, C1146i c1146i, int i, C1168b c1168b, C1169c c1169c, String str) {
        this.f3094j = (Context) C1157b.m5370a((Object) context, (Object) "Context must not be null");
        this.f3095k = (Looper) C1157b.m5370a((Object) looper, (Object) "Looper must not be null");
        this.f3096l = (C1187o) C1157b.m5370a((Object) c1187o, (Object) "Supervisor must not be null");
        this.f3097m = (C1146i) C1157b.m5370a((Object) c1146i, (Object) "API availability must not be null");
        this.f3086a = new C1170d(this, looper);
        this.f3107w = i;
        this.f3105u = c1168b;
        this.f3106v = c1169c;
        this.f3108x = str;
    }

    private boolean m5388a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f3098n) {
            if (this.f3104t != i) {
                z = false;
            } else {
                m5391b(i2, t);
                z = true;
            }
        }
        return z;
    }

    private void m5391b(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        C1157b.m5376b(z);
        synchronized (this.f3098n) {
            this.f3104t = i;
            this.f3101q = t;
            mo785a(i, (IInterface) t);
            switch (i) {
                case 1:
                    m5396q();
                    break;
                case 2:
                    mo788h();
                    break;
                case 3:
                    m5403a((IInterface) t);
                    break;
            }
        }
    }

    private void m5392b(ConnectionResult connectionResult) {
        this.f3086a.sendMessage(this.f3086a.obtainMessage(3, this.f3088c.get(), connectionResult.m5261c(), connectionResult.m5262d()));
    }

    private void mo788h() {
        if (this.f3103s != null) {
            String valueOf = String.valueOf(mo786f());
            String valueOf2 = String.valueOf(m5414i());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.f3096l.mo800b(mo786f(), m5414i(), this.f3103s, m5415j());
            this.f3088c.incrementAndGet();
        }
        this.f3103s = new C1174h(this, this.f3088c.get());
        if (!this.f3096l.mo799a(mo786f(), m5414i(), this.f3103s, m5415j())) {
            valueOf = String.valueOf(mo786f());
            valueOf2 = String.valueOf(m5414i());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
            m5400a(16, null, this.f3088c.get());
        }
    }

    private void m5396q() {
        if (this.f3103s != null) {
            this.f3096l.mo800b(mo786f(), m5414i(), this.f3103s, m5415j());
            this.f3103s = null;
        }
    }

    protected abstract T mo784a(IBinder iBinder);

    public void m5398a() {
        this.f3088c.incrementAndGet();
        synchronized (this.f3102r) {
            int size = this.f3102r.size();
            for (int i = 0; i < size; i++) {
                ((C1166e) this.f3102r.get(i)).m5443e();
            }
            this.f3102r.clear();
        }
        synchronized (this.f3099o) {
            this.f3100p = null;
        }
        m5391b(1, null);
    }

    protected void m5399a(int i) {
        this.f3089e = i;
        this.f3090f = System.currentTimeMillis();
    }

    protected void m5400a(int i, Bundle bundle, int i2) {
        this.f3086a.sendMessage(this.f3086a.obtainMessage(5, i2, -1, new C1176j(this, i, bundle)));
    }

    protected void m5401a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f3086a.sendMessage(this.f3086a.obtainMessage(1, i2, -1, new C1175i(this, i, iBinder, bundle)));
    }

    void mo785a(int i, T t) {
    }

    protected void m5403a(T t) {
        this.f3091g = System.currentTimeMillis();
    }

    protected void m5404a(ConnectionResult connectionResult) {
        this.f3092h = connectionResult.m5261c();
        this.f3093i = System.currentTimeMillis();
    }

    public void m5405a(C1092f c1092f) {
        this.f3087b = (C1092f) C1157b.m5370a((Object) c1092f, (Object) "Connection progress callbacks cannot be null.");
        m5391b(2, null);
    }

    public void m5406a(C1154r c1154r, Set<Scope> set) {
        GetServiceRequest a = new GetServiceRequest(this.f3107w).m5352a(this.f3094j.getPackageName()).m5350a(mo867n());
        if (set != null) {
            a.m5353a((Collection) set);
        }
        if (mo866d()) {
            a.m5349a(m5418m()).m5351a(c1154r);
        } else if (m5421p()) {
            a.m5349a(mo783l());
        }
        try {
            synchronized (this.f3099o) {
                if (this.f3100p != null) {
                    this.f3100p.mo813a(new C1173g(this, this.f3088c.get()), a);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            m5407b(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        } catch (SecurityException e3) {
            throw e3;
        } catch (Throwable e22) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e22);
            m5392b(new ConnectionResult(8, null, "IGmsServiceBroker.getService failed."));
        }
    }

    public void m5407b(int i) {
        this.f3086a.sendMessage(this.f3086a.obtainMessage(4, this.f3088c.get(), i));
    }

    public boolean m5408b() {
        boolean z;
        synchronized (this.f3098n) {
            z = this.f3104t == 3;
        }
        return z;
    }

    public boolean m5409c() {
        boolean z;
        synchronized (this.f3098n) {
            z = this.f3104t == 2;
        }
        return z;
    }

    public boolean mo866d() {
        return false;
    }

    public boolean m5411e() {
        return true;
    }

    protected abstract String mo786f();

    protected abstract String mo787g();

    protected String m5414i() {
        return "com.google.android.gms";
    }

    protected final String m5415j() {
        return this.f3108x == null ? this.f3094j.getClass().getName() : this.f3108x;
    }

    public final Context m5416k() {
        return this.f3094j;
    }

    public Account mo783l() {
        return null;
    }

    public final Account m5418m() {
        return mo783l() != null ? mo783l() : new Account("<<default account>>", "com.google");
    }

    protected Bundle mo867n() {
        return new Bundle();
    }

    public Bundle m5420o() {
        return null;
    }

    public boolean m5421p() {
        return false;
    }
}
