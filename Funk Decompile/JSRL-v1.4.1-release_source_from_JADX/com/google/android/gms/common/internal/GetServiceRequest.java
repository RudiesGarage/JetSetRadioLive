package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C1146i;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1154r.C1155a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collection;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new C1184m();
    final int f3060a;
    final int f3061b;
    int f3062c;
    String f3063d;
    IBinder f3064e;
    Scope[] f3065f;
    Bundle f3066g;
    Account f3067h;
    long f3068i;

    public GetServiceRequest(int i) {
        this.f3060a = 3;
        this.f3062c = C1146i.f3045b;
        this.f3061b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.f3060a = i;
        this.f3061b = i2;
        this.f3062c = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f3063d = "com.google.android.gms";
        } else {
            this.f3063d = str;
        }
        if (i < 2) {
            this.f3067h = m5348a(iBinder);
        } else {
            this.f3064e = iBinder;
            this.f3067h = account;
        }
        this.f3065f = scopeArr;
        this.f3066g = bundle;
        this.f3068i = j;
    }

    private Account m5348a(IBinder iBinder) {
        return iBinder != null ? C1156a.m5367a(C1155a.m5366a(iBinder)) : null;
    }

    public GetServiceRequest m5349a(Account account) {
        this.f3067h = account;
        return this;
    }

    public GetServiceRequest m5350a(Bundle bundle) {
        this.f3066g = bundle;
        return this;
    }

    public GetServiceRequest m5351a(C1154r c1154r) {
        if (c1154r != null) {
            this.f3064e = c1154r.asBinder();
        }
        return this;
    }

    public GetServiceRequest m5352a(String str) {
        this.f3063d = str;
        return this;
    }

    public GetServiceRequest m5353a(Collection<Scope> collection) {
        this.f3065f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1184m.m5486a(this, parcel, i);
    }
}
