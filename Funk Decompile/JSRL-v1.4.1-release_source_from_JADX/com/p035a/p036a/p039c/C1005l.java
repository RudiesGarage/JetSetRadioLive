package com.p035a.p036a.p039c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.p035a.p036a.p039c.C1005l;
import com.p035a.p036a.p039c.p040a.p041a.C0958d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0026l;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o;
import p000a.p001a.p002a.p003a.p004a.p011f.C0103a;
import p000a.p001a.p002a.p003a.p004a.p012g.C0125p;
import p000a.p001a.p002a.p003a.p004a.p012g.C0129q;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class C1005l implements UncaughtExceptionHandler {
    static final FilenameFilter f2721a = new C09921();
    static final Comparator<File> f2722b = new C09976();
    static final Comparator<File> f2723c = new C09987();
    static final FilenameFilter f2724d = new C09998();
    private static final Pattern f2725e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> f2726f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] f2727g = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final AtomicInteger f2728h = new AtomicInteger(0);
    private final UncaughtExceptionHandler f2729i;
    private final C0103a f2730j;
    private final AtomicBoolean f2731k;
    private final C0988g f2732l;
    private final C0033o f2733m;
    private final C0985f f2734n;
    private final C1016s f2735o;
    private final C1011p f2736p;
    private final String f2737q;

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    static class C09921 implements FilenameFilter {
        C09921() {
        }

        public boolean accept(File file, String str) {
            return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    class C09932 implements Callable<Void> {
        final /* synthetic */ C1005l f2708a;

        C09932(C1005l c1005l) {
            this.f2708a = c1005l;
        }

        public /* synthetic */ Object call() {
            return m4909a();
        }

        public Void m4909a() {
            this.f2708a.m4954l();
            return null;
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    class C09943 implements Callable<Boolean> {
        final /* synthetic */ C1005l f2709a;

        C09943(C1005l c1005l) {
            this.f2709a = c1005l;
        }

        public /* synthetic */ Object call() {
            return m4910a();
        }

        public Boolean m4910a() {
            if (this.f2709a.f2731k.get()) {
                C0142c.m468h().mo46a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                return Boolean.FALSE;
            }
            C0142c.m468h().mo46a("CrashlyticsCore", "Finalizing previously open sessions.");
            C0958d v = this.f2709a.f2734n.m4892v();
            if (v != null) {
                this.f2709a.m4917a(v);
            }
            this.f2709a.m4933a(true);
            C0142c.m468h().mo46a("CrashlyticsCore", "Closed all previously open sessions");
            return Boolean.TRUE;
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    class C09954 implements Runnable {
        final /* synthetic */ C1005l f2710a;

        C09954(C1005l c1005l) {
            this.f2710a = c1005l;
        }

        public void run() {
            this.f2710a.m4961a(this.f2710a.m4936a(C0968d.f2647a));
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    static class C09976 implements Comparator<File> {
        C09976() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4911a((File) obj, (File) obj2);
        }

        public int m4911a(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    static class C09987 implements Comparator<File> {
        C09987() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4912a((File) obj, (File) obj2);
        }

        public int m4912a(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    static class C09998 implements FilenameFilter {
        C09998() {
        }

        public boolean accept(File file, String str) {
            return C1005l.f2725e.matcher(str).matches();
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    private static class C1001a implements FilenameFilter {
        private C1001a() {
        }

        public boolean accept(File file, String str) {
            return !C1005l.f2721a.accept(file, str) && C1005l.f2725e.matcher(str).matches();
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    static class C1002b implements FilenameFilter {
        private final String f2717a;

        public C1002b(String str) {
            this.f2717a = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.f2717a) && !str.endsWith(".cls_temp");
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    private static final class C1003c implements Runnable {
        private final C0985f f2718a;
        private final File f2719b;

        public C1003c(C0985f c0985f, File file) {
            this.f2718a = c0985f;
            this.f2719b = file;
        }

        public void run() {
            if (C0021i.m94n(this.f2718a.m496E())) {
                C0142c.m468h().mo46a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                C1007n a = this.f2718a.m4869a(C0129q.m415a().m419b());
                if (a != null) {
                    new C1038z(a).m5055a(new ab(this.f2719b, C1005l.f2726f));
                }
            }
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    static class C1004d implements FilenameFilter {
        private final String f2720a;

        public C1004d(String str) {
            this.f2720a = str;
        }

        public boolean accept(File file, String str) {
            if (str.equals(this.f2720a + ".cls") || !str.contains(this.f2720a) || str.endsWith(".cls_temp")) {
                return false;
            }
            return true;
        }
    }

    C1005l(UncaughtExceptionHandler uncaughtExceptionHandler, C0988g c0988g, C0033o c0033o, ac acVar, C0103a c0103a, C0985f c0985f) {
        this.f2729i = uncaughtExceptionHandler;
        this.f2732l = c0988g;
        this.f2733m = c0033o;
        this.f2734n = c0985f;
        this.f2737q = acVar.mo744a();
        this.f2730j = c0103a;
        this.f2731k = new AtomicBoolean(false);
        Context E = c0985f.m496E();
        this.f2735o = new C1016s(E, c0103a);
        this.f2736p = new C1011p(E);
    }

    public synchronized void uncaughtException(final Thread thread, final Throwable th) {
        this.f2731k.set(true);
        try {
            C0142c.m468h().mo46a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            this.f2736p.m4975b();
            final Date date = new Date();
            this.f2732l.m4897a(new Callable<Void>(this) {
                final /* synthetic */ C1005l f2716d;

                public /* synthetic */ Object call() {
                    return m4913a();
                }

                public Void m4913a() {
                    this.f2716d.m4932a(date, thread, th);
                    return null;
                }
            });
            C0142c.m468h().mo46a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f2729i.uncaughtException(thread, th);
            this.f2731k.set(false);
        } catch (Throwable e) {
            C0142c.m468h().mo54e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
            C0142c.m468h().mo46a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f2729i.uncaughtException(thread, th);
            this.f2731k.set(false);
        } catch (Throwable th2) {
            C0142c.m468h().mo46a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f2729i.uncaughtException(thread, th);
            this.f2731k.set(false);
        }
    }

    private void m4932a(Date date, Thread thread, Throwable th) {
        this.f2734n.m4867A();
        m4940b(date, thread, th);
        m4965d();
        m4954l();
        m4967f();
        if (!this.f2734n.m4894x()) {
            m4958p();
        }
    }

    boolean m4962a() {
        return this.f2731k.get();
    }

    void m4960a(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.f2732l.m4898a(new Runnable(this) {
            final /* synthetic */ C1005l f2707d;

            public void run() {
                if (!this.f2707d.f2731k.get()) {
                    this.f2707d.m4945c(date, thread, th);
                }
            }
        });
    }

    void m4963b() {
        this.f2732l.m4899b(new C09932(this));
    }

    private String m4952j() {
        File[] n = m4956n();
        return n.length > 0 ? m4914a(n[0]) : null;
    }

    private String m4953k() {
        File[] n = m4956n();
        return n.length > 1 ? m4914a(n[1]) : null;
    }

    private String m4914a(File file) {
        return file.getName().substring(0, 35);
    }

    boolean m4964c() {
        return ((Boolean) this.f2732l.m4897a(new C09943(this))).booleanValue();
    }

    private void m4954l() {
        Date date = new Date();
        String c0966c = new C0966c(this.f2733m).toString();
        C0142c.m468h().mo46a("CrashlyticsCore", "Opening an new session with ID " + c0966c);
        m4931a(c0966c, date);
        m4944c(c0966c);
        m4946d(c0966c);
        m4947e(c0966c);
        this.f2735o.m4996a(c0966c);
    }

    void m4965d() {
        m4933a(false);
    }

    private void m4933a(boolean z) {
        int i = z ? 1 : 0;
        m4916a(i + 8);
        File[] n = m4956n();
        if (n.length <= i) {
            C0142c.m468h().mo46a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        m4948f(m4914a(n[i]));
        C0985f c0985f = this.f2734n;
        C0125p B = C0985f.m4852B();
        if (B == null) {
            C0142c.m468h().mo46a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
        } else {
            m4934a(n, i, B.f272c);
        }
    }

    private void m4934a(File[] fileArr, int i, int i2) {
        C0142c.m468h().mo46a("CrashlyticsCore", "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String a = m4914a(file);
            C0142c.m468h().mo46a("CrashlyticsCore", "Closing session: " + a);
            m4926a(file, a, i2);
            i++;
        }
    }

    private void m4918a(C0968d c0968d) {
        if (c0968d != null) {
            try {
                c0968d.m4789a();
            } catch (Throwable e) {
                C0142c.m468h().mo54e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    private void m4929a(String str) {
        for (File delete : m4941b(str)) {
            delete.delete();
        }
    }

    private File[] m4941b(String str) {
        return m4936a(new C1004d(str));
    }

    private File[] m4955m() {
        return m4936a(f2721a);
    }

    File[] m4966e() {
        return m4936a(new C1002b("BeginSession"));
    }

    private File[] m4956n() {
        File[] e = m4966e();
        Arrays.sort(e, f2722b);
        return e;
    }

    private File[] m4936a(FilenameFilter filenameFilter) {
        return m4942b(m4959q().listFiles(filenameFilter));
    }

    private File[] m4942b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void m4930a(String str, int i) {
        ae.m4777a(m4959q(), new C1002b(str + "SessionEvent"), i, f2723c);
    }

    void m4967f() {
        ae.m4777a(m4959q(), f2721a, 4, f2723c);
    }

    private void m4916a(int i) {
        int i2 = 0;
        Set hashSet = new HashSet();
        File[] n = m4956n();
        int min = Math.min(i, n.length);
        for (int i3 = 0; i3 < min; i3++) {
            hashSet.add(m4914a(n[i3]));
        }
        this.f2735o.m4997a(hashSet);
        File[] a = m4936a(new C1001a());
        int length = a.length;
        while (i2 < length) {
            File file = a[i2];
            Object name = file.getName();
            Matcher matcher = f2725e.matcher(name);
            matcher.matches();
            if (!hashSet.contains(matcher.group(1))) {
                C0142c.m468h().mo46a("CrashlyticsCore", "Trimming open session file: " + name);
                file.delete();
            }
            i2++;
        }
    }

    private File[] m4937a(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        C0142c.m468h().mo46a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
        m4930a(str, i);
        return m4936a(new C1002b(str + "SessionEvent"));
    }

    void m4968g() {
        this.f2732l.m4898a(new C09954(this));
    }

    void m4961a(File[] fileArr) {
        m4957o();
        for (File file : fileArr) {
            C0142c.m468h().mo46a("CrashlyticsCore", "Found invalid session part file: " + file);
            final String a = m4914a(file);
            FilenameFilter c09965 = new FilenameFilter(this) {
                final /* synthetic */ C1005l f2712b;

                public boolean accept(File file, String str) {
                    return str.startsWith(a);
                }
            };
            C0142c.m468h().mo46a("CrashlyticsCore", "Deleting all part files for invalid session: " + a);
            for (File file2 : m4936a(c09965)) {
                C0142c.m468h().mo46a("CrashlyticsCore", "Deleting session file: " + file2);
                file2.delete();
            }
        }
    }

    private void m4957o() {
        File file = new File(this.f2734n.m4893w(), "invalidClsFiles");
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
            file.delete();
        }
    }

    private void m4940b(Date date, Thread thread, Throwable th) {
        Throwable e;
        Closeable closeable;
        Flushable flushable = null;
        try {
            String j = m4952j();
            if (j == null) {
                C0142c.m468h().mo54e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                C0021i.m72a(null, "Failed to flush to session begin file.");
                C0021i.m71a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            C0985f.m4864b(j, th.getClass().getName());
            Closeable c0968d = new C0968d(m4959q(), j + "SessionCrash");
            try {
                flushable = C0970e.m4790a((OutputStream) c0968d);
                m4921a(flushable, date, thread, th, "crash", true);
                C0021i.m72a(flushable, "Failed to flush to session begin file.");
                C0021i.m71a(c0968d, "Failed to close fatal exception file output stream.");
            } catch (Exception e2) {
                e = e2;
                closeable = c0968d;
                try {
                    C0142c.m468h().mo54e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                    C0021i.m72a(flushable, "Failed to flush to session begin file.");
                    C0021i.m71a(closeable, "Failed to close fatal exception file output stream.");
                } catch (Throwable th2) {
                    e = th2;
                    C0021i.m72a(flushable, "Failed to flush to session begin file.");
                    C0021i.m71a(closeable, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                closeable = c0968d;
                C0021i.m72a(flushable, "Failed to flush to session begin file.");
                C0021i.m71a(closeable, "Failed to close fatal exception file output stream.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            closeable = null;
            C0142c.m468h().mo54e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            C0021i.m72a(flushable, "Failed to flush to session begin file.");
            C0021i.m71a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            e = th4;
            closeable = null;
            C0021i.m72a(flushable, "Failed to flush to session begin file.");
            C0021i.m71a(closeable, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void m4917a(C0958d c0958d) {
        Throwable e;
        Flushable flushable = null;
        Closeable c0968d;
        try {
            String k = m4953k();
            if (k == null) {
                C0142c.m468h().mo54e("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
                C0021i.m72a(null, "Failed to flush to session begin file.");
                C0021i.m71a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            C0985f.m4864b(k, String.format(Locale.US, "<native-crash [%s (%s)]>", new Object[]{c0958d.f2612b.f2618b, c0958d.f2612b.f2617a}));
            c0968d = new C0968d(m4959q(), k + "SessionCrash");
            try {
                flushable = C0970e.m4790a((OutputStream) c0968d);
                C1032v.m5038a(c0958d, new C1016s(this.f2734n.m496E(), this.f2730j, k), new C1018u(m4959q()).m5006b(k), flushable);
                C0021i.m72a(flushable, "Failed to flush to session begin file.");
                C0021i.m71a(c0968d, "Failed to close fatal exception file output stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C0142c.m468h().mo54e("CrashlyticsCore", "An error occurred in the native crash logger", e);
                    C0021i.m72a(flushable, "Failed to flush to session begin file.");
                    C0021i.m71a(c0968d, "Failed to close fatal exception file output stream.");
                } catch (Throwable th) {
                    e = th;
                    C0021i.m72a(flushable, "Failed to flush to session begin file.");
                    C0021i.m71a(c0968d, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            c0968d = null;
            C0142c.m468h().mo54e("CrashlyticsCore", "An error occurred in the native crash logger", e);
            C0021i.m72a(flushable, "Failed to flush to session begin file.");
            C0021i.m71a(c0968d, "Failed to close fatal exception file output stream.");
        } catch (Throwable th2) {
            e = th2;
            c0968d = null;
            C0021i.m72a(flushable, "Failed to flush to session begin file.");
            C0021i.m71a(c0968d, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void m4945c(Date date, Thread thread, Throwable th) {
        Throwable e;
        Closeable closeable;
        Flushable flushable = null;
        String j = m4952j();
        if (j == null) {
            C0142c.m468h().mo54e("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        C0985f.m4859a(j, th.getClass().getName());
        try {
            C0142c.m468h().mo46a("CrashlyticsCore", "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
            Closeable c0968d = new C0968d(m4959q(), j + "SessionEvent" + C0021i.m58a(this.f2728h.getAndIncrement()));
            try {
                flushable = C0970e.m4790a((OutputStream) c0968d);
                m4921a(flushable, date, thread, th, "error", false);
                C0021i.m72a(flushable, "Failed to flush to non-fatal file.");
                C0021i.m71a(c0968d, "Failed to close non-fatal file output stream.");
            } catch (Exception e2) {
                e = e2;
                closeable = c0968d;
                try {
                    C0142c.m468h().mo54e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                    C0021i.m72a(flushable, "Failed to flush to non-fatal file.");
                    C0021i.m71a(closeable, "Failed to close non-fatal file output stream.");
                    m4930a(j, 64);
                } catch (Throwable th2) {
                    e = th2;
                    C0021i.m72a(flushable, "Failed to flush to non-fatal file.");
                    C0021i.m71a(closeable, "Failed to close non-fatal file output stream.");
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                closeable = c0968d;
                C0021i.m72a(flushable, "Failed to flush to non-fatal file.");
                C0021i.m71a(closeable, "Failed to close non-fatal file output stream.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            closeable = null;
            C0142c.m468h().mo54e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
            C0021i.m72a(flushable, "Failed to flush to non-fatal file.");
            C0021i.m71a(closeable, "Failed to close non-fatal file output stream.");
            m4930a(j, 64);
        } catch (Throwable th4) {
            e = th4;
            closeable = null;
            C0021i.m72a(flushable, "Failed to flush to non-fatal file.");
            C0021i.m71a(closeable, "Failed to close non-fatal file output stream.");
            throw e;
        }
        try {
            m4930a(j, 64);
        } catch (Throwable e4) {
            C0142c.m468h().mo54e("CrashlyticsCore", "An error occurred when trimming non-fatal files.", e4);
        }
    }

    private void m4931a(String str, Date date) {
        Closeable c0968d;
        Throwable th;
        Flushable flushable = null;
        try {
            c0968d = new C0968d(m4959q(), str + "BeginSession");
            try {
                flushable = C0970e.m4790a((OutputStream) c0968d);
                aa.m4755a((C0970e) flushable, str, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.f2734n.mo64a()}), date.getTime() / 1000);
                C0021i.m72a(flushable, "Failed to flush to session begin file.");
                C0021i.m71a(c0968d, "Failed to close begin session file.");
            } catch (Throwable th2) {
                th = th2;
                C0021i.m72a(flushable, "Failed to flush to session begin file.");
                C0021i.m71a(c0968d, "Failed to close begin session file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c0968d = null;
            C0021i.m72a(flushable, "Failed to flush to session begin file.");
            C0021i.m71a(c0968d, "Failed to close begin session file.");
            throw th;
        }
    }

    private void m4944c(String str) {
        Closeable closeable;
        Throwable th;
        Flushable flushable = null;
        try {
            Closeable c0968d = new C0968d(m4959q(), str + "SessionApp");
            try {
                Flushable a = C0970e.m4790a((OutputStream) c0968d);
                try {
                    aa.m4757a((C0970e) a, this.f2733m.m114c(), this.f2734n.m4879i(), this.f2734n.m4882l(), this.f2734n.m4881k(), this.f2733m.m113b(), C0026l.m98a(this.f2734n.m4880j()).m99a(), this.f2737q);
                    C0021i.m72a(a, "Failed to flush to session app file.");
                    C0021i.m71a(c0968d, "Failed to close session app file.");
                } catch (Throwable th2) {
                    closeable = c0968d;
                    Flushable flushable2 = a;
                    th = th2;
                    flushable = flushable2;
                    C0021i.m72a(flushable, "Failed to flush to session app file.");
                    C0021i.m71a(closeable, "Failed to close session app file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = c0968d;
                C0021i.m72a(flushable, "Failed to flush to session app file.");
                C0021i.m71a(closeable, "Failed to close session app file.");
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            C0021i.m72a(flushable, "Failed to flush to session app file.");
            C0021i.m71a(closeable, "Failed to close session app file.");
            throw th;
        }
    }

    private void m4946d(String str) {
        Throwable th;
        Flushable flushable = null;
        Closeable c0968d;
        try {
            c0968d = new C0968d(m4959q(), str + "SessionOS");
            try {
                flushable = C0970e.m4790a((OutputStream) c0968d);
                aa.m4763a((C0970e) flushable, C0021i.m87g(this.f2734n.m496E()));
                C0021i.m72a(flushable, "Failed to flush to session OS file.");
                C0021i.m71a(c0968d, "Failed to close session OS file.");
            } catch (Throwable th2) {
                th = th2;
                C0021i.m72a(flushable, "Failed to flush to session OS file.");
                C0021i.m71a(c0968d, "Failed to close session OS file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c0968d = null;
            C0021i.m72a(flushable, "Failed to flush to session OS file.");
            C0021i.m71a(c0968d, "Failed to close session OS file.");
            throw th;
        }
    }

    private void m4947e(String str) {
        Throwable th;
        Closeable closeable = null;
        Flushable flushable = null;
        try {
            OutputStream c0968d = new C0968d(m4959q(), str + "SessionDevice");
            try {
                flushable = C0970e.m4790a(c0968d);
                Context E = this.f2734n.m496E();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                aa.m4754a((C0970e) flushable, this.f2733m.m119h(), C0021i.m52a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), C0021i.m75b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), C0021i.m86f(E), this.f2733m.m120i(), C0021i.m88h(E), Build.MANUFACTURER, Build.PRODUCT);
                C0021i.m72a(flushable, "Failed to flush session device info.");
                C0021i.m71a((Closeable) c0968d, "Failed to close session device file.");
            } catch (Throwable th2) {
                th = th2;
                Object obj = c0968d;
                C0021i.m72a(flushable, "Failed to flush session device info.");
                C0021i.m71a(closeable, "Failed to close session device file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            C0021i.m72a(flushable, "Failed to flush session device info.");
            C0021i.m71a(closeable, "Failed to close session device file.");
            throw th;
        }
    }

    private void m4948f(String str) {
        Throwable th;
        Flushable flushable = null;
        Closeable c0968d;
        try {
            c0968d = new C0968d(m4959q(), str + "SessionUser");
            try {
                flushable = C0970e.m4790a((OutputStream) c0968d);
                ad g = m4949g(str);
                if (g.m4776a()) {
                    C0021i.m72a(flushable, "Failed to flush session user file.");
                    C0021i.m71a(c0968d, "Failed to close session user file.");
                    return;
                }
                aa.m4756a((C0970e) flushable, g.f2635b, g.f2636c, g.f2637d);
                C0021i.m72a(flushable, "Failed to flush session user file.");
                C0021i.m71a(c0968d, "Failed to close session user file.");
            } catch (Throwable th2) {
                th = th2;
                C0021i.m72a(flushable, "Failed to flush session user file.");
                C0021i.m71a(c0968d, "Failed to close session user file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c0968d = null;
            C0021i.m72a(flushable, "Failed to flush session user file.");
            C0021i.m71a(c0968d, "Failed to close session user file.");
            throw th;
        }
    }

    private void m4921a(C0970e c0970e, Date date, Thread thread, Throwable th, String str, boolean z) {
        Thread[] threadArr;
        Map treeMap;
        Context E = this.f2734n.m496E();
        long time = date.getTime() / 1000;
        float c = C0021i.m80c(E);
        int a = C0021i.m54a(E, this.f2736p.m4974a());
        boolean d = C0021i.m84d(E);
        int i = E.getResources().getConfiguration().orientation;
        long b = C0021i.m75b() - C0021i.m76b(E);
        long b2 = C0021i.m77b(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a2 = C0021i.m56a(E.getPackageName(), E);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTrace = th.getStackTrace();
        String n = this.f2734n.m4884n();
        String c2 = this.f2733m.m114c();
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i2 = 0;
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr[i2] = (Thread) entry.getKey();
                linkedList.add(entry.getValue());
                i2++;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (C0021i.m74a(E, "com.crashlytics.CollectCustomKeys", true)) {
            Map g = this.f2734n.m4877g();
            treeMap = (g == null || g.size() <= 1) ? g : new TreeMap(g);
        } else {
            treeMap = new TreeMap();
        }
        aa.m4752a(c0970e, time, str, th, thread, stackTrace, threadArr, linkedList, treeMap, this.f2735o, a2, i, c2, n, c, a, d, b, b2);
    }

    private void m4926a(File file, String str, int i) {
        boolean z;
        C0142c.m468h().mo46a("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] a = m4936a(new C1002b(str + "SessionCrash"));
        boolean z2 = a != null && a.length > 0;
        C0142c.m468h().mo46a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z2)}));
        File[] a2 = m4936a(new C1002b(str + "SessionEvent"));
        if (a2 == null || a2.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        C0142c.m468h().mo46a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z)}));
        if (z2 || z) {
            m4927a(file, str, m4937a(str, a2, i), z2 ? a[0] : null);
        } else {
            C0142c.m468h().mo46a("CrashlyticsCore", "No events present for session ID " + str);
        }
        C0142c.m468h().mo46a("CrashlyticsCore", "Removing session part files for ID " + str);
        m4929a(str);
    }

    private void m4927a(File file, String str, File[] fileArr, File file2) {
        Throwable e;
        boolean z = true;
        if (file2 == null) {
            z = false;
        }
        Closeable c0968d;
        try {
            c0968d = new C0968d(m4959q(), str);
            try {
                Flushable a = C0970e.m4790a((OutputStream) c0968d);
                C0142c.m468h().mo46a("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                C1005l.m4919a((C0970e) a, file);
                a.m4817a(4, new Date().getTime() / 1000);
                a.m4819a(5, z);
                a.m4816a(11, 1);
                a.m4827b(12, 3);
                m4920a((C0970e) a, str);
                C1005l.m4922a((C0970e) a, fileArr, str);
                if (z) {
                    C1005l.m4919a((C0970e) a, file2);
                }
                C0021i.m72a(a, "Error flushing session file stream");
                C0021i.m71a(c0968d, "Failed to close CLS file");
            } catch (Exception e2) {
                e = e2;
                try {
                    C0142c.m468h().mo54e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                    C0021i.m72a(null, "Error flushing session file stream");
                    m4918a((C0968d) c0968d);
                } catch (Throwable th) {
                    e = th;
                    C0021i.m72a(null, "Error flushing session file stream");
                    C0021i.m71a(c0968d, "Failed to close CLS file");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            c0968d = null;
            C0142c.m468h().mo54e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
            C0021i.m72a(null, "Error flushing session file stream");
            m4918a((C0968d) c0968d);
        } catch (Throwable th2) {
            e = th2;
            c0968d = null;
            C0021i.m72a(null, "Error flushing session file stream");
            C0021i.m71a(c0968d, "Failed to close CLS file");
            throw e;
        }
    }

    private static void m4922a(C0970e c0970e, File[] fileArr, String str) {
        Arrays.sort(fileArr, C0021i.f35a);
        for (File name : fileArr) {
            try {
                C0142c.m468h().mo46a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                C1005l.m4919a(c0970e, name);
            } catch (Throwable e) {
                C0142c.m468h().mo54e("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    private void m4920a(C0970e c0970e, String str) {
        for (String str2 : f2727g) {
            File[] a = m4936a(new C1002b(str + str2));
            if (a.length == 0) {
                C0142c.m468h().mo54e("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                C0142c.m468h().mo46a("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                C1005l.m4919a(c0970e, a[0]);
            }
        }
    }

    private static void m4919a(C0970e c0970e, File file) {
        Throwable th;
        if (file.exists()) {
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    C1005l.m4928a((InputStream) fileInputStream, c0970e, (int) file.length());
                    C0021i.m71a(fileInputStream, "Failed to close file input stream.");
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    C0021i.m71a(fileInputStream, "Failed to close file input stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                C0021i.m71a(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        }
        C0142c.m468h().mo54e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
    }

    private static void m4928a(InputStream inputStream, C0970e c0970e, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = inputStream.read(bArr, i2, bArr.length - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        c0970e.m4824a(bArr);
    }

    private ad m4949g(String str) {
        return m4962a() ? new ad(this.f2734n.m4886p(), this.f2734n.m4888r(), this.f2734n.m4887q()) : new C1018u(m4959q()).m5005a(str);
    }

    private void m4958p() {
        for (File c1003c : m4955m()) {
            this.f2732l.m4898a(new C1003c(this.f2734n, c1003c));
        }
    }

    private File m4959q() {
        return this.f2730j.mo34a();
    }
}
