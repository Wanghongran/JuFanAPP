package com.example.wanghongra.jufan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.util.ArrayList;

import fragment.WeekFragment;
import fragment.ZongFragment;

public class ReachListActivity extends FragmentActivity implements View.OnClickListener {
    private ImageView bang_back;
    private ImageView bang_quan;
    private RadioButton zong,week;
    private ViewPager bang_vp;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reach_list);
        getindex();
    }

    public void getindex() {

        bang_back= (ImageView)findViewById(R.id.bang_back);
        bang_quan= (ImageView)findViewById(R.id.bang_quan);
        zong= (RadioButton)findViewById(R.id.zong);
        week= (RadioButton)findViewById(R.id.week);
        bang_vp= (ViewPager)findViewById(R.id.bang_vp);

        zong.setOnClickListener(this);
        week.setOnClickListener(this);

        list = new ArrayList<Fragment>();

        WeekFragment w1=new WeekFragment();
        ZongFragment z1=new ZongFragment();

        list.add(w1);
        list.add(z1);

        bang_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

        });

        bang_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==0){
                    week.setChecked(true);
                    zong.setChecked(false);
                }else if (position==1){
                    week.setChecked(false);
                    zong.setChecked(true);
                }
                week.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bang_vp.setCurrentItem(0);
                    }
                });
                zong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bang_vp.setCurrentItem(1);
                    }
                });
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
