package android.support.v4.view.p025a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p025a.C0504i.C0495a;
import android.support.v4.view.p025a.C0506j.C0499a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
public class C0502h {
    private static final C0494a f1096a;
    private final Object f1097b;

    /* compiled from: AccessibilityNodeProviderCompat */
    interface C0494a {
        Object mo344a(C0502h c0502h);
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    static class C0497d implements C0494a {
        C0497d() {
        }

        public Object mo344a(C0502h c0502h) {
            return null;
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    private static class C0498b extends C0497d {
        C0498b() {
        }

        public Object mo344a(final C0502h c0502h) {
            return C0504i.m2016a(new C0495a(this) {
                final /* synthetic */ C0498b f1093b;

                public boolean mo343a(int i, int i2, Bundle bundle) {
                    return c0502h.m2014a(i, i2, bundle);
                }

                public List<Object> mo342a(String str, int i) {
                    List a = c0502h.m2013a(str, i);
                    if (a == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((C0489c) a.get(i2)).m1942a());
                    }
                    return arrayList;
                }

                public Object mo341a(int i) {
                    C0489c a = c0502h.m2011a(i);
                    if (a == null) {
                        return null;
                    }
                    return a.m1942a();
                }
            });
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    private static class C0501c extends C0497d {
        C0501c() {
        }

        public Object mo344a(final C0502h c0502h) {
            return C0506j.m2017a(new C0499a(this) {
                final /* synthetic */ C0501c f1095b;

                public boolean mo347a(int i, int i2, Bundle bundle) {
                    return c0502h.m2014a(i, i2, bundle);
                }

                public List<Object> mo346a(String str, int i) {
                    List a = c0502h.m2013a(str, i);
                    if (a == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((C0489c) a.get(i2)).m1942a());
                    }
                    return arrayList;
                }

                public Object mo345a(int i) {
                    C0489c a = c0502h.m2011a(i);
                    if (a == null) {
                        return null;
                    }
                    return a.m1942a();
                }

                public Object mo348b(int i) {
                    C0489c b = c0502h.m2015b(i);
                    if (b == null) {
                        return null;
                    }
                    return b.m1942a();
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f1096a = new C0501c();
        } else if (VERSION.SDK_INT >= 16) {
            f1096a = new C0498b();
        } else {
            f1096a = new C0497d();
        }
    }

    public C0502h() {
        this.f1097b = f1096a.mo344a(this);
    }

    public C0502h(Object obj) {
        this.f1097b = obj;
    }

    public Object m2012a() {
        return this.f1097b;
    }

    public C0489c m2011a(int i) {
        return null;
    }

    public boolean m2014a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<C0489c> m2013a(String str, int i) {
        return null;
    }

    public C0489c m2015b(int i) {
        return null;
    }
}
