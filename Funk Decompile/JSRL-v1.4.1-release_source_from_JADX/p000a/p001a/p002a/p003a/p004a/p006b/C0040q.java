package p000a.p001a.p002a.p003a.p004a.p006b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile */
public class C0040q implements Closeable {
    private static final Logger f89b = Logger.getLogger(C0040q.class.getName());
    int f90a;
    private final RandomAccessFile f91c;
    private int f92d;
    private C0038a f93e;
    private C0038a f94f;
    private final byte[] f95g = new byte[16];

    /* compiled from: QueueFile */
    public interface C0036c {
        void mo7a(InputStream inputStream, int i);
    }

    /* compiled from: QueueFile */
    static class C0038a {
        static final C0038a f83a = new C0038a(0, 0);
        final int f84b;
        final int f85c;

        C0038a(int i, int i2) {
            this.f84b = i;
            this.f85c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[" + "position = " + this.f84b + ", length = " + this.f85c + "]";
        }
    }

    /* compiled from: QueueFile */
    private final class C0039b extends InputStream {
        final /* synthetic */ C0040q f86a;
        private int f87b;
        private int f88c;

        private C0039b(C0040q c0040q, C0038a c0038a) {
            this.f86a = c0040q;
            this.f87b = c0040q.m141b(c0038a.f84b + 4);
            this.f88c = c0038a.f85c;
        }

        public int read(byte[] bArr, int i, int i2) {
            C0040q.m143b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.f88c <= 0) {
                return -1;
            } else {
                if (i2 > this.f88c) {
                    i2 = this.f88c;
                }
                this.f86a.m144b(this.f87b, bArr, i, i2);
                this.f87b = this.f86a.m141b(this.f87b + i2);
                this.f88c -= i2;
                return i2;
            }
        }

        public int read() {
            if (this.f88c == 0) {
                return -1;
            }
            this.f86a.f91c.seek((long) this.f87b);
            int read = this.f86a.f91c.read();
            this.f87b = this.f86a.m141b(this.f87b + 1);
            this.f88c--;
            return read;
        }
    }

    public C0040q(File file) {
        if (!file.exists()) {
            C0040q.m139a(file);
        }
        this.f91c = C0040q.m142b(file);
        m146c();
    }

    private static void m145b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void m140a(byte[] bArr, int... iArr) {
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            C0040q.m145b(bArr, i2, iArr[i]);
            i2 += 4;
            i++;
        }
    }

    private static int m132a(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16)) + ((bArr[i + 2] & 255) << 8)) + (bArr[i + 3] & 255);
    }

    private void m146c() {
        this.f91c.seek(0);
        this.f91c.readFully(this.f95g);
        this.f90a = C0040q.m132a(this.f95g, 0);
        if (((long) this.f90a) > this.f91c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f90a + ", Actual length: " + this.f91c.length());
        }
        this.f92d = C0040q.m132a(this.f95g, 4);
        int a = C0040q.m132a(this.f95g, 8);
        int a2 = C0040q.m132a(this.f95g, 12);
        this.f93e = m133a(a);
        this.f94f = m133a(a2);
    }

    private void m136a(int i, int i2, int i3, int i4) {
        C0040q.m140a(this.f95g, i, i2, i3, i4);
        this.f91c.seek(0);
        this.f91c.write(this.f95g);
    }

    private C0038a m133a(int i) {
        if (i == 0) {
            return C0038a.f83a;
        }
        this.f91c.seek((long) i);
        return new C0038a(i, this.f91c.readInt());
    }

    private static void m139a(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b = C0040q.m142b(file2);
        try {
            b.setLength(4096);
            b.seek(0);
            byte[] bArr = new byte[16];
            C0040q.m140a(bArr, 4096, 0, 0, 0);
            b.write(bArr);
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } finally {
            b.close();
        }
    }

    private static RandomAccessFile m142b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private int m141b(int i) {
        return i < this.f90a ? i : (i + 16) - this.f90a;
    }

    private void m137a(int i, byte[] bArr, int i2, int i3) {
        int b = m141b(i);
        if (b + i3 <= this.f90a) {
            this.f91c.seek((long) b);
            this.f91c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f90a - b;
        this.f91c.seek((long) b);
        this.f91c.write(bArr, i2, i4);
        this.f91c.seek(16);
        this.f91c.write(bArr, i2 + i4, i3 - i4);
    }

    private void m144b(int i, byte[] bArr, int i2, int i3) {
        int b = m141b(i);
        if (b + i3 <= this.f90a) {
            this.f91c.seek((long) b);
            this.f91c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f90a - b;
        this.f91c.seek((long) b);
        this.f91c.readFully(bArr, i2, i4);
        this.f91c.seek(16);
        this.f91c.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void m152a(byte[] bArr) {
        m153a(bArr, 0, bArr.length);
    }

    public synchronized void m153a(byte[] bArr, int i, int i2) {
        C0040q.m143b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3;
        m147c(i2);
        boolean b = m155b();
        if (b) {
            i3 = 16;
        } else {
            i3 = m141b((this.f94f.f84b + 4) + this.f94f.f85c);
        }
        C0038a c0038a = new C0038a(i3, i2);
        C0040q.m145b(this.f95g, 0, i2);
        m137a(c0038a.f84b, this.f95g, 0, 4);
        m137a(c0038a.f84b + 4, bArr, i, i2);
        m136a(this.f90a, this.f92d + 1, b ? c0038a.f84b : this.f93e.f84b, c0038a.f84b);
        this.f94f = c0038a;
        this.f92d++;
        if (b) {
            this.f93e = this.f94f;
        }
    }

    public int m150a() {
        if (this.f92d == 0) {
            return 16;
        }
        if (this.f94f.f84b >= this.f93e.f84b) {
            return (((this.f94f.f84b - this.f93e.f84b) + 4) + this.f94f.f85c) + 16;
        }
        return (((this.f94f.f84b + 4) + this.f94f.f85c) + this.f90a) - this.f93e.f84b;
    }

    private int m148d() {
        return this.f90a - m150a();
    }

    public synchronized boolean m155b() {
        return this.f92d == 0;
    }

    private void m147c(int i) {
        int i2 = i + 4;
        int d = m148d();
        if (d < i2) {
            int i3 = this.f90a;
            do {
                d += i3;
                i3 <<= 1;
            } while (d < i2);
            m149d(i3);
            i2 = m141b((this.f94f.f84b + 4) + this.f94f.f85c);
            if (i2 < this.f93e.f84b) {
                FileChannel channel = this.f91c.getChannel();
                channel.position((long) this.f90a);
                int i4 = i2 - 4;
                if (channel.transferTo(16, (long) i4, channel) != ((long) i4)) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f94f.f84b < this.f93e.f84b) {
                d = (this.f90a + this.f94f.f84b) - 16;
                m136a(i3, this.f92d, this.f93e.f84b, d);
                this.f94f = new C0038a(d, this.f94f.f85c);
            } else {
                m136a(i3, this.f92d, this.f93e.f84b, this.f94f.f84b);
            }
            this.f90a = i3;
        }
    }

    private void m149d(int i) {
        this.f91c.setLength((long) i);
        this.f91c.getChannel().force(true);
    }

    public synchronized void m151a(C0036c c0036c) {
        int i = this.f93e.f84b;
        for (int i2 = 0; i2 < this.f92d; i2++) {
            C0038a a = m133a(i);
            c0036c.mo7a(new C0039b(a), a.f85c);
            i = m141b(a.f85c + (a.f84b + 4));
        }
    }

    private static <T> T m143b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void close() {
        this.f91c.close();
    }

    public boolean m154a(int i, int i2) {
        return (m150a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append('[');
        stringBuilder.append("fileLength=").append(this.f90a);
        stringBuilder.append(", size=").append(this.f92d);
        stringBuilder.append(", first=").append(this.f93e);
        stringBuilder.append(", last=").append(this.f94f);
        stringBuilder.append(", element lengths=[");
        try {
            m151a(new C0036c(this) {
                boolean f80a = true;
                final /* synthetic */ C0040q f82c;

                public void mo7a(InputStream inputStream, int i) {
                    if (this.f80a) {
                        this.f80a = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(i);
                }
            });
        } catch (Throwable e) {
            f89b.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
