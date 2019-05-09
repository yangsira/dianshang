package com.bawei.yangyakai;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 20:44
 * @Description：描述信息
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
