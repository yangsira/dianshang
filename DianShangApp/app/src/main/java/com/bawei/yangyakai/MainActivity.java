package com.bawei.yangyakai;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.yangyakai.fragment.Frag_01;
import com.bawei.yangyakai.fragment.Frag_02;
import com.bawei.yangyakai.fragment.Frag_03;
import com.bawei.yangyakai.fragment.Frag_04;
import com.bawei.yangyakai.fragment.Frag_05;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.radio)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Frag_01());
        list.add(new Frag_02());
        list.add(new Frag_03());
        list.add(new Frag_04());
        list.add(new Frag_05());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.radio2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.radio3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.radio4:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.radio5:
                        viewPager.setCurrentItem(4);
                        break;

                }
            }
        });
    }
}
