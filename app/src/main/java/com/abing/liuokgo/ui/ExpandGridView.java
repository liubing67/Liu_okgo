package com.abing.liuokgo.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 项目名称：Liu_okgo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2017/3/22 13:35
 * 修改人：Administrator
 * 修改时间：2017/3/22 13:35
 * 修改备注：
 */
public class ExpandGridView extends GridView {
    public ExpandGridView(Context context) {
        super(context);
    }

    public ExpandGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
