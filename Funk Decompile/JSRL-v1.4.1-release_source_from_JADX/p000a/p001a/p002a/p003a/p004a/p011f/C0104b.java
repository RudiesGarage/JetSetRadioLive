package p000a.p001a.p002a.p003a.p004a.p011f;

import android.content.Context;
import java.io.File;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.C0149i;

/* compiled from: FileStoreImpl */
public class C0104b implements C0103a {
    private final Context f210a;
    private final String f211b;
    private final String f212c;

    public C0104b(C0149i c0149i) {
        if (c0149i.m496E() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f210a = c0149i.m496E();
        this.f211b = c0149i.m498G();
        this.f212c = "Android/" + this.f210a.getPackageName();
    }

    public File mo34a() {
        return m367a(this.f210a.getFilesDir());
    }

    File m367a(File file) {
        if (file == null) {
            C0142c.m468h().mo46a("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            C0142c.m468h().mo51d("Fabric", "Couldn't create file");
        }
        return null;
    }
}
