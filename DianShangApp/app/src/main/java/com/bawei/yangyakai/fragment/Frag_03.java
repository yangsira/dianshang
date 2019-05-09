package com.bawei.yangyakai.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.yangyakai.R;
import com.bawei.yangyakai.mvp.model.ModelIml;
import com.bawei.yangyakai.mvp.presenter.PresenterIml;
import com.bawei.yangyakai.mvp.view.Views;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.HeaderMap;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 20:53
 * @Description：描述信息
 */
public class Frag_03 extends Fragment implements Views {
    @BindView(R.id.frag3_checkbox)
    CheckBox fragcheckBox;
    @BindView(R.id.frag3_jage)
    TextView frag_jage;
    @BindView(R.id.frag3_zjia)
    TextView frag_zjia;
    private HashMap<String, String> headerMap;
    private SharedPreferences sp;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag03, container, false);
        PresenterIml presenterIml = new PresenterIml(new ModelIml(), this);
        sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        int userId = sp.getInt("userId", 0);
        String sessionId = sp.getString("sessionId", "");
        headerMap = new HashMap<>();
        headerMap.put("userId", 3081 + "");
        headerMap.put("sessionId", "15569673638613081");

        presenterIml.shopping(6, "/small/order/verify/v1/findShoppingCart", headerMap, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void success(int type, String data) {
        if (type == 6) {
            Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
            Log.i("aabb", data);
        }
    }

    @Override
    public void fail(int type, String error) {

    }
}
