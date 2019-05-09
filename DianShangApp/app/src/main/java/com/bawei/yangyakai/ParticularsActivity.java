package com.bawei.yangyakai;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.yangyakai.bean.ParticuImageBean;
import com.bawei.yangyakai.bean.ParticularsBean;
import com.bawei.yangyakai.mvp.model.ModelIml;
import com.bawei.yangyakai.mvp.presenter.Presenter;
import com.bawei.yangyakai.mvp.presenter.PresenterIml;
import com.bawei.yangyakai.mvp.view.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ParticularsActivity extends AppCompatActivity implements Views {

    @BindView(R.id.pa_banner)
    XBanner banner;
    @BindView(R.id.pa_price)
    TextView price;
    @BindView(R.id.pa_title)
    TextView title;
    @BindView(R.id.webview)
    WebView mWebView;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);
        PresenterIml presenterIml = new PresenterIml(new ModelIml(), this);
        sp = getSharedPreferences("user", MODE_PRIVATE);
        int userId = sp.getInt("userId", 0);
        String sessionId = sp.getString("sessionId", "");
        HashMap<String, String> headMap = new HashMap<>();
        headMap.put("userId", userId + "");
        headMap.put("sessionId", sessionId);

        int id = getIntent().getIntExtra("id", 0);
        Map<String, String> map = new HashMap<>();
        map.put("commodityId", id + "");
        presenterIml.particulars(0, "small/commodity/v1/findCommodityDetailsById", headMap, map);
        ButterKnife.bind(this);
    }

    @Override
    public void success(int type, String data) {
        if (type == 0) {
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
            ParticularsBean bean = new Gson().fromJson(data, ParticularsBean.class);
            price.setText("价格：￥" + bean.getResult().getPrice() + "");
            title.setText("商品：" + bean.getResult().getCategoryName());
            String[] split = bean.getResult().getPicture().split(",");
            List<ParticuImageBean> mparticuImageBeans = new ArrayList<>();

            String html = bean.getResult().getDetails();
            html = html.replaceAll("http:http:", "http:");//将详情的图片中错误的url网址http:http:替换为http：
            mWebView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);

            for (int a = 0; a < split.length; a++) {
                String url = split[a];
                ParticuImageBean particuImageBean = new ParticuImageBean();
                particuImageBean.setIagemeUrl(url);
                mparticuImageBeans.add(particuImageBean);
            }
            banner.setBannerData(R.layout.image_itme, mparticuImageBeans);
            banner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    ParticuImageBean bean1 = (ParticuImageBean) model;
                    ((SimpleDraweeView) view).setImageURI(bean1.getIagemeUrl());
                }
            });

        }

    }

    @Override
    public void fail(int type, String error) {

    }
}
