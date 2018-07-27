package com.p035a.p036a.p038b;

import android.annotation.TargetApi;
import android.app.Activity;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.p003a.C0135a;
import p000a.p001a.p002a.p003a.C0135a.C0002b;

@TargetApi(14)
/* compiled from: ActivityLifecycleCheckForUpdatesController */
class C0947b extends C0944a {
    private final C0002b f2581a = new C09461(this);
    private final ExecutorService f2582b;

    /* compiled from: ActivityLifecycleCheckForUpdatesController */
    class C09461 extends C0002b {
        final /* synthetic */ C0947b f2580a;

        /* compiled from: ActivityLifecycleCheckForUpdatesController */
        class C09451 implements Runnable {
            final /* synthetic */ C09461 f2579a;

            C09451(C09461 c09461) {
                this.f2579a = c09461;
            }

            public void run() {
                this.f2579a.f2580a.m4705c();
            }
        }

        C09461(C0947b c0947b) {
            this.f2580a = c0947b;
        }

        public void mo55a(Activity activity) {
            if (this.f2580a.m4703a()) {
                this.f2580a.f2582b.submit(new C09451(this));
            }
        }
    }

    public C0947b(C0135a c0135a, ExecutorService executorService) {
        this.f2582b = executorService;
        c0135a.m425a(this.f2581a);
    }
}
