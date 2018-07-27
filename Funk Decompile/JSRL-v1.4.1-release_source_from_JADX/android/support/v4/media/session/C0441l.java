package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction;
import android.media.session.PlaybackState.CustomAction.Builder;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* compiled from: PlaybackStateCompatApi21 */
class C0441l {

    /* compiled from: PlaybackStateCompatApi21 */
    static final class C0440a {
        public static Object m1709a(String str, CharSequence charSequence, int i, Bundle bundle) {
            Builder builder = new Builder(str, charSequence, i);
            builder.setExtras(bundle);
            return builder.build();
        }
    }

    public static Object m1710a(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<Object> list, long j5) {
        PlaybackState.Builder builder = new PlaybackState.Builder();
        builder.setState(i, j, f, j4);
        builder.setBufferedPosition(j2);
        builder.setActions(j3);
        builder.setErrorMessage(charSequence);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            builder.addCustomAction((CustomAction) it.next());
        }
        builder.setActiveQueueItemId(j5);
        return builder.build();
    }
}
