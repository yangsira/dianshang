package com.bawei.yangyakai.mvp.model;

import com.bawei.yangyakai.net.HttpUtils;
import com.bawei.yangyakai.net.OkHttpUtils;

import java.util.Map;

import okhttp3.FormBody;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 13:54
 * @Description：描述信息
 */
public class ModelIml implements Model {

    @Override
    public void doget(final int type, String url, final CallBackListener listener) {

        HttpUtils httpUtils = new HttpUtils().get(url, null);
        result(type, listener, httpUtils);
    }

    @Override
    public void dopost(int type, String url, Map<String, String> headMap, Map<String, String> map, CallBackListener listener) {
        HttpUtils httpUtils = new HttpUtils().post(url, map);
        result(type, listener, httpUtils);
    }

    @Override
    public void register(int type, String url, Map<String, String> map, CallBackListener listener) {
        HttpUtils httpUtils = new HttpUtils().post(url, map);
        result(type, listener, httpUtils);
    }

    @Override
    public void login(int type, String url, Map<String, String> map, CallBackListener listener) {
        HttpUtils httpUtils = new HttpUtils().post(url, map);
        result(type, listener, httpUtils);
    }

    @Override
    public void shopping(int type, String url, Map<String, String> headMap, Map<String, String> map, CallBackListener listener) {
        HttpUtils httpUtils = new HttpUtils().get(url, map);
        result(type, listener, httpUtils);
    }

    @Override
    public void particulars(int type, String url,Map<String, String> headMap, Map<String, String> map, CallBackListener listener) {
        HttpUtils httpUtils = new HttpUtils().get(url, map);
        result(type, listener, httpUtils);
    }

    @Override
    public void CircleList(int type, String url, Map<String, String> headMap, Map<String, String> map, CallBackListener listener) {
        HttpUtils httpUtils = new HttpUtils().get(url, map);
        result(type, listener, httpUtils);
    }

    private void result(final int type, final CallBackListener listener, HttpUtils httpUtils) {
        httpUtils.result(new HttpUtils.HttpListener() {
            @Override
            public void success(String data) {
                listener.success(type, data);
            }

            @Override
            public void fail(String error) {
                listener.fail(type, error);
            }
        });
    }

}
