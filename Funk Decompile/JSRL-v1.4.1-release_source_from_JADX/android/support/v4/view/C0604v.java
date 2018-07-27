package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper */
public class C0604v {
    private final View f1148a;
    private ViewParent f1149b;
    private boolean f1150c;
    private int[] f1151d;

    public C0604v(View view) {
        this.f1148a = view;
    }

    public void m2517a(boolean z) {
        if (this.f1150c) {
            ae.m2242v(this.f1148a);
        }
        this.f1150c = z;
    }

    public boolean m2518a() {
        return this.f1150c;
    }

    public boolean m2524b() {
        return this.f1149b != null;
    }

    public boolean m2521a(int i) {
        if (m2524b()) {
            return true;
        }
        if (m2518a()) {
            View view = this.f1148a;
            for (ViewParent parent = this.f1148a.getParent(); parent != null; parent = parent.getParent()) {
                if (ao.m2328a(parent, view, this.f1148a, i)) {
                    this.f1149b = parent;
                    ao.m2329b(parent, view, this.f1148a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void m2525c() {
        if (this.f1149b != null) {
            ao.m2323a(this.f1149b, this.f1148a);
            this.f1149b = null;
        }
    }

    public boolean m2522a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m2518a() || this.f1149b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f1148a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            ao.m2324a(this.f1149b, this.f1148a, i, i2, i3, i4);
            if (iArr != null) {
                this.f1148a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m2523a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m2518a() || this.f1149b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f1148a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f1151d == null) {
                    this.f1151d = new int[2];
                }
                iArr = this.f1151d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ao.m2325a(this.f1149b, this.f1148a, i, i2, iArr);
            if (iArr2 != null) {
                this.f1148a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m2520a(float f, float f2, boolean z) {
        if (!m2518a() || this.f1149b == null) {
            return false;
        }
        return ao.m2327a(this.f1149b, this.f1148a, f, f2, z);
    }

    public boolean m2519a(float f, float f2) {
        if (!m2518a() || this.f1149b == null) {
            return false;
        }
        return ao.m2326a(this.f1149b, this.f1148a, f, f2);
    }
}
