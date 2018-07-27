package android.support.v4.p015c.p016a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p015c.p016a.C0310g.C0308a;

/* compiled from: DrawableWrapperKitKat */
class C0314i extends C0312h {

    /* compiled from: DrawableWrapperKitKat */
    private static class C0313a extends C0308a {
        C0313a(C0308a c0308a, Resources resources) {
            super(c0308a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0314i(this, resources);
        }
    }

    C0314i(Drawable drawable) {
        super(drawable);
    }

    C0314i(C0308a c0308a, Resources resources) {
        super(c0308a, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    C0308a mo186b() {
        return new C0313a(this.b, null);
    }
}
