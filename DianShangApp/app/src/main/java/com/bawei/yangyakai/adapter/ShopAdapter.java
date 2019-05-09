package com.bawei.yangyakai.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.yangyakai.R;
import com.bawei.yangyakai.bean.BannerBean;
import com.bawei.yangyakai.bean.ShopBean;
import com.bawei.yangyakai.bean.BaseBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;


/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/16 19:45
 * @Description：描述信息
 */
public class ShopAdapter extends RecyclerView.Adapter {

    private final Context context;
    private ArrayList<BaseBean> list = new ArrayList<>();


    public ShopAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (i) {
            case 0:
                View view = View.inflate(context, R.layout.xbanner_itme, null);
                viewHolder = new XBannerHolder(view);
                break;
            case 1:
                View view1 = View.inflate(context, R.layout.rxxp_adapter, null);
                viewHolder = new RxxpViewHolder(view1);
                break;
            case 2:
                View view2 = View.inflate(context, R.layout.mlss_adapter, null);
                viewHolder = new MlssViewHolder(view2);
                break;
            case 3:
                View view3 = View.inflate(context, R.layout.pzsh_adapter, null);
                viewHolder = new PzshViewHolder(view3);
                break;
        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        BaseBean baseBean = list.get(i);
        if (baseBean instanceof BannerBean) {
            XBannerHolder xBannerHolder = (XBannerHolder) viewHolder;
            BannerBean bannerBean = (BannerBean) baseBean;
            xBannerHolder.banner.setBannerData(R.layout.image_itme, bannerBean.getResult());
            xBannerHolder.banner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    BannerBean.ResultBean resultBean = (BannerBean.ResultBean) model;
                    ((SimpleDraweeView) view).setImageURI(resultBean.getImageUrl());
                }
            });

        } else if (baseBean instanceof ShopBean.ResultBean.RxxpBean) {
            RxxpViewHolder rxxpViewHolder = (RxxpViewHolder) viewHolder;
            ShopBean.ResultBean.RxxpBean rxxpBean = (ShopBean.ResultBean.RxxpBean) baseBean;
            rxxpViewHolder.listtext.setText(rxxpBean.getName());
            RxxpAdapter rxxpAdapter = new RxxpAdapter(context, rxxpBean.getCommodityList());
            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
            linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
            rxxpViewHolder.recyclerrxxp.setLayoutManager(linearLayoutManager1);
            rxxpViewHolder.recyclerrxxp.setAdapter(rxxpAdapter);

        } else if (baseBean instanceof ShopBean.ResultBean.MlssBean) {
            MlssViewHolder mlssViewHolder = (MlssViewHolder) viewHolder;
            ShopBean.ResultBean.MlssBean mlssBean = (ShopBean.ResultBean.MlssBean) baseBean;
            mlssViewHolder.listtext2.setText(mlssBean.getName());
            MlssAdapter mlssAdapter = new MlssAdapter(context, mlssBean.getCommodityList());
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context);
            linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
            mlssViewHolder.recyclermlss.setLayoutManager(linearLayoutManager2);
            mlssViewHolder.recyclermlss.setAdapter(mlssAdapter);

        } else if (baseBean instanceof ShopBean.ResultBean.PzshBean) {
            PzshViewHolder pzshViewHolder = (PzshViewHolder) viewHolder;
            ShopBean.ResultBean.PzshBean pzshBean = (ShopBean.ResultBean.PzshBean) baseBean;
            pzshViewHolder.listtext3.setText(pzshBean.getName());

            PzshAdapter pzshAdapter = new PzshAdapter(context, pzshBean.getCommodityList());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            pzshViewHolder.recyclerpzsh.setLayoutManager(gridLayoutManager);
            pzshViewHolder.recyclerpzsh.setAdapter(pzshAdapter);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof BannerBean) {
            return 0;
        } else if (list.get(position) instanceof ShopBean.ResultBean.RxxpBean) {
            return 1;
        } else if (list.get(position) instanceof ShopBean.ResultBean.MlssBean) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<BaseBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private class XBannerHolder extends RecyclerView.ViewHolder {

        XBanner banner;

        public XBannerHolder(@NonNull View itemView) {
            super(itemView);
            banner = (XBanner) itemView.findViewById(R.id.xbanner);
        }
    }

    private class RxxpViewHolder extends RecyclerView.ViewHolder {
        TextView listtext;
        RecyclerView recyclerrxxp;

        public RxxpViewHolder(@NonNull View itemView) {
            super(itemView);
            listtext = (TextView) itemView.findViewById(R.id.home_list_01_text);
            recyclerrxxp = (RecyclerView) itemView.findViewById(R.id.recycler_rxxp);
        }
    }

    private class MlssViewHolder extends RecyclerView.ViewHolder {
        TextView listtext2;
        RecyclerView recyclermlss;

        public MlssViewHolder(@NonNull View itemView) {
            super(itemView);
            listtext2 = (TextView) itemView.findViewById(R.id.home_list_02_text);
            recyclermlss = (RecyclerView) itemView.findViewById(R.id.recycler_mlss);

        }
    }

    private class PzshViewHolder extends RecyclerView.ViewHolder {

        TextView listtext3;
        RecyclerView recyclerpzsh;

        public PzshViewHolder(@NonNull View itemView) {
            super(itemView);
            listtext3 = (TextView) itemView.findViewById(R.id.home_list_03_text);
            recyclerpzsh = (RecyclerView) itemView.findViewById(R.id.recycler_pzsh);
        }
    }
}
