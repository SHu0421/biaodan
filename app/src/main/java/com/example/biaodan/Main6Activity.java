package com.example.biaodan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.example.biaodan.bean.LoginBean;
import com.example.biaodan.bean.UserBean;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class Main6Activity extends AppCompatActivity {

    @BindView(R.id.get)
    Button get;
    @BindView(R.id.post)
    Button post;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.addr)
    TextView addr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.get, R.id.post})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get:
                String url = "http://result.eolinker.com/Qai21Yf650581e783d09adf9f7966b117db875bf3288f72?uri=getUserInfo";
                OkGo.get(url)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                LogUtils.iTag("onsucesss", s);
                                Gson gson = new Gson();
//                               将获取到的string数据转化为类对象
                                UserBean bean = gson.fromJson(s, UserBean.class);
                                ToastUtils.showShort(bean.name);
                //实现网络图片的加载
                                Glide.with(Main6Activity.this)
                                        .load(bean.avatar)
                                        .placeholder(R.mipmap.ic_launcher)
                                        .crossFade()
                                        .into(ivHead);

                                name.setText(bean.name);
                                addr.setText(bean.addr);
                                email.setText(bean.email);
                            }

                            @Override
                            public void onError(Call call, Response response, Exception e) {
                                super.onError(call, response, e);
                            }
                        });

                break;
            case R.id.post:
//                String postUrl="http://mutualaid.scgbgx.com/mutualAid/api/basic/login";
//                OkGo.post(postUrl)
//                        .params("phone","")
//                        .params("code","111")
//                        .execute(new StringCallback() {
//                            @Override
//                            public void onSuccess(String s, Call call, Response response) {
//                                LoginBean o=new Gson().fromJson(s,LoginBean.class);
//                                ToastUtils.showShort(o.data.token);
//                            }
//                        });

                break;
        }

    }
}
