package p000a.p001a.p002a.p003a.p004a.p012g;

import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p006b.C0025k;

/* compiled from: DefaultSettingsJsonTransform */
class C0119k implements C0118v {
    C0119k() {
    }

    public C0131t mo43a(C0025k c0025k, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new C0131t(m395a(c0025k, (long) optInt2, jSONObject), m396a(jSONObject.getJSONObject("app")), m400e(jSONObject.getJSONObject("session")), m401f(jSONObject.getJSONObject("prompt")), m398c(jSONObject.getJSONObject("features")), m399d(jSONObject.getJSONObject("analytics")), m402g(jSONObject.getJSONObject("beta")), optInt, optInt2);
    }

    private C0111e m396a(JSONObject jSONObject) {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString("status");
        String string3 = jSONObject.getString("url");
        String string4 = jSONObject.getString("reports_url");
        boolean optBoolean = jSONObject.optBoolean("update_required", false);
        C0109c c0109c = null;
        if (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) {
            c0109c = m397b(jSONObject.getJSONObject("icon"));
        }
        return new C0111e(string, string2, string3, string4, optBoolean, c0109c);
    }

    private C0109c m397b(JSONObject jSONObject) {
        return new C0109c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    private C0122m m398c(JSONObject jSONObject) {
        return new C0122m(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    private C0108b m399d(JSONObject jSONObject) {
        return new C0108b(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    private C0125p m400e(JSONObject jSONObject) {
        return new C0125p(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false));
    }

    private C0124o m401f(JSONObject jSONObject) {
        return new C0124o(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private C0112f m402g(JSONObject jSONObject) {
        return new C0112f(jSONObject.optString("update_endpoint", C0132u.f294a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    private long m395a(C0025k c0025k, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return c0025k.mo8a() + (1000 * j);
    }
}
