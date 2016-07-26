package com.example.longyang.viewdemo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.longyang.viewdemo.adapter.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout sr;
    private RecyclerView rl;
    private List<String> list;
    private MyRecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        initData();


    }

    // 初始化  数据
    private void initData() {
        list = new ArrayList<>();

        for(int i =0; i<20; i++){
            list.add("条目-->"+i);
        }

        intiView(list);
    }

    // 初始化控件
    private void intiView( List<String> list) {

        sr = (SwipeRefreshLayout)findViewById(R.id.sr);
        rl = (RecyclerView)findViewById(R.id.rl);

        // 下拉刷新监听
        sr.setOnRefreshListener(this);

        //初始化  RecyclerView

        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       // linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
       rl.setLayoutManager(linearLayoutManager);
        myRecyclerView = new MyRecyclerView(list,this);
        myRecyclerView.setOnMyItemClikc(new OnItemClick());
        rl.setAdapter(myRecyclerView);
    }

    //下拉刷新回调
    @Override
    public void onRefresh() {

        //联网  加载数据  数据   改变 适配器的数据   刷新适配器    关闭刷新
        sr.setRefreshing(false);
    }

    public class OnItemClick implements MyRecyclerView.OnMyItemClick {

        //  view  postion
        @Override
        public void OnClick(View view ,int postion) {

           Toast.makeText(MainActivity.this,"条目",Toast.LENGTH_LONG).show();
        }
    }
}
