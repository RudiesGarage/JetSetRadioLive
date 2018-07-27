package com.p035a.p036a.p037a;

import java.io.File;
import java.util.List;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0007a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0041r;
import p000a.p001a.p002a.p003a.p004a.p009d.C0082f;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098d;

/* compiled from: SessionAnalyticsFilesSender */
class C0933p extends C0007a implements C0082f {
    private final String f2516b;

    public C0933p(C0149i c0149i, String str, String str2, C0088e c0088e, String str3) {
        super(c0149i, str, str2, c0088e, C0090c.POST);
        this.f2516b = str3;
    }

    public boolean mo713a(List<File> list) {
        C0098d a = m22b().m316a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m316a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo64a()).m316a("X-CRASHLYTICS-API-KEY", this.f2516b);
        int i = 0;
        for (File file : list) {
            a.m319a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        C0142c.m468h().mo46a("Answers", "Sending " + list.size() + " analytics files to " + m21a());
        int b = a.m326b();
        C0142c.m468h().mo46a("Answers", "Response code for analytics file send is " + b);
        if (C0041r.m156a(b) == 0) {
            return true;
        }
        return false;
    }
}
