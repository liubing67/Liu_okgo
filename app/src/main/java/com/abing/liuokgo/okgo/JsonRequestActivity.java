package com.abing.liuokgo.okgo;

import android.os.Bundle;
import android.view.View;

import com.abing.liuokgo.R;
import com.abing.liuokgo.base.BaseDetailActivity;
import com.abing.liuokgo.callback.DialogCallback;
import com.abing.liuokgo.model.LzyResponse;
import com.abing.liuokgo.model.ServerModel;
import com.abing.liuokgo.utils.Urls;
import com.lzy.okgo.OkGo;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class JsonRequestActivity extends BaseDetailActivity {

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_custom_request);
        ButterKnife.bind(this);
        actionBar.setTitle("自动解析Json对象");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，取消网络请求
        OkGo.getInstance().cancelTag(this);
    }

    /**
     * 解析javabean对象
     */
    @OnClick(R.id.requestJson)
    public void requestJson(View view) {
        OkGo.get(Urls.URL_JSONOBJECT)//
                .tag(this)//
                .headers("header1", "headerValue1")//
                .params("param1", "paramValue1")//
                .execute(new DialogCallback<LzyResponse<ServerModel>>(this) {
                    @Override
                    public void onSuccess(LzyResponse<ServerModel> responseData, Call call, Response response) {
                        handleResponse(responseData.data, call, response);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        handleError(call, response);
                    }
                });
    }

    /**
     * 解析集合对象
     */
    @OnClick(R.id.requestJsonArray)
    public void requestJsonArray(View view) {
        OkGo.get(Urls.URL_JSONARRAY)//
                .tag(this)//
                .headers("header1", "headerValue1")//
                .params("param1", "paramValue1")//
                .execute(new DialogCallback<LzyResponse<List<ServerModel>>>(this) {
                    @Override
                    public void onSuccess(LzyResponse<List<ServerModel>> responseData, Call call, Response response) {
                        handleResponse(responseData.data, call, response);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        handleError(call, response);
                    }
                });
    }
}
