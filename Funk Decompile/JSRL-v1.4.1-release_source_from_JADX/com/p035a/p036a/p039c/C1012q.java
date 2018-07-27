package com.p035a.p036a.p039c;

import android.content.Context;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p012g.C0124o;

/* compiled from: DialogStringResolver */
class C1012q {
    private final Context f2750a;
    private final C0124o f2751b;

    public C1012q(Context context, C0124o c0124o) {
        this.f2750a = context;
        this.f2751b = c0124o;
    }

    public String m4979a() {
        return m4976a("com.crashlytics.CrashSubmissionPromptTitle", this.f2751b.f263a);
    }

    public String m4980b() {
        return m4976a("com.crashlytics.CrashSubmissionPromptMessage", this.f2751b.f264b);
    }

    public String m4981c() {
        return m4976a("com.crashlytics.CrashSubmissionSendTitle", this.f2751b.f265c);
    }

    public String m4982d() {
        return m4976a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f2751b.f269g);
    }

    public String m4983e() {
        return m4976a("com.crashlytics.CrashSubmissionCancelTitle", this.f2751b.f267e);
    }

    private String m4976a(String str, String str2) {
        return m4978b(C0021i.m78b(this.f2750a, str), str2);
    }

    private String m4978b(String str, String str2) {
        return m4977a(str) ? str2 : str;
    }

    private boolean m4977a(String str) {
        return str == null || str.length() == 0;
    }
}
