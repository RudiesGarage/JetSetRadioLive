package p000a.p001a.p002a.p003a;

import p000a.p001a.p002a.p003a.p004a.p006b.C0043t;
import p000a.p001a.p002a.p003a.p004a.p007c.C0063e;
import p000a.p001a.p002a.p003a.p004a.p007c.C0069f;
import p000a.p001a.p002a.p003a.p004a.p007c.C0074m;

/* compiled from: InitializationTask */
class C0148h<Result> extends C0069f<Void, Void, Result> {
    final C0149i<Result> f341a;

    public C0148h(C0149i<Result> c0149i) {
        this.f341a = c0149i;
    }

    protected void mo61a() {
        super.mo61a();
        C0043t a = m487a("onPreExecute");
        try {
            boolean a_ = this.f341a.a_();
            a.m160b();
            if (!a_) {
                m178a(true);
            }
        } catch (C0074m e) {
            throw e;
        } catch (Throwable e2) {
            C0142c.m468h().mo54e("Fabric", "Failure onPreExecute()", e2);
            a.m160b();
            m178a(true);
        } catch (Throwable th) {
            a.m160b();
            m178a(true);
        }
    }

    protected Result m489a(Void... voidArr) {
        C0043t a = m487a("doInBackground");
        Result result = null;
        if (!m181e()) {
            result = this.f341a.mo67f();
        }
        a.m160b();
        return result;
    }

    protected void mo62a(Result result) {
        this.f341a.m504a((Object) result);
        this.f341a.f345h.mo59a((Object) result);
    }

    protected void mo63b(Result result) {
        this.f341a.m506b((Object) result);
        this.f341a.f345h.mo58a(new C0147g(this.f341a.mo66b() + " Initialization was cancelled"));
    }

    public C0063e mo11b() {
        return C0063e.HIGH;
    }

    private C0043t m487a(String str) {
        C0043t c0043t = new C0043t(this.f341a.mo66b() + "." + str, "KitInitialization");
        c0043t.m159a();
        return c0043t;
    }
}
