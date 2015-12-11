package com.jhd.fangdazhongdianping.ui.detail;

import com.jhd.fangdazhongdianping.R;
import com.jhd.fangdazhongdianping.R.layout;
import com.jhd.fangdazhongdianping.R.menu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ActivityHomeList1 extends Activity {
	@ViewInject(R.id.detail_activity_home_list1_back)
	private ImageView btn_back;
	
	//4个过滤条件的按钮
	@ViewInject(R.id.detail_activity_home_list1_fujin)
	private LinearLayout fujin;
	@ViewInject(R.id.detail_activity_home_list1_meishi)
	private LinearLayout meishi;
	@ViewInject(R.id.detail_activity_home_list1_zhineng)
	private LinearLayout zhineng;
	@ViewInject(R.id.detail_activity_home_list1_shaixuan)
	private LinearLayout shaixuan;
	//对应的图片和布局显示
	@ViewInject(R.id.detail_activity_home_list1_filter1)
	private LinearLayout filter_1;
	@ViewInject(R.id.detail_activity_home_list1_0_arrow_fujin)
	private ImageView iv_1;
	@ViewInject(R.id.detail_activity_home_list1_0_arrow_meishi)
	private ImageView iv_2;
	@ViewInject(R.id.detail_activity_home_list1_0_arrow_zhineng)
	private ImageView iv_3;
	@ViewInject(R.id.detail_activity_home_list1_0_arrow_shaixuan)
	private ImageView iv_4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity_home_list1);
		ViewUtils.inject(this);
	}
	
	@OnClick({R.id.detail_activity_home_list1_back,R.id.detail_activity_home_list1_fujin,
		R.id.detail_activity_home_list1_meishi,R.id.detail_activity_home_list1_zhineng,
		R.id.detail_activity_home_list1_shaixuan})
	private void onClick(View v){
		switch (v.getId()) {
		case R.id.detail_activity_home_list1_back:
			finish();
			break;
		case R.id.detail_activity_home_list1_fujin:
			if(filter_1.getVisibility()==View.GONE){
				filter_1.setVisibility(View.VISIBLE);//对应的布局设置显示
				iv_1.setVisibility(View.VISIBLE);//对应上面的小箭头显示
			}else{               //设置gone不显示
				filter_1.setVisibility(View.GONE);
				setAllImageArrowGone();
			}
			
			break;
		case R.id.detail_activity_home_list1_meishi:
			if(filter_1.getVisibility()==View.GONE){
				filter_1.setVisibility(View.VISIBLE);//对应的布局设置显示
				iv_2.setVisibility(View.VISIBLE);//对应上面的小箭头显示
			}else{               //设置gone不显示
				filter_1.setVisibility(View.GONE);
				setAllImageArrowGone();
			}
			break;
		case R.id.detail_activity_home_list1_zhineng:
			if(filter_1.getVisibility()==View.GONE){
				filter_1.setVisibility(View.VISIBLE);//对应的布局设置显示
				iv_3.setVisibility(View.VISIBLE);//对应上面的小箭头显示
			}else{               //设置gone不显示
				filter_1.setVisibility(View.GONE);
				setAllImageArrowGone();
			}
			break;
		case R.id.detail_activity_home_list1_shaixuan:
			if(filter_1.getVisibility()==View.GONE){
				filter_1.setVisibility(View.VISIBLE);//对应的布局设置显示
				iv_4.setVisibility(View.VISIBLE);//对应上面的小箭头显示
			}else{               //设置gone不显示
				filter_1.setVisibility(View.GONE);
				setAllImageArrowGone();
			}
			break;

		default:
			break;
		}
	}
	private void setAllImageArrowGone(){
		iv_1.setVisibility(View.GONE);
		iv_2.setVisibility(View.GONE);
		iv_3.setVisibility(View.GONE);
		iv_4.setVisibility(View.GONE);
	}

	
}
