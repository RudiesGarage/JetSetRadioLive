package android.support.v7.p028c.p029a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.p015c.C0317a;
import android.support.v7.p027b.C0670a.C0659a;
import android.support.v7.p027b.C0670a.C0669k;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AppCompatColorStateListInflater */
final class C0671a {
    public static ColorStateList m2761a(Resources resources, XmlPullParser xmlPullParser, Theme theme) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return C0671a.m2762a(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static ColorStateList m2762a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return C0671a.m2764b(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static ColorStateList m2764b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        Object trimStateSet;
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = new int[20][];
        Object obj2 = obj;
        int i = 0;
        Object obj3 = new int[obj.length];
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                break;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                break;
            } else if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray a = C0671a.m2763a(resources, theme, attributeSet, C0669k.ColorStateListItem);
                int color = a.getColor(C0669k.ColorStateListItem_android_color, -65281);
                float f = 1.0f;
                if (a.hasValue(C0669k.ColorStateListItem_android_alpha)) {
                    f = a.getFloat(C0669k.ColorStateListItem_android_alpha, 1.0f);
                } else if (a.hasValue(C0669k.ColorStateListItem_alpha)) {
                    f = a.getFloat(C0669k.ColorStateListItem_alpha, 1.0f);
                }
                a.recycle();
                int i2 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i3 = 0;
                while (i3 < attributeCount) {
                    depth2 = attributeSet.getAttributeNameResource(i3);
                    if (depth2 == 16843173 || depth2 == 16843551 || depth2 == C0659a.alpha) {
                        depth2 = i2;
                    } else {
                        int i4 = i2 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                            depth2 = -depth2;
                        }
                        iArr[i2] = depth2;
                        depth2 = i4;
                    }
                    i3++;
                    i2 = depth2;
                }
                trimStateSet = StateSet.trimStateSet(iArr, i2);
                next = C0671a.m2760a(color, f);
                if (i == 0 || trimStateSet.length == 0) {
                    obj = C0674c.m2773a((int[]) obj3, i, next);
                    i++;
                    obj2 = (int[][]) C0674c.m2774a((Object[]) obj2, i, trimStateSet);
                    obj3 = obj;
                } else {
                    obj = C0674c.m2773a((int[]) obj3, i, next);
                    i++;
                    obj2 = (int[][]) C0674c.m2774a((Object[]) obj2, i, trimStateSet);
                    obj3 = obj;
                }
            }
        }
        obj = new int[i];
        trimStateSet = new int[i][];
        System.arraycopy(obj3, 0, obj, 0, i);
        System.arraycopy(obj2, 0, trimStateSet, 0, i);
        return new ColorStateList(trimStateSet, obj);
    }

    private static TypedArray m2763a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static int m2760a(int i, float f) {
        return C0317a.m1188b(i, Math.round(((float) Color.alpha(i)) * f));
    }
}
