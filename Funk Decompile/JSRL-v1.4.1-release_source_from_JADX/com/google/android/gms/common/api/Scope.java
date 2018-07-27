package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1157b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new C1143k();
    final int f2997a;
    private final String f2998b;

    Scope(int i, String str) {
        C1157b.m5372a(str, (Object) "scopeUri must not be null or empty");
        this.f2997a = i;
        this.f2998b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public String m5280a() {
        return this.f2998b;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.f2998b.equals(((Scope) obj).f2998b);
    }

    public int hashCode() {
        return this.f2998b.hashCode();
    }

    public String toString() {
        return this.f2998b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1143k.m5308a(this, parcel, i);
    }
}
