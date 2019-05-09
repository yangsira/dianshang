package com.bawei.yangyakai.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/19 10:00
 * @Description：描述信息
 */
public abstract class BaseAdapter<D> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {
    private Context context;
    private List<D> mList = new ArrayList<>();

    public BaseAdapter(Context context, List<D> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public BaseAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, getLayoutId(), null);
        BaseViewHolder baseViewHolder = new BaseViewHolder(view);
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.BaseViewHolder baseViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public abstract int getLayoutId();
}
