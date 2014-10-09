package com.litest.slidingmenu_left;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.litest.slidingmenu_left.frame.MenuFragment;
import com.litest.slidingmenu_left.frame.RightMenuFragment;

public class MainActivity extends SlidingFragmentActivity {

	private SlidingMenu slidingMenu;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//关联内容
		setContentView(R.layout.content);
		//关联侧滑栏
		setBehindContentView(R.layout.menu_frame);
		
		//设置左侧侧拉栏的位置
		slidingMenu = getSlidingMenu();
		//设置在左侧
		slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);//Sets which side the SlidingMenu should appear on.
		//设置侧拉栏对应的宽度
//		slidingMenu.setBehindWidth(40);
		//通过内容页去指定侧拉栏目的宽度
		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		//设定其分割线
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		//设置拖拽范围
		/*
		 * SlidingMenu.TOUCHMODE_FULLSCREEN
		 * SlidingMenu.TOUCHMODE_MARGIN
		 * SlidingMenu.TOUCHMODE_NONE  //指定某一个模块不响应拖拽事件
		 */
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		/**
		 * 左侧
		 */
		//创建fragment对象
		MenuFragment menuFragment = new MenuFragment();
		//替换帧布局中内容
		getSupportFragmentManager().beginTransaction().
		replace(R.id.menu_frame,menuFragment , "MENU").commit();
		
		
		
		slidingMenu.setSecondaryMenu(R.layout.menu_right_frame);
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		
		
		/**
		 * 右侧
		 */
		//创建fragment对象
		RightMenuFragment rhmenuFragment = new RightMenuFragment();
		//替换帧布局中内容
		getSupportFragmentManager().beginTransaction().
		replace(R.id.righe_menu_frame,rhmenuFragment , "rhMENU").commit();
		
		/*//设置右侧的布局
		slidingMenu.setSecondaryMenu(R.layout.menu_right_frame);
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);*/
		
		
		
	}
	/**
	 * 替换布局的方法
	 * @param fragment
	 */
	public void switchFragment(Fragment fragment) {
		if(fragment!=null){
			//替换帧布局中内容
			getSupportFragmentManager().beginTransaction().
			replace(R.id.content_frame, fragment, "MAIN").commit();
			//缩回左侧栏
			slidingMenu.toggle();
		}
	}

	

}
