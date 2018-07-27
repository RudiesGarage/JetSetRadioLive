package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.C0218i;
import android.support.v4.app.C0226n;
import com.google.android.gms.common.internal.C1157b;

public class C1151e extends C0218i {
    private Dialog f3051a = null;
    private OnCancelListener f3052b = null;

    public static C1151e m5343a(Dialog dialog, OnCancelListener onCancelListener) {
        C1151e c1151e = new C1151e();
        Dialog dialog2 = (Dialog) C1157b.m5370a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c1151e.f3051a = dialog2;
        if (onCancelListener != null) {
            c1151e.f3052b = onCancelListener;
        }
        return c1151e;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f3052b != null) {
            this.f3052b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f3051a == null) {
            setShowsDialog(false);
        }
        return this.f3051a;
    }

    public void show(C0226n c0226n, String str) {
        super.show(c0226n, str);
    }
}
