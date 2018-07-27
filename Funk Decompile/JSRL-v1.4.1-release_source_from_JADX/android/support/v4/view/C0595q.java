package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemCompatHoneycomb */
class C0595q {
    public static void m2502a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m2501a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static MenuItem m2503b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }
}
