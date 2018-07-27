package com.google.android.gms.p043b;

import android.content.Context;

public class C1111y {
    private static C1111y f2948b = new C1111y();
    private C1110x f2949a = null;

    public static C1110x m5247b(Context context) {
        return f2948b.m5248a(context);
    }

    public synchronized C1110x m5248a(Context context) {
        if (this.f2949a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f2949a = new C1110x(context);
        }
        return this.f2949a;
    }
}
