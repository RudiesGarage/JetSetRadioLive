package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.support.v4.p015c.p016a.C0302a;
import android.support.v4.p015c.p016a.C0307f;
import android.support.v7.p030d.p031a.C0675a;
import android.util.Log;
import java.lang.reflect.Field;

/* compiled from: DrawableUtils */
public class C0901u {
    public static final Rect f2448a = new Rect();
    private static Class<?> f2449b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                f2449b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    public static Rect m4588a(Drawable drawable) {
        if (f2449b != null) {
            try {
                Drawable g = C0302a.m1151g(drawable);
                Object invoke = g.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(g, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : f2449b.getFields()) {
                        String name = field.getName();
                        Object obj = -1;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    obj = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    obj = null;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    obj = 2;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case null:
                                rect.left = field.getInt(invoke);
                                break;
                            case 1:
                                rect.top = field.getInt(invoke);
                                break;
                            case 2:
                                rect.right = field.getInt(invoke);
                                break;
                            case 3:
                                rect.bottom = field.getInt(invoke);
                                break;
                            default:
                                break;
                        }
                    }
                    return rect;
                }
            } catch (Exception e) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f2448a;
    }

    static void m4589b(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            C0901u.m4591d(drawable);
        }
    }

    public static boolean m4590c(Drawable drawable) {
        if (VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainerState) {
                for (Drawable c : ((DrawableContainerState) constantState).getChildren()) {
                    if (!C0901u.m4590c(c)) {
                        return false;
                    }
                }
            }
        } else if (drawable instanceof C0307f) {
            return C0901u.m4590c(((C0307f) drawable).mo185a());
        } else {
            if (drawable instanceof C0675a) {
                return C0901u.m4590c(((C0675a) drawable).m2775a());
            }
            if (drawable instanceof ScaleDrawable) {
                return C0901u.m4590c(((ScaleDrawable) drawable).getDrawable());
            }
        }
        return true;
    }

    private static void m4591d(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(an.f2224e);
        } else {
            drawable.setState(an.f2227h);
        }
        drawable.setState(state);
    }

    static Mode m4587a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                if (VERSION.SDK_INT >= 11) {
                    return Mode.valueOf("ADD");
                }
                return mode;
            default:
                return mode;
        }
    }
}
