package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wanghongra.jufan.LoginActivity;
import com.example.wanghongra.jufan.R;

/**
 * Created by legedelove on 2016/9/26.
 */

public class Fragment3 extends Fragment{
    private Button tiyan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag03,container,false);
        tiyan=(Button)v.findViewById(R.id.tiyan);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tiyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump();
            }
        });
    }

    /*
        * jump页面跳转
        * */
    public void jump(){
        Intent in=new Intent(getActivity(), LoginActivity.class);
        startActivity(in);
    }
}
