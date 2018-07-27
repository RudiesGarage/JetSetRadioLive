package com.google.android.gms.common.internal;

import java.util.Iterator;

public class C1207x {
    private final String f3177a;

    private C1207x(String str) {
        this.f3177a = str;
    }

    public static C1207x m5653a(String str) {
        return new C1207x(str);
    }

    CharSequence m5654a(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final StringBuilder m5655a(StringBuilder stringBuilder, Iterable<?> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            stringBuilder.append(m5654a(it.next()));
            while (it.hasNext()) {
                stringBuilder.append(this.f3177a);
                stringBuilder.append(m5654a(it.next()));
            }
        }
        return stringBuilder;
    }
}
