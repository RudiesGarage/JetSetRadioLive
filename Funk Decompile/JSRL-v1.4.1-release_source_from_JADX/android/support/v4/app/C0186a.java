package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.p018b.C0185a;

/* compiled from: ActivityCompat */
public class C0186a extends C0185a {

    /* compiled from: ActivityCompat */
    public interface C0184a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void m615a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0206d.m672a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m616a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0206d.m673a(activity, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void m617a(final Activity activity, final String[] strArr, final int i) {
        if (VERSION.SDK_INT >= 23) {
            C0204b.m669a(activity, strArr, i);
        } else if (activity instanceof C0184a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C0184a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean m618a(Activity activity, String str) {
        if (VERSION.SDK_INT >= 23) {
            return C0204b.m670a(activity, str);
        }
        return false;
    }
}
