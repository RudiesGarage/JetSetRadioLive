package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: ViewCompatLollipop */
class al {

    /* compiled from: ViewCompatLollipop */
    public interface C0530a {
        Object mo402a(View view, Object obj);
    }

    public static void m2287a(View view) {
        view.requestApplyInsets();
    }

    public static void m2290a(View view, final C0530a c0530a) {
        if (c0530a == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return (WindowInsets) c0530a.mo402a(view, windowInsets);
                }
            });
        }
    }

    static ColorStateList m2291b(View view) {
        return view.getBackgroundTintList();
    }

    static void m2288a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static Mode m2293c(View view) {
        return view.getBackgroundTintMode();
    }

    static void m2289a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static Object m2286a(View view, Object obj) {
        WindowInsets windowInsets = (WindowInsets) obj;
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (onApplyWindowInsets != windowInsets) {
            return new WindowInsets(onApplyWindowInsets);
        }
        return obj;
    }

    public static Object m2292b(View view, Object obj) {
        WindowInsets windowInsets = (WindowInsets) obj;
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (dispatchApplyWindowInsets != windowInsets) {
            return new WindowInsets(dispatchApplyWindowInsets);
        }
        return obj;
    }

    public static void m2294d(View view) {
        view.stopNestedScroll();
    }
}
