package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.C1157b;

@TargetApi(11)
public class C1126a extends DialogFragment {
    private Dialog f2994a = null;
    private OnCancelListener f2995b = null;

    public static C1126a m5273a(Dialog dialog, OnCancelListener onCancelListener) {
        C1126a c1126a = new C1126a();
        Dialog dialog2 = (Dialog) C1157b.m5370a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c1126a.f2994a = dialog2;
        if (onCancelListener != null) {
            c1126a.f2995b = onCancelListener;
        }
        return c1126a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f2995b != null) {
            this.f2995b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2994a == null) {
            setShowsDialog(false);
        }
        return this.f2994a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
