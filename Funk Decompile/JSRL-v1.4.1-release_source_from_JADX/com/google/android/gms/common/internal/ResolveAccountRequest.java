package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR = new C1158c();
    final int f3069a;
    private final Account f3070b;
    private final int f3071c;
    private final GoogleSignInAccount f3072d;

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f3069a = i;
        this.f3070b = account;
        this.f3071c = i2;
        this.f3072d = googleSignInAccount;
    }

    public Account m5354a() {
        return this.f3070b;
    }

    public int m5355b() {
        return this.f3071c;
    }

    public GoogleSignInAccount m5356c() {
        return this.f3072d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1158c.m5378a(this, parcel, i);
    }
}
