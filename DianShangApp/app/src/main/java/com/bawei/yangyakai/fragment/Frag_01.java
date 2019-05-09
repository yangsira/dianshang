package com.bawei.yangyakai.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.yangyakai.R;
import com.bawei.yangyakai.adapter.ShopAdapter;
import com.bawei.yangyakai.bean.BannerBean;
import com.bawei.yangyakai.bean.ShopBean;
import com.bawei.yangyakai.bean.BaseBean;
import com.bawei.yangyakai.mvp.model.ModelIml;
import com.bawei.yangyakai.mvp.presenter.PresenterIml;
import com.bawei.yangyakai.mvp.view.Views;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 20:53
 * @Description：描述信息
 */
public class Frag_01 extends Fragment implements Views {

    private PresenterIml presenterIml;
    @BindView(R.id.recycler)
    XRecyclerView recyclerView;
    private ShopAdapter shopAdapter;
    private ArrayList<BaseBean> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag01, container, false);
        ButterKnife.bind(this, view);
        presenterIml = new PresenterIml(new ModelIml(), this);
        presenterIml.doget(0, "/small/commodity/v1/bannerShow");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        shopAdapter = new ShopAdapter(getActivity());
        recyclerView.setAdapter(shopAdapter);
        recyclerView.setLoadingMoreEnabled(false);//关闭上拉加载
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                arrayList.clear();
                Log.i("aaa", arrayList.size() + "");
                presenterIml.doget(0, "http://172.17.8.100/small/commodity/v1/bannerShow");
                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {

            }
        });


        return view;
    }


    @Override
    public void success(int type, String data) {
        if (type == 0) {
            Gson gson = new Gson();
            BannerBean bean = gson.fromJson(data, BannerBean.class);
            arrayList.add(bean);
            // Log.i("aaa", data);
            presenterIml.doget(1, "/small/commodity/v1/commodityList");
        }
        if (type == 1) {
            Gson gson = new Gson();
            ShopBean bean = gson.fromJson(data, ShopBean.class);
            ShopBean.ResultBean.MlssBean mlss = bean.getResult().getMlss();
            ShopBean.ResultBean.PzshBean pzsh = bean.getResult().getPzsh();
            ShopBean.ResultBean.RxxpBean rxxp = bean.getResult().getRxxp();
            arrayList.add(rxxp);
            arrayList.add(mlss);
            arrayList.add(pzsh);

            shopAdapter.setList(arrayList);
        }
    }

    @Override
    public void fail(int type, String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterIml.destory();
    }
}
