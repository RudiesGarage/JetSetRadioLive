package com.p035a.p036a.p037a;

import p000a.p001a.p002a.p003a.p004a.p007c.p008a.C0058e;

/* compiled from: RetryManager */
class C0929m {
    long f2511a;
    private C0058e f2512b;

    public C0929m(C0058e c0058e) {
        if (c0058e == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.f2512b = c0058e;
    }

    public boolean m4661a(long j) {
        return j - this.f2511a >= 1000000 * this.f2512b.m164a();
    }

    public void m4662b(long j) {
        this.f2511a = j;
        this.f2512b = this.f2512b.m165b();
    }

    public void m4660a() {
        this.f2511a = 0;
        this.f2512b = this.f2512b.m166c();
    }
}
