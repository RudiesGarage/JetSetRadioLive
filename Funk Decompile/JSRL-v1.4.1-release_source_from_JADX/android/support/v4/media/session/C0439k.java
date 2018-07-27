package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.C0437j.C0391a;
import android.support.v4.media.session.C0437j.C0436b;

/* compiled from: MediaSessionCompatApi24 */
class C0439k {

    /* compiled from: MediaSessionCompatApi24 */
    public interface C0393a extends C0391a {
        void mo221b(Uri uri, Bundle bundle);

        void mo222d(String str, Bundle bundle);

        void mo223e(String str, Bundle bundle);

        void mo224h();
    }

    /* compiled from: MediaSessionCompatApi24 */
    static class C0438b<T extends C0393a> extends C0436b<T> {
        public C0438b(T t) {
            super(t);
        }

        public void onPrepare() {
            ((C0393a) this.a).mo224h();
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
            ((C0393a) this.a).mo222d(str, bundle);
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
            ((C0393a) this.a).mo223e(str, bundle);
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            ((C0393a) this.a).mo221b(uri, bundle);
        }
    }

    public static Object m1708a(C0393a c0393a) {
        return new C0438b(c0393a);
    }
}
