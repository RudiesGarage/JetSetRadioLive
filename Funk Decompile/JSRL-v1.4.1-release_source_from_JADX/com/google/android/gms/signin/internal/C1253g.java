package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1253g implements Creator<SignInRequest> {
    static void m5764a(SignInRequest signInRequest, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, signInRequest.f3225a);
        C1197b.m5545a(parcel, 2, signInRequest.m5713a(), i, false);
        C1197b.m5540a(parcel, a);
    }

    public SignInRequest m5765a(Parcel parcel) {
        int b = C1196a.m5528b(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < b) {
            int a = C1196a.m5523a(parcel);
            switch (C1196a.m5522a(a)) {
                case 1:
                    i = C1196a.m5533d(parcel, a);
                    break;
                case 2:
                    resolveAccountRequest = (ResolveAccountRequest) C1196a.m5525a(parcel, a, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public SignInRequest[] m5766a(int i) {
        return new SignInRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5765a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5766a(i);
    }
}
