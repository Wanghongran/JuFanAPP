package fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.App;
import com.example.wanghongra.jufan.R;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import bean.Zx;

/**
 * Created by legedelove on 2016/9/26.
 */

public class Zuixing extends Fragment{

    private PullToRefreshGridView mPullRefreshListView;
    private LinkedList<String> mListItems;
    private int mItemCount = 10;
    private ArrayAdapter<String> mAdapter;
    private ArrayList<Zx> aalist;
    private ArrayList<Zx> aalistt=new ArrayList<>();
    private Handler handler = new Handler() {



        // 该方法运行在主线程中
        // 接收到handler发送的消息，对UI进行操作
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            if (aalist == msg.obj) {
                aalistt.addAll(aalist);
                zhufangfa();
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.zx,container,false);
        mPullRefreshListView=(PullToRefreshGridView)v.findViewById(R.id.pull_refresh_grid);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        aalist = new ArrayList<Zx>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                simpleGetClick();
            }
        }).start();
    }

    private void zhufangfa(){

        Log.e("axxxxxxxxxxxxxxxxxxxxx",aalist.size()+"");
        mPullRefreshListView.setAdapter(new BaseAdapter() {
            public ViewGroup.LayoutParams hdt;
            public holder ho;

            @Override
            public int getCount() {
                return aalistt.size();
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    convertView=View.inflate(getActivity(),R.layout.zx_item,null);
                    ho=new holder();
                    ho.datu=(ImageView) convertView.findViewById(R.id.datu);
                    hdt=ho.datu.getLayoutParams();
                    WindowManager wm = (WindowManager) getContext()
                            .getSystemService(getActivity().WINDOW_SERVICE);
                    int width = wm.getDefaultDisplay().getWidth();
                    hdt.height=width/2-5;
                    convertView.setTag(ho);
                }else{
                    ho= (holder) convertView.getTag();
                }
               App.loder.displayImage(aalistt.get(position).midheadimg,ho.datu,App.optionss);
                return convertView;
            }
            class holder{
                ImageView datu;
            }
        });

    }

    public void simpleGetClick() {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url("http://live.jufan.tv/cgi/hall/get?userid=500073885&type=new&r=ghzsbn&page=0")
                .build();
        try {
            Response response = mOkHttpClient.newCall(request).execute();
            String shuju=response.body().string();
            Log.e("sssssssssssssss",shuju);
            jiexi(shuju);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void jiexi(String s){
        Log.e("yyyyyyyyyyy","ok");
        try {
            JSONObject json=new JSONObject(s);
            JSONObject obj=json.optJSONObject("content");
            JSONArray mlist=obj.optJSONArray("list");

            for (int i=0;i<mlist.length();i++){
                JSONObject dx=mlist.optJSONObject(i);
                String midheadimg = dx.optString("midheadimg");
                String name = dx.optString("name");
                String livename =dx.optString("livename");
                String place =dx.optString("place");
                String samllheadimg =dx.optString("samllheadimg");
                Zx r=new Zx(name,livename,place,samllheadimg,midheadimg);
                aalist.add(r);
                Log.e("bxxxxxxxxxxxxxxxxxxxxxx",aalist.size()+"");
            }
            Message msg = new Message();
            msg.obj = aalist;
            handler.sendMessage(msg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
