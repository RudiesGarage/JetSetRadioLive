package android.support.v4.p018b;

import android.content.SharedPreferences.Editor;

/* compiled from: SharedPreferencesCompat */
public final class C0294g {

    /* compiled from: SharedPreferencesCompat */
    public static final class C0293a {
        private static C0293a f782a;
        private final C0292a f783b = new C0292a();

        /* compiled from: SharedPreferencesCompat */
        private static class C0292a {
            C0292a() {
            }

            public void m1089a(Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError e) {
                    editor.commit();
                }
            }
        }

        private C0293a() {
        }

        public static C0293a m1090a() {
            if (f782a == null) {
                f782a = new C0293a();
            }
            return f782a;
        }

        public void m1091a(Editor editor) {
            this.f783b.m1089a(editor);
        }
    }
}
