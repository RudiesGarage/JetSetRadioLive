package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ac.C0192a;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: NotificationCompatApi21 */
class aa {

    /* compiled from: NotificationCompatApi21 */
    public static class C0189a implements C0187w, C0188x {
        private Builder f486a;
        private Bundle f487b;
        private RemoteViews f488c;
        private RemoteViews f489d;
        private RemoteViews f490e;

        public C0189a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4) {
            this.f486a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
            this.f487b = new Bundle();
            if (bundle != null) {
                this.f487b.putAll(bundle);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f486a.addPerson((String) it.next());
            }
            this.f488c = remoteViews2;
            this.f489d = remoteViews3;
            this.f490e = remoteViews4;
        }

        public void mo94a(C0192a c0192a) {
            C0273z.m1042a(this.f486a, c0192a);
        }

        public Builder mo93a() {
            return this.f486a;
        }

        public Notification mo95b() {
            this.f486a.setExtras(this.f487b);
            Notification build = this.f486a.build();
            if (this.f488c != null) {
                build.contentView = this.f488c;
            }
            if (this.f489d != null) {
                build.bigContentView = this.f489d;
            }
            if (this.f490e != null) {
                build.headsUpContentView = this.f490e;
            }
            return build;
        }
    }
}
