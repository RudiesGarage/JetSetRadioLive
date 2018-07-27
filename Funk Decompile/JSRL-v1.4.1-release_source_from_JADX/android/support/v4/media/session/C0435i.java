package android.support.v4.media.session;

import android.content.Context;
import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession;
import android.media.session.MediaSession.Callback;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.session.C0433h.C0388a;

/* compiled from: MediaSessionCompatApi21 */
class C0435i {

    /* compiled from: MediaSessionCompatApi21 */
    interface C0389a extends C0388a {
        void mo205a();

        void mo206a(long j);

        void mo208a(String str, Bundle bundle);

        void mo209a(String str, Bundle bundle, ResultReceiver resultReceiver);

        boolean mo210a(Intent intent);

        void mo211b();

        void mo213b(String str, Bundle bundle);

        void mo214c();

        void mo215c(String str, Bundle bundle);

        void mo216d();

        void mo217e();

        void mo218f();

        void mo219g();
    }

    /* compiled from: MediaSessionCompatApi21 */
    static class C0434b<T extends C0389a> extends Callback {
        protected final T f1009a;

        public C0434b(T t) {
            this.f1009a = t;
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f1009a.mo209a(str, bundle, resultReceiver);
        }

        public boolean onMediaButtonEvent(Intent intent) {
            return this.f1009a.mo210a(intent) || super.onMediaButtonEvent(intent);
        }

        public void onPlay() {
            this.f1009a.mo205a();
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
            this.f1009a.mo208a(str, bundle);
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
            this.f1009a.mo213b(str, bundle);
        }

        public void onSkipToQueueItem(long j) {
            this.f1009a.mo206a(j);
        }

        public void onPause() {
            this.f1009a.mo211b();
        }

        public void onSkipToNext() {
            this.f1009a.mo214c();
        }

        public void onSkipToPrevious() {
            this.f1009a.mo216d();
        }

        public void onFastForward() {
            this.f1009a.mo217e();
        }

        public void onRewind() {
            this.f1009a.mo218f();
        }

        public void onStop() {
            this.f1009a.mo219g();
        }

        public void onSeekTo(long j) {
            this.f1009a.mo212b(j);
        }

        public void onSetRating(Rating rating) {
            this.f1009a.mo207a(rating);
        }

        public void onCustomAction(String str, Bundle bundle) {
            this.f1009a.mo215c(str, bundle);
        }
    }

    public static Object m1699a(Context context, String str) {
        return new MediaSession(context, str);
    }

    public static Object m1700a(C0389a c0389a) {
        return new C0434b(c0389a);
    }

    public static void m1704a(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((Callback) obj2, handler);
    }

    public static void m1702a(Object obj, int i) {
        ((MediaSession) obj).setFlags(i);
    }

    public static void m1705a(Object obj, boolean z) {
        ((MediaSession) obj).setActive(z);
    }

    public static void m1701a(Object obj) {
        ((MediaSession) obj).release();
    }

    public static Parcelable m1706b(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }

    public static void m1703a(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }
}
