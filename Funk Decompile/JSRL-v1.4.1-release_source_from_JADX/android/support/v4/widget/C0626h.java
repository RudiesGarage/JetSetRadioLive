package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

/* compiled from: ListViewCompat */
public final class C0626h {
    public static void m2661a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            C0628j.m2663a(listView, i);
        } else {
            C0627i.m2662a(listView, i);
        }
    }
}
