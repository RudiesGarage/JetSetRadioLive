package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.p020d.p021a.C0318a;
import android.support.v4.view.C0563d;
import android.support.v4.view.C0594p;
import android.support.v7.p027b.C0670a.C0669k;
import android.support.v7.view.menu.C0726h;
import android.support.v7.view.menu.C0731i;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: SupportMenuInflater */
public class C0701d extends MenuInflater {
    static final Class<?>[] f1348a = new Class[]{Context.class};
    static final Class<?>[] f1349b = f1348a;
    final Object[] f1350c;
    final Object[] f1351d = this.f1350c;
    Context f1352e;
    private Object f1353f;

    /* compiled from: SupportMenuInflater */
    private static class C0699a implements OnMenuItemClickListener {
        private static final Class<?>[] f1319a = new Class[]{MenuItem.class};
        private Object f1320b;
        private Method f1321c;

        public C0699a(Object obj, String str) {
            this.f1320b = obj;
            Class cls = obj.getClass();
            try {
                this.f1321c = cls.getMethod(str, f1319a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1321c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1321c.invoke(this.f1320b, new Object[]{menuItem})).booleanValue();
                }
                this.f1321c.invoke(this.f1320b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: SupportMenuInflater */
    private class C0700b {
        C0563d f1322a;
        final /* synthetic */ C0701d f1323b;
        private Menu f1324c;
        private int f1325d;
        private int f1326e;
        private int f1327f;
        private int f1328g;
        private boolean f1329h;
        private boolean f1330i;
        private boolean f1331j;
        private int f1332k;
        private int f1333l;
        private CharSequence f1334m;
        private CharSequence f1335n;
        private int f1336o;
        private char f1337p;
        private char f1338q;
        private int f1339r;
        private boolean f1340s;
        private boolean f1341t;
        private boolean f1342u;
        private int f1343v;
        private int f1344w;
        private String f1345x;
        private String f1346y;
        private String f1347z;

        public C0700b(C0701d c0701d, Menu menu) {
            this.f1323b = c0701d;
            this.f1324c = menu;
            m2864a();
        }

        public void m2864a() {
            this.f1325d = 0;
            this.f1326e = 0;
            this.f1327f = 0;
            this.f1328g = 0;
            this.f1329h = true;
            this.f1330i = true;
        }

        public void m2865a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.f1323b.f1352e.obtainStyledAttributes(attributeSet, C0669k.MenuGroup);
            this.f1325d = obtainStyledAttributes.getResourceId(C0669k.MenuGroup_android_id, 0);
            this.f1326e = obtainStyledAttributes.getInt(C0669k.MenuGroup_android_menuCategory, 0);
            this.f1327f = obtainStyledAttributes.getInt(C0669k.MenuGroup_android_orderInCategory, 0);
            this.f1328g = obtainStyledAttributes.getInt(C0669k.MenuGroup_android_checkableBehavior, 0);
            this.f1329h = obtainStyledAttributes.getBoolean(C0669k.MenuGroup_android_visible, true);
            this.f1330i = obtainStyledAttributes.getBoolean(C0669k.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void m2867b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.f1323b.f1352e.obtainStyledAttributes(attributeSet, C0669k.MenuItem);
            this.f1332k = obtainStyledAttributes.getResourceId(C0669k.MenuItem_android_id, 0);
            this.f1333l = (obtainStyledAttributes.getInt(C0669k.MenuItem_android_menuCategory, this.f1326e) & -65536) | (obtainStyledAttributes.getInt(C0669k.MenuItem_android_orderInCategory, this.f1327f) & 65535);
            this.f1334m = obtainStyledAttributes.getText(C0669k.MenuItem_android_title);
            this.f1335n = obtainStyledAttributes.getText(C0669k.MenuItem_android_titleCondensed);
            this.f1336o = obtainStyledAttributes.getResourceId(C0669k.MenuItem_android_icon, 0);
            this.f1337p = m2861a(obtainStyledAttributes.getString(C0669k.MenuItem_android_alphabeticShortcut));
            this.f1338q = m2861a(obtainStyledAttributes.getString(C0669k.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(C0669k.MenuItem_android_checkable)) {
                this.f1339r = obtainStyledAttributes.getBoolean(C0669k.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1339r = this.f1328g;
            }
            this.f1340s = obtainStyledAttributes.getBoolean(C0669k.MenuItem_android_checked, false);
            this.f1341t = obtainStyledAttributes.getBoolean(C0669k.MenuItem_android_visible, this.f1329h);
            this.f1342u = obtainStyledAttributes.getBoolean(C0669k.MenuItem_android_enabled, this.f1330i);
            this.f1343v = obtainStyledAttributes.getInt(C0669k.MenuItem_showAsAction, -1);
            this.f1347z = obtainStyledAttributes.getString(C0669k.MenuItem_android_onClick);
            this.f1344w = obtainStyledAttributes.getResourceId(C0669k.MenuItem_actionLayout, 0);
            this.f1345x = obtainStyledAttributes.getString(C0669k.MenuItem_actionViewClass);
            this.f1346y = obtainStyledAttributes.getString(C0669k.MenuItem_actionProviderClass);
            if (this.f1346y == null) {
                z = false;
            }
            if (z && this.f1344w == 0 && this.f1345x == null) {
                this.f1322a = (C0563d) m2862a(this.f1346y, C0701d.f1349b, this.f1323b.f1351d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1322a = null;
            }
            obtainStyledAttributes.recycle();
            this.f1331j = false;
        }

        private char m2861a(String str) {
            if (str == null) {
                return '\u0000';
            }
            return str.charAt(0);
        }

        private void m2863a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f1340s).setVisible(this.f1341t).setEnabled(this.f1342u).setCheckable(this.f1339r >= 1).setTitleCondensed(this.f1335n).setIcon(this.f1336o).setAlphabeticShortcut(this.f1337p).setNumericShortcut(this.f1338q);
            if (this.f1343v >= 0) {
                C0594p.m2498a(menuItem, this.f1343v);
            }
            if (this.f1347z != null) {
                if (this.f1323b.f1352e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C0699a(this.f1323b.m2872a(), this.f1347z));
            }
            if (menuItem instanceof C0726h) {
                C0726h c0726h = (C0726h) menuItem;
            }
            if (this.f1339r >= 2) {
                if (menuItem instanceof C0726h) {
                    ((C0726h) menuItem).m3056a(true);
                } else if (menuItem instanceof C0731i) {
                    ((C0731i) menuItem).m3085a(true);
                }
            }
            if (this.f1345x != null) {
                C0594p.m2497a(menuItem, (View) m2862a(this.f1345x, C0701d.f1348a, this.f1323b.f1350c));
            } else {
                z = false;
            }
            if (this.f1344w > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    C0594p.m2500b(menuItem, this.f1344w);
                }
            }
            if (this.f1322a != null) {
                C0594p.m2496a(menuItem, this.f1322a);
            }
        }

        public void m2866b() {
            this.f1331j = true;
            m2863a(this.f1324c.add(this.f1325d, this.f1332k, this.f1333l, this.f1334m));
        }

        public SubMenu m2868c() {
            this.f1331j = true;
            SubMenu addSubMenu = this.f1324c.addSubMenu(this.f1325d, this.f1332k, this.f1333l, this.f1334m);
            m2863a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean m2869d() {
            return this.f1331j;
        }

        private <T> T m2862a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.f1323b.f1352e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    public C0701d(Context context) {
        super(context);
        this.f1352e = context;
        this.f1350c = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof C0318a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.f1352e.getResources().getLayout(i);
                m2871a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2871a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.view.d$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00dd;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d5;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.m2865a(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.m2867b(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.m2868c();
        r10.m2871a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.m2864a();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00c9;
    L_0x00ab:
        r3 = r7.m2869d();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.f1322a;
        if (r3 == 0) goto L_0x00c3;
    L_0x00b5:
        r3 = r7.f1322a;
        r3 = r3.mo535e();
        if (r3 == 0) goto L_0x00c3;
    L_0x00bd:
        r7.m2868c();
        r3 = r5;
        goto L_0x0029;
    L_0x00c3:
        r7.m2866b();
        r3 = r5;
        goto L_0x0029;
    L_0x00c9:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d1:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d5:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00dd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.d.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object m2872a() {
        if (this.f1353f == null) {
            this.f1353f = m2870a(this.f1352e);
        }
        return this.f1353f;
    }

    private Object m2870a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return m2870a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }
}
