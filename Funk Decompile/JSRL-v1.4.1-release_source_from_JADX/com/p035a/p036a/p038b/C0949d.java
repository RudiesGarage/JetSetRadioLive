package com.p035a.p036a.p038b;

import java.io.InputStream;
import java.util.Properties;

/* compiled from: BuildProperties */
class C0949d {
    public final String f2586a;
    public final String f2587b;
    public final String f2588c;
    public final String f2589d;

    C0949d(String str, String str2, String str3, String str4) {
        this.f2586a = str;
        this.f2587b = str2;
        this.f2588c = str3;
        this.f2589d = str4;
    }

    public static C0949d m4721a(Properties properties) {
        return new C0949d(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    public static C0949d m4720a(InputStream inputStream) {
        Properties properties = new Properties();
        properties.load(inputStream);
        return C0949d.m4721a(properties);
    }
}
