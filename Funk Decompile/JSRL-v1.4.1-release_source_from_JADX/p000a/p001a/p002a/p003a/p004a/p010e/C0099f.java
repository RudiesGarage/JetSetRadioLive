package p000a.p001a.p002a.p003a.p004a.p010e;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: NetworkUtils */
public final class C0099f {
    public static final SSLSocketFactory m351a(C0100g c0100g) {
        SSLContext instance = SSLContext.getInstance("TLS");
        C0101h c0101h = new C0101h(new C0102i(c0100g.mo736a(), c0100g.mo737b()), c0100g);
        instance.init(null, new TrustManager[]{c0101h}, null);
        return instance.getSocketFactory();
    }
}
