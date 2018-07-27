package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p020d.p021a.C0320c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuWrapperICS */
class C0742t extends C0738p implements SubMenu {
    C0742t(Context context, C0320c c0320c) {
        super(context, c0320c);
    }

    public C0320c m3135b() {
        return (C0320c) this.b;
    }

    public SubMenu setHeaderTitle(int i) {
        m3135b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m3135b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        m3135b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m3135b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m3135b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        m3135b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        m3135b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m3135b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return m2938a(m3135b().getItem());
    }
}
