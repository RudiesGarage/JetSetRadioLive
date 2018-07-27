package p000a.p001a.p002a.p003a;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o;
import p000a.p001a.p002a.p003a.p004a.p007c.C0062d;
import p000a.p001a.p002a.p003a.p004a.p007c.C0065l;

/* compiled from: Kit */
public abstract class C0149i<Result> implements Comparable<C0149i> {
    C0142c f342e;
    C0148h<Result> f343f = new C0148h(this);
    Context f344g;
    C0139f<Result> f345h;
    C0033o f346i;
    final C0062d f347j = ((C0062d) getClass().getAnnotation(C0062d.class));

    public abstract String mo64a();

    public abstract String mo66b();

    protected abstract Result mo67f();

    public /* synthetic */ int compareTo(Object obj) {
        return m501a((C0149i) obj);
    }

    void m503a(Context context, C0142c c0142c, C0139f<Result> c0139f, C0033o c0033o) {
        this.f342e = c0142c;
        this.f344g = new C0143d(context, mo66b(), m498G());
        this.f345h = c0139f;
        this.f346i = c0033o;
    }

    final void m494C() {
        this.f343f.m215a(this.f342e.m480f(), (Void) null);
    }

    protected boolean a_() {
        return true;
    }

    protected void m504a(Result result) {
    }

    protected void m506b(Result result) {
    }

    protected C0033o m495D() {
        return this.f346i;
    }

    public Context m496E() {
        return this.f344g;
    }

    public C0142c m497F() {
        return this.f342e;
    }

    public String m498G() {
        return ".Fabric" + File.separator + mo66b();
    }

    public int m501a(C0149i c0149i) {
        if (m507b(c0149i)) {
            return 1;
        }
        if (c0149i.m507b(this)) {
            return -1;
        }
        if (m499H() && !c0149i.m499H()) {
            return 1;
        }
        if (m499H() || !c0149i.m499H()) {
            return 0;
        }
        return -1;
    }

    boolean m507b(C0149i c0149i) {
        if (!m499H()) {
            return false;
        }
        for (Class isAssignableFrom : this.f347j.m195a()) {
            if (isAssignableFrom.isAssignableFrom(c0149i.getClass())) {
                return true;
            }
        }
        return false;
    }

    boolean m499H() {
        return this.f347j != null;
    }

    protected Collection<C0065l> m500I() {
        return this.f343f.mo13c();
    }
}
