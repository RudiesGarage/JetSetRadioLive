package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ac.C0192a;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotificationCompatKitKat */
class ag {

    /* compiled from: NotificationCompatKitKat */
    public static class C0195a implements C0187w, C0188x {
        private Builder f502a;
        private Bundle f503b;
        private List<Bundle> f504c = new ArrayList();
        private RemoteViews f505d;
        private RemoteViews f506e;

        public C0195a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.f502a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f503b = new Bundle();
            if (bundle != null) {
                this.f503b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f503b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f503b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f503b.putString("android.support.groupKey", str);
                if (z5) {
                    this.f503b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f503b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f503b.putString("android.support.sortKey", str2);
            }
            this.f505d = remoteViews2;
            this.f506e = remoteViews3;
        }

        public void mo94a(C0192a c0192a) {
            this.f504c.add(af.m642a(this.f502a, c0192a));
        }

        public Builder mo93a() {
            return this.f502a;
        }

        public Notification mo95b() {
            SparseArray a = af.m644a(this.f504c);
            if (a != null) {
                this.f503b.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f502a.setExtras(this.f503b);
            Notification build = this.f502a.build();
            if (this.f505d != null) {
                build.contentView = this.f505d;
            }
            if (this.f506e != null) {
                build.bigContentView = this.f506e;
            }
            return build;
        }
    }

    public static Bundle m651a(Notification notification) {
        return notification.extras;
    }
}
