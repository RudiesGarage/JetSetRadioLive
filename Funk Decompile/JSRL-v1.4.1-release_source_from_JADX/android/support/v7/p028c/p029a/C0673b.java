package android.support.v7.p028c.p029a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p018b.C0185a;
import android.support.v7.widget.C0873i;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* compiled from: AppCompatResources */
public final class C0673b {
    private static final ThreadLocal<TypedValue> f1245a = new ThreadLocal();
    private static final WeakHashMap<Context, SparseArray<C0672a>> f1246b = new WeakHashMap(0);
    private static final Object f1247c = new Object();

    /* compiled from: AppCompatResources */
    private static class C0672a {
        final ColorStateList f1243a;
        final Configuration f1244b;

        C0672a(ColorStateList colorStateList, Configuration configuration) {
            this.f1243a = colorStateList;
            this.f1244b = configuration;
        }
    }

    public static ColorStateList m2765a(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList d = C0673b.m2770d(context, i);
        if (d != null) {
            return d;
        }
        d = C0673b.m2769c(context, i);
        if (d == null) {
            return C0185a.m614b(context, i);
        }
        C0673b.m2767a(context, i, d);
        return d;
    }

    public static Drawable m2768b(Context context, int i) {
        return C0873i.m4467a().m4485a(context, i);
    }

    private static ColorStateList m2769c(Context context, int i) {
        ColorStateList colorStateList = null;
        if (!C0673b.m2771e(context, i)) {
            Resources resources = context.getResources();
            try {
                colorStateList = C0671a.m2761a(resources, resources.getXml(i), context.getTheme());
            } catch (Throwable e) {
                Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        return colorStateList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList m2770d(android.content.Context r5, int r6) {
        /*
        r2 = f1247c;
        monitor-enter(r2);
        r0 = f1246b;	 Catch:{ all -> 0x0035 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0035 }
        r0 = (android.util.SparseArray) r0;	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0032;
    L_0x000d:
        r1 = r0.size();	 Catch:{ all -> 0x0035 }
        if (r1 <= 0) goto L_0x0032;
    L_0x0013:
        r1 = r0.get(r6);	 Catch:{ all -> 0x0035 }
        r1 = (android.support.v7.p028c.p029a.C0673b.C0672a) r1;	 Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x0032;
    L_0x001b:
        r3 = r1.f1244b;	 Catch:{ all -> 0x0035 }
        r4 = r5.getResources();	 Catch:{ all -> 0x0035 }
        r4 = r4.getConfiguration();	 Catch:{ all -> 0x0035 }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x0035 }
        if (r3 == 0) goto L_0x002f;
    L_0x002b:
        r0 = r1.f1243a;	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
    L_0x002e:
        return r0;
    L_0x002f:
        r0.remove(r6);	 Catch:{ all -> 0x0035 }
    L_0x0032:
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        r0 = 0;
        goto L_0x002e;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.c.a.b.d(android.content.Context, int):android.content.res.ColorStateList");
    }

    private static void m2767a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f1247c) {
            SparseArray sparseArray = (SparseArray) f1246b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f1246b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0672a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean m2771e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a = C0673b.m2766a();
        resources.getValue(i, a, true);
        if (a.type < 28 || a.type > 31) {
            return false;
        }
        return true;
    }

    private static TypedValue m2766a() {
        TypedValue typedValue = (TypedValue) f1245a.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f1245a.set(typedValue);
        return typedValue;
    }
}
