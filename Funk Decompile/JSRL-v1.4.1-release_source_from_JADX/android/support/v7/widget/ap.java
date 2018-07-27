package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper */
public class ap extends ContextWrapper {
    private static final Object f2230a = new Object();
    private static ArrayList<WeakReference<ap>> f2231b;
    private final Resources f2232c;
    private final Theme f2233d;

    public static Context m4289a(Context context) {
        if (!m4290b(context)) {
            return context;
        }
        synchronized (f2230a) {
            Context context2;
            if (f2231b == null) {
                f2231b = new ArrayList();
            } else {
                int size;
                WeakReference weakReference;
                for (size = f2231b.size() - 1; size >= 0; size--) {
                    weakReference = (WeakReference) f2231b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f2231b.remove(size);
                    }
                }
                size = f2231b.size() - 1;
                while (size >= 0) {
                    weakReference = (WeakReference) f2231b.get(size);
                    context2 = weakReference != null ? (ap) weakReference.get() : null;
                    if (context2 == null || context2.getBaseContext() != context) {
                        size--;
                    } else {
                        return context2;
                    }
                }
            }
            context2 = new ap(context);
            f2231b.add(new WeakReference(context2));
            return context2;
        }
    }

    private static boolean m4290b(Context context) {
        if ((context instanceof ap) || (context.getResources() instanceof ar) || (context.getResources() instanceof au)) {
            return false;
        }
        if (VERSION.SDK_INT < 21 || au.m4338a()) {
            return true;
        }
        return false;
    }

    private ap(Context context) {
        super(context);
        if (au.m4338a()) {
            this.f2232c = new au(this, context.getResources());
            this.f2233d = this.f2232c.newTheme();
            this.f2233d.setTo(context.getTheme());
            return;
        }
        this.f2232c = new ar(this, context.getResources());
        this.f2233d = null;
    }

    public Theme getTheme() {
        return this.f2233d == null ? super.getTheme() : this.f2233d;
    }

    public void setTheme(int i) {
        if (this.f2233d == null) {
            super.setTheme(i);
        } else {
            this.f2233d.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        return this.f2232c;
    }
}
