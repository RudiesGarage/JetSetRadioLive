package p000a.p001a.p002a.p003a.p004a.p010e;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

/* compiled from: HttpRequest */
public class C0098d {
    private static final String[] f190b = new String[0];
    private static C0094b f191c = C0094b.f188a;
    public final URL f192a;
    private HttpURLConnection f193d = null;
    private final String f194e;
    private C0097e f195f;
    private boolean f196g;
    private boolean f197h = true;
    private boolean f198i = false;
    private int f199j = 8192;
    private String f200k;
    private int f201l;

    /* compiled from: HttpRequest */
    protected static abstract class C0091d<V> implements Callable<V> {
        protected abstract V mo31b();

        protected abstract void mo30c();

        protected C0091d() {
        }

        public V call() {
            Throwable th;
            Object obj = 1;
            try {
                V b = mo31b();
                try {
                    mo30c();
                    return b;
                } catch (IOException e) {
                    throw new C0096c(e);
                }
            } catch (C0096c e2) {
                throw e2;
            } catch (IOException e3) {
                throw new C0096c(e3);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                mo30c();
            } catch (IOException e4) {
                if (obj == null) {
                    throw new C0096c(e4);
                }
            }
            throw th;
        }
    }

    /* compiled from: HttpRequest */
    protected static abstract class C0092a<V> extends C0091d<V> {
        private final Closeable f183a;
        private final boolean f184b;

        protected C0092a(Closeable closeable, boolean z) {
            this.f183a = closeable;
            this.f184b = z;
        }

        protected void mo30c() {
            if (this.f183a instanceof Flushable) {
                ((Flushable) this.f183a).flush();
            }
            if (this.f184b) {
                try {
                    this.f183a.close();
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            this.f183a.close();
        }
    }

    /* compiled from: HttpRequest */
    public interface C0094b {
        public static final C0094b f188a = new C00951();

        /* compiled from: HttpRequest */
        static class C00951 implements C0094b {
            C00951() {
            }

            public HttpURLConnection mo32a(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            public HttpURLConnection mo33a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        HttpURLConnection mo32a(URL url);

        HttpURLConnection mo33a(URL url, Proxy proxy);
    }

    /* compiled from: HttpRequest */
    public static class C0096c extends RuntimeException {
        public /* synthetic */ Throwable getCause() {
            return m295a();
        }

        protected C0096c(IOException iOException) {
            super(iOException);
        }

        public IOException m295a() {
            return (IOException) super.getCause();
        }
    }

    /* compiled from: HttpRequest */
    public static class C0097e extends BufferedOutputStream {
        private final CharsetEncoder f189a;

        public C0097e(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f189a = Charset.forName(C0098d.m309f(str)).newEncoder();
        }

        public C0097e m296a(String str) {
            ByteBuffer encode = this.f189a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    private static String m309f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private static StringBuilder m301a(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    private static StringBuilder m304b(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    public static String m299a(CharSequence charSequence) {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String toASCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = toASCIIString.indexOf(63);
                if (indexOf > 0 && indexOf + 1 < toASCIIString.length()) {
                    toASCIIString = toASCIIString.substring(0, indexOf + 1) + toASCIIString.substring(indexOf + 1).replace("+", "%2B");
                }
                return toASCIIString;
            } catch (Throwable e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new C0096c(iOException);
            }
        } catch (IOException e2) {
            throw new C0096c(e2);
        }
    }

    public static String m300a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        C0098d.m301a(charSequence2, stringBuilder);
        C0098d.m304b(charSequence2, stringBuilder);
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object value = entry.getValue();
        if (value != null) {
            stringBuilder.append(value);
        }
        while (it.hasNext()) {
            stringBuilder.append('&');
            entry = (Entry) it.next();
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append('=');
            value = entry.getValue();
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    public static C0098d m302b(CharSequence charSequence) {
        return new C0098d(charSequence, "GET");
    }

    public static C0098d m298a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = C0098d.m300a(charSequence, (Map) map);
        if (z) {
            a = C0098d.m299a(a);
        }
        return C0098d.m302b(a);
    }

    public static C0098d m305c(CharSequence charSequence) {
        return new C0098d(charSequence, "POST");
    }

    public static C0098d m303b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = C0098d.m300a(charSequence, (Map) map);
        if (z) {
            a = C0098d.m299a(a);
        }
        return C0098d.m305c(a);
    }

    public static C0098d m306d(CharSequence charSequence) {
        return new C0098d(charSequence, "PUT");
    }

    public static C0098d m307e(CharSequence charSequence) {
        return new C0098d(charSequence, "DELETE");
    }

    public C0098d(CharSequence charSequence, String str) {
        try {
            this.f192a = new URL(charSequence.toString());
            this.f194e = str;
        } catch (IOException e) {
            throw new C0096c(e);
        }
    }

    private Proxy m310q() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.f200k, this.f201l));
    }

    private HttpURLConnection m311r() {
        try {
            HttpURLConnection a;
            if (this.f200k != null) {
                a = f191c.mo33a(this.f192a, m310q());
            } else {
                a = f191c.mo32a(this.f192a);
            }
            a.setRequestMethod(this.f194e);
            return a;
        } catch (IOException e) {
            throw new C0096c(e);
        }
    }

    public String toString() {
        return m350p() + ' ' + m349o();
    }

    public HttpURLConnection m325a() {
        if (this.f193d == null) {
            this.f193d = m311r();
        }
        return this.f193d;
    }

    public int m326b() {
        try {
            m345k();
            return m325a().getResponseCode();
        } catch (IOException e) {
            throw new C0096c(e);
        }
    }

    public boolean m332c() {
        return 200 == m326b();
    }

    protected ByteArrayOutputStream m335d() {
        int j = m344j();
        if (j > 0) {
            return new ByteArrayOutputStream(j);
        }
        return new ByteArrayOutputStream();
    }

    public String m324a(String str) {
        OutputStream d = m335d();
        try {
            m314a(m340f(), d);
            return d.toString(C0098d.m309f(str));
        } catch (IOException e) {
            throw new C0096c(e);
        }
    }

    public String m337e() {
        return m324a(m342h());
    }

    public BufferedInputStream m340f() {
        return new BufferedInputStream(m341g(), this.f199j);
    }

    public InputStream m341g() {
        if (m326b() < 400) {
            try {
                InputStream inputStream = m325a().getInputStream();
            } catch (IOException e) {
                throw new C0096c(e);
            }
        }
        inputStream = m325a().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = m325a().getInputStream();
            } catch (IOException e2) {
                throw new C0096c(e2);
            }
        }
        if (!this.f198i || !"gzip".equals(m343i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e22) {
            throw new C0096c(e22);
        }
    }

    public C0098d m313a(int i) {
        m325a().setConnectTimeout(i);
        return this;
    }

    public C0098d m316a(String str, String str2) {
        m325a().setRequestProperty(str, str2);
        return this;
    }

    public C0098d m322a(Entry<String, String> entry) {
        return m316a((String) entry.getKey(), (String) entry.getValue());
    }

    public String m328b(String str) {
        m346l();
        return m325a().getHeaderField(str);
    }

    public int m330c(String str) {
        return m312a(str, -1);
    }

    public int m312a(String str, int i) {
        m346l();
        return m325a().getHeaderFieldInt(str, i);
    }

    public String m329b(String str, String str2) {
        return m331c(m328b(str), str2);
    }

    protected String m331c(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length) {
            return null;
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = indexOf;
            indexOf = length;
        } else {
            int i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        while (indexOf2 < indexOf) {
            int indexOf3 = str.indexOf(61, indexOf2);
            if (indexOf3 != -1 && indexOf3 < indexOf && str2.equals(str.substring(indexOf2, indexOf3).trim())) {
                String trim = str.substring(indexOf3 + 1, indexOf).trim();
                indexOf3 = trim.length();
                if (indexOf3 != 0) {
                    if (indexOf3 > 2 && '\"' == trim.charAt(0) && '\"' == trim.charAt(indexOf3 - 1)) {
                        return trim.substring(1, indexOf3 - 1);
                    }
                    return trim;
                }
            }
            indexOf++;
            indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = length;
            }
            i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        return null;
    }

    public String m342h() {
        return m329b("Content-Type", "charset");
    }

    public C0098d m323a(boolean z) {
        m325a().setUseCaches(z);
        return this;
    }

    public String m343i() {
        return m328b("Content-Encoding");
    }

    public C0098d m333d(String str) {
        return m334d(str, null);
    }

    public C0098d m334d(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return m316a("Content-Type", str);
        }
        String str3 = "; charset=";
        return m316a("Content-Type", str + "; charset=" + str2);
    }

    public int m344j() {
        return m330c("Content-Length");
    }

    protected C0098d m314a(InputStream inputStream, OutputStream outputStream) {
        final InputStream inputStream2 = inputStream;
        final OutputStream outputStream2 = outputStream;
        return (C0098d) new C0092a<C0098d>(this, inputStream, this.f197h) {
            final /* synthetic */ C0098d f187c;

            public /* synthetic */ Object mo31b() {
                return m289a();
            }

            public C0098d m289a() {
                byte[] bArr = new byte[this.f187c.f199j];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        return this.f187c;
                    }
                    outputStream2.write(bArr, 0, read);
                }
            }
        }.call();
    }

    protected C0098d m345k() {
        if (this.f195f != null) {
            if (this.f196g) {
                this.f195f.m296a("\r\n--00content0boundary00--\r\n");
            }
            if (this.f197h) {
                try {
                    this.f195f.close();
                } catch (IOException e) {
                }
            } else {
                this.f195f.close();
            }
            this.f195f = null;
        }
        return this;
    }

    protected C0098d m346l() {
        try {
            return m345k();
        } catch (IOException e) {
            throw new C0096c(e);
        }
    }

    protected C0098d m347m() {
        if (this.f195f == null) {
            m325a().setDoOutput(true);
            this.f195f = new C0097e(m325a().getOutputStream(), m331c(m325a().getRequestProperty("Content-Type"), "charset"), this.f199j);
        }
        return this;
    }

    protected C0098d m348n() {
        if (this.f196g) {
            this.f195f.m296a("\r\n--00content0boundary00\r\n");
        } else {
            this.f196g = true;
            m333d("multipart/form-data; boundary=00content0boundary00").m347m();
            this.f195f.m296a("--00content0boundary00\r\n");
        }
        return this;
    }

    protected C0098d m318a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"").append(str2);
        }
        stringBuilder.append('\"');
        m339f("Content-Disposition", stringBuilder.toString());
        if (str3 != null) {
            m339f("Content-Type", str3);
        }
        return m338f((CharSequence) "\r\n");
    }

    public C0098d m336e(String str, String str2) {
        return m327b(str, null, str2);
    }

    public C0098d m327b(String str, String str2, String str3) {
        return m321a(str, str2, null, str3);
    }

    public C0098d m321a(String str, String str2, String str3, String str4) {
        try {
            m348n();
            m318a(str, str2, str3);
            this.f195f.m296a(str4);
            return this;
        } catch (IOException e) {
            throw new C0096c(e);
        }
    }

    public C0098d m315a(String str, Number number) {
        return m317a(str, null, number);
    }

    public C0098d m317a(String str, String str2, Number number) {
        return m327b(str, str2, number != null ? number.toString() : null);
    }

    public C0098d m319a(String str, String str2, String str3, File file) {
        InputStream bufferedInputStream;
        IOException e;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                C0098d a = m320a(str, str2, str3, bufferedInputStream);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                return a;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new C0096c(e);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
            throw new C0096c(e);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public C0098d m320a(String str, String str2, String str3, InputStream inputStream) {
        try {
            m348n();
            m318a(str, str2, str3);
            m314a(inputStream, this.f195f);
            return this;
        } catch (IOException e) {
            throw new C0096c(e);
        }
    }

    public C0098d m339f(String str, String str2) {
        return m338f((CharSequence) str).m338f((CharSequence) ": ").m338f((CharSequence) str2).m338f((CharSequence) "\r\n");
    }

    public C0098d m338f(CharSequence charSequence) {
        try {
            m347m();
            this.f195f.m296a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new C0096c(e);
        }
    }

    public URL m349o() {
        return m325a().getURL();
    }

    public String m350p() {
        return m325a().getRequestMethod();
    }
}
