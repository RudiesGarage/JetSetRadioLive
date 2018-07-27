package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0454a;
import android.support.v4.view.C0601s;
import android.support.v4.view.C0603u;
import android.support.v4.view.C0604v;
import android.support.v4.view.C0605w;
import android.support.v4.view.C0606x;
import android.support.v4.view.aa;
import android.support.v4.view.ac;
import android.support.v4.view.ae;
import android.support.v4.view.p025a.C0474a;
import android.support.v4.view.p025a.C0489c;
import android.support.v4.view.p025a.C0512k;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.util.List;

public class NestedScrollView extends FrameLayout implements aa, C0603u, C0605w {
    private static final C0608a f1155v = new C0608a();
    private static final int[] f1156w = new int[]{16843130};
    private C0609b f1157A;
    private long f1158a;
    private final Rect f1159b;
    private C0639p f1160c;
    private C0622d f1161d;
    private C0622d f1162e;
    private int f1163f;
    private boolean f1164g;
    private boolean f1165h;
    private View f1166i;
    private boolean f1167j;
    private VelocityTracker f1168k;
    private boolean f1169l;
    private boolean f1170m;
    private int f1171n;
    private int f1172o;
    private int f1173p;
    private int f1174q;
    private final int[] f1175r;
    private final int[] f1176s;
    private int f1177t;
    private SavedState f1178u;
    private final C0606x f1179x;
    private final C0604v f1180y;
    private float f1181z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C06071();
        public int f1154a;

        static class C06071 implements Creator<SavedState> {
            C06071() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2529a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2530a(i);
            }

            public SavedState m2529a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m2530a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1154a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1154a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1154a + "}";
        }
    }

    static class C0608a extends C0454a {
        C0608a() {
        }

        public boolean mo285a(View view, int i, Bundle bundle) {
            if (super.mo285a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2559b(0, min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2559b(0, min);
                    return true;
                default:
                    return false;
            }
        }

        public void mo284a(View view, C0489c c0489c) {
            super.mo284a(view, c0489c);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0489c.m1945a(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    c0489c.m1947a(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c0489c.m1943a(8192);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        c0489c.m1943a(4096);
                    }
                }
            }
        }

        public void mo286d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo286d(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            C0512k a = C0474a.m1857a(accessibilityEvent);
            a.m2043a(nestedScrollView.getScrollRange() > 0);
            a.m2046d(nestedScrollView.getScrollX());
            a.m2047e(nestedScrollView.getScrollY());
            a.m2048f(nestedScrollView.getScrollX());
            a.m2049g(nestedScrollView.getScrollRange());
        }
    }

    public interface C0609b {
        void m2534a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1159b = new Rect();
        this.f1164g = true;
        this.f1165h = false;
        this.f1166i = null;
        this.f1167j = false;
        this.f1170m = true;
        this.f1174q = -1;
        this.f1175r = new int[2];
        this.f1176s = new int[2];
        m2536a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1156w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1179x = new C0606x(this);
        this.f1180y = new C0604v(this);
        setNestedScrollingEnabled(true);
        ae.m2210a((View) this, f1155v);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1180y.m2517a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1180y.m2518a();
    }

    public boolean startNestedScroll(int i) {
        return this.f1180y.m2521a(i);
    }

    public void stopNestedScroll() {
        this.f1180y.m2525c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f1180y.m2524b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1180y.m2522a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1180y.m2523a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1180y.m2520a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1180y.m2519a(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1179x.m2528a(view, view2, i);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.f1179x.m2527a(view);
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m2552f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.f1179x.m2526a();
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    private void m2536a() {
        this.f1160c = C0639p.m2684a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1171n = viewConfiguration.getScaledTouchSlop();
        this.f1172o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1173p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(C0609b c0609b) {
        this.f1157A = c0609b;
    }

    private boolean m2545b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1169l) {
            this.f1169l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1170m = z;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f1157A != null) {
            this.f1157A.m2534a(this, i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1169l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2558a(keyEvent);
    }

    public boolean m2558a(KeyEvent keyEvent) {
        int i = 33;
        this.f1159b.setEmpty();
        if (m2545b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (keyEvent.isAltPressed()) {
                        return m2560b(33);
                    }
                    return m2561c(33);
                case 20:
                    if (keyEvent.isAltPressed()) {
                        return m2560b(130);
                    }
                    return m2561c(130);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m2556a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            boolean z;
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) {
                z = false;
            } else {
                z = true;
            }
            return z;
        }
    }

    private boolean m2547c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void m2546c() {
        if (this.f1168k == null) {
            this.f1168k = VelocityTracker.obtain();
        } else {
            this.f1168k.clear();
        }
    }

    private void m2548d() {
        if (this.f1168k == null) {
            this.f1168k = VelocityTracker.obtain();
        }
    }

    private void m2549e() {
        if (this.f1168k != null) {
            this.f1168k.recycle();
            this.f1168k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2549e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f1167j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                action = (int) motionEvent.getY();
                if (!m2547c((int) motionEvent.getX(), action)) {
                    this.f1167j = false;
                    m2549e();
                    break;
                }
                this.f1163f = action;
                this.f1174q = motionEvent.getPointerId(0);
                m2546c();
                this.f1168k.addMovement(motionEvent);
                this.f1160c.m2696g();
                if (!this.f1160c.m2689a()) {
                    z = true;
                }
                this.f1167j = z;
                startNestedScroll(2);
                break;
            case 1:
            case 3:
                this.f1167j = false;
                this.f1174q = -1;
                m2549e();
                if (this.f1160c.m2690a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ae.m2224d(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.f1174q;
                if (action != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(action);
                    if (findPointerIndex != -1) {
                        action = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(action - this.f1163f) > this.f1171n && (getNestedScrollAxes() & 2) == 0) {
                            this.f1167j = true;
                            this.f1163f = action;
                            m2548d();
                            this.f1168k.addMovement(motionEvent);
                            this.f1177t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m2537a(motionEvent);
                break;
        }
        return this.f1167j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m2548d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = C0601s.m2508a(motionEvent);
        if (a == 0) {
            this.f1177t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f1177t);
        switch (a) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f1160c.m2689a();
                    this.f1167j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f1160c.m2689a()) {
                        this.f1160c.m2697h();
                    }
                    this.f1163f = (int) motionEvent.getY();
                    this.f1174q = motionEvent.getPointerId(0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.f1167j) {
                    VelocityTracker velocityTracker = this.f1168k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1173p);
                    a = (int) ac.m2065b(velocityTracker, this.f1174q);
                    if (Math.abs(a) > this.f1172o) {
                        m2552f(-a);
                    } else if (this.f1160c.m2690a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ae.m2224d(this);
                    }
                }
                this.f1174q = -1;
                m2551f();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1174q);
                if (findPointerIndex != -1) {
                    int i;
                    int y = (int) motionEvent.getY(findPointerIndex);
                    a = this.f1163f - y;
                    if (dispatchNestedPreScroll(0, a, this.f1176s, this.f1175r)) {
                        a -= this.f1176s[1];
                        obtain.offsetLocation(0.0f, (float) this.f1175r[1]);
                        this.f1177t += this.f1175r[1];
                    }
                    if (this.f1167j || Math.abs(a) <= this.f1171n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1167j = true;
                        if (a > 0) {
                            i = a - this.f1171n;
                        } else {
                            i = a + this.f1171n;
                        }
                    }
                    if (this.f1167j) {
                        Object obj;
                        this.f1163f = y - this.f1175r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = getOverScrollMode();
                        if (a == 0 || (a == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (m2557a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f1168k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f1175r)) {
                            if (obj != null) {
                                m2553g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f1161d.m2644a(((float) i) / ((float) getHeight()), motionEvent.getX(findPointerIndex) / ((float) getWidth()));
                                    if (!this.f1162e.m2642a()) {
                                        this.f1162e.m2648c();
                                    }
                                } else if (a > scrollRange) {
                                    this.f1162e.m2644a(((float) i) / ((float) getHeight()), 1.0f - (motionEvent.getX(findPointerIndex) / ((float) getWidth())));
                                    if (!this.f1161d.m2642a()) {
                                        this.f1161d.m2648c();
                                    }
                                }
                                if (!(this.f1161d == null || (this.f1161d.m2642a() && this.f1162e.m2642a()))) {
                                    ae.m2224d(this);
                                    break;
                                }
                            }
                        }
                        this.f1163f -= this.f1175r[1];
                        obtain.offsetLocation(0.0f, (float) this.f1175r[1]);
                        this.f1177t += this.f1175r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f1174q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.f1167j && getChildCount() > 0 && this.f1160c.m2690a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ae.m2224d(this);
                }
                this.f1174q = -1;
                m2551f();
                break;
            case 5:
                a = C0601s.m2510b(motionEvent);
                this.f1163f = (int) motionEvent.getY(a);
                this.f1174q = motionEvent.getPointerId(a);
                break;
            case 6:
                m2537a(motionEvent);
                this.f1163f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f1174q));
                break;
        }
        if (this.f1168k != null) {
            this.f1168k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void m2537a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f1174q) {
            action = action == 0 ? 1 : 0;
            this.f1163f = (int) motionEvent.getY(action);
            this.f1174q = motionEvent.getPointerId(action);
            if (this.f1168k != null) {
                this.f1168k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f1167j) {
                    return false;
                }
                float e = C0601s.m2515e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1181z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f1181z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f1181z;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    boolean m2557a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (overScrollMode == 0 || (overScrollMode == 1 && obj != null)) ? 1 : null;
        obj = (overScrollMode == 0 || (overScrollMode == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        overScrollMode = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < overScrollMode) {
            z3 = true;
            i13 = overScrollMode;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.f1160c.m2690a(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private View m2535a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    public boolean m2556a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f1159b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f1159b.top + height > childAt.getBottom()) {
                    this.f1159b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f1159b.top = getScrollY() - height;
            if (this.f1159b.top < 0) {
                this.f1159b.top = 0;
            }
        }
        this.f1159b.bottom = this.f1159b.top + height;
        return m2538a(i, this.f1159b.top, this.f1159b.bottom);
    }

    public boolean m2560b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f1159b.top = 0;
        this.f1159b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f1159b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f1159b.top = this.f1159b.bottom - height;
            }
        }
        return m2538a(i, this.f1159b.top, this.f1159b.bottom);
    }

    private boolean m2538a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2535a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2550e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    public boolean m2561c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2541a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2550e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1159b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1159b);
            m2550e(m2554a(this.f1159b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m2540a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean m2540a(View view) {
        return !m2541a(view, 0, getHeight());
    }

    private boolean m2541a(View view, int i, int i2) {
        view.getDrawingRect(this.f1159b);
        offsetDescendantRectToMyCoords(view, this.f1159b);
        return this.f1159b.bottom + i >= getScrollY() && this.f1159b.top - i <= getScrollY() + i2;
    }

    private void m2550e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f1170m) {
            m2555a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    public final void m2555a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1158a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1160c.m2685a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                ae.m2224d(this);
            } else {
                if (!this.f1160c.m2689a()) {
                    this.f1160c.m2697h();
                }
                scrollBy(i, i2);
            }
            this.f1158a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void m2559b(int i, int i2) {
        m2555a(i - getScrollX(), i2 - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.f1160c.m2696g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f1160c.m2691b();
            int c = this.f1160c.m2692c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int overScrollMode = getOverScrollMode();
                int i = (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) ? 1 : 0;
                m2557a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m2553g();
                    if (c <= 0 && scrollY > 0) {
                        this.f1161d.m2645a((int) this.f1160c.m2695f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f1162e.m2645a((int) this.f1160c.m2695f());
                    }
                }
            }
        }
    }

    private void m2544b(View view) {
        view.getDrawingRect(this.f1159b);
        offsetDescendantRectToMyCoords(view, this.f1159b);
        int a = m2554a(this.f1159b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m2539a(Rect rect, boolean z) {
        int a = m2554a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m2555a(0, a);
            }
        }
        return z2;
    }

    protected int m2554a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f1164g) {
            this.f1166i = view2;
        } else {
            m2544b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocus;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocus = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocus == null || m2540a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2539a(rect, z);
    }

    public void requestLayout() {
        this.f1164g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1164g = false;
        if (this.f1166i != null && m2542a(this.f1166i, (View) this)) {
            m2544b(this.f1166i);
        }
        this.f1166i = null;
        if (!this.f1165h) {
            if (this.f1178u != null) {
                scrollTo(getScrollX(), this.f1178u.f1154a);
                this.f1178u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1165h = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1165h = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2541a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f1159b);
            offsetDescendantRectToMyCoords(findFocus, this.f1159b);
            m2550e(m2554a(this.f1159b));
        }
    }

    private static boolean m2542a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m2542a((View) parent, view2);
        return z;
    }

    public void m2562d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f1160c.m2688a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            ae.m2224d(this);
        }
    }

    private void m2552f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m2562d(i);
            }
        }
    }

    private void m2551f() {
        this.f1167j = false;
        m2549e();
        stopNestedScroll();
        if (this.f1161d != null) {
            this.f1161d.m2648c();
            this.f1162e.m2648c();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m2543b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m2543b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    private void m2553g() {
        if (getOverScrollMode() == 2) {
            this.f1161d = null;
            this.f1162e = null;
        } else if (this.f1161d == null) {
            Context context = getContext();
            this.f1161d = new C0622d(context);
            this.f1162e = new C0622d(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1161d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f1161d.m2642a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f1161d.m2641a(width, getHeight());
                if (this.f1161d.m2646a(canvas)) {
                    ae.m2224d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1162e.m2642a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f1162e.m2641a(width, height);
                if (this.f1162e.m2646a(canvas)) {
                    ae.m2224d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int m2543b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f1178u = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1154a = getScrollY();
        return savedState;
    }
}
