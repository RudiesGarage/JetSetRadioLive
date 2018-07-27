package android.support.v4.p024g;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter */
public class C0360d extends Writer {
    private final String f852a;
    private StringBuilder f853b = new StringBuilder(128);

    public C0360d(String str) {
        this.f852a = str;
    }

    public void close() {
        m1302a();
    }

    public void flush() {
        m1302a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1302a();
            } else {
                this.f853b.append(c);
            }
        }
    }

    private void m1302a() {
        if (this.f853b.length() > 0) {
            Log.d(this.f852a, this.f853b.toString());
            this.f853b.delete(0, this.f853b.length());
        }
    }
}
