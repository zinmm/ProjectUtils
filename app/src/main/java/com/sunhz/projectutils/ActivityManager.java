package com.sunhz.projectutils;

import android.app.Activity;
import android.content.Context;

import com.sunhz.projectutils.base.BaseApplication;

import java.util.List;

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
        List<Activity> activityList = BaseApplication.getInstance().getAllActivity();
        for (int i = 0; i < activityList.size(); i++) {
            Activity activity = activityList.get(i);
            if (activity != null) {
                activity.finish();
            }
        }
    }

}