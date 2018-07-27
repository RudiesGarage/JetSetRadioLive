package p000a.p001a.p002a.p003a;

import android.util.Log;

/* compiled from: DefaultLogger */
public class C0137b implements C0136l {
    private int f309a;

    public C0137b(int i) {
        this.f309a = i;
    }

    public C0137b() {
        this.f309a = 4;
    }

    public boolean mo48a(String str, int i) {
        return this.f309a <= i;
    }

    public void mo47a(String str, String str2, Throwable th) {
        if (mo48a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void m442b(String str, String str2, Throwable th) {
        if (mo48a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void m444c(String str, String str2, Throwable th) {
        if (mo48a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void mo52d(String str, String str2, Throwable th) {
        if (mo48a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void mo54e(String str, String str2, Throwable th) {
        if (mo48a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void mo46a(String str, String str2) {
        mo47a(str, str2, null);
    }

    public void mo49b(String str, String str2) {
        m442b(str, str2, null);
    }

    public void mo50c(String str, String str2) {
        m444c(str, str2, null);
    }

    public void mo51d(String str, String str2) {
        mo52d(str, str2, null);
    }

    public void mo53e(String str, String str2) {
        mo54e(str, str2, null);
    }

    public void mo45a(int i, String str, String str2) {
        m437a(i, str, str2, false);
    }

    public void m437a(int i, String str, String str2, boolean z) {
        if (z || mo48a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
