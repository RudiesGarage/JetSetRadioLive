package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.C0601s;
import android.support.v4.view.ae;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: AutoScrollHelper */
public abstract class C0612a implements OnTouchListener {
    private static final int f1194r = ViewConfiguration.getTapTimeout();
    final C0610a f1195a = new C0610a();
    final View f1196b;
    boolean f1197c;
    boolean f1198d;
    boolean f1199e;
    private final Interpolator f1200f = new AccelerateInterpolator();
    private Runnable f1201g;
    private float[] f1202h = new float[]{0.0f, 0.0f};
    private float[] f1203i = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int f1204j;
    private int f1205k;
    private float[] f1206l = new float[]{0.0f, 0.0f};
    private float[] f1207m = new float[]{0.0f, 0.0f};
    private float[] f1208n = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean f1209o;
    private boolean f1210p;
    private boolean f1211q;

    /* compiled from: AutoScrollHelper */
    private static class C0610a {
        private int f1182a;
        private int f1183b;
        private float f1184c;
        private float f1185d;
        private long f1186e = Long.MIN_VALUE;
        private long f1187f = 0;
        private int f1188g = 0;
        private int f1189h = 0;
        private long f1190i = -1;
        private float f1191j;
        private int f1192k;

        C0610a() {
        }

        public void m2568a(int i) {
            this.f1182a = i;
        }

        public void m2570b(int i) {
            this.f1183b = i;
        }

        public void m2566a() {
            this.f1186e = AnimationUtils.currentAnimationTimeMillis();
            this.f1190i = -1;
            this.f1187f = this.f1186e;
            this.f1191j = 0.5f;
            this.f1188g = 0;
            this.f1189h = 0;
        }

        public void m2569b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1192k = C0612a.m2580a((int) (currentAnimationTimeMillis - this.f1186e), 0, this.f1183b);
            this.f1191j = m2565a(currentAnimationTimeMillis);
            this.f1190i = currentAnimationTimeMillis;
        }

        public boolean m2571c() {
            return this.f1190i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1190i + ((long) this.f1192k);
        }

        private float m2565a(long j) {
            if (j < this.f1186e) {
                return 0.0f;
            }
            if (this.f1190i < 0 || j < this.f1190i) {
                return C0612a.m2577a(((float) (j - this.f1186e)) / ((float) this.f1182a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f1190i;
            return (C0612a.m2577a(((float) j2) / ((float) this.f1192k), 0.0f, 1.0f) * this.f1191j) + (1.0f - this.f1191j);
        }

        private float m2564a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        public void m2572d() {
            if (this.f1187f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m2564a(m2565a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f1187f;
            this.f1187f = currentAnimationTimeMillis;
            this.f1188g = (int) ((((float) j) * a) * this.f1184c);
            this.f1189h = (int) ((((float) j) * a) * this.f1185d);
        }

        public void m2567a(float f, float f2) {
            this.f1184c = f;
            this.f1185d = f2;
        }

        public int m2573e() {
            return (int) (this.f1184c / Math.abs(this.f1184c));
        }

        public int m2574f() {
            return (int) (this.f1185d / Math.abs(this.f1185d));
        }

        public int m2575g() {
            return this.f1188g;
        }

        public int m2576h() {
            return this.f1189h;
        }
    }

    /* compiled from: AutoScrollHelper */
    private class C0611b implements Runnable {
        final /* synthetic */ C0612a f1193a;

        C0611b(C0612a c0612a) {
            this.f1193a = c0612a;
        }

        public void run() {
            if (this.f1193a.f1199e) {
                if (this.f1193a.f1197c) {
                    this.f1193a.f1197c = false;
                    this.f1193a.f1195a.m2566a();
                }
                C0610a c0610a = this.f1193a.f1195a;
                if (c0610a.m2571c() || !this.f1193a.m2588a()) {
                    this.f1193a.f1199e = false;
                    return;
                }
                if (this.f1193a.f1198d) {
                    this.f1193a.f1198d = false;
                    this.f1193a.m2591b();
                }
                c0610a.m2572d();
                this.f1193a.mo466a(c0610a.m2575g(), c0610a.m2576h());
                ae.m2212a(this.f1193a.f1196b, (Runnable) this);
            }
        }
    }

    public abstract void mo466a(int i, int i2);

    public abstract boolean mo467e(int i);

    public abstract boolean mo468f(int i);

    public C0612a(View view) {
        this.f1196b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m2584a((float) i, (float) i);
        m2589b((float) i2, (float) i2);
        m2585a(1);
        m2596e(Float.MAX_VALUE, Float.MAX_VALUE);
        m2594d(0.2f, 0.2f);
        m2592c(1.0f, 1.0f);
        m2590b(f1194r);
        m2593c(500);
        m2595d(500);
    }

    public C0612a m2586a(boolean z) {
        if (this.f1210p && !z) {
            m2582d();
        }
        this.f1210p = z;
        return this;
    }

    public C0612a m2584a(float f, float f2) {
        this.f1208n[0] = f / 1000.0f;
        this.f1208n[1] = f2 / 1000.0f;
        return this;
    }

    public C0612a m2589b(float f, float f2) {
        this.f1207m[0] = f / 1000.0f;
        this.f1207m[1] = f2 / 1000.0f;
        return this;
    }

    public C0612a m2592c(float f, float f2) {
        this.f1206l[0] = f / 1000.0f;
        this.f1206l[1] = f2 / 1000.0f;
        return this;
    }

    public C0612a m2585a(int i) {
        this.f1204j = i;
        return this;
    }

    public C0612a m2594d(float f, float f2) {
        this.f1202h[0] = f;
        this.f1202h[1] = f2;
        return this;
    }

    public C0612a m2596e(float f, float f2) {
        this.f1203i[0] = f;
        this.f1203i[1] = f2;
        return this;
    }

    public C0612a m2590b(int i) {
        this.f1205k = i;
        return this;
    }

    public C0612a m2593c(int i) {
        this.f1195a.m2568a(i);
        return this;
    }

    public C0612a m2595d(int i) {
        this.f1195a.m2570b(i);
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1210p) {
            return false;
        }
        switch (C0601s.m2508a(motionEvent)) {
            case 0:
                this.f1198d = true;
                this.f1209o = false;
                break;
            case 1:
            case 3:
                m2582d();
                break;
            case 2:
                break;
        }
        this.f1195a.m2567a(m2579a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1196b.getWidth()), m2579a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1196b.getHeight()));
        if (!this.f1199e && m2588a()) {
            m2581c();
        }
        if (!(this.f1211q && this.f1199e)) {
            z = false;
        }
        return z;
    }

    boolean m2588a() {
        C0610a c0610a = this.f1195a;
        int f = c0610a.m2574f();
        int e = c0610a.m2573e();
        return (f != 0 && mo468f(f)) || (e != 0 && mo467e(e));
    }

    private void m2581c() {
        if (this.f1201g == null) {
            this.f1201g = new C0611b(this);
        }
        this.f1199e = true;
        this.f1197c = true;
        if (this.f1209o || this.f1205k <= 0) {
            this.f1201g.run();
        } else {
            ae.m2213a(this.f1196b, this.f1201g, (long) this.f1205k);
        }
        this.f1209o = true;
    }

    private void m2582d() {
        if (this.f1197c) {
            this.f1199e = false;
        } else {
            this.f1195a.m2569b();
        }
    }

    private float m2579a(int i, float f, float f2, float f3) {
        float a = m2578a(this.f1202h[i], f2, this.f1203i[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f1206l[i];
        float f5 = this.f1207m[i];
        float f6 = this.f1208n[i];
        f4 *= f3;
        if (a > 0.0f) {
            return C0612a.m2577a(a * f4, f5, f6);
        }
        return -C0612a.m2577a((-a) * f4, f5, f6);
    }

    private float m2578a(float f, float f2, float f3, float f4) {
        float f5;
        float a = C0612a.m2577a(f * f2, 0.0f, f3);
        a = m2583f(f2 - f4, a) - m2583f(f4, a);
        if (a < 0.0f) {
            f5 = -this.f1200f.getInterpolation(-a);
        } else if (a <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f1200f.getInterpolation(a);
        }
        return C0612a.m2577a(f5, -1.0f, 1.0f);
    }

    private float m2583f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f1204j) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f1199e && this.f1204j == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    static int m2580a(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    static float m2577a(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    void m2591b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1196b.onTouchEvent(obtain);
        obtain.recycle();
    }
}
