package com.google.android.gms.p043b;

import android.os.Binder;

public abstract class C1105w<T> {
    private static final Object f2940c = new Object();
    private static C1109a f2941d = null;
    private static int f2942e = 0;
    private static String f2943f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String f2944a;
    protected final T f2945b;
    private T f2946g = null;

    class C11061 extends C1105w<Long> {
        C11061(String str, Long l) {
            super(str, l);
        }

        protected /* synthetic */ Object mo766a(String str) {
            return m5235b(str);
        }

        protected Long m5235b(String str) {
            return null.m5241a(this.a, (Long) this.b);
        }
    }

    class C11072 extends C1105w<Integer> {
        C11072(String str, Integer num) {
            super(str, num);
        }

        protected /* synthetic */ Object mo766a(String str) {
            return m5237b(str);
        }

        protected Integer m5237b(String str) {
            return null.m5240a(this.a, (Integer) this.b);
        }
    }

    class C11083 extends C1105w<String> {
        C11083(String str, String str2) {
            super(str, str2);
        }

        protected /* synthetic */ Object mo766a(String str) {
            return m5239b(str);
        }

        protected String m5239b(String str) {
            return null.m5242a(this.a, (String) this.b);
        }
    }

    private interface C1109a {
        Integer m5240a(String str, Integer num);

        Long m5241a(String str, Long l);

        String m5242a(String str, String str2);
    }

    protected C1105w(String str, T t) {
        this.f2944a = str;
        this.f2945b = t;
    }

    public static C1105w<Integer> m5228a(String str, Integer num) {
        return new C11072(str, num);
    }

    public static C1105w<Long> m5229a(String str, Long l) {
        return new C11061(str, l);
    }

    public static C1105w<String> m5230a(String str, String str2) {
        return new C11083(str, str2);
    }

    public final T m5232a() {
        T a;
        long clearCallingIdentity;
        try {
            a = mo766a(this.f2944a);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            a = mo766a(this.f2944a);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return a;
    }

    protected abstract T mo766a(String str);
}
