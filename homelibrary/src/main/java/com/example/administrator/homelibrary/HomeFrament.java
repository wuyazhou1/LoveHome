package com.example.administrator.homelibrary;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.adapter.AdapterHomeVp;
import com.example.adapter.Gallery_adapter;
import com.example.adapter.HomeGvAdapter;
import com.example.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import entity.GvHomeEntity;

/**
 * Created by Administrator on 2016/8/11.
 */
public class HomeFrament extends Fragment {
    Gallery main_gallery;
    LinearLayout main_lin;
    public ImageView iv1;
    public ImageView iv2;
    List<Object> li;

    Integer[] res = {R.drawable.d, R.drawable.e};

    Gallery_adapter gallery_adapter;

    int current_circle = 0;

    Runnable timeadv;
    int count;

    Handler handler = new Handler();
    String [] names = {"美食","娱乐","房产","车","百货","跳蚤","商务","便民","婚庆","装修","教育","工作","老乡会","其他"};
    int [] icsons ={R.drawable.meishi,R.drawable.yule,R.drawable.fangchan,R.drawable.che,R.drawable.baihuo,R.drawable.tiaozhao,R.drawable.shangwu,R.drawable.bianmin,R.drawable.hunqing,R.drawable.zhuangxiu,R.drawable.jiaoyu,R.drawable.gongzuo,R.drawable.laoxianghui,R.drawable.qita};

    ViewPager viewPager;
    List<View> views ;//views代表着几个布局
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.home_fragment, null);

        views  =  new ArrayList<View>();
        View view1 = View.inflate(getActivity(), R.layout.view1, null);
        View view2 = View.inflate(getActivity(), R.layout.view2, null);
        views.add(view1);
        views.add(view2);

        viewPager = (ViewPager)view.findViewById(R.id.vp_home_top);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(views);
        viewPager.setAdapter(pagerAdapter);
       // getHeadView(view);
        initview(view);
        li = new ArrayList<Object>();
        for(int i = 0;i<res.length;i++){
            li.add(res[i]);
        }

        gallery_adapter = new Gallery_adapter(getActivity());

        main_gallery.setAdapter(gallery_adapter);
        gallery_adapter.setList(li);
        setCircle();

        //设置滚动图片的时候，对应小圆点的图片切换
        main_gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                View v = main_lin.getChildAt(position);
                View cuview = main_lin.getChildAt(current_circle);

                if(v != null && cuview != null){
                    ImageView pointView = (ImageView) v;
                    ImageView curpointView = (ImageView) cuview;
                    curpointView
                            .setBackgroundResource(R.drawable.circle_transparent);
                    pointView
                            .setBackgroundResource(R.drawable.circle_white);
                    current_circle = position;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //
        timeadv = new Runnable() {

            @Override
            public void run() {
                //获取当前的图片是哪一张图片，图片的序号，
                count = main_gallery.getSelectedItemPosition();
                //当前滚动的图片序号大于多有的图片的数量，就跳转到第一张图片，否则就跳转到下一张图片
                if(count+1>=li.size()){
                    count = 0;
                }else{
                    count = count+1;
                }
                main_gallery.setSelection(count);
                handler.postDelayed(this, 5000);

            }
        };

        //开始定时器，5000毫秒切换一次图片
        handler.postDelayed(timeadv, 5000);


        return view;
    }
//    public GridView getGridView(int pag) {
//        GridView gvTop = new GridView(getActivity());
//         gvTop.setNumColumns(5);
//        List<GvHomeEntity> list = new ArrayList<GvHomeEntity>();
//      //  Class c = R.drawable.class;
//        for (int i = (pag - 1) * 10; i < pag * 10; i++){
//        try {
//            GvHomeEntity gv = new GvHomeEntity();
//            GvHomeEntity img1 = new GvHomeEntity();
//            img1.setImg(icsons[i]);
//            //int img1 = c.getField("ic_category_" + i).getInt(null);
//            gv.setName(names[i]);
//            list.add(gv);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }//获取属性值
//
//       }
//设置适配器
//        gvTop.setAdapter(new HomeGvAdapter(list,getActivity()));
    private void initview(View view) {
        main_gallery = (Gallery)view.findViewById(R.id.main_gallery);
        main_lin = (LinearLayout)view.findViewById(R.id.main_lin);
    }
    //设置滚动图片的小圆点
    private void setCircle() {
        for(int i = 0;i<li.size();i++){
            ImageView iv = new ImageView(getActivity());
            //循环创建小圆点，判断第一个小圆点为白色的，其他的都是透明的
            if(i == 0){
                iv.setBackgroundResource(R.drawable.circle_white);
            }else{
                iv.setBackgroundResource(R.drawable.circle_transparent);
            }
            main_lin.addView(iv);

            //设置小圆点的margin值
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);  // , 1�ǿ�ѡд��
            lp.setMargins(5, 10, 5, 10);
            iv.setLayoutParams(lp);
        }
    }

    @Override
    public void onDestroy() {
        //销毁activity之前先关闭定时器
        if(handler != null){
            if(timeadv != null){
                handler.removeCallbacks(timeadv);
            }
        }
        super.onDestroy();
    }
    /*
       * 设置ListView和gridView
       */

//    public View getHeadView(View view){
//
//        ViewPager vpHome=(ViewPager)view.findViewById(R.id.vp_home_top);
//
//        ///////////////////左右滑动界面//////////////////////////
//        iv1=(ImageView) view.findViewById(R.id.index01);
//        iv2=(ImageView) view.findViewById(R.id.index02);
//        List<View> vpList=new ArrayList<View>();
//       // vpList.add(getGridView(1));
//       // vpList.add(getGridView(2));
//        vpHome.setAdapter(new AdapterHomeVp(vpList));
//        vpHome.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            public void onPageSelected(int arg0) {//当前页
//                //		Log.v("TAG","这是第"+arg0);
//                if(arg0==0){
//                    iv1.setImageResource(R.drawable.circle_white);
//                    iv2.setImageResource(R.drawable.circle_transparent);
//
//                }else{
//                    iv1.setImageResource(R.drawable.circle_white);
//                    iv2.setImageResource(R.drawable.circle_transparent);
//
//                }
//            }
//            public void onPageScrolled(int arg0, float arg1, int arg2) {//正在滑动监听
//                //	Log.v("TAG","滚动"+arg0+"/"+arg1+"/"+arg2);
//
//            }
//            public void onPageScrollStateChanged(int arg0) {
//                //	Log.v("TAG","滚动状态"+arg0);
//
//            }
//        });
//
//        return vpHome;
//    }

}
