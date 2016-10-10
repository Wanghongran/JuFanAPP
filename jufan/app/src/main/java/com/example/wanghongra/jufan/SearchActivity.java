package com.example.wanghongra.jufan;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import net.HttpNet;
import net.ResponseListener;

import java.util.List;

import adapter.NoticeAdapter;
import bean.SearchBean;


public class SearchActivity extends AppCompatActivity {
    private String path = "http://api.vas.jufan.tv/cgi/rank/sendTopWeek?r=mvohabl&page=1&user_id=500059702&sign=1425BC86225D0897C7A2F6A63F6AD0C99933122D";
    private ListView search_lv;
    private Button seacher_btn;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 0) {
                List<SearchBean.ContentBean.DataBean> data = (List<SearchBean.ContentBean.DataBean>) msg.obj;
                search_lv.setAdapter(new NoticeAdapter(SearchActivity.this, data));
            }
        }
    };
    private EditText searchtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        seacher_btn = (Button) findViewById(R.id.seacher_btn);
        searchtext = (EditText) findViewById(R.id.search_ed);


        search_lv = (ListView) findViewById(R.id.search_lv);


        seacher_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String s = searchtext.getText().toString();
                if (s.equals("")) {
                    Toast.makeText(SearchActivity.this, "请输入昵称或者房间ID", Toast.LENGTH_SHORT).show();
                } else {
                    initData();

                }
            }


        });


    }

    private void initData() {

        HttpNet.getObjectMinongApi(path, new ResponseListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Tag", "请求失败");
                Toast.makeText(SearchActivity.this, "请求失败", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                Log.d("Tag", s.toString());
                SearchBean searchBean = gson.fromJson(s, SearchBean.class);
                List<SearchBean.ContentBean.DataBean> data = searchBean.getContent().getData();
                Message msg = Message.obtain();
                msg.obj = data;
                msg.what = 0;
                handler.sendMessage(msg);

            }
        });
    }

}
