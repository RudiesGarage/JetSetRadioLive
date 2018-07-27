package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.C0223j;
import android.support.v4.app.C0271y.C0256c;
import android.support.v4.app.C0271y.C0257d;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.C1045a.C1039a;
import com.google.android.gms.C1045a.C1040b;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.C1157b;
import com.google.android.gms.common.internal.C1179k;
import com.google.android.gms.common.internal.C1180l;
import com.google.android.gms.common.util.C1224e;
import com.google.android.gms.common.util.C1228i;
import com.google.android.gms.p043b.C1095n;
import com.google.android.gms.p043b.C1095n.C1075a;
import com.google.android.gms.p043b.C1096p;

public class C1147b extends C1146i {
    public static final int f3046a = C1146i.f3045b;
    private static final C1147b f3047c = new C1147b();

    @SuppressLint({"HandlerLeak"})
    private class C1145a extends Handler {
        final /* synthetic */ C1147b f3042a;
        private final Context f3043b;

        public C1145a(C1147b c1147b, Context context) {
            this.f3042a = c1147b;
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f3043b = context.getApplicationContext();
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int a = this.f3042a.mo773a(this.f3043b);
                    if (this.f3042a.mo776a(a)) {
                        this.f3042a.m5333a(this.f3043b, a);
                        return;
                    }
                    return;
                default:
                    Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + message.what);
                    return;
            }
        }
    }

    C1147b() {
    }

    public static C1147b m5323a() {
        return f3047c;
    }

    public int mo773a(Context context) {
        return super.mo773a(context);
    }

    public Dialog m5325a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return m5327a((Context) activity, i, C1180l.m5479a(activity, mo777b(activity, i, "d"), i2), onCancelListener);
    }

    public Dialog m5326a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(C1179k.m5476c(activity, 18));
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        m5332a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    @TargetApi(14)
    Dialog m5327a(Context context, int i, C1180l c1180l, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (C1228i.m5687c()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(context, 5);
            }
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(C1179k.m5476c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence e = C1179k.m5478e(context, i);
        if (e != null) {
            builder.setPositiveButton(e, c1180l);
        }
        e = C1179k.m5472a(context, i);
        if (e != null) {
            builder.setTitle(e);
        }
        return builder.create();
    }

    public PendingIntent mo774a(Context context, int i, int i2) {
        return super.mo774a(context, i, i2);
    }

    public PendingIntent mo775a(Context context, int i, int i2, String str) {
        return super.mo775a(context, i, i2, str);
    }

    public PendingIntent m5330a(Context context, ConnectionResult connectionResult) {
        return connectionResult.m5259a() ? connectionResult.m5262d() : mo774a(context, connectionResult.m5261c(), 0);
    }

    public C1095n m5331a(Context context, C1075a c1075a) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver c1095n = new C1095n(c1075a);
        context.registerReceiver(c1095n, intentFilter);
        c1095n.m5220a(context);
        if (m5320a(context, "com.google.android.gms")) {
            return c1095n;
        }
        c1075a.mo758a();
        c1095n.m5219a();
        return null;
    }

    @TargetApi(11)
    void m5332a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        boolean z;
        try {
            z = activity instanceof C0223j;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            C1151e.m5343a(dialog, onCancelListener).show(((C0223j) activity).m780e(), str);
        } else if (C1228i.m5685a()) {
            C1126a.m5273a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    public void m5333a(Context context, int i) {
        m5334a(context, i, null);
    }

    public void m5334a(Context context, int i, String str) {
        m5335a(context, i, str, mo775a(context, i, 0, "n"));
    }

    @TargetApi(20)
    void m5335a(Context context, int i, String str, PendingIntent pendingIntent) {
        if (i == 18) {
            m5341b(context);
        } else if (pendingIntent != null) {
            Notification build;
            int i2;
            CharSequence b = C1179k.m5475b(context, i);
            CharSequence d = C1179k.m5477d(context, i);
            Resources resources = context.getResources();
            if (C1224e.m5681a(context)) {
                C1157b.m5373a(C1228i.m5690f());
                build = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(b).setStyle(new BigTextStyle().bigText(d)).addAction(C1039a.common_full_open_on_phone, resources.getString(C1040b.common_open_on_phone), pendingIntent).build();
            } else {
                build = new C0257d(context).m990a(17301642).m1002c(resources.getString(C1040b.common_google_play_services_notification_ticker)).m991a(System.currentTimeMillis()).m1000b(true).m992a(pendingIntent).m996a(b).m999b(d).m1003c(true).m995a(new C0256c().m986a(d)).m989a();
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                    C1120k.xf.set(false);
                    i2 = 10436;
                    break;
                default:
                    i2 = 39789;
                    break;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (str == null) {
                notificationManager.notify(i2, build);
            } else {
                notificationManager.notify(str, i2, build);
            }
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public void m5336a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a = m5330a(context, connectionResult);
        if (a != null) {
            m5335a(context, connectionResult.m5261c(), null, GoogleApiActivity.m5274a(context, a, i));
        }
    }

    public final boolean mo776a(int i) {
        return super.mo776a(i);
    }

    public boolean m5338a(Activity activity, C1096p c1096p, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m5327a((Context) activity, i, C1180l.m5481a(c1096p, mo777b(activity, i, "d"), i2), onCancelListener);
        if (a == null) {
            return false;
        }
        m5332a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public Intent mo777b(Context context, int i, String str) {
        return super.mo777b(context, i, str);
    }

    public final String mo778b(int i) {
        return super.mo778b(i);
    }

    void m5341b(Context context) {
        new C1145a(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public boolean m5342b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m5325a(activity, i, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        m5332a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
