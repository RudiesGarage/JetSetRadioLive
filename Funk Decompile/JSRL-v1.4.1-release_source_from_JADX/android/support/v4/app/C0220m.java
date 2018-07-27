package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.p024g.C0356i;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback */
public abstract class C0220m<E> extends C0177k {
    private final Activity f571a;
    final Context f572b;
    final int f573c;
    final C0234o f574d;
    private final Handler f575e;
    private C0356i<String, C0245t> f576f;
    private boolean f577g;
    private C0249u f578h;
    private boolean f579i;
    private boolean f580j;

    public abstract E mo128g();

    C0220m(C0223j c0223j) {
        this(c0223j, c0223j, c0223j.f585c, 0);
    }

    C0220m(Activity activity, Context context, Handler handler, int i) {
        this.f574d = new C0234o();
        this.f571a = activity;
        this.f572b = context;
        this.f575e = handler;
        this.f573c = i;
    }

    public void mo120a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean mo121a(Fragment fragment) {
        return true;
    }

    public LayoutInflater mo123b() {
        return (LayoutInflater) this.f572b.getSystemService("layout_inflater");
    }

    public void mo125d() {
    }

    public void mo117a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f572b.startActivity(intent);
    }

    public void mo118a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        C0186a.m616a(this.f571a, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void mo119a(Fragment fragment, String[] strArr, int i) {
    }

    public boolean mo122a(String str) {
        return false;
    }

    public boolean mo126e() {
        return true;
    }

    public int mo127f() {
        return this.f573c;
    }

    public View mo91a(int i) {
        return null;
    }

    public boolean mo92a() {
        return true;
    }

    Activity m741h() {
        return this.f571a;
    }

    Context m742i() {
        return this.f572b;
    }

    Handler m743j() {
        return this.f575e;
    }

    C0234o m744k() {
        return this.f574d;
    }

    void m735b(String str) {
        if (this.f576f != null) {
            C0249u c0249u = (C0249u) this.f576f.get(str);
            if (c0249u != null && !c0249u.f690f) {
                c0249u.m974h();
                this.f576f.remove(str);
            }
        }
    }

    void mo124b(Fragment fragment) {
    }

    boolean m745l() {
        return this.f577g;
    }

    void m746m() {
        if (!this.f580j) {
            this.f580j = true;
            if (this.f578h != null) {
                this.f578h.m968b();
            } else if (!this.f579i) {
                this.f578h = m722a("(root)", this.f580j, false);
                if (!(this.f578h == null || this.f578h.f689e)) {
                    this.f578h.m968b();
                }
            }
            this.f579i = true;
        }
    }

    void m729a(boolean z) {
        this.f577g = z;
        if (this.f578h != null && this.f580j) {
            this.f580j = false;
            if (z) {
                this.f578h.m970d();
            } else {
                this.f578h.m969c();
            }
        }
    }

    void m747n() {
        if (this.f578h != null) {
            this.f578h.m974h();
        }
    }

    void m748o() {
        if (this.f576f != null) {
            int size = this.f576f.size();
            C0249u[] c0249uArr = new C0249u[size];
            for (int i = size - 1; i >= 0; i--) {
                c0249uArr[i] = (C0249u) this.f576f.m1291c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                C0249u c0249u = c0249uArr[i2];
                c0249u.m971e();
                c0249u.m973g();
            }
        }
    }

    C0249u m722a(String str, boolean z, boolean z2) {
        if (this.f576f == null) {
            this.f576f = new C0356i();
        }
        C0249u c0249u = (C0249u) this.f576f.get(str);
        if (c0249u != null) {
            c0249u.m965a(this);
            return c0249u;
        } else if (!z2) {
            return c0249u;
        } else {
            c0249u = new C0249u(str, this, z);
            this.f576f.put(str, c0249u);
            return c0249u;
        }
    }

    C0356i<String, C0245t> m749p() {
        int i;
        int i2 = 0;
        if (this.f576f != null) {
            int size = this.f576f.size();
            C0249u[] c0249uArr = new C0249u[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                c0249uArr[i3] = (C0249u) this.f576f.m1291c(i3);
            }
            boolean l = m745l();
            i = 0;
            while (i2 < size) {
                C0249u c0249u = c0249uArr[i2];
                if (!c0249u.f690f && l) {
                    if (!c0249u.f689e) {
                        c0249u.m968b();
                    }
                    c0249u.m970d();
                }
                if (c0249u.f690f) {
                    i = 1;
                } else {
                    c0249u.m974h();
                    this.f576f.remove(c0249u.f688d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.f576f;
        }
        return null;
    }

    void m727a(C0356i<String, C0245t> c0356i) {
        this.f576f = c0356i;
    }

    void m736b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f580j);
        if (this.f578h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f578h)));
            printWriter.println(":");
            this.f578h.m966a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
