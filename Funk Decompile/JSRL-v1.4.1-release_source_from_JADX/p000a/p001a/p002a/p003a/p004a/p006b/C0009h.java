package p000a.p001a.p002a.p003a.p004a.p006b;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable */
public abstract class C0009h implements Runnable {
    protected abstract void mo4a();

    public final void run() {
        Process.setThreadPriority(10);
        mo4a();
    }
}
