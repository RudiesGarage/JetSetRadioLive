package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p028c.p029a.C0673b;
import android.util.AttributeSet;

/* compiled from: TintTypedArray */
public class as {
    private final Context f2239a;
    private final TypedArray f2240b;

    public static as m4293a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new as(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static as m4294a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new as(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static as m4292a(Context context, int i, int[] iArr) {
        return new as(context, context.obtainStyledAttributes(i, iArr));
    }

    private as(Context context, TypedArray typedArray) {
        this.f2239a = context;
        this.f2240b = typedArray;
    }

    public Drawable m4297a(int i) {
        if (this.f2240b.hasValue(i)) {
            int resourceId = this.f2240b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0673b.m2768b(this.f2239a, resourceId);
            }
        }
        return this.f2240b.getDrawable(i);
    }

    public CharSequence m4301b(int i) {
        return this.f2240b.getText(i);
    }

    public String m4303c(int i) {
        return this.f2240b.getString(i);
    }

    public boolean m4299a(int i, boolean z) {
        return this.f2240b.getBoolean(i, z);
    }

    public int m4296a(int i, int i2) {
        return this.f2240b.getInt(i, i2);
    }

    public float m4295a(int i, float f) {
        return this.f2240b.getFloat(i, f);
    }

    public int m4300b(int i, int i2) {
        return this.f2240b.getColor(i, i2);
    }

    public ColorStateList m4305d(int i) {
        if (this.f2240b.hasValue(i)) {
            int resourceId = this.f2240b.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList a = C0673b.m2765a(this.f2239a, resourceId);
                if (a != null) {
                    return a;
                }
            }
        }
        return this.f2240b.getColorStateList(i);
    }

    public int m4302c(int i, int i2) {
        return this.f2240b.getInteger(i, i2);
    }

    public int m4304d(int i, int i2) {
        return this.f2240b.getDimensionPixelOffset(i, i2);
    }

    public int m4306e(int i, int i2) {
        return this.f2240b.getDimensionPixelSize(i, i2);
    }

    public int m4308f(int i, int i2) {
        return this.f2240b.getLayoutDimension(i, i2);
    }

    public int m4310g(int i, int i2) {
        return this.f2240b.getResourceId(i, i2);
    }

    public CharSequence[] m4307e(int i) {
        return this.f2240b.getTextArray(i);
    }

    public boolean m4309f(int i) {
        return this.f2240b.hasValue(i);
    }

    public void m4298a() {
        this.f2240b.recycle();
    }
}
