package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.homelibrary.R;

import java.util.List;

import entity.GvHomeEntity;

/**
 * Created by Administrator on 2016/8/13.
 */
public class HomeGvAdapter extends BaseAdapter {
public List<GvHomeEntity> list;
    public LayoutInflater inflater;
public HomeGvAdapter(List<GvHomeEntity> list,Context context){
    inflater =LayoutInflater.from(context);
    this.list=list;
}
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HorldView h;
        if(view==null){
            view=inflater.inflate(R.layout.tab_indicator, null);
            h=new HorldView();
            h.tvName=(TextView) view.findViewById(R.id.title);
            h.ivImg= (ImageView) view.findViewById(R.id.icon);
            view.setTag(h);
        }else{
            h=(HorldView) view.getTag();
        }
        GvHomeEntity gv=list.get(i);
        h.ivImg.setImageResource(gv.getImg());
        h.tvName.setText(gv.getName());
        return view;
    }
    class HorldView{
        TextView tvName;
        ImageView ivImg;
    }
}
