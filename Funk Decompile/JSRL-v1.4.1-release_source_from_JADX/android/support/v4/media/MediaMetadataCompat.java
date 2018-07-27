package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p024g.C0357a;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new C03741();
    static final C0357a<String, Integer> f904a = new C0357a();
    private static final String[] f905c = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    private static final String[] f906d = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    private static final String[] f907e = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
    final Bundle f908b;

    static class C03741 implements Creator<MediaMetadataCompat> {
        C03741() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1353a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1354a(i);
        }

        public MediaMetadataCompat m1353a(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        public MediaMetadataCompat[] m1354a(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    public static final class C0375a {
        private final Bundle f903a;

        public C0375a() {
            this.f903a = new Bundle();
        }

        public C0375a(MediaMetadataCompat mediaMetadataCompat) {
            this.f903a = new Bundle(mediaMetadataCompat.f908b);
        }

        public C0375a(MediaMetadataCompat mediaMetadataCompat, int i) {
            this(mediaMetadataCompat);
            for (String str : this.f903a.keySet()) {
                Object obj = this.f903a.get(str);
                if (obj != null && (obj instanceof Bitmap)) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i || bitmap.getWidth() > i) {
                        m1356a(str, m1355a(bitmap, i));
                    } else if (VERSION.SDK_INT >= 14 && (str.equals("android.media.metadata.ART") || str.equals("android.media.metadata.ALBUM_ART"))) {
                        m1356a(str, bitmap.copy(bitmap.getConfig(), false));
                    }
                }
            }
        }

        public C0375a m1356a(String str, Bitmap bitmap) {
            if (!MediaMetadataCompat.f904a.containsKey(str) || ((Integer) MediaMetadataCompat.f904a.get(str)).intValue() == 2) {
                this.f903a.putParcelable(str, bitmap);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
        }

        public MediaMetadataCompat m1357a() {
            return new MediaMetadataCompat(this.f903a);
        }

        private Bitmap m1355a(Bitmap bitmap, int i) {
            float f = (float) i;
            f = Math.min(f / ((float) bitmap.getWidth()), f / ((float) bitmap.getHeight()));
            return Bitmap.createScaledBitmap(bitmap, (int) (f * ((float) bitmap.getWidth())), (int) (((float) bitmap.getHeight()) * f), true);
        }
    }

    static {
        f904a.put("android.media.metadata.TITLE", Integer.valueOf(1));
        f904a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        f904a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        f904a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        f904a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        f904a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        f904a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        f904a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        f904a.put("android.media.metadata.DATE", Integer.valueOf(1));
        f904a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        f904a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        f904a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        f904a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        f904a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        f904a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        f904a.put("android.media.metadata.ART", Integer.valueOf(2));
        f904a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        f904a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        f904a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        f904a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        f904a.put("android.media.metadata.RATING", Integer.valueOf(3));
        f904a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        f904a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        f904a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        f904a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        f904a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        f904a.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        f904a.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
        f904a.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
    }

    MediaMetadataCompat(Bundle bundle) {
        this.f908b = new Bundle(bundle);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f908b = parcel.readBundle();
    }

    public boolean m1359a(String str) {
        return this.f908b.containsKey(str);
    }

    public long m1360b(String str) {
        return this.f908b.getLong(str, 0);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f908b);
    }

    public Bundle m1358a() {
        return this.f908b;
    }
}
