package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.media.session.C0441l.C0440a;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new C04081();
    final int f985a;
    final long f986b;
    final long f987c;
    final float f988d;
    final long f989e;
    final CharSequence f990f;
    final long f991g;
    List<CustomAction> f992h;
    final long f993i;
    final Bundle f994j;
    private Object f995k;

    static class C04081 implements Creator<PlaybackStateCompat> {
        C04081() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1584a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1585a(i);
        }

        public PlaybackStateCompat m1584a(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        public PlaybackStateCompat[] m1585a(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new C04091();
        private final String f970a;
        private final CharSequence f971b;
        private final int f972c;
        private final Bundle f973d;
        private Object f974e;

        static class C04091 implements Creator<CustomAction> {
            C04091() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1586a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1587a(i);
            }

            public CustomAction m1586a(Parcel parcel) {
                return new CustomAction(parcel);
            }

            public CustomAction[] m1587a(int i) {
                return new CustomAction[i];
            }
        }

        CustomAction(Parcel parcel) {
            this.f970a = parcel.readString();
            this.f971b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f972c = parcel.readInt();
            this.f973d = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f970a);
            TextUtils.writeToParcel(this.f971b, parcel, i);
            parcel.writeInt(this.f972c);
            parcel.writeBundle(this.f973d);
        }

        public int describeContents() {
            return 0;
        }

        public Object m1588a() {
            if (this.f974e != null || VERSION.SDK_INT < 21) {
                return this.f974e;
            }
            this.f974e = C0440a.m1709a(this.f970a, this.f971b, this.f972c, this.f973d);
            return this.f974e;
        }

        public String toString() {
            return "Action:mName='" + this.f971b + ", mIcon=" + this.f972c + ", mExtras=" + this.f973d;
        }
    }

    public static final class C0410a {
        private final List<CustomAction> f975a = new ArrayList();
        private int f976b;
        private long f977c;
        private long f978d;
        private float f979e;
        private long f980f;
        private CharSequence f981g;
        private long f982h;
        private long f983i = -1;
        private Bundle f984j;

        public C0410a(PlaybackStateCompat playbackStateCompat) {
            this.f976b = playbackStateCompat.f985a;
            this.f977c = playbackStateCompat.f986b;
            this.f979e = playbackStateCompat.f988d;
            this.f982h = playbackStateCompat.f991g;
            this.f978d = playbackStateCompat.f987c;
            this.f980f = playbackStateCompat.f989e;
            this.f981g = playbackStateCompat.f990f;
            if (playbackStateCompat.f992h != null) {
                this.f975a.addAll(playbackStateCompat.f992h);
            }
            this.f983i = playbackStateCompat.f993i;
            this.f984j = playbackStateCompat.f994j;
        }

        public C0410a m1589a(int i, long j, float f) {
            return m1590a(i, j, f, SystemClock.elapsedRealtime());
        }

        public C0410a m1590a(int i, long j, float f, long j2) {
            this.f976b = i;
            this.f977c = j;
            this.f982h = j2;
            this.f979e = f;
            return this;
        }

        public C0410a m1591a(long j) {
            this.f980f = j;
            return this;
        }

        public PlaybackStateCompat m1592a() {
            return new PlaybackStateCompat(this.f976b, this.f977c, this.f978d, this.f979e, this.f980f, this.f981g, this.f982h, this.f975a, this.f983i, this.f984j);
        }
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f985a = i;
        this.f986b = j;
        this.f987c = j2;
        this.f988d = f;
        this.f989e = j3;
        this.f990f = charSequence;
        this.f991g = j4;
        this.f992h = new ArrayList(list);
        this.f993i = j5;
        this.f994j = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f985a = parcel.readInt();
        this.f986b = parcel.readLong();
        this.f988d = parcel.readFloat();
        this.f991g = parcel.readLong();
        this.f987c = parcel.readLong();
        this.f989e = parcel.readLong();
        this.f990f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f992h = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f993i = parcel.readLong();
        this.f994j = parcel.readBundle();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.f985a);
        stringBuilder.append(", position=").append(this.f986b);
        stringBuilder.append(", buffered position=").append(this.f987c);
        stringBuilder.append(", speed=").append(this.f988d);
        stringBuilder.append(", updated=").append(this.f991g);
        stringBuilder.append(", actions=").append(this.f989e);
        stringBuilder.append(", error=").append(this.f990f);
        stringBuilder.append(", custom actions=").append(this.f992h);
        stringBuilder.append(", active item id=").append(this.f993i);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f985a);
        parcel.writeLong(this.f986b);
        parcel.writeFloat(this.f988d);
        parcel.writeLong(this.f991g);
        parcel.writeLong(this.f987c);
        parcel.writeLong(this.f989e);
        TextUtils.writeToParcel(this.f990f, parcel, i);
        parcel.writeTypedList(this.f992h);
        parcel.writeLong(this.f993i);
        parcel.writeBundle(this.f994j);
    }

    public int m1593a() {
        return this.f985a;
    }

    public long m1594b() {
        return this.f986b;
    }

    public float m1595c() {
        return this.f988d;
    }

    public long m1596d() {
        return this.f989e;
    }

    public long m1597e() {
        return this.f991g;
    }

    public Object m1598f() {
        if (this.f995k != null || VERSION.SDK_INT < 21) {
            return this.f995k;
        }
        List list = null;
        if (this.f992h != null) {
            list = new ArrayList(this.f992h.size());
            for (CustomAction a : this.f992h) {
                list.add(a.m1588a());
            }
        }
        if (VERSION.SDK_INT >= 22) {
            this.f995k = C0442m.m1711a(this.f985a, this.f986b, this.f987c, this.f988d, this.f989e, this.f990f, this.f991g, list, this.f993i, this.f994j);
        } else {
            this.f995k = C0441l.m1710a(this.f985a, this.f986b, this.f987c, this.f988d, this.f989e, this.f990f, this.f991g, list, this.f993i);
        }
        return this.f995k;
    }
}
