package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C1219l;
import com.google.android.gms.p043b.C1111y;

public final class C1231l {
    public static boolean m5695a(Context context, int i) {
        boolean z = false;
        if (!C1231l.m5696a(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return C1219l.m5672a(context).m5675a(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return z;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean m5696a(Context context, int i, String str) {
        return C1111y.m5247b(context).m5245a(i, str);
    }
}
