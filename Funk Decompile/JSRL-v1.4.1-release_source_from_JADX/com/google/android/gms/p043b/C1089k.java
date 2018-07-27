package com.google.android.gms.p043b;

import com.google.android.gms.common.api.C1140h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p044c.C1116b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class C1089k {
    private final Map<C1084h<?>, Boolean> f2893a = Collections.synchronizedMap(new WeakHashMap());
    private final Map<C1116b<?>, Boolean> f2894b = Collections.synchronizedMap(new WeakHashMap());

    private void m5159a(boolean z, Status status) {
        synchronized (this.f2893a) {
            Map hashMap = new HashMap(this.f2893a);
        }
        synchronized (this.f2894b) {
            Map hashMap2 = new HashMap(this.f2894b);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((C1084h) entry.getKey()).m5146a(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C1116b) entry2.getKey()).m5251b(new C1140h(status));
            }
        }
    }

    boolean m5160a() {
        return (this.f2893a.isEmpty() && this.f2894b.isEmpty()) ? false : true;
    }

    public void m5161b() {
        m5159a(false, C1094m.f2910a);
    }

    public void m5162c() {
        m5159a(true, C1103u.f2938a);
    }
}
