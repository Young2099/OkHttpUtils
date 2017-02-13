package com.demo.panguso.okhttputils.okhttp.listener;

/**
 * Created by ${yf} on 2017/2/13.
 * 构造对DataListener的监听实现
 */

public class DataListererImpl  {
    public DataListerer dataListerer = null;
    public Class<?> mClass = null;//这里为了处理服务器返回的json数据

    public DataListererImpl(DataListerer dataListerer) {
        this.dataListerer = dataListerer;
    }

    public DataListererImpl(DataListerer dataListerer, Class<?> mClass) {
        this.dataListerer = dataListerer;
        this.mClass = mClass;
    }
}
