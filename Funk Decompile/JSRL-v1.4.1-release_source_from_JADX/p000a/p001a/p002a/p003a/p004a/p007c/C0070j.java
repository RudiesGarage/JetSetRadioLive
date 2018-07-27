package p000a.p001a.p002a.p003a.p004a.p007c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PriorityTask */
public class C0070j implements C0060b<C0065l>, C0064i, C0065l {
    private final List<C0065l> f148a = new ArrayList();
    private final AtomicBoolean f149b = new AtomicBoolean(false);
    private final AtomicReference<Throwable> f150c = new AtomicReference(null);

    public /* synthetic */ void mo14c(Object obj) {
        m224a((C0065l) obj);
    }

    public synchronized Collection<C0065l> mo13c() {
        return Collections.unmodifiableCollection(this.f148a);
    }

    public synchronized void m224a(C0065l c0065l) {
        this.f148a.add(c0065l);
    }

    public boolean mo15d() {
        for (C0065l f : mo13c()) {
            if (!f.mo16f()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void mo12b(boolean z) {
        this.f149b.set(z);
    }

    public boolean mo16f() {
        return this.f149b.get();
    }

    public C0063e mo11b() {
        return C0063e.NORMAL;
    }

    public void mo10a(Throwable th) {
        this.f150c.set(th);
    }

    public int compareTo(Object obj) {
        return C0063e.m196a(this, obj);
    }

    public static boolean m223a(Object obj) {
        try {
            C0060b c0060b = (C0060b) obj;
            C0065l c0065l = (C0065l) obj;
            C0064i c0064i = (C0064i) obj;
            if (c0060b == null || c0065l == null || c0064i == null) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
