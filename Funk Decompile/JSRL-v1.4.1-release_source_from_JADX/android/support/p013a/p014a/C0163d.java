package android.support.p013a.p014a;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: TypedArrayUtils */
class C0163d {
    public static boolean m545a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static float m542a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !C0163d.m545a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static boolean m544a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !C0163d.m545a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static int m543a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0163d.m545a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static int m546b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0163d.m545a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }
}
