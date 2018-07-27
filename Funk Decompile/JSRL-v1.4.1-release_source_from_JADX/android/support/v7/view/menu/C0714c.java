package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p020d.p021a.C0319b;
import android.support.v4.p020d.p021a.C0320c;
import android.support.v4.p024g.C0357a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BaseMenuWrapper */
abstract class C0714c<T> extends C0713d<T> {
    final Context f1419a;
    private Map<C0319b, MenuItem> f1420c;
    private Map<C0320c, SubMenu> f1421d;

    C0714c(Context context, T t) {
        super(t);
        this.f1419a = context;
    }

    final MenuItem m2938a(MenuItem menuItem) {
        if (!(menuItem instanceof C0319b)) {
            return menuItem;
        }
        C0319b c0319b = (C0319b) menuItem;
        if (this.f1420c == null) {
            this.f1420c = new C0357a();
        }
        MenuItem menuItem2 = (MenuItem) this.f1420c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = C0737o.m3107a(this.f1419a, c0319b);
        this.f1420c.put(c0319b, menuItem2);
        return menuItem2;
    }

    final SubMenu m2939a(SubMenu subMenu) {
        if (!(subMenu instanceof C0320c)) {
            return subMenu;
        }
        C0320c c0320c = (C0320c) subMenu;
        if (this.f1421d == null) {
            this.f1421d = new C0357a();
        }
        SubMenu subMenu2 = (SubMenu) this.f1421d.get(c0320c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = C0737o.m3108a(this.f1419a, c0320c);
        this.f1421d.put(c0320c, subMenu2);
        return subMenu2;
    }

    final void m2940a() {
        if (this.f1420c != null) {
            this.f1420c.clear();
        }
        if (this.f1421d != null) {
            this.f1421d.clear();
        }
    }

    final void m2941a(int i) {
        if (this.f1420c != null) {
            Iterator it = this.f1420c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m2942b(int i) {
        if (this.f1420c != null) {
            Iterator it = this.f1420c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
