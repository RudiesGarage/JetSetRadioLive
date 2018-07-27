package android.support.v4.app;

import android.app.Activity;

/* compiled from: ActivityCompatApi23 */
class C0204b {

    /* compiled from: ActivityCompatApi23 */
    public interface C0203a {
        void mo130a(int i);
    }

    public static void m669a(Activity activity, String[] strArr, int i) {
        if (activity instanceof C0203a) {
            ((C0203a) activity).mo130a(i);
        }
        activity.requestPermissions(strArr, i);
    }

    public static boolean m670a(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
