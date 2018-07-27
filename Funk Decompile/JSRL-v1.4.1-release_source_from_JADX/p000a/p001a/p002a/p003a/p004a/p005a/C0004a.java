package p000a.p001a.p002a.p003a.p004a.p005a;

import android.content.Context;

/* compiled from: AbstractValueCache */
public abstract class C0004a<T> implements C0003c<T> {
    private final C0003c<T> f4a;

    protected abstract T mo2a(Context context);

    protected abstract void mo3a(Context context, T t);

    public C0004a(C0003c<T> c0003c) {
        this.f4a = c0003c;
    }

    public final synchronized T mo1a(Context context, C0006d<T> c0006d) {
        T a;
        a = mo2a(context);
        if (a == null) {
            a = this.f4a != null ? this.f4a.mo1a(context, c0006d) : c0006d.mo6b(context);
            m12b(context, a);
        }
        return a;
    }

    private void m12b(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        mo3a(context, (Object) t);
    }
}
