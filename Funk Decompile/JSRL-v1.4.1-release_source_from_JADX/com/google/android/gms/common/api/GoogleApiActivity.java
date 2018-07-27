package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.C1147b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.p043b.C1094m;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    protected int f2996a = 0;

    public static PendingIntent m5274a(Context context, PendingIntent pendingIntent, int i) {
        return m5275a(context, pendingIntent, i, true);
    }

    public static PendingIntent m5275a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        return PendingIntent.getActivity(context, 0, m5278b(context, pendingIntent, i, z), 134217728);
    }

    private void m5276a() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.f2996a = 1;
            } catch (Throwable e) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                finish();
            }
        } else {
            C1147b.m5323a().m5342b(this, num.intValue(), 2, this);
            this.f2996a = 1;
        }
    }

    private void m5277a(int i, C1094m c1094m) {
        switch (i) {
            case -1:
                c1094m.m5214a();
                return;
            case 0:
                c1094m.m5218b(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                return;
            default:
                return;
        }
    }

    public static Intent m5278b(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    protected void m5279a(int i) {
        setResult(i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f2996a = 0;
            m5279a(i2);
            if (booleanExtra) {
                m5277a(i2, C1094m.m5198a((Context) this));
            }
        } else if (i == 2) {
            this.f2996a = 0;
            m5279a(i2);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f2996a = 0;
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f2996a = bundle.getInt("resolution");
        }
        if (this.f2996a != 1) {
            m5276a();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f2996a);
        super.onSaveInstanceState(bundle);
    }
}
