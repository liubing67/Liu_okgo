package com.abing.liuokgo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abing.liuokgo.base.BaseActivity;
import com.abing.liuokgo.callback.DialogCallback;
import com.abing.liuokgo.callback.StringDialogCallback;
import com.abing.liuokgo.model.ApkModel;
import com.abing.liuokgo.model.Login;
import com.abing.liuokgo.model.LzyResponse;
import com.abing.liuokgo.utils.Urls;
import com.lzy.okgo.OkGo;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 项目名称：Liu_okgo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2017/3/22 14:35
 * 修改人：Administrator
 * 修改时间：2017/3/22 14:35
 * 修改备注：
 */
public class LTextActivity extends BaseActivity {

    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ltext);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                OkGo.post(Urls.URL_login)
                        .params("username", "17321436171")
                        .params("password", "123456789")
                        .execute(new DialogCallback<com.abing.liuokgo.model.Log<Login>>(this) {


                            @Override
                            public void onSuccess(com.abing.liuokgo.model.Log<Login> loginLog, Call call, Response response) {
                                Log.d("111111111111111",loginLog.toString());
                            }

                            @Override
                            public void onError(Call call, Response response, Exception e) {
                                super.onError(call, response, e);
                            }
                        });
                break;
            case R.id.button2:
                OkGo.post(Urls.getHome)
                        .execute(new StringDialogCallback(this) {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                text.setText(s);
                        }

                            @Override
                            public void onError(Call call, Response response, Exception e) {
                                super.onError(call, response, e);
                                text.setText(e.getMessage());
                            }
                        });
                break;
        }


    }
}
