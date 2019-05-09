package com.bawei.yangyakai.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yangyakai.R;

import butterknife.ButterKnife;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 20:53
 * @Description：描述信息
 */
public class Frag_04 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag04,container,false);

        ButterKnife.bind(this,view);
        return view;
    }
}
