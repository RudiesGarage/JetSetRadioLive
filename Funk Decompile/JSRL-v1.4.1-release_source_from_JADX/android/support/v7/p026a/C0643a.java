package android.support.v7.p026a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p027b.C0670a.C0669k;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: ActionBar */
public abstract class C0643a {

    /* compiled from: ActionBar */
    public static class C0641a extends MarginLayoutParams {
        public int f1236a;

        public C0641a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1236a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0669k.ActionBarLayout);
            this.f1236a = obtainStyledAttributes.getInt(C0669k.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0641a(int i, int i2) {
            super(i, i2);
            this.f1236a = 0;
            this.f1236a = 8388627;
        }

        public C0641a(C0641a c0641a) {
            super(c0641a);
            this.f1236a = 0;
            this.f1236a = c0641a.f1236a;
        }

        public C0641a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1236a = 0;
        }
    }

    @Deprecated
    /* compiled from: ActionBar */
    public static abstract class C0642b {
        public abstract Drawable m2699a();

        public abstract CharSequence m2700b();

        public abstract View m2701c();

        public abstract void m2702d();

        public abstract CharSequence m2703e();
    }
}
