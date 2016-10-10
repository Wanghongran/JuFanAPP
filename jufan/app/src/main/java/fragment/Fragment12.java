package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.App;
import com.example.wanghongra.jufan.R;

/**
 * Created by legedelove on 2016/9/26.
 */

public class Fragment12 extends Fragment{
    private ImageView f3_rela_head;
    private TextView f3_rela_name;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag12,container,false);
        f3_rela_head=(ImageView)v.findViewById(R.id.f3_rela_head);
        f3_rela_name=(TextView)v.findViewById(R.id.f3_rela_name);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        f3_rela_name.setText(App.Qname);
        App.loder.displayImage(App.Qurl,f3_rela_head,App.options);
    }
}
