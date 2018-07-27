package org.greenrobot.eventbus.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.greenrobot.eventbus.EventBus;

public class ExceptionToResourceMapping {
    public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap = new HashMap();

    public Integer mapThrowable(Throwable th) {
        int i = 20;
        Throwable th2 = th;
        do {
            Integer mapThrowableFlat = mapThrowableFlat(th2);
            if (mapThrowableFlat != null) {
                return mapThrowableFlat;
            }
            th2 = th2.getCause();
            i--;
            if (i <= 0 || th2 == th) {
                Log.d(EventBus.TAG, "No specific message ressource ID found for " + th);
            }
        } while (th2 != null);
        Log.d(EventBus.TAG, "No specific message ressource ID found for " + th);
        return null;
    }

    protected Integer mapThrowableFlat(Throwable th) {
        Class cls = th.getClass();
        Integer num = (Integer) this.throwableToMsgIdMap.get(cls);
        if (num != null) {
            return num;
        }
        Class cls2 = null;
        Integer num2 = num;
        for (Entry entry : this.throwableToMsgIdMap.entrySet()) {
            Class cls3 = (Class) entry.getKey();
            if (cls3.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(cls3))) {
                num = (Integer) entry.getValue();
            } else {
                cls3 = cls2;
                num = num2;
            }
            cls2 = cls3;
            num2 = num;
        }
        return num2;
    }

    public ExceptionToResourceMapping addMapping(Class<? extends Throwable> cls, int i) {
        this.throwableToMsgIdMap.put(cls, Integer.valueOf(i));
        return this;
    }
}
