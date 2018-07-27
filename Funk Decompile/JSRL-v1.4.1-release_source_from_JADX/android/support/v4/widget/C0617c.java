package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* compiled from: CursorFilter */
class C0617c extends Filter {
    C0615a f1223a;

    /* compiled from: CursorFilter */
    interface C0615a {
        Cursor mo453a();

        Cursor mo454a(CharSequence charSequence);

        void mo455a(Cursor cursor);

        CharSequence mo456c(Cursor cursor);
    }

    C0617c(C0615a c0615a) {
        this.f1223a = c0615a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1223a.mo456c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f1223a.mo454a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f1223a.mo453a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f1223a.mo455a((Cursor) filterResults.values);
        }
    }
}
