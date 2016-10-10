package com;

import android.app.Activity;
import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.umeng.socialize.PlatformConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/9/28.
 */

public class App extends Application {
    public static List<Object> activitys = new ArrayList<Object>();
    private static App instance;
    public static String Qname;
    public static String Qurl;
    public static com.nostra13.universalimageloader.core.ImageLoader loder;
    public static DisplayImageOptions options;
    public static DisplayImageOptions optionss;
    @Override
    public void onCreate() {
        super.onCreate();
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        loder= com.nostra13.universalimageloader.core.ImageLoader.getInstance();
        loder.init(ImageLoaderConfiguration.createDefault(this));
        options=new DisplayImageOptions.Builder()
                .displayer(new CircleBitmapDisplayer())
                .build();
        optionss = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new RoundedBitmapDisplayer(30))
                .build();
    }
    //获取单例模式中唯一的MyApplication实例
    public static App getInstance() {
        if (instance == null)
            instance=new App();
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        if (!activitys.contains(activity))
            activitys.add(activity);
    }

    // 遍历所有Activity并finish
    public void destory() {

        for (Object activity : activitys) {
            ((Activity) activity).finish();
        }
        System.exit(0);
    }

}
