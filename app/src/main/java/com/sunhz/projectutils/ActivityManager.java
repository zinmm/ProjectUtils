package com.sunhz.projectutils;

import android.app.Activity;
import android.content.Context;

import com.sunhz.projectutils.base.BaseApplication;

/**
 * activity 管理器
 * Created by Spencer on 15/2/3.
 */
public class ActivityManager {


    /**
     * 关掉所有activity
     *
     * @param mContext
     */
    public static void closeAllActivity(Context mContext) {
        int len = BaseApplication.actList.size();
        for (int i = 0; i < len; i++) {
            Activity act = BaseApplication.actList.get(i);
            if (act != null) {
                act.finish();
            }
        }
    }

    public static void closeActivity(Activity activity) {
        BaseApplication.actList.remove(activity);
    }

}