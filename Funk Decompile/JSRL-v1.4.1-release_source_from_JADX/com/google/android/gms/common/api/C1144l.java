package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1144l implements Creator<Status> {
    static void m5311a(Status status, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, status.m5285d());
        C1197b.m5547a(parcel, 2, status.m5284c(), false);
        C1197b.m5545a(parcel, 3, status.m5283b(), i, false);
        C1197b.m5541a(parcel, 1000, status.f3006h);
        C1197b.m5540a(parcel, a);
    }

    public Status m5312a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = C1196a.m5528b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1196a.m5523a(parcel);
            switch (C1196a.m5522a(a)) {
                case 1:
                    i = C1196a.m5533d(parcel, a);
                    break;
                case 2:
                    str = C1196a.m5536g(parcel, a);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) C1196a.m5525a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = C1196a.m5533d(parcel, a);
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public Status[] m5313a(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5312a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5313a(i);
    }
}
