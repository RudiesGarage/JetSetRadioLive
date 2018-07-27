package com.p035a.p036a.p039c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o.C0032a;

/* compiled from: SessionProtobufHelper */
class aa {
    private static final C0965b f2630a = C0965b.m4779a("0");
    private static final C0965b f2631b = C0965b.m4779a("Unity");

    public static void m4755a(C0970e c0970e, String str, String str2, long j) {
        c0970e.m4818a(1, C0965b.m4779a(str2));
        c0970e.m4818a(2, C0965b.m4779a(str));
        c0970e.m4817a(3, j);
    }

    public static void m4757a(C0970e c0970e, String str, String str2, String str3, String str4, String str5, int i, String str6) {
        C0965b a = C0965b.m4779a(str);
        C0965b a2 = C0965b.m4779a(str2);
        C0965b a3 = C0965b.m4779a(str3);
        C0965b a4 = C0965b.m4779a(str4);
        C0965b a5 = C0965b.m4779a(str5);
        C0965b a6 = str6 != null ? C0965b.m4779a(str6) : null;
        c0970e.m4833g(7, 2);
        c0970e.m4835k(aa.m4741a(a, a2, a3, a4, a5, i, a6));
        c0970e.m4818a(1, a);
        c0970e.m4818a(2, a3);
        c0970e.m4818a(3, a4);
        c0970e.m4833g(5, 2);
        c0970e.m4835k(aa.m4739a(a2));
        c0970e.m4818a(1, a2);
        c0970e.m4818a(6, a5);
        if (a6 != null) {
            c0970e.m4818a(8, f2631b);
            c0970e.m4818a(9, a6);
        }
        c0970e.m4827b(10, i);
    }

    public static void m4763a(C0970e c0970e, boolean z) {
        C0965b a = C0965b.m4779a(VERSION.RELEASE);
        C0965b a2 = C0965b.m4779a(VERSION.CODENAME);
        c0970e.m4833g(8, 2);
        c0970e.m4835k(aa.m4742a(a, a2, z));
        c0970e.m4827b(1, 3);
        c0970e.m4818a(2, a);
        c0970e.m4818a(3, a2);
        c0970e.m4819a(4, z);
    }

    public static void m4754a(C0970e c0970e, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<C0032a, String> map, int i3, String str3, String str4) {
        C0965b a = C0965b.m4779a(str);
        C0965b a2 = aa.m4749a(str2);
        C0965b a3 = aa.m4749a(str4);
        C0965b a4 = aa.m4749a(str3);
        c0970e.m4833g(9, 2);
        c0970e.m4835k(aa.m4736a(i, a, a2, i2, j, j2, z, (Map) map, i3, a4, a3));
        c0970e.m4818a(1, a);
        c0970e.m4827b(3, i);
        c0970e.m4818a(4, a2);
        c0970e.m4816a(5, i2);
        c0970e.m4817a(6, j);
        c0970e.m4817a(7, j2);
        c0970e.m4819a(10, z);
        for (Entry entry : map.entrySet()) {
            c0970e.m4833g(11, 2);
            c0970e.m4835k(aa.m4738a((C0032a) entry.getKey(), (String) entry.getValue()));
            c0970e.m4827b(1, ((C0032a) entry.getKey()).f63h);
            c0970e.m4818a(2, C0965b.m4779a((String) entry.getValue()));
        }
        c0970e.m4816a(12, i3);
        if (a4 != null) {
            c0970e.m4818a(13, a4);
        }
        if (a3 != null) {
            c0970e.m4818a(14, a3);
        }
    }

    public static void m4756a(C0970e c0970e, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        C0965b a = C0965b.m4779a(str);
        C0965b a2 = aa.m4749a(str2);
        C0965b a3 = aa.m4749a(str3);
        int b = 0 + C0970e.m4796b(1, a);
        if (str2 != null) {
            b += C0970e.m4796b(2, a2);
        }
        if (str3 != null) {
            b += C0970e.m4796b(3, a3);
        }
        c0970e.m4833g(6, 2);
        c0970e.m4835k(b);
        c0970e.m4818a(1, a);
        if (str2 != null) {
            c0970e.m4818a(2, a2);
        }
        if (str3 != null) {
            c0970e.m4818a(3, a3);
        }
    }

    public static void m4752a(C0970e c0970e, long j, String str, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, C1016s c1016s, RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, float f, int i2, boolean z, long j2, long j3) {
        C0965b c0965b;
        C0965b a = C0965b.m4779a(str2);
        if (str3 == null) {
            c0965b = null;
        } else {
            c0965b = C0965b.m4779a(str3.replace("-", ""));
        }
        C0965b a2 = c1016s.m4994a();
        if (a2 == null) {
            C0142c.m468h().mo46a("CrashlyticsCore", "No log data to include with this event.");
        }
        c1016s.m4998b();
        c0970e.m4833g(10, 2);
        c0970e.m4835k(aa.m4737a(j, str, th, thread, stackTraceElementArr, threadArr, (List) list, 8, (Map) map, runningAppProcessInfo, i, a, c0965b, f, i2, z, j2, j3, a2));
        c0970e.m4817a(1, j);
        c0970e.m4818a(2, C0965b.m4779a(str));
        aa.m4761a(c0970e, th, thread, stackTraceElementArr, threadArr, (List) list, 8, a, c0965b, (Map) map, runningAppProcessInfo, i);
        aa.m4750a(c0970e, f, i2, z, i, j2, j3);
        aa.m4753a(c0970e, a2);
    }

    private static void m4761a(C0970e c0970e, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C0965b c0965b, C0965b c0965b2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        c0970e.m4833g(3, 2);
        c0970e.m4835k(aa.m4748a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c0965b, c0965b2, (Map) map, runningAppProcessInfo, i2));
        aa.m4760a(c0970e, th, thread, stackTraceElementArr, threadArr, list, i, c0965b, c0965b2);
        if (!(map == null || map.isEmpty())) {
            aa.m4762a(c0970e, (Map) map);
        }
        if (runningAppProcessInfo != null) {
            c0970e.m4819a(3, runningAppProcessInfo.importance != 100);
        }
        c0970e.m4816a(4, i2);
    }

    private static void m4760a(C0970e c0970e, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C0965b c0965b, C0965b c0965b2) {
        c0970e.m4833g(1, 2);
        c0970e.m4835k(aa.m4747a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c0965b, c0965b2));
        aa.m4758a(c0970e, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            aa.m4758a(c0970e, threadArr[i2], (StackTraceElement[]) list.get(i2), 0, false);
        }
        aa.m4759a(c0970e, th, 1, i, 2);
        c0970e.m4833g(3, 2);
        c0970e.m4835k(aa.m4734a());
        c0970e.m4818a(1, f2630a);
        c0970e.m4818a(2, f2630a);
        c0970e.m4817a(3, 0);
        c0970e.m4833g(4, 2);
        c0970e.m4835k(aa.m4740a(c0965b, c0965b2));
        c0970e.m4817a(1, 0);
        c0970e.m4817a(2, 0);
        c0970e.m4818a(3, c0965b);
        if (c0965b2 != null) {
            c0970e.m4818a(4, c0965b2);
        }
    }

    private static void m4762a(C0970e c0970e, Map<String, String> map) {
        for (Entry entry : map.entrySet()) {
            c0970e.m4833g(2, 2);
            c0970e.m4835k(aa.m4744a((String) entry.getKey(), (String) entry.getValue()));
            c0970e.m4818a(1, C0965b.m4779a((String) entry.getKey()));
            String str = (String) entry.getValue();
            if (str == null) {
                str = "";
            }
            c0970e.m4818a(2, C0965b.m4779a(str));
        }
    }

    private static void m4759a(C0970e c0970e, Throwable th, int i, int i2, int i3) {
        int i4 = 0;
        c0970e.m4833g(i3, 2);
        c0970e.m4835k(aa.m4746a(th, 1, i2));
        c0970e.m4818a(1, C0965b.m4779a(th.getClass().getName()));
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            c0970e.m4818a(3, C0965b.m4779a(localizedMessage));
        }
        for (StackTraceElement a : th.getStackTrace()) {
            aa.m4751a(c0970e, 4, a, true);
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return;
        }
        if (i < i2) {
            aa.m4759a(c0970e, cause, i + 1, i2, 6);
            return;
        }
        while (cause != null) {
            cause = cause.getCause();
            i4++;
        }
        c0970e.m4816a(7, i4);
    }

    private static void m4758a(C0970e c0970e, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        c0970e.m4833g(1, 2);
        c0970e.m4835k(aa.m4745a(thread, stackTraceElementArr, i, z));
        c0970e.m4818a(1, C0965b.m4779a(thread.getName()));
        c0970e.m4816a(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            aa.m4751a(c0970e, 3, a, z);
        }
    }

    private static void m4751a(C0970e c0970e, int i, StackTraceElement stackTraceElement, boolean z) {
        int i2 = 4;
        c0970e.m4833g(i, 2);
        c0970e.m4835k(aa.m4743a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            c0970e.m4817a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            c0970e.m4817a(1, 0);
        }
        c0970e.m4818a(2, C0965b.m4779a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            c0970e.m4818a(3, C0965b.m4779a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            c0970e.m4817a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        c0970e.m4816a(5, i2);
    }

    private static void m4750a(C0970e c0970e, float f, int i, boolean z, int i2, long j, long j2) {
        c0970e.m4833g(5, 2);
        c0970e.m4835k(aa.m4735a(f, i, z, i2, j, j2));
        c0970e.m4815a(1, f);
        c0970e.m4829c(2, i);
        c0970e.m4819a(3, z);
        c0970e.m4816a(4, i2);
        c0970e.m4817a(5, j);
        c0970e.m4817a(6, j2);
    }

    private static void m4753a(C0970e c0970e, C0965b c0965b) {
        if (c0965b != null) {
            c0970e.m4833g(6, 2);
            c0970e.m4835k(aa.m4764b(c0965b));
            c0970e.m4818a(1, c0965b);
        }
    }

    private static int m4741a(C0965b c0965b, C0965b c0965b2, C0965b c0965b3, C0965b c0965b4, C0965b c0965b5, int i, C0965b c0965b6) {
        int b = ((0 + C0970e.m4796b(1, c0965b)) + C0970e.m4796b(2, c0965b3)) + C0970e.m4796b(3, c0965b4);
        int a = aa.m4739a(c0965b2);
        b = (b + (a + (C0970e.m4809j(5) + C0970e.m4810l(a)))) + C0970e.m4796b(6, c0965b5);
        if (c0965b6 != null) {
            b = (b + C0970e.m4796b(8, f2631b)) + C0970e.m4796b(9, c0965b6);
        }
        return b + C0970e.m4804e(10, i);
    }

    private static int m4739a(C0965b c0965b) {
        return 0 + C0970e.m4796b(1, c0965b);
    }

    private static int m4742a(C0965b c0965b, C0965b c0965b2, boolean z) {
        return (((0 + C0970e.m4804e(1, 3)) + C0970e.m4796b(2, c0965b)) + C0970e.m4796b(3, c0965b2)) + C0970e.m4797b(4, z);
    }

    private static int m4738a(C0032a c0032a, String str) {
        return C0970e.m4804e(1, c0032a.f63h) + C0970e.m4796b(2, C0965b.m4779a(str));
    }

    private static int m4736a(int i, C0965b c0965b, C0965b c0965b2, int i2, long j, long j2, boolean z, Map<C0032a, String> map, int i3, C0965b c0965b3, C0965b c0965b4) {
        int i4;
        int i5;
        int e = C0970e.m4804e(3, i) + (0 + C0970e.m4796b(1, c0965b));
        if (c0965b2 == null) {
            i4 = 0;
        } else {
            i4 = C0970e.m4796b(4, c0965b2);
        }
        i4 = ((((i4 + e) + C0970e.m4801d(5, i2)) + C0970e.m4795b(6, j)) + C0970e.m4795b(7, j2)) + C0970e.m4797b(10, z);
        if (map != null) {
            i5 = i4;
            for (Entry entry : map.entrySet()) {
                i4 = aa.m4738a((C0032a) entry.getKey(), (String) entry.getValue());
                i5 = (i4 + (C0970e.m4809j(11) + C0970e.m4810l(i4))) + i5;
            }
        } else {
            i5 = i4;
        }
        return (c0965b4 == null ? 0 : C0970e.m4796b(14, c0965b4)) + ((i5 + C0970e.m4801d(12, i3)) + (c0965b3 == null ? 0 : C0970e.m4796b(13, c0965b3)));
    }

    private static int m4740a(C0965b c0965b, C0965b c0965b2) {
        int b = ((0 + C0970e.m4795b(1, 0)) + C0970e.m4795b(2, 0)) + C0970e.m4796b(3, c0965b);
        if (c0965b2 != null) {
            return b + C0970e.m4796b(4, c0965b2);
        }
        return b;
    }

    private static int m4737a(long j, String str, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2, C0965b c0965b, C0965b c0965b2, float f, int i3, boolean z, long j2, long j3, C0965b c0965b3) {
        int b = (0 + C0970e.m4795b(1, j)) + C0970e.m4796b(2, C0965b.m4779a(str));
        int a = aa.m4748a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c0965b, c0965b2, (Map) map, runningAppProcessInfo, i2);
        int j4 = b + (a + (C0970e.m4809j(3) + C0970e.m4810l(a)));
        a = aa.m4735a(f, i3, z, i2, j2, j3);
        a = (a + (C0970e.m4809j(5) + C0970e.m4810l(a))) + j4;
        if (c0965b3 == null) {
            return a;
        }
        int b2 = aa.m4764b(c0965b3);
        return a + (b2 + (C0970e.m4809j(6) + C0970e.m4810l(b2)));
    }

    private static int m4748a(Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C0965b c0965b, C0965b c0965b2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int a = aa.m4747a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c0965b, c0965b2);
        int j = 0 + (a + (C0970e.m4809j(1) + C0970e.m4810l(a)));
        if (map != null) {
            int i3 = j;
            for (Entry entry : map.entrySet()) {
                j = aa.m4744a((String) entry.getKey(), (String) entry.getValue());
                i3 = (j + (C0970e.m4809j(2) + C0970e.m4810l(j))) + i3;
            }
            a = i3;
        } else {
            a = j;
        }
        if (runningAppProcessInfo != null) {
            j = C0970e.m4797b(3, runningAppProcessInfo.importance != 100) + a;
        } else {
            j = a;
        }
        return j + C0970e.m4801d(4, i2);
    }

    private static int m4747a(Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C0965b c0965b, C0965b c0965b2) {
        int a;
        int a2 = aa.m4745a(thread, stackTraceElementArr, 4, true);
        a2 = (a2 + (C0970e.m4809j(1) + C0970e.m4810l(a2))) + 0;
        int length = threadArr.length;
        int i2 = a2;
        for (a2 = 0; a2 < length; a2++) {
            a = aa.m4745a(threadArr[a2], (StackTraceElement[]) list.get(a2), 0, false);
            i2 += a + (C0970e.m4809j(1) + C0970e.m4810l(a));
        }
        a = aa.m4746a(th, 1, i);
        a = (a + (C0970e.m4809j(2) + C0970e.m4810l(a))) + i2;
        a2 = aa.m4734a();
        a += a2 + (C0970e.m4809j(3) + C0970e.m4810l(a2));
        a2 = aa.m4740a(c0965b, c0965b2);
        return a + (a2 + (C0970e.m4809j(3) + C0970e.m4810l(a2)));
    }

    private static int m4744a(String str, String str2) {
        int b = C0970e.m4796b(1, C0965b.m4779a(str));
        if (str2 == null) {
            str2 = "";
        }
        return b + C0970e.m4796b(2, C0965b.m4779a(str2));
    }

    private static int m4735a(float f, int i, boolean z, int i2, long j, long j2) {
        return (((((0 + C0970e.m4794b(1, f)) + C0970e.m4806f(2, i)) + C0970e.m4797b(3, z)) + C0970e.m4801d(4, i2)) + C0970e.m4795b(5, j)) + C0970e.m4795b(6, j2);
    }

    private static int m4764b(C0965b c0965b) {
        return C0970e.m4796b(1, c0965b);
    }

    private static int m4746a(Throwable th, int i, int i2) {
        int i3 = 0;
        int b = C0970e.m4796b(1, C0965b.m4779a(th.getClass().getName())) + 0;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            b += C0970e.m4796b(3, C0965b.m4779a(localizedMessage));
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i4 = 0;
        while (i4 < length) {
            int a = aa.m4743a(stackTrace[i4], true);
            i4++;
            b = (a + (C0970e.m4809j(4) + C0970e.m4810l(a))) + b;
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return b;
        }
        if (i < i2) {
            i3 = aa.m4746a(cause, i + 1, i2);
            return b + (i3 + (C0970e.m4809j(6) + C0970e.m4810l(i3)));
        }
        while (cause != null) {
            cause = cause.getCause();
            i3++;
        }
        return b + C0970e.m4801d(7, i3);
    }

    private static int m4734a() {
        return ((0 + C0970e.m4796b(1, f2630a)) + C0970e.m4796b(2, f2630a)) + C0970e.m4795b(3, 0);
    }

    private static int m4743a(StackTraceElement stackTraceElement, boolean z) {
        int b;
        int i;
        if (stackTraceElement.isNativeMethod()) {
            b = C0970e.m4795b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            b = C0970e.m4795b(1, 0) + 0;
        }
        b += C0970e.m4796b(2, C0965b.m4779a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            b += C0970e.m4796b(3, C0965b.m4779a(stackTraceElement.getFileName()));
        }
        if (stackTraceElement.isNativeMethod() || stackTraceElement.getLineNumber() <= 0) {
            i = b;
        } else {
            i = b + C0970e.m4795b(4, (long) stackTraceElement.getLineNumber());
        }
        return C0970e.m4801d(5, z ? 2 : 0) + i;
    }

    private static int m4745a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int d = C0970e.m4801d(2, i) + C0970e.m4796b(1, C0965b.m4779a(thread.getName()));
        for (StackTraceElement a : stackTraceElementArr) {
            int a2 = aa.m4743a(a, z);
            d += a2 + (C0970e.m4809j(3) + C0970e.m4810l(a2));
        }
        return d;
    }

    private static C0965b m4749a(String str) {
        return str == null ? null : C0965b.m4779a(str);
    }
}
