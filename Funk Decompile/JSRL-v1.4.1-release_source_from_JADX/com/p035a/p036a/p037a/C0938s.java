package com.p035a.p036a.p037a;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

/* compiled from: SessionEvent */
final class C0938s {
    public final C0939t f2538a;
    public final long f2539b;
    public final C0937b f2540c;
    public final Map<String, String> f2541d;
    public final String f2542e;
    public final Map<String, Object> f2543f;
    public final String f2544g;
    public final Map<String, Object> f2545h;
    private String f2546i;

    /* compiled from: SessionEvent */
    static class C0936a {
        final C0937b f2522a;
        final long f2523b = System.currentTimeMillis();
        Map<String, String> f2524c = null;
        String f2525d = null;
        Map<String, Object> f2526e = null;
        String f2527f = null;
        Map<String, Object> f2528g = null;

        public C0936a(C0937b c0937b) {
            this.f2522a = c0937b;
        }

        public C0936a m4680a(Map<String, String> map) {
            this.f2524c = map;
            return this;
        }

        public C0936a m4682b(Map<String, Object> map) {
            this.f2526e = map;
            return this;
        }

        public C0938s m4681a(C0939t c0939t) {
            return new C0938s(c0939t, this.f2523b, this.f2522a, this.f2524c, this.f2525d, this.f2526e, this.f2527f, this.f2528g);
        }
    }

    /* compiled from: SessionEvent */
    enum C0937b {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    public static C0936a m4684a(C0937b c0937b, Activity activity) {
        return new C0936a(c0937b).m4680a(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    public static C0936a m4683a() {
        return new C0936a(C0937b.INSTALL);
    }

    public static C0936a m4685a(String str) {
        return new C0936a(C0937b.CRASH).m4680a(Collections.singletonMap("sessionId", str));
    }

    public static C0936a m4686a(String str, String str2) {
        return C0938s.m4685a(str).m4682b(Collections.singletonMap("exceptionName", str2));
    }

    private C0938s(C0939t c0939t, long j, C0937b c0937b, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f2538a = c0939t;
        this.f2539b = j;
        this.f2540c = c0937b;
        this.f2541d = map;
        this.f2542e = str;
        this.f2543f = map2;
        this.f2544g = str2;
        this.f2545h = map3;
    }

    public String toString() {
        if (this.f2546i == null) {
            this.f2546i = "[" + getClass().getSimpleName() + ": " + "timestamp=" + this.f2539b + ", type=" + this.f2540c + ", details=" + this.f2541d + ", customType=" + this.f2542e + ", customAttributes=" + this.f2543f + ", predefinedType=" + this.f2544g + ", predefinedAttributes=" + this.f2545h + ", metadata=[" + this.f2538a + "]]";
        }
        return this.f2546i;
    }
}
