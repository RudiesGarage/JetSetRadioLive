package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new C03761();
    private final int f909a;
    private final float f910b;
    private Object f911c;

    static class C03761 implements Creator<RatingCompat> {
        C03761() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1361a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1362a(i);
        }

        public RatingCompat m1361a(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public RatingCompat[] m1362a(int i) {
            return new RatingCompat[i];
        }
    }

    RatingCompat(int i, float f) {
        this.f909a = i;
        this.f910b = f;
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder().append("Rating:style=").append(this.f909a).append(" rating=");
        if (this.f910b < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(this.f910b);
        }
        return append.append(str).toString();
    }

    public int describeContents() {
        return this.f909a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f909a);
        parcel.writeFloat(this.f910b);
    }

    public static RatingCompat m1364a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    public static RatingCompat m1367a(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat m1368b(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat m1365a(int i, float f) {
        float f2;
        switch (i) {
            case 3:
                f2 = 3.0f;
                break;
            case 4:
                f2 = 4.0f;
                break;
            case 5:
                f2 = 5.0f;
                break;
            default:
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
        }
        if (f >= 0.0f && f <= r1) {
            return new RatingCompat(i, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat m1363a(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat m1366a(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null && VERSION.SDK_INT >= 19) {
            int b = C0381c.m1390b(obj);
            if (C0381c.m1389a(obj)) {
                switch (b) {
                    case 1:
                        ratingCompat = m1367a(C0381c.m1391c(obj));
                        break;
                    case 2:
                        ratingCompat = m1368b(C0381c.m1392d(obj));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = m1365a(b, C0381c.m1393e(obj));
                        break;
                    case 6:
                        ratingCompat = m1363a(C0381c.m1394f(obj));
                        break;
                    default:
                        break;
                }
            }
            ratingCompat = m1364a(b);
            ratingCompat.f911c = obj;
        }
        return ratingCompat;
    }
}
