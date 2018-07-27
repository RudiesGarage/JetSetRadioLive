package p000a.p001a.p002a.p003a.p004a.p012g;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0018g;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0026l;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o;
import p000a.p001a.p002a.p003a.p004a.p006b.C0042s;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;

/* compiled from: Settings */
public class C0129q {
    private final AtomicReference<C0131t> f277a;
    private final CountDownLatch f278b;
    private C0116s f279c;
    private boolean f280d;

    /* compiled from: Settings */
    static class C0127a {
        private static final C0129q f276a = new C0129q();
    }

    /* compiled from: Settings */
    public interface C0128b<T> {
        T mo734b(C0131t c0131t);
    }

    public static C0129q m415a() {
        return C0127a.f276a;
    }

    private C0129q() {
        this.f277a = new AtomicReference();
        this.f278b = new CountDownLatch(1);
        this.f280d = false;
    }

    public synchronized C0129q m417a(C0149i c0149i, C0033o c0033o, C0088e c0088e, String str, String str2, String str3) {
        C0129q c0129q;
        if (this.f280d) {
            c0129q = this;
        } else {
            if (this.f279c == null) {
                Context E = c0149i.m496E();
                String c = c0033o.m114c();
                String a = new C0018g().m46a(E);
                String j = c0033o.m121j();
                C0042s c0042s = new C0042s();
                C0119k c0119k = new C0119k();
                C0115i c0115i = new C0115i(c0149i);
                String k = C0021i.m91k(E);
                C0149i c0149i2 = c0149i;
                String str4 = str3;
                C0121l c0121l = new C0121l(c0149i2, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c}), c0088e);
                j = str2;
                String str5 = str;
                this.f279c = new C0117j(c0149i, new C0133w(a, c0033o.m118g(), c0033o.m117f(), c0033o.m116e(), c0033o.m124m(), c0033o.m113b(), c0033o.m125n(), C0021i.m66a(C0021i.m93m(E)), j, str5, C0026l.m98a(j).m99a(), k), c0042s, c0119k, c0115i, c0121l);
            }
            this.f280d = true;
            c0129q = this;
        }
        return c0129q;
    }

    public <T> T m418a(C0128b<T> c0128b, T t) {
        C0131t c0131t = (C0131t) this.f277a.get();
        return c0131t == null ? t : c0128b.mo734b(c0131t);
    }

    public C0131t m419b() {
        try {
            this.f278b.await();
            return (C0131t) this.f277a.get();
        } catch (InterruptedException e) {
            C0142c.m468h().mo53e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean m420c() {
        C0131t a;
        a = this.f279c.mo41a();
        m416a(a);
        return a != null;
    }

    public synchronized boolean m421d() {
        C0131t a;
        a = this.f279c.mo42a(C0130r.SKIP_CACHE_LOOKUP);
        m416a(a);
        if (a == null) {
            C0142c.m468h().mo54e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a != null;
    }

    private void m416a(C0131t c0131t) {
        this.f277a.set(c0131t);
        this.f278b.countDown();
    }
}
