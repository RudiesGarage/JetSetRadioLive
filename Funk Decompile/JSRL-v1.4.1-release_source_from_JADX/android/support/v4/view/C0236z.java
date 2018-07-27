package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: PagerAdapter */
public abstract class C0236z {
    private final DataSetObservable f640a = new DataSetObservable();
    private DataSetObserver f641b;

    public abstract boolean mo154a(View view, Object obj);

    public abstract int mo873b();

    public void mo152a(ViewGroup viewGroup) {
        m907a((View) viewGroup);
    }

    public Object mo150a(ViewGroup viewGroup, int i) {
        return m903a((View) viewGroup, i);
    }

    public void mo153a(ViewGroup viewGroup, int i, Object obj) {
        m908a((View) viewGroup, i, obj);
    }

    public void mo156b(ViewGroup viewGroup, int i, Object obj) {
        m915b((View) viewGroup, i, obj);
    }

    public void mo155b(ViewGroup viewGroup) {
        m914b((View) viewGroup);
    }

    @Deprecated
    public void m907a(View view) {
    }

    @Deprecated
    public Object m903a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void m908a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    @Deprecated
    public void m915b(View view, int i, Object obj) {
    }

    @Deprecated
    public void m914b(View view) {
    }

    public Parcelable mo149a() {
        return null;
    }

    public void mo151a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int m901a(Object obj) {
        return -1;
    }

    void m905a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f641b = dataSetObserver;
        }
    }

    public float m912b(int i) {
        return 1.0f;
    }
}
