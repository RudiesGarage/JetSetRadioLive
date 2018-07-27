package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C1045a.C1040b;

public class C1163f {
    private final Resources f3113a;
    private final String f3114b = this.f3113a.getResourcePackageName(C1040b.common_google_play_services_unknown_issue);

    public C1163f(Context context) {
        C1157b.m5369a((Object) context);
        this.f3113a = context.getResources();
    }

    public String m5432a(String str) {
        int identifier = this.f3113a.getIdentifier(str, "string", this.f3114b);
        return identifier == 0 ? null : this.f3113a.getString(identifier);
    }
}
