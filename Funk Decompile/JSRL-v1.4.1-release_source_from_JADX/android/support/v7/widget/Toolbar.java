package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p022e.C0325d;
import android.support.v4.p022e.C0326e;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.C0567e;
import android.support.v4.view.C0587n;
import android.support.v4.view.C0594p;
import android.support.v4.view.C0601s;
import android.support.v4.view.ae;
import android.support.v7.p026a.C0643a.C0641a;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0669k;
import android.support.v7.p028c.p029a.C0673b;
import android.support.v7.view.C0697b;
import android.support.v7.view.C0701d;
import android.support.v7.view.menu.C0711m;
import android.support.v7.view.menu.C0711m.C0736a;
import android.support.v7.view.menu.C0724g;
import android.support.v7.view.menu.C0724g.C0723a;
import android.support.v7.view.menu.C0726h;
import android.support.v7.view.menu.C0741s;
import android.support.v7.widget.ActionMenuView.C0753e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int f2054A;
    private int f2055B;
    private boolean f2056C;
    private boolean f2057D;
    private final ArrayList<View> f2058E;
    private final ArrayList<View> f2059F;
    private final int[] f2060G;
    private final C0753e f2061H;
    private at f2062I;
    private C0821a f2063J;
    private C0736a f2064K;
    private C0723a f2065L;
    private boolean f2066M;
    private final Runnable f2067N;
    ImageButton f2068a;
    View f2069b;
    int f2070c;
    C0823c f2071d;
    private ActionMenuView f2072e;
    private TextView f2073f;
    private TextView f2074g;
    private ImageButton f2075h;
    private ImageView f2076i;
    private Drawable f2077j;
    private CharSequence f2078k;
    private Context f2079l;
    private int f2080m;
    private int f2081n;
    private int f2082o;
    private int f2083p;
    private int f2084q;
    private int f2085r;
    private int f2086s;
    private int f2087t;
    private ai f2088u;
    private int f2089v;
    private int f2090w;
    private int f2091x;
    private CharSequence f2092y;
    private CharSequence f2093z;

    class C08171 implements C0753e {
        final /* synthetic */ Toolbar f2045a;

        C08171(Toolbar toolbar) {
            this.f2045a = toolbar;
        }

        public boolean mo639a(MenuItem menuItem) {
            if (this.f2045a.f2071d != null) {
                return this.f2045a.f2071d.m4064a(menuItem);
            }
            return false;
        }
    }

    class C08182 implements Runnable {
        final /* synthetic */ Toolbar f2046a;

        C08182(Toolbar toolbar) {
            this.f2046a = toolbar;
        }

        public void run() {
            this.f2046a.m4092b();
        }
    }

    class C08193 implements OnClickListener {
        final /* synthetic */ Toolbar f2047a;

        C08193(Toolbar toolbar) {
            this.f2047a = toolbar;
        }

        public void onClick(View view) {
            this.f2047a.m4093c();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = C0325d.m1196a(new C08201());
        int f2048b;
        boolean f2049c;

        static class C08201 implements C0326e<SavedState> {
            C08201() {
            }

            public /* synthetic */ Object mo280a(Parcel parcel, ClassLoader classLoader) {
                return m4053b(parcel, classLoader);
            }

            public /* synthetic */ Object[] mo281a(int i) {
                return m4054b(i);
            }

            public SavedState m4053b(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m4054b(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2048b = parcel.readInt();
            this.f2049c = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2048b);
            parcel.writeInt(this.f2049c ? 1 : 0);
        }
    }

    private class C0821a implements C0711m {
        C0724g f2050a;
        C0726h f2051b;
        final /* synthetic */ Toolbar f2052c;

        C0821a(Toolbar toolbar) {
            this.f2052c = toolbar;
        }

        public void mo508a(Context context, C0724g c0724g) {
            if (!(this.f2050a == null || this.f2051b == null)) {
                this.f2050a.mo550d(this.f2051b);
            }
            this.f2050a = c0724g;
        }

        public void mo513b(boolean z) {
            Object obj = null;
            if (this.f2051b != null) {
                if (this.f2050a != null) {
                    int size = this.f2050a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f2050a.getItem(i) == this.f2051b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    mo515b(this.f2050a, this.f2051b);
                }
            }
        }

        public void mo510a(C0736a c0736a) {
        }

        public boolean mo512a(C0741s c0741s) {
            return false;
        }

        public void mo509a(C0724g c0724g, boolean z) {
        }

        public boolean mo514b() {
            return false;
        }

        public boolean mo511a(C0724g c0724g, C0726h c0726h) {
            this.f2052c.m4094d();
            if (this.f2052c.f2068a.getParent() != this.f2052c) {
                this.f2052c.addView(this.f2052c.f2068a);
            }
            this.f2052c.f2069b = c0726h.getActionView();
            this.f2051b = c0726h;
            if (this.f2052c.f2069b.getParent() != this.f2052c) {
                LayoutParams e = this.f2052c.m4095e();
                e.a = 8388611 | (this.f2052c.f2070c & 112);
                e.f2053b = 2;
                this.f2052c.f2069b.setLayoutParams(e);
                this.f2052c.addView(this.f2052c.f2069b);
            }
            this.f2052c.m4096f();
            this.f2052c.requestLayout();
            c0726h.m3065e(true);
            if (this.f2052c.f2069b instanceof C0697b) {
                ((C0697b) this.f2052c.f2069b).mo536a();
            }
            return true;
        }

        public boolean mo515b(C0724g c0724g, C0726h c0726h) {
            if (this.f2052c.f2069b instanceof C0697b) {
                ((C0697b) this.f2052c.f2069b).mo537b();
            }
            this.f2052c.removeView(this.f2052c.f2069b);
            this.f2052c.removeView(this.f2052c.f2068a);
            this.f2052c.f2069b = null;
            this.f2052c.m4097g();
            this.f2051b = null;
            this.f2052c.requestLayout();
            c0726h.m3065e(false);
            return true;
        }
    }

    public static class C0822b extends C0641a {
        int f2053b;

        public C0822b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2053b = 0;
        }

        public C0822b(int i, int i2) {
            super(i, i2);
            this.f2053b = 0;
            this.a = 8388627;
        }

        public C0822b(C0822b c0822b) {
            super((C0641a) c0822b);
            this.f2053b = 0;
            this.f2053b = c0822b.f2053b;
        }

        public C0822b(C0641a c0641a) {
            super(c0641a);
            this.f2053b = 0;
        }

        public C0822b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f2053b = 0;
            m4063a(marginLayoutParams);
        }

        public C0822b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2053b = 0;
        }

        void m4063a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface C0823c {
        boolean m4064a(MenuItem menuItem);
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m4095e();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m4086a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m4087a(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0659a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2091x = 8388627;
        this.f2058E = new ArrayList();
        this.f2059F = new ArrayList();
        this.f2060G = new int[2];
        this.f2061H = new C08171(this);
        this.f2067N = new C08182(this);
        as a = as.m4294a(getContext(), attributeSet, C0669k.Toolbar, i, 0);
        this.f2081n = a.m4310g(C0669k.Toolbar_titleTextAppearance, 0);
        this.f2082o = a.m4310g(C0669k.Toolbar_subtitleTextAppearance, 0);
        this.f2091x = a.m4302c(C0669k.Toolbar_android_gravity, this.f2091x);
        this.f2070c = a.m4302c(C0669k.Toolbar_buttonGravity, 48);
        int d = a.m4304d(C0669k.Toolbar_titleMargin, 0);
        if (a.m4309f(C0669k.Toolbar_titleMargins)) {
            d = a.m4304d(C0669k.Toolbar_titleMargins, d);
        }
        this.f2087t = d;
        this.f2086s = d;
        this.f2085r = d;
        this.f2084q = d;
        d = a.m4304d(C0669k.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.f2084q = d;
        }
        d = a.m4304d(C0669k.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.f2085r = d;
        }
        d = a.m4304d(C0669k.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.f2086s = d;
        }
        d = a.m4304d(C0669k.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.f2087t = d;
        }
        this.f2083p = a.m4306e(C0669k.Toolbar_maxButtonHeight, -1);
        d = a.m4304d(C0669k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.m4304d(C0669k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e = a.m4306e(C0669k.Toolbar_contentInsetLeft, 0);
        int e2 = a.m4306e(C0669k.Toolbar_contentInsetRight, 0);
        m4085n();
        this.f2088u.m4219b(e, e2);
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.f2088u.m4216a(d, d2);
        }
        this.f2089v = a.m4304d(C0669k.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f2090w = a.m4304d(C0669k.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f2077j = a.m4297a(C0669k.Toolbar_collapseIcon);
        this.f2078k = a.m4301b(C0669k.Toolbar_collapseContentDescription);
        CharSequence b = a.m4301b(C0669k.Toolbar_title);
        if (!TextUtils.isEmpty(b)) {
            setTitle(b);
        }
        b = a.m4301b(C0669k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(b)) {
            setSubtitle(b);
        }
        this.f2079l = getContext();
        setPopupTheme(a.m4310g(C0669k.Toolbar_popupTheme, 0));
        Drawable a2 = a.m4297a(C0669k.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        b = a.m4301b(C0669k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(b)) {
            setNavigationContentDescription(b);
        }
        a2 = a.m4297a(C0669k.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        b = a.m4301b(C0669k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(b)) {
            setLogoDescription(b);
        }
        if (a.m4309f(C0669k.Toolbar_titleTextColor)) {
            setTitleTextColor(a.m4300b(C0669k.Toolbar_titleTextColor, -1));
        }
        if (a.m4309f(C0669k.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.m4300b(C0669k.Toolbar_subtitleTextColor, -1));
        }
        a.m4298a();
    }

    public void setPopupTheme(int i) {
        if (this.f2080m != i) {
            this.f2080m = i;
            if (i == 0) {
                this.f2079l = getContext();
            } else {
                this.f2079l = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f2080m;
    }

    public int getTitleMarginStart() {
        return this.f2084q;
    }

    public void setTitleMarginStart(int i) {
        this.f2084q = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.f2086s;
    }

    public void setTitleMarginTop(int i) {
        this.f2086s = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.f2085r;
    }

    public void setTitleMarginEnd(int i) {
        this.f2085r = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.f2087t;
    }

    public void setTitleMarginBottom(int i) {
        this.f2087t = i;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        m4085n();
        ai aiVar = this.f2088u;
        if (i != 1) {
            z = false;
        }
        aiVar.m4217a(z);
    }

    public void setLogo(int i) {
        setLogo(C0673b.m2768b(getContext(), i));
    }

    public boolean m4090a() {
        return this.f2072e != null && this.f2072e.m3204e();
    }

    public boolean m4092b() {
        return this.f2072e != null && this.f2072e.m3203d();
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m4079h();
            if (!m4078d(this.f2076i)) {
                m4071a(this.f2076i, true);
            }
        } else if (this.f2076i != null && m4078d(this.f2076i)) {
            removeView(this.f2076i);
            this.f2059F.remove(this.f2076i);
        }
        if (this.f2076i != null) {
            this.f2076i.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.f2076i != null ? this.f2076i.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m4079h();
        }
        if (this.f2076i != null) {
            this.f2076i.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.f2076i != null ? this.f2076i.getContentDescription() : null;
    }

    private void m4079h() {
        if (this.f2076i == null) {
            this.f2076i = new C0854l(getContext());
        }
    }

    public void m4093c() {
        C0726h c0726h = this.f2063J == null ? null : this.f2063J.f2051b;
        if (c0726h != null) {
            c0726h.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f2092y;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2073f == null) {
                Context context = getContext();
                this.f2073f = new C0705q(context);
                this.f2073f.setSingleLine();
                this.f2073f.setEllipsize(TruncateAt.END);
                if (this.f2081n != 0) {
                    this.f2073f.setTextAppearance(context, this.f2081n);
                }
                if (this.f2054A != 0) {
                    this.f2073f.setTextColor(this.f2054A);
                }
            }
            if (!m4078d(this.f2073f)) {
                m4071a(this.f2073f, true);
            }
        } else if (this.f2073f != null && m4078d(this.f2073f)) {
            removeView(this.f2073f);
            this.f2059F.remove(this.f2073f);
        }
        if (this.f2073f != null) {
            this.f2073f.setText(charSequence);
        }
        this.f2092y = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f2093z;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2074g == null) {
                Context context = getContext();
                this.f2074g = new C0705q(context);
                this.f2074g.setSingleLine();
                this.f2074g.setEllipsize(TruncateAt.END);
                if (this.f2082o != 0) {
                    this.f2074g.setTextAppearance(context, this.f2082o);
                }
                if (this.f2055B != 0) {
                    this.f2074g.setTextColor(this.f2055B);
                }
            }
            if (!m4078d(this.f2074g)) {
                m4071a(this.f2074g, true);
            }
        } else if (this.f2074g != null && m4078d(this.f2074g)) {
            removeView(this.f2074g);
            this.f2059F.remove(this.f2074g);
        }
        if (this.f2074g != null) {
            this.f2074g.setText(charSequence);
        }
        this.f2093z = charSequence;
    }

    public void m4089a(Context context, int i) {
        this.f2081n = i;
        if (this.f2073f != null) {
            this.f2073f.setTextAppearance(context, i);
        }
    }

    public void m4091b(Context context, int i) {
        this.f2082o = i;
        if (this.f2074g != null) {
            this.f2074g.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.f2054A = i;
        if (this.f2073f != null) {
            this.f2073f.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.f2055B = i;
        if (this.f2074g != null) {
            this.f2074g.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.f2075h != null ? this.f2075h.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m4082k();
        }
        if (this.f2075h != null) {
            this.f2075h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(C0673b.m2768b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m4082k();
            if (!m4078d(this.f2075h)) {
                m4071a(this.f2075h, true);
            }
        } else if (this.f2075h != null && m4078d(this.f2075h)) {
            removeView(this.f2075h);
            this.f2059F.remove(this.f2075h);
        }
        if (this.f2075h != null) {
            this.f2075h.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.f2075h != null ? this.f2075h.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m4082k();
        this.f2075h.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m4080i();
        return this.f2072e.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        m4080i();
        this.f2072e.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        m4080i();
        return this.f2072e.getOverflowIcon();
    }

    private void m4080i() {
        m4081j();
        if (this.f2072e.m3202c() == null) {
            C0724g c0724g = (C0724g) this.f2072e.getMenu();
            if (this.f2063J == null) {
                this.f2063J = new C0821a(this);
            }
            this.f2072e.setExpandedActionViewsExclusive(true);
            c0724g.m3018a(this.f2063J, this.f2079l);
        }
    }

    private void m4081j() {
        if (this.f2072e == null) {
            this.f2072e = new ActionMenuView(getContext());
            this.f2072e.setPopupTheme(this.f2080m);
            this.f2072e.setOnMenuItemClickListener(this.f2061H);
            this.f2072e.m3196a(this.f2064K, this.f2065L);
            LayoutParams e = m4095e();
            e.a = 8388613 | (this.f2070c & 112);
            this.f2072e.setLayoutParams(e);
            m4071a(this.f2072e, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C0701d(getContext());
    }

    public void setOnMenuItemClickListener(C0823c c0823c) {
        this.f2071d = c0823c;
    }

    public void m4088a(int i, int i2) {
        m4085n();
        this.f2088u.m4216a(i, i2);
    }

    public int getContentInsetStart() {
        return this.f2088u != null ? this.f2088u.m4220c() : 0;
    }

    public int getContentInsetEnd() {
        return this.f2088u != null ? this.f2088u.m4221d() : 0;
    }

    public int getContentInsetLeft() {
        return this.f2088u != null ? this.f2088u.m4215a() : 0;
    }

    public int getContentInsetRight() {
        return this.f2088u != null ? this.f2088u.m4218b() : 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.f2089v != Integer.MIN_VALUE) {
            return this.f2089v;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f2089v) {
            this.f2089v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.f2090w != Integer.MIN_VALUE) {
            return this.f2090w;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f2090w) {
            this.f2090w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f2089v, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.f2072e != null) {
            C0724g c = this.f2072e.m3202c();
            i = (c == null || !c.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return Math.max(getContentInsetEnd(), Math.max(this.f2090w, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ae.m2228h(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ae.m2228h(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void m4082k() {
        if (this.f2075h == null) {
            this.f2075h = new C0874j(getContext(), null, C0659a.toolbarNavigationButtonStyle);
            LayoutParams e = m4095e();
            e.a = 8388611 | (this.f2070c & 112);
            this.f2075h.setLayoutParams(e);
        }
    }

    void m4094d() {
        if (this.f2068a == null) {
            this.f2068a = new C0874j(getContext(), null, C0659a.toolbarNavigationButtonStyle);
            this.f2068a.setImageDrawable(this.f2077j);
            this.f2068a.setContentDescription(this.f2078k);
            LayoutParams e = m4095e();
            e.a = 8388611 | (this.f2070c & 112);
            e.f2053b = 2;
            this.f2068a.setLayoutParams(e);
            this.f2068a.setOnClickListener(new C08193(this));
        }
    }

    private void m4071a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m4095e();
        } else if (checkLayoutParams(layoutParams)) {
            C0822b c0822b = (C0822b) layoutParams;
        } else {
            layoutParams = m4087a(layoutParams);
        }
        layoutParams.f2053b = 1;
        if (!z || this.f2069b == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f2059F.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f2063J == null || this.f2063J.f2051b == null)) {
            savedState.f2048b = this.f2063J.f2051b.getItemId();
        }
        savedState.f2049c = m4090a();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.m1712a());
            Menu c = this.f2072e != null ? this.f2072e.m3202c() : null;
            if (!(savedState.f2048b == 0 || this.f2063J == null || c == null)) {
                MenuItem findItem = c.findItem(savedState.f2048b);
                if (findItem != null) {
                    C0594p.m2499a(findItem);
                }
            }
            if (savedState.f2049c) {
                m4083l();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void m4083l() {
        removeCallbacks(this.f2067N);
        post(this.f2067N);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2067N);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0601s.m2508a(motionEvent);
        if (a == 0) {
            this.f2056C = false;
        }
        if (!this.f2056C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f2056C = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f2056C = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0601s.m2508a(motionEvent);
        if (a == 9) {
            this.f2057D = false;
        }
        if (!this.f2057D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f2057D = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f2057D = false;
        }
        return true;
    }

    private void m4070a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int m4067a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean m4084m() {
        if (!this.f2066M) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m4073a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f2060G;
        if (aw.m4362a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m4073a(this.f2075h)) {
            m4070a(this.f2075h, i, 0, i2, 0, this.f2083p);
            i7 = this.f2075h.getMeasuredWidth() + m4075b(this.f2075h);
            max = Math.max(0, this.f2075h.getMeasuredHeight() + m4077c(this.f2075h));
            i6 = aw.m4360a(0, ae.m2230j(this.f2075h));
            i5 = max;
        }
        if (m4073a(this.f2068a)) {
            m4070a(this.f2068a, i, 0, i2, 0, this.f2083p);
            i7 = this.f2068a.getMeasuredWidth() + m4075b(this.f2068a);
            i5 = Math.max(i5, this.f2068a.getMeasuredHeight() + m4077c(this.f2068a));
            i6 = aw.m4360a(i6, ae.m2230j(this.f2068a));
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[i4] = Math.max(0, currentContentInsetStart - i7);
        i7 = 0;
        if (m4073a(this.f2072e)) {
            m4070a(this.f2072e, i, max2, i2, 0, this.f2083p);
            i7 = this.f2072e.getMeasuredWidth() + m4075b(this.f2072e);
            i5 = Math.max(i5, this.f2072e.getMeasuredHeight() + m4077c(this.f2072e));
            i6 = aw.m4360a(i6, ae.m2230j(this.f2072e));
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i7);
        iArr[i3] = Math.max(0, currentContentInsetStart - i7);
        if (m4073a(this.f2069b)) {
            max2 += m4067a(this.f2069b, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f2069b.getMeasuredHeight() + m4077c(this.f2069b));
            i6 = aw.m4360a(i6, ae.m2230j(this.f2069b));
        }
        if (m4073a(this.f2076i)) {
            max2 += m4067a(this.f2076i, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f2076i.getMeasuredHeight() + m4077c(this.f2076i));
            i6 = aw.m4360a(i6, ae.m2230j(this.f2076i));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((C0822b) childAt.getLayoutParams()).f2053b != 0) {
                i7 = i5;
                currentContentInsetStart = i8;
            } else if (m4073a(childAt)) {
                max2 += m4067a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m4077c(childAt));
                i7 = aw.m4360a(i5, ae.m2230j(childAt));
                currentContentInsetStart = max;
            } else {
                i7 = i5;
                currentContentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = currentContentInsetStart;
        }
        currentContentInsetStart = 0;
        i7 = 0;
        i6 = this.f2086s + this.f2087t;
        max = this.f2084q + this.f2085r;
        if (m4073a(this.f2073f)) {
            m4067a(this.f2073f, i, max2 + max, i2, i6, iArr);
            currentContentInsetStart = m4075b(this.f2073f) + this.f2073f.getMeasuredWidth();
            i7 = this.f2073f.getMeasuredHeight() + m4077c(this.f2073f);
            i5 = aw.m4360a(i5, ae.m2230j(this.f2073f));
        }
        if (m4073a(this.f2074g)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, m4067a(this.f2074g, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f2074g.getMeasuredHeight() + m4077c(this.f2074g);
            i5 = aw.m4360a(i5, ae.m2230j(this.f2074g));
        }
        currentContentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        currentContentInsetStart = ae.m2202a(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = ae.m2202a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m4084m()) {
            i7 = 0;
        }
        setMeasuredDimension(currentContentInsetStart, i7);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int measuredHeight;
        int measuredWidth;
        if (ae.m2228h(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i5 = width - paddingRight;
        int[] iArr = this.f2060G;
        iArr[1] = 0;
        iArr[0] = 0;
        int n = ae.m2234n(this);
        int min = n >= 0 ? Math.min(n, i4 - i2) : 0;
        if (!m4073a(this.f2075h)) {
            n = i5;
            i5 = paddingLeft;
        } else if (obj != null) {
            n = m4076b(this.f2075h, i5, iArr, min);
            i5 = paddingLeft;
        } else {
            int i6 = i5;
            i5 = m4068a(this.f2075h, paddingLeft, iArr, min);
            n = i6;
        }
        if (m4073a(this.f2068a)) {
            if (obj != null) {
                n = m4076b(this.f2068a, n, iArr, min);
            } else {
                i5 = m4068a(this.f2068a, i5, iArr, min);
            }
        }
        if (m4073a(this.f2072e)) {
            if (obj != null) {
                i5 = m4068a(this.f2072e, i5, iArr, min);
            } else {
                n = m4076b(this.f2072e, n, iArr, min);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - n));
        i5 = Math.max(i5, currentContentInsetLeft);
        n = Math.min(n, (width - paddingRight) - currentContentInsetRight);
        if (m4073a(this.f2069b)) {
            if (obj != null) {
                n = m4076b(this.f2069b, n, iArr, min);
            } else {
                i5 = m4068a(this.f2069b, i5, iArr, min);
            }
        }
        if (!m4073a(this.f2076i)) {
            currentContentInsetLeft = n;
            currentContentInsetRight = i5;
        } else if (obj != null) {
            currentContentInsetLeft = m4076b(this.f2076i, n, iArr, min);
            currentContentInsetRight = i5;
        } else {
            currentContentInsetLeft = n;
            currentContentInsetRight = m4068a(this.f2076i, i5, iArr, min);
        }
        boolean a = m4073a(this.f2073f);
        boolean a2 = m4073a(this.f2074g);
        i5 = 0;
        if (a) {
            C0822b c0822b = (C0822b) this.f2073f.getLayoutParams();
            i5 = 0 + (c0822b.bottomMargin + (c0822b.topMargin + this.f2073f.getMeasuredHeight()));
        }
        if (a2) {
            c0822b = (C0822b) this.f2074g.getLayoutParams();
            measuredHeight = (c0822b.bottomMargin + (c0822b.topMargin + this.f2074g.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            c0822b = (C0822b) (a ? this.f2073f : this.f2074g).getLayoutParams();
            C0822b c0822b2 = (C0822b) (a2 ? this.f2074g : this.f2073f).getLayoutParams();
            Object obj2 = ((!a || this.f2073f.getMeasuredWidth() <= 0) && (!a2 || this.f2074g.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f2091x & 112) {
                case 48:
                    paddingTop2 = (c0822b.topMargin + getPaddingTop()) + this.f2086s;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - c0822b2.bottomMargin) - this.f2087t) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < c0822b.topMargin + this.f2086s) {
                        n = c0822b.topMargin + this.f2086s;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        if (measuredHeight < c0822b.bottomMargin + this.f2087t) {
                            n = Math.max(0, paddingTop2 - ((c0822b2.bottomMargin + this.f2087t) - measuredHeight));
                        } else {
                            n = paddingTop2;
                        }
                    }
                    paddingTop2 = paddingTop + n;
                    break;
            }
            if (obj != null) {
                n = (obj2 != null ? this.f2084q : 0) - iArr[1];
                i5 = currentContentInsetLeft - Math.max(0, n);
                iArr[1] = Math.max(0, -n);
                if (a) {
                    c0822b = (C0822b) this.f2073f.getLayoutParams();
                    measuredWidth = i5 - this.f2073f.getMeasuredWidth();
                    currentContentInsetLeft = this.f2073f.getMeasuredHeight() + paddingTop2;
                    this.f2073f.layout(measuredWidth, paddingTop2, i5, currentContentInsetLeft);
                    paddingTop2 = currentContentInsetLeft + c0822b.bottomMargin;
                    currentContentInsetLeft = measuredWidth - this.f2085r;
                } else {
                    currentContentInsetLeft = i5;
                }
                if (a2) {
                    c0822b = (C0822b) this.f2074g.getLayoutParams();
                    measuredWidth = c0822b.topMargin + paddingTop2;
                    measuredHeight = this.f2074g.getMeasuredHeight() + measuredWidth;
                    this.f2074g.layout(i5 - this.f2074g.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    n = c0822b.bottomMargin + measuredHeight;
                    n = i5 - this.f2085r;
                } else {
                    n = i5;
                }
                if (obj2 != null) {
                    n = Math.min(currentContentInsetLeft, n);
                } else {
                    n = i5;
                }
                currentContentInsetLeft = n;
            } else {
                n = (obj2 != null ? this.f2084q : 0) - iArr[0];
                currentContentInsetRight += Math.max(0, n);
                iArr[0] = Math.max(0, -n);
                if (a) {
                    c0822b = (C0822b) this.f2073f.getLayoutParams();
                    i5 = this.f2073f.getMeasuredWidth() + currentContentInsetRight;
                    measuredWidth = this.f2073f.getMeasuredHeight() + paddingTop2;
                    this.f2073f.layout(currentContentInsetRight, paddingTop2, i5, measuredWidth);
                    n = c0822b.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f2085r;
                    i5 = n;
                } else {
                    measuredWidth = currentContentInsetRight;
                    i5 = paddingTop2;
                }
                if (a2) {
                    c0822b = (C0822b) this.f2074g.getLayoutParams();
                    i5 += c0822b.topMargin;
                    paddingTop2 = this.f2074g.getMeasuredWidth() + currentContentInsetRight;
                    measuredHeight = this.f2074g.getMeasuredHeight() + i5;
                    this.f2074g.layout(currentContentInsetRight, i5, paddingTop2, measuredHeight);
                    n = c0822b.bottomMargin + measuredHeight;
                    n = this.f2085r + paddingTop2;
                } else {
                    n = currentContentInsetRight;
                }
                if (obj2 != null) {
                    currentContentInsetRight = Math.max(measuredWidth, n);
                }
            }
        }
        m4072a(this.f2058E, 3);
        int size = this.f2058E.size();
        i5 = currentContentInsetRight;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m4068a((View) this.f2058E.get(measuredWidth), i5, iArr, min);
        }
        m4072a(this.f2058E, 5);
        currentContentInsetRight = this.f2058E.size();
        for (measuredWidth = 0; measuredWidth < currentContentInsetRight; measuredWidth++) {
            currentContentInsetLeft = m4076b((View) this.f2058E.get(measuredWidth), currentContentInsetLeft, iArr, min);
        }
        m4072a(this.f2058E, 1);
        measuredWidth = m4069a(this.f2058E, iArr);
        n = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += n;
        if (n < i5) {
            n = i5;
        } else if (measuredWidth > currentContentInsetLeft) {
            n -= measuredWidth - currentContentInsetLeft;
        }
        paddingLeft = this.f2058E.size();
        measuredWidth = n;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m4068a((View) this.f2058E.get(i5), measuredWidth, iArr, min);
        }
        this.f2058E.clear();
    }

    private int m4069a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            C0822b c0822b = (C0822b) view.getLayoutParams();
            i6 = c0822b.leftMargin - i6;
            i = c0822b.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private int m4068a(View view, int i, int[] iArr, int i2) {
        C0822b c0822b = (C0822b) view.getLayoutParams();
        int i3 = c0822b.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m4066a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (c0822b.rightMargin + measuredWidth) + max;
    }

    private int m4076b(View view, int i, int[] iArr, int i2) {
        C0822b c0822b = (C0822b) view.getLayoutParams();
        int i3 = c0822b.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m4066a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (c0822b.leftMargin + measuredWidth);
    }

    private int m4066a(View view, int i) {
        C0822b c0822b = (C0822b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m4065a(c0822b.a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0822b.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < c0822b.topMargin) {
                    i3 = c0822b.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < c0822b.bottomMargin ? Math.max(0, i2 - (c0822b.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m4065a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f2091x & 112;
        }
    }

    private void m4072a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ae.m2228h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = C0567e.m2446a(i, ae.m2228h(this));
        list.clear();
        C0822b c0822b;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                c0822b = (C0822b) childAt.getLayoutParams();
                if (c0822b.f2053b == 0 && m4073a(childAt) && m4074b(c0822b.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            c0822b = (C0822b) childAt2.getLayoutParams();
            if (c0822b.f2053b == 0 && m4073a(childAt2) && m4074b(c0822b.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int m4074b(int i) {
        int h = ae.m2228h(this);
        int a = C0567e.m2446a(i, h) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private boolean m4073a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m4075b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0587n.m2478b(marginLayoutParams) + C0587n.m2477a(marginLayoutParams);
    }

    private int m4077c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public C0822b m4086a(AttributeSet attributeSet) {
        return new C0822b(getContext(), attributeSet);
    }

    protected C0822b m4087a(LayoutParams layoutParams) {
        if (layoutParams instanceof C0822b) {
            return new C0822b((C0822b) layoutParams);
        }
        if (layoutParams instanceof C0641a) {
            return new C0822b((C0641a) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0822b((MarginLayoutParams) layoutParams);
        }
        return new C0822b(layoutParams);
    }

    protected C0822b m4095e() {
        return new C0822b(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0822b);
    }

    public C0846s getWrapper() {
        if (this.f2062I == null) {
            this.f2062I = new at(this, true);
        }
        return this.f2062I;
    }

    void m4096f() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0822b) childAt.getLayoutParams()).f2053b == 2 || childAt == this.f2072e)) {
                removeViewAt(childCount);
                this.f2059F.add(childAt);
            }
        }
    }

    void m4097g() {
        for (int size = this.f2059F.size() - 1; size >= 0; size--) {
            addView((View) this.f2059F.get(size));
        }
        this.f2059F.clear();
    }

    private boolean m4078d(View view) {
        return view.getParent() == this || this.f2059F.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.f2066M = z;
        requestLayout();
    }

    private void m4085n() {
        if (this.f2088u == null) {
            this.f2088u = new ai();
        }
    }
}
