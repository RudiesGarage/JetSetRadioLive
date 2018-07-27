package p000a.p001a.p002a.p003a.p004a.p006b;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: TimingMetric */
public class C0043t {
    private final String f96a;
    private final String f97b;
    private final boolean f98c;
    private long f99d;
    private long f100e;

    public C0043t(String str, String str2) {
        this.f96a = str;
        this.f97b = str2;
        this.f98c = !Log.isLoggable(str2, 2);
    }

    public synchronized void m159a() {
        if (!this.f98c) {
            this.f99d = SystemClock.elapsedRealtime();
            this.f100e = 0;
        }
    }

    public synchronized void m160b() {
        if (!this.f98c) {
            if (this.f100e == 0) {
                this.f100e = SystemClock.elapsedRealtime() - this.f99d;
                m158c();
            }
        }
    }

    private void m158c() {
        Log.v(this.f97b, this.f96a + ": " + this.f100e + "ms");
    }
}
