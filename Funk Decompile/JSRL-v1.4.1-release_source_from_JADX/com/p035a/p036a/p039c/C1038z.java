package com.p035a.p036a.p039c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0009h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;

/* compiled from: ReportUploader */
class C1038z {
    static final Map<String, String> f2802a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    private static final FilenameFilter f2803b = new C10361();
    private static final short[] f2804c = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    private final Object f2805d = new Object();
    private final C1007n f2806e;
    private Thread f2807f;

    /* compiled from: ReportUploader */
    static class C10361 implements FilenameFilter {
        C10361() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".cls") && !str.contains("Session");
        }
    }

    /* compiled from: ReportUploader */
    private class C1037a extends C0009h {
        final /* synthetic */ C1038z f2800a;
        private final float f2801b;

        C1037a(C1038z c1038z, float f) {
            this.f2800a = c1038z;
            this.f2801b = f;
        }

        public void mo4a() {
            try {
                m5049b();
            } catch (Throwable e) {
                C0142c.m468h().mo54e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            this.f2800a.f2807f = null;
        }

        private void m5049b() {
            C0142c.m468h().mo46a("CrashlyticsCore", "Starting report processing in " + this.f2801b + " second(s)...");
            if (this.f2801b > 0.0f) {
                try {
                    Thread.sleep((long) (this.f2801b * 1000.0f));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            C0985f e2 = C0985f.m4866e();
            C1005l o = e2.m4885o();
            List<C0964y> a = this.f2800a.m5053a();
            if (!o.m4962a()) {
                if (a.isEmpty() || e2.m4896z()) {
                    List list = a;
                    int i = 0;
                    while (!r0.isEmpty() && !C0985f.m4866e().m4885o().m4962a()) {
                        C0142c.m468h().mo46a("CrashlyticsCore", "Attempting to send " + r0.size() + " report(s)");
                        for (C0964y a2 : r0) {
                            this.f2800a.m5055a(a2);
                        }
                        List a3 = this.f2800a.m5053a();
                        if (a3.isEmpty()) {
                            list = a3;
                        } else {
                            int i2 = i + 1;
                            long j = (long) C1038z.f2804c[Math.min(i, C1038z.f2804c.length - 1)];
                            C0142c.m468h().mo46a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                                list = a3;
                            } catch (InterruptedException e3) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                C0142c.m468h().mo46a("CrashlyticsCore", "User declined to send. Removing " + a.size() + " Report(s).");
                for (C0964y a22 : a) {
                    a22.mo729a();
                }
            }
        }
    }

    public C1038z(C1007n c1007n) {
        if (c1007n == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f2806e = c1007n;
    }

    public synchronized void m5054a(float f) {
        if (this.f2807f == null) {
            this.f2807f = new Thread(new C1037a(this, f), "Crashlytics Report Uploader");
            this.f2807f.start();
        }
    }

    boolean m5055a(C0964y c0964y) {
        boolean z = false;
        synchronized (this.f2805d) {
            try {
                boolean a = this.f2806e.mo740a(new C1006m(new C0018g().m46a(C0985f.m4866e().m496E()), c0964y));
                C0142c.m468h().mo50c("CrashlyticsCore", "Crashlytics report upload " + (a ? "complete: " : "FAILED: ") + c0964y.mo730b());
                if (a) {
                    c0964y.mo729a();
                    z = true;
                }
            } catch (Throwable e) {
                C0142c.m468h().mo54e("CrashlyticsCore", "Error occurred sending report " + c0964y, e);
            }
        }
        return z;
    }

    List<C0964y> m5053a() {
        C0142c.m468h().mo46a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f2805d) {
            File[] listFiles = C0985f.m4866e().m4893w().listFiles(f2803b);
        }
        List<C0964y> linkedList = new LinkedList();
        for (File file : listFiles) {
            C0142c.m468h().mo46a("CrashlyticsCore", "Found crash report " + file.getPath());
            linkedList.add(new ab(file));
        }
        if (linkedList.isEmpty()) {
            C0142c.m468h().mo46a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }
}
