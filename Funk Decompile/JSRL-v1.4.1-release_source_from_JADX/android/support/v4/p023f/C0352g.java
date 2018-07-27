package android.support.v4.p023f;

import android.os.Build.VERSION;
import java.util.Locale;

/* compiled from: TextUtilsCompat */
public final class C0352g {
    public static final Locale f833a = new Locale("", "");
    static String f834b = "Arab";
    static String f835c = "Hebr";
    private static final C0350a f836d;

    /* compiled from: TextUtilsCompat */
    private static class C0350a {
        C0350a() {
        }

        public int mo193a(Locale locale) {
            if (!(locale == null || locale.equals(C0352g.f833a))) {
                String a = C0339b.m1233a(locale);
                if (a == null) {
                    return C0350a.m1249b(locale);
                }
                if (a.equalsIgnoreCase(C0352g.f834b) || a.equalsIgnoreCase(C0352g.f835c)) {
                    return 1;
                }
            }
            return 0;
        }

        private static int m1249b(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case (byte) 1:
                case (byte) 2:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    /* compiled from: TextUtilsCompat */
    private static class C0351b extends C0350a {
        C0351b() {
        }

        public int mo193a(Locale locale) {
            return C0353h.m1253a(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f836d = new C0351b();
        } else {
            f836d = new C0350a();
        }
    }

    public static int m1252a(Locale locale) {
        return f836d.mo193a(locale);
    }
}
