package p000a.p001a.p002a.p003a.p004a.p007c;

/* compiled from: Priority */
public enum C0063e {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int m196a(C0064i c0064i, Y y) {
        C0063e b;
        if (y instanceof C0064i) {
            b = ((C0064i) y).mo11b();
        } else {
            b = NORMAL;
        }
        return b.ordinal() - c0064i.mo11b().ordinal();
    }
}
