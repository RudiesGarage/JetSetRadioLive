package com.p035a.p036a.p037a;

import java.io.File;
import java.util.List;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.C0056b;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.C0057c;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.C0058e;
import p000a.p001a.p002a.p003a.p004a.p009d.C0082f;

/* compiled from: AnswersRetryFilesSender */
class C0919f implements C0082f {
    private final C0933p f2487a;
    private final C0929m f2488b;

    public static C0919f m4629a(C0933p c0933p) {
        return new C0919f(c0933p, new C0929m(new C0058e(new C0928l(new C0057c(1000, 8), 0.1d), new C0056b(5))));
    }

    C0919f(C0933p c0933p, C0929m c0929m) {
        this.f2487a = c0933p;
        this.f2488b = c0929m;
    }

    public boolean mo713a(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.f2488b.m4661a(nanoTime)) {
            return false;
        }
        if (this.f2487a.mo713a(list)) {
            this.f2488b.m4660a();
            return true;
        }
        this.f2488b.m4662b(nanoTime);
        return false;
    }
}
