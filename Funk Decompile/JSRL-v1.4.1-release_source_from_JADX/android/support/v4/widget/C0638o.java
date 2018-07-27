package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter */
public abstract class C0638o extends C0616b {
    private int f1231j;
    private int f1232k;
    private LayoutInflater f1233l;

    @Deprecated
    public C0638o(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1232k = i;
        this.f1231j = i;
        this.f1233l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View mo472a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1233l.inflate(this.f1231j, viewGroup, false);
    }

    public View mo473b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1233l.inflate(this.f1232k, viewGroup, false);
    }
}
