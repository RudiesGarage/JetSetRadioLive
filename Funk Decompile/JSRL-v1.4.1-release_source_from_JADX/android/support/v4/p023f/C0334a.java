package android.support.v4.p023f;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* compiled from: BidiFormatter */
public final class C0334a {
    private static C0342e f808a = C0349f.f829c;
    private static final String f809b = Character.toString('‎');
    private static final String f810c = Character.toString('‏');
    private static final C0334a f811d = new C0334a(false, 2, f808a);
    private static final C0334a f812e = new C0334a(true, 2, f808a);
    private final boolean f813f;
    private final int f814g;
    private final C0342e f815h;

    /* compiled from: BidiFormatter */
    public static final class C0332a {
        private boolean f799a;
        private int f800b;
        private C0342e f801c;

        public C0332a() {
            m1204a(C0334a.m1221b(Locale.getDefault()));
        }

        private void m1204a(boolean z) {
            this.f799a = z;
            this.f801c = C0334a.f808a;
            this.f800b = 2;
        }

        private static C0334a m1205b(boolean z) {
            return z ? C0334a.f812e : C0334a.f811d;
        }

        public C0334a m1206a() {
            if (this.f800b == 2 && this.f801c == C0334a.f808a) {
                return C0332a.m1205b(this.f799a);
            }
            return new C0334a(this.f799a, this.f800b, this.f801c);
        }
    }

    /* compiled from: BidiFormatter */
    private static class C0333b {
        private static final byte[] f802a = new byte[1792];
        private final CharSequence f803b;
        private final boolean f804c;
        private final int f805d;
        private int f806e;
        private char f807f;

        static {
            for (int i = 0; i < 1792; i++) {
                f802a[i] = Character.getDirectionality(i);
            }
        }

        C0333b(CharSequence charSequence, boolean z) {
            this.f803b = charSequence;
            this.f804c = z;
            this.f805d = charSequence.length();
        }

        int m1212a() {
            this.f806e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f806e < this.f805d && i == 0) {
                switch (m1214c()) {
                    case (byte) 0:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        }
                        return -1;
                    case (byte) 1:
                    case (byte) 2:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        }
                        return 1;
                    case (byte) 9:
                        break;
                    case (byte) 14:
                    case (byte) 15:
                        i3++;
                        i2 = -1;
                        break;
                    case (byte) 16:
                    case (byte) 17:
                        i3++;
                        i2 = 1;
                        break;
                    case (byte) 18:
                        i3--;
                        i2 = 0;
                        break;
                    default:
                        i = i3;
                        break;
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f806e > 0) {
                switch (m1215d()) {
                    case (byte) 14:
                    case (byte) 15:
                        if (i != i3) {
                            i3--;
                            break;
                        }
                        return -1;
                    case (byte) 16:
                    case (byte) 17:
                        if (i != i3) {
                            i3--;
                            break;
                        }
                        return 1;
                    case (byte) 18:
                        i3++;
                        break;
                    default:
                        break;
                }
            }
            return 0;
        }

        int m1213b() {
            this.f806e = this.f805d;
            int i = 0;
            int i2 = 0;
            while (this.f806e > 0) {
                switch (m1215d()) {
                    case (byte) 0:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            }
                            i = i2;
                            break;
                        }
                        return -1;
                    case (byte) 1:
                    case (byte) 2:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            }
                            i = i2;
                            break;
                        }
                        return 1;
                    case (byte) 9:
                        break;
                    case (byte) 14:
                    case (byte) 15:
                        if (i != i2) {
                            i2--;
                            break;
                        }
                        return -1;
                    case (byte) 16:
                    case (byte) 17:
                        if (i != i2) {
                            i2--;
                            break;
                        }
                        return 1;
                    case (byte) 18:
                        i2++;
                        break;
                    default:
                        if (i != 0) {
                            break;
                        }
                        i = i2;
                        break;
                }
            }
            return 0;
        }

        private static byte m1207a(char c) {
            return c < '܀' ? f802a[c] : Character.getDirectionality(c);
        }

        byte m1214c() {
            this.f807f = this.f803b.charAt(this.f806e);
            if (Character.isHighSurrogate(this.f807f)) {
                int codePointAt = Character.codePointAt(this.f803b, this.f806e);
                this.f806e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f806e++;
            byte a = C0333b.m1207a(this.f807f);
            if (!this.f804c) {
                return a;
            }
            if (this.f807f == '<') {
                return m1208e();
            }
            if (this.f807f == '&') {
                return m1210g();
            }
            return a;
        }

        byte m1215d() {
            this.f807f = this.f803b.charAt(this.f806e - 1);
            if (Character.isLowSurrogate(this.f807f)) {
                int codePointBefore = Character.codePointBefore(this.f803b, this.f806e);
                this.f806e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f806e--;
            byte a = C0333b.m1207a(this.f807f);
            if (!this.f804c) {
                return a;
            }
            if (this.f807f == '>') {
                return m1209f();
            }
            if (this.f807f == ';') {
                return m1211h();
            }
            return a;
        }

        private byte m1208e() {
            int i = this.f806e;
            while (this.f806e < this.f805d) {
                CharSequence charSequence = this.f803b;
                int i2 = this.f806e;
                this.f806e = i2 + 1;
                this.f807f = charSequence.charAt(i2);
                if (this.f807f == '>') {
                    return (byte) 12;
                }
                if (this.f807f == '\"' || this.f807f == '\'') {
                    char c = this.f807f;
                    while (this.f806e < this.f805d) {
                        CharSequence charSequence2 = this.f803b;
                        int i3 = this.f806e;
                        this.f806e = i3 + 1;
                        char charAt = charSequence2.charAt(i3);
                        this.f807f = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f806e = i;
            this.f807f = '<';
            return (byte) 13;
        }

        private byte m1209f() {
            int i = this.f806e;
            while (this.f806e > 0) {
                CharSequence charSequence = this.f803b;
                int i2 = this.f806e - 1;
                this.f806e = i2;
                this.f807f = charSequence.charAt(i2);
                if (this.f807f == '<') {
                    return (byte) 12;
                }
                if (this.f807f == '>') {
                    break;
                } else if (this.f807f == '\"' || this.f807f == '\'') {
                    char c = this.f807f;
                    while (this.f806e > 0) {
                        CharSequence charSequence2 = this.f803b;
                        int i3 = this.f806e - 1;
                        this.f806e = i3;
                        char charAt = charSequence2.charAt(i3);
                        this.f807f = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f806e = i;
            this.f807f = '>';
            return (byte) 13;
        }

        private byte m1210g() {
            while (this.f806e < this.f805d) {
                CharSequence charSequence = this.f803b;
                int i = this.f806e;
                this.f806e = i + 1;
                char charAt = charSequence.charAt(i);
                this.f807f = charAt;
                if (charAt == ';') {
                    break;
                }
            }
            return (byte) 12;
        }

        private byte m1211h() {
            int i = this.f806e;
            while (this.f806e > 0) {
                CharSequence charSequence = this.f803b;
                int i2 = this.f806e - 1;
                this.f806e = i2;
                this.f807f = charSequence.charAt(i2);
                if (this.f807f != '&') {
                    if (this.f807f == ';') {
                        break;
                    }
                }
                return (byte) 12;
            }
            this.f806e = i;
            this.f807f = ';';
            return (byte) 13;
        }
    }

    public static C0334a m1216a() {
        return new C0332a().m1206a();
    }

    private C0334a(boolean z, int i, C0342e c0342e) {
        this.f813f = z;
        this.f814g = i;
        this.f815h = c0342e;
    }

    public boolean m1228b() {
        return (this.f814g & 2) != 0;
    }

    private String m1217a(CharSequence charSequence, C0342e c0342e) {
        boolean a = c0342e.mo191a(charSequence, 0, charSequence.length());
        if (!this.f813f && (a || C0334a.m1219b(charSequence) == 1)) {
            return f809b;
        }
        if (!this.f813f || (a && C0334a.m1219b(charSequence) != -1)) {
            return "";
        }
        return f810c;
    }

    private String m1220b(CharSequence charSequence, C0342e c0342e) {
        boolean a = c0342e.mo191a(charSequence, 0, charSequence.length());
        if (!this.f813f && (a || C0334a.m1222c(charSequence) == 1)) {
            return f809b;
        }
        if (!this.f813f || (a && C0334a.m1222c(charSequence) != -1)) {
            return "";
        }
        return f810c;
    }

    public CharSequence m1227a(CharSequence charSequence, C0342e c0342e, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a = c0342e.mo191a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (m1228b() && z) {
            spannableStringBuilder.append(m1220b(charSequence, a ? C0349f.f828b : C0349f.f827a));
        }
        if (a != this.f813f) {
            spannableStringBuilder.append(a ? '‫' : '‪');
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append('‬');
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(m1217a(charSequence, a ? C0349f.f828b : C0349f.f827a));
        }
        return spannableStringBuilder;
    }

    public CharSequence m1226a(CharSequence charSequence) {
        return m1227a(charSequence, this.f815h, true);
    }

    private static boolean m1221b(Locale locale) {
        return C0352g.m1252a(locale) == 1;
    }

    private static int m1219b(CharSequence charSequence) {
        return new C0333b(charSequence, false).m1213b();
    }

    private static int m1222c(CharSequence charSequence) {
        return new C0333b(charSequence, false).m1212a();
    }
}
