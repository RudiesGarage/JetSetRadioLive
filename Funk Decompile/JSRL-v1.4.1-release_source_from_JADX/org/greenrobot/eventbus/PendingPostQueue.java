package org.greenrobot.eventbus;

final class PendingPostQueue {
    private PendingPost head;
    private PendingPost tail;

    PendingPostQueue() {
    }

    synchronized void enqueue(PendingPost pendingPost) {
        if (pendingPost == null) {
            throw new NullPointerException("null cannot be enqueued");
        }
        if (this.tail != null) {
            this.tail.next = pendingPost;
            this.tail = pendingPost;
        } else if (this.head == null) {
            this.tail = pendingPost;
            this.head = pendingPost;
        } else {
            throw new IllegalStateException("Head present, but no tail");
        }
        notifyAll();
    }

    synchronized PendingPost poll() {
        PendingPost pendingPost;
        pendingPost = this.head;
        if (this.head != null) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
        }
        return pendingPost;
    }

    synchronized PendingPost poll(int i) {
        if (this.head == null) {
            wait((long) i);
        }
        return poll();
    }
}
