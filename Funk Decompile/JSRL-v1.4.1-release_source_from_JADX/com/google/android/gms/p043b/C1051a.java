package com.google.android.gms.p043b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.firebase.C1257a;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class C1051a implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final C1051a f2830a = new C1051a();
    private final AtomicBoolean f2831b = new AtomicBoolean();
    private boolean f2832c;

    private C1051a() {
    }

    public static void m5079a(Application application) {
        application.registerActivityLifecycleCallbacks(f2830a);
        application.registerComponentCallbacks(f2830a);
        f2830a.f2832c = true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f2831b.compareAndSet(true, false)) {
            C1257a.m5780a(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.f2831b.compareAndSet(true, false)) {
            C1257a.m5780a(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.f2831b.compareAndSet(false, true)) {
            C1257a.m5780a(true);
        }
    }
}
