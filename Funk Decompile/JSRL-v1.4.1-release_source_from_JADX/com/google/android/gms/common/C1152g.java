package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.C1157b;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class C1152g implements ServiceConnection {
    boolean f3053a = false;
    private final BlockingQueue<IBinder> f3054b = new LinkedBlockingQueue();

    public IBinder m5344a(long j, TimeUnit timeUnit) {
        C1157b.m5375b("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f3053a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f3053a = true;
        IBinder iBinder = (IBinder) this.f3054b.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3054b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
