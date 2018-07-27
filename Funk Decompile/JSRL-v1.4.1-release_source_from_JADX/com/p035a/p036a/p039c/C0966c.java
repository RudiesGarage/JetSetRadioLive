package com.p035a.p036a.p039c;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0033o;

/* compiled from: CLSUUID */
class C0966c {
    private static final AtomicLong f2645a = new AtomicLong(0);
    private static String f2646b;

    public C0966c(C0033o c0033o) {
        r0 = new byte[10];
        m4784a(r0);
        m4786b(r0);
        m4788c(r0);
        String a = C0021i.m62a(c0033o.m113b());
        String a2 = C0021i.m64a(r0);
        f2646b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a2.substring(0, 12), a2.substring(12, 16), a2.subSequence(16, 20), a.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private void m4784a(byte[] bArr) {
        long time = new Date().getTime();
        long j = time / 1000;
        time %= 1000;
        byte[] a = C0966c.m4785a(j);
        bArr[0] = a[0];
        bArr[1] = a[1];
        bArr[2] = a[2];
        bArr[3] = a[3];
        byte[] b = C0966c.m4787b(time);
        bArr[4] = b[0];
        bArr[5] = b[1];
    }

    private void m4786b(byte[] bArr) {
        byte[] b = C0966c.m4787b(f2645a.incrementAndGet());
        bArr[6] = b[0];
        bArr[7] = b[1];
    }

    private void m4788c(byte[] bArr) {
        byte[] b = C0966c.m4787b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b[0];
        bArr[9] = b[1];
    }

    private static byte[] m4785a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] m4787b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return f2646b;
    }
}
