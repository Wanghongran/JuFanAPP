package com.example.wanghongra.jufan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import utils.BitmapDemo;

;

public class MyCenter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_center);
        ImageView imageView = (ImageView) findViewById(R.id.bg_im);
        getindex();

       String path=" http://scimg.jb51.net/allimg/160826/103-160R60Z21SF.jpg";

        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.li_default_head_bg);
        Drawable drawable = BitmapDemo.BoxBlurFilter(bitmap);
        imageView.setBackgroundDrawable(drawable);
    }


    public void getindex() {
        LinearLayout dengji= (LinearLayout) findViewById(R.id.dengji);
        LinearLayout tuijian= (LinearLayout) findViewById(R.id.tuijian);
        LinearLayout gongchang= (LinearLayout) findViewById(R.id.gongchang);
        LinearLayout duixian= (LinearLayout) findViewById(R.id.duixian);
        LinearLayout shezhi= (LinearLayout) findViewById(R.id.shezhi);


        dengji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyCenter.this,DengjiActivity.class);
                startActivity(intent);
            }
        });


        tuijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyCenter.this,TuijianActivity.class);
                startActivity(intent);
            }
        });

        gongchang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyCenter.this,GongchangActivity.class);
                startActivity(intent);
            }
        });

        duixian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyCenter.this,DuixianActivity.class);
                startActivity(intent);
            }
        });

        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyCenter.this,ShezhiActivity.class);
                startActivity(intent);
            }
        });

    }


}
