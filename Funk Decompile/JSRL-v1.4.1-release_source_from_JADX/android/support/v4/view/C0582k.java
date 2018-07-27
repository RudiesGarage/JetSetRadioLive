package android.support.v4.view;

import android.content.Context;
import android.support.v4.view.C0580j.C0579a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompatHC */
class C0582k {
    private static Field f1143a;
    private static boolean f1144b;

    /* compiled from: LayoutInflaterCompatHC */
    static class C0581a extends C0579a implements Factory2 {
        C0581a(C0233m c0233m) {
            super(c0233m);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.a.mo143a(view, str, context, attributeSet);
        }
    }

    static void m2468a(LayoutInflater layoutInflater, C0233m c0233m) {
        Factory2 c0581a;
        if (c0233m != null) {
            c0581a = new C0581a(c0233m);
        } else {
            c0581a = null;
        }
        layoutInflater.setFactory2(c0581a);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            C0582k.m2469a(layoutInflater, (Factory2) factory);
        } else {
            C0582k.m2469a(layoutInflater, c0581a);
        }
    }

    static void m2469a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f1144b) {
            try {
                f1143a = LayoutInflater.class.getDeclaredField("mFactory2");
                f1143a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f1144b = true;
        }
        if (f1143a != null) {
            try {
                f1143a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
