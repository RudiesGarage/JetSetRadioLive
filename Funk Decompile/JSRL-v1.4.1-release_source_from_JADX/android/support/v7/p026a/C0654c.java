package android.support.v7.p026a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.support.v4.app.C0188x;
import android.support.v4.app.C0271y;
import android.support.v4.app.C0271y.C0254q;
import android.support.v4.app.C0271y.C0257d;
import android.support.v4.app.C0271y.C0258e;
import android.support.v4.app.C0271y.C0261g;
import android.support.v4.app.C0271y.C0261g.C0260a;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.p023f.C0334a;
import android.support.v7.p027b.C0670a.C0661c;
import android.support.v7.p027b.C0670a.C0664f;
import android.support.v7.p027b.C0670a.C0666h;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import java.util.List;

/* compiled from: NotificationCompat */
public class C0654c extends C0271y {

    /* compiled from: NotificationCompat */
    private static class C0646a extends C0258e {
        private C0646a() {
        }

        public Notification mo474a(C0257d c0257d, C0188x c0188x) {
            C0654c.m2731e(c0188x, c0257d);
            return c0188x.mo95b();
        }
    }

    /* compiled from: NotificationCompat */
    public static class C0647b extends C0257d {
        public C0647b(Context context) {
            super(context);
        }

        protected CharSequence mo476i() {
            if (this.m instanceof C0261g) {
                C0261g c0261g = (C0261g) this.m;
                C0260a a = C0654c.m2722b(c0261g);
                CharSequence b = c0261g.m1022b();
                if (a != null) {
                    if (b != null) {
                        return C0654c.m2724b(this, c0261g, a);
                    }
                    return a.m1015a();
                }
            }
            return super.mo476i();
        }

        protected CharSequence mo477j() {
            if (this.m instanceof C0261g) {
                C0261g c0261g = (C0261g) this.m;
                C0260a a = C0654c.m2722b(c0261g);
                CharSequence b = c0261g.m1022b();
                if (!(b == null && a == null)) {
                    if (b != null) {
                        return b;
                    }
                    return a.m1017c();
                }
            }
            return super.mo477j();
        }

        protected C0258e mo475b() {
            if (VERSION.SDK_INT >= 24) {
                return new C0646a();
            }
            if (VERSION.SDK_INT >= 21) {
                return new C0653g();
            }
            if (VERSION.SDK_INT >= 16) {
                return new C0652f();
            }
            if (VERSION.SDK_INT >= 14) {
                return new C0651e();
            }
            return super.mo475b();
        }
    }

    /* compiled from: NotificationCompat */
    public static class C0648c extends C0254q {
    }

    /* compiled from: NotificationCompat */
    public static class C0649h extends C0254q {
        int[] f1239a = null;
        Token f1240b;
        boolean f1241c;
        PendingIntent f1242h;

        public C0649h m2709a(int... iArr) {
            this.f1239a = iArr;
            return this;
        }
    }

    /* compiled from: NotificationCompat */
    public static class C0650d extends C0649h {
    }

    /* compiled from: NotificationCompat */
    private static class C0651e extends C0258e {
        C0651e() {
        }

        public Notification mo474a(C0257d c0257d, C0188x c0188x) {
            RemoteViews a = C0654c.m2736h(c0188x, c0257d);
            Notification b = c0188x.mo95b();
            if (a != null) {
                b.contentView = a;
            } else if (c0257d.m1004c() != null) {
                b.contentView = c0257d.m1004c();
            }
            return b;
        }
    }

    /* compiled from: NotificationCompat */
    private static class C0652f extends C0258e {
        C0652f() {
        }

        public Notification mo474a(C0257d c0257d, C0188x c0188x) {
            RemoteViews b = C0654c.m2734g(c0188x, c0257d);
            Notification b2 = c0188x.mo95b();
            if (b != null) {
                b2.contentView = b;
            }
            C0654c.m2728d(b2, c0257d);
            return b2;
        }
    }

    /* compiled from: NotificationCompat */
    private static class C0653g extends C0258e {
        C0653g() {
        }

        public Notification mo474a(C0257d c0257d, C0188x c0188x) {
            RemoteViews c = C0654c.m2732f(c0188x, c0257d);
            Notification b = c0188x.mo95b();
            if (c != null) {
                b.contentView = c;
            }
            C0654c.m2735g(b, c0257d);
            C0654c.m2737h(b, c0257d);
            return b;
        }
    }

    private static void m2731e(C0188x c0188x, C0257d c0257d) {
        if (c0257d.f732m instanceof C0648c) {
            C0656e.m2739a(c0188x);
        } else if (c0257d.f732m instanceof C0650d) {
            C0656e.m2740b(c0188x);
        } else if (!(c0257d.f732m instanceof C0261g)) {
            C0654c.m2732f(c0188x, c0257d);
        }
    }

    private static RemoteViews m2732f(C0188x c0188x, C0257d c0257d) {
        if (c0257d.f732m instanceof C0649h) {
            C0649h c0649h = (C0649h) c0257d.f732m;
            C0655d.m2738a(c0188x, c0649h.f1239a, c0649h.f1240b != null ? c0649h.f1240b.m1407a() : null);
            boolean z = c0257d.m1004c() != null;
            Object obj = (VERSION.SDK_INT < 21 || VERSION.SDK_INT > 23) ? null : 1;
            obj = (z || !(obj == null || c0257d.m1005d() == null)) ? 1 : null;
            if (!(c0257d.f732m instanceof C0650d) || obj == null) {
                return null;
            }
            RemoteViews a = C0657f.m2754a(c0188x, c0257d.f720a, c0257d.f721b, c0257d.f722c, c0257d.f727h, c0257d.f728i, c0257d.f726g, c0257d.f733n, c0257d.f731l, c0257d.m1007f(), c0257d.m1008g(), c0257d.f741v, c0649h.f1239a, false, null, z);
            if (z) {
                C0657f.m2756a(c0257d.f720a, a, c0257d.m1004c());
            }
            C0654c.m2719a(c0257d.f720a, a, c0257d.m1009h());
            return a;
        } else if (c0257d.f732m instanceof C0648c) {
            return C0654c.m2716a(c0257d);
        } else {
            return C0654c.m2734g(c0188x, c0257d);
        }
    }

    private static RemoteViews m2734g(C0188x c0188x, C0257d c0257d) {
        if (c0257d.f732m instanceof C0261g) {
            C0654c.m2720a((C0261g) c0257d.f732m, c0188x, c0257d);
        }
        return C0654c.m2736h(c0188x, c0257d);
    }

    private static C0260a m2722b(C0261g c0261g) {
        List c = c0261g.m1023c();
        for (int size = c.size() - 1; size >= 0; size--) {
            C0260a c0260a = (C0260a) c.get(size);
            if (!TextUtils.isEmpty(c0260a.m1017c())) {
                return c0260a;
            }
        }
        if (c.isEmpty()) {
            return null;
        }
        return (C0260a) c.get(c.size() - 1);
    }

    private static CharSequence m2724b(C0257d c0257d, C0261g c0261g, C0260a c0260a) {
        int i;
        CharSequence charSequence;
        C0334a a = C0334a.m1216a();
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        Object obj = VERSION.SDK_INT >= 21 ? 1 : null;
        int i2 = (obj != null || VERSION.SDK_INT <= 10) ? -16777216 : -1;
        CharSequence c = c0260a.m1017c();
        if (TextUtils.isEmpty(c0260a.m1017c())) {
            String str;
            if (c0261g.m1020a() == null) {
                str = "";
            } else {
                str = c0261g.m1020a();
            }
            if (!(obj == null || c0257d.m1009h() == 0)) {
                i2 = c0257d.m1009h();
            }
            String str2 = str;
            i = i2;
            charSequence = str2;
        } else {
            CharSequence charSequence2 = c;
            i = i2;
            charSequence = charSequence2;
        }
        charSequence = a.m1226a(charSequence);
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(C0654c.m2714a(i), spannableStringBuilder.length() - charSequence.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.append("  ").append(a.m1226a(c0260a.m1015a() == null ? "" : c0260a.m1015a()));
        return spannableStringBuilder;
    }

    private static TextAppearanceSpan m2714a(int i) {
        return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null);
    }

    private static void m2720a(C0261g c0261g, C0188x c0188x, C0257d c0257d) {
        int i;
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        List c = c0261g.m1023c();
        if (c0261g.m1022b() != null || C0654c.m2721a(c0261g.m1023c())) {
            i = 1;
        } else {
            i = 0;
        }
        for (int size = c.size() - 1; size >= 0; size--) {
            C0260a c0260a = (C0260a) c.get(size);
            CharSequence b = i != 0 ? C0654c.m2724b(c0257d, c0261g, c0260a) : c0260a.m1015a();
            if (size != c.size() - 1) {
                spannableStringBuilder.insert(0, "\n");
            }
            spannableStringBuilder.insert(0, b);
        }
        C0658g.m2759a(c0188x, spannableStringBuilder);
    }

    private static boolean m2721a(List<C0260a> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((C0260a) list.get(size)).m1017c() == null) {
                return true;
            }
        }
        return false;
    }

    private static RemoteViews m2736h(C0188x c0188x, C0257d c0257d) {
        if (c0257d.f732m instanceof C0649h) {
            C0649h c0649h = (C0649h) c0257d.f732m;
            boolean z = (c0257d.f732m instanceof C0650d) && c0257d.m1004c() != null;
            RemoteViews a = C0657f.m2754a(c0188x, c0257d.f720a, c0257d.f721b, c0257d.f722c, c0257d.f727h, c0257d.f728i, c0257d.f726g, c0257d.f733n, c0257d.f731l, c0257d.m1007f(), c0257d.m1008g(), c0257d.f741v, c0649h.f1239a, c0649h.f1241c, c0649h.f1242h, z);
            if (z) {
                C0657f.m2756a(c0257d.f720a, a, c0257d.m1004c());
                return a;
            }
        } else if (c0257d.f732m instanceof C0648c) {
            return C0654c.m2716a(c0257d);
        }
        return null;
    }

    private static void m2728d(Notification notification, C0257d c0257d) {
        if (c0257d.f732m instanceof C0649h) {
            RemoteViews d;
            C0649h c0649h = (C0649h) c0257d.f732m;
            if (c0257d.m1005d() != null) {
                d = c0257d.m1005d();
            } else {
                d = c0257d.m1004c();
            }
            boolean z = (c0257d.f732m instanceof C0650d) && d != null;
            C0657f.m2755a(notification, c0257d.f720a, c0257d.f721b, c0257d.f722c, c0257d.f727h, c0257d.f728i, c0257d.f726g, c0257d.f733n, c0257d.f731l, c0257d.m1007f(), c0257d.m1008g(), 0, (List) c0257d.f741v, c0649h.f1241c, c0649h.f1242h, z);
            if (z) {
                C0657f.m2756a(c0257d.f720a, notification.bigContentView, d);
            }
        } else if (c0257d.f732m instanceof C0648c) {
            C0654c.m2730e(notification, c0257d);
        }
    }

    private static RemoteViews m2716a(C0257d c0257d) {
        if (c0257d.m1004c() == null) {
            return null;
        }
        RemoteViews a = C0657f.m2751a(c0257d.f720a, c0257d.f721b, c0257d.f722c, c0257d.f727h, c0257d.f728i, c0257d.f718F.icon, c0257d.f726g, c0257d.f733n, c0257d.f731l, c0257d.m1007f(), c0257d.m1008g(), c0257d.m1009h(), C0666h.notification_template_custom_big, false, null);
        C0657f.m2756a(c0257d.f720a, a, c0257d.m1004c());
        return a;
    }

    private static void m2730e(Notification notification, C0257d c0257d) {
        RemoteViews d = c0257d.m1005d();
        if (d == null) {
            d = c0257d.m1004c();
        }
        if (d != null) {
            RemoteViews a = C0657f.m2751a(c0257d.f720a, c0257d.f721b, c0257d.f722c, c0257d.f727h, c0257d.f728i, notification.icon, c0257d.f726g, c0257d.f733n, c0257d.f731l, c0257d.m1007f(), c0257d.m1008g(), c0257d.m1009h(), C0666h.notification_template_custom_big, false, c0257d.f741v);
            C0657f.m2756a(c0257d.f720a, a, d);
            notification.bigContentView = a;
        }
    }

    private static void m2733f(Notification notification, C0257d c0257d) {
        RemoteViews e = c0257d.m1006e();
        RemoteViews c = e != null ? e : c0257d.m1004c();
        if (e != null) {
            e = C0657f.m2751a(c0257d.f720a, c0257d.f721b, c0257d.f722c, c0257d.f727h, c0257d.f728i, notification.icon, c0257d.f726g, c0257d.f733n, c0257d.f731l, c0257d.m1007f(), c0257d.m1008g(), c0257d.m1009h(), C0666h.notification_template_custom_big, false, c0257d.f741v);
            C0657f.m2756a(c0257d.f720a, e, c);
            notification.headsUpContentView = e;
        }
    }

    private static void m2735g(Notification notification, C0257d c0257d) {
        RemoteViews d;
        if (c0257d.m1005d() != null) {
            d = c0257d.m1005d();
        } else {
            d = c0257d.m1004c();
        }
        if ((c0257d.f732m instanceof C0650d) && d != null) {
            C0657f.m2755a(notification, c0257d.f720a, c0257d.f721b, c0257d.f722c, c0257d.f727h, c0257d.f728i, c0257d.f726g, c0257d.f733n, c0257d.f731l, c0257d.m1007f(), c0257d.m1008g(), 0, (List) c0257d.f741v, false, null, true);
            C0657f.m2756a(c0257d.f720a, notification.bigContentView, d);
            C0654c.m2719a(c0257d.f720a, notification.bigContentView, c0257d.m1009h());
        } else if (c0257d.f732m instanceof C0648c) {
            C0654c.m2730e(notification, c0257d);
        }
    }

    private static void m2719a(Context context, RemoteViews remoteViews, int i) {
        if (i == 0) {
            i = context.getResources().getColor(C0661c.notification_material_background_media_default_color);
        }
        remoteViews.setInt(C0664f.status_bar_latest_event_content, "setBackgroundColor", i);
    }

    private static void m2737h(Notification notification, C0257d c0257d) {
        RemoteViews e;
        if (c0257d.m1006e() != null) {
            e = c0257d.m1006e();
        } else {
            e = c0257d.m1004c();
        }
        if ((c0257d.f732m instanceof C0650d) && e != null) {
            notification.headsUpContentView = C0657f.m2752a(c0257d.f720a, c0257d.f721b, c0257d.f722c, c0257d.f727h, c0257d.f728i, c0257d.f726g, c0257d.f733n, c0257d.f731l, c0257d.m1007f(), c0257d.m1008g(), 0, c0257d.f741v, false, null, true);
            C0657f.m2756a(c0257d.f720a, notification.headsUpContentView, e);
            C0654c.m2719a(c0257d.f720a, notification.headsUpContentView, c0257d.m1009h());
        } else if (c0257d.f732m instanceof C0648c) {
            C0654c.m2733f(notification, c0257d);
        }
    }
}
