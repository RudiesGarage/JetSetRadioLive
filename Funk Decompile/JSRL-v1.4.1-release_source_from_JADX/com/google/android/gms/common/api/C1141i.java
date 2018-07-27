package com.google.android.gms.common.api;

import android.support.v4.p024g.C0357a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1207x;
import com.google.android.gms.p043b.C1072e;
import java.util.ArrayList;

public class C1141i extends Exception {
    private final C0357a<C1072e<?>, ConnectionResult> f3034a;

    public C1141i(C0357a<C1072e<?>, ConnectionResult> c0357a) {
        this.f3034a = c0357a;
    }

    public String getMessage() {
        Iterable arrayList = new ArrayList();
        Object obj = 1;
        for (C1072e c1072e : this.f3034a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.f3034a.get(c1072e);
            if (connectionResult.m5260b()) {
                obj = null;
            }
            String valueOf = String.valueOf(c1072e.m5125a());
            String valueOf2 = String.valueOf(connectionResult);
            arrayList.add(new StringBuilder((String.valueOf(valueOf).length() + 2) + String.valueOf(valueOf2).length()).append(valueOf).append(": ").append(valueOf2).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (obj != null) {
            stringBuilder.append("None of the queried APIs are available. ");
        } else {
            stringBuilder.append("Some of the queried APIs are unavailable. ");
        }
        C1207x.m5653a("; ").m5655a(stringBuilder, arrayList);
        return stringBuilder.toString();
    }
}
