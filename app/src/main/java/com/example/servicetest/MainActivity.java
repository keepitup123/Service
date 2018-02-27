package com.example.servicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mtnMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtnMusic = (Button)findViewById(R.id.btn_music);
        mtnMusic.setOnClickListener(new OnClick());

    }
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_music:
                    intent = new Intent(MainActivity.this,MusicButtonActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
