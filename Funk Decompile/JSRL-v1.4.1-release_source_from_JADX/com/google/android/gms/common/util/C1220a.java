package com.google.android.gms.common.util;

import android.support.v4.p024g.C0357a;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class C1220a<E> extends AbstractSet<E> {
    private final C0357a<E, E> f3192a = new C0357a();

    public boolean m5676a(C1220a<? extends E> c1220a) {
        int size = size();
        this.f3192a.m1288a(c1220a.f3192a);
        return size() > size;
    }

    public boolean add(E e) {
        if (this.f3192a.containsKey(e)) {
            return false;
        }
        this.f3192a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof C1220a ? m5676a((C1220a) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f3192a.clear();
    }

    public boolean contains(Object obj) {
        return this.f3192a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f3192a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f3192a.containsKey(obj)) {
            return false;
        }
        this.f3192a.remove(obj);
        return true;
    }

    public int size() {
        return this.f3192a.size();
    }
}
