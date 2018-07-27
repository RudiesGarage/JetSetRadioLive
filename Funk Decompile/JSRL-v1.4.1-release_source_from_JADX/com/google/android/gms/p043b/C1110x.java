package com.google.android.gms.p043b;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.util.C1228i;

public class C1110x {
    protected final Context f2947a;

    public C1110x(Context context) {
        this.f2947a = context;
    }

    public ApplicationInfo m5243a(String str, int i) {
        return this.f2947a.getPackageManager().getApplicationInfo(str, i);
    }

    public CharSequence m5244a(String str) {
        return this.f2947a.getPackageManager().getApplicationLabel(this.f2947a.getPackageManager().getApplicationInfo(str, 0));
    }

    @TargetApi(19)
    public boolean m5245a(int i, String str) {
        if (C1228i.m5689e()) {
            try {
                ((AppOpsManager) this.f2947a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.f2947a.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public PackageInfo m5246b(String str, int i) {
        return this.f2947a.getPackageManager().getPackageInfo(str, i);
    }
}
