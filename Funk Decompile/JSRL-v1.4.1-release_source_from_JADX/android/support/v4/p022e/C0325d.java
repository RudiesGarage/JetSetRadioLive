package android.support.v4.p022e;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ParcelableCompat */
public final class C0325d {

    /* compiled from: ParcelableCompat */
    static class C0324a<T> implements Creator<T> {
        final C0326e<T> f797a;

        public C0324a(C0326e<T> c0326e) {
            this.f797a = c0326e;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f797a.mo280a(parcel, null);
        }

        public T[] newArray(int i) {
            return this.f797a.mo281a(i);
        }
    }

    public static <T> Creator<T> m1196a(C0326e<T> c0326e) {
        if (VERSION.SDK_INT >= 13) {
            return C0328g.m1199a(c0326e);
        }
        return new C0324a(c0326e);
    }
}
