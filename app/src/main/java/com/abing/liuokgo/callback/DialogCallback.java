package com.abing.liuokgo.callback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.view.Window;

import com.abing.tools.LoadingDialogView;
import com.lzy.okgo.request.BaseRequest;

/**
 * ================================================
 * 作    者：廖子尧
 * 版    本：1.0
 * 创建日期：2016/1/14
 * 描    述：对于网络请求是否需要弹出进度对话框
 * 修订历史：
 * ================================================
 */
public abstract class DialogCallback<T> extends JsonCallback<T> {

    private LoadingDialogView mWaitDialog;

    private void initDialog(Activity activity) {
        if (mWaitDialog != null && mWaitDialog.isShowing()) return;
        mWaitDialog = LoadingDialogView.loadingDefaultDialog(activity,true);
    }

    public DialogCallback(Activity activity) {
        super();
        initDialog(activity);
    }

    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        //网络请求前显示对话框
        if (mWaitDialog != null && !mWaitDialog.isShowing()) {
            mWaitDialog.show();
        }
    }

    @Override
    public void onAfter(@Nullable T t, @Nullable Exception e) {
        super.onAfter(t, e);
        //网络请求结束后关闭对话框
        if (mWaitDialog != null && mWaitDialog.isShowing()) {
            mWaitDialog.cancel();
        }
    }
}
