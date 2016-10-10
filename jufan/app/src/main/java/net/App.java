package net;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by wanghongra on 2016/10/8.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyUtil.initialize(this);
        ImageLoaderConfiguration ic=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(ic);
    }
}
