package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInRequest extends AbstractSafeParcelable {
    public static final Creator<SignInRequest> CREATOR = new C1253g();
    final int f3225a;
    final ResolveAccountRequest f3226b;

    SignInRequest(int i, ResolveAccountRequest resolveAccountRequest) {
        this.f3225a = i;
        this.f3226b = resolveAccountRequest;
    }

    public ResolveAccountRequest m5713a() {
        return this.f3226b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1253g.m5764a(this, parcel, i);
    }
}
