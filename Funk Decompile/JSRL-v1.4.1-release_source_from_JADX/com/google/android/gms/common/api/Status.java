package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1211z;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Status extends AbstractSafeParcelable implements C1127f, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new C1144l();
    public static final Status f2999a = new Status(0);
    public static final Status f3000b = new Status(14);
    public static final Status f3001c = new Status(8);
    public static final Status f3002d = new Status(15);
    public static final Status f3003e = new Status(16);
    public static final Status f3004f = new Status(17);
    public static final Status f3005g = new Status(18);
    final int f3006h;
    private final int f3007i;
    private final String f3008j;
    private final PendingIntent f3009k;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f3006h = i;
        this.f3007i = i2;
        this.f3008j = str;
        this.f3009k = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public Status mo772a() {
        return this;
    }

    PendingIntent m5283b() {
        return this.f3009k;
    }

    public String m5284c() {
        return this.f3008j;
    }

    public int m5285d() {
        return this.f3007i;
    }

    public String m5286e() {
        return this.f3008j != null ? this.f3008j : C1134b.m5297a(this.f3007i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f3006h == status.f3006h && this.f3007i == status.f3007i && C1211z.m5661a(this.f3008j, status.f3008j) && C1211z.m5661a(this.f3009k, status.f3009k);
    }

    public int hashCode() {
        return C1211z.m5659a(Integer.valueOf(this.f3006h), Integer.valueOf(this.f3007i), this.f3008j, this.f3009k);
    }

    public String toString() {
        return C1211z.m5660a((Object) this).m5658a("statusCode", m5286e()).m5658a("resolution", this.f3009k).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1144l.m5311a(this, parcel, i);
    }
}
