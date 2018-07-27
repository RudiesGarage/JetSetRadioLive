package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p026a.C0643a.C0642b;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.view.C0696a;
import android.support.v7.widget.C0754z.C0750a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/* compiled from: ScrollingTabContainerView */
public class ak extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator f2189j = new DecelerateInterpolator();
    Runnable f2190a;
    C0754z f2191b;
    int f2192c;
    int f2193d;
    private C0842b f2194e;
    private Spinner f2195f;
    private boolean f2196g;
    private int f2197h;
    private int f2198i;

    /* compiled from: ScrollingTabContainerView */
    private class C0841a extends BaseAdapter {
        final /* synthetic */ ak f2181a;

        C0841a(ak akVar) {
            this.f2181a = akVar;
        }

        public int getCount() {
            return this.f2181a.f2191b.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0843c) this.f2181a.f2191b.getChildAt(i)).m4227b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.f2181a.m4232a((C0642b) getItem(i), true);
            }
            ((C0843c) view).m4226a((C0642b) getItem(i));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView */
    private class C0842b implements OnClickListener {
        final /* synthetic */ ak f2182a;

        C0842b(ak akVar) {
            this.f2182a = akVar;
        }

        public void onClick(View view) {
            ((C0843c) view).m4227b().m2702d();
            int childCount = this.f2182a.f2191b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean z;
                View childAt = this.f2182a.f2191b.getChildAt(i);
                if (childAt == view) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    /* compiled from: ScrollingTabContainerView */
    private class C0843c extends C0754z implements OnLongClickListener {
        final /* synthetic */ ak f2183a;
        private final int[] f2184b = new int[]{16842964};
        private C0642b f2185c;
        private TextView f2186d;
        private ImageView f2187e;
        private View f2188f;

        public C0843c(ak akVar, Context context, C0642b c0642b, boolean z) {
            this.f2183a = akVar;
            super(context, null, C0659a.actionBarTabStyle);
            this.f2185c = c0642b;
            as a = as.m4294a(context, null, this.f2184b, C0659a.actionBarTabStyle, 0);
            if (a.m4309f(0)) {
                setBackgroundDrawable(a.m4297a(0));
            }
            a.m4298a();
            if (z) {
                setGravity(8388627);
            }
            m4225a();
        }

        public void m4226a(C0642b c0642b) {
            this.f2185c = c0642b;
            m4225a();
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0642b.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(C0642b.class.getName());
            }
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f2183a.f2192c > 0 && getMeasuredWidth() > this.f2183a.f2192c) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f2183a.f2192c, 1073741824), i2);
            }
        }

        public void m4225a() {
            C0642b c0642b = this.f2185c;
            View c = c0642b.m2701c();
            if (c != null) {
                C0843c parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f2188f = c;
                if (this.f2186d != null) {
                    this.f2186d.setVisibility(8);
                }
                if (this.f2187e != null) {
                    this.f2187e.setVisibility(8);
                    this.f2187e.setImageDrawable(null);
                    return;
                }
                return;
            }
            boolean z;
            if (this.f2188f != null) {
                removeView(this.f2188f);
                this.f2188f = null;
            }
            Drawable a = c0642b.m2699a();
            CharSequence b = c0642b.m2700b();
            if (a != null) {
                if (this.f2187e == null) {
                    View c0854l = new C0854l(getContext());
                    LayoutParams c0750a = new C0750a(-2, -2);
                    c0750a.f1620h = 16;
                    c0854l.setLayoutParams(c0750a);
                    addView(c0854l, 0);
                    this.f2187e = c0854l;
                }
                this.f2187e.setImageDrawable(a);
                this.f2187e.setVisibility(0);
            } else if (this.f2187e != null) {
                this.f2187e.setVisibility(8);
                this.f2187e.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(b)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.f2186d == null) {
                    c0854l = new C0705q(getContext(), null, C0659a.actionBarTabTextStyle);
                    c0854l.setEllipsize(TruncateAt.END);
                    c0750a = new C0750a(-2, -2);
                    c0750a.f1620h = 16;
                    c0854l.setLayoutParams(c0750a);
                    addView(c0854l);
                    this.f2186d = c0854l;
                }
                this.f2186d.setText(b);
                this.f2186d.setVisibility(0);
            } else if (this.f2186d != null) {
                this.f2186d.setVisibility(8);
                this.f2186d.setText(null);
            }
            if (this.f2187e != null) {
                this.f2187e.setContentDescription(c0642b.m2703e());
            }
            if (z || TextUtils.isEmpty(c0642b.m2703e())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f2185c.m2703e(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public C0642b m4227b() {
            return this.f2185c;
        }
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f2191b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2192c = -1;
        } else {
            if (childCount > 2) {
                this.f2192c = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f2192c = MeasureSpec.getSize(i) / 2;
            }
            this.f2192c = Math.min(this.f2192c, this.f2193d);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f2197h, 1073741824);
        if (z || !this.f2196g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f2191b.measure(0, mode);
            if (this.f2191b.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m4229b();
            } else {
                m4230c();
            }
        } else {
            m4230c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f2198i);
        }
    }

    private boolean m4228a() {
        return this.f2195f != null && this.f2195f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f2196g = z;
    }

    private void m4229b() {
        if (!m4228a()) {
            if (this.f2195f == null) {
                this.f2195f = m4231d();
            }
            removeView(this.f2191b);
            addView(this.f2195f, new LayoutParams(-2, -1));
            if (this.f2195f.getAdapter() == null) {
                this.f2195f.setAdapter(new C0841a(this));
            }
            if (this.f2190a != null) {
                removeCallbacks(this.f2190a);
                this.f2190a = null;
            }
            this.f2195f.setSelection(this.f2198i);
        }
    }

    private boolean m4230c() {
        if (m4228a()) {
            removeView(this.f2195f);
            addView(this.f2191b, new LayoutParams(-2, -1));
            setTabSelected(this.f2195f.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.f2198i = i;
        int childCount = this.f2191b.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.f2191b.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                m4233a(i);
            }
        }
        if (this.f2195f != null && i >= 0) {
            this.f2195f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f2197h = i;
        requestLayout();
    }

    private Spinner m4231d() {
        Spinner c0884n = new C0884n(getContext(), null, C0659a.actionDropDownStyle);
        c0884n.setLayoutParams(new C0750a(-2, -1));
        c0884n.setOnItemSelectedListener(this);
        return c0884n;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0696a a = C0696a.m2850a(getContext());
        setContentHeight(a.m2855e());
        this.f2193d = a.m2856f();
    }

    public void m4233a(int i) {
        final View childAt = this.f2191b.getChildAt(i);
        if (this.f2190a != null) {
            removeCallbacks(this.f2190a);
        }
        this.f2190a = new Runnable(this) {
            final /* synthetic */ ak f2180b;

            public void run() {
                this.f2180b.smoothScrollTo(childAt.getLeft() - ((this.f2180b.getWidth() - childAt.getWidth()) / 2), 0);
                this.f2180b.f2190a = null;
            }
        };
        post(this.f2190a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2190a != null) {
            post(this.f2190a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2190a != null) {
            removeCallbacks(this.f2190a);
        }
    }

    C0843c m4232a(C0642b c0642b, boolean z) {
        C0843c c0843c = new C0843c(this, getContext(), c0642b, z);
        if (z) {
            c0843c.setBackgroundDrawable(null);
            c0843c.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2197h));
        } else {
            c0843c.setFocusable(true);
            if (this.f2194e == null) {
                this.f2194e = new C0842b(this);
            }
            c0843c.setOnClickListener(this.f2194e);
        }
        return c0843c;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0843c) view).m4227b().m2702d();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
