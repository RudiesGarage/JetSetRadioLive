package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p022e.C0323c;
import android.support.v4.view.al.C0530a;
import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* compiled from: ViewCompat */
public class ae {
    static final C0518l f1108a;

    /* compiled from: ViewCompat */
    interface C0518l {
        int mo359a(int i, int i2, int i3);

        av mo360a(View view, av avVar);

        void mo361a(View view, float f);

        void mo362a(View view, int i, Paint paint);

        void mo363a(View view, ColorStateList colorStateList);

        void mo364a(View view, Mode mode);

        void mo365a(View view, Drawable drawable);

        void mo366a(View view, C0454a c0454a);

        void mo367a(View view, C0448y c0448y);

        void mo368a(View view, Runnable runnable);

        void mo369a(View view, Runnable runnable, long j);

        void mo370a(View view, boolean z);

        boolean mo371a(View view);

        boolean mo372a(View view, int i);

        av mo373b(View view, av avVar);

        void mo374b(View view, float f);

        void mo375b(View view, boolean z);

        boolean mo376b(View view);

        boolean mo377b(View view, int i);

        void mo378c(View view);

        void mo379c(View view, float f);

        void mo380c(View view, int i);

        int mo381d(View view);

        float mo382e(View view);

        int mo383f(View view);

        int mo384g(View view);

        int mo385h(View view);

        int mo386i(View view);

        boolean mo387j(View view);

        float mo388k(View view);

        float mo389l(View view);

        int mo390m(View view);

        int mo391n(View view);

        aq mo392o(View view);

        int mo393p(View view);

        void mo394q(View view);

        void mo395r(View view);

        ColorStateList mo396s(View view);

        Mode mo397t(View view);

        void mo398u(View view);

        boolean mo399v(View view);

        boolean mo400w(View view);
    }

    /* compiled from: ViewCompat */
    static class C0519b implements C0518l {
        WeakHashMap<View, aq> f1103a = null;

        C0519b() {
        }

        public boolean mo372a(View view, int i) {
            return (view instanceof aa) && m2110a((aa) view, i);
        }

        public boolean mo377b(View view, int i) {
            return (view instanceof aa) && m2111b((aa) view, i);
        }

        public void mo366a(View view, C0454a c0454a) {
        }

        public boolean mo371a(View view) {
            return false;
        }

        public boolean mo376b(View view) {
            return false;
        }

        public void mo378c(View view) {
            view.invalidate();
        }

        public void mo368a(View view, Runnable runnable) {
            view.postDelayed(runnable, mo401a());
        }

        public void mo369a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, mo401a() + j);
        }

        long mo401a() {
            return 10;
        }

        public int mo381d(View view) {
            return 0;
        }

        public void mo380c(View view, int i) {
        }

        public float mo382e(View view) {
            return 1.0f;
        }

        public void mo362a(View view, int i, Paint paint) {
        }

        public int mo383f(View view) {
            return 0;
        }

        public int mo384g(View view) {
            return 0;
        }

        public int mo359a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public int mo385h(View view) {
            return view.getMeasuredWidth();
        }

        public int mo386i(View view) {
            return 0;
        }

        public boolean mo387j(View view) {
            return true;
        }

        public float mo388k(View view) {
            return 0.0f;
        }

        public float mo389l(View view) {
            return 0.0f;
        }

        public int mo390m(View view) {
            return af.m2250d(view);
        }

        public int mo391n(View view) {
            return af.m2251e(view);
        }

        public aq mo392o(View view) {
            return new aq(view);
        }

        public void mo361a(View view, float f) {
        }

        public void mo374b(View view, float f) {
        }

        public void mo379c(View view, float f) {
        }

        public int mo393p(View view) {
            return 0;
        }

        public void mo394q(View view) {
        }

        public void mo395r(View view) {
        }

        public void mo367a(View view, C0448y c0448y) {
        }

        public av mo360a(View view, av avVar) {
            return avVar;
        }

        public av mo373b(View view, av avVar) {
            return avVar;
        }

        public void mo370a(View view, boolean z) {
        }

        public void mo375b(View view, boolean z) {
        }

        public void mo365a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        public ColorStateList mo396s(View view) {
            return af.m2245a(view);
        }

        public void mo363a(View view, ColorStateList colorStateList) {
            af.m2246a(view, colorStateList);
        }

        public void mo364a(View view, Mode mode) {
            af.m2247a(view, mode);
        }

        public Mode mo397t(View view) {
            return af.m2248b(view);
        }

        private boolean m2110a(aa aaVar, int i) {
            int computeHorizontalScrollOffset = aaVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = aaVar.computeHorizontalScrollRange() - aaVar.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeHorizontalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeHorizontalScrollOffset >= computeHorizontalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        private boolean m2111b(aa aaVar, int i) {
            int computeVerticalScrollOffset = aaVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = aaVar.computeVerticalScrollRange() - aaVar.computeVerticalScrollExtent();
            if (computeVerticalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeVerticalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeVerticalScrollOffset >= computeVerticalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        public void mo398u(View view) {
            if (view instanceof C0603u) {
                ((C0603u) view).stopNestedScroll();
            }
        }

        public boolean mo399v(View view) {
            return af.m2249c(view);
        }

        public boolean mo400w(View view) {
            return af.m2252f(view);
        }
    }

    /* compiled from: ViewCompat */
    static class C0520c extends C0519b {
        C0520c() {
        }

        long mo401a() {
            return ag.m2255a();
        }

        public float mo382e(View view) {
            return ag.m2253a(view);
        }

        public void mo362a(View view, int i, Paint paint) {
            ag.m2257a(view, i, paint);
        }

        public int mo383f(View view) {
            return ag.m2259b(view);
        }

        public int mo359a(int i, int i2, int i3) {
            return ag.m2254a(i, i2, i3);
        }

        public int mo385h(View view) {
            return ag.m2262c(view);
        }

        public int mo386i(View view) {
            return ag.m2264d(view);
        }

        public float mo388k(View view) {
            return ag.m2265e(view);
        }

        public float mo389l(View view) {
            return ag.m2266f(view);
        }

        public void mo361a(View view, float f) {
            ag.m2256a(view, f);
        }

        public void mo374b(View view, float f) {
            ag.m2260b(view, f);
        }

        public void mo379c(View view, float f) {
            ag.m2263c(view, f);
        }

        public void mo395r(View view) {
            ag.m2267g(view);
        }

        public void mo370a(View view, boolean z) {
            ag.m2258a(view, z);
        }

        public void mo375b(View view, boolean z) {
            ag.m2261b(view, z);
        }
    }

    /* compiled from: ViewCompat */
    static class C0521e extends C0520c {
        static Field f1104b;
        static boolean f1105c = false;

        C0521e() {
        }

        public boolean mo372a(View view, int i) {
            return ah.m2269a(view, i);
        }

        public boolean mo377b(View view, int i) {
            return ah.m2270b(view, i);
        }

        public void mo366a(View view, C0454a c0454a) {
            Object obj;
            if (c0454a == null) {
                obj = null;
            } else {
                obj = c0454a.m1725a();
            }
            ah.m2268a(view, obj);
        }

        public boolean mo371a(View view) {
            boolean z = true;
            if (f1105c) {
                return false;
            }
            if (f1104b == null) {
                try {
                    f1104b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f1104b.setAccessible(true);
                } catch (Throwable th) {
                    f1105c = true;
                    return false;
                }
            }
            try {
                if (f1104b.get(view) == null) {
                    z = false;
                }
                return z;
            } catch (Throwable th2) {
                f1105c = true;
                return false;
            }
        }

        public aq mo392o(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            aq aqVar = (aq) this.a.get(view);
            if (aqVar != null) {
                return aqVar;
            }
            aqVar = new aq(view);
            this.a.put(view, aqVar);
            return aqVar;
        }
    }

    /* compiled from: ViewCompat */
    static class C0522d extends C0521e {
        C0522d() {
        }
    }

    /* compiled from: ViewCompat */
    static class C0523f extends C0522d {
        C0523f() {
        }

        public boolean mo376b(View view) {
            return ai.m2275a(view);
        }

        public void mo378c(View view) {
            ai.m2276b(view);
        }

        public void mo368a(View view, Runnable runnable) {
            ai.m2273a(view, runnable);
        }

        public void mo369a(View view, Runnable runnable, long j) {
            ai.m2274a(view, runnable, j);
        }

        public int mo381d(View view) {
            return ai.m2277c(view);
        }

        public void mo380c(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            ai.m2271a(view, i);
        }

        public int mo390m(View view) {
            return ai.m2278d(view);
        }

        public int mo391n(View view) {
            return ai.m2279e(view);
        }

        public void mo394q(View view) {
            ai.m2280f(view);
        }

        public boolean mo387j(View view) {
            return ai.m2281g(view);
        }

        public void mo365a(View view, Drawable drawable) {
            ai.m2272a(view, drawable);
        }
    }

    /* compiled from: ViewCompat */
    static class C0524g extends C0523f {
        C0524g() {
        }

        public int mo384g(View view) {
            return aj.m2282a(view);
        }

        public int mo393p(View view) {
            return aj.m2283b(view);
        }
    }

    /* compiled from: ViewCompat */
    static class C0525h extends C0524g {
        C0525h() {
        }
    }

    /* compiled from: ViewCompat */
    static class C0526i extends C0525h {
        C0526i() {
        }

        public void mo380c(View view, int i) {
            ai.m2271a(view, i);
        }

        public boolean mo399v(View view) {
            return ak.m2284a(view);
        }

        public boolean mo400w(View view) {
            return ak.m2285b(view);
        }
    }

    /* compiled from: ViewCompat */
    static class C0527j extends C0526i {
        C0527j() {
        }

        public void mo394q(View view) {
            al.m2287a(view);
        }

        public void mo367a(View view, final C0448y c0448y) {
            if (c0448y == null) {
                al.m2290a(view, null);
            } else {
                al.m2290a(view, new C0530a(this) {
                    final /* synthetic */ C0527j f1107b;

                    public Object mo402a(View view, Object obj) {
                        return av.m2405a(c0448y.mo282a(view, av.m2404a(obj)));
                    }
                });
            }
        }

        public void mo398u(View view) {
            al.m2294d(view);
        }

        public ColorStateList mo396s(View view) {
            return al.m2291b(view);
        }

        public void mo363a(View view, ColorStateList colorStateList) {
            al.m2288a(view, colorStateList);
        }

        public void mo364a(View view, Mode mode) {
            al.m2289a(view, mode);
        }

        public Mode mo397t(View view) {
            return al.m2293c(view);
        }

        public av mo360a(View view, av avVar) {
            return av.m2404a(al.m2286a(view, av.m2405a(avVar)));
        }

        public av mo373b(View view, av avVar) {
            return av.m2404a(al.m2292b(view, av.m2405a(avVar)));
        }
    }

    /* compiled from: ViewCompat */
    static class C0528k extends C0527j {
        C0528k() {
        }
    }

    /* compiled from: ViewCompat */
    static class C0529a extends C0528k {
        C0529a() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (C0323c.m1195a()) {
            f1108a = new C0529a();
        } else if (i >= 23) {
            f1108a = new C0528k();
        } else if (i >= 21) {
            f1108a = new C0527j();
        } else if (i >= 19) {
            f1108a = new C0526i();
        } else if (i >= 18) {
            f1108a = new C0525h();
        } else if (i >= 17) {
            f1108a = new C0524g();
        } else if (i >= 16) {
            f1108a = new C0523f();
        } else if (i >= 15) {
            f1108a = new C0522d();
        } else if (i >= 14) {
            f1108a = new C0521e();
        } else if (i >= 11) {
            f1108a = new C0520c();
        } else {
            f1108a = new C0519b();
        }
    }

    public static boolean m2215a(View view, int i) {
        return f1108a.mo372a(view, i);
    }

    public static boolean m2220b(View view, int i) {
        return f1108a.mo377b(view, i);
    }

    @Deprecated
    public static int m2203a(View view) {
        return view.getOverScrollMode();
    }

    public static void m2210a(View view, C0454a c0454a) {
        f1108a.mo366a(view, c0454a);
    }

    public static boolean m2219b(View view) {
        return f1108a.mo371a(view);
    }

    public static boolean m2223c(View view) {
        return f1108a.mo376b(view);
    }

    public static void m2224d(View view) {
        f1108a.mo378c(view);
    }

    public static void m2212a(View view, Runnable runnable) {
        f1108a.mo368a(view, runnable);
    }

    public static void m2213a(View view, Runnable runnable, long j) {
        f1108a.mo369a(view, runnable, j);
    }

    public static int m2225e(View view) {
        return f1108a.mo381d(view);
    }

    public static void m2222c(View view, int i) {
        f1108a.mo380c(view, i);
    }

    public static float m2226f(View view) {
        return f1108a.mo382e(view);
    }

    public static void m2206a(View view, int i, Paint paint) {
        f1108a.mo362a(view, i, paint);
    }

    public static int m2227g(View view) {
        return f1108a.mo383f(view);
    }

    public static int m2228h(View view) {
        return f1108a.mo384g(view);
    }

    public static int m2202a(int i, int i2, int i3) {
        return f1108a.mo359a(i, i2, i3);
    }

    public static int m2229i(View view) {
        return f1108a.mo385h(view);
    }

    public static int m2230j(View view) {
        return f1108a.mo386i(view);
    }

    public static float m2231k(View view) {
        return f1108a.mo388k(view);
    }

    public static float m2232l(View view) {
        return f1108a.mo389l(view);
    }

    public static int m2233m(View view) {
        return f1108a.mo390m(view);
    }

    public static int m2234n(View view) {
        return f1108a.mo391n(view);
    }

    public static aq m2235o(View view) {
        return f1108a.mo392o(view);
    }

    public static void m2205a(View view, float f) {
        f1108a.mo361a(view, f);
    }

    public static void m2217b(View view, float f) {
        f1108a.mo374b(view, f);
    }

    public static void m2221c(View view, float f) {
        f1108a.mo379c(view, f);
    }

    public static int m2236p(View view) {
        return f1108a.mo393p(view);
    }

    public static void m2237q(View view) {
        f1108a.mo394q(view);
    }

    public static void m2238r(View view) {
        f1108a.mo395r(view);
    }

    public static void m2211a(View view, C0448y c0448y) {
        f1108a.mo367a(view, c0448y);
    }

    public static av m2204a(View view, av avVar) {
        return f1108a.mo360a(view, avVar);
    }

    public static av m2216b(View view, av avVar) {
        return f1108a.mo373b(view, avVar);
    }

    public static void m2214a(View view, boolean z) {
        f1108a.mo370a(view, z);
    }

    public static void m2218b(View view, boolean z) {
        f1108a.mo375b(view, z);
    }

    public static boolean m2239s(View view) {
        return f1108a.mo387j(view);
    }

    public static void m2209a(View view, Drawable drawable) {
        f1108a.mo365a(view, drawable);
    }

    public static ColorStateList m2240t(View view) {
        return f1108a.mo396s(view);
    }

    public static void m2207a(View view, ColorStateList colorStateList) {
        f1108a.mo363a(view, colorStateList);
    }

    public static Mode m2241u(View view) {
        return f1108a.mo397t(view);
    }

    public static void m2208a(View view, Mode mode) {
        f1108a.mo364a(view, mode);
    }

    public static void m2242v(View view) {
        f1108a.mo398u(view);
    }

    public static boolean m2243w(View view) {
        return f1108a.mo399v(view);
    }

    public static boolean m2244x(View view) {
        return f1108a.mo400w(view);
    }
}
