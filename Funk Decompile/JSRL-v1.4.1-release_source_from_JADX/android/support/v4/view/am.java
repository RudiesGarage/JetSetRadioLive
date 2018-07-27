package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* compiled from: ViewConfigurationCompat */
public final class am {
    static final C0533d f1114a;

    /* compiled from: ViewConfigurationCompat */
    interface C0533d {
        boolean mo403a(ViewConfiguration viewConfiguration);
    }

    /* compiled from: ViewConfigurationCompat */
    static class C0534a implements C0533d {
        C0534a() {
        }

        public boolean mo403a(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    /* compiled from: ViewConfigurationCompat */
    static class C0535b extends C0534a {
        C0535b() {
        }

        public boolean mo403a(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    /* compiled from: ViewConfigurationCompat */
    static class C0536c extends C0535b {
        C0536c() {
        }

        public boolean mo403a(ViewConfiguration viewConfiguration) {
            return an.m2301a(viewConfiguration);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f1114a = new C0536c();
        } else if (VERSION.SDK_INT >= 11) {
            f1114a = new C0535b();
        } else {
            f1114a = new C0534a();
        }
    }

    @Deprecated
    public static int m2299a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static boolean m2300b(ViewConfiguration viewConfiguration) {
        return f1114a.mo403a(viewConfiguration);
    }
}
