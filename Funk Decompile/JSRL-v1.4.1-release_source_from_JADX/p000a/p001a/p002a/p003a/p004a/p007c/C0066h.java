package p000a.p001a.p002a.p003a.p004a.p007c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: PriorityFutureTask */
public class C0066h<V> extends FutureTask<V> implements C0060b<C0065l>, C0064i, C0065l {
    final Object f143b;

    public /* synthetic */ void mo14c(Object obj) {
        m203a((C0065l) obj);
    }

    public C0066h(Callable<V> callable) {
        super(callable);
        this.f143b = m202a((Object) callable);
    }

    public C0066h(Runnable runnable, V v) {
        super(runnable, v);
        this.f143b = m202a((Object) runnable);
    }

    public int compareTo(Object obj) {
        return ((C0064i) mo17a()).compareTo(obj);
    }

    public void m203a(C0065l c0065l) {
        ((C0060b) ((C0064i) mo17a())).mo14c(c0065l);
    }

    public Collection<C0065l> mo13c() {
        return ((C0060b) ((C0064i) mo17a())).mo13c();
    }

    public boolean mo15d() {
        return ((C0060b) ((C0064i) mo17a())).mo15d();
    }

    public C0063e mo11b() {
        return ((C0064i) mo17a()).mo11b();
    }

    public void mo12b(boolean z) {
        ((C0065l) ((C0064i) mo17a())).mo12b(z);
    }

    public boolean mo16f() {
        return ((C0065l) ((C0064i) mo17a())).mo16f();
    }

    public void mo10a(Throwable th) {
        ((C0065l) ((C0064i) mo17a())).mo10a(th);
    }

    public <T extends C0060b<C0065l> & C0064i & C0065l> T mo17a() {
        return (C0060b) this.f143b;
    }

    protected <T extends C0060b<C0065l> & C0064i & C0065l> T m202a(Object obj) {
        if (C0070j.m223a(obj)) {
            return (C0060b) obj;
        }
        return new C0070j();
    }
}
