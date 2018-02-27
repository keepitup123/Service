package com.example.servicetest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zhu on 2018/2/7.
 */

public class MusicService extends Service {

    private static final String TAG = "MusicService";
    private MediaPlayer mediaPlayer;
    private IBinder iBinder = new LocalBinder();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "---onCreate---: ");
        mediaPlayer = MediaPlayer.create(this,R.raw.tonghuazhen);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "---onStartCommand:--- ");
        mediaPlayer.start();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "---onBind:--- ");
        mediaPlayer.start();
        return iBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "---onDestroy:--- ");
        mediaPlayer.stop();
    }
    public  class LocalBinder extends Binder{
        MusicService getService(){
            return MusicService.this;
        }
    }
}
