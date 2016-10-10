package com.example.wanghongra.jufan;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import fragment.Fragment11;
import fragment.Fragment12;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private LinearLayout linearLayout;
    private ToggleButton but2, but1;
    private Fragment11 f11;
    private Fragment12 f12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        data();
        chushihua();
    }

    /*
    * 找控件
    * */
    public void findID() {

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        linearLayout.getBackground().setAlpha(130);
        but1 = (ToggleButton) findViewById(R.id.but1);
        but1.setOnClickListener(this);
        but2 = (ToggleButton) findViewById(R.id.but2);
        but2.setOnClickListener(this);

    }

    /*
    * Fragment事物
    * */
    public void chushihua() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fm.beginTransaction();
        but1.setChecked(true);
        beginTransaction.add(R.id.buju, f11).commit();
    }

    /*
    * Fragment 数据
    * */
    public void data() {
        f11 = new Fragment11();
        f12 = new Fragment12();
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.but1:
                but1.setChecked(true);
                but2.setChecked(false);
                beginTransaction.replace(R.id.buju, f11).commit();
                break;
            case R.id.but2:
                but2.setChecked(true);
                but1.setChecked(false);
                beginTransaction.replace(R.id.buju, f12).commit();
                break;
        }
    }


}

