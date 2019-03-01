package com.example.biaodan.adapter;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.biaodan.R;
import com.example.biaodan.bean.DifBean;

import java.util.List;

public class BrvahAdapter extends BaseQuickAdapter<DifBean.ItemBean, BaseViewHolder> {

    public BrvahAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, DifBean.ItemBean item) {

        helper.addOnClickListener(R.id.iv_head)
                .addOnClickListener(R.id.tv_title);
        helper.setText(R.id.tv_title,item.sign);
        helper.setText(R.id.tv_content,item.joinTime);

//        helper.setText(R.id.tv_title,item+"标题");
//        helper.setText(R.id.tv_content,item+"内容");
//        helper.getView(R.id.tv_content).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtils.showShort("我点击了"+helper.getLayoutPosition()+"内容");
//            }
//        });
//
//        if(helper.getLayoutPosition()==10){
//            helper.setText(R.id.tv_title,"特殊标题");
//        }
    }

}
