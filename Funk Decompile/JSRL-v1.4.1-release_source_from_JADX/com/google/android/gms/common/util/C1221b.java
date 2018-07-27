package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.p043b.C1111y;

public class C1221b {
    public static boolean m5677a() {
        return false;
    }

    @TargetApi(12)
    public static boolean m5678a(Context context, String str) {
        if (!C1228i.m5686b()) {
            return false;
        }
        if ("com.google.android.gms".equals(str) && C1221b.m5677a()) {
            return false;
        }
        try {
            return (C1111y.m5247b(context).m5243a(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
