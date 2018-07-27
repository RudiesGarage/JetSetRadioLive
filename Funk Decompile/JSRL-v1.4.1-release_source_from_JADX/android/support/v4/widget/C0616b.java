package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.C0617c.C0615a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* compiled from: CursorAdapter */
public abstract class C0616b extends BaseAdapter implements C0615a, Filterable {
    protected boolean f1214a;
    protected boolean f1215b;
    protected Cursor f1216c;
    protected Context f1217d;
    protected int f1218e;
    protected C0613a f1219f;
    protected DataSetObserver f1220g;
    protected C0617c f1221h;
    protected FilterQueryProvider f1222i;

    /* compiled from: CursorAdapter */
    private class C0613a extends ContentObserver {
        final /* synthetic */ C0616b f1212a;

        C0613a(C0616b c0616b) {
            this.f1212a = c0616b;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.f1212a.m2611b();
        }
    }

    /* compiled from: CursorAdapter */
    private class C0614b extends DataSetObserver {
        final /* synthetic */ C0616b f1213a;

        C0614b(C0616b c0616b) {
            this.f1213a = c0616b;
        }

        public void onChanged() {
            this.f1213a.f1214a = true;
            this.f1213a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f1213a.f1214a = false;
            this.f1213a.notifyDataSetInvalidated();
        }
    }

    public abstract View mo472a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void mo672a(View view, Context context, Cursor cursor);

    public C0616b(Context context, Cursor cursor, boolean z) {
        m2606a(context, cursor, z ? 1 : 2);
    }

    void m2606a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f1215b = true;
        } else {
            this.f1215b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f1216c = cursor;
        this.f1214a = z;
        this.f1217d = context;
        this.f1218e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f1219f = new C0613a(this);
            this.f1220g = new C0614b(this);
        } else {
            this.f1219f = null;
            this.f1220g = null;
        }
        if (z) {
            if (this.f1219f != null) {
                cursor.registerContentObserver(this.f1219f);
            }
            if (this.f1220g != null) {
                cursor.registerDataSetObserver(this.f1220g);
            }
        }
    }

    public Cursor mo453a() {
        return this.f1216c;
    }

    public int getCount() {
        if (!this.f1214a || this.f1216c == null) {
            return 0;
        }
        return this.f1216c.getCount();
    }

    public Object getItem(int i) {
        if (!this.f1214a || this.f1216c == null) {
            return null;
        }
        this.f1216c.moveToPosition(i);
        return this.f1216c;
    }

    public long getItemId(int i) {
        if (this.f1214a && this.f1216c != null && this.f1216c.moveToPosition(i)) {
            return this.f1216c.getLong(this.f1218e);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1214a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1216c.moveToPosition(i)) {
            if (view == null) {
                view = mo472a(this.f1217d, this.f1216c, viewGroup);
            }
            mo672a(view, this.f1217d, this.f1216c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1214a) {
            return null;
        }
        this.f1216c.moveToPosition(i);
        if (view == null) {
            view = mo473b(this.f1217d, this.f1216c, viewGroup);
        }
        mo672a(view, this.f1217d, this.f1216c);
        return view;
    }

    public View mo473b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo472a(context, cursor, viewGroup);
    }

    public void mo455a(Cursor cursor) {
        Cursor b = m2609b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public Cursor m2609b(Cursor cursor) {
        if (cursor == this.f1216c) {
            return null;
        }
        Cursor cursor2 = this.f1216c;
        if (cursor2 != null) {
            if (this.f1219f != null) {
                cursor2.unregisterContentObserver(this.f1219f);
            }
            if (this.f1220g != null) {
                cursor2.unregisterDataSetObserver(this.f1220g);
            }
        }
        this.f1216c = cursor;
        if (cursor != null) {
            if (this.f1219f != null) {
                cursor.registerContentObserver(this.f1219f);
            }
            if (this.f1220g != null) {
                cursor.registerDataSetObserver(this.f1220g);
            }
            this.f1218e = cursor.getColumnIndexOrThrow("_id");
            this.f1214a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f1218e = -1;
        this.f1214a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public CharSequence mo456c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor mo454a(CharSequence charSequence) {
        if (this.f1222i != null) {
            return this.f1222i.runQuery(charSequence);
        }
        return this.f1216c;
    }

    public Filter getFilter() {
        if (this.f1221h == null) {
            this.f1221h = new C0617c(this);
        }
        return this.f1221h;
    }

    protected void m2611b() {
        if (this.f1215b && this.f1216c != null && !this.f1216c.isClosed()) {
            this.f1214a = this.f1216c.requery();
        }
    }
}
