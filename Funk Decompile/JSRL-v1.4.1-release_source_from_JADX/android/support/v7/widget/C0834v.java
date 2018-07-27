package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.C0601s;
import android.support.v4.view.aq;
import android.support.v4.widget.C0625g;
import android.support.v7.p027b.C0670a.C0659a;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: DropDownListView */
class C0834v extends ab {
    private boolean f2153g;
    private boolean f2154h;
    private boolean f2155i;
    private aq f2156j;
    private C0625g f2157k;

    public C0834v(Context context, boolean z) {
        super(context, null, C0659a.dropDownListViewStyle);
        this.f2154h = z;
        setCacheColorHint(0);
    }

    public boolean mo646a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int a = C0601s.m2508a(motionEvent);
        switch (a) {
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                m4146a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (a == 1) {
                    m4145a(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            m4147d();
        }
        if (z2) {
            if (this.f2157k == null) {
                this.f2157k = new C0625g(this);
            }
            this.f2157k.m2586a(true);
            this.f2157k.onTouch(this, motionEvent);
        } else if (this.f2157k != null) {
            this.f2157k.m2586a(false);
        }
        return z2;
    }

    private void m4145a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    void setListSelectionHidden(boolean z) {
        this.f2153g = z;
    }

    private void m4147d() {
        this.f2155i = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f2156j != null) {
            this.f2156j.m2371a();
            this.f2156j = null;
        }
    }

    private void m4146a(View view, int i, float f, float f2) {
        this.f2155i = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f != -1) {
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m4139a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    protected boolean mo645a() {
        return this.f2155i || super.mo645a();
    }

    public boolean isInTouchMode() {
        return (this.f2154h && this.f2153g) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.f2154h || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f2154h || super.isFocused();
    }

    public boolean hasFocus() {
        return this.f2154h || super.hasFocus();
    }
}
