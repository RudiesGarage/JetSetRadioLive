package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.p022e.C0321a;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: ActivityChooserModel */
class C0864e extends DataSetObservable {
    static final String f2307a = C0864e.class.getSimpleName();
    private static final Object f2308e = new Object();
    private static final Map<String, C0864e> f2309f = new HashMap();
    final Context f2310b;
    final String f2311c;
    boolean f2312d;
    private final Object f2313g;
    private final List<C0859a> f2314h;
    private final List<C0861c> f2315i;
    private Intent f2316j;
    private C0860b f2317k;
    private int f2318l;
    private boolean f2319m;
    private boolean f2320n;
    private boolean f2321o;
    private C0862d f2322p;

    /* compiled from: ActivityChooserModel */
    public final class C0859a implements Comparable<C0859a> {
        public final ResolveInfo f2300a;
        public float f2301b;
        final /* synthetic */ C0864e f2302c;

        public /* synthetic */ int compareTo(Object obj) {
            return m4401a((C0859a) obj);
        }

        public C0859a(C0864e c0864e, ResolveInfo resolveInfo) {
            this.f2302c = c0864e;
            this.f2300a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f2301b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.f2301b) != Float.floatToIntBits(((C0859a) obj).f2301b)) {
                return false;
            }
            return true;
        }

        public int m4401a(C0859a c0859a) {
            return Float.floatToIntBits(c0859a.f2301b) - Float.floatToIntBits(this.f2301b);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.f2300a.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2301b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: ActivityChooserModel */
    public interface C0860b {
        void m4402a(Intent intent, List<C0859a> list, List<C0861c> list2);
    }

    /* compiled from: ActivityChooserModel */
    public static final class C0861c {
        public final ComponentName f2303a;
        public final long f2304b;
        public final float f2305c;

        public C0861c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public C0861c(ComponentName componentName, long j, float f) {
            this.f2303a = componentName;
            this.f2304b = j;
            this.f2305c = f;
        }

        public int hashCode() {
            return (((((this.f2303a == null ? 0 : this.f2303a.hashCode()) + 31) * 31) + ((int) (this.f2304b ^ (this.f2304b >>> 32)))) * 31) + Float.floatToIntBits(this.f2305c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C0861c c0861c = (C0861c) obj;
            if (this.f2303a == null) {
                if (c0861c.f2303a != null) {
                    return false;
                }
            } else if (!this.f2303a.equals(c0861c.f2303a)) {
                return false;
            }
            if (this.f2304b != c0861c.f2304b) {
                return false;
            }
            if (Float.floatToIntBits(this.f2305c) != Float.floatToIntBits(c0861c.f2305c)) {
                return false;
            }
            return true;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.f2303a);
            stringBuilder.append("; time:").append(this.f2304b);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2305c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: ActivityChooserModel */
    public interface C0862d {
        boolean m4403a(C0864e c0864e, Intent intent);
    }

    /* compiled from: ActivityChooserModel */
    private final class C0863e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ C0864e f2306a;

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4404a(objArr);
        }

        C0863e(C0864e c0864e) {
            this.f2306a = c0864e;
        }

        public Void m4404a(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.f2306a.f2310b.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        C0861c c0861c = (C0861c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", c0861c.f2303a.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(c0861c.f2304b));
                        newSerializer.attribute(null, "weight", String.valueOf(c0861c.f2305c));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.f2306a.f2312d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(C0864e.f2307a, "Error writing historical record file: " + this.f2306a.f2311c, e2);
                    this.f2306a.f2312d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(C0864e.f2307a, "Error writing historical record file: " + this.f2306a.f2311c, e22);
                    this.f2306a.f2312d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(C0864e.f2307a, "Error writing historical record file: " + this.f2306a.f2311c, e222);
                    this.f2306a.f2312d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.f2306a.f2312d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(C0864e.f2307a, "Error writing historical record file: " + str, e2222);
            }
            return null;
        }
    }

    public int m4413a() {
        int size;
        synchronized (this.f2313g) {
            m4407d();
            size = this.f2314h.size();
        }
        return size;
    }

    public ResolveInfo m4415a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f2313g) {
            m4407d();
            resolveInfo = ((C0859a) this.f2314h.get(i)).f2300a;
        }
        return resolveInfo;
    }

    public int m4414a(ResolveInfo resolveInfo) {
        synchronized (this.f2313g) {
            m4407d();
            List list = this.f2314h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0859a) list.get(i)).f2300a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent m4416b(int i) {
        synchronized (this.f2313g) {
            if (this.f2316j == null) {
                return null;
            }
            m4407d();
            C0859a c0859a = (C0859a) this.f2314h.get(i);
            ComponentName componentName = new ComponentName(c0859a.f2300a.activityInfo.packageName, c0859a.f2300a.activityInfo.name);
            Intent intent = new Intent(this.f2316j);
            intent.setComponent(componentName);
            if (this.f2322p != null) {
                if (this.f2322p.m4403a(this, new Intent(intent))) {
                    return null;
                }
            }
            m4405a(new C0861c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo m4417b() {
        synchronized (this.f2313g) {
            m4407d();
            if (this.f2314h.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0859a) this.f2314h.get(0)).f2300a;
            return resolveInfo;
        }
    }

    public void m4418c(int i) {
        synchronized (this.f2313g) {
            float f;
            m4407d();
            C0859a c0859a = (C0859a) this.f2314h.get(i);
            C0859a c0859a2 = (C0859a) this.f2314h.get(0);
            if (c0859a2 != null) {
                f = (c0859a2.f2301b - c0859a.f2301b) + 5.0f;
            } else {
                f = 1.0f;
            }
            m4405a(new C0861c(new ComponentName(c0859a.f2300a.activityInfo.packageName, c0859a.f2300a.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    private void m4406c() {
        if (!this.f2319m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f2320n) {
            this.f2320n = false;
            if (!TextUtils.isEmpty(this.f2311c)) {
                C0321a.m1193a(new C0863e(this), new ArrayList(this.f2315i), this.f2311c);
            }
        }
    }

    private void m4407d() {
        int f = m4409f() | m4410g();
        m4411h();
        if (f != 0) {
            m4408e();
            notifyChanged();
        }
    }

    private boolean m4408e() {
        if (this.f2317k == null || this.f2316j == null || this.f2314h.isEmpty() || this.f2315i.isEmpty()) {
            return false;
        }
        this.f2317k.m4402a(this.f2316j, this.f2314h, Collections.unmodifiableList(this.f2315i));
        return true;
    }

    private boolean m4409f() {
        if (!this.f2321o || this.f2316j == null) {
            return false;
        }
        this.f2321o = false;
        this.f2314h.clear();
        List queryIntentActivities = this.f2310b.getPackageManager().queryIntentActivities(this.f2316j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f2314h.add(new C0859a(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean m4410g() {
        if (!this.f2312d || !this.f2320n || TextUtils.isEmpty(this.f2311c)) {
            return false;
        }
        this.f2312d = false;
        this.f2319m = true;
        m4412i();
        return true;
    }

    private boolean m4405a(C0861c c0861c) {
        boolean add = this.f2315i.add(c0861c);
        if (add) {
            this.f2320n = true;
            m4411h();
            m4406c();
            m4408e();
            notifyChanged();
        }
        return add;
    }

    private void m4411h() {
        int size = this.f2315i.size() - this.f2318l;
        if (size > 0) {
            this.f2320n = true;
            for (int i = 0; i < size; i++) {
                C0861c c0861c = (C0861c) this.f2315i.remove(0);
            }
        }
    }

    private void m4412i() {
        try {
            InputStream openFileInput = this.f2310b.openFileInput(this.f2311c);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f2315i;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new C0861c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(f2307a, "Error reading historical recrod file: " + this.f2311c, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(f2307a, "Error reading historical recrod file: " + this.f2311c, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }
}
