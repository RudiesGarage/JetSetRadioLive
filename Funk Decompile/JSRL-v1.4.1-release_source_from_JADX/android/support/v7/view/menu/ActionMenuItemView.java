package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.p018b.p019a.C0278a;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0669k;
import android.support.v7.view.menu.C0709n.C0706a;
import android.support.v7.view.menu.C0724g.C0708b;
import android.support.v7.widget.ActionMenuView.C0707a;
import android.support.v7.widget.C0702x;
import android.support.v7.widget.C0705q;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends C0705q implements C0706a, C0707a, OnClickListener, OnLongClickListener {
    C0726h f1366a;
    C0708b f1367b;
    C0704b f1368c;
    private CharSequence f1369d;
    private Drawable f1370e;
    private C0702x f1371f;
    private boolean f1372g;
    private boolean f1373h;
    private int f1374i;
    private int f1375j;
    private int f1376k;

    private class C0703a extends C0702x {
        final /* synthetic */ ActionMenuItemView f1363a;

        public C0703a(ActionMenuItemView actionMenuItemView) {
            this.f1363a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public C0719q mo485a() {
            if (this.f1363a.f1368c != null) {
                return this.f1363a.f1368c.mo683a();
            }
            return null;
        }

        protected boolean mo486b() {
            if (this.f1363a.f1367b == null || !this.f1363a.f1367b.mo496a(this.f1363a.f1366a)) {
                return false;
            }
            C0719q a = mo485a();
            if (a == null || !a.mo528d()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class C0704b {
        public abstract C0719q mo683a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1372g = m2894e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0669k.ActionMenuItemView, i, 0);
        this.f1374i = obtainStyledAttributes.getDimensionPixelSize(C0669k.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1376k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f1375j = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1372g = m2894e();
        m2895f();
    }

    private boolean m2894e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int b = C0278a.m1053b(getResources());
        return b >= 480 || ((b >= 640 && C0278a.m1052a(getResources()) >= 480) || configuration.orientation == 2);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1375j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public C0726h getItemData() {
        return this.f1366a;
    }

    public void mo491a(C0726h c0726h, int i) {
        this.f1366a = c0726h;
        setIcon(c0726h.getIcon());
        setTitle(c0726h.m3053a((C0706a) this));
        setId(c0726h.getItemId());
        setVisibility(c0726h.isVisible() ? 0 : 8);
        setEnabled(c0726h.isEnabled());
        if (c0726h.hasSubMenu() && this.f1371f == null) {
            this.f1371f = new C0703a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1366a.hasSubMenu() && this.f1371f != null && this.f1371f.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.f1367b != null) {
            this.f1367b.mo496a(this.f1366a);
        }
    }

    public void setItemInvoker(C0708b c0708b) {
        this.f1367b = c0708b;
    }

    public void setPopupCallback(C0704b c0704b) {
        this.f1368c = c0704b;
    }

    public boolean mo492a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1373h != z) {
            this.f1373h = z;
            if (this.f1366a != null) {
                this.f1366a.m3068h();
            }
        }
    }

    private void m2895f() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f1369d) ? 1 : 0;
        if (this.f1370e == null || (this.f1366a.m3073m() && (this.f1372g || this.f1373h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f1369d : null);
    }

    public void setIcon(Drawable drawable) {
        this.f1370e = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1376k) {
                f = ((float) this.f1376k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f1376k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f1376k) {
                f = ((float) this.f1376k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f1376k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m2895f();
    }

    public boolean m2898b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f1369d = charSequence;
        setContentDescription(this.f1369d);
        m2895f();
    }

    public boolean mo493c() {
        return m2898b() && this.f1366a.getIcon() == null;
    }

    public boolean mo494d() {
        return m2898b();
    }

    public boolean onLongClick(View view) {
        if (m2898b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (ae.m2228h(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.f1366a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m2898b();
        if (b && this.f1375j >= 0) {
            super.setPadding(this.f1375j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f1374i) : this.f1374i;
        if (mode != 1073741824 && this.f1374i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f1370e != null) {
            super.setPadding((getMeasuredWidth() - this.f1370e.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
