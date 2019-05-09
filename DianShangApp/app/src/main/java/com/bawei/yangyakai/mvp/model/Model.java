package com.bawei.yangyakai.mvp.model;

import java.util.Map;

import okhttp3.FormBody;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 13:52
 * @Description：描述信息
 */
public interface Model {
    interface CallBackListener {
        void success(int type, String data);

        void fail(int type, String error);
    }

    void doget(int type, String url, CallBackListener listener);

    void dopost(int type, String url, Map<String, String> headMap, Map<String, String> map, CallBackListener listener);

    void register(int type, String url, Map<String, String> map, CallBackListener listener);

    void login(int type, String url, Map<String, String> map, CallBackListener listener);

    void shopping(int type, String url, Map<String, String> headMap, Map<String, String> map, CallBackListener listener);

    void particulars(int type, String url,Map<String, String> headMap, Map<String, String> map, CallBackListener listener);

    void CircleList(int type, String url,Map<String, String> headMap, Map<String, String> map, CallBackListener listener);
}
