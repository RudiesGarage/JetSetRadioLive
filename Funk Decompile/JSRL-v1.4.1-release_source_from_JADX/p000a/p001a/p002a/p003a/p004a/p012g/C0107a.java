package p000a.p001a.p002a.p003a.p004a.p012g;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;
import p000a.p001a.p002a.p003a.C0151k;
import p000a.p001a.p002a.p003a.p004a.p006b.C0007a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0041r;
import p000a.p001a.p002a.p003a.p004a.p010e.C0088e;
import p000a.p001a.p002a.p003a.p004a.p010e.C0090c;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098d;

/* compiled from: AbstractAppSpiCall */
abstract class C0107a extends C0007a {
    public C0107a(C0149i c0149i, String str, String str2, C0088e c0088e, C0090c c0090c) {
        super(c0149i, str, str2, c0088e, c0090c);
    }

    public boolean mo38a(C0110d c0110d) {
        C0098d b = m375b(m374a(m22b(), c0110d), c0110d);
        C0142c.m468h().mo46a("Fabric", "Sending app info to " + m21a());
        if (c0110d.f237j != null) {
            C0142c.m468h().mo46a("Fabric", "App icon hash is " + c0110d.f237j.f259a);
            C0142c.m468h().mo46a("Fabric", "App icon size is " + c0110d.f237j.f261c + "x" + c0110d.f237j.f262d);
        }
        int b2 = b.m326b();
        C0142c.m468h().mo46a("Fabric", ("POST".equals(b.m350p()) ? "Create" : "Update") + " app request ID: " + b.m328b("X-REQUEST-ID"));
        C0142c.m468h().mo46a("Fabric", "Result was " + b2);
        if (C0041r.m156a(b2) == 0) {
            return true;
        }
        return false;
    }

    private C0098d m374a(C0098d c0098d, C0110d c0110d) {
        return c0098d.m316a("X-CRASHLYTICS-API-KEY", c0110d.f228a).m316a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m316a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo64a());
    }

    private C0098d m375b(C0098d c0098d, C0110d c0110d) {
        C0098d e = c0098d.m336e("app[identifier]", c0110d.f229b).m336e("app[name]", c0110d.f233f).m336e("app[display_version]", c0110d.f230c).m336e("app[build_version]", c0110d.f231d).m315a("app[source]", Integer.valueOf(c0110d.f234g)).m336e("app[minimum_sdk_version]", c0110d.f235h).m336e("app[built_sdk_version]", c0110d.f236i);
        if (!C0021i.m83c(c0110d.f232e)) {
            e.m336e("app[instance_identifier]", c0110d.f232e);
        }
        if (c0110d.f237j != null) {
            Closeable closeable = null;
            try {
                closeable = this.a.m496E().getResources().openRawResource(c0110d.f237j.f260b);
                e.m336e("app[icon][hash]", c0110d.f237j.f259a).m320a("app[icon][data]", "icon.png", "application/octet-stream", (InputStream) closeable).m315a("app[icon][width]", Integer.valueOf(c0110d.f237j.f261c)).m315a("app[icon][height]", Integer.valueOf(c0110d.f237j.f262d));
            } catch (Throwable e2) {
                C0142c.m468h().mo54e("Fabric", "Failed to find app icon with resource ID: " + c0110d.f237j.f260b, e2);
            } finally {
                String str = "Failed to close app icon InputStream.";
                C0021i.m71a(closeable, str);
            }
        }
        if (c0110d.f238k != null) {
            for (C0151k c0151k : c0110d.f238k) {
                e.m336e(m376a(c0151k), c0151k.m511b());
                e.m336e(m378b(c0151k), c0151k.m512c());
            }
        }
        return e;
    }

    String m376a(C0151k c0151k) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{c0151k.m510a()});
    }

    String m378b(C0151k c0151k) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{c0151k.m510a()});
    }
}
