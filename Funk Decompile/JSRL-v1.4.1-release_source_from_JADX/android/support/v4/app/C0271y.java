package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0273z.C0272a;
import android.support.v4.app.aa.C0189a;
import android.support.v4.app.ab.C0190a;
import android.support.v4.app.ac.C0192a;
import android.support.v4.app.ac.C0192a.C0191a;
import android.support.v4.app.ae.C0193a;
import android.support.v4.app.af.C0194a;
import android.support.v4.app.ag.C0195a;
import android.support.v4.app.aj.C0202a;
import android.support.v4.p022e.C0323c;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompat */
public class C0271y {
    static final C0262h f755a;

    /* compiled from: NotificationCompat */
    public static class C0253a extends C0192a {
        public static final C0191a f698e = new C02511();
        final Bundle f699a;
        public int f700b;
        public CharSequence f701c;
        public PendingIntent f702d;
        private final ah[] f703f;
        private boolean f704g = false;

        /* compiled from: NotificationCompat */
        static class C02511 implements C0191a {
            C02511() {
            }
        }

        /* compiled from: NotificationCompat */
        public static final class C0252a {
            private final int f692a;
            private final CharSequence f693b;
            private final PendingIntent f694c;
            private boolean f695d;
            private final Bundle f696e;
            private ArrayList<ah> f697f;

            public C0252a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle());
            }

            private C0252a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
                this.f692a = i;
                this.f693b = C0257d.m988d(charSequence);
                this.f694c = pendingIntent;
                this.f696e = bundle;
            }

            public C0253a m976a() {
                return new C0253a(this.f692a, this.f693b, this.f694c, this.f696e, this.f697f != null ? (ah[]) this.f697f.toArray(new ah[this.f697f.size()]) : null, this.f695d);
            }
        }

        public /* synthetic */ C0202a[] mo163g() {
            return m982f();
        }

        C0253a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, ah[] ahVarArr, boolean z) {
            this.f700b = i;
            this.f701c = C0257d.m988d(charSequence);
            this.f702d = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f699a = bundle;
            this.f703f = ahVarArr;
            this.f704g = z;
        }

        public int mo158a() {
            return this.f700b;
        }

        public CharSequence mo159b() {
            return this.f701c;
        }

        public PendingIntent mo160c() {
            return this.f702d;
        }

        public Bundle mo161d() {
            return this.f699a;
        }

        public boolean mo162e() {
            return this.f704g;
        }

        public ah[] m982f() {
            return this.f703f;
        }
    }

    /* compiled from: NotificationCompat */
    public static abstract class C0254q {
        C0257d f705d;
        CharSequence f706e;
        CharSequence f707f;
        boolean f708g = false;

        public void m985a(C0257d c0257d) {
            if (this.f705d != c0257d) {
                this.f705d = c0257d;
                if (this.f705d != null) {
                    this.f705d.m995a(this);
                }
            }
        }

        public void mo164a(Bundle bundle) {
        }
    }

    /* compiled from: NotificationCompat */
    public static class C0255b extends C0254q {
        Bitmap f709a;
        Bitmap f710b;
        boolean f711c;
    }

    /* compiled from: NotificationCompat */
    public static class C0256c extends C0254q {
        CharSequence f712a;

        public C0256c m986a(CharSequence charSequence) {
            this.f712a = C0257d.m988d(charSequence);
            return this;
        }
    }

    /* compiled from: NotificationCompat */
    public static class C0257d {
        int f713A = 0;
        Notification f714B;
        RemoteViews f715C;
        RemoteViews f716D;
        RemoteViews f717E;
        public Notification f718F = new Notification();
        public ArrayList<String> f719G;
        public Context f720a;
        public CharSequence f721b;
        public CharSequence f722c;
        PendingIntent f723d;
        PendingIntent f724e;
        RemoteViews f725f;
        public Bitmap f726g;
        public CharSequence f727h;
        public int f728i;
        int f729j;
        boolean f730k = true;
        public boolean f731l;
        public C0254q f732m;
        public CharSequence f733n;
        public CharSequence[] f734o;
        int f735p;
        int f736q;
        boolean f737r;
        String f738s;
        boolean f739t;
        String f740u;
        public ArrayList<C0253a> f741v = new ArrayList();
        boolean f742w = false;
        String f743x;
        Bundle f744y;
        int f745z = 0;

        public C0257d(Context context) {
            this.f720a = context;
            this.f718F.when = System.currentTimeMillis();
            this.f718F.audioStreamType = -1;
            this.f729j = 0;
            this.f719G = new ArrayList();
        }

        public C0257d m991a(long j) {
            this.f718F.when = j;
            return this;
        }

        public C0257d m997a(boolean z) {
            this.f730k = z;
            return this;
        }

        public C0257d m990a(int i) {
            this.f718F.icon = i;
            return this;
        }

        public C0257d m996a(CharSequence charSequence) {
            this.f721b = C0257d.m988d(charSequence);
            return this;
        }

        public C0257d m999b(CharSequence charSequence) {
            this.f722c = C0257d.m988d(charSequence);
            return this;
        }

        public C0257d m992a(PendingIntent pendingIntent) {
            this.f723d = pendingIntent;
            return this;
        }

        public C0257d m1002c(CharSequence charSequence) {
            this.f718F.tickerText = C0257d.m988d(charSequence);
            return this;
        }

        public C0257d m993a(Bitmap bitmap) {
            this.f726g = bitmap;
            return this;
        }

        public C0257d m1000b(boolean z) {
            m987a(16, z);
            return this;
        }

        public C0257d m1003c(boolean z) {
            this.f742w = z;
            return this;
        }

        private void m987a(int i, boolean z) {
            if (z) {
                Notification notification = this.f718F;
                notification.flags |= i;
                return;
            }
            notification = this.f718F;
            notification.flags &= i ^ -1;
        }

        public C0257d m994a(C0253a c0253a) {
            this.f741v.add(c0253a);
            return this;
        }

        public C0257d m995a(C0254q c0254q) {
            if (this.f732m != c0254q) {
                this.f732m = c0254q;
                if (this.f732m != null) {
                    this.f732m.m985a(this);
                }
            }
            return this;
        }

        public C0257d m998b(int i) {
            this.f713A = i;
            return this;
        }

        public Notification m989a() {
            return C0271y.f755a.mo165a(this, mo475b());
        }

        protected C0258e mo475b() {
            return new C0258e();
        }

        protected static CharSequence m988d(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        public RemoteViews m1004c() {
            return this.f715C;
        }

        public RemoteViews m1005d() {
            return this.f716D;
        }

        public RemoteViews m1006e() {
            return this.f717E;
        }

        public long m1007f() {
            return this.f730k ? this.f718F.when : 0;
        }

        public int m1008g() {
            return this.f729j;
        }

        public int m1009h() {
            return this.f745z;
        }

        protected CharSequence mo476i() {
            return this.f722c;
        }

        protected CharSequence mo477j() {
            return this.f721b;
        }
    }

    /* compiled from: NotificationCompat */
    protected static class C0258e {
        protected C0258e() {
        }

        public Notification mo474a(C0257d c0257d, C0188x c0188x) {
            Notification b = c0188x.mo95b();
            if (c0257d.f715C != null) {
                b.contentView = c0257d.f715C;
            }
            return b;
        }
    }

    /* compiled from: NotificationCompat */
    public static class C0259f extends C0254q {
        ArrayList<CharSequence> f746a = new ArrayList();
    }

    /* compiled from: NotificationCompat */
    public static class C0261g extends C0254q {
        CharSequence f752a;
        CharSequence f753b;
        List<C0260a> f754c = new ArrayList();

        /* compiled from: NotificationCompat */
        public static final class C0260a {
            private final CharSequence f747a;
            private final long f748b;
            private final CharSequence f749c;
            private String f750d;
            private Uri f751e;

            public CharSequence m1015a() {
                return this.f747a;
            }

            public long m1016b() {
                return this.f748b;
            }

            public CharSequence m1017c() {
                return this.f749c;
            }

            public String m1018d() {
                return this.f750d;
            }

            public Uri m1019e() {
                return this.f751e;
            }

            private Bundle m1014f() {
                Bundle bundle = new Bundle();
                if (this.f747a != null) {
                    bundle.putCharSequence("text", this.f747a);
                }
                bundle.putLong("time", this.f748b);
                if (this.f749c != null) {
                    bundle.putCharSequence("sender", this.f749c);
                }
                if (this.f750d != null) {
                    bundle.putString("type", this.f750d);
                }
                if (this.f751e != null) {
                    bundle.putParcelable("uri", this.f751e);
                }
                return bundle;
            }

            static Bundle[] m1013a(List<C0260a> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = ((C0260a) list.get(i)).m1014f();
                }
                return bundleArr;
            }
        }

        C0261g() {
        }

        public CharSequence m1020a() {
            return this.f752a;
        }

        public CharSequence m1022b() {
            return this.f753b;
        }

        public List<C0260a> m1023c() {
            return this.f754c;
        }

        public void mo164a(Bundle bundle) {
            super.mo164a(bundle);
            if (this.f752a != null) {
                bundle.putCharSequence("android.selfDisplayName", this.f752a);
            }
            if (this.f753b != null) {
                bundle.putCharSequence("android.conversationTitle", this.f753b);
            }
            if (!this.f754c.isEmpty()) {
                bundle.putParcelableArray("android.messages", C0260a.m1013a(this.f754c));
            }
        }
    }

    /* compiled from: NotificationCompat */
    interface C0262h {
        Notification mo165a(C0257d c0257d, C0258e c0258e);
    }

    /* compiled from: NotificationCompat */
    static class C0263l implements C0262h {
        C0263l() {
        }

        public Notification mo165a(C0257d c0257d, C0258e c0258e) {
            Notification a = ac.m635a(c0257d.f718F, c0257d.f720a, c0257d.mo477j(), c0257d.mo476i(), c0257d.f723d, c0257d.f724e);
            if (c0257d.f729j > 0) {
                a.flags |= 128;
            }
            if (c0257d.f715C != null) {
                a.contentView = c0257d.f715C;
            }
            return a;
        }

        public Bundle mo166a(Notification notification) {
            return null;
        }
    }

    /* compiled from: NotificationCompat */
    static class C0264o extends C0263l {
        C0264o() {
        }

        public Notification mo165a(C0257d c0257d, C0258e c0258e) {
            C0188x c0194a = new C0194a(c0257d.f720a, c0257d.f718F, c0257d.mo477j(), c0257d.mo476i(), c0257d.f727h, c0257d.f725f, c0257d.f728i, c0257d.f723d, c0257d.f724e, c0257d.f726g, c0257d.f735p, c0257d.f736q, c0257d.f737r, c0257d.f731l, c0257d.f729j, c0257d.f733n, c0257d.f742w, c0257d.f744y, c0257d.f738s, c0257d.f739t, c0257d.f740u, c0257d.f715C, c0257d.f716D);
            C0271y.m1036a((C0187w) c0194a, c0257d.f741v);
            C0271y.m1037a(c0194a, c0257d.f732m);
            Notification a = c0258e.mo474a(c0257d, c0194a);
            if (c0257d.f732m != null) {
                Bundle a2 = mo166a(a);
                if (a2 != null) {
                    c0257d.f732m.mo164a(a2);
                }
            }
            return a;
        }

        public Bundle mo166a(Notification notification) {
            return af.m643a(notification);
        }
    }

    /* compiled from: NotificationCompat */
    static class C0265p extends C0264o {
        C0265p() {
        }

        public Notification mo165a(C0257d c0257d, C0258e c0258e) {
            C0188x c0195a = new C0195a(c0257d.f720a, c0257d.f718F, c0257d.mo477j(), c0257d.mo476i(), c0257d.f727h, c0257d.f725f, c0257d.f728i, c0257d.f723d, c0257d.f724e, c0257d.f726g, c0257d.f735p, c0257d.f736q, c0257d.f737r, c0257d.f730k, c0257d.f731l, c0257d.f729j, c0257d.f733n, c0257d.f742w, c0257d.f719G, c0257d.f744y, c0257d.f738s, c0257d.f739t, c0257d.f740u, c0257d.f715C, c0257d.f716D);
            C0271y.m1036a((C0187w) c0195a, c0257d.f741v);
            C0271y.m1037a(c0195a, c0257d.f732m);
            return c0258e.mo474a(c0257d, c0195a);
        }

        public Bundle mo166a(Notification notification) {
            return ag.m651a(notification);
        }
    }

    /* compiled from: NotificationCompat */
    static class C0266i extends C0265p {
        C0266i() {
        }

        public Notification mo165a(C0257d c0257d, C0258e c0258e) {
            C0188x c0272a = new C0272a(c0257d.f720a, c0257d.f718F, c0257d.mo477j(), c0257d.mo476i(), c0257d.f727h, c0257d.f725f, c0257d.f728i, c0257d.f723d, c0257d.f724e, c0257d.f726g, c0257d.f735p, c0257d.f736q, c0257d.f737r, c0257d.f730k, c0257d.f731l, c0257d.f729j, c0257d.f733n, c0257d.f742w, c0257d.f719G, c0257d.f744y, c0257d.f738s, c0257d.f739t, c0257d.f740u, c0257d.f715C, c0257d.f716D);
            C0271y.m1036a((C0187w) c0272a, c0257d.f741v);
            C0271y.m1037a(c0272a, c0257d.f732m);
            Notification a = c0258e.mo474a(c0257d, c0272a);
            if (c0257d.f732m != null) {
                c0257d.f732m.mo164a(mo166a(a));
            }
            return a;
        }
    }

    /* compiled from: NotificationCompat */
    static class C0267j extends C0266i {
        C0267j() {
        }

        public Notification mo165a(C0257d c0257d, C0258e c0258e) {
            C0188x c0189a = new C0189a(c0257d.f720a, c0257d.f718F, c0257d.mo477j(), c0257d.mo476i(), c0257d.f727h, c0257d.f725f, c0257d.f728i, c0257d.f723d, c0257d.f724e, c0257d.f726g, c0257d.f735p, c0257d.f736q, c0257d.f737r, c0257d.f730k, c0257d.f731l, c0257d.f729j, c0257d.f733n, c0257d.f742w, c0257d.f743x, c0257d.f719G, c0257d.f744y, c0257d.f745z, c0257d.f713A, c0257d.f714B, c0257d.f738s, c0257d.f739t, c0257d.f740u, c0257d.f715C, c0257d.f716D, c0257d.f717E);
            C0271y.m1036a((C0187w) c0189a, c0257d.f741v);
            C0271y.m1037a(c0189a, c0257d.f732m);
            Notification a = c0258e.mo474a(c0257d, c0189a);
            if (c0257d.f732m != null) {
                c0257d.f732m.mo164a(mo166a(a));
            }
            return a;
        }
    }

    /* compiled from: NotificationCompat */
    static class C0268k extends C0267j {
        C0268k() {
        }

        public Notification mo165a(C0257d c0257d, C0258e c0258e) {
            C0187w c0190a = new C0190a(c0257d.f720a, c0257d.f718F, c0257d.f721b, c0257d.f722c, c0257d.f727h, c0257d.f725f, c0257d.f728i, c0257d.f723d, c0257d.f724e, c0257d.f726g, c0257d.f735p, c0257d.f736q, c0257d.f737r, c0257d.f730k, c0257d.f731l, c0257d.f729j, c0257d.f733n, c0257d.f742w, c0257d.f743x, c0257d.f719G, c0257d.f744y, c0257d.f745z, c0257d.f713A, c0257d.f714B, c0257d.f738s, c0257d.f739t, c0257d.f740u, c0257d.f734o, c0257d.f715C, c0257d.f716D, c0257d.f717E);
            C0271y.m1036a(c0190a, c0257d.f741v);
            C0271y.m1038b(c0190a, c0257d.f732m);
            Notification a = c0258e.mo474a(c0257d, c0190a);
            if (c0257d.f732m != null) {
                c0257d.f732m.mo164a(mo166a(a));
            }
            return a;
        }
    }

    /* compiled from: NotificationCompat */
    static class C0269m extends C0263l {
        C0269m() {
        }

        public Notification mo165a(C0257d c0257d, C0258e c0258e) {
            Notification a = ad.m636a(c0257d.f720a, c0257d.f718F, c0257d.mo477j(), c0257d.mo476i(), c0257d.f727h, c0257d.f725f, c0257d.f728i, c0257d.f723d, c0257d.f724e, c0257d.f726g);
            if (c0257d.f715C != null) {
                a.contentView = c0257d.f715C;
            }
            return a;
        }
    }

    /* compiled from: NotificationCompat */
    static class C0270n extends C0263l {
        C0270n() {
        }

        public Notification mo165a(C0257d c0257d, C0258e c0258e) {
            return c0258e.mo474a(c0257d, new C0193a(c0257d.f720a, c0257d.f718F, c0257d.mo477j(), c0257d.mo476i(), c0257d.f727h, c0257d.f725f, c0257d.f728i, c0257d.f723d, c0257d.f724e, c0257d.f726g, c0257d.f735p, c0257d.f736q, c0257d.f737r));
        }
    }

    static void m1036a(C0187w c0187w, ArrayList<C0253a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c0187w.mo94a((C0253a) it.next());
        }
    }

    static void m1037a(C0188x c0188x, C0254q c0254q) {
        if (c0254q == null) {
            return;
        }
        if (c0254q instanceof C0256c) {
            C0256c c0256c = (C0256c) c0254q;
            af.m646a(c0188x, c0256c.e, c0256c.g, c0256c.f, c0256c.f712a);
        } else if (c0254q instanceof C0259f) {
            C0259f c0259f = (C0259f) c0254q;
            af.m647a(c0188x, c0259f.e, c0259f.g, c0259f.f, c0259f.f746a);
        } else if (c0254q instanceof C0255b) {
            C0255b c0255b = (C0255b) c0254q;
            af.m645a(c0188x, c0255b.e, c0255b.g, c0255b.f, c0255b.f709a, c0255b.f710b, c0255b.f711c);
        }
    }

    static void m1038b(C0188x c0188x, C0254q c0254q) {
        if (c0254q == null) {
            return;
        }
        if (c0254q instanceof C0261g) {
            C0261g c0261g = (C0261g) c0254q;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            List arrayList4 = new ArrayList();
            List arrayList5 = new ArrayList();
            for (C0260a c0260a : c0261g.f754c) {
                arrayList.add(c0260a.m1015a());
                arrayList2.add(Long.valueOf(c0260a.m1016b()));
                arrayList3.add(c0260a.m1017c());
                arrayList4.add(c0260a.m1018d());
                arrayList5.add(c0260a.m1019e());
            }
            ab.m628a(c0188x, c0261g.f752a, c0261g.f753b, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
            return;
        }
        C0271y.m1037a(c0188x, c0254q);
    }

    static {
        if (C0323c.m1195a()) {
            f755a = new C0268k();
        } else if (VERSION.SDK_INT >= 21) {
            f755a = new C0267j();
        } else if (VERSION.SDK_INT >= 20) {
            f755a = new C0266i();
        } else if (VERSION.SDK_INT >= 19) {
            f755a = new C0265p();
        } else if (VERSION.SDK_INT >= 16) {
            f755a = new C0264o();
        } else if (VERSION.SDK_INT >= 14) {
            f755a = new C0270n();
        } else if (VERSION.SDK_INT >= 11) {
            f755a = new C0269m();
        } else {
            f755a = new C0263l();
        }
    }
}
