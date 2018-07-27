package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.C0558b.C0461a;
import android.support.v4.view.C0560c.C0466a;
import android.support.v4.view.p025a.C0489c;
import android.support.v4.view.p025a.C0502h;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat */
public class C0454a {
    private static final C0463b f1029b;
    private static final Object f1030c = f1029b.mo295a();
    final Object f1031a = f1029b.mo296a(this);

    /* compiled from: AccessibilityDelegateCompat */
    interface C0463b {
        C0502h mo294a(Object obj, View view);

        Object mo295a();

        Object mo296a(C0454a c0454a);

        void mo297a(Object obj, View view, int i);

        void mo298a(Object obj, View view, C0489c c0489c);

        boolean mo299a(Object obj, View view, int i, Bundle bundle);

        boolean mo300a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean mo301a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo302b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo303c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo304d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    /* compiled from: AccessibilityDelegateCompat */
    static class C0464d implements C0463b {
        C0464d() {
        }

        public Object mo295a() {
            return null;
        }

        public Object mo296a(C0454a c0454a) {
            return null;
        }

        public boolean mo300a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public void mo302b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void mo298a(Object obj, View view, C0489c c0489c) {
        }

        public void mo303c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean mo301a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void mo297a(Object obj, View view, int i) {
        }

        public void mo304d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public C0502h mo294a(Object obj, View view) {
            return null;
        }

        public boolean mo299a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }
    }

    /* compiled from: AccessibilityDelegateCompat */
    static class C0465a extends C0464d {
        C0465a() {
        }

        public Object mo295a() {
            return C0558b.m2418a();
        }

        public Object mo296a(final C0454a c0454a) {
            return C0558b.m2419a(new C0461a(this) {
                final /* synthetic */ C0465a f1084b;

                public boolean mo289a(View view, AccessibilityEvent accessibilityEvent) {
                    return c0454a.m1731b(view, accessibilityEvent);
                }

                public void mo291b(View view, AccessibilityEvent accessibilityEvent) {
                    c0454a.mo286d(view, accessibilityEvent);
                }

                public void mo288a(View view, Object obj) {
                    c0454a.mo284a(view, new C0489c(obj));
                }

                public void mo292c(View view, AccessibilityEvent accessibilityEvent) {
                    c0454a.m1732c(view, accessibilityEvent);
                }

                public boolean mo290a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0454a.m1730a(viewGroup, view, accessibilityEvent);
                }

                public void mo287a(View view, int i) {
                    c0454a.m1726a(view, i);
                }

                public void mo293d(View view, AccessibilityEvent accessibilityEvent) {
                    c0454a.m1728a(view, accessibilityEvent);
                }
            });
        }

        public boolean mo300a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return C0558b.m2422a(obj, view, accessibilityEvent);
        }

        public void mo302b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0558b.m2424b(obj, view, accessibilityEvent);
        }

        public void mo298a(Object obj, View view, C0489c c0489c) {
            C0558b.m2421a(obj, view, c0489c.m1942a());
        }

        public void mo303c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0558b.m2425c(obj, view, accessibilityEvent);
        }

        public boolean mo301a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return C0558b.m2423a(obj, viewGroup, view, accessibilityEvent);
        }

        public void mo297a(Object obj, View view, int i) {
            C0558b.m2420a(obj, view, i);
        }

        public void mo304d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0558b.m2426d(obj, view, accessibilityEvent);
        }
    }

    /* compiled from: AccessibilityDelegateCompat */
    static class C0468c extends C0465a {
        C0468c() {
        }

        public Object mo296a(final C0454a c0454a) {
            return C0560c.m2427a(new C0466a(this) {
                final /* synthetic */ C0468c f1086b;

                public boolean mo309a(View view, AccessibilityEvent accessibilityEvent) {
                    return c0454a.m1731b(view, accessibilityEvent);
                }

                public void mo311b(View view, AccessibilityEvent accessibilityEvent) {
                    c0454a.mo286d(view, accessibilityEvent);
                }

                public void mo307a(View view, Object obj) {
                    c0454a.mo284a(view, new C0489c(obj));
                }

                public void mo312c(View view, AccessibilityEvent accessibilityEvent) {
                    c0454a.m1732c(view, accessibilityEvent);
                }

                public boolean mo310a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0454a.m1730a(viewGroup, view, accessibilityEvent);
                }

                public void mo306a(View view, int i) {
                    c0454a.m1726a(view, i);
                }

                public void mo313d(View view, AccessibilityEvent accessibilityEvent) {
                    c0454a.m1728a(view, accessibilityEvent);
                }

                public Object mo305a(View view) {
                    C0502h a = c0454a.m1724a(view);
                    return a != null ? a.m2012a() : null;
                }

                public boolean mo308a(View view, int i, Bundle bundle) {
                    return c0454a.mo285a(view, i, bundle);
                }
            });
        }

        public C0502h mo294a(Object obj, View view) {
            Object a = C0560c.m2428a(obj, view);
            if (a != null) {
                return new C0502h(a);
            }
            return null;
        }

        public boolean mo299a(Object obj, View view, int i, Bundle bundle) {
            return C0560c.m2429a(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1029b = new C0468c();
        } else if (VERSION.SDK_INT >= 14) {
            f1029b = new C0465a();
        } else {
            f1029b = new C0464d();
        }
    }

    Object m1725a() {
        return this.f1031a;
    }

    public void m1726a(View view, int i) {
        f1029b.mo297a(f1030c, view, i);
    }

    public void m1728a(View view, AccessibilityEvent accessibilityEvent) {
        f1029b.mo304d(f1030c, view, accessibilityEvent);
    }

    public boolean m1731b(View view, AccessibilityEvent accessibilityEvent) {
        return f1029b.mo300a(f1030c, view, accessibilityEvent);
    }

    public void m1732c(View view, AccessibilityEvent accessibilityEvent) {
        f1029b.mo303c(f1030c, view, accessibilityEvent);
    }

    public void mo286d(View view, AccessibilityEvent accessibilityEvent) {
        f1029b.mo302b(f1030c, view, accessibilityEvent);
    }

    public void mo284a(View view, C0489c c0489c) {
        f1029b.mo298a(f1030c, view, c0489c);
    }

    public boolean m1730a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f1029b.mo301a(f1030c, viewGroup, view, accessibilityEvent);
    }

    public C0502h m1724a(View view) {
        return f1029b.mo294a(f1030c, view);
    }

    public boolean mo285a(View view, int i, Bundle bundle) {
        return f1029b.mo299a(f1030c, view, i, bundle);
    }
}
