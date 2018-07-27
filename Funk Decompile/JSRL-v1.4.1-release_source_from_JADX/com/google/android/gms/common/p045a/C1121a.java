package com.google.android.gms.common.p045a;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.p045a.C1123b.C1122a;
import com.google.android.gms.common.util.C1221b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C1121a {
    private static final Object f2965a = new Object();
    private static C1121a f2966b;
    private static Integer f2967h;
    private final List<String> f2968c;
    private final List<String> f2969d;
    private final List<String> f2970e;
    private final List<String> f2971f;
    private C1125d f2972g;
    private C1125d f2973i;

    private C1121a() {
        if (m5266b()) {
            this.f2968c = Collections.EMPTY_LIST;
            this.f2969d = Collections.EMPTY_LIST;
            this.f2970e = Collections.EMPTY_LIST;
            this.f2971f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) C1122a.f2975b.m5232a();
        this.f2968c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1122a.f2976c.m5232a();
        this.f2969d = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1122a.f2977d.m5232a();
        this.f2970e = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1122a.f2978e.m5232a();
        this.f2971f = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.f2972g = new C1125d(1024, ((Long) C1122a.f2979f.m5232a()).longValue());
        this.f2973i = new C1125d(1024, ((Long) C1122a.f2979f.m5232a()).longValue());
    }

    public static C1121a m5264a() {
        synchronized (f2965a) {
            if (f2966b == null) {
                f2966b = new C1121a();
            }
        }
        return f2966b;
    }

    private boolean m5265a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? false : C1221b.m5678a(context, component.getPackageName());
    }

    private boolean m5266b() {
        return C1121a.m5267c() == C1124c.f2983b;
    }

    private static int m5267c() {
        if (f2967h == null) {
            try {
                f2967h = Integer.valueOf(C1221b.m5677a() ? ((Integer) C1122a.f2974a.m5232a()).intValue() : C1124c.f2983b);
            } catch (SecurityException e) {
                f2967h = Integer.valueOf(C1124c.f2983b);
            }
        }
        return f2967h.intValue();
    }

    @SuppressLint({"UntrackedBindService"})
    public void m5268a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public void m5269a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
    }

    public boolean m5270a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m5271a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean m5271a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (!m5265a(context, intent)) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    public void m5272b(Context context, ServiceConnection serviceConnection) {
    }
}
