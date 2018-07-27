package android.support.v4.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.List;

/* compiled from: MediaButtonReceiver */
public class C0415c extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
        intent2.setPackage(context.getPackageName());
        PackageManager packageManager = context.getPackageManager();
        List queryIntentServices = packageManager.queryIntentServices(intent2, 0);
        if (queryIntentServices.isEmpty()) {
            intent2.setAction("android.media.browse.MediaBrowserService");
            queryIntentServices = packageManager.queryIntentServices(intent2, 0);
        }
        if (queryIntentServices.isEmpty()) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or a media browser service implementation");
        } else if (queryIntentServices.size() != 1) {
            throw new IllegalStateException("Expected 1 Service that handles " + intent2.getAction() + ", found " + queryIntentServices.size());
        } else {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
            intent.setComponent(new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name));
            context.startService(intent);
        }
    }

    static ComponentName m1652a(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ResolveInfo resolveInfo = (ResolveInfo) queryBroadcastReceivers.get(0);
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }
        if (queryBroadcastReceivers.size() > 1) {
            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        }
        return null;
    }
}
