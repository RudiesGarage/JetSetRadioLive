package p000a.p001a.p002a.p003a.p004a.p006b;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098d;

/* compiled from: AbstractSpiCall */
public abstract class C0007a {
    private static final Pattern f6b = Pattern.compile("http(s?)://[^\\/]+", 2);
    protected final C0149i f7a;
    private final String f8c;
    private final C0088e f9d;
    private final C0090c f10e;
    private final String f11f;

    public C0007a(C0149i c0149i, String str, String str2, C0088e c0088e, C0090c c0090c) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (c0088e == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        } else {
            this.f7a = c0149i;
            this.f11f = str;
            this.f8c = m19a(str2);
            this.f9d = c0088e;
            this.f10e = c0090c;
        }
    }

    protected String m21a() {
        return this.f8c;
    }

    protected C0098d m22b() {
        return m20a(Collections.emptyMap());
    }

    protected C0098d m20a(Map<String, String> map) {
        return this.f9d.mo28a(this.f10e, m21a(), map).m323a(false).m313a(10000).m316a("User-Agent", "Crashlytics Android SDK/" + this.f7a.mo64a()).m316a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    private String m19a(String str) {
        if (C0021i.m83c(this.f11f)) {
            return str;
        }
        return f6b.matcher(str).replaceFirst(this.f11f);
    }
}
