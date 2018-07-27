package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p020d.p021a.C0319b;
import android.support.v4.view.C0563d.C0562b;
import android.support.v7.view.menu.C0731i.C0727a;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
/* compiled from: MenuItemWrapperJB */
class C0733j extends C0731i {

    /* compiled from: MenuItemWrapperJB */
    class C0732a extends C0727a implements VisibilityListener {
        C0562b f1521c;
        final /* synthetic */ C0733j f1522d;

        public C0732a(C0733j c0733j, Context context, ActionProvider actionProvider) {
            this.f1522d = c0733j;
            super(c0733j, context, actionProvider);
        }

        public View mo540a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public boolean mo542b() {
            return this.a.overridesItemVisibility();
        }

        public boolean mo543c() {
            return this.a.isVisible();
        }

        public void mo541a(C0562b c0562b) {
            VisibilityListener visibilityListener;
            this.f1521c = c0562b;
            ActionProvider actionProvider = this.a;
            if (c0562b == null) {
                visibilityListener = null;
            }
            actionProvider.setVisibilityListener(visibilityListener);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1521c != null) {
                this.f1521c.mo531a(z);
            }
        }
    }

    C0733j(Context context, C0319b c0319b) {
        super(context, c0319b);
    }

    C0727a mo544a(ActionProvider actionProvider) {
        return new C0732a(this, this.a, actionProvider);
    }
}
