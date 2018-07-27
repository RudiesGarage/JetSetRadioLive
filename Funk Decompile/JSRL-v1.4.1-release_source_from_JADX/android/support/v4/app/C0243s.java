package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: FragmentTransitionCompat21 */
class C0243s {

    /* compiled from: FragmentTransitionCompat21 */
    public interface C0207b {
        View mo101a();
    }

    /* compiled from: FragmentTransitionCompat21 */
    public static class C0242a {
        public View f669a;
    }

    public static String m930a(View view) {
        return view.getTransitionName();
    }

    public static Object m927a(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    public static Object m928a(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj == null) {
            return obj;
        }
        C0243s.m951b((ArrayList) arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        C0243s.m950b((Transition) obj, (ArrayList) arrayList);
        return obj;
    }

    public static void m937a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void m934a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void m935a(Object obj, View view) {
        Transition transition = (Transition) obj;
        final Rect c = C0243s.m952c(view);
        transition.setEpicenterCallback(new EpicenterCallback() {
            public Rect onGetEpicenter(Transition transition) {
                return c;
            }
        });
    }

    public static Object m948b(Object obj) {
        if (obj == null) {
            return null;
        }
        Transition transition = (Transition) obj;
        if (transition == null) {
            return null;
        }
        Object transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        return transitionSet;
    }

    private static void m949b(Transition transition, Transition transition2, ArrayList<View> arrayList, boolean z) {
        if (transition != null) {
            int size = transition2 == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                transition.excludeTarget((View) arrayList.get(i), z);
            }
        }
    }

    public static void m939a(Object obj, Object obj2, Object obj3, ArrayList<View> arrayList, boolean z) {
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        C0243s.m949b((Transition) obj, transition2, arrayList, z);
        C0243s.m949b(transition, transition2, arrayList, z);
    }

    public static void m938a(Object obj, Object obj2, Object obj3, View view, C0207b c0207b, View view2, C0242a c0242a, Map<String, String> map, ArrayList<View> arrayList, ArrayList<View> arrayList2, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList3) {
        final Transition transition = (Transition) obj;
        final Transition transition2 = (Transition) obj3;
        Object obj4 = (Transition) obj2;
        C0243s.m949b(transition, transition2, arrayList2, true);
        if (obj != null || obj2 != null) {
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                C0243s.m936a(obj4, view2, (Map) map2, (ArrayList) arrayList3);
                C0243s.m949b(transition, obj4, arrayList3, true);
                C0243s.m949b(transition2, obj4, arrayList3, true);
            }
            final View view3 = view;
            final View view4 = view2;
            final C0207b c0207b2 = c0207b;
            final Map<String, String> map4 = map;
            final Map<String, View> map5 = map3;
            final ArrayList<View> arrayList4 = arrayList;
            view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public boolean onPreDraw() {
                    view3.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (transition != null) {
                        transition.removeTarget(view4);
                    }
                    if (c0207b2 != null) {
                        View a = c0207b2.mo101a();
                        if (a != null) {
                            if (!map4.isEmpty()) {
                                C0243s.m943a(map5, a);
                                map5.keySet().retainAll(map4.values());
                                for (Entry entry : map4.entrySet()) {
                                    View view = (View) map5.get((String) entry.getValue());
                                    if (view != null) {
                                        view.setTransitionName((String) entry.getKey());
                                    }
                                }
                            }
                            if (transition != null) {
                                C0243s.m951b(arrayList4, a);
                                arrayList4.removeAll(map5.values());
                                arrayList4.add(view4);
                                C0243s.m950b(transition, arrayList4);
                            }
                        }
                    }
                    C0243s.m949b(transition2, transition, arrayList4, true);
                    return true;
                }
            });
            C0243s.m931a(transition, c0242a);
        }
    }

    public static Object m929a(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition == null || transition2 == null) {
            z = true;
        }
        Object transitionSet;
        if (z) {
            transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 == null) {
                return transitionSet;
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        Transition transition4 = null;
        if (transition2 != null && transition != null) {
            transition4 = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            transition4 = transition2;
        } else if (transition != null) {
            transition4 = transition;
        }
        if (transition3 == null) {
            return transition4;
        }
        transitionSet = new TransitionSet();
        if (transition4 != null) {
            transitionSet.addTransition(transition4);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public static void m936a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = obj.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0243s.m942a(targets, (View) arrayList.get(i));
        }
        arrayList.add(view);
        C0243s.m950b(obj, (ArrayList) arrayList);
    }

    private static void m942a(List<View> list, View view) {
        int size = list.size();
        if (!C0243s.m946a((List) list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!C0243s.m946a((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean m946a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    private static void m931a(Transition transition, final C0242a c0242a) {
        if (transition != null) {
            transition.setEpicenterCallback(new EpicenterCallback() {
                private Rect f657b;

                public Rect onGetEpicenter(Transition transition) {
                    if (this.f657b == null && c0242a.f669a != null) {
                        this.f657b = C0243s.m952c(c0242a.f669a);
                    }
                    return this.f657b;
                }
            });
        }
    }

    private static Rect m952c(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    private static void m951b(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                C0243s.m951b((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void m943a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    C0243s.m943a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void m933a(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        final Transition transition = (Transition) obj;
        final Transition transition2 = (Transition) obj2;
        final Transition transition3 = (Transition) obj3;
        final Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            final View view3 = view;
            final ArrayList<View> arrayList5 = arrayList;
            final ArrayList<View> arrayList6 = arrayList2;
            final ArrayList<View> arrayList7 = arrayList3;
            final Map<String, View> map2 = map;
            final ArrayList<View> arrayList8 = arrayList4;
            final View view4 = view2;
            view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public boolean onPreDraw() {
                    view3.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (transition != null) {
                        C0243s.m940a(transition, arrayList5);
                        C0243s.m949b(transition, transition2, arrayList6, false);
                        C0243s.m949b(transition, transition3, arrayList7, false);
                    }
                    if (transition2 != null) {
                        C0243s.m940a(transition2, arrayList6);
                        C0243s.m949b(transition2, transition, arrayList5, false);
                        C0243s.m949b(transition2, transition3, arrayList7, false);
                    }
                    if (transition3 != null) {
                        C0243s.m940a(transition3, arrayList7);
                    }
                    for (Entry entry : map2.entrySet()) {
                        ((View) entry.getValue()).setTransitionName((String) entry.getKey());
                    }
                    int size = arrayList8.size();
                    for (int i = 0; i < size; i++) {
                        transition4.excludeTarget((View) arrayList8.get(i), false);
                    }
                    transition4.excludeTarget(view4, false);
                    return true;
                }
            });
        }
    }

    public static void m940a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                C0243s.m940a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!C0243s.m944a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void m950b(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                C0243s.m950b(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
                i++;
            }
        } else if (!C0243s.m944a(transition) && C0243s.m945a(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static boolean m944a(Transition transition) {
        return (C0243s.m945a(transition.getTargetIds()) && C0243s.m945a(transition.getTargetNames()) && C0243s.m945a(transition.getTargetTypes())) ? false : true;
    }

    private static boolean m945a(List list) {
        return list == null || list.isEmpty();
    }
}
