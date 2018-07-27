package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentManager */
public abstract class C0226n {

    /* compiled from: FragmentManager */
    public interface C0225a {
        void m815a();
    }

    public abstract SavedState mo139a(Fragment fragment);

    public abstract Fragment mo140a(Bundle bundle, String str);

    public abstract Fragment mo141a(String str);

    public abstract C0213r mo142a();

    public abstract void mo144a(int i, int i2);

    public abstract void mo145a(Bundle bundle, String str, Fragment fragment);

    public abstract void mo146a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean mo147b();

    public abstract boolean mo148c();
}
