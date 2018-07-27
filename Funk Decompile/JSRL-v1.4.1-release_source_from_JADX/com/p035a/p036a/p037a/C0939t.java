package com.p035a.p036a.p037a;

/* compiled from: SessionEventMetadata */
final class C0939t {
    public final String f2547a;
    public final String f2548b;
    public final String f2549c;
    public final String f2550d;
    public final String f2551e;
    public final Boolean f2552f;
    public final String f2553g;
    public final String f2554h;
    public final String f2555i;
    public final String f2556j;
    public final String f2557k;
    public final String f2558l;
    private String f2559m;

    public C0939t(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f2547a = str;
        this.f2548b = str2;
        this.f2549c = str3;
        this.f2550d = str4;
        this.f2551e = str5;
        this.f2552f = bool;
        this.f2553g = str6;
        this.f2554h = str7;
        this.f2555i = str8;
        this.f2556j = str9;
        this.f2557k = str10;
        this.f2558l = str11;
    }

    public String toString() {
        if (this.f2559m == null) {
            this.f2559m = "appBundleId=" + this.f2547a + ", executionId=" + this.f2548b + ", installationId=" + this.f2549c + ", androidId=" + this.f2550d + ", advertisingId=" + this.f2551e + ", limitAdTrackingEnabled=" + this.f2552f + ", betaDeviceToken=" + this.f2553g + ", buildId=" + this.f2554h + ", osVersion=" + this.f2555i + ", deviceModel=" + this.f2556j + ", appVersionCode=" + this.f2557k + ", appVersionName=" + this.f2558l;
        }
        return this.f2559m;
    }
}
