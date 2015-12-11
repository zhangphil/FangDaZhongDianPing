package com.jhd.fangdazhongdianping.ui.detail;

import com.jhd.fangdazhongdianping.R;
import com.jhd.fangdazhongdianping.UserSetActivity;
import com.jhd.fangdazhongdianping.dao.UserDao;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	@ViewInject(R.id.login_phone)//账号输入框
	EditText et_phone;
	@ViewInject(R.id.login) //登录按钮
	Button login;
	@ViewInject(R.id.login_back)
	ImageView img_back;
	
	//其他登录方式
	@ViewInject(R.id.login_qq)
	TextView tv_login_qq;
	@ViewInject(R.id.login_weixin)
	TextView tv_login_weixin;
	@ViewInject(R.id.login_weibo)
	TextView tv_login_weibo;
	@ViewInject(R.id.login_zhifubao)
	TextView tv_login_zhifubao;
	
	//其他登录的弹出框父容器
	@ViewInject(R.id.login_container)
	LinearLayout container;
	@ViewInject(R.id.needmiss)//隐藏的新浪、支付宝登录
	LinearLayout needmiss;
	@ViewInject(R.id.tanchu)//弹出整个布局
	LinearLayout tanchu;
	@ViewInject(R.id.login_click_up_click_down)//点击使下面能弹出的按钮
	ImageView login_click_up_click_down;
	private boolean isUp=false;//初始状态事没有弹出

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ViewUtils.inject(this);
		et_phone.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				if(et_phone.getText().toString().length()>=5){
					login.setEnabled(true);
					Log.e("jhd1", "login-set-true");
				}
				else{
					login.setEnabled(false);
					Log.e("jhd1", "login-set-false");
				}				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}
		});


		//
		//动态设置控件宽高
		ViewTreeObserver vto = container.getViewTreeObserver();

		vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
		{
			public boolean onPreDraw()
			{



				int H = needmiss.getMeasuredHeight();

				FrameLayout.LayoutParams lp1=(android.widget.FrameLayout.LayoutParams) tanchu.getLayoutParams();
				lp1.bottomMargin=-H;
				return true;
			}
		});
	}


	@OnClick({R.id.login,R.id.login_click_up_click_down,
		R.id.login_qq,R.id.login_weibo,R.id.login_weixin,R.id.login_zhifubao,
		R.id.login_back})
	public void onClick(View v){
		if(v.getId()==R.id.login){
			Log.e("jhd1", "click_login");
			UserDao ud=new UserDao(this);
			if(ud.login(et_phone.getText().toString())){
				startActivity(new Intent(this, UserSetActivity.class));
			}
			else{
				Toast.makeText(this, "输入有误！请重试！", Toast.LENGTH_SHORT).show();
			}
		}
		else if(v.getId()==R.id.login_click_up_click_down){
			if(isUp){
				translationYAnimRunDown(tanchu);
				login_click_up_click_down.setImageResource(R.drawable.navibar_arrow_up);

			}else{
				translationYAnimRunUp(tanchu);
				login_click_up_click_down.setImageResource(R.drawable.navibar_arrow_down);
			}
			isUp=!isUp;
		}else if(v.getId()==R.id.login_qq||v.getId()==R.id.login_weibo
				||v.getId()==R.id.login_weixin||v.getId()==R.id.login_zhifubao){
			Toast.makeText(this, "第三方登录目前暂未实现！", Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.login_back){
			finish();
		}
		
	}

	@SuppressLint("NewApi")
	public void translationYAnimRunUp(View view)  //向上平移  。
	{  
		int h = needmiss.getHeight();    
		ObjectAnimator anim=ObjectAnimator.ofFloat(view, "translationY",0.0F , -h);               
		anim.setDuration(1000);// 持续时间 
		anim.setInterpolator(new BounceInterpolator());//插值器，变化速率或者规则      
		anim.start();  //开始执行
	}
	@SuppressLint("NewApi")
	public void translationYAnimRunDown(View view)  
	{ 
		int h = needmiss.getHeight();     
		ObjectAnimator anim=ObjectAnimator.ofFloat(view, "translationY",-h , 0.0f);
		anim.setDuration(1000);// 持续时间 
		anim.setInterpolator(new BounceInterpolator());//插值器，变化速率或者规则       
		anim.start();  //开始执行
	}


}
