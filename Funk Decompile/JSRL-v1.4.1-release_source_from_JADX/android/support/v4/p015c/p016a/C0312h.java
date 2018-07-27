package android.support.v4.p015c.p016a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p015c.p016a.C0310g.C0308a;

/* compiled from: DrawableWrapperHoneycomb */
class C0312h extends C0310g {

    /* compiled from: DrawableWrapperHoneycomb */
    private static class C0311a extends C0308a {
        C0311a(C0308a c0308a, Resources resources) {
            super(c0308a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0312h(this, resources);
        }
    }

    C0312h(Drawable drawable) {
        super(drawable);
    }

    C0312h(C0308a c0308a, Resources resources) {
        super(c0308a, resources);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    C0308a mo186b() {
        return new C0311a(this.b, null);
    }
}
