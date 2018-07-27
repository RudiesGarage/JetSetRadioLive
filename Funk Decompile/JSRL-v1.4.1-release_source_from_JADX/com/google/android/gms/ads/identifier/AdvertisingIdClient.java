package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.C1120k;
import com.google.android.gms.common.C1146i;
import com.google.android.gms.common.C1148c;
import com.google.android.gms.common.C1152g;
import com.google.android.gms.common.internal.C1157b;
import com.google.android.gms.common.p045a.C1121a;
import com.google.android.gms.p043b.C1066c;
import com.google.android.gms.p043b.C1066c.C1068a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    C1152g zzalf;
    C1066c zzalg;
    boolean zzalh;
    Object zzali;
    C1047a zzalj;
    final long zzalk;

    public static final class Info {
        private final String zzalr;
        private final boolean zzals;

        public Info(String str, boolean z) {
            this.zzalr = str;
            this.zzals = z;
        }

        public String getId() {
            return this.zzalr;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzals;
        }

        public String toString() {
            String str = this.zzalr;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.zzals).toString();
        }
    }

    static class C1047a extends Thread {
        CountDownLatch f2812a = new CountDownLatch(1);
        boolean f2813b = false;
        private WeakReference<AdvertisingIdClient> f2814c;
        private long f2815d;

        public C1047a(AdvertisingIdClient advertisingIdClient, long j) {
            this.f2814c = new WeakReference(advertisingIdClient);
            this.f2815d = j;
            start();
        }

        private void m5059c() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f2814c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f2813b = true;
            }
        }

        public void m5060a() {
            this.f2812a.countDown();
        }

        public boolean m5061b() {
            return this.f2813b;
        }

        public void run() {
            try {
                if (!this.f2812a.await(this.f2815d, TimeUnit.MILLISECONDS)) {
                    m5059c();
                }
            } catch (InterruptedException e) {
                m5059c();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000, false);
    }

    public AdvertisingIdClient(Context context, long j, boolean z) {
        this.zzali = new Object();
        C1157b.m5369a((Object) context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            this.mContext = context;
        } else {
            this.mContext = context;
        }
        this.zzalh = false;
        this.zzalk = j;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        Info info;
        float f = 0.0f;
        boolean z = false;
        try {
            Context remoteContext = C1120k.getRemoteContext(context);
            if (remoteContext != null) {
                SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("google_ads_flags", 1);
                z = sharedPreferences.getBoolean("gads:ad_id_app_context:enabled", false);
                f = sharedPreferences.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
            }
        } catch (Throwable e) {
            Log.w("AdvertisingIdClient", "Error while reading from SharedPreferences ", e);
        }
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, z);
        try {
            advertisingIdClient.zze(false);
            info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, z, f, null);
            return info;
        } catch (Throwable th) {
            info = th;
            advertisingIdClient.zza(null, z, f, info);
            return null;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    static C1066c zza(Context context, C1152g c1152g) {
        try {
            return C1068a.m5113a(c1152g.m5344a(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void zza(Info info, boolean z, float f, Throwable th) {
        if (Math.random() <= ((double) f)) {
            final String uri = zza(info, z, th).toString();
            new Thread(this) {
                final /* synthetic */ AdvertisingIdClient f2811b;

                public void run() {
                    new C1048a().m5062a(uri);
                }
            }.start();
        }
    }

    private void zzea() {
        synchronized (this.zzali) {
            if (this.zzalj != null) {
                this.zzalj.m5060a();
                try {
                    this.zzalj.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzalk > 0) {
                this.zzalj = new C1047a(this, this.zzalk);
            }
        }
    }

    static C1152g zzf(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (C1146i.m5314b().mo773a(context)) {
                case 0:
                case 2:
                    ServiceConnection c1152g = new C1152g();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (C1121a.m5264a().m5270a(context, intent, c1152g, 1)) {
                            return c1152g;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new C1148c(9);
        }
    }

    protected void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.C1157b.m5375b(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.zzalf;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.zzalh;	 Catch:{ IllegalArgumentException -> 0x002d, Throwable -> 0x0036 }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.common.p045a.C1121a.m5264a();	 Catch:{ IllegalArgumentException -> 0x002d, Throwable -> 0x0036 }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002d, Throwable -> 0x0036 }
        r2 = r3.zzalf;	 Catch:{ IllegalArgumentException -> 0x002d, Throwable -> 0x0036 }
        r0.m5268a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002d, Throwable -> 0x0036 }
    L_0x001f:
        r0 = 0;
        r3.zzalh = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzalg = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzalf = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
    L_0x0036:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() {
        Info info;
        C1157b.m5375b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzalh) {
                synchronized (this.zzali) {
                    if (this.zzalj == null || !this.zzalj.m5061b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zze(false);
                    if (!this.zzalh) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            C1157b.m5369a(this.zzalf);
            C1157b.m5369a(this.zzalg);
            info = new Info(this.zzalg.mo750a(), this.zzalg.mo753a(true));
        }
        zzea();
        return info;
    }

    public void start() {
        zze(true);
    }

    Uri zza(Info info, boolean z, Throwable th) {
        Bundle bundle = new Bundle();
        bundle.putString("app_context", z ? "1" : "0");
        if (info != null) {
            bundle.putString("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (!(info == null || info.getId() == null)) {
            bundle.putString("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            bundle.putString("error", th.getClass().getName());
        }
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : bundle.keySet()) {
            buildUpon.appendQueryParameter(str, bundle.getString(str));
        }
        return buildUpon.build();
    }

    protected void zze(boolean z) {
        C1157b.m5375b("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzalh) {
                finish();
            }
            this.zzalf = zzf(this.mContext);
            this.zzalg = zza(this.mContext, this.zzalf);
            this.zzalh = true;
            if (z) {
                zzea();
            }
        }
    }
}
