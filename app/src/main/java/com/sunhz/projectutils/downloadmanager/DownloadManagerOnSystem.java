package com.sunhz.projectutils.downloadmanager;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;

/**
 * 系统自带的DownloadManager进行下载
 * Created by Spencer on 15/2/4.
 */
public class DownloadManagerOnSystem {

    private Context mContext;

    private DownloadCompleteCallBack downloadCompleteCallBack;

    private long lastDownloadID;

    private static DownloadManagerOnSystem downloadManagerOnSystem;

    private DownloadManagerOnSystem(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 使用时,要执行startDownloadFile,也要在界面销毁或下载完成时,执行endDownloadFile操作
     *
     * @param mContext
     * @return
     */
    public static DownloadManagerOnSystem getInstance(Context mContext) {
        if (downloadManagerOnSystem == null) {
            downloadManagerOnSystem = new DownloadManagerOnSystem(mContext);
        }
        return downloadManagerOnSystem;
    }

    /**
     * 直接进行下载文件操作.并打开系统的notification(有进度条)
     *
     * @param url                      下载文件链接地址
     * @param fileName                 文件名
     * @param mimeType                 文件类型
     * @param downloadCompleteCallBack 下载完成时的回调
     */
    public void startDownloadFile(String url, String fileName, String mimeType, DownloadCompleteCallBack downloadCompleteCallBack) {

        this.downloadCompleteCallBack = downloadCompleteCallBack;

        Uri uri = Uri.parse(url);

        DownloadManager dowanloadmanagerService = (DownloadManager) mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        lastDownloadID = dowanloadmanagerService.enqueue(new DownloadManager.Request(uri)
                .setAllowedNetworkTypes(
                        DownloadManager.Request.NETWORK_MOBILE
                                | DownloadManager.Request.NETWORK_WIFI)
                .setAllowedOverRoaming(false)
                .setNotificationVisibility(
                        DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
                .setMimeType(mimeType));
        mContext.registerReceiver(downloadBroadcastReceiver, new IntentFilter(
                DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    private BroadcastReceiver downloadBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            downloadCompleteCallBack.downloadCompleteCallBak(context, intent);
        }
    };

    public long getLastDownloadID() {
        return lastDownloadID;
    }


    public void endDownloadFile() {
        mContext.unregisterReceiver(downloadBroadcastReceiver);
    }

    public interface DownloadCompleteCallBack {
        void downloadCompleteCallBak(Context context, Intent intent);
    }

}
