package com.bawei.yangyakai.net;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/27 20:49
 * @Description：描述信息
 */
public interface HttpServer {

    @GET
    Observable<ResponseBody> get(@Url String url, @HeaderMap Map<String, String> headMap, @QueryMap Map<String, String> map);

    @POST
    Observable<ResponseBody> post(@Url String url, @HeaderMap Map<String, String> headMap, @QueryMap Map<String, String> map);

}
