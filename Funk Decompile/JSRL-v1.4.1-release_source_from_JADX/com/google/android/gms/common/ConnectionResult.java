package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1211z;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class ConnectionResult extends AbstractSafeParcelable {
    public static final Creator<ConnectionResult> CREATOR = new C1153h();
    public static final ConnectionResult f2960a = new ConnectionResult(0);
    final int f2961b;
    private final int f2962c;
    private final PendingIntent f2963d;
    private final String f2964e;

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f2961b = i;
        this.f2962c = i2;
        this.f2963d = pendingIntent;
        this.f2964e = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String m5258a(int i) {
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case 16:
                return "API_UNAVAILABLE";
            case 17:
                return "SIGN_IN_FAILED";
            case 18:
                return "SERVICE_UPDATING";
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            case 20:
                return "RESTRICTED_PROFILE";
            case 21:
                return "API_VERSION_UPDATE_REQUIRED";
            case 99:
                return "UNFINISHED";
            case 1500:
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    public boolean m5259a() {
        return (this.f2962c == 0 || this.f2963d == null) ? false : true;
    }

    public boolean m5260b() {
        return this.f2962c == 0;
    }

    public int m5261c() {
        return this.f2962c;
    }

    public PendingIntent m5262d() {
        return this.f2963d;
    }

    public String m5263e() {
        return this.f2964e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f2962c == connectionResult.f2962c && C1211z.m5661a(this.f2963d, connectionResult.f2963d) && C1211z.m5661a(this.f2964e, connectionResult.f2964e);
    }

    public int hashCode() {
        return C1211z.m5659a(Integer.valueOf(this.f2962c), this.f2963d, this.f2964e);
    }

    public String toString() {
        return C1211z.m5660a((Object) this).m5658a("statusCode", m5258a(this.f2962c)).m5658a("resolution", this.f2963d).m5658a("message", this.f2964e).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1153h.m5345a(this, parcel, i);
    }
}
