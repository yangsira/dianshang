package com.bawei.yangyakai.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yangyakai.R;
import com.bawei.yangyakai.TowActivity;
import com.bawei.yangyakai.bean.UserBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 20:53
 * @Description：描述信息
 */
public class Frag_05 extends Fragment {
    @BindView(R.id.image_tou)
    ImageView imagetou;
    @BindView(R.id.text_ncheng)
    TextView ncehng;
    private SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag05, container, false);
        sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      /*  String headPic = sp.getString("headPic", "");
        String nickName = sp.getString("nickName", "");
        Log.i("head", headPic);
        Log.i("head", nickName);
        imagetou.setImageURI(Uri.parse(headPic));
        ncehng.setText(nickName);*/

        imagetou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TowActivity.class);
                startActivity(intent);
            }
        });
    }
}
