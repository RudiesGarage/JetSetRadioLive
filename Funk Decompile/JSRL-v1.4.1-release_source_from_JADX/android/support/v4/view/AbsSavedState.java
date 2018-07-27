package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p022e.C0325d;
import android.support.v4.p022e.C0326e;

public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = C0325d.m1196a(new C04442());
    public static final AbsSavedState f1010a = new C04431();
    private final Parcelable f1011b;

    static class C04431 extends AbsSavedState {
        C04431() {
            super();
        }
    }

    static class C04442 implements C0326e<AbsSavedState> {
        C04442() {
        }

        public /* synthetic */ Object mo280a(Parcel parcel, ClassLoader classLoader) {
            return m1715b(parcel, classLoader);
        }

        public /* synthetic */ Object[] mo281a(int i) {
            return m1716b(i);
        }

        public AbsSavedState m1715b(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f1010a;
            }
            throw new IllegalStateException("superState must be null");
        }

        public AbsSavedState[] m1716b(int i) {
            return new AbsSavedState[i];
        }
    }

    private AbsSavedState() {
        this.f1011b = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == f1010a) {
            parcelable = null;
        }
        this.f1011b = parcelable;
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = f1010a;
        }
        this.f1011b = readParcelable;
    }

    public final Parcelable m1712a() {
        return this.f1011b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1011b, i);
    }
}
