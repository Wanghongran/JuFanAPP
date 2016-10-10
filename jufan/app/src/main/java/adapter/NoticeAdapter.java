package adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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

import bean.SearchBean;

/**
 * Created by wanghongra on 2016/10/8.
 */


public class NoticeAdapter extends BaseAdapter {

    private final List<SearchBean.ContentBean.DataBean> news;
    private View view;
    private TextView name;
    private TextView level;
    private TextView out;
    private ImageView week_img;
    private ImageView attention;
    private TextView position;
    private ImageView add_attention;
    private Context context;
    private SQLiteDatabase db;
    private NoticeAdapter adapter;

    public NoticeAdapter(Context context, List<SearchBean.ContentBean.DataBean> news) {
        this.context=context;
        this.news=news;

    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return news.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return news.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
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

        ImageLoader.getInstance().displayImage(news.get(position).getHeadImgSmall(),holder.week_img,options_mid);
        holder.name.setText(news.get(position).getNickname());
        holder.level.setText("LEVEl"+news.get(position).getLevel()+"");
        holder.out.setText("送出"+news.get(position).getOut_amount()+"聚钻");
        holder.position.setText(position+1+"、");
      /*  holder.attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.attention.setVisibility(View.GONE);
                holder.add_attention.setVisibility(View.VISIBLE);
                myhelper = new AttentionDb(context);
                db = myhelper.getWritableDatabase();

                AttentionOpenHelper att=new AttentionOpenHelper(context);
                att.Delete(news.get(position).getNickname());
                news.remove(position);
                att.Select();
//				adapter.notifyDataSetChanged();
                Toast.makeText(context,"取消关注！",Toast.LENGTH_LONG).show();
            }
        });

        holder.add_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.add_attention.setVisibility(View.GONE);
                holder.attention.setVisibility(View.VISIBLE);
                myhelper = new AttentionDb(context);
                db = myhelper.getWritableDatabase();
                AttentionOpenHelper att=new AttentionOpenHelper(context);
                att.addGoods(news);
                Toast.makeText(context,"关注成功！",Toast.LENGTH_LONG).show();
            }
        });*/
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

