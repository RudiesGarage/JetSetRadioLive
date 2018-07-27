package p000a.p001a.p002a.p003a.p004a.p006b;

/* compiled from: DeliveryMechanism */
public enum C0026l {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    private final int f46e;

    private C0026l(int i) {
        this.f46e = i;
    }

    public int m99a() {
        return this.f46e;
    }

    public String toString() {
        return Integer.toString(this.f46e);
    }

    public static C0026l m98a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
