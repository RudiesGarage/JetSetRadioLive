package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.p043b.aa;
import java.util.concurrent.Callable;

public abstract class C1233a<T> {

    public static class C1234a extends C1233a<Boolean> {

        class C12321 implements Callable<Boolean> {
            final /* synthetic */ SharedPreferences f3201a;
            final /* synthetic */ String f3202b;
            final /* synthetic */ Boolean f3203c;

            C12321(SharedPreferences sharedPreferences, String str, Boolean bool) {
                this.f3201a = sharedPreferences;
                this.f3202b = str;
                this.f3203c = bool;
            }

            public Boolean m5697a() {
                return Boolean.valueOf(this.f3201a.getBoolean(this.f3202b, this.f3203c.booleanValue()));
            }

            public /* synthetic */ Object call() {
                return m5697a();
            }
        }

        public static Boolean m5698a(SharedPreferences sharedPreferences, String str, Boolean bool) {
            return (Boolean) aa.m5080a(new C12321(sharedPreferences, str, bool));
        }
    }

    public static class C1236b extends C1233a<Integer> {

        class C12351 implements Callable<Integer> {
            final /* synthetic */ SharedPreferences f3204a;
            final /* synthetic */ String f3205b;
            final /* synthetic */ Integer f3206c;

            C12351(SharedPreferences sharedPreferences, String str, Integer num) {
                this.f3204a = sharedPreferences;
                this.f3205b = str;
                this.f3206c = num;
            }

            public Integer m5699a() {
                return Integer.valueOf(this.f3204a.getInt(this.f3205b, this.f3206c.intValue()));
            }

            public /* synthetic */ Object call() {
                return m5699a();
            }
        }

        public static Integer m5700a(SharedPreferences sharedPreferences, String str, Integer num) {
            return (Integer) aa.m5080a(new C12351(sharedPreferences, str, num));
        }
    }

    public static class C1238c extends C1233a<Long> {

        class C12371 implements Callable<Long> {
            final /* synthetic */ SharedPreferences f3207a;
            final /* synthetic */ String f3208b;
            final /* synthetic */ Long f3209c;

            C12371(SharedPreferences sharedPreferences, String str, Long l) {
                this.f3207a = sharedPreferences;
                this.f3208b = str;
                this.f3209c = l;
            }

            public Long m5701a() {
                return Long.valueOf(this.f3207a.getLong(this.f3208b, this.f3209c.longValue()));
            }

            public /* synthetic */ Object call() {
                return m5701a();
            }
        }

        public static Long m5702a(SharedPreferences sharedPreferences, String str, Long l) {
            return (Long) aa.m5080a(new C12371(sharedPreferences, str, l));
        }
    }

    public static class C1240d extends C1233a<String> {

        class C12391 implements Callable<String> {
            final /* synthetic */ SharedPreferences f3210a;
            final /* synthetic */ String f3211b;
            final /* synthetic */ String f3212c;

            C12391(SharedPreferences sharedPreferences, String str, String str2) {
                this.f3210a = sharedPreferences;
                this.f3211b = str;
                this.f3212c = str2;
            }

            public String m5703a() {
                return this.f3210a.getString(this.f3211b, this.f3212c);
            }

            public /* synthetic */ Object call() {
                return m5703a();
            }
        }

        public static String m5704a(SharedPreferences sharedPreferences, String str, String str2) {
            return (String) aa.m5080a(new C12391(sharedPreferences, str, str2));
        }
    }
}
