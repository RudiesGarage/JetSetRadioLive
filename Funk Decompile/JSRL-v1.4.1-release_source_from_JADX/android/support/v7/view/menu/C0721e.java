package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.C0567e;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0662d;
import android.support.v7.p027b.C0670a.C0666h;
import android.support.v7.view.menu.C0711m.C0736a;
import android.support.v7.widget.ac;
import android.support.v7.widget.ad;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: CascadingMenuPopup */
final class C0721e extends C0720k implements C0711m, OnKeyListener, OnDismissListener {
    final Handler f1432a;
    final List<C0718a> f1433b = new ArrayList();
    View f1434c;
    boolean f1435d;
    private final Context f1436e;
    private final int f1437f;
    private final int f1438g;
    private final int f1439h;
    private final boolean f1440i;
    private final List<C0724g> f1441j = new LinkedList();
    private final OnGlobalLayoutListener f1442k = new C07151(this);
    private final ac f1443l = new C07172(this);
    private int f1444m = 0;
    private int f1445n = 0;
    private View f1446o;
    private int f1447p;
    private boolean f1448q;
    private boolean f1449r;
    private int f1450s;
    private int f1451t;
    private boolean f1452u;
    private boolean f1453v;
    private C0736a f1454w;
    private ViewTreeObserver f1455x;
    private OnDismissListener f1456y;

    /* compiled from: CascadingMenuPopup */
    class C07151 implements OnGlobalLayoutListener {
        final /* synthetic */ C0721e f1422a;

        C07151(C0721e c0721e) {
            this.f1422a = c0721e;
        }

        public void onGlobalLayout() {
            if (this.f1422a.mo528d() && this.f1422a.f1433b.size() > 0 && !((C0718a) this.f1422a.f1433b.get(0)).f1428a.m4126g()) {
                View view = this.f1422a.f1434c;
                if (view == null || !view.isShown()) {
                    this.f1422a.mo525c();
                    return;
                }
                for (C0718a c0718a : this.f1422a.f1433b) {
                    c0718a.f1428a.mo518a();
                }
            }
        }
    }

    /* compiled from: CascadingMenuPopup */
    class C07172 implements ac {
        final /* synthetic */ C0721e f1427a;

        C07172(C0721e c0721e) {
            this.f1427a = c0721e;
        }

        public void mo516a(C0724g c0724g, MenuItem menuItem) {
            this.f1427a.f1432a.removeCallbacksAndMessages(c0724g);
        }

        public void mo517b(final C0724g c0724g, final MenuItem menuItem) {
            int i;
            this.f1427a.f1432a.removeCallbacksAndMessages(null);
            int size = this.f1427a.f1433b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (c0724g == ((C0718a) this.f1427a.f1433b.get(i2)).f1429b) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                C0718a c0718a;
                i++;
                if (i < this.f1427a.f1433b.size()) {
                    c0718a = (C0718a) this.f1427a.f1433b.get(i);
                } else {
                    c0718a = null;
                }
                this.f1427a.f1432a.postAtTime(new Runnable(this) {
                    final /* synthetic */ C07172 f1426d;

                    public void run() {
                        if (c0718a != null) {
                            this.f1426d.f1427a.f1435d = true;
                            c0718a.f1429b.m3021a(false);
                            this.f1426d.f1427a.f1435d = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            c0724g.m3024a(menuItem, 0);
                        }
                    }
                }, c0724g, SystemClock.uptimeMillis() + 200);
            }
        }
    }

    /* compiled from: CascadingMenuPopup */
    private static class C0718a {
        public final ad f1428a;
        public final C0724g f1429b;
        public final int f1430c;

        public C0718a(ad adVar, C0724g c0724g, int i) {
            this.f1428a = adVar;
            this.f1429b = c0724g;
            this.f1430c = i;
        }

        public ListView m2947a() {
            return this.f1428a.mo529e();
        }
    }

    public C0721e(Context context, View view, int i, int i2, boolean z) {
        this.f1436e = context;
        this.f1446o = view;
        this.f1438g = i;
        this.f1439h = i2;
        this.f1440i = z;
        this.f1452u = false;
        this.f1447p = m2975i();
        Resources resources = context.getResources();
        this.f1437f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0662d.abc_config_prefDialogWidth));
        this.f1432a = new Handler();
    }

    public void mo523a(boolean z) {
        this.f1452u = z;
    }

    private ad m2974h() {
        ad adVar = new ad(this.f1436e, null, this.f1438g, this.f1439h);
        adVar.m4153a(this.f1443l);
        adVar.m4112a((OnItemClickListener) this);
        adVar.m4114a((OnDismissListener) this);
        adVar.m4117b(this.f1446o);
        adVar.m4123e(this.f1445n);
        adVar.m4115a(true);
        return adVar;
    }

    public void mo518a() {
        if (!mo528d()) {
            for (C0724g c : this.f1441j) {
                m2971c(c);
            }
            this.f1441j.clear();
            this.f1434c = this.f1446o;
            if (this.f1434c != null) {
                Object obj = this.f1455x == null ? 1 : null;
                this.f1455x = this.f1434c.getViewTreeObserver();
                if (obj != null) {
                    this.f1455x.addOnGlobalLayoutListener(this.f1442k);
                }
            }
        }
    }

    public void mo525c() {
        int size = this.f1433b.size();
        if (size > 0) {
            C0718a[] c0718aArr = (C0718a[]) this.f1433b.toArray(new C0718a[size]);
            for (size--; size >= 0; size--) {
                C0718a c0718a = c0718aArr[size];
                if (c0718a.f1428a.mo528d()) {
                    c0718a.f1428a.mo525c();
                }
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo525c();
        return true;
    }

    private int m2975i() {
        if (ae.m2228h(this.f1446o) == 1) {
            return 0;
        }
        return 1;
    }

    private int m2972d(int i) {
        ListView a = ((C0718a) this.f1433b.get(this.f1433b.size() - 1)).m2947a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1434c.getWindowVisibleDisplayFrame(rect);
        if (this.f1447p == 1) {
            if ((a.getWidth() + iArr[0]) + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void mo520a(C0724g c0724g) {
        c0724g.m3018a((C0711m) this, this.f1436e);
        if (mo528d()) {
            m2971c(c0724g);
        } else {
            this.f1441j.add(c0724g);
        }
    }

    private void m2971c(C0724g c0724g) {
        View a;
        C0718a c0718a;
        LayoutInflater from = LayoutInflater.from(this.f1436e);
        Object c0722f = new C0722f(c0724g, from, this.f1440i);
        if (!mo528d() && this.f1452u) {
            c0722f.m2996a(true);
        } else if (mo528d()) {
            c0722f.m2996a(C0720k.m2954b(c0724g));
        }
        int a2 = C0720k.m2952a(c0722f, null, this.f1436e, this.f1437f);
        ad h = m2974h();
        h.mo694a((ListAdapter) c0722f);
        h.m4125g(a2);
        h.m4123e(this.f1445n);
        if (this.f1433b.size() > 0) {
            C0718a c0718a2 = (C0718a) this.f1433b.get(this.f1433b.size() - 1);
            a = m2970a(c0718a2, c0724g);
            c0718a = c0718a2;
        } else {
            a = null;
            c0718a = null;
        }
        if (a != null) {
            boolean z;
            int i;
            h.mo652b(false);
            h.m4154a(null);
            int d = m2972d(a2);
            if (d == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f1447p = d;
            int[] iArr = new int[2];
            a.getLocationInWindow(iArr);
            int j = c0718a.f1428a.m4131j() + iArr[0];
            int k = iArr[1] + c0718a.f1428a.m4132k();
            if ((this.f1445n & 5) == 5) {
                if (z) {
                    i = j + a2;
                } else {
                    i = j - a.getWidth();
                }
            } else if (z) {
                i = a.getWidth() + j;
            } else {
                i = j - a2;
            }
            h.m4119c(i);
            h.m4120d(k);
        } else {
            if (this.f1448q) {
                h.m4119c(this.f1450s);
            }
            if (this.f1449r) {
                h.m4120d(this.f1451t);
            }
            h.m4110a(m2968g());
        }
        this.f1433b.add(new C0718a(h, c0724g, this.f1447p));
        h.mo518a();
        if (c0718a == null && this.f1453v && c0724g.m3043l() != null) {
            ViewGroup e = h.mo529e();
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0666h.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(c0724g.m3043l());
            e.addHeaderView(frameLayout, null, false);
            h.mo518a();
        }
    }

    private MenuItem m2969a(C0724g c0724g, C0724g c0724g2) {
        int size = c0724g.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0724g.getItem(i);
            if (item.hasSubMenu() && c0724g2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View m2970a(C0718a c0718a, C0724g c0724g) {
        int i = 0;
        MenuItem a = m2969a(c0718a.f1429b, c0724g);
        if (a == null) {
            return null;
        }
        int headersCount;
        C0722f c0722f;
        int i2;
        ListView a2 = c0718a.m2947a();
        ListAdapter adapter = a2.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c0722f = (C0722f) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0722f = (C0722f) adapter;
            headersCount = 0;
        }
        int count = c0722f.getCount();
        while (i < count) {
            if (a == c0722f.m2995a(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - a2.getFirstVisiblePosition();
        if (i2 < 0 || i2 >= a2.getChildCount()) {
            return null;
        }
        return a2.getChildAt(i2);
    }

    public boolean mo528d() {
        return this.f1433b.size() > 0 && ((C0718a) this.f1433b.get(0)).f1428a.mo528d();
    }

    public void onDismiss() {
        C0718a c0718a;
        int size = this.f1433b.size();
        for (int i = 0; i < size; i++) {
            c0718a = (C0718a) this.f1433b.get(i);
            if (!c0718a.f1428a.mo528d()) {
                break;
            }
        }
        c0718a = null;
        if (c0718a != null) {
            c0718a.f1429b.m3021a(false);
        }
    }

    public void mo513b(boolean z) {
        for (C0718a a : this.f1433b) {
            C0720k.m2953a(a.m2947a().getAdapter()).notifyDataSetChanged();
        }
    }

    public void mo510a(C0736a c0736a) {
        this.f1454w = c0736a;
    }

    public boolean mo512a(C0741s c0741s) {
        for (C0718a c0718a : this.f1433b) {
            if (c0741s == c0718a.f1429b) {
                c0718a.m2947a().requestFocus();
                return true;
            }
        }
        if (!c0741s.hasVisibleItems()) {
            return false;
        }
        mo520a((C0724g) c0741s);
        if (this.f1454w != null) {
            this.f1454w.mo560a(c0741s);
        }
        return true;
    }

    private int m2973d(C0724g c0724g) {
        int size = this.f1433b.size();
        for (int i = 0; i < size; i++) {
            if (c0724g == ((C0718a) this.f1433b.get(i)).f1429b) {
                return i;
            }
        }
        return -1;
    }

    public void mo509a(C0724g c0724g, boolean z) {
        int d = m2973d(c0724g);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.f1433b.size()) {
                ((C0718a) this.f1433b.get(i)).f1429b.m3021a(false);
            }
            C0718a c0718a = (C0718a) this.f1433b.remove(d);
            c0718a.f1429b.m3017a((C0711m) this);
            if (this.f1435d) {
                c0718a.f1428a.m4156b(null);
                c0718a.f1428a.m4116b(0);
            }
            c0718a.f1428a.mo525c();
            d = this.f1433b.size();
            if (d > 0) {
                this.f1447p = ((C0718a) this.f1433b.get(d - 1)).f1430c;
            } else {
                this.f1447p = m2975i();
            }
            if (d == 0) {
                mo525c();
                if (this.f1454w != null) {
                    this.f1454w.mo559a(c0724g, true);
                }
                if (this.f1455x != null) {
                    if (this.f1455x.isAlive()) {
                        this.f1455x.removeGlobalOnLayoutListener(this.f1442k);
                    }
                    this.f1455x = null;
                }
                this.f1456y.onDismiss();
            } else if (z) {
                ((C0718a) this.f1433b.get(0)).f1429b.m3021a(false);
            }
        }
    }

    public boolean mo514b() {
        return false;
    }

    public void mo519a(int i) {
        if (this.f1444m != i) {
            this.f1444m = i;
            this.f1445n = C0567e.m2446a(i, ae.m2228h(this.f1446o));
        }
    }

    public void mo521a(View view) {
        if (this.f1446o != view) {
            this.f1446o = view;
            this.f1445n = C0567e.m2446a(this.f1444m, ae.m2228h(this.f1446o));
        }
    }

    public void mo522a(OnDismissListener onDismissListener) {
        this.f1456y = onDismissListener;
    }

    public ListView mo529e() {
        if (this.f1433b.isEmpty()) {
            return null;
        }
        return ((C0718a) this.f1433b.get(this.f1433b.size() - 1)).m2947a();
    }

    public void mo524b(int i) {
        this.f1448q = true;
        this.f1450s = i;
    }

    public void mo526c(int i) {
        this.f1449r = true;
        this.f1451t = i;
    }

    public void mo527c(boolean z) {
        this.f1453v = z;
    }

    protected boolean mo530f() {
        return false;
    }
}
