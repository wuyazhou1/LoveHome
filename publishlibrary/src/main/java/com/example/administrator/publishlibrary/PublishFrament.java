package com.example.administrator.publishlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.publishlibrary.PublishlibraryAdapter.PublishDialogBottomAdapter;

import java.util.ArrayList;
import java.util.List;

public class PublishFrament extends Fragment {
    List<String> word = new ArrayList<String>();
    List<Integer> icon = new ArrayList<Integer>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.publish_fragment,null);
        // 一、准备数据
        final int[] icons = {
                R.drawable.baihuo,
                R.drawable.bianmin,
                R.drawable.che,
                R.drawable.fangchan,
                R.drawable.gongzuo,
                R.drawable.hunqing,
                R.drawable.jiaoyu,
                R.drawable.laoxianghui,
                R.drawable.meishi,
                R.drawable.qita,
                R.drawable.shangwu,
                R.drawable.tiaozhao,
                R.drawable.yule,
                R.drawable.yule,
                R.drawable.zhuangxiu
        };

        final String [] name={"百度","便民","车","房产","工作","婚庆","教育","老乡会","美食",
                "其他","商务","跳骚","娱乐","装修"};

        // 二、找到网格控件
        GridView gridview = (GridView) view.findViewById(R.id.grid_view);
        // 三、设置适配器
        for (int i = 0;i<name.length;i++){
            word.add(name[i]);
            icon.add(icons[i]);
        }
        PublishDialogBottomAdapter adapter = new PublishDialogBottomAdapter(getActivity(),word,icon);
        gridview.setAdapter(adapter);
        return view;
    }
}



