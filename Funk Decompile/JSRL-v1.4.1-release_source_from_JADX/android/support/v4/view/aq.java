package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: ViewPropertyAnimatorCompat */
public final class aq {
    static final C0543g f1123d;
    Runnable f1124a = null;
    Runnable f1125b = null;
    int f1126c = -1;
    private WeakReference<View> f1127e;

    /* compiled from: ViewPropertyAnimatorCompat */
    interface C0543g {
        void mo411a(aq aqVar, View view);

        void mo412a(aq aqVar, View view, float f);

        void mo413a(aq aqVar, View view, long j);

        void mo414a(aq aqVar, View view, at atVar);

        void mo415b(aq aqVar, View view);

        void mo416b(aq aqVar, View view, float f);

        void mo417c(aq aqVar, View view, float f);
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0544a implements C0543g {
        WeakHashMap<View, Runnable> f1119a = null;

        /* compiled from: ViewPropertyAnimatorCompat */
        class C0542a implements Runnable {
            WeakReference<View> f1116a;
            aq f1117b;
            final /* synthetic */ C0544a f1118c;

            C0542a(C0544a c0544a, aq aqVar, View view) {
                this.f1118c = c0544a;
                this.f1116a = new WeakReference(view);
                this.f1117b = aqVar;
            }

            public void run() {
                View view = (View) this.f1116a.get();
                if (view != null) {
                    this.f1118c.m2352c(this.f1117b, view);
                }
            }
        }

        C0544a() {
        }

        public void mo413a(aq aqVar, View view, long j) {
        }

        public void mo412a(aq aqVar, View view, float f) {
            m2345d(aqVar, view);
        }

        public void mo416b(aq aqVar, View view, float f) {
            m2345d(aqVar, view);
        }

        public void mo417c(aq aqVar, View view, float f) {
            m2345d(aqVar, view);
        }

        public void mo411a(aq aqVar, View view) {
            m2345d(aqVar, view);
        }

        public void mo415b(aq aqVar, View view) {
            m2344a(view);
            m2352c(aqVar, view);
        }

        public void mo414a(aq aqVar, View view, at atVar) {
            view.setTag(2113929216, atVar);
        }

        void m2352c(aq aqVar, View view) {
            at atVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof at) {
                atVar = (at) tag;
            } else {
                atVar = null;
            }
            Runnable runnable = aqVar.f1124a;
            Runnable runnable2 = aqVar.f1125b;
            aqVar.f1124a = null;
            aqVar.f1125b = null;
            if (runnable != null) {
                runnable.run();
            }
            if (atVar != null) {
                atVar.mo418a(view);
                atVar.mo419b(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            if (this.f1119a != null) {
                this.f1119a.remove(view);
            }
        }

        private void m2344a(View view) {
            if (this.f1119a != null) {
                Runnable runnable = (Runnable) this.f1119a.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
        }

        private void m2345d(aq aqVar, View view) {
            Runnable runnable = null;
            if (this.f1119a != null) {
                runnable = (Runnable) this.f1119a.get(view);
            }
            if (runnable == null) {
                runnable = new C0542a(this, aqVar, view);
                if (this.f1119a == null) {
                    this.f1119a = new WeakHashMap();
                }
                this.f1119a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0546b extends C0544a {
        WeakHashMap<View, Integer> f1122b = null;

        /* compiled from: ViewPropertyAnimatorCompat */
        static class C0545a implements at {
            aq f1120a;
            boolean f1121b;

            C0545a(aq aqVar) {
                this.f1120a = aqVar;
            }

            public void mo418a(View view) {
                at atVar;
                this.f1121b = false;
                if (this.f1120a.f1126c >= 0) {
                    ae.m2206a(view, 2, null);
                }
                if (this.f1120a.f1124a != null) {
                    Runnable runnable = this.f1120a.f1124a;
                    this.f1120a.f1124a = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof at) {
                    atVar = (at) tag;
                } else {
                    atVar = null;
                }
                if (atVar != null) {
                    atVar.mo418a(view);
                }
            }

            public void mo419b(View view) {
                if (this.f1120a.f1126c >= 0) {
                    ae.m2206a(view, this.f1120a.f1126c, null);
                    this.f1120a.f1126c = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.f1121b) {
                    at atVar;
                    if (this.f1120a.f1125b != null) {
                        Runnable runnable = this.f1120a.f1125b;
                        this.f1120a.f1125b = null;
                        runnable.run();
                    }
                    Object tag = view.getTag(2113929216);
                    if (tag instanceof at) {
                        atVar = (at) tag;
                    } else {
                        atVar = null;
                    }
                    if (atVar != null) {
                        atVar.mo419b(view);
                    }
                    this.f1121b = true;
                }
            }

            public void mo420c(View view) {
                at atVar;
                Object tag = view.getTag(2113929216);
                if (tag instanceof at) {
                    atVar = (at) tag;
                } else {
                    atVar = null;
                }
                if (atVar != null) {
                    atVar.mo420c(view);
                }
            }
        }

        C0546b() {
        }

        public void mo413a(aq aqVar, View view, long j) {
            ar.m2377a(view, j);
        }

        public void mo412a(aq aqVar, View view, float f) {
            ar.m2376a(view, f);
        }

        public void mo416b(aq aqVar, View view, float f) {
            ar.m2380b(view, f);
        }

        public void mo417c(aq aqVar, View view, float f) {
            ar.m2381c(view, f);
        }

        public void mo411a(aq aqVar, View view) {
            ar.m2375a(view);
        }

        public void mo415b(aq aqVar, View view) {
            ar.m2379b(view);
        }

        public void mo414a(aq aqVar, View view, at atVar) {
            view.setTag(2113929216, atVar);
            ar.m2378a(view, new C0545a(aqVar));
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0547d extends C0546b {
        C0547d() {
        }

        public void mo414a(aq aqVar, View view, at atVar) {
            as.m2382a(view, atVar);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0548c extends C0547d {
        C0548c() {
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0549e extends C0548c {
        C0549e() {
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0550f extends C0549e {
        C0550f() {
        }
    }

    aq(View view) {
        this.f1127e = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1123d = new C0550f();
        } else if (i >= 19) {
            f1123d = new C0549e();
        } else if (i >= 18) {
            f1123d = new C0548c();
        } else if (i >= 16) {
            f1123d = new C0547d();
        } else if (i >= 14) {
            f1123d = new C0546b();
        } else {
            f1123d = new C0544a();
        }
    }

    public aq m2369a(long j) {
        View view = (View) this.f1127e.get();
        if (view != null) {
            f1123d.mo413a(this, view, j);
        }
        return this;
    }

    public aq m2368a(float f) {
        View view = (View) this.f1127e.get();
        if (view != null) {
            f1123d.mo412a(this, view, f);
        }
        return this;
    }

    public aq m2372b(float f) {
        View view = (View) this.f1127e.get();
        if (view != null) {
            f1123d.mo416b(this, view, f);
        }
        return this;
    }

    public aq m2374c(float f) {
        View view = (View) this.f1127e.get();
        if (view != null) {
            f1123d.mo417c(this, view, f);
        }
        return this;
    }

    public void m2371a() {
        View view = (View) this.f1127e.get();
        if (view != null) {
            f1123d.mo411a(this, view);
        }
    }

    public void m2373b() {
        View view = (View) this.f1127e.get();
        if (view != null) {
            f1123d.mo415b(this, view);
        }
    }

    public aq m2370a(at atVar) {
        View view = (View) this.f1127e.get();
        if (view != null) {
            f1123d.mo414a(this, view, atVar);
        }
        return this;
    }
}
