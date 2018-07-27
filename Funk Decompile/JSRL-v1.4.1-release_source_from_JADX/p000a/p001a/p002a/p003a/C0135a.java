package p000a.p001a.p002a.p003a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ActivityLifecycleManager */
public class C0135a {
    private final Application f307a;
    private C0001a f308b;

    /* compiled from: ActivityLifecycleManager */
    private static class C0001a {
        private final Set<ActivityLifecycleCallbacks> f2a = new HashSet();
        private final Application f3b;

        C0001a(Application application) {
            this.f3b = application;
        }

        @TargetApi(14)
        private void m0a() {
            for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f2a) {
                this.f3b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        @TargetApi(14)
        private boolean m3a(final C0002b c0002b) {
            if (this.f3b == null) {
                return false;
            }
            ActivityLifecycleCallbacks c00001 = new ActivityLifecycleCallbacks(this) {
                final /* synthetic */ C0001a f1b;

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    c0002b.mo56a(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    c0002b.mo55a(activity);
                }

                public void onActivityResumed(Activity activity) {
                    c0002b.mo57b(activity);
                }

                public void onActivityPaused(Activity activity) {
                    c0002b.mo710c(activity);
                }

                public void onActivityStopped(Activity activity) {
                    c0002b.mo711d(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    c0002b.mo709b(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    c0002b.mo712e(activity);
                }
            };
            this.f3b.registerActivityLifecycleCallbacks(c00001);
            this.f2a.add(c00001);
            return true;
        }
    }

    /* compiled from: ActivityLifecycleManager */
    public static abstract class C0002b {
        public void mo56a(Activity activity, Bundle bundle) {
        }

        public void mo55a(Activity activity) {
        }

        public void mo57b(Activity activity) {
        }

        public void mo710c(Activity activity) {
        }

        public void mo711d(Activity activity) {
        }

        public void mo709b(Activity activity, Bundle bundle) {
        }

        public void mo712e(Activity activity) {
        }
    }

    public C0135a(Context context) {
        this.f307a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f308b = new C0001a(this.f307a);
        }
    }

    public boolean m425a(C0002b c0002b) {
        return this.f308b != null && this.f308b.m3a(c0002b);
    }

    public void m424a() {
        if (this.f308b != null) {
            this.f308b.m0a();
        }
    }
}
