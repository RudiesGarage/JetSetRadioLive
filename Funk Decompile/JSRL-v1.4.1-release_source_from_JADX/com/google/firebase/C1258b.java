package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1157b;
import com.google.android.gms.common.internal.C1163f;
import com.google.android.gms.common.internal.C1211z;
import com.google.android.gms.common.util.C1230k;

public final class C1258b {
    private final String f3253a;
    private final String f3254b;
    private final String f3255c;
    private final String f3256d;
    private final String f3257e;
    private final String f3258f;

    private C1258b(String str, String str2, String str3, String str4, String str5, String str6) {
        C1157b.m5374a(!C1230k.m5694a(str), (Object) "ApplicationId must be set.");
        this.f3254b = str;
        this.f3253a = str2;
        this.f3255c = str3;
        this.f3256d = str4;
        this.f3257e = str5;
        this.f3258f = str6;
    }

    public static C1258b m5790a(Context context) {
        C1163f c1163f = new C1163f(context);
        Object a = c1163f.m5432a("google_app_id");
        return TextUtils.isEmpty(a) ? null : new C1258b(a, c1163f.m5432a("google_api_key"), c1163f.m5432a("firebase_database_url"), c1163f.m5432a("ga_trackingId"), c1163f.m5432a("gcm_defaultSenderId"), c1163f.m5432a("google_storage_bucket"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1258b)) {
            return false;
        }
        C1258b c1258b = (C1258b) obj;
        return C1211z.m5661a(this.f3254b, c1258b.f3254b) && C1211z.m5661a(this.f3253a, c1258b.f3253a) && C1211z.m5661a(this.f3255c, c1258b.f3255c) && C1211z.m5661a(this.f3256d, c1258b.f3256d) && C1211z.m5661a(this.f3257e, c1258b.f3257e) && C1211z.m5661a(this.f3258f, c1258b.f3258f);
    }

    public int hashCode() {
        return C1211z.m5659a(this.f3254b, this.f3253a, this.f3255c, this.f3256d, this.f3257e, this.f3258f);
    }

    public String toString() {
        return C1211z.m5660a((Object) this).m5658a("applicationId", this.f3254b).m5658a("apiKey", this.f3253a).m5658a("databaseUrl", this.f3255c).m5658a("gcmSenderId", this.f3257e).m5658a("storageBucket", this.f3258f).toString();
    }
}
