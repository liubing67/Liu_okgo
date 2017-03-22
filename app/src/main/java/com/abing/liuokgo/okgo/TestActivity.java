package com.abing.liuokgo.okgo;

import android.database.Observable;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.abing.liuokgo.R;
import com.abing.liuokgo.base.BaseActivity;
import com.abing.liuokgo.callback.JsonConvert;
import com.abing.liuokgo.model.LzyResponse;
import com.abing.liuokgo.model.ServerModel;
import com.abing.liuokgo.utils.Urls;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.adapter.Call;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.convert.BitmapConvert;
import com.lzy.okgo.convert.FileConvert;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.request.BaseRequest;

import java.io.File;
import butterknife.OnClick;
import butterknife.Bind;
import okhttp3.Response;

public class TestActivity extends BaseActivity {

    @Bind(R.id.image) ImageView imageView;
    @Bind(R.id.edit) EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setTitle("测试页面");
    }

    @OnClick(R.id.btn1)
    public void btn1(View view) {
        Call<String> stringCall = OkGo.get("").getCall(StringConvert.create());
        Call<Bitmap> bitmapCall = OkGo.get("").getCall(BitmapConvert.create());
        Call<File> fileCall = OkGo.get("").getCall(new FileConvert());
        Call<LzyResponse<ServerModel>> call = OkGo.get("").getCall(new JsonConvert<LzyResponse<ServerModel>>() {});
        Call<LzyResponse<ServerModel>> listCall = OkGo.get("").getCall(new JsonConvert<LzyResponse<ServerModel>>() {});

//        Observable<String> stringObservable = OkGo.get("").getCall(StringConvert.create(), RxAdapter.<String>create());
//        Observable<LzyResponse<ServerModel>> observable = OkGo.get("").getCall(new JsonConvert<LzyResponse<ServerModel>>() {}, RxAdapter.<LzyResponse<ServerModel>>create());
    }

    @OnClick(R.id.btn2)
    public void btn2(View view) {
    }

    @OnClick(R.id.btn3)
    public void btn3(View view) {
        OkGo.get(Urls.URL_METHOD)//
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        System.out.println("---" + request.getMethod());
                        System.out.println("---" + request.getMethod());
                    }

                    @Override
                    public void onSuccess(String s, okhttp3.Call call, Response response) {

                    }
                });
    }
}