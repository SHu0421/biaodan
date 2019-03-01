package com.example.biaodan;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.biaodan.fragment.FirstFragment;
import com.example.biaodan.fragment.SecondFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main8Activity extends AppCompatActivity {


    @BindView(R.id.flt)
    FrameLayout flt;

    FragmentTransaction mFragmentTransaction;
    FragmentManager fm;
    FirstFragment f1 = new FirstFragment();
    SecondFragment f2 = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        ButterKnife.bind(this);


        //获取到FragmentManager，在V4包中通过getSupportFragmentManager，
        //在系统中原生的Fragment是通过getFragmentManager获得的。
        fm = getSupportFragmentManager();
        //2.开启一个事务，通过调用beginTransaction方法开启。
        mFragmentTransaction = fm.beginTransaction();
        //向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例。
        mFragmentTransaction.replace(R.id.flt,f1);
        //提交事务，调用commit方法提交。
        mFragmentTransaction.commit();
    }

    @OnClick({R.id.fragment1, R.id.fragment2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment1:
                mFragmentTransaction = fm.beginTransaction();
                mFragmentTransaction.replace(R.id.flt,f1);
                mFragmentTransaction.commit();
                break;
            case R.id.fragment2:
                mFragmentTransaction = fm.beginTransaction();
                mFragmentTransaction.replace(R.id.flt,f2);
                mFragmentTransaction.commit();
                break;
        }
    }
}
