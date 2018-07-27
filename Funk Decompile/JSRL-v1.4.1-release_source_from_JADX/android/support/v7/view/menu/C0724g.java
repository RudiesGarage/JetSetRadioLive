package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p018b.C0185a;
import android.support.v4.p020d.p021a.C0318a;
import android.support.v4.view.C0563d;
import android.support.v7.p027b.C0670a.C0660b;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuBuilder */
public class C0724g implements C0318a {
    private static final int[] f1463d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence f1464a;
    Drawable f1465b;
    View f1466c;
    private final Context f1467e;
    private final Resources f1468f;
    private boolean f1469g;
    private boolean f1470h;
    private C0723a f1471i;
    private ArrayList<C0726h> f1472j;
    private ArrayList<C0726h> f1473k;
    private boolean f1474l;
    private ArrayList<C0726h> f1475m;
    private ArrayList<C0726h> f1476n;
    private boolean f1477o;
    private int f1478p = 0;
    private ContextMenuInfo f1479q;
    private boolean f1480r = false;
    private boolean f1481s = false;
    private boolean f1482t = false;
    private boolean f1483u = false;
    private ArrayList<C0726h> f1484v = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<C0711m>> f1485w = new CopyOnWriteArrayList();
    private C0726h f1486x;
    private boolean f1487y;

    /* compiled from: MenuBuilder */
    public interface C0708b {
        boolean mo496a(C0726h c0726h);
    }

    /* compiled from: MenuBuilder */
    public interface C0723a {
        void mo561a(C0724g c0724g);

        boolean mo562a(C0724g c0724g, MenuItem menuItem);
    }

    public C0724g(Context context) {
        this.f1467e = context;
        this.f1468f = context.getResources();
        this.f1472j = new ArrayList();
        this.f1473k = new ArrayList();
        this.f1474l = true;
        this.f1475m = new ArrayList();
        this.f1476n = new ArrayList();
        this.f1477o = true;
        m3006d(true);
    }

    public void m3018a(C0711m c0711m, Context context) {
        this.f1485w.add(new WeakReference(c0711m));
        c0711m.mo508a(context, this);
        this.f1477o = true;
    }

    public void m3017a(C0711m c0711m) {
        Iterator it = this.f1485w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0711m c0711m2 = (C0711m) weakReference.get();
            if (c0711m2 == null || c0711m2 == c0711m) {
                this.f1485w.remove(weakReference);
            }
        }
    }

    private void m3005c(boolean z) {
        if (!this.f1485w.isEmpty()) {
            m3037f();
            Iterator it = this.f1485w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0711m c0711m = (C0711m) weakReference.get();
                if (c0711m == null) {
                    this.f1485w.remove(weakReference);
                } else {
                    c0711m.mo513b(z);
                }
            }
            m3038g();
        }
    }

    private boolean m3004a(C0741s c0741s, C0711m c0711m) {
        boolean z = false;
        if (this.f1485w.isEmpty()) {
            return false;
        }
        if (c0711m != null) {
            z = c0711m.mo512a(c0741s);
        }
        Iterator it = this.f1485w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0711m c0711m2 = (C0711m) weakReference.get();
            if (c0711m2 == null) {
                this.f1485w.remove(weakReference);
                z = z2;
            } else if (z2) {
                z = z2;
            } else {
                z = c0711m2.mo512a(c0741s);
            }
            z2 = z;
        }
        return z2;
    }

    public void mo545a(C0723a c0723a) {
        this.f1471i = c0723a;
    }

    protected MenuItem m3014a(int i, int i2, int i3, CharSequence charSequence) {
        int e = C0724g.m3007e(i3);
        MenuItem a = m3001a(i, i2, i3, e, charSequence, this.f1478p);
        if (this.f1479q != null) {
            a.m3055a(this.f1479q);
        }
        this.f1472j.add(C0724g.m3000a(this.f1472j, e), a);
        m3028b(true);
        return a;
    }

    private C0726h m3001a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0726h(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return m3014a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m3014a(0, 0, 0, this.f1468f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m3014a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m3014a(i, i2, i3, this.f1468f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1468f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0726h c0726h = (C0726h) m3014a(i, i2, i3, charSequence);
        C0741s c0741s = new C0741s(this.f1467e, this, c0726h);
        c0726h.m3054a(c0741s);
        return c0741s;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1468f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1467e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m3003a(m3008a(i), true);
    }

    public void removeGroup(int i) {
        int b = m3026b(i);
        if (b >= 0) {
            int size = this.f1472j.size() - b;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C0726h) this.f1472j.get(b)).getGroupId() != i) {
                    m3028b(true);
                } else {
                    m3003a(b, false);
                    i2 = i3;
                }
            }
            m3028b(true);
        }
    }

    private void m3003a(int i, boolean z) {
        if (i >= 0 && i < this.f1472j.size()) {
            this.f1472j.remove(i);
            if (z) {
                m3028b(true);
            }
        }
    }

    public void clear() {
        if (this.f1486x != null) {
            mo550d(this.f1486x);
        }
        this.f1472j.clear();
        m3028b(true);
    }

    void m3019a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1472j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0726h) this.f1472j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m3067g() && menuItem2.isCheckable()) {
                menuItem2.m3058b(menuItem2 == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1472j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0726h c0726h = (C0726h) this.f1472j.get(i2);
            if (c0726h.getGroupId() == i) {
                c0726h.m3056a(z2);
                c0726h.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f1472j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            C0726h c0726h = (C0726h) this.f1472j.get(i2);
            if (c0726h.getGroupId() == i && c0726h.m3061c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            m3028b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1472j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0726h c0726h = (C0726h) this.f1472j.get(i2);
            if (c0726h.getGroupId() == i) {
                c0726h.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1487y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0726h) this.f1472j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0726h c0726h = (C0726h) this.f1472j.get(i2);
            if (c0726h.getItemId() == i) {
                return c0726h;
            }
            if (c0726h.hasSubMenu()) {
                MenuItem findItem = c0726h.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int m3008a(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0726h) this.f1472j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int m3026b(int i) {
        return m3009a(i, 0);
    }

    public int m3009a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0726h) this.f1472j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f1472j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f1472j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m3013a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f1469g = z;
        m3028b(false);
    }

    private static int m3007e(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f1463d.length) {
            return (f1463d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean mo546a() {
        return this.f1469g;
    }

    private void m3006d(boolean z) {
        boolean z2 = true;
        if (!(z && this.f1468f.getConfiguration().keyboard != 1 && this.f1468f.getBoolean(C0660b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f1470h = z2;
    }

    public boolean mo548b() {
        return this.f1470h;
    }

    Resources m3030c() {
        return this.f1468f;
    }

    public Context m3033d() {
        return this.f1467e;
    }

    boolean mo547a(C0724g c0724g, MenuItem menuItem) {
        return this.f1471i != null && this.f1471i.mo562a(c0724g, menuItem);
    }

    public void m3036e() {
        if (this.f1471i != null) {
            this.f1471i.mo561a(this);
        }
    }

    private static int m3000a(ArrayList<C0726h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0726h) arrayList.get(size)).m3060c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m3013a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m3024a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m3021a(true);
        }
        return z;
    }

    void m3020a(List<C0726h> list, int i, KeyEvent keyEvent) {
        boolean a = mo546a();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1472j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0726h c0726h = (C0726h) this.f1472j.get(i2);
                if (c0726h.hasSubMenu()) {
                    ((C0724g) c0726h.getSubMenu()).m3020a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = a ? c0726h.getAlphabeticShortcut() : c0726h.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (a && alphabeticShortcut == '\b' && i == 67)) && c0726h.isEnabled())) {
                    list.add(c0726h);
                }
            }
        }
    }

    C0726h m3013a(int i, KeyEvent keyEvent) {
        List list = this.f1484v;
        list.clear();
        m3020a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0726h) list.get(0);
        }
        boolean a = mo546a();
        for (int i2 = 0; i2 < size; i2++) {
            char alphabeticShortcut;
            C0726h c0726h = (C0726h) list.get(i2);
            if (a) {
                alphabeticShortcut = c0726h.getAlphabeticShortcut();
            } else {
                alphabeticShortcut = c0726h.getNumericShortcut();
            }
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0726h;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0726h;
            }
            if (a && alphabeticShortcut == '\b' && i == 67) {
                return c0726h;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m3024a(findItem(i), i2);
    }

    public boolean m3024a(MenuItem menuItem, int i) {
        return m3025a(menuItem, null, i);
    }

    public boolean m3025a(MenuItem menuItem, C0711m c0711m, int i) {
        C0726h c0726h = (C0726h) menuItem;
        if (c0726h == null || !c0726h.isEnabled()) {
            return false;
        }
        boolean z;
        boolean b = c0726h.m3059b();
        C0563d a = c0726h.mo499a();
        if (a == null || !a.mo535e()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (c0726h.m3074n()) {
            expandActionView = c0726h.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m3021a(true);
            return expandActionView;
        } else if (c0726h.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                m3021a(false);
            }
            if (!c0726h.hasSubMenu()) {
                c0726h.m3054a(new C0741s(m3033d(), this, c0726h));
            }
            C0741s c0741s = (C0741s) c0726h.getSubMenu();
            if (z) {
                a.mo533a((SubMenu) c0741s);
            }
            expandActionView = m3004a(c0741s, c0711m) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m3021a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m3021a(true);
            }
            return b;
        }
    }

    public final void m3021a(boolean z) {
        if (!this.f1483u) {
            this.f1483u = true;
            Iterator it = this.f1485w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0711m c0711m = (C0711m) weakReference.get();
                if (c0711m == null) {
                    this.f1485w.remove(weakReference);
                } else {
                    c0711m.mo509a(this, z);
                }
            }
            this.f1483u = false;
        }
    }

    public void close() {
        m3021a(true);
    }

    public void m3028b(boolean z) {
        if (this.f1480r) {
            this.f1481s = true;
            return;
        }
        if (z) {
            this.f1474l = true;
            this.f1477o = true;
        }
        m3005c(z);
    }

    public void m3037f() {
        if (!this.f1480r) {
            this.f1480r = true;
            this.f1481s = false;
        }
    }

    public void m3038g() {
        this.f1480r = false;
        if (this.f1481s) {
            this.f1481s = false;
            m3028b(true);
        }
    }

    void m3016a(C0726h c0726h) {
        this.f1474l = true;
        m3028b(true);
    }

    void m3027b(C0726h c0726h) {
        this.f1477o = true;
        m3028b(true);
    }

    public ArrayList<C0726h> m3039h() {
        if (!this.f1474l) {
            return this.f1473k;
        }
        this.f1473k.clear();
        int size = this.f1472j.size();
        for (int i = 0; i < size; i++) {
            C0726h c0726h = (C0726h) this.f1472j.get(i);
            if (c0726h.isVisible()) {
                this.f1473k.add(c0726h);
            }
        }
        this.f1474l = false;
        this.f1477o = true;
        return this.f1473k;
    }

    public void m3040i() {
        ArrayList h = m3039h();
        if (this.f1477o) {
            Iterator it = this.f1485w.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                WeakReference weakReference = (WeakReference) it.next();
                C0711m c0711m = (C0711m) weakReference.get();
                if (c0711m == null) {
                    this.f1485w.remove(weakReference);
                    i2 = i;
                } else {
                    i2 = c0711m.mo514b() | i;
                }
                i = i2;
            }
            if (i != 0) {
                this.f1475m.clear();
                this.f1476n.clear();
                i = h.size();
                for (int i3 = 0; i3 < i; i3++) {
                    C0726h c0726h = (C0726h) h.get(i3);
                    if (c0726h.m3070j()) {
                        this.f1475m.add(c0726h);
                    } else {
                        this.f1476n.add(c0726h);
                    }
                }
            } else {
                this.f1475m.clear();
                this.f1476n.clear();
                this.f1476n.addAll(m3039h());
            }
            this.f1477o = false;
        }
    }

    public ArrayList<C0726h> m3041j() {
        m3040i();
        return this.f1475m;
    }

    public ArrayList<C0726h> m3042k() {
        m3040i();
        return this.f1476n;
    }

    public void clearHeader() {
        this.f1465b = null;
        this.f1464a = null;
        this.f1466c = null;
        m3028b(false);
    }

    private void m3002a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources c = m3030c();
        if (view != null) {
            this.f1466c = view;
            this.f1464a = null;
            this.f1465b = null;
        } else {
            if (i > 0) {
                this.f1464a = c.getText(i);
            } else if (charSequence != null) {
                this.f1464a = charSequence;
            }
            if (i2 > 0) {
                this.f1465b = C0185a.m612a(m3033d(), i2);
            } else if (drawable != null) {
                this.f1465b = drawable;
            }
            this.f1466c = null;
        }
        m3028b(false);
    }

    protected C0724g m3012a(CharSequence charSequence) {
        m3002a(0, charSequence, 0, null, null);
        return this;
    }

    protected C0724g m3031c(int i) {
        m3002a(i, null, 0, null, null);
        return this;
    }

    protected C0724g m3010a(Drawable drawable) {
        m3002a(0, null, 0, drawable, null);
        return this;
    }

    protected C0724g m3034d(int i) {
        m3002a(0, null, i, null, null);
        return this;
    }

    protected C0724g m3011a(View view) {
        m3002a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m3043l() {
        return this.f1464a;
    }

    public C0724g mo551m() {
        return this;
    }

    boolean m3045n() {
        return this.f1482t;
    }

    public boolean mo549c(C0726h c0726h) {
        boolean z = false;
        if (!this.f1485w.isEmpty()) {
            m3037f();
            Iterator it = this.f1485w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0711m c0711m = (C0711m) weakReference.get();
                if (c0711m == null) {
                    this.f1485w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0711m.mo511a(this, c0726h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3038g();
            if (z) {
                this.f1486x = c0726h;
            }
        }
        return z;
    }

    public boolean mo550d(C0726h c0726h) {
        boolean z = false;
        if (!this.f1485w.isEmpty() && this.f1486x == c0726h) {
            m3037f();
            Iterator it = this.f1485w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0711m c0711m = (C0711m) weakReference.get();
                if (c0711m == null) {
                    this.f1485w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0711m.mo515b(this, c0726h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3038g();
            if (z) {
                this.f1486x = null;
            }
        }
        return z;
    }

    public C0726h m3046o() {
        return this.f1486x;
    }
}
