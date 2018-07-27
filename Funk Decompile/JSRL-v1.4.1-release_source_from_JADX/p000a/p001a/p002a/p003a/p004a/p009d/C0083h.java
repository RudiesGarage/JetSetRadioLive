package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0040q;

/* compiled from: QueueFileEventStorage */
public class C0083h implements C0079c {
    private final Context f165a;
    private final File f166b;
    private final String f167c;
    private final File f168d;
    private C0040q f169e = new C0040q(this.f168d);
    private File f170f;

    public C0083h(Context context, File file, String str, String str2) {
        this.f165a = context;
        this.f166b = file;
        this.f167c = str2;
        this.f168d = new File(this.f166b, str);
        m264e();
    }

    private void m264e() {
        this.f170f = new File(this.f166b, this.f167c);
        if (!this.f170f.exists()) {
            this.f170f.mkdirs();
        }
    }

    public void mo22a(byte[] bArr) {
        this.f169e.m152a(bArr);
    }

    public int mo18a() {
        return this.f169e.m150a();
    }

    public void mo20a(String str) {
        this.f169e.close();
        m263a(this.f168d, new File(this.f170f, str));
        this.f169e = new C0040q(this.f168d);
    }

    private void m263a(File file, File file2) {
        Closeable fileInputStream;
        Throwable th;
        Closeable closeable = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                closeable = mo27a(file2);
                C0021i.m73a((InputStream) fileInputStream, (OutputStream) closeable, new byte[1024]);
                C0021i.m71a(fileInputStream, "Failed to close file input stream");
                C0021i.m71a(closeable, "Failed to close output stream");
                file.delete();
            } catch (Throwable th2) {
                th = th2;
                C0021i.m71a(fileInputStream, "Failed to close file input stream");
                C0021i.m71a(closeable, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            C0021i.m71a(fileInputStream, "Failed to close file input stream");
            C0021i.m71a(closeable, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream mo27a(File file) {
        return new FileOutputStream(file);
    }

    public List<File> mo19a(int i) {
        List<File> arrayList = new ArrayList();
        for (Object add : this.f170f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    public void mo21a(List<File> list) {
        for (File file : list) {
            C0021i.m68a(this.f165a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public List<File> mo25c() {
        return Arrays.asList(this.f170f.listFiles());
    }

    public void mo26d() {
        try {
            this.f169e.close();
        } catch (IOException e) {
        }
        this.f168d.delete();
    }

    public boolean mo24b() {
        return this.f169e.m155b();
    }

    public boolean mo23a(int i, int i2) {
        return this.f169e.m154a(i, i2);
    }
}
