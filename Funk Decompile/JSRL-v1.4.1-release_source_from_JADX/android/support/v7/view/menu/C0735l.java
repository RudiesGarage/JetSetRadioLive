package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.C0567e;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0662d;
import android.support.v7.view.menu.C0711m.C0736a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: MenuPopupHelper */
public class C0735l {
    private final Context f1524a;
    private final C0724g f1525b;
    private final boolean f1526c;
    private final int f1527d;
    private final int f1528e;
    private View f1529f;
    private int f1530g;
    private boolean f1531h;
    private C0736a f1532i;
    private C0720k f1533j;
    private OnDismissListener f1534k;
    private final OnDismissListener f1535l;

    /* compiled from: MenuPopupHelper */
    class C07341 implements OnDismissListener {
        final /* synthetic */ C0735l f1523a;

        C07341(C0735l c0735l) {
            this.f1523a = c0735l;
        }

        public void onDismiss() {
            this.f1523a.mo682e();
        }
    }

    public C0735l(Context context, C0724g c0724g, View view, boolean z, int i) {
        this(context, c0724g, view, z, i, 0);
    }

    public C0735l(Context context, C0724g c0724g, View view, boolean z, int i, int i2) {
        this.f1530g = 8388611;
        this.f1535l = new C07341(this);
        this.f1524a = context;
        this.f1525b = c0724g;
        this.f1529f = view;
        this.f1526c = z;
        this.f1527d = i;
        this.f1528e = i2;
    }

    public void m3097a(OnDismissListener onDismissListener) {
        this.f1534k = onDismissListener;
    }

    public void m3096a(View view) {
        this.f1529f = view;
    }

    public void m3098a(boolean z) {
        this.f1531h = z;
        if (this.f1533j != null) {
            this.f1533j.mo523a(z);
        }
    }

    public void m3094a(int i) {
        this.f1530g = i;
    }

    public void m3093a() {
        if (!m3101c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public C0720k m3100b() {
        if (this.f1533j == null) {
            this.f1533j = m3092g();
        }
        return this.f1533j;
    }

    public boolean m3101c() {
        if (m3104f()) {
            return true;
        }
        if (this.f1529f == null) {
            return false;
        }
        m3091a(0, 0, false, false);
        return true;
    }

    public boolean m3099a(int i, int i2) {
        if (m3104f()) {
            return true;
        }
        if (this.f1529f == null) {
            return false;
        }
        m3091a(i, i2, true, true);
        return true;
    }

    private C0720k m3092g() {
        C0720k c0721e;
        Display defaultDisplay = ((WindowManager) this.f1524a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        if ((Math.min(point.x, point.y) >= this.f1524a.getResources().getDimensionPixelSize(C0662d.abc_cascading_menus_min_smallest_width) ? 1 : null) != null) {
            c0721e = new C0721e(this.f1524a, this.f1529f, this.f1527d, this.f1528e, this.f1526c);
        } else {
            c0721e = new C0740r(this.f1524a, this.f1525b, this.f1529f, this.f1527d, this.f1528e, this.f1526c);
        }
        c0721e.mo520a(this.f1525b);
        c0721e.mo522a(this.f1535l);
        c0721e.mo521a(this.f1529f);
        c0721e.mo510a(this.f1532i);
        c0721e.mo523a(this.f1531h);
        c0721e.mo519a(this.f1530g);
        return c0721e;
    }

    private void m3091a(int i, int i2, boolean z, boolean z2) {
        C0720k b = m3100b();
        b.mo527c(z2);
        if (z) {
            if ((C0567e.m2446a(this.f1530g, ae.m2228h(this.f1529f)) & 7) == 5) {
                i -= this.f1529f.getWidth();
            }
            b.mo524b(i);
            b.mo526c(i2);
            int i3 = (int) ((this.f1524a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.m2957a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        b.mo518a();
    }

    public void m3102d() {
        if (m3104f()) {
            this.f1533j.mo525c();
        }
    }

    protected void mo682e() {
        this.f1533j = null;
        if (this.f1534k != null) {
            this.f1534k.onDismiss();
        }
    }

    public boolean m3104f() {
        return this.f1533j != null && this.f1533j.mo528d();
    }

    public void m3095a(C0736a c0736a) {
        this.f1532i = c0736a;
        if (this.f1533j != null) {
            this.f1533j.mo510a(c0736a);
        }
    }
}
