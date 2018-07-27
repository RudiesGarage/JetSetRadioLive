package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.C0378a.C0377a;
import android.support.v4.media.C0380b.C0379a;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new C03721();
    private final String f894a;
    private final CharSequence f895b;
    private final CharSequence f896c;
    private final CharSequence f897d;
    private final Bitmap f898e;
    private final Uri f899f;
    private final Bundle f900g;
    private final Uri f901h;
    private Object f902i;

    static class C03721 implements Creator<MediaDescriptionCompat> {
        C03721() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1340a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1341a(i);
        }

        public MediaDescriptionCompat m1340a(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.m1351a(C0378a.m1378a(parcel));
        }

        public MediaDescriptionCompat[] m1341a(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    public static final class C0373a {
        private String f886a;
        private CharSequence f887b;
        private CharSequence f888c;
        private CharSequence f889d;
        private Bitmap f890e;
        private Uri f891f;
        private Bundle f892g;
        private Uri f893h;

        public C0373a m1346a(String str) {
            this.f886a = str;
            return this;
        }

        public C0373a m1345a(CharSequence charSequence) {
            this.f887b = charSequence;
            return this;
        }

        public C0373a m1349b(CharSequence charSequence) {
            this.f888c = charSequence;
            return this;
        }

        public C0373a m1350c(CharSequence charSequence) {
            this.f889d = charSequence;
            return this;
        }

        public C0373a m1342a(Bitmap bitmap) {
            this.f890e = bitmap;
            return this;
        }

        public C0373a m1343a(Uri uri) {
            this.f891f = uri;
            return this;
        }

        public C0373a m1344a(Bundle bundle) {
            this.f892g = bundle;
            return this;
        }

        public C0373a m1348b(Uri uri) {
            this.f893h = uri;
            return this;
        }

        public MediaDescriptionCompat m1347a() {
            return new MediaDescriptionCompat(this.f886a, this.f887b, this.f888c, this.f889d, this.f890e, this.f891f, this.f892g, this.f893h);
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f894a = str;
        this.f895b = charSequence;
        this.f896c = charSequence2;
        this.f897d = charSequence3;
        this.f898e = bitmap;
        this.f899f = uri;
        this.f900g = bundle;
        this.f901h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f894a = parcel.readString();
        this.f895b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f896c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f897d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f898e = (Bitmap) parcel.readParcelable(null);
        this.f899f = (Uri) parcel.readParcelable(null);
        this.f900g = parcel.readBundle();
        this.f901h = (Uri) parcel.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f894a);
            TextUtils.writeToParcel(this.f895b, parcel, i);
            TextUtils.writeToParcel(this.f896c, parcel, i);
            TextUtils.writeToParcel(this.f897d, parcel, i);
            parcel.writeParcelable(this.f898e, i);
            parcel.writeParcelable(this.f899f, i);
            parcel.writeBundle(this.f900g);
            parcel.writeParcelable(this.f901h, i);
            return;
        }
        C0378a.m1380a(m1352a(), parcel, i);
    }

    public String toString() {
        return this.f895b + ", " + this.f896c + ", " + this.f897d;
    }

    public Object m1352a() {
        if (this.f902i != null || VERSION.SDK_INT < 21) {
            return this.f902i;
        }
        Object a = C0377a.m1369a();
        C0377a.m1375a(a, this.f894a);
        C0377a.m1374a(a, this.f895b);
        C0377a.m1376b(a, this.f896c);
        C0377a.m1377c(a, this.f897d);
        C0377a.m1371a(a, this.f898e);
        C0377a.m1372a(a, this.f899f);
        Bundle bundle = this.f900g;
        if (VERSION.SDK_INT < 23 && this.f901h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f901h);
        }
        C0377a.m1373a(a, bundle);
        if (VERSION.SDK_INT >= 23) {
            C0379a.m1387b(a, this.f901h);
        }
        this.f902i = C0377a.m1370a(a);
        return this.f902i;
    }

    public static MediaDescriptionCompat m1351a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        MediaDescriptionCompat a;
        C0373a c0373a = new C0373a();
        c0373a.m1346a(C0378a.m1379a(obj));
        c0373a.m1345a(C0378a.m1381b(obj));
        c0373a.m1349b(C0378a.m1382c(obj));
        c0373a.m1350c(C0378a.m1383d(obj));
        c0373a.m1342a(C0378a.m1384e(obj));
        c0373a.m1343a(C0378a.m1385f(obj));
        Bundle g = C0378a.m1386g(obj);
        if (g == null) {
            uri = null;
        } else {
            uri = (Uri) g.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (g.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && g.size() == 2) {
                bundle = null;
                c0373a.m1344a(bundle);
                if (uri != null) {
                    c0373a.m1348b(uri);
                } else if (VERSION.SDK_INT >= 23) {
                    c0373a.m1348b(C0380b.m1388h(obj));
                }
                a = c0373a.m1347a();
                a.f902i = obj;
                return a;
            }
            g.remove("android.support.v4.media.description.MEDIA_URI");
            g.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = g;
        c0373a.m1344a(bundle);
        if (uri != null) {
            c0373a.m1348b(uri);
        } else if (VERSION.SDK_INT >= 23) {
            c0373a.m1348b(C0380b.m1388h(obj));
        }
        a = c0373a.m1347a();
        a.f902i = obj;
        return a;
    }
}
