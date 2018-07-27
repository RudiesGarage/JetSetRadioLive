package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import p000a.p001a.p002a.p003a.C0142c;

/* compiled from: AdvertisingInfoServiceStrategy */
class C0017e implements C0012f {
    private final Context f22a;

    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C0015a implements ServiceConnection {
        private boolean f19a;
        private final LinkedBlockingQueue<IBinder> f20b;

        private C0015a() {
            this.f19a = false;
            this.f20b = new LinkedBlockingQueue(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f20b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f20b.clear();
        }

        public IBinder m41a() {
            if (this.f19a) {
                C0142c.m468h().mo53e("Fabric", "getBinder already called");
            }
            this.f19a = true;
            try {
                return (IBinder) this.f20b.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C0016b implements IInterface {
        private final IBinder f21a;

        public boolean m43b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r0 = 1;
            r1 = 0;
            r2 = android.os.Parcel.obtain();
            r3 = android.os.Parcel.obtain();
            r4 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r2.writeInterfaceToken(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = 1;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r2.writeInt(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = r7.f21a;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r5 = 2;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r6 = 0;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4.transact(r5, r2, r3, r6);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r3.readException();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = r3.readInt();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            if (r4 == 0) goto L_0x002a;
        L_0x0023:
            r3.recycle();
            r2.recycle();
        L_0x0029:
            return r0;
        L_0x002a:
            r0 = r1;
            goto L_0x0023;
        L_0x002c:
            r0 = move-exception;
            r0 = p000a.p001a.p002a.p003a.C0142c.m468h();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = "Fabric";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r5 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r0.mo46a(r4, r5);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r3.recycle();
            r2.recycle();
            r0 = r1;
            goto L_0x0029;
        L_0x0040:
            r0 = move-exception;
            r3.recycle();
            r2.recycle();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.b.e.b.b():boolean");
        }

        public C0016b(IBinder iBinder) {
            this.f21a = iBinder;
        }

        public IBinder asBinder() {
            return this.f21a;
        }

        public String m42a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str = null;
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f21a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Exception e) {
                C0142c.m468h().mo46a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
            return str;
        }
    }

    public C0017e(Context context) {
        this.f22a = context.getApplicationContext();
    }

    public C0008b mo5a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C0142c.m468h().mo46a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f22a.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnection c0015a = new C0015a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f22a.bindService(intent, c0015a, 1)) {
                    C0016b c0016b = new C0016b(c0015a.m41a());
                    C0008b c0008b = new C0008b(c0016b.m42a(), c0016b.m43b());
                    this.f22a.unbindService(c0015a);
                    return c0008b;
                }
                C0142c.m468h().mo46a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                return null;
            } catch (Throwable e) {
                C0142c.m468h().mo52d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                this.f22a.unbindService(c0015a);
                return null;
            } catch (Throwable e2) {
                C0142c.m468h().mo47a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", e2);
                return null;
            }
        } catch (NameNotFoundException e3) {
            C0142c.m468h().mo46a("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Throwable e22) {
            C0142c.m468h().mo47a("Fabric", "Unable to determine if Google Play Services is available", e22);
            return null;
        }
    }
}
