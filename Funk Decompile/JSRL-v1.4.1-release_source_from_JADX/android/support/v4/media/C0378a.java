package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* compiled from: MediaDescriptionCompatApi21 */
class C0378a {

    /* compiled from: MediaDescriptionCompatApi21 */
    static class C0377a {
        public static Object m1369a() {
            return new Builder();
        }

        public static void m1375a(Object obj, String str) {
            ((Builder) obj).setMediaId(str);
        }

        public static void m1374a(Object obj, CharSequence charSequence) {
            ((Builder) obj).setTitle(charSequence);
        }

        public static void m1376b(Object obj, CharSequence charSequence) {
            ((Builder) obj).setSubtitle(charSequence);
        }

        public static void m1377c(Object obj, CharSequence charSequence) {
            ((Builder) obj).setDescription(charSequence);
        }

        public static void m1371a(Object obj, Bitmap bitmap) {
            ((Builder) obj).setIconBitmap(bitmap);
        }

        public static void m1372a(Object obj, Uri uri) {
            ((Builder) obj).setIconUri(uri);
        }

        public static void m1373a(Object obj, Bundle bundle) {
            ((Builder) obj).setExtras(bundle);
        }

        public static Object m1370a(Object obj) {
            return ((Builder) obj).build();
        }
    }

    public static String m1379a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence m1381b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence m1382c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence m1383d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap m1384e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri m1385f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle m1386g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static void m1380a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static Object m1378a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }
}
