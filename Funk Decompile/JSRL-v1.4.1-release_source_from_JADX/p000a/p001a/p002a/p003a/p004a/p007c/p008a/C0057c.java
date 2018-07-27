package p000a.p001a.p002a.p003a.p004a.p007c.p008a;

/* compiled from: ExponentialBackoff */
public class C0057c implements C0054a {
    private final long f117a;
    private final int f118b;

    public C0057c(long j, int i) {
        this.f117a = j;
        this.f118b = i;
    }

    public long mo9a(int i) {
        return (long) (((double) this.f117a) * Math.pow((double) this.f118b, (double) i));
    }
}
