package com.bawei.yangyakai.net;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/27 20:49
 * @Description：描述信息
 */
public class HttpUtils {
    private String baseUrl = "http://mobile.bwstudent.com";
    private Map<String, String> headmap = new HashMap<>();
    private HttpListener mhttpListener;

    public HttpUtils setMap(Map<String, String> headmap) {
        this.headmap = headmap;
        return this;
    }

    public HttpUtils get(String url, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        HttpServer server = null;
        try {
            server = HttpServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Observable<ResponseBody> observable = server.get(url, headmap, map);
        send(observable);
        return this;
    }

    public HttpUtils post(String url, Map<String, String> map) {
        HttpServer server = null;
        try {
            server = HttpServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Observable<ResponseBody> observable = server.post(url, headmap, map);
        send(observable);
        return this;
    }

    private void send(Observable<ResponseBody> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String data = responseBody.string();
                            mhttpListener.success(data);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        String error = e.getMessage();
                        mhttpListener.fail(error);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private HttpServer HttpServer() throws IOException {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        Cache cache = new Cache(file, 10 * 1024);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        return chain.proceed(request);
                    }
                })
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(HttpServer.class);
    }

    public interface HttpListener {
        void success(String data);

        void fail(String error);
    }

    public void result(HttpListener mhttpListener) {
        this.mhttpListener = mhttpListener;
    }

}

