package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.flags.impl.C1233a.C1234a;
import com.google.android.gms.flags.impl.C1233a.C1236b;
import com.google.android.gms.flags.impl.C1233a.C1238c;
import com.google.android.gms.flags.impl.C1233a.C1240d;
import com.google.android.gms.p042a.C1041a;
import com.google.android.gms.p042a.C1044b;
import com.google.android.gms.p043b.C1112z.C1114a;

@DynamiteApi
public class FlagProviderImpl extends C1114a {
    private boolean f3199a = false;
    private SharedPreferences f3200b;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f3199a ? z : C1234a.m5698a(this.f3200b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f3199a ? i : C1236b.m5700a(this.f3200b, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.f3199a ? j : C1238c.m5702a(this.f3200b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f3199a ? str2 : C1240d.m5704a(this.f3200b, str, str2);
    }

    public void init(C1041a c1041a) {
        Context context = (Context) C1044b.m5058a(c1041a);
        if (!this.f3199a) {
            try {
                this.f3200b = C1242b.m5706a(context.createPackageContext("com.google.android.gms", 0));
                this.f3199a = true;
            } catch (NameNotFoundException e) {
            }
        }
    }
}
