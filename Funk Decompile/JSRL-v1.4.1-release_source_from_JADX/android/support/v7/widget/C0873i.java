package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p013a.p014a.C0159b;
import android.support.p013a.p014a.C0171f;
import android.support.v4.p015c.C0317a;
import android.support.v4.p015c.p016a.C0302a;
import android.support.v4.p018b.C0185a;
import android.support.v4.p024g.C0357a;
import android.support.v4.p024g.C0361e;
import android.support.v4.p024g.C0362f;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0661c;
import android.support.v7.p027b.C0670a.C0663e;
import android.support.v7.p028c.p029a.C0673b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AppCompatDrawableManager */
public final class C0873i {
    private static final Mode f2342a = Mode.SRC_IN;
    private static C0873i f2343b;
    private static final C0871b f2344c = new C0871b(6);
    private static final int[] f2345d = new int[]{C0663e.abc_textfield_search_default_mtrl_alpha, C0663e.abc_textfield_default_mtrl_alpha, C0663e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] f2346e = new int[]{C0663e.abc_ic_commit_search_api_mtrl_alpha, C0663e.abc_seekbar_tick_mark_material, C0663e.abc_ic_menu_share_mtrl_alpha, C0663e.abc_ic_menu_copy_mtrl_am_alpha, C0663e.abc_ic_menu_cut_mtrl_alpha, C0663e.abc_ic_menu_selectall_mtrl_alpha, C0663e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f2347f = new int[]{C0663e.abc_textfield_activated_mtrl_alpha, C0663e.abc_textfield_search_activated_mtrl_alpha, C0663e.abc_cab_background_top_mtrl_alpha, C0663e.abc_text_cursor_material, C0663e.abc_text_select_handle_left_mtrl_dark, C0663e.abc_text_select_handle_middle_mtrl_dark, C0663e.abc_text_select_handle_right_mtrl_dark, C0663e.abc_text_select_handle_left_mtrl_light, C0663e.abc_text_select_handle_middle_mtrl_light, C0663e.abc_text_select_handle_right_mtrl_light};
    private static final int[] f2348g = new int[]{C0663e.abc_popup_background_mtrl_mult, C0663e.abc_cab_background_internal_bg, C0663e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] f2349h = new int[]{C0663e.abc_tab_indicator_material, C0663e.abc_textfield_search_material};
    private static final int[] f2350i = new int[]{C0663e.abc_btn_check_material, C0663e.abc_btn_radio_material};
    private WeakHashMap<Context, SparseArray<ColorStateList>> f2351j;
    private C0357a<String, C0869c> f2352k;
    private SparseArray<String> f2353l;
    private final Object f2354m = new Object();
    private final WeakHashMap<Context, C0361e<WeakReference<ConstantState>>> f2355n = new WeakHashMap(0);
    private TypedValue f2356o;
    private boolean f2357p;

    /* compiled from: AppCompatDrawableManager */
    private interface C0869c {
        Drawable mo693a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    /* compiled from: AppCompatDrawableManager */
    private static class C0870a implements C0869c {
        C0870a() {
        }

        public Drawable mo693a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0159b.m527a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* compiled from: AppCompatDrawableManager */
    private static class C0871b extends C0362f<Integer, PorterDuffColorFilter> {
        public C0871b(int i) {
            super(i);
        }

        PorterDuffColorFilter m4457a(int i, Mode mode) {
            return (PorterDuffColorFilter) m1315a((Object) Integer.valueOf(C0871b.m4456b(i, mode)));
        }

        PorterDuffColorFilter m4458a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) m1316a(Integer.valueOf(C0871b.m4456b(i, mode)), porterDuffColorFilter);
        }

        private static int m4456b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    /* compiled from: AppCompatDrawableManager */
    private static class C0872d implements C0869c {
        C0872d() {
        }

        public Drawable mo693a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0171f.m587a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static C0873i m4467a() {
        if (f2343b == null) {
            f2343b = new C0873i();
            C0873i.m4471a(f2343b);
        }
        return f2343b;
    }

    private static void m4471a(C0873i c0873i) {
        int i = VERSION.SDK_INT;
        if (i < 24) {
            c0873i.m4472a("vector", new C0872d());
            if (i >= 11) {
                c0873i.m4472a("animated-vector", new C0870a());
            }
        }
    }

    public Drawable m4485a(Context context, int i) {
        return m4486a(context, i, false);
    }

    Drawable m4486a(Context context, int i, boolean z) {
        m4468a(context);
        Drawable d = m4482d(context, i);
        if (d == null) {
            d = m4481c(context, i);
        }
        if (d == null) {
            d = C0185a.m612a(context, i);
        }
        if (d != null) {
            d = m4465a(context, i, z, d);
        }
        if (d != null) {
            C0901u.m4589b(d);
        }
        return d;
    }

    private static long m4460a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable m4481c(Context context, int i) {
        if (this.f2356o == null) {
            this.f2356o = new TypedValue();
        }
        TypedValue typedValue = this.f2356o;
        context.getResources().getValue(i, typedValue, true);
        long a = C0873i.m4460a(typedValue);
        Drawable a2 = m4466a(context, a);
        if (a2 == null) {
            if (i == C0663e.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{m4485a(context, C0663e.abc_cab_background_internal_bg), m4485a(context, C0663e.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                m4474a(context, a, a2);
            }
        }
        return a2;
    }

    private Drawable m4465a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m4488b(context, i);
        if (b != null) {
            if (C0901u.m4590c(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = C0302a.m1150f(drawable);
            C0302a.m1141a(drawable, b);
            Mode a = C0873i.m4462a(i);
            if (a == null) {
                return drawable;
            }
            C0302a.m1144a(drawable, a);
            return drawable;
        } else if (i == C0663e.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            C0873i.m4469a(r0.findDrawableByLayerId(16908288), an.m4282a(context, C0659a.colorControlNormal), f2342a);
            C0873i.m4469a(r0.findDrawableByLayerId(16908303), an.m4282a(context, C0659a.colorControlNormal), f2342a);
            C0873i.m4469a(r0.findDrawableByLayerId(16908301), an.m4282a(context, C0659a.colorControlActivated), f2342a);
            return drawable;
        } else if (i == C0663e.abc_ratingbar_material || i == C0663e.abc_ratingbar_indicator_material || i == C0663e.abc_ratingbar_small_material) {
            r0 = (LayerDrawable) drawable;
            C0873i.m4469a(r0.findDrawableByLayerId(16908288), an.m4286c(context, C0659a.colorControlNormal), f2342a);
            C0873i.m4469a(r0.findDrawableByLayerId(16908303), an.m4282a(context, C0659a.colorControlActivated), f2342a);
            C0873i.m4469a(r0.findDrawableByLayerId(16908301), an.m4282a(context, C0659a.colorControlActivated), f2342a);
            return drawable;
        } else if (C0873i.m4473a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m4482d(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.f2352k;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.f2352k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.f2353l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.f2353l;
        r0 = r0.get(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.f2352k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.util.SparseArray;
        r0.<init>();
        r9.f2353l = r0;
    L_0x0036:
        r0 = r9.f2356o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.f2356o = r0;
    L_0x0041:
        r2 = r9.f2356o;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = android.support.v7.widget.C0873i.m4460a(r2);
        r1 = r9.m4466a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.f2353l;
        r2 = "appcompat_skip_skip";
        r1.append(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2353l;	 Catch:{ Exception -> 0x0082 }
        r7.append(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2352k;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (android.support.v7.widget.C0873i.C0869c) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.mo693a(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.m4474a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.i.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m4466a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r2 = 0;
        r3 = r4.f2354m;
        monitor-enter(r3);
        r0 = r4.f2355n;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.p024g.C0361e) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.m1305a(r6);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0031;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0.m1310b(r6);	 Catch:{ all -> 0x002b }
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.i.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean m4474a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f2354m) {
            C0361e c0361e = (C0361e) this.f2355n.get(context);
            if (c0361e == null) {
                c0361e = new C0361e();
                this.f2355n.put(context, c0361e);
            }
            c0361e.m1311b(j, new WeakReference(constantState));
        }
        return true;
    }

    Drawable m4487a(Context context, au auVar, int i) {
        Drawable d = m4482d(context, i);
        if (d == null) {
            d = auVar.m4339a(i);
        }
        if (d != null) {
            return m4465a(context, i, false, d);
        }
        return null;
    }

    static boolean m4473a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = f2342a;
        if (C0873i.m4476a(f2345d, i)) {
            i2 = C0659a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0873i.m4476a(f2347f, i)) {
            i2 = C0659a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0873i.m4476a(f2348g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0663e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == C0663e.abc_dialog_material_background) {
            i2 = 16842801;
            mode = mode2;
            z = true;
            i3 = -1;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (C0901u.m4590c(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(C0873i.m4463a(an.m4282a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void m4472a(String str, C0869c c0869c) {
        if (this.f2352k == null) {
            this.f2352k = new C0357a();
        }
        this.f2352k.put(str, c0869c);
    }

    private static boolean m4476a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    static Mode m4462a(int i) {
        if (i == C0663e.abc_switch_thumb_material) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    ColorStateList m4488b(Context context, int i) {
        return m4484a(context, i, null);
    }

    ColorStateList m4484a(Context context, int i, ColorStateList colorStateList) {
        Object obj = colorStateList == null ? 1 : null;
        ColorStateList e = obj != null ? m4483e(context, i) : null;
        if (e == null) {
            if (i == C0663e.abc_edit_text_material) {
                e = C0673b.m2765a(context, C0661c.abc_tint_edittext);
            } else if (i == C0663e.abc_switch_track_mtrl_alpha) {
                e = C0673b.m2765a(context, C0661c.abc_tint_switch_track);
            } else if (i == C0663e.abc_switch_thumb_material) {
                e = C0673b.m2765a(context, C0661c.abc_tint_switch_thumb);
            } else if (i == C0663e.abc_btn_default_mtrl_shape) {
                e = m4461a(context, colorStateList);
            } else if (i == C0663e.abc_btn_borderless_material) {
                e = m4477b(context, colorStateList);
            } else if (i == C0663e.abc_btn_colored_material) {
                e = m4480c(context, colorStateList);
            } else if (i == C0663e.abc_spinner_mtrl_am_alpha || i == C0663e.abc_spinner_textfield_background_material) {
                e = C0673b.m2765a(context, C0661c.abc_tint_spinner);
            } else if (C0873i.m4476a(f2346e, i)) {
                e = an.m4285b(context, C0659a.colorControlNormal);
            } else if (C0873i.m4476a(f2349h, i)) {
                e = C0673b.m2765a(context, C0661c.abc_tint_default);
            } else if (C0873i.m4476a(f2350i, i)) {
                e = C0673b.m2765a(context, C0661c.abc_tint_btn_checkable);
            } else if (i == C0663e.abc_seekbar_thumb_material) {
                e = C0673b.m2765a(context, C0661c.abc_tint_seek_thumb);
            }
            if (!(obj == null || e == null)) {
                m4478b(context, i, e);
            }
        }
        return e;
    }

    private ColorStateList m4483e(Context context, int i) {
        if (this.f2351j == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.f2351j.get(context);
        if (sparseArray != null) {
            return (ColorStateList) sparseArray.get(i);
        }
        return null;
    }

    private void m4478b(Context context, int i, ColorStateList colorStateList) {
        if (this.f2351j == null) {
            this.f2351j = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.f2351j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f2351j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private ColorStateList m4461a(Context context, ColorStateList colorStateList) {
        return m4479c(context, an.m4282a(context, C0659a.colorButtonNormal), colorStateList);
    }

    private ColorStateList m4477b(Context context, ColorStateList colorStateList) {
        return m4479c(context, 0, null);
    }

    private ColorStateList m4480c(Context context, ColorStateList colorStateList) {
        return m4479c(context, an.m4282a(context, C0659a.colorAccent), colorStateList);
    }

    private ColorStateList m4479c(Context context, int i, ColorStateList colorStateList) {
        r1 = new int[4][];
        int[] iArr = new int[4];
        int a = an.m4282a(context, C0659a.colorControlHighlight);
        int c = an.m4286c(context, C0659a.colorButtonNormal);
        r1[0] = an.f2220a;
        if (colorStateList != null) {
            c = colorStateList.getColorForState(r1[0], 0);
        }
        iArr[0] = c;
        r1[1] = an.f2223d;
        if (colorStateList == null) {
            c = i;
        } else {
            c = colorStateList.getColorForState(r1[1], 0);
        }
        iArr[1] = C0317a.m1186a(a, c);
        r1[2] = an.f2221b;
        if (colorStateList == null) {
            c = i;
        } else {
            c = colorStateList.getColorForState(r1[2], 0);
        }
        iArr[2] = C0317a.m1186a(a, c);
        r1[3] = an.f2227h;
        if (colorStateList != null) {
            i = colorStateList.getColorForState(r1[3], 0);
        }
        iArr[3] = i;
        return new ColorStateList(r1, iArr);
    }

    static void m4470a(Drawable drawable, aq aqVar, int[] iArr) {
        if (!C0901u.m4590c(drawable) || drawable.mutate() == drawable) {
            if (aqVar.f2237e || aqVar.f2236d) {
                drawable.setColorFilter(C0873i.m4464a(aqVar.f2237e ? aqVar.f2234b : null, aqVar.f2236d ? aqVar.f2235c : f2342a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static PorterDuffColorFilter m4464a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return C0873i.m4463a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static PorterDuffColorFilter m4463a(int i, Mode mode) {
        PorterDuffColorFilter a = f2344c.m4457a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f2344c.m4458a(i, mode, a);
        return a;
    }

    private static void m4469a(Drawable drawable, int i, Mode mode) {
        if (C0901u.m4590c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f2342a;
        }
        drawable.setColorFilter(C0873i.m4463a(i, mode));
    }

    private void m4468a(Context context) {
        if (!this.f2357p) {
            this.f2357p = true;
            Drawable a = m4485a(context, C0663e.abc_vector_test);
            if (a == null || !C0873i.m4475a(a)) {
                this.f2357p = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static boolean m4475a(Drawable drawable) {
        return (drawable instanceof C0171f) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
