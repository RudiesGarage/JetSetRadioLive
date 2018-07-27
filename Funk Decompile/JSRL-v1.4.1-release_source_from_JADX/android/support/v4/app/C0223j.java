package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.C0186a.C0184a;
import android.support.v4.app.C0204b.C0203a;
import android.support.v4.p024g.C0356i;
import android.support.v4.p024g.C0371j;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentActivity */
public class C0223j extends C0217h implements C0184a, C0203a {
    final Handler f585c = new C02191(this);
    final C0224l f586d = C0224l.m781a(new C0221a(this));
    boolean f587e;
    boolean f588f;
    boolean f589g;
    boolean f590h;
    boolean f591i;
    boolean f592j;
    boolean f593k;
    int f594l;
    C0371j<String> f595m;

    /* compiled from: FragmentActivity */
    class C02191 extends Handler {
        final /* synthetic */ C0223j f570a;

        C02191(C0223j c0223j) {
            this.f570a = c0223j;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.f570a.f589g) {
                        this.f570a.m775a(false);
                        return;
                    }
                    return;
                case 2:
                    this.f570a.m769a();
                    this.f570a.f586d.m810n();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* compiled from: FragmentActivity */
    class C0221a extends C0220m<C0223j> {
        final /* synthetic */ C0223j f581a;

        public /* synthetic */ Object mo128g() {
            return m760c();
        }

        public C0221a(C0223j c0223j) {
            this.f581a = c0223j;
            super(c0223j);
        }

        public void mo120a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.f581a.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean mo121a(Fragment fragment) {
            return !this.f581a.isFinishing();
        }

        public LayoutInflater mo123b() {
            return this.f581a.getLayoutInflater().cloneInContext(this.f581a);
        }

        public C0223j m760c() {
            return this.f581a;
        }

        public void mo125d() {
            this.f581a.m778c();
        }

        public void mo117a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            this.f581a.m772a(fragment, intent, i, bundle);
        }

        public void mo118a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            this.f581a.m773a(fragment, intentSender, i, intent, i2, i3, i4, bundle);
        }

        public void mo119a(Fragment fragment, String[] strArr, int i) {
            this.f581a.m774a(fragment, strArr, i);
        }

        public boolean mo122a(String str) {
            return C0186a.m618a(this.f581a, str);
        }

        public boolean mo126e() {
            return this.f581a.getWindow() != null;
        }

        public int mo127f() {
            Window window = this.f581a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public void mo124b(Fragment fragment) {
            this.f581a.m771a(fragment);
        }

        public View mo91a(int i) {
            return this.f581a.findViewById(i);
        }

        public boolean mo92a() {
            Window window = this.f581a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    /* compiled from: FragmentActivity */
    static final class C0222b {
        Object f582a;
        C0235p f583b;
        C0356i<String, C0245t> f584c;

        C0222b() {
        }
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f586d.m794b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.f595m.m1330a(i4);
            this.f595m.m1336c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.f586d.m782a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.onActivityResult(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f586d.m783a().mo148c()) {
            super.onBackPressed();
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.f586d.m790a(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.f586d.m796b(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f586d.m785a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f586d.m787a(null);
        super.onCreate(bundle);
        C0222b c0222b = (C0222b) getLastNonConfigurationInstance();
        if (c0222b != null) {
            this.f586d.m788a(c0222b.f584c);
        }
        if (bundle != null) {
            this.f586d.m786a(bundle.getParcelable("android:support:fragments"), c0222b != null ? c0222b.f583b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f594l = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f595m = new C0371j(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f595m.m1334b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.f595m == null) {
            this.f595m = new C0371j();
            this.f594l = 0;
        }
        this.f586d.m801e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f586d.m792a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View mo129a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f586d.m784a(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        m775a(false);
        this.f586d.m808l();
        this.f586d.m812p();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f586d.m809m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f586d.m793a(menuItem);
            case 6:
                return this.f586d.m797b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f586d.m795b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f588f = false;
        if (this.f585c.hasMessages(2)) {
            this.f585c.removeMessages(2);
            m769a();
        }
        this.f586d.m805i();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f586d.m794b();
    }

    public void onStateNotSaved() {
        this.f586d.m794b();
    }

    protected void onResume() {
        super.onResume();
        this.f585c.sendEmptyMessage(2);
        this.f588f = true;
        this.f586d.m810n();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f585c.removeMessages(2);
        m769a();
        this.f586d.m810n();
    }

    protected void m769a() {
        this.f586d.m804h();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f592j) {
            this.f592j = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m776a(view, menu) | this.f586d.m791a(menu);
    }

    protected boolean m776a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f589g) {
            m775a(true);
        }
        Object b = m777b();
        C0235p d = this.f586d.m800d();
        C0356i r = this.f586d.m814r();
        if (d == null && r == null && b == null) {
            return null;
        }
        Object c0222b = new C0222b();
        c0222b.f582a = b;
        c0222b.f583b = d;
        c0222b.f584c = r;
        return c0222b;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable c = this.f586d.m798c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.f595m.m1332b() > 0) {
            bundle.putInt("android:support:next_request_index", this.f594l);
            int[] iArr = new int[this.f595m.m1332b()];
            String[] strArr = new String[this.f595m.m1332b()];
            for (int i = 0; i < this.f595m.m1332b(); i++) {
                iArr[i] = this.f595m.m1337d(i);
                strArr[i] = (String) this.f595m.m1338e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f589g = false;
        this.f590h = false;
        this.f585c.removeMessages(1);
        if (!this.f587e) {
            this.f587e = true;
            this.f586d.m802f();
        }
        this.f586d.m794b();
        this.f586d.m810n();
        this.f586d.m811o();
        this.f586d.m803g();
        this.f586d.m813q();
    }

    protected void onStop() {
        super.onStop();
        this.f589g = true;
        this.f585c.sendEmptyMessage(1);
        this.f586d.m806j();
    }

    public Object m777b() {
        return null;
    }

    public void m778c() {
        if (VERSION.SDK_INT >= 11) {
            C0205c.m671a(this);
        } else {
            this.f592j = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f587e);
            printWriter.print("mResumed=");
            printWriter.print(this.f588f);
            printWriter.print(" mStopped=");
            printWriter.print(this.f589g);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f590h);
            this.f586d.m789a(str2, fileDescriptor, printWriter, strArr);
            this.f586d.m783a().mo146a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m766a(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f587e);
            printWriter.print("mResumed=");
            printWriter.print(this.f588f);
            printWriter.print(" mStopped=");
            printWriter.print(this.f589g);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f590h);
            this.f586d.m789a(str2, fileDescriptor, printWriter, strArr);
            this.f586d.m783a().mo146a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m766a(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    private static String m765a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m766a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(C0223j.m765a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m766a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void m775a(boolean z) {
        if (!this.f590h) {
            this.f590h = true;
            this.f591i = z;
            this.f585c.removeMessages(1);
            m779d();
        } else if (z) {
            this.f586d.m811o();
            this.f586d.m799c(true);
        }
    }

    void m779d() {
        this.f586d.m799c(this.f591i);
        this.f586d.m807k();
    }

    public void m771a(Fragment fragment) {
    }

    public C0226n m780e() {
        return this.f586d.m783a();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.b || i == -1)) {
            C0215f.m720b(i);
        }
        super.startActivityForResult(intent, i);
    }

    public final void mo130a(int i) {
        if (!this.f593k && i != -1) {
            C0215f.m720b(i);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.f595m.m1330a(i3);
            this.f595m.m1336c(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.f586d.m782a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                a.onRequestPermissionsResult(i & 65535, strArr, iArr);
            }
        }
    }

    public void m772a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.b = true;
        if (i == -1) {
            try {
                C0186a.m615a(this, intent, -1, bundle);
            } finally {
                this.b = false;
            }
        } else {
            C0215f.m720b(i);
            C0186a.m615a(this, intent, ((m767b(fragment) + 1) << 16) + (65535 & i), bundle);
            this.b = false;
        }
    }

    public void m773a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.a = true;
        if (i == -1) {
            try {
                C0186a.m616a(this, intentSender, i, intent, i2, i3, i4, bundle);
            } finally {
                this.a = false;
            }
        } else {
            C0215f.m720b(i);
            C0186a.m616a(this, intentSender, ((m767b(fragment) + 1) << 16) + (65535 & i), intent, i2, i3, i4, bundle);
            this.a = false;
        }
    }

    private int m767b(Fragment fragment) {
        if (this.f595m.m1332b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.f595m.m1339f(this.f594l) >= 0) {
            this.f594l = (this.f594l + 1) % 65534;
        }
        int i = this.f594l;
        this.f595m.m1334b(i, fragment.mWho);
        this.f594l = (this.f594l + 1) % 65534;
        return i;
    }

    void m774a(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            C0186a.m617a(this, strArr, i);
            return;
        }
        C0215f.m720b(i);
        try {
            this.f593k = true;
            C0186a.m617a(this, strArr, ((m767b(fragment) + 1) << 16) + (65535 & i));
        } finally {
            this.f593k = false;
        }
    }
}
