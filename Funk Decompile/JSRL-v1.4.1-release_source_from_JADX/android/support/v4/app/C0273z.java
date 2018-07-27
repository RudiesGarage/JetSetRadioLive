package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ac.C0192a;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* compiled from: NotificationCompatApi20 */
class C0273z {

    /* compiled from: NotificationCompatApi20 */
    public static class C0272a implements C0187w, C0188x {
        private Builder f756a;
        private Bundle f757b;
        private RemoteViews f758c;
        private RemoteViews f759d;

        public C0272a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.f756a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.f757b = new Bundle();
            if (bundle != null) {
                this.f757b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f757b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            this.f758c = remoteViews2;
            this.f759d = remoteViews3;
        }

        public void mo94a(C0192a c0192a) {
            C0273z.m1042a(this.f756a, c0192a);
        }

        public Builder mo93a() {
            return this.f756a;
        }

        public Notification mo95b() {
            this.f756a.setExtras(this.f757b);
            Notification build = this.f756a.build();
            if (this.f758c != null) {
                build.contentView = this.f758c;
            }
            if (this.f759d != null) {
                build.bigContentView = this.f759d;
            }
            return build;
        }
    }

    public static void m1042a(Builder builder, C0192a c0192a) {
        Bundle bundle;
        Action.Builder builder2 = new Action.Builder(c0192a.mo158a(), c0192a.mo159b(), c0192a.mo160c());
        if (c0192a.mo163g() != null) {
            for (RemoteInput addRemoteInput : ai.m662a(c0192a.mo163g())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (c0192a.mo161d() != null) {
            bundle = new Bundle(c0192a.mo161d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c0192a.mo162e());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
