package com.example.administrator.lovehome;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.homelibrary.HomeFrament;
import com.example.administrator.lovehome.R.color;
import com.example.administrator.minelibrary.mineFrament;
import com.example.administrator.publishlibrary.PublishFrament;

import java.util.ArrayList;
import java.util.List;

public class LoveActivity extends FragmentActivity {
    ViewPager viewPager;
    TextView text1,text2,text3;
    ImageView io1,io2,io3;
    List<Fragment> lists = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
        //获取碎片
        lists.add(new HomeFrament());
        lists.add(new PublishFrament());
        lists.add(new mineFrament());
        //获取界面布局
        viewPager = (ViewPager)findViewById(R.id.ViewPager);
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        text3 = (TextView)findViewById(R.id.text3);
        io1 = (ImageView)findViewById(R.id.io1);
        io2 = (ImageView)findViewById(R.id.io2);
        io3 = (ImageView)findViewById(R.id.io3);

        //导入v4的包
        FragmentManager ma  = getSupportFragmentManager();

        //准备一个适配器
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(ma) {
            @Override
            public Fragment getItem(int position) {
                return lists.get(position);
            }

            @Override
            public int getCount() {
                return lists.size();
            }
        };
        //给ViewPager设置适配器
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //界面在切换之后

                io1.setImageResource(R.drawable.home);
                io2.setImageResource(R.drawable.publish);
                io3.setImageResource(R.drawable.wode);


                text1.setTextColor(color.tab_unchecked_color);
                text2.setTextColor(color.tab_unchecked_color);
                text3.setTextColor(color.tab_unchecked_color);
//滑动时切换界面
                switch (position) {
                    case 0:
                        io1.setImageResource(R.drawable.home_press);
                        text1.setTextColor(Color.rgb(81, 196, 118));

                        break;
                    case 1:

                        io2.setImageResource(R.drawable.publish_press);
                        text2.setTextColor(Color.rgb(81, 196, 118));

                        break;
                    case 2:

                        io3.setImageResource(R.drawable.wode_press);
                        text3.setTextColor(Color.rgb(81, 196, 118));

                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    //点击时切换界面
    public void Change(View v){
        switch (v.getId()) {
            case R.id.layout1:
                viewPager.setCurrentItem(0);

                break;
            case R.id.layout2:

                viewPager.setCurrentItem(1);

                break;
            case R.id.layout3:

                viewPager.setCurrentItem(2);

                break;


        }
    }
}
