package com.sunhz.projectutils.mediautils;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

import java.io.File;

/**
 * 多媒体相关工具类 Created by spencer on 2015/1/30.
 */
public class MediaUtils {

    private static MediaUtils mediaUtils;

    private MediaUtils() {

    }

    public synchronized static MediaUtils getInstance() {
        if (mediaUtils == null) {
            mediaUtils = new MediaUtils();
        }
        return mediaUtils;
    }

    /**
     * 向媒体库中插入一条数据,进行媒体更新
     * @param mContext
     * @param file 待插入媒体文件在手机中的绝对路径
     * @param mediaScanCompletedCallBack  插入完成后的回调
     */
    public void mediaScan(Context mContext, File file,
            final MediaScanCompletedCallBack mediaScanCompletedCallBack) {
        MediaScannerConnection.scanFile(mContext, new String[] { file.getAbsolutePath() }, null,
                new MediaScannerConnection.OnScanCompletedListener() {

                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        mediaScanCompletedCallBack.onScanCompleted(path, uri);
                    }
                });
    }

    public interface MediaScanCompletedCallBack {

        void onScanCompleted(String path, Uri uri);
    }
}
