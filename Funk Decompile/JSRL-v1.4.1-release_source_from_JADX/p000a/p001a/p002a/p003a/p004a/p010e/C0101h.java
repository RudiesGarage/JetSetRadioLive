package p000a.p001a.p002a.p003a.p004a.p010e;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p000a.p001a.p002a.p003a.C0142c;

/* compiled from: PinningTrustManager */
class C0101h implements X509TrustManager {
    private static final X509Certificate[] f202a = new X509Certificate[0];
    private final TrustManager[] f203b;
    private final C0102i f204c;
    private final long f205d;
    private final List<byte[]> f206e = new LinkedList();
    private final Set<X509Certificate> f207f = Collections.synchronizedSet(new HashSet());

    public C0101h(C0102i c0102i, C0100g c0100g) {
        this.f203b = m360a(c0102i);
        this.f204c = c0102i;
        this.f205d = c0100g.mo739d();
        for (String a : c0100g.mo738c()) {
            this.f206e.add(m359a(a));
        }
    }

    private TrustManager[] m360a(C0102i c0102i) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(c0102i.f208a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean m358a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f206e) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private void m357a(X509Certificate[] x509CertificateArr, String str) {
        for (TrustManager trustManager : this.f203b) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void m356a(X509Certificate[] x509CertificateArr) {
        if (this.f205d == -1 || System.currentTimeMillis() - this.f205d <= 15552000000L) {
            X509Certificate[] a = C0086a.m277a(x509CertificateArr, this.f204c);
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!m358a(a[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        C0142c.m468h().mo51d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f205d) + " millis vs " + 15552000000L + " millis) " + "falling back to system trust.");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.f207f.contains(x509CertificateArr[0])) {
            m357a(x509CertificateArr, str);
            m356a(x509CertificateArr);
            this.f207f.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f202a;
    }

    private byte[] m359a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
