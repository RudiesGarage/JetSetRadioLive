package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1164g implements Creator<ValidateAccountRequest> {
    static void m5433a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, validateAccountRequest.f3078a);
        C1197b.m5541a(parcel, 2, validateAccountRequest.m5361a());
        C1197b.m5544a(parcel, 3, validateAccountRequest.f3079b, false);
        C1197b.m5550a(parcel, 4, validateAccountRequest.m5362b(), i, false);
        C1197b.m5543a(parcel, 5, validateAccountRequest.m5364d(), false);
        C1197b.m5547a(parcel, 6, validateAccountRequest.m5363c(), false);
        C1197b.m5540a(parcel, a);
    }

    public ValidateAccountRequest m5434a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = C1196a.m5528b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1196a.m5523a(parcel);
            switch (C1196a.m5522a(a)) {
                case 1:
                    i2 = C1196a.m5533d(parcel, a);
                    break;
                case 2:
                    i = C1196a.m5533d(parcel, a);
                    break;
                case 3:
                    iBinder = C1196a.m5537h(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) C1196a.m5530b(parcel, a, Scope.CREATOR);
                    break;
                case 5:
                    bundle = C1196a.m5538i(parcel, a);
                    break;
                case 6:
                    str = C1196a.m5536g(parcel, a);
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public ValidateAccountRequest[] m5435a(int i) {
        return new ValidateAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5434a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5435a(i);
    }
}
