package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.C0214e.C0212b;
import android.support.v4.app.C0226n.C0225a;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.p022e.C0323c;
import android.support.v4.p024g.C0359c;
import android.support.v4.p024g.C0360d;
import android.support.v4.view.C0233m;
import android.support.v4.view.ae;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: FragmentManager */
final class C0234o extends C0226n implements C0233m {
    static final Interpolator f608A = new DecelerateInterpolator(2.5f);
    static final Interpolator f609B = new DecelerateInterpolator(1.5f);
    static final Interpolator f610C = new AccelerateInterpolator(2.5f);
    static final Interpolator f611D = new AccelerateInterpolator(1.5f);
    static boolean f612a = false;
    static final boolean f613b;
    static Field f614r = null;
    ArrayList<Runnable> f615c;
    Runnable[] f616d;
    boolean f617e;
    ArrayList<Fragment> f618f;
    ArrayList<Fragment> f619g;
    ArrayList<Integer> f620h;
    ArrayList<C0214e> f621i;
    ArrayList<Fragment> f622j;
    ArrayList<C0214e> f623k;
    ArrayList<Integer> f624l;
    ArrayList<C0225a> f625m;
    int f626n = 0;
    C0220m f627o;
    C0177k f628p;
    Fragment f629q;
    boolean f630s;
    boolean f631t;
    boolean f632u;
    String f633v;
    boolean f634w;
    Bundle f635x = null;
    SparseArray<Parcelable> f636y = null;
    Runnable f637z = new C02271(this);

    /* compiled from: FragmentManager */
    class C02271 implements Runnable {
        final /* synthetic */ C0234o f597a;

        C02271(C0234o c0234o) {
            this.f597a = c0234o;
        }

        public void run() {
            this.f597a.m880e();
        }
    }

    /* compiled from: FragmentManager */
    static class C0229a implements AnimationListener {
        private AnimationListener f601a;
        private boolean f602b;
        View f603c;

        /* compiled from: FragmentManager */
        class C02311 implements Runnable {
            final /* synthetic */ C0229a f606a;

            C02311(C0229a c0229a) {
                this.f606a = c0229a;
            }

            public void run() {
                ae.m2206a(this.f606a.f603c, 0, null);
            }
        }

        public C0229a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.f603c = view;
            }
        }

        public C0229a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.f601a = animationListener;
                this.f603c = view;
                this.f602b = true;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.f601a != null) {
                this.f601a.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f603c != null && this.f602b) {
                if (ae.m2244x(this.f603c) || C0323c.m1195a()) {
                    this.f603c.post(new C02311(this));
                } else {
                    ae.m2206a(this.f603c, 0, null);
                }
            }
            if (this.f601a != null) {
                this.f601a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f601a != null) {
                this.f601a.onAnimationRepeat(animation);
            }
        }
    }

    /* compiled from: FragmentManager */
    static class C0232b {
        public static final int[] f607a = new int[]{16842755, 16842960, 16842961};
    }

    C0234o() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f613b = z;
    }

    static boolean m830a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean m829a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && ae.m2227g(view) == 0 && ae.m2239s(view) && C0234o.m830a(animation);
    }

    private void m828a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0360d("FragmentManager"));
        if (this.f627o != null) {
            try {
                this.f627o.mo120a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo146a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public C0213r mo142a() {
        return new C0214e(this);
    }

    public boolean mo147b() {
        return m880e();
    }

    public boolean mo148c() {
        m834v();
        mo147b();
        return m857a(this.f627o.m743j(), null, -1, 0);
    }

    public void mo144a(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m853a(new Runnable(this) {
            final /* synthetic */ C0234o f600c;

            public void run() {
                this.f600c.m857a(this.f600c.f627o.m743j(), null, i, i2);
            }
        }, false);
    }

    public void mo145a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            m828a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public Fragment mo140a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f618f.size()) {
            m828a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f618f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m828a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public SavedState mo139a(Fragment fragment) {
        if (fragment.mIndex < 0) {
            m828a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0) {
            return null;
        }
        Bundle g = m883g(fragment);
        if (g != null) {
            return new SavedState(g);
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f629q != null) {
            C0359c.m1301a(this.f629q, stringBuilder);
        } else {
            C0359c.m1301a(this.f627o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void mo146a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f618f != null) {
            size = this.f618f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f618f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f619g != null) {
            size = this.f619g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f619g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f622j != null) {
            size = this.f622j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f622j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f621i != null) {
            size = this.f621i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0214e c0214e = (C0214e) this.f621i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0214e.toString());
                    c0214e.m714a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f623k != null) {
                int size2 = this.f623k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0214e = (C0214e) this.f623k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0214e);
                    }
                }
            }
            if (this.f624l != null && this.f624l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f624l.toArray()));
            }
        }
        if (this.f615c != null) {
            i = this.f615c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f615c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f627o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f628p);
        if (this.f629q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f629q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f626n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f631t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f632u);
        if (this.f630s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f630s);
        }
        if (this.f633v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f633v);
        }
        if (this.f620h != null && this.f620h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f620h.toArray()));
        }
    }

    static Animation m827a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f608A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f609B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation m826a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f609B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation m841a(Fragment fragment, int i, boolean z, int i2) {
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.mNextAnim);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.mNextAnim != 0) {
            onCreateAnimation = AnimationUtils.loadAnimation(this.f627o.m742i(), fragment.mNextAnim);
            if (onCreateAnimation != null) {
                return onCreateAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0234o.m831b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return C0234o.m827a(this.f627o.m742i(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return C0234o.m827a(this.f627o.m742i(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return C0234o.m827a(this.f627o.m742i(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return C0234o.m827a(this.f627o.m742i(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return C0234o.m826a(this.f627o.m742i(), 0.0f, 1.0f);
            case 6:
                return C0234o.m826a(this.f627o.m742i(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f627o.mo126e()) {
                    i2 = this.f627o.mo127f();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void m863b(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.f617e) {
            this.f634w = true;
            return;
        }
        fragment.mDeferStart = false;
        m850a(fragment, this.f626n, 0, 0, false);
    }

    private void m832b(View view, Animation animation) {
        if (view != null && animation != null && C0234o.m829a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (f614r == null) {
                    f614r = Animation.class.getDeclaredField("mListener");
                    f614r.setAccessible(true);
                }
                animationListener = (AnimationListener) f614r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            ae.m2206a(view, 2, null);
            animation.setAnimationListener(new C0229a(view, animation, animationListener));
        }
    }

    boolean m856a(int i) {
        return this.f626n >= i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m850a(final android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r3 = 0;
        r5 = 1;
        r7 = 0;
        r0 = r11.mAdded;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.mDetached;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.mRemoving;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.mState;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.mState;
    L_0x001a:
        r0 = r11.mDeferStart;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.mState;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.mState;
        if (r0 >= r12) goto L_0x02eb;
    L_0x0029:
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.mInLayout;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.mAnimatingAway = r7;
        r2 = r11.mStateAfterAnimating;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m850a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.mState;
        switch(r0) {
            case 0: goto L_0x0080;
            case 1: goto L_0x0176;
            case 2: goto L_0x026d;
            case 3: goto L_0x0272;
            case 4: goto L_0x0293;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.mState;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.mState;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.mState = r12;
        goto L_0x0031;
    L_0x0080:
        r0 = f612a;
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x009c:
        r0 = r11.mSavedFragmentState;
        if (r0 == 0) goto L_0x00e4;
    L_0x00a0:
        r0 = r11.mSavedFragmentState;
        r1 = r10.f627o;
        r1 = r1.m742i();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.mSavedViewState = r0;
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r10.mo140a(r0, r1);
        r11.mTarget = r0;
        r0 = r11.mTarget;
        if (r0 == 0) goto L_0x00d1;
    L_0x00c7:
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.mTargetRequestCode = r0;
    L_0x00d1:
        r0 = r11.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.mUserVisibleHint = r0;
        r0 = r11.mUserVisibleHint;
        if (r0 != 0) goto L_0x00e4;
    L_0x00df:
        r11.mDeferStart = r5;
        if (r12 <= r6) goto L_0x00e4;
    L_0x00e3:
        r12 = r6;
    L_0x00e4:
        r0 = r10.f627o;
        r11.mHost = r0;
        r0 = r10.f629q;
        r11.mParentFragment = r0;
        r0 = r10.f629q;
        if (r0 == 0) goto L_0x0124;
    L_0x00f0:
        r0 = r10.f629q;
        r0 = r0.mChildFragmentManager;
    L_0x00f4:
        r11.mFragmentManager = r0;
        r11.mCalled = r3;
        r0 = r10.f627o;
        r0 = r0.m742i();
        r11.onAttach(r0);
        r0 = r11.mCalled;
        if (r0 != 0) goto L_0x012b;
    L_0x0105:
        r0 = new android.support.v4.app.am;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0124:
        r0 = r10.f627o;
        r0 = r0.m744k();
        goto L_0x00f4;
    L_0x012b:
        r0 = r11.mParentFragment;
        if (r0 != 0) goto L_0x02ba;
    L_0x012f:
        r0 = r10.f627o;
        r0.mo124b(r11);
    L_0x0134:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x02c1;
    L_0x0138:
        r0 = r11.mSavedFragmentState;
        r11.performCreate(r0);
    L_0x013d:
        r11.mRetaining = r3;
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x0176;
    L_0x0143:
        r0 = r11.mSavedFragmentState;
        r0 = r11.getLayoutInflater(r0);
        r1 = r11.mSavedFragmentState;
        r0 = r11.performCreateView(r0, r7, r1);
        r11.mView = r0;
        r0 = r11.mView;
        if (r0 == 0) goto L_0x02d4;
    L_0x0155:
        r0 = r11.mView;
        r11.mInnerView = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x02ca;
    L_0x015f:
        r0 = r11.mView;
        android.support.v4.view.ae.m2214a(r0, r3);
    L_0x0164:
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x016f;
    L_0x0168:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x016f:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
    L_0x0176:
        if (r12 <= r5) goto L_0x026d;
    L_0x0178:
        r0 = f612a;
        if (r0 == 0) goto L_0x0194;
    L_0x017c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0194:
        r0 = r11.mFromLayout;
        if (r0 != 0) goto L_0x025d;
    L_0x0198:
        r0 = r11.mContainerId;
        if (r0 == 0) goto L_0x0421;
    L_0x019c:
        r0 = r11.mContainerId;
        r1 = -1;
        if (r0 != r1) goto L_0x01c2;
    L_0x01a1:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.m828a(r0);
    L_0x01c2:
        r0 = r10.f628p;
        r1 = r11.mContainerId;
        r0 = r0.mo91a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0211;
    L_0x01ce:
        r1 = r11.mRestored;
        if (r1 != 0) goto L_0x0211;
    L_0x01d2:
        r1 = r11.getResources();	 Catch:{ NotFoundException -> 0x02d8 }
        r2 = r11.mContainerId;	 Catch:{ NotFoundException -> 0x02d8 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x02d8 }
    L_0x01dc:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = "No view found for id 0x";
        r4 = r4.append(r8);
        r8 = r11.mContainerId;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.m828a(r2);
    L_0x0211:
        r11.mContainer = r0;
        r1 = r11.mSavedFragmentState;
        r1 = r11.getLayoutInflater(r1);
        r2 = r11.mSavedFragmentState;
        r1 = r11.performCreateView(r1, r0, r2);
        r11.mView = r1;
        r1 = r11.mView;
        if (r1 == 0) goto L_0x02e7;
    L_0x0225:
        r1 = r11.mView;
        r11.mInnerView = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x02dd;
    L_0x022f:
        r1 = r11.mView;
        android.support.v4.view.ae.m2214a(r1, r3);
    L_0x0234:
        if (r0 == 0) goto L_0x024b;
    L_0x0236:
        r1 = r10.m841a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0246;
    L_0x023c:
        r2 = r11.mView;
        r10.m832b(r2, r1);
        r2 = r11.mView;
        r2.startAnimation(r1);
    L_0x0246:
        r1 = r11.mView;
        r0.addView(r1);
    L_0x024b:
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x0256;
    L_0x024f:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0256:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
    L_0x025d:
        r0 = r11.mSavedFragmentState;
        r11.performActivityCreated(r0);
        r0 = r11.mView;
        if (r0 == 0) goto L_0x026b;
    L_0x0266:
        r0 = r11.mSavedFragmentState;
        r11.restoreViewState(r0);
    L_0x026b:
        r11.mSavedFragmentState = r7;
    L_0x026d:
        r0 = 2;
        if (r12 <= r0) goto L_0x0272;
    L_0x0270:
        r11.mState = r6;
    L_0x0272:
        if (r12 <= r6) goto L_0x0293;
    L_0x0274:
        r0 = f612a;
        if (r0 == 0) goto L_0x0290;
    L_0x0278:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0290:
        r11.performStart();
    L_0x0293:
        if (r12 <= r9) goto L_0x0045;
    L_0x0295:
        r0 = f612a;
        if (r0 == 0) goto L_0x02b1;
    L_0x0299:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02b1:
        r11.performResume();
        r11.mSavedFragmentState = r7;
        r11.mSavedViewState = r7;
        goto L_0x0045;
    L_0x02ba:
        r0 = r11.mParentFragment;
        r0.onAttachFragment(r11);
        goto L_0x0134;
    L_0x02c1:
        r0 = r11.mSavedFragmentState;
        r11.restoreChildFragmentState(r0);
        r11.mState = r5;
        goto L_0x013d;
    L_0x02ca:
        r0 = r11.mView;
        r0 = android.support.v4.app.C0250v.m975a(r0);
        r11.mView = r0;
        goto L_0x0164;
    L_0x02d4:
        r11.mInnerView = r7;
        goto L_0x0176;
    L_0x02d8:
        r1 = move-exception;
        r1 = "unknown";
        goto L_0x01dc;
    L_0x02dd:
        r1 = r11.mView;
        r1 = android.support.v4.app.C0250v.m975a(r1);
        r11.mView = r1;
        goto L_0x0234;
    L_0x02e7:
        r11.mInnerView = r7;
        goto L_0x025d;
    L_0x02eb:
        r0 = r11.mState;
        if (r0 <= r12) goto L_0x0045;
    L_0x02ef:
        r0 = r11.mState;
        switch(r0) {
            case 1: goto L_0x02f6;
            case 2: goto L_0x0374;
            case 3: goto L_0x0353;
            case 4: goto L_0x0332;
            case 5: goto L_0x0310;
            default: goto L_0x02f4;
        };
    L_0x02f4:
        goto L_0x0045;
    L_0x02f6:
        if (r12 >= r5) goto L_0x0045;
    L_0x02f8:
        r0 = r10.f632u;
        if (r0 == 0) goto L_0x0307;
    L_0x02fc:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x0307;
    L_0x0300:
        r0 = r11.mAnimatingAway;
        r11.mAnimatingAway = r7;
        r0.clearAnimation();
    L_0x0307:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x03e3;
    L_0x030b:
        r11.mStateAfterAnimating = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x0310:
        r0 = 5;
        if (r12 >= r0) goto L_0x0332;
    L_0x0313:
        r0 = f612a;
        if (r0 == 0) goto L_0x032f;
    L_0x0317:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x032f:
        r11.performPause();
    L_0x0332:
        if (r12 >= r9) goto L_0x0353;
    L_0x0334:
        r0 = f612a;
        if (r0 == 0) goto L_0x0350;
    L_0x0338:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0350:
        r11.performStop();
    L_0x0353:
        if (r12 >= r6) goto L_0x0374;
    L_0x0355:
        r0 = f612a;
        if (r0 == 0) goto L_0x0371;
    L_0x0359:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0371:
        r11.performReallyStop();
    L_0x0374:
        r0 = 2;
        if (r12 >= r0) goto L_0x02f6;
    L_0x0377:
        r0 = f612a;
        if (r0 == 0) goto L_0x0393;
    L_0x037b:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0393:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x03a6;
    L_0x0397:
        r0 = r10.f627o;
        r0 = r0.mo121a(r11);
        if (r0 == 0) goto L_0x03a6;
    L_0x039f:
        r0 = r11.mSavedViewState;
        if (r0 != 0) goto L_0x03a6;
    L_0x03a3:
        r10.m882f(r11);
    L_0x03a6:
        r11.performDestroyView();
        r0 = r11.mView;
        if (r0 == 0) goto L_0x03db;
    L_0x03ad:
        r0 = r11.mContainer;
        if (r0 == 0) goto L_0x03db;
    L_0x03b1:
        r0 = r10.f626n;
        if (r0 <= 0) goto L_0x041f;
    L_0x03b5:
        r0 = r10.f632u;
        if (r0 != 0) goto L_0x041f;
    L_0x03b9:
        r0 = r10.m841a(r11, r13, r3, r14);
    L_0x03bd:
        if (r0 == 0) goto L_0x03d4;
    L_0x03bf:
        r1 = r11.mView;
        r11.mAnimatingAway = r1;
        r11.mStateAfterAnimating = r12;
        r1 = r11.mView;
        r2 = new android.support.v4.app.o$3;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.mView;
        r1.startAnimation(r0);
    L_0x03d4:
        r0 = r11.mContainer;
        r1 = r11.mView;
        r0.removeView(r1);
    L_0x03db:
        r11.mContainer = r7;
        r11.mView = r7;
        r11.mInnerView = r7;
        goto L_0x02f6;
    L_0x03e3:
        r0 = f612a;
        if (r0 == 0) goto L_0x03ff;
    L_0x03e7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03ff:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0414;
    L_0x0403:
        r11.performDestroy();
    L_0x0406:
        r11.performDetach();
        if (r15 != 0) goto L_0x0045;
    L_0x040b:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0417;
    L_0x040f:
        r10.m878e(r11);
        goto L_0x0045;
    L_0x0414:
        r11.mState = r3;
        goto L_0x0406;
    L_0x0417:
        r11.mHost = r7;
        r11.mParentFragment = r7;
        r11.mFragmentManager = r7;
        goto L_0x0045;
    L_0x041f:
        r0 = r7;
        goto L_0x03bd;
    L_0x0421:
        r0 = r7;
        goto L_0x0211;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.o.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void m872c(Fragment fragment) {
        m850a(fragment, this.f626n, 0, 0, false);
    }

    void m845a(int i, boolean z) {
        m843a(i, 0, 0, z);
    }

    void m843a(int i, int i2, int i3, boolean z) {
        if (this.f627o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f626n != i) {
            this.f626n = i;
            if (this.f618f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f618f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f618f.get(i4);
                    if (fragment != null) {
                        m850a(fragment, i, i2, i3, false);
                        if (fragment.mLoaderManager != null) {
                            a = i5 | fragment.mLoaderManager.mo157a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m875d();
                }
                if (this.f630s && this.f627o != null && this.f626n == 5) {
                    this.f627o.mo125d();
                    this.f630s = false;
                }
            }
        }
    }

    void m875d() {
        if (this.f618f != null) {
            for (int i = 0; i < this.f618f.size(); i++) {
                Fragment fragment = (Fragment) this.f618f.get(i);
                if (fragment != null) {
                    m863b(fragment);
                }
            }
        }
    }

    void m876d(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.f620h == null || this.f620h.size() <= 0) {
                if (this.f618f == null) {
                    this.f618f = new ArrayList();
                }
                fragment.setIndex(this.f618f.size(), this.f629q);
                this.f618f.add(fragment);
            } else {
                fragment.setIndex(((Integer) this.f620h.remove(this.f620h.size() - 1)).intValue(), this.f629q);
                this.f618f.set(fragment.mIndex, fragment);
            }
            if (f612a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void m878e(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (f612a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f618f.set(fragment.mIndex, null);
            if (this.f620h == null) {
                this.f620h = new ArrayList();
            }
            this.f620h.add(Integer.valueOf(fragment.mIndex));
            this.f627o.m735b(fragment.mWho);
            fragment.initState();
        }
    }

    public void m851a(Fragment fragment, boolean z) {
        if (this.f619g == null) {
            this.f619g = new ArrayList();
        }
        if (f612a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m876d(fragment);
        if (!fragment.mDetached) {
            if (this.f619g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f619g.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f630s = true;
            }
            if (z) {
                m872c(fragment);
            }
        }
    }

    public void m849a(Fragment fragment, int i, int i2) {
        if (f612a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            int i3;
            if (this.f619g != null) {
                this.f619g.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f630s = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            m850a(fragment, i3, i, i2, false);
        }
    }

    public void m864b(Fragment fragment, int i, int i2) {
        if (f612a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation a = m841a(fragment, i, false, i2);
                if (a != null) {
                    m832b(fragment.mView, a);
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.f630s = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public void m873c(Fragment fragment, int i, int i2) {
        if (f612a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation a = m841a(fragment, i, true, i2);
                if (a != null) {
                    m832b(fragment.mView, a);
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.f630s = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public void m877d(Fragment fragment, int i, int i2) {
        if (f612a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.f619g != null) {
                    if (f612a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f619g.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f630s = true;
                }
                fragment.mAdded = false;
                m850a(fragment, 1, i, i2, false);
            }
        }
    }

    public void m879e(Fragment fragment, int i, int i2) {
        if (f612a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.f619g == null) {
                    this.f619g = new ArrayList();
                }
                if (this.f619g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f612a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f619g.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f630s = true;
                }
                m850a(fragment, this.f626n, i, i2, false);
            }
        }
    }

    public Fragment m861b(int i) {
        int size;
        Fragment fragment;
        if (this.f619g != null) {
            for (size = this.f619g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f619g.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.f618f != null) {
            for (size = this.f618f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f618f.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment mo141a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f619g == null || str == null)) {
            for (size = this.f619g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f619g.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.f618f == null || str == null)) {
            for (size = this.f618f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f618f.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m862b(String str) {
        if (!(this.f618f == null || str == null)) {
            for (int size = this.f618f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f618f.get(size);
                if (fragment != null) {
                    fragment = fragment.findFragmentByWho(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void m834v() {
        if (this.f631t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f633v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f633v);
        }
    }

    public void m853a(Runnable runnable, boolean z) {
        if (!z) {
            m834v();
        }
        synchronized (this) {
            if (this.f632u || this.f627o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f615c == null) {
                this.f615c = new ArrayList();
            }
            this.f615c.add(runnable);
            if (this.f615c.size() == 1) {
                this.f627o.m743j().removeCallbacks(this.f637z);
                this.f627o.m743j().post(this.f637z);
            }
        }
    }

    public int m835a(C0214e c0214e) {
        int size;
        synchronized (this) {
            if (this.f624l == null || this.f624l.size() <= 0) {
                if (this.f623k == null) {
                    this.f623k = new ArrayList();
                }
                size = this.f623k.size();
                if (f612a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0214e);
                }
                this.f623k.add(c0214e);
            } else {
                size = ((Integer) this.f624l.remove(this.f624l.size() - 1)).intValue();
                if (f612a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0214e);
                }
                this.f623k.set(size, c0214e);
            }
        }
        return size;
    }

    public void m844a(int i, C0214e c0214e) {
        synchronized (this) {
            if (this.f623k == null) {
                this.f623k = new ArrayList();
            }
            int size = this.f623k.size();
            if (i < size) {
                if (f612a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0214e);
                }
                this.f623k.set(i, c0214e);
            } else {
                while (size < i) {
                    this.f623k.add(null);
                    if (this.f624l == null) {
                        this.f624l = new ArrayList();
                    }
                    if (f612a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f624l.add(Integer.valueOf(size));
                    size++;
                }
                if (f612a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0214e);
                }
                this.f623k.add(c0214e);
            }
        }
    }

    public void m871c(int i) {
        synchronized (this) {
            this.f623k.set(i, null);
            if (this.f624l == null) {
                this.f624l = new ArrayList();
            }
            if (f612a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f624l.add(Integer.valueOf(i));
        }
    }

    public void m867b(Runnable runnable, boolean z) {
        if (this.f617e) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.f627o.m743j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                m834v();
            }
            this.f617e = true;
            runnable.run();
            this.f617e = false;
            m881f();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m880e() {
        /*
        r6 = this;
        r2 = 1;
        r1 = 0;
        r0 = r6.f617e;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "FragmentManager is already executing transactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r0 = android.os.Looper.myLooper();
        r3 = r6.f627o;
        r3 = r3.m743j();
        r3 = r3.getLooper();
        if (r0 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of fragment host";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r0 = r1;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f615c;	 Catch:{ all -> 0x0078 }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f615c;	 Catch:{ all -> 0x0078 }
        r3 = r3.size();	 Catch:{ all -> 0x0078 }
        if (r3 != 0) goto L_0x0039;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6.m881f();
        return r0;
    L_0x0039:
        r0 = r6.f615c;	 Catch:{ all -> 0x0078 }
        r3 = r0.size();	 Catch:{ all -> 0x0078 }
        r0 = r6.f616d;	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0048;
    L_0x0043:
        r0 = r6.f616d;	 Catch:{ all -> 0x0078 }
        r0 = r0.length;	 Catch:{ all -> 0x0078 }
        if (r0 >= r3) goto L_0x004c;
    L_0x0048:
        r0 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0078 }
        r6.f616d = r0;	 Catch:{ all -> 0x0078 }
    L_0x004c:
        r0 = r6.f615c;	 Catch:{ all -> 0x0078 }
        r4 = r6.f616d;	 Catch:{ all -> 0x0078 }
        r0.toArray(r4);	 Catch:{ all -> 0x0078 }
        r0 = r6.f615c;	 Catch:{ all -> 0x0078 }
        r0.clear();	 Catch:{ all -> 0x0078 }
        r0 = r6.f627o;	 Catch:{ all -> 0x0078 }
        r0 = r0.m743j();	 Catch:{ all -> 0x0078 }
        r4 = r6.f637z;	 Catch:{ all -> 0x0078 }
        r0.removeCallbacks(r4);	 Catch:{ all -> 0x0078 }
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6.f617e = r2;
        r0 = r1;
    L_0x0067:
        if (r0 >= r3) goto L_0x007b;
    L_0x0069:
        r4 = r6.f616d;
        r4 = r4[r0];
        r4.run();
        r4 = r6.f616d;
        r5 = 0;
        r4[r0] = r5;
        r0 = r0 + 1;
        goto L_0x0067;
    L_0x0078:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        throw r0;
    L_0x007b:
        r6.f617e = r1;
        r0 = r2;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.o.e():boolean");
    }

    void m881f() {
        if (this.f634w) {
            int i = 0;
            for (int i2 = 0; i2 < this.f618f.size(); i2++) {
                Fragment fragment = (Fragment) this.f618f.get(i2);
                if (!(fragment == null || fragment.mLoaderManager == null)) {
                    i |= fragment.mLoaderManager.mo157a();
                }
            }
            if (i == 0) {
                this.f634w = false;
                m875d();
            }
        }
    }

    void m884g() {
        if (this.f625m != null) {
            for (int i = 0; i < this.f625m.size(); i++) {
                ((C0225a) this.f625m.get(i)).m815a();
            }
        }
    }

    void m865b(C0214e c0214e) {
        if (this.f621i == null) {
            this.f621i = new ArrayList();
        }
        this.f621i.add(c0214e);
        m884g();
    }

    boolean m857a(Handler handler, String str, int i, int i2) {
        if (this.f621i == null) {
            return false;
        }
        int size;
        C0214e c0214e;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f621i.size() - 1;
            if (size < 0) {
                return false;
            }
            c0214e = (C0214e) this.f621i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            if (this.f626n >= 1) {
                c0214e.m713a(sparseArray, sparseArray2);
            }
            c0214e.m702a(true, null, sparseArray, sparseArray2);
            m884g();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.f621i.size() - 1;
                while (size2 >= 0) {
                    c0214e = (C0214e) this.f621i.get(size2);
                    if ((str != null && str.equals(c0214e.m719e())) || (i >= 0 && i == c0214e.f561p)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0214e = (C0214e) this.f621i.get(size2);
                        if ((str == null || !str.equals(c0214e.m719e())) && (i < 0 || i != c0214e.f561p)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f621i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f621i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f621i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            if (this.f626n >= 1) {
                for (size2 = 0; size2 <= size3; size2++) {
                    ((C0214e) arrayList.get(size2)).m713a(sparseArray3, sparseArray4);
                }
            }
            C0212b c0212b = null;
            int i3 = 0;
            while (i3 <= size3) {
                boolean z;
                if (f612a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                c0214e = (C0214e) arrayList.get(i3);
                if (i3 == size3) {
                    z = true;
                } else {
                    z = false;
                }
                i3++;
                c0212b = c0214e.m702a(z, c0212b, sparseArray3, sparseArray4);
            }
            m884g();
        }
        return true;
    }

    C0235p m885h() {
        List list;
        List list2;
        if (this.f618f != null) {
            int i = 0;
            list = null;
            list2 = null;
            while (i < this.f618f.size()) {
                ArrayList arrayList;
                Fragment fragment = (Fragment) this.f618f.get(i);
                if (fragment != null) {
                    boolean z;
                    if (fragment.mRetainInstance) {
                        if (list2 == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragment);
                        fragment.mRetaining = true;
                        fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                        if (f612a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                        }
                    }
                    if (fragment.mChildFragmentManager != null) {
                        C0235p h = fragment.mChildFragmentManager.m885h();
                        if (h != null) {
                            ArrayList arrayList2;
                            if (list == null) {
                                arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < i; i2++) {
                                    arrayList2.add(null);
                                }
                            } else {
                                arrayList2 = list;
                            }
                            arrayList2.add(h);
                            list = arrayList2;
                            z = true;
                            if (!(list == null || r0)) {
                                list.add(null);
                            }
                        }
                    }
                    z = false;
                    list.add(null);
                }
                i++;
                Object obj = arrayList;
            }
        } else {
            list = null;
            list2 = null;
        }
        if (list2 == null && list == null) {
            return null;
        }
        return new C0235p(list2, list);
    }

    void m882f(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.f636y == null) {
                this.f636y = new SparseArray();
            } else {
                this.f636y.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.f636y);
            if (this.f636y.size() > 0) {
                fragment.mSavedViewState = this.f636y;
                this.f636y = null;
            }
        }
    }

    Bundle m883g(Fragment fragment) {
        Bundle bundle;
        if (this.f635x == null) {
            this.f635x = new Bundle();
        }
        fragment.performSaveInstanceState(this.f635x);
        if (this.f635x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f635x;
            this.f635x = null;
        }
        if (fragment.mView != null) {
            m882f(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    Parcelable m886i() {
        BackStackState[] backStackStateArr = null;
        m880e();
        if (f613b) {
            this.f631t = true;
        }
        if (this.f618f == null || this.f618f.size() <= 0) {
            return null;
        }
        int size = this.f618f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f618f.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    m828a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.f479k != null) {
                    fragmentState.f479k = fragment.mSavedFragmentState;
                } else {
                    fragmentState.f479k = m883g(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            m828a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (fragmentState.f479k == null) {
                            fragmentState.f479k = new Bundle();
                        }
                        mo145a(fragmentState.f479k, "android:target_state", fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.f479k.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                }
                if (f612a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f479k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f619g != null) {
                i = this.f619g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f619g.get(i2)).mIndex;
                        if (iArr[i2] < 0) {
                            m828a(new IllegalStateException("Failure saving state: active " + this.f619g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f612a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f619g.get(i2));
                        }
                    }
                    if (this.f621i != null) {
                        i = this.f621i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((C0214e) this.f621i.get(i2));
                                if (f612a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f621i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f466a = fragmentStateArr;
                    fragmentManagerState.f467b = iArr;
                    fragmentManagerState.f468c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f621i != null) {
                i = this.f621i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((C0214e) this.f621i.get(i2));
                        if (f612a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f621i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f466a = fragmentStateArr;
            fragmentManagerState.f467b = iArr;
            fragmentManagerState.f468c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f612a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void m848a(Parcelable parcelable, C0235p c0235p) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f466a != null) {
                List a;
                int size;
                int i;
                Fragment fragment;
                List list;
                if (c0235p != null) {
                    a = c0235p.m899a();
                    List b = c0235p.m900b();
                    if (a != null) {
                        size = a.size();
                    } else {
                        boolean z = false;
                    }
                    for (i = 0; i < size; i++) {
                        fragment = (Fragment) a.get(i);
                        if (f612a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f466a[fragment.mIndex];
                        fragmentState.f480l = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.f479k != null) {
                            fragmentState.f479k.setClassLoader(this.f627o.m742i().getClassLoader());
                            fragment.mSavedViewState = fragmentState.f479k.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = fragmentState.f479k;
                        }
                    }
                    list = b;
                } else {
                    list = null;
                }
                this.f618f = new ArrayList(fragmentManagerState.f466a.length);
                if (this.f620h != null) {
                    this.f620h.clear();
                }
                int i2 = 0;
                while (i2 < fragmentManagerState.f466a.length) {
                    FragmentState fragmentState2 = fragmentManagerState.f466a[i2];
                    if (fragmentState2 != null) {
                        C0235p c0235p2;
                        if (list == null || i2 >= list.size()) {
                            c0235p2 = null;
                        } else {
                            c0235p2 = (C0235p) list.get(i2);
                        }
                        fragment = fragmentState2.m611a(this.f627o, this.f629q, c0235p2);
                        if (f612a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + fragment);
                        }
                        this.f618f.add(fragment);
                        fragmentState2.f480l = null;
                    } else {
                        this.f618f.add(null);
                        if (this.f620h == null) {
                            this.f620h = new ArrayList();
                        }
                        if (f612a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f620h.add(Integer.valueOf(i2));
                    }
                    i2++;
                }
                if (c0235p != null) {
                    a = c0235p.m899a();
                    if (a != null) {
                        i2 = a.size();
                    } else {
                        boolean z2 = false;
                    }
                    for (i = 0; i < i2; i++) {
                        fragment = (Fragment) a.get(i);
                        if (fragment.mTargetIndex >= 0) {
                            if (fragment.mTargetIndex < this.f618f.size()) {
                                fragment.mTarget = (Fragment) this.f618f.get(fragment.mTargetIndex);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.mTargetIndex);
                                fragment.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f467b != null) {
                    this.f619g = new ArrayList(fragmentManagerState.f467b.length);
                    for (size = 0; size < fragmentManagerState.f467b.length; size++) {
                        fragment = (Fragment) this.f618f.get(fragmentManagerState.f467b[size]);
                        if (fragment == null) {
                            m828a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f467b[size]));
                        }
                        fragment.mAdded = true;
                        if (f612a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + size + ": " + fragment);
                        }
                        if (this.f619g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f619g.add(fragment);
                    }
                } else {
                    this.f619g = null;
                }
                if (fragmentManagerState.f468c != null) {
                    this.f621i = new ArrayList(fragmentManagerState.f468c.length);
                    for (int i3 = 0; i3 < fragmentManagerState.f468c.length; i3++) {
                        C0214e a2 = fragmentManagerState.f468c[i3].m600a(this);
                        if (f612a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + a2.f561p + "): " + a2);
                            a2.m715a("  ", new PrintWriter(new C0360d("FragmentManager")), false);
                        }
                        this.f621i.add(a2);
                        if (a2.f561p >= 0) {
                            m844a(a2.f561p, a2);
                        }
                    }
                    return;
                }
                this.f621i = null;
            }
        }
    }

    public void m852a(C0220m c0220m, C0177k c0177k, Fragment fragment) {
        if (this.f627o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f627o = c0220m;
        this.f628p = c0177k;
        this.f629q = fragment;
    }

    public void m887j() {
        this.f631t = false;
    }

    public void m888k() {
        this.f631t = false;
        m845a(1, false);
    }

    public void m889l() {
        this.f631t = false;
        m845a(2, false);
    }

    public void m890m() {
        this.f631t = false;
        m845a(4, false);
    }

    public void m891n() {
        this.f631t = false;
        m845a(5, false);
    }

    public void m892o() {
        m845a(4, false);
    }

    public void m893p() {
        this.f631t = true;
        m845a(3, false);
    }

    public void m894q() {
        m845a(2, false);
    }

    public void m895r() {
        m845a(1, false);
    }

    public void m896s() {
        this.f632u = true;
        m880e();
        m845a(0, false);
        this.f627o = null;
        this.f628p = null;
        this.f629q = null;
    }

    public void m855a(boolean z) {
        if (this.f619g != null) {
            for (int size = this.f619g.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f619g.get(size);
                if (fragment != null) {
                    fragment.performMultiWindowModeChanged(z);
                }
            }
        }
    }

    public void m868b(boolean z) {
        if (this.f619g != null) {
            for (int size = this.f619g.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f619g.get(size);
                if (fragment != null) {
                    fragment.performPictureInPictureModeChanged(z);
                }
            }
        }
    }

    public void m846a(Configuration configuration) {
        if (this.f619g != null) {
            for (int i = 0; i < this.f619g.size(); i++) {
                Fragment fragment = (Fragment) this.f619g.get(i);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
            }
        }
    }

    public void m897t() {
        if (this.f619g != null) {
            for (int i = 0; i < this.f619g.size(); i++) {
                Fragment fragment = (Fragment) this.f619g.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }

    public boolean m859a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f619g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f619g.size()) {
                fragment = (Fragment) this.f619g.get(i2);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f622j != null) {
            while (i < this.f622j.size()) {
                fragment = (Fragment) this.f622j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.f622j = arrayList;
        return z;
    }

    public boolean m858a(Menu menu) {
        if (this.f619g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f619g.size(); i++) {
            Fragment fragment = (Fragment) this.f619g.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m860a(MenuItem menuItem) {
        if (this.f619g == null) {
            return false;
        }
        for (int i = 0; i < this.f619g.size(); i++) {
            Fragment fragment = (Fragment) this.f619g.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean m870b(MenuItem menuItem) {
        if (this.f619g == null) {
            return false;
        }
        for (int i = 0; i < this.f619g.size(); i++) {
            Fragment fragment = (Fragment) this.f619g.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m866b(Menu menu) {
        if (this.f619g != null) {
            for (int i = 0; i < this.f619g.size(); i++) {
                Fragment fragment = (Fragment) this.f619g.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public static int m833d(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int m831b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View mo143a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0232b.f607a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.f627o.m742i(), string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment b = resourceId != -1 ? m861b(resourceId) : null;
        if (b == null && string2 != null) {
            b = mo141a(string2);
        }
        if (b == null && id != -1) {
            b = m861b(id);
        }
        if (f612a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + b);
        }
        if (b == null) {
            Fragment instantiate = Fragment.instantiate(context, string);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            instantiate.mContainerId = id;
            instantiate.mTag = string2;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.mHost = this.f627o;
            instantiate.onInflate(this.f627o.m742i(), attributeSet, instantiate.mSavedFragmentState);
            m851a(instantiate, true);
            fragment = instantiate;
        } else if (b.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            b.mInLayout = true;
            b.mHost = this.f627o;
            if (!b.mRetaining) {
                b.onInflate(this.f627o.m742i(), attributeSet, b.mSavedFragmentState);
            }
            fragment = b;
        }
        if (this.f626n >= 1 || !fragment.mFromLayout) {
            m872c(fragment);
        } else {
            m850a(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }

    C0233m m898u() {
        return this;
    }
}
