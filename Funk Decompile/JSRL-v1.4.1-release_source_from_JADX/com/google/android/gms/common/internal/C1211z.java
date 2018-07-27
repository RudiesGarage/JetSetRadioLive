package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class C1211z {

    public static final class C1210a {
        private final List<String> f3182a;
        private final Object f3183b;

        private C1210a(Object obj) {
            this.f3183b = C1157b.m5369a(obj);
            this.f3182a = new ArrayList();
        }

        public C1210a m5658a(String str, Object obj) {
            List list = this.f3182a;
            String str2 = (String) C1157b.m5369a((Object) str);
            String valueOf = String.valueOf(String.valueOf(obj));
            list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f3183b.getClass().getSimpleName()).append('{');
            int size = this.f3182a.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.f3182a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static int m5659a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static C1210a m5660a(Object obj) {
        return new C1210a(obj);
    }

    public static boolean m5661a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
