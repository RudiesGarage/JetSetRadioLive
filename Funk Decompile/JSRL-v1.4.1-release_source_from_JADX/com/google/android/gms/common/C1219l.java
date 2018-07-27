package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.C1218j.C1212a;
import com.google.android.gms.common.C1218j.C1213b;
import com.google.android.gms.common.C1218j.C1217d;
import com.google.android.gms.common.internal.C1157b;

public class C1219l {
    private static C1219l f3190a;
    private final Context f3191b;

    private C1219l(Context context) {
        this.f3191b = context.getApplicationContext();
    }

    public static C1219l m5672a(Context context) {
        C1157b.m5369a((Object) context);
        synchronized (C1219l.class) {
            if (f3190a == null) {
                C1218j.m5671a(context);
                f3190a = new C1219l(context);
            }
        }
        return f3190a;
    }

    C1212a m5673a(PackageInfo packageInfo, C1212a... c1212aArr) {
        int i = 0;
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C1213b c1213b = new C1213b(packageInfo.signatures[0].toByteArray());
        while (i < c1212aArr.length) {
            if (c1212aArr[i].equals(c1213b)) {
                return c1212aArr[i];
            }
            i++;
        }
        return null;
    }

    public boolean m5674a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            C1212a a;
            if (z) {
                a = m5673a(packageInfo, C1217d.f3188a);
            } else {
                a = m5673a(packageInfo, C1217d.f3188a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean m5675a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m5674a(packageInfo, false)) {
            return true;
        }
        if (!m5674a(packageInfo, true)) {
            return false;
        }
        if (C1120k.zzbr(this.f3191b)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }
}
