package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1143k implements Creator<Scope> {
    static void m5308a(Scope scope, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, scope.f2997a);
        C1197b.m5547a(parcel, 2, scope.m5280a(), false);
        C1197b.m5540a(parcel, a);
    }

    public Scope m5309a(Parcel parcel) {
        int b = C1196a.m5528b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C1196a.m5523a(parcel);
            switch (C1196a.m5522a(a)) {
                case 1:
                    i = C1196a.m5533d(parcel, a);
                    break;
                case 2:
                    str = C1196a.m5536g(parcel, a);
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Scope(i, str);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public Scope[] m5310a(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5309a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5310a(i);
    }
}
