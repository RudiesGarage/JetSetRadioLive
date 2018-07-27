package android.support.v4.p018b;

import android.support.v4.p024g.C0359c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader */
public class C0287e<D> {
    int f761a;
    C0247b<D> f762b;
    C0246a<D> f763c;
    boolean f764d;
    boolean f765e;
    boolean f766f;
    boolean f767g;
    boolean f768h;

    /* compiled from: Loader */
    public interface C0246a<D> {
    }

    /* compiled from: Loader */
    public interface C0247b<D> {
    }

    public void m1074a(int i, C0247b<D> c0247b) {
        if (this.f762b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f762b = c0247b;
        this.f761a = i;
    }

    public void m1076a(C0247b<D> c0247b) {
        if (this.f762b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f762b != c0247b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f762b = null;
        }
    }

    public void m1075a(C0246a<D> c0246a) {
        if (this.f763c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f763c = c0246a;
    }

    public void m1079b(C0246a<D> c0246a) {
        if (this.f763c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f763c != c0246a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f763c = null;
        }
    }

    public final void m1073a() {
        this.f764d = true;
        this.f766f = false;
        this.f765e = false;
        m1078b();
    }

    protected void m1078b() {
    }

    public void m1080c() {
        this.f764d = false;
        m1081d();
    }

    protected void m1081d() {
    }

    public void m1082e() {
        m1083f();
        this.f766f = true;
        this.f764d = false;
        this.f765e = false;
        this.f767g = false;
        this.f768h = false;
    }

    protected void m1083f() {
    }

    public String m1072a(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0359c.m1301a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0359c.m1301a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f761a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m1077a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f761a);
        printWriter.print(" mListener=");
        printWriter.println(this.f762b);
        if (this.f764d || this.f767g || this.f768h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f764d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f767g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f768h);
        }
        if (this.f765e || this.f766f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f765e);
            printWriter.print(" mReset=");
            printWriter.println(this.f766f);
        }
    }
}
