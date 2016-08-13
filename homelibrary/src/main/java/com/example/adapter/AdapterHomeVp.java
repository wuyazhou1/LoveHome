package com.example.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

public class AdapterHomeVp  extends PagerAdapter{
    public List<View>  vpList;

    public AdapterHomeVp(List<View>  vpList){
    	this.vpList=vpList;
    }
	public int getCount() {//�õ�pager������
		// TODO Auto-generated method stub
		return vpList.size();
	}
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {//����view
		container.removeView(vpList.get(position));
	}
	public Object instantiateItem(ViewGroup container, int position) {//����view
		container.addView(vpList.get(position));
		return vpList.get(position);
	}
	
}
