package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.C0383d;
import android.support.v4.media.C0383d.C0382a;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.MediaMetadataCompat.C0375a;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.C0401b.C0402a;
import android.support.v4.media.session.C0431g.C0387a;
import android.support.v4.media.session.C0433h.C0388a;
import android.support.v4.media.session.C0435i.C0389a;
import android.support.v4.media.session.C0437j.C0391a;
import android.support.v4.media.session.C0439k.C0393a;
import android.support.v4.media.session.PlaybackStateCompat.C0410a;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
    static int f961a;
    private final C0396b f962b;
    private final C0426d f963c;
    private final ArrayList<C0406e> f964d = new ArrayList();

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new C03841();
        private final MediaDescriptionCompat f915a;
        private final long f916b;

        static class C03841 implements Creator<QueueItem> {
            C03841() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1400a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1401a(i);
            }

            public QueueItem m1400a(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public QueueItem[] m1401a(int i) {
                return new QueueItem[i];
            }
        }

        QueueItem(Parcel parcel) {
            this.f915a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f916b = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f915a.writeToParcel(parcel, i);
            parcel.writeLong(this.f916b);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f915a + ", Id=" + this.f916b + " }";
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new C03851();
        private ResultReceiver f917a;

        static class C03851 implements Creator<ResultReceiverWrapper> {
            C03851() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1402a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1403a(i);
            }

            public ResultReceiverWrapper m1402a(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] m1403a(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f917a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f917a.writeToParcel(parcel, i);
        }
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new C03861();
        private final Object f918a;

        static class C03861 implements Creator<Token> {
            C03861() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1405a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1406a(i);
            }

            public Token m1405a(Parcel parcel) {
                Object readParcelable;
                if (VERSION.SDK_INT >= 21) {
                    readParcelable = parcel.readParcelable(null);
                } else {
                    readParcelable = parcel.readStrongBinder();
                }
                return new Token(readParcelable);
            }

            public Token[] m1406a(int i) {
                return new Token[i];
            }
        }

        Token(Object obj) {
            this.f918a = obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f918a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f918a);
            }
        }

        public int hashCode() {
            if (this.f918a == null) {
                return 0;
            }
            return this.f918a.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.f918a == null) {
                if (token.f918a != null) {
                    return false;
                }
                return true;
            } else if (token.f918a == null) {
                return false;
            } else {
                return this.f918a.equals(token.f918a);
            }
        }

        public Object m1407a() {
            return this.f918a;
        }
    }

    public static abstract class C0395a {
        final Object f922a;

        private class C0390a implements C0389a {
            final /* synthetic */ C0395a f919a;

            C0390a(C0395a c0395a) {
                this.f919a = c0395a;
            }

            public void mo209a(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f919a.m1453a(str, bundle, resultReceiver);
            }

            public boolean mo210a(Intent intent) {
                return this.f919a.mo877a(intent);
            }

            public void mo205a() {
                this.f919a.mo878b();
            }

            public void mo208a(String str, Bundle bundle) {
                this.f919a.m1460c(str, bundle);
            }

            public void mo213b(String str, Bundle bundle) {
                this.f919a.m1462d(str, bundle);
            }

            public void mo206a(long j) {
                this.f919a.m1449a(j);
            }

            public void mo211b() {
                this.f919a.mo879c();
            }

            public void mo214c() {
                this.f919a.mo880d();
            }

            public void mo216d() {
                this.f919a.m1463e();
            }

            public void mo217e() {
                this.f919a.m1465f();
            }

            public void mo218f() {
                this.f919a.m1466g();
            }

            public void mo219g() {
                this.f919a.mo881h();
            }

            public void mo212b(long j) {
                this.f919a.m1456b(j);
            }

            public void mo207a(Object obj) {
                this.f919a.m1451a(RatingCompat.m1366a(obj));
            }

            public void mo215c(String str, Bundle bundle) {
                if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                    this.f919a.m1457b((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), (Bundle) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                    this.f919a.m1448a();
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                    this.f919a.m1452a(bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                    this.f919a.m1458b(bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                    this.f919a.m1450a((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else {
                    this.f919a.m1464e(str, bundle);
                }
            }
        }

        private class C0392b extends C0390a implements C0391a {
            final /* synthetic */ C0395a f920b;

            C0392b(C0395a c0395a) {
                this.f920b = c0395a;
                super(c0395a);
            }

            public void mo220a(Uri uri, Bundle bundle) {
                this.f920b.m1457b(uri, bundle);
            }
        }

        private class C0394c extends C0392b implements C0393a {
            final /* synthetic */ C0395a f921c;

            C0394c(C0395a c0395a) {
                this.f921c = c0395a;
                super(c0395a);
            }

            public void mo224h() {
                this.f921c.m1448a();
            }

            public void mo222d(String str, Bundle bundle) {
                this.f921c.m1452a(str, bundle);
            }

            public void mo223e(String str, Bundle bundle) {
                this.f921c.m1458b(str, bundle);
            }

            public void mo221b(Uri uri, Bundle bundle) {
                this.f921c.m1450a(uri, bundle);
            }
        }

        public C0395a() {
            if (VERSION.SDK_INT >= 24) {
                this.f922a = C0439k.m1708a(new C0394c(this));
            } else if (VERSION.SDK_INT >= 23) {
                this.f922a = C0437j.m1707a(new C0392b(this));
            } else if (VERSION.SDK_INT >= 21) {
                this.f922a = C0435i.m1700a(new C0390a(this));
            } else {
                this.f922a = null;
            }
        }

        public void m1453a(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public boolean mo877a(Intent intent) {
            return false;
        }

        public void m1448a() {
        }

        public void m1452a(String str, Bundle bundle) {
        }

        public void m1458b(String str, Bundle bundle) {
        }

        public void m1450a(Uri uri, Bundle bundle) {
        }

        public void mo878b() {
        }

        public void m1460c(String str, Bundle bundle) {
        }

        public void m1462d(String str, Bundle bundle) {
        }

        public void m1457b(Uri uri, Bundle bundle) {
        }

        public void m1449a(long j) {
        }

        public void mo879c() {
        }

        public void mo880d() {
        }

        public void m1463e() {
        }

        public void m1465f() {
        }

        public void m1466g() {
        }

        public void mo881h() {
        }

        public void m1456b(long j) {
        }

        public void m1451a(RatingCompat ratingCompat) {
        }

        public void m1464e(String str, Bundle bundle) {
        }
    }

    interface C0396b {
        void mo225a();

        void mo226a(int i);

        void mo227a(C0395a c0395a, Handler handler);

        void mo228a(PlaybackStateCompat playbackStateCompat);

        void mo229a(boolean z);

        Token mo230b();
    }

    static class C0397c implements C0396b {
        private final Object f923a;
        private final Token f924b = new Token(C0435i.m1706b(this.f923a));

        public C0397c(Context context, String str) {
            this.f923a = C0435i.m1699a(context, str);
        }

        public void mo227a(C0395a c0395a, Handler handler) {
            C0435i.m1704a(this.f923a, c0395a == null ? null : c0395a.f922a, handler);
        }

        public void mo226a(int i) {
            C0435i.m1702a(this.f923a, i);
        }

        public void mo229a(boolean z) {
            C0435i.m1705a(this.f923a, z);
        }

        public void mo225a() {
            C0435i.m1701a(this.f923a);
        }

        public Token mo230b() {
            return this.f924b;
        }

        public void mo228a(PlaybackStateCompat playbackStateCompat) {
            Object obj;
            Object obj2 = this.f923a;
            if (playbackStateCompat == null) {
                obj = null;
            } else {
                obj = playbackStateCompat.m1598f();
            }
            C0435i.m1703a(obj2, obj);
        }
    }

    static class C0405d implements C0396b {
        private boolean f932A = false;
        private boolean f933B = false;
        private C0382a f934C = new C03981(this);
        final String f935a;
        final String f936b;
        final AudioManager f937c;
        final Object f938d = new Object();
        final RemoteCallbackList<C0411a> f939e = new RemoteCallbackList();
        boolean f940f = false;
        volatile C0395a f941g;
        int f942h;
        MediaMetadataCompat f943i;
        PlaybackStateCompat f944j;
        PendingIntent f945k;
        List<QueueItem> f946l;
        CharSequence f947m;
        int f948n;
        Bundle f949o;
        int f950p;
        int f951q;
        C0383d f952r;
        private final Context f953s;
        private final ComponentName f954t;
        private final PendingIntent f955u;
        private final Object f956v;
        private final C0403b f957w;
        private final Token f958x;
        private C0404c f959y;
        private boolean f960z = false;

        class C03981 extends C0382a {
            final /* synthetic */ C0405d f925a;

            C03981(C0405d c0405d) {
                this.f925a = c0405d;
            }
        }

        class C03992 implements C0388a {
            final /* synthetic */ C0405d f926a;

            C03992(C0405d c0405d) {
                this.f926a = c0405d;
            }

            public void mo207a(Object obj) {
                this.f926a.m1564a(19, RatingCompat.m1366a(obj));
            }

            public void mo212b(long j) {
                this.f926a.m1564a(18, Long.valueOf(j));
            }
        }

        private static final class C0400a {
            public final String f927a;
            public final Bundle f928b;
            public final ResultReceiver f929c;

            public C0400a(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f927a = str;
                this.f928b = bundle;
                this.f929c = resultReceiver;
            }
        }

        class C0403b extends C0402a {
            final /* synthetic */ C0405d f930a;

            C0403b(C0405d c0405d) {
                this.f930a = c0405d;
            }

            public void mo237a(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                this.f930a.m1564a(1, new C0400a(str, bundle, resultReceiverWrapper.f917a));
            }

            public boolean mo239a(KeyEvent keyEvent) {
                boolean z = (this.f930a.f942h & 1) != 0;
                if (z) {
                    this.f930a.m1564a(21, (Object) keyEvent);
                }
                return z;
            }

            public void mo235a(C0411a c0411a) {
                if (this.f930a.f940f) {
                    try {
                        c0411a.mo267a();
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                this.f930a.f939e.register(c0411a);
            }

            public void mo244b(C0411a c0411a) {
                this.f930a.f939e.unregister(c0411a);
            }

            public String mo240b() {
                return this.f930a.f935a;
            }

            public String mo246c() {
                return this.f930a.f936b;
            }

            public PendingIntent mo248d() {
                PendingIntent pendingIntent;
                synchronized (this.f930a.f938d) {
                    pendingIntent = this.f930a.f945k;
                }
                return pendingIntent;
            }

            public long mo250e() {
                long j;
                synchronized (this.f930a.f938d) {
                    j = (long) this.f930a.f942h;
                }
                return j;
            }

            public ParcelableVolumeInfo mo252f() {
                int i;
                int i2;
                int c;
                int a;
                int i3 = 2;
                synchronized (this.f930a.f938d) {
                    i = this.f930a.f950p;
                    i2 = this.f930a.f951q;
                    C0383d c0383d = this.f930a.f952r;
                    if (i == 2) {
                        i3 = c0383d.m1397b();
                        c = c0383d.m1399c();
                        a = c0383d.m1395a();
                    } else {
                        c = this.f930a.f937c.getStreamMaxVolume(i2);
                        a = this.f930a.f937c.getStreamVolume(i2);
                    }
                }
                return new ParcelableVolumeInfo(i, i2, i3, c, a);
            }

            public void mo231a(int i, int i2, String str) {
                this.f930a.m1563a(i, i2);
            }

            public void mo241b(int i, int i2, String str) {
                this.f930a.m1572b(i, i2);
            }

            public void mo266t() {
                this.f930a.m1571b(3);
            }

            public void mo249d(String str, Bundle bundle) {
                this.f930a.m1565a(4, str, bundle);
            }

            public void mo251e(String str, Bundle bundle) {
                this.f930a.m1565a(5, str, bundle);
            }

            public void mo243b(Uri uri, Bundle bundle) {
                this.f930a.m1565a(6, uri, bundle);
            }

            public void mo253g() {
                this.f930a.m1571b(7);
            }

            public void mo236a(String str, Bundle bundle) {
                this.f930a.m1565a(8, str, bundle);
            }

            public void mo245b(String str, Bundle bundle) {
                this.f930a.m1565a(9, str, bundle);
            }

            public void mo233a(Uri uri, Bundle bundle) {
                this.f930a.m1565a(10, uri, bundle);
            }

            public void mo232a(long j) {
                this.f930a.m1564a(11, Long.valueOf(j));
            }

            public void mo254h() {
                this.f930a.m1571b(12);
            }

            public void mo255i() {
                this.f930a.m1571b(13);
            }

            public void mo256j() {
                this.f930a.m1571b(14);
            }

            public void mo257k() {
                this.f930a.m1571b(15);
            }

            public void mo258l() {
                this.f930a.m1571b(16);
            }

            public void mo259m() {
                this.f930a.m1571b(17);
            }

            public void mo242b(long j) {
                this.f930a.m1564a(18, Long.valueOf(j));
            }

            public void mo234a(RatingCompat ratingCompat) {
                this.f930a.m1564a(19, (Object) ratingCompat);
            }

            public void mo247c(String str, Bundle bundle) {
                this.f930a.m1565a(20, str, bundle);
            }

            public MediaMetadataCompat mo260n() {
                return this.f930a.f943i;
            }

            public PlaybackStateCompat mo261o() {
                return this.f930a.m1573c();
            }

            public List<QueueItem> mo262p() {
                List<QueueItem> list;
                synchronized (this.f930a.f938d) {
                    list = this.f930a.f946l;
                }
                return list;
            }

            public CharSequence mo263q() {
                return this.f930a.f947m;
            }

            public Bundle mo264r() {
                Bundle bundle;
                synchronized (this.f930a.f938d) {
                    bundle = this.f930a.f949o;
                }
                return bundle;
            }

            public int mo265s() {
                return this.f930a.f948n;
            }

            public boolean mo238a() {
                return (this.f930a.f942h & 2) != 0;
            }
        }

        private class C0404c extends Handler {
            final /* synthetic */ C0405d f931a;

            public C0404c(C0405d c0405d, Looper looper) {
                this.f931a = c0405d;
                super(looper);
            }

            public void m1556a(int i, Object obj, Bundle bundle) {
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }

            public void handleMessage(Message message) {
                C0395a c0395a = this.f931a.f941g;
                if (c0395a != null) {
                    switch (message.what) {
                        case 1:
                            C0400a c0400a = (C0400a) message.obj;
                            c0395a.m1453a(c0400a.f927a, c0400a.f928b, c0400a.f929c);
                            return;
                        case 2:
                            this.f931a.m1563a(((Integer) message.obj).intValue(), 0);
                            return;
                        case 3:
                            c0395a.m1448a();
                            return;
                        case 4:
                            c0395a.m1452a((String) message.obj, message.getData());
                            return;
                        case 5:
                            c0395a.m1458b((String) message.obj, message.getData());
                            return;
                        case 6:
                            c0395a.m1450a((Uri) message.obj, message.getData());
                            return;
                        case 7:
                            c0395a.mo878b();
                            return;
                        case 8:
                            c0395a.m1460c((String) message.obj, message.getData());
                            return;
                        case 9:
                            c0395a.m1462d((String) message.obj, message.getData());
                            return;
                        case 10:
                            c0395a.m1457b((Uri) message.obj, message.getData());
                            return;
                        case 11:
                            c0395a.m1449a(((Long) message.obj).longValue());
                            return;
                        case 12:
                            c0395a.mo879c();
                            return;
                        case 13:
                            c0395a.mo881h();
                            return;
                        case 14:
                            c0395a.mo880d();
                            return;
                        case 15:
                            c0395a.m1463e();
                            return;
                        case 16:
                            c0395a.m1465f();
                            return;
                        case 17:
                            c0395a.m1466g();
                            return;
                        case 18:
                            c0395a.m1456b(((Long) message.obj).longValue());
                            return;
                        case 19:
                            c0395a.m1451a((RatingCompat) message.obj);
                            return;
                        case 20:
                            c0395a.m1464e((String) message.obj, message.getData());
                            return;
                        case 21:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!c0395a.mo877a(intent)) {
                                m1555a(keyEvent, c0395a);
                                return;
                            }
                            return;
                        case 22:
                            this.f931a.m1572b(((Integer) message.obj).intValue(), 0);
                            return;
                        default:
                            return;
                    }
                }
            }

            private void m1555a(KeyEvent keyEvent, C0395a c0395a) {
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    long d = this.f931a.f944j == null ? 0 : this.f931a.f944j.m1596d();
                    switch (keyEvent.getKeyCode()) {
                        case 79:
                        case 85:
                            Object obj;
                            if (this.f931a.f944j == null || this.f931a.f944j.m1593a() != 3) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            Object obj2;
                            if ((516 & d) != 0) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            Object obj3;
                            if ((d & 514) != 0) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (obj != null && r0 != null) {
                                c0395a.mo879c();
                                return;
                            } else if (obj == null && r6 != null) {
                                c0395a.mo878b();
                                return;
                            } else {
                                return;
                            }
                        case 86:
                            if ((d & 1) != 0) {
                                c0395a.mo881h();
                                return;
                            }
                            return;
                        case 87:
                            if ((d & 32) != 0) {
                                c0395a.mo880d();
                                return;
                            }
                            return;
                        case 88:
                            if ((d & 16) != 0) {
                                c0395a.m1463e();
                                return;
                            }
                            return;
                        case 89:
                            if ((d & 8) != 0) {
                                c0395a.m1466g();
                                return;
                            }
                            return;
                        case 90:
                            if ((d & 64) != 0) {
                                c0395a.m1465f();
                                return;
                            }
                            return;
                        case 126:
                            if ((d & 4) != 0) {
                                c0395a.mo878b();
                                return;
                            }
                            return;
                        case 127:
                            if ((d & 2) != 0) {
                                c0395a.mo879c();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        public C0405d(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            if (componentName == null) {
                componentName = C0415c.m1652a(context);
                if (componentName == null) {
                    Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
                }
            }
            if (componentName != null && pendingIntent == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            }
            if (componentName == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }
            this.f953s = context;
            this.f935a = context.getPackageName();
            this.f937c = (AudioManager) context.getSystemService("audio");
            this.f936b = str;
            this.f954t = componentName;
            this.f955u = pendingIntent;
            this.f957w = new C0403b(this);
            this.f958x = new Token(this.f957w);
            this.f948n = 0;
            this.f950p = 1;
            this.f951q = 3;
            if (VERSION.SDK_INT >= 14) {
                this.f956v = C0429f.m1679a(pendingIntent);
            } else {
                this.f956v = null;
            }
        }

        public void mo227a(C0395a c0395a, Handler handler) {
            this.f941g = c0395a;
            if (c0395a == null) {
                if (VERSION.SDK_INT >= 18) {
                    C0431g.m1691a(this.f956v, null);
                }
                if (VERSION.SDK_INT >= 19) {
                    C0433h.m1698a(this.f956v, null);
                    return;
                }
                return;
            }
            if (handler == null) {
                handler = new Handler();
            }
            synchronized (this.f938d) {
                this.f959y = new C0404c(this, handler.getLooper());
            }
            C0388a c03992 = new C03992(this);
            if (VERSION.SDK_INT >= 18) {
                C0431g.m1691a(this.f956v, C0431g.m1687a((C0387a) c03992));
            }
            if (VERSION.SDK_INT >= 19) {
                C0433h.m1698a(this.f956v, C0433h.m1694a(c03992));
            }
        }

        void m1571b(int i) {
            m1564a(i, null);
        }

        void m1564a(int i, Object obj) {
            m1565a(i, obj, null);
        }

        void m1565a(int i, Object obj, Bundle bundle) {
            synchronized (this.f938d) {
                if (this.f959y != null) {
                    this.f959y.m1556a(i, obj, bundle);
                }
            }
        }

        public void mo226a(int i) {
            synchronized (this.f938d) {
                this.f942h = i;
            }
            m1559d();
        }

        public void mo229a(boolean z) {
            if (z != this.f960z) {
                this.f960z = z;
                if (m1559d()) {
                    m1566a(this.f943i);
                    mo228a(this.f944j);
                }
            }
        }

        public void mo225a() {
            this.f960z = false;
            this.f940f = true;
            m1559d();
            m1560e();
        }

        public Token mo230b() {
            return this.f958x;
        }

        public void mo228a(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.f938d) {
                this.f944j = playbackStateCompat;
            }
            m1558b(playbackStateCompat);
            if (!this.f960z) {
                return;
            }
            if (playbackStateCompat != null) {
                if (VERSION.SDK_INT >= 18) {
                    C0431g.m1689a(this.f956v, playbackStateCompat.m1593a(), playbackStateCompat.m1594b(), playbackStateCompat.m1595c(), playbackStateCompat.m1597e());
                } else if (VERSION.SDK_INT >= 14) {
                    C0429f.m1682a(this.f956v, playbackStateCompat.m1593a());
                }
                if (VERSION.SDK_INT >= 19) {
                    C0433h.m1696a(this.f956v, playbackStateCompat.m1596d());
                } else if (VERSION.SDK_INT >= 18) {
                    C0431g.m1690a(this.f956v, playbackStateCompat.m1596d());
                } else if (VERSION.SDK_INT >= 14) {
                    C0429f.m1683a(this.f956v, playbackStateCompat.m1596d());
                }
            } else if (VERSION.SDK_INT >= 14) {
                C0429f.m1682a(this.f956v, 0);
                C0429f.m1683a(this.f956v, 0);
            }
        }

        public void m1566a(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle = null;
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new C0375a(mediaMetadataCompat, MediaSessionCompat.f961a).m1357a();
            }
            synchronized (this.f938d) {
                this.f943i = mediaMetadataCompat;
            }
            m1557b(mediaMetadataCompat);
            if (!this.f960z) {
                return;
            }
            Object obj;
            if (VERSION.SDK_INT >= 19) {
                long j;
                obj = this.f956v;
                if (mediaMetadataCompat != null) {
                    bundle = mediaMetadataCompat.m1358a();
                }
                if (this.f944j == null) {
                    j = 0;
                } else {
                    j = this.f944j.m1596d();
                }
                C0433h.m1697a(obj, bundle, j);
            } else if (VERSION.SDK_INT >= 14) {
                obj = this.f956v;
                if (mediaMetadataCompat != null) {
                    bundle = mediaMetadataCompat.m1358a();
                }
                C0429f.m1684a(obj, bundle);
            }
        }

        private boolean m1559d() {
            if (this.f960z) {
                if (!this.f933B && (this.f942h & 1) != 0) {
                    if (VERSION.SDK_INT >= 18) {
                        C0431g.m1688a(this.f953s, this.f955u, this.f954t);
                    } else {
                        ((AudioManager) this.f953s.getSystemService("audio")).registerMediaButtonEventReceiver(this.f954t);
                    }
                    this.f933B = true;
                } else if (this.f933B && (this.f942h & 1) == 0) {
                    if (VERSION.SDK_INT >= 18) {
                        C0431g.m1692b(this.f953s, this.f955u, this.f954t);
                    } else {
                        ((AudioManager) this.f953s.getSystemService("audio")).unregisterMediaButtonEventReceiver(this.f954t);
                    }
                    this.f933B = false;
                }
                if (VERSION.SDK_INT >= 14) {
                    if (!this.f932A && (this.f942h & 2) != 0) {
                        C0429f.m1680a(this.f953s, this.f956v);
                        this.f932A = true;
                        return true;
                    } else if (this.f932A && (this.f942h & 2) == 0) {
                        C0429f.m1682a(this.f956v, 0);
                        C0429f.m1685b(this.f953s, this.f956v);
                        this.f932A = false;
                        return false;
                    }
                }
            }
            if (this.f933B) {
                if (VERSION.SDK_INT >= 18) {
                    C0431g.m1692b(this.f953s, this.f955u, this.f954t);
                } else {
                    ((AudioManager) this.f953s.getSystemService("audio")).unregisterMediaButtonEventReceiver(this.f954t);
                }
                this.f933B = false;
            }
            if (this.f932A) {
                C0429f.m1682a(this.f956v, 0);
                C0429f.m1685b(this.f953s, this.f956v);
                this.f932A = false;
            }
            return false;
        }

        void m1563a(int i, int i2) {
            if (this.f950p != 2) {
                this.f937c.adjustStreamVolume(this.f951q, i, i2);
            } else if (this.f952r != null) {
                this.f952r.m1398b(i);
            }
        }

        void m1572b(int i, int i2) {
            if (this.f950p != 2) {
                this.f937c.setStreamVolume(this.f951q, i, i2);
            } else if (this.f952r != null) {
                this.f952r.m1396a(i);
            }
        }

        PlaybackStateCompat m1573c() {
            PlaybackStateCompat a;
            long j = -1;
            synchronized (this.f938d) {
                PlaybackStateCompat playbackStateCompat = this.f944j;
                if (this.f943i != null && this.f943i.m1359a("android.media.metadata.DURATION")) {
                    j = this.f943i.m1360b("android.media.metadata.DURATION");
                }
            }
            if (playbackStateCompat != null && (playbackStateCompat.m1593a() == 3 || playbackStateCompat.m1593a() == 4 || playbackStateCompat.m1593a() == 5)) {
                long e = playbackStateCompat.m1597e();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (e > 0) {
                    e = ((long) (playbackStateCompat.m1595c() * ((float) (elapsedRealtime - e)))) + playbackStateCompat.m1594b();
                    if (j < 0 || e <= j) {
                        if (e < 0) {
                            j = 0;
                        } else {
                            j = e;
                        }
                    }
                    C0410a c0410a = new C0410a(playbackStateCompat);
                    c0410a.m1590a(playbackStateCompat.m1593a(), j, playbackStateCompat.m1595c(), elapsedRealtime);
                    a = c0410a.m1592a();
                    return a != null ? playbackStateCompat : a;
                }
            }
            a = null;
            if (a != null) {
            }
        }

        private void m1560e() {
            for (int beginBroadcast = this.f939e.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((C0411a) this.f939e.getBroadcastItem(beginBroadcast)).mo267a();
                } catch (RemoteException e) {
                }
            }
            this.f939e.finishBroadcast();
            this.f939e.kill();
        }

        private void m1558b(PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.f939e.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((C0411a) this.f939e.getBroadcastItem(beginBroadcast)).mo271a(playbackStateCompat);
                } catch (RemoteException e) {
                }
            }
            this.f939e.finishBroadcast();
        }

        private void m1557b(MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.f939e.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((C0411a) this.f939e.getBroadcastItem(beginBroadcast)).mo269a(mediaMetadataCompat);
                } catch (RemoteException e) {
                }
            }
            this.f939e.finishBroadcast();
        }
    }

    public interface C0406e {
        void m1574a();
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        } else {
            if (VERSION.SDK_INT >= 21) {
                this.f962b = new C0397c(context, str);
            } else {
                this.f962b = new C0405d(context, str, componentName, pendingIntent);
            }
            this.f963c = new C0426d(context, this);
            if (f961a == 0) {
                f961a = (int) TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics());
            }
        }
    }

    public void m1577a(C0395a c0395a) {
        m1578a(c0395a, null);
    }

    public void m1578a(C0395a c0395a, Handler handler) {
        C0396b c0396b = this.f962b;
        if (handler == null) {
            handler = new Handler();
        }
        c0396b.mo227a(c0395a, handler);
    }

    public void m1576a(int i) {
        this.f962b.mo226a(i);
    }

    public void m1580a(boolean z) {
        this.f962b.mo229a(z);
        Iterator it = this.f964d.iterator();
        while (it.hasNext()) {
            ((C0406e) it.next()).m1574a();
        }
    }

    public void m1575a() {
        this.f962b.mo225a();
    }

    public Token m1581b() {
        return this.f962b.mo230b();
    }

    public void m1579a(PlaybackStateCompat playbackStateCompat) {
        this.f962b.mo228a(playbackStateCompat);
    }
}
