package android.support.v4.p017a;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: AnimatorCompatHelper */
public final class C0172a {
    private static final C0173b f451a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f451a = new C0175d();
        } else {
            f451a = new C0174c();
        }
    }

    public static void m594a(View view) {
        f451a.mo90a(view);
    }
}
