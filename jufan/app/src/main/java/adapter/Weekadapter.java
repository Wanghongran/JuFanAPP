package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wanghongra.jufan.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

import bean.WeekBean;

/**
 * Created by wanghongra on 2016/10/9.
 */

public class Weekadapter extends BaseAdapter {
    private final Context context;
    private final List<WeekBean.ContentBean.DataBean> data;

    public Weekadapter(Context context, List<WeekBean.ContentBean.DataBean> data) {
        this.context=context;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.notice_item,null);
            holder=new ViewHolder();
            holder.week_img= (ImageView) convertView.findViewById(R.id.week_img);
            holder.name= (TextView) convertView.findViewById(R.id.week_name);
            holder.level= (TextView) convertView.findViewById(R.id.week_level);
            holder.out= (TextView) convertView.findViewById(R.id.out_amount);
            holder.position= (TextView) convertView.findViewById(R.id.position);
            holder.attention= (ImageView) convertView.findViewById(R.id.attention);
            holder.add_attention= (ImageView) convertView.findViewById(R.id.add_attention);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        DisplayImageOptions options_mid = new DisplayImageOptions.Builder().showStubImage(R.drawable.li_default_head) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.li_default_head) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.li_default_head) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(90)) // 设置成圆角、圆形图片,我这里将new
                // RoundedBitmapDisplayer的参数设置为90,就是圆形图片，其他角度可以根据需求自行修改
                .build();
        ImageLoader.getInstance().displayImage(data.get(position).getHeadImgSmall(),holder.week_img,options_mid);
        holder.name.setText(data.get(position).getNickname());
        holder.level.setText("LEVEl"+data.get(position).getLevel()+"");
        holder.out.setText("送出"+data.get(position).getOut_amount()+"聚钻");
        holder.position.setText(position+1+"、");
        return convertView;



    }


    class ViewHolder{
        TextView position;
        ImageView week_img,attention,add_attention;
        TextView name;
        TextView level;
        TextView out;
    }
}
