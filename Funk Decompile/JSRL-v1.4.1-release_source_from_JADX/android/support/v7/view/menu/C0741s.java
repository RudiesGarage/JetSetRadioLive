package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.C0724g.C0723a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuBuilder */
public class C0741s extends C0724g implements SubMenu {
    private C0724g f1556d;
    private C0726h f1557e;

    public C0741s(Context context, C0724g c0724g, C0726h c0726h) {
        super(context);
        this.f1556d = c0724g;
        this.f1557e = c0726h;
    }

    public void setQwertyMode(boolean z) {
        this.f1556d.setQwertyMode(z);
    }

    public boolean mo546a() {
        return this.f1556d.mo546a();
    }

    public boolean mo548b() {
        return this.f1556d.mo548b();
    }

    public Menu m3134p() {
        return this.f1556d;
    }

    public MenuItem getItem() {
        return this.f1557e;
    }

    public void mo545a(C0723a c0723a) {
        this.f1556d.mo545a(c0723a);
    }

    public C0724g mo551m() {
        return this.f1556d.mo551m();
    }

    boolean mo547a(C0724g c0724g, MenuItem menuItem) {
        return super.mo547a(c0724g, menuItem) || this.f1556d.mo547a(c0724g, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1557e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1557e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m3010a(drawable);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.m3034d(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m3012a(charSequence);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.m3031c(i);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m3011a(view);
    }

    public boolean mo549c(C0726h c0726h) {
        return this.f1556d.mo549c(c0726h);
    }

    public boolean mo550d(C0726h c0726h) {
        return this.f1556d.mo550d(c0726h);
    }
}
