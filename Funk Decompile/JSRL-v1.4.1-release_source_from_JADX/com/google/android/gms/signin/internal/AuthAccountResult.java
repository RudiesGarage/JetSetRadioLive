package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C1127f;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountResult extends AbstractSafeParcelable implements C1127f {
    public static final Creator<AuthAccountResult> CREATOR = new C1243a();
    final int f3215a;
    private int f3216b;
    private Intent f3217c;

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.f3215a = i;
        this.f3216b = i2;
        this.f3217c = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public Status mo772a() {
        return this.f3216b == 0 ? Status.f2999a : Status.f3003e;
    }

    public int m5708b() {
        return this.f3216b;
    }

    public Intent m5709c() {
        return this.f3217c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1243a.m5716a(this, parcel, i);
    }
}
