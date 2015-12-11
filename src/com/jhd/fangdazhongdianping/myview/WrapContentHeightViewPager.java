package com.jhd.fangdazhongdianping.myview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
 
public class WrapContentHeightViewPager extends ViewPager {
 
    public WrapContentHeightViewPager(Context context) {
        super(context);
    }
 
    public WrapContentHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
 
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    	
        int height = 0;
        //下面遍历所有child的高度
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec,
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            if (h > height) //采用最大的view的高度。
                height = h;
        }
                                                                 //本程序viewpager中放置的是2行gridview
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height*2,//由于本程序需要高度为两个grid_item的高度,故此项*2
                MeasureSpec.EXACTLY);
        
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);//这个方法只能放最后
 
        
    }
}