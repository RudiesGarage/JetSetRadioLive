package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1254h implements Creator<SignInResponse> {
    static void m5767a(SignInResponse signInResponse, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, signInResponse.f3227a);
        C1197b.m5545a(parcel, 2, signInResponse.m5714a(), i, false);
        C1197b.m5545a(parcel, 3, signInResponse.m5715b(), i, false);
        C1197b.m5540a(parcel, a);
    }

    public SignInResponse m5768a(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse = null;
        int b = C1196a.m5528b(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < b) {
            ConnectionResult connectionResult2;
            int d;
            ResolveAccountResponse resolveAccountResponse2;
            int a = C1196a.m5523a(parcel);
            switch (C1196a.m5522a(a)) {
                case 1:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    d = C1196a.m5533d(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse3;
                    break;
                case 2:
                    d = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) C1196a.m5525a(parcel, a, ConnectionResult.CREATOR);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult3;
                    break;
                case 3:
                    resolveAccountResponse2 = (ResolveAccountResponse) C1196a.m5525a(parcel, a, ResolveAccountResponse.CREATOR);
                    connectionResult2 = connectionResult;
                    d = i;
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    d = i;
                    break;
            }
            i = d;
            connectionResult = connectionResult2;
            resolveAccountResponse = resolveAccountResponse2;
        }
        if (parcel.dataPosition() == b) {
            return new SignInResponse(i, connectionResult, resolveAccountResponse);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public SignInResponse[] m5769a(int i) {
        return new SignInResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5768a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5769a(i);
    }
}
