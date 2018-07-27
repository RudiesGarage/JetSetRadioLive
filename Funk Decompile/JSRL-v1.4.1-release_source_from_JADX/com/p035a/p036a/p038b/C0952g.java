package com.p035a.p036a.p038b;

import org.json.JSONObject;

/* compiled from: CheckForUpdatesResponseTransform */
class C0952g {
    C0952g() {
    }

    public C0951f m4726a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C0951f(jSONObject.optString("url", null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}
