package com.sunhz.projectutils.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.sunhz.projectutils.CrashHandler;
import com.sunhz.projectutils.DebugController;

import java.util.ArrayList;

public class BaseApplication extends Application {

    private Context mContext;

    private static BaseApplication baseApplication;

    private ArrayList<Activity> actList = new ArrayList<Activity>();

    public synchronized static BaseApplication getInstance() {
        if (baseApplication == null) {
            baseApplication = new BaseApplication();
        }
        return baseApplication;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;


        if (!DebugController.isDebug) {
            CrashHandler.getInstance(mContext).init();
        }
    }

    public void addActivity(Activity activity) {
        actList.add(activity);
    }

    public void removeActivity(Activity activity) {
        actList.remove(activity);
    }

    public ArrayList<Activity> getAllActivity() {
        return actList;
    }
}
