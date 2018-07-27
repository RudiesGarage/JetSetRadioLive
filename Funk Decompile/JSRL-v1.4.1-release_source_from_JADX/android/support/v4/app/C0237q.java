package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.C0236z;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: FragmentStatePagerAdapter */
public abstract class C0237q extends C0236z {
    private final C0226n f642a;
    private C0213r f643b = null;
    private ArrayList<SavedState> f644c = new ArrayList();
    private ArrayList<Fragment> f645d = new ArrayList();
    private Fragment f646e = null;

    public abstract Fragment mo872a(int i);

    public C0237q(C0226n c0226n) {
        this.f642a = c0226n;
    }

    public void mo152a(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public Object mo150a(ViewGroup viewGroup, int i) {
        if (this.f645d.size() > i) {
            Fragment fragment = (Fragment) this.f645d.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f643b == null) {
            this.f643b = this.f642a.mo142a();
        }
        Fragment a = mo872a(i);
        if (this.f644c.size() > i) {
            SavedState savedState = (SavedState) this.f644c.get(i);
            if (savedState != null) {
                a.setInitialSavedState(savedState);
            }
        }
        while (this.f645d.size() <= i) {
            this.f645d.add(null);
        }
        a.setMenuVisibility(false);
        a.setUserVisibleHint(false);
        this.f645d.set(i, a);
        this.f643b.mo102a(viewGroup.getId(), a);
        return a;
    }

    public void mo153a(ViewGroup viewGroup, int i, Object obj) {
        Object a;
        Fragment fragment = (Fragment) obj;
        if (this.f643b == null) {
            this.f643b = this.f642a.mo142a();
        }
        while (this.f644c.size() <= i) {
            this.f644c.add(null);
        }
        ArrayList arrayList = this.f644c;
        if (fragment.isAdded()) {
            a = this.f642a.mo139a(fragment);
        } else {
            a = null;
        }
        arrayList.set(i, a);
        this.f645d.set(i, null);
        this.f643b.mo103a(fragment);
    }

    public void mo156b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f646e) {
            if (this.f646e != null) {
                this.f646e.setMenuVisibility(false);
                this.f646e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f646e = fragment;
        }
    }

    public void mo155b(ViewGroup viewGroup) {
        if (this.f643b != null) {
            this.f643b.mo107d();
            this.f643b = null;
        }
    }

    public boolean mo154a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public Parcelable mo149a() {
        Bundle bundle = null;
        if (this.f644c.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.f644c.size()];
            this.f644c.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.f645d.size(); i++) {
            Fragment fragment = (Fragment) this.f645d.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.f642a.mo145a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public void mo151a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f644c.clear();
            this.f645d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f644c.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.f642a.mo140a(bundle, str);
                    if (a != null) {
                        while (this.f645d.size() <= parseInt) {
                            this.f645d.add(null);
                        }
                        a.setMenuVisibility(false);
                        this.f645d.set(parseInt, a);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
