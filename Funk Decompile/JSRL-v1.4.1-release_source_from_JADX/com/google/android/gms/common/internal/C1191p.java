package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.p045a.C1121a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class C1191p extends C1187o implements Callback {
    private final HashMap<C1188a, C1190b> f3166a = new HashMap();
    private final Context f3167b;
    private final Handler f3168c;
    private final C1121a f3169d;
    private final long f3170e;

    private static final class C1188a {
        private final String f3154a;
        private final String f3155b;
        private final ComponentName f3156c = null;

        public C1188a(String str, String str2) {
            this.f3154a = C1157b.m5371a(str);
            this.f3155b = C1157b.m5371a(str2);
        }

        public Intent m5495a() {
            return this.f3154a != null ? new Intent(this.f3154a).setPackage(this.f3155b) : new Intent().setComponent(this.f3156c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1188a)) {
                return false;
            }
            C1188a c1188a = (C1188a) obj;
            return C1211z.m5661a(this.f3154a, c1188a.f3154a) && C1211z.m5661a(this.f3156c, c1188a.f3156c);
        }

        public int hashCode() {
            return C1211z.m5659a(this.f3154a, this.f3156c);
        }

        public String toString() {
            return this.f3154a == null ? this.f3156c.flattenToString() : this.f3154a;
        }
    }

    private final class C1190b {
        final /* synthetic */ C1191p f3158a;
        private final C1189a f3159b = new C1189a(this);
        private final Set<ServiceConnection> f3160c = new HashSet();
        private int f3161d = 2;
        private boolean f3162e;
        private IBinder f3163f;
        private final C1188a f3164g;
        private ComponentName f3165h;

        public class C1189a implements ServiceConnection {
            final /* synthetic */ C1190b f3157a;

            public C1189a(C1190b c1190b) {
                this.f3157a = c1190b;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.f3157a.f3158a.f3166a) {
                    this.f3157a.f3163f = iBinder;
                    this.f3157a.f3165h = componentName;
                    for (ServiceConnection onServiceConnected : this.f3157a.f3160c) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.f3157a.f3161d = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.f3157a.f3158a.f3166a) {
                    this.f3157a.f3163f = null;
                    this.f3157a.f3165h = componentName;
                    for (ServiceConnection onServiceDisconnected : this.f3157a.f3160c) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.f3157a.f3161d = 2;
                }
            }
        }

        public C1190b(C1191p c1191p, C1188a c1188a) {
            this.f3158a = c1191p;
            this.f3164g = c1188a;
        }

        public void m5500a(ServiceConnection serviceConnection, String str) {
            this.f3158a.f3169d.m5269a(this.f3158a.f3167b, serviceConnection, str, this.f3164g.m5495a());
            this.f3160c.add(serviceConnection);
        }

        @TargetApi(14)
        public void m5501a(String str) {
            this.f3161d = 3;
            this.f3162e = this.f3158a.f3169d.m5271a(this.f3158a.f3167b, str, this.f3164g.m5495a(), this.f3159b, 129);
            if (!this.f3162e) {
                this.f3161d = 2;
                try {
                    this.f3158a.f3169d.m5268a(this.f3158a.f3167b, this.f3159b);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public boolean m5502a() {
            return this.f3162e;
        }

        public boolean m5503a(ServiceConnection serviceConnection) {
            return this.f3160c.contains(serviceConnection);
        }

        public int m5504b() {
            return this.f3161d;
        }

        public void m5505b(ServiceConnection serviceConnection, String str) {
            this.f3158a.f3169d.m5272b(this.f3158a.f3167b, serviceConnection);
            this.f3160c.remove(serviceConnection);
        }

        public void m5506b(String str) {
            this.f3158a.f3169d.m5268a(this.f3158a.f3167b, this.f3159b);
            this.f3162e = false;
            this.f3161d = 2;
        }

        public boolean m5507c() {
            return this.f3160c.isEmpty();
        }

        public IBinder m5508d() {
            return this.f3163f;
        }

        public ComponentName m5509e() {
            return this.f3165h;
        }
    }

    C1191p(Context context) {
        this.f3167b = context.getApplicationContext();
        this.f3168c = new Handler(context.getMainLooper(), this);
        this.f3169d = C1121a.m5264a();
        this.f3170e = 5000;
    }

    private boolean m5511a(C1188a c1188a, ServiceConnection serviceConnection, String str) {
        boolean a;
        C1157b.m5370a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f3166a) {
            C1190b c1190b = (C1190b) this.f3166a.get(c1188a);
            if (c1190b != null) {
                this.f3168c.removeMessages(0, c1188a);
                if (!c1190b.m5503a(serviceConnection)) {
                    c1190b.m5500a(serviceConnection, str);
                    switch (c1190b.m5504b()) {
                        case 1:
                            serviceConnection.onServiceConnected(c1190b.m5509e(), c1190b.m5508d());
                            break;
                        case 2:
                            c1190b.m5501a(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(c1188a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            c1190b = new C1190b(this, c1188a);
            c1190b.m5500a(serviceConnection, str);
            c1190b.m5501a(str);
            this.f3166a.put(c1188a, c1190b);
            a = c1190b.m5502a();
        }
        return a;
    }

    private void m5513b(C1188a c1188a, ServiceConnection serviceConnection, String str) {
        C1157b.m5370a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f3166a) {
            C1190b c1190b = (C1190b) this.f3166a.get(c1188a);
            String valueOf;
            if (c1190b == null) {
                valueOf = String.valueOf(c1188a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (c1190b.m5503a(serviceConnection)) {
                c1190b.m5505b(serviceConnection, str);
                if (c1190b.m5507c()) {
                    this.f3168c.sendMessageDelayed(this.f3168c.obtainMessage(0, c1188a), this.f3170e);
                }
            } else {
                valueOf = String.valueOf(c1188a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public boolean mo799a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return m5511a(new C1188a(str, str2), serviceConnection, str3);
    }

    public void mo800b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        m5513b(new C1188a(str, str2), serviceConnection, str3);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                C1188a c1188a = (C1188a) message.obj;
                synchronized (this.f3166a) {
                    C1190b c1190b = (C1190b) this.f3166a.get(c1188a);
                    if (c1190b != null && c1190b.m5507c()) {
                        if (c1190b.m5502a()) {
                            c1190b.m5506b("GmsClientSupervisor");
                        }
                        this.f3166a.remove(c1188a);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
