package org.greenrobot.eventbus;

import java.lang.reflect.Method;

public class SubscriberMethod {
    final Class<?> eventType;
    final Method method;
    String methodString;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethod(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = cls;
        this.priority = i;
        this.sticky = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        checkMethodString();
        SubscriberMethod subscriberMethod = (SubscriberMethod) obj;
        subscriberMethod.checkMethodString();
        return this.methodString.equals(subscriberMethod.methodString);
    }

    private synchronized void checkMethodString() {
        if (this.methodString == null) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append(this.method.getDeclaringClass().getName());
            stringBuilder.append('#').append(this.method.getName());
            stringBuilder.append('(').append(this.eventType.getName());
            this.methodString = stringBuilder.toString();
        }
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
