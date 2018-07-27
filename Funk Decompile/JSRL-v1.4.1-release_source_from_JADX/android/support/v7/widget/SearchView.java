package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.p018b.p019a.C0278a;
import android.support.v4.p022e.C0325d;
import android.support.v4.p022e.C0326e;
import android.support.v4.view.AbsSavedState;
import android.support.v4.widget.C0616b;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0662d;
import android.support.v7.view.C0697b;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends C0754z implements C0697b {
    static final C0804a f1904i = new C0804a();
    private OnClickListener f1905A;
    private boolean f1906B;
    private boolean f1907C;
    private boolean f1908D;
    private CharSequence f1909E;
    private boolean f1910F;
    private boolean f1911G;
    private int f1912H;
    private boolean f1913I;
    private CharSequence f1914J;
    private boolean f1915K;
    private int f1916L;
    private Bundle f1917M;
    private Runnable f1918N;
    private final Runnable f1919O;
    private Runnable f1920P;
    private final WeakHashMap<String, ConstantState> f1921Q;
    final SearchAutoComplete f1922a;
    final ImageView f1923b;
    final ImageView f1924c;
    final ImageView f1925d;
    final ImageView f1926e;
    OnFocusChangeListener f1927f;
    C0616b f1928g;
    SearchableInfo f1929h;
    private final View f1930j;
    private final View f1931k;
    private C0808e f1932l;
    private Rect f1933m;
    private Rect f1934n;
    private int[] f1935o;
    private int[] f1936p;
    private final ImageView f1937q;
    private final Drawable f1938r;
    private final int f1939s;
    private final int f1940t;
    private final Intent f1941u;
    private final Intent f1942v;
    private final CharSequence f1943w;
    private C0806c f1944x;
    private C0805b f1945y;
    private C0807d f1946z;

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = C0325d.m1196a(new C08021());
        boolean f1888b;

        static class C08021 implements C0326e<SavedState> {
            C08021() {
            }

            public /* synthetic */ Object mo280a(Parcel parcel, ClassLoader classLoader) {
                return m3863b(parcel, classLoader);
            }

            public /* synthetic */ Object[] mo281a(int i) {
                return m3864b(i);
            }

            public SavedState m3863b(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m3864b(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1888b = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1888b));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1888b + "}";
        }
    }

    public static class SearchAutoComplete extends C0803g {
        private int f1892a;
        private SearchView f1893b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0659a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1892a = getThreshold();
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.f1893b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1892a = i;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1893b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m3874a(getContext())) {
                    SearchView.f1904i.m3866a(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1893b.m3895h();
        }

        public boolean enoughToFilter() {
            return this.f1892a <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1893b.clearFocus();
                        this.f1893b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int b = C0278a.m1053b(getResources());
            int a = C0278a.m1052a(getResources());
            if (b >= 960 && a >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (b >= 600 || (b >= 640 && a >= 480)) {
                return 192;
            }
            return 160;
        }
    }

    private static class C0804a {
        private Method f1894a;
        private Method f1895b;
        private Method f1896c;
        private Method f1897d;

        C0804a() {
            try {
                this.f1894a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1894a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f1895b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1895b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f1896c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1896c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.f1897d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.f1897d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void m3865a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1894a != null) {
                try {
                    this.f1894a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m3867b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1895b != null) {
                try {
                    this.f1895b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m3866a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f1896c != null) {
                try {
                    this.f1896c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }
    }

    public interface C0805b {
        boolean m3868a();
    }

    public interface C0806c {
        boolean m3869a(String str);
    }

    public interface C0807d {
    }

    private static class C0808e extends TouchDelegate {
        private final View f1898a;
        private final Rect f1899b = new Rect();
        private final Rect f1900c = new Rect();
        private final Rect f1901d = new Rect();
        private final int f1902e;
        private boolean f1903f;

        public C0808e(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1902e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            m3870a(rect, rect2);
            this.f1898a = view;
        }

        public void m3870a(Rect rect, Rect rect2) {
            this.f1899b.set(rect);
            this.f1901d.set(rect);
            this.f1901d.inset(-this.f1902e, -this.f1902e);
            this.f1900c.set(rect2);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
            r6 = this;
            r1 = 1;
            r0 = 0;
            r2 = r7.getX();
            r3 = (int) r2;
            r2 = r7.getY();
            r4 = (int) r2;
            r2 = r7.getAction();
            switch(r2) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0048;
                case 2: goto L_0x0048;
                case 3: goto L_0x0056;
                default: goto L_0x0013;
            };
        L_0x0013:
            r2 = r0;
        L_0x0014:
            if (r2 == 0) goto L_0x003b;
        L_0x0016:
            if (r1 == 0) goto L_0x005b;
        L_0x0018:
            r0 = r6.f1900c;
            r0 = r0.contains(r3, r4);
            if (r0 != 0) goto L_0x005b;
        L_0x0020:
            r0 = r6.f1898a;
            r0 = r0.getWidth();
            r0 = r0 / 2;
            r0 = (float) r0;
            r1 = r6.f1898a;
            r1 = r1.getHeight();
            r1 = r1 / 2;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
        L_0x0035:
            r0 = r6.f1898a;
            r0 = r0.dispatchTouchEvent(r7);
        L_0x003b:
            return r0;
        L_0x003c:
            r2 = r6.f1899b;
            r2 = r2.contains(r3, r4);
            if (r2 == 0) goto L_0x0013;
        L_0x0044:
            r6.f1903f = r1;
            r2 = r1;
            goto L_0x0014;
        L_0x0048:
            r2 = r6.f1903f;
            if (r2 == 0) goto L_0x0014;
        L_0x004c:
            r5 = r6.f1901d;
            r5 = r5.contains(r3, r4);
            if (r5 != 0) goto L_0x0014;
        L_0x0054:
            r1 = r0;
            goto L_0x0014;
        L_0x0056:
            r2 = r6.f1903f;
            r6.f1903f = r0;
            goto L_0x0014;
        L_0x005b:
            r0 = r6.f1900c;
            r0 = r0.left;
            r0 = r3 - r0;
            r0 = (float) r0;
            r1 = r6.f1900c;
            r1 = r1.top;
            r1 = r4 - r1;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
            goto L_0x0035;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.e.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    int getSuggestionRowLayout() {
        return this.f1939s;
    }

    int getSuggestionCommitIconResId() {
        return this.f1940t;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1929h = searchableInfo;
        if (this.f1929h != null) {
            m3884p();
            m3883o();
        }
        this.f1913I = m3878j();
        if (this.f1913I) {
            this.f1922a.setPrivateImeOptions("nm");
        }
        m3873a(m3891c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1917M = bundle;
    }

    public void setImeOptions(int i) {
        this.f1922a.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f1922a.getImeOptions();
    }

    public void setInputType(int i) {
        this.f1922a.setInputType(i);
    }

    public int getInputType() {
        return this.f1922a.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1911G || !isFocusable()) {
            return false;
        }
        if (m3891c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1922a.requestFocus(i, rect);
        if (requestFocus) {
            m3873a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.f1911G = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1922a.clearFocus();
        this.f1911G = false;
    }

    public void setOnQueryTextListener(C0806c c0806c) {
        this.f1944x = c0806c;
    }

    public void setOnCloseListener(C0805b c0805b) {
        this.f1945y = c0805b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f1927f = onFocusChangeListener;
    }

    public void setOnSuggestionListener(C0807d c0807d) {
        this.f1946z = c0807d;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f1905A = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f1922a.getText();
    }

    public void m3889a(CharSequence charSequence, boolean z) {
        this.f1922a.setText(charSequence);
        if (charSequence != null) {
            this.f1922a.setSelection(this.f1922a.length());
            this.f1914J = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m3892d();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1909E = charSequence;
        m3883o();
    }

    public CharSequence getQueryHint() {
        if (this.f1909E != null) {
            return this.f1909E;
        }
        if (this.f1929h == null || this.f1929h.getHintId() == 0) {
            return this.f1943w;
        }
        return getContext().getText(this.f1929h.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1906B != z) {
            this.f1906B = z;
            m3873a(z);
            m3883o();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            m3893e();
        } else {
            m3894f();
        }
    }

    public boolean m3891c() {
        return this.f1907C;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1908D = z;
        m3873a(m3891c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1910F = z;
        if (this.f1928g instanceof am) {
            ((am) this.f1928g).m4278a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(C0616b c0616b) {
        this.f1928g = c0616b;
        this.f1922a.setAdapter(this.f1928g);
    }

    public C0616b getSuggestionsAdapter() {
        return this.f1928g;
    }

    public void setMaxWidth(int i) {
        this.f1912H = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f1912H;
    }

    protected void onMeasure(int i, int i2) {
        if (m3891c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f1912H <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f1912H, size);
                    break;
                }
            case 0:
                if (this.f1912H <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1912H;
                    break;
                }
            case 1073741824:
                if (this.f1912H > 0) {
                    size = Math.min(this.f1912H, size);
                    break;
                }
                break;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
                mode = Math.min(getPreferredHeight(), mode);
                break;
            case 0:
                mode = getPreferredHeight();
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m3872a(this.f1922a, this.f1933m);
            this.f1934n.set(this.f1933m.left, 0, this.f1933m.right, i4 - i2);
            if (this.f1932l == null) {
                this.f1932l = new C0808e(this.f1934n, this.f1933m, this.f1922a);
                setTouchDelegate(this.f1932l);
                return;
            }
            this.f1932l.m3870a(this.f1934n, this.f1933m);
        }
    }

    private void m3872a(View view, Rect rect) {
        view.getLocationInWindow(this.f1935o);
        getLocationInWindow(this.f1936p);
        int i = this.f1935o[1] - this.f1936p[1];
        int i2 = this.f1935o[0] - this.f1936p[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0662d.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C0662d.abc_search_view_preferred_height);
    }

    private void m3873a(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.f1907C = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.f1922a.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f1923b.setVisibility(i2);
        m3876b(z2);
        View view = this.f1930j;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.f1937q.getDrawable() == null || this.f1906B)) {
            i = 0;
        }
        this.f1937q.setVisibility(i);
        m3881m();
        if (z2) {
            z3 = false;
        }
        m3877c(z3);
        m3880l();
    }

    private boolean m3878j() {
        if (this.f1929h == null || !this.f1929h.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1929h.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1941u;
        } else if (this.f1929h.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1942v;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private boolean m3879k() {
        return (this.f1908D || this.f1913I) && !m3891c();
    }

    private void m3876b(boolean z) {
        int i = 8;
        if (this.f1908D && m3879k() && hasFocus() && (z || !this.f1913I)) {
            i = 0;
        }
        this.f1924c.setVisibility(i);
    }

    private void m3880l() {
        int i = 8;
        if (m3879k() && (this.f1924c.getVisibility() == 0 || this.f1926e.getVisibility() == 0)) {
            i = 0;
        }
        this.f1931k.setVisibility(i);
    }

    private void m3881m() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f1922a.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f1906B || this.f1915K)) {
            i = 0;
        }
        ImageView imageView = this.f1925d;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1925d.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m3882n() {
        post(this.f1919O);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1919O);
        post(this.f1920P);
        super.onDetachedFromWindow();
    }

    void setImeVisibility(boolean z) {
        if (z) {
            post(this.f1918N);
            return;
        }
        removeCallbacks(this.f1918N);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    void m3888a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    private CharSequence m3875b(CharSequence charSequence) {
        if (!this.f1906B || this.f1938r == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1922a.getTextSize()) * 1.25d);
        this.f1938r.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1938r), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void m3883o() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1922a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m3875b(queryHint));
    }

    private void m3884p() {
        int i = 1;
        this.f1922a.setThreshold(this.f1929h.getSuggestThreshold());
        this.f1922a.setImeOptions(this.f1929h.getImeOptions());
        int inputType = this.f1929h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1929h.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.f1922a.setInputType(inputType);
        if (this.f1928g != null) {
            this.f1928g.mo455a(null);
        }
        if (this.f1929h.getSuggestAuthority() != null) {
            this.f1928g = new am(getContext(), this, this.f1929h, this.f1921Q);
            this.f1922a.setAdapter(this.f1928g);
            am amVar = (am) this.f1928g;
            if (this.f1910F) {
                i = 2;
            }
            amVar.m4278a(i);
        }
    }

    private void m3877c(boolean z) {
        int i;
        if (this.f1913I && !m3891c() && z) {
            i = 0;
            this.f1924c.setVisibility(8);
        } else {
            i = 8;
        }
        this.f1926e.setVisibility(i);
    }

    void m3892d() {
        CharSequence text = this.f1922a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1944x == null || !this.f1944x.m3869a(text.toString())) {
                if (this.f1929h != null) {
                    m3887a(0, null, text.toString());
                }
                setImeVisibility(false);
                m3885q();
            }
        }
    }

    private void m3885q() {
        this.f1922a.dismissDropDown();
    }

    void m3893e() {
        if (!TextUtils.isEmpty(this.f1922a.getText())) {
            this.f1922a.setText("");
            this.f1922a.requestFocus();
            setImeVisibility(true);
        } else if (!this.f1906B) {
        } else {
            if (this.f1945y == null || !this.f1945y.m3868a()) {
                clearFocus();
                m3873a(true);
            }
        }
    }

    void m3894f() {
        m3873a(false);
        this.f1922a.requestFocus();
        setImeVisibility(true);
        if (this.f1905A != null) {
            this.f1905A.onClick(this);
        }
    }

    void m3895h() {
        m3873a(m3891c());
        m3882n();
        if (this.f1922a.hasFocus()) {
            m3896i();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m3882n();
    }

    public void mo537b() {
        m3889a((CharSequence) "", false);
        clearFocus();
        m3873a(true);
        this.f1922a.setImeOptions(this.f1916L);
        this.f1915K = false;
    }

    public void mo536a() {
        if (!this.f1915K) {
            this.f1915K = true;
            this.f1916L = this.f1922a.getImeOptions();
            this.f1922a.setImeOptions(this.f1916L | 33554432);
            this.f1922a.setText("");
            setIconified(false);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1888b = m3891c();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.m1712a());
            m3873a(savedState.f1888b);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void setQuery(CharSequence charSequence) {
        this.f1922a.setText(charSequence);
        this.f1922a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void m3887a(int i, String str, String str2) {
        getContext().startActivity(m3871a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private Intent m3871a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1914J);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1917M != null) {
            intent.putExtra("app_data", this.f1917M);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1929h.getSearchActivity());
        return intent;
    }

    void m3896i() {
        f1904i.m3865a(this.f1922a);
        f1904i.m3867b(this.f1922a);
    }

    static boolean m3874a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
