package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

public abstract class AbstractSubscriberInfo implements SubscriberInfo {
    private final boolean shouldCheckSuperclass;
    private final Class subscriberClass;
    private final Class<? extends SubscriberInfo> superSubscriberInfoClass;

    protected AbstractSubscriberInfo(Class cls, Class<? extends SubscriberInfo> cls2, boolean z) {
        this.subscriberClass = cls;
        this.superSubscriberInfoClass = cls2;
        this.shouldCheckSuperclass = z;
    }

    public Class getSubscriberClass() {
        return this.subscriberClass;
    }

    public SubscriberInfo getSuperSubscriberInfo() {
        Throwable e;
        if (this.superSubscriberInfoClass == null) {
            return null;
        }
        try {
            return (SubscriberInfo) this.superSubscriberInfoClass.newInstance();
        } catch (InstantiationException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    public boolean shouldCheckSuperclass() {
        return this.shouldCheckSuperclass;
    }

    protected SubscriberMethod createSubscriberMethod(String str, Class<?> cls) {
        return createSubscriberMethod(str, cls, ThreadMode.POSTING, 0, false);
    }

    protected SubscriberMethod createSubscriberMethod(String str, Class<?> cls, ThreadMode threadMode) {
        return createSubscriberMethod(str, cls, threadMode, 0, false);
    }

    protected SubscriberMethod createSubscriberMethod(String str, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        try {
            return new SubscriberMethod(this.subscriberClass.getDeclaredMethod(str, new Class[]{cls}), cls, threadMode, i, z);
        } catch (Throwable e) {
            throw new EventBusException("Could not find subscriber method in " + this.subscriberClass + ". Maybe a missing ProGuard rule?", e);
        }
    }
}
