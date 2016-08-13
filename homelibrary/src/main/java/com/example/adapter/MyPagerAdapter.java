package com.example.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter{
	private List<View> pagerList;
	
	//���캯��
	public MyPagerAdapter(List<View> pagerList) {
		// TODO Auto-generated method stub
		this.pagerList = pagerList;
	}

	//����ҳ�������
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pagerList.size();
	}
     //View�Ƿ������ڶ���
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
	//ʵ����һ��ҳ��
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		container.addView(pagerList.get(position));
		return pagerList.get(position);
	}
	//����һ��ҳ��
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(pagerList.get(position));
	}

}
