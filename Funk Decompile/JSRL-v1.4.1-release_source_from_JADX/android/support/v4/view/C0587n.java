package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MarginLayoutParamsCompat */
public final class C0587n {
    static final C0584a f1145a;

    /* compiled from: MarginLayoutParamsCompat */
    interface C0584a {
        int mo432a(MarginLayoutParams marginLayoutParams);

        int mo433b(MarginLayoutParams marginLayoutParams);
    }

    /* compiled from: MarginLayoutParamsCompat */
    static class C0585b implements C0584a {
        C0585b() {
        }

        public int mo432a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public int mo433b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    /* compiled from: MarginLayoutParamsCompat */
    static class C0586c implements C0584a {
        C0586c() {
        }

        public int mo432a(MarginLayoutParams marginLayoutParams) {
            return C0588o.m2479a(marginLayoutParams);
        }

        public int mo433b(MarginLayoutParams marginLayoutParams) {
            return C0588o.m2480b(marginLayoutParams);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f1145a = new C0586c();
        } else {
            f1145a = new C0585b();
        }
    }

    public static int m2477a(MarginLayoutParams marginLayoutParams) {
        return f1145a.mo432a(marginLayoutParams);
    }

    public static int m2478b(MarginLayoutParams marginLayoutParams) {
        return f1145a.mo433b(marginLayoutParams);
    }
}
