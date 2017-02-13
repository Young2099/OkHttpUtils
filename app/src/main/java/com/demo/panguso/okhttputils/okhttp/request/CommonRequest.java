package com.demo.panguso.okhttputils.okhttp.request;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by ${yf} on 2017/2/13.
 * 负责创建request的各种请求对象，包括get和post请求，上传文件和下载文件的请求
 */

public class CommonRequest {

    /**
     * 创建get请求的Request对象
     *
     * @param url
     * @param params
     * @return
     */
    public static Request createGetRequest(String url, RequestParams params) {
        //创建url字符串的链接
        StringBuilder builder = new StringBuilder(url).append("?");
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                //拼接字符串形成url的地址get请求
                builder.append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        return new Request.Builder().url(builder.substring(0, builder.length() - 1)).get().build();
    }

    /**
     * 创建post的请求对象
     *
     * @param url
     * @param params
     * @return
     */
    public static Request createPostRequest(String url, RequestParams params) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        //创建请求体
        FormBody body = builder.build();
        return new Request.Builder().url(url).post(body).build();
    }

    private static final MediaType File_TYPE =
            MediaType.parse("application/x-www-form-urlencoded");

    /**
     * 文件上传的请求对象
     *
     * @param url
     * @param params
     * @return
     */
    public static Request createMultipartBody(String url, RequestParams params) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);//类型，表单形式的提交
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.fileParams.entrySet()) {
                if (entry.getValue() instanceof File) {
                    builder.addPart(MultipartBody.Part.createFormData(entry.getKey(),
                            String.valueOf(RequestBody.create(File_TYPE, String.valueOf(entry.getValue())))));
                } else {
                    builder.addFormDataPart(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
        }
        return new Request.Builder().url(url).post(builder.build()).build();
    }
}
