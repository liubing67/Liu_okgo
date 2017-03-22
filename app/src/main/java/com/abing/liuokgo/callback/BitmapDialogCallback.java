package com.abing.liuokgo.callback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.Window;

import com.abing.tools.LoadingDialogView;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.request.BaseRequest;

/**
 * ================================================
 * 作    者：廖子尧
 * 版    本：1.0
 * 创建日期：2016/1/14
 * 描    述：请求图图片的时候显示对话框
 * 修订历史：
 * ================================================
 */
public abstract class BitmapDialogCallback extends BitmapCallback {

    private LoadingDialogView mWaitDialog;

    public BitmapDialogCallback(Activity activity) {
        if (mWaitDialog != null && mWaitDialog.isShowing()) return;
        mWaitDialog = LoadingDialogView.loadingDefaultDialog(activity,false);
    }

    @Override
    public void onBefore(BaseRequest request) {
        if (mWaitDialog != null && !mWaitDialog.isShowing()) {
            mWaitDialog.show();
        }
    }

    @Override
    public void onAfter(@Nullable Bitmap bitmap, @Nullable Exception e) {
        if (mWaitDialog != null && mWaitDialog.isShowing()) {
            mWaitDialog.cancel();
        }
    }
}
