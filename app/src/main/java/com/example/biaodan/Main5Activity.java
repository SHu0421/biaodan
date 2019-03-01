package com.example.biaodan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.biaodan.adapter.BrvahAdapter;
import com.example.biaodan.bean.DifBean;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;


public class Main5Activity extends AppCompatActivity {
 RecyclerView rv;
 BrvahAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        rv=findViewById(R.id.rv);

//返回的数据相当于arrayList
//        ArrayList<String> arrayList=new ArrayList<>();
//
//        for (int i = 0; i < 100; i++) {
//            arrayList.add(""+i);
//        }
        adapter=new BrvahAdapter(R.layout.item_list,null);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort(""+position);
            }
        });

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.iv_head:
                        ToastUtils.showShort("头像"+position);
                        break;
                    case R.id.tv_content:
                        ToastUtils.showShort("标题"+position);
                        break;
                }
            }
        });

        adapter.isFirstOnly(true);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        //进行网络数据的请求

        String url="http://result.eolinker.com/Qai21Yf650581e783d09adf9f7966b117db875bf3288f72?uri=simpleData";
        OkGo.get(url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        DifBean bean=new Gson().fromJson(s,DifBean.class);
//                        在这里给adapter传入内容，最开始的时候传入的数据为null
                        adapter.setNewData(bean.item);
                    }
                });
    }
}
