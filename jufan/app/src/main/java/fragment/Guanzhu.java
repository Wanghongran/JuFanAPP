package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.wanghongra.jufan.R;


/**
 * Created by legedelove on 2016/9/26.
 */

public class Guanzhu extends Fragment{
    private ImageView sss;
    private ViewGroup.LayoutParams sshdt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.gz,container,false);
        sss=(ImageView)v.findViewById(R.id.sss);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sshdt=sss.getLayoutParams();
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(getActivity().WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();

        sshdt.height=height*3/10;
    }
}
