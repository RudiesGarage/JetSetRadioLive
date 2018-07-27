package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0025k;

/* compiled from: EventsFilesManager */
public abstract class C0078b<T> {
    protected final Context f158a;
    protected final C0075a<T> f159b;
    protected final C0025k f160c;
    protected final C0079c f161d;
    protected volatile long f162e;
    protected final List<C0080d> f163f = new CopyOnWriteArrayList();
    private final int f164g;

    /* compiled from: EventsFilesManager */
    class C00761 implements Comparator<C0077a> {
        final /* synthetic */ C0078b f155a;

        C00761(C0078b c0078b) {
            this.f155a = c0078b;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m236a((C0077a) obj, (C0077a) obj2);
        }

        public int m236a(C0077a c0077a, C0077a c0077a2) {
            return (int) (c0077a.f157b - c0077a2.f157b);
        }
    }

    /* compiled from: EventsFilesManager */
    static class C0077a {
        final File f156a;
        final long f157b;

        public C0077a(File file, long j) {
            this.f156a = file;
            this.f157b = j;
        }
    }

    protected abstract String mo721a();

    public C0078b(Context context, C0075a<T> c0075a, C0025k c0025k, C0079c c0079c, int i) {
        this.f158a = context.getApplicationContext();
        this.f159b = c0075a;
        this.f161d = c0079c;
        this.f160c = c0025k;
        this.f162e = this.f160c.mo8a();
        this.f164g = i;
    }

    public void m242a(T t) {
        byte[] a = this.f159b.mo725a(t);
        m237a(a.length);
        this.f161d.mo22a(a);
    }

    public void m241a(C0080d c0080d) {
        if (c0080d != null) {
            this.f163f.add(c0080d);
        }
    }

    public boolean m246d() {
        boolean z = true;
        String str = null;
        if (this.f161d.mo24b()) {
            z = false;
        } else {
            str = mo721a();
            this.f161d.mo20a(str);
            C0021i.m67a(this.f158a, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.f162e = this.f160c.mo8a();
        }
        m238b(str);
        return z;
    }

    private void m237a(int i) {
        if (!this.f161d.mo23a(i, mo723c())) {
            C0021i.m67a(this.f158a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.f161d.mo18a()), Integer.valueOf(i), Integer.valueOf(mo723c())}));
            m246d();
        }
    }

    protected int mo722b() {
        return this.f164g;
    }

    protected int mo723c() {
        return 8000;
    }

    private void m238b(String str) {
        for (C0080d a : this.f163f) {
            try {
                a.mo708a(str);
            } catch (Throwable e) {
                C0021i.m69a(this.f158a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> m247e() {
        return this.f161d.mo19a(1);
    }

    public void m243a(List<File> list) {
        this.f161d.mo21a((List) list);
    }

    public void m248f() {
        this.f161d.mo21a(this.f161d.mo25c());
        this.f161d.mo26d();
    }

    public void m249g() {
        List<File> c = this.f161d.mo25c();
        int b = mo722b();
        if (c.size() > b) {
            int size = c.size() - b;
            C0021i.m68a(this.f158a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(b), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new C00761(this));
            for (File file : c) {
                treeSet.add(new C0077a(file, m239a(file.getName())));
            }
            List arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((C0077a) it.next()).f156a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.f161d.mo21a(arrayList);
        }
    }

    public long m239a(String str) {
        long j = 0;
        String[] split = str.split("_");
        if (split.length == 3) {
            try {
                j = Long.valueOf(split[2]).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}
