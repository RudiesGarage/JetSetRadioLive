package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Creator<AuthAccountRequest> CREATOR = new C1165h();
    final int f3055a;
    final IBinder f3056b;
    final Scope[] f3057c;
    Integer f3058d;
    Integer f3059e;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.f3055a = i;
        this.f3056b = iBinder;
        this.f3057c = scopeArr;
        this.f3058d = num;
        this.f3059e = num2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1165h.m5436a(this, parcel, i);
    }
}
