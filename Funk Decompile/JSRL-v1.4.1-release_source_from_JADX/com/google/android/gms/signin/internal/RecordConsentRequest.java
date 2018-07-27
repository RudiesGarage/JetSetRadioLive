package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR = new C1251e();
    final int f3221a;
    private final Account f3222b;
    private final Scope[] f3223c;
    private final String f3224d;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.f3221a = i;
        this.f3222b = account;
        this.f3223c = scopeArr;
        this.f3224d = str;
    }

    public Account m5710a() {
        return this.f3222b;
    }

    public Scope[] m5711b() {
        return this.f3223c;
    }

    public String m5712c() {
        return this.f3224d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1251e.m5754a(this, parcel, i);
    }
}
