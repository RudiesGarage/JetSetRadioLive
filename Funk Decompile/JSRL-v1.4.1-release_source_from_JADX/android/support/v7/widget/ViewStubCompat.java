package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.p027b.C0670a.C0669k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f2094a;
    private int f2095b;
    private WeakReference<View> f2096c;
    private LayoutInflater f2097d;
    private C0824a f2098e;

    public interface C0824a {
        void m4098a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2094a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0669k.ViewStubCompat, i, 0);
        this.f2095b = obtainStyledAttributes.getResourceId(C0669k.ViewStubCompat_android_inflatedId, -1);
        this.f2094a = obtainStyledAttributes.getResourceId(C0669k.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0669k.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f2095b;
    }

    public void setInflatedId(int i) {
        this.f2095b = i;
    }

    public int getLayoutResource() {
        return this.f2094a;
    }

    public void setLayoutResource(int i) {
        this.f2094a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2097d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f2097d;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void draw(Canvas canvas) {
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void setVisibility(int i) {
        if (this.f2096c != null) {
            View view = (View) this.f2096c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m4099a();
        }
    }

    public View m4099a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f2094a != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.f2097d != null) {
                layoutInflater = this.f2097d;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f2094a, viewGroup, false);
            if (this.f2095b != -1) {
                inflate.setId(this.f2095b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f2096c = new WeakReference(inflate);
            if (this.f2098e != null) {
                this.f2098e.m4098a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void setOnInflateListener(C0824a c0824a) {
        this.f2098e = c0824a;
    }
}
