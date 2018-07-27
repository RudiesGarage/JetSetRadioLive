package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.aj.C0202a;

/* compiled from: NotificationCompatBase */
public class ac {

    /* compiled from: NotificationCompatBase */
    public static abstract class C0192a {

        /* compiled from: NotificationCompatBase */
        public interface C0191a {
        }

        public abstract int mo158a();

        public abstract CharSequence mo159b();

        public abstract PendingIntent mo160c();

        public abstract Bundle mo161d();

        public abstract boolean mo162e();

        public abstract C0202a[] mo163g();
    }

    public static Notification m635a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        return notification;
    }
}
