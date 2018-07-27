package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1165h implements Creator<AuthAccountRequest> {
    static void m5436a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, authAccountRequest.f3055a);
        C1197b.m5544a(parcel, 2, authAccountRequest.f3056b, false);
        C1197b.m5550a(parcel, 3, authAccountRequest.f3057c, i, false);
        C1197b.m5546a(parcel, 4, authAccountRequest.f3058d, false);
        C1197b.m5546a(parcel, 5, authAccountRequest.f3059e, false);
        C1197b.m5540a(parcel, a);
    }

    public AuthAccountRequest m5437a(Parcel parcel) {
        Integer num = null;
        int b = C1196a.m5528b(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    scopeArr = (Scope[]) C1196a.m5530b(parcel, a, Scope.CREATOR);
                    break;
                case 4:
                    num2 = C1196a.m5534e(parcel, a);
                    break;
                case 5:
                    num = C1196a.m5534e(parcel, a);
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountRequest[] m5438a(int i) {
        return new AuthAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5437a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5438a(i);
    }
}
