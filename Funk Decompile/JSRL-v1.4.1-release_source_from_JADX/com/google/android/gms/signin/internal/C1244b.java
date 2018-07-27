package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;
import java.util.List;

public class C1244b implements Creator<CheckServerAuthResult> {
    static void m5719a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, checkServerAuthResult.f3218a);
        C1197b.m5549a(parcel, 2, checkServerAuthResult.f3219b);
        C1197b.m5548a(parcel, 3, checkServerAuthResult.f3220c, false);
        C1197b.m5540a(parcel, a);
    }

    public CheckServerAuthResult m5720a(Parcel parcel) {
        boolean z = false;
        int b = C1196a.m5528b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1196a.m5523a(parcel);
            switch (C1196a.m5522a(a)) {
                case 1:
                    i = C1196a.m5533d(parcel, a);
                    break;
                case 2:
                    z = C1196a.m5532c(parcel, a);
                    break;
                case 3:
                    list = C1196a.m5531c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public CheckServerAuthResult[] m5721a(int i) {
        return new CheckServerAuthResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5720a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5721a(i);
    }
}
