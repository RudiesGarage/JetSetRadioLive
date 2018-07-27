package org.greenrobot.eventbus;

import android.util.Log;

final class BackgroundPoster implements Runnable {
    private final EventBus eventBus;
    private volatile boolean executorRunning;
    private final PendingPostQueue queue = new PendingPostQueue();

    BackgroundPoster(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        PendingPost obtainPendingPost = PendingPost.obtainPendingPost(subscription, obj);
        synchronized (this) {
            this.queue.enqueue(obtainPendingPost);
            if (!this.executorRunning) {
                this.executorRunning = true;
                this.eventBus.getExecutorService().execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                PendingPost poll = this.queue.poll(1000);
                if (poll == null) {
                    synchronized (this) {
                        poll = this.queue.poll();
                        if (poll == null) {
                            this.executorRunning = false;
                            this.executorRunning = false;
                            return;
                        }
                    }
                }
                this.eventBus.invokeSubscriber(poll);
            } catch (Throwable e) {
                Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                this.executorRunning = false;
                return;
            } catch (Throwable th) {
                this.executorRunning = false;
            }
        }
    }
}
