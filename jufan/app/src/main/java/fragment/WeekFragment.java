package fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.wanghongra.jufan.R;
import com.google.gson.Gson;

import net.HttpNet;
import net.ResponseListener;

import java.util.List;

import adapter.Weekadapter;
import bean.WeekBean;


public class WeekFragment extends Fragment {
    private String path = "http://api.vas.jufan.tv/cgi/rank/sendTopWeek?r=mvohabl&page=1&user_id=500059702&sign=1425BC86225D0897C7A2F6A63F6AD0C99933122D";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 0) {
                List<WeekBean.ContentBean.DataBean> data= (List<WeekBean.ContentBean.DataBean>) msg.obj;
                week_lv.setAdapter(new Weekadapter(getActivity(), data));
            }
        }
    };
    private ListView week_lv;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = View.inflate(getActivity(), R.layout.frag_week, null);
        week_lv = (ListView) view.findViewById(R.id.week_lv);
        initData();
        return view;
    }
    private void initData() {

        HttpNet.getObjectMinongApi(path, new ResponseListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Tag", "请求失败");
                Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                Log.d("Tag", s.toString());
                WeekBean weekBean = gson.fromJson(s, WeekBean.class);
                List<WeekBean.ContentBean.DataBean> data = weekBean.getContent().getData();
                Message msg = Message.obtain();
                msg.obj = data;
                msg.what = 0;
                handler.sendMessage(msg);

            }
        });
    }

}
