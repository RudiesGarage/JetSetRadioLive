package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources */
class ar extends ah {
    private final WeakReference<Context> f2238a;

    public ar(Context context, Resources resources) {
        super(resources);
        this.f2238a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f2238a.get();
        if (!(drawable == null || context == null)) {
            C0873i.m4467a();
            C0873i.m4473a(context, i, drawable);
        }
        return drawable;
    }
}
