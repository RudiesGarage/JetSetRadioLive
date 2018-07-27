package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.C0435i.C0389a;
import android.support.v4.media.session.C0435i.C0434b;

/* compiled from: MediaSessionCompatApi23 */
class C0437j {

    /* compiled from: MediaSessionCompatApi23 */
    public interface C0391a extends C0389a {
        void mo220a(Uri uri, Bundle bundle);
    }

    /* compiled from: MediaSessionCompatApi23 */
    static class C0436b<T extends C0391a> extends C0434b<T> {
        public C0436b(T t) {
            super(t);
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
            ((C0391a) this.a).mo220a(uri, bundle);
        }
    }

    public static Object m1707a(C0391a c0391a) {
        return new C0436b(c0391a);
    }
}
