package com.sunhz.projectutils.fileutils;

import java.util.Set;

import android.content.Context;

public class SharePreferenceUtils {

	private static SharePreferenceUtils sharePreferenceUtils;
	private Context mContext;

	private SharePreferenceUtils() {

	}

	private SharePreferenceUtils(Context mContext) {
		this.mContext = mContext;
	}

	public static SharePreferenceUtils getInstance(Context mContext) {
		if (sharePreferenceUtils != null) {
			sharePreferenceUtils = new SharePreferenceUtils(mContext);
		}
		return sharePreferenceUtils;
	}

	public void saveLong(String spName, String key, long content) {
		mContext.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().putLong(key, content).commit();
	}

	public void saveInt(String spName, String key, int content) {
		mContext.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().putLong(key, content).commit();
	}

	public void saveBoolean(String spName, String key, boolean content) {
		mContext.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().putBoolean(key, content).commit();
	}

	public void saveString(String spName, String key, String content) {
		mContext.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().putString(key, content).commit();
	}

	public void saveFloat(String spName, String key, float content) {
		mContext.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().putFloat(key, content).commit();
	}

}
