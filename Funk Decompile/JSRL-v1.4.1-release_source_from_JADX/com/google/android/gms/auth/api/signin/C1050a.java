package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1196a;
import com.google.android.gms.common.internal.safeparcel.C1196a.C1195a;
import com.google.android.gms.common.internal.safeparcel.C1197b;
import java.util.List;

public class C1050a implements Creator<GoogleSignInAccount> {
    static void m5076a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = C1197b.m5539a(parcel);
        C1197b.m5541a(parcel, 1, googleSignInAccount.f2818b);
        C1197b.m5547a(parcel, 2, googleSignInAccount.m5065a(), false);
        C1197b.m5547a(parcel, 3, googleSignInAccount.m5066b(), false);
        C1197b.m5547a(parcel, 4, googleSignInAccount.m5067c(), false);
        C1197b.m5547a(parcel, 5, googleSignInAccount.m5068d(), false);
        C1197b.m5545a(parcel, 6, googleSignInAccount.m5071g(), i, false);
        C1197b.m5547a(parcel, 7, googleSignInAccount.m5072h(), false);
        C1197b.m5542a(parcel, 8, googleSignInAccount.m5073i());
        C1197b.m5547a(parcel, 9, googleSignInAccount.m5074j(), false);
        C1197b.m5548a(parcel, 10, googleSignInAccount.f2819c, false);
        C1197b.m5547a(parcel, 11, googleSignInAccount.m5069e(), false);
        C1197b.m5547a(parcel, 12, googleSignInAccount.m5070f(), false);
        C1197b.m5540a(parcel, a);
    }

    public GoogleSignInAccount m5077a(Parcel parcel) {
        int b = C1196a.m5528b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < b) {
            int a = C1196a.m5523a(parcel);
            switch (C1196a.m5522a(a)) {
                case 1:
                    i = C1196a.m5533d(parcel, a);
                    break;
                case 2:
                    str = C1196a.m5536g(parcel, a);
                    break;
                case 3:
                    str2 = C1196a.m5536g(parcel, a);
                    break;
                case 4:
                    str3 = C1196a.m5536g(parcel, a);
                    break;
                case 5:
                    str4 = C1196a.m5536g(parcel, a);
                    break;
                case 6:
                    uri = (Uri) C1196a.m5525a(parcel, a, Uri.CREATOR);
                    break;
                case 7:
                    str5 = C1196a.m5536g(parcel, a);
                    break;
                case 8:
                    j = C1196a.m5535f(parcel, a);
                    break;
                case 9:
                    str6 = C1196a.m5536g(parcel, a);
                    break;
                case 10:
                    list = C1196a.m5531c(parcel, a, Scope.CREATOR);
                    break;
                case 11:
                    str7 = C1196a.m5536g(parcel, a);
                    break;
                case 12:
                    str8 = C1196a.m5536g(parcel, a);
                    break;
                default:
                    C1196a.m5529b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
        }
        throw new C1195a("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInAccount[] m5078a(int i) {
        return new GoogleSignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5077a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5078a(i);
    }
}
