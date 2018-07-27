package android.support.v4.p018b.p019a;

import android.content.res.Resources;
import android.os.Build.VERSION;

/* compiled from: ConfigurationHelper */
public final class C0278a {
    private static final C0274a f760a;

    /* compiled from: ConfigurationHelper */
    private interface C0274a {
        int mo167a(Resources resources);

        int mo168b(Resources resources);

        int mo169c(Resources resources);
    }

    /* compiled from: ConfigurationHelper */
    private static class C0275b implements C0274a {
        C0275b() {
        }

        public int mo167a(Resources resources) {
            return C0279b.m1055a(resources);
        }

        public int mo168b(Resources resources) {
            return C0279b.m1056b(resources);
        }

        public int mo169c(Resources resources) {
            return C0279b.m1057c(resources);
        }
    }

    /* compiled from: ConfigurationHelper */
    private static class C0276c extends C0275b {
        C0276c() {
        }

        public int mo167a(Resources resources) {
            return C0280c.m1058a(resources);
        }

        public int mo168b(Resources resources) {
            return C0280c.m1059b(resources);
        }

        public int mo169c(Resources resources) {
            return C0280c.m1060c(resources);
        }
    }

    /* compiled from: ConfigurationHelper */
    private static class C0277d extends C0276c {
        C0277d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f760a = new C0277d();
        } else if (i >= 13) {
            f760a = new C0276c();
        } else {
            f760a = new C0275b();
        }
    }

    public static int m1052a(Resources resources) {
        return f760a.mo167a(resources);
    }

    public static int m1053b(Resources resources) {
        return f760a.mo168b(resources);
    }

    public static int m1054c(Resources resources) {
        return f760a.mo169c(resources);
    }
}
