package com.live.jetsetradio.JetSetRadioLive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RadioServ extends Service {
    public RadioServ() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
