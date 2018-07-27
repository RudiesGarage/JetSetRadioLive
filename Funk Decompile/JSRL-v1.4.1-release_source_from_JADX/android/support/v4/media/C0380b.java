package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.support.v4.media.C0378a.C0377a;

/* compiled from: MediaDescriptionCompatApi23 */
class C0380b extends C0378a {

    /* compiled from: MediaDescriptionCompatApi23 */
    static class C0379a extends C0377a {
        public static void m1387b(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri m1388h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
