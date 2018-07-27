package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p015c.p016a.C0302a;
import android.support.v7.p030d.p031a.C0675a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* compiled from: ListViewCompat */
public class ab extends ListView {
    private static final int[] f2144g = new int[]{0};
    final Rect f2145a = new Rect();
    int f2146b = 0;
    int f2147c = 0;
    int f2148d = 0;
    int f2149e = 0;
    protected int f2150f;
    private Field f2151h;
    private C0833a f2152i;

    /* compiled from: ListViewCompat */
    private static class C0833a extends C0675a {
        private boolean f2143a = true;

        public C0833a(Drawable drawable) {
            super(drawable);
        }

        void m4136a(boolean z) {
            this.f2143a = z;
        }

        public boolean setState(int[] iArr) {
            if (this.f2143a) {
                return super.setState(iArr);
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.f2143a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f2143a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f2143a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f2143a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public ab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            this.f2151h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2151h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.f2152i = drawable != null ? new C0833a(drawable) : null;
        super.setSelector(this.f2152i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2146b = rect.left;
        this.f2147c = rect.top;
        this.f2148d = rect.right;
        this.f2149e = rect.bottom;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m4142b();
    }

    protected void dispatchDraw(Canvas canvas) {
        m4140a(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f2150f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void m4142b() {
        Drawable selector = getSelector();
        if (selector != null && m4144c()) {
            selector.setState(getDrawableState());
        }
    }

    protected boolean m4144c() {
        return mo645a() && isPressed();
    }

    protected boolean mo645a() {
        return false;
    }

    protected void m4140a(Canvas canvas) {
        if (!this.f2145a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f2145a);
                selector.draw(canvas);
            }
        }
    }

    protected void m4139a(int i, View view, float f, float f2) {
        m4138a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0302a.m1138a(selector, f, f2);
        }
    }

    protected void m4138a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m4143b(i, view);
        if (z2) {
            Rect rect = this.f2145a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0302a.m1138a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m4143b(int i, View view) {
        Rect rect = this.f2145a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2146b;
        rect.top -= this.f2147c;
        rect.right += this.f2148d;
        rect.bottom += this.f2149e;
        try {
            boolean z = this.f2151h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f2151h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int m4137a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, listPaddingTop);
            view.forceLayout();
            if (i8 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingTop += view.getMeasuredHeight();
            if (listPaddingTop < i4) {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            } else if (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) {
                return i4;
            } else {
                return i6;
            }
        }
        return listPaddingBottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f2152i != null) {
            this.f2152i.m4136a(z);
        }
    }
}
