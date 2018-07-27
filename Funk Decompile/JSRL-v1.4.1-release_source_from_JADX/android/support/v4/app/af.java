package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ac.C0192a;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatJellybean */
class af {
    private static final Object f498a = new Object();
    private static Field f499b;
    private static boolean f500c;
    private static final Object f501d = new Object();

    /* compiled from: NotificationCompatJellybean */
    public static class C0194a implements C0187w, C0188x {
        private Builder f493a;
        private final Bundle f494b;
        private List<Bundle> f495c = new ArrayList();
        private RemoteViews f496d;
        private RemoteViews f497e;

        public C0194a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.f493a = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f494b = new Bundle();
            if (bundle != null) {
                this.f494b.putAll(bundle);
            }
            if (z3) {
                this.f494b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f494b.putString("android.support.groupKey", str);
                if (z4) {
                    this.f494b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f494b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f494b.putString("android.support.sortKey", str2);
            }
            this.f496d = remoteViews2;
            this.f497e = remoteViews3;
        }

        public void mo94a(C0192a c0192a) {
            this.f495c.add(af.m642a(this.f493a, c0192a));
        }

        public Builder mo93a() {
            return this.f493a;
        }

        public Notification mo95b() {
            Notification build = this.f493a.build();
            Bundle a = af.m643a(build);
            Bundle bundle = new Bundle(this.f494b);
            for (String str : this.f494b.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray a2 = af.m644a(this.f495c);
            if (a2 != null) {
                af.m643a(build).putSparseParcelableArray("android.support.actionExtras", a2);
            }
            if (this.f496d != null) {
                build.contentView = this.f496d;
            }
            if (this.f497e != null) {
                build.bigContentView = this.f497e;
            }
            return build;
        }
    }

    public static void m646a(C0188x c0188x, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(c0188x.mo93a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void m645a(C0188x c0188x, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(c0188x.mo93a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void m647a(C0188x c0188x, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(c0188x.mo93a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> m644a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle m643a(Notification notification) {
        synchronized (f498a) {
            if (f500c) {
                return null;
            }
            try {
                if (f499b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f499b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f500c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f499b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f499b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f500c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f500c = true;
                return null;
            }
        }
    }

    public static Bundle m642a(Builder builder, C0192a c0192a) {
        builder.addAction(c0192a.mo158a(), c0192a.mo159b(), c0192a.mo160c());
        Bundle bundle = new Bundle(c0192a.mo161d());
        if (c0192a.mo163g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", ak.m664a(c0192a.mo163g()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c0192a.mo162e());
        return bundle;
    }
}
