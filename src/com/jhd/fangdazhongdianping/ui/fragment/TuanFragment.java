package com.jhd.fangdazhongdianping.ui.fragment;

import com.jhd.fangdazhongdianping.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//首页
public class TuanFragment extends Fragment {
	@ViewInject(R.id.index_tuan_list6_tv)
	private TextView tv;//给这个tv加 删除线
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.index_tuan, null);
		ViewUtils.inject(this, view);
		tv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		return view;
	}

}
