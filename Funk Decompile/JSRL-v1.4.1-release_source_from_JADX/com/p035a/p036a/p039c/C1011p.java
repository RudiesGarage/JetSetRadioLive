package com.p035a.p036a.p039c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DevicePowerStateListener */
class C1011p {
    private static final IntentFilter f2742a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter f2743b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter f2744c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final AtomicBoolean f2745d;
    private final Context f2746e;
    private final BroadcastReceiver f2747f;
    private final BroadcastReceiver f2748g;
    private boolean f2749h;

    /* compiled from: DevicePowerStateListener */
    class C10091 extends BroadcastReceiver {
        final /* synthetic */ C1011p f2740a;

        C10091(C1011p c1011p) {
            this.f2740a = c1011p;
        }

        public void onReceive(Context context, Intent intent) {
            this.f2740a.f2749h = true;
        }
    }

    /* compiled from: DevicePowerStateListener */
    class C10102 extends BroadcastReceiver {
        final /* synthetic */ C1011p f2741a;

        C10102(C1011p c1011p) {
            this.f2741a = c1011p;
        }

        public void onReceive(Context context, Intent intent) {
            this.f2741a.f2749h = false;
        }
    }

    public C1011p(Context context) {
        int i = -1;
        this.f2746e = context;
        Intent registerReceiver = context.registerReceiver(null, f2742a);
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("status", -1);
        }
        boolean z = i == 2 || i == 5;
        this.f2749h = z;
        this.f2748g = new C10091(this);
        this.f2747f = new C10102(this);
        context.registerReceiver(this.f2748g, f2743b);
        context.registerReceiver(this.f2747f, f2744c);
        this.f2745d = new AtomicBoolean(true);
    }

    public boolean m4974a() {
        return this.f2749h;
    }

    public void m4975b() {
        if (this.f2745d.getAndSet(false)) {
            this.f2746e.unregisterReceiver(this.f2748g);
            this.f2746e.unregisterReceiver(this.f2747f);
        }
    }
}
