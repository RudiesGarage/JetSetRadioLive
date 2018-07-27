package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.p043b.aa;
import java.util.concurrent.Callable;

public class C1242b {
    private static SharedPreferences f3214a = null;

    class C12411 implements Callable<SharedPreferences> {
        final /* synthetic */ Context f3213a;

        C12411(Context context) {
            this.f3213a = context;
        }

        public SharedPreferences m5705a() {
            return this.f3213a.getSharedPreferences("google_sdk_flags", 1);
        }

        public /* synthetic */ Object call() {
            return m5705a();
        }
    }

    public static SharedPreferences m5706a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f3214a == null) {
                f3214a = (SharedPreferences) aa.m5080a(new C12411(context));
            }
            sharedPreferences = f3214a;
        }
        return sharedPreferences;
    }
}
