package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInResponse extends AbstractSafeParcelable {
    public static final Creator<SignInResponse> CREATOR = new C1254h();
    final int f3227a;
    private final ConnectionResult f3228b;
    private final ResolveAccountResponse f3229c;

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f3227a = i;
        this.f3228b = connectionResult;
        this.f3229c = resolveAccountResponse;
    }

    public ConnectionResult m5714a() {
        return this.f3228b;
    }

    public ResolveAccountResponse m5715b() {
        return this.f3229c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1254h.m5767a(this, parcel, i);
    }
}
