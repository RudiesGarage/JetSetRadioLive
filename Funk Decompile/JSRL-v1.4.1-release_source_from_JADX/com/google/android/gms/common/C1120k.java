package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.C1045a.C1040b;
import com.google.android.gms.common.C1218j.C1217d;
import com.google.android.gms.common.internal.C1208y;
import com.google.android.gms.common.util.C1221b;
import com.google.android.gms.common.util.C1224e;
import com.google.android.gms.common.util.C1225f;
import com.google.android.gms.common.util.C1228i;
import com.google.android.gms.common.util.C1231l;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class C1120k {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = C1120k.zzaqq();
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean xb = false;
    public static boolean xc = false;
    static boolean xd = false;
    private static boolean xe = false;
    static final AtomicBoolean xf = new AtomicBoolean();
    private static final AtomicBoolean xg = new AtomicBoolean();

    C1120k() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return C1146i.m5314b().mo774a(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.m5258a(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C1040b.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            C1120k.zzbp(context);
        }
        int i = !C1224e.m5681a(context) ? 1 : 0;
        PackageInfo packageInfo = null;
        if (i != 0) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            C1219l a = C1219l.m5672a(context);
            if (i != 0) {
                if (a.m5673a(packageInfo, C1217d.f3188a) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                }
                if (a.m5673a(packageInfo2, a.m5673a(packageInfo, C1217d.f3188a)) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (a.m5673a(packageInfo2, C1217d.f3188a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (C1225f.m5682a(packageInfo2.versionCode) < C1225f.m5682a(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + packageInfo2.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static int zzaqq() {
        return 9877000;
    }

    @Deprecated
    public static boolean zzaqr() {
        return C1224e.m5680a();
    }

    @Deprecated
    public static void zzaz(Context context) {
        int a = C1146i.m5314b().mo773a(context);
        if (a != 0) {
            Intent b = C1146i.m5314b().mo777b(context, a, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + a);
            if (b == null) {
                throw new C1148c(a);
            }
            throw new C1150d(a, "Google Play Services not available", b);
        }
    }

    @Deprecated
    public static int zzbk(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    @Deprecated
    public static void zzbn(Context context) {
        if (!xf.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException e) {
            }
        }
    }

    private static void zzbp(Context context) {
        if (!xg.get()) {
            int a = C1208y.m5656a(context);
            if (a == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (a != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                String valueOf = String.valueOf("com.google.android.gms.version");
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(i).append(" but found ").append(a).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(valueOf).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
    }

    public static boolean zzbq(Context context) {
        C1120k.zzbt(context);
        return xd;
    }

    public static boolean zzbr(Context context) {
        return C1120k.zzbq(context) || !C1120k.zzaqr();
    }

    @TargetApi(18)
    public static boolean zzbs(Context context) {
        if (C1228i.m5688d()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    private static void zzbt(Context context) {
        if (!xe) {
            C1120k.zzbu(context);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzbu(android.content.Context r7) {
        /*
        r6 = 1;
        r0 = com.google.android.gms.p043b.C1111y.m5247b(r7);	 Catch:{ NameNotFoundException -> 0x002e }
        r1 = "com.google.android.gms";
        r2 = 64;
        r0 = r0.m5246b(r1, r2);	 Catch:{ NameNotFoundException -> 0x002e }
        if (r0 == 0) goto L_0x002a;
    L_0x000f:
        r1 = com.google.android.gms.common.C1219l.m5672a(r7);	 Catch:{ NameNotFoundException -> 0x002e }
        r2 = 1;
        r2 = new com.google.android.gms.common.C1218j.C1212a[r2];	 Catch:{ NameNotFoundException -> 0x002e }
        r3 = 0;
        r4 = com.google.android.gms.common.C1218j.C1217d.f3188a;	 Catch:{ NameNotFoundException -> 0x002e }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ NameNotFoundException -> 0x002e }
        r2[r3] = r4;	 Catch:{ NameNotFoundException -> 0x002e }
        r0 = r1.m5673a(r0, r2);	 Catch:{ NameNotFoundException -> 0x002e }
        if (r0 == 0) goto L_0x002a;
    L_0x0024:
        r0 = 1;
        xd = r0;	 Catch:{ NameNotFoundException -> 0x002e }
    L_0x0027:
        xe = r6;
    L_0x0029:
        return;
    L_0x002a:
        r0 = 0;
        xd = r0;	 Catch:{ NameNotFoundException -> 0x002e }
        goto L_0x0027;
    L_0x002e:
        r0 = move-exception;
        r1 = "GooglePlayServicesUtil";
        r2 = "Cannot find Google Play services package name.";
        android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x0039 }
        xe = r6;
        goto L_0x0029;
    L_0x0039:
        r0 = move-exception;
        xe = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.k.zzbu(android.content.Context):void");
    }

    @TargetApi(19)
    @Deprecated
    public static boolean zzc(Context context, int i, String str) {
        return C1231l.m5696a(context, i, str);
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        return i == 18 ? true : i == 1 ? C1120k.zzs(context, "com.google.android.gms") : false;
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        return i == 9 ? C1120k.zzs(context, "com.android.vending") : false;
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        return C1231l.m5695a(context, i);
    }

    @TargetApi(21)
    static boolean zzs(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (equals && C1221b.m5677a()) {
            return false;
        }
        if (C1228i.m5691g()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            boolean z = applicationInfo.enabled && !C1120k.zzbs(context);
            return z;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
