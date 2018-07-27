package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p020d.p021a.C0319b;
import android.support.v4.view.C0563d;
import android.support.v4.view.C0594p.C0593e;
import android.support.v7.view.C0697b;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
/* compiled from: MenuItemWrapperICS */
public class C0731i extends C0714c<C0319b> implements MenuItem {
    private Method f1520c;

    /* compiled from: MenuItemWrapperICS */
    class C0727a extends C0563d {
        final ActionProvider f1515a;
        final /* synthetic */ C0731i f1516b;

        public C0727a(C0731i c0731i, Context context, ActionProvider actionProvider) {
            this.f1516b = c0731i;
            super(context);
            this.f1515a = actionProvider;
        }

        public View mo532a() {
            return this.f1515a.onCreateActionView();
        }

        public boolean mo534d() {
            return this.f1515a.onPerformDefaultAction();
        }

        public boolean mo535e() {
            return this.f1515a.hasSubMenu();
        }

        public void mo533a(SubMenu subMenu) {
            this.f1515a.onPrepareSubMenu(this.f1516b.m2939a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    static class C0728b extends FrameLayout implements C0697b {
        final CollapsibleActionView f1517a;

        C0728b(View view) {
            super(view.getContext());
            this.f1517a = (CollapsibleActionView) view;
            addView(view);
        }

        public void mo536a() {
            this.f1517a.onActionViewExpanded();
        }

        public void mo537b() {
            this.f1517a.onActionViewCollapsed();
        }

        View m3081c() {
            return (View) this.f1517a;
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class C0729c extends C0713d<OnActionExpandListener> implements C0593e {
        final /* synthetic */ C0731i f1518a;

        C0729c(C0731i c0731i, OnActionExpandListener onActionExpandListener) {
            this.f1518a = c0731i;
            super(onActionExpandListener);
        }

        public boolean mo538a(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f1518a.m2938a(menuItem));
        }

        public boolean mo539b(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f1518a.m2938a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class C0730d extends C0713d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ C0731i f1519a;

        C0730d(C0731i c0731i, OnMenuItemClickListener onMenuItemClickListener) {
            this.f1519a = c0731i;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f1519a.m2938a(menuItem));
        }
    }

    C0731i(Context context, C0319b c0319b) {
        super(context, c0319b);
    }

    public int getItemId() {
        return ((C0319b) this.b).getItemId();
    }

    public int getGroupId() {
        return ((C0319b) this.b).getGroupId();
    }

    public int getOrder() {
        return ((C0319b) this.b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0319b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0319b) this.b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((C0319b) this.b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0319b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((C0319b) this.b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0319b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0319b) this.b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((C0319b) this.b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((C0319b) this.b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((C0319b) this.b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0319b) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0319b) this.b).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((C0319b) this.b).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0319b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((C0319b) this.b).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((C0319b) this.b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((C0319b) this.b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((C0319b) this.b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((C0319b) this.b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((C0319b) this.b).setVisible(z);
    }

    public boolean isVisible() {
        return ((C0319b) this.b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((C0319b) this.b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((C0319b) this.b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((C0319b) this.b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m2939a(((C0319b) this.b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0319b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0730d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0319b) this.b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((C0319b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0319b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0728b(view);
        }
        ((C0319b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0319b) this.b).setActionView(i);
        View actionView = ((C0319b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0319b) this.b).setActionView(new C0728b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((C0319b) this.b).getActionView();
        if (actionView instanceof C0728b) {
            return ((C0728b) actionView).m3081c();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0319b) this.b).mo497a(actionProvider != null ? mo544a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        C0563d a = ((C0319b) this.b).mo499a();
        if (a instanceof C0727a) {
            return ((C0727a) a).f1515a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((C0319b) this.b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((C0319b) this.b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((C0319b) this.b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0319b) this.b).mo498a(onActionExpandListener != null ? new C0729c(this, onActionExpandListener) : null);
        return this;
    }

    public void m3085a(boolean z) {
        try {
            if (this.f1520c == null) {
                this.f1520c = ((C0319b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1520c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    C0727a mo544a(ActionProvider actionProvider) {
        return new C0727a(this, this.a, actionProvider);
    }
}
