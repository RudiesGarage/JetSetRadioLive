package p000a.p001a.p002a.p003a.p004a.p007c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DependencyPriorityBlockingQueue */
public class C0061c<E extends C0060b & C0065l & C0064i> extends PriorityBlockingQueue<E> {
    final Queue<E> f136a = new LinkedList();
    private final ReentrantLock f137b = new ReentrantLock();

    public /* synthetic */ Object peek() {
        return m191b();
    }

    public /* synthetic */ Object poll() {
        return m193c();
    }

    public /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
        return m187a(j, timeUnit);
    }

    public /* synthetic */ Object take() {
        return m185a();
    }

    public E m185a() {
        return m192b(0, null, null);
    }

    public E m191b() {
        E e = null;
        try {
            e = m192b(1, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public E m187a(long j, TimeUnit timeUnit) {
        return m192b(3, Long.valueOf(j), timeUnit);
    }

    public E m193c() {
        E e = null;
        try {
            e = m192b(2, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public int size() {
        try {
            this.f137b.lock();
            int size = this.f136a.size() + super.size();
            return size;
        } finally {
            this.f137b.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.f137b.lock();
            T[] a = m190a(super.toArray(tArr), this.f136a.toArray(tArr));
            return a;
        } finally {
            this.f137b.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.f137b.lock();
            Object[] a = m190a(super.toArray(), this.f136a.toArray());
            return a;
        } finally {
            this.f137b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.f137b.lock();
            int drainTo = super.drainTo(collection) + this.f136a.size();
            while (!this.f136a.isEmpty()) {
                collection.add(this.f136a.poll());
            }
            return drainTo;
        } finally {
            this.f137b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f137b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f136a.isEmpty() && drainTo <= i) {
                collection.add(this.f136a.poll());
                drainTo++;
            }
            this.f137b.unlock();
            return drainTo;
        } catch (Throwable th) {
            this.f137b.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.f137b.lock();
            boolean z = super.contains(obj) || this.f136a.contains(obj);
            this.f137b.unlock();
            return z;
        } catch (Throwable th) {
            this.f137b.unlock();
        }
    }

    public void clear() {
        try {
            this.f137b.lock();
            this.f136a.clear();
            super.clear();
        } finally {
            this.f137b.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.f137b.lock();
            boolean z = super.remove(obj) || this.f136a.remove(obj);
            this.f137b.unlock();
            return z;
        } catch (Throwable th) {
            this.f137b.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.f137b.lock();
            boolean removeAll = super.removeAll(collection) | this.f136a.removeAll(collection);
            return removeAll;
        } finally {
            this.f137b.unlock();
        }
    }

    E m186a(int i, Long l, TimeUnit timeUnit) {
        switch (i) {
            case 0:
                return (C0060b) super.take();
            case 1:
                return (C0060b) super.peek();
            case 2:
                return (C0060b) super.poll();
            case 3:
                return (C0060b) super.poll(l.longValue(), timeUnit);
            default:
                return null;
        }
    }

    boolean m188a(int i, E e) {
        try {
            this.f137b.lock();
            if (i == 1) {
                super.remove(e);
            }
            boolean offer = this.f136a.offer(e);
            return offer;
        } finally {
            this.f137b.unlock();
        }
    }

    E m192b(int i, Long l, TimeUnit timeUnit) {
        C0060b a;
        while (true) {
            a = m186a(i, l, timeUnit);
            if (a == null || m189a(a)) {
                return a;
            }
            m188a(i, a);
        }
        return a;
    }

    boolean m189a(E e) {
        return e.mo15d();
    }

    public void m194d() {
        try {
            this.f137b.lock();
            Iterator it = this.f136a.iterator();
            while (it.hasNext()) {
                C0060b c0060b = (C0060b) it.next();
                if (m189a(c0060b)) {
                    super.offer(c0060b);
                    it.remove();
                }
            }
        } finally {
            this.f137b.unlock();
        }
    }

    <T> T[] m190a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, objArr, 0, length);
        System.arraycopy(tArr2, 0, objArr, length, length2);
        return objArr;
    }
}
