package com.example.longyang.viewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.longyang.viewdemo.R;

import java.util.List;

/**
 * Created by longyang on 2016/7/25.
 */
public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyViewHolder> {

    private List<String> list;
    private Context context ;

    public MyRecyclerView(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //  创建 view  绑定给 viewholder
    @Override
    public MyRecyclerView.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局
        // 绑定给 viewholder
        // 还回
        View  view = LayoutInflater.from(context).inflate(R.layout.item,null);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    //  把数据  绑定  给我们 viewholder上的控件
    @Override
    public void onBindViewHolder(final MyRecyclerView.MyViewHolder holder, int position) {

        holder.tv_item.setText(list.get(position));
        if(onMyItemClikc!=null){
             holder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     int po = holder.getLayoutPosition();
                     onMyItemClikc.OnClick(v,po);
                 }
             });
        }
    }

    // 控制条目数量
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_item;
        private RelativeLayout rl;

        public MyViewHolder(View itemView) {
            super(itemView);

           tv_item =  (TextView) itemView.findViewById(R.id.tv_item);

        }
    }

    private OnMyItemClick onMyItemClikc;

    public void setOnMyItemClikc(OnMyItemClick onMyItemClikc) {
        this.onMyItemClikc = onMyItemClikc;
    }

    //定义一个接口
    public interface OnMyItemClick {
        void OnClick(View view ,int postion);
    }
}

