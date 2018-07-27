package com.p035a.p036a.p037a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.io.File;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0022j.C0023a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0022j.C0024b;
import p000a.p001a.p002a.p003a.p004a.p012g.C0129q;
import p000a.p001a.p002a.p003a.p004a.p012g.C0131t;

/* compiled from: Answers */
public class C0908a extends C0149i<Boolean> {
    C0934q f2464a;

    protected /* synthetic */ Object mo67f() {
        return m4599d();
    }

    public void m4597a(C0024b c0024b) {
        if (this.f2464a != null) {
            this.f2464a.m4673a(c0024b.m95a());
        }
    }

    public void m4596a(C0023a c0023a) {
        if (this.f2464a != null) {
            this.f2464a.m4674a(c0023a.m95a(), c0023a.m96b());
        }
    }

    @SuppressLint({"NewApi"})
    protected boolean a_() {
        try {
            long j;
            Context E = m496E();
            PackageManager packageManager = E.getPackageManager();
            String packageName = E.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                j = packageInfo.firstInstallTime;
            } else {
                j = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f2464a = C0934q.m4669a(this, E, m495D(), num, str, j);
            this.f2464a.m4676b();
            return true;
        } catch (Throwable e) {
            C0142c.m468h().mo54e("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    protected Boolean m4599d() {
        try {
            C0131t b = C0129q.m415a().m419b();
            if (b == null) {
                C0142c.m468h().mo53e("Answers", "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (b.f288d.f258d) {
                C0142c.m468h().mo46a("Answers", "Analytics collection enabled");
                this.f2464a.m4671a(b.f289e, m4600e());
                return Boolean.valueOf(true);
            } else {
                C0142c.m468h().mo46a("Answers", "Analytics collection disabled");
                this.f2464a.m4678c();
                return Boolean.valueOf(false);
            }
        } catch (Throwable e) {
            C0142c.m468h().mo54e("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    public String mo66b() {
        return "com.crashlytics.sdk.android:answers";
    }

    public String mo64a() {
        return "1.3.8.127";
    }

    String m4600e() {
        return C0021i.m78b(m496E(), "com.crashlytics.ApiEndpoint");
    }
}
