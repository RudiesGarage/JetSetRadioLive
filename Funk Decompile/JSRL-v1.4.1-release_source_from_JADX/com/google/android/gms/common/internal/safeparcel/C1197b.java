package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class C1197b {
    public static int m5539a(Parcel parcel) {
        return C1197b.m5552b(parcel, 20293);
    }

    public static void m5540a(Parcel parcel, int i) {
        C1197b.m5554c(parcel, i);
    }

    public static void m5541a(Parcel parcel, int i, int i2) {
        C1197b.m5553b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m5542a(Parcel parcel, int i, long j) {
        C1197b.m5553b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m5543a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = C1197b.m5552b(parcel, i);
            parcel.writeBundle(bundle);
            C1197b.m5554c(parcel, b);
        } else if (z) {
            C1197b.m5553b(parcel, i, 0);
        }
    }

    public static void m5544a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = C1197b.m5552b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C1197b.m5554c(parcel, b);
        } else if (z) {
            C1197b.m5553b(parcel, i, 0);
        }
    }

    public static void m5545a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = C1197b.m5552b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C1197b.m5554c(parcel, b);
        } else if (z) {
            C1197b.m5553b(parcel, i, 0);
        }
    }

    public static void m5546a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C1197b.m5553b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C1197b.m5553b(parcel, i, 0);
        }
    }

    public static void m5547a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = C1197b.m5552b(parcel, i);
            parcel.writeString(str);
            C1197b.m5554c(parcel, b);
        } else if (z) {
            C1197b.m5553b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m5548a(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = C1197b.m5552b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C1197b.m5551a(parcel, parcelable, 0);
                }
            }
            C1197b.m5554c(parcel, b);
        } else if (z) {
            C1197b.m5553b(parcel, i, 0);
        }
    }

    public static void m5549a(Parcel parcel, int i, boolean z) {
        C1197b.m5553b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static <T extends Parcelable> void m5550a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = C1197b.m5552b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C1197b.m5551a(parcel, parcelable, i2);
                }
            }
            C1197b.m5554c(parcel, b);
        } else if (z) {
            C1197b.m5553b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m5551a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int m5552b(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m5553b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    private static void m5554c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }
}
