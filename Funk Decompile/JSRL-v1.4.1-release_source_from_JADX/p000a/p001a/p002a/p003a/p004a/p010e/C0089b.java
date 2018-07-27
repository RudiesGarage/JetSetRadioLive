package p000a.p001a.p002a.p003a.p004a.p010e;

import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import p000a.p001a.p002a.p003a.C0136l;
import p000a.p001a.p002a.p003a.C0137b;

/* compiled from: DefaultHttpRequestFactory */
public class C0089b implements C0088e {
    private final C0136l f174a;
    private C0100g f175b;
    private SSLSocketFactory f176c;
    private boolean f177d;

    public C0089b() {
        this(new C0137b());
    }

    public C0089b(C0136l c0136l) {
        this.f174a = c0136l;
    }

    public void mo29a(C0100g c0100g) {
        if (this.f175b != c0100g) {
            this.f175b = c0100g;
            m280a();
        }
    }

    private synchronized void m280a() {
        this.f177d = false;
        this.f176c = null;
    }

    public C0098d mo28a(C0090c c0090c, String str, Map<String, String> map) {
        C0098d a;
        switch (c0090c) {
            case GET:
                a = C0098d.m298a((CharSequence) str, (Map) map, true);
                break;
            case POST:
                a = C0098d.m303b((CharSequence) str, (Map) map, true);
                break;
            case PUT:
                a = C0098d.m306d((CharSequence) str);
                break;
            case DELETE:
                a = C0098d.m307e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (m281a(str) && this.f175b != null) {
            SSLSocketFactory b = m282b();
            if (b != null) {
                ((HttpsURLConnection) a.m325a()).setSSLSocketFactory(b);
            }
        }
        return a;
    }

    private boolean m281a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory m282b() {
        if (this.f176c == null && !this.f177d) {
            this.f176c = m283c();
        }
        return this.f176c;
    }

    private synchronized SSLSocketFactory m283c() {
        SSLSocketFactory a;
        this.f177d = true;
        try {
            a = C0099f.m351a(this.f175b);
            this.f174a.mo46a("Fabric", "Custom SSL pinning enabled");
        } catch (Throwable e) {
            this.f174a.mo54e("Fabric", "Exception while validating pinned certs", e);
            a = null;
        }
        return a;
    }
}
