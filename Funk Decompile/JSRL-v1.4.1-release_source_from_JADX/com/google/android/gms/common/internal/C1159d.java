package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1159d implements Creator<ResolveAccountResponse> {
    static void m5381a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, resolveAccountResponse.f3073a);
        C1197b.m5544a(parcel, 2, resolveAccountResponse.f3074b, false);
        C1197b.m5545a(parcel, 3, resolveAccountResponse.m5358b(), i, false);
        C1197b.m5549a(parcel, 4, resolveAccountResponse.m5359c());
        C1197b.m5549a(parcel, 5, resolveAccountResponse.m5360d());
        C1197b.m5540a(parcel, a);
    }

    public ResolveAccountResponse m5382a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = C1196a.m5528b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1196a.m5523a(parcel);
            switch (C1196a.m5522a(a)) {
                case 1:
                    i = C1196a.m5533d(parcel, a);
                    break;
                case 2:
                    iBinder = C1196a.m5537h(parcel, a);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) C1196a.m5525a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = C1196a.m5532c(parcel, a);
                    break;
                case 5:
                    z = C1196a.m5532c(parcel, a);
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountResponse[] m5383a(int i) {
        return new ResolveAccountResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5382a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5383a(i);
    }
}
