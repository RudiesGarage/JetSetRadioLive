package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.view.menu.C0722f;
import android.support.v7.view.menu.C0724g;
import android.support.v7.view.menu.ListMenuItemView;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow */
public class ad extends aa implements ac {
    private static Method f2162a;
    private ac f2163b;

    /* compiled from: MenuPopupWindow */
    public static class C0835a extends C0834v {
        final int f2158g;
        final int f2159h;
        private ac f2160i;
        private MenuItem f2161j;

        public /* bridge */ /* synthetic */ boolean mo646a(MotionEvent motionEvent, int i) {
            return super.mo646a(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public C0835a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f2158g = 22;
                this.f2159h = 21;
                return;
            }
            this.f2158g = 21;
            this.f2159h = 22;
        }

        public void setHoverListener(ac acVar) {
            this.f2160i = acVar;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f2158g) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.f2159h) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((C0722f) getAdapter()).m2994a().m3021a(false);
                return true;
            }
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.f2160i != null) {
                int headersCount;
                C0722f c0722f;
                MenuItem a;
                MenuItem menuItem;
                C0724g a2;
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    c0722f = (C0722f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    c0722f = (C0722f) adapter;
                }
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        headersCount = pointToPosition - headersCount;
                        if (headersCount >= 0 && headersCount < c0722f.getCount()) {
                            a = c0722f.m2995a(headersCount);
                            menuItem = this.f2161j;
                            if (menuItem != a) {
                                a2 = c0722f.m2994a();
                                if (menuItem != null) {
                                    this.f2160i.mo516a(a2, menuItem);
                                }
                                this.f2161j = a;
                                if (a != null) {
                                    this.f2160i.mo517b(a2, a);
                                }
                            }
                        }
                    }
                }
                a = null;
                menuItem = this.f2161j;
                if (menuItem != a) {
                    a2 = c0722f.m2994a();
                    if (menuItem != null) {
                        this.f2160i.mo516a(a2, menuItem);
                    }
                    this.f2161j = a;
                    if (a != null) {
                        this.f2160i.mo517b(a2, a);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }

    static {
        try {
            f2162a = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public ad(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    C0834v mo651a(Context context, boolean z) {
        C0834v c0835a = new C0835a(context, z);
        c0835a.setHoverListener(this);
        return c0835a;
    }

    public void m4154a(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition((Transition) obj);
        }
    }

    public void m4156b(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.g.setExitTransition((Transition) obj);
        }
    }

    public void m4153a(ac acVar) {
        this.f2163b = acVar;
    }

    public void mo652b(boolean z) {
        if (f2162a != null) {
            try {
                f2162a.invoke(this.g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public void mo517b(C0724g c0724g, MenuItem menuItem) {
        if (this.f2163b != null) {
            this.f2163b.mo517b(c0724g, menuItem);
        }
    }

    public void mo516a(C0724g c0724g, MenuItem menuItem) {
        if (this.f2163b != null) {
            this.f2163b.mo516a(c0724g, menuItem);
        }
    }
}
