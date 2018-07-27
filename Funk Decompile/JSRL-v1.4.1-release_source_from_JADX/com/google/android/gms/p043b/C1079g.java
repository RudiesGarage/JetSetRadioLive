package com.google.android.gms.p043b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Handler;
import com.google.android.gms.common.C1147b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.p043b.C1095n.C1075a;

public abstract class C1079g extends C1078o implements OnCancelListener {
    protected boolean f2868a;
    protected boolean f2869b;
    protected final C1147b f2870c;
    private ConnectionResult f2871e;
    private int f2872f;
    private final Handler f2873g;

    private class C1077a implements Runnable {
        final /* synthetic */ C1079g f2866a;

        private C1077a(C1079g c1079g) {
            this.f2866a = c1079g;
        }

        public void run() {
            if (!this.f2866a.f2868a) {
                return;
            }
            if (this.f2866a.f2871e.m5259a()) {
                this.f2866a.d.m5222a(GoogleApiActivity.m5278b(this.f2866a.m5130c(), this.f2866a.f2871e.m5262d(), this.f2866a.f2872f, false), 1);
            } else if (this.f2866a.f2870c.mo776a(this.f2866a.f2871e.m5261c())) {
                this.f2866a.f2870c.m5338a(this.f2866a.m5130c(), this.f2866a.d, this.f2866a.f2871e.m5261c(), 2, this.f2866a);
            } else if (this.f2866a.f2871e.m5261c() == 18) {
                final Dialog a = this.f2866a.f2870c.m5326a(this.f2866a.m5130c(), this.f2866a);
                this.f2866a.f2870c.m5331a(this.f2866a.m5130c().getApplicationContext(), new C1075a(this) {
                    final /* synthetic */ C1077a f2865b;

                    public void mo758a() {
                        this.f2865b.f2866a.m5135b();
                        if (a.isShowing()) {
                            a.dismiss();
                        }
                    }
                });
            } else {
                this.f2866a.mo763a(this.f2866a.f2871e, this.f2866a.f2872f);
            }
        }
    }

    protected abstract void mo762a();

    protected abstract void mo763a(ConnectionResult connectionResult, int i);

    protected void m5135b() {
        this.f2872f = -1;
        this.f2869b = false;
        this.f2871e = null;
        mo762a();
    }

    public void m5136b(ConnectionResult connectionResult, int i) {
        if (!this.f2869b) {
            this.f2869b = true;
            this.f2872f = i;
            this.f2871e = connectionResult;
            this.f2873g.post(new C1077a());
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo763a(new ConnectionResult(13, null), this.f2872f);
        m5135b();
    }
}
