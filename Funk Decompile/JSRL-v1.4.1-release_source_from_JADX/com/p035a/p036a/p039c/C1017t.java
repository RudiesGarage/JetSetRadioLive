package com.p035a.p036a.p039c;

import android.content.Context;
import android.os.Bundle;

/* compiled from: ManifestUnityVersionProvider */
class C1017t implements ac {
    private final Context f2756a;
    private final String f2757b;

    public C1017t(Context context, String str) {
        this.f2756a = context;
        this.f2757b = str;
    }

    public String mo744a() {
        String str = null;
        try {
            Bundle bundle = this.f2756a.getPackageManager().getApplicationInfo(this.f2757b, 128).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.unity.crashlytics.version");
            }
        } catch (Exception e) {
        }
        return str;
    }
}
