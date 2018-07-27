package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1243a implements Creator<AuthAccountResult> {
    static void m5716a(AuthAccountResult authAccountResult, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, authAccountResult.f3215a);
        C1197b.m5541a(parcel, 2, authAccountResult.m5708b());
        C1197b.m5545a(parcel, 3, authAccountResult.m5709c(), i, false);
        C1197b.m5540a(parcel, a);
    }

    public AuthAccountResult m5717a(Parcel parcel) {
        int i = 0;
        int b = C1196a.m5528b(parcel);
        Intent intent = null;
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
                    intent = (Intent) C1196a.m5525a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountResult(i2, i, intent);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountResult[] m5718a(int i) {
        return new AuthAccountResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5717a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5718a(i);
    }
}
