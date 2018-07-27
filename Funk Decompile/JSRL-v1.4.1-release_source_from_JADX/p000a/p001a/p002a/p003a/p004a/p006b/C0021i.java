package p000a.p001a.p002a.p003a.p004a.p006b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.C0142c;

/* compiled from: CommonUtils */
public class C0021i {
    public static final Comparator<File> f35a = new C00191();
    private static Boolean f36b = null;
    private static final char[] f37c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long f38d = -1;

    /* compiled from: CommonUtils */
    static class C00191 implements Comparator<File> {
        C00191() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m50a((File) obj, (File) obj2);
        }

        public int m50a(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* compiled from: CommonUtils */
    enum C0020a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, C0020a> f33k = null;

        static {
            f33k = new HashMap(4);
            f33k.put("armeabi-v7a", ARMV7);
            f33k.put("armeabi", ARMV6);
            f33k.put("arm64-v8a", ARM64);
            f33k.put("x86", X86_32);
        }

        static C0020a m51a() {
            Object obj = Build.CPU_ABI;
            if (TextUtils.isEmpty(obj)) {
                C0142c.m468h().mo46a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            C0020a c0020a = (C0020a) f33k.get(obj.toLowerCase(Locale.US));
            if (c0020a == null) {
                return UNKNOWN;
            }
            return c0020a;
        }
    }

    public static SharedPreferences m57a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String m59a(File file, String str) {
        Throwable e;
        Throwable th;
        String str2 = null;
        if (file.exists()) {
            Closeable bufferedReader;
            try {
                String[] split;
                bufferedReader = new BufferedReader(new FileReader(file), 1024);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                str2 = split[1];
                C0021i.m71a(bufferedReader, "Failed to close system file reader.");
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                try {
                    C0142c.m468h().mo54e("Fabric", "Error parsing " + file, e);
                    C0021i.m71a(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    C0021i.m71a(bufferedReader, "Failed to close system file reader.");
                    throw th;
                }
            } catch (Throwable e4) {
                bufferedReader = null;
                th = e4;
                C0021i.m71a(bufferedReader, "Failed to close system file reader.");
                throw th;
            }
        }
        return str2;
    }

    public static int m52a() {
        return C0020a.m51a().ordinal();
    }

    public static synchronized long m75b() {
        long j;
        synchronized (C0021i.class) {
            if (f38d == -1) {
                j = 0;
                Object a = C0021i.m59a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a)) {
                    String toUpperCase = a.toUpperCase(Locale.US);
                    try {
                        if (toUpperCase.endsWith("KB")) {
                            j = C0021i.m55a(toUpperCase, "KB", 1024);
                        } else if (toUpperCase.endsWith("MB")) {
                            j = C0021i.m55a(toUpperCase, "MB", 1048576);
                        } else if (toUpperCase.endsWith("GB")) {
                            j = C0021i.m55a(toUpperCase, "GB", 1073741824);
                        } else {
                            C0142c.m468h().mo46a("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase);
                        }
                    } catch (Throwable e) {
                        C0142c.m468h().mo54e("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase, e);
                    }
                }
                f38d = j;
            }
            j = f38d;
        }
        return j;
    }

    static long m55a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static RunningAppProcessInfo m56a(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String m60a(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static String m62a(String str) {
        return C0021i.m63a(str, "SHA-1");
    }

    public static String m79b(InputStream inputStream) {
        return C0021i.m61a(inputStream, "SHA-1");
    }

    private static String m61a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return C0021i.m64a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            C0142c.m468h().mo54e("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    private static String m65a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return C0021i.m64a(instance.digest());
        } catch (Throwable e) {
            C0142c.m468h().mo54e("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    private static String m63a(String str, String str2) {
        return C0021i.m65a(str.getBytes(), str2);
    }

    public static String m66a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : arrayList) {
            stringBuilder.append(append);
        }
        String append2 = stringBuilder.toString();
        return append2.length() > 0 ? C0021i.m62a(append2) : null;
    }

    public static long m76b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long m77b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (((long) statFs.getAvailableBlocks()) * blockSize);
    }

    public static float m80c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
    }

    public static boolean m84d(Context context) {
        if (C0021i.m86f(context)) {
            return false;
        }
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static void m68a(Context context, String str) {
        if (C0021i.m85e(context)) {
            C0142c.m468h().mo46a("Fabric", str);
        }
    }

    public static void m69a(Context context, String str, Throwable th) {
        if (C0021i.m85e(context)) {
            C0142c.m468h().mo53e("Fabric", str);
        }
    }

    public static void m67a(Context context, int i, String str, String str2) {
        if (C0021i.m85e(context)) {
            C0142c.m468h().mo45a(i, "Fabric", str2);
        }
    }

    public static boolean m85e(Context context) {
        if (f36b == null) {
            f36b = Boolean.valueOf(C0021i.m74a(context, "com.crashlytics.Trace", false));
        }
        return f36b.booleanValue();
    }

    public static boolean m74a(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return z;
        }
        int a = C0021i.m53a(context, str, "bool");
        if (a > 0) {
            return resources.getBoolean(a);
        }
        int a2 = C0021i.m53a(context, str, "string");
        if (a2 > 0) {
            return Boolean.parseBoolean(context.getString(a2));
        }
        return z;
    }

    public static int m53a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, C0021i.m90j(context));
    }

    public static boolean m86f(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean m87g(Context context) {
        boolean f = C0021i.m86f(context);
        String str = Build.TAGS;
        if ((!f && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (f || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean m81c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int m88h(Context context) {
        int i = 0;
        if (C0021i.m86f(context)) {
            i = 1;
        }
        if (C0021i.m87g(context)) {
            i |= 2;
        }
        if (C0021i.m81c()) {
            return i | 4;
        }
        return i;
    }

    public static int m54a(Context context, boolean z) {
        float c = C0021i.m80c(context);
        if (!z) {
            return 1;
        }
        if (z && ((double) c) >= 99.0d) {
            return 3;
        }
        if (!z || ((double) c) >= 99.0d) {
            return 0;
        }
        return 2;
    }

    public static String m64a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f37c[i2 >>> 4];
            cArr[(i * 2) + 1] = f37c[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean m89i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String m78b(Context context, String str) {
        int a = C0021i.m53a(context, str, "string");
        if (a > 0) {
            return context.getString(a);
        }
        return "";
    }

    public static void m71a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                C0142c.m468h().mo54e("Fabric", str, e);
            }
        }
    }

    public static void m72a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable e) {
                C0142c.m468h().mo54e("Fabric", str, e);
            }
        }
    }

    public static boolean m83c(String str) {
        return str == null || str.length() == 0;
    }

    public static String m58a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value must be zero or greater");
        }
        return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i)}).replace(' ', '0');
    }

    public static String m90j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    public static void m73a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String m91k(Context context) {
        Closeable openRawResource;
        Throwable e;
        Throwable th;
        String str = null;
        try {
            openRawResource = context.getResources().openRawResource(C0021i.m92l(context));
            try {
                String b = C0021i.m79b((InputStream) openRawResource);
                if (!C0021i.m83c(b)) {
                    str = b;
                }
                C0021i.m71a(openRawResource, "Failed to close icon input stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C0142c.m468h().mo54e("Fabric", "Could not calculate hash for app icon.", e);
                    C0021i.m71a(openRawResource, "Failed to close icon input stream.");
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C0021i.m71a(openRawResource, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            C0142c.m468h().mo54e("Fabric", "Could not calculate hash for app icon.", e);
            C0021i.m71a(openRawResource, "Failed to close icon input stream.");
            return str;
        } catch (Throwable e4) {
            openRawResource = null;
            th = e4;
            C0021i.m71a(openRawResource, "Failed to close icon input stream.");
            throw th;
        }
        return str;
    }

    public static int m92l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m93m(Context context) {
        int a = C0021i.m53a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = C0021i.m53a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        String string = context.getResources().getString(a);
        C0142c.m468h().mo46a("Fabric", "Build ID is: " + string);
        return string;
    }

    public static void m70a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean m82c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean m94n(Context context) {
        if (!C0021i.m82c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
