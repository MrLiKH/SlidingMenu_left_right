package com.litest.slidingmenu_left.frame;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.litest.slidingmenu_left.MainActivity;
import com.litest.slidingmenu_left.R;

public class RightMenuFragment extends Fragment {
	private View view;
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
		view = inflater.inflate(R.layout.list_view, null);
		return view;
	}
	/**
	 * 填充布局
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		//填充数据
		ListView listview = (ListView) view.findViewById(R.id.list_view);
		listview.setAdapter(
				new ArrayAdapter<String>(
						getActivity(), 
						android.R.layout.simple_list_item_1, 
						android.R.id.text1,
						initData()));
		//点击条目事件
		listview.setOnItemClickListener(new OnItemClickListener() {

			private Fragment fragment = null;

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//1，创建一个fragment去替换内容页中控件
				switch (position) {
				case 0:
					fragment  = new frgment1();
					break;
				case 1:
					fragment  = new frgment2();
					break;
				case 2:
					fragment  = new frgment3();
					break;
				case 3:
					fragment  = new frgment4();
					break;

				}
				switchFragment(fragment);//去替换mainactivity的中的一个布局
			}
		});
		
		super.onActivityCreated(savedInstanceState);
	}
	
	/**
	 * 
	 * @param fragment
	 */
	protected void switchFragment(Fragment fragment) {
		//获取一个activity对象
		if(getActivity() instanceof MainActivity){
			((MainActivity)getActivity()).switchFragment(fragment);//获取到mainactivity对象，调用其身上的方法，替换布局
		}
	}
	/**
	 * 返回一个集合，填充数据
	 * @return
	 */
	private List<String> initData() {
		List<String> list = new ArrayList<String>();
		
		list.add("fragment1");
		list.add("fragment2");
		list.add("fragment3");
		list.add("fragment4");
		
		return list;
	}
}
