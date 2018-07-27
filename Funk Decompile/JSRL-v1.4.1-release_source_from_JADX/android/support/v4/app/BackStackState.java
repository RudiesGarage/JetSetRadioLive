package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.C0214e.C0211a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: BackStackRecord */
final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new C01761();
    final int[] f453a;
    final int f454b;
    final int f455c;
    final String f456d;
    final int f457e;
    final int f458f;
    final CharSequence f459g;
    final int f460h;
    final CharSequence f461i;
    final ArrayList<String> f462j;
    final ArrayList<String> f463k;

    /* compiled from: BackStackRecord */
    static class C01761 implements Creator<BackStackState> {
        C01761() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m598a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m599a(i);
        }

        public BackStackState m598a(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public BackStackState[] m599a(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(C0214e c0214e) {
        int i = 0;
        for (C0211a c0211a = c0214e.f548c; c0211a != null; c0211a = c0211a.f532a) {
            if (c0211a.f540i != null) {
                i += c0211a.f540i.size();
            }
        }
        this.f453a = new int[(i + (c0214e.f550e * 7))];
        if (c0214e.f557l) {
            i = 0;
            for (C0211a c0211a2 = c0214e.f548c; c0211a2 != null; c0211a2 = c0211a2.f532a) {
                int i2 = i + 1;
                this.f453a[i] = c0211a2.f534c;
                int i3 = i2 + 1;
                this.f453a[i2] = c0211a2.f535d != null ? c0211a2.f535d.mIndex : -1;
                int i4 = i3 + 1;
                this.f453a[i3] = c0211a2.f536e;
                i2 = i4 + 1;
                this.f453a[i4] = c0211a2.f537f;
                i4 = i2 + 1;
                this.f453a[i2] = c0211a2.f538g;
                i2 = i4 + 1;
                this.f453a[i4] = c0211a2.f539h;
                if (c0211a2.f540i != null) {
                    int size = c0211a2.f540i.size();
                    i4 = i2 + 1;
                    this.f453a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f453a[i4] = ((Fragment) c0211a2.f540i.get(i2)).mIndex;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f453a[i2] = 0;
                }
            }
            this.f454b = c0214e.f555j;
            this.f455c = c0214e.f556k;
            this.f456d = c0214e.f559n;
            this.f457e = c0214e.f561p;
            this.f458f = c0214e.f562q;
            this.f459g = c0214e.f563r;
            this.f460h = c0214e.f564s;
            this.f461i = c0214e.f565t;
            this.f462j = c0214e.f566u;
            this.f463k = c0214e.f567v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f453a = parcel.createIntArray();
        this.f454b = parcel.readInt();
        this.f455c = parcel.readInt();
        this.f456d = parcel.readString();
        this.f457e = parcel.readInt();
        this.f458f = parcel.readInt();
        this.f459g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f460h = parcel.readInt();
        this.f461i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f462j = parcel.createStringArrayList();
        this.f463k = parcel.createStringArrayList();
    }

    public C0214e m600a(C0234o c0234o) {
        C0214e c0214e = new C0214e(c0234o);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f453a.length) {
            C0211a c0211a = new C0211a();
            int i3 = i2 + 1;
            c0211a.f534c = this.f453a[i2];
            if (C0234o.f612a) {
                Log.v("FragmentManager", "Instantiate " + c0214e + " op #" + i + " base fragment #" + this.f453a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f453a[i3];
            if (i2 >= 0) {
                c0211a.f535d = (Fragment) c0234o.f618f.get(i2);
            } else {
                c0211a.f535d = null;
            }
            i3 = i4 + 1;
            c0211a.f536e = this.f453a[i4];
            i4 = i3 + 1;
            c0211a.f537f = this.f453a[i3];
            i3 = i4 + 1;
            c0211a.f538g = this.f453a[i4];
            int i5 = i3 + 1;
            c0211a.f539h = this.f453a[i3];
            i4 = i5 + 1;
            int i6 = this.f453a[i5];
            if (i6 > 0) {
                c0211a.f540i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0234o.f612a) {
                        Log.v("FragmentManager", "Instantiate " + c0214e + " set remove fragment #" + this.f453a[i4]);
                    }
                    i5 = i4 + 1;
                    c0211a.f540i.add((Fragment) c0234o.f618f.get(this.f453a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0214e.f551f = c0211a.f536e;
            c0214e.f552g = c0211a.f537f;
            c0214e.f553h = c0211a.f538g;
            c0214e.f554i = c0211a.f539h;
            c0214e.m709a(c0211a);
            i++;
            i2 = i4;
        }
        c0214e.f555j = this.f454b;
        c0214e.f556k = this.f455c;
        c0214e.f559n = this.f456d;
        c0214e.f561p = this.f457e;
        c0214e.f557l = true;
        c0214e.f562q = this.f458f;
        c0214e.f563r = this.f459g;
        c0214e.f564s = this.f460h;
        c0214e.f565t = this.f461i;
        c0214e.f566u = this.f462j;
        c0214e.f567v = this.f463k;
        c0214e.m708a(1);
        return c0214e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f453a);
        parcel.writeInt(this.f454b);
        parcel.writeInt(this.f455c);
        parcel.writeString(this.f456d);
        parcel.writeInt(this.f457e);
        parcel.writeInt(this.f458f);
        TextUtils.writeToParcel(this.f459g, parcel, 0);
        parcel.writeInt(this.f460h);
        TextUtils.writeToParcel(this.f461i, parcel, 0);
        parcel.writeStringList(this.f462j);
        parcel.writeStringList(this.f463k);
    }
}
