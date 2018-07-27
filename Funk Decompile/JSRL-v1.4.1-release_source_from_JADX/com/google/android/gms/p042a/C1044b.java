package com.google.android.gms.p042a;

import android.os.IBinder;
import com.google.android.gms.p042a.C1041a.C1043a;
import java.lang.reflect.Field;

public final class C1044b<T> extends C1043a {
    private final T f2809a;

    private C1044b(T t) {
        this.f2809a = t;
    }

    public static <T> C1041a m5057a(T t) {
        return new C1044b(t);
    }

    public static <T> T m5058a(C1041a c1041a) {
        if (c1041a instanceof C1044b) {
            return ((C1044b) c1041a).f2809a;
        }
        IBinder asBinder = c1041a.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
            }
        }
        throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
    }
}
