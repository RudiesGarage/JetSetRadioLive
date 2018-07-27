package com.p035a.p036a.p037a;

import android.app.Activity;
import android.os.Bundle;
import com.p035a.p036a.p037a.C0938s.C0937b;
import p000a.p001a.p002a.p003a.C0135a.C0002b;

/* compiled from: AnswersLifecycleCallbacks */
class C0917d extends C0002b {
    private final C0934q f2484a;
    private final C0922g f2485b;

    public C0917d(C0934q c0934q, C0922g c0922g) {
        this.f2484a = c0934q;
        this.f2485b = c0922g;
    }

    public void mo56a(Activity activity, Bundle bundle) {
    }

    public void mo55a(Activity activity) {
        this.f2484a.m4672a(activity, C0937b.START);
    }

    public void mo57b(Activity activity) {
        this.f2484a.m4672a(activity, C0937b.RESUME);
        this.f2485b.m4634a();
    }

    public void mo710c(Activity activity) {
        this.f2484a.m4672a(activity, C0937b.PAUSE);
        this.f2485b.m4637b();
    }

    public void mo711d(Activity activity) {
        this.f2484a.m4672a(activity, C0937b.STOP);
    }

    public void mo709b(Activity activity, Bundle bundle) {
    }

    public void mo712e(Activity activity) {
    }
}
