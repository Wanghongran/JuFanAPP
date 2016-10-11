package com.example.wanghongra.jufan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class LiveActivity extends AppCompatActivity {
    private String videoURl;
    private TXCloudVideoView mPlayerView;
    private TXLivePlayer mLivePlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_live);

        videoURl = getIntent().getStringExtra("url");
        Toast.makeText(this, videoURl, Toast.LENGTH_SHORT).show();

        //播放器控件
        mPlayerView = (TXCloudVideoView) findViewById(R.id.video_view);
        //创建播放器
        mLivePlayer = new TXLivePlayer(this);
        TXLivePlayer mTXLivePlayer = new TXLivePlayer(this);
        mTXLivePlayer.setPlayerView(mPlayerView);
        mLivePlayer.startPlay(videoURl, TXLivePlayer.PLAY_TYPE_VOD_MP4);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLivePlayer != null) {
            mLivePlayer.stopPlay(true);
        }
        if (mPlayerView != null) {
            mPlayerView.onDestroy();
        }
    }
    }

