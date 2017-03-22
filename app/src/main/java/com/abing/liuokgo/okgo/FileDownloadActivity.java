package com.abing.liuokgo.okgo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abing.liuokgo.R;
import com.abing.liuokgo.base.BaseDetailActivity;
import com.abing.liuokgo.ui.NumberProgressBar;
import com.abing.liuokgo.utils.Urls;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.request.BaseRequest;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class FileDownloadActivity extends BaseDetailActivity {
    @Bind(R.id.fileDownload)
    Button fileDownload;
    @Bind(R.id.downloadSize)
    TextView downloadSize;
    @Bind(R.id.netSpeed)
    TextView TnetSpeed;
    @Bind(R.id.tvProgress)
    TextView tvProgress;
    @Bind(R.id.pbProgress)
    NumberProgressBar pbProgress;

//    @Bind(R.id.fileDownload) Button btnFileDownload;
//    @Bind(R.id.downloadSize) TextView tvDownloadSize;
//    @Bind(R.id.tvProgress) TextView tvProgress;
//    @Bind(R.id.netSpeed) TextView tvNetSpeed;
//    @Bind(R.id.pbProgress)
//    NumberProgressBar pbProgress;

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_file_download);
        ButterKnife.bind(this);
        setTitle("文件下载");
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

    @OnClick(R.id.fileDownload)
    public void onClick() {
        OkGo.get(Urls.URL_DOWNLOAD)//
                .tag(this)//
                .headers("header1", "headerValue1")//
                .params("param1", "paramValue1")//
                .execute(new FileCallback("OkGo.apk") {
                    @Override
                    public void onBefore(BaseRequest request) {
                        fileDownload.setText("正在下载中");
                    }

                    @Override
                    public void onSuccess(File file, Call call, Response response) {
                        handleResponse(file, call, response);
                        fileDownload.setText("下载完成");
                    }

                    @Override
                    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        System.out.println("downloadProgress -- " + totalSize + "  " + currentSize + "  " + progress + "  " + networkSpeed);

                        String downloadLength = Formatter.formatFileSize(getApplicationContext(), currentSize);
                        String totalLength = Formatter.formatFileSize(getApplicationContext(), totalSize);
                        downloadSize.setText(downloadLength + "/" + totalLength);
                        String netSpeed = Formatter.formatFileSize(getApplicationContext(), networkSpeed);
                        TnetSpeed.setText(netSpeed + "/S");
                        tvProgress.setText((Math.round(progress * 10000) * 1.0f / 100) + "%");
                        pbProgress.setMax(100);
                        pbProgress.setProgress((int) (progress * 100));
                    }

                    @Override
                    public void onError(Call call, @Nullable Response response, @Nullable Exception e) {
                        super.onError(call, response, e);
                        handleError(call, response);
                        fileDownload.setText("下载出错");
                    }
                });
    }
}