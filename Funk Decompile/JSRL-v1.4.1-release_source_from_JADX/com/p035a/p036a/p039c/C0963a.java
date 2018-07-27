package com.p035a.p036a.p039c;

import android.util.Log;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;

/* compiled from: BuildIdValidator */
class C0963a {
    private final String f2628a;
    private final boolean f2629b;

    public C0963a(String str, boolean z) {
        this.f2628a = str;
        this.f2629b = z;
    }

    public void m4732a(String str, String str2) {
        if (C0021i.m83c(this.f2628a) && this.f2629b) {
            String b = m4733b(str, str2);
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".     |  | ");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".   \\ |  | /");
            Log.e("CrashlyticsCore", ".    \\    /");
            Log.e("CrashlyticsCore", ".     \\  /");
            Log.e("CrashlyticsCore", ".      \\/");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", b);
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".      /\\");
            Log.e("CrashlyticsCore", ".     /  \\");
            Log.e("CrashlyticsCore", ".    /    \\");
            Log.e("CrashlyticsCore", ".   / |  | \\");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".");
            throw new C0990j(b);
        } else if (!this.f2629b) {
            C0142c.m468h().mo46a("CrashlyticsCore", "Configured not to require a build ID.");
        }
    }

    protected String m4733b(String str, String str2) {
        return "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    }
}
