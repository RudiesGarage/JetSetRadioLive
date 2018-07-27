package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.p025a.C0474a;
import android.support.v4.view.p025a.C0489c;
import android.support.v4.view.p025a.C0489c.C0488m;
import android.support.v4.view.p025a.C0512k;
import android.support.v7.widget.RecyclerView.C0761i;
import android.support.v7.widget.RecyclerView.C0763h;
import android.support.v7.widget.RecyclerView.C0763h.C0788a;
import android.support.v7.widget.RecyclerView.C0793n;
import android.support.v7.widget.RecyclerView.C0798r;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends C0763h {
    private final Runnable f1977A = new C08091(this);
    af f1978a;
    af f1979b;
    boolean f1980c = false;
    int f1981d = -1;
    int f1982e = Integer.MIN_VALUE;
    LazySpanLookup f1983f = new LazySpanLookup();
    private int f1984g = -1;
    private C0814c[] f1985h;
    private int f1986i;
    private int f1987j;
    private final C0907y f1988k;
    private boolean f1989l = false;
    private BitSet f1990m;
    private int f1991n = 2;
    private boolean f1992o;
    private boolean f1993t;
    private SavedState f1994u;
    private int f1995v;
    private final Rect f1996w = new Rect();
    private final C0812a f1997x = new C0812a();
    private boolean f1998y = false;
    private boolean f1999z = true;

    class C08091 implements Runnable {
        final /* synthetic */ StaggeredGridLayoutManager f1947a;

        C08091(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f1947a = staggeredGridLayoutManager;
        }

        public void run() {
            this.f1947a.m3943I();
        }
    }

    static class LazySpanLookup {
        int[] f1952a;
        List<FullSpanItem> f1953b;

        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new C08101();
            int f1948a;
            int f1949b;
            int[] f1950c;
            boolean f1951d;

            static class C08101 implements Creator<FullSpanItem> {
                C08101() {
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return m3897a(parcel);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m3898a(i);
                }

                public FullSpanItem m3897a(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public FullSpanItem[] m3898a(int i) {
                    return new FullSpanItem[i];
                }
            }

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.f1948a = parcel.readInt();
                this.f1949b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f1951d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f1950c = new int[readInt];
                    parcel.readIntArray(this.f1950c);
                }
            }

            int m3899a(int i) {
                return this.f1950c == null ? 0 : this.f1950c[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1948a);
                parcel.writeInt(this.f1949b);
                parcel.writeInt(this.f1951d ? 1 : 0);
                if (this.f1950c == null || this.f1950c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f1950c.length);
                parcel.writeIntArray(this.f1950c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1948a + ", mGapDir=" + this.f1949b + ", mHasUnwantedGapAfter=" + this.f1951d + ", mGapPerSpan=" + Arrays.toString(this.f1950c) + '}';
            }
        }

        LazySpanLookup() {
        }

        int m3903a(int i) {
            if (this.f1953b != null) {
                for (int size = this.f1953b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f1953b.get(size)).f1948a >= i) {
                        this.f1953b.remove(size);
                    }
                }
            }
            return m3909b(i);
        }

        int m3909b(int i) {
            if (this.f1952a == null || i >= this.f1952a.length) {
                return -1;
            }
            int g = m3902g(i);
            if (g == -1) {
                Arrays.fill(this.f1952a, i, this.f1952a.length, -1);
                return this.f1952a.length;
            }
            Arrays.fill(this.f1952a, i, g + 1, -1);
            return g + 1;
        }

        int m3911c(int i) {
            if (this.f1952a == null || i >= this.f1952a.length) {
                return -1;
            }
            return this.f1952a[i];
        }

        void m3907a(int i, C0814c c0814c) {
            m3913e(i);
            this.f1952a[i] = c0814c.f1974d;
        }

        int m3912d(int i) {
            int length = this.f1952a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void m3913e(int i) {
            if (this.f1952a == null) {
                this.f1952a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f1952a, -1);
            } else if (i >= this.f1952a.length) {
                Object obj = this.f1952a;
                this.f1952a = new int[m3912d(i)];
                System.arraycopy(obj, 0, this.f1952a, 0, obj.length);
                Arrays.fill(this.f1952a, obj.length, this.f1952a.length, -1);
            }
        }

        void m3905a() {
            if (this.f1952a != null) {
                Arrays.fill(this.f1952a, -1);
            }
            this.f1953b = null;
        }

        void m3906a(int i, int i2) {
            if (this.f1952a != null && i < this.f1952a.length) {
                m3913e(i + i2);
                System.arraycopy(this.f1952a, i + i2, this.f1952a, i, (this.f1952a.length - i) - i2);
                Arrays.fill(this.f1952a, this.f1952a.length - i2, this.f1952a.length, -1);
                m3900c(i, i2);
            }
        }

        private void m3900c(int i, int i2) {
            if (this.f1953b != null) {
                int i3 = i + i2;
                for (int size = this.f1953b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f1953b.get(size);
                    if (fullSpanItem.f1948a >= i) {
                        if (fullSpanItem.f1948a < i3) {
                            this.f1953b.remove(size);
                        } else {
                            fullSpanItem.f1948a -= i2;
                        }
                    }
                }
            }
        }

        void m3910b(int i, int i2) {
            if (this.f1952a != null && i < this.f1952a.length) {
                m3913e(i + i2);
                System.arraycopy(this.f1952a, i, this.f1952a, i + i2, (this.f1952a.length - i) - i2);
                Arrays.fill(this.f1952a, i, i + i2, -1);
                m3901d(i, i2);
            }
        }

        private void m3901d(int i, int i2) {
            if (this.f1953b != null) {
                for (int size = this.f1953b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f1953b.get(size);
                    if (fullSpanItem.f1948a >= i) {
                        fullSpanItem.f1948a += i2;
                    }
                }
            }
        }

        private int m3902g(int i) {
            if (this.f1953b == null) {
                return -1;
            }
            FullSpanItem f = m3914f(i);
            if (f != null) {
                this.f1953b.remove(f);
            }
            int size = this.f1953b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((FullSpanItem) this.f1953b.get(i2)).f1948a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (FullSpanItem) this.f1953b.get(i2);
            this.f1953b.remove(i2);
            return f.f1948a;
        }

        public void m3908a(FullSpanItem fullSpanItem) {
            if (this.f1953b == null) {
                this.f1953b = new ArrayList();
            }
            int size = this.f1953b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f1953b.get(i);
                if (fullSpanItem2.f1948a == fullSpanItem.f1948a) {
                    this.f1953b.remove(i);
                }
                if (fullSpanItem2.f1948a >= fullSpanItem.f1948a) {
                    this.f1953b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f1953b.add(fullSpanItem);
        }

        public FullSpanItem m3914f(int i) {
            if (this.f1953b == null) {
                return null;
            }
            for (int size = this.f1953b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1953b.get(size);
                if (fullSpanItem.f1948a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem m3904a(int i, int i2, int i3, boolean z) {
            if (this.f1953b == null) {
                return null;
            }
            int size = this.f1953b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1953b.get(i4);
                if (fullSpanItem.f1948a >= i2) {
                    return null;
                }
                if (fullSpanItem.f1948a >= i) {
                    if (i3 == 0 || fullSpanItem.f1949b == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.f1951d) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C08111();
        int f1954a;
        int f1955b;
        int f1956c;
        int[] f1957d;
        int f1958e;
        int[] f1959f;
        List<FullSpanItem> f1960g;
        boolean f1961h;
        boolean f1962i;
        boolean f1963j;

        static class C08111 implements Creator<SavedState> {
            C08111() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3915a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3916a(i);
            }

            public SavedState m3915a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m3916a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.f1954a = parcel.readInt();
            this.f1955b = parcel.readInt();
            this.f1956c = parcel.readInt();
            if (this.f1956c > 0) {
                this.f1957d = new int[this.f1956c];
                parcel.readIntArray(this.f1957d);
            }
            this.f1958e = parcel.readInt();
            if (this.f1958e > 0) {
                this.f1959f = new int[this.f1958e];
                parcel.readIntArray(this.f1959f);
            }
            this.f1961h = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f1962i = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f1963j = z2;
            this.f1960g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f1956c = savedState.f1956c;
            this.f1954a = savedState.f1954a;
            this.f1955b = savedState.f1955b;
            this.f1957d = savedState.f1957d;
            this.f1958e = savedState.f1958e;
            this.f1959f = savedState.f1959f;
            this.f1961h = savedState.f1961h;
            this.f1962i = savedState.f1962i;
            this.f1963j = savedState.f1963j;
            this.f1960g = savedState.f1960g;
        }

        void m3917a() {
            this.f1957d = null;
            this.f1956c = 0;
            this.f1958e = 0;
            this.f1959f = null;
            this.f1960g = null;
        }

        void m3918b() {
            this.f1957d = null;
            this.f1956c = 0;
            this.f1954a = -1;
            this.f1955b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.f1954a);
            parcel.writeInt(this.f1955b);
            parcel.writeInt(this.f1956c);
            if (this.f1956c > 0) {
                parcel.writeIntArray(this.f1957d);
            }
            parcel.writeInt(this.f1958e);
            if (this.f1958e > 0) {
                parcel.writeIntArray(this.f1959f);
            }
            if (this.f1961h) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.f1962i) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.f1963j) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.f1960g);
        }
    }

    private class C0812a {
        int f1964a;
        int f1965b;
        boolean f1966c;
        boolean f1967d;
        final /* synthetic */ StaggeredGridLayoutManager f1968e;

        private C0812a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f1968e = staggeredGridLayoutManager;
        }

        void m3919a() {
            this.f1964a = -1;
            this.f1965b = Integer.MIN_VALUE;
            this.f1966c = false;
            this.f1967d = false;
        }

        void m3921b() {
            this.f1965b = this.f1966c ? this.f1968e.f1978a.mo658d() : this.f1968e.f1978a.mo656c();
        }

        void m3920a(int i) {
            if (this.f1966c) {
                this.f1965b = this.f1968e.f1978a.mo658d() - i;
            } else {
                this.f1965b = this.f1968e.f1978a.mo656c() + i;
            }
        }
    }

    public static class C0813b extends C0761i {
        C0814c f1969e;
        boolean f1970f;

        public C0813b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0813b(int i, int i2) {
            super(i, i2);
        }

        public C0813b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0813b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean m3922a() {
            return this.f1970f;
        }

        public final int m3923b() {
            if (this.f1969e == null) {
                return -1;
            }
            return this.f1969e.f1974d;
        }
    }

    class C0814c {
        int f1971a;
        int f1972b;
        int f1973c;
        final int f1974d;
        final /* synthetic */ StaggeredGridLayoutManager f1975e;
        private ArrayList<View> f1976f;

        private C0814c(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.f1975e = staggeredGridLayoutManager;
            this.f1976f = new ArrayList();
            this.f1971a = Integer.MIN_VALUE;
            this.f1972b = Integer.MIN_VALUE;
            this.f1973c = 0;
            this.f1974d = i;
        }

        int m3925a(int i) {
            if (this.f1971a != Integer.MIN_VALUE) {
                return this.f1971a;
            }
            if (this.f1976f.size() == 0) {
                return i;
            }
            m3927a();
            return this.f1971a;
        }

        void m3927a() {
            View view = (View) this.f1976f.get(0);
            C0813b c = m3933c(view);
            this.f1971a = this.f1975e.f1978a.mo653a(view);
            if (c.f1970f) {
                FullSpanItem f = this.f1975e.f1983f.m3914f(c.m3235e());
                if (f != null && f.f1949b == -1) {
                    this.f1971a -= f.m3899a(this.f1974d);
                }
            }
        }

        int m3930b() {
            if (this.f1971a != Integer.MIN_VALUE) {
                return this.f1971a;
            }
            m3927a();
            return this.f1971a;
        }

        int m3931b(int i) {
            if (this.f1972b != Integer.MIN_VALUE) {
                return this.f1972b;
            }
            if (this.f1976f.size() == 0) {
                return i;
            }
            m3934c();
            return this.f1972b;
        }

        void m3934c() {
            View view = (View) this.f1976f.get(this.f1976f.size() - 1);
            C0813b c = m3933c(view);
            this.f1972b = this.f1975e.f1978a.mo655b(view);
            if (c.f1970f) {
                FullSpanItem f = this.f1975e.f1983f.m3914f(c.m3235e());
                if (f != null && f.f1949b == 1) {
                    this.f1972b = f.m3899a(this.f1974d) + this.f1972b;
                }
            }
        }

        int m3936d() {
            if (this.f1972b != Integer.MIN_VALUE) {
                return this.f1972b;
            }
            m3934c();
            return this.f1972b;
        }

        void m3928a(View view) {
            C0813b c = m3933c(view);
            c.f1969e = this;
            this.f1976f.add(0, view);
            this.f1971a = Integer.MIN_VALUE;
            if (this.f1976f.size() == 1) {
                this.f1972b = Integer.MIN_VALUE;
            }
            if (c.m3233c() || c.m3234d()) {
                this.f1973c += this.f1975e.f1978a.mo657c(view);
            }
        }

        void m3932b(View view) {
            C0813b c = m3933c(view);
            c.f1969e = this;
            this.f1976f.add(view);
            this.f1972b = Integer.MIN_VALUE;
            if (this.f1976f.size() == 1) {
                this.f1971a = Integer.MIN_VALUE;
            }
            if (c.m3233c() || c.m3234d()) {
                this.f1973c += this.f1975e.f1978a.mo657c(view);
            }
        }

        void m3929a(boolean z, int i) {
            int b;
            if (z) {
                b = m3931b(Integer.MIN_VALUE);
            } else {
                b = m3925a(Integer.MIN_VALUE);
            }
            m3938e();
            if (b != Integer.MIN_VALUE) {
                if (z && b < this.f1975e.f1978a.mo658d()) {
                    return;
                }
                if (z || b <= this.f1975e.f1978a.mo656c()) {
                    if (i != Integer.MIN_VALUE) {
                        b += i;
                    }
                    this.f1972b = b;
                    this.f1971a = b;
                }
            }
        }

        void m3938e() {
            this.f1976f.clear();
            m3939f();
            this.f1973c = 0;
        }

        void m3939f() {
            this.f1971a = Integer.MIN_VALUE;
            this.f1972b = Integer.MIN_VALUE;
        }

        void m3935c(int i) {
            this.f1971a = i;
            this.f1972b = i;
        }

        void m3940g() {
            int size = this.f1976f.size();
            View view = (View) this.f1976f.remove(size - 1);
            C0813b c = m3933c(view);
            c.f1969e = null;
            if (c.m3233c() || c.m3234d()) {
                this.f1973c -= this.f1975e.f1978a.mo657c(view);
            }
            if (size == 1) {
                this.f1971a = Integer.MIN_VALUE;
            }
            this.f1972b = Integer.MIN_VALUE;
        }

        void m3941h() {
            View view = (View) this.f1976f.remove(0);
            C0813b c = m3933c(view);
            c.f1969e = null;
            if (this.f1976f.size() == 0) {
                this.f1972b = Integer.MIN_VALUE;
            }
            if (c.m3233c() || c.m3234d()) {
                this.f1973c -= this.f1975e.f1978a.mo657c(view);
            }
            this.f1971a = Integer.MIN_VALUE;
        }

        public int m3942i() {
            return this.f1973c;
        }

        C0813b m3933c(View view) {
            return (C0813b) view.getLayoutParams();
        }

        void m3937d(int i) {
            if (this.f1971a != Integer.MIN_VALUE) {
                this.f1971a += i;
            }
            if (this.f1972b != Integer.MIN_VALUE) {
                this.f1972b += i;
            }
        }

        public View m3926a(int i, int i2) {
            View view = null;
            int size;
            View view2;
            if (i2 == -1) {
                size = this.f1976f.size();
                int i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.f1976f.get(i3);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    boolean z;
                    if (this.f1975e.m3330d(view2) > i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z != this.f1975e.f1989l) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            size = this.f1976f.size() - 1;
            while (size >= 0) {
                view2 = (View) this.f1976f.get(size);
                if (!view2.isFocusable()) {
                    break;
                }
                Object obj;
                if (this.f1975e.m3330d(view2) > i) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != (!this.f1975e.f1989l ? 1 : null)) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        C0788a a = C0763h.m3244a(context, attributeSet, i, i2);
        m4013b(a.f1773a);
        m3995a(a.f1774b);
        m4007a(a.f1775c);
        if (this.f1991n == 0) {
            z = false;
        }
        m3327c(z);
        this.f1988k = new C0907y();
        m3975m();
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.f1986i = i2;
        m3995a(i);
        if (this.f1991n == 0) {
            z = false;
        }
        m3327c(z);
        this.f1988k = new C0907y();
        m3975m();
    }

    private void m3975m() {
        this.f1978a = af.m4167a(this, this.f1986i);
        this.f1979b = af.m4167a(this, 1 - this.f1986i);
    }

    private boolean m3943I() {
        if (m3367t() == 0 || this.f1991n == 0 || !m3362o()) {
            return false;
        }
        int L;
        int M;
        if (this.f1980c) {
            L = m3946L();
            M = m3947M();
        } else {
            L = m3947M();
            M = m3946L();
        }
        if (L == 0 && m4028f() != null) {
            this.f1983f.m3905a();
            m3260G();
            m3360n();
            return true;
        } else if (!this.f1998y) {
            return false;
        } else {
            int i = this.f1980c ? -1 : 1;
            FullSpanItem a = this.f1983f.m3904a(L, M + 1, i, true);
            if (a == null) {
                this.f1998y = false;
                this.f1983f.m3903a(M + 1);
                return false;
            }
            FullSpanItem a2 = this.f1983f.m3904a(L, a.f1948a, i * -1, true);
            if (a2 == null) {
                this.f1983f.m3903a(a.f1948a);
            } else {
                this.f1983f.m3903a(a2.f1948a + 1);
            }
            m3260G();
            m3360n();
            return true;
        }
    }

    public void mo638k(int i) {
        if (i == 0) {
            m3943I();
        }
    }

    public void mo578a(RecyclerView recyclerView, C0793n c0793n) {
        m3304a(this.f1977A);
        for (int i = 0; i < this.f1984g; i++) {
            this.f1985h[i].m3938e();
        }
    }

    View m4028f() {
        int i;
        int i2;
        int t = m3367t() - 1;
        BitSet bitSet = new BitSet(this.f1984g);
        bitSet.set(0, this.f1984g, true);
        boolean z = (this.f1986i == 1 && m4031h()) ? true : true;
        if (this.f1980c) {
            i = -1;
        } else {
            i = t + 1;
            t = 0;
        }
        if (t < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = t;
        while (i3 != i) {
            View h = m3349h(i3);
            C0813b c0813b = (C0813b) h.getLayoutParams();
            if (bitSet.get(c0813b.f1969e.f1974d)) {
                if (m3960a(c0813b.f1969e)) {
                    return h;
                }
                bitSet.clear(c0813b.f1969e.f1974d);
            }
            if (!(c0813b.f1970f || i3 + i2 == i)) {
                boolean z2;
                View h2 = m3349h(i3 + i2);
                int b;
                if (this.f1980c) {
                    t = this.f1978a.mo655b(h);
                    b = this.f1978a.mo655b(h2);
                    if (t < b) {
                        return h;
                    }
                    if (t == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    t = this.f1978a.mo653a(h);
                    b = this.f1978a.mo653a(h2);
                    if (t > b) {
                        return h;
                    }
                    if (t == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if (c0813b.f1969e.f1974d - ((C0813b) h2.getLayoutParams()).f1969e.f1974d < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 != (z >= false)) {
                        return h;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    private boolean m3960a(C0814c c0814c) {
        boolean z = true;
        if (this.f1980c) {
            if (c0814c.m3936d() < this.f1978a.mo658d()) {
                return !c0814c.m3933c((View) c0814c.f1976f.get(c0814c.f1976f.size() + -1)).f1970f;
            }
        } else if (c0814c.m3930b() > this.f1978a.mo656c()) {
            if (c0814c.m3933c((View) c0814c.f1976f.get(0)).f1970f) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void m3995a(int i) {
        mo580a(null);
        if (i != this.f1984g) {
            m4030g();
            this.f1984g = i;
            this.f1990m = new BitSet(this.f1984g);
            this.f1985h = new C0814c[this.f1984g];
            for (int i2 = 0; i2 < this.f1984g; i2++) {
                this.f1985h[i2] = new C0814c(i2);
            }
            m3360n();
        }
    }

    public void m4013b(int i) {
        if (i == 0 || i == 1) {
            mo580a(null);
            if (i != this.f1986i) {
                this.f1986i = i;
                af afVar = this.f1978a;
                this.f1978a = this.f1979b;
                this.f1979b = afVar;
                m3360n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void m4007a(boolean z) {
        mo580a(null);
        if (!(this.f1994u == null || this.f1994u.f1961h == z)) {
            this.f1994u.f1961h = z;
        }
        this.f1989l = z;
        m3360n();
    }

    public void mo580a(String str) {
        if (this.f1994u == null) {
            super.mo580a(str);
        }
    }

    public void m4030g() {
        this.f1983f.m3905a();
        m3360n();
    }

    private void m3944J() {
        boolean z = true;
        if (this.f1986i == 1 || !m4031h()) {
            this.f1980c = this.f1989l;
            return;
        }
        if (this.f1989l) {
            z = false;
        }
        this.f1980c = z;
    }

    boolean m4031h() {
        return m3365r() == 1;
    }

    public void mo600a(Rect rect, int i, int i2) {
        int A = m3254A() + m3372y();
        int z = m3373z() + m3255B();
        if (this.f1986i == 1) {
            z = C0763h.m3242a(i2, z + rect.height(), m3258E());
            A = C0763h.m3242a(i, A + (this.f1987j * this.f1984g), m3257D());
        } else {
            A = C0763h.m3242a(i, A + rect.width(), m3257D());
            z = C0763h.m3242a(i2, z + (this.f1987j * this.f1984g), m3258E());
        }
        m3333d(A, z);
    }

    public void mo587c(C0793n c0793n, C0798r c0798r) {
        m3953a(c0793n, c0798r, true);
    }

    private void m3953a(C0793n c0793n, C0798r c0798r, boolean z) {
        C0812a c0812a = this.f1997x;
        c0812a.m3919a();
        if (!(this.f1994u == null && this.f1981d == -1) && c0798r.m3687e() == 0) {
            m3321c(c0793n);
            return;
        }
        boolean z2;
        if (this.f1994u != null) {
            m3955a(c0812a);
        } else {
            m3944J();
            c0812a.f1966c = this.f1980c;
        }
        m3999a(c0798r, c0812a);
        if (this.f1994u == null && !(c0812a.f1966c == this.f1992o && m4031h() == this.f1993t)) {
            this.f1983f.m3905a();
            c0812a.f1967d = true;
        }
        if (m3367t() > 0 && (this.f1994u == null || this.f1994u.f1956c < 1)) {
            int i;
            if (c0812a.f1967d) {
                for (i = 0; i < this.f1984g; i++) {
                    this.f1985h[i].m3938e();
                    if (c0812a.f1965b != Integer.MIN_VALUE) {
                        this.f1985h[i].m3935c(c0812a.f1965b);
                    }
                }
            } else {
                for (i = 0; i < this.f1984g; i++) {
                    this.f1985h[i].m3929a(this.f1980c, c0812a.f1965b);
                }
            }
        }
        m3274a(c0793n);
        this.f1988k.f2455a = false;
        this.f1998y = false;
        m4025e(this.f1979b.mo661f());
        m3951a(c0812a.f1964a, c0798r);
        if (c0812a.f1966c) {
            m3973l(-1);
            m3948a(c0793n, this.f1988k, c0798r);
            m3973l(1);
            this.f1988k.f2457c = c0812a.f1964a + this.f1988k.f2458d;
            m3948a(c0793n, this.f1988k, c0798r);
        } else {
            m3973l(1);
            m3948a(c0793n, this.f1988k, c0798r);
            m3973l(-1);
            this.f1988k.f2457c = c0812a.f1964a + this.f1988k.f2458d;
            m3948a(c0793n, this.f1988k, c0798r);
        }
        m3945K();
        if (m3367t() > 0) {
            if (this.f1980c) {
                m3964b(c0793n, c0798r, true);
                m3968c(c0793n, c0798r, false);
            } else {
                m3968c(c0793n, c0798r, true);
                m3964b(c0793n, c0798r, false);
            }
        }
        if (!z || c0798r.m3683a()) {
            z2 = false;
        } else {
            if (this.f1991n == 0 || m3367t() <= 0 || (!this.f1998y && m4028f() == null)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                m3304a(this.f1977A);
                if (m3943I()) {
                    z2 = true;
                    this.f1981d = -1;
                    this.f1982e = Integer.MIN_VALUE;
                }
            }
            z2 = false;
            this.f1981d = -1;
            this.f1982e = Integer.MIN_VALUE;
        }
        this.f1992o = c0812a.f1966c;
        this.f1993t = m4031h();
        this.f1994u = null;
        if (z2) {
            m3953a(c0793n, c0798r, false);
        }
    }

    private void m3945K() {
        if (this.f1979b.mo663h() != 1073741824) {
            float f = 0.0f;
            int t = m3367t();
            int i = 0;
            while (i < t) {
                float f2;
                View h = m3349h(i);
                float c = (float) this.f1979b.mo657c(h);
                if (c < f) {
                    f2 = f;
                } else {
                    if (((C0813b) h.getLayoutParams()).m3922a()) {
                        f2 = (1.0f * c) / ((float) this.f1984g);
                    } else {
                        f2 = c;
                    }
                    f2 = Math.max(f, f2);
                }
                i++;
                f = f2;
            }
            i = this.f1987j;
            int round = Math.round(((float) this.f1984g) * f);
            if (this.f1979b.mo663h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f1979b.mo661f());
            }
            m4025e(round);
            if (this.f1987j != i) {
                for (int i2 = 0; i2 < t; i2++) {
                    View h2 = m3349h(i2);
                    C0813b c0813b = (C0813b) h2.getLayoutParams();
                    if (!c0813b.f1970f) {
                        if (m4031h() && this.f1986i == 1) {
                            h2.offsetLeftAndRight(((-((this.f1984g - 1) - c0813b.f1969e.f1974d)) * this.f1987j) - ((-((this.f1984g - 1) - c0813b.f1969e.f1974d)) * i));
                        } else {
                            int i3 = c0813b.f1969e.f1974d * this.f1987j;
                            round = c0813b.f1969e.f1974d * i;
                            if (this.f1986i == 1) {
                                h2.offsetLeftAndRight(i3 - round);
                            } else {
                                h2.offsetTopAndBottom(i3 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private void m3955a(C0812a c0812a) {
        if (this.f1994u.f1956c > 0) {
            if (this.f1994u.f1956c == this.f1984g) {
                for (int i = 0; i < this.f1984g; i++) {
                    this.f1985h[i].m3938e();
                    int i2 = this.f1994u.f1957d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.f1994u.f1962i) {
                            i2 += this.f1978a.mo658d();
                        } else {
                            i2 += this.f1978a.mo656c();
                        }
                    }
                    this.f1985h[i].m3935c(i2);
                }
            } else {
                this.f1994u.m3917a();
                this.f1994u.f1954a = this.f1994u.f1955b;
            }
        }
        this.f1993t = this.f1994u.f1963j;
        m4007a(this.f1994u.f1961h);
        m3944J();
        if (this.f1994u.f1954a != -1) {
            this.f1981d = this.f1994u.f1954a;
            c0812a.f1966c = this.f1994u.f1962i;
        } else {
            c0812a.f1966c = this.f1980c;
        }
        if (this.f1994u.f1958e > 1) {
            this.f1983f.f1952a = this.f1994u.f1959f;
            this.f1983f.f1953b = this.f1994u.f1960g;
        }
    }

    void m3999a(C0798r c0798r, C0812a c0812a) {
        if (!m4016b(c0798r, c0812a) && !m3969c(c0798r, c0812a)) {
            c0812a.m3921b();
            c0812a.f1964a = 0;
        }
    }

    private boolean m3969c(C0798r c0798r, C0812a c0812a) {
        c0812a.f1964a = this.f1992o ? m3986v(c0798r.m3687e()) : m3985u(c0798r.m3687e());
        c0812a.f1965b = Integer.MIN_VALUE;
        return true;
    }

    boolean m4016b(C0798r c0798r, C0812a c0812a) {
        boolean z = false;
        if (c0798r.m3683a() || this.f1981d == -1) {
            return false;
        }
        if (this.f1981d < 0 || this.f1981d >= c0798r.m3687e()) {
            this.f1981d = -1;
            this.f1982e = Integer.MIN_VALUE;
            return false;
        } else if (this.f1994u == null || this.f1994u.f1954a == -1 || this.f1994u.f1956c < 1) {
            View c = mo586c(this.f1981d);
            if (c != null) {
                c0812a.f1964a = this.f1980c ? m3946L() : m3947M();
                if (this.f1982e != Integer.MIN_VALUE) {
                    if (c0812a.f1966c) {
                        c0812a.f1965b = (this.f1978a.mo658d() - this.f1982e) - this.f1978a.mo655b(c);
                        return true;
                    }
                    c0812a.f1965b = (this.f1978a.mo656c() + this.f1982e) - this.f1978a.mo653a(c);
                    return true;
                } else if (this.f1978a.mo657c(c) > this.f1978a.mo661f()) {
                    c0812a.f1965b = c0812a.f1966c ? this.f1978a.mo658d() : this.f1978a.mo656c();
                    return true;
                } else {
                    int a = this.f1978a.mo653a(c) - this.f1978a.mo656c();
                    if (a < 0) {
                        c0812a.f1965b = -a;
                        return true;
                    }
                    a = this.f1978a.mo658d() - this.f1978a.mo655b(c);
                    if (a < 0) {
                        c0812a.f1965b = a;
                        return true;
                    }
                    c0812a.f1965b = Integer.MIN_VALUE;
                    return true;
                }
            }
            c0812a.f1964a = this.f1981d;
            if (this.f1982e == Integer.MIN_VALUE) {
                if (m3984t(c0812a.f1964a) == 1) {
                    z = true;
                }
                c0812a.f1966c = z;
                c0812a.m3921b();
            } else {
                c0812a.m3920a(this.f1982e);
            }
            c0812a.f1967d = true;
            return true;
        } else {
            c0812a.f1965b = Integer.MIN_VALUE;
            c0812a.f1964a = this.f1981d;
            return true;
        }
    }

    void m4025e(int i) {
        this.f1987j = i / this.f1984g;
        this.f1995v = MeasureSpec.makeMeasureSpec(i, this.f1979b.mo663h());
    }

    public boolean mo583b() {
        return this.f1994u == null;
    }

    public int mo582b(C0798r c0798r) {
        return m3949a(c0798r);
    }

    private int m3949a(C0798r c0798r) {
        boolean z = false;
        if (m3367t() == 0) {
            return 0;
        }
        af afVar = this.f1978a;
        View a = m3994a(!this.f1999z, true);
        if (!this.f1999z) {
            z = true;
        }
        return aj.m4223a(c0798r, afVar, a, m4012b(z, true), this, this.f1999z, this.f1980c);
    }

    public int mo584c(C0798r c0798r) {
        return m3949a(c0798r);
    }

    public int mo588d(C0798r c0798r) {
        return m3971h(c0798r);
    }

    private int m3971h(C0798r c0798r) {
        boolean z = false;
        if (m3367t() == 0) {
            return 0;
        }
        af afVar = this.f1978a;
        View a = m3994a(!this.f1999z, true);
        if (!this.f1999z) {
            z = true;
        }
        return aj.m4222a(c0798r, afVar, a, m4012b(z, true), this, this.f1999z);
    }

    public int mo591e(C0798r c0798r) {
        return m3971h(c0798r);
    }

    public int mo593f(C0798r c0798r) {
        return m3972i(c0798r);
    }

    private int m3972i(C0798r c0798r) {
        boolean z = false;
        if (m3367t() == 0) {
            return 0;
        }
        af afVar = this.f1978a;
        View a = m3994a(!this.f1999z, true);
        if (!this.f1999z) {
            z = true;
        }
        return aj.m4224b(c0798r, afVar, a, m4012b(z, true), this, this.f1999z);
    }

    public int mo594g(C0798r c0798r) {
        return m3972i(c0798r);
    }

    private void m3959a(View view, C0813b c0813b, boolean z) {
        if (c0813b.f1970f) {
            if (this.f1986i == 1) {
                m3957a(view, this.f1995v, C0763h.m3243a(m3371x(), m3369v(), 0, c0813b.height, true), z);
            } else {
                m3957a(view, C0763h.m3243a(m3370w(), m3368u(), 0, c0813b.width, true), this.f1995v, z);
            }
        } else if (this.f1986i == 1) {
            m3957a(view, C0763h.m3243a(this.f1987j, m3368u(), 0, c0813b.width, false), C0763h.m3243a(m3371x(), m3369v(), 0, c0813b.height, true), z);
        } else {
            m3957a(view, C0763h.m3243a(m3370w(), m3368u(), 0, c0813b.width, true), C0763h.m3243a(this.f1987j, m3369v(), 0, c0813b.height, false), z);
        }
    }

    private void m3957a(View view, int i, int i2, boolean z) {
        m3289a(view, this.f1996w);
        C0813b c0813b = (C0813b) view.getLayoutParams();
        int b = m3962b(i, c0813b.leftMargin + this.f1996w.left, c0813b.rightMargin + this.f1996w.right);
        int b2 = m3962b(i2, c0813b.topMargin + this.f1996w.top, c0813b.bottomMargin + this.f1996w.bottom);
        if (z ? m3302a(view, b, b2, (C0761i) c0813b) : m3316b(view, b, b2, c0813b)) {
            view.measure(b, b2);
        }
    }

    private int m3962b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    public void mo577a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f1994u = (SavedState) parcelable;
            m3360n();
        }
    }

    public Parcelable mo585c() {
        if (this.f1994u != null) {
            return new SavedState(this.f1994u);
        }
        SavedState savedState = new SavedState();
        savedState.f1961h = this.f1989l;
        savedState.f1962i = this.f1992o;
        savedState.f1963j = this.f1993t;
        if (this.f1983f == null || this.f1983f.f1952a == null) {
            savedState.f1958e = 0;
        } else {
            savedState.f1959f = this.f1983f.f1952a;
            savedState.f1958e = savedState.f1959f.length;
            savedState.f1960g = this.f1983f.f1953b;
        }
        if (m3367t() > 0) {
            savedState.f1954a = this.f1992o ? m3946L() : m3947M();
            savedState.f1955b = m4032i();
            savedState.f1956c = this.f1984g;
            savedState.f1957d = new int[this.f1984g];
            for (int i = 0; i < this.f1984g; i++) {
                int b;
                if (this.f1992o) {
                    b = this.f1985h[i].m3931b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f1978a.mo658d();
                    }
                } else {
                    b = this.f1985h[i].m3925a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f1978a.mo656c();
                    }
                }
                savedState.f1957d[i] = b;
            }
        } else {
            savedState.f1954a = -1;
            savedState.f1955b = -1;
            savedState.f1956c = 0;
        }
        return savedState;
    }

    public void mo603a(C0793n c0793n, C0798r c0798r, View view, C0489c c0489c) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0813b) {
            C0813b c0813b = (C0813b) layoutParams;
            if (this.f1986i == 0) {
                c0489c.m1950b(C0488m.m1940a(c0813b.m3923b(), c0813b.f1970f ? this.f1984g : 1, -1, -1, c0813b.f1970f, false));
                return;
            } else {
                c0489c.m1950b(C0488m.m1940a(-1, -1, c0813b.m3923b(), c0813b.f1970f ? this.f1984g : 1, c0813b.f1970f, false));
                return;
            }
        }
        super.m3290a(view, c0489c);
    }

    public void mo579a(AccessibilityEvent accessibilityEvent) {
        super.mo579a(accessibilityEvent);
        if (m3367t() > 0) {
            C0512k a = C0474a.m1857a(accessibilityEvent);
            View a2 = m3994a(false, true);
            View b = m4012b(false, true);
            if (a2 != null && b != null) {
                int d = m3330d(a2);
                int d2 = m3330d(b);
                if (d < d2) {
                    a.m2044b(d);
                    a.m2045c(d2);
                    return;
                }
                a.m2044b(d2);
                a.m2045c(d);
            }
        }
    }

    int m4032i() {
        View b = this.f1980c ? m4012b(true, true) : m3994a(true, true);
        return b == null ? -1 : m3330d(b);
    }

    public int mo596a(C0793n c0793n, C0798r c0798r) {
        if (this.f1986i == 0) {
            return this.f1984g;
        }
        return super.mo596a(c0793n, c0798r);
    }

    public int mo610b(C0793n c0793n, C0798r c0798r) {
        if (this.f1986i == 1) {
            return this.f1984g;
        }
        return super.mo610b(c0793n, c0798r);
    }

    View m3994a(boolean z, boolean z2) {
        int c = this.f1978a.mo656c();
        int d = this.f1978a.mo658d();
        int t = m3367t();
        View view = null;
        for (int i = 0; i < t; i++) {
            View h = m3349h(i);
            int a = this.f1978a.mo653a(h);
            if (this.f1978a.mo655b(h) > c && a < d) {
                if (a >= c || !z) {
                    return h;
                }
                if (z2 && view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    View m4012b(boolean z, boolean z2) {
        int c = this.f1978a.mo656c();
        int d = this.f1978a.mo658d();
        View view = null;
        for (int t = m3367t() - 1; t >= 0; t--) {
            View h = m3349h(t);
            int a = this.f1978a.mo653a(h);
            int b = this.f1978a.mo655b(h);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return h;
                }
                if (z2 && view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    private void m3964b(C0793n c0793n, C0798r c0798r, boolean z) {
        int q = m3980q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE) {
            q = this.f1978a.mo658d() - q;
            if (q > 0) {
                q -= -m4017c(-q, c0793n, c0798r);
                if (z && q > 0) {
                    this.f1978a.mo654a(q);
                }
            }
        }
    }

    private void m3968c(C0793n c0793n, C0798r c0798r, boolean z) {
        int p = m3978p(Integer.MAX_VALUE);
        if (p != Integer.MAX_VALUE) {
            p -= this.f1978a.mo656c();
            if (p > 0) {
                p -= m4017c(p, c0793n, c0798r);
                if (z && p > 0) {
                    this.f1978a.mo654a(-p);
                }
            }
        }
    }

    private void m3951a(int i, C0798r c0798r) {
        int c;
        int i2;
        C0907y c0907y;
        boolean z = false;
        this.f1988k.f2456b = 0;
        this.f1988k.f2457c = i;
        if (m3364q()) {
            c = c0798r.m3685c();
            if (c != -1) {
                if (this.f1980c == (c < i)) {
                    c = this.f1978a.mo661f();
                    i2 = 0;
                } else {
                    i2 = this.f1978a.mo661f();
                    c = 0;
                }
                if (m3363p()) {
                    this.f1988k.f2461g = c + this.f1978a.mo660e();
                    this.f1988k.f2460f = -i2;
                } else {
                    this.f1988k.f2460f = this.f1978a.mo656c() - i2;
                    this.f1988k.f2461g = c + this.f1978a.mo658d();
                }
                this.f1988k.f2462h = false;
                this.f1988k.f2455a = true;
                c0907y = this.f1988k;
                if (this.f1978a.mo663h() == 0 && this.f1978a.mo660e() == 0) {
                    z = true;
                }
                c0907y.f2463i = z;
            }
        }
        c = 0;
        i2 = 0;
        if (m3363p()) {
            this.f1988k.f2461g = c + this.f1978a.mo660e();
            this.f1988k.f2460f = -i2;
        } else {
            this.f1988k.f2460f = this.f1978a.mo656c() - i2;
            this.f1988k.f2461g = c + this.f1978a.mo658d();
        }
        this.f1988k.f2462h = false;
        this.f1988k.f2455a = true;
        c0907y = this.f1988k;
        z = true;
        c0907y.f2463i = z;
    }

    private void m3973l(int i) {
        int i2 = 1;
        this.f1988k.f2459e = i;
        C0907y c0907y = this.f1988k;
        if (this.f1980c != (i == -1)) {
            i2 = -1;
        }
        c0907y.f2458d = i2;
    }

    public void mo636i(int i) {
        super.mo636i(i);
        for (int i2 = 0; i2 < this.f1984g; i2++) {
            this.f1985h[i2].m3937d(i);
        }
    }

    public void mo637j(int i) {
        super.mo637j(i);
        for (int i2 = 0; i2 < this.f1984g; i2++) {
            this.f1985h[i2].m3937d(i);
        }
    }

    public void mo611b(RecyclerView recyclerView, int i, int i2) {
        m3967c(i, i2, 2);
    }

    public void mo605a(RecyclerView recyclerView, int i, int i2) {
        m3967c(i, i2, 1);
    }

    public void mo604a(RecyclerView recyclerView) {
        this.f1983f.m3905a();
        m3360n();
    }

    public void mo606a(RecyclerView recyclerView, int i, int i2, int i3) {
        m3967c(i, i2, 8);
    }

    public void mo607a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m3967c(i, i2, 4);
    }

    private void m3967c(int i, int i2, int i3) {
        int i4;
        int i5;
        int L = this.f1980c ? m3946L() : m3947M();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f1983f.m3909b(i5);
        switch (i3) {
            case 1:
                this.f1983f.m3910b(i, i2);
                break;
            case 2:
                this.f1983f.m3906a(i, i2);
                break;
            case 8:
                this.f1983f.m3906a(i, 1);
                this.f1983f.m3910b(i2, 1);
                break;
        }
        if (i4 > L) {
            if (i5 <= (this.f1980c ? m3947M() : m3946L())) {
                m3360n();
            }
        }
    }

    private int m3948a(C0793n c0793n, C0907y c0907y, C0798r c0798r) {
        int i;
        int d;
        int q;
        this.f1990m.set(0, this.f1984g, true);
        if (this.f1988k.f2463i) {
            if (c0907y.f2459e == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (c0907y.f2459e == 1) {
            i = c0907y.f2461g + c0907y.f2456b;
        } else {
            i = c0907y.f2460f - c0907y.f2456b;
        }
        m3970e(c0907y.f2459e, i);
        if (this.f1980c) {
            d = this.f1978a.mo658d();
        } else {
            d = this.f1978a.mo656c();
        }
        Object obj = null;
        while (c0907y.m4594a(c0798r) && (this.f1988k.f2463i || !this.f1990m.isEmpty())) {
            C0814c c0814c;
            int c;
            int c2;
            View a = c0907y.m4593a(c0793n);
            C0813b c0813b = (C0813b) a.getLayoutParams();
            int e = c0813b.m3235e();
            int c3 = this.f1983f.m3911c(e);
            Object obj2 = c3 == -1 ? 1 : null;
            if (obj2 != null) {
                C0814c a2 = c0813b.f1970f ? this.f1985h[0] : m3950a(c0907y);
                this.f1983f.m3907a(e, a2);
                c0814c = a2;
            } else {
                c0814c = this.f1985h[c3];
            }
            c0813b.f1969e = c0814c;
            if (c0907y.f2459e == 1) {
                m3313b(a);
            } else {
                m3314b(a, 0);
            }
            m3959a(a, c0813b, false);
            if (c0907y.f2459e == 1) {
                if (c0813b.f1970f) {
                    q = m3980q(d);
                } else {
                    q = c0814c.m3931b(d);
                }
                c = q + this.f1978a.mo657c(a);
                if (obj2 == null || !c0813b.f1970f) {
                    c3 = q;
                } else {
                    FullSpanItem m = m3974m(q);
                    m.f1949b = -1;
                    m.f1948a = e;
                    this.f1983f.m3908a(m);
                    c3 = q;
                }
            } else {
                if (c0813b.f1970f) {
                    q = m3978p(d);
                } else {
                    q = c0814c.m3925a(d);
                }
                c3 = q - this.f1978a.mo657c(a);
                if (obj2 != null && c0813b.f1970f) {
                    FullSpanItem n = m3976n(q);
                    n.f1949b = 1;
                    n.f1948a = e;
                    this.f1983f.m3908a(n);
                }
                c = q;
            }
            if (c0813b.f1970f && c0907y.f2458d == -1) {
                if (obj2 != null) {
                    this.f1998y = true;
                } else {
                    obj = c0907y.f2459e == 1 ? !m4035j() ? 1 : null : !m4037l() ? 1 : null;
                    if (obj != null) {
                        FullSpanItem f = this.f1983f.m3914f(e);
                        if (f != null) {
                            f.f1951d = true;
                        }
                        this.f1998y = true;
                    }
                }
            }
            m3958a(a, c0813b, c0907y);
            if (m4031h() && this.f1986i == 1) {
                q = c0813b.f1970f ? this.f1979b.mo658d() : this.f1979b.mo658d() - (((this.f1984g - 1) - c0814c.f1974d) * this.f1987j);
                c2 = q - this.f1979b.mo657c(a);
                e = q;
            } else {
                q = c0813b.f1970f ? this.f1979b.mo656c() : (c0814c.f1974d * this.f1987j) + this.f1979b.mo656c();
                e = q + this.f1979b.mo657c(a);
                c2 = q;
            }
            if (this.f1986i == 1) {
                m3965b(a, c2, c3, e, c);
            } else {
                m3965b(a, c3, c2, c, e);
            }
            if (c0813b.f1970f) {
                m3970e(this.f1988k.f2459e, i);
            } else {
                m3956a(c0814c, this.f1988k.f2459e, i);
            }
            m3954a(c0793n, this.f1988k);
            if (this.f1988k.f2462h && a.isFocusable()) {
                if (c0813b.f1970f) {
                    this.f1990m.clear();
                } else {
                    this.f1990m.set(c0814c.f1974d, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            m3954a(c0793n, this.f1988k);
        }
        if (this.f1988k.f2459e == -1) {
            q = this.f1978a.mo656c() - m3978p(this.f1978a.mo656c());
        } else {
            q = m3980q(this.f1978a.mo658d()) - this.f1978a.mo658d();
        }
        return q > 0 ? Math.min(c0907y.f2456b, q) : 0;
    }

    private FullSpanItem m3974m(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f1950c = new int[this.f1984g];
        for (int i2 = 0; i2 < this.f1984g; i2++) {
            fullSpanItem.f1950c[i2] = i - this.f1985h[i2].m3931b(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem m3976n(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f1950c = new int[this.f1984g];
        for (int i2 = 0; i2 < this.f1984g; i2++) {
            fullSpanItem.f1950c[i2] = this.f1985h[i2].m3925a(i) - i;
        }
        return fullSpanItem;
    }

    private void m3958a(View view, C0813b c0813b, C0907y c0907y) {
        if (c0907y.f2459e == 1) {
            if (c0813b.f1970f) {
                m3979p(view);
            } else {
                c0813b.f1969e.m3932b(view);
            }
        } else if (c0813b.f1970f) {
            m3981q(view);
        } else {
            c0813b.f1969e.m3928a(view);
        }
    }

    private void m3954a(C0793n c0793n, C0907y c0907y) {
        if (c0907y.f2455a && !c0907y.f2463i) {
            if (c0907y.f2456b == 0) {
                if (c0907y.f2459e == -1) {
                    m3963b(c0793n, c0907y.f2461g);
                } else {
                    m3952a(c0793n, c0907y.f2460f);
                }
            } else if (c0907y.f2459e == -1) {
                r0 = c0907y.f2460f - m3977o(c0907y.f2460f);
                if (r0 < 0) {
                    r0 = c0907y.f2461g;
                } else {
                    r0 = c0907y.f2461g - Math.min(r0, c0907y.f2456b);
                }
                m3963b(c0793n, r0);
            } else {
                r0 = m3982r(c0907y.f2461g) - c0907y.f2461g;
                if (r0 < 0) {
                    r0 = c0907y.f2460f;
                } else {
                    r0 = Math.min(r0, c0907y.f2456b) + c0907y.f2460f;
                }
                m3952a(c0793n, r0);
            }
        }
    }

    private void m3979p(View view) {
        for (int i = this.f1984g - 1; i >= 0; i--) {
            this.f1985h[i].m3932b(view);
        }
    }

    private void m3981q(View view) {
        for (int i = this.f1984g - 1; i >= 0; i--) {
            this.f1985h[i].m3928a(view);
        }
    }

    private void m3965b(View view, int i, int i2, int i3, int i4) {
        C0813b c0813b = (C0813b) view.getLayoutParams();
        m3287a(view, i + c0813b.leftMargin, i2 + c0813b.topMargin, i3 - c0813b.rightMargin, i4 - c0813b.bottomMargin);
    }

    private void m3970e(int i, int i2) {
        for (int i3 = 0; i3 < this.f1984g; i3++) {
            if (!this.f1985h[i3].f1976f.isEmpty()) {
                m3956a(this.f1985h[i3], i, i2);
            }
        }
    }

    private void m3956a(C0814c c0814c, int i, int i2) {
        int i3 = c0814c.m3942i();
        if (i == -1) {
            if (i3 + c0814c.m3930b() <= i2) {
                this.f1990m.set(c0814c.f1974d, false);
            }
        } else if (c0814c.m3936d() - i3 >= i2) {
            this.f1990m.set(c0814c.f1974d, false);
        }
    }

    private int m3977o(int i) {
        int a = this.f1985h[0].m3925a(i);
        for (int i2 = 1; i2 < this.f1984g; i2++) {
            int a2 = this.f1985h[i2].m3925a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int m3978p(int i) {
        int a = this.f1985h[0].m3925a(i);
        for (int i2 = 1; i2 < this.f1984g; i2++) {
            int a2 = this.f1985h[i2].m3925a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    boolean m4035j() {
        int b = this.f1985h[0].m3931b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1984g; i++) {
            if (this.f1985h[i].m3931b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    boolean m4037l() {
        int a = this.f1985h[0].m3925a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1984g; i++) {
            if (this.f1985h[i].m3925a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    private int m3980q(int i) {
        int b = this.f1985h[0].m3931b(i);
        for (int i2 = 1; i2 < this.f1984g; i2++) {
            int b2 = this.f1985h[i2].m3931b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private int m3982r(int i) {
        int b = this.f1985h[0].m3931b(i);
        for (int i2 = 1; i2 < this.f1984g; i2++) {
            int b2 = this.f1985h[i2].m3931b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private void m3952a(C0793n c0793n, int i) {
        while (m3367t() > 0) {
            View h = m3349h(0);
            if (this.f1978a.mo655b(h) <= i) {
                C0813b c0813b = (C0813b) h.getLayoutParams();
                if (c0813b.f1970f) {
                    int i2 = 0;
                    while (i2 < this.f1984g) {
                        if (this.f1985h[i2].f1976f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f1984g; i2++) {
                        this.f1985h[i2].m3941h();
                    }
                } else if (c0813b.f1969e.f1976f.size() != 1) {
                    c0813b.f1969e.m3941h();
                } else {
                    return;
                }
                m3291a(h, c0793n);
            } else {
                return;
            }
        }
    }

    private void m3963b(C0793n c0793n, int i) {
        int t = m3367t() - 1;
        while (t >= 0) {
            View h = m3349h(t);
            if (this.f1978a.mo653a(h) >= i) {
                C0813b c0813b = (C0813b) h.getLayoutParams();
                if (c0813b.f1970f) {
                    int i2 = 0;
                    while (i2 < this.f1984g) {
                        if (this.f1985h[i2].f1976f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f1984g; i2++) {
                        this.f1985h[i2].m3940g();
                    }
                } else if (c0813b.f1969e.f1976f.size() != 1) {
                    c0813b.f1969e.m3940g();
                } else {
                    return;
                }
                m3291a(h, c0793n);
                t--;
            } else {
                return;
            }
        }
    }

    private boolean m3983s(int i) {
        if (this.f1986i == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.f1980c) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.f1980c) != m4031h()) {
            return false;
        }
        return true;
    }

    private C0814c m3950a(C0907y c0907y) {
        int i;
        int i2;
        C0814c c0814c = null;
        int i3 = -1;
        if (m3983s(c0907y.f2459e)) {
            i = this.f1984g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f1984g;
            i3 = 1;
        }
        int c;
        int i4;
        C0814c c0814c2;
        int b;
        C0814c c0814c3;
        if (c0907y.f2459e == 1) {
            c = this.f1978a.mo656c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                c0814c2 = this.f1985h[i4];
                b = c0814c2.m3931b(c);
                if (b < i) {
                    c0814c3 = c0814c2;
                } else {
                    b = i;
                    c0814c3 = c0814c;
                }
                i4 += i3;
                c0814c = c0814c3;
                i = b;
            }
        } else {
            c = this.f1978a.mo658d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                c0814c2 = this.f1985h[i4];
                b = c0814c2.m3925a(c);
                if (b > i) {
                    c0814c3 = c0814c2;
                } else {
                    b = i;
                    c0814c3 = c0814c;
                }
                i4 += i3;
                c0814c = c0814c3;
                i = b;
            }
        }
        return c0814c;
    }

    public boolean mo592e() {
        return this.f1986i == 1;
    }

    public boolean mo590d() {
        return this.f1986i == 0;
    }

    public int mo574a(int i, C0793n c0793n, C0798r c0798r) {
        return m4017c(i, c0793n, c0798r);
    }

    public int mo581b(int i, C0793n c0793n, C0798r c0798r) {
        return m4017c(i, c0793n, c0798r);
    }

    private int m3984t(int i) {
        int i2 = -1;
        if (m3367t() != 0) {
            if ((i < m3947M()) == this.f1980c) {
                i2 = 1;
            }
            return i2;
        } else if (this.f1980c) {
            return 1;
        } else {
            return -1;
        }
    }

    public void mo589d(int i) {
        if (!(this.f1994u == null || this.f1994u.f1954a == i)) {
            this.f1994u.m3918b();
        }
        this.f1981d = i;
        this.f1982e = Integer.MIN_VALUE;
        m3360n();
    }

    int m4017c(int i, C0793n c0793n, C0798r c0798r) {
        int L;
        int i2;
        if (i > 0) {
            L = m3946L();
            i2 = 1;
        } else {
            i2 = -1;
            L = m3947M();
        }
        this.f1988k.f2455a = true;
        m3951a(L, c0798r);
        m3973l(i2);
        this.f1988k.f2457c = this.f1988k.f2458d + L;
        int abs = Math.abs(i);
        this.f1988k.f2456b = abs;
        i2 = m3948a(c0793n, this.f1988k, c0798r);
        if (abs >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.f1978a.mo654a(-i);
        this.f1992o = this.f1980c;
        return i;
    }

    private int m3946L() {
        int t = m3367t();
        return t == 0 ? 0 : m3330d(m3349h(t - 1));
    }

    private int m3947M() {
        if (m3367t() == 0) {
            return 0;
        }
        return m3330d(m3349h(0));
    }

    private int m3985u(int i) {
        int t = m3367t();
        for (int i2 = 0; i2 < t; i2++) {
            int d = m3330d(m3349h(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m3986v(int i) {
        for (int t = m3367t() - 1; t >= 0; t--) {
            int d = m3330d(m3349h(t));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    public C0761i mo575a() {
        if (this.f1986i == 0) {
            return new C0813b(-2, -1);
        }
        return new C0813b(-1, -2);
    }

    public C0761i mo597a(Context context, AttributeSet attributeSet) {
        return new C0813b(context, attributeSet);
    }

    public C0761i mo598a(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0813b((MarginLayoutParams) layoutParams);
        }
        return new C0813b(layoutParams);
    }

    public boolean mo609a(C0761i c0761i) {
        return c0761i instanceof C0813b;
    }

    public View mo576a(View view, int i, C0793n c0793n, C0798r c0798r) {
        int i2 = 0;
        if (m3367t() == 0) {
            return null;
        }
        View e = m3337e(view);
        if (e == null) {
            return null;
        }
        m3944J();
        int w = m3987w(i);
        if (w == Integer.MIN_VALUE) {
            return null;
        }
        int L;
        View a;
        C0813b c0813b = (C0813b) e.getLayoutParams();
        boolean z = c0813b.f1970f;
        C0814c c0814c = c0813b.f1969e;
        if (w == 1) {
            L = m3946L();
        } else {
            L = m3947M();
        }
        m3951a(L, c0798r);
        m3973l(w);
        this.f1988k.f2457c = this.f1988k.f2458d + L;
        this.f1988k.f2456b = (int) (0.33333334f * ((float) this.f1978a.mo661f()));
        this.f1988k.f2462h = true;
        this.f1988k.f2455a = false;
        m3948a(c0793n, this.f1988k, c0798r);
        this.f1992o = this.f1980c;
        if (!z) {
            a = c0814c.m3926a(L, w);
            if (!(a == null || a == e)) {
                return a;
            }
        }
        if (m3983s(w)) {
            for (int i3 = this.f1984g - 1; i3 >= 0; i3--) {
                View a2 = this.f1985h[i3].m3926a(L, w);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.f1984g) {
                a = this.f1985h[i2].m3926a(L, w);
                if (a != null && a != e) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }

    private int m3987w(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                if (this.f1986i != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 33:
                if (this.f1986i != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 66:
                if (this.f1986i != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case 130:
                if (this.f1986i == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }
}
