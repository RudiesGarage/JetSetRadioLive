package p000a.p001a.p002a.p003a.p004a.p011f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import p000a.p001a.p002a.p003a.C0149i;

/* compiled from: PreferenceStoreImpl */
public class C0106d implements C0105c {
    private final SharedPreferences f213a;
    private final String f214b;
    private final Context f215c;

    public C0106d(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f215c = context;
        this.f214b = str;
        this.f213a = this.f215c.getSharedPreferences(this.f214b, 0);
    }

    @Deprecated
    public C0106d(C0149i c0149i) {
        this(c0149i.m496E(), c0149i.getClass().getName());
    }

    public SharedPreferences mo35a() {
        return this.f213a;
    }

    public Editor mo37b() {
        return this.f213a.edit();
    }

    @TargetApi(9)
    public boolean mo36a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
