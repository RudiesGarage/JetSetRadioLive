package android.support.v7.p026a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.C0188x;
import android.support.v4.app.C0271y.C0253a;
import android.support.v4.app.ac.C0192a;
import android.support.v7.p027b.C0670a.C0661c;
import android.support.v7.p027b.C0670a.C0662d;
import android.support.v7.p027b.C0670a.C0663e;
import android.support.v7.p027b.C0670a.C0664f;
import android.support.v7.p027b.C0670a.C0665g;
import android.support.v7.p027b.C0670a.C0666h;
import android.support.v7.p027b.C0670a.C0667i;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotificationCompatImplBase */
class C0657f {
    public static <T extends C0192a> RemoteViews m2754a(C0188x c0188x, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent, boolean z3) {
        RemoteViews a = C0657f.m2753a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, i2, (List) list, iArr, z2, pendingIntent, z3);
        c0188x.mo93a().setContent(a);
        if (z2) {
            c0188x.mo93a().setOngoing(true);
        }
        return a;
    }

    private static <T extends C0192a> RemoteViews m2753a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent, boolean z3) {
        int i3;
        RemoteViews a = C0657f.m2750a(context, charSequence, charSequence2, charSequence3, i, 0, bitmap, charSequence4, z, j, i2, 0, z3 ? C0666h.notification_template_media_custom : C0666h.notification_template_media, true);
        int size = list.size();
        if (iArr == null) {
            i3 = 0;
        } else {
            i3 = Math.min(iArr.length, 3);
        }
        a.removeAllViews(C0664f.media_actions);
        if (i3 > 0) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (i4 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i4), Integer.valueOf(size - 1)}));
                }
                a.addView(C0664f.media_actions, C0657f.m2748a(context, (C0192a) list.get(iArr[i4])));
            }
        }
        if (z2) {
            a.setViewVisibility(C0664f.end_padder, 8);
            a.setViewVisibility(C0664f.cancel_action, 0);
            a.setOnClickPendingIntent(C0664f.cancel_action, pendingIntent);
            a.setInt(C0664f.cancel_action, "setAlpha", context.getResources().getInteger(C0665g.cancel_button_image_alpha));
        } else {
            a.setViewVisibility(C0664f.end_padder, 0);
            a.setViewVisibility(C0664f.cancel_action, 8);
        }
        return a;
    }

    public static <T extends C0192a> void m2755a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, int i3, List<T> list, boolean z2, PendingIntent pendingIntent, boolean z3) {
        notification.bigContentView = C0657f.m2752a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, i2, i3, (List) list, z2, pendingIntent, z3);
        if (z2) {
            notification.flags |= 2;
        }
    }

    public static <T extends C0192a> RemoteViews m2752a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, int i3, List<T> list, boolean z2, PendingIntent pendingIntent, boolean z3) {
        int min = Math.min(list.size(), 5);
        RemoteViews a = C0657f.m2750a(context, charSequence, charSequence2, charSequence3, i, 0, bitmap, charSequence4, z, j, i2, i3, C0657f.m2744a(z3, min), false);
        a.removeAllViews(C0664f.media_actions);
        if (min > 0) {
            for (int i4 = 0; i4 < min; i4++) {
                a.addView(C0664f.media_actions, C0657f.m2748a(context, (C0192a) list.get(i4)));
            }
        }
        if (z2) {
            a.setViewVisibility(C0664f.cancel_action, 0);
            a.setInt(C0664f.cancel_action, "setAlpha", context.getResources().getInteger(C0665g.cancel_button_image_alpha));
            a.setOnClickPendingIntent(C0664f.cancel_action, pendingIntent);
        } else {
            a.setViewVisibility(C0664f.cancel_action, 8);
        }
        return a;
    }

    private static RemoteViews m2748a(Context context, C0192a c0192a) {
        Object obj = c0192a.mo160c() == null ? 1 : null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0666h.notification_media_action);
        remoteViews.setImageViewResource(C0664f.action0, c0192a.mo158a());
        if (obj == null) {
            remoteViews.setOnClickPendingIntent(C0664f.action0, c0192a.mo160c());
        }
        if (VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(C0664f.action0, c0192a.mo159b());
        }
        return remoteViews;
    }

    private static int m2744a(boolean z, int i) {
        return i <= 3 ? z ? C0666h.notification_template_big_media_narrow_custom : C0666h.notification_template_big_media_narrow : z ? C0666h.notification_template_big_media_custom : C0666h.notification_template_big_media;
    }

    public static RemoteViews m2751a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, int i2, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i3, int i4, int i5, boolean z2, ArrayList<C0253a> arrayList) {
        int size;
        Object obj;
        RemoteViews a = C0657f.m2750a(context, charSequence, charSequence2, charSequence3, i, i2, bitmap, charSequence4, z, j, i3, i4, i5, z2);
        a.removeAllViews(C0664f.actions);
        if (arrayList != null) {
            size = arrayList.size();
            if (size > 0) {
                int i6;
                if (size > 3) {
                    i6 = 3;
                } else {
                    i6 = size;
                }
                for (int i7 = 0; i7 < i6; i7++) {
                    a.addView(C0664f.actions, C0657f.m2749a(context, (C0253a) arrayList.get(i7)));
                }
                obj = 1;
                size = obj == null ? 0 : 8;
                a.setViewVisibility(C0664f.actions, size);
                a.setViewVisibility(C0664f.action_divider, size);
                return a;
            }
        }
        obj = null;
        if (obj == null) {
        }
        a.setViewVisibility(C0664f.actions, size);
        a.setViewVisibility(C0664f.action_divider, size);
        return a;
    }

    private static RemoteViews m2749a(Context context, C0253a c0253a) {
        int b;
        Object obj = c0253a.f702d == null ? 1 : null;
        String packageName = context.getPackageName();
        if (obj != null) {
            b = C0657f.m2758b();
        } else {
            b = C0657f.m2742a();
        }
        RemoteViews remoteViews = new RemoteViews(packageName, b);
        remoteViews.setImageViewBitmap(C0664f.action_image, C0657f.m2745a(context, c0253a.mo158a(), context.getResources().getColor(C0661c.notification_action_color_filter)));
        remoteViews.setTextViewText(C0664f.action_text, c0253a.f701c);
        if (obj == null) {
            remoteViews.setOnClickPendingIntent(C0664f.action_container, c0253a.f702d);
        }
        remoteViews.setContentDescription(C0664f.action_container, c0253a.f701c);
        return remoteViews;
    }

    private static Bitmap m2745a(Context context, int i, int i2) {
        return C0657f.m2746a(context, i, i2, 0);
    }

    private static Bitmap m2746a(Context context, int i, int i2, int i3) {
        Drawable drawable = context.getResources().getDrawable(i);
        int intrinsicWidth = i3 == 0 ? drawable.getIntrinsicWidth() : i3;
        if (i3 == 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Config.ARGB_8888);
        drawable.setBounds(0, 0, intrinsicWidth, i3);
        if (i2 != 0) {
            drawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_IN));
        }
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private static int m2742a() {
        return C0666h.notification_action;
    }

    private static int m2758b() {
        return C0666h.notification_action_tombstone;
    }

    public static RemoteViews m2750a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, int i2, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i3, int i4, int i5, boolean z2) {
        Object obj;
        Resources resources = context.getResources();
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i5);
        Object obj2 = i3 < -1 ? 1 : null;
        Object obj3 = VERSION.SDK_INT >= 16 ? 1 : null;
        Object obj4 = VERSION.SDK_INT >= 21 ? 1 : null;
        if (obj3 != null && obj4 == null) {
            if (obj2 != null) {
                remoteViews.setInt(C0664f.notification_background, "setBackgroundResource", C0663e.notification_bg_low);
                remoteViews.setInt(C0664f.icon, "setBackgroundResource", C0663e.notification_template_icon_low_bg);
            } else {
                remoteViews.setInt(C0664f.notification_background, "setBackgroundResource", C0663e.notification_bg);
                remoteViews.setInt(C0664f.icon, "setBackgroundResource", C0663e.notification_template_icon_bg);
            }
        }
        if (bitmap != null) {
            if (obj3 != null) {
                remoteViews.setViewVisibility(C0664f.icon, 0);
                remoteViews.setImageViewBitmap(C0664f.icon, bitmap);
            } else {
                remoteViews.setViewVisibility(C0664f.icon, 8);
            }
            if (i2 != 0) {
                int dimensionPixelSize = resources.getDimensionPixelSize(C0662d.notification_right_icon_size);
                int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(C0662d.notification_small_icon_background_padding) * 2);
                if (obj4 != null) {
                    remoteViews.setImageViewBitmap(C0664f.right_icon, C0657f.m2747a(context, i2, dimensionPixelSize, dimensionPixelSize2, i4));
                } else {
                    remoteViews.setImageViewBitmap(C0664f.right_icon, C0657f.m2745a(context, i2, -1));
                }
                remoteViews.setViewVisibility(C0664f.right_icon, 0);
            }
        } else if (i2 != 0) {
            remoteViews.setViewVisibility(C0664f.icon, 0);
            if (obj4 != null) {
                remoteViews.setImageViewBitmap(C0664f.icon, C0657f.m2747a(context, i2, resources.getDimensionPixelSize(C0662d.notification_large_icon_width) - resources.getDimensionPixelSize(C0662d.notification_big_circle_margin), resources.getDimensionPixelSize(C0662d.notification_small_icon_size_as_large), i4));
            } else {
                remoteViews.setImageViewBitmap(C0664f.icon, C0657f.m2745a(context, i2, -1));
            }
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(C0664f.title, charSequence);
        }
        if (charSequence2 != null) {
            remoteViews.setTextViewText(C0664f.text, charSequence2);
            obj2 = 1;
        } else {
            obj2 = null;
        }
        Object obj5 = (obj4 != null || bitmap == null) ? null : 1;
        if (charSequence3 != null) {
            remoteViews.setTextViewText(C0664f.info, charSequence3);
            remoteViews.setViewVisibility(C0664f.info, 0);
            obj5 = 1;
            obj = 1;
        } else if (i > 0) {
            if (i > resources.getInteger(C0665g.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(C0664f.info, resources.getString(C0667i.status_bar_notification_info_overflow));
            } else {
                remoteViews.setTextViewText(C0664f.info, NumberFormat.getIntegerInstance().format((long) i));
            }
            remoteViews.setViewVisibility(C0664f.info, 0);
            obj5 = 1;
            int i6 = 1;
        } else {
            remoteViews.setViewVisibility(C0664f.info, 8);
            obj = obj2;
        }
        if (!(charSequence4 == null || obj3 == null)) {
            remoteViews.setTextViewText(C0664f.text, charSequence4);
            if (charSequence2 != null) {
                remoteViews.setTextViewText(C0664f.text2, charSequence2);
                remoteViews.setViewVisibility(C0664f.text2, 0);
                obj2 = 1;
                if (!(obj2 == null || obj3 == null)) {
                    if (z2) {
                        remoteViews.setTextViewTextSize(C0664f.text, 0, (float) resources.getDimensionPixelSize(C0662d.notification_subtext_size));
                    }
                    remoteViews.setViewPadding(C0664f.line1, 0, 0, 0, 0);
                }
                if (j == 0) {
                    if (z || obj3 == null) {
                        remoteViews.setViewVisibility(C0664f.time, 0);
                        remoteViews.setLong(C0664f.time, "setTime", j);
                    } else {
                        remoteViews.setViewVisibility(C0664f.chronometer, 0);
                        remoteViews.setLong(C0664f.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + j);
                        remoteViews.setBoolean(C0664f.chronometer, "setStarted", true);
                    }
                    obj2 = 1;
                } else {
                    obj2 = obj5;
                }
                remoteViews.setViewVisibility(C0664f.right_side, obj2 == null ? 0 : 8);
                remoteViews.setViewVisibility(C0664f.line3, obj == null ? 0 : 8);
                return remoteViews;
            }
            remoteViews.setViewVisibility(C0664f.text2, 8);
        }
        obj2 = null;
        if (z2) {
            remoteViews.setTextViewTextSize(C0664f.text, 0, (float) resources.getDimensionPixelSize(C0662d.notification_subtext_size));
        }
        remoteViews.setViewPadding(C0664f.line1, 0, 0, 0, 0);
        if (j == 0) {
            obj2 = obj5;
        } else {
            if (z) {
            }
            remoteViews.setViewVisibility(C0664f.time, 0);
            remoteViews.setLong(C0664f.time, "setTime", j);
            obj2 = 1;
        }
        if (obj2 == null) {
        }
        remoteViews.setViewVisibility(C0664f.right_side, obj2 == null ? 0 : 8);
        if (obj == null) {
        }
        remoteViews.setViewVisibility(C0664f.line3, obj == null ? 0 : 8);
        return remoteViews;
    }

    public static Bitmap m2747a(Context context, int i, int i2, int i3, int i4) {
        int i5 = C0663e.notification_icon_background;
        if (i4 == 0) {
            i4 = 0;
        }
        Bitmap a = C0657f.m2746a(context, i5, i4, i2);
        Canvas canvas = new Canvas(a);
        Drawable mutate = context.getResources().getDrawable(i).mutate();
        mutate.setFilterBitmap(true);
        int i6 = (i2 - i3) / 2;
        mutate.setBounds(i6, i6, i3 + i6, i3 + i6);
        mutate.setColorFilter(new PorterDuffColorFilter(-1, Mode.SRC_ATOP));
        mutate.draw(canvas);
        return a;
    }

    public static void m2756a(Context context, RemoteViews remoteViews, RemoteViews remoteViews2) {
        C0657f.m2757a(remoteViews);
        remoteViews.removeAllViews(C0664f.notification_main_column);
        remoteViews.addView(C0664f.notification_main_column, remoteViews2.clone());
        remoteViews.setViewVisibility(C0664f.notification_main_column, 0);
        if (VERSION.SDK_INT >= 21) {
            remoteViews.setViewPadding(C0664f.notification_main_column_container, 0, C0657f.m2743a(context), 0, 0);
        }
    }

    private static void m2757a(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(C0664f.title, 8);
        remoteViews.setViewVisibility(C0664f.text2, 8);
        remoteViews.setViewVisibility(C0664f.text, 8);
    }

    public static int m2743a(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0662d.notification_top_pad);
        float a = (C0657f.m2741a(context.getResources().getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
        return Math.round((((float) dimensionPixelSize) * (1.0f - a)) + (((float) context.getResources().getDimensionPixelSize(C0662d.notification_top_pad_large_text)) * a));
    }

    public static float m2741a(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }
}
