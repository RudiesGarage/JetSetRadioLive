package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.aj.C0202a;
import android.support.v4.app.aj.C0202a.C0196a;

/* compiled from: RemoteInput */
public final class ah extends C0202a {
    public static final C0196a f507a = new C01971();
    private static final C0198a f508g;
    private final String f509b;
    private final CharSequence f510c;
    private final CharSequence[] f511d;
    private final boolean f512e;
    private final Bundle f513f;

    /* compiled from: RemoteInput */
    static class C01971 implements C0196a {
        C01971() {
        }
    }

    /* compiled from: RemoteInput */
    interface C0198a {
    }

    /* compiled from: RemoteInput */
    static class C0199b implements C0198a {
        C0199b() {
        }
    }

    /* compiled from: RemoteInput */
    static class C0200c implements C0198a {
        C0200c() {
        }
    }

    /* compiled from: RemoteInput */
    static class C0201d implements C0198a {
        C0201d() {
        }
    }

    public String mo96a() {
        return this.f509b;
    }

    public CharSequence mo97b() {
        return this.f510c;
    }

    public CharSequence[] mo98c() {
        return this.f511d;
    }

    public boolean mo99d() {
        return this.f512e;
    }

    public Bundle mo100e() {
        return this.f513f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f508g = new C0199b();
        } else if (VERSION.SDK_INT >= 16) {
            f508g = new C0201d();
        } else {
            f508g = new C0200c();
        }
    }
}
