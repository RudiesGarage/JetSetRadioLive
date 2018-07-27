package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0454a;
import android.support.v4.view.p025a.C0489c;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: RecyclerViewAccessibilityDelegate */
public class ag extends C0454a {
    final RecyclerView f2168b;
    final C0454a f2169c = new C08391(this);

    /* compiled from: RecyclerViewAccessibilityDelegate */
    class C08391 extends C0454a {
        final /* synthetic */ ag f2167b;

        C08391(ag agVar) {
            this.f2167b = agVar;
        }

        public void mo284a(View view, C0489c c0489c) {
            super.mo284a(view, c0489c);
            if (!this.f2167b.m4210c() && this.f2167b.f2168b.getLayoutManager() != null) {
                this.f2167b.f2168b.getLayoutManager().m3290a(view, c0489c);
            }
        }

        public boolean mo285a(View view, int i, Bundle bundle) {
            if (super.mo285a(view, i, bundle)) {
                return true;
            }
            if (this.f2167b.m4210c() || this.f2167b.f2168b.getLayoutManager() == null) {
                return false;
            }
            return this.f2167b.f2168b.getLayoutManager().m3303a(view, i, bundle);
        }
    }

    public ag(RecyclerView recyclerView) {
        this.f2168b = recyclerView;
    }

    private boolean m4210c() {
        return this.f2168b.m3860p();
    }

    public boolean mo285a(View view, int i, Bundle bundle) {
        if (super.mo285a(view, i, bundle)) {
            return true;
        }
        if (m4210c() || this.f2168b.getLayoutManager() == null) {
            return false;
        }
        return this.f2168b.getLayoutManager().m3294a(i, bundle);
    }

    public void mo284a(View view, C0489c c0489c) {
        super.mo284a(view, c0489c);
        c0489c.m1945a(RecyclerView.class.getName());
        if (!m4210c() && this.f2168b.getLayoutManager() != null) {
            this.f2168b.getLayoutManager().m3272a(c0489c);
        }
    }

    public void mo286d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo286d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m4210c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().mo579a(accessibilityEvent);
            }
        }
    }

    C0454a m4213b() {
        return this.f2169c;
    }
}
