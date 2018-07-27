package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1153h implements Creator<ConnectionResult> {
    static void m5345a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, connectionResult.f2961b);
        C1197b.m5541a(parcel, 2, connectionResult.m5261c());
        C1197b.m5545a(parcel, 3, connectionResult.m5262d(), i, false);
        C1197b.m5547a(parcel, 4, connectionResult.m5263e(), false);
        C1197b.m5540a(parcel, a);
    }

    public ConnectionResult m5346a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C1196a.m5528b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = C1196a.m5523a(parcel);
            String str3;
            switch (C1196a.m5522a(a)) {
                case 1:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = C1196a.m5533d(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = C1196a.m5533d(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) C1196a.m5525a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C1196a.m5536g(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] m5347a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5346a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5347a(i);
    }
}
