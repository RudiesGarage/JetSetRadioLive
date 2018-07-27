package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.C1222c;
import com.google.android.gms.common.util.C1223d;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new C1050a();
    public static C1222c f2816a = C1223d.m5679a();
    private static Comparator<Scope> f2817n = new C10491();
    final int f2818b;
    List<Scope> f2819c;
    private String f2820d;
    private String f2821e;
    private String f2822f;
    private String f2823g;
    private Uri f2824h;
    private String f2825i;
    private long f2826j;
    private String f2827k;
    private String f2828l;
    private String f2829m;

    class C10491 implements Comparator<Scope> {
        C10491() {
        }

        public int m5063a(Scope scope, Scope scope2) {
            return scope.m5280a().compareTo(scope2.m5280a());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5063a((Scope) obj, (Scope) obj2);
        }
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f2818b = i;
        this.f2820d = str;
        this.f2821e = str2;
        this.f2822f = str3;
        this.f2823g = str4;
        this.f2824h = uri;
        this.f2825i = str5;
        this.f2826j = j;
        this.f2827k = str6;
        this.f2819c = list;
        this.f2828l = str7;
        this.f2829m = str8;
    }

    private JSONObject m5064l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m5065a() != null) {
                jSONObject.put("id", m5065a());
            }
            if (m5066b() != null) {
                jSONObject.put("tokenId", m5066b());
            }
            if (m5067c() != null) {
                jSONObject.put("email", m5067c());
            }
            if (m5068d() != null) {
                jSONObject.put("displayName", m5068d());
            }
            if (m5069e() != null) {
                jSONObject.put("givenName", m5069e());
            }
            if (m5070f() != null) {
                jSONObject.put("familyName", m5070f());
            }
            if (m5071g() != null) {
                jSONObject.put("photoUrl", m5071g().toString());
            }
            if (m5072h() != null) {
                jSONObject.put("serverAuthCode", m5072h());
            }
            jSONObject.put("expirationTime", this.f2826j);
            jSONObject.put("obfuscatedIdentifier", m5074j());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f2819c, f2817n);
            for (Scope a : this.f2819c) {
                jSONArray.put(a.m5280a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String m5065a() {
        return this.f2820d;
    }

    public String m5066b() {
        return this.f2821e;
    }

    public String m5067c() {
        return this.f2822f;
    }

    public String m5068d() {
        return this.f2823g;
    }

    public String m5069e() {
        return this.f2828l;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).m5075k().equals(m5075k());
    }

    public String m5070f() {
        return this.f2829m;
    }

    public Uri m5071g() {
        return this.f2824h;
    }

    public String m5072h() {
        return this.f2825i;
    }

    public int hashCode() {
        return m5075k().hashCode();
    }

    public long m5073i() {
        return this.f2826j;
    }

    public String m5074j() {
        return this.f2827k;
    }

    public String m5075k() {
        return m5064l().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1050a.m5076a(this, parcel, i);
    }
}
