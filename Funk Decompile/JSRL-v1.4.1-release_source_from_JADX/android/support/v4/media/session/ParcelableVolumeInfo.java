package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new C04071();
    public int f965a;
    public int f966b;
    public int f967c;
    public int f968d;
    public int f969e;

    static class C04071 implements Creator<ParcelableVolumeInfo> {
        C04071() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1582a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1583a(i);
        }

        public ParcelableVolumeInfo m1582a(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        public ParcelableVolumeInfo[] m1583a(int i) {
            return new ParcelableVolumeInfo[i];
        }
    }

    public ParcelableVolumeInfo(int i, int i2, int i3, int i4, int i5) {
        this.f965a = i;
        this.f966b = i2;
        this.f967c = i3;
        this.f968d = i4;
        this.f969e = i5;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f965a = parcel.readInt();
        this.f967c = parcel.readInt();
        this.f968d = parcel.readInt();
        this.f969e = parcel.readInt();
        this.f966b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f965a);
        parcel.writeInt(this.f967c);
        parcel.writeInt(this.f968d);
        parcel.writeInt(this.f969e);
        parcel.writeInt(this.f966b);
    }
}
