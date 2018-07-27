package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1158c implements Creator<ResolveAccountRequest> {
    static void m5378a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, resolveAccountRequest.f3069a);
        C1197b.m5545a(parcel, 2, resolveAccountRequest.m5354a(), i, false);
        C1197b.m5541a(parcel, 3, resolveAccountRequest.m5355b());
        C1197b.m5545a(parcel, 4, resolveAccountRequest.m5356c(), i, false);
        C1197b.m5540a(parcel, a);
    }

    public ResolveAccountRequest m5379a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int b = C1196a.m5528b(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            Account account2;
            int d;
            GoogleSignInAccount googleSignInAccount2;
            int a = C1196a.m5523a(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (C1196a.m5522a(a)) {
                case 1:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    d = C1196a.m5533d(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 2:
                    d = i2;
                    int i4 = i;
                    account2 = (Account) C1196a.m5525a(parcel, a, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case 3:
                    account2 = account;
                    d = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = C1196a.m5533d(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 4:
                    googleSignInAccount2 = (GoogleSignInAccount) C1196a.m5525a(parcel, a, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    d = i2;
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    d = i2;
                    break;
            }
            i2 = d;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountRequest[] m5380a(int i) {
        return new ResolveAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5379a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5380a(i);
    }
}
