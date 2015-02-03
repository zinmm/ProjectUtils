package com.sunhz.projectutils.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.sunhz.projectutils.CrashHandler;
import com.sunhz.projectutils.DebugController;

import java.util.ArrayList;
import java.util.List;

public class BaseApplication extends Application {
    private Context mContext;
    public static List<Activity> actList;
	@Override
	public void onCreate() {
		super.onCreate();
        this.mContext = mContext;
        actList = new ArrayList<Activity>() ;


        if (!DebugController.isDebug){
            CrashHandler.getInstance().init(mContext);
        }
	}
}
