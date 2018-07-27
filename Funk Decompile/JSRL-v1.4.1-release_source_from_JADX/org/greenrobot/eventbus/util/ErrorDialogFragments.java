package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.C0218i;

public class ErrorDialogFragments {
    public static int ERROR_DIALOG_ICON = 0;
    public static Class<?> EVENT_TYPE_ON_CLICK;

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements OnClickListener {
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.handleOnClick(dialogInterface, i, getActivity(), getArguments());
        }
    }

    public static class Support extends C0218i implements OnClickListener {
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.handleOnClick(dialogInterface, i, getActivity(), getArguments());
        }
    }

    public static Dialog createDialog(Context context, Bundle bundle, OnClickListener onClickListener) {
        Builder builder = new Builder(context);
        builder.setTitle(bundle.getString(ErrorDialogManager.KEY_TITLE));
        builder.setMessage(bundle.getString(ErrorDialogManager.KEY_MESSAGE));
        if (ERROR_DIALOG_ICON != 0) {
            builder.setIcon(ERROR_DIALOG_ICON);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void handleOnClick(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) {
        if (EVENT_TYPE_ON_CLICK != null) {
            try {
                ErrorDialogManager.factory.config.getEventBus().post(EVENT_TYPE_ON_CLICK.newInstance());
            } catch (Throwable e) {
                throw new RuntimeException("Event cannot be constructed", e);
            }
        }
        if (bundle.getBoolean(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, false) && activity != null) {
            activity.finish();
        }
    }
}
