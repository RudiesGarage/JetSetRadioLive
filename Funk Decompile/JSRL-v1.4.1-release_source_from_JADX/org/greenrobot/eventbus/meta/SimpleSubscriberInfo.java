package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

public class SimpleSubscriberInfo extends AbstractSubscriberInfo {
    private final SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(Class cls, boolean z, SubscriberMethodInfo[] subscriberMethodInfoArr) {
        super(cls, null, z);
        this.methodInfos = subscriberMethodInfoArr;
    }

    public synchronized SubscriberMethod[] getSubscriberMethods() {
        SubscriberMethod[] subscriberMethodArr;
        int length = this.methodInfos.length;
        subscriberMethodArr = new SubscriberMethod[length];
        for (int i = 0; i < length; i++) {
            SubscriberMethodInfo subscriberMethodInfo = this.methodInfos[i];
            subscriberMethodArr[i] = createSubscriberMethod(subscriberMethodInfo.methodName, subscriberMethodInfo.eventType, subscriberMethodInfo.threadMode, subscriberMethodInfo.priority, subscriberMethodInfo.sticky);
        }
        return subscriberMethodArr;
    }
}
