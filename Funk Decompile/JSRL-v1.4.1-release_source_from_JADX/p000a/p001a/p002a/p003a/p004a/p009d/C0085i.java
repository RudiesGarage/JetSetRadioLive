package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;

/* compiled from: TimeBasedFileRollOverRunnable */
public class C0085i implements Runnable {
    private final Context f171a;
    private final C0081e f172b;

    public C0085i(Context context, C0081e c0081e) {
        this.f171a = context;
        this.f172b = c0081e;
    }

    public void run() {
        try {
            C0021i.m68a(this.f171a, "Performing time based file roll over.");
            if (!this.f172b.mo718c()) {
                this.f172b.mo719d();
            }
        } catch (Throwable e) {
            C0021i.m69a(this.f171a, "Failed to roll over file", e);
        }
    }
}
