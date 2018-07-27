package com.google.android.gms.p043b;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.C1140h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p043b.C1094m.C1091a;
import com.google.android.gms.p043b.C1098q.C1097a;
import com.google.android.gms.p044c.C1116b;

public abstract class C1069d {
    public final int f2853a;

    private static abstract class C1070a extends C1069d {
        protected final C1116b<Void> f2854b;

        public C1070a(int i, C1116b<Void> c1116b) {
            super(i);
            this.f2854b = c1116b;
        }

        private void m5117a(RemoteException remoteException) {
            mo756a(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public void mo754a(C1089k c1089k, boolean z) {
        }

        public final void mo755a(C1091a<?> c1091a) {
            try {
                mo757b(c1091a);
            } catch (RemoteException e) {
                m5117a(e);
                throw e;
            } catch (RemoteException e2) {
                m5117a(e2);
            }
        }

        public void mo756a(Status status) {
            this.f2854b.m5251b(new C1140h(status));
        }

        protected abstract void mo757b(C1091a<?> c1091a);
    }

    public static final class C1071b extends C1070a {
        public final C1097a<?> f2855c;

        public C1071b(C1097a<?> c1097a, C1116b<Void> c1116b) {
            super(4, c1116b);
            this.f2855c = c1097a;
        }

        public /* bridge */ /* synthetic */ void mo754a(C1089k c1089k, boolean z) {
            super.mo754a(c1089k, z);
        }

        public /* bridge */ /* synthetic */ void mo756a(Status status) {
            super.mo756a(status);
        }

        public void mo757b(C1091a<?> c1091a) {
            C1101t c1101t = (C1101t) c1091a.m5188d().remove(this.f2855c);
            if (c1101t != null) {
                c1101t.f2937b.m5227a(c1091a.m5187c(), this.b);
                c1101t.f2936a.m5224a();
                return;
            }
            Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
            this.b.m5251b(new C1140h(Status.f3001c));
        }
    }

    public C1069d(int i) {
        this.f2853a = i;
    }

    public abstract void mo754a(C1089k c1089k, boolean z);

    public abstract void mo755a(C1091a<?> c1091a);

    public abstract void mo756a(Status status);
}
