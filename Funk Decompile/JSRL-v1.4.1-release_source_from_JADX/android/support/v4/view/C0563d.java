package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider */
public abstract class C0563d {
    private final Context f1136a;
    private C0561a f1137b;
    private C0562b f1138c;

    /* compiled from: ActionProvider */
    public interface C0561a {
        void mo687a(boolean z);
    }

    /* compiled from: ActionProvider */
    public interface C0562b {
        void mo531a(boolean z);
    }

    public abstract View mo532a();

    public C0563d(Context context) {
        this.f1136a = context;
    }

    public View mo540a(MenuItem menuItem) {
        return mo532a();
    }

    public boolean mo542b() {
        return false;
    }

    public boolean mo543c() {
        return true;
    }

    public boolean mo534d() {
        return false;
    }

    public boolean mo535e() {
        return false;
    }

    public void mo533a(SubMenu subMenu) {
    }

    public void m2437a(boolean z) {
        if (this.f1137b != null) {
            this.f1137b.mo687a(z);
        }
    }

    public void m2434a(C0561a c0561a) {
        this.f1137b = c0561a;
    }

    public void mo541a(C0562b c0562b) {
        if (!(this.f1138c == null || c0562b == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1138c = c0562b;
    }

    public void m2442f() {
        this.f1138c = null;
        this.f1137b = null;
    }
}
