package p000a.p001a.p002a.p003a.p004a.p007c.p008a;

/* compiled from: RetryState */
public class C0058e {
    private final int f119a;
    private final C0054a f120b;
    private final C0055d f121c;

    public C0058e(C0054a c0054a, C0055d c0055d) {
        this(0, c0054a, c0055d);
    }

    public C0058e(int i, C0054a c0054a, C0055d c0055d) {
        this.f119a = i;
        this.f120b = c0054a;
        this.f121c = c0055d;
    }

    public long m164a() {
        return this.f120b.mo9a(this.f119a);
    }

    public C0058e m165b() {
        return new C0058e(this.f119a + 1, this.f120b, this.f121c);
    }

    public C0058e m166c() {
        return new C0058e(this.f120b, this.f121c);
    }
}
