package com.bawei.yangyakai.fragment;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.yangyakai.R;
import com.bawei.yangyakai.adapter.CircleListAdapter;
import com.bawei.yangyakai.bean.CircleListBean;
import com.bawei.yangyakai.mvp.model.ModelIml;
import com.bawei.yangyakai.mvp.presenter.PresenterIml;
import com.bawei.yangyakai.mvp.view.Views;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 20:53
 * @Description：描述信息
 */
public class Frag_02 extends Fragment implements Views {

    private SharedPreferences sp;
    @BindView(R.id.frag_02_recycler)
    RecyclerView recycler_02;
    private CircleListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag02, container, false);
        PresenterIml presenterIml = new PresenterIml(new ModelIml(), this);
        sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        int userId = sp.getInt("userId", 0);
        String sessionId = sp.getString("sessionId", "");
        HashMap<String, String> heahMap = new HashMap<>();
        heahMap.put("userId", userId + "");
        heahMap.put("sessionId", sessionId);
        Map<String, String> map = new HashMap<>();
        map.put("page", 1 + "");
        map.put("count", 5 + "");
        presenterIml.CircleList(0, "/small/circle/v1/findCircleList?page=1&count=5", heahMap, null);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void success(int type, String data) {
        adapter = new CircleListAdapter(getActivity());
        LinearLayoutManager linearLayoutManager_02 = new LinearLayoutManager(getActivity());
        linearLayoutManager_02.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_02.setLayoutManager(linearLayoutManager_02);
        recycler_02.setAdapter(adapter);
        if (type == 0) {
            CircleListBean bean = new Gson().fromJson(data, CircleListBean.class);
            List<CircleListBean.ResultBean> result = bean.getResult();
            adapter.setList(result);
        }
    }

    @Override
    public void fail(int type, String error) {

    }
}
