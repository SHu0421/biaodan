package com.example.biaodan;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.biaodan.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class Main7Activity extends AppCompatActivity {

    private ViewPager vpager_one;
    private ArrayList<View> aList;
    private ViewPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        vpager_one=(ViewPager) findViewById(R.id.vpager);

        aList=new ArrayList<View>();
        LayoutInflater li=getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one,null,false));
        aList.add(li.inflate(R.layout.view_two,null,false));
        aList.add(li.inflate(R.layout.view_three,null,false));
        mAdapter=new ViewPagerAdapter(aList);
        vpager_one.setAdapter(mAdapter);
    }
}
