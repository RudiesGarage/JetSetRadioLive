package com.google.android.gms.p043b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.C1083d;
import com.google.android.gms.common.api.C1083d.C1137a;
import com.google.android.gms.common.api.C1127f;
import com.google.android.gms.common.api.C1136c;
import com.google.android.gms.common.api.C1138e;
import com.google.android.gms.common.api.C1139g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1157b;
import com.google.android.gms.common.internal.C1194s;
import com.google.android.gms.p043b.C1103u.C1102a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public abstract class C1084h<R extends C1127f> extends C1083d<R> {
    static final ThreadLocal<Boolean> f2875a = new C10801();
    protected final C1081a<R> f2876b = new C1081a(Looper.getMainLooper());
    protected final WeakReference<C1136c> f2877c = new WeakReference(null);
    private final Object f2878d = new Object();
    private final CountDownLatch f2879e = new CountDownLatch(1);
    private final ArrayList<C1137a> f2880f = new ArrayList();
    private C1139g<? super R> f2881g;
    private final AtomicReference<C1102a> f2882h = new AtomicReference();
    private R f2883i;
    private C1082b f2884j;
    private volatile boolean f2885k;
    private boolean f2886l;
    private boolean f2887m;
    private C1194s f2888n;
    private boolean f2889o = false;

    class C10801 extends ThreadLocal<Boolean> {
        C10801() {
        }

        protected Boolean m5137a() {
            return Boolean.valueOf(false);
        }

        protected /* synthetic */ Object initialValue() {
            return m5137a();
        }
    }

    public static class C1081a<R extends C1127f> extends Handler {
        public C1081a() {
            this(Looper.getMainLooper());
        }

        public C1081a(Looper looper) {
            super(looper);
        }

        public void m5138a() {
            removeMessages(2);
        }

        public void m5139a(C1139g<? super R> c1139g, R r) {
            sendMessage(obtainMessage(1, new Pair(c1139g, r)));
        }

        protected void m5140b(C1139g<? super R> c1139g, R r) {
            try {
                c1139g.m5301a(r);
            } catch (RuntimeException e) {
                C1084h.m5143b((C1127f) r);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    m5140b((C1139g) pair.first, (C1127f) pair.second);
                    return;
                case 2:
                    ((C1084h) message.obj).m5146a(Status.f3002d);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                    return;
            }
        }
    }

    private final class C1082b {
        final /* synthetic */ C1084h f2874a;

        private C1082b(C1084h c1084h) {
            this.f2874a = c1084h;
        }

        protected void finalize() {
            C1084h.m5143b(this.f2874a.f2883i);
            super.finalize();
        }
    }

    @Deprecated
    C1084h() {
    }

    private void m5142b() {
        C1102a c1102a = (C1102a) this.f2882h.getAndSet(null);
        if (c1102a != null) {
            c1102a.m5226a(this);
        }
    }

    public static void m5143b(C1127f c1127f) {
        if (c1127f instanceof C1138e) {
            try {
                ((C1138e) c1127f).m5300a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(c1127f);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private R m5144c() {
        R r;
        boolean z = true;
        synchronized (this.f2878d) {
            if (this.f2885k) {
                z = false;
            }
            C1157b.m5374a(z, (Object) "Result has already been consumed.");
            C1157b.m5374a(m5148a(), (Object) "Result is not ready.");
            r = this.f2883i;
            this.f2883i = null;
            this.f2881g = null;
            this.f2885k = true;
        }
        m5142b();
        return r;
    }

    private void m5145c(R r) {
        this.f2883i = r;
        this.f2888n = null;
        this.f2879e.countDown();
        Status a = this.f2883i.mo772a();
        if (this.f2886l) {
            this.f2881g = null;
        } else if (this.f2881g != null) {
            this.f2876b.m5138a();
            this.f2876b.m5139a(this.f2881g, m5144c());
        } else if (this.f2883i instanceof C1138e) {
            this.f2884j = new C1082b();
        }
        Iterator it = this.f2880f.iterator();
        while (it.hasNext()) {
            ((C1137a) it.next()).m5299a(a);
        }
        this.f2880f.clear();
    }

    public final void m5146a(Status status) {
        synchronized (this.f2878d) {
            if (!m5148a()) {
                m5147a(m5149b(status));
                this.f2887m = true;
            }
        }
    }

    public final void m5147a(R r) {
        boolean z = true;
        synchronized (this.f2878d) {
            if (this.f2887m || this.f2886l) {
                C1084h.m5143b((C1127f) r);
                return;
            }
            if (m5148a()) {
            }
            C1157b.m5374a(!m5148a(), (Object) "Results have already been set");
            if (this.f2885k) {
                z = false;
            }
            C1157b.m5374a(z, (Object) "Result has already been consumed");
            m5145c(r);
        }
    }

    public final boolean m5148a() {
        return this.f2879e.getCount() == 0;
    }

    protected abstract R m5149b(Status status);
}
