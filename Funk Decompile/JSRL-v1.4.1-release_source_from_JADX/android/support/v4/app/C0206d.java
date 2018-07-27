package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* compiled from: ActivityCompatJB */
class C0206d {
    public static void m672a(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void m673a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
