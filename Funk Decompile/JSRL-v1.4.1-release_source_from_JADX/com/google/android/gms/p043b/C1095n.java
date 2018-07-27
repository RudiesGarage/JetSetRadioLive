package com.google.android.gms.p043b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class C1095n extends BroadcastReceiver {
    protected Context f2927a;
    private final C1075a f2928b;

    public static abstract class C1075a {
        public abstract void mo758a();
    }

    public C1095n(C1075a c1075a) {
        this.f2928b = c1075a;
    }

    public synchronized void m5219a() {
        if (this.f2927a != null) {
            this.f2927a.unregisterReceiver(this);
        }
        this.f2927a = null;
    }

    public void m5220a(Context context) {
        this.f2927a = context;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            this.f2928b.mo758a();
            m5219a();
        }
    }
}
