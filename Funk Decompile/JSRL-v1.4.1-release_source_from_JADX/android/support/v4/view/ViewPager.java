package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p018b.C0185a;
import android.support.v4.p022e.C0325d;
import android.support.v4.p022e.C0326e;
import android.support.v4.view.p025a.C0474a;
import android.support.v4.view.p025a.C0489c;
import android.support.v4.view.p025a.C0512k;
import android.support.v4.widget.C0622d;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    static final int[] f1034a = new int[]{16842931};
    private static final C0460i aj = new C0460i();
    private static final Comparator<C0452b> f1035e = new C04451();
    private static final Interpolator f1036f = new C04462();
    private int f1037A = 1;
    private boolean f1038B;
    private boolean f1039C;
    private int f1040D;
    private int f1041E;
    private int f1042F;
    private float f1043G;
    private float f1044H;
    private float f1045I;
    private float f1046J;
    private int f1047K = -1;
    private VelocityTracker f1048L;
    private int f1049M;
    private int f1050N;
    private int f1051O;
    private int f1052P;
    private boolean f1053Q;
    private C0622d f1054R;
    private C0622d f1055S;
    private boolean f1056T = true;
    private boolean f1057U = false;
    private boolean f1058V;
    private int f1059W;
    private List<C0457f> aa;
    private C0457f ab;
    private C0457f ac;
    private List<C0456e> ad;
    private C0458g ae;
    private int af;
    private Method ag;
    private int ah;
    private ArrayList<View> ai;
    private final Runnable ak = new C04473(this);
    private int al = 0;
    C0236z f1060b;
    int f1061c;
    private int f1062d;
    private final ArrayList<C0452b> f1063g = new ArrayList();
    private final C0452b f1064h = new C0452b();
    private final Rect f1065i = new Rect();
    private int f1066j = -1;
    private Parcelable f1067k = null;
    private ClassLoader f1068l = null;
    private Scroller f1069m;
    private boolean f1070n;
    private C0459h f1071o;
    private int f1072p;
    private Drawable f1073q;
    private int f1074r;
    private int f1075s;
    private float f1076t = -3.4028235E38f;
    private float f1077u = Float.MAX_VALUE;
    private int f1078v;
    private int f1079w;
    private boolean f1080x;
    private boolean f1081y;
    private boolean f1082z;

    static class C04451 implements Comparator<C0452b> {
        C04451() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1717a((C0452b) obj, (C0452b) obj2);
        }

        public int m1717a(C0452b c0452b, C0452b c0452b2) {
            return c0452b.f1019b - c0452b2.f1019b;
        }
    }

    static class C04462 implements Interpolator {
        C04462() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C04473 implements Runnable {
        final /* synthetic */ ViewPager f1012a;

        C04473(ViewPager viewPager) {
            this.f1012a = viewPager;
        }

        public void run() {
            this.f1012a.setScrollState(0);
            this.f1012a.m1781c();
        }
    }

    class C04494 implements C0448y {
        final /* synthetic */ ViewPager f1013a;
        private final Rect f1014b = new Rect();

        C04494(ViewPager viewPager) {
            this.f1013a = viewPager;
        }

        public av mo282a(View view, av avVar) {
            av a = ae.m2204a(view, avVar);
            if (a.m2411e()) {
                return a;
            }
            Rect rect = this.f1014b;
            rect.left = a.m2406a();
            rect.top = a.m2408b();
            rect.right = a.m2409c();
            rect.bottom = a.m2410d();
            int childCount = this.f1013a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                av b = ae.m2216b(this.f1013a.getChildAt(i), a);
                rect.left = Math.min(b.m2406a(), rect.left);
                rect.top = Math.min(b.m2408b(), rect.top);
                rect.right = Math.min(b.m2409c(), rect.right);
                rect.bottom = Math.min(b.m2410d(), rect.bottom);
            }
            return a.m2407a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = C0325d.m1196a(new C04501());
        int f1015b;
        Parcelable f1016c;
        ClassLoader f1017d;

        static class C04501 implements C0326e<SavedState> {
            C04501() {
            }

            public /* synthetic */ Object mo280a(Parcel parcel, ClassLoader classLoader) {
                return m1722b(parcel, classLoader);
            }

            public /* synthetic */ Object[] mo281a(int i) {
                return m1723b(i);
            }

            public SavedState m1722b(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m1723b(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1015b);
            parcel.writeParcelable(this.f1016c, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1015b + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f1015b = parcel.readInt();
            this.f1016c = parcel.readParcelable(classLoader);
            this.f1017d = classLoader;
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface C0451a {
    }

    static class C0452b {
        Object f1018a;
        int f1019b;
        boolean f1020c;
        float f1021d;
        float f1022e;

        C0452b() {
        }
    }

    public static class C0453c extends LayoutParams {
        public boolean f1023a;
        public int f1024b;
        float f1025c = 0.0f;
        boolean f1026d;
        int f1027e;
        int f1028f;

        public C0453c() {
            super(-1, -1);
        }

        public C0453c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f1034a);
            this.f1024b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    class C0455d extends C0454a {
        final /* synthetic */ ViewPager f1032b;

        C0455d(ViewPager viewPager) {
            this.f1032b = viewPager;
        }

        public void mo286d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo286d(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            C0512k a = C0474a.m1857a(accessibilityEvent);
            a.m2043a(m1734b());
            if (accessibilityEvent.getEventType() == 4096 && this.f1032b.f1060b != null) {
                a.m2042a(this.f1032b.f1060b.mo873b());
                a.m2044b(this.f1032b.f1061c);
                a.m2045c(this.f1032b.f1061c);
            }
        }

        public void mo284a(View view, C0489c c0489c) {
            super.mo284a(view, c0489c);
            c0489c.m1945a(ViewPager.class.getName());
            c0489c.m1947a(m1734b());
            if (this.f1032b.canScrollHorizontally(1)) {
                c0489c.m1943a(4096);
            }
            if (this.f1032b.canScrollHorizontally(-1)) {
                c0489c.m1943a(8192);
            }
        }

        public boolean mo285a(View view, int i, Bundle bundle) {
            if (super.mo285a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.f1032b.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.f1032b.setCurrentItem(this.f1032b.f1061c + 1);
                    return true;
                case 8192:
                    if (!this.f1032b.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.f1032b.setCurrentItem(this.f1032b.f1061c - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean m1734b() {
            return this.f1032b.f1060b != null && this.f1032b.f1060b.mo873b() > 1;
        }
    }

    public interface C0456e {
        void m1738a(ViewPager viewPager, C0236z c0236z, C0236z c0236z2);
    }

    public interface C0457f {
        void mo869a(int i);

        void mo870a(int i, float f, int i2);

        void mo871b(int i);
    }

    public interface C0458g {
        void m1742a(View view, float f);
    }

    private class C0459h extends DataSetObserver {
        final /* synthetic */ ViewPager f1033a;

        C0459h(ViewPager viewPager) {
            this.f1033a = viewPager;
        }

        public void onChanged() {
            this.f1033a.m1780b();
        }

        public void onInvalidated() {
            this.f1033a.m1780b();
        }
    }

    static class C0460i implements Comparator<View> {
        C0460i() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1743a((View) obj, (View) obj2);
        }

        public int m1743a(View view, View view2) {
            C0453c c0453c = (C0453c) view.getLayoutParams();
            C0453c c0453c2 = (C0453c) view2.getLayoutParams();
            if (c0453c.f1023a != c0453c2.f1023a) {
                return c0453c.f1023a ? 1 : -1;
            } else {
                return c0453c.f1027e - c0453c2.f1027e;
            }
        }
    }

    public ViewPager(Context context) {
        super(context);
        m1768a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1768a();
    }

    void m1768a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f1069m = new Scroller(context, f1036f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1042F = viewConfiguration.getScaledPagingTouchSlop();
        this.f1049M = (int) (400.0f * f);
        this.f1050N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1054R = new C0622d(context);
        this.f1055S = new C0622d(context);
        this.f1051O = (int) (25.0f * f);
        this.f1052P = (int) (2.0f * f);
        this.f1040D = (int) (16.0f * f);
        ae.m2210a((View) this, new C0455d(this));
        if (ae.m2225e(this) == 0) {
            ae.m2222c((View) this, 1);
        }
        ae.m2211a((View) this, new C04494(this));
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ak);
        if (!(this.f1069m == null || this.f1069m.isFinished())) {
            this.f1069m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.al != i) {
            this.al = i;
            if (this.ae != null) {
                m1753b(i != 0);
            }
            m1760f(i);
        }
    }

    public void setAdapter(C0236z c0236z) {
        int i = false;
        if (this.f1060b != null) {
            this.f1060b.m905a(null);
            this.f1060b.mo152a((ViewGroup) this);
            for (int i2 = 0; i2 < this.f1063g.size(); i2++) {
                C0452b c0452b = (C0452b) this.f1063g.get(i2);
                this.f1060b.mo153a((ViewGroup) this, c0452b.f1019b, c0452b.f1018a);
            }
            this.f1060b.mo155b((ViewGroup) this);
            this.f1063g.clear();
            m1759f();
            this.f1061c = 0;
            scrollTo(0, 0);
        }
        C0236z c0236z2 = this.f1060b;
        this.f1060b = c0236z;
        this.f1062d = 0;
        if (this.f1060b != null) {
            if (this.f1071o == null) {
                this.f1071o = new C0459h(this);
            }
            this.f1060b.m905a(this.f1071o);
            this.f1082z = false;
            boolean z = this.f1056T;
            this.f1056T = true;
            this.f1062d = this.f1060b.mo873b();
            if (this.f1066j >= 0) {
                this.f1060b.mo151a(this.f1067k, this.f1068l);
                m1773a(this.f1066j, false, true);
                this.f1066j = -1;
                this.f1067k = null;
                this.f1068l = null;
            } else if (z) {
                requestLayout();
            } else {
                m1781c();
            }
        }
        if (this.ad != null && !this.ad.isEmpty()) {
            int size = this.ad.size();
            while (i < size) {
                ((C0456e) this.ad.get(i)).m1738a(this, c0236z2, c0236z);
                i++;
            }
        }
    }

    private void m1759f() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0453c) getChildAt(i).getLayoutParams()).f1023a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public C0236z getAdapter() {
        return this.f1060b;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.f1082z = false;
        if (this.f1056T) {
            z = false;
        } else {
            z = true;
        }
        m1773a(i, z, false);
    }

    public void m1772a(int i, boolean z) {
        this.f1082z = false;
        m1773a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f1061c;
    }

    void m1773a(int i, boolean z, boolean z2) {
        m1774a(i, z, z2, 0);
    }

    void m1774a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f1060b == null || this.f1060b.mo873b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f1061c != i || this.f1063g.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f1060b.mo873b()) {
                i = this.f1060b.mo873b() - 1;
            }
            int i3 = this.f1037A;
            if (i > this.f1061c + i3 || i < this.f1061c - i3) {
                for (int i4 = 0; i4 < this.f1063g.size(); i4++) {
                    ((C0452b) this.f1063g.get(i4)).f1020c = true;
                }
            }
            if (this.f1061c != i) {
                z3 = true;
            }
            if (this.f1056T) {
                this.f1061c = i;
                if (z3) {
                    m1758e(i);
                }
                requestLayout();
                return;
            }
            m1769a(i);
            m1747a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void m1747a(int i, boolean z, int i2, boolean z2) {
        int max;
        C0452b b = m1778b(i);
        if (b != null) {
            max = (int) (Math.max(this.f1076t, Math.min(b.f1022e, this.f1077u)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m1771a(max, 0, i2);
            if (z2) {
                m1758e(i);
                return;
            }
            return;
        }
        if (z2) {
            m1758e(i);
        }
        m1750a(false);
        scrollTo(max, 0);
        m1757d(max);
    }

    @Deprecated
    public void setOnPageChangeListener(C0457f c0457f) {
        this.ab = c0457f;
    }

    public void m1775a(C0457f c0457f) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(c0457f);
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ag == null) {
                try {
                    this.ag = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ag.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ah == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0453c) ((View) this.ai.get(i2)).getLayoutParams()).f1028f;
    }

    public int getOffscreenPageLimit() {
        return this.f1037A;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f1037A) {
            this.f1037A = i;
            m1781c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f1072p;
        this.f1072p = i;
        int width = getWidth();
        m1746a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f1072p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f1073q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(C0185a.m612a(getContext(), i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1073q;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1073q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float m1765a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void m1771a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int i4;
        boolean z = (this.f1069m == null || this.f1069m.isFinished()) ? false : true;
        if (z) {
            int currX = this.f1070n ? this.f1069m.getCurrX() : this.f1069m.getStartX();
            this.f1069m.abortAnimation();
            setScrollingCacheEnabled(false);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m1750a(false);
            m1781c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        currX = getClientWidth();
        int i7 = currX / 2;
        float a = (((float) i7) * m1765a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        if (abs > 0) {
            currX = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            currX = (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.f1060b.m912b(this.f1061c)) + ((float) this.f1072p))) + 1.0f) * 100.0f);
        }
        i7 = Math.min(currX, 600);
        this.f1070n = false;
        this.f1069m.startScroll(i4, scrollY, i5, i6, i7);
        ae.m2224d(this);
    }

    C0452b m1766a(int i, int i2) {
        C0452b c0452b = new C0452b();
        c0452b.f1019b = i;
        c0452b.f1018a = this.f1060b.mo150a((ViewGroup) this, i);
        c0452b.f1021d = this.f1060b.m912b(i);
        if (i2 < 0 || i2 >= this.f1063g.size()) {
            this.f1063g.add(c0452b);
        } else {
            this.f1063g.add(i2, c0452b);
        }
        return c0452b;
    }

    void m1780b() {
        boolean z;
        int b = this.f1060b.mo873b();
        this.f1062d = b;
        if (this.f1063g.size() >= (this.f1037A * 2) + 1 || this.f1063g.size() >= b) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = false;
        int i = this.f1061c;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f1063g.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            C0452b c0452b = (C0452b) this.f1063g.get(i2);
            int a = this.f1060b.m901a(c0452b.f1018a);
            if (a == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a == -2) {
                this.f1063g.remove(i2);
                i2--;
                if (!z2) {
                    this.f1060b.mo152a((ViewGroup) this);
                    z2 = true;
                }
                this.f1060b.mo153a((ViewGroup) this, c0452b.f1019b, c0452b.f1018a);
                if (this.f1061c == c0452b.f1019b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f1061c, b - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (c0452b.f1019b != a) {
                if (c0452b.f1019b == this.f1061c) {
                    i = a;
                }
                c0452b.f1019b = a;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f1060b.mo155b((ViewGroup) this);
        }
        Collections.sort(this.f1063g, f1035e);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                C0453c c0453c = (C0453c) getChildAt(i2).getLayoutParams();
                if (!c0453c.f1023a) {
                    c0453c.f1025c = 0.0f;
                }
            }
            m1773a(i, false, true);
            requestLayout();
        }
    }

    void m1781c() {
        m1769a(this.f1061c);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1769a(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.f1061c;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.f1061c;
        r0 = r17;
        r2 = r0.m1778b(r2);
        r0 = r18;
        r1 = r17;
        r1.f1061c = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.f1060b;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.m1761g();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.f1082z;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.m1761g();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.f1060b;
        r0 = r17;
        r2.mo152a(r0);
        r0 = r17;
        r2 = r0.f1037A;
        r4 = 0;
        r0 = r17;
        r5 = r0.f1061c;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.f1060b;
        r11 = r4.mo873b();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.f1061c;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.f1062d;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.f1062d;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.f1060b;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0452b) r2;
        r6 = r2.f1019b;
        r0 = r17;
        r7 = r0.f1061c;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.f1019b;
        r0 = r17;
        r7 = r0.f1061c;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.f1061c;
        r0 = r17;
        r2 = r0.m1766a(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.C0452b) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.f1061c;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.f1021d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.C0452b) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.f1061c;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.m1748a(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.f1060b;
        r0 = r17;
        r4 = r0.f1061c;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.f1018a;
    L_0x0179:
        r0 = r17;
        r3.mo156b(r0, r4, r2);
        r0 = r17;
        r2 = r0.f1060b;
        r0 = r17;
        r2.mo155b(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.C0453c) r2;
        r2.f1028f = r3;
        r6 = r2.f1023a;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.f1025c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.m1767a(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.f1021d;
        r2.f1025c = r6;
        r5 = r5.f1019b;
        r2.f1027e = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.f1021d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.f1019b;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.f1020c;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.f1063g;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.f1060b;
        r2 = r2.f1018a;
        r0 = r17;
        r14.mo153a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0452b) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.f1019b;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.f1021d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0452b) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.m1766a(r8, r2);
        r2 = r2.f1021d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0452b) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.f1019b;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.f1020c;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.f1063g;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.f1060b;
        r2 = r2.f1018a;
        r0 = r17;
        r10.mo153a(r0, r8, r2);
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0452b) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.f1019b;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.f1021d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0452b) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.m1766a(r8, r6);
        r6 = r6 + 1;
        r2 = r2.f1021d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.f1063g;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0452b) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.m1761g();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.m1779b(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.f1019b;
        r0 = r17;
        r3 = r0.f1061c;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.m1767a(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.f1019b;
        r0 = r17;
        r5 = r0.f1061c;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    private void m1761g() {
        if (this.ah != 0) {
            if (this.ai == null) {
                this.ai = new ArrayList();
            } else {
                this.ai.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ai.add(getChildAt(i));
            }
            Collections.sort(this.ai, aj);
        }
    }

    private void m1748a(C0452b c0452b, int i, C0452b c0452b2) {
        float f;
        float f2;
        int i2;
        C0452b c0452b3;
        int i3;
        int b = this.f1060b.mo873b();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.f1072p) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (c0452b2 != null) {
            clientWidth = c0452b2.f1019b;
            int i4;
            if (clientWidth < c0452b.f1019b) {
                f2 = (c0452b2.f1022e + c0452b2.f1021d) + f;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= c0452b.f1019b && i2 < this.f1063g.size()) {
                    c0452b3 = (C0452b) this.f1063g.get(i2);
                    while (i4 > c0452b3.f1019b && i2 < this.f1063g.size() - 1) {
                        i2++;
                        c0452b3 = (C0452b) this.f1063g.get(i2);
                    }
                    while (i4 < c0452b3.f1019b) {
                        f2 += this.f1060b.m912b(i4) + f;
                        i4++;
                    }
                    c0452b3.f1022e = f2;
                    f2 += c0452b3.f1021d + f;
                    i4++;
                }
            } else if (clientWidth > c0452b.f1019b) {
                i2 = this.f1063g.size() - 1;
                f2 = c0452b2.f1022e;
                i4 = clientWidth - 1;
                while (i4 >= c0452b.f1019b && i2 >= 0) {
                    c0452b3 = (C0452b) this.f1063g.get(i2);
                    while (i4 < c0452b3.f1019b && i2 > 0) {
                        i2--;
                        c0452b3 = (C0452b) this.f1063g.get(i2);
                    }
                    while (i4 > c0452b3.f1019b) {
                        f2 -= this.f1060b.m912b(i4) + f;
                        i4--;
                    }
                    f2 -= c0452b3.f1021d + f;
                    c0452b3.f1022e = f2;
                    i4--;
                }
            }
        }
        int size = this.f1063g.size();
        float f3 = c0452b.f1022e;
        i2 = c0452b.f1019b - 1;
        this.f1076t = c0452b.f1019b == 0 ? c0452b.f1022e : -3.4028235E38f;
        this.f1077u = c0452b.f1019b == b + -1 ? (c0452b.f1022e + c0452b.f1021d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            c0452b3 = (C0452b) this.f1063g.get(i3);
            f2 = f3;
            while (i2 > c0452b3.f1019b) {
                f2 -= this.f1060b.m912b(i2) + f;
                i2--;
            }
            f3 = f2 - (c0452b3.f1021d + f);
            c0452b3.f1022e = f3;
            if (c0452b3.f1019b == 0) {
                this.f1076t = f3;
            }
            i2--;
        }
        f3 = (c0452b.f1022e + c0452b.f1021d) + f;
        i2 = c0452b.f1019b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            c0452b3 = (C0452b) this.f1063g.get(i3);
            f2 = f3;
            while (i2 < c0452b3.f1019b) {
                f2 = (this.f1060b.m912b(i2) + f) + f2;
                i2++;
            }
            if (c0452b3.f1019b == b - 1) {
                this.f1077u = (c0452b3.f1021d + f2) - 1.0f;
            }
            c0452b3.f1022e = f2;
            f3 = f2 + (c0452b3.f1021d + f);
            i2++;
        }
        this.f1057U = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1015b = this.f1061c;
        if (this.f1060b != null) {
            savedState.f1016c = this.f1060b.mo149a();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.m1712a());
            if (this.f1060b != null) {
                this.f1060b.mo151a(savedState.f1016c, savedState.f1017d);
                m1773a(savedState.f1015b, false, true);
                return;
            }
            this.f1066j = savedState.f1015b;
            this.f1067k = savedState.f1016c;
            this.f1068l = savedState.f1017d;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        C0453c c0453c = (C0453c) layoutParams2;
        c0453c.f1023a |= m1756c(view);
        if (!this.f1080x) {
            super.addView(view, i, layoutParams2);
        } else if (c0453c == null || !c0453c.f1023a) {
            c0453c.f1026d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private static boolean m1756c(View view) {
        return view.getClass().getAnnotation(C0451a.class) != null;
    }

    public void removeView(View view) {
        if (this.f1080x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    C0452b m1767a(View view) {
        for (int i = 0; i < this.f1063g.size(); i++) {
            C0452b c0452b = (C0452b) this.f1063g.get(i);
            if (this.f1060b.mo154a(view, c0452b.f1018a)) {
                return c0452b;
            }
        }
        return null;
    }

    C0452b m1779b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m1767a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    C0452b m1778b(int i) {
        for (int i2 = 0; i2 < this.f1063g.size(); i2++) {
            C0452b c0452b = (C0452b) this.f1063g.get(i2);
            if (c0452b.f1019b == i) {
                return c0452b;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1056T = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f1041E = Math.min(measuredWidth / 10, this.f1040D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            C0453c c0453c;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                c0453c = (C0453c) childAt.getLayoutParams();
                if (c0453c != null && c0453c.f1023a) {
                    int i6 = c0453c.f1024b & 7;
                    int i7 = c0453c.f1024b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (c0453c.width != -2) {
                        i7 = 1073741824;
                        i3 = c0453c.width != -1 ? c0453c.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (c0453c.height != -2) {
                        i5 = 1073741824;
                        if (c0453c.height != -1) {
                            measuredWidth = c0453c.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f1078v = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f1079w = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f1080x = true;
        m1781c();
        this.f1080x = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                c0453c = (C0453c) childAt2.getLayoutParams();
                if (c0453c == null || !c0453c.f1023a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0453c.f1025c * ((float) paddingLeft)), 1073741824), this.f1079w);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m1746a(i, i3, this.f1072p, this.f1072p);
        }
    }

    private void m1746a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f1063g.isEmpty()) {
            C0452b b = m1778b(this.f1061c);
            int min = (int) ((b != null ? Math.min(b.f1022e, this.f1077u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m1750a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.f1069m.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.f1069m.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            C0453c c0453c;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c0453c = (C0453c) childAt.getLayoutParams();
                if (c0453c.f1023a) {
                    int i9 = c0453c.f1024b & 112;
                    switch (c0453c.f1024b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                c0453c = (C0453c) childAt2.getLayoutParams();
                if (!c0453c.f1023a) {
                    C0452b a = m1767a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f1022e * ((float) max))) + paddingLeft;
                        if (c0453c.f1026d) {
                            c0453c.f1026d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0453c.f1025c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f1074r = paddingTop;
        this.f1075s = i6 - paddingBottom;
        this.f1059W = i7;
        if (this.f1056T) {
            m1747a(this.f1061c, false, 0, false);
        }
        this.f1056T = false;
    }

    public void computeScroll() {
        this.f1070n = true;
        if (this.f1069m.isFinished() || !this.f1069m.computeScrollOffset()) {
            m1750a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f1069m.getCurrX();
        int currY = this.f1069m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m1757d(currX)) {
                this.f1069m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ae.m2224d(this);
    }

    private boolean m1757d(int i) {
        if (this.f1063g.size() != 0) {
            C0452b i2 = m1763i();
            int clientWidth = getClientWidth();
            int i3 = this.f1072p + clientWidth;
            float f = ((float) this.f1072p) / ((float) clientWidth);
            int i4 = i2.f1019b;
            float f2 = ((((float) i) / ((float) clientWidth)) - i2.f1022e) / (i2.f1021d + f);
            clientWidth = (int) (((float) i3) * f2);
            this.f1058V = false;
            m1770a(i4, f2, clientWidth);
            if (this.f1058V) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.f1056T) {
            return false;
        } else {
            this.f1058V = false;
            m1770a(0, 0.0f, 0);
            if (this.f1058V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    protected void m1770a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f1059W > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                C0453c c0453c = (C0453c) childAt.getLayoutParams();
                if (c0453c.f1023a) {
                    int max;
                    switch (c0453c.f1024b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        m1752b(i, f, i2);
        if (this.ae != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((C0453c) childAt2.getLayoutParams()).f1023a) {
                    this.ae.m1742a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f1058V = true;
    }

    private void m1752b(int i, float f, int i2) {
        if (this.ab != null) {
            this.ab.mo870a(i, f, i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0457f c0457f = (C0457f) this.aa.get(i3);
                if (c0457f != null) {
                    c0457f.mo870a(i, f, i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo870a(i, f, i2);
        }
    }

    private void m1758e(int i) {
        if (this.ab != null) {
            this.ab.mo869a(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0457f c0457f = (C0457f) this.aa.get(i2);
                if (c0457f != null) {
                    c0457f.mo869a(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo869a(i);
        }
    }

    private void m1760f(int i) {
        if (this.ab != null) {
            this.ab.mo871b(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0457f c0457f = (C0457f) this.aa.get(i2);
                if (c0457f != null) {
                    c0457f.mo871b(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo871b(i);
        }
    }

    private void m1750a(boolean z) {
        int scrollX;
        boolean z2 = this.al == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.f1069m.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.f1069m.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f1069m.getCurrX();
                int currY = this.f1069m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m1757d(currX);
                    }
                }
            }
        }
        this.f1082z = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.f1063g.size(); scrollX++) {
            C0452b c0452b = (C0452b) this.f1063g.get(scrollX);
            if (c0452b.f1020c) {
                c0452b.f1020c = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z) {
            ae.m2212a((View) this, this.ak);
        } else {
            this.ak.run();
        }
    }

    private boolean m1751a(float f, float f2) {
        return (f < ((float) this.f1041E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f1041E)) && f2 < 0.0f);
    }

    private void m1753b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = this.af;
            } else {
                i2 = 0;
            }
            ae.m2206a(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m1762h();
            return false;
        }
        if (action != 0) {
            if (this.f1038B) {
                return true;
            }
            if (this.f1039C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f1045I = x;
                this.f1043G = x;
                x = motionEvent.getY();
                this.f1046J = x;
                this.f1044H = x;
                this.f1047K = motionEvent.getPointerId(0);
                this.f1039C = false;
                this.f1070n = true;
                this.f1069m.computeScrollOffset();
                if (this.al == 2 && Math.abs(this.f1069m.getFinalX() - this.f1069m.getCurrX()) > this.f1052P) {
                    this.f1069m.abortAnimation();
                    this.f1082z = false;
                    m1781c();
                    this.f1038B = true;
                    m1755c(true);
                    setScrollState(1);
                    break;
                }
                m1750a(false);
                this.f1038B = false;
                break;
            case 2:
                action = this.f1047K;
                if (action != -1) {
                    action = motionEvent.findPointerIndex(action);
                    float x2 = motionEvent.getX(action);
                    float f = x2 - this.f1043G;
                    float abs = Math.abs(f);
                    float y = motionEvent.getY(action);
                    float abs2 = Math.abs(y - this.f1046J);
                    if (f == 0.0f || m1751a(this.f1043G, f) || !m1777a(this, false, (int) f, (int) x2, (int) y)) {
                        if (abs > ((float) this.f1042F) && 0.5f * abs > abs2) {
                            this.f1038B = true;
                            m1755c(true);
                            setScrollState(1);
                            this.f1043G = f > 0.0f ? this.f1045I + ((float) this.f1042F) : this.f1045I - ((float) this.f1042F);
                            this.f1044H = y;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f1042F)) {
                            this.f1039C = true;
                        }
                        if (this.f1038B && m1754b(x2)) {
                            ae.m2224d(this);
                            break;
                        }
                    }
                    this.f1043G = x2;
                    this.f1044H = y;
                    this.f1039C = true;
                    return false;
                }
                break;
            case 6:
                m1749a(motionEvent);
                break;
        }
        if (this.f1048L == null) {
            this.f1048L = VelocityTracker.obtain();
        }
        this.f1048L.addMovement(motionEvent);
        return this.f1038B;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f1053Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f1060b == null || this.f1060b.mo873b() == 0) {
            return false;
        }
        if (this.f1048L == null) {
            this.f1048L = VelocityTracker.obtain();
        }
        this.f1048L.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f1069m.abortAnimation();
                this.f1082z = false;
                m1781c();
                x = motionEvent.getX();
                this.f1045I = x;
                this.f1043G = x;
                x = motionEvent.getY();
                this.f1046J = x;
                this.f1044H = x;
                this.f1047K = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.f1038B) {
                    VelocityTracker velocityTracker = this.f1048L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1050N);
                    a = (int) ac.m2064a(velocityTracker, this.f1047K);
                    this.f1082z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C0452b i = m1763i();
                    m1774a(m1744a(i.f1019b, ((((float) scrollX) / ((float) clientWidth)) - i.f1022e) / (i.f1021d + (((float) this.f1072p) / ((float) clientWidth))), a, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f1047K)) - this.f1045I)), true, true, a);
                    z = m1762h();
                    break;
                }
                break;
            case 2:
                if (!this.f1038B) {
                    a = motionEvent.findPointerIndex(this.f1047K);
                    if (a == -1) {
                        z = m1762h();
                        break;
                    }
                    float x2 = motionEvent.getX(a);
                    float abs = Math.abs(x2 - this.f1043G);
                    float y = motionEvent.getY(a);
                    x = Math.abs(y - this.f1044H);
                    if (abs > ((float) this.f1042F) && abs > x) {
                        this.f1038B = true;
                        m1755c(true);
                        if (x2 - this.f1045I > 0.0f) {
                            x = this.f1045I + ((float) this.f1042F);
                        } else {
                            x = this.f1045I - ((float) this.f1042F);
                        }
                        this.f1043G = x;
                        this.f1044H = y;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f1038B) {
                    z = false | m1754b(motionEvent.getX(motionEvent.findPointerIndex(this.f1047K)));
                    break;
                }
                break;
            case 3:
                if (this.f1038B) {
                    m1747a(this.f1061c, true, 0, false);
                    z = m1762h();
                    break;
                }
                break;
            case 5:
                a = C0601s.m2510b(motionEvent);
                this.f1043G = motionEvent.getX(a);
                this.f1047K = motionEvent.getPointerId(a);
                break;
            case 6:
                m1749a(motionEvent);
                this.f1043G = motionEvent.getX(motionEvent.findPointerIndex(this.f1047K));
                break;
        }
        if (z) {
            ae.m2224d(this);
        }
        return true;
    }

    private boolean m1762h() {
        this.f1047K = -1;
        m1764j();
        return this.f1054R.m2648c() | this.f1055S.m2648c();
    }

    private void m1755c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m1754b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f1043G - f;
        this.f1043G = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f1076t;
        float f5 = ((float) clientWidth) * this.f1077u;
        C0452b c0452b = (C0452b) this.f1063g.get(0);
        C0452b c0452b2 = (C0452b) this.f1063g.get(this.f1063g.size() - 1);
        if (c0452b.f1019b != 0) {
            f4 = c0452b.f1022e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (c0452b2.f1019b != this.f1060b.mo873b() - 1) {
            f2 = c0452b2.f1022e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f1054R.m2643a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f1055S.m2643a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f1043G += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m1757d((int) f4);
        return z3;
    }

    private C0452b m1763i() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.f1072p) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        C0452b c0452b = null;
        while (i2 < this.f1063g.size()) {
            int i3;
            C0452b c0452b2;
            C0452b c0452b3 = (C0452b) this.f1063g.get(i2);
            C0452b c0452b4;
            if (obj != null || c0452b3.f1019b == i + 1) {
                c0452b4 = c0452b3;
                i3 = i2;
                c0452b2 = c0452b4;
            } else {
                c0452b3 = this.f1064h;
                c0452b3.f1022e = (f2 + f3) + f;
                c0452b3.f1019b = i + 1;
                c0452b3.f1021d = this.f1060b.m912b(c0452b3.f1019b);
                c0452b4 = c0452b3;
                i3 = i2 - 1;
                c0452b2 = c0452b4;
            }
            f2 = c0452b2.f1022e;
            f3 = (c0452b2.f1021d + f2) + f;
            if (obj == null && scrollX < f2) {
                return c0452b;
            }
            if (scrollX < f3 || i3 == this.f1063g.size() - 1) {
                return c0452b2;
            }
            f3 = f2;
            i = c0452b2.f1019b;
            obj = null;
            f2 = c0452b2.f1021d;
            c0452b = c0452b2;
            i2 = i3 + 1;
        }
        return c0452b;
    }

    private int m1744a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f1051O || Math.abs(i2) <= this.f1049M) {
            i += (int) ((i >= this.f1061c ? 0.4f : 0.6f) + f);
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f1063g.size() <= 0) {
            return i;
        }
        return Math.max(((C0452b) this.f1063g.get(0)).f1019b, Math.min(i, ((C0452b) this.f1063g.get(this.f1063g.size() - 1)).f1019b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f1060b != null && this.f1060b.mo873b() > 1)) {
            int height;
            int width;
            if (!this.f1054R.m2642a()) {
                overScrollMode = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f1076t * ((float) width));
                this.f1054R.m2641a(height, width);
                i = 0 | this.f1054R.m2646a(canvas);
                canvas.restoreToCount(overScrollMode);
            }
            if (!this.f1055S.m2642a()) {
                overScrollMode = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f1077u + 1.0f)) * ((float) height));
                this.f1055S.m2641a(width, height);
                i |= this.f1055S.m2646a(canvas);
                canvas.restoreToCount(overScrollMode);
            }
        } else {
            this.f1054R.m2647b();
            this.f1055S.m2647b();
        }
        if (i != 0) {
            ae.m2224d(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1072p > 0 && this.f1073q != null && this.f1063g.size() > 0 && this.f1060b != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f1072p) / ((float) width);
            C0452b c0452b = (C0452b) this.f1063g.get(0);
            float f2 = c0452b.f1022e;
            int size = this.f1063g.size();
            int i = c0452b.f1019b;
            int i2 = ((C0452b) this.f1063g.get(size - 1)).f1019b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c0452b.f1019b && i3 < size) {
                    i3++;
                    c0452b = (C0452b) this.f1063g.get(i3);
                }
                if (i4 == c0452b.f1019b) {
                    f3 = (c0452b.f1022e + c0452b.f1021d) * ((float) width);
                    f2 = (c0452b.f1022e + c0452b.f1021d) + f;
                } else {
                    float b = this.f1060b.m912b(i4);
                    f3 = (f2 + b) * ((float) width);
                    f2 += b + f;
                }
                if (((float) this.f1072p) + f3 > ((float) scrollX)) {
                    this.f1073q.setBounds(Math.round(f3), this.f1074r, Math.round(((float) this.f1072p) + f3), this.f1075s);
                    this.f1073q.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void m1749a(MotionEvent motionEvent) {
        int b = C0601s.m2510b(motionEvent);
        if (motionEvent.getPointerId(b) == this.f1047K) {
            b = b == 0 ? 1 : 0;
            this.f1043G = motionEvent.getX(b);
            this.f1047K = motionEvent.getPointerId(b);
            if (this.f1048L != null) {
                this.f1048L.clear();
            }
        }
    }

    private void m1764j() {
        this.f1038B = false;
        this.f1039C = false;
        if (this.f1048L != null) {
            this.f1048L.recycle();
            this.f1048L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f1081y != z) {
            this.f1081y = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f1060b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f1076t))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f1077u))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean m1777a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m1777a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && ae.m2215a(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m1776a(keyEvent);
    }

    public boolean m1776a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return m1782c(17);
            case 22:
                return m1782c(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (C0572g.m2457a(keyEvent)) {
                    return m1782c(2);
                }
                if (C0572g.m2458a(keyEvent, 1)) {
                    return m1782c(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean m1782c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = m1783d();
            } else {
                if (i == 66 || i == 2) {
                    d = m1784e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || m1745a(this.f1065i, findNextFocus).left < m1745a(this.f1065i, view).left) ? findNextFocus.requestFocus() : m1783d();
        } else {
            if (i == 66) {
                d = (view == null || m1745a(this.f1065i, findNextFocus).left > m1745a(this.f1065i, view).left) ? findNextFocus.requestFocus() : m1784e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    private Rect m1745a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean m1783d() {
        if (this.f1061c <= 0) {
            return false;
        }
        m1772a(this.f1061c - 1, true);
        return true;
    }

    boolean m1784e() {
        if (this.f1060b == null || this.f1061c >= this.f1060b.mo873b() - 1) {
            return false;
        }
        m1772a(this.f1061c + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C0452b a = m1767a(childAt);
                    if (a != null && a.f1019b == this.f1061c) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0452b a = m1767a(childAt);
                if (a != null && a.f1019b == this.f1061c) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                C0452b a = m1767a(childAt);
                if (a != null && a.f1019b == this.f1061c && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0452b a = m1767a(childAt);
                if (a != null && a.f1019b == this.f1061c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0453c();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0453c) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0453c(getContext(), attributeSet);
    }
}
