package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaController.TransportControls;
import android.media.session.MediaSession.Token;

/* compiled from: MediaControllerCompatApi21 */
class C0428e {

    /* compiled from: MediaControllerCompatApi21 */
    public static class C0427a {
        public static void m1671a(Object obj) {
            ((TransportControls) obj).play();
        }

        public static void m1672b(Object obj) {
            ((TransportControls) obj).pause();
        }

        public static void m1673c(Object obj) {
            ((TransportControls) obj).stop();
        }

        public static void m1674d(Object obj) {
            ((TransportControls) obj).skipToNext();
        }
    }

    public static Object m1675a(Context context, Object obj) {
        return new MediaController(context, (Token) obj);
    }

    public static Object m1676a(Object obj) {
        return ((MediaController) obj).getTransportControls();
    }
}
