package com.google.android.gms.p044c;

import com.google.android.gms.common.internal.C1157b;

final class C1119e<TResult> extends C1115a<TResult> {
    private final Object f2955a = new Object();
    private final C1118d<TResult> f2956b = new C1118d();
    private boolean f2957c;
    private TResult f2958d;
    private Exception f2959e;

    C1119e() {
    }

    private void m5254a() {
        C1157b.m5374a(!this.f2957c, (Object) "Task is already complete");
    }

    public void m5255a(Exception exception) {
        C1157b.m5370a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f2955a) {
            m5254a();
            this.f2957c = true;
            this.f2959e = exception;
        }
        this.f2956b.m5253a(this);
    }

    public void m5256a(TResult tResult) {
        synchronized (this.f2955a) {
            m5254a();
            this.f2957c = true;
            this.f2958d = tResult;
        }
        this.f2956b.m5253a(this);
    }

    public boolean m5257b(Exception exception) {
        boolean z = true;
        C1157b.m5370a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f2955a) {
            if (this.f2957c) {
                z = false;
            } else {
                this.f2957c = true;
                this.f2959e = exception;
                this.f2956b.m5253a(this);
            }
        }
        return z;
    }
}
