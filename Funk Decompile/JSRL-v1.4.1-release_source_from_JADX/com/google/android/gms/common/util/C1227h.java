package com.google.android.gms.common.util;

import java.io.Closeable;
import java.io.IOException;

public final class C1227h {
    public static void m5684a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
