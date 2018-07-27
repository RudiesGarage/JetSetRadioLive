package android.support.v7.p028c.p029a;

import java.lang.reflect.Array;

/* compiled from: GrowingArrayUtils */
final class C0674c {
    static final /* synthetic */ boolean f1248a = (!C0674c.class.desiredAssertionStatus());

    public static <T> T[] m2774a(T[] tArr, int i, T t) {
        if (f1248a || i <= tArr.length) {
            T[] tArr2;
            if (i + 1 > tArr.length) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), C0674c.m2772a(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
            } else {
                tArr2 = tArr;
            }
            tArr2[i] = t;
            return tArr2;
        }
        throw new AssertionError();
    }

    public static int[] m2773a(int[] iArr, int i, int i2) {
        if (f1248a || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                Object obj = new int[C0674c.m2772a(i)];
                System.arraycopy(iArr, 0, obj, 0, i);
                iArr = obj;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    public static int m2772a(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    private C0674c() {
    }
}
