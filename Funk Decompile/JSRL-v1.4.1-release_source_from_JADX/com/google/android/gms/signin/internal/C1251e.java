package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;

public class C1251e implements Creator<RecordConsentRequest> {
    static void m5754a(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, recordConsentRequest.f3221a);
        C1197b.m5545a(parcel, 2, recordConsentRequest.m5710a(), i, false);
        C1197b.m5550a(parcel, 3, recordConsentRequest.m5711b(), i, false);
        C1197b.m5547a(parcel, 4, recordConsentRequest.m5712c(), false);
        C1197b.m5540a(parcel, a);
    }

    public RecordConsentRequest m5755a(Parcel parcel) {
        String str = null;
        int b = C1196a.m5528b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < b) {
            Scope[] scopeArr2;
            Account account2;
            int d;
            String str2;
            int a = C1196a.m5523a(parcel);
            String str3;
            switch (C1196a.m5522a(a)) {
                case 1:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = C1196a.m5533d(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    d = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) C1196a.m5525a(parcel, a, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case 3:
                    account2 = account;
                    d = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) C1196a.m5530b(parcel, a, Scope.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C1196a.m5536g(parcel, a);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = i;
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = i;
                    break;
            }
            i = d;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public RecordConsentRequest[] m5756a(int i) {
        return new RecordConsentRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5755a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5756a(i);
    }
}
