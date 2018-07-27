package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.p043b.C1111y;

public class C1208y {
    private static Object f3178a = new Object();
    private static boolean f3179b;
    private static String f3180c;
    private static int f3181d;

    public static int m5656a(Context context) {
        C1208y.m5657b(context);
        return f3181d;
    }

    private static void m5657b(Context context) {
        synchronized (f3178a) {
            if (f3179b) {
                return;
            }
            f3179b = true;
            try {
                Bundle bundle = C1111y.m5247b(context).m5243a(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f3180c = bundle.getString("com.google.app.id");
                f3181d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
