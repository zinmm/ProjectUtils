package com.sunhz.projectutils.asynctaskutils;

import android.os.AsyncTask;

/**
 * 拓展的AsyncTask,随意控制线程并串行
 * Created by Spencer on 15/2/3.
 */
public abstract class AsyncTaskExpand<Params, Progress, Result> extends AsyncTask {

    private boolean flag = SERIAL;

    /**
     * 并行
     */
    public static final boolean PARALLEL = true;

    /**
     * 串行
     */
    public static final boolean SERIAL = false;

    /**
     * 控制是否并行,若系统不支持,便自动为串行
     *
     * @param flag AsyncTaskExpend.PARALLEL or AsyncTaskExpend.SERIAL
     */
    public AsyncTaskExpand(boolean flag) {
        super();
        this.flag = flag;
    }


    @Override
    protected void onPostExecute(Object o) {
        if (flag) {
            super.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, o);
        } else {
            super.onPostExecute(o);
        }

    }
}
