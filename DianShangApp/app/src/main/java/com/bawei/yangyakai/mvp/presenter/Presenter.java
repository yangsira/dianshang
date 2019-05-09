package com.bawei.yangyakai.mvp.presenter;

import com.bawei.yangyakai.mvp.model.Model;

import java.util.Map;

import okhttp3.FormBody;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 19:36
 * @Description：描述信息
 */
public interface Presenter {
    void doget(int type, String url);

    void dopost(int type, String url, Map<String, String> headMap, Map<String, String> map);

    void register(int type, String url, Map<String, String> map);

    void login(int type, String url, Map<String, String> map);

    void shopping(int type, String url, Map<String, String> headMap, Map<String, String> map);

    void particulars(int type, String url, Map<String, String> headMap, Map<String, String> map);

    void CircleList(int type, String url, Map<String, String> headMap, Map<String, String> map);
}
