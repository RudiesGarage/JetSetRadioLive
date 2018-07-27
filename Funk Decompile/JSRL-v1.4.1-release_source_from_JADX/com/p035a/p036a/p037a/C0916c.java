package com.p035a.p036a.p037a;

import android.content.Context;
import android.os.Looper;
import p000a.p001a.p002a.p003a.p004a.p006b.C0042s;
import p000a.p001a.p002a.p003a.p004a.p009d.C0084g;
import p000a.p001a.p002a.p003a.p004a.p011f.C0103a;

/* compiled from: AnswersFilesManagerProvider */
class C0916c {
    final Context f2482a;
    final C0103a f2483b;

    public C0916c(Context context, C0103a c0103a) {
        this.f2482a = context;
        this.f2483b = c0103a;
    }

    public C0932o m4618a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new C0932o(this.f2482a, new C0940u(), new C0042s(), new C0084g(this.f2482a, this.f2483b.mo34a(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
