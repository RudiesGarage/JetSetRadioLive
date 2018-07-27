package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR = new C1164g();
    final int f3078a;
    final IBinder f3079b;
    private final int f3080c;
    private final Scope[] f3081d;
    private final Bundle f3082e;
    private final String f3083f;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f3078a = i;
        this.f3080c = i2;
        this.f3079b = iBinder;
        this.f3081d = scopeArr;
        this.f3082e = bundle;
        this.f3083f = str;
    }

    public int m5361a() {
        return this.f3080c;
    }

    public Scope[] m5362b() {
        return this.f3081d;
    }

    public String m5363c() {
        return this.f3083f;
    }

    public Bundle m5364d() {
        return this.f3082e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1164g.m5433a(this, parcel, i);
    }
}
