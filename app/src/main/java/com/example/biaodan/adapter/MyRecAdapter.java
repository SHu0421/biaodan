package com.example.biaodan.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.example.biaodan.R;

import java.lang.reflect.Array;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;

public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.VH> {
    private ArrayList data;

    public MyRecAdapter(ArrayList data) {
        this.data = data;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        VH vh=new VH(v);
        vh.lin_rec=v.findViewById(R.id.lin_rec);
        vh.title = v.findViewById(R.id.tv_title);
        vh.content = v.findViewById(R.id.tv_content);
        vh.head = v.findViewById(R.id.iv_head);

        return vh;
    }

    //对每个控件进行操作
    @Override
    public void onBindViewHolder(@NonNull VH vh, final int i) {
      switch (i % 3){
          case 0:
              vh.title.setText("这是第一行数据的标题");
              vh.content.setText("这是第一行数据的内容");
              vh.head.setImageResource(R.drawable.fengyi);
              break;
              case 1:
              vh.title.setText("这是第2行数据的标题");
              vh.content.setText("这是第2行数据的内容");
              vh.head.setImageResource(R.drawable.maozi);
                  break;
              case 2:
              vh.title.setText("这是第3行数据的标题");
              vh.content.setText("这是第3行数据的内容");
              vh.head.setImageResource(R.drawable.fengyi);
                  break;
      }

      vh.lin_rec.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              ToastUtils.showShort(i+"lin_rec");
          }
      });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class VH extends RecyclerView.ViewHolder{
        //这个初始化在这里的用处,因为之前没有这样的属性，因此需要添加
        LinearLayout lin_rec;
        TextView title;
        TextView content;
        ImageView head;
        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }


}
