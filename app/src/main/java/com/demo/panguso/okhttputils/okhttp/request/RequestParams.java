package com.demo.panguso.okhttputils.okhttp.request;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ${yf} on 2017/2/13.
 * 创建请求的参数（url和file类型）
 */

public class RequestParams {
    public ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Object> fileParams = new ConcurrentHashMap<>();

    public RequestParams() {
        this((Map<String, String>) null);
    }

    public RequestParams(Map<String, String> value) {
        if (value != null) {
            for (Map.Entry<String, String> entry : value.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    private void put(String key, String value) {
        urlParams.put(key, value);
        fileParams.put(key, value);
    }
}
