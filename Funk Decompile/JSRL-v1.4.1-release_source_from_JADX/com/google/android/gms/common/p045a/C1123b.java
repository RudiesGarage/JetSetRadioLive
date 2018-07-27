package com.google.android.gms.common.p045a;

import com.google.android.gms.p043b.C1105w;

public final class C1123b {
    public static C1105w<Integer> f2980a = C1105w.m5228a("gms:common:stats:max_num_of_events", Integer.valueOf(100));
    public static C1105w<Integer> f2981b = C1105w.m5228a("gms:common:stats:max_chunk_size", Integer.valueOf(100));

    public static final class C1122a {
        public static C1105w<Integer> f2974a = C1105w.m5228a("gms:common:stats:connections:level", Integer.valueOf(C1124c.f2983b));
        public static C1105w<String> f2975b = C1105w.m5230a("gms:common:stats:connections:ignored_calling_processes", "");
        public static C1105w<String> f2976c = C1105w.m5230a("gms:common:stats:connections:ignored_calling_services", "");
        public static C1105w<String> f2977d = C1105w.m5230a("gms:common:stats:connections:ignored_target_processes", "");
        public static C1105w<String> f2978e = C1105w.m5230a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static C1105w<Long> f2979f = C1105w.m5229a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
    }
}
