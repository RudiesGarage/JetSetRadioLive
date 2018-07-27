package android.support.v4.media.session;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.session.C0401b.C0402a;
import android.support.v4.media.session.C0428e.C0427a;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.util.Log;

/* compiled from: MediaControllerCompat */
public final class C0426d {
    private final C0416a f1004a;
    private final Token f1005b;

    /* compiled from: MediaControllerCompat */
    interface C0416a {
        C0421f mo275a();
    }

    /* compiled from: MediaControllerCompat */
    static class C0417b implements C0416a {
        protected final Object f998a;

        public C0417b(Context context, MediaSessionCompat mediaSessionCompat) {
            this.f998a = C0428e.m1675a(context, mediaSessionCompat.m1581b().m1407a());
        }

        public C0417b(Context context, Token token) {
            this.f998a = C0428e.m1675a(context, token.m1407a());
            if (this.f998a == null) {
                throw new RemoteException();
            }
        }

        public C0421f mo275a() {
            Object a = C0428e.m1676a(this.f998a);
            return a != null ? new C0422g(a) : null;
        }
    }

    /* compiled from: MediaControllerCompat */
    static class C0418c extends C0417b {
        public C0418c(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        public C0418c(Context context, Token token) {
            super(context, token);
        }

        public C0421f mo275a() {
            Object a = C0428e.m1676a(this.a);
            return a != null ? new C0423h(a) : null;
        }
    }

    /* compiled from: MediaControllerCompat */
    static class C0419d extends C0418c {
        public C0419d(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        public C0419d(Context context, Token token) {
            super(context, token);
        }

        public C0421f mo275a() {
            Object a = C0428e.m1676a(this.a);
            return a != null ? new C0424i(a) : null;
        }
    }

    /* compiled from: MediaControllerCompat */
    static class C0420e implements C0416a {
        private Token f999a;
        private C0401b f1000b;
        private C0421f f1001c;

        public C0420e(Token token) {
            this.f999a = token;
            this.f1000b = C0402a.m1518a((IBinder) token.m1407a());
        }

        public C0421f mo275a() {
            if (this.f1001c == null) {
                this.f1001c = new C0425j(this.f1000b);
            }
            return this.f1001c;
        }
    }

    /* compiled from: MediaControllerCompat */
    public static abstract class C0421f {
        public abstract void mo276a();

        public abstract void mo277b();

        public abstract void mo278c();

        public abstract void mo279d();

        C0421f() {
        }
    }

    /* compiled from: MediaControllerCompat */
    static class C0422g extends C0421f {
        protected final Object f1002a;

        public C0422g(Object obj) {
            this.f1002a = obj;
        }

        public void mo276a() {
            C0427a.m1671a(this.f1002a);
        }

        public void mo277b() {
            C0427a.m1672b(this.f1002a);
        }

        public void mo278c() {
            C0427a.m1673c(this.f1002a);
        }

        public void mo279d() {
            C0427a.m1674d(this.f1002a);
        }
    }

    /* compiled from: MediaControllerCompat */
    static class C0423h extends C0422g {
        public C0423h(Object obj) {
            super(obj);
        }
    }

    /* compiled from: MediaControllerCompat */
    static class C0424i extends C0423h {
        public C0424i(Object obj) {
            super(obj);
        }
    }

    /* compiled from: MediaControllerCompat */
    static class C0425j extends C0421f {
        private C0401b f1003a;

        public C0425j(C0401b c0401b) {
            this.f1003a = c0401b;
        }

        public void mo276a() {
            try {
                this.f1003a.mo253g();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in play. " + e);
            }
        }

        public void mo277b() {
            try {
                this.f1003a.mo254h();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in pause. " + e);
            }
        }

        public void mo278c() {
            try {
                this.f1003a.mo255i();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in stop. " + e);
            }
        }

        public void mo279d() {
            try {
                this.f1003a.mo256j();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext. " + e);
            }
        }
    }

    public C0426d(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        this.f1005b = mediaSessionCompat.m1581b();
        if (VERSION.SDK_INT >= 24) {
            this.f1004a = new C0419d(context, mediaSessionCompat);
        } else if (VERSION.SDK_INT >= 23) {
            this.f1004a = new C0418c(context, mediaSessionCompat);
        } else if (VERSION.SDK_INT >= 21) {
            this.f1004a = new C0417b(context, mediaSessionCompat);
        } else {
            this.f1004a = new C0420e(this.f1005b);
        }
    }

    public C0426d(Context context, Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.f1005b = token;
        if (VERSION.SDK_INT >= 24) {
            this.f1004a = new C0419d(context, token);
        } else if (VERSION.SDK_INT >= 23) {
            this.f1004a = new C0418c(context, token);
        } else if (VERSION.SDK_INT >= 21) {
            this.f1004a = new C0417b(context, token);
        } else {
            this.f1004a = new C0420e(this.f1005b);
        }
    }

    public C0421f m1670a() {
        return this.f1004a.mo275a();
    }
}
