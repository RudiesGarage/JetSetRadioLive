package com.google.android.gms.p043b;

import android.content.Context;
import com.google.firebase.C1257a;
import java.util.concurrent.atomic.AtomicReference;

public class C1065b {
    private static final AtomicReference<C1065b> f2851a = new AtomicReference();

    C1065b(Context context) {
    }

    public static C1065b m5103a(Context context) {
        f2851a.compareAndSet(null, new C1065b(context));
        return (C1065b) f2851a.get();
    }

    public void m5104a(C1257a c1257a) {
    }
}
