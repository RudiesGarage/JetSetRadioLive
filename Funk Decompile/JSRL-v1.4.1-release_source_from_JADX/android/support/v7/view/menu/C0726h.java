package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p020d.p021a.C0319b;
import android.support.v4.view.C0563d;
import android.support.v4.view.C0563d.C0562b;
import android.support.v4.view.C0594p.C0593e;
import android.support.v7.p028c.p029a.C0673b;
import android.support.v7.view.menu.C0709n.C0706a;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

/* compiled from: MenuItemImpl */
public final class C0726h implements C0319b {
    private static String f1489w;
    private static String f1490x;
    private static String f1491y;
    private static String f1492z;
    C0724g f1493a;
    private final int f1494b;
    private final int f1495c;
    private final int f1496d;
    private final int f1497e;
    private CharSequence f1498f;
    private CharSequence f1499g;
    private Intent f1500h;
    private char f1501i;
    private char f1502j;
    private Drawable f1503k;
    private int f1504l = 0;
    private C0741s f1505m;
    private Runnable f1506n;
    private OnMenuItemClickListener f1507o;
    private int f1508p = 16;
    private int f1509q = 0;
    private View f1510r;
    private C0563d f1511s;
    private C0593e f1512t;
    private boolean f1513u = false;
    private ContextMenuInfo f1514v;

    /* compiled from: MenuItemImpl */
    class C07251 implements C0562b {
        final /* synthetic */ C0726h f1488a;

        C07251(C0726h c0726h) {
            this.f1488a = c0726h;
        }

        public void mo531a(boolean z) {
            this.f1488a.f1493a.m3016a(this.f1488a);
        }
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3048a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3051a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3057b(i);
    }

    C0726h(C0724g c0724g, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1493a = c0724g;
        this.f1494b = i2;
        this.f1495c = i;
        this.f1496d = i3;
        this.f1497e = i4;
        this.f1498f = charSequence;
        this.f1509q = i5;
    }

    public boolean m3059b() {
        if ((this.f1507o != null && this.f1507o.onMenuItemClick(this)) || this.f1493a.mo547a(this.f1493a.mo551m(), (MenuItem) this)) {
            return true;
        }
        if (this.f1506n != null) {
            this.f1506n.run();
            return true;
        }
        if (this.f1500h != null) {
            try {
                this.f1493a.m3033d().startActivity(this.f1500h);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f1511s == null || !this.f1511s.mo534d()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f1508p & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1508p |= 16;
        } else {
            this.f1508p &= -17;
        }
        this.f1493a.m3028b(false);
        return this;
    }

    public int getGroupId() {
        return this.f1495c;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f1494b;
    }

    public int getOrder() {
        return this.f1496d;
    }

    public int m3060c() {
        return this.f1497e;
    }

    public Intent getIntent() {
        return this.f1500h;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1500h = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f1502j;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1502j != c) {
            this.f1502j = Character.toLowerCase(c);
            this.f1493a.m3028b(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.f1501i;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1501i != c) {
            this.f1501i = c;
            this.f1493a.m3028b(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1501i = c;
        this.f1502j = Character.toLowerCase(c2);
        this.f1493a.m3028b(false);
        return this;
    }

    char m3062d() {
        return this.f1493a.mo546a() ? this.f1502j : this.f1501i;
    }

    String m3064e() {
        char d = m3062d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f1489w);
        switch (d) {
            case '\b':
                stringBuilder.append(f1491y);
                break;
            case '\n':
                stringBuilder.append(f1490x);
                break;
            case ' ':
                stringBuilder.append(f1492z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    boolean m3066f() {
        return this.f1493a.mo548b() && m3062d() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.f1505m;
    }

    public boolean hasSubMenu() {
        return this.f1505m != null;
    }

    public void m3054a(C0741s c0741s) {
        this.f1505m = c0741s;
        c0741s.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1498f;
    }

    CharSequence m3053a(C0706a c0706a) {
        if (c0706a == null || !c0706a.mo492a()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1498f = charSequence;
        this.f1493a.m3028b(false);
        if (this.f1505m != null) {
            this.f1505m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f1493a.m3033d().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1499g != null ? this.f1499g : this.f1498f;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1499g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1498f;
        }
        this.f1493a.m3028b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f1503k != null) {
            return this.f1503k;
        }
        if (this.f1504l == 0) {
            return null;
        }
        Drawable b = C0673b.m2768b(this.f1493a.m3033d(), this.f1504l);
        this.f1504l = 0;
        this.f1503k = b;
        return b;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1504l = 0;
        this.f1503k = drawable;
        this.f1493a.m3028b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1503k = null;
        this.f1504l = i;
        this.f1493a.m3028b(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.f1508p & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1508p;
        this.f1508p = (z ? 1 : 0) | (this.f1508p & -2);
        if (i != this.f1508p) {
            this.f1493a.m3028b(false);
        }
        return this;
    }

    public void m3056a(boolean z) {
        this.f1508p = (z ? 4 : 0) | (this.f1508p & -5);
    }

    public boolean m3067g() {
        return (this.f1508p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f1508p & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1508p & 4) != 0) {
            this.f1493a.m3019a((MenuItem) this);
        } else {
            m3058b(z);
        }
        return this;
    }

    void m3058b(boolean z) {
        int i;
        int i2 = this.f1508p;
        int i3 = this.f1508p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f1508p = i | i3;
        if (i2 != this.f1508p) {
            this.f1493a.m3028b(false);
        }
    }

    public boolean isVisible() {
        if (this.f1511s == null || !this.f1511s.mo542b()) {
            if ((this.f1508p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f1508p & 8) == 0 && this.f1511s.mo543c()) {
            return true;
        } else {
            return false;
        }
    }

    boolean m3061c(boolean z) {
        int i = this.f1508p;
        this.f1508p = (z ? 0 : 8) | (this.f1508p & -9);
        if (i != this.f1508p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (m3061c(z)) {
            this.f1493a.m3016a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1507o = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.f1498f != null ? this.f1498f.toString() : null;
    }

    void m3055a(ContextMenuInfo contextMenuInfo) {
        this.f1514v = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f1514v;
    }

    public void m3068h() {
        this.f1493a.m3027b(this);
    }

    public boolean m3069i() {
        return this.f1493a.m3045n();
    }

    public boolean m3070j() {
        return (this.f1508p & 32) == 32;
    }

    public boolean m3071k() {
        return (this.f1509q & 1) == 1;
    }

    public boolean m3072l() {
        return (this.f1509q & 2) == 2;
    }

    public void m3063d(boolean z) {
        if (z) {
            this.f1508p |= 32;
        } else {
            this.f1508p &= -33;
        }
    }

    public boolean m3073m() {
        return (this.f1509q & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1509q = i;
                this.f1493a.m3027b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public C0319b m3051a(View view) {
        this.f1510r = view;
        this.f1511s = null;
        if (view != null && view.getId() == -1 && this.f1494b > 0) {
            view.setId(this.f1494b);
        }
        this.f1493a.m3027b(this);
        return this;
    }

    public C0319b m3048a(int i) {
        Context d = this.f1493a.m3033d();
        m3051a(LayoutInflater.from(d).inflate(i, new LinearLayout(d), false));
        return this;
    }

    public View getActionView() {
        if (this.f1510r != null) {
            return this.f1510r;
        }
        if (this.f1511s == null) {
            return null;
        }
        this.f1510r = this.f1511s.mo540a((MenuItem) this);
        return this.f1510r;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public C0563d mo499a() {
        return this.f1511s;
    }

    public C0319b mo497a(C0563d c0563d) {
        if (this.f1511s != null) {
            this.f1511s.m2442f();
        }
        this.f1510r = null;
        this.f1511s = c0563d;
        this.f1493a.m3028b(true);
        if (this.f1511s != null) {
            this.f1511s.mo541a(new C07251(this));
        }
        return this;
    }

    public C0319b m3057b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!m3074n()) {
            return false;
        }
        if (this.f1512t == null || this.f1512t.mo538a(this)) {
            return this.f1493a.mo549c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f1509q & 8) == 0) {
            return false;
        }
        if (this.f1510r == null) {
            return true;
        }
        if (this.f1512t == null || this.f1512t.mo539b(this)) {
            return this.f1493a.mo550d(this);
        }
        return false;
    }

    public C0319b mo498a(C0593e c0593e) {
        this.f1512t = c0593e;
        return this;
    }

    public boolean m3074n() {
        if ((this.f1509q & 8) == 0) {
            return false;
        }
        if (this.f1510r == null && this.f1511s != null) {
            this.f1510r = this.f1511s.mo540a((MenuItem) this);
        }
        if (this.f1510r != null) {
            return true;
        }
        return false;
    }

    public void m3065e(boolean z) {
        this.f1513u = z;
        this.f1493a.m3028b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f1513u;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
