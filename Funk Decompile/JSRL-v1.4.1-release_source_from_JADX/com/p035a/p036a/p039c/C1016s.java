package com.p035a.p036a.p039c;

import android.content.Context;
import java.io.File;
import java.util.Set;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p011f.C0103a;

/* compiled from: LogFileManager */
class C1016s {
    private static final C1015a f2752a = new C1015a();
    private final Context f2753b;
    private final C0103a f2754c;
    private C1013r f2755d;

    /* compiled from: LogFileManager */
    private static final class C1015a implements C1013r {
        private C1015a() {
        }

        public C0965b mo741a() {
            return null;
        }

        public void mo742b() {
        }

        public void mo743c() {
        }
    }

    public C1016s(Context context, C0103a c0103a) {
        this(context, c0103a, null);
    }

    public C1016s(Context context, C0103a c0103a, String str) {
        this.f2753b = context;
        this.f2754c = c0103a;
        this.f2755d = f2752a;
        m4996a(str);
    }

    public final void m4996a(String str) {
        this.f2755d.mo742b();
        this.f2755d = f2752a;
        if (str != null) {
            if (m4992c()) {
                m4995a(m4991b(str), 65536);
            } else {
                C0142c.m468h().mo46a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            }
        }
    }

    public C0965b m4994a() {
        return this.f2755d.mo741a();
    }

    public void m4998b() {
        this.f2755d.mo743c();
    }

    public void m4997a(Set<String> set) {
        File[] listFiles = m4993d().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(m4990a(file))) {
                    file.delete();
                }
            }
        }
    }

    void m4995a(File file, int i) {
        this.f2755d = new C1035x(file, i);
    }

    private File m4991b(String str) {
        return new File(m4993d(), "crashlytics-userlog-" + str + ".temp");
    }

    private String m4990a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        return lastIndexOf == -1 ? name : name.substring("crashlytics-userlog-".length(), lastIndexOf);
    }

    private boolean m4992c() {
        return C0021i.m74a(this.f2753b, "com.crashlytics.CollectCustomLogs", true);
    }

    private File m4993d() {
        File file = new File(this.f2754c.mo34a(), "log-files");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
