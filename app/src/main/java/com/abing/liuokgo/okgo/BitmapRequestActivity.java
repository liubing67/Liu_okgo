package com.abing.liuokgo.okgo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.abing.liuokgo.R;
import com.abing.liuokgo.base.BaseActivity;
import com.abing.liuokgo.base.BaseDetailActivity;
import com.abing.liuokgo.callback.BitmapDialogCallback;
import com.abing.liuokgo.utils.Urls;
import com.lzy.okgo.OkGo;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class BitmapRequestActivity extends BaseDetailActivity {


    @Bind(R.id.requestImage)
    Button requestImage;
    @Bind(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_bitmap_request);
        setTitle("请求图片");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，取消网络请求
        OkGo.getInstance().cancelTag(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.requestImage)
    public void onClick() {
        OkGo.get(Urls.URL_IMAGE)//
                .tag(this)//
                .headers("header1", "headerValue1")//
                .params("param1", "paramValue1")//
                .execute(new BitmapDialogCallback(this) {
                    @Override
                    public void onSuccess(Bitmap bitmap, Call call, Response response) {
                        handleResponse(bitmap, call, response);
                        imageView.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        handleError(call, response);
                    }
                });
    }
}
