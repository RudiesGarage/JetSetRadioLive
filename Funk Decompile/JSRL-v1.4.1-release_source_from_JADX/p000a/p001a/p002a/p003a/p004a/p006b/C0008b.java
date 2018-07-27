package p000a.p001a.p002a.p003a.p004a.p006b;

/* compiled from: AdvertisingInfo */
class C0008b {
    public final String f12a;
    public final boolean f13b;

    C0008b(String str, boolean z) {
        this.f12a = str;
        this.f13b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0008b c0008b = (C0008b) obj;
        if (this.f13b != c0008b.f13b) {
            return false;
        }
        if (this.f12a != null) {
            if (this.f12a.equals(c0008b.f12a)) {
                return true;
            }
        } else if (c0008b.f12a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f12a != null) {
            hashCode = this.f12a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f13b) {
            i = 1;
        }
        return hashCode + i;
    }
}
