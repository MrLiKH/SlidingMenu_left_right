package com.litest.slidingmenu_left.frame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	/**
	 * 加载布局
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//获取当前类的名称
		TextView textview = new TextView(getActivity());
		String simpleName = this.getClass().getSimpleName();
		textview.setText(simpleName);
		return textview;
	}
	/**
	 * 填充布局
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
