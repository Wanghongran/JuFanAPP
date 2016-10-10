package com.example.wanghongra.jufan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {
    //声明控件
    private ViewPager vp;
    private List<View> list;
    private int ImageId[]= new int[]{R.drawable.v1,R.drawable.v2,R.drawable.v3};

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        sp=getSharedPreferences("com",MODE_PRIVATE);
        if(sp.getBoolean("flag",false)){
            Log.i("flag",sp.getBoolean("flag",false)+"*****");
            Intent i= new Intent(GuideActivity.this,LoginActivity.class);
            startActivity(i);
            finish();
        }
        initialize();
        addView();
        addViewPager();

    }

    private void addViewPager() {
        vp.setAdapter(new PagerAdapter() {
             @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(list.get(position));
                return list.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));
            }


            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==list.size()-1){
                    View v=list.get(position);
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           SharedPreferences.Editor edit= sp.edit();
                            edit.putBoolean("flag",true);
                            edit.commit();
                            Intent i= new Intent(GuideActivity.this,LoginActivity.class);
                            startActivity(i);

                            finish();
                        }
                    });
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //添加视图
    private void addView() {
        list=new ArrayList<View>();
        for(int i=0;i<ImageId.length;i++){
         View v=View.inflate(this,R.layout.vp_item,null);
            ImageView iv= (ImageView) v.findViewById(R.id.vp_iv);
            iv.setBackgroundResource(ImageId[i]);
            list.add(v);
        }


    }

    private void initialize() {
        vp = (ViewPager) findViewById(R.id.vp);
    }



}
