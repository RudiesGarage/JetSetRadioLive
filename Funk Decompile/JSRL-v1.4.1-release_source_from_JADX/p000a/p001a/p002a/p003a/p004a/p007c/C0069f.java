package p000a.p001a.p002a.p003a.p004a.p007c;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.p003a.p004a.p007c.C0059a.C0053d;

/* compiled from: PriorityAsyncTask */
public abstract class C0069f<Params, Progress, Result> extends C0059a<Params, Progress, Result> implements C0060b<C0065l>, C0064i, C0065l {
    private final C0070j f147a = new C0070j();

    /* compiled from: PriorityAsyncTask */
    private static class C0068a<Result> implements Executor {
        private final Executor f145a;
        private final C0069f f146b;

        public C0068a(Executor executor, C0069f c0069f) {
            this.f145a = executor;
            this.f146b = c0069f;
        }

        public void execute(Runnable runnable) {
            this.f145a.execute(new C0066h<Result>(this, runnable, null) {
                final /* synthetic */ C0068a f144a;

                public <T extends C0060b<C0065l> & C0064i & C0065l> T mo17a() {
                    return this.f144a.f146b;
                }
            });
        }
    }

    public /* synthetic */ void mo14c(Object obj) {
        m213a((C0065l) obj);
    }

    public final void m215a(ExecutorService executorService, Params... paramsArr) {
        super.m174a(new C0068a(executorService, this), (Object[]) paramsArr);
    }

    public int compareTo(Object obj) {
        return C0063e.m196a(this, obj);
    }

    public void m213a(C0065l c0065l) {
        if (b_() != C0053d.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((C0060b) ((C0064i) m222g())).mo14c(c0065l);
    }

    public Collection<C0065l> mo13c() {
        return ((C0060b) ((C0064i) m222g())).mo13c();
    }

    public boolean mo15d() {
        return ((C0060b) ((C0064i) m222g())).mo15d();
    }

    public C0063e mo11b() {
        return ((C0064i) m222g()).mo11b();
    }

    public void mo12b(boolean z) {
        ((C0065l) ((C0064i) m222g())).mo12b(z);
    }

    public boolean mo16f() {
        return ((C0065l) ((C0064i) m222g())).mo16f();
    }

    public void mo10a(Throwable th) {
        ((C0065l) ((C0064i) m222g())).mo10a(th);
    }

    public <T extends C0060b<C0065l> & C0064i & C0065l> T m222g() {
        return this.f147a;
    }
}
