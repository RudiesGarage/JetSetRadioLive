package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p020d.p021a.C0319b;
import android.support.v4.p020d.p021a.C0320c;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: MenuWrapperFactory */
public final class C0737o {
    public static MenuItem m3107a(Context context, C0319b c0319b) {
        if (VERSION.SDK_INT >= 16) {
            return new C0733j(context, c0319b);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0731i(context, c0319b);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m3108a(Context context, C0320c c0320c) {
        if (VERSION.SDK_INT >= 14) {
            return new C0742t(context, c0320c);
        }
        throw new UnsupportedOperationException();
    }
}
