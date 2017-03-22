package com.abing.liuokgo.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.abing.liuokgo.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/5
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class GlideImageLoader {
    public void onDisplayImage(Context context, ImageView imageView, String url) {
        Glide.with(context).load(url)//
                .placeholder(R.mipmap.ic_launcher)// 这行貌似是glide的bug,在部分机型上会导致第一次图片不在中间
                .error(R.mipmap.ic_launcher)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }

    public Bitmap getCacheImage(String url) {
        return null;
    }

    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        Glide.with(activity).load(new File(path))//
                .placeholder(R.mipmap.ic_launcher)//
                .error(R.mipmap.ic_launcher)//
                .diskCacheStrategy(DiskCacheStrategy.ALL)//
                .into(imageView);
    }
}
