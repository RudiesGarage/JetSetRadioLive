package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: FragmentManager */
final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new C01811();
    FragmentState[] f466a;
    int[] f467b;
    BackStackState[] f468c;

    /* compiled from: FragmentManager */
    static class C01811 implements Creator<FragmentManagerState> {
        C01811() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m607a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m608a(i);
        }

        public FragmentManagerState m607a(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public FragmentManagerState[] m608a(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState(Parcel parcel) {
        this.f466a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f467b = parcel.createIntArray();
        this.f468c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f466a, i);
        parcel.writeIntArray(this.f467b);
        parcel.writeTypedArray(this.f468c, i);
    }
}
