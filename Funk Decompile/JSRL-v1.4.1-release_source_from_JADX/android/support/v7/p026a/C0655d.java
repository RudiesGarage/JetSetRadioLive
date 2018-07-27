package android.support.v7.p026a;

import android.app.Notification.MediaStyle;
import android.media.session.MediaSession.Token;
import android.support.v4.app.C0188x;

/* compiled from: NotificationCompatImpl21 */
class C0655d {
    public static void m2738a(C0188x c0188x, int[] iArr, Object obj) {
        MediaStyle mediaStyle = new MediaStyle(c0188x.mo93a());
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        if (obj != null) {
            mediaStyle.setMediaSession((Token) obj);
        }
    }
}
