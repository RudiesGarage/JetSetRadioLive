package com.p035a.p036a.p037a;

import android.annotation.SuppressLint;
import android.content.Context;
import p000a.p001a.p002a.p003a.p004a.p011f.C0105c;
import p000a.p001a.p002a.p003a.p004a.p011f.C0106d;

/* compiled from: AnswersPreferenceManager */
class C0918e {
    private final C0105c f2486a;

    public static C0918e m4626a(Context context) {
        return new C0918e(new C0106d(context, "settings"));
    }

    C0918e(C0105c c0105c) {
        this.f2486a = c0105c;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void m4627a() {
        this.f2486a.mo36a(this.f2486a.mo37b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean m4628b() {
        return this.f2486a.mo35a().getBoolean("analytics_launched", false);
    }
}
