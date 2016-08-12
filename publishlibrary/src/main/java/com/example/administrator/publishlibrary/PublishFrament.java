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

import com.example.administrator.publishlibrary.cooking.CookChildType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class PublishFrament extends Fragment {

    List<CookChildType> cookChildTypeDatas;


    LayoutInflater layoutInflater;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.layoutInflater =inflater;

        View view =inflater.inflate(R.layout.publish_fragment, null);


        GridView gridview = (GridView) view.findViewById(R.id.grid_view);
        initData();
        //适配器
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                CookChildType cookChildType = cookChildTypeDatas.get(position);
                convertView = layoutInflater.inflate(R.layout.aublishadapter, null);
                ImageView img = (ImageView) convertView.findViewById(R.id.adapter_image);
                TextView text = (TextView)convertView.findViewById(R.id.adapter_text);

                //给图片设值
                img.setImageResource(cookChildType.imgResId);
                //给text设值
                text.setText(cookChildType.name);

                return convertView;
            }
            @Override
            public long getItemId(int position) {
                return position;
            }
            @Override
            public Object getItem(int position) {
                return cookChildTypeDatas.get(position);
            }
            @Override
            public int getCount() {
                return cookChildTypeDatas.size();
            }
        };
        //填充适配器
        gridview.setAdapter(adapter);
        //给gridview设置点击事件
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int cid = position+1;
                CookChildType cookChildType = cookChildTypeDatas.get(position);
                Toast.makeText(getActivity(), "要查看菜谱分类的ID为："+cookChildType.id, Toast.LENGTH_LONG).show();

                //传值并跳转
              //  Intent intent = new Intent();
              //  intent.setClass(getActivity(), CookingActivity.class);
               // intent.putExtra(Constant.QUERY_KEY, Constant.QUERY_COOK_TYPE); //按父类id
               // intent.putExtra("typeId", cookChildType.id);
               // startActivity(intent);
            }
        });
        return view;
    }

    private void initData(){
        //	给gridview设置参数
        cookChildTypeDatas = new ArrayList<CookChildType>();
        CookChildType type1 = new CookChildType("1", "美食", "10001", R.drawable.meishi);
        CookChildType type2 = new CookChildType("2", "娱乐", "10002", R.drawable.yule);
        CookChildType type3 = new CookChildType("3", "房产", "10003", R.drawable.fangchan);
        CookChildType type4 = new CookChildType("4", "车", "10004", R.drawable.che);
        CookChildType type5 = new CookChildType("5", "婚庆", "10005", R.drawable.hunqing);
        CookChildType type6 = new CookChildType("6", "装修", "10006", R.drawable.zhuangxiu);
        CookChildType type7 = new CookChildType("7", "教育", "10007", R.drawable.jiaoyu);
        CookChildType type8 = new CookChildType("8", "工作", "10008", R.drawable.gongzuo);
        CookChildType type9 = new CookChildType("9", "百货","10009", R.drawable.baihuo);
        CookChildType type10 = new CookChildType("10", "跳蚤", "10010", R.drawable.tiaozhao);
        CookChildType type11 = new CookChildType("11", "商务", "10011", R.drawable.shangwu);
        CookChildType type12 = new CookChildType("12", "便民", "10012", R.drawable.bianmin);
        CookChildType type13 = new CookChildType("13", "老乡会", "10013", R.drawable.laoxianghui);
        CookChildType type14 = new CookChildType("14", "其他", "10014", R.drawable.qita);





        cookChildTypeDatas.add(type1);
        cookChildTypeDatas.add(type2);
        cookChildTypeDatas.add(type3);
        cookChildTypeDatas.add(type4);
        cookChildTypeDatas.add(type5);
        cookChildTypeDatas.add(type6);
        cookChildTypeDatas.add(type7);
        cookChildTypeDatas.add(type8);
        cookChildTypeDatas.add(type9);
        cookChildTypeDatas.add(type10);
        cookChildTypeDatas.add(type11);
        cookChildTypeDatas.add(type12);
        cookChildTypeDatas.add(type13);
        cookChildTypeDatas.add(type14);
    }
}



