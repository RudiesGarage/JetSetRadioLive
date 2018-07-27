package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p005a.C0005b;
import p000a.p001a.p002a.p003a.p004a.p005a.C0006d;

/* compiled from: InstallerPackageNameProvider */
public class C0035p {
    private final C0006d<String> f78a = new C00341(this);
    private final C0005b<String> f79b = new C0005b();

    /* compiled from: InstallerPackageNameProvider */
    class C00341 implements C0006d<String> {
        final /* synthetic */ C0035p f77a;

        C00341(C0035p c0035p) {
            this.f77a = c0035p;
        }

        public /* synthetic */ Object mo6b(Context context) {
            return m126a(context);
        }

        public String m126a(Context context) {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    }

    public String m128a(Context context) {
        try {
            String str = (String) this.f79b.mo1a(context, this.f78a);
            if ("".equals(str)) {
                return null;
            }
            return str;
        } catch (Throwable e) {
            C0142c.m468h().mo54e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
