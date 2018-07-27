package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1184m implements Creator<GetServiceRequest> {
    static void m5486a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, getServiceRequest.f3060a);
        C1197b.m5541a(parcel, 2, getServiceRequest.f3061b);
        C1197b.m5541a(parcel, 3, getServiceRequest.f3062c);
        C1197b.m5547a(parcel, 4, getServiceRequest.f3063d, false);
        C1197b.m5544a(parcel, 5, getServiceRequest.f3064e, false);
        C1197b.m5550a(parcel, 6, getServiceRequest.f3065f, i, false);
        C1197b.m5543a(parcel, 7, getServiceRequest.f3066g, false);
        C1197b.m5545a(parcel, 8, getServiceRequest.f3067h, i, false);
        C1197b.m5542a(parcel, 9, getServiceRequest.f3068i);
        C1197b.m5540a(parcel, a);
    }

    public GetServiceRequest m5487a(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = C1196a.m5528b(parcel);
        long j = 0;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1196a.m5523a(parcel);
            switch (C1196a.m5522a(a)) {
                case 1:
                    i3 = C1196a.m5533d(parcel, a);
                    break;
                case 2:
                    i2 = C1196a.m5533d(parcel, a);
                    break;
                case 3:
                    i = C1196a.m5533d(parcel, a);
                    break;
                case 4:
                    str = C1196a.m5536g(parcel, a);
                    break;
                case 5:
                    iBinder = C1196a.m5537h(parcel, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) C1196a.m5530b(parcel, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = C1196a.m5538i(parcel, a);
                    break;
                case 8:
                    account = (Account) C1196a.m5525a(parcel, a, Account.CREATOR);
                    break;
                case 9:
                    j = C1196a.m5535f(parcel, a);
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account, j);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public GetServiceRequest[] m5488a(int i) {
        return new GetServiceRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5487a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5488a(i);
    }
}
