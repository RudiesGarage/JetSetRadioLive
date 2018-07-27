package android.support.v4.p022e;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: ParcelableCompatHoneycombMR2 */
class C0327f<T> implements ClassLoaderCreator<T> {
    private final C0326e<T> f798a;

    public C0327f(C0326e<T> c0326e) {
        this.f798a = c0326e;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f798a.mo280a(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f798a.mo280a(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f798a.mo281a(i);
    }
}
