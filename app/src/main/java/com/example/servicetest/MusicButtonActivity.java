package com.example.servicetest;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicButtonActivity extends AppCompatActivity {

    private Button mbtnStart,mbtnStop;

    private MusicService musicService;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.LocalBinder  localBinder = (MusicService.LocalBinder)service;
             musicService =localBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_button);
        mbtnStart = (Button)findViewById(R.id.btn_start);
        mbtnStop = (Button)findViewById(R.id.btn_stop);

        mbtnStart.setOnClickListener(new OnClick());
        mbtnStop.setOnClickListener(new OnClick());
    }
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_start:
                    intent = new Intent(MusicButtonActivity.this,MusicService.class);
                    bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                   // startService(intent);
                    break;
                case R.id.btn_stop:
                    //intent = new Intent(MusicButtonActivity.this,MusicService.class);
                    unbindService(serviceConnection);
                  //  stopService(intent);
                    break;
            }
            //startService(intent);
        }
    }
}
