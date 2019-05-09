package com.bawei.yangyakai.net;

import android.os.Build;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 18:40
 * @Description：描述信息
 */
public class OkHttpUtils {
    private int FAIL_HTTP = 1001;
    private int SUCCESS_HTTP = 1000;
    private HttpListener mhttpListener;

    public OkHttpUtils get(String url) {
        dohttp(0, url, null);
        return this;
    }

    public OkHttpUtils post(String url, FormBody.Builder bodybuilder) {
        dohttp(1, url, bodybuilder);
        return this;
    }

    private void dohttp(int type, String url, FormBody.Builder bodybuilder) {
        OkHttpClient client = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        if (type == 0) {
            builder.get();
        } else {
            builder.post(bodybuilder.build());
        }
        Request request = builder.build();
        final Message message = Message.obtain();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                message.what = FAIL_HTTP;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                message.obj = response.body().string();
                message.what = SUCCESS_HTTP;
                handler.sendMessage(message);
            }
        });
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == FAIL_HTTP) {
                String error = (String) msg.obj;
                mhttpListener.fail(error);
            } else {
                String data = (String) msg.obj;
                mhttpListener.success(data);
            }
        }
    };

    public interface HttpListener {
        void success(String data);

        void fail(String error);
    }

    public void result(HttpListener mhttpListener) {
        this.mhttpListener = mhttpListener;
    }

}
