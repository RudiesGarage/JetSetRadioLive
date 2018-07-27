package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.C0634k;
import android.support.v7.p027b.C0670a.C0669k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: AppCompatPopupWindow */
class C0877m extends PopupWindow {
    private static final boolean f2364a = (VERSION.SDK_INT < 21);
    private boolean f2365b;

    public C0877m(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4492a(context, attributeSet, i, 0);
    }

    @TargetApi(11)
    public C0877m(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m4492a(context, attributeSet, i, i2);
    }

    private void m4492a(Context context, AttributeSet attributeSet, int i, int i2) {
        as a = as.m4294a(context, attributeSet, C0669k.PopupWindow, i, i2);
        if (a.m4309f(C0669k.PopupWindow_overlapAnchor)) {
            m4494a(a.m4299a(C0669k.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.m4297a(C0669k.PopupWindow_android_popupBackground));
        int i3 = VERSION.SDK_INT;
        if (i2 != 0 && i3 < 11 && a.m4309f(C0669k.PopupWindow_android_popupAnimationStyle)) {
            setAnimationStyle(a.m4310g(C0669k.PopupWindow_android_popupAnimationStyle, -1));
        }
        a.m4298a();
        if (VERSION.SDK_INT < 14) {
            C0877m.m4493a((PopupWindow) this);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2364a && this.f2365b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2364a && this.f2365b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height;
        if (f2364a && this.f2365b) {
            height = i2 - view.getHeight();
        } else {
            height = i2;
        }
        super.update(view, i, height, i3, i4);
    }

    private static void m4493a(final PopupWindow popupWindow) {
        try {
            final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            final OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) declaredField2.get(popupWindow);
            declaredField2.set(popupWindow, new OnScrollChangedListener() {
                public void onScrollChanged() {
                    try {
                        WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                        if (weakReference != null && weakReference.get() != null) {
                            onScrollChangedListener.onScrollChanged();
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
            });
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void m4494a(boolean z) {
        if (f2364a) {
            this.f2365b = z;
        } else {
            C0634k.m2676a((PopupWindow) this, z);
        }
    }
}
