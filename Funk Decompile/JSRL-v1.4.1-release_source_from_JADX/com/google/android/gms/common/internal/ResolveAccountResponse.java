package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1154r.C1155a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new C1159d();
    final int f3073a;
    IBinder f3074b;
    private ConnectionResult f3075c;
    private boolean f3076d;
    private boolean f3077e;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f3073a = i;
        this.f3074b = iBinder;
        this.f3075c = connectionResult;
        this.f3076d = z;
        this.f3077e = z2;
    }

    public C1154r m5357a() {
        return C1155a.m5366a(this.f3074b);
    }

    public ConnectionResult m5358b() {
        return this.f3075c;
    }

    public boolean m5359c() {
        return this.f3076d;
    }

    public boolean m5360d() {
        return this.f3077e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f3075c.equals(resolveAccountResponse.f3075c) && m5357a().equals(resolveAccountResponse.m5357a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1159d.m5381a(this, parcel, i);
    }
}
