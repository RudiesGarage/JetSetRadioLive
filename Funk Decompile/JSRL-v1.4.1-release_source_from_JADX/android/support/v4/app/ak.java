package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.aj.C0202a;

/* compiled from: RemoteInputCompatJellybean */
class ak {
    static Bundle m663a(C0202a c0202a) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c0202a.mo96a());
        bundle.putCharSequence("label", c0202a.mo97b());
        bundle.putCharSequenceArray("choices", c0202a.mo98c());
        bundle.putBoolean("allowFreeFormInput", c0202a.mo99d());
        bundle.putBundle("extras", c0202a.mo100e());
        return bundle;
    }

    static Bundle[] m664a(C0202a[] c0202aArr) {
        if (c0202aArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0202aArr.length];
        for (int i = 0; i < c0202aArr.length; i++) {
            bundleArr[i] = m663a(c0202aArr[i]);
        }
        return bundleArr;
    }
}
