package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1192q;
import com.google.android.gms.common.util.C1224e;
import com.google.android.gms.p043b.C1111y;

public class C1146i {
    private static final C1146i f3044a = new C1146i();
    public static final int f3045b = C1120k.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    C1146i() {
    }

    public static C1146i m5314b() {
        return f3044a;
    }

    static String m5315b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(f3045b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(C1111y.m5247b(context).m5246b(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int mo773a(Context context) {
        int isGooglePlayServicesAvailable = C1120k.isGooglePlayServicesAvailable(context);
        return C1120k.zzd(context, isGooglePlayServicesAvailable) ? 18 : isGooglePlayServicesAvailable;
    }

    public PendingIntent mo774a(Context context, int i, int i2) {
        return mo775a(context, i, i2, null);
    }

    public PendingIntent mo775a(Context context, int i, int i2, String str) {
        Intent b = mo777b(context, i, str);
        return b == null ? null : PendingIntent.getActivity(context, i2, b, 268435456);
    }

    public boolean mo776a(int i) {
        return C1120k.isUserRecoverableError(i);
    }

    public boolean m5320a(Context context, String str) {
        return C1120k.zzs(context, str);
    }

    public Intent mo777b(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return (context == null || !C1224e.m5681a(context)) ? C1192q.m5519a("com.google.android.gms", C1146i.m5315b(context, str)) : C1192q.m5517a();
            case 3:
                return C1192q.m5518a("com.google.android.gms");
            default:
                return null;
        }
    }

    public String mo778b(int i) {
        return C1120k.getErrorString(i);
    }
}
