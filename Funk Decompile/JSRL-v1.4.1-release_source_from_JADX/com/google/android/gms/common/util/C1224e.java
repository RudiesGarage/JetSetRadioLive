package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.C1120k;

public final class C1224e {
    private static Boolean f3194a;

    public static boolean m5680a() {
        boolean z = C1120k.xb;
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean m5681a(Context context) {
        if (f3194a == null) {
            boolean z = C1228i.m5690f() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            f3194a = Boolean.valueOf(z);
        }
        return f3194a.booleanValue();
    }
}
