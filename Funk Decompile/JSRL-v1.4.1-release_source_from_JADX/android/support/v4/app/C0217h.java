package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* compiled from: BaseFragmentActivityJB */
abstract class C0217h extends C0216g {
    boolean f569b;

    C0217h() {
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!(this.f569b || i == -1)) {
            C0215f.m720b(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!(this.a || i == -1)) {
            C0215f.m720b(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
