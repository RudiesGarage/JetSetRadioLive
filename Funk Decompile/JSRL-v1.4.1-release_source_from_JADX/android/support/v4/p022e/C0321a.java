package android.support.v4.p022e;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* compiled from: AsyncTaskCompat */
public final class C0321a {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m1193a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            C0322b.m1194a(asyncTask, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
