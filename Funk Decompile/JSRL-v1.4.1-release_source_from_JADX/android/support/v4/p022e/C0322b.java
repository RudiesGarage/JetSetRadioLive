package android.support.v4.p022e;

import android.os.AsyncTask;

/* compiled from: AsyncTaskCompatHoneycomb */
class C0322b {
    static <Params, Progress, Result> void m1194a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
