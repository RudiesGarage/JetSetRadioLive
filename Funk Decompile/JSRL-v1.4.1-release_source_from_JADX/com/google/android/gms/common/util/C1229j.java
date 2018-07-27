package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public class C1229j {
    private static String f3196a = null;
    private static final int f3197b = Process.myPid();

    public static String m5692a() {
        if (f3196a == null) {
            f3196a = C1229j.m5693a(f3197b);
        }
        return f3196a;
    }

    static String m5693a(int i) {
        ThreadPolicy allowThreadDiskReads;
        Closeable bufferedReader;
        Throwable th;
        String str = null;
        if (i > 0) {
            try {
                allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
                try {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    str = bufferedReader.readLine().trim();
                    C1227h.m5684a(bufferedReader);
                } catch (IOException e) {
                    C1227h.m5684a(bufferedReader);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C1227h.m5684a(bufferedReader);
                    throw th;
                }
            } catch (IOException e2) {
                bufferedReader = str;
                C1227h.m5684a(bufferedReader);
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = str;
                th = th4;
                C1227h.m5684a(bufferedReader);
                throw th;
            }
        }
        return str;
    }
}
