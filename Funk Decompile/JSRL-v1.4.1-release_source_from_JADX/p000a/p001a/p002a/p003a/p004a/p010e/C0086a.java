package p000a.p001a.p002a.p003a.p004a.p010e;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* compiled from: CertificateChainCleaner */
final class C0086a {
    public static X509Certificate[] m277a(X509Certificate[] x509CertificateArr, C0102i c0102i) {
        int i;
        int i2 = 1;
        LinkedList linkedList = new LinkedList();
        if (c0102i.m363a(x509CertificateArr[0])) {
            i = 1;
        } else {
            i = 0;
        }
        linkedList.add(x509CertificateArr[0]);
        int i3 = i;
        i = 1;
        while (i < x509CertificateArr.length) {
            if (c0102i.m363a(x509CertificateArr[i])) {
                i3 = 1;
            }
            if (!C0086a.m276a(x509CertificateArr[i], x509CertificateArr[i - 1])) {
                break;
            }
            linkedList.add(x509CertificateArr[i]);
            i++;
        }
        X509Certificate b = c0102i.m364b(x509CertificateArr[i - 1]);
        if (b != null) {
            linkedList.add(b);
        } else {
            i2 = i3;
        }
        if (i2 != 0) {
            return (X509Certificate[]) linkedList.toArray(new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    private static boolean m276a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getIssuerX500Principal())) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }
}
