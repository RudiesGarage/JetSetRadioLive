package android.support.p013a.p014a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.p013a.p014a.C0162c.C0161b;
import android.support.v4.p015c.p016a.C0302a;
import android.support.v4.p018b.p019a.C0281d;
import android.support.v4.p024g.C0357a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
/* compiled from: VectorDrawableCompat */
public class C0171f extends C0158e {
    static final Mode f441a = Mode.SRC_IN;
    private C0169f f442c;
    private PorterDuffColorFilter f443d;
    private ColorFilter f444e;
    private boolean f445f;
    private boolean f446g;
    private ConstantState f447h;
    private final float[] f448i;
    private final Matrix f449j;
    private final Rect f450k;

    /* compiled from: VectorDrawableCompat */
    private static class C0164d {
        protected C0161b[] f383m = null;
        String f384n;
        int f385o;

        public C0164d(C0164d c0164d) {
            this.f384n = c0164d.f384n;
            this.f385o = c0164d.f385o;
            this.f383m = C0162c.m540a(c0164d.f383m);
        }

        public void m547a(Path path) {
            path.reset();
            if (this.f383m != null) {
                C0161b.m534a(this.f383m, path);
            }
        }

        public String m549b() {
            return this.f384n;
        }

        public boolean mo89a() {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class C0165a extends C0164d {
        public C0165a(C0165a c0165a) {
            super(c0165a);
        }

        public void m551a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (C0163d.m545a(xmlPullParser, "pathData")) {
                TypedArray b = C0158e.m525b(resources, theme, attributeSet, C0153a.f365d);
                m550a(b);
                b.recycle();
            }
        }

        private void m550a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.m = C0162c.m539a(string);
            }
        }

        public boolean mo89a() {
            return true;
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class C0166b extends C0164d {
        int f386a = 0;
        float f387b = 0.0f;
        int f388c = 0;
        float f389d = 1.0f;
        int f390e;
        float f391f = 1.0f;
        float f392g = 0.0f;
        float f393h = 1.0f;
        float f394i = 0.0f;
        Cap f395j = Cap.BUTT;
        Join f396k = Join.MITER;
        float f397l = 4.0f;
        private int[] f398p;

        public C0166b(C0166b c0166b) {
            super(c0166b);
            this.f398p = c0166b.f398p;
            this.f386a = c0166b.f386a;
            this.f387b = c0166b.f387b;
            this.f389d = c0166b.f389d;
            this.f388c = c0166b.f388c;
            this.f390e = c0166b.f390e;
            this.f391f = c0166b.f391f;
            this.f392g = c0166b.f392g;
            this.f393h = c0166b.f393h;
            this.f394i = c0166b.f394i;
            this.f395j = c0166b.f395j;
            this.f396k = c0166b.f396k;
            this.f397l = c0166b.f397l;
        }

        private Cap m553a(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join m554a(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        public void m556a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0158e.m525b(resources, theme, attributeSet, C0153a.f364c);
            m555a(b, xmlPullParser);
            b.recycle();
        }

        private void m555a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f398p = null;
            if (C0163d.m545a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = C0162c.m539a(string);
                }
                this.f388c = C0163d.m546b(typedArray, xmlPullParser, "fillColor", 1, this.f388c);
                this.f391f = C0163d.m542a(typedArray, xmlPullParser, "fillAlpha", 12, this.f391f);
                this.f395j = m553a(C0163d.m543a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f395j);
                this.f396k = m554a(C0163d.m543a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f396k);
                this.f397l = C0163d.m542a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f397l);
                this.f386a = C0163d.m546b(typedArray, xmlPullParser, "strokeColor", 3, this.f386a);
                this.f389d = C0163d.m542a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f389d);
                this.f387b = C0163d.m542a(typedArray, xmlPullParser, "strokeWidth", 4, this.f387b);
                this.f393h = C0163d.m542a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f393h);
                this.f394i = C0163d.m542a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f394i);
                this.f392g = C0163d.m542a(typedArray, xmlPullParser, "trimPathStart", 5, this.f392g);
            }
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class C0167c {
        final ArrayList<Object> f399a = new ArrayList();
        float f400b = 0.0f;
        int f401c;
        private final Matrix f402d = new Matrix();
        private float f403e = 0.0f;
        private float f404f = 0.0f;
        private float f405g = 1.0f;
        private float f406h = 1.0f;
        private float f407i = 0.0f;
        private float f408j = 0.0f;
        private final Matrix f409k = new Matrix();
        private int[] f410l;
        private String f411m = null;

        public C0167c(C0167c c0167c, C0357a<String, Object> c0357a) {
            this.f400b = c0167c.f400b;
            this.f403e = c0167c.f403e;
            this.f404f = c0167c.f404f;
            this.f405g = c0167c.f405g;
            this.f406h = c0167c.f406h;
            this.f407i = c0167c.f407i;
            this.f408j = c0167c.f408j;
            this.f410l = c0167c.f410l;
            this.f411m = c0167c.f411m;
            this.f401c = c0167c.f401c;
            if (this.f411m != null) {
                c0357a.put(this.f411m, this);
            }
            this.f409k.set(c0167c.f409k);
            ArrayList arrayList = c0167c.f399a;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof C0167c) {
                    this.f399a.add(new C0167c((C0167c) obj, c0357a));
                } else {
                    C0164d c0166b;
                    if (obj instanceof C0166b) {
                        c0166b = new C0166b((C0166b) obj);
                    } else if (obj instanceof C0165a) {
                        c0166b = new C0165a((C0165a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f399a.add(c0166b);
                    if (c0166b.f384n != null) {
                        c0357a.put(c0166b.f384n, c0166b);
                    }
                }
            }
        }

        public String m561a() {
            return this.f411m;
        }

        public void m562a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0158e.m525b(resources, theme, attributeSet, C0153a.f363b);
            m558a(b, xmlPullParser);
            b.recycle();
        }

        private void m558a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f410l = null;
            this.f400b = C0163d.m542a(typedArray, xmlPullParser, "rotation", 5, this.f400b);
            this.f403e = typedArray.getFloat(1, this.f403e);
            this.f404f = typedArray.getFloat(2, this.f404f);
            this.f405g = C0163d.m542a(typedArray, xmlPullParser, "scaleX", 3, this.f405g);
            this.f406h = C0163d.m542a(typedArray, xmlPullParser, "scaleY", 4, this.f406h);
            this.f407i = C0163d.m542a(typedArray, xmlPullParser, "translateX", 6, this.f407i);
            this.f408j = C0163d.m542a(typedArray, xmlPullParser, "translateY", 7, this.f408j);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f411m = string;
            }
            m560b();
        }

        private void m560b() {
            this.f409k.reset();
            this.f409k.postTranslate(-this.f403e, -this.f404f);
            this.f409k.postScale(this.f405g, this.f406h);
            this.f409k.postRotate(this.f400b, 0.0f, 0.0f);
            this.f409k.postTranslate(this.f407i + this.f403e, this.f408j + this.f404f);
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class C0168e {
        private static final Matrix f412k = new Matrix();
        final C0167c f413a;
        float f414b;
        float f415c;
        float f416d;
        float f417e;
        int f418f;
        String f419g;
        final C0357a<String, Object> f420h;
        private final Path f421i;
        private final Path f422j;
        private final Matrix f423l;
        private Paint f424m;
        private Paint f425n;
        private PathMeasure f426o;
        private int f427p;

        public C0168e() {
            this.f423l = new Matrix();
            this.f414b = 0.0f;
            this.f415c = 0.0f;
            this.f416d = 0.0f;
            this.f417e = 0.0f;
            this.f418f = 255;
            this.f419g = null;
            this.f420h = new C0357a();
            this.f413a = new C0167c();
            this.f421i = new Path();
            this.f422j = new Path();
        }

        public void m573a(int i) {
            this.f418f = i;
        }

        public int m571a() {
            return this.f418f;
        }

        public void m572a(float f) {
            m573a((int) (255.0f * f));
        }

        public float m575b() {
            return ((float) m571a()) / 255.0f;
        }

        public C0168e(C0168e c0168e) {
            this.f423l = new Matrix();
            this.f414b = 0.0f;
            this.f415c = 0.0f;
            this.f416d = 0.0f;
            this.f417e = 0.0f;
            this.f418f = 255;
            this.f419g = null;
            this.f420h = new C0357a();
            this.f413a = new C0167c(c0168e.f413a, this.f420h);
            this.f421i = new Path(c0168e.f421i);
            this.f422j = new Path(c0168e.f422j);
            this.f414b = c0168e.f414b;
            this.f415c = c0168e.f415c;
            this.f416d = c0168e.f416d;
            this.f417e = c0168e.f417e;
            this.f427p = c0168e.f427p;
            this.f418f = c0168e.f418f;
            this.f419g = c0168e.f419g;
            if (c0168e.f419g != null) {
                this.f420h.put(c0168e.f419g, this);
            }
        }

        private void m567a(C0167c c0167c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0167c.f402d.set(matrix);
            c0167c.f402d.preConcat(c0167c.f409k);
            canvas.save();
            for (int i3 = 0; i3 < c0167c.f399a.size(); i3++) {
                Object obj = c0167c.f399a.get(i3);
                if (obj instanceof C0167c) {
                    m567a((C0167c) obj, c0167c.f402d, canvas, i, i2, colorFilter);
                } else if (obj instanceof C0164d) {
                    m568a(c0167c, (C0164d) obj, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public void m574a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m567a(this.f413a, f412k, canvas, i, i2, colorFilter);
        }

        private void m568a(C0167c c0167c, C0164d c0164d, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f416d;
            float f2 = ((float) i2) / this.f417e;
            float min = Math.min(f, f2);
            Matrix a = c0167c.f402d;
            this.f423l.set(a);
            this.f423l.postScale(f, f2);
            f = m564a(a);
            if (f != 0.0f) {
                c0164d.m547a(this.f421i);
                Path path = this.f421i;
                this.f422j.reset();
                if (c0164d.mo89a()) {
                    this.f422j.addPath(path, this.f423l);
                    canvas.clipPath(this.f422j);
                    return;
                }
                Paint paint;
                C0166b c0166b = (C0166b) c0164d;
                if (!(c0166b.f392g == 0.0f && c0166b.f393h == 1.0f)) {
                    float f3 = (c0166b.f392g + c0166b.f394i) % 1.0f;
                    float f4 = (c0166b.f393h + c0166b.f394i) % 1.0f;
                    if (this.f426o == null) {
                        this.f426o = new PathMeasure();
                    }
                    this.f426o.setPath(this.f421i, false);
                    float length = this.f426o.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.f426o.getSegment(f3, length, path, true);
                        this.f426o.getSegment(0.0f, f4, path, true);
                    } else {
                        this.f426o.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f422j.addPath(path, this.f423l);
                if (c0166b.f388c != 0) {
                    if (this.f425n == null) {
                        this.f425n = new Paint();
                        this.f425n.setStyle(Style.FILL);
                        this.f425n.setAntiAlias(true);
                    }
                    paint = this.f425n;
                    paint.setColor(C0171f.m584a(c0166b.f388c, c0166b.f391f));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.f422j, paint);
                }
                if (c0166b.f386a != 0) {
                    if (this.f424m == null) {
                        this.f424m = new Paint();
                        this.f424m.setStyle(Style.STROKE);
                        this.f424m.setAntiAlias(true);
                    }
                    paint = this.f424m;
                    if (c0166b.f396k != null) {
                        paint.setStrokeJoin(c0166b.f396k);
                    }
                    if (c0166b.f395j != null) {
                        paint.setStrokeCap(c0166b.f395j);
                    }
                    paint.setStrokeMiter(c0166b.f397l);
                    paint.setColor(C0171f.m584a(c0166b.f386a, c0166b.f389d));
                    paint.setColorFilter(colorFilter);
                    paint.setStrokeWidth((f * min) * c0166b.f387b);
                    canvas.drawPath(this.f422j, paint);
                }
            }
        }

        private static float m563a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float m564a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = C0168e.m563a(fArr[0], fArr[1], fArr[2], fArr[3]);
            hypot = Math.max(hypot, hypot2);
            if (hypot > 0.0f) {
                return Math.abs(a) / hypot;
            }
            return 0.0f;
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class C0169f extends ConstantState {
        int f428a;
        C0168e f429b;
        ColorStateList f430c;
        Mode f431d;
        boolean f432e;
        Bitmap f433f;
        ColorStateList f434g;
        Mode f435h;
        int f436i;
        boolean f437j;
        boolean f438k;
        Paint f439l;

        public C0169f(C0169f c0169f) {
            this.f430c = null;
            this.f431d = C0171f.f441a;
            if (c0169f != null) {
                this.f428a = c0169f.f428a;
                this.f429b = new C0168e(c0169f.f429b);
                if (c0169f.f429b.f425n != null) {
                    this.f429b.f425n = new Paint(c0169f.f429b.f425n);
                }
                if (c0169f.f429b.f424m != null) {
                    this.f429b.f424m = new Paint(c0169f.f429b.f424m);
                }
                this.f430c = c0169f.f430c;
                this.f431d = c0169f.f431d;
                this.f432e = c0169f.f432e;
            }
        }

        public void m578a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f433f, null, rect, m576a(colorFilter));
        }

        public boolean m579a() {
            return this.f429b.m571a() < 255;
        }

        public Paint m576a(ColorFilter colorFilter) {
            if (!m579a() && colorFilter == null) {
                return null;
            }
            if (this.f439l == null) {
                this.f439l = new Paint();
                this.f439l.setFilterBitmap(true);
            }
            this.f439l.setAlpha(this.f429b.m571a());
            this.f439l.setColorFilter(colorFilter);
            return this.f439l;
        }

        public void m577a(int i, int i2) {
            this.f433f.eraseColor(0);
            this.f429b.m574a(new Canvas(this.f433f), i, i2, null);
        }

        public void m580b(int i, int i2) {
            if (this.f433f == null || !m583c(i, i2)) {
                this.f433f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f438k = true;
            }
        }

        public boolean m583c(int i, int i2) {
            if (i == this.f433f.getWidth() && i2 == this.f433f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean m581b() {
            if (!this.f438k && this.f434g == this.f430c && this.f435h == this.f431d && this.f437j == this.f432e && this.f436i == this.f429b.m571a()) {
                return true;
            }
            return false;
        }

        public void m582c() {
            this.f434g = this.f430c;
            this.f435h = this.f431d;
            this.f436i = this.f429b.m571a();
            this.f437j = this.f432e;
            this.f438k = false;
        }

        public C0169f() {
            this.f430c = null;
            this.f431d = C0171f.f441a;
            this.f429b = new C0168e();
        }

        public Drawable newDrawable() {
            return new C0171f(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0171f(this);
        }

        public int getChangingConfigurations() {
            return this.f428a;
        }
    }

    /* compiled from: VectorDrawableCompat */
    private static class C0170g extends ConstantState {
        private final ConstantState f440a;

        public C0170g(ConstantState constantState) {
            this.f440a = constantState;
        }

        public Drawable newDrawable() {
            Drawable c0171f = new C0171f();
            c0171f.b = (VectorDrawable) this.f440a.newDrawable();
            return c0171f;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0171f = new C0171f();
            c0171f.b = (VectorDrawable) this.f440a.newDrawable(resources);
            return c0171f;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0171f = new C0171f();
            c0171f.b = (VectorDrawable) this.f440a.newDrawable(resources, theme);
            return c0171f;
        }

        public boolean canApplyTheme() {
            return this.f440a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f440a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
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

    C0171f() {
        this.f446g = true;
        this.f448i = new float[9];
        this.f449j = new Matrix();
        this.f450k = new Rect();
        this.f442c = new C0169f();
    }

    C0171f(C0169f c0169f) {
        this.f446g = true;
        this.f448i = new float[9];
        this.f449j = new Matrix();
        this.f450k = new Rect();
        this.f442c = c0169f;
        this.f443d = m591a(this.f443d, c0169f.f430c, c0169f.f431d);
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        } else if (!this.f445f && super.mutate() == this) {
            this.f442c = new C0169f(this.f442c);
            this.f445f = true;
        }
        return this;
    }

    Object m592a(String str) {
        return this.f442c.f429b.f420h.get(str);
    }

    public ConstantState getConstantState() {
        if (this.b != null) {
            return new C0170g(this.b.getConstantState());
        }
        this.f442c.f428a = getChangingConfigurations();
        return this.f442c;
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        copyBounds(this.f450k);
        if (this.f450k.width() > 0 && this.f450k.height() > 0) {
            ColorFilter colorFilter = this.f444e == null ? this.f443d : this.f444e;
            canvas.getMatrix(this.f449j);
            this.f449j.getValues(this.f448i);
            float abs = Math.abs(this.f448i[0]);
            float abs2 = Math.abs(this.f448i[4]);
            float abs3 = Math.abs(this.f448i[1]);
            float abs4 = Math.abs(this.f448i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.f450k.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.f450k.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f450k.left, (float) this.f450k.top);
                if (m589a()) {
                    canvas.translate((float) this.f450k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f450k.offsetTo(0, 0);
                this.f442c.m580b(min, height);
                if (!this.f446g) {
                    this.f442c.m577a(min, height);
                } else if (!this.f442c.m581b()) {
                    this.f442c.m577a(min, height);
                    this.f442c.m582c();
                }
                this.f442c.m578a(canvas, colorFilter, this.f450k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        if (this.b != null) {
            return C0302a.m1147c(this.b);
        }
        return this.f442c.f429b.m571a();
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else if (this.f442c.f429b.m571a() != i) {
            this.f442c.f429b.m573a(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
            return;
        }
        this.f444e = colorFilter;
        invalidateSelf();
    }

    PorterDuffColorFilter m591a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTint(int i) {
        if (this.b != null) {
            C0302a.m1139a(this.b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            C0302a.m1141a(this.b, colorStateList);
            return;
        }
        C0169f c0169f = this.f442c;
        if (c0169f.f430c != colorStateList) {
            c0169f.f430c = colorStateList;
            this.f443d = m591a(this.f443d, colorStateList, c0169f.f431d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            C0302a.m1144a(this.b, mode);
            return;
        }
        C0169f c0169f = this.f442c;
        if (c0169f.f431d != mode) {
            c0169f.f431d = mode;
            this.f443d = m591a(this.f443d, c0169f.f430c, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.b != null) {
            return this.b.isStateful();
        }
        return super.isStateful() || !(this.f442c == null || this.f442c.f430c == null || !this.f442c.f430c.isStateful());
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        C0169f c0169f = this.f442c;
        if (c0169f.f430c == null || c0169f.f431d == null) {
            return false;
        }
        this.f443d = m591a(this.f443d, c0169f.f430c, c0169f.f431d);
        invalidateSelf();
        return true;
    }

    public int getOpacity() {
        if (this.b != null) {
            return this.b.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.b != null) {
            return this.b.getIntrinsicWidth();
        }
        return (int) this.f442c.f429b.f414b;
    }

    public int getIntrinsicHeight() {
        if (this.b != null) {
            return this.b.getIntrinsicHeight();
        }
        return (int) this.f442c.f429b.f415c;
    }

    public boolean canApplyTheme() {
        if (this.b != null) {
            C0302a.m1148d(this.b);
        }
        return false;
    }

    public boolean isAutoMirrored() {
        if (this.b != null) {
            return C0302a.m1146b(this.b);
        }
        return this.f442c.f432e;
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            C0302a.m1145a(this.b, z);
        } else {
            this.f442c.f432e = z;
        }
    }

    public static C0171f m586a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 24) {
            C0171f c0171f = new C0171f();
            c0171f.b = C0281d.m1061a(resources, i, theme);
            c0171f.f447h = new C0170g(c0171f.b.getConstantState());
            return c0171f;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return C0171f.m587a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static C0171f m587a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0171f c0171f = new C0171f();
        c0171f.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0171f;
    }

    static int m584a(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.b != null) {
            this.b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.b != null) {
            C0302a.m1143a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0169f c0169f = this.f442c;
        c0169f.f429b = new C0168e();
        TypedArray b = C0158e.m525b(resources, theme, attributeSet, C0153a.f362a);
        m588a(b, xmlPullParser);
        b.recycle();
        c0169f.f428a = getChangingConfigurations();
        c0169f.f438k = true;
        m590b(resources, xmlPullParser, attributeSet, theme);
        this.f443d = m591a(this.f443d, c0169f.f430c, c0169f.f431d);
    }

    private static Mode m585a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    private void m588a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0169f c0169f = this.f442c;
        C0168e c0168e = c0169f.f429b;
        c0169f.f431d = C0171f.m585a(C0163d.m543a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0169f.f430c = colorStateList;
        }
        c0169f.f432e = C0163d.m544a(typedArray, xmlPullParser, "autoMirrored", 5, c0169f.f432e);
        c0168e.f416d = C0163d.m542a(typedArray, xmlPullParser, "viewportWidth", 7, c0168e.f416d);
        c0168e.f417e = C0163d.m542a(typedArray, xmlPullParser, "viewportHeight", 8, c0168e.f417e);
        if (c0168e.f416d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c0168e.f417e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0168e.f414b = typedArray.getDimension(3, c0168e.f414b);
            c0168e.f415c = typedArray.getDimension(2, c0168e.f415c);
            if (c0168e.f414b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c0168e.f415c <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0168e.m572a(C0163d.m542a(typedArray, xmlPullParser, "alpha", 4, c0168e.m575b()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0168e.f419g = string;
                    c0168e.f420h.put(string, c0168e);
                }
            }
        }
    }

    private void m590b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0169f c0169f = this.f442c;
        C0168e c0168e = c0169f.f429b;
        Stack stack = new Stack();
        stack.push(c0168e.f413a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                C0167c c0167c = (C0167c) stack.peek();
                if ("path".equals(name)) {
                    C0166b c0166b = new C0166b();
                    c0166b.m556a(resources, attributeSet, theme, xmlPullParser);
                    c0167c.f399a.add(c0166b);
                    if (c0166b.m549b() != null) {
                        c0168e.f420h.put(c0166b.m549b(), c0166b);
                    }
                    obj2 = null;
                    c0169f.f428a = c0166b.o | c0169f.f428a;
                } else if ("clip-path".equals(name)) {
                    C0165a c0165a = new C0165a();
                    c0165a.m551a(resources, attributeSet, theme, xmlPullParser);
                    c0167c.f399a.add(c0165a);
                    if (c0165a.m549b() != null) {
                        c0168e.f420h.put(c0165a.m549b(), c0165a);
                    }
                    c0169f.f428a |= c0165a.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        C0167c c0167c2 = new C0167c();
                        c0167c2.m562a(resources, attributeSet, theme, xmlPullParser);
                        c0167c.f399a.add(c0167c2);
                        stack.push(c0167c2);
                        if (c0167c2.m561a() != null) {
                            c0168e.f420h.put(c0167c2.m561a(), c0167c2);
                        }
                        c0169f.f428a |= c0167c2.f401c;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    void m593a(boolean z) {
        this.f446g = z;
    }

    private boolean m589a() {
        boolean z = true;
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!(isAutoMirrored() && getLayoutDirection() == 1)) {
            z = false;
        }
        return z;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.b != null) {
            return this.b.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f442c.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.b != null) {
            this.b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.b != null) {
            this.b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.b != null) {
            return this.b.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.b != null) {
            this.b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
