package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.C0243s.C0207b;
import android.support.v4.app.C0243s.C0242a;
import android.support.v4.p024g.C0357a;
import android.support.v4.p024g.C0360d;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: BackStackRecord */
final class C0214e extends C0213r implements Runnable {
    static final boolean f546a = (VERSION.SDK_INT >= 21);
    final C0234o f547b;
    C0211a f548c;
    C0211a f549d;
    int f550e;
    int f551f;
    int f552g;
    int f553h;
    int f554i;
    int f555j;
    int f556k;
    boolean f557l;
    boolean f558m = true;
    String f559n;
    boolean f560o;
    int f561p = -1;
    int f562q;
    CharSequence f563r;
    int f564s;
    CharSequence f565t;
    ArrayList<String> f566u;
    ArrayList<String> f567v;

    /* compiled from: BackStackRecord */
    static final class C0211a {
        C0211a f532a;
        C0211a f533b;
        int f534c;
        Fragment f535d;
        int f536e;
        int f537f;
        int f538g;
        int f539h;
        ArrayList<Fragment> f540i;

        C0211a() {
        }
    }

    /* compiled from: BackStackRecord */
    public class C0212b {
        public C0357a<String, String> f541a = new C0357a();
        public ArrayList<View> f542b = new ArrayList();
        public C0242a f543c = new C0242a();
        public View f544d;
        final /* synthetic */ C0214e f545e;

        public C0212b(C0214e c0214e) {
            this.f545e = c0214e;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f561p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f561p);
        }
        if (this.f559n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f559n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m714a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m715a(str, printWriter, true);
    }

    public void m715a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f559n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f561p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f560o);
            if (this.f555j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f555j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f556k));
            }
            if (!(this.f551f == 0 && this.f552g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f551f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f552g));
            }
            if (!(this.f553h == 0 && this.f554i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f553h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f554i));
            }
            if (!(this.f562q == 0 && this.f563r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f562q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f563r);
            }
            if (!(this.f564s == 0 && this.f565t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f564s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f565t);
            }
        }
        if (this.f548c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0211a c0211a = this.f548c;
            while (c0211a != null) {
                String str3;
                switch (c0211a.f534c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0211a.f534c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0211a.f535d);
                if (z) {
                    if (!(c0211a.f536e == 0 && c0211a.f537f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0211a.f536e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0211a.f537f));
                    }
                    if (!(c0211a.f538g == 0 && c0211a.f539h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0211a.f538g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0211a.f539h));
                    }
                }
                if (c0211a.f540i != null && c0211a.f540i.size() > 0) {
                    for (int i2 = 0; i2 < c0211a.f540i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0211a.f540i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0211a.f540i.get(i2));
                    }
                }
                c0211a = c0211a.f532a;
                i++;
            }
        }
    }

    public C0214e(C0234o c0234o) {
        this.f547b = c0234o;
    }

    void m709a(C0211a c0211a) {
        if (this.f548c == null) {
            this.f549d = c0211a;
            this.f548c = c0211a;
        } else {
            c0211a.f533b = this.f549d;
            this.f549d.f532a = c0211a;
            this.f549d = c0211a;
        }
        c0211a.f536e = this.f551f;
        c0211a.f537f = this.f552g;
        c0211a.f538g = this.f553h;
        c0211a.f539h = this.f554i;
        this.f550e++;
    }

    public C0213r mo104a(Fragment fragment, String str) {
        m688a(0, fragment, str, 1);
        return this;
    }

    public C0213r mo102a(int i, Fragment fragment) {
        m688a(i, fragment, null, 1);
        return this;
    }

    private void m688a(int i, Fragment fragment, String str, int i2) {
        Class cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state.");
        }
        fragment.mFragmentManager = this.f547b;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        C0211a c0211a = new C0211a();
        c0211a.f534c = i2;
        c0211a.f535d = fragment;
        m709a(c0211a);
    }

    public C0213r mo103a(Fragment fragment) {
        C0211a c0211a = new C0211a();
        c0211a.f534c = 3;
        c0211a.f535d = fragment;
        m709a(c0211a);
        return this;
    }

    public C0213r m703a() {
        if (this.f557l) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f558m = false;
        return this;
    }

    void m708a(int i) {
        if (this.f557l) {
            if (C0234o.f612a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0211a c0211a = this.f548c; c0211a != null; c0211a = c0211a.f532a) {
                Fragment fragment;
                if (c0211a.f535d != null) {
                    fragment = c0211a.f535d;
                    fragment.mBackStackNesting += i;
                    if (C0234o.f612a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0211a.f535d + " to " + c0211a.f535d.mBackStackNesting);
                    }
                }
                if (c0211a.f540i != null) {
                    for (int size = c0211a.f540i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) c0211a.f540i.get(size);
                        fragment.mBackStackNesting += i;
                        if (C0234o.f612a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    public int mo105b() {
        return m701a(false);
    }

    public int mo106c() {
        return m701a(true);
    }

    public void mo107d() {
        m703a();
        this.f547b.m867b((Runnable) this, true);
    }

    int m701a(boolean z) {
        if (this.f560o) {
            throw new IllegalStateException("commit already called");
        }
        if (C0234o.f612a) {
            Log.v("FragmentManager", "Commit: " + this);
            m714a("  ", null, new PrintWriter(new C0360d("FragmentManager")), null);
        }
        this.f560o = true;
        if (this.f557l) {
            this.f561p = this.f547b.m835a(this);
        } else {
            this.f561p = -1;
        }
        this.f547b.m853a((Runnable) this, z);
        return this.f561p;
    }

    public void run() {
        if (C0234o.f612a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f557l || this.f561p >= 0) {
            C0212b c0212b;
            m708a(1);
            if (!f546a || this.f547b.f626n < 1) {
                c0212b = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m699b(sparseArray, sparseArray2);
                c0212b = m682a(sparseArray, sparseArray2, false);
            }
            int i = c0212b != null ? 0 : this.f556k;
            int i2 = c0212b != null ? 0 : this.f555j;
            C0211a c0211a = this.f548c;
            while (c0211a != null) {
                int i3 = c0212b != null ? 0 : c0211a.f536e;
                int i4 = c0212b != null ? 0 : c0211a.f537f;
                Fragment fragment;
                switch (c0211a.f534c) {
                    case 1:
                        fragment = c0211a.f535d;
                        fragment.mNextAnim = i3;
                        this.f547b.m851a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = c0211a.f535d;
                        int i5 = fragment2.mContainerId;
                        if (this.f547b.f619g != null) {
                            int size = this.f547b.f619g.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.f547b.f619g.get(size);
                                if (C0234o.f612a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment.mContainerId == i5) {
                                    if (fragment == fragment2) {
                                        fragment = null;
                                        c0211a.f535d = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (c0211a.f540i == null) {
                                            c0211a.f540i = new ArrayList();
                                        }
                                        c0211a.f540i.add(fragment);
                                        fragment.mNextAnim = i4;
                                        if (this.f557l) {
                                            fragment.mBackStackNesting++;
                                            if (C0234o.f612a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                                            }
                                        }
                                        this.f547b.m849a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.mNextAnim = i3;
                        this.f547b.m851a(fragment2, false);
                        break;
                    case 3:
                        fragment = c0211a.f535d;
                        fragment.mNextAnim = i4;
                        this.f547b.m849a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = c0211a.f535d;
                        fragment.mNextAnim = i4;
                        this.f547b.m864b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = c0211a.f535d;
                        fragment.mNextAnim = i3;
                        this.f547b.m873c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = c0211a.f535d;
                        fragment.mNextAnim = i4;
                        this.f547b.m877d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = c0211a.f535d;
                        fragment.mNextAnim = i3;
                        this.f547b.m879e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0211a.f534c);
                }
                c0211a = c0211a.f532a;
            }
            this.f547b.m843a(this.f547b.f626n, i2, i, true);
            if (this.f557l) {
                this.f547b.m865b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void m693a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0 && !fragment.isHidden()) {
                if (fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void m700b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0) {
                if (!fragment.isAdded()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.mState < 1 && this.f547b.f626n >= 1) {
                this.f547b.m876d(fragment);
                this.f547b.m850a(fragment, 1, 0, 0, false);
            }
        }
    }

    private void m699b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f547b.f628p.mo92a()) {
            for (C0211a c0211a = this.f548c; c0211a != null; c0211a = c0211a.f532a) {
                switch (c0211a.f534c) {
                    case 1:
                        m700b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 2:
                        Fragment fragment = c0211a.f535d;
                        if (this.f547b.f619g != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.f547b.f619g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.f547b.f619g.get(i);
                                if (fragment2 == null || fragment3.mContainerId == fragment2.mContainerId) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.mContainerId);
                                    } else {
                                        C0214e.m693a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        m700b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 3:
                        C0214e.m693a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 4:
                        C0214e.m693a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 5:
                        m700b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 6:
                        C0214e.m693a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 7:
                        m700b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m713a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f547b.f628p.mo92a()) {
            for (C0211a c0211a = this.f549d; c0211a != null; c0211a = c0211a.f533b) {
                switch (c0211a.f534c) {
                    case 1:
                        C0214e.m693a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 2:
                        if (c0211a.f540i != null) {
                            for (int size = c0211a.f540i.size() - 1; size >= 0; size--) {
                                m700b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) c0211a.f540i.get(size));
                            }
                        }
                        C0214e.m693a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 3:
                        m700b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 4:
                        m700b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 5:
                        C0214e.m693a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 6:
                        m700b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    case 7:
                        C0214e.m693a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0211a.f535d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public C0212b m702a(boolean z, C0212b c0212b, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (C0234o.f612a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m714a("  ", null, new PrintWriter(new C0360d("FragmentManager")), null);
        }
        if (f546a && this.f547b.f626n >= 1) {
            if (c0212b == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    c0212b = m682a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                C0214e.m691a(c0212b, this.f567v, this.f566u);
            }
        }
        m708a(-1);
        int i = c0212b != null ? 0 : this.f556k;
        int i2 = c0212b != null ? 0 : this.f555j;
        C0211a c0211a = this.f549d;
        while (c0211a != null) {
            int i3 = c0212b != null ? 0 : c0211a.f538g;
            int i4 = c0212b != null ? 0 : c0211a.f539h;
            Fragment fragment;
            Fragment fragment2;
            switch (c0211a.f534c) {
                case 1:
                    fragment = c0211a.f535d;
                    fragment.mNextAnim = i4;
                    this.f547b.m849a(fragment, C0234o.m833d(i2), i);
                    break;
                case 2:
                    fragment = c0211a.f535d;
                    if (fragment != null) {
                        fragment.mNextAnim = i4;
                        this.f547b.m849a(fragment, C0234o.m833d(i2), i);
                    }
                    if (c0211a.f540i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < c0211a.f540i.size(); i5++) {
                        fragment2 = (Fragment) c0211a.f540i.get(i5);
                        fragment2.mNextAnim = i3;
                        this.f547b.m851a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = c0211a.f535d;
                    fragment2.mNextAnim = i3;
                    this.f547b.m851a(fragment2, false);
                    break;
                case 4:
                    fragment2 = c0211a.f535d;
                    fragment2.mNextAnim = i3;
                    this.f547b.m873c(fragment2, C0234o.m833d(i2), i);
                    break;
                case 5:
                    fragment = c0211a.f535d;
                    fragment.mNextAnim = i4;
                    this.f547b.m864b(fragment, C0234o.m833d(i2), i);
                    break;
                case 6:
                    fragment2 = c0211a.f535d;
                    fragment2.mNextAnim = i3;
                    this.f547b.m879e(fragment2, C0234o.m833d(i2), i);
                    break;
                case 7:
                    fragment2 = c0211a.f535d;
                    fragment2.mNextAnim = i3;
                    this.f547b.m877d(fragment2, C0234o.m833d(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0211a.f534c);
            }
            c0211a = c0211a.f533b;
        }
        if (z) {
            this.f547b.m843a(this.f547b.f626n, C0234o.m833d(i2), i, true);
            c0212b = null;
        }
        if (this.f561p >= 0) {
            this.f547b.m871c(this.f561p);
            this.f561p = -1;
        }
        return c0212b;
    }

    public String m719e() {
        return this.f559n;
    }

    private C0212b m682a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        C0212b c0212b = new C0212b(this);
        c0212b.f544d = new View(this.f547b.f627o.m742i());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (m695a(sparseArray.keyAt(i2), c0212b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m695a(i4, c0212b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return c0212b;
    }

    private static Object m686a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return C0243s.m927a(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object m697b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return C0243s.m927a(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static Object m685a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object sharedElementReturnTransition;
        if (z) {
            sharedElementReturnTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementReturnTransition = fragment.getSharedElementEnterTransition();
        }
        return C0243s.m948b(sharedElementReturnTransition);
    }

    private static Object m687a(Object obj, Fragment fragment, ArrayList<View> arrayList, C0357a<String, View> c0357a, View view) {
        if (obj != null) {
            return C0243s.m928a(obj, fragment.getView(), (ArrayList) arrayList, (Map) c0357a, view);
        }
        return obj;
    }

    private C0357a<String, View> m683a(C0212b c0212b, Fragment fragment, boolean z) {
        C0357a c0357a = new C0357a();
        if (this.f566u != null) {
            C0243s.m943a((Map) c0357a, fragment.getView());
            if (z) {
                c0357a.m1294a(this.f567v);
            } else {
                c0357a = C0214e.m684a(this.f566u, this.f567v, c0357a);
            }
        }
        if (z) {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.m666a(this.f567v, c0357a);
            }
            m689a(c0212b, c0357a, false);
        } else {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.m666a(this.f567v, c0357a);
            }
            m698b(c0212b, c0357a, false);
        }
        return c0357a;
    }

    private boolean m695a(int i, C0212b c0212b, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.f547b.f628p.mo91a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        C0207b c02081;
        ArrayList arrayList2;
        Map c0357a;
        boolean z2;
        Object a2;
        final Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a3 = C0214e.m686a(fragment, z);
        Object a4 = C0214e.m685a(fragment, fragment2, z);
        Object b = C0214e.m697b(fragment2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m683a(c0212b, fragment2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = C0214e.m687a(b, fragment2, arrayList, (C0357a) map, c0212b.f544d);
                if (!(this.f567v == null || map == null)) {
                    view2 = (View) map.get(this.f567v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            C0243s.m935a(a, view2);
                        }
                        if (obj != null) {
                            C0243s.m935a(obj, view2);
                        }
                    }
                }
                c02081 = new C0207b(this) {
                    final /* synthetic */ C0214e f516b;

                    public View mo101a() {
                        return fragment.getView();
                    }
                };
                arrayList2 = new ArrayList();
                c0357a = new C0357a();
                z2 = true;
                if (fragment != null) {
                    if (z) {
                        z2 = fragment.getAllowEnterTransitionOverlap();
                    } else {
                        z2 = fragment.getAllowReturnTransitionOverlap();
                    }
                }
                a2 = C0243s.m929a(a3, a, obj, z2);
                if (a2 != null) {
                    C0243s.m938a(a3, obj, a, view, c02081, c0212b.f544d, c0212b.f543c, c0212b.f541a, arrayList2, arrayList, map, c0357a, arrayList3);
                    m694a(view, c0212b, i, a2);
                    C0243s.m937a(a2, c0212b.f544d, true);
                    m710a(c0212b, i, a2);
                    C0243s.m934a((ViewGroup) view, a2);
                    C0243s.m933a(view, c0212b.f544d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0212b.f542b, c0357a);
                }
                if (a2 == null) {
                    return true;
                }
                return false;
            }
            al alVar = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
            if (alVar != null) {
                alVar.m665a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
            }
            m690a(c0212b, view, a4, fragment, fragment2, z, arrayList3, a3, b);
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = C0214e.m687a(b, fragment2, arrayList, (C0357a) map, c0212b.f544d);
        view2 = (View) map.get(this.f567v.get(0));
        if (view2 != null) {
            if (a != null) {
                C0243s.m935a(a, view2);
            }
            if (obj != null) {
                C0243s.m935a(obj, view2);
            }
        }
        c02081 = /* anonymous class already generated */;
        arrayList2 = new ArrayList();
        c0357a = new C0357a();
        z2 = true;
        if (fragment != null) {
            if (z) {
                z2 = fragment.getAllowEnterTransitionOverlap();
            } else {
                z2 = fragment.getAllowReturnTransitionOverlap();
            }
        }
        a2 = C0243s.m929a(a3, a, obj, z2);
        if (a2 != null) {
            C0243s.m938a(a3, obj, a, view, c02081, c0212b.f544d, c0212b.f543c, c0212b.f541a, arrayList2, arrayList, map, c0357a, arrayList3);
            m694a(view, c0212b, i, a2);
            C0243s.m937a(a2, c0212b.f544d, true);
            m710a(c0212b, i, a2);
            C0243s.m934a((ViewGroup) view, a2);
            C0243s.m933a(view, c0212b.f544d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0212b.f542b, c0357a);
        }
        if (a2 == null) {
            return false;
        }
        return true;
    }

    private void m690a(C0212b c0212b, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList, Object obj2, Object obj3) {
        if (obj != null) {
            final View view2 = view;
            final Object obj4 = obj;
            final ArrayList<View> arrayList2 = arrayList;
            final C0212b c0212b2 = c0212b;
            final Object obj5 = obj2;
            final Object obj6 = obj3;
            final boolean z2 = z;
            final Fragment fragment3 = fragment;
            final Fragment fragment4 = fragment2;
            view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ C0214e f526j;

                public boolean onPreDraw() {
                    view2.getViewTreeObserver().removeOnPreDrawListener(this);
                    C0243s.m940a(obj4, arrayList2);
                    arrayList2.remove(c0212b2.f544d);
                    C0243s.m939a(obj5, obj6, obj4, arrayList2, false);
                    arrayList2.clear();
                    C0357a a = this.f526j.m707a(c0212b2, z2, fragment3);
                    C0243s.m936a(obj4, c0212b2.f544d, (Map) a, arrayList2);
                    this.f526j.m712a(a, c0212b2);
                    this.f526j.m711a(c0212b2, fragment3, fragment4, z2, a);
                    C0243s.m939a(obj5, obj6, obj4, arrayList2, true);
                    return true;
                }
            });
        }
    }

    void m711a(C0212b c0212b, Fragment fragment, Fragment fragment2, boolean z, C0357a<String, View> c0357a) {
        al alVar = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
        if (alVar != null) {
            alVar.m667b(new ArrayList(c0357a.keySet()), new ArrayList(c0357a.values()), null);
        }
    }

    void m712a(C0357a<String, View> c0357a, C0212b c0212b) {
        if (this.f567v != null && !c0357a.isEmpty()) {
            View view = (View) c0357a.get(this.f567v.get(0));
            if (view != null) {
                c0212b.f543c.f669a = view;
            }
        }
    }

    C0357a<String, View> m707a(C0212b c0212b, boolean z, Fragment fragment) {
        C0357a b = m696b(c0212b, fragment, z);
        if (z) {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.m666a(this.f567v, b);
            }
            m689a(c0212b, b, true);
        } else {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.m666a(this.f567v, b);
            }
            m698b(c0212b, b, true);
        }
        return b;
    }

    private static C0357a<String, View> m684a(ArrayList<String> arrayList, ArrayList<String> arrayList2, C0357a<String, View> c0357a) {
        if (c0357a.isEmpty()) {
            return c0357a;
        }
        C0357a<String, View> c0357a2 = new C0357a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) c0357a.get(arrayList.get(i));
            if (view != null) {
                c0357a2.put(arrayList2.get(i), view);
            }
        }
        return c0357a2;
    }

    private C0357a<String, View> m696b(C0212b c0212b, Fragment fragment, boolean z) {
        C0357a c0357a = new C0357a();
        View view = fragment.getView();
        if (view == null || this.f566u == null) {
            return c0357a;
        }
        C0243s.m943a((Map) c0357a, view);
        if (z) {
            return C0214e.m684a(this.f566u, this.f567v, c0357a);
        }
        c0357a.m1294a(this.f567v);
        return c0357a;
    }

    private void m694a(View view, C0212b c0212b, int i, Object obj) {
        final View view2 = view;
        final C0212b c0212b2 = c0212b;
        final int i2 = i;
        final Object obj2 = obj;
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ C0214e f531e;

            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f531e.m710a(c0212b2, i2, obj2);
                return true;
            }
        });
    }

    void m710a(C0212b c0212b, int i, Object obj) {
        if (this.f547b.f619g != null) {
            for (int i2 = 0; i2 < this.f547b.f619g.size(); i2++) {
                Fragment fragment = (Fragment) this.f547b.f619g.get(i2);
                if (!(fragment.mView == null || fragment.mContainer == null || fragment.mContainerId != i)) {
                    if (!fragment.mHidden) {
                        C0243s.m937a(obj, fragment.mView, false);
                        c0212b.f542b.remove(fragment.mView);
                    } else if (!c0212b.f542b.contains(fragment.mView)) {
                        C0243s.m937a(obj, fragment.mView, true);
                        c0212b.f542b.add(fragment.mView);
                    }
                }
            }
        }
    }

    private static void m692a(C0357a<String, String> c0357a, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < c0357a.size(); i++) {
                if (str.equals(c0357a.m1291c(i))) {
                    c0357a.m1286a(i, (Object) str2);
                    return;
                }
            }
            c0357a.put(str, str2);
        }
    }

    private static void m691a(C0212b c0212b, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0214e.m692a(c0212b.f541a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m689a(C0212b c0212b, C0357a<String, View> c0357a, boolean z) {
        int size = this.f567v == null ? 0 : this.f567v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f566u.get(i);
            View view = (View) c0357a.get((String) this.f567v.get(i));
            if (view != null) {
                String a = C0243s.m930a(view);
                if (z) {
                    C0214e.m692a(c0212b.f541a, str, a);
                } else {
                    C0214e.m692a(c0212b.f541a, a, str);
                }
            }
        }
    }

    private void m698b(C0212b c0212b, C0357a<String, View> c0357a, boolean z) {
        int size = c0357a.size();
        for (int i = 0; i < size; i++) {
            String str = (String) c0357a.m1290b(i);
            String a = C0243s.m930a((View) c0357a.m1291c(i));
            if (z) {
                C0214e.m692a(c0212b.f541a, str, a);
            } else {
                C0214e.m692a(c0212b.f541a, a, str);
            }
        }
    }
}
