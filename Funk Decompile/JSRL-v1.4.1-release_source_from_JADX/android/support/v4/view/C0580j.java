package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* compiled from: LayoutInflaterCompatBase */
class C0580j {

    /* compiled from: LayoutInflaterCompatBase */
    static class C0579a implements Factory {
        final C0233m f1142a;

        C0579a(C0233m c0233m) {
            this.f1142a = c0233m;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f1142a.mo143a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f1142a + "}";
        }
    }

    static void m2467a(LayoutInflater layoutInflater, C0233m c0233m) {
        layoutInflater.setFactory(c0233m != null ? new C0579a(c0233m) : null);
    }
}
