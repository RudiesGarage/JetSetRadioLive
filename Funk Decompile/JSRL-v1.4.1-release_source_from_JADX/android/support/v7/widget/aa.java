package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ae;
import android.support.v4.widget.C0634k;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0669k;
import android.support.v7.view.menu.C0719q;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow */
public class aa implements C0719q {
    private static Method f2109a;
    private static Method f2110b;
    private static Method f2111h;
    private OnItemSelectedListener f2112A;
    private final C0831d f2113B;
    private final C0830c f2114C;
    private final C0828a f2115D;
    private Runnable f2116E;
    private final Rect f2117F;
    private Rect f2118G;
    private boolean f2119H;
    C0834v f2120c;
    int f2121d;
    final C0832e f2122e;
    final Handler f2123f;
    PopupWindow f2124g;
    private Context f2125i;
    private ListAdapter f2126j;
    private int f2127k;
    private int f2128l;
    private int f2129m;
    private int f2130n;
    private int f2131o;
    private boolean f2132p;
    private boolean f2133q;
    private int f2134r;
    private boolean f2135s;
    private boolean f2136t;
    private View f2137u;
    private int f2138v;
    private DataSetObserver f2139w;
    private View f2140x;
    private Drawable f2141y;
    private OnItemClickListener f2142z;

    /* compiled from: ListPopupWindow */
    class C08261 implements Runnable {
        final /* synthetic */ aa f2102a;

        C08261(aa aaVar) {
            this.f2102a = aaVar;
        }

        public void run() {
            View i = this.f2102a.m4129i();
            if (i != null && i.getWindowToken() != null) {
                this.f2102a.mo518a();
            }
        }
    }

    /* compiled from: ListPopupWindow */
    class C08272 implements OnItemSelectedListener {
        final /* synthetic */ aa f2103a;

        C08272(aa aaVar) {
            this.f2103a = aaVar;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                C0834v c0834v = this.f2103a.f2120c;
                if (c0834v != null) {
                    c0834v.setListSelectionHidden(false);
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: ListPopupWindow */
    private class C0828a implements Runnable {
        final /* synthetic */ aa f2104a;

        C0828a(aa aaVar) {
            this.f2104a = aaVar;
        }

        public void run() {
            this.f2104a.m4134m();
        }
    }

    /* compiled from: ListPopupWindow */
    private class C0829b extends DataSetObserver {
        final /* synthetic */ aa f2105a;

        C0829b(aa aaVar) {
            this.f2105a = aaVar;
        }

        public void onChanged() {
            if (this.f2105a.mo528d()) {
                this.f2105a.mo518a();
            }
        }

        public void onInvalidated() {
            this.f2105a.mo525c();
        }
    }

    /* compiled from: ListPopupWindow */
    private class C0830c implements OnScrollListener {
        final /* synthetic */ aa f2106a;

        C0830c(aa aaVar) {
            this.f2106a = aaVar;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.f2106a.m4135n() && this.f2106a.f2124g.getContentView() != null) {
                this.f2106a.f2123f.removeCallbacks(this.f2106a.f2122e);
                this.f2106a.f2122e.run();
            }
        }
    }

    /* compiled from: ListPopupWindow */
    private class C0831d implements OnTouchListener {
        final /* synthetic */ aa f2107a;

        C0831d(aa aaVar) {
            this.f2107a = aaVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f2107a.f2124g != null && this.f2107a.f2124g.isShowing() && x >= 0 && x < this.f2107a.f2124g.getWidth() && y >= 0 && y < this.f2107a.f2124g.getHeight()) {
                this.f2107a.f2123f.postDelayed(this.f2107a.f2122e, 250);
            } else if (action == 1) {
                this.f2107a.f2123f.removeCallbacks(this.f2107a.f2122e);
            }
            return false;
        }
    }

    /* compiled from: ListPopupWindow */
    private class C0832e implements Runnable {
        final /* synthetic */ aa f2108a;

        C0832e(aa aaVar) {
            this.f2108a = aaVar;
        }

        public void run() {
            if (this.f2108a.f2120c != null && ae.m2244x(this.f2108a.f2120c) && this.f2108a.f2120c.getCount() > this.f2108a.f2120c.getChildCount() && this.f2108a.f2120c.getChildCount() <= this.f2108a.f2121d) {
                this.f2108a.f2124g.setInputMethodMode(2);
                this.f2108a.mo518a();
            }
        }
    }

    static {
        try {
            f2109a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f2110b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f2111h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public aa(Context context) {
        this(context, null, C0659a.listPopupWindowStyle);
    }

    public aa(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public aa(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2127k = -2;
        this.f2128l = -2;
        this.f2131o = 1002;
        this.f2133q = true;
        this.f2134r = 0;
        this.f2135s = false;
        this.f2136t = false;
        this.f2121d = Integer.MAX_VALUE;
        this.f2138v = 0;
        this.f2122e = new C0832e(this);
        this.f2113B = new C0831d(this);
        this.f2114C = new C0830c(this);
        this.f2115D = new C0828a(this);
        this.f2117F = new Rect();
        this.f2125i = context;
        this.f2123f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0669k.ListPopupWindow, i, i2);
        this.f2129m = obtainStyledAttributes.getDimensionPixelOffset(C0669k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f2130n = obtainStyledAttributes.getDimensionPixelOffset(C0669k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f2130n != 0) {
            this.f2132p = true;
        }
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 11) {
            this.f2124g = new C0877m(context, attributeSet, i, i2);
        } else {
            this.f2124g = new C0877m(context, attributeSet, i);
        }
        this.f2124g.setInputMethodMode(1);
    }

    public void mo694a(ListAdapter listAdapter) {
        if (this.f2139w == null) {
            this.f2139w = new C0829b(this);
        } else if (this.f2126j != null) {
            this.f2126j.unregisterDataSetObserver(this.f2139w);
        }
        this.f2126j = listAdapter;
        if (this.f2126j != null) {
            listAdapter.registerDataSetObserver(this.f2139w);
        }
        if (this.f2120c != null) {
            this.f2120c.setAdapter(this.f2126j);
        }
    }

    public void m4109a(int i) {
        this.f2138v = i;
    }

    public void m4115a(boolean z) {
        this.f2119H = z;
        this.f2124g.setFocusable(z);
    }

    public boolean m4126g() {
        return this.f2119H;
    }

    public Drawable m4127h() {
        return this.f2124g.getBackground();
    }

    public void m4111a(Drawable drawable) {
        this.f2124g.setBackgroundDrawable(drawable);
    }

    public void m4116b(int i) {
        this.f2124g.setAnimationStyle(i);
    }

    public View m4129i() {
        return this.f2140x;
    }

    public void m4117b(View view) {
        this.f2140x = view;
    }

    public int m4131j() {
        return this.f2129m;
    }

    public void m4119c(int i) {
        this.f2129m = i;
    }

    public int m4132k() {
        if (this.f2132p) {
            return this.f2130n;
        }
        return 0;
    }

    public void m4120d(int i) {
        this.f2130n = i;
        this.f2132p = true;
    }

    public void m4110a(Rect rect) {
        this.f2118G = rect;
    }

    public void m4123e(int i) {
        this.f2134r = i;
    }

    public int m4133l() {
        return this.f2128l;
    }

    public void m4124f(int i) {
        this.f2128l = i;
    }

    public void m4125g(int i) {
        Drawable background = this.f2124g.getBackground();
        if (background != null) {
            background.getPadding(this.f2117F);
            this.f2128l = (this.f2117F.left + this.f2117F.right) + i;
            return;
        }
        m4124f(i);
    }

    public void m4112a(OnItemClickListener onItemClickListener) {
        this.f2142z = onItemClickListener;
    }

    public void mo518a() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int f = mo696f();
        boolean n = m4135n();
        C0634k.m2674a(this.f2124g, this.f2131o);
        int i2;
        if (this.f2124g.isShowing()) {
            int i3;
            int i4;
            if (this.f2128l == -1) {
                i3 = -1;
            } else if (this.f2128l == -2) {
                i3 = m4129i().getWidth();
            } else {
                i3 = this.f2128l;
            }
            if (this.f2127k == -1) {
                if (!n) {
                    f = -1;
                }
                PopupWindow popupWindow;
                if (n) {
                    popupWindow = this.f2124g;
                    if (this.f2128l == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.f2124g.setHeight(0);
                    i4 = f;
                } else {
                    popupWindow = this.f2124g;
                    if (this.f2128l == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.f2124g.setHeight(-1);
                    i4 = f;
                }
            } else if (this.f2127k == -2) {
                i4 = f;
            } else {
                i4 = this.f2127k;
            }
            PopupWindow popupWindow2 = this.f2124g;
            if (!(this.f2136t || this.f2135s)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            popupWindow2 = this.f2124g;
            View i5 = m4129i();
            f = this.f2129m;
            int i6 = this.f2130n;
            if (i3 < 0) {
                i3 = -1;
            }
            if (i4 >= 0) {
                i = i4;
            }
            popupWindow2.update(i5, f, i6, i3, i);
            return;
        }
        if (this.f2128l == -1) {
            i2 = -1;
        } else if (this.f2128l == -2) {
            i2 = m4129i().getWidth();
        } else {
            i2 = this.f2128l;
        }
        if (this.f2127k == -1) {
            f = -1;
        } else if (this.f2127k != -2) {
            f = this.f2127k;
        }
        this.f2124g.setWidth(i2);
        this.f2124g.setHeight(f);
        mo652b(true);
        popupWindow2 = this.f2124g;
        if (this.f2136t || this.f2135s) {
            z = false;
        }
        popupWindow2.setOutsideTouchable(z);
        this.f2124g.setTouchInterceptor(this.f2113B);
        if (f2111h != null) {
            try {
                f2111h.invoke(this.f2124g, new Object[]{this.f2118G});
            } catch (Throwable e) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
            }
        }
        C0634k.m2675a(this.f2124g, m4129i(), this.f2129m, this.f2130n, this.f2134r);
        this.f2120c.setSelection(-1);
        if (!this.f2119H || this.f2120c.isInTouchMode()) {
            m4134m();
        }
        if (!this.f2119H) {
            this.f2123f.post(this.f2115D);
        }
    }

    public void mo525c() {
        this.f2124g.dismiss();
        mo695b();
        this.f2124g.setContentView(null);
        this.f2120c = null;
        this.f2123f.removeCallbacks(this.f2122e);
    }

    public void m4114a(OnDismissListener onDismissListener) {
        this.f2124g.setOnDismissListener(onDismissListener);
    }

    private void mo695b() {
        if (this.f2137u != null) {
            ViewParent parent = this.f2137u.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2137u);
            }
        }
    }

    public void m4128h(int i) {
        this.f2124g.setInputMethodMode(i);
    }

    public void m4130i(int i) {
        C0834v c0834v = this.f2120c;
        if (mo528d() && c0834v != null) {
            c0834v.setListSelectionHidden(false);
            c0834v.setSelection(i);
            if (VERSION.SDK_INT >= 11 && c0834v.getChoiceMode() != 0) {
                c0834v.setItemChecked(i, true);
            }
        }
    }

    public void m4134m() {
        C0834v c0834v = this.f2120c;
        if (c0834v != null) {
            c0834v.setListSelectionHidden(true);
            c0834v.requestLayout();
        }
    }

    public boolean mo528d() {
        return this.f2124g.isShowing();
    }

    public boolean m4135n() {
        return this.f2124g.getInputMethodMode() == 2;
    }

    public ListView mo529e() {
        return this.f2120c;
    }

    C0834v mo651a(Context context, boolean z) {
        return new C0834v(context, z);
    }

    private int mo696f() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.f2120c == null) {
            Context context = this.f2125i;
            this.f2116E = new C08261(this);
            this.f2120c = mo651a(context, !this.f2119H);
            if (this.f2141y != null) {
                this.f2120c.setSelector(this.f2141y);
            }
            this.f2120c.setAdapter(this.f2126j);
            this.f2120c.setOnItemClickListener(this.f2142z);
            this.f2120c.setFocusable(true);
            this.f2120c.setFocusableInTouchMode(true);
            this.f2120c.setOnItemSelectedListener(new C08272(this));
            this.f2120c.setOnScrollListener(this.f2114C);
            if (this.f2112A != null) {
                this.f2120c.setOnItemSelectedListener(this.f2112A);
            }
            View view2 = this.f2120c;
            View view3 = this.f2137u;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f2138v) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f2138v);
                        break;
                }
                if (this.f2128l >= 0) {
                    i = this.f2128l;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.f2124g.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f2124g.getContentView();
            view = this.f2137u;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.f2124g.getBackground();
        if (background != null) {
            background.getPadding(this.f2117F);
            i2 = this.f2117F.top + this.f2117F.bottom;
            if (this.f2132p) {
                i4 = i2;
            } else {
                this.f2130n = -this.f2117F.top;
                i4 = i2;
            }
        } else {
            this.f2117F.setEmpty();
            i4 = 0;
        }
        if (this.f2124g.getInputMethodMode() != 2) {
            z = false;
        }
        i = m4103a(m4129i(), this.f2130n, z);
        if (this.f2135s || this.f2127k == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.f2128l) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2125i.getResources().getDisplayMetrics().widthPixels - (this.f2117F.left + this.f2117F.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2125i.getResources().getDisplayMetrics().widthPixels - (this.f2117F.left + this.f2117F.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2128l, 1073741824);
                break;
        }
        i2 = this.f2120c.m4137a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += (this.f2120c.getPaddingTop() + this.f2120c.getPaddingBottom()) + i4;
        }
        return i2 + i3;
    }

    private void mo652b(boolean z) {
        if (f2109a != null) {
            try {
                f2109a.invoke(this.f2124g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int m4103a(View view, int i, boolean z) {
        if (f2110b != null) {
            try {
                return ((Integer) f2110b.invoke(this.f2124g, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f2124g.getMaxAvailableHeight(view, i);
    }
}
