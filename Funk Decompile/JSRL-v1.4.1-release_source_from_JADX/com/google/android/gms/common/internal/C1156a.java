package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C1120k;
import com.google.android.gms.common.internal.C1154r.C1155a;

public class C1156a extends C1155a {
    int f3084a;

    public static Account m5367a(C1154r c1154r) {
        Account account = null;
        if (c1154r != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = c1154r.mo782a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account mo782a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.f3084a) {
            if (C1120k.zzf(null, callingUid)) {
                this.f3084a = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        Account account = null;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1156a)) {
            return false;
        }
        C1156a c1156a = (C1156a) obj;
        return account.equals(account);
    }
}
