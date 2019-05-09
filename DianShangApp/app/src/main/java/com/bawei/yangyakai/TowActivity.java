package com.bawei.yangyakai;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.yangyakai.bean.Datas;
import com.bawei.yangyakai.bean.UserBean;
import com.bawei.yangyakai.fragment.Frag_01;
import com.bawei.yangyakai.fragment.Frag_03;
import com.bawei.yangyakai.mvp.model.ModelIml;
import com.bawei.yangyakai.mvp.presenter.PresenterIml;
import com.bawei.yangyakai.mvp.view.Views;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;

public class TowActivity extends AppCompatActivity implements Views, View.OnClickListener {
    @BindView(R.id.edit_phone)
    EditText phone;
    @BindView(R.id.edit_passd)
    EditText password;
    private SharedPreferences sp;
    private PresenterIml presenterIml;
    private String rag_phone;
    private String rag_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tow);
        sp = getSharedPreferences("user", MODE_PRIVATE);
        ButterKnife.bind(this);
        findViewById(R.id.text_zhuce).setOnClickListener(this);
        findViewById(R.id.button_denglu).setOnClickListener(this);
        presenterIml = new PresenterIml(new ModelIml(), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        rag_phone = sp.getString("edit_phone", null);
        rag_password = sp.getString("edit_passd", null);
        if (!TextUtils.isEmpty(rag_phone)) {
            phone.setText(rag_phone);
        }
        if (!TextUtils.isEmpty(rag_password)) {
            password.setText(rag_password);
        }
    }


    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_denglu:
                dologin();
                break;
            case R.id.text_zhuce:
                Intent intent = new Intent(TowActivity.this, ThreeActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void dologin() {
        String phone_name = phone.getText().toString().trim();
        String pass_word = password.getText().toString().trim();
        Log.i("ooo", phone_name);
        if (TextUtils.isEmpty(phone_name)) {
            toast("请输入账号");
            return;
        }
        if (TextUtils.isEmpty(pass_word)) {
            toast("请输入密码");
            return;
        }
        // presenterIml.login(1, phone_name, pass_word);
        Map<String, String> map = new HashMap<>();
        map.put("phone", phone_name);
        map.put("pwd", pass_word);
        presenterIml.login(1, "/small/user/v1/login", map);
    }

    @Override
    public void success(int type, String data) {

        if (type == 1) {
            UserBean bean = new Gson().fromJson(data, UserBean.class);
            String nickName = bean.getResult().getNickName();
            String phone = bean.getResult().getPhone();
            String headPic = bean.getResult().getHeadPic();
            String sessionId = bean.getResult().getSessionId();
            int userId = bean.getResult().getUserId();
            sp.edit().putInt("userId", userId)
                    .putString("sessionId", sessionId)
                    .putString("phone", phone)
                    .putString("headPic", headPic)
                    .putString("nickName", nickName).commit();
            Log.i("sop", sp.toString());
            finish();
        }


    }

    @Override
    public void fail(int type, String error) {

    }

}
