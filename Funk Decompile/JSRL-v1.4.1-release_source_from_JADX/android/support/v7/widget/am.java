package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.p018b.C0185a;
import android.support.v4.widget.C0638o;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0664f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter */
class am extends C0638o implements OnClickListener {
    private final SearchManager f2205j = ((SearchManager) this.d.getSystemService("search"));
    private final SearchView f2206k;
    private final SearchableInfo f2207l;
    private final Context f2208m;
    private final WeakHashMap<String, ConstantState> f2209n;
    private final int f2210o;
    private boolean f2211p = false;
    private int f2212q = 1;
    private ColorStateList f2213r;
    private int f2214s = -1;
    private int f2215t = -1;
    private int f2216u = -1;
    private int f2217v = -1;
    private int f2218w = -1;
    private int f2219x = -1;

    /* compiled from: SuggestionsAdapter */
    private static final class C0844a {
        public final TextView f2200a;
        public final TextView f2201b;
        public final ImageView f2202c;
        public final ImageView f2203d;
        public final ImageView f2204e;

        public C0844a(View view) {
            this.f2200a = (TextView) view.findViewById(16908308);
            this.f2201b = (TextView) view.findViewById(16908309);
            this.f2202c = (ImageView) view.findViewById(16908295);
            this.f2203d = (ImageView) view.findViewById(16908296);
            this.f2204e = (ImageView) view.findViewById(C0664f.edit_query);
        }
    }

    public am(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2206k = searchView;
        this.f2207l = searchableInfo;
        this.f2210o = searchView.getSuggestionCommitIconResId();
        this.f2208m = context;
        this.f2209n = weakHashMap;
    }

    public void m4278a(int i) {
        this.f2212q = i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public Cursor mo454a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f2206k.getVisibility() != 0 || this.f2206k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m4274a(this.f2207l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m4270d(mo453a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m4270d(mo453a());
    }

    private void m4270d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public void mo455a(Cursor cursor) {
        if (this.f2211p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo455a(cursor);
            if (cursor != null) {
                this.f2214s = cursor.getColumnIndex("suggest_text_1");
                this.f2215t = cursor.getColumnIndex("suggest_text_2");
                this.f2216u = cursor.getColumnIndex("suggest_text_2_url");
                this.f2217v = cursor.getColumnIndex("suggest_icon_1");
                this.f2218w = cursor.getColumnIndex("suggest_icon_2");
                this.f2219x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public View mo472a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo472a(context, cursor, viewGroup);
        a.setTag(new C0844a(a));
        ((ImageView) a.findViewById(C0664f.edit_query)).setImageResource(this.f2210o);
        return a;
    }

    public void mo672a(View view, Context context, Cursor cursor) {
        C0844a c0844a = (C0844a) view.getTag();
        int i;
        if (this.f2219x != -1) {
            i = cursor.getInt(this.f2219x);
        } else {
            i = 0;
        }
        if (c0844a.f2200a != null) {
            m4264a(c0844a.f2200a, m4261a(cursor, this.f2214s));
        }
        if (c0844a.f2201b != null) {
            CharSequence a = m4261a(cursor, this.f2216u);
            if (a != null) {
                a = m4269b(a);
            } else {
                a = m4261a(cursor, this.f2215t);
            }
            if (TextUtils.isEmpty(a)) {
                if (c0844a.f2200a != null) {
                    c0844a.f2200a.setSingleLine(false);
                    c0844a.f2200a.setMaxLines(2);
                }
            } else if (c0844a.f2200a != null) {
                c0844a.f2200a.setSingleLine(true);
                c0844a.f2200a.setMaxLines(1);
            }
            m4264a(c0844a.f2201b, a);
        }
        if (c0844a.f2202c != null) {
            m4263a(c0844a.f2202c, m4271e(cursor), 4);
        }
        if (c0844a.f2203d != null) {
            m4263a(c0844a.f2203d, m4272f(cursor), 8);
        }
        if (this.f2212q == 2 || (this.f2212q == 1 && (r1 & 1) != 0)) {
            c0844a.f2204e.setVisibility(0);
            c0844a.f2204e.setTag(c0844a.f2200a.getText());
            c0844a.f2204e.setOnClickListener(this);
            return;
        }
        c0844a.f2204e.setVisibility(8);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2206k.m3888a((CharSequence) tag);
        }
    }

    private CharSequence m4269b(CharSequence charSequence) {
        if (this.f2213r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0659a.textColorSearchUrl, typedValue, true);
            this.f2213r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2213r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m4264a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable m4271e(Cursor cursor) {
        if (this.f2217v == -1) {
            return null;
        }
        Drawable a = m4260a(cursor.getString(this.f2217v));
        return a == null ? m4273g(cursor) : a;
    }

    private Drawable m4272f(Cursor cursor) {
        if (this.f2218w == -1) {
            return null;
        }
        return m4260a(cursor.getString(this.f2218w));
    }

    private void m4263a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence mo456c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m4262a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f2207l.shouldRewriteQueryFromData()) {
            a = m4262a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f2207l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m4262a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo472a(this.d, this.c, viewGroup);
            if (a != null) {
                ((C0844a) a.getTag()).f2200a.setText(e.toString());
            }
            return a;
        }
    }

    private Drawable m4260a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        Drawable b;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2208m.getPackageName() + "/" + parseInt;
            b = m4268b(str2);
            if (b != null) {
                return b;
            }
            b = C0185a.m612a(this.f2208m, parseInt);
            m4265a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m4268b(str);
            if (b != null) {
                return b;
            }
            b = m4267b(Uri.parse(str));
            m4265a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable m4267b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m4276a(uri);
            }
            openInputStream = this.f2208m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m4268b(String str) {
        ConstantState constantState = (ConstantState) this.f2209n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void m4265a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2209n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m4273g(Cursor cursor) {
        Drawable a = m4259a(this.f2207l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable m4259a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f2209n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f2209n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f2208m.getResources());
        } else {
            Drawable b = m4266b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f2209n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m4266b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String m4262a(Cursor cursor, String str) {
        return m4261a(cursor, cursor.getColumnIndex(str));
    }

    private static String m4261a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    Drawable m4276a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor m4274a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }
}
