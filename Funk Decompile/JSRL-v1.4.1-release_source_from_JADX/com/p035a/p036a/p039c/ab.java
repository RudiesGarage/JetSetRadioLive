package com.p035a.p036a.p039c;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p002a.p003a.C0142c;

/* compiled from: SessionReport */
class ab implements C0964y {
    private final File f2632a;
    private final Map<String, String> f2633b;

    public ab(File file) {
        this(file, Collections.emptyMap());
    }

    public ab(File file, Map<String, String> map) {
        this.f2632a = file;
        this.f2633b = new HashMap(map);
        if (this.f2632a.length() == 0) {
            this.f2633b.putAll(C1038z.f2802a);
        }
    }

    public File mo732d() {
        return this.f2632a;
    }

    public String mo730b() {
        return mo732d().getName();
    }

    public String mo731c() {
        String b = mo730b();
        return b.substring(0, b.lastIndexOf(46));
    }

    public Map<String, String> mo733e() {
        return Collections.unmodifiableMap(this.f2633b);
    }

    public boolean mo729a() {
        C0142c.m468h().mo46a("CrashlyticsCore", "Removing report at " + this.f2632a.getPath());
        return this.f2632a.delete();
    }
}
