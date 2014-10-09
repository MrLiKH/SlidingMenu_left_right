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
		//��������
		setContentView(R.layout.content);
		//�����໬��
		setBehindContentView(R.layout.menu_frame);
		
		//��������������λ��
		slidingMenu = getSlidingMenu();
		//���������
		slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);//Sets which side the SlidingMenu should appear on.
		//���ò�������Ӧ�Ŀ��
//		slidingMenu.setBehindWidth(40);
		//ͨ������ҳȥָ��������Ŀ�Ŀ��
		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		//�趨��ָ���
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		//������ק��Χ
		/*
		 * SlidingMenu.TOUCHMODE_FULLSCREEN
		 * SlidingMenu.TOUCHMODE_MARGIN
		 * SlidingMenu.TOUCHMODE_NONE  //ָ��ĳһ��ģ�鲻��Ӧ��ק�¼�
		 */
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		/**
		 * ���
		 */
		//����fragment����
		MenuFragment menuFragment = new MenuFragment();
		//�滻֡����������
		getSupportFragmentManager().beginTransaction().
		replace(R.id.menu_frame,menuFragment , "MENU").commit();
		
		
		
		slidingMenu.setSecondaryMenu(R.layout.menu_right_frame);
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		
		
		/**
		 * �Ҳ�
		 */
		//����fragment����
		RightMenuFragment rhmenuFragment = new RightMenuFragment();
		//�滻֡����������
		getSupportFragmentManager().beginTransaction().
		replace(R.id.righe_menu_frame,rhmenuFragment , "rhMENU").commit();
		
		/*//�����Ҳ�Ĳ���
		slidingMenu.setSecondaryMenu(R.layout.menu_right_frame);
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);*/
		
		
		
	}
	/**
	 * �滻���ֵķ���
	 * @param fragment
	 */
	public void switchFragment(Fragment fragment) {
		if(fragment!=null){
			//�滻֡����������
			getSupportFragmentManager().beginTransaction().
			replace(R.id.content_frame, fragment, "MAIN").commit();
			//���������
			slidingMenu.toggle();
		}
	}

	

}
