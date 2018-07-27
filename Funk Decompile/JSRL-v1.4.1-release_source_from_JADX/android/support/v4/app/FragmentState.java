package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

/* compiled from: Fragment */
final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new C01821();
    final String f469a;
    final int f470b;
    final boolean f471c;
    final int f472d;
    final int f473e;
    final String f474f;
    final boolean f475g;
    final boolean f476h;
    final Bundle f477i;
    final boolean f478j;
    Bundle f479k;
    Fragment f480l;

    /* compiled from: Fragment */
    static class C01821 implements Creator<FragmentState> {
        C01821() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m609a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m610a(i);
        }

        public FragmentState m609a(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public FragmentState[] m610a(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f469a = fragment.getClass().getName();
        this.f470b = fragment.mIndex;
        this.f471c = fragment.mFromLayout;
        this.f472d = fragment.mFragmentId;
        this.f473e = fragment.mContainerId;
        this.f474f = fragment.mTag;
        this.f475g = fragment.mRetainInstance;
        this.f476h = fragment.mDetached;
        this.f477i = fragment.mArguments;
        this.f478j = fragment.mHidden;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f469a = parcel.readString();
        this.f470b = parcel.readInt();
        this.f471c = parcel.readInt() != 0;
        this.f472d = parcel.readInt();
        this.f473e = parcel.readInt();
        this.f474f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f475g = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f476h = z;
        this.f477i = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f478j = z2;
        this.f479k = parcel.readBundle();
    }

    public Fragment m611a(C0220m c0220m, Fragment fragment, C0235p c0235p) {
        if (this.f480l == null) {
            Context i = c0220m.m742i();
            if (this.f477i != null) {
                this.f477i.setClassLoader(i.getClassLoader());
            }
            this.f480l = Fragment.instantiate(i, this.f469a, this.f477i);
            if (this.f479k != null) {
                this.f479k.setClassLoader(i.getClassLoader());
                this.f480l.mSavedFragmentState = this.f479k;
            }
            this.f480l.setIndex(this.f470b, fragment);
            this.f480l.mFromLayout = this.f471c;
            this.f480l.mRestored = true;
            this.f480l.mFragmentId = this.f472d;
            this.f480l.mContainerId = this.f473e;
            this.f480l.mTag = this.f474f;
            this.f480l.mRetainInstance = this.f475g;
            this.f480l.mDetached = this.f476h;
            this.f480l.mHidden = this.f478j;
            this.f480l.mFragmentManager = c0220m.f574d;
            if (C0234o.f612a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f480l);
            }
        }
        this.f480l.mChildNonConfig = c0235p;
        return this.f480l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f469a);
        parcel.writeInt(this.f470b);
        parcel.writeInt(this.f471c ? 1 : 0);
        parcel.writeInt(this.f472d);
        parcel.writeInt(this.f473e);
        parcel.writeString(this.f474f);
        if (this.f475g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f476h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f477i);
        if (!this.f478j) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f479k);
    }
}
