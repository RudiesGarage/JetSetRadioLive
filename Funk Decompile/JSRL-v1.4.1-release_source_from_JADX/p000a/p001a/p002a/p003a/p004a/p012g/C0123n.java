package p000a.p001a.p002a.p003a.p004a.p012g;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import p000a.p001a.p002a.p003a.C0142c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0021i;

/* compiled from: IconRequest */
public class C0123n {
    public final String f259a;
    public final int f260b;
    public final int f261c;
    public final int f262d;

    public C0123n(String str, int i, int i2, int i3) {
        this.f259a = str;
        this.f260b = i;
        this.f261c = i2;
        this.f262d = i3;
    }

    public static C0123n m412a(Context context, String str) {
        if (str != null) {
            try {
                int l = C0021i.m92l(context);
                C0142c.m468h().mo46a("Fabric", "App icon resource ID is " + l);
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), l, options);
                return new C0123n(str, l, options.outWidth, options.outHeight);
            } catch (Throwable e) {
                C0142c.m468h().mo54e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
