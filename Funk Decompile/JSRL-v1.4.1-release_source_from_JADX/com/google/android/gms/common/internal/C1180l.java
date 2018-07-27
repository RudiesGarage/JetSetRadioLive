package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.p043b.C1096p;

public abstract class C1180l implements OnClickListener {

    class C11811 extends C1180l {
        final /* synthetic */ Intent f3141a;
        final /* synthetic */ Activity f3142b;
        final /* synthetic */ int f3143c;

        C11811(Intent intent, Activity activity, int i) {
            this.f3141a = intent;
            this.f3142b = activity;
            this.f3143c = i;
        }

        public void mo795a() {
            if (this.f3141a != null) {
                this.f3142b.startActivityForResult(this.f3141a, this.f3143c);
            }
        }
    }

    class C11822 extends C1180l {
        final /* synthetic */ Intent f3144a;
        final /* synthetic */ Fragment f3145b;
        final /* synthetic */ int f3146c;

        C11822(Intent intent, Fragment fragment, int i) {
            this.f3144a = intent;
            this.f3145b = fragment;
            this.f3146c = i;
        }

        public void mo795a() {
            if (this.f3144a != null) {
                this.f3145b.startActivityForResult(this.f3144a, this.f3146c);
            }
        }
    }

    class C11833 extends C1180l {
        final /* synthetic */ Intent f3147a;
        final /* synthetic */ C1096p f3148b;
        final /* synthetic */ int f3149c;

        C11833(Intent intent, C1096p c1096p, int i) {
            this.f3147a = intent;
            this.f3148b = c1096p;
            this.f3149c = i;
        }

        @TargetApi(11)
        public void mo795a() {
            if (this.f3147a != null) {
                this.f3148b.m5222a(this.f3147a, this.f3149c);
            }
        }
    }

    public static C1180l m5479a(Activity activity, Intent intent, int i) {
        return new C11811(intent, activity, i);
    }

    public static C1180l m5480a(Fragment fragment, Intent intent, int i) {
        return new C11822(intent, fragment, i);
    }

    public static C1180l m5481a(C1096p c1096p, Intent intent, int i) {
        return new C11833(intent, c1096p, i);
    }

    protected abstract void mo795a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo795a();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
