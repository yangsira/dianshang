package com.bawei.yangyakai.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yangyakai.ParticularsActivity;
import com.bawei.yangyakai.R;
import com.bawei.yangyakai.bean.ShopBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/17 19:46
 * @Description：描述信息
 */
public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder> {


    private final Context context;
    private final List<ShopBean.ResultBean.RxxpBean.CommodityListBean> commodityList;

    public RxxpAdapter(Context context, List<ShopBean.ResultBean.RxxpBean.CommodityListBean> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.rxxp_itme, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.iamge.setImageURI(commodityList.get(i).getMasterPic());
        viewHolder.title.setText(commodityList.get(i).getCommodityName());
        viewHolder.price.setText("￥" + commodityList.get(i).getPrice() + "");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ParticularsActivity.class);
                intent.putExtra("id", commodityList.get(i).getCommodityId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView iamge;
        TextView title, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iamge = (SimpleDraweeView) itemView.findViewById(R.id.rxxp_img);
            title = (TextView) itemView.findViewById(R.id.rxxp_title);
            price = (TextView) itemView.findViewById(R.id.rxxp_price);
        }
    }
}
