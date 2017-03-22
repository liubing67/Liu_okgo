package com.abing.liuokgo.model;

/**
 * 项目名称：Liu_okgo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2017/3/22 15:10
 * 修改人：Administrator
 * 修改时间：2017/3/22 15:10
 * 修改备注：
 */
public class Log<T>  {

    private int rtState;
    private String rtMsrg;
    private T rtData;
    private int totalRecord;

    @Override
    public String toString() {
        return "Log{" +
                "rtState=" + rtState +
                ", rtMsrg='" + rtMsrg + '\'' +
                ", rtData=" + rtData +
                ", totalRecord=" + totalRecord +
                '}';
    }
}
