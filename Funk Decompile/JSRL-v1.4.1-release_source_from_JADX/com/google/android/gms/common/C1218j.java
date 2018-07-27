package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.C1157b;
import com.google.android.gms.common.internal.C1198t;
import com.google.android.gms.common.internal.C1198t.C1199a;
import com.google.android.gms.common.util.C1226g;
import com.google.android.gms.p042a.C1041a;
import com.google.android.gms.p042a.C1044b;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;

class C1218j {
    private static Context f3189a;

    static abstract class C1212a extends C1199a {
        private int f3184a;

        protected C1212a(byte[] bArr) {
            boolean z = false;
            if (bArr.length != 25) {
                int length = bArr.length;
                String valueOf = String.valueOf(C1226g.m5683a(bArr, 0, bArr.length, false));
                Log.wtf("GoogleCertificates", new StringBuilder(String.valueOf(valueOf).length() + 51).append("Cert hash data has incorrect length (").append(length).append("):\n").append(valueOf).toString(), new Exception());
                bArr = Arrays.copyOfRange(bArr, 0, 25);
                if (bArr.length == 25) {
                    z = true;
                }
                C1157b.m5377b(z, "cert hash data has incorrect length. length=" + bArr.length);
            }
            this.f3184a = Arrays.hashCode(bArr);
        }

        protected static byte[] m5662a(String str) {
            try {
                return str.getBytes("ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }

        public C1041a mo847a() {
            return C1044b.m5057a(mo849c());
        }

        public int mo848b() {
            return hashCode();
        }

        abstract byte[] mo849c();

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C1198t)) {
                return false;
            }
            try {
                C1198t c1198t = (C1198t) obj;
                if (c1198t.mo848b() != hashCode()) {
                    return false;
                }
                C1041a a = c1198t.mo847a();
                if (a == null) {
                    return false;
                }
                return Arrays.equals(mo849c(), (byte[]) C1044b.m5058a(a));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "iCertData failed to retrive data from remote");
                return false;
            }
        }

        public int hashCode() {
            return this.f3184a;
        }
    }

    static class C1213b extends C1212a {
        private final byte[] f3185a;

        C1213b(byte[] bArr) {
            super(Arrays.copyOfRange(bArr, 0, 25));
            this.f3185a = bArr;
        }

        byte[] mo849c() {
            return this.f3185a;
        }
    }

    static abstract class C1214c extends C1212a {
        private static final WeakReference<byte[]> f3186b = new WeakReference(null);
        private WeakReference<byte[]> f3187a = f3186b;

        C1214c(byte[] bArr) {
            super(bArr);
        }

        byte[] mo849c() {
            byte[] bArr;
            synchronized (this) {
                bArr = (byte[]) this.f3187a.get();
                if (bArr == null) {
                    bArr = mo850d();
                    this.f3187a = new WeakReference(bArr);
                }
            }
            return bArr;
        }

        protected abstract byte[] mo850d();
    }

    static final class C1217d {
        static final C1212a[] f3188a = new C1212a[]{new C12151(C1212a.m5662a("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00")), new C12162(C1212a.m5662a("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"))};

        class C12151 extends C1214c {
            C12151(byte[] bArr) {
                super(bArr);
            }

            protected byte[] mo850d() {
                return C1212a.m5662a("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u00000t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u001e\u0017\r080821231334Z\u0017\r360107231334Z0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000«V.\u0000Ø;¢\b®\no\u0012N)Ú\u0011ò«VÐXâÌ©\u0013\u0003é·TÓrö@§\u001b\u001dË\u0013\tgbNFV§wj\u0019=²å¿·$©\u001ew\u0018\u000ejG¤;3Ù`w\u00181EÌß{.XftÉáV[\u001fLjYU¿òQ¦=«ùÅ\\'\"\"Rèuäø\u0015Jd_qhÀ±¿Æ\u0012ê¿xWi»4ªyÜ~.¢vL®\u0007ØÁqT×î_d¥\u001aD¦\u0002ÂI\u0005AWÜ\u0002Í_\\\u000eUûï\u0019ûã'ð±Q\u0016Å o\u0019ÑõÄÛÂÖ¹?hÌ)yÇ\u000e\u0018«k;ÕÛU*\u000e;LßXûíÁº5à\u0003Á´±\rÒD¨î$ÿý38r«R!^Ú°ü\r\u000b\u0014[j¡y\u0002\u0001\u0003£Ù0Ö0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014Ç}Â!\u0017V%Óßkãä×¥0¦\u0006\u0003U\u001d#\u00040\u0014Ç}Â!\u0017V%Óßkãä×¥¡x¤v0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android\t\u0000ÂàFdJ00\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0001\u0001\u0000mÒRÎï0,6\nªÎÏòÌ©\u0004»]z\u0016aø®F²B\u0004ÐÿJhÇí\u001aS\u001eÄYZb<æ\u0007c±g)zzãW\u0012Ä\u0007ò\bðË\u0010)\u0012M{\u0010b\u0019ÀÊ>³ù­_¸qï&âñmDÈÙ l²ð\u0005»?âËD~s\u0010v­E³?`\tê\u0019Áaæ&Aª'\u001dýR(ÅÅ]ÛE'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\u000b\u0010q§Ä@ðþ \u001c¶'ÊgCiÐ½/Ù\u0011ÿ\u0006Í¿,ú\u0010Ü\u000f:ãWbHÇïÆLqD\u0017B÷\u0005ÉÞW:õ[9\r×ý¹A1]_u0\u0011&ÿb\u0014\u0010Ài0");
            }
        }

        class C12162 extends C1214c {
            C12162(byte[] bArr) {
                super(bArr);
            }

            protected byte[] mo850d() {
                return C1212a.m5662a("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u000001\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u001e\u0017\r080415233656Z\u0017\r350901233656Z01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000ÖÎ.\b\n¿â1MÑ³ÏÓ\u0018\\´=3ú\ftá½¶ÑÛ\u0013ö,\\9ßVøF=e¾ÀóÊBk\u0007Å¨íZ9ÁgçkÉ¹'K\u000b\"\u0000\u0019©)\u0015årÅm*0\u001b£oÅü\u0011:ÖËt5¡m#«}úîáeäß\u001f\n½§\nQlN\u0005\u0011Ê|\fU\u0017[ÃuùHÅj®\b¤O¦¤Ý}¿,\n5\"­\u0006¸Ì\u0018^±Uyîøm\b\u000b\u001daÀù¯±ÂëÑ\u0007êE«Ûh£Ç^TÇlSÔ\u000b\u0012\u001dç»Ó\u000eb\f\u0018áªaÛ¼Ý<d_/UóÔÃuì@p©?qQØ6pÁj\u001a¾^òÑ\u0018á¸®ó)ðf¿láD¬èm\u001c\u001b\u000f\u0002\u0001\u0003£ü0ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u001cÅ¾LC<a:\u0015°L¼\u0003òOà²0É\u0006\u0003U\u001d#\u0004Á0¾\u0014\u001cÅ¾LC<a:\u0015°L¼\u0003òOà²¡¤01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com\t\u0000Õ¸l}ÓNõ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0001\u0001\u0000\u0019Ó\fñ\u0005ûx?L\r}Ò##=@zÏÎ\u0000\b\u001d[×ÆéÖí k\u000e\u0011 \u0006Al¢D\u0013ÒkJ àõ$ÊÒ»\\nL¡\u0001j\u0015n¡ì]ÉZ^:\u0001\u00006ôHÕ\u0010¿.\u001eag:;åm¯\u000bw±Â)ãÂUãèL]#ïº\tËñ; +NZ\"É2cHJ#Òü)ú\u00199u3¯Øª\u0016\u000fBÂÐ\u0016>fCéÁ/ Á33[Àÿk\"ÞÑ­DB)¥9©Nï­«ÐeÎÒK>QåÝ{fx{ï\u0012þû¤Ä#ûOøÌIL\u0002ðõ\u0005\u0016\u0012ÿe)9>FêÅ»!òwÁQª_*¦'Ñè§\n¶\u00035iÞ;¿ÿ|©Ú>\u0012Cö\u000b");
            }
        }
    }

    static synchronized void m5671a(Context context) {
        synchronized (C1218j.class) {
            if (f3189a != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f3189a = context.getApplicationContext();
            }
        }
    }
}
