package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.support.v4.app.aj.C0202a;

/* compiled from: RemoteInputCompatApi20 */
class ai {
    static RemoteInput[] m662a(C0202a[] c0202aArr) {
        if (c0202aArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0202aArr.length];
        for (int i = 0; i < c0202aArr.length; i++) {
            C0202a c0202a = c0202aArr[i];
            remoteInputArr[i] = new Builder(c0202a.mo96a()).setLabel(c0202a.mo97b()).setChoices(c0202a.mo98c()).setAllowFreeFormInput(c0202a.mo99d()).addExtras(c0202a.mo100e()).build();
        }
        return remoteInputArr;
    }
}
