package com.example.administrator.viewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MyRecyclerView extends RecyclerView.Adapter {
    private List<String> list = new ArrayList();
    private RecyclerView.ViewHolder holder;
    /**
     * 创建view 绑定给viewholder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局

        return null;
    }

    //绑定数据 把数据加载给布局
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    /**
     * 控制条目数量
     */
    @Override
    public int getItemCount() {
        return list.size();
    }
    private OnMyItemClick onMyItemClick;

   public interface OnMyItemClick{
        void OnClick(View view,int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
