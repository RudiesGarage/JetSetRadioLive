package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.os.SystemClock;
import android.util.Log;

/* compiled from: MediaSessionCompatApi18 */
class C0431g {
    private static boolean f1007a = true;

    /* compiled from: MediaSessionCompatApi18 */
    interface C0387a {
        void mo212b(long j);
    }

    /* compiled from: MediaSessionCompatApi18 */
    static class C0430b<T extends C0387a> implements OnPlaybackPositionUpdateListener {
        protected final T f1006a;

        public C0430b(T t) {
            this.f1006a = t;
        }

        public void onPlaybackPositionUpdate(long j) {
            this.f1006a.mo212b(j);
        }
    }

    public static Object m1687a(C0387a c0387a) {
        return new C0430b(c0387a);
    }

    public static void m1688a(Context context, PendingIntent pendingIntent, ComponentName componentName) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (f1007a) {
            try {
                audioManager.registerMediaButtonEventReceiver(pendingIntent);
            } catch (NullPointerException e) {
                Log.w("MediaSessionCompatApi18", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                f1007a = false;
            }
        }
        if (!f1007a) {
            audioManager.registerMediaButtonEventReceiver(componentName);
        }
    }

    public static void m1692b(Context context, PendingIntent pendingIntent, ComponentName componentName) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (f1007a) {
            audioManager.unregisterMediaButtonEventReceiver(pendingIntent);
        } else {
            audioManager.unregisterMediaButtonEventReceiver(componentName);
        }
    }

    public static void m1689a(Object obj, int i, long j, float f, long j2) {
        long j3 = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i == 3 && j > 0) {
            if (j2 > 0) {
                j3 = elapsedRealtime - j2;
                if (f > 0.0f && f != 1.0f) {
                    j3 = (long) (((float) j3) * f);
                }
            }
            j += j3;
        }
        ((RemoteControlClient) obj).setPlaybackState(C0429f.m1677a(i), j, f);
    }

    public static void m1690a(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(C0431g.m1686a(j));
    }

    public static void m1691a(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setPlaybackPositionUpdateListener((OnPlaybackPositionUpdateListener) obj2);
    }

    static int m1686a(long j) {
        int a = C0429f.m1678a(j);
        if ((256 & j) != 0) {
            return a | 256;
        }
        return a;
    }
}
