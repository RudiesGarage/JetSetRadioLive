package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.p020d.p021a.C0319b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemCompat */
public final class C0594p {
    static final C0589d f1146a;

    /* compiled from: MenuItemCompat */
    interface C0589d {
        MenuItem mo434a(MenuItem menuItem, View view);

        void mo435a(MenuItem menuItem, int i);

        boolean mo436a(MenuItem menuItem);

        MenuItem mo437b(MenuItem menuItem, int i);
    }

    /* compiled from: MenuItemCompat */
    static class C0590a implements C0589d {
        C0590a() {
        }

        public void mo435a(MenuItem menuItem, int i) {
        }

        public MenuItem mo434a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public MenuItem mo437b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public boolean mo436a(MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: MenuItemCompat */
    static class C0591b implements C0589d {
        C0591b() {
        }

        public void mo435a(MenuItem menuItem, int i) {
            C0595q.m2502a(menuItem, i);
        }

        public MenuItem mo434a(MenuItem menuItem, View view) {
            return C0595q.m2501a(menuItem, view);
        }

        public MenuItem mo437b(MenuItem menuItem, int i) {
            return C0595q.m2503b(menuItem, i);
        }

        public boolean mo436a(MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: MenuItemCompat */
    static class C0592c extends C0591b {
        C0592c() {
        }

        public boolean mo436a(MenuItem menuItem) {
            return C0596r.m2504a(menuItem);
        }
    }

    /* compiled from: MenuItemCompat */
    public interface C0593e {
        boolean mo538a(MenuItem menuItem);

        boolean mo539b(MenuItem menuItem);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f1146a = new C0592c();
        } else if (i >= 11) {
            f1146a = new C0591b();
        } else {
            f1146a = new C0590a();
        }
    }

    public static void m2498a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0319b) {
            ((C0319b) menuItem).setShowAsAction(i);
        } else {
            f1146a.mo435a(menuItem, i);
        }
    }

    public static MenuItem m2497a(MenuItem menuItem, View view) {
        if (menuItem instanceof C0319b) {
            return ((C0319b) menuItem).setActionView(view);
        }
        return f1146a.mo434a(menuItem, view);
    }

    public static MenuItem m2500b(MenuItem menuItem, int i) {
        if (menuItem instanceof C0319b) {
            return ((C0319b) menuItem).setActionView(i);
        }
        return f1146a.mo437b(menuItem, i);
    }

    public static MenuItem m2496a(MenuItem menuItem, C0563d c0563d) {
        if (menuItem instanceof C0319b) {
            return ((C0319b) menuItem).mo497a(c0563d);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static boolean m2499a(MenuItem menuItem) {
        if (menuItem instanceof C0319b) {
            return ((C0319b) menuItem).expandActionView();
        }
        return f1146a.mo436a(menuItem);
    }
}
