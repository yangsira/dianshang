package com.bawei.yangyakai.mvp.presenter;

import com.bawei.yangyakai.mvp.model.Model;
import com.bawei.yangyakai.mvp.view.Views;

import java.util.Map;

import okhttp3.FormBody;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 19:37
 * @Description：描述信息
 */
public class PresenterIml implements Presenter, Model.CallBackListener {
    private Model model;
    private Views views;

    public PresenterIml(Model model, Views views) {
        this.model = model;
        this.views = views;
    }

    @Override
    public void doget(int type, String url) {
        model.doget(type, url, this);
    }

    @Override
    public void dopost(int type, String url, Map<String, String> headMap, Map<String, String> map) {
        model.dopost(type, url, headMap, map, this);
    }

    @Override
    public void register(int type, String url, Map<String, String> map) {
        model.register(type, url, map, this);
    }

    @Override
    public void login(int type, String url, Map<String, String> map) {
        model.login(type, url, map, this);
    }

    @Override
    public void shopping(int type, String url, Map<String, String> headMap, Map<String, String> map) {
        model.shopping(type, url, headMap, map, this);
    }

    @Override
    public void particulars(int type, String url, Map<String, String> headMap, Map<String, String> map) {
        model.shopping(type, url, headMap, map, this);
    }

    @Override
    public void CircleList(int type, String url, Map<String, String> headMap, Map<String, String> map) {
        model.CircleList(type, url, headMap, map, this);
    }

    @Override
    public void success(int type, String data) {
        views.success(type, data);
    }

    @Override
    public void fail(int type, String error) {
        views.fail(type, error);
    }

    public void destory() {
        if (model != null) {
            model = null;
        }
        if (views != null) {
            views = null;
        }
        System.gc();
    }


}
