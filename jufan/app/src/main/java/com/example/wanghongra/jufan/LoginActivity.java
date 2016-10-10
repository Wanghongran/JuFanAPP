package com.example.wanghongra.jufan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.App;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends Activity {

    private ImageView imageView;
    private ImageView weixin;
    private ImageView qq;
    private ImageView phone;
    private ImageView weibo;
    private LinearLayout loginly;
    private UMShareAPI mShareAPI;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        sp=getSharedPreferences("come",MODE_PRIVATE);
        if(sp.getBoolean("flag",false)){
            loginly.setVisibility(View.INVISIBLE);
            final Timer timer=new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Intent i= new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                   timer.cancel();
                }
            };
            timer.schedule(task,4000);

        }

        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShareAPI = UMShareAPI.get(LoginActivity.this);
                SHARE_MEDIA platform = SHARE_MEDIA.QQ;
                mShareAPI.doOauthVerify(LoginActivity.this, platform, umAuthListener);
            }
        });
    }

    private void initialize() {
        imageView = (ImageView) findViewById(R.id.imageView);
        weixin = (ImageView) findViewById(R.id.weixin);
        qq = (ImageView) findViewById(R.id.qq);
        phone = (ImageView) findViewById(R.id.phone);
        weibo = (ImageView) findViewById(R.id.weibo);
        loginly = (LinearLayout) findViewById(R.id.login_ly);
    }



    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText( getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
            //获得QQ的头像及名称
            mShareAPI.getPlatformInfo(LoginActivity.this, platform, new UMAuthListener() {

                @Override
                public void onComplete(SHARE_MEDIA arg0, int arg1, Map<String, String> arg2) {
                    App.Qname = arg2.get("screen_name");
                    App.Qurl = arg2.get("profile_image_url");
                    SharedPreferences.Editor edit= sp.edit();
                    edit.putBoolean("flag",true);
                    edit.commit();
                    Intent mInten=new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(mInten);
                    finish();
                }

                @Override
                public void onError(SHARE_MEDIA arg0, int arg1, Throwable arg2) {

                }

                @Override
                public void onCancel(SHARE_MEDIA arg0, int arg1) {

                }
            });
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).HandleQQError(LoginActivity.this,requestCode,umAuthListener);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }
    }

