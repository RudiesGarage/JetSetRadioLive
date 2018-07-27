package android.support.v7.widget;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.view.C0601s;
import android.support.v7.view.menu.C0719q;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: ForwardingListener */
public abstract class C0702x implements OnTouchListener {
    private final float f1354a;
    private final int f1355b;
    final View f1356c;
    private final int f1357d;
    private Runnable f1358e;
    private Runnable f1359f;
    private boolean f1360g;
    private int f1361h;
    private final int[] f1362i = new int[2];

    /* compiled from: ForwardingListener */
    class C09031 implements OnAttachStateChangeListener {
        final /* synthetic */ C0702x f2450a;

        C09031(C0702x c0702x) {
            this.f2450a = c0702x;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.f2450a.m2881e();
        }
    }

    /* compiled from: ForwardingListener */
    class C09042 implements OnGlobalLayoutListener {
        boolean f2451a = this.f2452b.f1356c.isAttachedToWindow();
        final /* synthetic */ C0702x f2452b;

        C09042(C0702x c0702x) {
            this.f2452b = c0702x;
        }

        public void onGlobalLayout() {
            boolean z = this.f2451a;
            this.f2451a = this.f2452b.f1356c.isAttachedToWindow();
            if (z && !this.f2451a) {
                this.f2452b.m2881e();
            }
        }
    }

    /* compiled from: ForwardingListener */
    private class C0905a implements Runnable {
        final /* synthetic */ C0702x f2453a;

        C0905a(C0702x c0702x) {
            this.f2453a = c0702x;
        }

        public void run() {
            ViewParent parent = this.f2453a.f1356c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener */
    private class C0906b implements Runnable {
        final /* synthetic */ C0702x f2454a;

        C0906b(C0702x c0702x) {
            this.f2454a = c0702x;
        }

        public void run() {
            this.f2454a.m2886d();
        }
    }

    public abstract C0719q mo485a();

    public C0702x(View view) {
        this.f1356c = view;
        view.setLongClickable(true);
        if (VERSION.SDK_INT >= 12) {
            m2874a(view);
        } else {
            m2878b(view);
        }
        this.f1354a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1355b = ViewConfiguration.getTapTimeout();
        this.f1357d = (this.f1355b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void m2874a(View view) {
        view.addOnAttachStateChangeListener(new C09031(this));
    }

    private void m2878b(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new C09042(this));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1360g;
        if (!z2) {
            boolean z3 = m2875a(motionEvent) && mo486b();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1356c.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        } else if (m2879b(motionEvent) || !mo684c()) {
            z = true;
        } else {
            z = false;
        }
        this.f1360g = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    private void m2881e() {
        this.f1360g = false;
        this.f1361h = -1;
        if (this.f1358e != null) {
            this.f1356c.removeCallbacks(this.f1358e);
        }
    }

    protected boolean mo486b() {
        C0719q a = mo485a();
        if (!(a == null || a.mo528d())) {
            a.mo518a();
        }
        return true;
    }

    protected boolean mo684c() {
        C0719q a = mo485a();
        if (a != null && a.mo528d()) {
            a.mo525c();
        }
        return true;
    }

    private boolean m2875a(MotionEvent motionEvent) {
        View view = this.f1356c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (C0601s.m2508a(motionEvent)) {
            case 0:
                this.f1361h = motionEvent.getPointerId(0);
                if (this.f1358e == null) {
                    this.f1358e = new C0905a(this);
                }
                view.postDelayed(this.f1358e, (long) this.f1355b);
                if (this.f1359f == null) {
                    this.f1359f = new C0906b(this);
                }
                view.postDelayed(this.f1359f, (long) this.f1357d);
                return false;
            case 1:
            case 3:
                m2882f();
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1361h);
                if (findPointerIndex < 0 || C0702x.m2876a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1354a)) {
                    return false;
                }
                m2882f();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private void m2882f() {
        if (this.f1359f != null) {
            this.f1356c.removeCallbacks(this.f1359f);
        }
        if (this.f1358e != null) {
            this.f1356c.removeCallbacks(this.f1358e);
        }
    }

    void m2886d() {
        m2882f();
        View view = this.f1356c;
        if (view.isEnabled() && !view.isLongClickable() && mo486b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1360g = true;
        }
    }

    private boolean m2879b(MotionEvent motionEvent) {
        View view = this.f1356c;
        C0719q a = mo485a();
        if (a == null || !a.mo528d()) {
            return false;
        }
        C0834v c0834v = (C0834v) a.mo529e();
        if (c0834v == null || !c0834v.isShown()) {
            return false;
        }
        boolean z;
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m2880b(view, obtainNoHistory);
        m2877a(c0834v, obtainNoHistory);
        boolean a2 = c0834v.mo646a(obtainNoHistory, this.f1361h);
        obtainNoHistory.recycle();
        int a3 = C0601s.m2508a(motionEvent);
        if (a3 == 1 || a3 == 3) {
            z = false;
        } else {
            z = true;
        }
        if (a2 && r0) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private static boolean m2876a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean m2877a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1362i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean m2880b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1362i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }
}
