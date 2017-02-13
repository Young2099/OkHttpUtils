package com.demo.panguso.okhttputils.okhttp.listener;

/**
 * Created by ${yf} on 2017/2/13.
 * 设置请求参数的响应接口
 */

public interface DataListerer {
    void onSuccess(Object responseObj);
    void onFailure(Object responseFail);
}
