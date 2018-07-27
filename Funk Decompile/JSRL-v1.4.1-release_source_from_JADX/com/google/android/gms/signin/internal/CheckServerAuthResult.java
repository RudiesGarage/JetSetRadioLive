package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class CheckServerAuthResult extends AbstractSafeParcelable {
    public static final Creator<CheckServerAuthResult> CREATOR = new C1244b();
    final int f3218a;
    final boolean f3219b;
    final List<Scope> f3220c;

    CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        this.f3218a = i;
        this.f3219b = z;
        this.f3220c = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1244b.m5719a(this, parcel, i);
    }
}
