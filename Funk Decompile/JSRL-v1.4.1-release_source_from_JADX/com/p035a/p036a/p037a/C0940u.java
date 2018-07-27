package com.p035a.p036a.p037a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.IOException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p009d.C0075a;

/* compiled from: SessionEventTransform */
class C0940u implements C0075a<C0938s> {
    C0940u() {
    }

    public byte[] m4687a(C0938s c0938s) {
        return m4689b(c0938s).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    public JSONObject m4689b(C0938s c0938s) {
        try {
            JSONObject jSONObject = new JSONObject();
            C0939t c0939t = c0938s.f2538a;
            jSONObject.put("appBundleId", c0939t.f2547a);
            jSONObject.put("executionId", c0939t.f2548b);
            jSONObject.put("installationId", c0939t.f2549c);
            jSONObject.put("androidId", c0939t.f2550d);
            jSONObject.put("advertisingId", c0939t.f2551e);
            jSONObject.put("limitAdTrackingEnabled", c0939t.f2552f);
            jSONObject.put("betaDeviceToken", c0939t.f2553g);
            jSONObject.put("buildId", c0939t.f2554h);
            jSONObject.put("osVersion", c0939t.f2555i);
            jSONObject.put("deviceModel", c0939t.f2556j);
            jSONObject.put("appVersionCode", c0939t.f2557k);
            jSONObject.put("appVersionName", c0939t.f2558l);
            jSONObject.put("timestamp", c0938s.f2539b);
            jSONObject.put("type", c0938s.f2540c.toString());
            if (c0938s.f2541d != null) {
                jSONObject.put("details", new JSONObject(c0938s.f2541d));
            }
            jSONObject.put("customType", c0938s.f2542e);
            if (c0938s.f2543f != null) {
                jSONObject.put("customAttributes", new JSONObject(c0938s.f2543f));
            }
            jSONObject.put("predefinedType", c0938s.f2544g);
            if (c0938s.f2545h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(c0938s.f2545h));
            }
            return jSONObject;
        } catch (Throwable e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
