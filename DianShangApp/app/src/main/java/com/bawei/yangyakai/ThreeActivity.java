package com.bawei.yangyakai;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.yangyakai.bean.UserBean;
import com.bawei.yangyakai.mvp.model.ModelIml;
import com.bawei.yangyakai.mvp.presenter.PresenterIml;
import com.bawei.yangyakai.mvp.view.Views;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.ResponseBody;

public class ThreeActivity extends AppCompatActivity implements View.OnClickListener, Views {

    @BindView(R.id.phone_name)
    EditText name_phone;
    @BindView(R.id.yanzheng_edit)
    EditText edit_yanzheng;
    @BindView(R.id.mm_edit)
    EditText edit_mm;
    private SharedPreferences sp;
    private PresenterIml presenterIml;
    private String name;
    private String yanzheng;
    private String mm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        ButterKnife.bind(this);
        presenterIml = new PresenterIml(new ModelIml(), this);
        sp = getSharedPreferences("user", MODE_PRIVATE);
        findViewById(R.id.text_denglu).setOnClickListener(this);
        findViewById(R.id.button_zhuce).setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_denglu:
                finish();
                break;
            case R.id.button_zhuce:
                doRegister();
                break;
        }
    }

    private void doRegister() {
        name = name_phone.getText().toString().trim();
        yanzheng = edit_yanzheng.getText().toString().trim();
        mm = edit_mm.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            toast("请输入您的手机号");
            return;
        }
        if (TextUtils.isEmpty(yanzheng)) {
            toast("请输入您的密码");
            return;
        }
        if (TextUtils.isEmpty(mm)) {
            toast("请确认您的密码");
            return;
        }
        if (!yanzheng.equals(mm)) {
            toast("请检查您的密码是否一致");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("phone", name);
        map.put("pwd", yanzheng);
        presenterIml.register(2, "/small/user/v1/register", map);
    }

    @Override
    public void success(int type, String data) {
        if (type == 2) {
            toast(data);
            UserBean bean = new Gson().fromJson(data, UserBean.class);
            toast(bean.getMessage());

            sp.edit().putString("phone_name", name).commit();
            Log.i("iii", sp.toString());
            if (bean.getStatus().equals("0000")) {
                finish();
            }
        }
    }

    @Override
    public void fail(int type, String error) {

    }

    private void toast(String mag) {
        Toast.makeText(this, mag, Toast.LENGTH_SHORT).show();
    }
}
