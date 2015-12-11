package com.jhd.fangdazhongdianping.ui;

import com.jhd.fangdazhongdianping.R;
import com.jhd.fangdazhongdianping.R.layout;
import com.jhd.fangdazhongdianping.R.menu;
import com.jhd.fangdazhongdianping.ui.fragment.HomeFragment;
import com.jhd.fangdazhongdianping.ui.fragment.MyFragment;
import com.jhd.fangdazhongdianping.ui.fragment.SearchFragment;
import com.jhd.fangdazhongdianping.ui.fragment.TuanFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnCheckedChangeListener{

	@ViewInject(R.id.main_bottom_tabs)
	private RadioGroup group;
	@ViewInject(R.id.main_home)
	private RadioButton main_home;
	private FragmentManager fragmentManager;//管理fragment
	private HomeFragment home;
	private MyFragment my;
	private SearchFragment search;
	private TuanFragment tuan;
	private long exitTime=0;//两次按返回退出

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);
		//初始化fragmentManager
		fragmentManager=getSupportFragmentManager();
		//设置默认选中
		main_home.setChecked(true);
		group.setOnCheckedChangeListener(this);
		//切换不同的fragment
		changeFragment(0);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkedId) {
		switch (checkedId) {
		case R.id.main_home:
			changeFragment(0);			
			break;
		case R.id.main_tuan:
			changeFragment(1);
			break;
		case R.id.main_search:
			changeFragment(2);
			break;
		case R.id.main_my:
			changeFragment(3);
			break;
		default:
			break;
		}		
	}
	//切换不同的fragment
	/** 
     * 根据传入的index参数来设置选中的tab页。 
     *  
     * @param index 
     *            每个tab页对应的下标。0表示home，1表示tuan，2表示search，3表示my。 
     */  
	public void changeFragment(int index)//同时保存每个fragment
	{
		FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
		hideFragments(beginTransaction);
		switch (index) {
		case 0:
			if(home==null){
				home=new HomeFragment();
				beginTransaction.add(R.id.main_content,	home);
			}else{
				beginTransaction.show(home);
			}
			break;
		case 1:
			if(tuan==null){
				tuan=new TuanFragment();
				beginTransaction.add(R.id.main_content,	tuan);
			}else{
				beginTransaction.show(tuan);
			}
			break;
		case 2:
			if(search==null){
				search=new SearchFragment();
				beginTransaction.add(R.id.main_content,	search);
			}else{
				beginTransaction.show(search);
			}
			break;
		case 3:
			if(my==null){
				my=new MyFragment();
				beginTransaction.add(R.id.main_content,	my);
			}else{
				beginTransaction.show(my);
			}
			break;

		default:
			break;
		}
		beginTransaction.commit();//需要提交事务
	}
	private void hideFragments(FragmentTransaction transaction) {  
		if (home != null)   
			transaction.hide(home);  	         
		if (my != null)   
			transaction.hide(my);  	          
		if (tuan != null)   
			transaction.hide(tuan);  	          
		if (search != null)   
			transaction.hide(search);  	         
	}  
	
	@Override
	public void onBackPressed() {    
	
		
			exit();  ///退出应用
			
	}
	
	public void exit() {   //退出应用
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            //System.exit(0);
        }
    }
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
	//	this.overridePendingTransition(0,R.anim.activity_close);
	}

}
