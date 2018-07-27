package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p026a.C0644b;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources */
public class au extends Resources {
    private final WeakReference<Context> f2258a;

    public static boolean m4338a() {
        return C0644b.m2704a() && VERSION.SDK_INT <= 20;
    }

    public au(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2258a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f2258a.get();
        if (context != null) {
            return C0873i.m4467a().m4487a(context, this, i);
        }
        return super.getDrawable(i);
    }

    final Drawable m4339a(int i) {
        return super.getDrawable(i);
    }
}
