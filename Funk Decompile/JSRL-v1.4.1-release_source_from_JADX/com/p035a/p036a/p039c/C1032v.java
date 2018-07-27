package com.p035a.p036a.p039c;

import com.p035a.p036a.p039c.p040a.p041a.C0955a;
import com.p035a.p036a.p039c.p040a.p041a.C0956b;
import com.p035a.p036a.p039c.p040a.p041a.C0957c;
import com.p035a.p036a.p039c.p040a.p041a.C0958d;
import com.p035a.p036a.p039c.p040a.p041a.C0959e;
import com.p035a.p036a.p039c.p040a.p041a.C0961f;
import com.p035a.p036a.p039c.p040a.p041a.C0961f.C0960a;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import p000a.p001a.p002a.p003a.C0142c;

/* compiled from: NativeCrashWriter */
class C1032v {
    private static final C0959e f2788a = new C0959e("", "", 0);
    private static final C1019j[] f2789b = new C1019j[0];
    private static final C1031m[] f2790c = new C1031m[0];
    private static final C1026g[] f2791d = new C1026g[0];
    private static final C1021b[] f2792e = new C1021b[0];
    private static final C1022c[] f2793f = new C1022c[0];

    /* compiled from: NativeCrashWriter */
    private static abstract class C1019j {
        private final int f2760a;
        private final C1019j[] f2761b;

        public C1019j(int i, C1019j... c1019jArr) {
            this.f2760a = i;
            if (c1019jArr == null) {
                c1019jArr = C1032v.f2789b;
            }
            this.f2761b = c1019jArr;
        }

        public int mo748b() {
            int c = m5011c();
            return (c + C0970e.m4810l(c)) + C0970e.m4809j(this.f2760a);
        }

        public int m5011c() {
            int a = mo745a();
            for (C1019j b : this.f2761b) {
                a += b.mo748b();
            }
            return a;
        }

        public void mo747b(C0970e c0970e) {
            c0970e.m4833g(this.f2760a, 2);
            c0970e.m4835k(m5011c());
            mo746a(c0970e);
            for (C1019j b : this.f2761b) {
                b.mo747b(c0970e);
            }
        }

        public int mo745a() {
            return 0;
        }

        public void mo746a(C0970e c0970e) {
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1020a extends C1019j {
        public C1020a(C1025f c1025f, C1029k c1029k) {
            super(3, c1025f, c1029k);
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1021b extends C1019j {
        private final long f2762a;
        private final long f2763b;
        private final String f2764c;
        private final String f2765d;

        public C1021b(C0955a c0955a) {
            super(4, new C1019j[0]);
            this.f2762a = c0955a.f2597a;
            this.f2763b = c0955a.f2598b;
            this.f2764c = c0955a.f2599c;
            this.f2765d = c0955a.f2600d;
        }

        public int mo745a() {
            int b = C0970e.m4795b(1, this.f2762a);
            return ((b + C0970e.m4796b(3, C0965b.m4779a(this.f2764c))) + C0970e.m4795b(2, this.f2763b)) + C0970e.m4796b(4, C0965b.m4779a(this.f2765d));
        }

        public void mo746a(C0970e c0970e) {
            c0970e.m4817a(1, this.f2762a);
            c0970e.m4817a(2, this.f2763b);
            c0970e.m4818a(3, C0965b.m4779a(this.f2764c));
            c0970e.m4818a(4, C0965b.m4779a(this.f2765d));
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1022c extends C1019j {
        private final String f2766a;
        private final String f2767b;

        public C1022c(C0956b c0956b) {
            super(2, new C1019j[0]);
            this.f2766a = c0956b.f2601a;
            this.f2767b = c0956b.f2602b;
        }

        public int mo745a() {
            return C0970e.m4796b(2, C0965b.m4779a(this.f2767b == null ? "" : this.f2767b)) + C0970e.m4796b(1, C0965b.m4779a(this.f2766a));
        }

        public void mo746a(C0970e c0970e) {
            c0970e.m4818a(1, C0965b.m4779a(this.f2766a));
            c0970e.m4818a(2, C0965b.m4779a(this.f2767b == null ? "" : this.f2767b));
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1023d extends C1019j {
        private final float f2768a;
        private final int f2769b;
        private final boolean f2770c;
        private final int f2771d;
        private final long f2772e;
        private final long f2773f;

        public C1023d(float f, int i, boolean z, int i2, long j, long j2) {
            super(5, new C1019j[0]);
            this.f2768a = f;
            this.f2769b = i;
            this.f2770c = z;
            this.f2771d = i2;
            this.f2772e = j;
            this.f2773f = j2;
        }

        public int mo745a() {
            return (((((0 + C0970e.m4794b(1, this.f2768a)) + C0970e.m4806f(2, this.f2769b)) + C0970e.m4797b(3, this.f2770c)) + C0970e.m4801d(4, this.f2771d)) + C0970e.m4795b(5, this.f2772e)) + C0970e.m4795b(6, this.f2773f);
        }

        public void mo746a(C0970e c0970e) {
            c0970e.m4815a(1, this.f2768a);
            c0970e.m4829c(2, this.f2769b);
            c0970e.m4819a(3, this.f2770c);
            c0970e.m4816a(4, this.f2771d);
            c0970e.m4817a(5, this.f2772e);
            c0970e.m4817a(6, this.f2773f);
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1024e extends C1019j {
        private final long f2774a;
        private final String f2775b;

        public C1024e(long j, String str, C1019j... c1019jArr) {
            super(10, c1019jArr);
            this.f2774a = j;
            this.f2775b = str;
        }

        public int mo745a() {
            return C0970e.m4795b(1, this.f2774a) + C0970e.m4796b(2, C0965b.m4779a(this.f2775b));
        }

        public void mo746a(C0970e c0970e) {
            c0970e.m4817a(1, this.f2774a);
            c0970e.m4818a(2, C0965b.m4779a(this.f2775b));
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1025f extends C1019j {
        public C1025f(C1030l c1030l, C1029k c1029k, C1029k c1029k2) {
            super(1, c1029k, c1030l, c1029k2);
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1026g extends C1019j {
        private final long f2776a;
        private final String f2777b;
        private final String f2778c;
        private final long f2779d;
        private final int f2780e;

        public C1026g(C0960a c0960a) {
            super(3, new C1019j[0]);
            this.f2776a = c0960a.f2620a;
            this.f2777b = c0960a.f2621b;
            this.f2778c = c0960a.f2622c;
            this.f2779d = c0960a.f2623d;
            this.f2780e = c0960a.f2624e;
        }

        public int mo745a() {
            return (((C0970e.m4795b(1, this.f2776a) + C0970e.m4796b(2, C0965b.m4779a(this.f2777b))) + C0970e.m4796b(3, C0965b.m4779a(this.f2778c))) + C0970e.m4795b(4, this.f2779d)) + C0970e.m4801d(5, this.f2780e);
        }

        public void mo746a(C0970e c0970e) {
            c0970e.m4817a(1, this.f2776a);
            c0970e.m4818a(2, C0965b.m4779a(this.f2777b));
            c0970e.m4818a(3, C0965b.m4779a(this.f2778c));
            c0970e.m4817a(4, this.f2779d);
            c0970e.m4816a(5, this.f2780e);
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1027h extends C1019j {
        C0965b f2781a;

        public C1027h(C0965b c0965b) {
            super(6, new C1019j[0]);
            this.f2781a = c0965b;
        }

        public int mo745a() {
            return C0970e.m4796b(1, this.f2781a);
        }

        public void mo746a(C0970e c0970e) {
            c0970e.m4818a(1, this.f2781a);
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1028i extends C1019j {
        public C1028i() {
            super(0, new C1019j[0]);
        }

        public void mo747b(C0970e c0970e) {
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1029k extends C1019j {
        private final C1019j[] f2782a;

        public C1029k(C1019j... c1019jArr) {
            super(0, new C1019j[0]);
            this.f2782a = c1019jArr;
        }

        public void mo747b(C0970e c0970e) {
            for (C1019j b : this.f2782a) {
                b.mo747b(c0970e);
            }
        }

        public int mo748b() {
            int i = 0;
            C1019j[] c1019jArr = this.f2782a;
            int i2 = 0;
            while (i < c1019jArr.length) {
                i2 += c1019jArr[i].mo748b();
                i++;
            }
            return i2;
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1030l extends C1019j {
        private final String f2783a;
        private final String f2784b;
        private final long f2785c;

        public C1030l(C0959e c0959e) {
            super(3, new C1019j[0]);
            this.f2783a = c0959e.f2617a;
            this.f2784b = c0959e.f2618b;
            this.f2785c = c0959e.f2619c;
        }

        public int mo745a() {
            return (C0970e.m4796b(1, C0965b.m4779a(this.f2783a)) + C0970e.m4796b(2, C0965b.m4779a(this.f2784b))) + C0970e.m4795b(3, this.f2785c);
        }

        public void mo746a(C0970e c0970e) {
            c0970e.m4818a(1, C0965b.m4779a(this.f2783a));
            c0970e.m4818a(2, C0965b.m4779a(this.f2784b));
            c0970e.m4817a(3, this.f2785c);
        }
    }

    /* compiled from: NativeCrashWriter */
    private static final class C1031m extends C1019j {
        private final String f2786a;
        private final int f2787b;

        public C1031m(C0961f c0961f, C1029k c1029k) {
            super(1, c1029k);
            this.f2786a = c0961f.f2625a;
            this.f2787b = c0961f.f2626b;
        }

        public int mo745a() {
            return (m5029d() ? C0970e.m4796b(1, C0965b.m4779a(this.f2786a)) : 0) + C0970e.m4801d(2, this.f2787b);
        }

        public void mo746a(C0970e c0970e) {
            if (m5029d()) {
                c0970e.m4818a(1, C0965b.m4779a(this.f2786a));
            }
            c0970e.m4816a(2, this.f2787b);
        }

        private boolean m5029d() {
            return this.f2786a != null && this.f2786a.length() > 0;
        }
    }

    private static C1024e m5033a(C0958d c0958d, C1016s c1016s, Map<String, String> map) {
        C1020a c1020a = new C1020a(new C1025f(new C1030l(c0958d.f2612b != null ? c0958d.f2612b : f2788a), C1032v.m5037a(c0958d.f2613c), C1032v.m5034a(c0958d.f2614d)), C1032v.m5035a(C1032v.m5039a(c0958d.f2615e, map)));
        C1023d a = C1032v.m5032a(c0958d.f2616f);
        C0965b a2 = c1016s.m4994a();
        if (a2 == null) {
            C0142c.m468h().mo46a("CrashlyticsCore", "No log data to include with this event.");
        }
        c1016s.m4998b();
        C1027h c1027h = a2 != null ? new C1027h(a2) : new C1028i();
        return new C1024e(c0958d.f2611a, "ndk-crash", c1020a, a, c1027h);
    }

    private static C0956b[] m5039a(C0956b[] c0956bArr, Map<String, String> map) {
        int i;
        Map treeMap = new TreeMap(map);
        if (c0956bArr != null) {
            for (C0956b c0956b : c0956bArr) {
                treeMap.put(c0956b.f2601a, c0956b.f2602b);
            }
        }
        Entry[] entryArr = (Entry[]) treeMap.entrySet().toArray(new Entry[treeMap.size()]);
        C0956b[] c0956bArr2 = new C0956b[entryArr.length];
        for (i = 0; i < c0956bArr2.length; i++) {
            c0956bArr2[i] = new C0956b((String) entryArr[i].getKey(), (String) entryArr[i].getValue());
        }
        return c0956bArr2;
    }

    private static C1023d m5032a(C0957c c0957c) {
        return new C1023d(((float) c0957c.f2608f) / 100.0f, c0957c.f2609g, c0957c.f2610h, c0957c.f2603a, c0957c.f2604b - c0957c.f2606d, c0957c.f2605c - c0957c.f2607e);
    }

    private static C1029k m5037a(C0961f[] c0961fArr) {
        C1019j[] c1019jArr = c0961fArr != null ? new C1031m[c0961fArr.length] : f2790c;
        for (int i = 0; i < c1019jArr.length; i++) {
            C0961f c0961f = c0961fArr[i];
            c1019jArr[i] = new C1031m(c0961f, C1032v.m5036a(c0961f.f2627c));
        }
        return new C1029k(c1019jArr);
    }

    private static C1029k m5036a(C0960a[] c0960aArr) {
        C1019j[] c1019jArr = c0960aArr != null ? new C1026g[c0960aArr.length] : f2791d;
        for (int i = 0; i < c1019jArr.length; i++) {
            c1019jArr[i] = new C1026g(c0960aArr[i]);
        }
        return new C1029k(c1019jArr);
    }

    private static C1029k m5034a(C0955a[] c0955aArr) {
        C1019j[] c1019jArr = c0955aArr != null ? new C1021b[c0955aArr.length] : f2792e;
        for (int i = 0; i < c1019jArr.length; i++) {
            c1019jArr[i] = new C1021b(c0955aArr[i]);
        }
        return new C1029k(c1019jArr);
    }

    private static C1029k m5035a(C0956b[] c0956bArr) {
        C1019j[] c1019jArr = c0956bArr != null ? new C1022c[c0956bArr.length] : f2793f;
        for (int i = 0; i < c1019jArr.length; i++) {
            c1019jArr[i] = new C1022c(c0956bArr[i]);
        }
        return new C1029k(c1019jArr);
    }

    public static void m5038a(C0958d c0958d, C1016s c1016s, Map<String, String> map, C0970e c0970e) {
        C1032v.m5033a(c0958d, c1016s, map).mo747b(c0970e);
    }
}
