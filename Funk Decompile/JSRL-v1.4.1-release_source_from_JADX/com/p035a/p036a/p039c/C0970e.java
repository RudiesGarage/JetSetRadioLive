package com.p035a.p036a.p039c;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: CodedOutputStream */
final class C0970e implements Flushable {
    private final byte[] f2652a;
    private final int f2653b;
    private int f2654c = 0;
    private final OutputStream f2655d;

    /* compiled from: CodedOutputStream */
    static class C0969a extends IOException {
        C0969a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private C0970e(OutputStream outputStream, byte[] bArr) {
        this.f2655d = outputStream;
        this.f2652a = bArr;
        this.f2653b = bArr.length;
    }

    public static C0970e m4790a(OutputStream outputStream) {
        return C0970e.m4791a(outputStream, 4096);
    }

    public static C0970e m4791a(OutputStream outputStream, int i) {
        return new C0970e(outputStream, new byte[i]);
    }

    public void m4815a(int i, float f) {
        m4833g(i, 5);
        m4813a(f);
    }

    public void m4817a(int i, long j) {
        m4833g(i, 0);
        m4820a(j);
    }

    public void m4819a(int i, boolean z) {
        m4833g(i, 0);
        m4823a(z);
    }

    public void m4818a(int i, C0965b c0965b) {
        m4833g(i, 2);
        m4821a(c0965b);
    }

    public void m4816a(int i, int i2) {
        m4833g(i, 0);
        m4826b(i2);
    }

    public void m4827b(int i, int i2) {
        m4833g(i, 0);
        m4828c(i2);
    }

    public void m4829c(int i, int i2) {
        m4833g(i, 0);
        m4832d(i2);
    }

    public void m4813a(float f) {
        m4836m(Float.floatToRawIntBits(f));
    }

    public void m4820a(long j) {
        m4830c(j);
    }

    public void m4814a(int i) {
        if (i >= 0) {
            m4835k(i);
        } else {
            m4830c((long) i);
        }
    }

    public void m4823a(boolean z) {
        m4834i(z ? 1 : 0);
    }

    public void m4821a(C0965b c0965b) {
        m4835k(c0965b.m4781a());
        m4831c(c0965b);
    }

    public void m4826b(int i) {
        m4835k(i);
    }

    public void m4828c(int i) {
        m4814a(i);
    }

    public void m4832d(int i) {
        m4835k(C0970e.m4811n(i));
    }

    public static int m4794b(int i, float f) {
        return C0970e.m4809j(i) + C0970e.m4793b(f);
    }

    public static int m4795b(int i, long j) {
        return C0970e.m4809j(i) + C0970e.m4798b(j);
    }

    public static int m4797b(int i, boolean z) {
        return C0970e.m4809j(i) + C0970e.m4800b(z);
    }

    public static int m4796b(int i, C0965b c0965b) {
        return C0970e.m4809j(i) + C0970e.m4799b(c0965b);
    }

    public static int m4801d(int i, int i2) {
        return C0970e.m4809j(i) + C0970e.m4805f(i2);
    }

    public static int m4804e(int i, int i2) {
        return C0970e.m4809j(i) + C0970e.m4807g(i2);
    }

    public static int m4806f(int i, int i2) {
        return C0970e.m4809j(i) + C0970e.m4808h(i2);
    }

    public static int m4793b(float f) {
        return 4;
    }

    public static int m4798b(long j) {
        return C0970e.m4802d(j);
    }

    public static int m4803e(int i) {
        if (i >= 0) {
            return C0970e.m4810l(i);
        }
        return 10;
    }

    public static int m4800b(boolean z) {
        return 1;
    }

    public static int m4799b(C0965b c0965b) {
        return C0970e.m4810l(c0965b.m4781a()) + c0965b.m4781a();
    }

    public static int m4805f(int i) {
        return C0970e.m4810l(i);
    }

    public static int m4807g(int i) {
        return C0970e.m4803e(i);
    }

    public static int m4808h(int i) {
        return C0970e.m4810l(C0970e.m4811n(i));
    }

    private void m4792a() {
        if (this.f2655d == null) {
            throw new C0969a();
        }
        this.f2655d.write(this.f2652a, 0, this.f2654c);
        this.f2654c = 0;
    }

    public void flush() {
        if (this.f2655d != null) {
            m4792a();
        }
    }

    public void m4812a(byte b) {
        if (this.f2654c == this.f2653b) {
            m4792a();
        }
        byte[] bArr = this.f2652a;
        int i = this.f2654c;
        this.f2654c = i + 1;
        bArr[i] = b;
    }

    public void m4834i(int i) {
        m4812a((byte) i);
    }

    public void m4831c(C0965b c0965b) {
        m4822a(c0965b, 0, c0965b.m4781a());
    }

    public void m4824a(byte[] bArr) {
        m4825a(bArr, 0, bArr.length);
    }

    public void m4825a(byte[] bArr, int i, int i2) {
        if (this.f2653b - this.f2654c >= i2) {
            System.arraycopy(bArr, i, this.f2652a, this.f2654c, i2);
            this.f2654c += i2;
            return;
        }
        int i3 = this.f2653b - this.f2654c;
        System.arraycopy(bArr, i, this.f2652a, this.f2654c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f2654c = this.f2653b;
        m4792a();
        if (i3 <= this.f2653b) {
            System.arraycopy(bArr, i4, this.f2652a, 0, i3);
            this.f2654c = i3;
            return;
        }
        this.f2655d.write(bArr, i4, i3);
    }

    public void m4822a(C0965b c0965b, int i, int i2) {
        if (this.f2653b - this.f2654c >= i2) {
            c0965b.m4782a(this.f2652a, i, this.f2654c, i2);
            this.f2654c += i2;
            return;
        }
        int i3 = this.f2653b - this.f2654c;
        c0965b.m4782a(this.f2652a, i, this.f2654c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f2654c = this.f2653b;
        m4792a();
        if (i3 <= this.f2653b) {
            c0965b.m4782a(this.f2652a, i4, 0, i3);
            this.f2654c = i3;
            return;
        }
        InputStream b = c0965b.m4783b();
        if (((long) i4) != b.skip((long) i4)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i3 > 0) {
            i4 = Math.min(i3, this.f2653b);
            int read = b.read(this.f2652a, 0, i4);
            if (read != i4) {
                throw new IllegalStateException("Read failed.");
            }
            this.f2655d.write(this.f2652a, 0, read);
            i3 -= read;
        }
    }

    public void m4833g(int i, int i2) {
        m4835k(af.m4778a(i, i2));
    }

    public static int m4809j(int i) {
        return C0970e.m4810l(af.m4778a(i, 0));
    }

    public void m4835k(int i) {
        while ((i & -128) != 0) {
            m4834i((i & 127) | 128);
            i >>>= 7;
        }
        m4834i(i);
    }

    public static int m4810l(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    public void m4830c(long j) {
        while ((-128 & j) != 0) {
            m4834i((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m4834i((int) j);
    }

    public static int m4802d(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    public void m4836m(int i) {
        m4834i(i & 255);
        m4834i((i >> 8) & 255);
        m4834i((i >> 16) & 255);
        m4834i((i >> 24) & 255);
    }

    public static int m4811n(int i) {
        return (i << 1) ^ (i >> 31);
    }
}
