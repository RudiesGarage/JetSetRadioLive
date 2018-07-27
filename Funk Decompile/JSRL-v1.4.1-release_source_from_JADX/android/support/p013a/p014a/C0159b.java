package android.support.p013a.p014a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.p015c.p016a.C0302a;
import android.support.v4.p024g.C0357a;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
/* compiled from: AnimatedVectorDrawableCompat */
public class C0159b extends C0158e implements Animatable {
    final Callback f375a;
    private C0155a f376c;
    private Context f377d;
    private ArgbEvaluator f378e;

    /* compiled from: AnimatedVectorDrawableCompat */
    class C01541 implements Callback {
        final /* synthetic */ C0159b f368a;

        C01541(C0159b c0159b) {
            this.f368a = c0159b;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f368a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f368a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f368a.unscheduleSelf(runnable);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C0155a extends ConstantState {
        int f369a;
        C0171f f370b;
        ArrayList<Animator> f371c;
        C0357a<Animator, String> f372d;

        public C0155a(Context context, C0155a c0155a, Callback callback, Resources resources) {
            int i = 0;
            if (c0155a != null) {
                this.f369a = c0155a.f369a;
                if (c0155a.f370b != null) {
                    ConstantState constantState = c0155a.f370b.getConstantState();
                    if (resources != null) {
                        this.f370b = (C0171f) constantState.newDrawable(resources);
                    } else {
                        this.f370b = (C0171f) constantState.newDrawable();
                    }
                    this.f370b = (C0171f) this.f370b.mutate();
                    this.f370b.setCallback(callback);
                    this.f370b.setBounds(c0155a.f370b.getBounds());
                    this.f370b.m593a(false);
                }
                if (c0155a.f371c != null) {
                    int size = c0155a.f371c.size();
                    this.f371c = new ArrayList(size);
                    this.f372d = new C0357a(size);
                    while (i < size) {
                        Animator animator = (Animator) c0155a.f371c.get(i);
                        Animator clone = animator.clone();
                        String str = (String) c0155a.f372d.get(animator);
                        clone.setTarget(this.f370b.m592a(str));
                        this.f371c.add(clone);
                        this.f372d.put(clone, str);
                        i++;
                    }
                }
            }
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public int getChangingConfigurations() {
            return this.f369a;
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C0156b extends ConstantState {
        private final ConstantState f373a;

        public C0156b(ConstantState constantState) {
            this.f373a = constantState;
        }

        public Drawable newDrawable() {
            Drawable c0159b = new C0159b();
            c0159b.b = this.f373a.newDrawable();
            c0159b.b.setCallback(c0159b.f375a);
            return c0159b;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0159b = new C0159b();
            c0159b.b = this.f373a.newDrawable(resources);
            c0159b.b.setCallback(c0159b.f375a);
            return c0159b;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0159b = new C0159b();
            c0159b.b = this.f373a.newDrawable(resources, theme);
            c0159b.b.setCallback(c0159b.f375a);
            return c0159b;
        }

        public boolean canApplyTheme() {
            return this.f373a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f373a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    C0159b() {
        this(null, null, null);
    }

    private C0159b(Context context) {
        this(context, null, null);
    }

    private C0159b(Context context, C0155a c0155a, Resources resources) {
        this.f378e = null;
        this.f375a = new C01541(this);
        this.f377d = context;
        if (c0155a != null) {
            this.f376c = c0155a;
        } else {
            this.f376c = new C0155a(context, c0155a, this.f375a, resources);
        }
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static C0159b m527a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0159b c0159b = new C0159b(context);
        c0159b.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0159b;
    }

    public ConstantState getConstantState() {
        if (this.b != null) {
            return new C0156b(this.b.getConstantState());
        }
        return null;
    }

    public int getChangingConfigurations() {
        if (this.b != null) {
            return this.b.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f376c.f369a;
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        this.f376c.f370b.draw(canvas);
        if (m530a()) {
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        } else {
            this.f376c.f370b.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        return this.f376c.f370b.setState(iArr);
    }

    protected boolean onLevelChange(int i) {
        if (this.b != null) {
            return this.b.setLevel(i);
        }
        return this.f376c.f370b.setLevel(i);
    }

    public int getAlpha() {
        if (this.b != null) {
            return C0302a.m1147c(this.b);
        }
        return this.f376c.f370b.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else {
            this.f376c.f370b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
        } else {
            this.f376c.f370b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.b != null) {
            C0302a.m1139a(this.b, i);
        } else {
            this.f376c.f370b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            C0302a.m1141a(this.b, colorStateList);
        } else {
            this.f376c.f370b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            C0302a.m1144a(this.b, mode);
        } else {
            this.f376c.f370b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.b != null) {
            return this.b.setVisible(z, z2);
        }
        this.f376c.f370b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.b != null) {
            return this.b.isStateful();
        }
        return this.f376c.f370b.isStateful();
    }

    public int getOpacity() {
        if (this.b != null) {
            return this.b.getOpacity();
        }
        return this.f376c.f370b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.b != null) {
            return this.b.getIntrinsicWidth();
        }
        return this.f376c.f370b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.b != null) {
            return this.b.getIntrinsicHeight();
        }
        return this.f376c.f370b.getIntrinsicHeight();
    }

    public boolean isAutoMirrored() {
        if (this.b != null) {
            return C0302a.m1146b(this.b);
        }
        return this.f376c.f370b.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            this.b.setAutoMirrored(z);
        } else {
            this.f376c.f370b.setAutoMirrored(z);
        }
    }

    static TypedArray m526a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.b != null) {
            C0302a.m1143a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1) {
            if (xmlPullParser.getDepth() >= depth || eventType != 3) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    TypedArray a;
                    if ("animated-vector".equals(name)) {
                        a = C0159b.m526a(resources, theme, attributeSet, C0153a.f366e);
                        int resourceId = a.getResourceId(0, 0);
                        if (resourceId != 0) {
                            C0171f a2 = C0171f.m586a(resources, resourceId, theme);
                            a2.m593a(false);
                            a2.setCallback(this.f375a);
                            if (this.f376c.f370b != null) {
                                this.f376c.f370b.setCallback(null);
                            }
                            this.f376c.f370b = a2;
                        }
                        a.recycle();
                    } else if ("target".equals(name)) {
                        a = resources.obtainAttributes(attributeSet, C0153a.f367f);
                        String string = a.getString(0);
                        int resourceId2 = a.getResourceId(1, 0);
                        if (resourceId2 != 0) {
                            if (this.f377d != null) {
                                m529a(string, AnimatorInflater.loadAnimator(this.f377d, resourceId2));
                            } else {
                                throw new IllegalStateException("Context can't be null when inflating animators");
                            }
                        }
                        a.recycle();
                    } else {
                        continue;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void applyTheme(Theme theme) {
        if (this.b != null) {
            C0302a.m1142a(this.b, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.b != null) {
            return C0302a.m1148d(this.b);
        }
        return false;
    }

    private void m528a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m528a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f378e == null) {
                    this.f378e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f378e);
            }
        }
    }

    private void m529a(String str, Animator animator) {
        animator.setTarget(this.f376c.f370b.m592a(str));
        if (VERSION.SDK_INT < 21) {
            m528a(animator);
        }
        if (this.f376c.f371c == null) {
            this.f376c.f371c = new ArrayList();
            this.f376c.f372d = new C0357a();
        }
        this.f376c.f371c.add(animator);
        this.f376c.f372d.put(animator, str);
    }

    public boolean isRunning() {
        if (this.b != null) {
            return ((AnimatedVectorDrawable) this.b).isRunning();
        }
        ArrayList arrayList = this.f376c.f371c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean m530a() {
        ArrayList arrayList = this.f376c.f371c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).start();
        } else if (!m530a()) {
            ArrayList arrayList = this.f376c.f371c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).stop();
            return;
        }
        ArrayList arrayList = this.f376c.f371c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
