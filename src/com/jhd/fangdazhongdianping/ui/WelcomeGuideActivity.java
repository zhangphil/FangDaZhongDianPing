package com.jhd.fangdazhongdianping.ui;

import java.util.ArrayList;
import java.util.List;

import com.jhd.fangdazhongdianping.R;
import com.jhd.fangdazhongdianping.R.layout;
import com.jhd.fangdazhongdianping.R.menu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomeGuideActivity extends Activity {
	@ViewInject(R.id.welcome_guide_btn)   //注解形式
	private ImageView btn;  //btn用imageview 实现的    // 注意

	@ViewInject(R.id.welcome_guide_viewpager)
	private ViewPager pager;


	private List<View> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_guide);
		ViewUtils.inject(this);

		initViewPager();
	}
	@OnClick(R.id.welcome_guide_btn)  //btn 的点击事件
	public void click(View view)
	{

		startActivity(new Intent(this, MainActivity.class));
		finish();
	}
	//初始化viewpager
	public void initViewPager()
	{
		list=new ArrayList<View>();
		ImageView iv=new ImageView(this);
		iv.setImageResource(R.drawable.guide_01);
		list.add(iv);
		ImageView iv1=new ImageView(this);
		iv1.setImageResource(R.drawable.guide_02);
		list.add(iv1);
		ImageView iv2=new ImageView(this);
		iv2.setImageResource(R.drawable.guide_03);
		list.add(iv2);
		pager.setAdapter(new MyViewPagerAdapter());

		//监听滑动效果
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			//也卡被选中的方法
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				if(arg0==2)//如果是第三个页面
				{

					btn.setVisibility(View.VISIBLE);

				}else
				{


					btn.setVisibility(View.GONE);

				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}
	//自定义viewpager的适配器
	class MyViewPagerAdapter extends PagerAdapter{


		//计算需要多少item显示
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		//初始化item实例方法
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(list.get(position));
			return list.get(position);
		}
		//item的销毁的方法
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			//必须注销掉父类的方法
			//super.destroyItem(container, position, object);
			container.removeView(list.get(position));
		}

	}

}
