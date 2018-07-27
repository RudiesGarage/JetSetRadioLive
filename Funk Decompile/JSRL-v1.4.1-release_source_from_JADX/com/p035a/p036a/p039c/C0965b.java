package com.p035a.p036a.p039c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ByteString */
final class C0965b {
    public static final C0965b f2642a = new C0965b(new byte[0]);
    private final byte[] f2643b;
    private volatile int f2644c = 0;

    private C0965b(byte[] bArr) {
        this.f2643b = bArr;
    }

    public int m4781a() {
        return this.f2643b.length;
    }

    public static C0965b m4780a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new C0965b(obj);
    }

    public static C0965b m4779a(String str) {
        try {
            return new C0965b(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public void m4782a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f2643b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0965b)) {
            return false;
        }
        C0965b c0965b = (C0965b) obj;
        int length = this.f2643b.length;
        if (length != c0965b.f2643b.length) {
            return false;
        }
        byte[] bArr = this.f2643b;
        byte[] bArr2 = c0965b.f2643b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f2644c;
        if (i == 0) {
            byte[] bArr = this.f2643b;
            int length = this.f2643b.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                int i3 = bArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
            if (i == 0) {
                i = 1;
            }
            this.f2644c = i;
        }
        return i;
    }

    public InputStream m4783b() {
        return new ByteArrayInputStream(this.f2643b);
    }
}
