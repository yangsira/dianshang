package com.bawei.yangyakai.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.yangyakai.R;
import com.bawei.yangyakai.bean.CircleListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/4 16:19
 * @Description：描述信息
 */
public class CircleListAdapter extends RecyclerView.Adapter<CircleListAdapter.ViewHolder> {
    private final Context context;
    private List<CircleListBean.ResultBean> list = new ArrayList<>();

    public CircleListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CircleListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.circlelist, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CircleListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.simp1.setImageURI(list.get(i).getHeadPic());
        viewHolder.simp2.setImageURI(list.get(i).getImage());
        viewHolder.text1.setText(list.get(i).getNickName());
        viewHolder.text3.setText(list.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<CircleListBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simp1, simp2;
        private final TextView text1, text2, text3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simp1 = (SimpleDraweeView) itemView.findViewById(R.id.circle_simp1);
            simp2 = (SimpleDraweeView) itemView.findViewById(R.id.circle_simp2);
            text1 = (TextView) itemView.findViewById(R.id.circle_text1);
            text2 = (TextView) itemView.findViewById(R.id.circle_text2);
            text3 = (TextView) itemView.findViewById(R.id.circle_text3);
        }
    }
}
