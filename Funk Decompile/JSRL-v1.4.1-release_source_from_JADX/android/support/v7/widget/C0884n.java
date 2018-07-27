package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ab;
import android.support.v4.view.ae;
import android.support.v7.p027b.C0670a.C0666h;
import android.support.v7.p027b.C0670a.C0669k;
import android.support.v7.p028c.p029a.C0673b;
import android.support.v7.view.C0698c;
import android.support.v7.view.menu.C0719q;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* compiled from: AppCompatSpinner */
public class C0884n extends Spinner implements ab {
    static final boolean f2379a;
    private static final boolean f2380e;
    private static final int[] f2381f = new int[]{16843505};
    C0883b f2382b;
    int f2383c;
    final Rect f2384d;
    private C0868h f2385g;
    private Context f2386h;
    private C0702x f2387i;
    private SpinnerAdapter f2388j;
    private boolean f2389k;

    /* compiled from: AppCompatSpinner */
    private static class C0879a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter f2368a;
        private ListAdapter f2369b;

        public C0879a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f2368a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2369b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (C0884n.f2379a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof ao) {
                ao aoVar = (ao) spinnerAdapter;
                if (aoVar.m4287a() == null) {
                    aoVar.m4288a(theme);
                }
            }
        }

        public int getCount() {
            return this.f2368a == null ? 0 : this.f2368a.getCount();
        }

        public Object getItem(int i) {
            return this.f2368a == null ? null : this.f2368a.getItem(i);
        }

        public long getItemId(int i) {
            return this.f2368a == null ? -1 : this.f2368a.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f2368a == null) {
                return null;
            }
            return this.f2368a.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.f2368a != null && this.f2368a.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2368a != null) {
                this.f2368a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2368a != null) {
                this.f2368a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2369b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2369b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* compiled from: AppCompatSpinner */
    private class C0883b extends aa {
        ListAdapter f2375a;
        final /* synthetic */ C0884n f2376b;
        private CharSequence f2377h;
        private final Rect f2378i = new Rect();

        /* compiled from: AppCompatSpinner */
        class C08812 implements OnGlobalLayoutListener {
            final /* synthetic */ C0883b f2372a;

            C08812(C0883b c0883b) {
                this.f2372a = c0883b;
            }

            public void onGlobalLayout() {
                if (this.f2372a.m4501a(this.f2372a.f2376b)) {
                    this.f2372a.mo696f();
                    super.mo518a();
                    return;
                }
                this.f2372a.mo525c();
            }
        }

        public C0883b(final C0884n c0884n, Context context, AttributeSet attributeSet, int i) {
            this.f2376b = c0884n;
            super(context, attributeSet, i);
            m4117b((View) c0884n);
            m4115a(true);
            m4109a(0);
            m4112a(new OnItemClickListener(this) {
                final /* synthetic */ C0883b f2371b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f2371b.f2376b.setSelection(i);
                    if (this.f2371b.f2376b.getOnItemClickListener() != null) {
                        this.f2371b.f2376b.performItemClick(view, i, this.f2371b.f2375a.getItemId(i));
                    }
                    this.f2371b.mo525c();
                }
            });
        }

        public void mo694a(ListAdapter listAdapter) {
            super.mo694a(listAdapter);
            this.f2375a = listAdapter;
        }

        public CharSequence mo695b() {
            return this.f2377h;
        }

        public void m4500a(CharSequence charSequence) {
            this.f2377h = charSequence;
        }

        void mo696f() {
            int i;
            int i2;
            Drawable h = m4127h();
            if (h != null) {
                h.getPadding(this.f2376b.f2384d);
                i = aw.m4362a(this.f2376b) ? this.f2376b.f2384d.right : -this.f2376b.f2384d.left;
            } else {
                Rect rect = this.f2376b.f2384d;
                this.f2376b.f2384d.right = 0;
                rect.left = 0;
                i = 0;
            }
            int paddingLeft = this.f2376b.getPaddingLeft();
            int paddingRight = this.f2376b.getPaddingRight();
            int width = this.f2376b.getWidth();
            if (this.f2376b.f2383c == -2) {
                int a = this.f2376b.m4504a((SpinnerAdapter) this.f2375a, m4127h());
                i2 = (this.f2376b.getContext().getResources().getDisplayMetrics().widthPixels - this.f2376b.f2384d.left) - this.f2376b.f2384d.right;
                if (a <= i2) {
                    i2 = a;
                }
                m4125g(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.f2376b.f2383c == -1) {
                m4125g((width - paddingLeft) - paddingRight);
            } else {
                m4125g(this.f2376b.f2383c);
            }
            if (aw.m4362a(this.f2376b)) {
                i2 = ((width - paddingRight) - m4133l()) + i;
            } else {
                i2 = i + paddingLeft;
            }
            m4119c(i2);
        }

        public void mo518a() {
            boolean d = mo528d();
            mo696f();
            m4128h(2);
            super.mo518a();
            mo529e().setChoiceMode(1);
            m4130i(this.f2376b.getSelectedItemPosition());
            if (!d) {
                ViewTreeObserver viewTreeObserver = this.f2376b.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener c08812 = new C08812(this);
                    viewTreeObserver.addOnGlobalLayoutListener(c08812);
                    m4114a(new OnDismissListener(this) {
                        final /* synthetic */ C0883b f2374b;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.f2374b.f2376b.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(c08812);
                            }
                        }
                    });
                }
            }
        }

        boolean m4501a(View view) {
            return ae.m2244x(view) && view.getGlobalVisibleRect(this.f2378i);
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        f2379a = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        f2380e = z;
    }

    public C0884n(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0884n(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public C0884n(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        Throwable e;
        final C0883b c0883b;
        as a;
        CharSequence[] e2;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.f2384d = new Rect();
        as a2 = as.m4294a(context, attributeSet, C0669k.Spinner, i, 0);
        this.f2385g = new C0868h(this);
        if (theme != null) {
            this.f2386h = new C0698c(context, theme);
        } else {
            int g = a2.m4310g(C0669k.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f2386h = new C0698c(context, g);
            } else {
                this.f2386h = !f2379a ? context : null;
            }
        }
        if (this.f2386h != null) {
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    TypedArray obtainStyledAttributes;
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2381f, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    c0883b = new C0883b(this, this.f2386h, attributeSet, i);
                                    a = as.m4294a(this.f2386h, attributeSet, C0669k.Spinner, i, 0);
                                    this.f2383c = a.m4308f(C0669k.Spinner_android_dropDownWidth, -2);
                                    c0883b.m4111a(a.m4297a(C0669k.Spinner_android_popupBackground));
                                    c0883b.m4500a(a2.m4303c(C0669k.Spinner_android_prompt));
                                    a.m4298a();
                                    this.f2382b = c0883b;
                                    this.f2387i = new C0702x(this, this) {
                                        final /* synthetic */ C0884n f2367b;

                                        public C0719q mo485a() {
                                            return c0883b;
                                        }

                                        public boolean mo486b() {
                                            if (!this.f2367b.f2382b.mo528d()) {
                                                this.f2367b.f2382b.mo518a();
                                            }
                                            return true;
                                        }
                                    };
                                }
                                e2 = a2.m4307e(C0669k.Spinner_android_entries);
                                if (e2 != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                                    arrayAdapter.setDropDownViewResource(C0666h.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a2.m4298a();
                                this.f2389k = true;
                                if (this.f2388j != null) {
                                    setAdapter(this.f2388j);
                                    this.f2388j = null;
                                }
                                this.f2385g.m4450a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            c0883b = new C0883b(this, this.f2386h, attributeSet, i);
                            a = as.m4294a(this.f2386h, attributeSet, C0669k.Spinner, i, 0);
                            this.f2383c = a.m4308f(C0669k.Spinner_android_dropDownWidth, -2);
                            c0883b.m4111a(a.m4297a(C0669k.Spinner_android_popupBackground));
                            c0883b.m4500a(a2.m4303c(C0669k.Spinner_android_prompt));
                            a.m4298a();
                            this.f2382b = c0883b;
                            this.f2387i = /* anonymous class already generated */;
                        }
                        e2 = a2.m4307e(C0669k.Spinner_android_entries);
                        if (e2 != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                            arrayAdapter.setDropDownViewResource(C0666h.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.m4298a();
                        this.f2389k = true;
                        if (this.f2388j != null) {
                            setAdapter(this.f2388j);
                            this.f2388j = null;
                        }
                        this.f2385g.m4450a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                c0883b = new C0883b(this, this.f2386h, attributeSet, i);
                a = as.m4294a(this.f2386h, attributeSet, C0669k.Spinner, i, 0);
                this.f2383c = a.m4308f(C0669k.Spinner_android_dropDownWidth, -2);
                c0883b.m4111a(a.m4297a(C0669k.Spinner_android_popupBackground));
                c0883b.m4500a(a2.m4303c(C0669k.Spinner_android_prompt));
                a.m4298a();
                this.f2382b = c0883b;
                this.f2387i = /* anonymous class already generated */;
            }
        }
        e2 = a2.m4307e(C0669k.Spinner_android_entries);
        if (e2 != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
            arrayAdapter.setDropDownViewResource(C0666h.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.m4298a();
        this.f2389k = true;
        if (this.f2388j != null) {
            setAdapter(this.f2388j);
            this.f2388j = null;
        }
        this.f2385g.m4450a(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.f2382b != null) {
            return this.f2386h;
        }
        if (f2379a) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f2382b != null) {
            this.f2382b.m4111a(drawable);
        } else if (f2380e) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0673b.m2768b(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.f2382b != null) {
            return this.f2382b.m4127h();
        }
        if (f2380e) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f2382b != null) {
            this.f2382b.m4120d(i);
        } else if (f2380e) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.f2382b != null) {
            return this.f2382b.m4132k();
        }
        if (f2380e) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f2382b != null) {
            this.f2382b.m4119c(i);
        } else if (f2380e) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.f2382b != null) {
            return this.f2382b.m4131j();
        }
        if (f2380e) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.f2382b != null) {
            this.f2383c = i;
        } else if (f2380e) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.f2382b != null) {
            return this.f2383c;
        }
        if (f2380e) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f2389k) {
            super.setAdapter(spinnerAdapter);
            if (this.f2382b != null) {
                this.f2382b.mo694a(new C0879a(spinnerAdapter, (this.f2386h == null ? getContext() : this.f2386h).getTheme()));
                return;
            }
            return;
        }
        this.f2388j = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2382b != null && this.f2382b.mo528d()) {
            this.f2382b.mo525c();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f2387i == null || !this.f2387i.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2382b != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m4504a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.f2382b == null) {
            return super.performClick();
        }
        if (!this.f2382b.mo528d()) {
            this.f2382b.mo518a();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f2382b != null) {
            this.f2382b.m4500a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.f2382b != null ? this.f2382b.mo695b() : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2385g != null) {
            this.f2385g.m4446a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2385g != null) {
            this.f2385g.m4449a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2385g != null) {
            this.f2385g.m4447a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2385g != null ? this.f2385g.m4445a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2385g != null) {
            this.f2385g.m4448a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2385g != null ? this.f2385g.m4451b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2385g != null) {
            this.f2385g.m4453c();
        }
    }

    int m4504a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f2384d);
        return (this.f2384d.left + this.f2384d.right) + i;
    }
}
