package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.internal.C1180l;

public final class GooglePlayServicesUtil extends C1120k {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = C1120k.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        if (zzd(activity, i)) {
            i = 18;
        }
        return C1147b.m5323a().m5325a(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return C1120k.getErrorPendingIntent(i, context, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return C1120k.getErrorString(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        return C1120k.getOpenSourceSoftwareLicenseInfo(context);
    }

    public static Context getRemoteContext(Context context) {
        return C1120k.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return C1120k.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return C1120k.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return C1120k.isUserRecoverableError(i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        if (zzd(activity, i)) {
            i = 18;
        }
        C1147b a = C1147b.m5323a();
        if (fragment == null) {
            return a.m5342b(activity, i, i2, onCancelListener);
        }
        Dialog a2 = a.m5327a((Context) activity, i, C1180l.m5480a(fragment, C1147b.m5323a().mo777b(activity, i, "d"), i2), onCancelListener);
        if (a2 == null) {
            return false;
        }
        a.m5332a(activity, a2, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        C1147b a = C1147b.m5323a();
        if (zzd(context, i) || zze(context, i)) {
            a.m5341b(context);
        } else {
            a.m5333a(context, i);
        }
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        return C1120k.zzd(context, i);
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        return C1120k.zze(context, i);
    }
}
