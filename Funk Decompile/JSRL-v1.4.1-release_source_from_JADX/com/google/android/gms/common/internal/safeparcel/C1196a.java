package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class C1196a {

    public static class C1195a extends RuntimeException {
        public C1195a(String str, Parcel parcel) {
            int dataPosition = parcel.dataPosition();
            super(new StringBuilder(String.valueOf(str).length() + 41).append(str).append(" Parcel: pos=").append(dataPosition).append(" size=").append(parcel.dataSize()).toString());
        }
    }

    public static int m5522a(int i) {
        return 65535 & i;
    }

    public static int m5523a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m5524a(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T m5525a(Parcel parcel, int i, Creator<T> creator) {
        int a = C1196a.m5524a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m5526a(Parcel parcel, int i, int i2) {
        int a = C1196a.m5524a(parcel, i);
        if (a != i2) {
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C1195a(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i2).append(" got ").append(a).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    private static void m5527a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String valueOf = String.valueOf(Integer.toHexString(i2));
            throw new C1195a(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    public static int m5528b(Parcel parcel) {
        int a = C1196a.m5523a(parcel);
        int a2 = C1196a.m5524a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (C1196a.m5522a(a) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C1195a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        a = dataPosition + a2;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new C1195a("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m5529b(Parcel parcel, int i) {
        parcel.setDataPosition(C1196a.m5524a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m5530b(Parcel parcel, int i, Creator<T> creator) {
        int a = C1196a.m5524a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m5531c(Parcel parcel, int i, Creator<T> creator) {
        int a = C1196a.m5524a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m5532c(Parcel parcel, int i) {
        C1196a.m5526a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int m5533d(Parcel parcel, int i) {
        C1196a.m5526a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m5534e(Parcel parcel, int i) {
        int a = C1196a.m5524a(parcel, i);
        if (a == 0) {
            return null;
        }
        C1196a.m5527a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m5535f(Parcel parcel, int i) {
        C1196a.m5526a(parcel, i, 8);
        return parcel.readLong();
    }

    public static String m5536g(Parcel parcel, int i) {
        int a = C1196a.m5524a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m5537h(Parcel parcel, int i) {
        int a = C1196a.m5524a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m5538i(Parcel parcel, int i) {
        int a = C1196a.m5524a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }
}
