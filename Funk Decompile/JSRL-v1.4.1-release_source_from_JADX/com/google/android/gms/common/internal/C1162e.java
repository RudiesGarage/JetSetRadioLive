package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C1133a.C1130h;
import com.google.android.gms.common.api.C1136c.C1085b;
import com.google.android.gms.common.api.C1136c.C1086c;

public class C1162e<T extends IInterface> extends C1161n<T> {
    private final C1130h<T> f3112e;

    public C1162e(Context context, Looper looper, int i, C1085b c1085b, C1086c c1086c, C1178j c1178j, C1130h<T> c1130h) {
        super(context, looper, i, c1178j, c1085b, c1086c);
        this.f3112e = c1130h;
    }

    protected T mo784a(IBinder iBinder) {
        return this.f3112e.m5287a(iBinder);
    }

    protected void mo785a(int i, T t) {
        this.f3112e.m5289a(i, t);
    }

    protected String mo786f() {
        return this.f3112e.m5288a();
    }

    protected String mo787g() {
        return this.f3112e.m5290b();
    }

    public C1130h<T> mo788h() {
        return this.f3112e;
    }
}
