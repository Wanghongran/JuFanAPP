package fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wanghongra.jufan.R;

import java.util.ArrayList;

/**
 * Created by legedelove on 2016/9/26.
 */

public class Fragment11 extends Fragment{
    private TabLayout tab_FindFragment_title;
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;
    private ArrayList<Fragment> list;
    private ArrayList<String> list1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag11,container,false);
        tab_FindFragment_title=(TabLayout)v.findViewById(R.id.tab_FindFragment_title);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        return v;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        data();
        shipeiqi();
    }
    public void data(){
        Guanzhu f1=new Guanzhu();
        Remen f2=new Remen();
        Zuixing f3=new Zuixing();
        list=new ArrayList<Fragment>();
        list1=new ArrayList<String>();
        list1.add("关注");
        list1.add("热门");
        list1.add("最新");
        list.add(f1);
        list.add(f2);
        list.add(f3);
    }
    public void shipeiqi(){

        adapter= new FragmentPagerAdapter(getChildFragmentManager()){

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }
            //此方法用来显示tab上的名字
            @Override
            public CharSequence getPageTitle(int position) {

                return list1.get(position % list1.size());
            }
        };
        viewPager.setAdapter(adapter);
        tab_FindFragment_title.setupWithViewPager(viewPager);
        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
    }
}
