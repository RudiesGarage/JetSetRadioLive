package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0563d;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0664f;
import android.support.v7.p027b.C0670a.C0666h;
import android.support.v7.p027b.C0670a.C0667i;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
    final C0755a f1663a;
    final FrameLayout f1664b;
    final FrameLayout f1665c;
    C0563d f1666d;
    final DataSetObserver f1667e;
    OnDismissListener f1668f;
    boolean f1669g;
    int f1670h;
    private final C0756b f1671i;
    private final C0754z f1672j;
    private final ImageView f1673k;
    private final int f1674l;
    private final OnGlobalLayoutListener f1675m;
    private aa f1676n;
    private boolean f1677o;
    private int f1678p;

    public static class InnerLayout extends C0754z {
        private static final int[] f1655a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            as a = as.m4293a(context, attributeSet, f1655a);
            setBackgroundDrawable(a.m4297a(0));
            a.m4298a();
        }
    }

    private class C0755a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView f1656a;
        private C0864e f1657b;
        private int f1658c;
        private boolean f1659d;
        private boolean f1660e;
        private boolean f1661f;

        public void m3209a(C0864e c0864e) {
            C0864e d = this.f1656a.f1663a.m3214d();
            if (d != null && this.f1656a.isShown()) {
                d.unregisterObserver(this.f1656a.f1667e);
            }
            this.f1657b = c0864e;
            if (c0864e != null && this.f1656a.isShown()) {
                c0864e.registerObserver(this.f1656a.f1667e);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int i) {
            if (this.f1661f && i == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int getCount() {
            int a = this.f1657b.m4413a();
            if (!(this.f1659d || this.f1657b.m4417b() == null)) {
                a--;
            }
            a = Math.min(a, this.f1658c);
            if (this.f1661f) {
                return a + 1;
            }
            return a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.f1659d || this.f1657b.m4417b() == null)) {
                        i++;
                    }
                    return this.f1657b.m4415a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0664f.list_item) {
                        view = LayoutInflater.from(this.f1656a.getContext()).inflate(C0666h.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f1656a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0664f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0664f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f1659d && i == 0 && this.f1660e) {
                        ae.m2218b(view, true);
                        return view;
                    }
                    ae.m2218b(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.f1656a.getContext()).inflate(C0666h.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(C0664f.title)).setText(this.f1656a.getContext().getString(C0667i.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int m3207a() {
            int i = 0;
            int i2 = this.f1658c;
            this.f1658c = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.f1658c = i2;
            return i3;
        }

        public void m3208a(int i) {
            if (this.f1658c != i) {
                this.f1658c = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo m3212b() {
            return this.f1657b.m4417b();
        }

        public void m3210a(boolean z) {
            if (this.f1661f != z) {
                this.f1661f = z;
                notifyDataSetChanged();
            }
        }

        public int m3213c() {
            return this.f1657b.m4413a();
        }

        public C0864e m3214d() {
            return this.f1657b;
        }

        public void m3211a(boolean z, boolean z2) {
            if (this.f1659d != z || this.f1660e != z2) {
                this.f1659d = z;
                this.f1660e = z2;
                notifyDataSetChanged();
            }
        }

        public boolean m3215e() {
            return this.f1659d;
        }
    }

    private class C0756b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView f1662a;

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0755a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f1662a.m3219b();
                    if (!this.f1662a.f1669g) {
                        if (!this.f1662a.f1663a.m3215e()) {
                            i++;
                        }
                        Intent b = this.f1662a.f1663a.m3214d().m4416b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            this.f1662a.getContext().startActivity(b);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.f1662a.f1663a.m3214d().m4418c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.f1662a.m3217a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.f1662a.f1665c) {
                this.f1662a.m3219b();
                Intent b = this.f1662a.f1663a.m3214d().m4416b(this.f1662a.f1663a.m3214d().m4414a(this.f1662a.f1663a.m3212b()));
                if (b != null) {
                    b.addFlags(524288);
                    this.f1662a.getContext().startActivity(b);
                }
            } else if (view == this.f1662a.f1664b) {
                this.f1662a.f1669g = false;
                this.f1662a.m3217a(this.f1662a.f1670h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f1662a.f1665c) {
                if (this.f1662a.f1663a.getCount() > 0) {
                    this.f1662a.f1669g = true;
                    this.f1662a.m3217a(this.f1662a.f1670h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            m3216a();
            if (this.f1662a.f1666d != null) {
                this.f1662a.f1666d.m2437a(false);
            }
        }

        private void m3216a() {
            if (this.f1662a.f1668f != null) {
                this.f1662a.f1668f.onDismiss();
            }
        }
    }

    public void setActivityChooserModel(C0864e c0864e) {
        this.f1663a.m3209a(c0864e);
        if (m3220c()) {
            m3219b();
            m3218a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1673k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1673k.setContentDescription(getContext().getString(i));
    }

    public void setProvider(C0563d c0563d) {
        this.f1666d = c0563d;
    }

    public boolean m3218a() {
        if (m3220c() || !this.f1677o) {
            return false;
        }
        this.f1669g = false;
        m3217a(this.f1670h);
        return true;
    }

    void m3217a(int i) {
        if (this.f1663a.m3214d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1675m);
        boolean z = this.f1665c.getVisibility() == 0;
        int c = this.f1663a.m3213c();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || c <= r3 + i) {
            this.f1663a.m3210a(false);
            this.f1663a.m3208a(i);
        } else {
            this.f1663a.m3210a(true);
            this.f1663a.m3208a(i - 1);
        }
        aa listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.mo528d()) {
            if (this.f1669g || !z) {
                this.f1663a.m3211a(true, z);
            } else {
                this.f1663a.m3211a(false, false);
            }
            listPopupWindow.m4125g(Math.min(this.f1663a.m3207a(), this.f1674l));
            listPopupWindow.mo518a();
            if (this.f1666d != null) {
                this.f1666d.m2437a(true);
            }
            listPopupWindow.mo529e().setContentDescription(getContext().getString(C0667i.abc_activitychooserview_choose_application));
        }
    }

    public boolean m3219b() {
        if (m3220c()) {
            getListPopupWindow().mo525c();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1675m);
            }
        }
        return true;
    }

    public boolean m3220c() {
        return getListPopupWindow().mo528d();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0864e d = this.f1663a.m3214d();
        if (d != null) {
            d.registerObserver(this.f1667e);
        }
        this.f1677o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0864e d = this.f1663a.m3214d();
        if (d != null) {
            d.unregisterObserver(this.f1667e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1675m);
        }
        if (m3220c()) {
            m3219b();
        }
        this.f1677o = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f1672j;
        if (this.f1665c.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1672j.layout(0, 0, i3 - i, i4 - i2);
        if (!m3220c()) {
            m3219b();
        }
    }

    public C0864e getDataModel() {
        return this.f1663a.m3214d();
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1668f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f1670h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1678p = i;
    }

    aa getListPopupWindow() {
        if (this.f1676n == null) {
            this.f1676n = new aa(getContext());
            this.f1676n.mo694a(this.f1663a);
            this.f1676n.m4117b((View) this);
            this.f1676n.m4115a(true);
            this.f1676n.m4112a(this.f1671i);
            this.f1676n.m4114a(this.f1671i);
        }
        return this.f1676n;
    }
}
