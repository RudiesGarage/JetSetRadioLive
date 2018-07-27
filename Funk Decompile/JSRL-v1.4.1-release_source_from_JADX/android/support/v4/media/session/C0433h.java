package android.support.v4.media.session;

import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.media.RemoteControlClient.OnMetadataUpdateListener;
import android.os.Bundle;
import android.support.v4.media.session.C0431g.C0387a;

/* compiled from: MediaSessionCompatApi19 */
class C0433h {

    /* compiled from: MediaSessionCompatApi19 */
    interface C0388a extends C0387a {
        void mo207a(Object obj);
    }

    /* compiled from: MediaSessionCompatApi19 */
    static class C0432b<T extends C0388a> implements OnMetadataUpdateListener {
        protected final T f1008a;

        public C0432b(T t) {
            this.f1008a = t;
        }

        public void onMetadataUpdate(int i, Object obj) {
            if (i == 268435457 && (obj instanceof Rating)) {
                this.f1008a.mo207a(obj);
            }
        }
    }

    public static void m1696a(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(C0433h.m1693a(j));
    }

    public static Object m1694a(C0388a c0388a) {
        return new C0432b(c0388a);
    }

    public static void m1697a(Object obj, Bundle bundle, long j) {
        MetadataEditor editMetadata = ((RemoteControlClient) obj).editMetadata(true);
        C0429f.m1681a(bundle, editMetadata);
        C0433h.m1695a(bundle, editMetadata);
        if ((128 & j) != 0) {
            editMetadata.addEditableKey(268435457);
        }
        editMetadata.apply();
    }

    public static void m1698a(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setMetadataUpdateListener((OnMetadataUpdateListener) obj2);
    }

    static int m1693a(long j) {
        int a = C0431g.m1686a(j);
        if ((128 & j) != 0) {
            return a | 512;
        }
        return a;
    }

    static void m1695a(Bundle bundle, MetadataEditor metadataEditor) {
        if (bundle != null) {
            if (bundle.containsKey("android.media.metadata.YEAR")) {
                metadataEditor.putLong(8, bundle.getLong("android.media.metadata.YEAR"));
            }
            if (bundle.containsKey("android.media.metadata.RATING")) {
                metadataEditor.putObject(101, bundle.getParcelable("android.media.metadata.RATING"));
            }
            if (bundle.containsKey("android.media.metadata.USER_RATING")) {
                metadataEditor.putObject(268435457, bundle.getParcelable("android.media.metadata.USER_RATING"));
            }
        }
    }
}
