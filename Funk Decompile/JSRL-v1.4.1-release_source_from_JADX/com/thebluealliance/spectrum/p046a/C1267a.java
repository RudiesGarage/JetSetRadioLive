package com.thebluealliance.spectrum.p046a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: ColorCircleDrawable */
public class C1267a extends Drawable {
    private final Paint f3297a = new Paint(1);
    private int f3298b = 0;
    private int f3299c = 0;
    private final Paint f3300d;

    public C1267a(int i) {
        this.f3297a.setColor(i);
        this.f3300d = new Paint(1);
        this.f3300d.setColor(C1271c.m5824a(i) ? -1 : -16777216);
        this.f3300d.setStyle(Style.STROKE);
    }

    public void m5813a(int i) {
        this.f3297a.setColor(i);
        this.f3300d.setColor(C1271c.m5824a(i) ? -1 : -16777216);
        invalidateSelf();
    }

    public void m5814b(int i) {
        this.f3300d.setColor(i);
        invalidateSelf();
    }

    public void m5815c(int i) {
        this.f3300d.setAlpha(i);
        invalidateSelf();
    }

    public void m5816d(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f3299c = i;
        this.f3300d.setStrokeWidth((float) this.f3299c);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.f3299c != 0) {
            canvas.drawCircle((float) bounds.centerX(), (float) bounds.centerY(), (float) (this.f3298b - this.f3299c), this.f3297a);
            canvas.drawCircle((float) bounds.centerX(), (float) bounds.centerY(), (float) (this.f3298b - this.f3299c), this.f3300d);
            return;
        }
        canvas.drawCircle((float) bounds.centerX(), (float) bounds.centerY(), (float) this.f3298b, this.f3297a);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3298b = Math.min(rect.width(), rect.height()) / 2;
    }

    public void setAlpha(int i) {
        this.f3297a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3297a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }
}
