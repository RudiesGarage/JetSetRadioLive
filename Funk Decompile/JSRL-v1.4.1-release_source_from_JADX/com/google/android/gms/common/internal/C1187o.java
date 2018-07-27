package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class C1187o {
    private static final Object f3152a = new Object();
    private static C1187o f3153b;

    public static C1187o m5492a(Context context) {
        synchronized (f3152a) {
            if (f3153b == null) {
                f3153b = new C1191p(context.getApplicationContext());
            }
        }
        return f3153b;
    }

    public abstract boolean mo799a(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void mo800b(String str, String str2, ServiceConnection serviceConnection, String str3);
}
