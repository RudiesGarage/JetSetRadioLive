package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.C0245t.C0244a;
import android.support.v4.p018b.C0287e;
import android.support.v4.p018b.C0287e.C0246a;
import android.support.v4.p018b.C0287e.C0247b;
import android.support.v4.p024g.C0359c;
import android.support.v4.p024g.C0371j;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: LoaderManager */
class C0249u extends C0245t {
    static boolean f685a = false;
    final C0371j<C0248a> f686b = new C0371j();
    final C0371j<C0248a> f687c = new C0371j();
    final String f688d;
    boolean f689e;
    boolean f690f;
    C0220m f691g;

    /* compiled from: LoaderManager */
    final class C0248a implements C0246a<Object>, C0247b<Object> {
        final int f670a;
        final Bundle f671b;
        C0244a<Object> f672c;
        C0287e<Object> f673d;
        boolean f674e;
        boolean f675f;
        Object f676g;
        boolean f677h;
        boolean f678i;
        boolean f679j;
        boolean f680k;
        boolean f681l;
        boolean f682m;
        C0248a f683n;
        final /* synthetic */ C0249u f684o;

        void m957a() {
            if (this.f678i && this.f679j) {
                this.f677h = true;
            } else if (!this.f677h) {
                this.f677h = true;
                if (C0249u.f685a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f673d == null && this.f672c != null) {
                    this.f673d = this.f672c.m953a(this.f670a, this.f671b);
                }
                if (this.f673d == null) {
                    return;
                }
                if (!this.f673d.getClass().isMemberClass() || Modifier.isStatic(this.f673d.getClass().getModifiers())) {
                    if (!this.f682m) {
                        this.f673d.m1074a(this.f670a, this);
                        this.f673d.m1075a((C0246a) this);
                        this.f682m = true;
                    }
                    this.f673d.m1073a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f673d);
            }
        }

        void m960b() {
            if (C0249u.f685a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f678i = true;
            this.f679j = this.f677h;
            this.f677h = false;
            this.f672c = null;
        }

        void m961c() {
            if (this.f678i) {
                if (C0249u.f685a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f678i = false;
                if (!(this.f677h == this.f679j || this.f677h)) {
                    m963e();
                }
            }
            if (this.f677h && this.f674e && !this.f680k) {
                m958a(this.f673d, this.f676g);
            }
        }

        void m962d() {
            if (this.f677h && this.f680k) {
                this.f680k = false;
                if (this.f674e && !this.f678i) {
                    m958a(this.f673d, this.f676g);
                }
            }
        }

        void m963e() {
            if (C0249u.f685a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f677h = false;
            if (!this.f678i && this.f673d != null && this.f682m) {
                this.f682m = false;
                this.f673d.m1076a((C0247b) this);
                this.f673d.m1079b(this);
                this.f673d.m1080c();
            }
        }

        void m964f() {
            String str;
            C0244a c0244a = null;
            if (C0249u.f685a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f681l = true;
            boolean z = this.f675f;
            this.f675f = false;
            if (this.f672c != null && this.f673d != null && this.f674e && z) {
                if (C0249u.f685a) {
                    Log.v("LoaderManager", "  Resetting: " + this);
                }
                if (this.f684o.f691g != null) {
                    String str2 = this.f684o.f691g.f574d.f633v;
                    this.f684o.f691g.f574d.f633v = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f672c.m954a(this.f673d);
                } finally {
                    c0244a = this.f684o.f691g;
                    if (c0244a != null) {
                        c0244a = this.f684o.f691g.f574d;
                        c0244a.f633v = str;
                    }
                }
            }
            this.f672c = c0244a;
            this.f676g = c0244a;
            this.f674e = false;
            if (this.f673d != null) {
                if (this.f682m) {
                    this.f682m = false;
                    this.f673d.m1076a((C0247b) this);
                    this.f673d.m1079b(this);
                }
                this.f673d.m1082e();
            }
            if (this.f683n != null) {
                this.f683n.m964f();
            }
        }

        void m958a(C0287e<Object> c0287e, Object obj) {
            String str;
            if (this.f672c != null) {
                if (this.f684o.f691g != null) {
                    String str2 = this.f684o.f691g.f574d.f633v;
                    this.f684o.f691g.f574d.f633v = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (C0249u.f685a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + c0287e + ": " + c0287e.m1072a(obj));
                    }
                    this.f672c.m955a((C0287e) c0287e, obj);
                    this.f675f = true;
                } finally {
                    if (this.f684o.f691g != null) {
                        this.f684o.f691g.f574d.f633v = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f670a);
            stringBuilder.append(" : ");
            C0359c.m1301a(this.f673d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public void m959a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f670a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f671b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f672c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f673d);
            if (this.f673d != null) {
                this.f673d.m1077a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f674e || this.f675f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f674e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f675f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f676g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f677h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f680k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f681l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f678i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f679j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f682m);
            if (this.f683n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f683n);
                printWriter.println(":");
                this.f683n.m959a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    C0249u(String str, C0220m c0220m, boolean z) {
        this.f688d = str;
        this.f691g = c0220m;
        this.f689e = z;
    }

    void m965a(C0220m c0220m) {
        this.f691g = c0220m;
    }

    void m968b() {
        if (f685a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f689e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f689e = true;
        for (int b = this.f686b.m1332b() - 1; b >= 0; b--) {
            ((C0248a) this.f686b.m1338e(b)).m957a();
        }
    }

    void m969c() {
        if (f685a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f689e) {
            for (int b = this.f686b.m1332b() - 1; b >= 0; b--) {
                ((C0248a) this.f686b.m1338e(b)).m963e();
            }
            this.f689e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m970d() {
        if (f685a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f689e) {
            this.f690f = true;
            this.f689e = false;
            for (int b = this.f686b.m1332b() - 1; b >= 0; b--) {
                ((C0248a) this.f686b.m1338e(b)).m960b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m971e() {
        if (this.f690f) {
            if (f685a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f690f = false;
            for (int b = this.f686b.m1332b() - 1; b >= 0; b--) {
                ((C0248a) this.f686b.m1338e(b)).m961c();
            }
        }
    }

    void m972f() {
        for (int b = this.f686b.m1332b() - 1; b >= 0; b--) {
            ((C0248a) this.f686b.m1338e(b)).f680k = true;
        }
    }

    void m973g() {
        for (int b = this.f686b.m1332b() - 1; b >= 0; b--) {
            ((C0248a) this.f686b.m1338e(b)).m962d();
        }
    }

    void m974h() {
        int b;
        if (!this.f690f) {
            if (f685a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f686b.m1332b() - 1; b >= 0; b--) {
                ((C0248a) this.f686b.m1338e(b)).m964f();
            }
            this.f686b.m1335c();
        }
        if (f685a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f687c.m1332b() - 1; b >= 0; b--) {
            ((C0248a) this.f687c.m1338e(b)).m964f();
        }
        this.f687c.m1335c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0359c.m1301a(this.f691g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m966a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f686b.m1332b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f686b.m1332b(); i2++) {
                C0248a c0248a = (C0248a) this.f686b.m1338e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f686b.m1337d(i2));
                printWriter.print(": ");
                printWriter.println(c0248a.toString());
                c0248a.m959a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f687c.m1332b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f687c.m1332b()) {
                c0248a = (C0248a) this.f687c.m1338e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f687c.m1337d(i));
                printWriter.print(": ");
                printWriter.println(c0248a.toString());
                c0248a.m959a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean mo157a() {
        int b = this.f686b.m1332b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            C0248a c0248a = (C0248a) this.f686b.m1338e(i);
            if (!c0248a.f677h || c0248a.f675f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
