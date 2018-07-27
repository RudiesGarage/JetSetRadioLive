package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p024g.C0356i;
import android.support.v4.p024g.C0359c;
import android.support.v4.view.C0578i;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    private static final C0356i<String, Class<?>> sClassMap = new C0356i();
    boolean mAdded;
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    C0234o mChildFragmentManager;
    C0235p mChildNonConfig;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    Object mEnterTransition = null;
    al mEnterTransitionCallback = null;
    Object mExitTransition = null;
    al mExitTransitionCallback = null;
    int mFragmentId;
    C0234o mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    C0220m mHost;
    boolean mInLayout;
    int mIndex = -1;
    View mInnerView;
    C0249u mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible = true;
    int mNextAnim;
    Fragment mParentFragment;
    Object mReenterTransition = USE_DEFAULT_TRANSITION;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetaining;
    Object mReturnTransition = USE_DEFAULT_TRANSITION;
    Bundle mSavedFragmentState;
    SparseArray<Parcelable> mSavedViewState;
    Object mSharedElementEnterTransition = null;
    Object mSharedElementReturnTransition = USE_DEFAULT_TRANSITION;
    int mState = 0;
    int mStateAfterAnimating;
    String mTag;
    Fragment mTarget;
    int mTargetIndex = -1;
    int mTargetRequestCode;
    boolean mUserVisibleHint = true;
    View mView;
    String mWho;

    class C01781 extends C0177k {
        final /* synthetic */ Fragment f464a;

        C01781(Fragment fragment) {
            this.f464a = fragment;
        }

        public View mo91a(int i) {
            if (this.f464a.mView != null) {
                return this.f464a.mView.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        public boolean mo92a() {
            return this.f464a.mView != null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C01791();
        final Bundle f465a;

        static class C01791 implements Creator<SavedState> {
            C01791() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m605a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m606a(i);
            }

            public SavedState m605a(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public SavedState[] m606a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Bundle bundle) {
            this.f465a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f465a = parcel.readBundle();
            if (classLoader != null && this.f465a != null) {
                this.f465a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f465a);
        }
    }

    public static class C0180a extends RuntimeException {
        public C0180a(String str, Exception exception) {
            super(str, exception);
        }
    }

    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) sClassMap.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                sClassMap.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.mArguments = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new C0180a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0180a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0180a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean isSupportFragmentClass(Context context, String str) {
        try {
            Class cls = (Class) sClassMap.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                sClassMap.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void restoreViewState(Bundle bundle) {
        if (this.mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new am("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    final void setIndex(int i, Fragment fragment) {
        this.mIndex = i;
        if (fragment != null) {
            this.mWho = fragment.mWho + ":" + this.mIndex;
        } else {
            this.mWho = "android:fragment:" + this.mIndex;
        }
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0359c.m1301a(this, stringBuilder);
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mTag);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(Bundle bundle) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.mArguments = bundle;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public void setInitialSavedState(SavedState savedState) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (savedState == null || savedState.f465a == null) ? null : savedState.f465a;
        this.mSavedFragmentState = bundle;
    }

    public void setTargetFragment(Fragment fragment, int i) {
        this.mTarget = fragment;
        this.mTargetRequestCode = i;
    }

    public final Fragment getTargetFragment() {
        return this.mTarget;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        return this.mHost == null ? null : this.mHost.m742i();
    }

    public final C0223j getActivity() {
        return this.mHost == null ? null : (C0223j) this.mHost.m741h();
    }

    public final Object getHost() {
        return this.mHost == null ? null : this.mHost.mo128g();
    }

    public final Resources getResources() {
        if (this.mHost != null) {
            return this.mHost.m742i().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final C0226n getFragmentManager() {
        return this.mFragmentManager;
    }

    public final C0226n getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
            if (this.mState >= 5) {
                this.mChildFragmentManager.m891n();
            } else if (this.mState >= 4) {
                this.mChildFragmentManager.m890m();
            } else if (this.mState >= 2) {
                this.mChildFragmentManager.m889l();
            } else if (this.mState >= 1) {
                this.mChildFragmentManager.m888k();
            }
        }
        return this.mChildFragmentManager;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        return this.mState >= 5;
    }

    public final boolean isVisible() {
        return (!isAdded() || isHidden() || this.mView == null || this.mView.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public void onHiddenChanged(boolean z) {
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mHost.mo125d();
            }
        }
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.mo125d();
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 4 && this.mFragmentManager != null && isAdded()) {
            this.mFragmentManager.m863b(this);
        }
        this.mUserVisibleHint = z;
        boolean z2 = this.mState < 4 && !z;
        this.mDeferStart = z2;
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public C0245t getLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = this.mHost.m722a(this.mWho, this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.mo117a(this, intent, -1, bundle);
    }

    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.mo117a(this, intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.mo118a(this, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.mo119a(this, strArr, i);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        if (this.mHost != null) {
            return this.mHost.mo122a(str);
        }
        return false;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        LayoutInflater b = this.mHost.mo123b();
        getChildFragmentManager();
        C0578i.m2466a(b, this.mChildFragmentManager.m898u());
        return b;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        Activity h = this.mHost == null ? null : this.mHost.m741h();
        if (h != null) {
            this.mCalled = false;
            onInflate(h, attributeSet, bundle);
        }
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        Activity h = this.mHost == null ? null : this.mHost.m741h();
        if (h != null) {
            this.mCalled = false;
            onAttach(h);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager != null && !this.mChildFragmentManager.m856a(1)) {
            this.mChildFragmentManager.m888k();
        }
    }

    void restoreChildFragmentState(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.mChildFragmentManager == null) {
                    instantiateChildFragmentManager();
                }
                this.mChildFragmentManager.m848a(parcelable, this.mChildNonConfig);
                this.mChildNonConfig = null;
                this.mChildFragmentManager.m888k();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public View getView() {
        return this.mView;
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.m722a(this.mWho, this.mLoadersStarted, false);
            }
            if (this.mLoaderManager != null) {
                this.mLoaderManager.m968b();
            }
        }
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
        if (!this.mCheckedForLoaderManager) {
            this.mCheckedForLoaderManager = true;
            this.mLoaderManager = this.mHost.m722a(this.mWho, this.mLoadersStarted, false);
        }
        if (this.mLoaderManager != null) {
            this.mLoaderManager.m974h();
        }
    }

    void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = null;
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
        this.mLoaderManager = null;
        this.mLoadersStarted = false;
        this.mCheckedForLoaderManager = false;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onDestroyOptionsMenu() {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        getActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void setEnterSharedElementCallback(al alVar) {
        this.mEnterTransitionCallback = alVar;
    }

    public void setExitSharedElementCallback(al alVar) {
        this.mExitTransitionCallback = alVar;
    }

    public void setEnterTransition(Object obj) {
        this.mEnterTransition = obj;
    }

    public Object getEnterTransition() {
        return this.mEnterTransition;
    }

    public void setReturnTransition(Object obj) {
        this.mReturnTransition = obj;
    }

    public Object getReturnTransition() {
        return this.mReturnTransition == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mReturnTransition;
    }

    public void setExitTransition(Object obj) {
        this.mExitTransition = obj;
    }

    public Object getExitTransition() {
        return this.mExitTransition;
    }

    public void setReenterTransition(Object obj) {
        this.mReenterTransition = obj;
    }

    public Object getReenterTransition() {
        return this.mReenterTransition == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mReenterTransition;
    }

    public void setSharedElementEnterTransition(Object obj) {
        this.mSharedElementEnterTransition = obj;
    }

    public Object getSharedElementEnterTransition() {
        return this.mSharedElementEnterTransition;
    }

    public void setSharedElementReturnTransition(Object obj) {
        this.mSharedElementReturnTransition = obj;
    }

    public Object getSharedElementReturnTransition() {
        return this.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mSharedElementReturnTransition;
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        this.mAllowEnterTransitionOverlap = Boolean.valueOf(z);
    }

    public boolean getAllowEnterTransitionOverlap() {
        return this.mAllowEnterTransitionOverlap == null ? true : this.mAllowEnterTransitionOverlap.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        this.mAllowReturnTransitionOverlap = Boolean.valueOf(z);
    }

    public boolean getAllowReturnTransitionOverlap() {
        return this.mAllowReturnTransitionOverlap == null ? true : this.mAllowReturnTransitionOverlap.booleanValue();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mRetaining=");
        printWriter.print(this.mRetaining);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mTarget != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.mTarget);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (this.mNextAnim != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.mNextAnim);
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (this.mAnimatingAway != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.mAnimatingAway);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.mStateAfterAnimating);
        }
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.mLoaderManager.m966a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.mChildFragmentManager != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.mChildFragmentManager + ":");
            this.mChildFragmentManager.mo146a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    Fragment findFragmentByWho(String str) {
        if (str.equals(this.mWho)) {
            return this;
        }
        if (this.mChildFragmentManager != null) {
            return this.mChildFragmentManager.m862b(str);
        }
        return null;
    }

    void instantiateChildFragmentManager() {
        this.mChildFragmentManager = new C0234o();
        this.mChildFragmentManager.m852a(this.mHost, new C01781(this), this);
    }

    void performCreate(Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m887j();
        }
        this.mState = 1;
        this.mCalled = false;
        onCreate(bundle);
        if (!this.mCalled) {
            throw new am("Fragment " + this + " did not call through to super.onCreate()");
        }
    }

    View performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m887j();
        }
        return onCreateView(layoutInflater, viewGroup, bundle);
    }

    void performActivityCreated(Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m887j();
        }
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new am("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m889l();
        }
    }

    void performStart() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m887j();
            this.mChildFragmentManager.m880e();
        }
        this.mState = 4;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.m890m();
            }
            if (this.mLoaderManager != null) {
                this.mLoaderManager.m973g();
                return;
            }
            return;
        }
        throw new am("Fragment " + this + " did not call through to super.onStart()");
    }

    void performResume() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m887j();
            this.mChildFragmentManager.m880e();
        }
        this.mState = 5;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new am("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m891n();
            this.mChildFragmentManager.m880e();
        }
    }

    void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m855a(z);
        }
    }

    void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m868b(z);
        }
    }

    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m846a(configuration);
        }
    }

    void performLowMemory() {
        onLowMemory();
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m897t();
        }
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        if (this.mChildFragmentManager != null) {
            return z | this.mChildFragmentManager.m859a(menu, menuInflater);
        }
        return z;
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        if (this.mChildFragmentManager != null) {
            return z | this.mChildFragmentManager.m858a(menu);
        }
        return z;
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
                return true;
            }
            if (this.mChildFragmentManager != null && this.mChildFragmentManager.m860a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (onContextItemSelected(menuItem)) {
                return true;
            }
            if (this.mChildFragmentManager != null && this.mChildFragmentManager.m870b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.m866b(menu);
            }
        }
    }

    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        if (this.mChildFragmentManager != null) {
            Parcelable i = this.mChildFragmentManager.m886i();
            if (i != null) {
                bundle.putParcelable("android:support:fragments", i);
            }
        }
    }

    void performPause() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m892o();
        }
        this.mState = 4;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new am("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void performStop() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m893p();
        }
        this.mState = 3;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new am("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void performReallyStop() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m894q();
        }
        this.mState = 2;
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.m722a(this.mWho, this.mLoadersStarted, false);
            }
            if (this.mLoaderManager == null) {
                return;
            }
            if (this.mHost.m745l()) {
                this.mLoaderManager.m970d();
            } else {
                this.mLoaderManager.m969c();
            }
        }
    }

    void performDestroyView() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m895r();
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new am("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.mLoaderManager != null) {
            this.mLoaderManager.m972f();
        }
    }

    void performDestroy() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m896s();
        }
        this.mState = 0;
        this.mCalled = false;
        onDestroy();
        if (this.mCalled) {
            this.mChildFragmentManager = null;
            return;
        }
        throw new am("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDetach() {
        this.mCalled = false;
        onDetach();
        if (!this.mCalled) {
            throw new am("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.mChildFragmentManager == null) {
        } else {
            if (this.mRetaining) {
                this.mChildFragmentManager.m896s();
                this.mChildFragmentManager = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
    }
}
