package com.thebluealliance.spectrum.p046a;

import android.graphics.Color;

/* compiled from: ColorUtil */
public final class C1271c {
    public static boolean m5824a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 160.0d;
    }

    public static int m5825b(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * 0.5f;
        return Color.HSVToColor(fArr);
    }
}
